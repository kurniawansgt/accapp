/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.ap.FrmAp_adjh;
 * 
 * .......
 * 
 * 
 * FrmAp_adjh frmAp_adjh;
 * 
 * .......
 * 
 try {
        if (frmAp_adjh == null) {
            frmmAp_adjh = new FrmAp_adjh(this);
        }
        
        showForm(frmAp_adjh);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.ar.adjustment;

import accapp.component.ar.adjustment.*;
import common.component.FrmBrowse;
import common.classinterface.NavigatorFormInt;
import common.component.FrmMainFrame;

import common.utils.CodeException;
import common.utils.GlobalUtils;
import javax.swing.JOptionPane;
import accapp.objectclasses.ar.adjustment.Ar_adjbatchlist;
import accapp.objectclasses.ar.adjustment.Ar_adjbatchlists;
import accapp.objectclasses.ar.adjustment.Ar_adjhs;
import common.print.FrmPrintTransaksiAPBatchListInvoice;
import common.tablemodels.GlobalModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Generator
 */

public class FrmAr_adjh extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="Frmaradjustmentbatchlist";
    
    FrmMainFrame mf ;
    
    
    Object[] datadetail;
    DefaultTableModel tmodeldetail;


    public Ar_adjbatchlists obj = new Ar_adjbatchlists();

    
   
    /** Creates new form Area */
    public FrmAr_adjh() throws CodeException {
        initComponents();
    }
    
    public FrmAr_adjh(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();

        datadetail = new Object[jtblDetail.getRowCount()];
        tmodeldetail = (DefaultTableModel) jtblDetail.getModel();
    }
     
       
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHeader = new javax.swing.JLabel();
        HorizontalLine = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jlblbatchno = new javax.swing.JLabel();
        jtxtbatchno = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jbtnBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AR Adjustment Batch List");
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
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jHeader.setBackground(new java.awt.Color(102, 102, 102));
        jHeader.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jHeader.setForeground(new java.awt.Color(255, 255, 255));
        jHeader.setText(" : : AR Adjustment Batch List");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 190, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 650, 2);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 2, 400);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchno.setText("Starting Batch Number");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(60, 70, 140, 14);

        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(210, 70, 90, 20);

        jButton6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton6.setText("Show Data");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(680, 70, 110, 20);

        jtblDetail.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Batch No.", "Batch Date", "Description", "#Entries", "Ttl. Amount", "Ready To Post", "Type", "Status", "Post Seq", "Gl Post Seq"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDetailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtblDetailMouseEntered(evt);
            }
        });
        jtblDetail.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblDetailPropertyChange(evt);
            }
        });
        jtblDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblDetailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblDetailKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtblDetail);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 100, 730, 310);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("Open");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 420, 100, 23);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 420, 100, 23);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(260, 420, 100, 23);

        jButton4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton4.setText("Post");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(360, 420, 100, 23);

        jButton5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton5.setText("Print");
        getContentPane().add(jButton5);
        jButton5.setBounds(460, 420, 100, 23);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(300, 70, 30, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
         try {
            moveFirst();

         } catch (CodeException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formInternalFrameOpened

private void kdatePurchaseDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdatePurchaseDateFocusLost

}//GEN-LAST:event_kdatePurchaseDateFocusLost

private void kdatePurchaseDateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_kdatePurchaseDateCaretPositionChanged

}//GEN-LAST:event_kdatePurchaseDateCaretPositionChanged

private void kdatePurchaseDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_kdatePurchaseDatePropertyChange

}//GEN-LAST:event_kdatePurchaseDatePropertyChange

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton6ActionPerformed

private void jtblDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailMouseClicked
    // TODO add your handling code here:
    int irow=jtblDetail.getSelectedRow();

    if (irow>-1){
        if (jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Posted")||jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Deleted")){
            jButton4.setEnabled(false);
            jButton3.setEnabled(false);
            jButton5.setEnabled(false);
            jtblDetail.setValueAt(true, irow, 5);
        } else {
            try {
                    Ar_adjbatchlist apinvb = (Ar_adjbatchlist) obj.list().get(irow);
                    if (Boolean.parseBoolean(jtblDetail.getValueAt(irow, 5).toString())){
                        apinvb.ReadtoPostMe(true);
                        jButton4.setEnabled(true);
                    } else {
                        apinvb.ReadtoPostMe(false);
                        jButton4.setEnabled(false);
                        jButton3.setEnabled(true);
                    }
                } catch (CodeException ex) {
                    Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}//GEN-LAST:event_jtblDetailMouseClicked

private void jtblDetailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailMouseEntered
    // TODO add your handling code here:
}//GEN-LAST:event_jtblDetailMouseEntered

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange
    // TODO add your handling code here:
    int irow=jtblDetail.getSelectedRow();
    int icol=jtblDetail.getSelectedColumn();

    if (irow>-1&&icol==5){
        if (jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Posted")||jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Delete")){
            jButton4.setEnabled(false);
            jButton3.setEnabled(false);
        } else {
            if (Boolean.parseBoolean(jtblDetail.getValueAt(irow, 5).toString())){
                jButton4.setEnabled(true);
            } else {
                jButton4.setEnabled(false);
                jButton3.setEnabled(true);
            }
        }
    }
}//GEN-LAST:event_jtblDetailPropertyChange

private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    // TODO add your handling code here:
}//GEN-LAST:event_jtblDetailKeyPressed

private void jtblDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyReleased
    // TODO add your handling code here:
    int irow=jtblDetail.getSelectedRow();

    if (irow>-1){
        if (evt.getKeyCode()==evt.VK_UP||evt.getKeyCode()==evt.VK_DOWN){
            if (jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Posted")||jtblDetail.getValueAt(irow, 7).toString().equalsIgnoreCase("Delete")){
                jButton4.setEnabled(false);
                jButton3.setEnabled(false);
            } else {
                if (Boolean.parseBoolean(jtblDetail.getValueAt(irow, 5).toString())){
                    jButton4.setEnabled(true);
                } else {
                    jButton4.setEnabled(false);
                    jButton3.setEnabled(true);
                }
            }
        }
    }
}//GEN-LAST:event_jtblDetailKeyReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    int row=jtblDetail.getSelectedRow();

    if (row>-1){
        try {
            this.mf.showAR_AdjustEntry((Ar_adjbatchlist) obj.list().get(row),0);
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    try {
        this.mf.showAR_AdjustEntry((Ar_adjbatchlist) obj.list().get(0),1);
    } catch (CodeException ex) {
        Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    int row=jtblDetail.getSelectedRow();

    if (row>-1){
        try {
            Ar_adjbatchlist arinvb=(Ar_adjbatchlist) obj.list().get(row);
            deletedata(arinvb, row);
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    int row=jtblDetail.getSelectedRow();

    if (row>-1){
        try {
            if (Boolean.parseBoolean(jtblDetail.getValueAt(row, 5).toString())){
                Ar_adjbatchlist apadjbat=(Ar_adjbatchlist) obj.list().get(row);
                if (postingdata(apadjbat, row)){
                    jtblDetail.setValueAt(true, row, 5);
                    jtblDetail.setValueAt("Posted", row, 7);
                    tmodeldetail.setValueAt(apadjbat.getpostngseq(), tmodeldetail.getRowCount()-1, 8);
                    tmodeldetail.setValueAt(apadjbat.getglpostngseq(), tmodeldetail.getRowCount()-1, 9);

                    jButton4.setEnabled(false);
                    jButton3.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Procedure, Batch List Should Be Ready To Post to be Processed!!");
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_jButton4ActionPerformed

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
      try {
	      Ar_adjhs brs = new Ar_adjhs();
	      FrmBrowse bd = new FrmBrowse(this, brs);
	      bd.setFirstValue(jtxtbatchno);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jbtnBrowseActionPerformed


private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
}                                           


private Boolean deletedata(Ar_adjbatchlist arinvb,int row){
    int idelete;
        try {
            idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + arinvb.getbatchno(), "Delete", JOptionPane.YES_NO_OPTION);
            if (idelete == JOptionPane.YES_OPTION) {
                arinvb.delete();
                obj.list().remove(row);
                tmodeldetail.removeRow(row);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }


    return false;
}
private Boolean postingdata(Ar_adjbatchlist apadjb,int row){
    int idelete;
        try {
            idelete = JOptionPane.showConfirmDialog(null, "Do you want to Post entry# " + apadjb.getbatchno(), "Delete", JOptionPane.YES_NO_OPTION);
            if (idelete == JOptionPane.YES_OPTION) {
                if (apadjb.runARAdjustmentPosting(apadjb.getbatchno(), apadjb.getbatchno())){
                    return true;
                }
            }
        } catch (CodeException ex) {
            try{
                apadjb.seterrorcnt(apadjb.geterrorcnt() + 1);
                apadjb.save();
            }catch(Exception e){}
            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }


    return false;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAr_adjh().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JTextField jtxtbatchno;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        
    }

    public void movePrevious() throws CodeException {
        
    }

    public void moveNext() throws CodeException {
        
    }

    public void moveLast() throws CodeException {
        
    }

    public void searchData() throws CodeException {
        

    }
    public void newData() throws CodeException {
       
    }

    public void saveData() throws CodeException {
        
    }

    public void showData() throws CodeException {
        try {
            obj.searchData(jtxtbatchno.getText());
            GlobalModel.clearRow(tmodeldetail);
            for (Object o:obj.list()){
                Ar_adjbatchlist apadjbat=(Ar_adjbatchlist) o;

                tmodeldetail.addRow(datadetail);
                tmodeldetail.setValueAt(apadjbat.getbatchno(), tmodeldetail.getRowCount()-1, 0);
                tmodeldetail.setValueAt(GlobalUtils.formatDate(apadjbat.getbatchdate(),"MM/dd/yyyy"), tmodeldetail.getRowCount()-1, 1);
                tmodeldetail.setValueAt(apadjbat.getbatchdesc(), tmodeldetail.getRowCount()-1, 2);
                tmodeldetail.setValueAt(apadjbat.getpayentrcnt(), tmodeldetail.getRowCount()-1, 3);
                tmodeldetail.setValueAt(apadjbat.getTotalAmount(), tmodeldetail.getRowCount()-1, 4);
                Boolean readytopost=false;
                if (GlobalUtils.churuf(apadjbat.getreadytpost()).equalsIgnoreCase("1")||apadjbat.getbatchsts().equalsIgnoreCase("2")){
                    readytopost=true;
                }
                tmodeldetail.setValueAt(readytopost, tmodeldetail.getRowCount()-1, 5);

                String batchtype="";
                switch (GlobalUtils.toInt(GlobalUtils.churuf(apadjbat.getbatchtype()))){
                     case 1:
                         batchtype="Entries";
                         break;
                     case 2:
                         batchtype="Import";
                         break;
                     case 3:
                         batchtype="Transfer";
                         break;
                }

                tmodeldetail.setValueAt(batchtype, tmodeldetail.getRowCount()-1, 6);

                String batchstatus="";
                switch (GlobalUtils.toInt(apadjbat.getbatchsts())){
                    case 1:
                        batchstatus="Open";
                        break;
                    case 2:
                        batchstatus="Posted";
                        break;
                    case 3:
                        batchstatus="Error";
                        break;
                    case 4:
                        batchstatus="Delete";
                        break;
                }

                tmodeldetail.setValueAt(batchstatus, tmodeldetail.getRowCount()-1, 7);
                tmodeldetail.setValueAt(apadjbat.getpostngseq(), tmodeldetail.getRowCount()-1, 8);
                tmodeldetail.setValueAt(apadjbat.getglpostngseq(), tmodeldetail.getRowCount()-1, 9);


            }

        } catch (CodeException ex) {


            Logger.getLogger(FrmAr_adjh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() throws CodeException {
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    

    public void undo() throws CodeException {
        istatus = 0;
        moveFirst();
        showData();
    }

    public void execute() throws CodeException {
       saveData();
    }

    public void printData() throws CodeException {
        FrmPrintTransaksiAPBatchListInvoice fp=new FrmPrintTransaksiAPBatchListInvoice();
        fp.jcmblistingfor.setSelectedIndex(0);
        fp.setVisible(true);
    }

    public void importCsv() throws CodeException {
        

    }

    public void exportCsv() throws CodeException {
        
    
        
    }

    public void importText() throws CodeException {
        
        }

    public void setData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void exportText() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
