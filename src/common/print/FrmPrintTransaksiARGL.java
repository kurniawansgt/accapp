/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.objectclasses.ar.Ar_invbatchlists;
import accapp.objectclasses.ar.Ar_rcpbatchlists;
import accapp.objectclasses.ar.adjustment.Ar_adjbatchlists;
import common.component.FrmBrowse;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author  wgata
 */
public class FrmPrintTransaksiARGL extends javax.swing.JDialog {
    
    

    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintTransaksiARGL(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintTransaksiARGL() {
        initComponents();


    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblHeader = new javax.swing.JLabel();
        jbtnCetak = new javax.swing.JButton();
        jbtnSelesai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcmbbatchtype = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jtxtNoBatchFr1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtxtNoBatchTo1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jcmbstatuscustomer = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jcmbjenislaporan = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jcmbshortby = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRINT AR - AGING REPORT");
        setName("FrmPrintTransaksiARGL"); // NOI18N
        getContentPane().setLayout(null);

        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("AR - GL TRANSACTION");
        jlblHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(80, 20, 300, 30);

        jbtnCetak.setText("Print");
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(120, 280, 90, 25);

        jbtnSelesai.setText("End");
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(270, 280, 90, 25);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel3.setText("Batch Type");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 80, 90, 20);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel6.setText("Report Type");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 150, 110, 20);

        jcmbbatchtype.setFont(new java.awt.Font("Dialog", 1, 9));
        jcmbbatchtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Invoice", "Receipt", "Adjustmen" }));
        jcmbbatchtype.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcmbbatchtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbbatchtypeItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbbatchtype);
        jcmbbatchtype.setBounds(160, 80, 120, 25);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel4.setText("Post Sequence No.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 110, 20);

        jtxtNoBatchFr1.setFont(new java.awt.Font("SansSerif", 1, 10));
        jtxtNoBatchFr1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jtxtNoBatchFr1);
        jtxtNoBatchFr1.setBounds(160, 120, 100, 20);

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(260, 120, 20, 20);

        jLabel10.setText("To");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(290, 120, 20, 20);

        jtxtNoBatchTo1.setFont(new java.awt.Font("SansSerif", 1, 10));
        jtxtNoBatchTo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jtxtNoBatchTo1);
        jtxtNoBatchTo1.setBounds(320, 120, 100, 19);

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(420, 120, 20, 20);

        jcmbstatuscustomer.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbstatuscustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Active", "Non Active" }));
        jcmbstatuscustomer.setSelectedIndex(1);
        jcmbstatuscustomer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcmbstatuscustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbstatuscustomerItemStateChanged(evt);
            }
        });
        jcmbstatuscustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbstatuscustomerActionPerformed(evt);
            }
        });
        getContentPane().add(jcmbstatuscustomer);
        jcmbstatuscustomer.setBounds(160, 230, 120, 25);

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel11.setText("Custommer Status");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 230, 110, 20);

        jcmbjenislaporan.setFont(new java.awt.Font("Dialog", 1, 9));
        jcmbjenislaporan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Detail", "Summary" }));
        jcmbjenislaporan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcmbjenislaporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbjenislaporanItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbjenislaporan);
        jcmbjenislaporan.setBounds(160, 150, 120, 25);

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel12.setText("Short By");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 190, 110, 20);

        jcmbshortby.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jcmbshortby.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Account Number", "Year Period", "Batch Entry" }));
        jcmbshortby.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcmbshortby.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbshortbyItemStateChanged(evt);
            }
        });
        jcmbshortby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbshortbyActionPerformed(evt);
            }
        });
        getContentPane().add(jcmbshortby);
        jcmbshortby.setBounds(160, 190, 120, 25);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-479)/2, (screenSize.height-351)/2, 479, 351);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed

        
    try{
        Map parameter = new HashMap();
//        parameter.put("kodeperusahaan", " ");
        parameter.put("operator", (GlobalUtils.getUserId()));

        parameter.put("batchtype",jcmbbatchtype.getSelectedIndex());
        String noposeqfr=  jtxtNoBatchFr1.getText();
        String noposeqto= jtxtNoBatchTo1.getText();
        if (jtxtNoBatchFr1.getText().isEmpty()){
            noposeqfr="0";
        }
        if (jtxtNoBatchTo1.getText().isEmpty()){
            noposeqfr="ZZZZZZZZZZ";
        }
        parameter.put("noseqfr", noposeqfr);
        parameter.put("noseqto",noposeqto);
        parameter.put("operator",GlobalUtils.userid);
        String act  = " ";
        String non = " " ;
        if(jcmbstatuscustomer.getSelectedIndex()==0){
                non="0";
                act="1";
        }else {
                   if(jcmbstatuscustomer.getSelectedIndex()==1){
                            non="N";
                            act="1";
                   }else {
                             non="0";
                             act="A";
                   }
        }
        parameter.put("aktifsts",act);
        parameter.put("nonaktifsts",non);

        String file   = "";
        System.out.println(parameter);

        if(jcmbbatchtype.getSelectedIndex()==1 ){
                if (jcmbjenislaporan.getSelectedIndex()==0){
                           if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceAccountNoDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceYearPeriodDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceBatchEntryDetail.jrxml";
                           }else{
                                   JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                }else{
                           if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceAccountNoSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceYearPeriodSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLInvoiceBatchEntrySummary.jrxml";
                           }else{
                                     JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                }
        }else if(jcmbbatchtype.getSelectedIndex()==2 ) {
                if (jcmbjenislaporan.getSelectedIndex()==0){
                           if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLReceiptAccountNoDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGReceiptYearPeriodDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLReceiptBatchEntryDetail.jrxml";
                           }else{
                                   JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                    }else{
                            if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLReceiptAccountNoSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLReceiptYearPeriodSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLReceiptBatchEntrySummary.jrxml";
                           }else{
                                     JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                    }
        }else if(jcmbbatchtype.getSelectedIndex()==3 ) {
                if (jcmbjenislaporan.getSelectedIndex()==0){
                           if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentAccountNoDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentYearPeriodDetail.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentBatchEntryDetail.jrxml";
                           }else{
                                   JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                   }else{
                            if (jcmbshortby.getSelectedIndex()==1){
                               file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentAccountNoSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==2){
                                   file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentYearPeriodSummary.jrxml";
                           }else if (jcmbshortby.getSelectedIndex()==3){
                                           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARGLAdjustmentBatchEntrySummary.jrxml";
                           }else{
                                     JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Sort By in the Short By column.  ");
                           }
                   }
        }else {
                    JOptionPane.showMessageDialog(this, "Printing does not work. Please select a Batch Type in the Batch Type column.  ");

        }

        
        GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnCetakActionPerformed

private void jmbModelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmbModelPropertyChange

}//GEN-LAST:event_jmbModelPropertyChange

private void jcmbbatchtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbbatchtypeItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbbatchtypeItemStateChanged

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {
            if(jcmbbatchtype.getSelectedIndex()==1){
                    Ar_invbatchlists brs = new Ar_invbatchlists();
                    FrmBrowse bd = new FrmBrowse(brs);
                    bd.setFourthValue(jtxtNoBatchFr1);
                    bd.setModal(true);
                    bd.setVisible(true);
            }else  if(jcmbbatchtype.getSelectedIndex()==2){
                            Ar_rcpbatchlists brs = new Ar_rcpbatchlists();
                            FrmBrowse bd = new FrmBrowse(brs);
                            bd.setFourthValue(jtxtNoBatchFr1);
                            bd.setModal(true);
                            bd.setVisible(true);
            }else if(jcmbbatchtype.getSelectedIndex()==3){
                            Ar_adjbatchlists brs = new Ar_adjbatchlists();
                            FrmBrowse bd = new FrmBrowse(brs);
                            bd.setFourthValue(jtxtNoBatchFr1);
                            bd.setModal(true);
                            bd.setVisible(true);
            }


    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
            if(jcmbbatchtype.getSelectedIndex()==1){
                    Ar_invbatchlists brs = new Ar_invbatchlists();
                    FrmBrowse bd = new FrmBrowse(brs);
                    bd.setFourthValue(jtxtNoBatchTo1);
                    bd.setModal(true);
                    bd.setVisible(true);
            }else  if(jcmbbatchtype.getSelectedIndex()==2){
                            Ar_rcpbatchlists brs = new Ar_rcpbatchlists();
                            FrmBrowse bd = new FrmBrowse(brs);
                            bd.setFourthValue(jtxtNoBatchTo1);
                            bd.setModal(true);
                            bd.setVisible(true);
            }else if(jcmbbatchtype.getSelectedIndex()==3){
                            Ar_adjbatchlists brs = new Ar_adjbatchlists();
                            FrmBrowse bd = new FrmBrowse(brs);
                            bd.setFourthValue(jtxtNoBatchTo1);
                            bd.setModal(true);
                            bd.setVisible(true);
            }

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton4ActionPerformed

private void jcmbstatuscustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbstatuscustomerItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbstatuscustomerItemStateChanged

private void jcmbstatuscustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbstatuscustomerActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbstatuscustomerActionPerformed

private void jcmbjenislaporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbjenislaporanItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbjenislaporanItemStateChanged

private void jcmbshortbyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbshortbyItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbshortbyItemStateChanged

private void jcmbshortbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbshortbyActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbshortbyActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintTransaksiARGL dialog = new FrmPrintTransaksiARGL(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    private javax.swing.JComboBox jcmbbatchtype;
    private javax.swing.JComboBox jcmbjenislaporan;
    private javax.swing.JComboBox jcmbshortby;
    private javax.swing.JComboBox jcmbstatuscustomer;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtNoBatchFr1;
    public javax.swing.JTextField jtxtNoBatchTo1;
    // End of variables declaration//GEN-END:variables

}