/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accapp.component.costapp;

import accapp.component.browse.FrmBrowseGl_batchcostacc;
import accapp.objectclasses.costapp.Costacc;
import accapp.objectclasses.costapp.Costacc_finished_goods_temp;
import accapp.objectclasses.costapp.Costacc_finished_goods_temps;
import accapp.objectclasses.costapp.Costacc_glwip_temp;
import accapp.objectclasses.costapp.Costacc_glwip_temps;
import accapp.objectclasses.costapp.Costacc_purchasevariance_temp;
import accapp.objectclasses.costapp.Costacc_purchasevariance_temps;
import accapp.objectclasses.costapp.Costacc_varianceallocation_temp;
import accapp.objectclasses.costapp.Costacc_varianceallocation_temps;
import accapp.objectclasses.costapp.Costacc_wip_temp;
import accapp.objectclasses.costapp.Costacc_wip_temps;
import accapp.objectclasses.costapp.Costacc_wipfg_temp;
import accapp.objectclasses.costapp.Costacc_wipfg_temps;
import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_batchlists;
import common.classinterface.NavigatorFormInt;
import common.component.FrmBrowse;
import common.component.FrmMainFrame;
import common.tablemodels.GlobalModel;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
/**
 *
 * @author windugata
 */
public class FrmCostAccounting extends javax.swing.JInternalFrame implements NavigatorFormInt  {
    
    FrmMainFrame mf ;
    private static int istatus = 0;
    private static int iformtype = 0;
    
    Costacc_purchasevariance_temps cpurchasevariances ;    
    DefaultTableModel tmodelpurchvar;
    Object[] datapurchvar;
    
    Costacc_glwip_temps cglwips ;    
    DefaultTableModel tmodelglwip;
    Object[] dataglwip;

    Costacc_wipfg_temps cwipfgs;
    DefaultTableModel tmodelwipfg;
    Object[] datawipfg;

    Costacc_varianceallocation_temps cvarlocs;
    DefaultTableModel tmodelvarloc;
    Object[] datavarloc;
    
    Costacc_wip_temps cwips;
    DefaultTableModel tmodelwip;
    Object[] datawip;
    
    Costacc_finished_goods_temps cfgs;
    DefaultTableModel tmodelfg;
    Object[] datafg;
    
    DefaultTableModel tmodeljournaltemp;
    Object[] datajournaltemp;

    
    DecimalFormat df=new DecimalFormat("0.00");

    /**
     * Creates new form FrmCostAccounting
     */
    public FrmCostAccounting() {
        initComponents();
    }

    public FrmCostAccounting(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();
        
        tmodelpurchvar = (DefaultTableModel) jtblPurchaseVariance.getModel();
        GlobalModel.clearRow(tmodelpurchvar);
        datapurchvar = new Object[tmodelpurchvar.getRowCount()];
        cpurchasevariances = new Costacc_purchasevariance_temps();
        
        
        tmodelglwip = (DefaultTableModel) jtblGLWIP.getModel();
        GlobalModel.clearRow(tmodelglwip);
        dataglwip = new Object[jtblGLWIP.getRowCount()];
        cglwips = new Costacc_glwip_temps();
        
        tmodelwipfg = (DefaultTableModel) jtblWIPFG.getModel();
        GlobalModel.clearRow(tmodelwipfg);
        datawipfg = new Object[jtblWIPFG.getRowCount()];
        cwipfgs = new Costacc_wipfg_temps();

        tmodelvarloc = (DefaultTableModel) jtblVarianceAllocation.getModel();
        GlobalModel.clearRow(tmodelvarloc);
        datawipfg = new Object[jtblVarianceAllocation.getRowCount()];
        cvarlocs = new Costacc_varianceallocation_temps();
        
        tmodelwip = (DefaultTableModel) jtblWIP.getModel();
        GlobalModel.clearRow(tmodelwip);
        datawip = new Object[jtblWIP.getRowCount()];
        cwips = new Costacc_wip_temps();

        tmodelfg = (DefaultTableModel) jtblFG.getModel();
        GlobalModel.clearRow(tmodelfg);
        datafg = new Object[jtblFG.getRowCount()];
        cfgs = new Costacc_finished_goods_temps();
        
        
        tmodeljournaltemp = (DefaultTableModel) jtblJournalTemp.getModel();
        GlobalModel.clearRow(tmodeljournaltemp);
        datajournaltemp = new Object[jtblJournalTemp.getRowCount()];
        
        

        jcmbBulan.removeAllItems();
        for(String month : GlobalUtils.getMonth()){
            jcmbBulan.addItem(month);
        }
        
        jcmbTahun.removeAllItems();
        int thnNow = Integer.parseInt(GlobalUtils.getCurrentYear());
        int thnBfr;
        if(thnNow==2020){
            thnBfr = thnNow - 1;
        } else {
            thnBfr = thnNow - 4;
        }
        for(int tahun = thnBfr; tahun <= thnNow; tahun++){
            jcmbTahun.addItem(tahun+"");
        }
        
        jtxtnobatch.setText("0");
        jtxtbatchdesc.setText("");
        
        jcmbBulan.setSelectedIndex(Integer.parseInt(GlobalUtils.getCurrentMonth()) - 1);
        jcmbTahun.setSelectedItem(GlobalUtils.getCurrentYear());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlblBulan = new javax.swing.JLabel();
        jlblTahun = new javax.swing.JLabel();
        jbtnShow = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jtabpaneCostAccounting = new javax.swing.JTabbedPane();
        jpanPurchaseVariance = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPurchaseVariance = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jbtnSavePurchaseVariance = new javax.swing.JButton();
        jpanGLWIP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblGLWIP = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbtnSaveGLWIP = new javax.swing.JButton();
        jpanWIPFG = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblWIPFG = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jbtnSaveWIPFG = new javax.swing.JButton();
        jpanVarianceAllocation = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblVarianceAllocation = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jbtnSaveVarianceAllocation = new javax.swing.JButton();
        jpanWIP = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblWIP = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jbtnSaveWIP = new javax.swing.JButton();
        jpanFinishedGoods = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jbtnSaveFinishedGoods = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblFG = new javax.swing.JTable();
        jbtnCalculateCostAccounting = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbtnCreateJournal = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblJournalTemp = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jtxtnobatch = new javax.swing.JTextField();
        jbtnBrowseNoBatch = new javax.swing.JButton();
        jtxtbatchdesc = new javax.swing.JTextField();
        jbtnProsesJournal = new javax.swing.JButton();
        jcmbBulan = new javax.swing.JComboBox<>();
        jcmbTahun = new javax.swing.JComboBox<>();

        setTitle("Screen Purchase Variance");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Cost Accounting");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 230, 32);

        jlblBulan.setText("Bulan");
        getContentPane().add(jlblBulan);
        jlblBulan.setBounds(30, 70, 70, 20);

        jlblTahun.setText("Tahun");
        getContentPane().add(jlblTahun);
        jlblTahun.setBounds(310, 70, 50, 20);

        jbtnShow.setText("Show");
        jbtnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnShow);
        jbtnShow.setBounds(440, 70, 70, 20);

        jPanel2.setLayout(null);

        jpanPurchaseVariance.setLayout(null);

        jtblPurchaseVariance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No", "Keterangan", "Standard", "Actual", "Variance", "% ToStandard", "Complete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPurchaseVariance.setColumnSelectionAllowed(true);
        jtblPurchaseVariance.getTableHeader().setReorderingAllowed(false);
        jtblPurchaseVariance.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblPurchaseVariancePropertyChange(evt);
            }
        });
        jtblPurchaseVariance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblPurchaseVarianceKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblPurchaseVariance);
        jtblPurchaseVariance.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtblPurchaseVariance.getColumnModel().getColumnCount() > 0) {
            jtblPurchaseVariance.getColumnModel().getColumn(0).setMinWidth(0);
            jtblPurchaseVariance.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblPurchaseVariance.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblPurchaseVariance.getColumnModel().getColumn(1).setMinWidth(50);
            jtblPurchaseVariance.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblPurchaseVariance.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblPurchaseVariance.getColumnModel().getColumn(2).setMinWidth(150);
            jtblPurchaseVariance.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblPurchaseVariance.getColumnModel().getColumn(3).setMinWidth(100);
            jtblPurchaseVariance.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblPurchaseVariance.getColumnModel().getColumn(4).setMinWidth(100);
            jtblPurchaseVariance.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtblPurchaseVariance.getColumnModel().getColumn(6).setMinWidth(50);
            jtblPurchaseVariance.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        jpanPurchaseVariance.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 850, 270);

        jLabel2.setText("Purchase Variance");
        jpanPurchaseVariance.add(jLabel2);
        jLabel2.setBounds(20, 20, 160, 20);

        jbtnSavePurchaseVariance.setText("Save Purchase Variance");
        jbtnSavePurchaseVariance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSavePurchaseVarianceActionPerformed(evt);
            }
        });
        jpanPurchaseVariance.add(jbtnSavePurchaseVariance);
        jbtnSavePurchaseVariance.setBounds(20, 330, 190, 23);

        jtabpaneCostAccounting.addTab("Purchase Variance", jpanPurchaseVariance);

        jpanGLWIP.setLayout(null);

        jtblGLWIP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No", "Keterangan", "Standard", "Actual", "Variance", "% ToStandard", "Complete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblGLWIP.getTableHeader().setReorderingAllowed(false);
        jtblGLWIP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblGLWIPPropertyChange(evt);
            }
        });
        jtblGLWIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblGLWIPKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtblGLWIP);
        if (jtblGLWIP.getColumnModel().getColumnCount() > 0) {
            jtblGLWIP.getColumnModel().getColumn(0).setMinWidth(0);
            jtblGLWIP.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblGLWIP.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblGLWIP.getColumnModel().getColumn(1).setMinWidth(50);
            jtblGLWIP.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblGLWIP.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblGLWIP.getColumnModel().getColumn(2).setMinWidth(200);
            jtblGLWIP.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtblGLWIP.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblGLWIP.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtblGLWIP.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jpanGLWIP.add(jScrollPane2);
        jScrollPane2.setBounds(23, 50, 850, 270);

        jLabel3.setText("GL WIP");
        jpanGLWIP.add(jLabel3);
        jLabel3.setBounds(25, 20, 110, 20);

        jbtnSaveGLWIP.setText("Save GL WIP");
        jbtnSaveGLWIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveGLWIPActionPerformed(evt);
            }
        });
        jpanGLWIP.add(jbtnSaveGLWIP);
        jbtnSaveGLWIP.setBounds(20, 330, 160, 23);

        jtabpaneCostAccounting.addTab(" GL WIP", jpanGLWIP);

        jpanWIPFG.setLayout(null);

        jtblWIPFG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No", "Keterangan", "Standard", "Actual", "Variance", "ToStandard(%)", "Complete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblWIPFG.getTableHeader().setReorderingAllowed(false);
        jtblWIPFG.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblWIPFGPropertyChange(evt);
            }
        });
        jtblWIPFG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblWIPFGKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtblWIPFG);
        if (jtblWIPFG.getColumnModel().getColumnCount() > 0) {
            jtblWIPFG.getColumnModel().getColumn(0).setMinWidth(0);
            jtblWIPFG.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblWIPFG.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblWIPFG.getColumnModel().getColumn(1).setMinWidth(50);
            jtblWIPFG.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblWIPFG.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblWIPFG.getColumnModel().getColumn(2).setMinWidth(200);
            jtblWIPFG.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jpanWIPFG.add(jScrollPane3);
        jScrollPane3.setBounds(27, 47, 830, 280);

        jLabel4.setText("WIP FG");
        jpanWIPFG.add(jLabel4);
        jLabel4.setBounds(30, 20, 133, 14);

        jbtnSaveWIPFG.setText("Save WIP FG");
        jbtnSaveWIPFG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveWIPFGActionPerformed(evt);
            }
        });
        jpanWIPFG.add(jbtnSaveWIPFG);
        jbtnSaveWIPFG.setBounds(30, 340, 130, 23);

        jtabpaneCostAccounting.addTab(" WIP FG", jpanWIPFG);

        jpanVarianceAllocation.setLayout(null);

        jtblVarianceAllocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "No", "Keterangan", "Produksi", "Prod%", "Inventory", "Inv%", "Total 1", "SO. Accured", "Variance", "Total 2", "COGS", "Accrued", "Total 3", "Completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, true, true, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblVarianceAllocation.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblVarianceAllocation.getTableHeader().setReorderingAllowed(false);
        jtblVarianceAllocation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblVarianceAllocationPropertyChange(evt);
            }
        });
        jtblVarianceAllocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblVarianceAllocationKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jtblVarianceAllocation);
        if (jtblVarianceAllocation.getColumnModel().getColumnCount() > 0) {
            jtblVarianceAllocation.getColumnModel().getColumn(0).setMinWidth(0);
            jtblVarianceAllocation.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblVarianceAllocation.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblVarianceAllocation.getColumnModel().getColumn(1).setMinWidth(50);
            jtblVarianceAllocation.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblVarianceAllocation.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblVarianceAllocation.getColumnModel().getColumn(2).setMinWidth(200);
            jtblVarianceAllocation.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtblVarianceAllocation.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtblVarianceAllocation.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        jpanVarianceAllocation.add(jScrollPane4);
        jScrollPane4.setBounds(17, 42, 840, 280);

        jLabel5.setText("Variance Allocation");
        jpanVarianceAllocation.add(jLabel5);
        jLabel5.setBounds(20, 14, 179, 20);

        jbtnSaveVarianceAllocation.setText("Save Variance Allocation");
        jbtnSaveVarianceAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveVarianceAllocationActionPerformed(evt);
            }
        });
        jpanVarianceAllocation.add(jbtnSaveVarianceAllocation);
        jbtnSaveVarianceAllocation.setBounds(20, 330, 230, 23);

        jtabpaneCostAccounting.addTab("Variance Allocation", jpanVarianceAllocation);

        jpanWIP.setLayout(null);

        jtblWIP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "No", "Keterangan", "Produksi", "Prod%", "Inventory", "Inv%", "Total 1", "SO. Accured", "Variance", "Total 2", "COGS", "Accrued", "Total 3", "Completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, true, true, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblWIP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblWIP.setMinimumSize(new java.awt.Dimension(430, 65));
        jtblWIP.getTableHeader().setReorderingAllowed(false);
        jtblWIP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblWIPPropertyChange(evt);
            }
        });
        jtblWIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblWIPKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jtblWIP);
        if (jtblWIP.getColumnModel().getColumnCount() > 0) {
            jtblWIP.getColumnModel().getColumn(0).setMinWidth(0);
            jtblWIP.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblWIP.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblWIP.getColumnModel().getColumn(1).setMinWidth(50);
            jtblWIP.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblWIP.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblWIP.getColumnModel().getColumn(2).setMinWidth(200);
            jtblWIP.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtblWIP.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtblWIP.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        jpanWIP.add(jScrollPane5);
        jScrollPane5.setBounds(22, 44, 830, 270);

        jLabel6.setText("WIP");
        jpanWIP.add(jLabel6);
        jLabel6.setBounds(20, 14, 60, 20);

        jbtnSaveWIP.setText("Save WIP");
        jbtnSaveWIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveWIPActionPerformed(evt);
            }
        });
        jpanWIP.add(jbtnSaveWIP);
        jbtnSaveWIP.setBounds(20, 330, 190, 23);

        jtabpaneCostAccounting.addTab(" WIP", jpanWIP);

        jpanFinishedGoods.setLayout(null);

        jLabel7.setText("Finished Good");
        jpanFinishedGoods.add(jLabel7);
        jLabel7.setBounds(20, 14, 90, 20);

        jbtnSaveFinishedGoods.setText("Save Finished Good");
        jbtnSaveFinishedGoods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveFinishedGoodsActionPerformed(evt);
            }
        });
        jpanFinishedGoods.add(jbtnSaveFinishedGoods);
        jbtnSaveFinishedGoods.setBounds(20, 330, 220, 23);

        jtblFG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "No", "Keterangan", "Sales", "Sls%", "Inventory", "Inv%", "Total 1", "SO. Accured", "Variance", "Total 2", "COGS", "Accrued", "Total 3", "Completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, true, true, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblFG.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblFG.setMinimumSize(new java.awt.Dimension(430, 65));
        jtblFG.getTableHeader().setReorderingAllowed(false);
        jtblFG.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblFGPropertyChange(evt);
            }
        });
        jtblFG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblFGKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(jtblFG);
        if (jtblFG.getColumnModel().getColumnCount() > 0) {
            jtblFG.getColumnModel().getColumn(0).setMinWidth(0);
            jtblFG.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblFG.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblFG.getColumnModel().getColumn(1).setMinWidth(50);
            jtblFG.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblFG.getColumnModel().getColumn(1).setMaxWidth(55);
            jtblFG.getColumnModel().getColumn(2).setMinWidth(200);
            jtblFG.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtblFG.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtblFG.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        jpanFinishedGoods.add(jScrollPane7);
        jScrollPane7.setBounds(20, 40, 846, 280);

        jtabpaneCostAccounting.addTab(" Finished Goods", jpanFinishedGoods);

        jPanel2.add(jtabpaneCostAccounting);
        jtabpaneCostAccounting.setBounds(20, 40, 900, 410);

        jbtnCalculateCostAccounting.setText("Calculate Cost Accounting");
        jbtnCalculateCostAccounting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCalculateCostAccountingActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCalculateCostAccounting);
        jbtnCalculateCostAccounting.setBounds(20, 10, 280, 23);

        jTabbedPane1.addTab("Cost Accounting", jPanel2);

        jPanel1.setLayout(null);

        jbtnCreateJournal.setText("Create Journal Temp");
        jbtnCreateJournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateJournalActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCreateJournal);
        jbtnCreateJournal.setBounds(20, 430, 230, 23);

        jtblJournalTemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "YOP", "MOP", "Journal ID", "Jurnal Desc", "TransNBR", "AcctID", "AccDesc", "TransAmt", "ScurnCode", "TransDesc", "TransReff"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jtblJournalTemp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblJournalTemp.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jtblJournalTemp);
        if (jtblJournalTemp.getColumnModel().getColumnCount() > 0) {
            jtblJournalTemp.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtblJournalTemp.getColumnModel().getColumn(2).setMinWidth(75);
            jtblJournalTemp.getColumnModel().getColumn(2).setPreferredWidth(75);
            jtblJournalTemp.getColumnModel().getColumn(5).setMinWidth(150);
            jtblJournalTemp.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblJournalTemp.getColumnModel().getColumn(6).setMinWidth(250);
            jtblJournalTemp.getColumnModel().getColumn(6).setPreferredWidth(250);
            jtblJournalTemp.getColumnModel().getColumn(9).setMinWidth(250);
            jtblJournalTemp.getColumnModel().getColumn(9).setPreferredWidth(250);
        }

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(20, 50, 870, 370);

        jLabel8.setText("No.Batch");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 20, 70, 20);

        jtxtnobatch.setText("no batch");
        jPanel1.add(jtxtnobatch);
        jtxtnobatch.setBounds(90, 20, 130, 20);

        jbtnBrowseNoBatch.setText("...");
        jbtnBrowseNoBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseNoBatchActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBrowseNoBatch);
        jbtnBrowseNoBatch.setBounds(230, 20, 40, 20);

        jtxtbatchdesc.setEditable(false);
        jtxtbatchdesc.setText("batch desc");
        jPanel1.add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(280, 20, 500, 20);

        jbtnProsesJournal.setText("Transfer Journal to GL");
        jbtnProsesJournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProsesJournalActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnProsesJournal);
        jbtnProsesJournal.setBounds(270, 430, 190, 23);

        jTabbedPane1.addTab("Jurnal Temp", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 920, 490);

        getContentPane().add(jcmbBulan);
        jcmbBulan.setBounds(100, 70, 180, 20);

        getContentPane().add(jcmbTahun);
        jcmbTahun.setBounds(360, 70, 70, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadGLWIP(){
        try {
            cglwips.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelglwip);

            for( Object obj : cglwips.list()) {
                tmodelglwip.addRow(dataglwip);

                Costacc_glwip_temp cglwip = (Costacc_glwip_temp) obj;
                
                tmodelglwip.setValueAt(cglwip.getID(), tmodelglwip.getRowCount() - 1, 0);
                tmodelglwip.setValueAt(cglwip.getcost_detail_id(), tmodelglwip.getRowCount() - 1, 1);
                tmodelglwip.setValueAt(cglwip.getcost_detail(), tmodelglwip.getRowCount() - 1, 2);
                tmodelglwip.setValueAt(cglwip.getstandard(), tmodelglwip.getRowCount() - 1, 3);
                tmodelglwip.setValueAt(cglwip.getactual(), tmodelglwip.getRowCount() - 1, 4);
                tmodelglwip.setValueAt(cglwip.getvariance(), tmodelglwip.getRowCount() - 1, 5);
                tmodelglwip.setValueAt(cglwip.getpercenttostd(), tmodelglwip.getRowCount() - 1, 6);
                tmodelglwip.setValueAt(cglwip.getiscompleted().equals("1") ? true : false, tmodelglwip.getRowCount() - 1, 7);
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadPurchaseVariant(){
        try {
            cpurchasevariances.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelpurchvar);

            for( Object obj : cpurchasevariances.list()) {
                tmodelpurchvar.addRow(datapurchvar);

                Costacc_purchasevariance_temp cpurchasevariance = (Costacc_purchasevariance_temp) obj;
                
                tmodelpurchvar.setValueAt(cpurchasevariance.getID(), tmodelpurchvar.getRowCount() - 1, 0);
                tmodelpurchvar.setValueAt(cpurchasevariance.getcost_detail_id(), tmodelpurchvar.getRowCount() - 1, 1);
                tmodelpurchvar.setValueAt(cpurchasevariance.getcost_detail(), tmodelpurchvar.getRowCount() - 1, 2);
                tmodelpurchvar.setValueAt(cpurchasevariance.getstandard(), tmodelpurchvar.getRowCount() - 1, 3);
                tmodelpurchvar.setValueAt(cpurchasevariance.getactual(), tmodelpurchvar.getRowCount() - 1, 4);
                tmodelpurchvar.setValueAt(cpurchasevariance.getvariance(), tmodelpurchvar.getRowCount() - 1, 5);
                tmodelpurchvar.setValueAt(cpurchasevariance.getpercenttostd(), tmodelpurchvar.getRowCount() - 1, 6);
                tmodelpurchvar.setValueAt(cpurchasevariance.getiscomplated().equals("1") ? true : false, tmodelpurchvar.getRowCount() - 1, 7);
             
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadWIPFG(){
        try {
            cwipfgs.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelwipfg);

            for( Object obj : cwipfgs.list()) {
                tmodelwipfg.addRow(datawipfg);

                Costacc_wipfg_temp cwipfg = (Costacc_wipfg_temp) obj;
                
                tmodelwipfg.setValueAt(cwipfg.getID(), tmodelwipfg.getRowCount() - 1, 0);
                tmodelwipfg.setValueAt(cwipfg.getcost_detail_id(), tmodelwipfg.getRowCount() - 1, 1);
                tmodelwipfg.setValueAt(cwipfg.getcost_detail(), tmodelwipfg.getRowCount() - 1, 2);
                tmodelwipfg.setValueAt(cwipfg.getstandard(), tmodelwipfg.getRowCount() - 1, 3);
                tmodelwipfg.setValueAt(cwipfg.getactual(), tmodelwipfg.getRowCount() - 1, 4);
                tmodelwipfg.setValueAt(cwipfg.getvariance(), tmodelwipfg.getRowCount() - 1, 5);
                tmodelwipfg.setValueAt(cwipfg.getpercenttostd(), tmodelwipfg.getRowCount() - 1, 6);
                tmodelwipfg.setValueAt(cwipfg.getiscompleted().equals("1") ? true : false, tmodelwipfg.getRowCount() - 1, 7);
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadVarLoc(){
        try {
            cvarlocs.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelvarloc);

            for( Object obj : cvarlocs.list()) {
                tmodelvarloc.addRow(datavarloc);

                Costacc_varianceallocation_temp cvarloc = (Costacc_varianceallocation_temp) obj;
                
                tmodelvarloc.setValueAt(cvarloc.getID(), tmodelvarloc.getRowCount() - 1, 0);
                tmodelvarloc.setValueAt(cvarloc.getcost_detail_id(), tmodelvarloc.getRowCount() - 1, 1);
                tmodelvarloc.setValueAt(cvarloc.getcost_detail(), tmodelvarloc.getRowCount() - 1, 2);
                tmodelvarloc.setValueAt(cvarloc.getproduksi(), tmodelvarloc.getRowCount() - 1, 3);
                tmodelvarloc.setValueAt(cvarloc.getproduksipcnt(), tmodelvarloc.getRowCount() - 1, 4);
                tmodelvarloc.setValueAt(cvarloc.getinventory(), tmodelvarloc.getRowCount() - 1, 5);
                tmodelvarloc.setValueAt(cvarloc.getinventorypcnt(), tmodelvarloc.getRowCount() - 1, 6);
                tmodelvarloc.setValueAt(cvarloc.gettotal_1(), tmodelvarloc.getRowCount() - 1, 7);
                tmodelvarloc.setValueAt(cvarloc.getsoaccrued(), tmodelvarloc.getRowCount() - 1, 8);
                tmodelvarloc.setValueAt(cvarloc.getvariance(), tmodelvarloc.getRowCount() - 1, 9);
                tmodelvarloc.setValueAt(cvarloc.gettotal_2(), tmodelvarloc.getRowCount() - 1, 10);
                tmodelvarloc.setValueAt(cvarloc.getcogs(), tmodelvarloc.getRowCount() - 1, 11);
                tmodelvarloc.setValueAt(cvarloc.getaccrued(), tmodelvarloc.getRowCount() - 1, 12);
                tmodelvarloc.setValueAt(cvarloc.gettotal_3(), tmodelvarloc.getRowCount() - 1, 13);
                
                if (cvarloc.getiscompleted() != null) {
                    tmodelvarloc.setValueAt(cvarloc.getiscompleted().equals("1") ? true : false, tmodelvarloc.getRowCount() - 1, 14);
                }
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadWIP(){
        try {
            cwips.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelwip);

            for( Object obj : cwips.list()) {
                tmodelwip.addRow(datawip);

                Costacc_wip_temp cwip = (Costacc_wip_temp) obj;
                
                tmodelwip.setValueAt(cwip.getID(), tmodelwip.getRowCount() - 1, 0);
                tmodelwip.setValueAt(cwip.getcost_detail_id(), tmodelwip.getRowCount() - 1, 1);
                tmodelwip.setValueAt(cwip.getcost_detail(), tmodelwip.getRowCount() - 1, 2);
                tmodelwip.setValueAt(cwip.getproduksi(), tmodelwip.getRowCount() - 1, 3);
                tmodelwip.setValueAt(cwip.getproduksipcnt(), tmodelwip.getRowCount() - 1, 4);
                tmodelwip.setValueAt(cwip.getinventory(), tmodelwip.getRowCount() - 1, 5);
                tmodelwip.setValueAt(cwip.getinventorypcnt(), tmodelwip.getRowCount() - 1, 6);
                tmodelwip.setValueAt(cwip.gettotal_1(), tmodelwip.getRowCount() - 1, 7);
                tmodelwip.setValueAt(cwip.getsoaccrued(), tmodelwip.getRowCount() - 1, 8);
                tmodelwip.setValueAt(cwip.getvariance(), tmodelwip.getRowCount() - 1, 9);
                tmodelwip.setValueAt(cwip.gettotal_2(), tmodelwip.getRowCount() - 1, 10);
                tmodelwip.setValueAt(cwip.getcogs(), tmodelwip.getRowCount() - 1, 11);
                tmodelwip.setValueAt(cwip.getaccrued(), tmodelwip.getRowCount() - 1, 12);
                tmodelwip.setValueAt(cwip.gettotal_3(), tmodelwip.getRowCount() - 1, 13);
                
                
                tmodelwip.setValueAt(cwip.getiscompleted().equals("1") ? true : false, tmodelwip.getRowCount() - 1, 14);
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void loadFinishedGood(){
        try {
            cfgs.loadData((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"");
            
            GlobalModel.clearRow(tmodelfg);

            for( Object obj : cfgs.list()) {
                tmodelfg.addRow(datafg);

                Costacc_finished_goods_temp cfg = (Costacc_finished_goods_temp) obj;
                
                tmodelfg.setValueAt(cfg.getID(), tmodelfg.getRowCount() - 1, 0);
                tmodelfg.setValueAt(cfg.getcost_detail_id(), tmodelfg.getRowCount() - 1, 1);
                tmodelfg.setValueAt(cfg.getcost_detail(), tmodelfg.getRowCount() - 1, 2);
                tmodelfg.setValueAt(cfg.getsales(), tmodelfg.getRowCount() - 1, 3);
                tmodelfg.setValueAt(cfg.getsalespcnt(), tmodelfg.getRowCount() - 1, 4);
                tmodelfg.setValueAt(cfg.getinventory(), tmodelfg.getRowCount() - 1, 5);
                tmodelfg.setValueAt(cfg.getinventorypcnt(), tmodelfg.getRowCount() - 1, 6);
                tmodelfg.setValueAt(cfg.gettotal_1(), tmodelfg.getRowCount() - 1, 7);
                tmodelfg.setValueAt(cfg.getsoaccrued(), tmodelfg.getRowCount() - 1, 8);
                tmodelfg.setValueAt(cfg.getvariance(), tmodelfg.getRowCount() - 1, 9);
                tmodelfg.setValueAt(cfg.gettotal_2(), tmodelfg.getRowCount() - 1, 10);
                tmodelfg.setValueAt(cfg.getcogs(), tmodelfg.getRowCount() - 1, 11);
                tmodelfg.setValueAt(cfg.getaccrued(), tmodelfg.getRowCount() - 1, 12);
                tmodelfg.setValueAt(cfg.gettotal_3(), tmodelfg.getRowCount() - 1, 13);
                
                
                tmodelfg.setValueAt(cfg.getiscompleted().equals("1") ? true : false, tmodelfg.getRowCount() - 1, 14);
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void loadJournalTemp(){


        setCursor(GlobalUtils.HOURGLASSCURSOR);        
        Costacc cacc = new Costacc();
        
        cacc.showJournalTemp((jcmbBulan.getSelectedIndex() + 1) + "", jcmbTahun.getSelectedItem()+"", tmodeljournaltemp, datajournaltemp);

        setCursor(GlobalUtils.NORMALCURSOR);        
        
        
    }
    
    private void jbtnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnShowActionPerformed

        setCursor(GlobalUtils.HOURGLASSCURSOR);        
        
        loadPurchaseVariant();        
        loadGLWIP();
        loadWIPFG();
        loadVarLoc();
        loadWIP();
        
        loadFinishedGood();        
        loadJournalTemp();
        
        setCursor(GlobalUtils.NORMALCURSOR);        
        
    }//GEN-LAST:event_jbtnShowActionPerformed

    private void jtblPurchaseVarianceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblPurchaseVarianceKeyPressed
        int row = jtblPurchaseVariance.getSelectedRow();
        
        if (row == 7) {
            
            evt.consume();
        }
        
        if (evt.getKeyCode()==evt.VK_ENTER ){
            evt.consume();
        }


        
    }//GEN-LAST:event_jtblPurchaseVarianceKeyPressed

    private void jtblPurchaseVariancePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblPurchaseVariancePropertyChange
        int row = jtblPurchaseVariance.getSelectedRow();
        int col = jtblPurchaseVariance.getSelectedColumn();
        
        try{
            
            Double dStandard =  Double.parseDouble(tmodelpurchvar.getValueAt(row, 3)+"");
            Double dActual = Double.parseDouble(tmodelpurchvar.getValueAt(row, 4) + "");
            Double dVariance = dStandard - dActual;
            Double dPercent = Double.parseDouble(df.format(dVariance / dStandard)) ;            
                        
            tmodelpurchvar.setValueAt( dVariance, row, 5);
            tmodelpurchvar.setValueAt( dPercent, row, 6);
            
            for(int h = 3; h<=6;  h++){
                Double dTotal = 0D;
                for(int i = 0; i<6 ; i++) {
                    //System.out.println("=======" + dTotal);
                    dTotal += Double.parseDouble(tmodelpurchvar.getValueAt(i, h) + "");
                }
                tmodelpurchvar.setValueAt( dTotal, 6, h);
            }
            
            Double val = Double.parseDouble(df.format( (Double.parseDouble(tmodelpurchvar.getValueAt(6, 5)+"")/Double.parseDouble(tmodelpurchvar.getValueAt(6, 3) + ""))));
            tmodelpurchvar.setValueAt( val, 6, 6);

        }catch(Exception e) {
            ////e.printStackTrace();
        }
        

    }//GEN-LAST:event_jtblPurchaseVariancePropertyChange

    private void jtblGLWIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblGLWIPKeyPressed
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
        }
    }//GEN-LAST:event_jtblGLWIPKeyPressed

    private void jtblGLWIPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblGLWIPPropertyChange
        int row = jtblGLWIP.getSelectedRow();
        int col = jtblGLWIP.getSelectedColumn();
        
        try{
            
            Double dStandard =  Double.parseDouble(tmodelglwip.getValueAt(row, 3)+"");
            //System.out.println("--------" + dStandard);
            
            Double dActual = Double.parseDouble(tmodelglwip.getValueAt(row, 4) + "");
            Double dVariance = dStandard - dActual;
            Double dPercent = Double.parseDouble(df.format(dVariance / dStandard)) ;            
                        
            tmodelglwip.setValueAt( dVariance, row, 5);
            tmodelglwip.setValueAt( dPercent, row, 6);
            
            for(int h = 3; h<=6;  h++){
                Double dTotal = 0D;
                for(int i = 0; i<5 ; i++) {
                    System.out.println("=======" + dTotal);                    
                    if(i == 3) {
                        tmodelglwip.setValueAt( dTotal, i, h);
                    }else{
                        dTotal += Double.parseDouble(tmodelglwip.getValueAt(i, h) + "");
                    }
                }
                tmodelglwip.setValueAt( dTotal, 5, h);
            }
            
            Double val = Double.parseDouble(df.format(Double.parseDouble(tmodelglwip.getValueAt(3, 5)+"")/Double.parseDouble(tmodelglwip.getValueAt(3, 3) + "")));
            tmodelglwip.setValueAt( val, 3, 6);
            val = Double.parseDouble(tmodelglwip.getValueAt(5, 5)+"")/Double.parseDouble(tmodelglwip.getValueAt(5, 3) + "");
            tmodelglwip.setValueAt( val , 5, 6);

        }catch(Exception e) {
            ////e.printStackTrace();
        }
    }//GEN-LAST:event_jtblGLWIPPropertyChange

    private void jtblWIPFGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblWIPFGKeyPressed
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
        }

    }//GEN-LAST:event_jtblWIPFGKeyPressed

    private void jtblWIPFGPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblWIPFGPropertyChange
        int row = jtblWIPFG.getSelectedRow();
        int col = jtblWIPFG.getSelectedColumn();
        
        try{
            
            Double dStandard =  Double.parseDouble(tmodelwipfg.getValueAt(row, 3)+"");
            //System.out.println("--------" + dStandard);
            
            Double dActual = Double.parseDouble(tmodelwipfg.getValueAt(row, 4) + "");
            Double dVariance = dStandard - dActual;
            Double dPercent = Double.parseDouble(df.format(dVariance / dStandard)) ;            
                        
            tmodelwipfg.setValueAt( dVariance, row, 5);
            tmodelwipfg.setValueAt( dPercent, row, 6);
            
            for(int h = 3; h<=5;  h++){
                Double dTotal = 0D;
                for(int i = 0; i<5 ; i++) {
                    //System.out.println("=======" + dTotal);                    
                    dTotal += Double.parseDouble(tmodelwipfg.getValueAt(i, h) + "");
                }
                
                tmodelwipfg.setValueAt( dTotal, 5, h);
            }
            Double val = Double.parseDouble(df.format(Double.parseDouble(tmodelwipfg.getValueAt(5, 5)+"")/Double.parseDouble(tmodelwipfg.getValueAt(5, 3) + "")));
            tmodelwipfg.setValueAt( val, 5, 6);
            
            
            
        }catch(Exception e) {
            ////e.printStackTrace();
        }
    }//GEN-LAST:event_jtblWIPFGPropertyChange

    private void jtblVarianceAllocationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblVarianceAllocationKeyPressed
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
        }
    }//GEN-LAST:event_jtblVarianceAllocationKeyPressed

    private void jtblVarianceAllocationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblVarianceAllocationPropertyChange
        int row = jtblVarianceAllocation.getSelectedRow();
        int col = jtblVarianceAllocation.getSelectedColumn();
        
        
        try{
            
            Double dProduksi =  Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 3)+"");
            Double dInventori =  Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 5)+"");
            
            Double dTotal1 = dProduksi + dInventori;
            
            jtblVarianceAllocation.setValueAt( dTotal1, row, 7);
            
            Double dSOAccured = Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 8)+"");
            Double dVariance = Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 9)+"");
            
            Double dTotal2 = dSOAccured + dVariance;
            
            jtblVarianceAllocation.setValueAt( dTotal2, row, 10);
            
            Double dCOGS = Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 11)+"");
            Double dAccrued = Double.parseDouble(jtblVarianceAllocation.getValueAt(row, 12)+"");
            
            Double dTotal3 = dCOGS + dAccrued;
            jtblVarianceAllocation.setValueAt( dTotal3, row, 13);

            
           
            
        }catch(Exception e) {
            ////e.printStackTrace();
        }        

    }//GEN-LAST:event_jtblVarianceAllocationPropertyChange

    private void jtblWIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblWIPKeyPressed
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
        }
    }//GEN-LAST:event_jtblWIPKeyPressed

    private void jtblWIPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblWIPPropertyChange
        int row = jtblWIP.getSelectedRow();
        int col = jtblWIP.getSelectedColumn();
        
        
        try{
            
            Double dProduksi =  Double.parseDouble(jtblWIP.getValueAt(row, 3)+"");
            Double dInventori =  Double.parseDouble(jtblWIP.getValueAt(row, 5)+"");
            
            Double dTotal1 = dProduksi + dInventori;
            
            jtblWIP.setValueAt( dTotal1, row, 7);
            
            Double dSOAccured = Double.parseDouble(jtblWIP.getValueAt(row, 8)+"");
            Double dVariance = Double.parseDouble(jtblWIP.getValueAt(row, 9)+"");
            
            Double dTotal2 = dSOAccured + dVariance;
            
            jtblWIP.setValueAt( dTotal2, row, 10);
            
            Double dCOGS = Double.parseDouble(jtblWIP.getValueAt(row, 11)+"");
            Double dAccrued = Double.parseDouble(jtblWIP.getValueAt(row, 12)+"");
            
            Double dTotal3 = dCOGS + dAccrued;
            jtblWIP.setValueAt( dTotal3, row, 13);

            
           
            
        }catch(Exception e) {
            ////e.printStackTrace();
        }        
    }//GEN-LAST:event_jtblWIPPropertyChange

    private void jtblFGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblFGKeyPressed
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
        }
    }//GEN-LAST:event_jtblFGKeyPressed

    private void jtblFGPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblFGPropertyChange
        int row = jtblFG.getSelectedRow();
        int col = jtblFG.getSelectedColumn();
        
        
        try{
            
            Double dSales =  Double.parseDouble(jtblFG.getValueAt(row, 3)+"");
            Double dInventori =  Double.parseDouble(jtblFG.getValueAt(row, 5)+"");
            
            Double dTotal1 = dSales + dInventori;
            
            jtblFG.setValueAt( dTotal1, row, 7);
            
            Double dSOAccured = Double.parseDouble(jtblFG.getValueAt(row, 8)+"");
            Double dVariance = Double.parseDouble(jtblFG.getValueAt(row, 9)+"");
            
            Double dTotal2 = dSOAccured + dVariance;
            
            jtblFG.setValueAt( dTotal2, row, 10);
            
            Double dCOGS = Double.parseDouble(jtblFG.getValueAt(row, 11)+"");
            Double dAccrued = Double.parseDouble(jtblFG.getValueAt(row, 12)+"");
            
            Double dTotal3 = dCOGS + dAccrued;
            jtblFG.setValueAt( dTotal3, row, 13);

            
           
            
        }catch(Exception e) {
            ////e.printStackTrace();
        }        
    }//GEN-LAST:event_jtblFGPropertyChange

    private void jbtnSavePurchaseVarianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSavePurchaseVarianceActionPerformed


        try {
            int rows = jtblPurchaseVariance.getRowCount();
    
            Costacc_purchasevariance_temp cpurchasevariance;
            
            
            for(int i = 0; i < rows; i++) {
                cpurchasevariance = new Costacc_purchasevariance_temp(Long.parseLong(tmodelpurchvar.getValueAt(i, 0)+""));
                cpurchasevariance.setstandard(Double.parseDouble(tmodelpurchvar.getValueAt(i, 3)+""));
                cpurchasevariance.setactual(Double.parseDouble(tmodelpurchvar.getValueAt(i, 4)+""));
                cpurchasevariance.setvariance(Double.parseDouble(tmodelpurchvar.getValueAt(i, 5)+""));
                cpurchasevariance.setpercenttostd(Double.parseDouble(tmodelpurchvar.getValueAt(i, 6)+""));
                cpurchasevariance.setiscomplated(Boolean.parseBoolean(tmodelpurchvar.getValueAt(i, 7)+"")? "1" : "0");
                
                cpurchasevariance.save();
                
            }
            JOptionPane.showMessageDialog(null, "Already Saved Purchase Variance");
            
        } catch (CodeException ex) {        
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSavePurchaseVarianceActionPerformed

    private void jbtnSaveGLWIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveGLWIPActionPerformed

        try {
            int rows = jtblGLWIP.getRowCount();
    
            Costacc_glwip_temp cglwip;
            
            
            for(int i = 0; i < rows; i++) {
                cglwip = new Costacc_glwip_temp(Long.parseLong(tmodelglwip.getValueAt(i, 0)+""));
                cglwip.setstandard(Double.parseDouble(tmodelglwip.getValueAt(i, 3)+""));
                cglwip.setactual(Double.parseDouble(tmodelglwip.getValueAt(i, 4)+""));
                cglwip.setvariance(Double.parseDouble(tmodelglwip.getValueAt(i, 5)+""));
                cglwip.setpercenttostd(Double.parseDouble(tmodelglwip.getValueAt(i, 6)+""));
                cglwip.setiscompleted(Boolean.parseBoolean(tmodelglwip.getValueAt(i, 6)+"") ? "1" : "0");

                cglwip.save();
                
            }
            JOptionPane.showMessageDialog(null, "Already GL WIP");
            
        } catch (CodeException ex) {        
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jbtnSaveGLWIPActionPerformed

    private void jbtnSaveWIPFGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveWIPFGActionPerformed

        try {
            int rows = jtblWIPFG.getRowCount();
    
            Costacc_wipfg_temp cwipfg;
            
            
            for(int i = 0; i < rows; i++) {
                cwipfg = new Costacc_wipfg_temp(Long.parseLong(tmodelwipfg.getValueAt(i, 0)+""));
                cwipfg.setstandard(Double.parseDouble(tmodelwipfg.getValueAt(i, 3)+""));
                cwipfg.setactual(Double.parseDouble(tmodelwipfg.getValueAt(i, 4)+""));
                cwipfg.setvariance(Double.parseDouble(tmodelwipfg.getValueAt(i, 5)+""));
                cwipfg.setpercenttostd(Double.parseDouble(tmodelwipfg.getValueAt(i, 6)+""));
                cwipfg.setiscompleted(Boolean.parseBoolean(tmodelwipfg.getValueAt(i, 6)+"")? "1" : "0");

                cwipfg.save();
                
            }
            JOptionPane.showMessageDialog(null, "Already WIP FG");
            
        } catch (CodeException ex) {        
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jbtnSaveWIPFGActionPerformed

    private void jbtnSaveVarianceAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveVarianceAllocationActionPerformed

        int rows = jtblVarianceAllocation.getRowCount();
        
        try {
            for (int i = 0; i <rows ; i++){
            
                Costacc_varianceallocation_temp cvarloc = new Costacc_varianceallocation_temp(Long.parseLong(tmodelvarloc.getValueAt(i, 0)+""));
           
                cvarloc.setproduksi(Double.parseDouble(tmodelvarloc.getValueAt(i, 3)+""));
                cvarloc.setproduksipcnt(Double.parseDouble(tmodelvarloc.getValueAt(i, 4)+""));
                cvarloc.setinventory(Double.parseDouble(tmodelvarloc.getValueAt(i, 5)+""));
                cvarloc.setinventorypcnt(Double.parseDouble(tmodelvarloc.getValueAt(i, 6)+""));
                cvarloc.settotal_1(Double.parseDouble(tmodelvarloc.getValueAt(i, 7)+""));
                cvarloc.setsoaccrued(Double.parseDouble(tmodelvarloc.getValueAt(i, 8)+""));
                cvarloc.setvariance(Double.parseDouble(tmodelvarloc.getValueAt(i, 9)+""));
                cvarloc.settotal_2(Double.parseDouble(tmodelvarloc.getValueAt(i, 10)+""));
                cvarloc.setcogs(Double.parseDouble(tmodelvarloc.getValueAt(i, 11)+""));
                cvarloc.setaccrued(Double.parseDouble(tmodelvarloc.getValueAt(i, 12)+""));
                cvarloc.settotal_3(Double.parseDouble(tmodelvarloc.getValueAt(i, 13)+""));
                cvarloc.setiscompleted(Boolean.parseBoolean(tmodelvarloc.getValueAt(i, 14)+"") ? "1" : "0");
                
                cvarloc.save();
            }
            JOptionPane.showMessageDialog(null, "Already Saved Variance Allocation");

        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jbtnSaveVarianceAllocationActionPerformed

    private void jbtnSaveWIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveWIPActionPerformed

        int rows = jtblWIP.getRowCount();
        
        try {
            for (int i = 0; i <rows ; i++){
            
                Costacc_wip_temp cwip = new Costacc_wip_temp(Long.parseLong(tmodelwip.getValueAt(i, 0)+""));
           
                cwip.setproduksi(Double.parseDouble(tmodelwip.getValueAt(i, 3)+""));
                cwip.setproduksipcnt(Double.parseDouble(tmodelwip.getValueAt(i, 4)+""));
                cwip.setinventory(Double.parseDouble(tmodelwip.getValueAt(i, 5)+""));
                cwip.setinventorypcnt(Double.parseDouble(tmodelwip.getValueAt(i, 6)+""));
                cwip.settotal_1(Double.parseDouble(tmodelwip.getValueAt(i, 7)+""));
                cwip.setsoaccrued(Double.parseDouble(tmodelwip.getValueAt(i, 8)+""));
                cwip.setvariance(Double.parseDouble(tmodelwip.getValueAt(i, 9)+""));
                cwip.settotal_2(Double.parseDouble(tmodelwip.getValueAt(i, 10)+""));
                cwip.setcogs(Double.parseDouble(tmodelwip.getValueAt(i, 11)+""));
                cwip.setaccrued(Double.parseDouble(tmodelwip.getValueAt(i, 12)+""));
                cwip.settotal_3(Double.parseDouble(tmodelwip.getValueAt(i, 13)+""));
                cwip.setiscompleted(Boolean.parseBoolean(tmodelwip.getValueAt(i, 14)+"") ? "1" : "0");
                
                cwip.save();
            }

            JOptionPane.showMessageDialog(null, "Already Saved WIP");

        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jbtnSaveWIPActionPerformed

    private void jbtnSaveFinishedGoodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveFinishedGoodsActionPerformed

        int rows = jtblFG.getRowCount();
        
        try {
            for (int i = 0; i <rows ; i++){
            
                Costacc_finished_goods_temp cfg = new Costacc_finished_goods_temp(Long.parseLong(jtblFG.getValueAt(i, 0)+""));
           
                cfg.setsales(Double.parseDouble(tmodelfg.getValueAt(i, 3)+""));
                cfg.setsalespcnt(Double.parseDouble(tmodelfg.getValueAt(i, 4)+""));
                cfg.setinventory(Double.parseDouble(tmodelfg.getValueAt(i, 5)+""));
                cfg.setinventorypcnt(Double.parseDouble(tmodelfg.getValueAt(i, 6)+""));
                cfg.settotal_1(Double.parseDouble(tmodelfg.getValueAt(i, 7)+""));
                cfg.setsoaccrued(Double.parseDouble(tmodelfg.getValueAt(i, 8)+""));
                cfg.setvariance(Double.parseDouble(tmodelfg.getValueAt(i, 9)+""));
                cfg.settotal_2(Double.parseDouble(tmodelfg.getValueAt(i, 10)+""));
                cfg.setcogs(Double.parseDouble(tmodelfg.getValueAt(i, 11)+""));
                cfg.setaccrued(Double.parseDouble(tmodelfg.getValueAt(i, 12)+""));
                cfg.settotal_3(Double.parseDouble(tmodelfg.getValueAt(i, 13)+""));
                cfg.setiscompleted(Boolean.parseBoolean(tmodelfg.getValueAt(i, 14)+"") ? "1": "0");
                
                cfg.save();
            }
            JOptionPane.showMessageDialog(null, "Already Saved Finished Good");

        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtnSaveFinishedGoodsActionPerformed

    private void jbtnCalculateCostAccountingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCalculateCostAccountingActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        Costacc ca = new Costacc();        
        boolean bcalc = ca.calculateCostAccounting((jcmbBulan.getSelectedIndex() - 1)+"", jcmbTahun.getSelectedItem()+"");
        
        if (bcalc){
            JOptionPane.showMessageDialog(null, "Calculate Cost Accounting Done");
        }else{
            JOptionPane.showMessageDialog(null, "Problem, Contact IT");
            
        }
        setCursor(GlobalUtils.NORMALCURSOR);
            
        
    }//GEN-LAST:event_jbtnCalculateCostAccountingActionPerformed

    private void jbtnCreateJournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateJournalActionPerformed
        JOptionPane.showMessageDialog(null, "Proses Akan Memerlukan Waktu 10 Menit ");
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        Costacc ca = new Costacc();
        boolean bproses = ca.createJournalTemp((jcmbBulan.getSelectedIndex() - 1)+"", jcmbTahun.getSelectedItem()+"");
        if(bproses){
            JOptionPane.showMessageDialog(null, "proses jurnal temp done");
            loadJournalTemp();  
        }else{
            JOptionPane.showMessageDialog(null, "proses jurnal temp failed");            
        }
        
        
        setCursor(GlobalUtils.NORMALCURSOR);

    }//GEN-LAST:event_jbtnCreateJournalActionPerformed

    private void jbtnBrowseNoBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseNoBatchActionPerformed
        try {
            Gl_batchlists brs = new Gl_batchlists();
            FrmBrowseGl_batchcostacc bd = new FrmBrowseGl_batchcostacc(brs);
            bd.setFirstValue(jtxtnobatch);
            bd.setThirdValue(jtxtbatchdesc);
            bd.setModal(true); 
            bd.setVisible(true);
        } catch (CodeException ex) {
            Logger.getLogger(FrmCostAccounting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnBrowseNoBatchActionPerformed

    private void jbtnProsesJournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProsesJournalActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        
        String yop = jcmbTahun.getSelectedItem()+"";
        String mop = (jcmbBulan.getSelectedIndex() - 1)+"";
        String currCode = "IDR";
        
        int batchid = Integer.parseInt(jtxtnobatch.getText().replace(".00", ""));
        String useraudit = GlobalUtils.audituser;
        String cmpnyid = GlobalUtils.company;
        
        Costacc ca = new Costacc();        
        boolean btransfer = ca.processCostAccToGL(yop,mop,currCode,batchid,useraudit,cmpnyid);
        
        if (btransfer){
            JOptionPane.showMessageDialog(null, "Process Transfer Journal to GL Done");
        }else{
            JOptionPane.showMessageDialog(null, "Problem, Contact IT");
            
        }
        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnProsesJournalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnBrowseNoBatch;
    private javax.swing.JButton jbtnCalculateCostAccounting;
    private javax.swing.JButton jbtnCreateJournal;
    private javax.swing.JButton jbtnProsesJournal;
    private javax.swing.JButton jbtnSaveFinishedGoods;
    private javax.swing.JButton jbtnSaveGLWIP;
    private javax.swing.JButton jbtnSavePurchaseVariance;
    private javax.swing.JButton jbtnSaveVarianceAllocation;
    private javax.swing.JButton jbtnSaveWIP;
    private javax.swing.JButton jbtnSaveWIPFG;
    private javax.swing.JButton jbtnShow;
    private javax.swing.JComboBox<String> jcmbBulan;
    private javax.swing.JComboBox<String> jcmbTahun;
    private javax.swing.JLabel jlblBulan;
    private javax.swing.JLabel jlblTahun;
    private javax.swing.JPanel jpanFinishedGoods;
    private javax.swing.JPanel jpanGLWIP;
    private javax.swing.JPanel jpanPurchaseVariance;
    private javax.swing.JPanel jpanVarianceAllocation;
    private javax.swing.JPanel jpanWIP;
    private javax.swing.JPanel jpanWIPFG;
    private javax.swing.JTabbedPane jtabpaneCostAccounting;
    private javax.swing.JTable jtblFG;
    private javax.swing.JTable jtblGLWIP;
    private javax.swing.JTable jtblJournalTemp;
    private javax.swing.JTable jtblPurchaseVariance;
    private javax.swing.JTable jtblVarianceAllocation;
    private javax.swing.JTable jtblWIP;
    private javax.swing.JTable jtblWIPFG;
    private javax.swing.JTextField jtxtbatchdesc;
    private javax.swing.JTextField jtxtnobatch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void delete() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveFirst() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePrevious() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveNext() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLast() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setToolBar(int iFormType, int istatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchData() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCsv() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportCsv() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importText() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportText() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
