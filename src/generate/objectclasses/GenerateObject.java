/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generate.objectclasses;

import common.utils.GlobalUtils;
import java.io.File;
import java.util.Enumeration;

/**
 *
 * @author root
 */
public class GenerateObject extends Generate{
    public static final String FILETABLEABST = "/TableAbst.java";
    public static final String FILETABLE = "/Table.java";
    public static final String FILETABLES = "/Tables.java";
    String TableAbst = "";
    String Table = "";
    String Tables = "";
    String TableData = "" ;
    String ClassName = "";
    String Package = "";
    String Location = "";
    String Properties = "";
    String Variables = "";
    String SetGet = "";
    String SaveFields = "";
    String LoadRecord = "";
    String ToString = "";
    String FromString="";
    String CopyObject = "";
    String saveToFile = "";
    
    public GenerateObject(String table, String Package, String location) {
         
         this.Package = Package;
         this.Location = location;
         this.TableData = table.toLowerCase();
         this.ClassName = table;
         
         TableAbst  = getFileTableAbst().toString();
         Table  = getFileTable().toString();
         Tables  = getFileTables().toString();      
         
         vStructure = getStructure(TableData);
         
         generateTableAbst();
         generateTable();
         generateTables();
         
         saveToFile = saveToFile();
    }
    
    
    public String  saveToFile() {
        return saveToFile(Location);
    }
    public String  saveToFile(String location) {
        
        
        File f;
        StringBuffer sb = new StringBuffer();
        
        String locationTableAbst = location + "/" + ClassName + "Abst.java";
        String locationTable     = location + "/" + ClassName + ".java";
        String locationTables    = location + "/" + ClassName + "s.java";
        
        sb.append("Creating File " + locationTableAbst);
        if (saveToFile(location , ClassName + "Abst.java", TableAbst.substring(0, TableAbst.length()-1))) {
            sb.append(" Success");
        }else{
            sb.append(" Not Success");
        }
        
        
        f = new File(locationTable);
        if (!f.exists()) {
            sb.append("\nCreating File " + locationTable);
            if (saveToFile(location , ClassName + ".java", Table.substring(0, Table.length()-1))) {
                sb.append(" Success");
            }else{
                sb.append(" Not Success");
            }        
        }else {
            sb.append("\n File "  + locationTable + " is Already Exist");
        }
        
        
        f = new File(locationTables);
        if (!f.exists()) {
            sb.append("\nCreating File " + locationTables);
            if (saveToFile(location , ClassName + "s.java", Tables.substring(0, Tables.length()-1))) {
                sb.append(" Success");
            }else{
                sb.append(" Not Success");
            }
        }else {
            sb.append("\n File "  + locationTables + " is Already Exist");
        }
        
        
        return sb.toString();
    }
    
    

    public void generateTables() {
        Tables = Tables.replace("<Table>", this.ClassName);
        Tables = Tables.replace("<Package>", Package);
        Tables = Tables.replace("<table>", this.TableData);
    }
    public void generateTable() {
        Table = Table.replace("<Table>", this.ClassName);
        Table = Table.replace("<Package>", Package);
        Table = Table.replace("<table>", this.TableData);
    }
    
    public void generateTableAbst() {
        TableAbst = GenerateObject.getFileTableAbst().toString();
        TableAbst = TableAbst.replace("<Package>", Package);
        TableAbst = TableAbst.replace("<Table>", this.ClassName);
        TableAbst = TableAbst.replace("<table>", this.TableData);
        TableAbst = TableAbst.replace("<Properties>", getProperties());        
        TableAbst = TableAbst.replace("<Variables>", getVariables());        
        TableAbst = TableAbst.replace("<PrimaryKey>", this.getPrimaryKey());
        TableAbst = TableAbst.replace("<primarykey>", getPrimaryKeyField());
        TableAbst = TableAbst.replace("<SetGet>", getSETGET());
        TableAbst = TableAbst.replace("<SaveFields>", getSaveFields());
        TableAbst = TableAbst.replace("<LoadRecord>", getLoadRecord());
        TableAbst = TableAbst.replace("<ToString>", getToString());
        TableAbst = TableAbst.replace("<FromString>", getFromString());
        TableAbst = TableAbst.replace("<CopyObject>", getCopyObject());        
        TableAbst = TableAbst.replace("<CheckCannotBeNull>", getCheckCannotBeNull());        
        
    }

    public String  getCopyObject() {
        CopyObject = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            
            
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
                CopyObject = CopyObject 
                             + "\n          " +   field[COLUMN_NAME] + "_ = obj.get" + field[COLUMN_NAME] + "();";
            }
            
        }
        return CopyObject;
    }

    
    public String getFromString(){
        FromString = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
                if ("double".equals(tipefield)) {
                     FromString = FromString 
                                  + "\n           else if (param.equals(PROPERTY_" + field[COLUMN_NAME].toUpperCase() + ")) { "
                                  + "\n                    double newVal; "
                                  + "\n                    try { "
                                  + "\n                          newVal = Double.parseDouble(value); "
                                  + "\n                          set" + field[COLUMN_NAME] + "(newVal); "
                                  + "\n                    } catch (NumberFormatException nfe){ "
                                  + "\n                      throw new CodeException(\"Unrecognised Number format: \"+nfe.getMessage(),nfe); "
                                  + "\n                    }"
                                  + "\n           }";
                
               }else if ("long".equals(tipefield)) {
                     FromString = FromString 
                                  + "\n           else if (param.equals(PROPERTY_" + field[COLUMN_NAME].toUpperCase() + ")) { "
                                  + "\n                    long newVal; "
                                  + "\n                    try { "
                                  + "\n                          newVal = Long.parseLong(value); "
                                  + "\n                          set" + field[COLUMN_NAME] + "(newVal); "
                                  + "\n                    } catch (NumberFormatException nfe){ "
                                  + "\n                      throw new CodeException(\"Unrecognised Number format: \"+nfe.getMessage(),nfe); "
                                  + "\n                    }"
                                  + "\n           }";
                
               }else if ("String".equals(tipefield)) {
                     FromString = FromString 
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"))  set" + field[COLUMN_NAME] + "(value); ";
               }else if ("Date".equals(tipefield)) {
                     FromString = FromString 
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) { "
                                  + "\n                   if (value==null || value.equals(\"\") || value.equals(\"null\") ) "
                                  + "\n                       set" + field[COLUMN_NAME] + "(null); "
                                  + "\n                   else { "
                                  + "\n                        try{ "
                                  + "\n                             java.util.Date d = dateformat.parse(value); "
                                  + "\n                             String year = String.valueOf(d.getYear()+1900); "
                                  + "\n                             int imonth = d.getMonth() + 1; "
                                  + "\n                             String month = imonth > 9 ? String.valueOf(imonth) : \"0\" + imonth; "
                                  + "\n                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : \"0\" + d.getDate();  "
                                  + "\n                             String date = year + \"-\" + month + \"-\" + numdate; "
                                  + "\n                             set" + field[COLUMN_NAME] + "(Date.valueOf(date )); "
                                  + "\n                        }catch(java.text.ParseException pe){ "
                                  + "\n                           throw new CodeException(\"Unrecognised Date format: \"+pe.getMessage(),pe); "
                                  + "\n                        } "
                                  + "\n                   } "
                                  + "\n           } ";
        
               }else if ("Timestamp".equals(tipefield)) {
                     FromString = FromString 
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) { "
                                  + "\n                   if (value==null || value.equals(\"\") || value.equals(\"null\") ) "
                                  + "\n                       set" + field[COLUMN_NAME] + "(null); "
                                  + "\n                   else { "
                                  + "\n                        try{ "
                                  + "\n                             java.util.Date d = datetimeformat.parse(value); "
                                  + "\n                             String year = String.valueOf(d.getYear()+1900); "
                                  + "\n                             int imonth = d.getMonth() + 1; "
                                  + "\n                             String month = imonth > 9 ? String.valueOf(imonth) : \"0\" + imonth; "
                                  + "\n                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : \"0\" + d.getDate();  "
                                  + "\n                             String date = year + \"-\" + month + \"-\" + numdate; "
                                  + "\n                             String time = d.getHours() + \":\" + d.getMinutes() + \":\" + d.getSeconds() + \".0\"; "
                                  + "\n                             set" + field[COLUMN_NAME] + "(Timestamp.valueOf(date + \" \" + time)); "
                                  + "\n                        }catch(java.text.ParseException pe){ "
                                  + "\n                           throw new CodeException(\"Unrecognised Date format: \"+pe.getMessage(),pe); "
                                  + "\n                        } "
                                  + "\n                   } "
                                  + "\n           } ";
        
                }
            }
        }
        return FromString;
        
    }
    
    public String getToString(){
        ToString = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
                if ("double".equals(tipefield)) {
                     ToString = ToString 
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) return decform.format(get" + field[COLUMN_NAME] + "()); ";
                }else if ("date".equals(tipefield) || "Date".equals(tipefield)) {
                     ToString = ToString
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) return get" + field[COLUMN_NAME] + "()  == null ? \"\" :dateformat.format(get" + field[COLUMN_NAME] + "()); ";
                }else if ("Timestamp".equals(tipefield)) {
                     ToString = ToString
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) return get" + field[COLUMN_NAME] + "()  == null || get" + field[COLUMN_NAME] + "().equals(\"0000-00-00 00:00:00\") ? \"\" : datetimeformat.format(get" + field[COLUMN_NAME] + "()) ; ";
                }else if ("String".equals(tipefield)) {
                     ToString = ToString
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) return get" + field[COLUMN_NAME] + "(); ";
                }else {
                     ToString = ToString 
                                  + "\n           else if (param.equals(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +")) return String.valueOf(get" + field[COLUMN_NAME] + "()); ";                    
                } 
            }
            
        }
        return ToString;
        
    }
    public String getLoadRecord(){
        LoadRecord = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);
            
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
                if ("long".equals(tipefield)) {
                     LoadRecord = LoadRecord 
                                  + "\n           " + field[COLUMN_NAME] + "_ = rs.getLong(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"); ";
                }else if ("double".equals(tipefield)) {
                     LoadRecord = LoadRecord 
                                  + "\n           " + field[COLUMN_NAME] + "_ = rs.getDouble(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"); ";
                }else if ("String".equals(tipefield)) {
                     LoadRecord = LoadRecord 
                                  + "\n           " + field[COLUMN_NAME] + "_ = rs.getString(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"); ";
                }else if ("Timestamp".equals(tipefield)) {
                     LoadRecord = LoadRecord 
                                  + "\n           " + field[COLUMN_NAME] + "_ = rs.getTimestamp(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"); ";
                }else if ("Date".equals(tipefield)) {
                     LoadRecord = LoadRecord 
                                  + "\n           " + field[COLUMN_NAME] + "_ = rs.getDate(PROPERTY_" +  field[COLUMN_NAME].toUpperCase() +"); ";
                } 
            }
            
        }
        return LoadRecord;
        
    }
    
    public String getCheckCannotBeNull() {
        String CheckCannotBeNull = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            
            if (field[NULLABLE].equals("0") && !field[COLUMN_NAME].toUpperCase().equals("ID")) {
                String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);


                CheckCannotBeNull +=  "\n         o = get" + field[COLUMN_NAME] + "(); "
                                    +  "\n        if (o == null) { "
                                    + "\n            throw new CodeException (\"Error Saving Application : " + field[COLUMN_NAME] + " can not be Empty\"); "
                                    + "\n        } "
                                    + "\n ";


            }
        }
        
        return CheckCannotBeNull;
    }
    public String getSaveFields(){
        SaveFields = "";
        for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            String tipefield = getJavaVariableFromMysql(field[TYPE_NAME]);

            
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
                if ("long".equals(tipefield)) {
                     SaveFields = SaveFields 
                                  + "\n            rs.updateLong(PROPERTY_" 
                                  + field[COLUMN_NAME].toUpperCase() + " , " + field[COLUMN_NAME] + "_ ); ";
                }else if ("double".equals(tipefield)) {
                     SaveFields = SaveFields 
                                  + "\n            rs.updateDouble(PROPERTY_" 
                                  + field[COLUMN_NAME].toUpperCase() + " , " + field[COLUMN_NAME] + "_ ); ";
                }else if ("String".equals(tipefield)) {
                     SaveFields = SaveFields 
                                  + "\n            rs.updateString(PROPERTY_" 
                                  + field[COLUMN_NAME].toUpperCase() + " , " + field[COLUMN_NAME] + "_ ); ";
                }else if ("Timestamp".equals(tipefield)) {
                     SaveFields = SaveFields 
                                  + "\n            if (get" + field[COLUMN_NAME] + "()==null) {"
                                  + "\n               rs.updateTimestamp(PROPERTY_" 
                                  +                   field[COLUMN_NAME].toUpperCase() + " ,   null ); "
                                  + "\n            }else{"
                                  + "\n               rs.updateTimestamp(PROPERTY_" 
                                  +                   field[COLUMN_NAME].toUpperCase() + " ,  get" + field[COLUMN_NAME] + "()); "
                                  + "\n            }";
                }else if ("Date".equals(tipefield)) {
                     SaveFields = SaveFields 
                                  + "\n           if (get" + field[COLUMN_NAME] + "()==null) {"
                                  + "\n              rs.updateDate(PROPERTY_" 
                                  +                       field[COLUMN_NAME].toUpperCase() + " , null ); "
                                  + "\n           }else{"
                                  + "\n              rs.updateDate(PROPERTY_" + field[COLUMN_NAME].toUpperCase() + " , get" + field[COLUMN_NAME] + "()); "
                                  + "\n           }";

                } 
            }
            
        }
        return SaveFields;
    }

    public String getSETGET() {
         SetGet = "";
         for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            if (!field[COLUMN_NAME].toUpperCase().equals("ID")) {
              SetGet = SetGet 
                    + "\n      public void set" + field[COLUMN_NAME] + "(" + getJavaVariableFromMysql(field[TYPE_NAME]) + " param) throws CodeException { "
                    + "\n         if (!_isLoaded_) { read();} "
                    + "\n         " + field[COLUMN_NAME] + "_ = param; "
                    + "\n         _isDirty_ = true; " 
                    + "\n      } \n" ; 
            
              SetGet = SetGet
                     + "\n      public " + getJavaVariableFromMysql(field[TYPE_NAME]) + " get" + field[COLUMN_NAME] + "() throws CodeException {"
                     + "\n         if (!_isLoaded_) { read();} "
                     + "\n         return " + field[COLUMN_NAME] + "_; "
                     + "\n      } \n" ;
            
            }
         }
         return SetGet;        
    }
    
    public String getVariables(){
         Variables = "";
         for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            Variables = Variables + "\n    private " + getJavaVariableFromMysql(field[TYPE_NAME]) + " " + field[COLUMN_NAME] + "_;";             
         }
         return Variables;
    }
    
    public String getProperties() {
        
         Properties = "";
         for (Enumeration e = vStructure.elements(); e.hasMoreElements();) {
            String[] field = ((String[]) e.nextElement());
            Properties = Properties + "\n    public static final String PROPERTY_" 
                         + field[COLUMN_NAME].toUpperCase() + " = \"" + field[COLUMN_NAME] + "\";";            
         }
         return Properties;
    }
    
    public static StringBuffer getFileTables(){
        return openFile(GlobalUtils.getCurrentDir() + FILETABLES);        
    }
    
    public static StringBuffer getFileTable(){
        return openFile(GlobalUtils.getCurrentDir() + FILETABLE);        
    }
    public static StringBuffer getFileTableAbst() {
        return openFile(GlobalUtils.getCurrentDir() + FILETABLEABST);
    }
      
    public String getPrimaryKeyField() {
        return primarykey + "_";
    }
    public String getPrimaryKey() {
        return " public static final String PRIMARYKEY = PROPERTY_" 
                                 + getPrimaryKey(TableData).toUpperCase()  + ";";
    }
    
    
    public String getTableData(){
        return TableData;
    }
    public String getTable(){
        return Table;
    }
    public String getTables(){
        return Tables;
    }
    
    public String getTableAbst(){
        return TableAbst;
    }
    
    public String getSaveToFile(){
        return saveToFile;
    }

    
}
