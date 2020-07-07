/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generate.objectclasses;

import common.utils.GlobalUtils;
import java.io.File;
import java.util.Enumeration;

public class GenerateForm extends Generate{
    public static final String FILEFORM     = "/FrmSample.form";
    public static final String FILEFORMJAVA = "/FrmSample.java";
    
    String Package = "";
    String PackageObject = "";
    String Table = "";
    String table = "";
    String form = getFileForm().toString();
    String formjava = getFileFormJava().toString();

    String component = "";
    String componentjava = "";
    String declaration = "" ;
    String variables ="";
    String showdata = "";
    String setdata = "";
    
    String Location = "";
    String saveToFile = "";


    final int yStart = 80;
    final int x1 = 70;
    final int x2 = 260;
    final int Ynext = 20;
    
    public GenerateForm(String table, String Package, String location, String PackageObject) {
        this.Table = table;
        this.table = table.toLowerCase();
        this.Package = Package;
        this.Location = location;
        this.PackageObject = PackageObject;
        
        vStructure = getStructure(this.table);
        generateFileForm();
        generateFileFormJava();
        
        saveToFile = saveToFile();
    }
    
      public void generateFileFormJava() {
        getDeclaration();
        getVariables();
        getShowData();
        getSetData();
        generateComponentFile();
        getPrimaryKey(table);
        
        
        formjava = formjava.replace("<Package>", Package);
        formjava = formjava.replace("<PackageObject>", PackageObject);
        formjava = formjava.replace("<Table>", Table);
        formjava = formjava.replace("<table>", Table);
        formjava = formjava.replace("<Declaration>", declaration);
        formjava = formjava.replace("<Variables>", variables);        
        formjava = formjava.replace("<ShowData>", showdata);
        formjava = formjava.replace("<SetData>", setdata);
        formjava = formjava.replace("<SetPosition>", componentjava);
        formjava = formjava.replace("<PrimaryKey>", primarykey);
        formjava = formjava.replace("<ImportObject>", importObject());

    }
      
    private String importObject(){
        if (PackageObject.equals(Package)) {
            return "";
        }else {
            return "import " + PackageObject + ".*;";
        }
    }
  
    public String  saveToFile() {
        return saveToFile(Location);
    }
    public String  saveToFile(String location) {
        
        
        File f;
        StringBuffer sb = new StringBuffer();
        
        String locationform         = location + "/Frm" + Table + ".form";
        String locationformjava     = location + "/Frm" + Table + ".java";
        
        sb.append("Creating File Form " + locationform);        
        
        f = new File(locationform);
        if (!f.exists()) {
           if (saveToFile(location , "Frm" + Table +".form", form.substring(0, form.length()-1))) {
                sb.append(" Success");
            }else{
                sb.append(" Not Success");
            }        
        }else {
            sb.append("\n File Frm"  + Table + ".form is Already Exist");
        }
        
        sb.append("Creating File Form Java " + locationformjava);        
        
        f = new File(locationformjava);
        if (!f.exists()) {
            sb.append("\nCreating File " + locationformjava);
            if (saveToFile(location , "Frm" + Table + ".java", formjava.substring(0, formjava.length()-1))) {
                sb.append(" Success");
            }else{
                sb.append(" Not Success");
            } 
        }else {
            sb.append("\n File Frm"  + Table + ".java  is Already Exist");
        }
        return sb.toString();
    }
    

    
    public String generateComponentFile(){
        componentjava = "";
        int y = this.yStart;
        
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            componentjava = componentjava
                            + "\n         jlbl" + field[COLUMN_NAME] + ".setText(\"" + field[COLUMN_NAME]  + "\"); "
                            + "\n         getContentPane().add(jlbl" + field[COLUMN_NAME]  + "); "
                            + "\n         jlbl" + field[COLUMN_NAME] + ".setBounds(" + x1 + ", " + y + ", 140, 15); ";
        
                    
            if (!"Date".equals(tipefield)) {
                componentjava = componentjava 
                                +  "\n         jtxt" + field[COLUMN_NAME] + ".setText(\"jtxt" + field[COLUMN_NAME] + "\"); "
                                +  "\n         getContentPane().add(jtxt" + field[COLUMN_NAME] + "); "
                                +  "\n         jtxt" + field[COLUMN_NAME] + ".setBounds(" + x2 + ", " + y + ", 80, 19); ";

            }else{
                componentjava = componentjava                         
                                + "\n         kdate" + field[COLUMN_NAME] + ".setFont(new java.awt.Font(\"Dialog\", 0, 10)); "
                                + "\n         kdate" + field[COLUMN_NAME] + ".setFontDate(new java.awt.Font(\"Dialog\", 0, 10)); "
                                + "\n         getContentPane().add(kdate" + field[COLUMN_NAME] + "); "
                                + "\n         kdate" + field[COLUMN_NAME] + ".setBounds(" + x2 + ", " + y + ", 80, 19); ";
                        
                
            }
            
            y = y + this.Ynext;
        }
        
        return component;
    }

    public String getSetData() {
        setdata = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            if ("Date".equals(tipefield)) {
                setdata = setdata
                  +"\n          obj.fromString("+ Table + ".PROPERTY_" + field[COLUMN_NAME].toUpperCase() +", kdate" + field[COLUMN_NAME] + ".getDate()); ";

            }else{
                setdata = setdata
                           + "\n          obj.fromString("+ Table + ".PROPERTY_" + field[COLUMN_NAME].toUpperCase() +", jtxt" + field[COLUMN_NAME] + ".getText()) ;";
            }
                                
        }
        
        return setdata;
        
    }
    public String getShowData() {
        showdata = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            if ("Date".equals(tipefield)) {
                showdata = showdata
                              + "\n             if (obj.get" + field[COLUMN_NAME] + "() != null) {"
                              + "\n                kdate" + field[COLUMN_NAME] + ".setDate(obj.get" + field[COLUMN_NAME] + "());  "
                              + "\n             } ";
            }else{
                showdata = showdata
                           + "\n             jtxt" + field[COLUMN_NAME] + ".setText(obj.toString(" + Table + ".PROPERTY_" + field[COLUMN_NAME].toUpperCase() + "));";
            }
                                
        }
        return showdata;
    }
    public String getVariables(){
        variables ="";

        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            variables = variables
                          + "\n      private javax.swing.JLabel jlbl"+ field[COLUMN_NAME] + ";  ";

            if ("Date".equals(tipefield)) {
                variables = variables
                              + "\n      private org.kazao.calendar.KazaoCalendarDate kdate" + field[COLUMN_NAME] + " ; ";
            }else{
                variables = variables 
                              + "\n      private javax.swing.JTextField jtxt" + field[COLUMN_NAME] + "; ";
                
            }
        }            
        
        return variables;

        
        
    }

    public String getDeclaration() {
        declaration = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            declaration = declaration
                          + "\n         jlbl" + field[COLUMN_NAME] + " = new javax.swing.JLabel(); ";

            if ("Date".equals(tipefield)) {
                declaration = declaration
                              + "\n         kdate" + field[COLUMN_NAME] + " = new org.kazao.calendar.KazaoCalendarDate(); ";
            }else{
                declaration = declaration 
                              + "\n         jtxt" + field[COLUMN_NAME] + " = new javax.swing.JTextField(); ";
                
            }
        }            
        
        return declaration;
    }
    
    public void generateFileForm() {
        generateComponentFileForm();
        form = form.replace("<Component>", component);
        form = form.replace("<Table>", Table);
        
    }
    
    public String generateComponentFileForm(){
        component = "";
        int y = this.yStart;
        
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            component = component 
                        + "\n  <Component class=\"javax.swing.JLabel\" name=\"jlbl" + field[COLUMN_NAME] + "\"> "
                        + "\n    <Properties> "
                        + "\n    <Property name=\"text\" type=\"java.lang.String\" value=\"" + field[COLUMN_NAME]  + "\"/>"
                        + "\n    </Properties>"
                        + "\n    <Constraints> "
                        + "\n      <Constraint layoutClass=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout\" value=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription\">"
                        + "\n        <AbsoluteConstraints x=\"" + x1 + "\" y=\"" + y + "\" width=\"140\" height=\"-1\"/>"
                        + "\n      </Constraint>"
                        + "\n    </Constraints> "
                        + "\n  </Component> ";
                    
            if (!"Date".equals(tipefield)) {
                component = component 
                            + "\n   <Component class=\"javax.swing.JTextField\" name=\"jtxt" + field[COLUMN_NAME] + "\">"
                            + "\n      <Properties> "
                            + "\n        <Property name=\"text\" type=\"java.lang.String\" value=\"" + field[COLUMN_NAME] + "\"/>"
                            + "\n      </Properties> "
                            + "\n      <Constraints> "
                            + "\n         <Constraint layoutClass=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout\" value=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription\">"
                            + "\n           <AbsoluteConstraints x=\"" + x2 +"\" y=\"" + y + "\" width=\"80\" height=\"-1\"/>"
                            + "\n         </Constraint>"
                            + "\n      </Constraints> "
                            + "\n   </Component> ";
            }else{
                component = component 
                          + "\n     <Component class=\"org.kazao.calendar.KazaoCalendarDate\" name=\"kdate"+ field[COLUMN_NAME] + "\">"
                          + "\n         <Properties> "
                          + "\n           <Property name=\"font\" type=\"java.awt.Font\" editor=\"org.netbeans.beaninfo.editors.FontEditor\">"
                          + "\n             <Font name=\"Dialog\" size=\"10\" style=\"0\"/>"
                          + "\n           </Property>"
                          + "\n           <Property name=\"fontDate\" type=\"java.awt.Font\" editor=\"org.netbeans.beaninfo.editors.FontEditor\">"
                          + "\n            <Font name=\"Dialog\" size=\"10\" style=\"0\"/>"
                          + "\n           </Property>"
                          + "\n        </Properties>"
                          + "\n        <Constraints> "
                          + "\n           <Constraint layoutClass=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout\" value=\"org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription\">"
                          + "\n              <AbsoluteConstraints x=\"" + x2 + "\" y=\"" + y + "\" width=\"94\" height=\"19\"/>"                          
                          + "\n           </Constraint> "
                          + "\n        </Constraints>"
                          + "\n  </Component>";
                
            }
            
            y = y + this.Ynext;
        }
        
        return component;
    }
    
    public static StringBuffer getFileForm() {
        return openFile(GlobalUtils.getCurrentDir() + FILEFORM);
    }
    public static StringBuffer getFileFormJava() {
        return openFile(GlobalUtils.getCurrentDir() + FILEFORMJAVA);
    }
    

    public String getForm() {
        return form;
    }
    public String getFormJava() {
        return formjava;
    }
    public String getSaveToFile(){
        return saveToFile;
    }
    public String getPrimaryKeyField() {
        return primarykey + "_";
    }
}
