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


import accapp.objectclasses.ap.Ap_invh;
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
public class FrmAp_invpopaddress extends javax.swing.JDialog {
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
    
    Ap_invh oar_invh=null;
    
    /** Creates new form frmBrowse */
    public FrmAp_invpopaddress() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public FrmAp_invpopaddress(Ap_invh oar_invh) throws CodeException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.oar_invh=oar_invh;

        jtxtShipVia.setText(oar_invh.getshpvia());
        jtxtSpecInstr.setText(oar_invh.getspecinstr());


    }
    public FrmAp_invpopaddress(JInternalFrame jf,Object obj) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        retrieveData();

    }

    public FrmAp_invpopaddress(Object obj) throws CodeException {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        retrieveData();
    }

        
    public FrmAp_invpopaddress(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        
        this.filterfield = filterfield; 
    }
    public FrmAp_invpopaddress(Object obj, String filterfield) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        
        this.filterfield = filterfield; 
               
    }
    
    public FrmAp_invpopaddress(JTable jtable, Object obj, int row, int col) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();

    } 
   
     public FrmAp_invpopaddress(TableModel tmodel, Object obj, int row, int col) {
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
        jtxtShipVia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtSpecInstr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnSelect.setText("Select");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jtxtShipVia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtShipViaActionPerformed(evt);
            }
        });
        jtxtShipVia.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtShipViaPropertyChange(evt);
            }
        });
        jtxtShipVia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtShipViaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtShipViaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtShipViaKeyTyped(evt);
            }
        });
        jtxtShipVia.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtShipViaVetoableChange(evt);
            }
        });

        jLabel3.setText("Ship Via");

        jLabel4.setText("Special Instruction");

        jtxtSpecInstr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSpecInstrActionPerformed(evt);
            }
        });
        jtxtSpecInstr.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtSpecInstrPropertyChange(evt);
            }
        });
        jtxtSpecInstr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtSpecInstrKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSpecInstrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtSpecInstrKeyTyped(evt);
            }
        });
        jtxtSpecInstr.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtSpecInstrVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSpecInstr, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                            .addComponent(jtxtShipVia, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtShipVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtSpecInstr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSelect)
                    .addComponent(jbtnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
        try {
            selectRow();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invpopaddress.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() throws CodeException {
   Integer irow;
   
   setCursor(GlobalUtils.HOURGLASSCURSOR);

   oar_invh.setshpvia(jtxtShipVia.getText());
   oar_invh.setspecinstr(jtxtSpecInstr.getText());
   
   setVisible(false); 
   
   setCursor(GlobalUtils.NORMALCURSOR);

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed
    

private void jtxtShipViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtShipViaActionPerformed

}//GEN-LAST:event_jtxtShipViaActionPerformed

private void jtxtShipViaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtShipViaPropertyChange

    

}//GEN-LAST:event_jtxtShipViaPropertyChange

private void jtxtShipViaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtShipViaKeyPressed

   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            retrieveData();                                         
        } catch (CodeException ex) {
           ex.printStackTrace();
        }
        jtxtSpecInstr.requestFocus();
   }
}//GEN-LAST:event_jtxtShipViaKeyPressed

private void jtxtShipViaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtShipViaKeyReleased
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       jtxtSpecInstr.requestFocus(); 
    }
}//GEN-LAST:event_jtxtShipViaKeyReleased

private void jtxtShipViaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtShipViaKeyTyped

}//GEN-LAST:event_jtxtShipViaKeyTyped

private void jtxtShipViaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtShipViaVetoableChange

}//GEN-LAST:event_jtxtShipViaVetoableChange

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    
}//GEN-LAST:event_formWindowOpened

private void jtxtSpecInstrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSpecInstrActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtSpecInstrActionPerformed

private void jtxtSpecInstrPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtSpecInstrPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtSpecInstrPropertyChange

private void jtxtSpecInstrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSpecInstrKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jbtnSelect.requestFocus();
    }
}//GEN-LAST:event_jtxtSpecInstrKeyPressed

private void jtxtSpecInstrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSpecInstrKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtSpecInstrKeyReleased

private void jtxtSpecInstrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSpecInstrKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtSpecInstrKeyTyped

private void jtxtSpecInstrVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtSpecInstrVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtSpecInstrVetoableChange

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAp_invpopaddress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnSelect;
    protected javax.swing.JTextField jtxtShipVia;
    protected javax.swing.JTextField jtxtSpecInstr;
    // End of variables declaration//GEN-END:variables

    protected JTable jtableparam;
    protected TableModel tmodelparam;
    protected int coltable1 = 0;
    protected int rowtable1 = 0;
    
}
