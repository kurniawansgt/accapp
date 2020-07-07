/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.objectclasses.ap.Ap_accsets;
import accapp.objectclasses.ap.Ap_distcodes;
import accapp.objectclasses.ap.Ap_distseths;
import accapp.objectclasses.ap.Ap_vendors;
import accapp.objectclasses.ar.Ar_accsets;
import accapp.objectclasses.ar.Ar_custgrps;
import accapp.objectclasses.ar.Ar_custnats;
import accapp.objectclasses.cashbook.Cb_batchcontrols;
import common.component.FrmBrowse;
import common.objectclasses.Masterkodesetting;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author  wgata
 */
public class FrmPrintMasterARNationalAccount extends javax.swing.JDialog {
    
    

    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintMasterARNationalAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintMasterARNationalAccount() {
        initComponents();
        jtxtyopfr.setText((new Date()).getYear() + 1900 +"");
        jtxtyopto.setText((new Date()).getYear() + 1900 +"");
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
        jcmbentrytypefr = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtyopfr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtyopto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcmbjenislaporan = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRINT AR - NATIONAL ACCOUNT MASTER\n");
        getContentPane().setLayout(null);

        jtxtNoBatchFr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtNoBatchFr);
        jtxtNoBatchFr.setBounds(140, 80, 100, 20);

        jlblHeader.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("AR - NATIONAL ACCOUNT MASTER REPORT");
        jlblHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(60, 20, 330, 30);

        jbtnCetak.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnCetak.setText("Print");
        jbtnCetak.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(140, 210, 90, 25);

        jbtnSelesai.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnSelesai.setText("End");
        jbtnSelesai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(300, 210, 90, 25);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 80, 20, 20);

        jtxtNoBatchTo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtNoBatchTo);
        jtxtNoBatchTo.setBounds(300, 80, 100, 20);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 80, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel3.setText("Group Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 80, 110, 20);

        jcmbentrytypefr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbentrytypefr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Not Active" }));
        jcmbentrytypefr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbentrytypefrItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbentrytypefr);
        jcmbentrytypefr.setBounds(140, 110, 120, 20);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel8.setText("To");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 80, 20, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel4.setText("Status");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 110, 110, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel5.setText("YOP From");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 140, 100, 20);

        jtxtyopfr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtyopfr);
        jtxtyopfr.setBounds(140, 140, 50, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel7.setText("To");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 140, 20, 20);

        jtxtyopto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtyopto);
        jtxtyopto.setBounds(300, 140, 50, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel6.setText("Report Type");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 110, 20);

        jcmbjenislaporan.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbjenislaporan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Group", "Statistic" }));
        jcmbjenislaporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbjenislaporanItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbjenislaporan);
        jcmbjenislaporan.setBounds(140, 170, 120, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-462)/2, (screenSize.height-282)/2, 462, 282);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed

        
    try{
        Map parameter = new HashMap();
//        parameter.put("kodeperusahaan", " ");
        parameter.put("operator", (GlobalUtils.getUserId()));
        parameter.put("natcodefr", jtxtNoBatchFr.getText());
        parameter.put("natcodeto", jtxtNoBatchTo.getText());
        parameter.put("yopfr", jtxtyopfr.getText());
        parameter.put("yopto", jtxtyopto.getText());
        int EntryTypefr=1;
        if(jcmbentrytypefr.getSelectedIndex()==0 ){
            EntryTypefr=1;
        }else {
            EntryTypefr=0;
        }
        parameter.put("aktif", EntryTypefr);
        String jenis="";
        if(jcmbjenislaporan.getSelectedIndex()==0 ){
            jenis="0";
        }else {
            jenis="1";
        }
        parameter.put("jenislaporan",jenis);

        String file   = "";
        System.out.println(parameter);
        file = GlobalUtils.getCurrentDir() +"/Reports/MasterARNasionalAccount.jrxml";
        GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnCetakActionPerformed

private void jmbModelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmbModelPropertyChange

}//GEN-LAST:event_jmbModelPropertyChange

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
	      Ar_custnats brs = new Ar_custnats();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtNoBatchFr);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try {
	      Ar_custnats brs = new Ar_custnats();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtNoBatchTo);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jButton2ActionPerformed

private void jcmbentrytypefrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbentrytypefrItemStateChanged
     


}//GEN-LAST:event_jcmbentrytypefrItemStateChanged

private void jcmbjenislaporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbjenislaporanItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbjenislaporanItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintMasterARNationalAccount dialog = new FrmPrintMasterARNationalAccount(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    private javax.swing.JComboBox jcmbentrytypefr;
    private javax.swing.JComboBox jcmbjenislaporan;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtNoBatchFr;
    public javax.swing.JTextField jtxtNoBatchTo;
    public javax.swing.JTextField jtxtyopfr;
    public javax.swing.JTextField jtxtyopto;
    // End of variables declaration//GEN-END:variables

}
