/*
 * FrmPrintMasterBahanBaku.java
 *
 * Created on September 8, 2009, 4:18 PM
 */

package common.print;

import accapp.objectclasses.ap.Ap_vendors;
import accapp.objectclasses.gl.Gl_batchlists;
import common.component.FrmBrowse;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author  wgata
 */
public class FrmPrintTransaksiGLJournalawal extends javax.swing.JDialog {
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DateFormat dateformatprint =new SimpleDateFormat("yyyy-MM-dd");


    /** Creates new form FrmPrintMasterBahanBaku */
    public FrmPrintTransaksiGLJournalawal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmPrintTransaksiGLJournalawal() {
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
        jLabel8 = new javax.swing.JLabel();
        batchdatefr = new org.kazao.calendar.KazaoCalendarDate();
        batchdateto = new org.kazao.calendar.KazaoCalendarDate();
        jLabel4 = new javax.swing.JLabel();
        jcmbSourceLedgerto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jcmbSourceLedgerfr = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcmbHavingStatusfr = new javax.swing.JComboBox();
        jcmbHavingStatusto = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcmbBatchTypefr = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jcmbBatchTypeto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtxtNoBatchFr = new javax.swing.JTextField();
        jbtnBatchFr = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtxtNoBatchTo = new javax.swing.JTextField();
        jbtnBatchTo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRINT GL - BATCH LIST");
        getContentPane().setLayout(null);

        jlblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHeader.setText("GL - BATCH LISTING");
        jlblHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jlblHeader);
        jlblHeader.setBounds(110, 20, 230, 30);

        jbtnCetak.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnCetak.setText("Print");
        jbtnCetak.setName("FrmPrintTransaksiGLJournal"); // NOI18N
        jbtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCetak);
        jbtnCetak.setBounds(140, 270, 70, 20);

        jbtnSelesai.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnSelesai.setText("End");
        jbtnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelesaiActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelesai);
        jbtnSelesai.setBounds(250, 270, 70, 20);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel8.setText("To");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 150, 20, 20);

        batchdatefr.setFont(new java.awt.Font("Dialog", 0, 10));
        batchdatefr.setFontDate(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(batchdatefr);
        batchdatefr.setBounds(140, 120, 130, 20);

        batchdateto.setFont(new java.awt.Font("Dialog", 0, 10));
        batchdateto.setFontDate(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(batchdateto);
        batchdateto.setBounds(310, 120, 110, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel4.setText("Document Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 100, 20);

        jcmbSourceLedgerto.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbSourceLedgerto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AP", "AR", "CB", "GL" }));
        jcmbSourceLedgerto.setSelectedIndex(3);
        jcmbSourceLedgerto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbSourceLedgerto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbSourceLedgertoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbSourceLedgerto);
        jcmbSourceLedgerto.setBounds(310, 150, 110, 20);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel1.setText("Source Ledger");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 150, 100, 20);

        jcmbSourceLedgerfr.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbSourceLedgerfr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AP", "AR", "CB", "GL" }));
        jcmbSourceLedgerfr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbSourceLedgerfr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbSourceLedgerfrItemStateChanged(evt);
            }
        });
        jcmbSourceLedgerfr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbSourceLedgerfrActionPerformed(evt);
            }
        });
        getContentPane().add(jcmbSourceLedgerfr);
        jcmbSourceLedgerfr.setBounds(140, 150, 130, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel9.setText("To");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(280, 120, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Having Of Status");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 100, 20);

        jcmbHavingStatusfr.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbHavingStatusfr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Open", "Posted", "Error", "Deleted", "Prov. Posted" }));
        jcmbHavingStatusfr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbHavingStatusfr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbHavingStatusfrItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbHavingStatusfr);
        jcmbHavingStatusfr.setBounds(140, 180, 130, 20);

        jcmbHavingStatusto.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbHavingStatusto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Open", "Posted", "Error", "Deleted", "Prov. Posted" }));
        jcmbHavingStatusto.setSelectedIndex(4);
        jcmbHavingStatusto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbHavingStatusto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbHavingStatustoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbHavingStatusto);
        jcmbHavingStatusto.setBounds(310, 180, 110, 20);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel10.setText("To");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(280, 180, 20, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel5.setText("Batch Type");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 210, 100, 20);

        jcmbBatchTypefr.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbBatchTypefr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entered", "Subledger", "Imported", "Generated" }));
        jcmbBatchTypefr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbBatchTypefr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbBatchTypefrItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbBatchTypefr);
        jcmbBatchTypefr.setBounds(140, 210, 130, 20);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel11.setText("To");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(280, 210, 20, 20);

        jcmbBatchTypeto.setFont(new java.awt.Font("Dialog", 1, 10));
        jcmbBatchTypeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entered", "Subledger", "Imported", "Generated" }));
        jcmbBatchTypeto.setSelectedIndex(3);
        jcmbBatchTypeto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcmbBatchTypeto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbBatchTypetoItemStateChanged(evt);
            }
        });
        getContentPane().add(jcmbBatchTypeto);
        jcmbBatchTypeto.setBounds(310, 210, 110, 20);

        jLabel6.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        jLabel6.setText("Batch");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 90, 100, 20);

        jtxtNoBatchFr.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        getContentPane().add(jtxtNoBatchFr);
        jtxtNoBatchFr.setBounds(140, 90, 110, 20);

        jbtnBatchFr.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        jbtnBatchFr.setText("...");
        jbtnBatchFr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBatchFrActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBatchFr);
        jbtnBatchFr.setBounds(250, 90, 20, 20);

        jLabel12.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        jLabel12.setText("To");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(280, 90, 20, 20);

        jtxtNoBatchTo.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        getContentPane().add(jtxtNoBatchTo);
        jtxtNoBatchTo.setBounds(310, 90, 90, 20);

        jbtnBatchTo.setFont(new java.awt.Font("Adobe Sans MM", 1, 10));
        jbtnBatchTo.setText("...");
        jbtnBatchTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBatchToActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBatchTo);
        jbtnBatchTo.setBounds(400, 90, 20, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-462)/2, (screenSize.height-404)/2, 462, 404);
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelesaiActionPerformed

    this.dispose();
}//GEN-LAST:event_jbtnSelesaiActionPerformed

private void jbtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCetakActionPerformed

        
    try{
        String file   = "" ;
        Map parameter = new HashMap();
        parameter.put("nobatchfr", jtxtNoBatchFr.getText());
        parameter.put("nobatchto", jtxtNoBatchTo.getText());
        System.out.println(jtxtNoBatchFr.getText());
        System.out.println(jtxtNoBatchTo.getText());
        parameter.put("cutoffby",jcmbSourceLedgerto.getSelectedIndex()+"");
        try{
                   String tgl1 = dateformatprint.format(dateformat.parse(batchdatefr.getDate()));
                   String tgl2 = dateformatprint.format(dateformat.parse(batchdateto.getDate()));
                   System.out.println(tgl1);
                   System.out.println(tgl2);
                   parameter.put("entrydatefr",tgl1);
                   parameter.put("entrydateto",tgl2);
            }catch (Exception e ) {
            }
       parameter.put("operator",GlobalUtils.userid);
        String slfr="";
        if(jcmbSourceLedgerfr.getSelectedIndex()==0 ){
            slfr="AP";
        }else if(jcmbSourceLedgerfr.getSelectedIndex()==1){
            slfr="AR";
        }else  if(jcmbSourceLedgerfr.getSelectedIndex()==2){
            slfr="CB";
        }else{
            slfr="GL";
        }
        parameter.put("srceledgrfr", slfr);

        String slto="";
        if(jcmbSourceLedgerto.getSelectedIndex()==0 ){
            slto="AP";
        }else if(jcmbSourceLedgerto.getSelectedIndex()==1){
            slto="AR";
        }else  if(jcmbSourceLedgerfr.getSelectedIndex()==2){
            slto="CB";
        }else{
            slto="GL";
        }
        parameter.put("srceledgrto", slto);

        String hsfr="";
        if(jcmbHavingStatusfr.getSelectedIndex()==0 ){
            hsfr="1";
        }else if(jcmbHavingStatusfr.getSelectedIndex()==1){
            hsfr="2";
        }else if(jcmbHavingStatusfr.getSelectedIndex()==2){
            hsfr="3";
        } else if(jcmbHavingStatusto.getSelectedIndex()==3){
            hsfr="4";
        }else {
            hsfr="5";
        }
        parameter.put("stsbatchfr", hsfr);

        String hsto="";
        if(jcmbHavingStatusto.getSelectedIndex()==0 ){
            hsto="1";
        }else if(jcmbHavingStatusto.getSelectedIndex()==1){
            hsto="2";
        }else if(jcmbHavingStatusto.getSelectedIndex()==2){
            hsto="3";
        } else if(jcmbHavingStatusto.getSelectedIndex()==3){
            hsto="4";
        }else {
            hsto="5";
        }
        parameter.put("stsbatchto", hsto);

        String btfr="";
        if(jcmbBatchTypefr.getSelectedIndex()==0 ){
            btfr="1";
        }else if(jcmbBatchTypefr.getSelectedIndex()==1){
            btfr="2";
        }else if(jcmbBatchTypefr.getSelectedIndex()==2){
            btfr="3";
        }else {
            btfr="4";
        }
        parameter.put("stbatchfr", btfr);

        String btto="";
        if(jcmbBatchTypeto.getSelectedIndex()==0 ){
            btto="1";
        }else if(jcmbBatchTypeto.getSelectedIndex()==1){
            btto="2";
        }else if(jcmbBatchTypeto.getSelectedIndex()==2){
            btto="3";
        }else {
            btto="4";
        }
        parameter.put("stbatchto", btto);
        System.out.println(parameter);
        file = GlobalUtils.getCurrentDir() +"/Reports/TransaksiGLBatchList.jrxml";
        GlobalUtils.printReport(file, parameter, false);
    }catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnCetakActionPerformed

private void jmbModelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmbModelPropertyChange

}//GEN-LAST:event_jmbModelPropertyChange

private void jcmbSourceLedgertoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbSourceLedgertoItemStateChanged

}//GEN-LAST:event_jcmbSourceLedgertoItemStateChanged

private void jcmbSourceLedgerfrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbSourceLedgerfrItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbSourceLedgerfrItemStateChanged

private void jcmbHavingStatusfrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbHavingStatusfrItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbHavingStatusfrItemStateChanged

private void jcmbHavingStatustoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbHavingStatustoItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbHavingStatustoItemStateChanged

private void jcmbBatchTypefrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbBatchTypefrItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbBatchTypefrItemStateChanged

private void jcmbBatchTypetoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbBatchTypetoItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbBatchTypetoItemStateChanged

private void jbtnBatchFrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBatchFrActionPerformed
    try {

            Gl_batchlists brs = new Gl_batchlists();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setFirstValue(jtxtNoBatchFr);
            bd.setModal(true);
            bd.setVisible(true);




    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jbtnBatchFrActionPerformed

private void jbtnBatchToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBatchToActionPerformed
    try {

            Gl_batchlists brs = new Gl_batchlists();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setFirstValue(jtxtNoBatchTo);
            bd.setModal(true);
            bd.setVisible(true);


    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jbtnBatchToActionPerformed

private void jcmbSourceLedgerfrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbSourceLedgerfrActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbSourceLedgerfrActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrintTransaksiGLJournalawal dialog = new FrmPrintTransaksiGLJournalawal(new javax.swing.JFrame(), true);
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
    private org.kazao.calendar.KazaoCalendarDate batchdatefr;
    private org.kazao.calendar.KazaoCalendarDate batchdateto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtnBatchFr;
    private javax.swing.JButton jbtnBatchTo;
    private javax.swing.JButton jbtnCetak;
    private javax.swing.JButton jbtnSelesai;
    private javax.swing.JComboBox jcmbBatchTypefr;
    private javax.swing.JComboBox jcmbBatchTypeto;
    private javax.swing.JComboBox jcmbHavingStatusfr;
    private javax.swing.JComboBox jcmbHavingStatusto;
    private javax.swing.JComboBox jcmbSourceLedgerfr;
    private javax.swing.JComboBox jcmbSourceLedgerto;
    public javax.swing.JLabel jlblHeader;
    public javax.swing.JTextField jtxtNoBatchFr;
    public javax.swing.JTextField jtxtNoBatchTo;
    // End of variables declaration//GEN-END:variables

}