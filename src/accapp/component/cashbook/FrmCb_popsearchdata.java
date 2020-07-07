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

package accapp.component.cashbook;




import accapp.objectclasses.cashbook.Cb_batchd;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author  windu
 */
public class FrmCb_popsearchdata extends javax.swing.JDialog {
    private String mode="Select";
    private String startpono = "";
    private String type = "";
    private String sortby = "";

    Cb_batchd oAp_payh=null;
    
    /** Creates new form frmBrowse */
    public FrmCb_popsearchdata(Cb_batchd obj) {
        this.oAp_payh=obj;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jbtnSelect = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtstartpono = new javax.swing.JTextField();
        jbtnBrowse6 = new javax.swing.JButton();
        joptSelect = new javax.swing.JRadioButton();
        joptSelect1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jcmbDocType = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jcmbSortBy = new javax.swing.JComboBox();
        joptSelect2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        setMinimumSize(new java.awt.Dimension(500, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jbtnSelect.setText("Select");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelect);
        jbtnSelect.setBounds(12, 118, 70, 25);

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCancel);
        jbtnCancel.setBounds(88, 118, 75, 25);

        jLabel3.setText("Mode");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 12, 34, 15);

        jLabel4.setText("Starting Doc No.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 35, 160, 15);

        jtxtstartpono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtstartponoActionPerformed(evt);
            }
        });
        jtxtstartpono.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtstartponoPropertyChange(evt);
            }
        });
        jtxtstartpono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyTyped(evt);
            }
        });
        jtxtstartpono.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtstartponoVetoableChange(evt);
            }
        });
        getContentPane().add(jtxtstartpono);
        jtxtstartpono.setBounds(181, 33, 193, 19);

        jbtnBrowse6.setText("...");
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse6);
        jbtnBrowse6.setBounds(380, 34, 20, 17);

        buttonGroup1.add(joptSelect);
        joptSelect.setFont(new java.awt.Font("Dialog", 0, 12));
        joptSelect.setSelected(true);
        joptSelect.setText("Select");
        getContentPane().add(joptSelect);
        joptSelect.setBounds(181, 8, 58, 23);

        buttonGroup1.add(joptSelect1);
        joptSelect1.setFont(new java.awt.Font("Dialog", 0, 12));
        joptSelect1.setText("Prepayment");
        getContentPane().add(joptSelect1);
        joptSelect1.setBounds(239, 8, 94, 23);

        jLabel5.setText("Doc Type");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 63, 58, 15);

        jcmbDocType.setFont(new java.awt.Font("Dialog", 0, 12));
        jcmbDocType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Credit Note", "Debit Note", "Interest Invoice" }));
        jcmbDocType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbDocTypeKeyPressed(evt);
            }
        });
        getContentPane().add(jcmbDocType);
        jcmbDocType.setBounds(181, 58, 130, 24);

        jLabel6.setText("Order By");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 93, 54, 15);

        jcmbSortBy.setFont(new java.awt.Font("Dialog", 0, 12));
        jcmbSortBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Document No", "PO Number", "Order No" }));
        jcmbSortBy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbSortByKeyPressed(evt);
            }
        });
        getContentPane().add(jcmbSortBy);
        jcmbSortBy.setBounds(181, 88, 130, 24);

        buttonGroup1.add(joptSelect2);
        joptSelect2.setFont(new java.awt.Font("Dialog", 0, 12));
        joptSelect2.setText("Apply Document");
        getContentPane().add(joptSelect2);
        joptSelect2.setBounds(330, 10, 170, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
        try {
            selectRow();
        } catch (CodeException ex) {
            Logger.getLogger(FrmCb_popsearchdata.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() throws CodeException {
   Integer irow;
   
   setCursor(GlobalUtils.HOURGLASSCURSOR);

   if (joptSelect.isSelected()){
        mode="Select";
   } else if (joptSelect1.isSelected()){
       mode="Prepayment";
   } else {
       mode="Apply Document";
   }

   startpono = jtxtstartpono.getText();

   int doctype=0;
    switch (jcmbDocType.getSelectedIndex()){
        case 0:
            doctype=4;
            break;
        case 1:
            doctype=5;
            break;
        case 2:
            doctype=6;
            break;
        case 3:
            doctype=7;
            break;
    }

   type = doctype+"";
   int i=jcmbSortBy.getSelectedIndex();
   switch (i){
       case 0:
           sortby = "docnum";
           break;
       case 1:
           sortby="custmrpono";
           break;
       case 2:
           sortby="orderno";
           break;
   }
 
   setVisible(false); 
   
   setCursor(GlobalUtils.NORMALCURSOR);

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed
    

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    
}//GEN-LAST:event_formWindowOpened

private void jtxtstartponoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtstartponoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoActionPerformed

private void jtxtstartponoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtstartponoPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoPropertyChange

private void jtxtstartponoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbDocType.requestFocus();
    }
    
}//GEN-LAST:event_jtxtstartponoKeyPressed

private void jtxtstartponoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoKeyReleased

private void jtxtstartponoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoKeyTyped

private void jtxtstartponoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtstartponoVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoVetoableChange

private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
    // TODO add your handling code here:

}//GEN-LAST:event_jbtnBrowse6ActionPerformed

private void jcmbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbDocTypeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbSortBy.requestFocus();
    }
}//GEN-LAST:event_jcmbDocTypeKeyPressed

private void jcmbSortByKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbSortByKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jbtnSelect.requestFocus();
    }
    
}//GEN-LAST:event_jcmbSortByKeyPressed

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbtnBrowse6;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnSelect;
    private javax.swing.JComboBox jcmbDocType;
    private javax.swing.JComboBox jcmbSortBy;
    private javax.swing.JRadioButton joptSelect;
    private javax.swing.JRadioButton joptSelect1;
    private javax.swing.JRadioButton joptSelect2;
    protected javax.swing.JTextField jtxtstartpono;
    // End of variables declaration//GEN-END:variables

    protected int coltable1 = 0;
    protected int rowtable1 = 0;

    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return the startpono
     */
    public String getStartpono() {
        return startpono;
    }

    /**
     * @param startpono the startpono to set
     */
    public void setStartpono(String startpono) {
        this.startpono = startpono;
    }

    /**
     * @return the type
     */
    public String getTypes() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the sortby
     */
    public String getSortby() {
        return sortby;
    }

    /**
     * @param sortby the sortby to set
     */
    public void setSortby(String sortby) {
        this.sortby = sortby;
    }
    
}
