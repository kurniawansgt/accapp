/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmAP_BatchGLPosting.java
 *
 * Created on Jun 27, 2011, 8:48:18 AM
 */

package accapp.component.gl;

import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_batchlists;
import common.classinterface.NavigatorFormInt;
import common.component.FrmBrowse;
import common.component.FrmMainFrame;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wgata
 */
public class FrmGL_PostJournalEntryBatches extends javax.swing.JInternalFrame implements NavigatorFormInt {
    FrmMainFrame mf ;
    private static int istatus = 4;
    private static int iformtype = 1;
    public static String CLASSNAME="FrmAP_BatchGLPosting";
    
    /** Creates new form FrmAP_BatchGLPosting */
    public FrmGL_PostJournalEntryBatches (FrmMainFrame mf) {
        this.mf = mf;
        initComponents();

        showrange(false);
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jtxtstartbatchno = new javax.swing.JTextField();
        jbtnBrowse6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnBrowse7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxttobatchno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jHeader = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        HorizontalLine = new javax.swing.JSeparator();

        setTitle("G/L Post Journal Entry Batches");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Post The Following Batches"));
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 10));
        jPanel1.setLayout(null);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 10));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("All Batches");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(20, 30, 81, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 10));
        jRadioButton2.setText("Range");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(20, 60, 57, 23);

        jtxtstartbatchno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtstartbatchnoActionPerformed(evt);
            }
        });
        jtxtstartbatchno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtstartbatchnoPropertyChange(evt);
            }
        });
        jtxtstartbatchno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstartbatchnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstartbatchnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstartbatchnoKeyTyped(evt);
            }
        });
        jtxtstartbatchno.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtstartbatchnoVetoableChange(evt);
            }
        });
        jPanel1.add(jtxtstartbatchno);
        jtxtstartbatchno.setBounds(100, 90, 90, 20);

        jbtnBrowse6.setText("...");
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBrowse6);
        jbtnBrowse6.setBounds(190, 90, 20, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("From");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 90, 40, 14);

        jbtnBrowse7.setText("...");
        jbtnBrowse7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse7ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBrowse7);
        jbtnBrowse7.setBounds(360, 90, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("To");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 90, 30, 14);

        jtxttobatchno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxttobatchnoActionPerformed(evt);
            }
        });
        jtxttobatchno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxttobatchnoPropertyChange(evt);
            }
        });
        jtxttobatchno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttobatchnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxttobatchnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxttobatchnoKeyTyped(evt);
            }
        });
        jtxttobatchno.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxttobatchnoVetoableChange(evt);
            }
        });
        jPanel1.add(jtxttobatchno);
        jtxttobatchno.setBounds(270, 90, 90, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 80, 530, 130);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10));
        jButton1.setText("Post");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 220, 100, 23);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 10));
        jButton2.setText("Prov. Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 220, 110, 23);

        jHeader.setBackground(new java.awt.Color(102, 102, 102));
        jHeader.setFont(new java.awt.Font("Dialog", 1, 10));
        jHeader.setForeground(new java.awt.Color(255, 255, 255));
        jHeader.setText(" : : G/L Post Journal Entry Batches");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 200, 20);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 2, 400);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 650, 2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        setToolBar(iformtype,istatus);
        //mf.setIcon(CLASSNAME);
    }//GEN-LAST:event_formInternalFrameActivated

    private void jtxtstartbatchnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtstartbatchnoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartbatchnoActionPerformed

    private void jtxtstartbatchnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtstartbatchnoPropertyChange
        // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartbatchnoPropertyChange

    private void jtxtstartbatchnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartbatchnoKeyPressed


    }//GEN-LAST:event_jtxtstartbatchnoKeyPressed

    private void jtxtstartbatchnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartbatchnoKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartbatchnoKeyReleased

    private void jtxtstartbatchnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartbatchnoKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartbatchnoKeyTyped

    private void jtxtstartbatchnoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtstartbatchnoVetoableChange
        // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartbatchnoVetoableChange

    private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
        // TODO add your handling code here:
        try {
	      Gl_batchlists brs = new Gl_batchlists();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtstartbatchno);
	      bd.setModal(true);
	      bd.setVisible(true);          
	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
    }//GEN-LAST:event_jbtnBrowse6ActionPerformed

    private void jbtnBrowse7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse7ActionPerformed
        // TODO add your handling code here:
        try {
	      Gl_batchlists brs = new Gl_batchlists();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxttobatchno);
	      bd.setModal(true);
	      bd.setVisible(true);
	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
    }//GEN-LAST:event_jbtnBrowse7ActionPerformed

    private void jtxttobatchnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxttobatchnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoActionPerformed

    private void jtxttobatchnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxttobatchnoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoPropertyChange

    private void jtxttobatchnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttobatchnoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoKeyPressed

    private void jtxttobatchnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttobatchnoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoKeyReleased

    private void jtxttobatchnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttobatchnoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoKeyTyped

    private void jtxttobatchnoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxttobatchnoVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttobatchnoVetoableChange

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
        showrange(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        showrange(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            setCursor(GlobalUtils.HOURGLASSCURSOR);
            dopost(false);
        } catch (CodeException ex) {
            Logger.getLogger(FrmGL_PostJournalEntryBatches.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            setCursor(GlobalUtils.HOURGLASSCURSOR);
            dopost(true);
        } catch (CodeException ex) {
            Logger.getLogger(FrmGL_PostJournalEntryBatches.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showrange(Boolean visible){
        jLabel2.setVisible(visible);
        jtxtstartbatchno.setVisible(visible);
        jbtnBrowse6.setVisible(visible);
        jLabel3.setVisible(visible);
        jtxttobatchno.setVisible(visible);
        jbtnBrowse7.setVisible(visible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jHeader;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnBrowse6;
    private javax.swing.JButton jbtnBrowse7;
    protected javax.swing.JTextField jtxtstartbatchno;
    protected javax.swing.JTextField jtxttobatchno;
    // End of variables declaration//GEN-END:variables

    public void delete() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void moveFirst() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void movePrevious() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void moveNext() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void moveLast() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void newData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);
    }

    public void setData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void undo() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void execute() throws CodeException {

    }
    public void dopost(Boolean provpost) throws CodeException {
        Gl_batchlist apbatchlist=new Gl_batchlist();

        int frombatchno=0;
        int tobatchno=0;

        if (jRadioButton1.isSelected()){
            if(apbatchlist.checkGLJournalPosting()) {
                apbatchlist.doPosting(provpost,frombatchno,tobatchno);
                JOptionPane.showMessageDialog(null, "Done");
            }else {
                JOptionPane.showMessageDialog(null, "Tidak Ada Yang Diposting");
            }
        } else {
            frombatchno=GlobalUtils.CNomorInt(jtxtstartbatchno.getText());
            tobatchno=GlobalUtils.CNomorInt(jtxttobatchno.getText());

            if (frombatchno==0||tobatchno==0){
                JOptionPane.showMessageDialog(null, "Harap Pilih Batch");
            }else {
                if(apbatchlist.checkGLJournalPosting()) {
                    apbatchlist.doPosting(provpost,frombatchno,tobatchno);
                    JOptionPane.showMessageDialog(null, "Done");
                }else {
                    JOptionPane.showMessageDialog(null, "Tidak Ada Yang Diposting");
                }
            }
        }
    }

    public void searchData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void importCsv() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void exportCsv() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void importText() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void exportText() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
