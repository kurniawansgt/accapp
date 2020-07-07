/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accapp.component.invoice;

import accapp.component.browse.FrmBrowseAR_invoBatchList;
import accapp.objectclasses.ap.Ap_distcodes;
import accapp.objectclasses.ar.Ar_invbatchlist;
import accapp.objectclasses.ar.Ar_invbatchlists;
import accapp.objectclasses.invoice.InvoiceValidation;
import common.classinterface.NavigatorFormInt;
import common.component.FrmBrowse;
import common.component.FrmMainFrame;
import common.jdbc.DbBeanWMS;
import common.tablemodels.GlobalModel;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import manufaktur.objectclasses.Masterbahan;
import manufaktur.objectclasses.Masterbahans;
import manufaktur.objectclasses.Masterproduk;
import manufaktur.objectclasses.Masterproduks;
import manufaktur.objectclasses.Masterrekanans;

/**
 *
 * @author windugata
 */
public class FrmInvoiceValidation extends javax.swing.JInternalFrame implements NavigatorFormInt {

    InvoiceValidation invvald = new InvoiceValidation();
    FrmMainFrame mf;
    
    DefaultTableModel tmodelinvsumMB;
    Object[] datainvsumMB;
     
    DefaultTableModel tmodelinvsumSAI;
    Object[] datainvsumSAI;

    DefaultTableModel tmodelinvdetailMB;
    Object[] datainvdetailMB;
    
    DefaultTableModel tmodelinvdetailSAI;
    Object[] datainvdetailSAI;
    
    DefaultTableModel tmodelCDFBB;
    Object[] datacdfbb;
    
    
    DefaultTableModel tmodelCDFBK;
    Object[] datacdfbk;

    DefaultTableModel tmodelVariance;
    Object[] dataVariance;
    
    DefaultTableModel tmodelCPP;
    Object[] dataCPP;
    
    DefaultTableModel tmodelMTS;
    Object[] dataMTS;
    
    DefaultTableModel tmodelOtherCompanyPlant1;
    Object[] dataOtherCompanyPlant1;

    DefaultTableModel tmodelOtherCompanyPlant2;
    Object[] dataOtherCompanyPlant2;

    DefaultTableModel tmodelInvoice;
    Object[] dataInvoice;

    DefaultTableModel tmodelothermanual;
    Object[] dataothermanual;

    boolean bload = false;
    
    /**
     * Creates new form FrmInvoiceValidation
     */
    public FrmInvoiceValidation() {
        this.mf = mf;
        initComponents();
    }
    public FrmInvoiceValidation(FrmMainFrame mf) {
        initComponents();        
        
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
        
        jcmbBulan.setSelectedIndex(Integer.parseInt(GlobalUtils.getCurrentMonth()) - 1);
        jcmbTahun.setSelectedItem(GlobalUtils.getCurrentYear());
        
       jbtnbrowsearbatch.setEnabled(false);
       jchkautobatchno.setSelected(true);
        
        tmodelinvsumMB = (DefaultTableModel) jtblInvoiceSummaryByBrandMB.getModel();
        datainvsumMB = new Object[tmodelinvsumMB.getRowCount()];
        tmodelinvsumSAI = (DefaultTableModel) jtblInvoiceSummaryByBrandSAI.getModel();
        datainvsumSAI = new Object[tmodelinvsumSAI.getRowCount()];
        tmodelinvdetailMB = (DefaultTableModel) jtblDetailMB.getModel();
        datainvdetailMB = new Object[tmodelinvdetailMB.getRowCount()];
        tmodelinvdetailSAI = (DefaultTableModel) jtblDetailSAI.getModel();
        datainvdetailSAI = new Object[tmodelinvdetailSAI.getRowCount()]; 

        tmodelVariance = (DefaultTableModel) jtblDetailSAIMBVariance.getModel();
        dataVariance = new Object[tmodelVariance.getRowCount()]; 
        
        tmodelCDFBB = (DefaultTableModel) jtblCDFBB.getModel();
        datacdfbb = new Object[tmodelCDFBB.getRowCount()];
        tmodelCDFBK = (DefaultTableModel) jtblCDFBK.getModel();
        datacdfbk = new Object[tmodelCDFBK.getRowCount()];
        
        tmodelCPP = (DefaultTableModel) jtblDetailCPP.getModel();
        dataCPP = new Object[tmodelCPP.getRowCount()];
        
        tmodelMTS = (DefaultTableModel) jtblDetailMTS.getModel();
        dataMTS = new Object[tmodelMTS.getRowCount()];

        tmodelOtherCompanyPlant1 = (DefaultTableModel) jtblOtherCompanyPlant1.getModel();
        dataOtherCompanyPlant1 = new Object[tmodelOtherCompanyPlant1.getRowCount()];
        
        tmodelOtherCompanyPlant2 = (DefaultTableModel) jtblOtherCompanyPlant2.getModel();
        dataOtherCompanyPlant2 = new Object[tmodelOtherCompanyPlant2.getRowCount()];

        tmodelInvoice = (DefaultTableModel) jtblInvoice.getModel();
        dataInvoice = new Object[tmodelInvoice.getRowCount()];

        tmodelothermanual = (DefaultTableModel) jtblOtherManual.getModel();
        dataothermanual = new Object[tmodelothermanual.getRowCount()];
        GlobalModel.clearRow(tmodelothermanual);
        tmodelothermanual.addRow(dataothermanual);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtValueSAIHJP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtValueMBHJP = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblInvoiceSummaryByBrandMB = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblInvoiceSummaryByBrandSAI = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnPrintBrandSaI = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblDetailMB = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblDetailSAI = new javax.swing.JTable();
        jbtnPrintDetailSAI = new javax.swing.JButton();
        jbtnResetSAI = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblDetailSAIMBVariance = new javax.swing.JTable();
        jbtnRefresh = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtValueSAIHPD = new javax.swing.JTextField();
        jtxtValueMBHPD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxtNoInvoiceSAI = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtNoFakturPajakSAI = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtxtTanggalSAI = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtxtTotalAmountSAI = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtDiscAmountSAI = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutSAI = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtxtTaxAmountSAI = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtxtAfterTaxAmountSAI = new javax.swing.JTextField();
        jbtnSaveSAI = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblCDFBK = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jtxtNoInvoiceBKCDF = new javax.swing.JTextField();
        jtxtTotalAmountBKCDF = new javax.swing.JTextField();
        jtxtTaxAmountBKCDF = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jtxtDiscAmountBKCDF = new javax.swing.JTextField();
        jtxtNoFakturPajakBKCDF = new javax.swing.JTextField();
        jtxtAfterTaxAmountBKCDF = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jtxtTanggalBKCDF = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutBKCDF = new javax.swing.JTextField();
        jbtnSaveBKCDF = new javax.swing.JButton();
        jbtnPrintBKCDF = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtblCDFBB = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtxtNoInvoiceBBCDF = new javax.swing.JTextField();
        jtxtTotalAmountBBCDF = new javax.swing.JTextField();
        jtxtTaxAmountBBCDF = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jtxtNoFakturPajakBBCDF = new javax.swing.JTextField();
        jtxtDiscAmountBBCDF = new javax.swing.JTextField();
        jtxtAfterTaxAmountBBCDF = new javax.swing.JTextField();
        jbtnSaveBBCDF = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtxtTanggalBBCDF = new javax.swing.JTextField();
        jtxtBfrTaxAmoutBBCDF = new javax.swing.JTextField();
        jbtnPrintBBCDF = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jtxtTotalBakuCDF = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jtxtTotalKemasCDF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtxtTotalCPP = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblDetailCPP = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jtxtNoInvoiceCPP = new javax.swing.JTextField();
        jtxtTotalAmountCPP = new javax.swing.JTextField();
        jtxtTaxAmountCPP = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jtxtNoFakturPajakCPP = new javax.swing.JTextField();
        jtxtDiscAmountCPP = new javax.swing.JTextField();
        jtxtAfterTaxAmountCPP = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jtxtTanggalCPP = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutCPP = new javax.swing.JTextField();
        jbtnSaveCPP = new javax.swing.JButton();
        jbtnPrintCPP = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jtxtTotalHETMTS = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jtblDetailMTS = new javax.swing.JTable();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jtxtNoInvoiceMTS = new javax.swing.JTextField();
        jtxtTotalAmountMTS = new javax.swing.JTextField();
        jtxtTaxAmountMTS = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jtxtNoFakturPajakMTS = new javax.swing.JTextField();
        jtxtDiscAmountMTS = new javax.swing.JTextField();
        jtxtAfterTaxAmountMTS = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jtxtTanggalMTS = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutMTS = new javax.swing.JTextField();
        jbtnSaveCPP1 = new javax.swing.JButton();
        jbtnPrintMTS = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jtxtTotalHPDMTS = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jcmbOtherCompanyPlant1 = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtblOtherCompanyPlant1 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jtxtNoInvoiceOtherCompanyPlant1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jtxtTotalAmountOtherCompanyPlant1 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jtxtTaxAmountOtherCompanyPlant1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jtxtNoFakturPajakOtherCompanyPlant1 = new javax.swing.JTextField();
        jtxtDiscAmountOtherCompanyPlant1 = new javax.swing.JTextField();
        jtxtAfterTaxAmountOtherCompanyPlant1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jtxtTanggalOtherCompanyPlant1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutOtherCompanyPlant1 = new javax.swing.JTextField();
        jbtnSaveOtherCompanyPlant1 = new javax.swing.JButton();
        jbtnPrintOTBahan = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jtxtTotalOtherCompanyPlant1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jcmbOtherCompanyPlant2 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jtxtTotalOtherCompanyPlant2 = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jtblOtherCompanyPlant2 = new javax.swing.JTable();
        jtxtNoInvoiceOtherCompanyPlant2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jtxtTotalAmountOtherCompanyPlant2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jtxtTaxAmountOtherCompanyPlant2 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jtxtNoFakturPajakOtherCompanyPlant2 = new javax.swing.JTextField();
        jtxtDiscAmountOtherCompanyPlant2 = new javax.swing.JTextField();
        jtxtAfterTaxAmountOtherCompanyPlant2 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jtxtTanggalOtherCompanyPlant2 = new javax.swing.JTextField();
        jtxtBfrTaxAmoutOtherCompanyPlant2 = new javax.swing.JTextField();
        jbtnSaveOtherCompanyFG = new javax.swing.JButton();
        jbtnPrintOTProdukBoxGroup = new javax.swing.JButton();
        jbtnPrintOTProdukBox = new javax.swing.JButton();
        jbtnPrintOTProduk = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jtxtKodeOtherManual = new javax.swing.JTextField();
        jtxtNamaOtherManual = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jtxtTotalOtherManual = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jtblOtherManual = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jtxtNoInvoiceOtherManual = new javax.swing.JTextField();
        jtxtTotalAmountOtherManual = new javax.swing.JTextField();
        jtxtTaxAmountOtherManual = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jtxtNoFakturPajakOtherManual = new javax.swing.JTextField();
        jtxtDiscAmountOtherManual = new javax.swing.JTextField();
        jtxtAfterTaxAmountOtherManual = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jtxtTanggalOtherManual = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jtxtBfrTaxAmoutOtherManual = new javax.swing.JTextField();
        jbtnSaveOtherManual = new javax.swing.JButton();
        jbtnBrowseCompany = new javax.swing.JButton();
        jchkBoxProduk = new javax.swing.JCheckBox();
        jbtnPrintOTManual = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtblInvoice = new javax.swing.JTable();
        jbtnRefreshInvoice = new javax.swing.JButton();
        jbtnCreateARInv = new javax.swing.JButton();
        jchkautobatchno = new javax.swing.JCheckBox();
        jtxtarinvbatchno = new javax.swing.JTextField();
        jbtnbrowsearbatch = new javax.swing.JButton();
        jtxtdescarinvobatchlist = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlblBulan = new javax.swing.JLabel();
        jcmbBulan = new javax.swing.JComboBox<>();
        jlblTahun = new javax.swing.JLabel();
        jbtnShow = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jtxtAccountManager = new javax.swing.JTextField();
        jcmbTahun = new javax.swing.JComboBox<>();

        setName(""); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setText("HJP SAI");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 20, 60, 20);

        jtxtValueSAIHJP.setEditable(false);
        jtxtValueSAIHJP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtValueSAIHJP.setText("0");
        jPanel1.add(jtxtValueSAIHJP);
        jtxtValueSAIHJP.setBounds(100, 20, 120, 20);

        jLabel3.setText("HJP MB");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 20, 60, 20);

        jtxtValueMBHJP.setEditable(false);
        jtxtValueMBHJP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtValueMBHJP.setText("0");
        jPanel1.add(jtxtValueMBHJP);
        jtxtValueMBHJP.setBounds(290, 20, 130, 20);

        jPanel5.setLayout(null);

        jtblInvoiceSummaryByBrandMB.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jtblInvoiceSummaryByBrandMB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "KdBrand", "Brand", "HPD", "Discount", "DPP", "PPN", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblInvoiceSummaryByBrandMB.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblInvoiceSummaryByBrandMB);
        if (jtblInvoiceSummaryByBrandMB.getColumnModel().getColumnCount() > 0) {
            jtblInvoiceSummaryByBrandMB.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 870, 110);

        jtblInvoiceSummaryByBrandSAI.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jtblInvoiceSummaryByBrandSAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "kdBrand", "Brand", "HPD", "DISCOUNT", "DPP", "PPN", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtblInvoiceSummaryByBrandSAI);
        if (jtblInvoiceSummaryByBrandSAI.getColumnModel().getColumnCount() > 0) {
            jtblInvoiceSummaryByBrandSAI.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 160, 870, 110);

        jLabel4.setText("MB");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 0, 40, 20);

        jLabel5.setText("SAI");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(10, 140, 50, 14);

        jbtnPrintBrandSaI.setText("Print Brand SAI");
        jbtnPrintBrandSaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintBrandSaIActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnPrintBrandSaI);
        jbtnPrintBrandSaI.setBounds(10, 280, 130, 23);

        jTabbedPane2.addTab("Summary Per Brand", jPanel5);

        jPanel6.setLayout(null);

        jtblDetailMB.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jtblDetailMB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "kdBrand", "Brand", "kdMB", "kdSAI", "MTGCode", "itemName", "QTY", "HPD", "Jumlah", "Disc", "HJP", "JumlahHJP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetailMB.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetailMB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtblDetailMB.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtblDetailMB);
        if (jtblDetailMB.getColumnModel().getColumnCount() > 0) {
            jtblDetailMB.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtblDetailMB.getColumnModel().getColumn(1).setMinWidth(70);
            jtblDetailMB.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtblDetailMB.getColumnModel().getColumn(2).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(3).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(4).setMinWidth(70);
            jtblDetailMB.getColumnModel().getColumn(4).setPreferredWidth(70);
            jtblDetailMB.getColumnModel().getColumn(5).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(6).setMinWidth(250);
            jtblDetailMB.getColumnModel().getColumn(6).setPreferredWidth(250);
            jtblDetailMB.getColumnModel().getColumn(7).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(8).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(8).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(9).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(9).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(10).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(10).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(11).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(11).setPreferredWidth(100);
            jtblDetailMB.getColumnModel().getColumn(12).setMinWidth(100);
            jtblDetailMB.getColumnModel().getColumn(12).setPreferredWidth(100);
        }

        jPanel6.add(jScrollPane4);
        jScrollPane4.setBounds(6, 6, 870, 300);

        jTabbedPane2.addTab("Detail MB", jPanel6);

        jPanel7.setLayout(null);

        jtblDetailSAI.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jtblDetailSAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "kdBrand", "Brand", "kdMB", "kdSAI", "MTGCode", "itemName", "QTY", "HPD", "Jumlah", "Disc", "HJP", "JumlahHJP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetailSAI.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetailSAI.setColumnSelectionAllowed(true);
        jtblDetailSAI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtblDetailSAI.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtblDetailSAI);
        jtblDetailSAI.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtblDetailSAI.getColumnModel().getColumnCount() > 0) {
            jtblDetailSAI.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtblDetailSAI.getColumnModel().getColumn(1).setMinWidth(70);
            jtblDetailSAI.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtblDetailSAI.getColumnModel().getColumn(2).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(3).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(4).setMinWidth(70);
            jtblDetailSAI.getColumnModel().getColumn(4).setPreferredWidth(70);
            jtblDetailSAI.getColumnModel().getColumn(5).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(6).setMinWidth(250);
            jtblDetailSAI.getColumnModel().getColumn(6).setPreferredWidth(250);
            jtblDetailSAI.getColumnModel().getColumn(7).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(8).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(8).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(9).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(9).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(10).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(10).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(11).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(11).setPreferredWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(12).setMinWidth(100);
            jtblDetailSAI.getColumnModel().getColumn(12).setPreferredWidth(100);
        }

        jPanel7.add(jScrollPane5);
        jScrollPane5.setBounds(6, 6, 870, 270);

        jbtnPrintDetailSAI.setText("Print Detail SAI");
        jbtnPrintDetailSAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintDetailSAIActionPerformed(evt);
            }
        });
        jPanel7.add(jbtnPrintDetailSAI);
        jbtnPrintDetailSAI.setBounds(10, 280, 130, 23);

        jbtnResetSAI.setText("Upate Harga");
        jbtnResetSAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetSAIActionPerformed(evt);
            }
        });
        jPanel7.add(jbtnResetSAI);
        jbtnResetSAI.setBounds(750, 280, 120, 23);

        jTabbedPane2.addTab("Detail SAI", jPanel7);

        jPanel10.setLayout(null);

        jtblDetailSAIMBVariance.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jtblDetailSAIMBVariance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "kdBrand", "Brand", "kdMB", "kdSAI", "MTGCode", "itemName", "qtySAI", "qtyMB", "hpdSAI", "hpdMB", "hjpSAI", "hjpMB"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetailSAIMBVariance.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetailSAIMBVariance.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtblDetailSAIMBVariance.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jtblDetailSAIMBVariance);
        if (jtblDetailSAIMBVariance.getColumnModel().getColumnCount() > 0) {
            jtblDetailSAIMBVariance.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(1).setMinWidth(70);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(2).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(3).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(4).setMinWidth(70);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(4).setPreferredWidth(70);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(5).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(6).setMinWidth(250);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(6).setPreferredWidth(250);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(7).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(8).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(8).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(9).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(9).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(10).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(10).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(11).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(11).setPreferredWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(12).setMinWidth(100);
            jtblDetailSAIMBVariance.getColumnModel().getColumn(12).setPreferredWidth(100);
        }

        jPanel10.add(jScrollPane7);
        jScrollPane7.setBounds(6, 6, 870, 250);

        jbtnRefresh.setText("Update Harga ");
        jbtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRefreshActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnRefresh);
        jbtnRefresh.setBounds(10, 270, 230, 23);

        jTabbedPane2.addTab("Variance MB VS SAI", jPanel10);

        jPanel1.add(jTabbedPane2);
        jTabbedPane2.setBounds(30, 50, 910, 340);

        jLabel8.setText("HPD SAI");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(430, 20, 60, 20);

        jLabel9.setText("HPD MB");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(620, 20, 60, 20);

        jtxtValueSAIHPD.setEditable(false);
        jtxtValueSAIHPD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtValueSAIHPD.setText("0");
        jPanel1.add(jtxtValueSAIHPD);
        jtxtValueSAIHPD.setBounds(490, 20, 120, 20);

        jtxtValueMBHPD.setEditable(false);
        jtxtValueMBHPD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtValueMBHPD.setText("0");
        jPanel1.add(jtxtValueMBHPD);
        jtxtValueMBHPD.setBounds(680, 20, 140, 20);

        jLabel11.setText("No Invoice SAI");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 400, 110, 20);
        jPanel1.add(jtxtNoInvoiceSAI);
        jtxtNoInvoiceSAI.setBounds(140, 400, 190, 20);

        jLabel12.setText("No Pajak SAI");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(340, 400, 90, 20);
        jPanel1.add(jtxtNoFakturPajakSAI);
        jtxtNoFakturPajakSAI.setBounds(430, 400, 180, 20);

        jLabel14.setText("Tgl Invoice SAI");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(630, 400, 110, 20);

        jtxtTanggalSAI.setText("2020-01-01");
        jPanel1.add(jtxtTanggalSAI);
        jtxtTanggalSAI.setBounds(740, 400, 100, 20);

        jLabel15.setText("Total SAI");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 430, 110, 20);

        jtxtTotalAmountSAI.setEditable(false);
        jtxtTotalAmountSAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jtxtTotalAmountSAI);
        jtxtTotalAmountSAI.setBounds(140, 430, 190, 20);

        jLabel16.setText("Disc SAI");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(340, 430, 90, 20);

        jtxtDiscAmountSAI.setEditable(false);
        jtxtDiscAmountSAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jtxtDiscAmountSAI);
        jtxtDiscAmountSAI.setBounds(430, 430, 180, 20);

        jLabel17.setText("Before Tax SAI");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(630, 430, 110, 20);

        jtxtBfrTaxAmoutSAI.setEditable(false);
        jtxtBfrTaxAmoutSAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jtxtBfrTaxAmoutSAI);
        jtxtBfrTaxAmoutSAI.setBounds(740, 430, 150, 20);

        jLabel18.setText("Tax SAI");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 460, 110, 20);

        jtxtTaxAmountSAI.setEditable(false);
        jtxtTaxAmountSAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jtxtTaxAmountSAI);
        jtxtTaxAmountSAI.setBounds(140, 460, 190, 20);

        jLabel19.setText("After Tax SAI");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(340, 460, 90, 20);

        jtxtAfterTaxAmountSAI.setEditable(false);
        jtxtAfterTaxAmountSAI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jtxtAfterTaxAmountSAI);
        jtxtAfterTaxAmountSAI.setBounds(430, 460, 180, 20);

        jbtnSaveSAI.setText("Save SAI");
        jbtnSaveSAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveSAIActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnSaveSAI);
        jbtnSaveSAI.setBounds(630, 460, 130, 23);

        jTabbedPane1.addTab("SAI", jPanel1);

        jPanel2.setLayout(null);

        jPanel9.setLayout(null);

        jLabel6.setText("CDF - Bahan Kemas");
        jPanel9.add(jLabel6);
        jLabel6.setBounds(10, 10, 170, 14);

        jtblCDFBK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Dok", "Tgl Dokumen", "No", "PO", "Kode Bahan", "Nama Bahan", "Satuan", "Jumlah", "Harga Standard", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblCDFBK.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblCDFBK.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblCDFBKPropertyChange(evt);
            }
        });
        jScrollPane6.setViewportView(jtblCDFBK);
        if (jtblCDFBK.getColumnModel().getColumnCount() > 0) {
            jtblCDFBK.getColumnModel().getColumn(0).setMinWidth(120);
            jtblCDFBK.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblCDFBK.getColumnModel().getColumn(1).setMinWidth(100);
            jtblCDFBK.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblCDFBK.getColumnModel().getColumn(2).setMinWidth(50);
            jtblCDFBK.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtblCDFBK.getColumnModel().getColumn(3).setMinWidth(50);
            jtblCDFBK.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtblCDFBK.getColumnModel().getColumn(5).setMinWidth(200);
            jtblCDFBK.getColumnModel().getColumn(5).setPreferredWidth(200);
            jtblCDFBK.getColumnModel().getColumn(7).setMinWidth(60);
            jtblCDFBK.getColumnModel().getColumn(7).setPreferredWidth(60);
            jtblCDFBK.getColumnModel().getColumn(8).setMinWidth(150);
            jtblCDFBK.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblCDFBK.getColumnModel().getColumn(9).setMinWidth(150);
            jtblCDFBK.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        jPanel9.add(jScrollPane6);
        jScrollPane6.setBounds(10, 40, 890, 200);

        jLabel38.setText("Total BK CDF");
        jPanel9.add(jLabel38);
        jLabel38.setBounds(20, 320, 110, 20);

        jLabel39.setText("NO Invoice BK CDF");
        jPanel9.add(jLabel39);
        jLabel39.setBounds(20, 290, 140, 20);

        jLabel40.setText("Tax BK CDF");
        jPanel9.add(jLabel40);
        jLabel40.setBounds(20, 350, 110, 20);
        jPanel9.add(jtxtNoInvoiceBKCDF);
        jtxtNoInvoiceBKCDF.setBounds(140, 290, 160, 20);

        jtxtTotalAmountBKCDF.setEditable(false);
        jtxtTotalAmountBKCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel9.add(jtxtTotalAmountBKCDF);
        jtxtTotalAmountBKCDF.setBounds(140, 320, 160, 20);

        jtxtTaxAmountBKCDF.setEditable(false);
        jtxtTaxAmountBKCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel9.add(jtxtTaxAmountBKCDF);
        jtxtTaxAmountBKCDF.setBounds(140, 350, 160, 20);

        jLabel41.setText("No Pajak BK CDF");
        jPanel9.add(jLabel41);
        jLabel41.setBounds(310, 290, 130, 20);

        jLabel42.setText("Disc BK CDF");
        jPanel9.add(jLabel42);
        jLabel42.setBounds(310, 320, 100, 20);

        jLabel43.setText("After Tax BK CDF");
        jPanel9.add(jLabel43);
        jLabel43.setBounds(310, 350, 120, 20);

        jtxtDiscAmountBKCDF.setEditable(false);
        jtxtDiscAmountBKCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel9.add(jtxtDiscAmountBKCDF);
        jtxtDiscAmountBKCDF.setBounds(430, 320, 180, 20);
        jPanel9.add(jtxtNoFakturPajakBKCDF);
        jtxtNoFakturPajakBKCDF.setBounds(430, 290, 180, 20);

        jtxtAfterTaxAmountBKCDF.setEditable(false);
        jtxtAfterTaxAmountBKCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel9.add(jtxtAfterTaxAmountBKCDF);
        jtxtAfterTaxAmountBKCDF.setBounds(430, 350, 180, 20);

        jLabel44.setText("Tgl Invoice BK CDF");
        jPanel9.add(jLabel44);
        jLabel44.setBounds(630, 290, 130, 20);

        jtxtTanggalBKCDF.setText("2020-01-01");
        jPanel9.add(jtxtTanggalBKCDF);
        jtxtTanggalBKCDF.setBounds(760, 290, 100, 20);

        jLabel45.setText("Before Tax BK CDF");
        jPanel9.add(jLabel45);
        jLabel45.setBounds(630, 320, 130, 20);

        jtxtBfrTaxAmoutBKCDF.setEditable(false);
        jtxtBfrTaxAmoutBKCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel9.add(jtxtBfrTaxAmoutBKCDF);
        jtxtBfrTaxAmoutBKCDF.setBounds(760, 320, 150, 20);

        jbtnSaveBKCDF.setText("Save BK CDF");
        jbtnSaveBKCDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveBKCDFActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnSaveBKCDF);
        jbtnSaveBKCDF.setBounds(620, 350, 130, 23);

        jbtnPrintBKCDF.setText("Print  BK CDF");
        jbtnPrintBKCDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintBKCDFActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnPrintBKCDF);
        jbtnPrintBKCDF.setBounds(10, 250, 130, 23);

        jTabbedPane3.addTab("Bahan Kemas", jPanel9);

        jPanel8.setLayout(null);

        jLabel7.setText("CDF - Bahan Baku");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(10, 10, 170, 14);

        jtblCDFBB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Dok", "Tgl Dokumen", "No", "PO", "Kode Bahan", "Nama Bahan", "Satuan", "Jumlah", "Harga Standard", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblCDFBB.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblCDFBB.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblCDFBBPropertyChange(evt);
            }
        });
        jScrollPane8.setViewportView(jtblCDFBB);
        if (jtblCDFBB.getColumnModel().getColumnCount() > 0) {
            jtblCDFBB.getColumnModel().getColumn(0).setMinWidth(120);
            jtblCDFBB.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblCDFBB.getColumnModel().getColumn(1).setMinWidth(100);
            jtblCDFBB.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblCDFBB.getColumnModel().getColumn(2).setMinWidth(50);
            jtblCDFBB.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtblCDFBB.getColumnModel().getColumn(3).setMinWidth(50);
            jtblCDFBB.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtblCDFBB.getColumnModel().getColumn(5).setMinWidth(200);
            jtblCDFBB.getColumnModel().getColumn(5).setPreferredWidth(200);
            jtblCDFBB.getColumnModel().getColumn(6).setMinWidth(80);
            jtblCDFBB.getColumnModel().getColumn(6).setPreferredWidth(80);
            jtblCDFBB.getColumnModel().getColumn(7).setMinWidth(60);
            jtblCDFBB.getColumnModel().getColumn(7).setPreferredWidth(60);
            jtblCDFBB.getColumnModel().getColumn(8).setMinWidth(150);
            jtblCDFBB.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblCDFBB.getColumnModel().getColumn(9).setMinWidth(150);
            jtblCDFBB.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        jPanel8.add(jScrollPane8);
        jScrollPane8.setBounds(10, 40, 890, 200);

        jLabel20.setText("NO Invoice BB CDF");
        jPanel8.add(jLabel20);
        jLabel20.setBounds(10, 290, 140, 20);

        jLabel21.setText("Total  BB CDF");
        jPanel8.add(jLabel21);
        jLabel21.setBounds(10, 320, 140, 20);

        jLabel22.setText("Tax BB CDF");
        jPanel8.add(jLabel22);
        jLabel22.setBounds(10, 350, 140, 20);
        jPanel8.add(jtxtNoInvoiceBBCDF);
        jtxtNoInvoiceBBCDF.setBounds(150, 290, 160, 20);

        jtxtTotalAmountBBCDF.setEditable(false);
        jtxtTotalAmountBBCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel8.add(jtxtTotalAmountBBCDF);
        jtxtTotalAmountBBCDF.setBounds(150, 320, 160, 20);

        jtxtTaxAmountBBCDF.setEditable(false);
        jtxtTaxAmountBBCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel8.add(jtxtTaxAmountBBCDF);
        jtxtTaxAmountBBCDF.setBounds(150, 350, 160, 20);

        jLabel23.setText("No Pajak BB CDF");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(320, 290, 120, 20);

        jLabel24.setText("Disc BB CDF");
        jPanel8.add(jLabel24);
        jLabel24.setBounds(320, 320, 120, 20);

        jLabel25.setText("After Tax BB CDF");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(320, 350, 120, 20);
        jPanel8.add(jtxtNoFakturPajakBBCDF);
        jtxtNoFakturPajakBBCDF.setBounds(440, 290, 180, 20);

        jtxtDiscAmountBBCDF.setEditable(false);
        jtxtDiscAmountBBCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel8.add(jtxtDiscAmountBBCDF);
        jtxtDiscAmountBBCDF.setBounds(440, 320, 180, 20);

        jtxtAfterTaxAmountBBCDF.setEditable(false);
        jtxtAfterTaxAmountBBCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel8.add(jtxtAfterTaxAmountBBCDF);
        jtxtAfterTaxAmountBBCDF.setBounds(440, 350, 180, 20);

        jbtnSaveBBCDF.setText("Save BB CDF");
        jbtnSaveBBCDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveBBCDFActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnSaveBBCDF);
        jbtnSaveBBCDF.setBounds(640, 350, 140, 23);

        jLabel27.setText("Before Tax BB CDF");
        jPanel8.add(jLabel27);
        jLabel27.setBounds(640, 320, 120, 20);

        jLabel26.setText("Tgl Invoice BB CDF");
        jPanel8.add(jLabel26);
        jLabel26.setBounds(640, 290, 120, 20);

        jtxtTanggalBBCDF.setText("2020-01-01");
        jPanel8.add(jtxtTanggalBBCDF);
        jtxtTanggalBBCDF.setBounds(760, 290, 100, 20);

        jtxtBfrTaxAmoutBBCDF.setEditable(false);
        jtxtBfrTaxAmoutBBCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel8.add(jtxtBfrTaxAmoutBBCDF);
        jtxtBfrTaxAmoutBBCDF.setBounds(760, 320, 140, 20);

        jbtnPrintBBCDF.setText("Print  BB CDF");
        jbtnPrintBBCDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintBBCDFActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnPrintBBCDF);
        jbtnPrintBBCDF.setBounds(10, 250, 130, 23);

        jTabbedPane3.addTab("Bahan Baku", jPanel8);

        jPanel2.add(jTabbedPane3);
        jTabbedPane3.setBounds(10, 50, 930, 430);

        jLabel28.setText("Total Baku CDF");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(30, 20, 130, 20);

        jtxtTotalBakuCDF.setEditable(false);
        jtxtTotalBakuCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(jtxtTotalBakuCDF);
        jtxtTotalBakuCDF.setBounds(180, 20, 180, 20);

        jLabel29.setText("Total Kemas CDF");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(400, 20, 140, 20);

        jtxtTotalKemasCDF.setEditable(false);
        jtxtTotalKemasCDF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(jtxtTotalKemasCDF);
        jtxtTotalKemasCDF.setBounds(550, 20, 200, 20);

        jTabbedPane1.addTab("CDF", jPanel2);

        jPanel3.setLayout(null);

        jLabel10.setText("Total");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 20, 60, 20);

        jtxtTotalCPP.setEditable(false);
        jtxtTotalCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtTotalCPP.setText("0");
        jtxtTotalCPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTotalCPPActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtTotalCPP);
        jtxtTotalCPP.setBounds(90, 20, 180, 20);

        jtblDetailCPP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "SKB", "Tanggal", "Kode Produk", "Nama Produk", "Price", "QTY", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtblDetailCPP);
        if (jtblDetailCPP.getColumnModel().getColumnCount() > 0) {
            jtblDetailCPP.getColumnModel().getColumn(0).setResizable(false);
            jtblDetailCPP.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtblDetailCPP.getColumnModel().getColumn(1).setResizable(false);
            jtblDetailCPP.getColumnModel().getColumn(1).setPreferredWidth(55);
            jtblDetailCPP.getColumnModel().getColumn(3).setMinWidth(100);
            jtblDetailCPP.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblDetailCPP.getColumnModel().getColumn(4).setMinWidth(200);
            jtblDetailCPP.getColumnModel().getColumn(4).setPreferredWidth(200);
            jtblDetailCPP.getColumnModel().getColumn(5).setPreferredWidth(85);
            jtblDetailCPP.getColumnModel().getColumn(6).setResizable(false);
            jtblDetailCPP.getColumnModel().getColumn(6).setPreferredWidth(45);
            jtblDetailCPP.getColumnModel().getColumn(7).setResizable(false);
            jtblDetailCPP.getColumnModel().getColumn(7).setPreferredWidth(95);
        }

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 60, 900, 260);

        jLabel30.setText("NO Invoice CPP");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(30, 340, 110, 20);

        jLabel31.setText("Total CPP");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(30, 370, 80, 20);

        jLabel32.setText("Tax CPP");
        jPanel3.add(jLabel32);
        jLabel32.setBounds(30, 400, 80, 20);
        jPanel3.add(jtxtNoInvoiceCPP);
        jtxtNoInvoiceCPP.setBounds(140, 340, 190, 20);

        jtxtTotalAmountCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jtxtTotalAmountCPP);
        jtxtTotalAmountCPP.setBounds(140, 370, 190, 20);

        jtxtTaxAmountCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jtxtTaxAmountCPP);
        jtxtTaxAmountCPP.setBounds(140, 400, 190, 20);

        jLabel33.setText("No Pajak CPP");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(340, 340, 90, 20);

        jLabel34.setText("Disc CPP");
        jPanel3.add(jLabel34);
        jLabel34.setBounds(340, 370, 60, 20);

        jLabel35.setText("After Tax CPP");
        jPanel3.add(jLabel35);
        jLabel35.setBounds(340, 400, 90, 20);
        jPanel3.add(jtxtNoFakturPajakCPP);
        jtxtNoFakturPajakCPP.setBounds(430, 340, 180, 20);

        jtxtDiscAmountCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jtxtDiscAmountCPP);
        jtxtDiscAmountCPP.setBounds(430, 370, 180, 20);

        jtxtAfterTaxAmountCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jtxtAfterTaxAmountCPP);
        jtxtAfterTaxAmountCPP.setBounds(430, 400, 180, 20);

        jLabel36.setText("Tgl Invoice CPPP");
        jPanel3.add(jLabel36);
        jLabel36.setBounds(630, 340, 110, 20);

        jtxtTanggalCPP.setText("2020-01-01");
        jPanel3.add(jtxtTanggalCPP);
        jtxtTanggalCPP.setBounds(740, 340, 100, 20);

        jLabel37.setText("Before Tax CPP");
        jPanel3.add(jLabel37);
        jLabel37.setBounds(630, 370, 110, 20);

        jtxtBfrTaxAmoutCPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jtxtBfrTaxAmoutCPP);
        jtxtBfrTaxAmoutCPP.setBounds(740, 370, 150, 20);

        jbtnSaveCPP.setText("Save CPP");
        jbtnSaveCPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveCPPActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnSaveCPP);
        jbtnSaveCPP.setBounds(620, 400, 120, 23);

        jbtnPrintCPP.setText("Print CPP");
        jbtnPrintCPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintCPPActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnPrintCPP);
        jbtnPrintCPP.setBounds(750, 400, 130, 23);

        jTabbedPane1.addTab("CPP", jPanel3);

        jPanel14.setLayout(null);

        jLabel76.setText("Total HET");
        jPanel14.add(jLabel76);
        jLabel76.setBounds(330, 20, 80, 20);

        jtxtTotalHETMTS.setEditable(false);
        jtxtTotalHETMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtTotalHETMTS.setText("0");
        jPanel14.add(jtxtTotalHETMTS);
        jtxtTotalHETMTS.setBounds(410, 20, 180, 20);

        jtblDetailMTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "MTS Code", "Doc No", "Tanggal", "Kode Produk", "Nama Produk", "HPD", "HET", "Qty", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jtblDetailMTS);
        if (jtblDetailMTS.getColumnModel().getColumnCount() > 0) {
            jtblDetailMTS.getColumnModel().getColumn(0).setResizable(false);
            jtblDetailMTS.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtblDetailMTS.getColumnModel().getColumn(1).setResizable(false);
            jtblDetailMTS.getColumnModel().getColumn(1).setPreferredWidth(55);
            jtblDetailMTS.getColumnModel().getColumn(2).setResizable(false);
            jtblDetailMTS.getColumnModel().getColumn(4).setMinWidth(100);
            jtblDetailMTS.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtblDetailMTS.getColumnModel().getColumn(5).setMinWidth(200);
            jtblDetailMTS.getColumnModel().getColumn(5).setPreferredWidth(200);
            jtblDetailMTS.getColumnModel().getColumn(6).setPreferredWidth(85);
            jtblDetailMTS.getColumnModel().getColumn(7).setPreferredWidth(85);
            jtblDetailMTS.getColumnModel().getColumn(8).setResizable(false);
            jtblDetailMTS.getColumnModel().getColumn(8).setPreferredWidth(45);
            jtblDetailMTS.getColumnModel().getColumn(9).setResizable(false);
            jtblDetailMTS.getColumnModel().getColumn(9).setPreferredWidth(95);
        }

        jPanel14.add(jScrollPane13);
        jScrollPane13.setBounds(20, 60, 920, 260);

        jLabel77.setText("No. Invoice MTS");
        jPanel14.add(jLabel77);
        jLabel77.setBounds(20, 340, 110, 20);

        jLabel78.setText("Total MTS");
        jPanel14.add(jLabel78);
        jLabel78.setBounds(20, 370, 80, 20);

        jLabel79.setText("Tax MTS");
        jPanel14.add(jLabel79);
        jLabel79.setBounds(20, 400, 80, 20);
        jPanel14.add(jtxtNoInvoiceMTS);
        jtxtNoInvoiceMTS.setBounds(130, 340, 190, 20);

        jtxtTotalAmountMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel14.add(jtxtTotalAmountMTS);
        jtxtTotalAmountMTS.setBounds(130, 370, 190, 20);

        jtxtTaxAmountMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel14.add(jtxtTaxAmountMTS);
        jtxtTaxAmountMTS.setBounds(130, 400, 190, 20);

        jLabel80.setText("No. Pajak MTS");
        jPanel14.add(jLabel80);
        jLabel80.setBounds(330, 340, 90, 20);

        jLabel81.setText("Disc MTS");
        jPanel14.add(jLabel81);
        jLabel81.setBounds(330, 370, 60, 20);

        jLabel82.setText("After Tax MTS");
        jPanel14.add(jLabel82);
        jLabel82.setBounds(330, 400, 90, 20);
        jPanel14.add(jtxtNoFakturPajakMTS);
        jtxtNoFakturPajakMTS.setBounds(420, 340, 180, 20);

        jtxtDiscAmountMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel14.add(jtxtDiscAmountMTS);
        jtxtDiscAmountMTS.setBounds(420, 370, 180, 20);

        jtxtAfterTaxAmountMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel14.add(jtxtAfterTaxAmountMTS);
        jtxtAfterTaxAmountMTS.setBounds(420, 400, 180, 20);

        jLabel83.setText("Tgl Invoice MTS");
        jPanel14.add(jLabel83);
        jLabel83.setBounds(620, 340, 110, 20);

        jtxtTanggalMTS.setText("2020-01-01");
        jPanel14.add(jtxtTanggalMTS);
        jtxtTanggalMTS.setBounds(730, 340, 100, 20);

        jLabel84.setText("Before Tax MTS");
        jPanel14.add(jLabel84);
        jLabel84.setBounds(620, 370, 110, 20);

        jtxtBfrTaxAmoutMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel14.add(jtxtBfrTaxAmoutMTS);
        jtxtBfrTaxAmoutMTS.setBounds(730, 370, 150, 20);

        jbtnSaveCPP1.setText("Save TPS");
        jbtnSaveCPP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveCPP1ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnSaveCPP1);
        jbtnSaveCPP1.setBounds(620, 400, 120, 23);

        jbtnPrintMTS.setText("Print TPS");
        jbtnPrintMTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintMTSActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnPrintMTS);
        jbtnPrintMTS.setBounds(750, 400, 130, 23);

        jLabel85.setText("Total HPD");
        jPanel14.add(jLabel85);
        jLabel85.setBounds(30, 20, 80, 20);

        jtxtTotalHPDMTS.setEditable(false);
        jtxtTotalHPDMTS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtTotalHPDMTS.setText("0");
        jPanel14.add(jtxtTotalHPDMTS);
        jtxtTotalHPDMTS.setBounds(110, 20, 180, 20);

        jTabbedPane1.addTab("TPS", jPanel14);

        jPanel4.setLayout(null);

        jLabel46.setText("Company Plant 1");
        jPanel4.add(jLabel46);
        jLabel46.setBounds(50, 20, 130, 20);

        jcmbOtherCompanyPlant1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbOtherCompanyPlant1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbOtherCompanyPlant1ItemStateChanged(evt);
            }
        });
        jcmbOtherCompanyPlant1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcmbOtherCompanyPlant1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbOtherCompanyPlant1MouseClicked(evt);
            }
        });
        jcmbOtherCompanyPlant1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbOtherCompanyPlant1ActionPerformed(evt);
            }
        });
        jcmbOtherCompanyPlant1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcmbOtherCompanyPlant1PropertyChange(evt);
            }
        });
        jPanel4.add(jcmbOtherCompanyPlant1);
        jcmbOtherCompanyPlant1.setBounds(190, 20, 400, 20);

        jtblOtherCompanyPlant1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Dok", "Tgl Dokumen", "No", "PO", "Kode Bahan", "Nama Bahan", "Jumlah", "Satuan", "Harga Standard", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblOtherCompanyPlant1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblOtherCompanyPlant1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblOtherCompanyPlant1PropertyChange(evt);
            }
        });
        jScrollPane9.setViewportView(jtblOtherCompanyPlant1);
        if (jtblOtherCompanyPlant1.getColumnModel().getColumnCount() > 0) {
            jtblOtherCompanyPlant1.getColumnModel().getColumn(0).setMinWidth(120);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(1).setMinWidth(100);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(2).setMinWidth(50);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(3).setMinWidth(150);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(5).setMinWidth(200);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(5).setPreferredWidth(200);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(6).setMinWidth(80);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(7).setMinWidth(60);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(7).setPreferredWidth(60);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(8).setMinWidth(150);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(9).setMinWidth(150);
            jtblOtherCompanyPlant1.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        jPanel4.add(jScrollPane9);
        jScrollPane9.setBounds(30, 60, 890, 210);

        jLabel47.setText("NO Invoice ");
        jPanel4.add(jLabel47);
        jLabel47.setBounds(30, 320, 140, 20);
        jPanel4.add(jtxtNoInvoiceOtherCompanyPlant1);
        jtxtNoInvoiceOtherCompanyPlant1.setBounds(170, 320, 160, 20);

        jLabel48.setText("Total  ");
        jPanel4.add(jLabel48);
        jLabel48.setBounds(30, 350, 110, 20);

        jtxtTotalAmountOtherCompanyPlant1.setEditable(false);
        jtxtTotalAmountOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtTotalAmountOtherCompanyPlant1);
        jtxtTotalAmountOtherCompanyPlant1.setBounds(170, 350, 160, 20);

        jLabel49.setText("Tax  ");
        jPanel4.add(jLabel49);
        jLabel49.setBounds(30, 380, 110, 20);

        jtxtTaxAmountOtherCompanyPlant1.setEditable(false);
        jtxtTaxAmountOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtTaxAmountOtherCompanyPlant1);
        jtxtTaxAmountOtherCompanyPlant1.setBounds(170, 380, 160, 20);

        jLabel50.setText("No Pajak  ");
        jPanel4.add(jLabel50);
        jLabel50.setBounds(340, 320, 110, 20);

        jLabel51.setText("Disc  ");
        jPanel4.add(jLabel51);
        jLabel51.setBounds(340, 350, 100, 20);

        jLabel52.setText("After Tax  ");
        jPanel4.add(jLabel52);
        jLabel52.setBounds(340, 380, 120, 20);
        jPanel4.add(jtxtNoFakturPajakOtherCompanyPlant1);
        jtxtNoFakturPajakOtherCompanyPlant1.setBounds(460, 320, 180, 20);

        jtxtDiscAmountOtherCompanyPlant1.setEditable(false);
        jtxtDiscAmountOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtDiscAmountOtherCompanyPlant1);
        jtxtDiscAmountOtherCompanyPlant1.setBounds(460, 350, 180, 20);

        jtxtAfterTaxAmountOtherCompanyPlant1.setEditable(false);
        jtxtAfterTaxAmountOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtAfterTaxAmountOtherCompanyPlant1);
        jtxtAfterTaxAmountOtherCompanyPlant1.setBounds(460, 380, 180, 20);

        jLabel53.setText("Tgl Invoice ");
        jPanel4.add(jLabel53);
        jLabel53.setBounds(660, 320, 120, 20);

        jtxtTanggalOtherCompanyPlant1.setText("2020-01-01");
        jPanel4.add(jtxtTanggalOtherCompanyPlant1);
        jtxtTanggalOtherCompanyPlant1.setBounds(780, 320, 100, 20);

        jLabel54.setText("Before Tax  ");
        jPanel4.add(jLabel54);
        jLabel54.setBounds(660, 350, 120, 20);

        jtxtBfrTaxAmoutOtherCompanyPlant1.setEditable(false);
        jtxtBfrTaxAmoutOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtBfrTaxAmoutOtherCompanyPlant1);
        jtxtBfrTaxAmoutOtherCompanyPlant1.setBounds(780, 350, 140, 20);

        jbtnSaveOtherCompanyPlant1.setText("Save OT Bahan ");
        jbtnSaveOtherCompanyPlant1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveOtherCompanyPlant1ActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnSaveOtherCompanyPlant1);
        jbtnSaveOtherCompanyPlant1.setBounds(660, 380, 150, 23);

        jbtnPrintOTBahan.setText("Print OT Bahan");
        jbtnPrintOTBahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintOTBahanActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnPrintOTBahan);
        jbtnPrintOTBahan.setBounds(30, 280, 220, 23);

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Total ");
        jPanel4.add(jLabel55);
        jLabel55.setBounds(640, 20, 90, 20);

        jtxtTotalOtherCompanyPlant1.setEditable(false);
        jtxtTotalOtherCompanyPlant1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel4.add(jtxtTotalOtherCompanyPlant1);
        jtxtTotalOtherCompanyPlant1.setBounds(740, 20, 180, 20);

        jTabbedPane1.addTab("Other Companies (Plant 1 - Bahan)", jPanel4);

        jPanel12.setLayout(null);

        jLabel56.setText("Company Plant 2");
        jPanel12.add(jLabel56);
        jLabel56.setBounds(50, 20, 130, 20);

        jcmbOtherCompanyPlant2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbOtherCompanyPlant2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbOtherCompanyPlant2ItemStateChanged(evt);
            }
        });
        jcmbOtherCompanyPlant2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcmbOtherCompanyPlant2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbOtherCompanyPlant2MouseClicked(evt);
            }
        });
        jcmbOtherCompanyPlant2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbOtherCompanyPlant2ActionPerformed(evt);
            }
        });
        jcmbOtherCompanyPlant2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcmbOtherCompanyPlant2PropertyChange(evt);
            }
        });
        jPanel12.add(jcmbOtherCompanyPlant2);
        jcmbOtherCompanyPlant2.setBounds(190, 20, 400, 20);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Total ");
        jPanel12.add(jLabel57);
        jLabel57.setBounds(640, 20, 90, 20);

        jtxtTotalOtherCompanyPlant2.setEditable(false);
        jtxtTotalOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtTotalOtherCompanyPlant2);
        jtxtTotalOtherCompanyPlant2.setBounds(740, 20, 180, 20);

        jtblOtherCompanyPlant2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Dok", "Tgl Dokumen", "No", "No Acuan", "Kode Produk", "Nama Produk", "Jumlah", "Satuan", "Harga Faktur", "Value", "Isi", "Box", "Harga Box", "NoGr", "Reff"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblOtherCompanyPlant2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblOtherCompanyPlant2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblOtherCompanyPlant2PropertyChange(evt);
            }
        });
        jScrollPane11.setViewportView(jtblOtherCompanyPlant2);
        if (jtblOtherCompanyPlant2.getColumnModel().getColumnCount() > 0) {
            jtblOtherCompanyPlant2.getColumnModel().getColumn(0).setMinWidth(120);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(1).setMinWidth(100);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(2).setMinWidth(50);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(3).setMinWidth(100);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(4).setMinWidth(150);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(5).setMinWidth(300);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(5).setPreferredWidth(300);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(6).setMinWidth(80);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(6).setPreferredWidth(80);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(7).setMinWidth(60);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(7).setPreferredWidth(60);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(8).setMinWidth(150);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(9).setMinWidth(150);
            jtblOtherCompanyPlant2.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        jPanel12.add(jScrollPane11);
        jScrollPane11.setBounds(30, 60, 890, 210);
        jPanel12.add(jtxtNoInvoiceOtherCompanyPlant2);
        jtxtNoInvoiceOtherCompanyPlant2.setBounds(170, 330, 160, 20);

        jLabel58.setText("NO Invoice ");
        jPanel12.add(jLabel58);
        jLabel58.setBounds(30, 330, 140, 20);

        jLabel59.setText("Total  ");
        jPanel12.add(jLabel59);
        jLabel59.setBounds(30, 360, 110, 20);

        jtxtTotalAmountOtherCompanyPlant2.setEditable(false);
        jtxtTotalAmountOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtTotalAmountOtherCompanyPlant2);
        jtxtTotalAmountOtherCompanyPlant2.setBounds(170, 360, 160, 20);

        jLabel60.setText("Tax  ");
        jPanel12.add(jLabel60);
        jLabel60.setBounds(30, 390, 110, 20);

        jtxtTaxAmountOtherCompanyPlant2.setEditable(false);
        jtxtTaxAmountOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtTaxAmountOtherCompanyPlant2);
        jtxtTaxAmountOtherCompanyPlant2.setBounds(170, 390, 160, 20);

        jLabel61.setText("No Pajak  ");
        jPanel12.add(jLabel61);
        jLabel61.setBounds(340, 330, 110, 20);

        jLabel62.setText("Disc  ");
        jPanel12.add(jLabel62);
        jLabel62.setBounds(340, 360, 100, 20);

        jLabel63.setText("After Tax  ");
        jPanel12.add(jLabel63);
        jLabel63.setBounds(340, 390, 120, 20);
        jPanel12.add(jtxtNoFakturPajakOtherCompanyPlant2);
        jtxtNoFakturPajakOtherCompanyPlant2.setBounds(460, 330, 180, 20);

        jtxtDiscAmountOtherCompanyPlant2.setEditable(false);
        jtxtDiscAmountOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtDiscAmountOtherCompanyPlant2);
        jtxtDiscAmountOtherCompanyPlant2.setBounds(460, 360, 180, 20);

        jtxtAfterTaxAmountOtherCompanyPlant2.setEditable(false);
        jtxtAfterTaxAmountOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtAfterTaxAmountOtherCompanyPlant2);
        jtxtAfterTaxAmountOtherCompanyPlant2.setBounds(460, 390, 180, 20);

        jLabel64.setText("Tgl Invoice ");
        jPanel12.add(jLabel64);
        jLabel64.setBounds(660, 330, 120, 20);

        jLabel65.setText("Before Tax  ");
        jPanel12.add(jLabel65);
        jLabel65.setBounds(660, 360, 120, 20);

        jtxtTanggalOtherCompanyPlant2.setText("2020-01-01");
        jPanel12.add(jtxtTanggalOtherCompanyPlant2);
        jtxtTanggalOtherCompanyPlant2.setBounds(780, 330, 100, 20);

        jtxtBfrTaxAmoutOtherCompanyPlant2.setEditable(false);
        jtxtBfrTaxAmoutOtherCompanyPlant2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel12.add(jtxtBfrTaxAmoutOtherCompanyPlant2);
        jtxtBfrTaxAmoutOtherCompanyPlant2.setBounds(780, 360, 140, 20);

        jbtnSaveOtherCompanyFG.setText("Save OT Produk ");
        jbtnSaveOtherCompanyFG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveOtherCompanyFGActionPerformed(evt);
            }
        });
        jPanel12.add(jbtnSaveOtherCompanyFG);
        jbtnSaveOtherCompanyFG.setBounds(660, 390, 130, 23);

        jbtnPrintOTProdukBoxGroup.setText("Print OT Produk (Box-Sum)");
        jbtnPrintOTProdukBoxGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintOTProdukBoxGroupActionPerformed(evt);
            }
        });
        jPanel12.add(jbtnPrintOTProdukBoxGroup);
        jbtnPrintOTProdukBoxGroup.setBounds(440, 280, 200, 23);

        jbtnPrintOTProdukBox.setText("Print OT Produk (Box)");
        jbtnPrintOTProdukBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintOTProdukBoxActionPerformed(evt);
            }
        });
        jPanel12.add(jbtnPrintOTProdukBox);
        jbtnPrintOTProdukBox.setBounds(230, 280, 200, 23);

        jbtnPrintOTProduk.setText("Print OT Produk");
        jbtnPrintOTProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintOTProdukActionPerformed(evt);
            }
        });
        jPanel12.add(jbtnPrintOTProduk);
        jbtnPrintOTProduk.setBounds(20, 280, 200, 23);

        jTabbedPane1.addTab("Other Companies (Plant 2) - FG", jPanel12);

        jPanel13.setLayout(null);

        jLabel66.setText("Company ");
        jPanel13.add(jLabel66);
        jLabel66.setBounds(40, 10, 110, 20);

        jtxtKodeOtherManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtKodeOtherManualActionPerformed(evt);
            }
        });
        jtxtKodeOtherManual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtKodeOtherManualKeyPressed(evt);
            }
        });
        jPanel13.add(jtxtKodeOtherManual);
        jtxtKodeOtherManual.setBounds(150, 10, 70, 20);
        jPanel13.add(jtxtNamaOtherManual);
        jtxtNamaOtherManual.setBounds(270, 10, 370, 20);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Total ");
        jPanel13.add(jLabel67);
        jLabel67.setBounds(640, 10, 90, 20);

        jtxtTotalOtherManual.setEditable(false);
        jtxtTotalOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtTotalOtherManual);
        jtxtTotalOtherManual.setBounds(740, 10, 180, 20);

        jtblOtherManual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Dok", "Tgl Dokumen", "Kode Produk", "Nama Produk", "Jumlah", "Satuan", "Harga Faktur", "Value", "Discount", "Total", "Isi", "Box", "Harga Box", "NoGr", "Reff"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true, false, true, true, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblOtherManual.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblOtherManual.setRowSelectionAllowed(false);
        jtblOtherManual.getTableHeader().setReorderingAllowed(false);
        jtblOtherManual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblOtherManualPropertyChange(evt);
            }
        });
        jtblOtherManual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblOtherManualKeyPressed(evt);
            }
        });
        jScrollPane12.setViewportView(jtblOtherManual);
        if (jtblOtherManual.getColumnModel().getColumnCount() > 0) {
            jtblOtherManual.getColumnModel().getColumn(0).setMinWidth(120);
            jtblOtherManual.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblOtherManual.getColumnModel().getColumn(1).setMinWidth(100);
            jtblOtherManual.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblOtherManual.getColumnModel().getColumn(2).setMinWidth(150);
            jtblOtherManual.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblOtherManual.getColumnModel().getColumn(3).setMinWidth(300);
            jtblOtherManual.getColumnModel().getColumn(3).setPreferredWidth(300);
            jtblOtherManual.getColumnModel().getColumn(4).setMinWidth(80);
            jtblOtherManual.getColumnModel().getColumn(4).setPreferredWidth(80);
            jtblOtherManual.getColumnModel().getColumn(5).setMinWidth(60);
            jtblOtherManual.getColumnModel().getColumn(5).setPreferredWidth(60);
            jtblOtherManual.getColumnModel().getColumn(6).setMinWidth(150);
            jtblOtherManual.getColumnModel().getColumn(6).setPreferredWidth(150);
            jtblOtherManual.getColumnModel().getColumn(7).setMinWidth(150);
            jtblOtherManual.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblOtherManual.getColumnModel().getColumn(9).setMinWidth(200);
            jtblOtherManual.getColumnModel().getColumn(9).setPreferredWidth(200);
        }

        jPanel13.add(jScrollPane12);
        jScrollPane12.setBounds(30, 70, 890, 200);

        jLabel68.setText("NO Invoice ");
        jPanel13.add(jLabel68);
        jLabel68.setBounds(30, 310, 140, 20);

        jLabel69.setText("Total  ");
        jPanel13.add(jLabel69);
        jLabel69.setBounds(30, 340, 110, 20);

        jLabel70.setText("Tax  ");
        jPanel13.add(jLabel70);
        jLabel70.setBounds(30, 370, 110, 20);
        jPanel13.add(jtxtNoInvoiceOtherManual);
        jtxtNoInvoiceOtherManual.setBounds(170, 310, 160, 20);

        jtxtTotalAmountOtherManual.setEditable(false);
        jtxtTotalAmountOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtTotalAmountOtherManual);
        jtxtTotalAmountOtherManual.setBounds(170, 340, 160, 20);

        jtxtTaxAmountOtherManual.setEditable(false);
        jtxtTaxAmountOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtTaxAmountOtherManual);
        jtxtTaxAmountOtherManual.setBounds(170, 370, 160, 20);

        jLabel71.setText("No Pajak  ");
        jPanel13.add(jLabel71);
        jLabel71.setBounds(340, 310, 110, 20);

        jLabel72.setText("Disc  ");
        jPanel13.add(jLabel72);
        jLabel72.setBounds(340, 340, 100, 20);

        jLabel73.setText("After Tax  ");
        jPanel13.add(jLabel73);
        jLabel73.setBounds(340, 370, 120, 20);
        jPanel13.add(jtxtNoFakturPajakOtherManual);
        jtxtNoFakturPajakOtherManual.setBounds(460, 310, 180, 20);

        jtxtDiscAmountOtherManual.setEditable(false);
        jtxtDiscAmountOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtDiscAmountOtherManual);
        jtxtDiscAmountOtherManual.setBounds(460, 340, 180, 20);

        jtxtAfterTaxAmountOtherManual.setEditable(false);
        jtxtAfterTaxAmountOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtAfterTaxAmountOtherManual);
        jtxtAfterTaxAmountOtherManual.setBounds(460, 370, 180, 20);

        jLabel74.setText("Tgl Invoice ");
        jPanel13.add(jLabel74);
        jLabel74.setBounds(660, 310, 120, 20);

        jtxtTanggalOtherManual.setText("2020-01-01");
        jPanel13.add(jtxtTanggalOtherManual);
        jtxtTanggalOtherManual.setBounds(780, 310, 100, 20);

        jLabel75.setText("Before Tax  ");
        jPanel13.add(jLabel75);
        jLabel75.setBounds(660, 340, 120, 20);

        jtxtBfrTaxAmoutOtherManual.setEditable(false);
        jtxtBfrTaxAmoutOtherManual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel13.add(jtxtBfrTaxAmoutOtherManual);
        jtxtBfrTaxAmoutOtherManual.setBounds(780, 340, 140, 20);

        jbtnSaveOtherManual.setText("Save Manual ");
        jbtnSaveOtherManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveOtherManualActionPerformed(evt);
            }
        });
        jPanel13.add(jbtnSaveOtherManual);
        jbtnSaveOtherManual.setBounds(660, 370, 130, 23);

        jbtnBrowseCompany.setText("...");
        jbtnBrowseCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseCompanyActionPerformed(evt);
            }
        });
        jPanel13.add(jbtnBrowseCompany);
        jbtnBrowseCompany.setBounds(220, 10, 40, 20);

        jchkBoxProduk.setSelected(true);
        jchkBoxProduk.setText("Produk ");
        jchkBoxProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jchkBoxProdukMouseClicked(evt);
            }
        });
        jchkBoxProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkBoxProdukActionPerformed(evt);
            }
        });
        jPanel13.add(jchkBoxProduk);
        jchkBoxProduk.setBounds(30, 40, 150, 23);

        jbtnPrintOTManual.setText("Print OT Manual");
        jbtnPrintOTManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintOTManualActionPerformed(evt);
            }
        });
        jPanel13.add(jbtnPrintOTManual);
        jbtnPrintOTManual.setBounds(30, 280, 180, 23);

        jTabbedPane1.addTab("Manual", jPanel13);

        jPanel11.setLayout(null);

        jtblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Ready to Create", "Company", "No Invoice", "No Faktur", "Tanggal", "Total Amount", "Disc Amount", "Before Amount", "Tax Amount", "After Amount", "Acount Mgr", "Status", "Base Batchno", "Base Entry"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblInvoice.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblInvoice.setColumnSelectionAllowed(true);
        jtblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblInvoiceMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtblInvoice);
        jtblInvoice.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtblInvoice.getColumnModel().getColumnCount() > 0) {
            jtblInvoice.getColumnModel().getColumn(0).setMinWidth(0);
            jtblInvoice.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblInvoice.getColumnModel().getColumn(1).setMinWidth(100);
            jtblInvoice.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblInvoice.getColumnModel().getColumn(1).setMaxWidth(100);
            jtblInvoice.getColumnModel().getColumn(2).setMinWidth(70);
            jtblInvoice.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtblInvoice.getColumnModel().getColumn(3).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(4).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(5).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(6).setMinWidth(200);
            jtblInvoice.getColumnModel().getColumn(6).setPreferredWidth(200);
            jtblInvoice.getColumnModel().getColumn(7).setMinWidth(100);
            jtblInvoice.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(8).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(8).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(9).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(10).setMinWidth(150);
            jtblInvoice.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtblInvoice.getColumnModel().getColumn(11).setMinWidth(250);
            jtblInvoice.getColumnModel().getColumn(11).setPreferredWidth(250);
            jtblInvoice.getColumnModel().getColumn(12).setMinWidth(80);
            jtblInvoice.getColumnModel().getColumn(12).setPreferredWidth(80);
            jtblInvoice.getColumnModel().getColumn(12).setMaxWidth(80);
            jtblInvoice.getColumnModel().getColumn(13).setMinWidth(120);
            jtblInvoice.getColumnModel().getColumn(13).setPreferredWidth(120);
            jtblInvoice.getColumnModel().getColumn(13).setMaxWidth(120);
        }

        jPanel11.add(jScrollPane10);
        jScrollPane10.setBounds(20, 10, 910, 370);

        jbtnRefreshInvoice.setText("Refresh");
        jbtnRefreshInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRefreshInvoiceActionPerformed(evt);
            }
        });
        jPanel11.add(jbtnRefreshInvoice);
        jbtnRefreshInvoice.setBounds(20, 390, 100, 23);

        jbtnCreateARInv.setText("Creat AR Invoice");
        jbtnCreateARInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateARInvActionPerformed(evt);
            }
        });
        jPanel11.add(jbtnCreateARInv);
        jbtnCreateARInv.setBounds(140, 390, 130, 23);

        jchkautobatchno.setSelected(true);
        jchkautobatchno.setText("Autonumber Batch No");
        jchkautobatchno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkautobatchnoActionPerformed(evt);
            }
        });
        jPanel11.add(jchkautobatchno);
        jchkautobatchno.setBounds(280, 390, 160, 23);

        jtxtarinvbatchno.setEditable(false);
        jPanel11.add(jtxtarinvbatchno);
        jtxtarinvbatchno.setBounds(440, 390, 80, 20);

        jbtnbrowsearbatch.setText("...");
        jbtnbrowsearbatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnbrowsearbatchActionPerformed(evt);
            }
        });
        jPanel11.add(jbtnbrowsearbatch);
        jbtnbrowsearbatch.setBounds(530, 390, 40, 20);

        jtxtdescarinvobatchlist.setEditable(false);
        jPanel11.add(jtxtdescarinvobatchlist);
        jtxtdescarinvobatchlist.setBounds(580, 390, 190, 20);

        jTabbedPane1.addTab("List Invoice", jPanel11);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 80, 960, 530);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Invoice Validation");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 0, 330, 40);

        jlblBulan.setText("Bulan");
        getContentPane().add(jlblBulan);
        jlblBulan.setBounds(30, 40, 50, 20);

        getContentPane().add(jcmbBulan);
        jcmbBulan.setBounds(80, 40, 180, 20);

        jlblTahun.setText("Tahun");
        getContentPane().add(jlblTahun);
        jlblTahun.setBounds(290, 40, 50, 20);

        jbtnShow.setText("Show");
        jbtnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnShow);
        jbtnShow.setBounds(420, 40, 70, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Acoount Manager");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(640, 40, 140, 14);

        jtxtAccountManager.setText("Herlina Dharma, SE");
        getContentPane().add(jtxtAccountManager);
        jtxtAccountManager.setBounds(790, 40, 180, 20);

        getContentPane().add(jcmbTahun);
        jcmbTahun.setBounds(340, 40, 70, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnShowActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        
        loadInvoice();
        
        setCursor(GlobalUtils.NORMALCURSOR);
        
        bload=true;


    }//GEN-LAST:event_jbtnShowActionPerformed

    private void jbtnRefreshInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRefreshInvoiceActionPerformed
        loadListInvoice();
    }//GEN-LAST:event_jbtnRefreshInvoiceActionPerformed

    private void jbtnPrintOTManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintOTManualActionPerformed
        // TODO add your handling code here:

        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetail.jrxml";

        String company = jtxtKodeOtherManual.getText();

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", company);

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintOTManualActionPerformed

    private void jchkBoxProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkBoxProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jchkBoxProdukActionPerformed

    private void jchkBoxProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jchkBoxProdukMouseClicked
        if (jchkBoxProduk.isSelected()) {
            jtblOtherManual.getColumnModel().getColumn(3).setHeaderValue("Kode Produk");
            jtblOtherManual.getColumnModel().getColumn(4).setHeaderValue("Nama Produk");
        }else{
            jtblOtherManual.getColumnModel().getColumn(3).setHeaderValue("Kode Bahan");
            jtblOtherManual.getColumnModel().getColumn(4).setHeaderValue("Nama Bahan");
        }
        jtblOtherManual.getTableHeader().repaint();
        tmodelothermanual.addRow(dataothermanual);
    }//GEN-LAST:event_jchkBoxProdukMouseClicked

    private void jbtnBrowseCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseCompanyActionPerformed

        try {

            Masterrekanans brs = new Masterrekanans();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setFirstValue(jtxtKodeOtherManual);
            bd.setSecondValue(jtxtNamaOtherManual);
            bd.setModal(true);
            bd.setVisible(true);
            loadOtherManual();

        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtnBrowseCompanyActionPerformed

    private void jbtnSaveOtherManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveOtherManualActionPerformed
        saveInvoiceOtherManual();

    }//GEN-LAST:event_jbtnSaveOtherManualActionPerformed

    private void jtblOtherManualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblOtherManualKeyPressed
        int row = jtblOtherManual.getSelectedRow();
        int col = jtblOtherManual.getSelectedColumn();

        if ( evt.getKeyCode() == 157) {
            evt.consume();

        }

        if (evt.getKeyCode() == evt.VK_ENTER) {
            evt.consume();
            if (col < jtblOtherManual.getColumnCount() - 1) {
                GlobalUtils.selectCellTable(jtblOtherManual, row, col + 1);
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
            System.out.println(evt.getKeyCode() == KeyEvent.VK_F5);
            System.out.print(col);
            switch (col) {
                case 2:

                if(jchkBoxProduk.isSelected()) {
                    try{
                        Masterproduks brs = new Masterproduks();
                        FrmBrowse bd = new FrmBrowse(tmodelothermanual, brs, row, 2);
                        bd.retrieveData();
                        bd.setModal(true);
                        bd.setVisible(true);

                        Masterproduk masterproduk = new Masterproduk((tmodelothermanual.getValueAt(row, 2) + "").replace("-", ""));
                        if (masterproduk.getID() > 0) {
                            tmodelothermanual.setValueAt(masterproduk.getNamaProduk(), row, 3);
                            tmodelothermanual.setValueAt(masterproduk.getSatuan(), row, 5);
                            tmodelothermanual.setValueAt(masterproduk.getHargaFaktur() == 0 ? masterproduk.getHargaStandard(): masterproduk.getHargaFaktur(), row, 6);
                            tmodelothermanual.setValueAt(masterproduk.getIsi(), row, 10);
                        }else{
                            tmodelothermanual.setValueAt("", row, 3);
                            tmodelothermanual.setValueAt("", row, 5);
                            tmodelothermanual.setValueAt(0, row, 6);
                            tmodelothermanual.setValueAt(1, row,10);
                        }
                    }catch(Exception ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try{

                        Masterbahan Masterbahan = new Masterbahan((tmodelothermanual.getValueAt(row, 2) + "").replace("-", ""));
                        if (Masterbahan.getID() > 0) {
                            tmodelothermanual.setValueAt(Masterbahan.getNamaBahan(), row, 3);
                            tmodelothermanual.setValueAt(Masterbahan.getSatuan(), row, 5);
                            tmodelothermanual.setValueAt(Masterbahan.getHargaJual() == 0 ? Masterbahan.getHargaStandard(): Masterbahan.getHargaJual(), row, 7);
                            tmodelothermanual.setValueAt(1, row, 11);

                        }else{
                            tmodelothermanual.setValueAt("", row, 3);
                            tmodelothermanual.setValueAt("", row, 5);
                            tmodelothermanual.setValueAt(0, row, 6);
                            tmodelothermanual.setValueAt("", row, 10);
                        }
                    }catch(Exception ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                break;

            }
        }
    }//GEN-LAST:event_jtblOtherManualKeyPressed

    private void jtblOtherManualPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblOtherManualPropertyChange
        int row = jtblOtherManual.getSelectedRow();
        int col = jtblOtherManual.getSelectedColumn();

        if (row > -1 ) {
            if (col == 2) {
                if(jchkBoxProduk.isSelected()) {
                    try{
                        Masterproduk masterproduk = new Masterproduk((tmodelothermanual.getValueAt(row, 2) + "").replace("-", ""));
                        if (masterproduk.getID() > 0) {
                            tmodelothermanual.setValueAt(masterproduk.getNamaProduk(), row, 3);
                            tmodelothermanual.setValueAt(masterproduk.getSatuan(), row, 5);
                            tmodelothermanual.setValueAt(masterproduk.getHargaFaktur() == 0 ? masterproduk.getHargaStandard(): masterproduk.getHargaFaktur(), row, 6);
                            tmodelothermanual.setValueAt(masterproduk.getIsi(), row, 10);
                        }else{
                            tmodelothermanual.setValueAt("", row, 3);
                            tmodelothermanual.setValueAt("", row, 5);
                            tmodelothermanual.setValueAt(0, row, 6);
                            tmodelothermanual.setValueAt(1, row,10);
                        }
                    }catch(Exception ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try{

                        Masterbahan Masterbahan = new Masterbahan((tmodelothermanual.getValueAt(row, 3) + "").replace("-", ""));
                        if (Masterbahan.getID() > 0) {
                            tmodelothermanual.setValueAt(Masterbahan.getNamaBahan(), row, 4);
                            tmodelothermanual.setValueAt(Masterbahan.getSatuan(), row, 6);
                            tmodelothermanual.setValueAt(Masterbahan.getHargaJual() == 0 ? Masterbahan.getHargaStandard(): Masterbahan.getHargaJual(), row, 7);
                            tmodelothermanual.setValueAt(1, row, 11);

                        }else{
                            tmodelothermanual.setValueAt("", row, 4);
                            tmodelothermanual.setValueAt("", row, 6);
                            tmodelothermanual.setValueAt(0, row, 7);
                            tmodelothermanual.setValueAt(1, row, 11);
                        }
                    }catch(Exception ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }else if (col ==4 || col == 8) {
                Double jumlah = tmodelothermanual.getValueAt(row, 4) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(row, 4)+"");
                Double harga = tmodelothermanual.getValueAt(row, 6) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(row, 6)+"");
                Double value = jumlah * harga;
                Double discount = tmodelothermanual.getValueAt(row, 8) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(row, 8)+"");
                Double total = value - discount;
                Double isi = tmodelothermanual.getValueAt(row, 10) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(row, 10)+"");
                Double box =  jumlah / isi;
                Double hargabox = harga * isi;
                tmodelothermanual.setValueAt(value, row, 7);
                tmodelothermanual.setValueAt(discount, row, 8);
                tmodelothermanual.setValueAt(total, row, 9);
                tmodelothermanual.setValueAt(box, row, 11);
                tmodelothermanual.setValueAt(hargabox, row, 12);
                System.out.println("nomor 7 "  + value);

                Double totalvalue = 0.0D;
                Double totaldiscount = 0.0D;
                for(int i=0; i< tmodelothermanual.getRowCount();i++){
                    Double valuerow = tmodelothermanual.getValueAt(i, 7) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(i, 7)+"");
                    Double discrow = tmodelothermanual.getValueAt(i, 8) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(i, 8)+"");

                    totaldiscount += discrow;
                    totalvalue += valuerow;
                }

                jtxtTotalOtherManual.setText(GlobalUtils.formatnumber(totalvalue));
                jtxtTotalAmountOtherManual.setText(jtxtTotalOtherManual.getText());
                jtxtDiscAmountOtherManual.setText( GlobalUtils.formatnumber(totaldiscount));
                jtxtBfrTaxAmoutOtherManual.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountOtherManual.getText().replace(",", "")) - Double.parseDouble(jtxtDiscAmountOtherManual.getText().replace(",", ""))));
                jtxtTaxAmountOtherManual.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtBfrTaxAmoutOtherManual.getText().replace(",", "")) * 0.1));
                jtxtAfterTaxAmountOtherManual.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtBfrTaxAmoutOtherManual.getText().replace(",", "")) * 1.1));

                Double jumlahterakhir = tmodelothermanual.getValueAt(tmodelothermanual.getRowCount() -1, 4) == null ? 0 : Double.parseDouble(tmodelothermanual.getValueAt(tmodelothermanual.getRowCount() -1, 4)+"");
                if(jumlahterakhir > 0) {
                    tmodelothermanual.addRow(dataothermanual);
                    String nomordokumen = tmodelothermanual.getValueAt(jtblOtherManual.getRowCount()-2, 0) == null ? "" : tmodelothermanual.getValueAt(jtblOtherManual.getRowCount()-2, 0)+"";
                    tmodelothermanual.setValueAt(nomordokumen, jtblOtherManual.getRowCount()-1, 0) ;
                    String tanggaldokumen = tmodelothermanual.getValueAt(jtblOtherManual.getRowCount()-2, 1) == null ? "" : tmodelothermanual.getValueAt(jtblOtherManual.getRowCount()-2, 1)+"";
                    tmodelothermanual.setValueAt(tanggaldokumen, jtblOtherManual.getRowCount()-1, 1);
                    GlobalUtils.selectCellTable(jtblOtherManual, jtblOtherManual.getRowCount()-1, 0);
                }

            }

        }
    }//GEN-LAST:event_jtblOtherManualPropertyChange

    private void jtxtKodeOtherManualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtKodeOtherManualKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loadOtherManual();
        }
    }//GEN-LAST:event_jtxtKodeOtherManualKeyPressed

    private void jtxtKodeOtherManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtKodeOtherManualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtKodeOtherManualActionPerformed

    private void jbtnPrintOTProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintOTProdukActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailothercompanyFG.jrxml";
        String company[] = (jcmbOtherCompanyPlant2.getSelectedItem()+"").split("-");

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", company[0]);

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintOTProdukActionPerformed

    private void jbtnPrintOTProdukBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintOTProdukBoxActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailothercompanyFGBox.jrxml";
        String company[] = (jcmbOtherCompanyPlant2.getSelectedItem()+"").split("-");

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", company[0]);

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintOTProdukBoxActionPerformed

    private void jbtnPrintOTProdukBoxGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintOTProdukBoxGroupActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailothercompanyFGBoxGroup.jrxml";
        String company[] = (jcmbOtherCompanyPlant2.getSelectedItem()+"").split("-");

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", company[0]);

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintOTProdukBoxGroupActionPerformed

    private void jbtnSaveOtherCompanyFGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveOtherCompanyFGActionPerformed
        saveInvoiceOtherCompanyPlant2();
    }//GEN-LAST:event_jbtnSaveOtherCompanyFGActionPerformed

    private void jtblOtherCompanyPlant2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblOtherCompanyPlant2PropertyChange
        int irow=jtblOtherCompanyPlant2.getSelectedRow();
        int icol=jtblOtherCompanyPlant2.getSelectedColumn();

        if (irow > -1 && (icol == 8 || icol == 13 || icol == 14 ) ) {
            String nomordokumen = (String) jtblOtherCompanyPlant2.getValueAt(irow, 0);
            String kodeproduk = (String) jtblOtherCompanyPlant2.getValueAt(irow, 4);
            String hargastandard = jtblOtherCompanyPlant2.getValueAt(irow, 8) + "";
            String noGR = jtblOtherCompanyPlant2.getValueAt(irow, 13) + "";
            String reff = jtblOtherCompanyPlant2.getValueAt(irow, 14) + "";

            invvald.saveRevisiDetailOtherCompanyPlant2(nomordokumen, kodeproduk, hargastandard, noGR, reff);
            loadInvoiceOtherCompanyPlant2();
            loadDetailOtherCompanyPlant2();
            loadSummaryOtherCompaniesPlant2();
        }
    }//GEN-LAST:event_jtblOtherCompanyPlant2PropertyChange

    private void jcmbOtherCompanyPlant2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant2PropertyChange

    private void jcmbOtherCompanyPlant2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant2ActionPerformed

    private void jcmbOtherCompanyPlant2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant2MouseClicked

    private void jcmbOtherCompanyPlant2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant2MouseReleased

    private void jcmbOtherCompanyPlant2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant2ItemStateChanged

    private void jbtnPrintOTBahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintOTBahanActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetail.jrxml";

        String company[] = (jcmbOtherCompanyPlant1.getSelectedItem()+"").split("-");

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", company[0]);

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintOTBahanActionPerformed

    private void jbtnSaveOtherCompanyPlant1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveOtherCompanyPlant1ActionPerformed

        saveInvoiceOtherCompanyPlant1();
    }//GEN-LAST:event_jbtnSaveOtherCompanyPlant1ActionPerformed

    private void jtblOtherCompanyPlant1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblOtherCompanyPlant1PropertyChange
        int irow=jtblOtherCompanyPlant1.getSelectedRow();
        int icol=jtblOtherCompanyPlant1.getSelectedColumn();

        if (irow > -1 && icol == 8 ) {
            String nomordokumen = (String) jtblOtherCompanyPlant1.getValueAt(irow, 0);
            String kodebahan = (String) jtblOtherCompanyPlant1.getValueAt(irow, 4);
            String hargastandard = jtblOtherCompanyPlant1.getValueAt(irow, 8) + "";

            invvald.saveRevisiDetailOtherCompanyPlant1(nomordokumen, kodebahan, hargastandard);
            loadInvoiceOtherCompanyPlant1();
            loadDetailOtherCompanyPlant1();
            loadSummaryOtherCompaniesPlant1();

        }
    }//GEN-LAST:event_jtblOtherCompanyPlant1PropertyChange

    private void jcmbOtherCompanyPlant1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant1PropertyChange

    }//GEN-LAST:event_jcmbOtherCompanyPlant1PropertyChange

    private void jcmbOtherCompanyPlant1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbOtherCompanyPlant1ActionPerformed

    private void jcmbOtherCompanyPlant1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant1MouseClicked

    }//GEN-LAST:event_jcmbOtherCompanyPlant1MouseClicked

    private void jcmbOtherCompanyPlant1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant1MouseReleased

    }//GEN-LAST:event_jcmbOtherCompanyPlant1MouseReleased

    private void jcmbOtherCompanyPlant1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbOtherCompanyPlant1ItemStateChanged
        if(bload) {
            loadSummaryOtherCompaniesPlant1();
            loadDetailOtherCompanyPlant1();
        }
    }//GEN-LAST:event_jcmbOtherCompanyPlant1ItemStateChanged

    private void jbtnPrintCPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintCPPActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailcpp.jrxml";

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", "SAI");

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintCPPActionPerformed

    private void jbtnSaveCPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveCPPActionPerformed

        saveInvoiceCPP();

    }//GEN-LAST:event_jbtnSaveCPPActionPerformed

    private void jtxtTotalCPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTotalCPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTotalCPPActionPerformed

    private void jbtnPrintBBCDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintBBCDFActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailCDF.jrxml";

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", "BBCDF");

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintBBCDFActionPerformed

    private void jbtnSaveBBCDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveBBCDFActionPerformed

        saveInvoiceBBCDF();

    }//GEN-LAST:event_jbtnSaveBBCDFActionPerformed

    private void jtblCDFBBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblCDFBBPropertyChange
        int irow=jtblCDFBB.getSelectedRow();
        int icol=jtblCDFBB.getSelectedColumn();

        if (irow > -1 && icol == 8 ) {
            String nomordokumen = (String) jtblCDFBB.getValueAt(irow, 0);
            String kodebahan = (String) jtblCDFBB.getValueAt(irow, 4);
            String hargastandard = jtblCDFBB.getValueAt(irow, 8) + "";

            invvald.saveRevisiDetailCDF(nomordokumen, kodebahan, hargastandard);
            loadInvoiceBBCDF();
        }
    }//GEN-LAST:event_jtblCDFBBPropertyChange

    private void jbtnPrintBKCDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintBKCDFActionPerformed
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailCDF.jrxml";

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", "BKCDF");

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintBKCDFActionPerformed

    private void jbtnSaveBKCDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveBKCDFActionPerformed

        saveInvoiceBKCDF();

    }//GEN-LAST:event_jbtnSaveBKCDFActionPerformed

    private void jtblCDFBKPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblCDFBKPropertyChange
        int irow=jtblCDFBK.getSelectedRow();
        int icol=jtblCDFBK.getSelectedColumn();

        if (irow > -1 && icol == 8 ) {
            String nomordokumen = (String) jtblCDFBK.getValueAt(irow, 0);
            String kodebahan = (String) jtblCDFBK.getValueAt(irow, 4);
            String hargastandard = jtblCDFBK.getValueAt(irow, 8) + "";

            invvald.saveRevisiDetailCDF(nomordokumen, kodebahan, hargastandard);
            loadInvoiceBKCDF();

        }
    }//GEN-LAST:event_jtblCDFBKPropertyChange

    private void jbtnSaveSAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveSAIActionPerformed
        //        if(jtxtValueSAIHJP.getText().equals(jtxtValueMBHJP.getText())
            //                && jtxtValueSAIHPD.getText().equals(jtxtValueMBHPD.getText())
            //                && !jtxtNoInvoiceSAI.getText().equals("")
            //                ){
            saveInvoiceSAI();
            //        }else{
            //            JOptionPane.showMessageDialog(null, "Nilai SAI dan MB Belum Sama, Tolong disamakan terlebih dahulu dan atau No Invoice Kosong");
            //        }

    }//GEN-LAST:event_jbtnSaveSAIActionPerformed

    private void jbtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRefreshActionPerformed
        //3  kdMB
        //10 hpd
        //12 hjp

        // call sp_itemprice_mb_update('MI151900011S','HJP',31818,'Admin');
        // call sp_itemprice_mb_update('MI151900011S','HPD',45455,'Admin');

        int rows = jtblDetailSAIMBVariance.getRowCount();
        for (int i = 0; i < rows; i ++){
            String kdMb = jtblDetailSAIMBVariance.getValueAt(i, 3)+"";
            Double dhpd = Double.parseDouble(jtblDetailSAIMBVariance.getValueAt(i, 10)+"");
            Double dhjp = Double.parseDouble(jtblDetailSAIMBVariance.getValueAt(i, 12)+"");
            String sUser = "Admin";

            boolean bsave = invvald.sp_itemprice_mb_update(kdMb, dhjp, dhpd);
            if(bsave){
                JOptionPane.showMessageDialog(null, "Saved");
            }else{
                JOptionPane.showMessageDialog(null, "Failed to Save");
            }

        }

    }//GEN-LAST:event_jbtnRefreshActionPerformed

    private void jbtnResetSAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetSAIActionPerformed

        try {
            DbBeanWMS dwms =  DbBeanWMS.connect();

            String sql = "CALL mb.sp_update_naik_harga_mb_dari_sai('Update Harga" + GlobalUtils.getUserId()+ "')";
            dwms.doexecute(sql);

            sql = "Call mb.spTarik_SalesToTable(" + jcmbTahun.getSelectedItem()+"" + ", " + (jcmbBulan.getSelectedIndex() + 1) + ") ";

            dwms.doexecute(sql);
            dwms.close();

            JOptionPane.showMessageDialog(null, "Update Harga Dari SAI ke MB Telah Selesai dilakukan");

        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtnResetSAIActionPerformed

    private void jbtnPrintDetailSAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintDetailSAIActionPerformed

        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicedetailsai.jrxml";

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", "SAI");

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);
    }//GEN-LAST:event_jbtnPrintDetailSAIActionPerformed

    private void jbtnPrintBrandSaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintBrandSaIActionPerformed

        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String file = GlobalUtils.getCurrentDir() +"/Reports/invoice/invoicebrandsai.jrxml";

        Map parameter = new HashMap();
        parameter.put("pYop",jcmbTahun.getSelectedItem()+"");
        parameter.put("pMop",jcmbBulan.getSelectedIndex()+1+"");
        parameter.put("pCompany", "SAI");

        GlobalUtils.printReport(file, parameter, false);

        setCursor(GlobalUtils.NORMALCURSOR);

    }//GEN-LAST:event_jbtnPrintBrandSaIActionPerformed

    private void jbtnSaveCPP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveCPP1ActionPerformed
        saveInvoiceMTS();
    }//GEN-LAST:event_jbtnSaveCPP1ActionPerformed

    private void jbtnPrintMTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintMTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnPrintMTSActionPerformed

    private void jbtnCreateARInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateARInvActionPerformed
        
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksi AR Invoice", "Create AR Invoice", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            int NoBatch;
            if(jchkautobatchno.isSelected()==true){
                NoBatch = 0;
            } else {
                NoBatch = Integer.parseInt(jtxtarinvbatchno.getText());
            }
            
            bsave = invvald.createARInvoice(NoBatch);

            if (bsave) {
                JOptionPane.showMessageDialog(null, "Saved AR Invoice");
            }else{
                JOptionPane.showMessageDialog(null, "Failed Save AR Invoice");
            }            
        }
    }//GEN-LAST:event_jbtnCreateARInvActionPerformed

    private void jtblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblInvoiceMouseClicked
        int irow=jtblInvoice.getSelectedRow();
        int icol=jtblInvoice.getSelectedColumn();

        if (irow > -1 && icol == 1 ) {            
            String id = tmodelInvoice.getValueAt(irow, 0).toString();
            String setCreate = tmodelInvoice.getValueAt(irow, 1).toString();
            String cmpny = tmodelInvoice.getValueAt(irow, 2).toString();
            
            invvald.setCreateInvoice(id,cmpny,setCreate);
        }
    }//GEN-LAST:event_jtblInvoiceMouseClicked

    private void jbtnbrowsearbatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnbrowsearbatchActionPerformed
        try {
            Ar_invbatchlists brs = new Ar_invbatchlists();
            FrmBrowseAR_invoBatchList bd = new FrmBrowseAR_invoBatchList(brs);
            bd.setFirstValue(jtxtarinvbatchno);
            bd.setSecondValue(jtxtdescarinvobatchlist);
            bd.setModal(true); 
            bd.setVisible(true);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnbrowsearbatchActionPerformed

    private void jchkautobatchnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkautobatchnoActionPerformed
        if(jchkautobatchno.isSelected()==true){
            jbtnbrowsearbatch.setEnabled(false);
            jtxtarinvbatchno.setText("");
            jtxtdescarinvobatchlist.setText("");
        } else { 
            jbtnbrowsearbatch.setEnabled(true);
        }
    }//GEN-LAST:event_jchkautobatchnoActionPerformed



    private void loadInvoice(){
        loadSAI();
        loadCDF();
        loadCPP();
        loadMTS();
        
        loadOtherCompaniesPlant1();
        loadOtherCompaniesPlant2();
        
        loadListInvoice();
    } 
    
    private void loadSAI() {
        /*SAI*/
        loadSummaryMBHJP();
        loadSummarySAIHJP();
        loadSummaryMBHPD();
        loadSummarySAIHPD();

        loadSummaryByBrandMB();
        loadSummaryByBrandSAI();
        loadDetailMB();
        loadDetailSAI();
        loadVarianceBetweenSAIAndMB();
        loadInvoiceSAI();
        
    }
    
    private void loadListInvoice(){
        invvald.getListInvoice(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                tmodelInvoice, 
                                dataInvoice
                                );
        
    }
    
    private boolean cekSetNoInvoice(String cmpnyid){
        //Object[]  objNoInv = new Object[1];
        
        String tahun = jcmbTahun.getSelectedItem()+"";
        String bulan = (jcmbBulan.getSelectedIndex() + 1) + "";
        String noInv = null;
        if(cmpnyid.equals("SAI")){
            noInv = jtxtNoInvoiceSAI.getText();
        } else if(cmpnyid.equals("BB CDF")){
            noInv = jtxtNoInvoiceBBCDF.getText();
        } else if(cmpnyid.equals("BK CDF")){
            noInv = jtxtNoInvoiceBKCDF.getText();
        } else if(cmpnyid.equals("CPP")){
            noInv = jtxtNoInvoiceCPP.getText();
        } else if(cmpnyid.equals("MTS")){
            noInv = jtxtNoInvoiceMTS.getText();
        } else if(cmpnyid.equals("OTH 1")){
            noInv = jtxtNoInvoiceOtherCompanyPlant1.getText();
        } else if(cmpnyid.equals("OTH 2")){
            noInv = jtxtNoInvoiceOtherCompanyPlant2.getText();
        } else if(cmpnyid.equals("Manual")){
            noInv = jtxtNoInvoiceOtherManual.getText();
        }
        
        boolean cek = false;
        try {         
            cek = invvald.cekNoInvoice(tahun,bulan,noInv);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    private void saveInvoiceSAI(){
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksi Invoice SAI", "Save SAI ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("SAI");
            
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceSAI.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {           
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                true,
                                jtxtNoInvoiceSAI.getText(),
                                jtxtNoFakturPajakSAI.getText(),
                                jtxtTanggalSAI.getText(),
                                Double.parseDouble(jtxtTotalAmountSAI.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountSAI.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutSAI.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountSAI.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountSAI.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                "SAI"
                        );

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved SAI");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save SAI");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    private void loadInvoiceSAI() {
        Object[]  objInvoice = new Object[13];
        
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", objInvoice, false);
            //jbtnSaveSAI.setEnabled(!bfound);
//            if(bfound) {
//                jtxtNoInvoiceSAI.setText(objInvoice[3] + "");
//                jtxtNoFakturPajakSAI.setText(objInvoice[4] + "");
//                jtxtTanggalSAI.setText(objInvoice[5] + "");
//                jtxtTotalAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
//                jtxtDiscAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
//                jtxtBfrTaxAmoutSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
//                jtxtTaxAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
//                jtxtAfterTaxAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
//                jtxtAccountManager.setText(objInvoice[11] + "");
//            }else{
//                
                //bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", objInvoice, true);
                if(bfound) {
                    jtxtAccountManager.setText(objInvoice[11]+"");
                }else{
                    jtxtAccountManager.setText("Herlina Dharma, SE");
                }
                
                String noInvSAI = (bfound) ? objInvoice[3]+"" : ".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"";
                jtxtNoInvoiceSAI.setText(noInvSAI);
                jtxtNoFakturPajakSAI.setText("Faktur Pajak SAI");
                
                jtxtTanggalSAI.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultSAIMB();
//            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadResultSAIMB(){
        jtxtTotalAmountSAI.setText(jtxtValueSAIHPD.getText());
        jtxtDiscAmountSAI.setText( GlobalUtils.formatnumber(Double.parseDouble(jtxtValueSAIHPD.getText().replace(",", "")) - Double.parseDouble(jtxtValueSAIHJP.getText().replace(",", ""))));
        jtxtBfrTaxAmoutSAI.setText(jtxtValueMBHJP.getText());
        jtxtTaxAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtValueMBHJP.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountSAI.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtValueMBHJP.getText().replace(",", "")) * 1.1));
    }

    
    private void loadSummaryMBHJP() {
        try {
            jtxtValueMBHJP.setText(invvald.getInvoiceSummary(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "MB", "HJP"));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSummarySAIHJP() {
        try {
            jtxtValueSAIHJP.setText(invvald.getInvoiceSummary(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", "HJP"));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void loadSummaryMBHPD() {
        try {
            jtxtValueMBHPD.setText(invvald.getInvoiceSummary(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "MB", "HPD"));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSummarySAIHPD() {
        try {
            jtxtValueSAIHPD.setText(invvald.getInvoiceSummary(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", "HPD"));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void loadSummaryByBrandMB(){
        try {
            invvald.getInvoiceSummaryByBrand(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "MB", tmodelinvsumMB, datainvsumMB);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadSummaryByBrandSAI(){
        try {
            invvald.getInvoiceSummaryByBrand(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", tmodelinvsumSAI, datainvsumSAI);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void loadDetailMB(){
        try {
            invvald.getInvoiceDetail(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "MB", tmodelinvdetailMB, datainvdetailMB);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadDetailSAI(){
        try {
            invvald.getInvoiceDetail(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "SAI", tmodelinvdetailSAI, datainvdetailSAI);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadVarianceBetweenSAIAndMB() {
        try {        
            invvald.getInvoiceDetailVariance(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "",  tmodelVariance, dataVariance);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCDF() {
        /*CDF*/
        loadDetailCDFBB();
        loadDetailCDFBK();      
        loadSummaryCDF();
        loadInvoiceBBCDF();
        loadInvoiceBKCDF();
    }
    private void saveInvoiceBBCDF(){
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksi Invoice BB CDF ", "Save BB CDF ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("BB CDF");
                        
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceBBCDF.getText().contains("../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                false,
                                jtxtNoInvoiceBBCDF.getText(),
                                jtxtNoFakturPajakBBCDF.getText(),
                                jtxtTanggalBBCDF.getText(),
                                Double.parseDouble(jtxtTotalAmountBBCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountBBCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutBBCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountBBCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountBBCDF.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                "BBCDF"
                        );
                        bsave = invvald.saveInvoiceCDF(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                jtxtNoInvoiceBBCDF.getText(),
                                "BB");

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved BB CDF");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save BB CDF");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void saveInvoiceBKCDF(){
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksi Invoice BK CDF ", "Save BK CDF ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("BK CDF");
                        
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceBKCDF.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                false,
                                jtxtNoInvoiceBKCDF.getText(),
                                jtxtNoFakturPajakBKCDF.getText(),
                                jtxtTanggalBKCDF.getText(),
                                Double.parseDouble(jtxtTotalAmountBKCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountBKCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutBKCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountBKCDF.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountBKCDF.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                "BKCDF"
                        );

                        bsave = invvald.saveInvoiceCDF(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                jtxtNoInvoiceBKCDF.getText(),
                                "BK");

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved BK CDF");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save BK CDF");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    private void loadInvoiceBBCDF() {
        Object[]  objInvoice = new Object[13];
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BBCDF", objInvoice, false);
            //jbtnSaveSAI.setEnabled(!bfound);
            if(bfound) {
                jtxtNoInvoiceBBCDF.setText(objInvoice[3] + "");
                jtxtNoFakturPajakBBCDF.setText(objInvoice[4] + "");
                jtxtTanggalBBCDF.setText(objInvoice[5] + "");
                jtxtTotalAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
                jtxtDiscAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
                jtxtBfrTaxAmoutBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
                jtxtTaxAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
                jtxtAfterTaxAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
            }else{

                jtxtNoInvoiceBBCDF.setText(".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"");
                jtxtNoFakturPajakBBCDF.setText("Faktur Pajak BB CDF");
                
                jtxtTanggalBBCDF.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultBBCDF();
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadInvoiceBKCDF() {
        Object[]  objInvoice = new Object[13];
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BKCDF", objInvoice, false);
            //jbtnSaveSAI.setEnabled(!bfound);
            if(bfound) {
                jtxtNoInvoiceBKCDF.setText(objInvoice[3] + "");
                jtxtNoFakturPajakBKCDF.setText(objInvoice[4] + "");
                jtxtTanggalBKCDF.setText(objInvoice[5] + "");
                jtxtTotalAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
                jtxtDiscAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
                jtxtBfrTaxAmoutBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
                jtxtTaxAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
                jtxtAfterTaxAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
            }else{
                
               
                jtxtNoInvoiceBKCDF.setText(".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"");
                jtxtNoFakturPajakBKCDF.setText("Faktur Pajak BK CDF");
                
                jtxtTanggalBKCDF.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultBKCDF();
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void loadResultBKCDF(){
        jtxtTotalAmountBKCDF.setText(jtxtTotalKemasCDF.getText() );
        jtxtDiscAmountBKCDF.setText( "0");
        jtxtBfrTaxAmoutBKCDF.setText(jtxtTotalAmountBKCDF.getText());
        jtxtTaxAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountBKCDF.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountBKCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountBKCDF.getText().replace(",", "")) * 1.1));        
    }
    
    private void loadResultBBCDF(){
        jtxtTotalAmountBBCDF.setText(jtxtTotalBakuCDF.getText() );
        jtxtDiscAmountBBCDF.setText( "0");
        jtxtBfrTaxAmoutBBCDF.setText(jtxtTotalAmountBBCDF.getText());
        jtxtTaxAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountBBCDF.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountBBCDF.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountBBCDF.getText().replace(",", "")) * 1.1));        
    }
    
    private void loadSummaryCDF(){
        try {
            jtxtTotalBakuCDF.setText(invvald.getInvoiceSummaryCDF(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BB") );
            jtxtTotalKemasCDF.setText(invvald.getInvoiceSummaryCDF(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BK") );
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDetailCDFBB() {
        try {
            invvald.getInvoiceCDF(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BB", tmodelCDFBB, datacdfbb);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDetailCDFBK() {
        try {
            invvald.getInvoiceCDF(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "BK", tmodelCDFBK, datacdfbk);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadCPP() {
        /*CPP*/
        loadSummaryCPPHJP();            
        loadDetailCPP(); 
        loadInvoiceCPP();
        
    }
    
    private void saveInvoiceCPP(){
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksin Invoice CPP", "Save CPP ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("CPP");
                        
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceCPP.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                true,
                                jtxtNoInvoiceCPP.getText(),
                                jtxtNoFakturPajakCPP.getText(),
                                jtxtTanggalCPP.getText(),
                                Double.parseDouble(jtxtTotalAmountCPP.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountCPP.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutCPP.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountCPP.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountCPP.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                "CPP"
                        );

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved CPP");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save CPP");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void loadInvoiceCPP() {
        Object[]  objInvoice = new Object[13];
        
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "CPP", objInvoice, false);
            //jbtnSaveCPP.setEnabled(!bfound);
            if(bfound) {
                jtxtNoInvoiceCPP.setText(objInvoice[3] + "");
                jtxtNoFakturPajakCPP.setText(objInvoice[4] + "");
                jtxtTanggalCPP.setText(objInvoice[5] + "");
                jtxtTotalAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
                jtxtDiscAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
                jtxtBfrTaxAmoutCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
                jtxtTaxAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
                jtxtAfterTaxAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
            }else{
                
                
                jtxtNoInvoiceCPP.setText(".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"");
                jtxtNoFakturPajakCPP.setText("Faktur Pajak CPP");
                
                jtxtTanggalCPP.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultCPP();
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadResultCPP(){
        jtxtTotalAmountCPP.setText( jtxtTotalCPP.getText());
        jtxtDiscAmountCPP.setText( "0");
        jtxtBfrTaxAmoutCPP.setText(jtxtTotalAmountCPP.getText());
        jtxtTaxAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountCPP.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountCPP.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountCPP.getText().replace(",", "")) * 1.1));        
    }
    
    private void loadSummaryCPPHJP() {
        try {
            jtxtTotalCPP.setText(invvald.getInvoiceSummary(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "CPP", "HJP"));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDetailCPP(){
        try {
            invvald.getInvoiceDetailCPP(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "",  tmodelCPP, dataCPP);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private void loadOtherCompaniesPlant1(){
        loadComboOtherCompaniesPlant1();
        loadSummaryOtherCompaniesPlant1();
        loadDetailOtherCompanyPlant1();
    }
    private void loadComboOtherCompaniesPlant1(){
        jcmbOtherCompanyPlant1.removeAllItems();
        List<String> list = invvald.addListOtherCompaniesPlant1(jcmbTahun.getSelectedItem()+"",  (jcmbBulan.getSelectedIndex() + 1) + "");
        for(String company : list) {
            jcmbOtherCompanyPlant1.addItem(company);
        }            
    }
    
    private void loadSummaryOtherCompaniesPlant1(){
        try {
            jtxtTotalOtherCompanyPlant1.setText(invvald.getInvoiceSummaryOtherCompaniesPlant1(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", jcmbOtherCompanyPlant1.getSelectedItem()+"") );
            loadInvoiceOtherCompanyPlant1();
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadInvoiceOtherCompanyPlant1() {
        Object[]  objInvoice = new Object[13];
        String[] companylst = (jcmbOtherCompanyPlant1.getSelectedItem() + "").split("-");
        
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", companylst[0], objInvoice, false);
            if(bfound) {
                jtxtNoInvoiceOtherCompanyPlant1.setText(objInvoice[3] + "");
                jtxtNoFakturPajakOtherCompanyPlant1.setText(objInvoice[4] + "");
                jtxtTanggalOtherCompanyPlant1.setText(objInvoice[5] + "");
                jtxtTotalAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
                jtxtDiscAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
                jtxtBfrTaxAmoutOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
                jtxtTaxAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
                jtxtAfterTaxAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
            }else{
                
                jtxtNoInvoiceOtherCompanyPlant1.setText(".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"");
                jtxtNoFakturPajakOtherCompanyPlant1.setText("Faktur Pajak OtherCompany");
                
                jtxtTanggalOtherCompanyPlant1.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultOtherCompanyPlant1();
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadResultOtherCompanyPlant1(){
        jtxtTotalAmountOtherCompanyPlant1.setText( jtxtTotalOtherCompanyPlant1.getText());
        jtxtDiscAmountOtherCompanyPlant1.setText( "0");
        jtxtBfrTaxAmoutOtherCompanyPlant1.setText(jtxtTotalAmountOtherCompanyPlant1.getText());
        jtxtTaxAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountOtherCompanyPlant1.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountOtherCompanyPlant1.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountOtherCompanyPlant1.getText().replace(",", "")) * 1.1));        
    }
    private void loadDetailOtherCompanyPlant1() {
        try {
            invvald.getInvoiceOtherCompaniesPlant1(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", jcmbOtherCompanyPlant1.getSelectedItem() +"", tmodelOtherCompanyPlant1, dataOtherCompanyPlant1);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void saveInvoiceOtherCompanyPlant1(){
        String[] companylst = (jcmbOtherCompanyPlant1.getSelectedItem() + "").split("-");

        int isave = JOptionPane.showConfirmDialog(null,  "Ingin Menyimpan Transaksi " + jcmbOtherCompanyPlant1.getSelectedItem(), "Save  ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("OTH 1");
                        
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceOtherCompanyPlant1.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                false,
                                jtxtNoInvoiceOtherCompanyPlant1.getText(),
                                jtxtNoFakturPajakOtherCompanyPlant1.getText(),
                                jtxtTanggalOtherCompanyPlant1.getText(),
                                Double.parseDouble(jtxtTotalAmountOtherCompanyPlant1.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountOtherCompanyPlant1.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutOtherCompanyPlant1.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountOtherCompanyPlant1.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountOtherCompanyPlant1.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                companylst[0]
                        );
                        bsave = invvald.saveInvoiceOtherCompanyPlant1(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                jtxtNoInvoiceOtherCompanyPlant1.getText(),
                                companylst[0]);

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved  ");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save  ");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void loadOtherCompaniesPlant2(){
        loadComboOtherCompaniesPlant2();
        loadSummaryOtherCompaniesPlant2();
        loadDetailOtherCompanyPlant2();
        loadInvoiceOtherCompanyPlant2();
    }
    private void loadDetailOtherCompanyPlant2() {
        try {
            invvald.getInvoiceOtherCompaniesPlant2(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", jcmbOtherCompanyPlant2.getSelectedItem() +"", tmodelOtherCompanyPlant2, dataOtherCompanyPlant2);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadComboOtherCompaniesPlant2(){
        jcmbOtherCompanyPlant2.removeAllItems();
        List<String> list = invvald.addListOtherCompaniesPlant2(jcmbTahun.getSelectedItem()+"",  (jcmbBulan.getSelectedIndex() + 1) + "");
        for(String company : list) {
            jcmbOtherCompanyPlant2.addItem(company);
        }            
    }
    private void loadSummaryOtherCompaniesPlant2(){
        try {
            jtxtTotalOtherCompanyPlant2.setText(invvald.getInvoiceSummaryOtherCompaniesPlant2(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", jcmbOtherCompanyPlant2.getSelectedItem()+"") );
            loadInvoiceOtherCompanyPlant2();
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadInvoiceOtherCompanyPlant2() {
        Object[]  objInvoice = new Object[13];
        String[] companylst = (jcmbOtherCompanyPlant2.getSelectedItem() + "").split("-");
        
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", companylst[0], objInvoice, false);
            
            if(bfound) {
                jtxtAccountManager.setText(objInvoice[11]+"");
            }else{
                jtxtAccountManager.setText("Herlina Dharma, SE");
            }

            String noInvOTH2 = (bfound) ? objInvoice[3]+"" : ".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"";
            jtxtNoInvoiceOtherCompanyPlant2.setText(noInvOTH2);
            jtxtNoFakturPajakOtherCompanyPlant2.setText("Faktur Pajak OtherCompany");

            jtxtTanggalOtherCompanyPlant2.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
            loadResultOtherCompanyPlant2();
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadResultOtherCompanyPlant2(){
        jtxtTotalAmountOtherCompanyPlant2.setText( jtxtTotalOtherCompanyPlant2.getText());
        jtxtDiscAmountOtherCompanyPlant2.setText( "0");
        jtxtBfrTaxAmoutOtherCompanyPlant2.setText(jtxtTotalAmountOtherCompanyPlant2.getText());
        jtxtTaxAmountOtherCompanyPlant2.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountOtherCompanyPlant2.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountOtherCompanyPlant2.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountOtherCompanyPlant2.getText().replace(",", "")) * 1.1));        
    }

    public void saveInvoiceOtherCompanyPlant2(){
        String[] companylst = (jcmbOtherCompanyPlant2.getSelectedItem() + "").split("-");

        int isave = JOptionPane.showConfirmDialog(null,  "Ingin Menyimpan Transaksi " + jcmbOtherCompanyPlant2.getSelectedItem(), "Save  ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("OTH 2");
            
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceOtherCompanyPlant2.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                true,
                                jtxtNoInvoiceOtherCompanyPlant2.getText(),
                                jtxtNoFakturPajakOtherCompanyPlant2.getText(),
                                jtxtTanggalOtherCompanyPlant2.getText(),
                                Double.parseDouble(jtxtTotalAmountOtherCompanyPlant2.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountOtherCompanyPlant2.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutOtherCompanyPlant2.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountOtherCompanyPlant2.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountOtherCompanyPlant2.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                companylst[0]
                        );
                        bsave = invvald.saveInvoiceOtherCompanyPlant2(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                jtxtNoInvoiceOtherCompanyPlant2.getText(),
                                companylst[0]);

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved  ");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save  ");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    
    private void saveInvoiceOtherManual(){
        String company = jtxtKodeOtherManual.getText();

        int isave = JOptionPane.showConfirmDialog(null,  "Ingin Menyimpan Transaksi " + jtxtNamaOtherManual.getText(), "Save  ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("Manual");
                        
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {
                if(jtxtNoInvoiceOtherManual.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {            
                    try {
                         bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                jchkBoxProduk.isSelected(),
                                jtxtNoInvoiceOtherManual.getText(),
                                jtxtNoFakturPajakOtherManual.getText(),
                                jtxtTanggalOtherManual.getText(),
                                Double.parseDouble(jtxtTotalAmountOtherManual.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountOtherManual.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutOtherManual.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountOtherManual.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountOtherManual.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                company
                        );

                        bsave = invvald.saveInvoiceOtherManual(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                jtxtNoInvoiceOtherManual.getText(),
                                tmodelothermanual,
                                jtxtKodeOtherManual.getText()
                        );
                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved  ");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save  ");
                        }


                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }                
    }
    private void loadOtherManual(){
        Object[] objOthermanual = new Object[13];
        invvald.loadOtherManual(
                        jcmbTahun.getSelectedItem()+"",
                        (jcmbBulan.getSelectedIndex() + 1) + "",
                        jtxtKodeOtherManual.getText(),
                        objOthermanual
                        );
        
//        jtxtKodeOtherManual.setText(objOthermanual[2]+"");
//        jtxtNamaOtherManual.setText(objOthermanual[3]+""); 
        jchkBoxProduk.setSelected(objOthermanual[4]  == null ? true : Integer.parseInt(objOthermanual[4]+"") == 1 ? true : false);
        jtxtTotalOtherManual.setText(GlobalUtils.formatnumber(objOthermanual[5]));
        jtxtNoInvoiceOtherManual.setText(objOthermanual[6] == null ? "" : objOthermanual[6] + ""); 
        jtxtNoFakturPajakOtherManual.setText(objOthermanual[7] == null ? "" : objOthermanual[7] + "");
        jtxtTanggalOtherManual.setText(objOthermanual[8] == null ? "" : objOthermanual[8] + "");                
        jtxtDiscAmountOtherManual.setText(GlobalUtils.formatnumber(objOthermanual[9]));
        jtxtBfrTaxAmoutOtherManual.setText(GlobalUtils.formatnumber(objOthermanual[10])); 
        jtxtTaxAmountOtherManual.setText(GlobalUtils.formatnumber(objOthermanual[11]));
        jtxtAfterTaxAmountOtherManual.setText(GlobalUtils.formatnumber(objOthermanual[12])); 

        
        invvald.loadDetailOtherManual(
                jcmbTahun.getSelectedItem()+"",
                (jcmbBulan.getSelectedIndex() + 1) + "",
                jtxtKodeOtherManual.getText(), 
                jchkBoxProduk.isSelected(), 
                tmodelothermanual,
                dataothermanual
                );
        tmodelothermanual.addRow(dataothermanual);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JButton jbtnBrowseCompany;
    private javax.swing.JButton jbtnCreateARInv;
    private javax.swing.JButton jbtnPrintBBCDF;
    private javax.swing.JButton jbtnPrintBKCDF;
    private javax.swing.JButton jbtnPrintBrandSaI;
    private javax.swing.JButton jbtnPrintCPP;
    private javax.swing.JButton jbtnPrintDetailSAI;
    private javax.swing.JButton jbtnPrintMTS;
    private javax.swing.JButton jbtnPrintOTBahan;
    private javax.swing.JButton jbtnPrintOTManual;
    private javax.swing.JButton jbtnPrintOTProduk;
    private javax.swing.JButton jbtnPrintOTProdukBox;
    private javax.swing.JButton jbtnPrintOTProdukBoxGroup;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnRefreshInvoice;
    private javax.swing.JButton jbtnResetSAI;
    private javax.swing.JButton jbtnSaveBBCDF;
    private javax.swing.JButton jbtnSaveBKCDF;
    private javax.swing.JButton jbtnSaveCPP;
    private javax.swing.JButton jbtnSaveCPP1;
    private javax.swing.JButton jbtnSaveOtherCompanyFG;
    private javax.swing.JButton jbtnSaveOtherCompanyPlant1;
    private javax.swing.JButton jbtnSaveOtherManual;
    private javax.swing.JButton jbtnSaveSAI;
    private javax.swing.JButton jbtnShow;
    private javax.swing.JButton jbtnbrowsearbatch;
    private javax.swing.JCheckBox jchkBoxProduk;
    private javax.swing.JCheckBox jchkautobatchno;
    private javax.swing.JComboBox<String> jcmbBulan;
    private javax.swing.JComboBox<String> jcmbOtherCompanyPlant1;
    private javax.swing.JComboBox<String> jcmbOtherCompanyPlant2;
    private javax.swing.JComboBox<String> jcmbTahun;
    private javax.swing.JLabel jlblBulan;
    private javax.swing.JLabel jlblTahun;
    private javax.swing.JTable jtblCDFBB;
    private javax.swing.JTable jtblCDFBK;
    private javax.swing.JTable jtblDetailCPP;
    private javax.swing.JTable jtblDetailMB;
    private javax.swing.JTable jtblDetailMTS;
    private javax.swing.JTable jtblDetailSAI;
    private javax.swing.JTable jtblDetailSAIMBVariance;
    private javax.swing.JTable jtblInvoice;
    private javax.swing.JTable jtblInvoiceSummaryByBrandMB;
    private javax.swing.JTable jtblInvoiceSummaryByBrandSAI;
    private javax.swing.JTable jtblOtherCompanyPlant1;
    private javax.swing.JTable jtblOtherCompanyPlant2;
    private javax.swing.JTable jtblOtherManual;
    private javax.swing.JTextField jtxtAccountManager;
    private javax.swing.JTextField jtxtAfterTaxAmountBBCDF;
    private javax.swing.JTextField jtxtAfterTaxAmountBKCDF;
    private javax.swing.JTextField jtxtAfterTaxAmountCPP;
    private javax.swing.JTextField jtxtAfterTaxAmountMTS;
    private javax.swing.JTextField jtxtAfterTaxAmountOtherCompanyPlant1;
    private javax.swing.JTextField jtxtAfterTaxAmountOtherCompanyPlant2;
    private javax.swing.JTextField jtxtAfterTaxAmountOtherManual;
    private javax.swing.JTextField jtxtAfterTaxAmountSAI;
    private javax.swing.JTextField jtxtBfrTaxAmoutBBCDF;
    private javax.swing.JTextField jtxtBfrTaxAmoutBKCDF;
    private javax.swing.JTextField jtxtBfrTaxAmoutCPP;
    private javax.swing.JTextField jtxtBfrTaxAmoutMTS;
    private javax.swing.JTextField jtxtBfrTaxAmoutOtherCompanyPlant1;
    private javax.swing.JTextField jtxtBfrTaxAmoutOtherCompanyPlant2;
    private javax.swing.JTextField jtxtBfrTaxAmoutOtherManual;
    private javax.swing.JTextField jtxtBfrTaxAmoutSAI;
    private javax.swing.JTextField jtxtDiscAmountBBCDF;
    private javax.swing.JTextField jtxtDiscAmountBKCDF;
    private javax.swing.JTextField jtxtDiscAmountCPP;
    private javax.swing.JTextField jtxtDiscAmountMTS;
    private javax.swing.JTextField jtxtDiscAmountOtherCompanyPlant1;
    private javax.swing.JTextField jtxtDiscAmountOtherCompanyPlant2;
    private javax.swing.JTextField jtxtDiscAmountOtherManual;
    private javax.swing.JTextField jtxtDiscAmountSAI;
    private javax.swing.JTextField jtxtKodeOtherManual;
    private javax.swing.JTextField jtxtNamaOtherManual;
    private javax.swing.JTextField jtxtNoFakturPajakBBCDF;
    private javax.swing.JTextField jtxtNoFakturPajakBKCDF;
    private javax.swing.JTextField jtxtNoFakturPajakCPP;
    private javax.swing.JTextField jtxtNoFakturPajakMTS;
    private javax.swing.JTextField jtxtNoFakturPajakOtherCompanyPlant1;
    private javax.swing.JTextField jtxtNoFakturPajakOtherCompanyPlant2;
    private javax.swing.JTextField jtxtNoFakturPajakOtherManual;
    private javax.swing.JTextField jtxtNoFakturPajakSAI;
    private javax.swing.JTextField jtxtNoInvoiceBBCDF;
    private javax.swing.JTextField jtxtNoInvoiceBKCDF;
    private javax.swing.JTextField jtxtNoInvoiceCPP;
    private javax.swing.JTextField jtxtNoInvoiceMTS;
    private javax.swing.JTextField jtxtNoInvoiceOtherCompanyPlant1;
    private javax.swing.JTextField jtxtNoInvoiceOtherCompanyPlant2;
    private javax.swing.JTextField jtxtNoInvoiceOtherManual;
    private javax.swing.JTextField jtxtNoInvoiceSAI;
    private javax.swing.JTextField jtxtTanggalBBCDF;
    private javax.swing.JTextField jtxtTanggalBKCDF;
    private javax.swing.JTextField jtxtTanggalCPP;
    private javax.swing.JTextField jtxtTanggalMTS;
    private javax.swing.JTextField jtxtTanggalOtherCompanyPlant1;
    private javax.swing.JTextField jtxtTanggalOtherCompanyPlant2;
    private javax.swing.JTextField jtxtTanggalOtherManual;
    private javax.swing.JTextField jtxtTanggalSAI;
    private javax.swing.JTextField jtxtTaxAmountBBCDF;
    private javax.swing.JTextField jtxtTaxAmountBKCDF;
    private javax.swing.JTextField jtxtTaxAmountCPP;
    private javax.swing.JTextField jtxtTaxAmountMTS;
    private javax.swing.JTextField jtxtTaxAmountOtherCompanyPlant1;
    private javax.swing.JTextField jtxtTaxAmountOtherCompanyPlant2;
    private javax.swing.JTextField jtxtTaxAmountOtherManual;
    private javax.swing.JTextField jtxtTaxAmountSAI;
    private javax.swing.JTextField jtxtTotalAmountBBCDF;
    private javax.swing.JTextField jtxtTotalAmountBKCDF;
    private javax.swing.JTextField jtxtTotalAmountCPP;
    private javax.swing.JTextField jtxtTotalAmountMTS;
    private javax.swing.JTextField jtxtTotalAmountOtherCompanyPlant1;
    private javax.swing.JTextField jtxtTotalAmountOtherCompanyPlant2;
    private javax.swing.JTextField jtxtTotalAmountOtherManual;
    private javax.swing.JTextField jtxtTotalAmountSAI;
    private javax.swing.JTextField jtxtTotalBakuCDF;
    private javax.swing.JTextField jtxtTotalCPP;
    private javax.swing.JTextField jtxtTotalHETMTS;
    private javax.swing.JTextField jtxtTotalHPDMTS;
    private javax.swing.JTextField jtxtTotalKemasCDF;
    private javax.swing.JTextField jtxtTotalOtherCompanyPlant1;
    private javax.swing.JTextField jtxtTotalOtherCompanyPlant2;
    private javax.swing.JTextField jtxtTotalOtherManual;
    private javax.swing.JTextField jtxtValueMBHJP;
    private javax.swing.JTextField jtxtValueMBHPD;
    private javax.swing.JTextField jtxtValueSAIHJP;
    private javax.swing.JTextField jtxtValueSAIHPD;
    private javax.swing.JTextField jtxtarinvbatchno;
    private javax.swing.JTextField jtxtdescarinvobatchlist;
    // End of variables declaration//GEN-END:variables

    private void loadMTS() {
        loadSummaryMTSHPD();            
        loadSummaryMTSHET();            
        loadDetailMTS(); 
        loadInvoiceMTS();
    }

    private void loadDetailMTS() {
        try {
            invvald.getInvoiceDetailMTS(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "",  tmodelMTS, dataMTS);
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSummaryMTSHPD() {
        try {
            jtxtTotalHPDMTS.setText(invvald.getInvoiceSummaryMTSHPD(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex()+1)+""));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSummaryMTSHET() {
        try {
            jtxtTotalHETMTS.setText(invvald.getInvoiceSummaryMTSHET(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex()+1)+""));
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadInvoiceMTS() {
        Object[]  objInvoice = new Object[13];
        
        
        boolean bfound = false;
        
        try {
            bfound = invvald.getInvoice(jcmbTahun.getSelectedItem()+"", (jcmbBulan.getSelectedIndex() + 1) + "", "MTS", objInvoice, false);
            //jbtnSaveCPP.setEnabled(!bfound);
            if(bfound) {
                jtxtNoInvoiceMTS.setText(objInvoice[3] + "");
                jtxtNoFakturPajakMTS.setText(objInvoice[4] + "");
                jtxtTanggalMTS.setText(objInvoice[5] + "");
                jtxtTotalAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[6]+"")));
                jtxtDiscAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[7] + "")));
                jtxtBfrTaxAmoutMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[8] + "")));
                jtxtTaxAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[9] + "")));
                jtxtAfterTaxAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(objInvoice[10] + "")));
            }else{
                jtxtNoInvoiceMTS.setText(".../MB/SLS/" + GlobalUtils.getRomawi(jcmbBulan.getSelectedIndex() + 1) + "/" + jcmbTahun.getSelectedItem()+"");
                jtxtNoFakturPajakMTS.setText("Faktur Pajak MTS");
                
                jtxtTanggalMTS.setText(jcmbTahun.getSelectedItem()+"" + "-" + (jcmbBulan.getSelectedIndex() + 1) + "-01");
                loadResultMTS();
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadResultMTS() {
        double totalHETMTS = Double.parseDouble(jtxtTotalHETMTS.getText().replace(",", ""));
        double totalHPDMTS = Double.parseDouble(jtxtTotalHPDMTS.getText().replace(",", ""));
        jtxtTotalAmountMTS.setText(jtxtTotalHETMTS.getText());
        jtxtDiscAmountMTS.setText("0");
        jtxtBfrTaxAmoutMTS.setText(jtxtTotalAmountMTS.getText());
        jtxtTaxAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountMTS.getText().replace(",", "")) * 0.1));
        jtxtAfterTaxAmountMTS.setText(GlobalUtils.formatnumber(Double.parseDouble(jtxtTotalAmountMTS.getText().replace(",", "")) * 1.1));
    }

    private void saveInvoiceMTS() {
        int isave = JOptionPane.showConfirmDialog(null, "Ingin Menyimpan Transaksi Invoice MTS", "Save MTS ", JOptionPane.OK_CANCEL_OPTION);
        if (isave == JOptionPane.OK_OPTION) {
            
            boolean bsave = false;
            boolean cekInvoice = cekSetNoInvoice("MTS");
            
            if(cekInvoice == true){
                JOptionPane.showMessageDialog(null, "No.Invoice yang dimasukan sudah ada di dalam database, silahkan masukkan No.Invoice lain.");
                bsave = false;
            } else {            
                if(jtxtNoInvoiceMTS.getText().contains(".../")){
                    JOptionPane.showMessageDialog(null, "Silahkan No.Invoice diisi dengan benar lebih dulu.");
                    bsave = false;
                } else {
                    try {

                        bsave = invvald.saveInvoice(
                                jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "",
                                true,
                                jtxtNoInvoiceMTS.getText(),
                                jtxtNoFakturPajakMTS.getText(),
                                jtxtTanggalMTS.getText(),
                                Double.parseDouble(jtxtTotalAmountMTS.getText().replace(",", "")),
                                Double.parseDouble(jtxtDiscAmountMTS.getText().replace(",", "")),
                                Double.parseDouble(jtxtBfrTaxAmoutMTS.getText().replace(",", "")),
                                Double.parseDouble(jtxtTaxAmountMTS.getText().replace(",", "")),
                                Double.parseDouble(jtxtAfterTaxAmountMTS.getText().replace(",", "")),
                                jtxtAccountManager.getText(), 
                                "MTS"
                        );
                        bsave = invvald.saveInvoiceMTS(jcmbTahun.getSelectedItem()+"",
                                (jcmbBulan.getSelectedIndex() + 1) + "", 
                                jtxtNoInvoiceMTS.getText());

                        if (bsave) {
                            JOptionPane.showMessageDialog(null, "Saved MTS");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed Save MTS");
                        }
                    } catch (CodeException ex) {
                        Logger.getLogger(FrmInvoiceValidation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

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
