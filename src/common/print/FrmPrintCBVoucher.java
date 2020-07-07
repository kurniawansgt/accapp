/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.component.browse.FrmBrowseCb_voucherAll;
import accapp.objectclasses.cashbook.Cb_banks;
import accapp.objectclasses.cashbook.Cb_batchcontrols;
import accapp.objectclasses.cashbook.Cb_vouchers;
import common.component.FrmBrowse;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;


/**
 *
 * @author  wgata
 */
public class FrmPrintCBVoucher extends javax.swing.JDialog {
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DateFormat dateformatprint =new SimpleDateFormat("yyyy-MM-dd");


    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintCBVoucher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintCBVoucher() {
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
        jLabel2 = new javax.swing.JLabel();
        jtxtbankcodefr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jtxtbankcodeto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtxtbatchnofr = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jtxtbatchnoto = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kvoucherdate_fr = new org.kazao.calendar.KazaoCalendarDate();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kvoucherdate_to = new org.kazao.calendar.KazaoCalendarDate();
        jtxtbanknamefr = new javax.swing.JTextField();
        jtxtbanknameto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRINT AR - CUSTOMMER TRANSACTION");
        setName("FrmPrintTransaksiARVendorawal"); // NOI18N
        getContentPane().setLayout(null);

        jlblHeader.setFont(new java.awt.Font("Dialog", 1, 12));
        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("CB - Voucher (Payment/Receipt)");
        jlblHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(10, 10, 290, 50);

        jbtnCetak.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnCetak.setText("Print");
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(50, 340, 90, 24);

        jbtnSelesai.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnSelesai.setText("End");
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(160, 340, 90, 24);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("From Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 200, 90, 20);

        jtxtbankcodefr.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(jtxtbankcodefr);
        jtxtbankcodefr.setBounds(140, 80, 110, 23);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 80, 20, 20);

        jtxtbankcodeto.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(jtxtbankcodeto);
        jtxtbankcodeto.setBounds(140, 140, 110, 23);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 140, 20, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel5.setText("Voucher No. To");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 290, 90, 20);

        jtxtbatchnofr.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(jtxtbatchnofr);
        jtxtbatchnofr.setBounds(140, 260, 110, 23);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 10));
        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(250, 260, 20, 20);

        jtxtbatchnoto.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(jtxtbatchnoto);
        jtxtbatchnoto.setBounds(140, 290, 110, 23);

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(250, 290, 20, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel6.setText("From No. Bank");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 80, 90, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel7.setText("Voucher No. From");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 260, 110, 20);

        kvoucherdate_fr.setFontDate(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(kvoucherdate_fr);
        kvoucherdate_fr.setBounds(140, 200, 110, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("To No. Bank");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 140, 90, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel4.setText("To Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 230, 90, 20);

        kvoucherdate_to.setFontDate(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(kvoucherdate_to);
        kvoucherdate_to.setBounds(140, 230, 110, 20);

        jtxtbanknamefr.setEditable(false);
        jtxtbanknamefr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtbanknamefr);
        jtxtbanknamefr.setBounds(30, 110, 240, 23);

        jtxtbanknameto.setEditable(false);
        jtxtbanknameto.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(jtxtbanknameto);
        jtxtbanknameto.setBounds(30, 170, 240, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-324)/2, (screenSize.height-413)/2, 324, 413);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed
        String voucherdate_fr=GlobalUtils.formatDate(kvoucherdate_fr.getDate(), "yyyy-MM-dd");
        String voucherdate_to=GlobalUtils.formatDate(kvoucherdate_to.getDate(), "yyyy-MM-dd");

        
    try{
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file   = "" ;
        Map parameter = new HashMap();
        String bankcodefr=jtxtbankcodefr.getText();
        String bankcodeto=jtxtbankcodeto.getText();

        String batchnofr=jtxtbatchnofr.getText();
        String batchnoto=jtxtbatchnoto.getText();
        
        parameter.put("bankcode_fr", bankcodefr);
        parameter.put("bankcode_to", bankcodeto);
        parameter.put("voucherdate_fr", voucherdate_fr);
        parameter.put("voucherdate_to", voucherdate_to);
        parameter.put("voucherno_fr", batchnofr);
        parameter.put("voucherno_to", batchnoto);
        

        System.out.println(parameter);
        file = GlobalUtils.getCurrentDir() +"/Reports/cb_voucher_frm.jrxml";


       GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
    setCursor(GlobalUtils.NORMALCURSOR);
}//GEN-LAST:event_jbtnCetakActionPerformed

private void jmbModelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmbModelPropertyChange

}//GEN-LAST:event_jmbModelPropertyChange

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        Cb_banks brs = new Cb_banks();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtbankcodefr);
        bd.setSecondValue(jtxtbanknamefr);
        bd.setModal(true);
        bd.setVisible(true);

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        Cb_banks brs = new Cb_banks();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtbankcodeto);
        bd.setSecondValue(jtxtbanknameto);
        bd.setModal(true);
        bd.setVisible(true);


    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    try {
        Cb_vouchers brs = new Cb_vouchers();
        FrmBrowseCb_voucherAll bd = new FrmBrowseCb_voucherAll(brs);
        bd.setSecondValue(jtxtbatchnofr);
        bd.setModal(true);
        bd.setVisible(true);

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    try {
        Cb_vouchers brs = new Cb_vouchers();
        FrmBrowseCb_voucherAll bd = new FrmBrowseCb_voucherAll(brs);
        bd.setSecondValue(jtxtbatchnoto);
        bd.setModal(true);
        bd.setVisible(true);

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintCBVoucher dialog = new FrmPrintCBVoucher(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtbankcodefr;
    public javax.swing.JTextField jtxtbankcodeto;
    public javax.swing.JTextField jtxtbanknamefr;
    public javax.swing.JTextField jtxtbanknameto;
    public javax.swing.JTextField jtxtbatchnofr;
    public javax.swing.JTextField jtxtbatchnoto;
    private org.kazao.calendar.KazaoCalendarDate kvoucherdate_fr;
    private org.kazao.calendar.KazaoCalendarDate kvoucherdate_to;
    // End of variables declaration//GEN-END:variables

}
