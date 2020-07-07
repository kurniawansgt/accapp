/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.component.browse.FrmBrowseARCustomer;
import accapp.objectclasses.ar.Ar_customers;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 *
 * @author  wgata
 */
public class FrmPrintTransaksiARAging extends javax.swing.JDialog {
    
    

    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintTransaksiARAging(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintTransaksiARAging() {
        initComponents();
        tanggal_asof.setText(GlobalUtils.formatDate(GlobalUtils.getCurrentDate(), "yyyy/MM/dd"));
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtNoBatchFr = new javax.swing.JTextField();
        jlblHeader = new javax.swing.JLabel();
        jbtnCetak = new javax.swing.JButton();
        jbtnSelesai = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jtxtNoBatchTo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcmbjenislaporan = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcmbstatuscustomer = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        tanggal_asof = new javax.swing.JFormattedTextField();
        jTextYop = new javax.swing.JTextField();
        jTextMop = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Module AR - Report - Aging");
        getContentPane().setLayout(null);

        jtxtNoBatchFr.setFont(new java.awt.Font("SansSerif", 0, 10));
        jtxtNoBatchFr.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtNoBatchFr.setNextFocusableComponent(jtxtNoBatchTo);
        getContentPane().add(jtxtNoBatchFr);
        jtxtNoBatchFr.setBounds(140, 70, 100, 20);

        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("AR - AGING REPORT");
        jlblHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(20, 10, 410, 40);

        jbtnCetak.setText("Print");
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(100, 210, 80, 23);

        jbtnSelesai.setText("End");
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(300, 210, 80, 23);

        jButton1.setText("...");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 70, 20, 20);

        jtxtNoBatchTo.setFont(new java.awt.Font("SansSerif", 0, 10));
        jtxtNoBatchTo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtNoBatchTo.setNextFocusableComponent(tanggal_asof);
        getContentPane().add(jtxtNoBatchTo);
        jtxtNoBatchTo.setBounds(300, 70, 100, 20);

        jButton2.setText("...");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setNextFocusableComponent(tanggal_asof);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 70, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Custumer Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 70, 90, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel6.setText("Report Type");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 130, 90, 20);

        jcmbjenislaporan.setFont(new java.awt.Font("Dialog", 1, 9));
        jcmbjenislaporan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Detail", "Summary" }));
        jcmbjenislaporan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jcmbjenislaporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbjenislaporanItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbjenislaporan);
        jcmbjenislaporan.setBounds(140, 130, 120, 24);

        jLabel9.setText("To");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(270, 70, 20, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel4.setText("Periode [yyyy/mm/dd]");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 100, 130, 20);

        jcmbstatuscustomer.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbstatuscustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Active", "Non Active" }));
        jcmbstatuscustomer.setSelectedIndex(1);
        jcmbstatuscustomer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        jcmbstatuscustomer.setBounds(140, 160, 120, 24);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel11.setText("Vendor Status");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 160, 90, 20);

        jButton5.setText("Exp");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(200, 210, 80, 23);

        try {
            tanggal_asof.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tanggal_asof.setToolTipText("Format = yyyy/mm/dd");
        tanggal_asof.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tanggal_asofFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tanggal_asofFocusLost(evt);
            }
        });
        getContentPane().add(tanggal_asof);
        tanggal_asof.setBounds(160, 100, 100, 22);

        jTextYop.setEnabled(false);
        jTextYop.setFocusable(false);
        getContentPane().add(jTextYop);
        jTextYop.setBounds(270, 100, 50, 22);

        jTextMop.setEnabled(false);
        jTextMop.setFocusable(false);
        getContentPane().add(jTextMop);
        jTextMop.setBounds(320, 100, 30, 22);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-462)/2, (screenSize.height-289)/2, 462, 289);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed
        
    try{
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        Map parameter = new HashMap();
        parameter.put("operator", (GlobalUtils.getUserId()));
        parameter.put("namaPT", (GlobalUtils.getNamaPT()));
        String ctmrfr= jtxtNoBatchFr.getText();
        String ctmrto= jtxtNoBatchTo.getText();
        if (jtxtNoBatchFr.getText().isEmpty()){
            ctmrfr="0" ;
        }
        if (jtxtNoBatchTo.getText().isEmpty()){
            ctmrto="ZZZZZZZZZZ";
        }
        parameter.put("custmrcodefr", ctmrfr);
        parameter.put("custmrcodeto",ctmrto);
        parameter.put("operator",GlobalUtils.userid);

        String jenis="";
        if(jcmbjenislaporan.getSelectedIndex()==0 ){
            jenis="0";
        }else {
            jenis="1";
        }

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
        parameter.put("tanggalasof",tanggal_asof.getText());

        String file   = "";
        System.out.println(parameter);

        if(jenis.equals("0") ){
           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARAgedTrialBalanceByDueDateDetail.jrxml";
        }else{
           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARAgedTrialBalanceByDueDateSummary.jrxml";
        }
        
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
	      Ar_customers brs = new Ar_customers();
	      FrmBrowseARCustomer bd = new FrmBrowseARCustomer(brs);
	      bd.setFirstValue(jtxtNoBatchFr);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try {
	      Ar_customers brs = new Ar_customers();
	      FrmBrowseARCustomer bd = new FrmBrowseARCustomer(brs);
	      bd.setFirstValue(jtxtNoBatchTo);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jButton2ActionPerformed

private void jcmbjenislaporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbjenislaporanItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbjenislaporanItemStateChanged

private void jcmbstatuscustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbstatuscustomerItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbstatuscustomerItemStateChanged

private void jcmbstatuscustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbstatuscustomerActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbstatuscustomerActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try{
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        Map parameter = new HashMap();
        parameter.put("operator", (GlobalUtils.getUserId()));
        parameter.put("namaPT", (GlobalUtils.getNamaPT()));
        String ctmrfr= jtxtNoBatchFr.getText();
        String ctmrto= jtxtNoBatchTo.getText();
        if (jtxtNoBatchFr.getText().isEmpty()){
            ctmrfr="0" ;
        }
        if (jtxtNoBatchTo.getText().isEmpty()){
            ctmrto="ZZZZZZZZZZ";
        }
        parameter.put("custmrcodefr", ctmrfr);
        parameter.put("custmrcodeto",ctmrto);

        String jenis="";
        if(jcmbjenislaporan.getSelectedIndex()==0 ){
            jenis="0";
        }else {
            jenis="1";
        }

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
        parameter.put("tanggalasof",tanggal_asof.getText());
        parameter.put("yon",jTextYop.getText()) ;
        parameter.put("mon",jTextMop.getText()) ;

        String file   = "";
        System.out.println(parameter);

        if(jenis.equals("0") ){
           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARAgedTrialBalanceByDueDateDetailExp.jrxml";
        }else{
           file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiARAgedTrialBalanceByDueDateSummary.jrxml";
        }

        GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
    setCursor(GlobalUtils.NORMALCURSOR);
}//GEN-LAST:event_jButton5ActionPerformed

private void tanggal_asofFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tanggal_asofFocusGained
    // TODO add your handling code here:
    tanggal_asof.selectAll();
}//GEN-LAST:event_tanggal_asofFocusGained

private void tanggal_asofFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tanggal_asofFocusLost
    // TODO add your handling code here:
             jTextYop.setText(tanggal_asof.getText().substring(0,4));
             jTextMop.setText(tanggal_asof.getText().substring(5,7));
}//GEN-LAST:event_tanggal_asofFocusLost

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintTransaksiARAging dialog = new FrmPrintTransaksiARAging(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextMop;
    private javax.swing.JTextField jTextYop;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    private javax.swing.JComboBox jcmbjenislaporan;
    private javax.swing.JComboBox jcmbstatuscustomer;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtNoBatchFr;
    public javax.swing.JTextField jtxtNoBatchTo;
    private javax.swing.JFormattedTextField tanggal_asof;
    // End of variables declaration//GEN-END:variables

}
