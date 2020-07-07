/*
 * FrmBrowse.java
 *
 * Created on December 22, 2008, 11:00 AM
 * 
 * FrmBrowse is POPUP Form to Filter Data From Collection
 * 
 * How To :
 * 1. Find array Column In Collection, and change to field/data you want to browse
 * 
 *   Sample : 
        private String[][] column = {
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "200"}, 
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "500"}
        };
 * 
 * 2. From Browse can be used with JTextField, JTable, TableModel
 * 
 * 3. If you input JInternalFrame as Parameter, 
        it will automatically run method searcData on Form
 * 
 */

package accapp.component.ap;



import accapp.objectclasses.ap.Ap_payh;
import accapp.objectclasses.ap.Ap_remitaddress;
import common.classinterface.NavigatorBrowseDataInt;
import common.classinterface.NavigatorFormInt;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.tablemodels.BdModel;
import common.tablemodels.BrowseColumnModelCol;
import common.utils.GlobalUtils;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author  windu
 */
public class FrmAp_payremitto extends javax.swing.JDialog {
    protected DefaultTableModel tmodel=new BdModel();
    
    protected NavigatorBrowseDataInt nbd = null;
    protected BrowseColumnModelCol colModel=new BrowseColumnModelCol();
    
    protected String filterfield="";
    String table="";
    
    protected JTextField first = null;
    protected JTextField second = null;
    protected JTextField third = null;
    protected JTextField fourth = null;
    
    protected NavigatorFormInt nfi = null;
    
    protected int skip = 0;
    
    Ap_payh oar_invh=null;
    Ap_remitaddress apremit;
    
    /** Creates new form frmBrowse */
    public FrmAp_payremitto() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public FrmAp_payremitto(Ap_payh oar_invh) throws CodeException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.oar_invh=oar_invh;

        apremit=oar_invh.getApremit();
        jtxtremitname.setText(apremit.getremitname());
        jtxtaddress.setText(apremit.getaddress());
        jtxtcity.setText(apremit.getcity());
        jtxtstate.setText(apremit.getstate());
        jtxtzipcode.setText(apremit.getzipcode());
        jtxtcountry.setText(apremit.getcountry());

        showdata();


    }

    private void showdata(){

    }

    public FrmAp_payremitto(JInternalFrame jf,Object obj) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        retrieveData();

    }

    public FrmAp_payremitto(Object obj) throws CodeException {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        retrieveData();
    }

        
    public FrmAp_payremitto(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        
        this.filterfield = filterfield; 
    }
    public FrmAp_payremitto(Object obj, String filterfield) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        
        this.filterfield = filterfield; 
               
    }
    
    public FrmAp_payremitto(JTable jtable, Object obj, int row, int col) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();

    } 
   
     public FrmAp_payremitto(TableModel tmodel, Object obj, int row, int col) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();

    } 
    
    public void setFirstValue(JTextField first) {
        this.first = first;
    }

      
    public void setSecondValue(JTextField second) {
        this.second = second;
    }

    public void setThirdValue(JTextField third) {
        this.third = third;
    }

    public void setFourthValue(JTextField fourth) {
        this.fourth = fourth;
    }
    
    protected void setFieldInCombo(){
        String[][] columns= nbd.getColumn();

        for (int i= 0; i < columns.length; i++ ) {
            colModel.Insert();
            colModel.getColModel().setColName(columns[i][0]);
            colModel.getColModel().setColDesc(columns[i][1]);
            colModel.getColModel().setColWidth(Integer.parseInt(columns[i][2]));
            colModel.add(colModel.getColModel());
        }

        for(int i=0;i<colModel.size();i++){

       }
    }
    
    protected void setColHeader(){
        for (int i=0;i<colModel.size();i++){
            tmodel.addColumn(colModel.get(i).getColDesc());
        }
    }
    protected void setColWidth(){
        for (int i=0;i<colModel.size();i++){
            if (colModel.get(i).getColWidth()>0){
                setColumnWidth(i,colModel.get(i).getColWidth());
            }
        }
    }
    
    public void retrieveData () throws CodeException{
        
        setCursor(GlobalUtils.HOURGLASSCURSOR);

        
        String[][] columns= nbd.getColumn();
        
        

         
        //delete row
        int row = tmodel.getRowCount();			
        while(row > 0){	
            row--;				
            tmodel.removeRow(row);
        }	
          


        
        
         Object[] data = new Object[nbd.getColumn().length];
         
         for (Object o: nbd.list()) {
             CodeObjectInt jcoi = (CodeObjectInt) o;
             for (int i = 0; i< columns.length; i++) {
                data[i] = jcoi.toString(columns[i][0]);
             }
             tmodel.addRow(data);
         }
         
         
         
         if (nbd.size() > 100) {
            
         }
        setCursor(GlobalUtils.NORMALCURSOR);

    }
    
    protected void setColumnWidth(Integer ColumnIdx,Integer Width){
       
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSelect = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jtxtremitname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtcity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtstate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtzipcode = new javax.swing.JTextField();
        jtxtcountry = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtaddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        setMinimumSize(new java.awt.Dimension(450, 340));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jbtnSelect.setText("Save");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelect);
        jbtnSelect.setBounds(10, 250, 62, 25);

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCancel);
        jbtnCancel.setBounds(90, 250, 75, 25);

        jtxtremitname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtremitnameActionPerformed(evt);
            }
        });
        jtxtremitname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtremitnameFocusGained(evt);
            }
        });
        jtxtremitname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtremitnamePropertyChange(evt);
            }
        });
        jtxtremitname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtremitnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtremitnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtremitnameKeyTyped(evt);
            }
        });
        jtxtremitname.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtremitnameVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtremitname);
        jtxtremitname.setBounds(134, 12, 290, 19);

        jLabel3.setText("Remit To");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 14, 56, 15);

        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 37, 51, 15);

        jtxtcity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcityActionPerformed(evt);
            }
        });
        jtxtcity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtcityFocusGained(evt);
            }
        });
        jtxtcity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtcityPropertyChange(evt);
            }
        });
        jtxtcity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtcityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtcityKeyTyped(evt);
            }
        });
        jtxtcity.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtcityVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtcity);
        jtxtcity.setBounds(134, 143, 290, 19);

        jLabel5.setText("City");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 145, 56, 15);

        jLabel6.setText("State / Province");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 170, 121, 15);

        jtxtstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtstateActionPerformed(evt);
            }
        });
        jtxtstate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtstateFocusGained(evt);
            }
        });
        jtxtstate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtstatePropertyChange(evt);
            }
        });
        jtxtstate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstateKeyTyped(evt);
            }
        });
        jtxtstate.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtstateVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtstate);
        jtxtstate.setBounds(134, 168, 290, 19);

        jLabel7.setText("Zip / Postal Code");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(12, 195, 120, 15);

        jtxtzipcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtzipcodeActionPerformed(evt);
            }
        });
        jtxtzipcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtzipcodeFocusGained(evt);
            }
        });
        jtxtzipcode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtzipcodePropertyChange(evt);
            }
        });
        jtxtzipcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtzipcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtzipcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtzipcodeKeyTyped(evt);
            }
        });
        jtxtzipcode.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtzipcodeVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtzipcode);
        jtxtzipcode.setBounds(134, 193, 290, 19);

        jtxtcountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcountryActionPerformed(evt);
            }
        });
        jtxtcountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtcountryFocusGained(evt);
            }
        });
        jtxtcountry.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtcountryPropertyChange(evt);
            }
        });
        jtxtcountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcountryKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtcountryKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtcountryKeyTyped(evt);
            }
        });
        jtxtcountry.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtcountryVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtcountry);
        jtxtcountry.setBounds(134, 218, 290, 19);

        jLabel8.setText("Country");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(12, 220, 92, 15);

        jtxtaddress.setColumns(20);
        jtxtaddress.setRows(5);
        jtxtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtaddressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtxtaddress);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(133, 40, 290, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
        try {
            selectRow();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_payremitto.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() throws CodeException {
   Integer irow;
   
   setCursor(GlobalUtils.HOURGLASSCURSOR);

   apremit.setremitname(jtxtremitname.getText());
    apremit.setaddress(jtxtaddress.getText());
    apremit.setcity(jtxtcity.getText());
    apremit.setstate(jtxtstate.getText());
    apremit.setzipcode(jtxtzipcode.getText());
    apremit.setcountry(jtxtcountry.getText());

   oar_invh.setApremit(apremit);
    
   setVisible(false); 
   
   setCursor(GlobalUtils.NORMALCURSOR);

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed
    

private void jtxtremitnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtremitnameActionPerformed

}//GEN-LAST:event_jtxtremitnameActionPerformed

private void jtxtremitnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtremitnamePropertyChange

    

}//GEN-LAST:event_jtxtremitnamePropertyChange

private void jtxtremitnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtremitnameKeyPressed

   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            retrieveData();                                         
        } catch (CodeException ex) {
           ex.printStackTrace();
        }
        jtxtaddress.requestFocus();
   }
}//GEN-LAST:event_jtxtremitnameKeyPressed

private void jtxtremitnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtremitnameKeyReleased
    
}//GEN-LAST:event_jtxtremitnameKeyReleased

private void jtxtremitnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtremitnameKeyTyped

}//GEN-LAST:event_jtxtremitnameKeyTyped

private void jtxtremitnameVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtremitnameVetoableChange

}//GEN-LAST:event_jtxtremitnameVetoableChange

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    
}//GEN-LAST:event_formWindowOpened

private void jtxtcityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcityActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcityActionPerformed

private void jtxtcityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtcityPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcityPropertyChange

private void jtxtcityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcityKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtstate.requestFocus();
    }
    
}//GEN-LAST:event_jtxtcityKeyPressed

private void jtxtcityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcityKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcityKeyReleased

private void jtxtcityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcityKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcityKeyTyped

private void jtxtcityVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtcityVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcityVetoableChange

private void jtxtstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtstateActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstateActionPerformed

private void jtxtstatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtstatePropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstatePropertyChange

private void jtxtstateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtzipcode.requestFocus();
    }
    
}//GEN-LAST:event_jtxtstateKeyPressed

private void jtxtstateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstateKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstateKeyReleased

private void jtxtstateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstateKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstateKeyTyped

private void jtxtstateVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtstateVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstateVetoableChange

private void jtxtzipcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtzipcodeActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtzipcodeActionPerformed

private void jtxtzipcodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtzipcodePropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtzipcodePropertyChange

private void jtxtzipcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtzipcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtcountry.requestFocus();
    }
}//GEN-LAST:event_jtxtzipcodeKeyPressed

private void jtxtzipcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtzipcodeKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtzipcodeKeyReleased

private void jtxtzipcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtzipcodeKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtzipcodeKeyTyped

private void jtxtzipcodeVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtzipcodeVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtzipcodeVetoableChange

private void jtxtcountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcountryActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcountryActionPerformed

private void jtxtcountryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtcountryPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcountryPropertyChange

private void jtxtcountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcountryKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jbtnSelect.requestFocus();
    }
}//GEN-LAST:event_jtxtcountryKeyPressed

private void jtxtcountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcountryKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcountryKeyReleased

private void jtxtcountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcountryKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcountryKeyTyped

private void jtxtcountryVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtcountryVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtcountryVetoableChange

private void jtxtremitnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtremitnameFocusGained
    GlobalUtils.highlighttext(jtxtremitname);
}//GEN-LAST:event_jtxtremitnameFocusGained

private void jtxtcityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtcityFocusGained
    // TODO add your handling code here:
    GlobalUtils.highlighttext(jtxtcity);
}//GEN-LAST:event_jtxtcityFocusGained

private void jtxtstateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtstateFocusGained
    // TODO add your handling code here:
    GlobalUtils.highlighttext(jtxtstate);
}//GEN-LAST:event_jtxtstateFocusGained

private void jtxtzipcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtzipcodeFocusGained
    // TODO add your handling code here:
    GlobalUtils.highlighttext(jtxtzipcode);
}//GEN-LAST:event_jtxtzipcodeFocusGained

private void jtxtcountryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtcountryFocusGained
    // TODO add your handling code here:
    GlobalUtils.highlighttext(jtxtcountry);
}//GEN-LAST:event_jtxtcountryFocusGained

private void jtxtaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtaddressKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtcity.requestFocus();
    }
}//GEN-LAST:event_jtxtaddressKeyPressed
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAp_payremitto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnSelect;
    private javax.swing.JTextArea jtxtaddress;
    protected javax.swing.JTextField jtxtcity;
    protected javax.swing.JTextField jtxtcountry;
    protected javax.swing.JTextField jtxtremitname;
    protected javax.swing.JTextField jtxtstate;
    protected javax.swing.JTextField jtxtzipcode;
    // End of variables declaration//GEN-END:variables

    protected JTable jtableparam;
    protected TableModel tmodelparam;
    protected int coltable1 = 0;
    protected int rowtable1 = 0;
    
}
