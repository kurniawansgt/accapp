/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.objectclasses.ap.Ap_vendors;
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
public class FrmPrintCBBatchList extends javax.swing.JDialog {
    
    

    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintCBBatchList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintCBBatchList() {
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

        jtxtNoBatchFr = new javax.swing.JTextField();
        jcmbentrytypeto = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jlblHeader = new javax.swing.JLabel();
        jbtnCetak = new javax.swing.JButton();
        jbtnSelesai = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jtxtNoBatchTo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcmbentrytypefr = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRINT CB - BATCH LIST");
        getContentPane().setLayout(null);
        getContentPane().add(jtxtNoBatchFr);
        jtxtNoBatchFr.setBounds(140, 70, 100, 19);

        jcmbentrytypeto.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbentrytypeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash Book", "AccountPayment", "Account Register" }));
        jcmbentrytypeto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbentrytypetoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbentrytypeto);
        jcmbentrytypeto.setBounds(300, 100, 120, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("Batch Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 110, 13);

        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("CASH BOOK - BATCH LIST TRANSACTION REPORT");
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(60, 20, 330, 30);

        jbtnCetak.setText("Cetak");
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(150, 170, 90, 25);

        jbtnSelesai.setText("Selesai");
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(300, 170, 90, 25);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 70, 20, 20);
        getContentPane().add(jtxtNoBatchTo);
        jtxtNoBatchTo.setBounds(300, 70, 100, 19);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 70, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Type Entry");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 100, 110, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel6.setText("To");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 100, 13, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel7.setText("To");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(280, 70, 13, 20);

        jcmbentrytypefr.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbentrytypefr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash Book", "AccountPayment", "Account Register" }));
        jcmbentrytypefr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbentrytypefrItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbentrytypefr);
        jcmbentrytypefr.setBounds(140, 100, 120, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-462)/2, (screenSize.height-282)/2, 462, 282);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed

        
    try{
        Map parameter = new HashMap();
        parameter.put("kodeperusahaan", "ACCAPP");
        parameter.put("operator", (GlobalUtils.getUserId()));
        parameter.put("nobatchfr", jtxtNoBatchFr.getText());
        parameter.put("nobatchto", jtxtNoBatchTo.getText());
        
        String EntryTypefr="";
        if(jcmbentrytypefr.getSelectedIndex()==0 ){
            EntryTypefr="C";
        }else if(jcmbentrytypefr.getSelectedIndex()==1){
            EntryTypefr="P";
        }else{
            EntryTypefr="R";
        }
        String EntryTypeto="";
        if(jcmbentrytypeto.getSelectedIndex()==0){
            EntryTypeto="C";
        }else if(jcmbentrytypeto.getSelectedIndex()==1){
           EntryTypeto="P";
        }else{
            EntryTypeto="R";
        }
        parameter.put("entrytypefr", EntryTypefr);
        parameter.put("entrytypeto", EntryTypeto);

        String file   = "";
        System.out.println(parameter);
        file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiCBBatchList.jrxml";
        GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnCetakActionPerformed

private void jmbModelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmbModelPropertyChange

}//GEN-LAST:event_jmbModelPropertyChange

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
	      Cb_batchcontrols brs = new Cb_batchcontrols();
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
	      Cb_batchcontrols brs = new Cb_batchcontrols();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtNoBatchTo);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jButton2ActionPerformed

private void jcmbentrytypetoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbentrytypetoItemStateChanged


}//GEN-LAST:event_jcmbentrytypetoItemStateChanged

private void jcmbentrytypefrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbentrytypefrItemStateChanged
     


}//GEN-LAST:event_jcmbentrytypefrItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintCBBatchList dialog = new FrmPrintCBBatchList(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    private javax.swing.JComboBox jcmbentrytypefr;
    private javax.swing.JComboBox jcmbentrytypeto;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtNoBatchFr;
    public javax.swing.JTextField jtxtNoBatchTo;
    // End of variables declaration//GEN-END:variables

}
