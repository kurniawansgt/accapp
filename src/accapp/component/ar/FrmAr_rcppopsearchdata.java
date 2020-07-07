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

package accapp.component.ar;


import accapp.objectclasses.ar.Ar_rcph;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author  windu
 */
public class FrmAr_rcppopsearchdata extends javax.swing.JDialog {
    private String mode="Select";
    private String startpono = "";
    private String type = "";
    private String sortby = "";

    Ar_rcph oAr_rcph=null;
    
    /** Creates new form frmBrowse */
    public FrmAr_rcppopsearchdata(Ar_rcph obj) {
        this.oAr_rcph=obj;
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

        jLabel3.setText("Mode");

        jLabel4.setText("Starting PO No.");

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

        jbtnBrowse6.setText("...");
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(joptSelect);
        joptSelect.setFont(new java.awt.Font("Dialog", 0, 12));
        joptSelect.setSelected(true);
        joptSelect.setText("Select");

        buttonGroup1.add(joptSelect1);
        joptSelect1.setFont(new java.awt.Font("Dialog", 0, 12));
        joptSelect1.setText("Direct");

        jLabel5.setText("Doc Type");

        jcmbDocType.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jcmbDocType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Credit Note", "Debit Note", "Interest Invoice" }));

        jLabel6.setText("Order By");

        jcmbSortBy.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jcmbSortBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Document No", "PO Number", "Order No" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(joptSelect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(joptSelect1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtstartpono, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnBrowse6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcmbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(joptSelect)
                    .addComponent(joptSelect1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtstartpono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBrowse6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcmbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcmbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            Logger.getLogger(FrmAr_rcppopsearchdata.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() throws CodeException {
   Integer irow;
   
   setCursor(GlobalUtils.HOURGLASSCURSOR);

   if (joptSelect.isSelected()){
        mode="Select";
   } else {
       mode="Direct";
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
    // TODO add your handling code here:
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
