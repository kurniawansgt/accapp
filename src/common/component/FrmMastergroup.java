/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import common.component.FrmMastergroup;
 * 
 * .......
 * 
 try {
        if (frmmastergroup == null) {
            frmmastergroup = new FrmMastergroup(this);
        }
        
        showForm(frmmastergroup);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package common.component;

import common.classinterface.NavigatorFormInt;
import common.classinterface.NavigatorObjectInt;
import common.objectclasses.Mastercompany;
import common.objectclasses.Mastercompanys;

import common.tablemodels.GlobalModel;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import common.objectclasses.Mastergroup;
import common.objectclasses.Mastergroupdetail;
import common.objectclasses.Mastergroupdetails;
import common.objectclasses.Mastergroups;
import java.util.HashMap;
import java.util.Map;
import common.objectclasses.Mastermodule;
import common.objectclasses.Mastermodules;
import common.tablemodels.CheckBoxRenderer;
import common.tablemodels.MasterGroupModel;
import common.utils.ExtFileChooserFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author  Generator
 */

public class FrmMastergroup extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmMastergroup";
    
    FrmMainFrame mf ;
    
    
    public Mastergroup obj = new Mastergroup();
    
    Object[] data = new Object[Mastergroupdetail.columns.length];

    DefaultTableModel tmodel = new MasterGroupModel();
   
    /** Creates new form Area */
    public FrmMastergroup() throws CodeException {
        initComponents();
    }

    private void setCmbAccess(){
        jcmbAccess.removeAllItems();
        jcmbAccess.addItem("All");
        jcmbAccess.addItem("Read");
        jcmbAccess.addItem("Confirm");
        jcmbAccess.addItem("Entry");
        jcmbAccess.addItem("Update");
        jcmbAccess.addItem("Delete");
        jcmbAccess.addItem("Print");
        jcmbAccess.addItem("Export");
        jcmbAccess.addItem("Import");
    }
    public FrmMastergroup(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        
        initComponents();
        setCmbAccess();
        jtblGroupDetail.setAutoCreateRowSorter(true);
        
        GlobalModel.setColHeader(tmodel, Mastergroupdetail.columns);
        GlobalModel.showTable(jtblGroupDetail, tmodel);
        GlobalModel.setCol(jtblGroupDetail, Mastergroupdetail.columns);
        
        GlobalModel.clearRow(tmodel);

        
        TableColumn column3 = jtblGroupDetail.getColumnModel().getColumn(3);
        column3.setCellRenderer(new CheckBoxRenderer());
        column3.setCellEditor(new DefaultCellEditor(new JCheckBox()));
  
        TableColumn column4 = jtblGroupDetail.getColumnModel().getColumn(4);
        column4.setCellRenderer(new CheckBoxRenderer());
        column4.setCellEditor(new DefaultCellEditor(new JCheckBox()));
  
        TableColumn column5 = jtblGroupDetail.getColumnModel().getColumn(5);
        column5.setCellRenderer(new CheckBoxRenderer());
        column5.setCellEditor(new DefaultCellEditor(new JCheckBox()));
  
        TableColumn column6 = jtblGroupDetail.getColumnModel().getColumn(6);
        column6.setCellRenderer(new CheckBoxRenderer());
        column6.setCellEditor(new DefaultCellEditor(new JCheckBox()));
  
        TableColumn column7 = jtblGroupDetail.getColumnModel().getColumn(7);
        column7.setCellRenderer(new CheckBoxRenderer());
        column7.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        TableColumn column8 = jtblGroupDetail.getColumnModel().getColumn(8);
        column8.setCellRenderer(new CheckBoxRenderer());
        column8.setCellEditor(new DefaultCellEditor(new JCheckBox()));
        
        TableColumn column9 = jtblGroupDetail.getColumnModel().getColumn(9);
        column9.setCellRenderer(new CheckBoxRenderer());
        column9.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        TableColumn column10 = jtblGroupDetail.getColumnModel().getColumn(10);
        column10.setCellRenderer(new CheckBoxRenderer());
        column10.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        try {
            Mastercompanys mastercompanys  = new Mastercompanys(0);

            for(Object o : mastercompanys.list()) {
                   Mastercompany m = (Mastercompany) o;
                   jcmbCompany.addItem(m.getCompany());

                   if (m.getSelected()==1) {
                       jcmbCompany.setSelectedIndex(jcmbCompany.getItemCount()-1);
                   }
            }
        }catch(Exception e) {

        }
        
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
        jtxtid = new javax.swing.JTextField();
        jlblKodeGroup = new javax.swing.JLabel();
        jtxtKodeGroup = new javax.swing.JTextField();
        jlblKeterangan = new javax.swing.JLabel();
        jtxtKeterangan = new javax.swing.JTextField();
        jtxtTanggalEntry = new javax.swing.JTextField();
        jtxtTanggalUpdate = new javax.swing.JTextField();
        jtxtUserId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblGroupDetail = new javax.swing.JTable();
        jbtnBrowse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcmbCompany = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcmbAccess = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mastergroup");
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
        jHeader.setFont(new java.awt.Font("Dialog", 1, 10));
        jHeader.setForeground(new java.awt.Color(255, 255, 255));
        jHeader.setText(" : : Master Group");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 130, 20);

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

        jtxtid.setEditable(false);
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(170, 30, 80, 16);

        jlblKodeGroup.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblKodeGroup.setText("KodeGroup");
        getContentPane().add(jlblKodeGroup);
        jlblKodeGroup.setBounds(70, 80, 140, 14);

        jtxtKodeGroup.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtKodeGroup.setText("KodeGroup");
        getContentPane().add(jtxtKodeGroup);
        jtxtKodeGroup.setBounds(260, 80, 160, 20);

        jlblKeterangan.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblKeterangan.setText("Keterangan");
        getContentPane().add(jlblKeterangan);
        jlblKeterangan.setBounds(70, 100, 140, 14);

        jtxtKeterangan.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtKeterangan.setText("Keterangan");
        getContentPane().add(jtxtKeterangan);
        jtxtKeterangan.setBounds(260, 100, 530, 20);

        jtxtTanggalEntry.setEditable(false);
        jtxtTanggalEntry.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtTanggalEntry.setText("TanggalEntry");
        getContentPane().add(jtxtTanggalEntry);
        jtxtTanggalEntry.setBounds(560, 30, 110, 16);

        jtxtTanggalUpdate.setEditable(false);
        jtxtTanggalUpdate.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtTanggalUpdate.setText("TanggalUpdate");
        getContentPane().add(jtxtTanggalUpdate);
        jtxtTanggalUpdate.setBounds(670, 30, 130, 16);

        jtxtUserId.setEditable(false);
        jtxtUserId.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtUserId.setText("UserId");
        getContentPane().add(jtxtUserId);
        jtxtUserId.setBounds(460, 30, 100, 16);

        jtblGroupDetail.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblGroupDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Module", "Keterangan", "Read", "Confirm", "Entry", "Update", "Delete", "Print", "Export", "Import"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblGroupDetail);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 150, 720, 280);

        jbtnBrowse.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnBrowse.setText("...");
        jbtnBrowse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jbtnBrowseItemStateChanged(evt);
            }
        });
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(430, 80, 30, 17);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("Company");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 120, 140, 14);

        jcmbCompany.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbCompanyMouseClicked(evt);
            }
        });
        jcmbCompany.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbCompanyItemStateChanged(evt);
            }
        });
        jcmbCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(jcmbCompany);
        jcmbCompany.setBounds(260, 120, 210, 20);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton2.setText("Check All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 440, 100, 23);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton3.setText("Un Check All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 440, 130, 23);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setText("Set");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 440, 16, 14);

        jcmbAccess.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbAccess.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcmbAccess);
        jcmbAccess.setBounds(110, 440, 150, 20);

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

private void jbtnBrowseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jbtnBrowseItemStateChanged

}//GEN-LAST:event_jbtnBrowseItemStateChanged

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
     try {
        Mastergroups brs = new Mastergroups();
        FrmBrowse bd = new FrmBrowse(this, brs);
        bd.setFirstValue(jtxtKodeGroup);
        bd.setModal(true);
        bd.setVisible(true);            

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowseActionPerformed

private void jcmbCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbCompanyActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbCompanyActionPerformed

private void jcmbCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbCompanyMouseClicked


}//GEN-LAST:event_jcmbCompanyMouseClicked

private void jcmbCompanyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbCompanyItemStateChanged

    try {
        showData();

        
    }catch(Exception e) {

    }

}//GEN-LAST:event_jcmbCompanyItemStateChanged

private void setaccess(Boolean bcheked){
    int col=0;
    if (jcmbAccess.getSelectedItem().equals("All")){
        for (col=3;col<=10;col++){
            int i=0;
            for (i=0;i<jtblGroupDetail.getRowCount();i++){
                jtblGroupDetail.setValueAt(bcheked, i, col);
            }
        }
    } else {
        if (jcmbAccess.getSelectedItem().equals("Read")){
            col=3;
        }
        if (jcmbAccess.getSelectedItem().equals("Confirm")){
            col=4;
        }
        if (jcmbAccess.getSelectedItem().equals("Entry")){
            col=5;
        }
        if (jcmbAccess.getSelectedItem().equals("Update")){
            col=6;
        }
        if (jcmbAccess.getSelectedItem().equals("Delete")){
            col=7;
        }
        if (jcmbAccess.getSelectedItem().equals("Print")){
            col=8;
        }
        if (jcmbAccess.getSelectedItem().equals("Export")){
            col=9;
        }
        if (jcmbAccess.getSelectedItem().equals("Import")){
            col=10;
        }

        int i=0;
        for (i=0;i<jtblGroupDetail.getRowCount();i++){
            jtblGroupDetail.setValueAt(bcheked, i, col);
        }
    }
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    setaccess(true);
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    setaccess(false);
}//GEN-LAST:event_jButton3ActionPerformed


    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
        setToolBar(iformtype,istatus);
        mf.setIcon(CLASSNAME);
    }

	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmMastergroup().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JComboBox jcmbAccess;
    private javax.swing.JComboBox jcmbCompany;
    private javax.swing.JLabel jlblKeterangan;
    private javax.swing.JLabel jlblKodeGroup;
    private javax.swing.JTable jtblGroupDetail;
    private javax.swing.JTextField jtxtKeterangan;
    private javax.swing.JTextField jtxtKodeGroup;
    private javax.swing.JTextField jtxtTanggalEntry;
    private javax.swing.JTextField jtxtTanggalUpdate;
    private javax.swing.JTextField jtxtUserId;
    private javax.swing.JTextField jtxtid;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        obj.moveFirst();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void searchData() throws CodeException {
        obj = new Mastergroup(this.jtxtKodeGroup.getText());
        showData();
        mf.setIcon(CLASSNAME);
    }
    public void newData() throws CodeException {
        obj = new Mastergroup();
        istatus=1;
        showData();
        setToolBar(iformtype,istatus);
    }

    public void saveData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);

        if (!"".equals(jtxtKodeGroup.getText()) ) {

            istatus = 0;
            setData();
            obj.save();


            for (int i = 0; i < tmodel.getRowCount(); i++) {
                String module = tmodel.getValueAt(i, 1) + "";
                boolean bread = tmodel.getValueAt(i, 3) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 3)+"") ;
                boolean bconfirm = tmodel.getValueAt(i, 4) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 4)+"") ;
                boolean bentry = tmodel.getValueAt(i, 5) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 5)+"") ;
                boolean bupdate = tmodel.getValueAt(i, 6) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 6)+"") ;
                boolean bdelete = tmodel.getValueAt(i, 7) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 7)+"") ;
                boolean bprint = tmodel.getValueAt(i, 8) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 8)+"") ;
                boolean bexport = tmodel.getValueAt(i, 9) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 9)+"") ;
                boolean bimport = tmodel.getValueAt(i, 10) == null? false : Boolean.parseBoolean(tmodel.getValueAt(i, 10)+"") ;

                Mastergroupdetail mg = new Mastergroupdetail();
                mg.loadData(jtxtKodeGroup.getText(), jcmbCompany.getSelectedItem() + "", module);
                
                if (bread) {

                    mg.setKodeGroup(jtxtKodeGroup.getText());
                    mg.setModule(module);
                    mg.setCompany(jcmbCompany.getSelectedItem()+"");
                    mg.setRead(bread?1:0);
                    mg.setConfirm(bconfirm?1:0);
                    mg.setEntry(bentry?1:0);
                    mg.setUpdate(bupdate?1:0);
                    mg.setDelete(bdelete?1:0);
                    mg.setPrint(bprint?1:0);
                    mg.setExport(bexport?1:0);
                    mg.setImport(bimport?1:0);
                    mg.save();
                }else {
                    try {
                        if (mg.getID() > 0) {
                            mg.delete();
                        }
                    }catch (Exception e) {}
                }

            }

            showData();
            mf.setIcon(CLASSNAME);

        }else {
            JOptionPane.showMessageDialog(null, "Group Code Cannot be Empty", "Form Group", JOptionPane.ERROR_MESSAGE);                
        }
       setCursor(GlobalUtils.NORMALCURSOR);
        
    }

    public void showData() throws CodeException {
             setCursor(GlobalUtils.HOURGLASSCURSOR);
	
             jtxtid.setText(obj.toString(Mastergroup.PROPERTY_ID));
             jtxtKodeGroup.setText(obj.toString(Mastergroup.PROPERTY_KODEGROUP));
             jtxtKeterangan.setText(obj.toString(Mastergroup.PROPERTY_KETERANGAN));
             jtxtTanggalEntry.setText(obj.toString(Mastergroup.PROPERTY_TANGGALENTRY));
             jtxtTanggalUpdate.setText(obj.toString(Mastergroup.PROPERTY_TANGGALUPDATE));
             jtxtUserId.setText(obj.toString(Mastergroup.PROPERTY_USERID));

             
             GlobalModel.clearRow(tmodel);
             int i = 0;
             Mastermodules modules = new Mastermodules(0);
             for (Object o : modules.list()) {
                Mastermodule module = (Mastermodule) o;

                Mastergroupdetail mg = new Mastergroupdetail();
                mg.loadData(jtxtKodeGroup.getText(), jcmbCompany.getSelectedItem() + "" , module.getModule());
                
                tmodel.addRow(data);
                
                if (mg.getID() != Mastergroupdetails.NULLID) {
                    tmodel.setValueAt(mg.getID(), i, 0);
                }else {
                    tmodel.setValueAt("0", i, 0);                    
                }

                tmodel.setValueAt(module.getModule(), i, 1);                
                tmodel.setValueAt(module.getDescription(), i, 2);                
                tmodel.setValueAt(mg.getRead()==1?true:false, i, 3);                
                tmodel.setValueAt(mg.getConfirm()==1?true:false, i, 4);                
                tmodel.setValueAt(mg.getEntry()==1?true:false, i, 5);                
                tmodel.setValueAt(mg.getUpdate()==1?true:false, i, 6);                
                tmodel.setValueAt(mg.getDelete()==1?true:false, i, 7);                
                tmodel.setValueAt(mg.getPrint()==1?true:false, i, 8);                
                tmodel.setValueAt(mg.getExport()==1?true:false, i, 9);                
                tmodel.setValueAt(mg.getImport()==1?true:false, i, 10);                
                
                i++;
             }
             setCursor(GlobalUtils.NORMALCURSOR);

    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Mastergroup.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Mastergroup.PROPERTY_KODEGROUP, jtxtKodeGroup.getText()) ;
          obj.fromString(Mastergroup.PROPERTY_KETERANGAN, jtxtKeterangan.getText()) ;
          obj.fromString(Mastergroup.PROPERTY_TANGGALENTRY, jtxtTanggalEntry.getText()) ;
          obj.fromString(Mastergroup.PROPERTY_TANGGALUPDATE, jtxtTanggalUpdate.getText()) ;
          obj.fromString(Mastergroup.PROPERTY_USERID, jtxtUserId.getText()) ;

    }

    public void undo() throws CodeException {
        istatus = 0;
        moveFirst();
        showData();
    }

    public void execute() throws CodeException {
       saveData();
    }


    public void importCsv() throws CodeException {
            
        String file1 = "";
        String file2 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".csv";   
        
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Pilih File ");
        FileFilter filter1 = new ExtFileChooserFilter("CSV", new String[] { "CSV"});
        chooser.setFileFilter(filter1);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            
            try {
                file1 = selectedFile.getCanonicalPath();
            
            }catch (Exception e) {}

            GlobalUtils.copyfile(file1, file2 );                

            obj.importCsv();
            
        }else {
          JOptionPane.showMessageDialog(null,"No Selection ");
        }

    }

    public void exportCsv() throws CodeException {
        
    
        if (obj.exportCsv()) {
            
            String file1 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".csv";   
            String file2 = "";
            
            JFileChooser chooser = new JFileChooser(".");
            chooser.setDialogTitle("Pilih Directory ");
    
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    file2 = chooser.getSelectedFile().getCanonicalPath() + ".csv";
                        
                    JOptionPane.showMessageDialog(null, GlobalUtils.copyfile(file1, file2 ));                    
                    
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());                    
                }
                
            }else {
              JOptionPane.showMessageDialog(null,"No Selection ");
            }
    
        }
        
    }

    public void importText() throws CodeException {
        String file1 = "";
        String file2 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".txt";   
        
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Pilih File ");
        FileFilter filter1 = new ExtFileChooserFilter("txt", new String[] { "txt"});
        chooser.setFileFilter(filter1);


        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            
            try {
                file1 = selectedFile.getCanonicalPath();
            
            }catch (Exception e) {}

            GlobalUtils.copyfile(file1, file2 );                

            obj.importCsv();
            
        }else {
          JOptionPane.showMessageDialog(null,"No Selection ");
        }
    }

    public void exportText() throws CodeException {
        if (obj.exportText()) {
            
            String file1 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".txt";   
            String file2 = "";
            
            JFileChooser chooser = new JFileChooser(".");
            chooser.setDialogTitle("Pilih Directory ");
    
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    file2 = chooser.getSelectedFile().getCanonicalPath() + ".txt";                        
                    JOptionPane.showMessageDialog(null, GlobalUtils.copyfile(file1, file2 ));                    
                    
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());                    
                }
                
            }else {
              JOptionPane.showMessageDialog(null,"No Selection ");
            }
    
        } 
    }


    public void printData() throws CodeException {
        Map parameter = new HashMap();
        parameter.put("user", (GlobalUtils.getUserId()));
        parameter.put("kodegroup", jtxtKodeGroup.getText());
        NavigatorObjectInt noi = (NavigatorObjectInt) obj;        
        String file   = GlobalUtils.getCurrentDir() +"/Reports/" + noi.getClassName() + ".jrxml";
        GlobalUtils.printReport(file, parameter,  false);    
    }
    
}
