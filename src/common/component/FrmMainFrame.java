/*
 * MainFrame.java
 *
 * Created on December 12, 2008, 2:55 PM
 * 
 * FrmMainFrame is the Main Form, It Provide Menus and Navigator Icons.
 * 
 * How To run JinternalForm and Plugin To 
 * 
 * 1. Add Menuitem 
 * Sample : JmniFrm<table>
 * 
 * 2. Type "Frm<table>" on Properties 'Menu' 
 * Sample : Frm<Table>
 * 
 * 3. Add "Frm<table>" to table Mastermodule (mysql)
 * 4. Run program Setting Previliges using Form Group
 * 5. Type this on FrmMainFrame
 * 
 * import common.component.FrmMaster<table>;
 * 
 * .......
 * 
 try {
        if (frmmaster<table> == null) {
            frmmaster<table> = new FrmMaster<table>(this);
        }
        
        showForm(frmmaster<table>);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 *Sample : 
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

import accapp.component.ap.FrmAP_BatchGLPosting;
import accapp.component.ap.FrmAP_PostInvoiceBatches;
import accapp.component.ap.FrmAP_PostPaymentBatches;
import accapp.component.ap.FrmAP_aging_process;
import accapp.component.ap.FrmAp_accset;
import accapp.component.ap.FrmAp_distcode;
import accapp.component.ap.FrmAp_distseth;
import accapp.component.ap.FrmAp_invbatchlist;
import accapp.component.ap.FrmAp_invh;
import accapp.component.ap.FrmAp_paybatchlist;
import accapp.component.ap.FrmAp_paybatchlistpro;
import accapp.component.ap.FrmAp_vendor;
import accapp.component.ap.FrmAp_vendorgrp;
import accapp.component.ap.adjustment.FrmAP_PostAdjustmentBatches;
import accapp.component.ap.adjustment.FrmAp_adjbatchlist;
import accapp.component.ap.adjustment.FrmAp_adjh;
import accapp.component.ar.FrmAR_BatchGLPosting;
import accapp.component.ar.FrmAR_PostAdjustmentBatches;
import accapp.component.ar.FrmAR_PostInvoiceBatches;
import accapp.component.ar.FrmAR_PostReceiptBatches;
import accapp.component.ar.FrmAr_accset;
import accapp.component.ar.FrmAr_billcycl;
import accapp.component.ar.FrmAr_custgrp;
import accapp.component.ar.FrmAr_custnat;
import accapp.component.ar.FrmAr_customer;
import accapp.component.ar.FrmAr_distcode;
import accapp.component.ar.FrmAr_interest;
import accapp.component.ar.FrmAr_invbatchlist;
import accapp.component.ar.FrmAr_invh;
import accapp.component.ar.FrmAr_optiionaldetail1;
import accapp.component.ar.FrmAr_rcpbatchlist;
import accapp.component.ar.FrmAr_rcph;
import accapp.component.ar.adjustment.FrmAr_adjbatchlist;
import accapp.component.ar.adjustment.FrmAr_adjh;
import accapp.component.cashbook.FrmCb_bank;
import accapp.component.cashbook.FrmCb_batchGLposting;
import accapp.component.cashbook.FrmCb_batchcontrol;
import accapp.component.cashbook.FrmCb_batchentry;
import accapp.component.cashbook.FrmCb_batchposting;
import accapp.component.cashbook.FrmCb_source;
import accapp.component.cashbook.FrmCb_voucherh;
import accapp.component.costapp.FrmCostAccounting;
import accapp.component.gl.FrmGL_JournalEntryList;
import accapp.component.gl.FrmGL_PostJournalEntryBatches;
import accapp.component.gl.FrmGl_Create_Openbalance;
import accapp.component.gl.FrmGl_account;
import accapp.component.gl.FrmGl_batchlist;
import accapp.component.gl.FrmGl_currency;
import accapp.component.gl.FrmGl_currencyrateh;
import accapp.component.gl.FrmGl_fiscalh;
import accapp.component.gl.FrmGl_sourcelgr;
import accapp.component.gl.FrmSetting_financial_rpt;
import accapp.component.invoice.FrmInvoiceValidation;
import accapp.component.op.FrmOp_addrtype;
import accapp.component.op.FrmOp_paymentterm;
import accapp.component.op.FrmOp_phonetype;
import accapp.component.op.FrmOp_tax;
import accapp.objectclasses.ap.Ap_invbatchlist;
import accapp.objectclasses.ap.Ap_paybatchlist;
import accapp.objectclasses.ap.adjustment.Ap_adjbatchlist;
import accapp.objectclasses.ar.Ar_invbatchlist;
import accapp.objectclasses.ar.Ar_rcpbatchlist;
import accapp.objectclasses.ar.adjustment.Ar_adjbatchlist;
import accapp.objectclasses.gl.Gl_batchlist;
import common.classinterface.NavigatorFormInt;
import common.classinterface.NavigatorFormReportInt;
import common.jdbc.DbBean;

import common.utils.GlobalUtils;
import generate.component.FrmGenerate;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import common.utils.CodeException;
import common.objectclasses.Mastergroupdetail;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import common.objectclasses.Masteruser;
import common.print.FrmPrintCBRegisterEntry;
import common.print.FrmPrintCBVoucher;
import common.print.FrmPrintCBVoucherFrCB;
import common.print.FrmPrintMasterAPAccountSetLap;
import common.print.FrmPrintMasterAPDistributionCodeLap;
import common.print.FrmPrintMasterAPDistributionSetCodeLap;
import common.print.FrmPrintMasterAPVendor;
import common.print.FrmPrintMasterARAccountSetLap;
import common.print.FrmPrintMasterARBillingCycle;
import common.print.FrmPrintMasterARCustommer;
import common.print.FrmPrintMasterARCustommerGroup;
import common.print.FrmPrintMasterARDistributionCode;
import common.print.FrmPrintMasterARInterest;
import common.print.FrmPrintMasterARNationalAccount;
import common.print.FrmPrintMasterAROptionalDetail1;
import common.print.FrmPrintMasterCBBank;
import common.print.FrmPrintMasterCBSourceAccount;
import common.print.FrmPrintMasterGLAccountCode;
import common.print.FrmPrintMasterGLFinancialSettingReport;
import common.print.FrmPrintMasterGLSourceCode;
import common.print.FrmPrintTransactionCBRegister;
import common.print.FrmPrintTransaksiAPAged;
import common.print.FrmPrintTransaksiAPBatchListInvoice;
import common.print.FrmPrintTransaksiAPBatchListStatus;
import common.print.FrmPrintTransaksiAPVendor;
import common.print.FrmPrintTransaksiARAging;
import common.print.FrmPrintTransaksiARBatchList;
import common.print.FrmPrintTransaksiARBatchListStatus;
import common.print.FrmPrintTransaksiARCustommer;
import common.print.FrmPrintTransaksiARGL;
import common.print.FrmPrintTransaksiCBBatchList;
import common.print.FrmPrintTransaksiGLByAccCode;
import common.print.FrmPrintTransaksiGLJournal;
import common.print.FrmPrintTransaksiGLEkporDataNeraca;
import common.print.FrmPrintTransaksiGLFinancialReport;
import common.print.FrmPrintTransaksiGLStatusBatch;
import common.print.FrmPrintTransaksiGLTrialBalance;
import common.print.FrmPrintVoucher_je_rpt;
import common.print.FrmPrintCb_cash_advance;
import common.print.Frmgl_ProvPosJournalRpt;
import cpp_utils.component.FrmAR_invoice_creator;
import cpp_utils.component.FrmUt_external_data;

/**
 *
 * @author  windu
 */
public class FrmMainFrame extends javax.swing.JFrame {
         
    boolean bactivate = false;
    /*Navigator eih*/
    NavigatorFormInt nfi;
    NavigatorFormReportInt nrfi;
    FrmGenerate frmgeneratetable;
    FrmMasteruser frmmasteruser;
    FrmMastermodule frmmastermodule;
    FrmMastergroup frmmastergroup;
    FrmCompany frmCompany;


    //Cash Book
    FrmCb_bank frmcbbank;
    FrmCb_batchcontrol frmcbbatchcontrol;
    FrmCb_batchentry frmcbbatchentry;
    FrmCb_source frmcbsource;
    FrmCb_batchposting FrmCbbatchposting;
    FrmCb_batchGLposting FrmCbbatchGLposting;

    //GL
    FrmGl_currency frmcurrency;
    FrmGl_account frmaccount;
    FrmGl_sourcelgr frmsource;
    FrmGl_batchlist frmjournalentry;
    FrmGl_currencyrateh FrmGlcurrencyrateh;
    FrmGl_fiscalh FrmGlfiscalh;
    FrmGL_JournalEntryList frmgljournalentrylist;
    FrmGL_PostJournalEntryBatches frmpostjournalentrybatches;
    FrmSetting_financial_rpt FrmGlFinancialReportSetting;

    //AP
    FrmAp_vendor frmapvendor;
    FrmAp_distseth frmapdistseth;
    FrmAp_accset frmapaccset;
    FrmAp_distcode frmapdistcode;
    FrmAp_vendorgrp frmapvendorgrp;
    FrmAp_invbatchlist frmapinvoiceentry;
    FrmAp_invh frmapinvh;
    FrmAp_paybatchlist frmappaybatchlist;
    FrmAp_paybatchlistpro frmAppaybatchlistpro;
    FrmAP_BatchGLPosting frmapbatchglposting;
    FrmAP_PostInvoiceBatches frmpostinvoicebatches;
    FrmAP_PostPaymentBatches frmpostpaymentbatches;

    FrmAp_adjbatchlist frmapadjentry;
    FrmAp_adjh frmapadjbatchlist;
    FrmAP_PostAdjustmentBatches frmpostadjustmentbatches;
    
    //AR
    FrmAr_accset frmaraccset;
    FrmAr_custgrp frmarcustgrp;
    FrmAr_billcycl frmarbillcycl;
    FrmAr_interest frmarinterest;
    FrmAr_custnat frmarnatacc;
    FrmAr_customer frmarcustomer;
    FrmAr_distcode frmardistributioncode;
    FrmAr_invbatchlist frmarinvoiceentry;
    FrmAr_optiionaldetail1 frmaroptionaldetail;
    FrmAr_invh frmarinvbatchlist;
    FrmAr_rcpbatchlist Frmarrcpbatchlist;
    FrmAr_rcph FrmArrcph;
    FrmAR_BatchGLPosting frmarbatchglposting;
    FrmAR_PostReceiptBatches frmarpostreceiptbatches;
    FrmAR_PostInvoiceBatches frmarpostinvoicebatches;
    FrmAR_PostAdjustmentBatches frmarpostadjustmentbatches;

    FrmAr_adjbatchlist frmaradjentry;
    FrmAr_adjh frmaradjbatchlist;

    //OP
    FrmOp_paymentterm frmoppaymentterm;
    FrmOp_phonetype frmopphonetype;
    FrmOp_addrtype frmopaddresstype;
    FrmOp_tax frmoptax;
    


    Action stopwatch = new AbstractAction(){
                                    public void actionPerformed(ActionEvent e) {
                                        jlblSystemDateTime.setText(GlobalUtils.showDateTime(0, "T"));
                                    }
                        };

 
    FrmLogin login;
    private FrmUt_external_data frmUt_external_data;
    private FrmAR_invoice_creator frmAR_invoice_creator;
    private FrmCb_voucherh frmCb_voucherh;
    private FrmPrintCBVoucher frmPrintCBVoucher;
    private FrmAP_aging_process frmAP_aging_process;
    private FrmGl_Create_Openbalance frmGl_Create_Openbalance;
    private FrmCostAccounting frmcostaccounting;
    private FrmInvoiceValidation frminvoicevalidation;
    
    

        
    /** Creates new form MainFrame */
    public FrmMainFrame() {
        initComponents();

        setToolTip();
            
        Timer timer = new Timer(1000, stopwatch);
        timer.start();
        setToolBar(-1,0);
        
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        
        login = new FrmLogin();
        setCursor(GlobalUtils.NORMALCURSOR);

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnImpXls = new javax.swing.JButton();
        btnImpTxt = new javax.swing.JButton();
        btnExXls = new javax.swing.JButton();
        btnExTxt = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnPrevScreen = new javax.swing.JButton();
        btnNextScreen = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLblUser = new javax.swing.JLabel();
        jLblWarning = new javax.swing.JLabel();
        jlblSystemDateTime = new javax.swing.JLabel();
        jMenuMain = new javax.swing.JMenuBar();
        jmnMaster = new javax.swing.JMenu();
        jmnuGL = new javax.swing.JMenu();
        jmniMasterAccount = new javax.swing.JMenuItem();
        jmniMasterGLSource = new javax.swing.JMenuItem();
        jmniMasterGLCurrencyRate = new javax.swing.JMenuItem();
        jmniMasterGLFiscalCalendar = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jmniFrmGl_Create_Openbalance = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmniFrmAr_accset = new javax.swing.JMenuItem();
        jmniFrmAr_custgrp = new javax.swing.JMenuItem();
        jmniAr_billcycl = new javax.swing.JMenuItem();
        jmniAr_interest = new javax.swing.JMenuItem();
        jmniAr_NationalAccount = new javax.swing.JMenuItem();
        jmniArCustomer = new javax.swing.JMenuItem();
        jmniArDistributionCode = new javax.swing.JMenuItem();
        jmniArOptionalDetail1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmniFrmAP_Vendor = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmniFrmAp_accset = new javax.swing.JMenuItem();
        jmniFrmAp_distcode = new javax.swing.JMenuItem();
        jmniFrmAp_vendorgrp = new javax.swing.JMenuItem();
        jmnuCashBook = new javax.swing.JMenu();
        jmniMasterBank = new javax.swing.JMenuItem();
        jmniCB_Source = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmniMasterCurrency = new javax.swing.JMenuItem();
        jmniOp_paymentterm = new javax.swing.JMenuItem();
        jmniAddressType = new javax.swing.JMenuItem();
        jmniphoneType = new javax.swing.JMenuItem();
        jmniTax = new javax.swing.JMenuItem();
        jmnTransaksi = new javax.swing.JMenu();
        jmnuTransaksiGL = new javax.swing.JMenu();
        jmniGlJournalEntry = new javax.swing.JMenuItem();
        jmniGlJournalEntryList = new javax.swing.JMenuItem();
        jmniFrmGL_PostJournalEntryBatches = new javax.swing.JMenuItem();
        jmnuTransaksiAR = new javax.swing.JMenu();
        jmnuiAR_InvoiceEntry = new javax.swing.JMenuItem();
        jmnuiAR_InvoiceBatchList = new javax.swing.JMenuItem();
        jmnuiAr_rcpbatchlist = new javax.swing.JMenuItem();
        jmnuiAr_rcpbatchlistprocess = new javax.swing.JMenuItem();
        jmniFrmAR_BatchGLPosting = new javax.swing.JMenuItem();
        jmniFrmAR_PostInvoiceBatches = new javax.swing.JMenuItem();
        jmniFrmAR_PostReceiptBatches = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmniARAdjusmentEntry = new javax.swing.JMenuItem();
        jmnuiAr_InvoiceBatchList = new javax.swing.JMenuItem();
        jmniFrmAR_PostAdjustmentBatches = new javax.swing.JMenuItem();
        jmnuTransaksiAP = new javax.swing.JMenu();
        jmnuiAP_InvoiceEntry = new javax.swing.JMenuItem();
        jmnuiAp_rcpbatchlistprocess = new javax.swing.JMenuItem();
        jmnuiAp_paybatchlist = new javax.swing.JMenuItem();
        jmnuiAp_paybatchlistpro = new javax.swing.JMenuItem();
        jmniFrmAP_BatchGLPosting = new javax.swing.JMenuItem();
        jmniFrmAP_PostInvoiceBatches = new javax.swing.JMenuItem();
        jmniFrmAP_PostPaymentBatches = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmniAPAdjusmentEntry = new javax.swing.JMenuItem();
        jmnuiAp_InvoiceBatchList = new javax.swing.JMenuItem();
        jmniFrmAP_PostAdjustmentBatches = new javax.swing.JMenuItem();
        jmnuTransaksiCashBook = new javax.swing.JMenu();
        jmniCb_batchcontrol = new javax.swing.JMenuItem();
        jmniFrmCb_batchentry = new javax.swing.JMenuItem();
        jmniFrmCb_batchposting = new javax.swing.JMenuItem();
        jmniFrmCb_batchGLposting = new javax.swing.JMenuItem();
        jmniFrmCb_voucher = new javax.swing.JMenuItem();
        jmnuCostAccounting = new javax.swing.JMenu();
        jmniScreenCost = new javax.swing.JMenuItem();
        jmnuInvoiceValidation = new javax.swing.JMenu();
        jmniInvoiceValidation = new javax.swing.JMenuItem();
        jmnLaporan = new javax.swing.JMenu();
        jmnuLaporanMasterGL = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jmniLaporanMasterGLSourceCode = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jmniLaporanTransaksiGlJournalEntry = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmnuLaporanMasterAR = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jmniLaporanMasterFrmAr_accset = new javax.swing.JMenuItem();
        jmniLaporanMasterFrmAr_custgrp = new javax.swing.JMenuItem();
        jmniLaporanMasterAr_billcycl = new javax.swing.JMenuItem();
        jmniLaporanMasterAr_interest = new javax.swing.JMenuItem();
        jmniLaporanMasterAr_NationalAccount = new javax.swing.JMenuItem();
        jmniLaporanMasterArCustomer = new javax.swing.JMenuItem();
        jmniLaporanMasterArDistributionCode = new javax.swing.JMenuItem();
        jmniLaporanMasterArOptionalDetail = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jmnuLaporanMasterAP = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jmniLaporanMasterFrmAP_Vendor = new javax.swing.JMenuItem();
        jmniLaporanMasterDistSetCode = new javax.swing.JMenuItem();
        jmniLaporanMasterFrmAp_accset = new javax.swing.JMenuItem();
        jmniLaporanMasterFrmAp_distcode = new javax.swing.JMenuItem();
        jmniLaporanMasterFrmAp_vendorgrp = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jmniLaporanTransaksiAp_rcpbatchlistprocess = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jmnuFrmAP_aging_process = new javax.swing.JMenuItem();
        jmniAPAgedPayables = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmnuLaporanMasterCashBook = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jmniLaporanCBMasterMasterBank = new javax.swing.JMenuItem();
        jmniLaporanMasterCBSource = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmniCBRegisterEntry = new javax.swing.JMenuItem();
        jmniCBVoucher = new javax.swing.JMenuItem();
        jmniCBVoucherReal = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jmnuSystem = new javax.swing.JMenu();
        jmniGenerate = new javax.swing.JMenuItem();
        jmniUser = new javax.swing.JMenuItem();
        jmniResetPassword = new javax.swing.JMenuItem();
        jmniGroup = new javax.swing.JMenuItem();
        jmniModule = new javax.swing.JMenuItem();
        jmniMasterCompany = new javax.swing.JMenuItem();
        jmniut_External_Data = new javax.swing.JMenuItem();
        jmniFrmAR_invoice_creator = new javax.swing.JMenuItem();
        jmniLogOut = new javax.swing.JMenuItem();
        jmniExit = new javax.swing.JMenuItem();
        jmnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accounting Application");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_newfile.gif"))); // NOI18N
        btnNew.setMnemonic('n');
        btnNew.setToolTipText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.gif"))); // NOI18N
        btnSave.setMnemonic('s');
        btnSave.setToolTipText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_undo.gif"))); // NOI18N
        btnUndo.setMnemonic('u');
        btnUndo.setToolTipText("Undo");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUndo);

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_del.gif"))); // NOI18N
        btnDel.setMnemonic('d');
        btnDel.setToolTipText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDel);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.gif"))); // NOI18N
        btnPrint.setMnemonic('p');
        btnPrint.setToolTipText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_first.gif"))); // NOI18N
        btnFirst.setMnemonic('q');
        btnFirst.setToolTipText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFirst);

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_prev.gif"))); // NOI18N
        btnPrev.setMnemonic('w');
        btnPrev.setToolTipText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrev);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_next.gif"))); // NOI18N
        btnNext.setMnemonic('e');
        btnNext.setToolTipText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_last.gif"))); // NOI18N
        btnLast.setMnemonic('r');
        btnLast.setToolTipText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLast);

        btnImpXls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_export_toexcel.gif"))); // NOI18N
        btnImpXls.setToolTipText("Import from .xls");
        btnImpXls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpXlsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImpXls);

        btnImpTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_export_to_txt.gif"))); // NOI18N
        btnImpTxt.setToolTipText("Import from .csv");
        btnImpTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpTxtActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImpTxt);

        btnExXls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_import_fr_excel.gif"))); // NOI18N
        btnExXls.setToolTipText("Export to .xls");
        btnExXls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExXlsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExXls);

        btnExTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_import_fr_txt.gif"))); // NOI18N
        btnExTxt.setToolTipText("Export to .csv");
        btnExTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExTxtActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExTxt);

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PNG-Symbol-Check.png-256x256.png"))); // NOI18N
        btnConfirm.setToolTipText("Confirm/Execute");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConfirm);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_close.gif"))); // NOI18N
        btnClose.setToolTipText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClose);

        btnPrevScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_prev_screen.gif"))); // NOI18N
        btnPrevScreen.setToolTipText("Previous Screen");
        btnPrevScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevScreenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrevScreen);

        btnNextScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_next_screen.gif"))); // NOI18N
        btnNextScreen.setToolTipText("Next Screen");
        btnNextScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextScreenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNextScreen);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_help.gif"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setPreferredSize(new java.awt.Dimension(30, 32));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHelp);

        jDesktopPane1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout-aplikasi-accounting.jpg"))); // NOI18N
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(0, -10, 1010, 780);

        jLblUser.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLblUser.setText("Loged User Name");

        jLblWarning.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLblWarning.setForeground(new java.awt.Color(255, 51, 102));
        jLblWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlblSystemDateTime.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblSystemDateTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSystemDateTime.setText("System Date Time ");

        jmnMaster.setText("Master");

        jmnuGL.setText("General Ledger");

        jmniMasterAccount.setText("GL Account");
        jmniMasterAccount.setName("FrmGl_account"); // NOI18N
        jmniMasterAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterAccountActionPerformed(evt);
            }
        });
        jmnuGL.add(jmniMasterAccount);

        jmniMasterGLSource.setText("Source Codes");
        jmniMasterGLSource.setName("FrmGl_sourcelgr"); // NOI18N
        jmniMasterGLSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterGLSourceActionPerformed(evt);
            }
        });
        jmnuGL.add(jmniMasterGLSource);

        jmniMasterGLCurrencyRate.setText("Currency Rate");
        jmniMasterGLCurrencyRate.setName("FrmGl_currencyrateh"); // NOI18N
        jmniMasterGLCurrencyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterGLCurrencyRateActionPerformed(evt);
            }
        });
        jmnuGL.add(jmniMasterGLCurrencyRate);

        jmniMasterGLFiscalCalendar.setText("Fiscal Calendar");
        jmniMasterGLFiscalCalendar.setName("FrmGl_fiscalh"); // NOI18N
        jmniMasterGLFiscalCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterGLFiscalCalendarActionPerformed(evt);
            }
        });
        jmnuGL.add(jmniMasterGLFiscalCalendar);

        jMenuItem16.setText("Financial Report Setting");
        jMenuItem16.setName("FrmSetting_financial_rpt"); // NOI18N
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jmnuGL.add(jMenuItem16);

        jmniFrmGl_Create_Openbalance.setText("Create Open Balance");
        jmniFrmGl_Create_Openbalance.setName("FrmGl_Create_Openbalance"); // NOI18N
        jmniFrmGl_Create_Openbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmGl_Create_OpenbalanceActionPerformed(evt);
            }
        });
        jmnuGL.add(jmniFrmGl_Create_Openbalance);

        jmnMaster.add(jmnuGL);

        jMenu2.setText("Account Receivable");

        jmniFrmAr_accset.setText("AR Account Set");
        jmniFrmAr_accset.setName("FrmAr_accset"); // NOI18N
        jmniFrmAr_accset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAr_accsetActionPerformed(evt);
            }
        });
        jMenu2.add(jmniFrmAr_accset);

        jmniFrmAr_custgrp.setText("AR Customer Group");
        jmniFrmAr_custgrp.setName("FrmAr_custgrp"); // NOI18N
        jmniFrmAr_custgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAr_custgrpActionPerformed(evt);
            }
        });
        jMenu2.add(jmniFrmAr_custgrp);

        jmniAr_billcycl.setText("AR Bill Cycle");
        jmniAr_billcycl.setName("FrmAr_billcycl"); // NOI18N
        jmniAr_billcycl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAr_billcyclActionPerformed(evt);
            }
        });
        jMenu2.add(jmniAr_billcycl);

        jmniAr_interest.setText("AR Interest");
        jmniAr_interest.setName("FrmAr_interest"); // NOI18N
        jmniAr_interest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAr_interestActionPerformed(evt);
            }
        });
        jMenu2.add(jmniAr_interest);

        jmniAr_NationalAccount.setText("AR National Account");
        jmniAr_NationalAccount.setName("FrmAr_custnat"); // NOI18N
        jmniAr_NationalAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAr_NationalAccountActionPerformed(evt);
            }
        });
        jMenu2.add(jmniAr_NationalAccount);

        jmniArCustomer.setText("AR Customer");
        jmniArCustomer.setName("FrmAr_customer"); // NOI18N
        jmniArCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniArCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(jmniArCustomer);

        jmniArDistributionCode.setText("AR Distribution Code");
        jmniArDistributionCode.setName("FrmAr_distcode"); // NOI18N
        jmniArDistributionCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniArDistributionCodeActionPerformed(evt);
            }
        });
        jMenu2.add(jmniArDistributionCode);

        jmniArOptionalDetail1.setText("AR Optional Detail");
        jmniArOptionalDetail1.setName("FrmAr_optiionaldetail1"); // NOI18N
        jmniArOptionalDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniArOptionalDetail1ActionPerformed(evt);
            }
        });
        jMenu2.add(jmniArOptionalDetail1);

        jmnMaster.add(jMenu2);
        jMenu2.getAccessibleContext().setAccessibleName("ACCOUNT RECEIEVABLE ");

        jMenu3.setText("Account Payable");
        jMenu3.setName(""); // NOI18N

        jmniFrmAP_Vendor.setText("Master Vendor");
        jmniFrmAP_Vendor.setName("FrmAP_Vendor"); // NOI18N
        jmniFrmAP_Vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAP_VendorActionPerformed(evt);
            }
        });
        jMenu3.add(jmniFrmAP_Vendor);

        jMenuItem1.setText("Distribution Set Code");
        jMenuItem1.setName("FrmAp_distseth"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jmniFrmAp_accset.setText("Account Set");
        jmniFrmAp_accset.setName("FrmAp_accset"); // NOI18N
        jmniFrmAp_accset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAp_accsetActionPerformed(evt);
            }
        });
        jmniFrmAp_accset.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jmniFrmAp_accsetAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenu3.add(jmniFrmAp_accset);

        jmniFrmAp_distcode.setText("Distribution Code");
        jmniFrmAp_distcode.setName("FrmAp_distcode"); // NOI18N
        jmniFrmAp_distcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAp_distcodeActionPerformed(evt);
            }
        });
        jMenu3.add(jmniFrmAp_distcode);

        jmniFrmAp_vendorgrp.setText("Distribution Group");
        jmniFrmAp_vendorgrp.setName("FrmAp_vendorgrp"); // NOI18N
        jmniFrmAp_vendorgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAp_vendorgrpActionPerformed(evt);
            }
        });
        jMenu3.add(jmniFrmAp_vendorgrp);

        jmnMaster.add(jMenu3);

        jmnuCashBook.setText("Cashbook");
        jmnuCashBook.setToolTipText("Cash Book");

        jmniMasterBank.setText("Bank");
        jmniMasterBank.setName("FrmCb_bank"); // NOI18N
        jmniMasterBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterBankActionPerformed(evt);
            }
        });
        jmnuCashBook.add(jmniMasterBank);

        jmniCB_Source.setText("Source");
        jmniCB_Source.setName("FrmCb_source"); // NOI18N
        jmniCB_Source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniCB_SourceActionPerformed(evt);
            }
        });
        jmnuCashBook.add(jmniCB_Source);

        jmnMaster.add(jmnuCashBook);

        jMenu1.setText("Option");

        jmniMasterCurrency.setText("Currency");
        jmniMasterCurrency.setName("FrmGl_currency"); // NOI18N
        jmniMasterCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterCurrencyActionPerformed(evt);
            }
        });
        jMenu1.add(jmniMasterCurrency);

        jmniOp_paymentterm.setText("Payment Term");
        jmniOp_paymentterm.setName("FrmOp_paymentterm"); // NOI18N
        jmniOp_paymentterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniOp_paymenttermActionPerformed(evt);
            }
        });
        jMenu1.add(jmniOp_paymentterm);

        jmniAddressType.setText("Address Type");
        jmniAddressType.setName("FrmOp_addrtype"); // NOI18N
        jmniAddressType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAddressTypeActionPerformed(evt);
            }
        });
        jMenu1.add(jmniAddressType);

        jmniphoneType.setText("Phone Type");
        jmniphoneType.setName("FrmOp_phonetype"); // NOI18N
        jmniphoneType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniphoneTypeActionPerformed(evt);
            }
        });
        jMenu1.add(jmniphoneType);

        jmniTax.setText("Tax");
        jmniTax.setName("FrmOp_tax"); // NOI18N
        jmniTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniTaxActionPerformed(evt);
            }
        });
        jMenu1.add(jmniTax);

        jmnMaster.add(jMenu1);

        jMenuMain.add(jmnMaster);

        jmnTransaksi.setMnemonic('T');
        jmnTransaksi.setText("Transaksi");

        jmnuTransaksiGL.setText("General Ledger");

        jmniGlJournalEntry.setText("Journal Entry");
        jmniGlJournalEntry.setName("FrmGl_batchlist"); // NOI18N
        jmniGlJournalEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniGlJournalEntryActionPerformed(evt);
            }
        });
        jmnuTransaksiGL.add(jmniGlJournalEntry);

        jmniGlJournalEntryList.setText("G/L Journal Entry List");
        jmniGlJournalEntryList.setName("FrmGL_JournalEntryList"); // NOI18N
        jmniGlJournalEntryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniGlJournalEntryListActionPerformed(evt);
            }
        });
        jmnuTransaksiGL.add(jmniGlJournalEntryList);

        jmniFrmGL_PostJournalEntryBatches.setText("G/L Post Journal Entry Batches");
        jmniFrmGL_PostJournalEntryBatches.setName("FrmAP_PostInvoiceBatches"); // NOI18N
        jmniFrmGL_PostJournalEntryBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmGL_PostJournalEntryBatchesActionPerformed(evt);
            }
        });
        jmnuTransaksiGL.add(jmniFrmGL_PostJournalEntryBatches);

        jmnTransaksi.add(jmnuTransaksiGL);

        jmnuTransaksiAR.setText("Account Recieveable");

        jmnuiAR_InvoiceEntry.setText("AR Invoice Entry");
        jmnuiAR_InvoiceEntry.setName("FrmAr_invbatchlist"); // NOI18N
        jmnuiAR_InvoiceEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAR_InvoiceEntryActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmnuiAR_InvoiceEntry);

        jmnuiAR_InvoiceBatchList.setText("AR Invoice Batch List");
        jmnuiAR_InvoiceBatchList.setName("FrmAr_invh"); // NOI18N
        jmnuiAR_InvoiceBatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAR_InvoiceBatchListActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmnuiAR_InvoiceBatchList);

        jmnuiAr_rcpbatchlist.setText("AR Receipt Entry");
        jmnuiAr_rcpbatchlist.setName("FrmAr_rcpbatchlist"); // NOI18N
        jmnuiAr_rcpbatchlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAr_rcpbatchlistActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmnuiAr_rcpbatchlist);

        jmnuiAr_rcpbatchlistprocess.setText("AR Receipt Batch List");
        jmnuiAr_rcpbatchlistprocess.setName("FrmAr_rcph"); // NOI18N
        jmnuiAr_rcpbatchlistprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAr_rcpbatchlistprocessActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmnuiAr_rcpbatchlistprocess);

        jmniFrmAR_BatchGLPosting.setText("AR Batch GL Posting");
        jmniFrmAR_BatchGLPosting.setName("FrmAR_BatchGLPosting"); // NOI18N
        jmniFrmAR_BatchGLPosting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAR_BatchGLPostingActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmniFrmAR_BatchGLPosting);

        jmniFrmAR_PostInvoiceBatches.setText("AR Post Invoice  Batches");
        jmniFrmAR_PostInvoiceBatches.setName("FrmAR_PostInvoiceBatches"); // NOI18N
        jmniFrmAR_PostInvoiceBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAR_PostInvoiceBatchesActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmniFrmAR_PostInvoiceBatches);

        jmniFrmAR_PostReceiptBatches.setText("AR Post Receipt  Batches");
        jmniFrmAR_PostReceiptBatches.setName("FrmAR_PostReceiptBatches"); // NOI18N
        jmniFrmAR_PostReceiptBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAR_PostReceiptBatchesActionPerformed(evt);
            }
        });
        jmnuTransaksiAR.add(jmniFrmAR_PostReceiptBatches);

        jMenu5.setText("AR Adjusment");

        jmniARAdjusmentEntry.setText("AR Adjustment Entry");
        jmniARAdjusmentEntry.setName("Frmaradjustmententry"); // NOI18N
        jmniARAdjusmentEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniARAdjusmentEntryActionPerformed(evt);
            }
        });
        jMenu5.add(jmniARAdjusmentEntry);

        jmnuiAr_InvoiceBatchList.setText("AR Adjustment Batch List");
        jmnuiAr_InvoiceBatchList.setName("Frmaradjustmentbatchlist"); // NOI18N
        jmnuiAr_InvoiceBatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAr_InvoiceBatchListActionPerformed(evt);
            }
        });
        jMenu5.add(jmnuiAr_InvoiceBatchList);

        jmniFrmAR_PostAdjustmentBatches.setText("AR Post Adjustment  Batches");
        jmniFrmAR_PostAdjustmentBatches.setName("FrmAR_PostAdjustmentBatches"); // NOI18N
        jmniFrmAR_PostAdjustmentBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAR_PostAdjustmentBatchesActionPerformed(evt);
            }
        });
        jMenu5.add(jmniFrmAR_PostAdjustmentBatches);

        jmnuTransaksiAR.add(jMenu5);

        jmnTransaksi.add(jmnuTransaksiAR);

        jmnuTransaksiAP.setText("Account Payable");

        jmnuiAP_InvoiceEntry.setText("AP Invoice Entry");
        jmnuiAP_InvoiceEntry.setName("FrmAp_invbatchlist"); // NOI18N
        jmnuiAP_InvoiceEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAP_InvoiceEntryActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmnuiAP_InvoiceEntry);

        jmnuiAp_rcpbatchlistprocess.setText("AP Invoice Batch List");
        jmnuiAp_rcpbatchlistprocess.setName("FrmAp_invh"); // NOI18N
        jmnuiAp_rcpbatchlistprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAp_rcpbatchlistprocessActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmnuiAp_rcpbatchlistprocess);

        jmnuiAp_paybatchlist.setText("AP Payment Entry");
        jmnuiAp_paybatchlist.setName("FrmAp_paybatchlist"); // NOI18N
        jmnuiAp_paybatchlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAp_paybatchlistActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmnuiAp_paybatchlist);

        jmnuiAp_paybatchlistpro.setText("AP Payment Batch List");
        jmnuiAp_paybatchlistpro.setName("FrmAp_paybatchlistpro"); // NOI18N
        jmnuiAp_paybatchlistpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAp_paybatchlistproActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmnuiAp_paybatchlistpro);

        jmniFrmAP_BatchGLPosting.setText("AP Batch GL Posting");
        jmniFrmAP_BatchGLPosting.setName("FrmAP_BatchGLPosting"); // NOI18N
        jmniFrmAP_BatchGLPosting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAP_BatchGLPostingActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmniFrmAP_BatchGLPosting);

        jmniFrmAP_PostInvoiceBatches.setText("AP Post Invoice  Batches");
        jmniFrmAP_PostInvoiceBatches.setName("FrmAP_PostInvoiceBatches"); // NOI18N
        jmniFrmAP_PostInvoiceBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAP_PostInvoiceBatchesActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmniFrmAP_PostInvoiceBatches);

        jmniFrmAP_PostPaymentBatches.setText("AP Post Payment  Batches");
        jmniFrmAP_PostPaymentBatches.setName("FrmAP_PostPaymentBatches"); // NOI18N
        jmniFrmAP_PostPaymentBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAP_PostPaymentBatchesActionPerformed(evt);
            }
        });
        jmnuTransaksiAP.add(jmniFrmAP_PostPaymentBatches);

        jMenu4.setText("Adjusment");

        jmniAPAdjusmentEntry.setText("AP Adjustment Entry");
        jmniAPAdjusmentEntry.setName("Frmapadjustmententry"); // NOI18N
        jmniAPAdjusmentEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAPAdjusmentEntryActionPerformed(evt);
            }
        });
        jMenu4.add(jmniAPAdjusmentEntry);

        jmnuiAp_InvoiceBatchList.setText("AP Adjustment Batch List");
        jmnuiAp_InvoiceBatchList.setName("Frmapadjustmentbatchlist"); // NOI18N
        jmnuiAp_InvoiceBatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuiAp_InvoiceBatchListActionPerformed(evt);
            }
        });
        jMenu4.add(jmnuiAp_InvoiceBatchList);

        jmniFrmAP_PostAdjustmentBatches.setText("AP Post Adjustment Batches");
        jmniFrmAP_PostAdjustmentBatches.setName("FrmAP_PostAdjustmentBatches"); // NOI18N
        jmniFrmAP_PostAdjustmentBatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAP_PostAdjustmentBatchesActionPerformed(evt);
            }
        });
        jMenu4.add(jmniFrmAP_PostAdjustmentBatches);

        jmnuTransaksiAP.add(jMenu4);

        jmnTransaksi.add(jmnuTransaksiAP);

        jmnuTransaksiCashBook.setText("Cash Book");
        jmnuTransaksiCashBook.setToolTipText("Cash Book");

        jmniCb_batchcontrol.setText("Batch Control");
        jmniCb_batchcontrol.setName("FrmCb_batchcontrol"); // NOI18N
        jmniCb_batchcontrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniCb_batchcontrolActionPerformed(evt);
            }
        });
        jmnuTransaksiCashBook.add(jmniCb_batchcontrol);

        jmniFrmCb_batchentry.setText("Batch Entry");
        jmniFrmCb_batchentry.setName("FrmCb_batchentry"); // NOI18N
        jmniFrmCb_batchentry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmCb_batchentryActionPerformed(evt);
            }
        });
        jmnuTransaksiCashBook.add(jmniFrmCb_batchentry);

        jmniFrmCb_batchposting.setText("Batch Posting");
        jmniFrmCb_batchposting.setName("FrmCb_batchposting"); // NOI18N
        jmniFrmCb_batchposting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmCb_batchpostingActionPerformed(evt);
            }
        });
        jmnuTransaksiCashBook.add(jmniFrmCb_batchposting);

        jmniFrmCb_batchGLposting.setText("Transfer To G/L");
        jmniFrmCb_batchGLposting.setName("FrmCb_batchGLposting"); // NOI18N
        jmniFrmCb_batchGLposting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmCb_batchGLpostingActionPerformed(evt);
            }
        });
        jmnuTransaksiCashBook.add(jmniFrmCb_batchGLposting);

        jmniFrmCb_voucher.setText("Payment Voucher Entry");
        jmniFrmCb_voucher.setName("FrmCb_voucherh"); // NOI18N
        jmniFrmCb_voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmCb_voucherActionPerformed(evt);
            }
        });
        jmnuTransaksiCashBook.add(jmniFrmCb_voucher);

        jmnTransaksi.add(jmnuTransaksiCashBook);

        jmnuCostAccounting.setText("Cost Accounting");

        jmniScreenCost.setText("Screen Cost");
        jmniScreenCost.setName("FrmCostAccounting"); // NOI18N
        jmniScreenCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniScreenCostActionPerformed(evt);
            }
        });
        jmnuCostAccounting.add(jmniScreenCost);

        jmnTransaksi.add(jmnuCostAccounting);

        jmnuInvoiceValidation.setText("Invoice Validation");

        jmniInvoiceValidation.setText("Invoice Validation");
        jmniInvoiceValidation.setName("FrmInvoiceValidation"); // NOI18N
        jmniInvoiceValidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniInvoiceValidationActionPerformed(evt);
            }
        });
        jmnuInvoiceValidation.add(jmniInvoiceValidation);

        jmnTransaksi.add(jmnuInvoiceValidation);

        jMenuMain.add(jmnTransaksi);

        jmnLaporan.setMnemonic('L');
        jmnLaporan.setText("Laporan/Form");

        jmnuLaporanMasterGL.setText("General Ledger");

        jMenu14.setText("Setup Reports");

        jMenuItem17.setText("Master GL Account");
        jMenuItem17.setName("FrmPrintMasterGLAccountCode"); // NOI18N
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem17);

        jmniLaporanMasterGLSourceCode.setText("Master Source Codes");
        jmniLaporanMasterGLSourceCode.setName("FrmGl_sourcelgr"); // NOI18N
        jmniLaporanMasterGLSourceCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterGLSourceCodeActionPerformed(evt);
            }
        });
        jMenu14.add(jmniLaporanMasterGLSourceCode);

        jmnuLaporanMasterGL.add(jMenu14);

        jMenu15.setText("Processing Reports");

        jMenuItem19.setText("Financial Master Setting ");
        jMenuItem19.setName("FrmPrintMasterGLFinancialSettingReport"); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem19);

        jmniLaporanTransaksiGlJournalEntry.setText("GL Transaction Batch Listing");
        jmniLaporanTransaksiGlJournalEntry.setName("FrmPrintTransaksiGLJournal"); // NOI18N
        jmniLaporanTransaksiGlJournalEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanTransaksiGlJournalEntryActionPerformed(evt);
            }
        });
        jMenu15.add(jmniLaporanTransaksiGlJournalEntry);

        jMenuItem5.setText("GL Batch Satus Listing");
        jMenuItem5.setName("FrmPrintTransaksiGLStatusBatch"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem5);

        jMenuItem9.setText("GL Account Code Transaction Listing");
        jMenuItem9.setName("FrmPrintTransaksiGLByAccCode"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem9);

        jMenuItem10.setText("GL Trial Balance");
        jMenuItem10.setName("FrmPrintTrialBalance "); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed1(evt);
            }
        });
        jMenu15.add(jMenuItem10);

        jMenuItem18.setText("GL Financial Report");
        jMenuItem18.setName("FrmPrintTransaksiGLFinancialReport"); // NOI18N
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem18);

        jMenuItem11.setText("G/L Provisional Posting Journal");
        jMenuItem11.setName("FrmPrintTrialBalance "); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed1(evt);
            }
        });
        jMenu15.add(jMenuItem11);

        jMenuItem8.setText("GL Print Voucher Journal Entry");
        jMenuItem8.setName("FrmPrintVoucher_je_rpt"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem8);

        jmnuLaporanMasterGL.add(jMenu15);

        jmnLaporan.add(jmnuLaporanMasterGL);

        jmnuLaporanMasterAR.setText("Acccunt Receivable");
        jmnuLaporanMasterAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuLaporanMasterARActionPerformed(evt);
            }
        });

        jMenu6.setText("Setup Reports");

        jmniLaporanMasterFrmAr_accset.setText("Master AR Account Set");
        jmniLaporanMasterFrmAr_accset.setName("FrmAr_accset"); // NOI18N
        jmniLaporanMasterFrmAr_accset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAr_accsetActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterFrmAr_accset);

        jmniLaporanMasterFrmAr_custgrp.setText("Master AR Customer Group");
        jmniLaporanMasterFrmAr_custgrp.setName("FrmAr_custgrp"); // NOI18N
        jmniLaporanMasterFrmAr_custgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAr_custgrpActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterFrmAr_custgrp);

        jmniLaporanMasterAr_billcycl.setText("Master AR Bill Cycle");
        jmniLaporanMasterAr_billcycl.setName("FrmAr_billcycl"); // NOI18N
        jmniLaporanMasterAr_billcycl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterAr_billcyclActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterAr_billcycl);

        jmniLaporanMasterAr_interest.setText("Master AR Interest");
        jmniLaporanMasterAr_interest.setName("FrmAr_interest"); // NOI18N
        jmniLaporanMasterAr_interest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterAr_interestActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterAr_interest);

        jmniLaporanMasterAr_NationalAccount.setText("Master AR National Account");
        jmniLaporanMasterAr_NationalAccount.setName("FrmAr_custnat"); // NOI18N
        jmniLaporanMasterAr_NationalAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterAr_NationalAccountActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterAr_NationalAccount);

        jmniLaporanMasterArCustomer.setText("Master AR Customer");
        jmniLaporanMasterArCustomer.setName("FrmAr_customer"); // NOI18N
        jmniLaporanMasterArCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterArCustomerActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterArCustomer);

        jmniLaporanMasterArDistributionCode.setText("Master AR Distribution Code");
        jmniLaporanMasterArDistributionCode.setName("FrmAr_distcode"); // NOI18N
        jmniLaporanMasterArDistributionCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterArDistributionCodeActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterArDistributionCode);

        jmniLaporanMasterArOptionalDetail.setText("Master AR Optional Detail");
        jmniLaporanMasterArOptionalDetail.setName("FrmAr_optiionaldetail1"); // NOI18N
        jmniLaporanMasterArOptionalDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterArOptionalDetailActionPerformed(evt);
            }
        });
        jMenu6.add(jmniLaporanMasterArOptionalDetail);

        jmnuLaporanMasterAR.add(jMenu6);

        jMenu7.setText("Processing Reports");

        jMenuItem7.setText("AR Batch Listing");
        jMenuItem7.setName("FrmPrintTransaksiARBatchList"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem6.setText("AR Batch Status");
        jMenuItem6.setName("FrmPrintTransaksiARBatchListStatus"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed1(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenuItem12.setText("AR GL Transcation");
        jMenuItem12.setName("FrmPrintTransaksiARGL"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jmnuLaporanMasterAR.add(jMenu7);

        jMenu8.setText("Analytical Reports");

        jMenuItem13.setText("AR Aged Trial Balance");
        jMenuItem13.setName("FrmPrintTransaksiARAging"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem13);

        jMenuItem14.setText("AR Custommer Transaction");
        jMenuItem14.setName("FrmPrintTransaksiARCustommer"); // NOI18N
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem14);

        jmnuLaporanMasterAR.add(jMenu8);

        jmnLaporan.add(jmnuLaporanMasterAR);

        jmnuLaporanMasterAP.setText("Account Payable");

        jMenu9.setText("Setup Reports");

        jmniLaporanMasterFrmAP_Vendor.setText("AP Vendor");
        jmniLaporanMasterFrmAP_Vendor.setName("FrmAP_Vendor"); // NOI18N
        jmniLaporanMasterFrmAP_Vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAP_VendorActionPerformed1(evt);
            }
        });
        jMenu9.add(jmniLaporanMasterFrmAP_Vendor);

        jmniLaporanMasterDistSetCode.setText("Distribution Set Code");
        jmniLaporanMasterDistSetCode.setName("FrmAp_distseth"); // NOI18N
        jmniLaporanMasterDistSetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterDistSetCodeActionPerformed(evt);
            }
        });
        jMenu9.add(jmniLaporanMasterDistSetCode);

        jmniLaporanMasterFrmAp_accset.setText("Account Set");
        jmniLaporanMasterFrmAp_accset.setName("FrmAp_accset"); // NOI18N
        jmniLaporanMasterFrmAp_accset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAp_accsetActionPerformed(evt);
            }
        });
        jmniLaporanMasterFrmAp_accset.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jmniLaporanMasterFrmAp_accsetAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenu9.add(jmniLaporanMasterFrmAp_accset);

        jmniLaporanMasterFrmAp_distcode.setText("Distribution Code");
        jmniLaporanMasterFrmAp_distcode.setName("FrmAp_distcode"); // NOI18N
        jmniLaporanMasterFrmAp_distcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAp_distcodeActionPerformed(evt);
            }
        });
        jMenu9.add(jmniLaporanMasterFrmAp_distcode);

        jmniLaporanMasterFrmAp_vendorgrp.setText("Distribution Group");
        jmniLaporanMasterFrmAp_vendorgrp.setName("FrmAp_vendorgrp"); // NOI18N
        jmniLaporanMasterFrmAp_vendorgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterFrmAp_vendorgrpActionPerformed(evt);
            }
        });
        jMenu9.add(jmniLaporanMasterFrmAp_vendorgrp);

        jmnuLaporanMasterAP.add(jMenu9);

        jMenu10.setText("Processing Reports");

        jmniLaporanTransaksiAp_rcpbatchlistprocess.setText("AP Batch Listing");
        jmniLaporanTransaksiAp_rcpbatchlistprocess.setName("FrmAp_invh"); // NOI18N
        jmniLaporanTransaksiAp_rcpbatchlistprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanTransaksiAp_rcpbatchlistprocessActionPerformed(evt);
            }
        });
        jMenu10.add(jmniLaporanTransaksiAp_rcpbatchlistprocess);

        jMenuItem2.setText("AP Batch Satus");
        jMenuItem2.setName("FrmPrintTransaksiAPBatchListStatus"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed1(evt);
            }
        });
        jMenu10.add(jMenuItem2);

        jmnuLaporanMasterAP.add(jMenu10);

        jMenu11.setText("Analytical Reports");

        jmnuFrmAP_aging_process.setText("AP Aging Process");
        jmnuFrmAP_aging_process.setToolTipText("AP Aging Process");
        jmnuFrmAP_aging_process.setName("FrmAP_aging_process"); // NOI18N
        jmnuFrmAP_aging_process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuFrmAP_aging_processActionPerformed(evt);
            }
        });
        jMenu11.add(jmnuFrmAP_aging_process);

        jmniAPAgedPayables.setText("AP Aged Payables");
        jmniAPAgedPayables.setName("FrmPrintApAged"); // NOI18N
        jmniAPAgedPayables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniAPAgedPayablesActionPerformed(evt);
            }
        });
        jMenu11.add(jmniAPAgedPayables);

        jMenuItem3.setText("AP Vendor Transaction");
        jMenuItem3.setName("FrmPrintTransaksiAPVendor"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem3);

        jmnuLaporanMasterAP.add(jMenu11);

        jmnLaporan.add(jmnuLaporanMasterAP);

        jmnuLaporanMasterCashBook.setText("Cash Book");
        jmnuLaporanMasterCashBook.setToolTipText("Cash Book");

        jMenu12.setText("Setup Reports");

        jmniLaporanCBMasterMasterBank.setText("Master Bank");
        jmniLaporanCBMasterMasterBank.setName("FrmCb_bank"); // NOI18N
        jmniLaporanCBMasterMasterBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanCBMasterMasterBankActionPerformed(evt);
            }
        });
        jMenu12.add(jmniLaporanCBMasterMasterBank);

        jmniLaporanMasterCBSource.setText("Master Source");
        jmniLaporanMasterCBSource.setName("FrmCb_source"); // NOI18N
        jmniLaporanMasterCBSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLaporanMasterCBSourceActionPerformed(evt);
            }
        });
        jMenu12.add(jmniLaporanMasterCBSource);

        jmnuLaporanMasterCashBook.add(jMenu12);

        jMenu13.setText("Processing Reports");

        jMenuItem4.setText("CB Batch Listing");
        jMenuItem4.setName("FrmPrintTransaksiCBBatchList"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem4);

        jmniCBRegisterEntry.setText("CB Register Entry");
        jmniCBRegisterEntry.setName("FrmPrintCBRegisterEntry"); // NOI18N
        jmniCBRegisterEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniCBRegisterEntryActionPerformed(evt);
            }
        });
        jMenu13.add(jmniCBRegisterEntry);

        jmniCBVoucher.setText("CB Voucher");
        jmniCBVoucher.setName("FrmPrintCBVoucher"); // NOI18N
        jmniCBVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniCBVoucherActionPerformed(evt);
            }
        });
        jMenu13.add(jmniCBVoucher);

        jmniCBVoucherReal.setText("CB Voucher Real");
        jmniCBVoucherReal.setName("FrmPrintCBVoucherFrCB"); // NOI18N
        jmniCBVoucherReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniCBVoucherRealActionPerformed(evt);
            }
        });
        jMenu13.add(jmniCBVoucherReal);

        jMenuItem15.setText("CB Cash Advance Monitoring");
        jMenuItem15.setName("FrmPrintCb_cash_advance"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem15);

        jmnuLaporanMasterCashBook.add(jMenu13);

        jmnLaporan.add(jmnuLaporanMasterCashBook);

        jMenuMain.add(jmnLaporan);

        jmnuSystem.setMnemonic('O');
        jmnuSystem.setText("Tools");

        jmniGenerate.setText("Generate Table");
        jmniGenerate.setName("FrmGenerateTable"); // NOI18N
        jmniGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniGenerateActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniGenerate);

        jmniUser.setText("User");
        jmniUser.setName("FrmMasteruser"); // NOI18N
        jmniUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniUserActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniUser);

        jmniResetPassword.setText("Reset Password");
        jmniResetPassword.setName("Reset Password"); // NOI18N
        jmniResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniResetPasswordActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniResetPassword);

        jmniGroup.setText("Group");
        jmniGroup.setName("FrmMastergroup"); // NOI18N
        jmniGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniGroupActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniGroup);

        jmniModule.setText("Module");
        jmniModule.setName("FrmMastermodule"); // NOI18N
        jmniModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniModuleActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniModule);

        jmniMasterCompany.setText("Company");
        jmniMasterCompany.setName("FrmMasterCompany"); // NOI18N
        jmniMasterCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniMasterCompanyActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniMasterCompany);

        jmniut_External_Data.setText("External Data Setting");
        jmniut_External_Data.setName("FrmUt_external_data"); // NOI18N
        jmniut_External_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniut_External_DataActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniut_External_Data);

        jmniFrmAR_invoice_creator.setText("CPP A/R Invoice Otomatis");
        jmniFrmAR_invoice_creator.setName("FrmAR_invoice_creator"); // NOI18N
        jmniFrmAR_invoice_creator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniFrmAR_invoice_creatorActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniFrmAR_invoice_creator);

        jmniLogOut.setText("Log Out");
        jmniLogOut.setName("LogOut"); // NOI18N
        jmniLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniLogOutActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniLogOut);

        jmniExit.setText("Exit");
        jmniExit.setName("Exit"); // NOI18N
        jmniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniExitActionPerformed(evt);
            }
        });
        jmnuSystem.add(jmniExit);

        jMenuMain.add(jmnuSystem);
        jMenuMain.add(jmnuHelp);

        setJMenuBar(jMenuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblSystemDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSystemDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblUser)
                    .addComponent(jLblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(1020, 885));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.newData();//GEN-LAST:event_btnNewActionPerformed
        setCursor(GlobalUtils.NORMALCURSOR);
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);
        
    }
}                                      

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    try {
        
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.saveData();
        setCursor(GlobalUtils.NORMALCURSOR);
        
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

}//GEN-LAST:event_btnSaveActionPerformed

private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
    try {
        int n=JOptionPane.showConfirmDialog(this,"Undo this data?","Undo data",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_NO_OPTION){
           setCursor(GlobalUtils.HOURGLASSCURSOR);
           nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
           nfi.undo();
           setCursor(GlobalUtils.NORMALCURSOR);
        }
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnUndoActionPerformed

private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
    try {
        int n=JOptionPane.showConfirmDialog(this,"Delete this data?","Delete data",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_NO_OPTION){
           setCursor(GlobalUtils.HOURGLASSCURSOR);
           nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
           nfi.delete();
           setCursor(GlobalUtils.NORMALCURSOR);
        }
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnDelActionPerformed

private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.moveFirst();
        setCursor(GlobalUtils.NORMALCURSOR);
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);        
    }
}//GEN-LAST:event_btnFirstActionPerformed

private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.movePrevious();
        setCursor(GlobalUtils.NORMALCURSOR);
    } catch (CodeException ex) {
        
    }
}//GEN-LAST:event_btnPrevActionPerformed

private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.moveNext();
        setCursor(GlobalUtils.NORMALCURSOR);
    } catch (CodeException ex) {
        
    }
}//GEN-LAST:event_btnNextActionPerformed

private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.moveLast();
        setCursor(GlobalUtils.NORMALCURSOR);
    } catch (CodeException ex) {
        setCursor(GlobalUtils.NORMALCURSOR);        
    }
}//GEN-LAST:event_btnLastActionPerformed

private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
    try {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        if (jDesktopPane1.getSelectedFrame() instanceof NavigatorFormInt) {
            nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
            nfi.execute();
        }else if (jDesktopPane1.getSelectedFrame() instanceof NavigatorFormReportInt) {
            nrfi = (NavigatorFormReportInt) jDesktopPane1.getSelectedFrame();
            nrfi.execute();
        }
        setCursor(GlobalUtils.NORMALCURSOR);

        
    } catch (CodeException ex) {
         setCursor(GlobalUtils.NORMALCURSOR);       
    }
}//GEN-LAST:event_btnConfirmActionPerformed

private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    setToolBar(-1,0);
    if(jDesktopPane1.getAllFrames().length > 0){
            jDesktopPane1.getSelectedFrame().doDefaultCloseAction();
            jDesktopPane1.selectFrame(true);
            if(jDesktopPane1.getSelectedFrame()==null){
                jDesktopPane1.selectFrame(false);                
            }
        }
}//GEN-LAST:event_btnCloseActionPerformed

private void btnPrevScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevScreenActionPerformed
        //jDesktopPane1.getSelectedFrame().moveToBack();
        jDesktopPane1.selectFrame(false);
}//GEN-LAST:event_btnPrevScreenActionPerformed

private void btnNextScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextScreenActionPerformed
        //jDesktopPane1.getSelectedFrame().toBack();
        jDesktopPane1.selectFrame(true);
}//GEN-LAST:event_btnNextScreenActionPerformed

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            this.setLocationRelativeTo(null);//GEN-LAST:event_formWindowOpened

            
}                                 

private void btnExTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExTxtActionPerformed
    

    
    setCursor(GlobalUtils.HOURGLASSCURSOR);
    try {
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.exportText();
    } catch (CodeException ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());        
    }    
    setCursor(GlobalUtils.NORMALCURSOR);//GEN-LAST:event_btnExTxtActionPerformed

}                                        

private void btnImpXlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpXlsActionPerformed
    
    
    
    
    setCursor(GlobalUtils.HOURGLASSCURSOR);
    try {
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.importCsv();
    } catch (CodeException ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
    }    
    setCursor(GlobalUtils.NORMALCURSOR);//GEN-LAST:event_btnImpXlsActionPerformed

}                                         

private void btnImpTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpTxtActionPerformed
    setCursor(GlobalUtils.HOURGLASSCURSOR);

    try {
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.importText();
    } catch (CodeException ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());        
    }    
    setCursor(GlobalUtils.NORMALCURSOR);

}//GEN-LAST:event_btnImpTxtActionPerformed

private void btnExXlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExXlsActionPerformed
    setCursor(GlobalUtils.HOURGLASSCURSOR);
    try {
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.exportCsv();
    } catch (CodeException ex) {
        javax.swing.JOptionPane.showMessageDialog(this,ex.getMessage());        
    }    
    setCursor(GlobalUtils.NORMALCURSOR);

}//GEN-LAST:event_btnExXlsActionPerformed

private void jmniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniExitActionPerformed

    System.exit(0);
    
}//GEN-LAST:event_jmniExitActionPerformed

private void jmniGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniGenerateActionPerformed

    if (frmgeneratetable == null) {
        frmgeneratetable = new FrmGenerate();
    }
    
    frmgeneratetable.setVisible(true);


}//GEN-LAST:event_jmniGenerateActionPerformed

 


/*private void jmniMasterWIPActionPerformed(java.awt.event.ActionEvent evt) {                                         

}*/

private void jmniUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniUserActionPerformed
    try {
        if (frmmasteruser == null) {
            frmmasteruser = new FrmMasteruser(this);
            frmmasteruser.setTitle("Master User");
        }
        showForm(frmmasteruser);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniUserActionPerformed

private void jmniModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniModuleActionPerformed
    try {
        if (frmmastermodule == null) {
            frmmastermodule = new FrmMastermodule(this);
            frmmastermodule.setTitle("Master Module");
        }
        showForm(frmmastermodule);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniModuleActionPerformed



private void jmniNonMatrialProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniNonMatrialProsesActionPerformed

}//GEN-LAST:event_jmniNonMatrialProsesActionPerformed

private void jmniGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniGroupActionPerformed
     try {
        if (frmmastergroup == null) {
            frmmastergroup = new FrmMastergroup(this);
        }
        
        showForm(frmmastergroup);
        
    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniGroupActionPerformed

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    if (!bactivate) {
        logOff();
        bactivate = true;
    }
}//GEN-LAST:event_formWindowActivated

private void jmniLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLogOutActionPerformed
        
         
    logOff();

}//GEN-LAST:event_jmniLogOutActionPerformed

private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
    try {
        nfi = (NavigatorFormInt) jDesktopPane1.getSelectedFrame();
        nfi.printData();
    } catch (CodeException ex) {
        
    }
}//GEN-LAST:event_btnPrintActionPerformed

private void jmniResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniResetPasswordActionPerformed

    try {
        Masteruser mu = new Masteruser(Masteruser.PROPERTY_USER, GlobalUtils.userid);
        FrmResetPassword frp = new FrmResetPassword(mu);
        
        frp.setModal(true);
        frp.setVisible(true);
        
    }catch(Exception e) {}
    
    
}//GEN-LAST:event_jmniResetPasswordActionPerformed

private void jmniMasterBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterBankActionPerformed

 try {
        if (frmcbbank == null) {
            frmcbbank = new FrmCb_bank(this);
        }

        showForm(frmcbbank);

    }catch(Exception e) {
        e.printStackTrace();
    }


}//GEN-LAST:event_jmniMasterBankActionPerformed

private void jmniMasterAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterAccountActionPerformed
    // TODO add your handling code here:
    try {
        if (frmaccount == null) {
            frmaccount = new FrmGl_account(this);
        }

        showForm(frmaccount);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniMasterAccountActionPerformed

private void jmniMasterGLSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterGLSourceActionPerformed
    // TODO add your handling code here:
    try {
        if (frmsource == null) {
            frmsource = new FrmGl_sourcelgr(this);
        }

        showForm(frmsource);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniMasterGLSourceActionPerformed

private void jmniGlJournalEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniGlJournalEntryActionPerformed
    // TODO add your handling code here:
    try {
        if (frmjournalentry == null) {
            frmjournalentry = new FrmGl_batchlist(this);
        }

        showForm(frmjournalentry);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniGlJournalEntryActionPerformed

private void jmniCb_batchcontrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniCb_batchcontrolActionPerformed

     try {
        if (frmcbbatchcontrol == null) {
            frmcbbatchcontrol = new FrmCb_batchcontrol(this);
        }

        showForm(frmcbbatchcontrol);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniCb_batchcontrolActionPerformed

private void jmniFrmCb_batchentryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmCb_batchentryActionPerformed
     try {
        if (frmcbbatchentry == null) {
            frmcbbatchentry = new FrmCb_batchentry(this);
        }

        showForm(frmcbbatchentry);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmCb_batchentryActionPerformed

private void jmniCB_SourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniCB_SourceActionPerformed

 try {
        if (frmcbsource  == null) {
            frmcbsource = new FrmCb_source(this);
        }

        showForm(frmcbsource);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniCB_SourceActionPerformed

private void jmniMasterCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterCurrencyActionPerformed
  try {
        if (frmcurrency  == null) {
            frmcurrency = new FrmGl_currency(this);
        }

        showForm(frmcurrency);

    }catch(Exception e) {
        e.printStackTrace();
    }


}//GEN-LAST:event_jmniMasterCurrencyActionPerformed

private void jmniFrmAr_accsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAr_accsetActionPerformed
  try {
        if (frmaraccset  == null) {
            frmaraccset = new FrmAr_accset(this);
        }

        showForm(frmaraccset);

    }catch(Exception e) {
        e.printStackTrace();
    }

    
}//GEN-LAST:event_jmniFrmAr_accsetActionPerformed

private void jmniFrmAr_custgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAr_custgrpActionPerformed
  try {
        if (frmarcustgrp  == null) {
            frmarcustgrp = new FrmAr_custgrp(this);
        }

        showForm(frmarcustgrp);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAr_custgrpActionPerformed

private void jmniAr_billcyclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAr_billcyclActionPerformed
  try {
        if (frmarbillcycl  == null) {
            frmarbillcycl = new FrmAr_billcycl(this);
        }

        showForm(frmarbillcycl);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniAr_billcyclActionPerformed

private void jmniAr_interestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAr_interestActionPerformed
  try {
        if (frmarinterest  == null) {
            frmarinterest = new FrmAr_interest(this);
        }

        showForm(frmarinterest);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniAr_interestActionPerformed

private void jmniOp_paymenttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniOp_paymenttermActionPerformed

    try {
        if (frmoppaymentterm  == null) {
            frmoppaymentterm = new FrmOp_paymentterm(this);
        }

        showForm(frmoppaymentterm);

    }catch(Exception e) {
        e.printStackTrace();
    }


}//GEN-LAST:event_jmniOp_paymenttermActionPerformed

private void jmniAr_NationalAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAr_NationalAccountActionPerformed

      try {
        if (frmarnatacc  == null) {
            frmarnatacc = new FrmAr_custnat(this);
        }

        showForm(frmarnatacc);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniAr_NationalAccountActionPerformed

private void jmniAddressTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAddressTypeActionPerformed
      try {
        if (frmopaddresstype  == null) {
            frmopaddresstype = new FrmOp_addrtype(this);
        }

        showForm(frmopaddresstype);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniAddressTypeActionPerformed

private void jmniphoneTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniphoneTypeActionPerformed
      try {
        if (frmopphonetype  == null) {
            frmopphonetype = new FrmOp_phonetype(this);
        }

        showForm(frmopphonetype);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniphoneTypeActionPerformed

private void jmniArCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniArCustomerActionPerformed
      try {
        if (frmarcustomer  == null) {
            frmarcustomer = new FrmAr_customer(this);
        }

        showForm(frmarcustomer);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniArCustomerActionPerformed

private void jmniTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniTaxActionPerformed
      try {
        if (frmoptax  == null) {
            frmoptax = new FrmOp_tax(this);
        }

        showForm(frmoptax);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniTaxActionPerformed

private void jmniArDistributionCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniArDistributionCodeActionPerformed
    // TODO add your handling code here:
    try {
        if (frmardistributioncode  == null) {
            frmardistributioncode = new FrmAr_distcode(this);
        }

        showForm(frmardistributioncode);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniArDistributionCodeActionPerformed

private void jmnuiAR_InvoiceEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAR_InvoiceEntryActionPerformed
    // TODO add your handling code here:
    try {
        if (frmarinvoiceentry  == null) {
            frmarinvoiceentry = new FrmAr_invbatchlist(this);
        }

        showForm(frmarinvoiceentry);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAR_InvoiceEntryActionPerformed

private void jmniArOptionalDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniArOptionalDetail1ActionPerformed
    // TODO add your handling code here:
    try {
        if (frmaroptionaldetail  == null) {
            frmaroptionaldetail = new FrmAr_optiionaldetail1(this);
        }

        showForm(frmaroptionaldetail);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniArOptionalDetail1ActionPerformed

private void jmnuiAR_InvoiceBatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAR_InvoiceBatchListActionPerformed
    // TODO add your handling code here:
    try {
        if (frmarinvbatchlist  == null) {
            frmarinvbatchlist = new FrmAr_invh(this);
        }

        showForm(frmarinvbatchlist);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAR_InvoiceBatchListActionPerformed

private void jmnuiAr_rcpbatchlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAr_rcpbatchlistActionPerformed
    // TODO add your handling code here:
    try {
        if (Frmarrcpbatchlist  == null) {
            Frmarrcpbatchlist = new FrmAr_rcpbatchlist(this);
        }

        showForm(Frmarrcpbatchlist);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAr_rcpbatchlistActionPerformed

private void jmnuiAr_rcpbatchlistprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAr_rcpbatchlistprocessActionPerformed
    // TODO add your handling code here:

    try {
        if (FrmArrcph  == null) {
            FrmArrcph = new FrmAr_rcph(this);
        }

        showForm(FrmArrcph);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAr_rcpbatchlistprocessActionPerformed

private void jmniFrmAP_VendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAP_VendorActionPerformed
      try {
        if (frmapvendor  == null) {
            frmapvendor = new FrmAp_vendor(this);
        }

        showForm(frmapvendor);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmAP_VendorActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      try {
        if (frmapdistseth  == null) {
            frmapdistseth = new FrmAp_distseth(this);
        }

        showForm(frmapdistseth);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jmniFrmAp_accsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAp_accsetActionPerformed
      try {
        if (frmapaccset  == null) {
            frmapaccset = new FrmAp_accset(this);
        }

        showForm(frmapaccset);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAp_accsetActionPerformed

private void jmniFrmAp_accsetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jmniFrmAp_accsetAncestorAdded
    // TODO add your handling code here:
}//GEN-LAST:event_jmniFrmAp_accsetAncestorAdded

private void jmniFrmAp_distcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAp_distcodeActionPerformed

      try {
        if (frmapdistcode  == null) {
            frmapdistcode = new FrmAp_distcode(this);
        }

        showForm(frmapdistcode);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmAp_distcodeActionPerformed

private void jmniFrmAp_vendorgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAp_vendorgrpActionPerformed
      try {
        if (frmapvendorgrp  == null) {
            frmapvendorgrp = new FrmAp_vendorgrp(this);
        }

        showForm(frmapvendorgrp);

    }catch(Exception e) {
        e.printStackTrace();
    }}//GEN-LAST:event_jmniFrmAp_vendorgrpActionPerformed

private void jmnuiAP_InvoiceEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAP_InvoiceEntryActionPerformed
    // TODO add your handling code here:
    try {
        if (frmapinvoiceentry  == null) {
            frmapinvoiceentry = new FrmAp_invbatchlist(this);
        }

        showForm(frmapinvoiceentry);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAP_InvoiceEntryActionPerformed

private void jmnuiAp_rcpbatchlistprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAp_rcpbatchlistprocessActionPerformed
    try {
        if (frmapinvh  == null) {
            frmapinvh = new FrmAp_invh(this);
        }

        showForm(frmapinvh);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAp_rcpbatchlistprocessActionPerformed

private void jmnuiAp_paybatchlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAp_paybatchlistActionPerformed
    // TODO add your handling code here:
    try {
        if (frmappaybatchlist  == null) {
            frmappaybatchlist = new FrmAp_paybatchlist(this);
        }

        showForm(frmappaybatchlist);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAp_paybatchlistActionPerformed

private void jmniLaporanMasterCBSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterCBSourceActionPerformed
        FrmPrintMasterCBSourceAccount fprint = new FrmPrintMasterCBSourceAccount();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterCBSourceActionPerformed

private void jmniLaporanCBMasterMasterBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanCBMasterMasterBankActionPerformed
        FrmPrintMasterCBBank fprint = new FrmPrintMasterCBBank();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanCBMasterMasterBankActionPerformed

private void jmniLaporanTransaksiAp_rcpbatchlistprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanTransaksiAp_rcpbatchlistprocessActionPerformed
    FrmPrintTransaksiAPBatchListInvoice fp=new FrmPrintTransaksiAPBatchListInvoice();
    fp.setVisible(true);
}//GEN-LAST:event_jmniLaporanTransaksiAp_rcpbatchlistprocessActionPerformed

private void jmniLaporanMasterFrmAp_vendorgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAp_vendorgrpActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jmniLaporanMasterFrmAp_vendorgrpActionPerformed

private void jmniLaporanMasterFrmAp_distcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAp_distcodeActionPerformed
        FrmPrintMasterAPDistributionCodeLap fprint = new FrmPrintMasterAPDistributionCodeLap();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAp_distcodeActionPerformed

private void jmniLaporanMasterFrmAp_accsetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAp_accsetAncestorAdded
    // TODO add your handling code here:
}//GEN-LAST:event_jmniLaporanMasterFrmAp_accsetAncestorAdded

private void jmniLaporanMasterFrmAp_accsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAp_accsetActionPerformed
        FrmPrintMasterAPAccountSetLap fprint = new FrmPrintMasterAPAccountSetLap();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAp_accsetActionPerformed

private void jmniLaporanMasterDistSetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterDistSetCodeActionPerformed
        FrmPrintMasterAPDistributionSetCodeLap fprint = new FrmPrintMasterAPDistributionSetCodeLap();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterDistSetCodeActionPerformed

private void jmniLaporanMasterFrmAP_VendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAP_VendorActionPerformed
        FrmPrintMasterAPVendor fprint = new FrmPrintMasterAPVendor();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAP_VendorActionPerformed

private void jmniLaporanMasterArOptionalDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterArOptionalDetailActionPerformed
        FrmPrintMasterAROptionalDetail1 fprint = new FrmPrintMasterAROptionalDetail1();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterArOptionalDetailActionPerformed

private void jmniLaporanMasterArDistributionCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterArDistributionCodeActionPerformed
        FrmPrintMasterARDistributionCode fprint = new FrmPrintMasterARDistributionCode();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterArDistributionCodeActionPerformed

private void jmniLaporanMasterArCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterArCustomerActionPerformed
//        FrmPrintMasterARCustommerCode fprint = new FrmPrintMasterARCustommerCode();
//        fprint.setVisible(true);
        FrmPrintMasterARCustommer fprint = new FrmPrintMasterARCustommer();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterArCustomerActionPerformed

private void jmniLaporanMasterAr_NationalAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterAr_NationalAccountActionPerformed
        FrmPrintMasterARNationalAccount fprint = new FrmPrintMasterARNationalAccount();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterAr_NationalAccountActionPerformed

private void jmniLaporanMasterAr_interestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterAr_interestActionPerformed
        FrmPrintMasterARInterest fprint = new FrmPrintMasterARInterest();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterAr_interestActionPerformed

private void jmniLaporanMasterAr_billcyclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterAr_billcyclActionPerformed
        FrmPrintMasterARBillingCycle fprint = new FrmPrintMasterARBillingCycle();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterAr_billcyclActionPerformed

private void jmniLaporanMasterFrmAr_custgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAr_custgrpActionPerformed
        FrmPrintMasterARCustommerGroup fprint = new FrmPrintMasterARCustommerGroup();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAr_custgrpActionPerformed

private void jmniLaporanMasterFrmAr_accsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAr_accsetActionPerformed
        FrmPrintMasterARAccountSetLap fprint = new FrmPrintMasterARAccountSetLap();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAr_accsetActionPerformed

private void jmniLaporanTransaksiGlJournalEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanTransaksiGlJournalEntryActionPerformed
        FrmPrintTransaksiGLJournal fprint = new FrmPrintTransaksiGLJournal();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanTransaksiGlJournalEntryActionPerformed

private void jmniLaporanMasterGLSourceCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterGLSourceCodeActionPerformed
        FrmPrintMasterGLSourceCode fprint = new FrmPrintMasterGLSourceCode();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterGLSourceCodeActionPerformed

private void jmniFrmCb_batchpostingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmCb_batchpostingActionPerformed
    // TODO add your handling code here:
    try {
        if (FrmCbbatchposting == null) {
            FrmCbbatchposting = new FrmCb_batchposting(this);
        }

        showForm(FrmCbbatchposting);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmCb_batchpostingActionPerformed

private void jmniMasterGLCurrencyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterGLCurrencyRateActionPerformed
    // TODO add your handling code here:
    try {
        if (FrmGlcurrencyrateh == null) {
            FrmGlcurrencyrateh = new FrmGl_currencyrateh(this);
        }

        showForm(FrmGlcurrencyrateh);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniMasterGLCurrencyRateActionPerformed

private void jmnuiAp_paybatchlistproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAp_paybatchlistproActionPerformed
    // TODO add your handling code here:

    try {
        if (frmAppaybatchlistpro == null) {
            frmAppaybatchlistpro = new FrmAp_paybatchlistpro(this);
        }

        showForm(frmAppaybatchlistpro);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAp_paybatchlistproActionPerformed

private void jmniMasterGLFiscalCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterGLFiscalCalendarActionPerformed
    // TODO add your handling code here:
    try {
        if (FrmGlfiscalh == null) {
            FrmGlfiscalh = new FrmGl_fiscalh(this);
        }

        showForm(FrmGlfiscalh);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniMasterGLFiscalCalendarActionPerformed

private void jmniFrmCb_batchGLpostingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmCb_batchGLpostingActionPerformed
    // TODO add your handling code here:
    try {
        if (FrmCbbatchGLposting == null) {
            FrmCbbatchGLposting = new FrmCb_batchGLposting(this);
        }

        showForm(FrmCbbatchGLposting);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmCb_batchGLpostingActionPerformed

private void jmnuLaporanMasterARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuLaporanMasterARActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jmnuLaporanMasterARActionPerformed

private void jmniAPAdjusmentEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAPAdjusmentEntryActionPerformed
    try {
        if (frmapadjentry  == null) {
            frmapadjentry = new FrmAp_adjbatchlist(this);
        }

        showForm(frmapadjentry);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniAPAdjusmentEntryActionPerformed

private void jmnuiAp_InvoiceBatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAp_InvoiceBatchListActionPerformed

    try {
        if (frmapadjbatchlist  == null) {
            frmapadjbatchlist = new FrmAp_adjh(this);
        }

        showForm(frmapadjbatchlist);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmnuiAp_InvoiceBatchListActionPerformed

private void jmniFrmAP_BatchGLPostingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAP_BatchGLPostingActionPerformed
    try {
        if (frmapbatchglposting  == null) {
            frmapbatchglposting = new FrmAP_BatchGLPosting(this);
        }

        showForm(frmapbatchglposting);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmAP_BatchGLPostingActionPerformed

private void jmniAPAgedPayablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniAPAgedPayablesActionPerformed
        FrmPrintTransaksiAPAged fprint = new FrmPrintTransaksiAPAged();
        fprint.setVisible(true);
}//GEN-LAST:event_jmniAPAgedPayablesActionPerformed

private void jmniFrmAR_BatchGLPostingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAR_BatchGLPostingActionPerformed
    // TODO add your handling code here:
    try {
        if (frmarbatchglposting  == null) {
            frmarbatchglposting = new FrmAR_BatchGLPosting(this);
        }

        showForm(frmarbatchglposting);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAR_BatchGLPostingActionPerformed

private void jmniARAdjusmentEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniARAdjusmentEntryActionPerformed
    // TODO add your handling code here:
    try {
        if (frmaradjentry  == null) {
            frmaradjentry = new FrmAr_adjbatchlist(this);
        }

        showForm(frmaradjentry);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniARAdjusmentEntryActionPerformed

private void jmnuiAr_InvoiceBatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuiAr_InvoiceBatchListActionPerformed
    // TODO add your handling code here:
    try {
        if (frmaradjbatchlist  == null) {
            frmaradjbatchlist = new FrmAr_adjh(this);
        }

        showForm(frmaradjbatchlist);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmnuiAr_InvoiceBatchListActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    FrmPrintTransaksiAPBatchListStatus fp=new FrmPrintTransaksiAPBatchListStatus();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jmniFrmAP_PostInvoiceBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAP_PostInvoiceBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmpostinvoicebatches  == null) {
            frmpostinvoicebatches = new FrmAP_PostInvoiceBatches(this);
        }

        showForm(frmpostinvoicebatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAP_PostInvoiceBatchesActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    FrmPrintTransaksiAPVendor fp=new FrmPrintTransaksiAPVendor();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jmniFrmAP_PostPaymentBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAP_PostPaymentBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmpostpaymentbatches  == null) {
            frmpostpaymentbatches = new FrmAP_PostPaymentBatches(this);
        }

        showForm(frmpostpaymentbatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAP_PostPaymentBatchesActionPerformed

private void jmniFrmAP_PostAdjustmentBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAP_PostAdjustmentBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmpostadjustmentbatches  == null) {
            frmpostadjustmentbatches = new FrmAP_PostAdjustmentBatches(this);
        }

        showForm(frmpostadjustmentbatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAP_PostAdjustmentBatchesActionPerformed

private void jmniFrmAR_PostReceiptBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAR_PostReceiptBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmarpostreceiptbatches  == null) {
            frmarpostreceiptbatches = new FrmAR_PostReceiptBatches(this);
        }

        showForm(frmarpostreceiptbatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAR_PostReceiptBatchesActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    FrmPrintTransaksiCBBatchList fp=new FrmPrintTransaksiCBBatchList();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jmniGlJournalEntryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniGlJournalEntryListActionPerformed
    // TODO add your handling code here:
    try {
        if (frmgljournalentrylist  == null) {
            frmgljournalentrylist = new FrmGL_JournalEntryList(this);
        }

        showForm(frmgljournalentrylist);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniGlJournalEntryListActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    FrmPrintTransaksiGLStatusBatch fp=new FrmPrintTransaksiGLStatusBatch();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem5ActionPerformed

private void jmniFrmAR_PostInvoiceBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAR_PostInvoiceBatchesActionPerformed
    // TODO add your handling code here:

                // TODO add your handling code here:
    try {
        if (frmarpostinvoicebatches  == null) {
            frmarpostinvoicebatches = new FrmAR_PostInvoiceBatches(this);
        }

        showForm(frmarpostinvoicebatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAR_PostInvoiceBatchesActionPerformed

private void jmniFrmAR_PostAdjustmentBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAR_PostAdjustmentBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmarpostadjustmentbatches  == null) {
            frmarpostadjustmentbatches = new FrmAR_PostAdjustmentBatches(this);
        }

        showForm(frmarpostadjustmentbatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmAR_PostAdjustmentBatchesActionPerformed

private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    FrmPrintTransaksiARBatchListStatus fp=new FrmPrintTransaksiARBatchListStatus();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem6ActionPerformed

private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    FrmPrintTransaksiARBatchList fp=new FrmPrintTransaksiARBatchList();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem7ActionPerformed

private void jmniCBRegisterEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniCBRegisterEntryActionPerformed
   FrmPrintCBRegisterEntry fp=new FrmPrintCBRegisterEntry();
   fp.setVisible(true);
}//GEN-LAST:event_jmniCBRegisterEntryActionPerformed

private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    FrmPrintTransaksiGLByAccCode fp=new FrmPrintTransaksiGLByAccCode();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem9ActionPerformed

private void jmniFrmGL_PostJournalEntryBatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmGL_PostJournalEntryBatchesActionPerformed
    // TODO add your handling code here:
    try {
        if (frmpostjournalentrybatches  == null) {
            frmpostjournalentrybatches = new FrmGL_PostJournalEntryBatches(this);
        }

        showForm(frmpostjournalentrybatches);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniFrmGL_PostJournalEntryBatchesActionPerformed

private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
    FrmPrintTransaksiGLTrialBalance fp=new FrmPrintTransaksiGLTrialBalance();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem10ActionPerformed

private void jMenuItem6ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed1
    FrmPrintTransaksiARBatchListStatus fp=new  FrmPrintTransaksiARBatchListStatus();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem6ActionPerformed1

private void jMenuItem10ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed1
    FrmPrintTransaksiGLTrialBalance  fp=new FrmPrintTransaksiGLTrialBalance();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem10ActionPerformed1

private void jmniMasterCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniMasterCompanyActionPerformed
    // TODO add your handling code here:
    try {
        if (frmCompany == null) {
            frmCompany = new FrmCompany(this);
            frmCompany.setTitle("Master Company");
        }
        showForm(frmCompany);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniMasterCompanyActionPerformed

private void jmniARAgedTrialBalancebyDueDateActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniARAgedTrialBalancebyDueDateActionPerformed1
    FrmPrintTransaksiARAging fp=new FrmPrintTransaksiARAging();
    fp.setVisible(true);
}//GEN-LAST:event_jmniARAgedTrialBalancebyDueDateActionPerformed1

private void jmniLaporanMasterFrmAP_VendorActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniLaporanMasterFrmAP_VendorActionPerformed1
    // TODO add your handling code here:
   FrmPrintMasterAPVendor fp=new FrmPrintMasterAPVendor();
    fp.setVisible(true);
}//GEN-LAST:event_jmniLaporanMasterFrmAP_VendorActionPerformed1

private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
    FrmPrintCb_cash_advance fp=new FrmPrintCb_cash_advance();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem15ActionPerformed

private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
    try {
        if (FrmGlFinancialReportSetting == null) {
            FrmGlFinancialReportSetting  = new FrmSetting_financial_rpt(this);
        }

        showForm(FrmGlFinancialReportSetting);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jMenuItem16ActionPerformed

private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
    // TODO add your handling code here:
        FrmPrintMasterGLAccountCode fprint = new FrmPrintMasterGLAccountCode();
        fprint.setVisible(true);
}//GEN-LAST:event_jMenuItem17ActionPerformed

private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
    // TODO add your handling code here:
        FrmPrintTransaksiGLFinancialReport fprint = new FrmPrintTransaksiGLFinancialReport();
        fprint.setVisible(true);
}//GEN-LAST:event_jMenuItem18ActionPerformed

private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
    FrmPrintMasterGLFinancialSettingReport fp=new FrmPrintMasterGLFinancialSettingReport();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem19ActionPerformed

private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
   FrmPrintTransaksiARGL fp=new FrmPrintTransaksiARGL();
   fp.setVisible(true);
}//GEN-LAST:event_jMenuItem12ActionPerformed

private void jMenuItem2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed1
   FrmPrintTransaksiAPBatchListStatus fp=new FrmPrintTransaksiAPBatchListStatus();
   fp.setVisible(true);
}//GEN-LAST:event_jMenuItem2ActionPerformed1

private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        FrmPrintTransaksiARAging fprint = new FrmPrintTransaksiARAging();
        fprint.setVisible(true);
}//GEN-LAST:event_jMenuItem13ActionPerformed

private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
    FrmPrintTransaksiARCustommer fp=new FrmPrintTransaksiARCustommer();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem14ActionPerformed

private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Accounting Application (ACCPAC) - 2012 \n"
                                       +"General Ledger, Cashbook, Account Payable, Account Receivable \n"
                                       +"-------------------------------------- \n"
                                       +"Language Programming: Java \n"
                                       +"Database: MYSQL (Distrib 5.0.45) \n"
                                       +"Database Server: 178.1.0.209 | Subversion Server: 178.1.0.211 \n"
                                       +"Juli 2012 - IT MTG");

}//GEN-LAST:event_btnHelpActionPerformed

private void jmniut_External_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniut_External_DataActionPerformed
    // TODO add your handling code here:
    try {
        if (frmUt_external_data == null) {
            frmUt_external_data = new FrmUt_external_data(this);
            frmUt_external_data.setTitle("External Data Setting");
        }
        showForm(frmUt_external_data);

    }catch(Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jmniut_External_DataActionPerformed

private void jmniFrmAR_invoice_creatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmAR_invoice_creatorActionPerformed
    // TODO add your handling code here:
    try {
        if (frmAR_invoice_creator == null) {
            frmAR_invoice_creator = new FrmAR_invoice_creator(this);
            frmAR_invoice_creator.setTitle("A/R Invoice Creator");
        }
        showForm(frmAR_invoice_creator);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmAR_invoice_creatorActionPerformed

private void jmniFrmCb_voucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmCb_voucherActionPerformed
    // TODO add your handling code here:
    try {
        if (frmCb_voucherh == null) {
            frmCb_voucherh = new FrmCb_voucherh(this);
        }
        showForm(frmCb_voucherh);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmCb_voucherActionPerformed

private void jmniCBVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniCBVoucherActionPerformed
    // TODO add your handling code here:
    FrmPrintCBVoucher fp=new FrmPrintCBVoucher();
   fp.setVisible(true);
    

}//GEN-LAST:event_jmniCBVoucherActionPerformed

private void jmnuFrmAP_aging_processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuFrmAP_aging_processActionPerformed
    // TODO add your handling code here:
    try {
        if (frmAP_aging_process == null) {
            frmAP_aging_process = new FrmAP_aging_process(this);
        }
        showForm(frmAP_aging_process);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmnuFrmAP_aging_processActionPerformed

private void jmniCBVoucherRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniCBVoucherRealActionPerformed
    // TODO add your handling code here:
    FrmPrintCBVoucherFrCB fp=new FrmPrintCBVoucherFrCB();
   fp.setVisible(true);

}//GEN-LAST:event_jmniCBVoucherRealActionPerformed

private void jMenuItem11ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed1
    // TODO add your handling code here:
    Frmgl_ProvPosJournalRpt fp=new Frmgl_ProvPosJournalRpt();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem11ActionPerformed1

private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    // TODO add your handling code here:
    FrmPrintVoucher_je_rpt fp=new FrmPrintVoucher_je_rpt();
    fp.setVisible(true);
}//GEN-LAST:event_jMenuItem8ActionPerformed

private void jmniFrmGl_Create_OpenbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniFrmGl_Create_OpenbalanceActionPerformed
    // TODO add your handling code here:
    try {
        if (frmGl_Create_Openbalance  == null) {
            frmGl_Create_Openbalance = new FrmGl_Create_Openbalance(this);
        }
        showForm(frmGl_Create_Openbalance);

    }catch(Exception e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jmniFrmGl_Create_OpenbalanceActionPerformed

    private void jmniScreenCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniScreenCostActionPerformed
        // TODO add your handling code here:
    try {
        if (frmcostaccounting  == null) {
            frmcostaccounting = new FrmCostAccounting(this);
        }
        showForm(frmcostaccounting);

    }catch(Exception e) {
        e.printStackTrace();
    }

        
    }//GEN-LAST:event_jmniScreenCostActionPerformed

    private void jmniInvoiceValidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniInvoiceValidationActionPerformed
    try {
        if (frminvoicevalidation  == null) {
            frminvoicevalidation = new FrmInvoiceValidation(this);
        }
        showForm(frminvoicevalidation);

    }catch(Exception e) {
        e.printStackTrace();
    }

    }//GEN-LAST:event_jmniInvoiceValidationActionPerformed
                

public void chekMenu() {
    
}


public void showInvoiceEntry(Ar_invbatchlist obj,int status){
    try {
        if (frmarinvoiceentry  == null) {
            frmarinvoiceentry = new FrmAr_invbatchlist(this);
        }
        showForm(frmarinvoiceentry);

        switch (status){
            case 0:
                frmarinvoiceentry.setar_invbatchlist(obj);
                break;
            case 1:
                frmarinvoiceentry.newData();
                break;
        }
        

    }catch(Exception e) {
        e.printStackTrace();
    }
}

public void showGL_JournalEntry(Gl_batchlist obj,int status){
    try {
        if (frmjournalentry  == null) {
            frmjournalentry = new FrmGl_batchlist(this);
        }
        showForm(frmjournalentry);

        switch (status){
            case 0:
                frmjournalentry.setgl_batchlist(obj);
                break;
            case 1:
                frmjournalentry.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}

public void showAP_InvoiceEntry(Ap_invbatchlist obj,int status){
    try {
        if (frmapinvoiceentry  == null) {
            frmapinvoiceentry = new FrmAp_invbatchlist(this);
        }
        showForm(frmapinvoiceentry);

        switch (status){
            case 0:
                frmapinvoiceentry.setap_invbatchlist(obj);
                break;
            case 1:
                frmapinvoiceentry.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}
public void showAP_AdjustEntry(Ap_adjbatchlist obj,int status){
    try {
        if (frmapadjentry  == null) {
            frmapadjentry = new FrmAp_adjbatchlist(this);
        }
        showForm(frmapadjentry);

        switch (status){
            case 0:
                frmapadjentry.setap_adjbatchlist(obj);
                break;
            case 1:
                frmapadjentry.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}
public void showAR_AdjustEntry(Ar_adjbatchlist obj,int status){
    try {
        if (frmaradjentry  == null) {
            frmaradjentry = new FrmAr_adjbatchlist(this);
        }
        showForm(frmaradjentry);

        switch (status){
            case 0:
                frmaradjentry.setAr_adjbatchlist(obj);
                break;
            case 1:
                frmaradjentry.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}

public void showReceiptEntry(Ar_rcpbatchlist obj,int status){
    try {
        if (Frmarrcpbatchlist  == null) {
            Frmarrcpbatchlist = new FrmAr_rcpbatchlist(this);
        }
        showForm(Frmarrcpbatchlist);

        switch (status){
            case 0:
                Frmarrcpbatchlist.setar_rcpbatchlist(obj);
                break;
            case 1:
                Frmarrcpbatchlist.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}

public void showPaymentEntry(Ap_paybatchlist obj,int status){
    try {
        if (frmappaybatchlist  == null) {
            frmappaybatchlist = new FrmAp_paybatchlist(this);
        }
        showForm(frmappaybatchlist);

        switch (status){
            case 0:
                frmappaybatchlist.setap_paybatchlist(obj);
                break;
            case 1:
                frmappaybatchlist.newData();
                break;
        }


    }catch(Exception e) {
        e.printStackTrace();
    }
}

public void setToolBar(Integer FORM_TYPE,Integer FORM_STATE){
        ImageIcon icon=null;
               
        boolean showdisabled = false;

        btnPrint.setEnabled(showdisabled);
        btnClose.setEnabled(showdisabled);
        btnConfirm.setEnabled(showdisabled);
        btnDel.setEnabled(showdisabled);
        btnExTxt.setEnabled(showdisabled);
        btnExXls.setEnabled(showdisabled);
        btnFirst.setEnabled(showdisabled);
        btnHelp.setEnabled(!showdisabled);
        btnImpTxt.setEnabled(showdisabled);
        btnImpXls.setEnabled(showdisabled);
        btnLast.setEnabled(showdisabled);
        btnNew.setEnabled(showdisabled);
        btnNext.setEnabled(showdisabled);
        btnNextScreen.setEnabled(showdisabled);
        btnPrev.setEnabled(showdisabled);
        btnPrevScreen.setEnabled(showdisabled);
        btnSave.setEnabled(showdisabled);
        btnUndo.setEnabled(showdisabled);

        switch (FORM_TYPE){
            case 0:
               btnClose.setEnabled(!showdisabled);
               btnNextScreen.setEnabled(!showdisabled);
               btnPrevScreen.setEnabled(!showdisabled);
               if (FORM_STATE == -1 || FORM_STATE == 0 ) {
                    btnDel.setEnabled(!showdisabled);
                    btnConfirm.setEnabled(!showdisabled);
                    btnExTxt.setEnabled(!showdisabled);
                    btnExXls.setEnabled(!showdisabled);
                    btnFirst.setEnabled(!showdisabled);
                    btnHelp.setEnabled(!showdisabled);
                    btnImpTxt.setEnabled(!showdisabled);
                    btnImpXls.setEnabled(showdisabled);
                    btnLast.setEnabled(!showdisabled);
                    btnNew.setEnabled(!showdisabled);
                    btnNext.setEnabled(!showdisabled);
                    btnPrev.setEnabled(!showdisabled);                   
                    btnPrint.setEnabled(!showdisabled);
               }
               
              if (FORM_STATE == 0 || FORM_STATE == 1 ) {
                  if (FORM_STATE == 0) {
                    btnDel.setEnabled(!showdisabled);
                  }else {
                    btnDel.setEnabled(showdisabled);
                  }
                  btnSave.setEnabled(!showdisabled);
                  btnUndo.setEnabled(!showdisabled);                  
              }
              
               if (FORM_STATE == 2 || FORM_STATE == 5) {
                  btnFirst.setEnabled(!showdisabled);
                  btnLast.setEnabled(!showdisabled);
                  btnNext.setEnabled(!showdisabled);
                  btnPrev.setEnabled(!showdisabled);   
               }
               if (FORM_STATE == 3) {
                  btnPrint.setEnabled(!showdisabled);
                  btnNew.setEnabled(!showdisabled);
                  btnDel.setEnabled(!showdisabled);
                  btnSave.setEnabled(!showdisabled);
                  btnConfirm.setEnabled(!showdisabled);
               }
               
               if (FORM_STATE == 4) {
                    btnNew.setEnabled(!showdisabled);
                    btnSave.setEnabled(!showdisabled);
                    btnDel.setEnabled(!showdisabled);
                    btnConfirm.setEnabled(!showdisabled);
                    btnFirst.setEnabled(!showdisabled);
                    btnHelp.setEnabled(!showdisabled);
                    btnLast.setEnabled(!showdisabled);
                    btnNext.setEnabled(!showdisabled);
                    btnPrev.setEnabled(!showdisabled);                 
               }
               if (FORM_STATE == 6) {
                  btnNew.setEnabled(!showdisabled);
                  btnUndo.setEnabled(!showdisabled);
                  btnDel.setEnabled(!showdisabled);
                  btnSave.setEnabled(!showdisabled);
                  btnConfirm.setEnabled(!showdisabled);
               }
               if (FORM_STATE == 7) {
                  btnNew.setEnabled(!showdisabled);
                  btnConfirm.setEnabled(!showdisabled);
                  btnFirst.setEnabled(!showdisabled);
                  btnHelp.setEnabled(!showdisabled);
                  btnLast.setEnabled(!showdisabled);
                  btnNext.setEnabled(!showdisabled);
                  btnPrev.setEnabled(!showdisabled);
               }
              break;
            case 1:
                btnClose.setEnabled(!showdisabled);
                btnConfirm.setEnabled(!showdisabled);
                btnNextScreen.setEnabled(!showdisabled);
                btnPrevScreen.setEnabled(!showdisabled);
                break;
            case 2:
                btnClose.setEnabled(!showdisabled);
                btnConfirm.setEnabled(!showdisabled);
                btnNextScreen.setEnabled(!showdisabled);
                btnPrevScreen.setEnabled(!showdisabled);
                break;
            case 3:
                btnPrint.setEnabled(!showdisabled);
                btnClose.setEnabled(!showdisabled);
                btnConfirm.setEnabled(!showdisabled);
                break;

        }
    }

private void setToolTip(){
        btnClose.createToolTip();
        btnClose.setToolTipText("Close");
        btnConfirm.setToolTipText("Execute");
        btnDel.setToolTipText("Delete");
        btnPrint.setToolTipText("Print");
        btnExTxt.setToolTipText("Export To Text Files");
        btnExXls.setToolTipText("Export To Csv Files");
        btnFirst.setToolTipText("Move First");
        btnHelp.setToolTipText("Help");
        btnImpTxt.setToolTipText("Import From Text Files");
        btnImpXls.setToolTipText("Import From Excels Files");
        btnLast.setToolTipText("Move Last");
        btnNew.setToolTipText("New");
        btnNext.setToolTipText("Move Next");
        btnNextScreen.setToolTipText("Next Screen");
        btnPrev.setToolTipText("Move Previous");
        btnPrevScreen.setToolTipText("Previous Screen");
        btnSave.setToolTipText("Save");
        btnUndo.setToolTipText("Undo");
}
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainFrame().setVisible(true);
            }
        });
    }


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClose;
    public javax.swing.JButton btnConfirm;
    public javax.swing.JButton btnDel;
    public javax.swing.JButton btnExTxt;
    public javax.swing.JButton btnExXls;
    public javax.swing.JButton btnFirst;
    public javax.swing.JButton btnHelp;
    public javax.swing.JButton btnImpTxt;
    public javax.swing.JButton btnImpXls;
    public javax.swing.JButton btnLast;
    public javax.swing.JButton btnNew;
    public javax.swing.JButton btnNext;
    public javax.swing.JButton btnNextScreen;
    public javax.swing.JButton btnPrev;
    public javax.swing.JButton btnPrevScreen;
    public javax.swing.JButton btnPrint;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnUndo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLblUser;
    public javax.swing.JLabel jLblWarning;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar jMenuMain;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel jlblSystemDateTime;
    private javax.swing.JMenu jmnLaporan;
    private javax.swing.JMenu jmnMaster;
    private javax.swing.JMenu jmnTransaksi;
    private javax.swing.JMenuItem jmniAPAdjusmentEntry;
    private javax.swing.JMenuItem jmniAPAgedPayables;
    private javax.swing.JMenuItem jmniARAdjusmentEntry;
    private javax.swing.JMenuItem jmniAddressType;
    private javax.swing.JMenuItem jmniArCustomer;
    private javax.swing.JMenuItem jmniArDistributionCode;
    private javax.swing.JMenuItem jmniArOptionalDetail1;
    private javax.swing.JMenuItem jmniAr_NationalAccount;
    private javax.swing.JMenuItem jmniAr_billcycl;
    private javax.swing.JMenuItem jmniAr_interest;
    private javax.swing.JMenuItem jmniCBRegisterEntry;
    private javax.swing.JMenuItem jmniCBVoucher;
    private javax.swing.JMenuItem jmniCBVoucherReal;
    private javax.swing.JMenuItem jmniCB_Source;
    private javax.swing.JMenuItem jmniCb_batchcontrol;
    private javax.swing.JMenuItem jmniExit;
    private javax.swing.JMenuItem jmniFrmAP_BatchGLPosting;
    private javax.swing.JMenuItem jmniFrmAP_PostAdjustmentBatches;
    private javax.swing.JMenuItem jmniFrmAP_PostInvoiceBatches;
    private javax.swing.JMenuItem jmniFrmAP_PostPaymentBatches;
    private javax.swing.JMenuItem jmniFrmAP_Vendor;
    private javax.swing.JMenuItem jmniFrmAR_BatchGLPosting;
    private javax.swing.JMenuItem jmniFrmAR_PostAdjustmentBatches;
    private javax.swing.JMenuItem jmniFrmAR_PostInvoiceBatches;
    private javax.swing.JMenuItem jmniFrmAR_PostReceiptBatches;
    private javax.swing.JMenuItem jmniFrmAR_invoice_creator;
    private javax.swing.JMenuItem jmniFrmAp_accset;
    private javax.swing.JMenuItem jmniFrmAp_distcode;
    private javax.swing.JMenuItem jmniFrmAp_vendorgrp;
    private javax.swing.JMenuItem jmniFrmAr_accset;
    private javax.swing.JMenuItem jmniFrmAr_custgrp;
    private javax.swing.JMenuItem jmniFrmCb_batchGLposting;
    private javax.swing.JMenuItem jmniFrmCb_batchentry;
    private javax.swing.JMenuItem jmniFrmCb_batchposting;
    private javax.swing.JMenuItem jmniFrmCb_voucher;
    private javax.swing.JMenuItem jmniFrmGL_PostJournalEntryBatches;
    private javax.swing.JMenuItem jmniFrmGl_Create_Openbalance;
    private javax.swing.JMenuItem jmniGenerate;
    private javax.swing.JMenuItem jmniGlJournalEntry;
    private javax.swing.JMenuItem jmniGlJournalEntryList;
    private javax.swing.JMenuItem jmniGroup;
    private javax.swing.JMenuItem jmniInvoiceValidation;
    private javax.swing.JMenuItem jmniLaporanCBMasterMasterBank;
    private javax.swing.JMenuItem jmniLaporanMasterArCustomer;
    private javax.swing.JMenuItem jmniLaporanMasterArDistributionCode;
    private javax.swing.JMenuItem jmniLaporanMasterArOptionalDetail;
    private javax.swing.JMenuItem jmniLaporanMasterAr_NationalAccount;
    private javax.swing.JMenuItem jmniLaporanMasterAr_billcycl;
    private javax.swing.JMenuItem jmniLaporanMasterAr_interest;
    private javax.swing.JMenuItem jmniLaporanMasterCBSource;
    private javax.swing.JMenuItem jmniLaporanMasterDistSetCode;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAP_Vendor;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAp_accset;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAp_distcode;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAp_vendorgrp;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAr_accset;
    private javax.swing.JMenuItem jmniLaporanMasterFrmAr_custgrp;
    private javax.swing.JMenuItem jmniLaporanMasterGLSourceCode;
    private javax.swing.JMenuItem jmniLaporanTransaksiAp_rcpbatchlistprocess;
    private javax.swing.JMenuItem jmniLaporanTransaksiGlJournalEntry;
    private javax.swing.JMenuItem jmniLogOut;
    private javax.swing.JMenuItem jmniMasterAccount;
    private javax.swing.JMenuItem jmniMasterBank;
    private javax.swing.JMenuItem jmniMasterCompany;
    private javax.swing.JMenuItem jmniMasterCurrency;
    private javax.swing.JMenuItem jmniMasterGLCurrencyRate;
    private javax.swing.JMenuItem jmniMasterGLFiscalCalendar;
    private javax.swing.JMenuItem jmniMasterGLSource;
    private javax.swing.JMenuItem jmniModule;
    private javax.swing.JMenuItem jmniOp_paymentterm;
    private javax.swing.JMenuItem jmniResetPassword;
    private javax.swing.JMenuItem jmniScreenCost;
    private javax.swing.JMenuItem jmniTax;
    private javax.swing.JMenuItem jmniUser;
    private javax.swing.JMenuItem jmniphoneType;
    private javax.swing.JMenuItem jmniut_External_Data;
    private javax.swing.JMenu jmnuCashBook;
    private javax.swing.JMenu jmnuCostAccounting;
    private javax.swing.JMenuItem jmnuFrmAP_aging_process;
    private javax.swing.JMenu jmnuGL;
    private javax.swing.JMenu jmnuHelp;
    private javax.swing.JMenu jmnuInvoiceValidation;
    private javax.swing.JMenu jmnuLaporanMasterAP;
    private javax.swing.JMenu jmnuLaporanMasterAR;
    private javax.swing.JMenu jmnuLaporanMasterCashBook;
    private javax.swing.JMenu jmnuLaporanMasterGL;
    private javax.swing.JMenu jmnuSystem;
    private javax.swing.JMenu jmnuTransaksiAP;
    private javax.swing.JMenu jmnuTransaksiAR;
    private javax.swing.JMenu jmnuTransaksiCashBook;
    private javax.swing.JMenu jmnuTransaksiGL;
    private javax.swing.JMenuItem jmnuiAP_InvoiceEntry;
    private javax.swing.JMenuItem jmnuiAR_InvoiceBatchList;
    private javax.swing.JMenuItem jmnuiAR_InvoiceEntry;
    private javax.swing.JMenuItem jmnuiAp_InvoiceBatchList;
    private javax.swing.JMenuItem jmnuiAp_paybatchlist;
    private javax.swing.JMenuItem jmnuiAp_paybatchlistpro;
    private javax.swing.JMenuItem jmnuiAp_rcpbatchlistprocess;
    private javax.swing.JMenuItem jmnuiAr_InvoiceBatchList;
    private javax.swing.JMenuItem jmnuiAr_rcpbatchlist;
    private javax.swing.JMenuItem jmnuiAr_rcpbatchlistprocess;
    // End of variables declaration//GEN-END:variables

     
    private void showForm(Object obj) {
        JInternalFrame jf = null;
        if (obj instanceof JInternalFrame) {
            jf = (JInternalFrame) obj;
            if (!jf.isVisible()) {
                jDesktopPane1.add(jf);
            }
            jf.setVisible(true);
            try {        
                jf.setMaximum(true);
                jf.setSelected(true);    
            } catch (java.beans.PropertyVetoException e) {
                e.printStackTrace();
            }        
        }
        
        jLblWarning.setText("");
        
    }

    private void logOff() {
        
        JInternalFrame[] ji = jDesktopPane1.getAllFrames();
        for (int i = 0; i < ji.length; i++) {
                ji[i].doDefaultCloseAction();
        }
        setToolBar(-1,0);
        
        login.setModal(true);
        login.setVisible(true);

        jLblUser.setText("User : " + GlobalUtils.getAuditUser() + " " + DbBean.getServerIP() + "/" + DbBean.getDatabase());
        this.setTitle(GlobalUtils.namapt);

        try {
            setMenuAll();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
 
    public void setMenuAll() throws CodeException {
      int menucount =  jMenuMain.getMenuCount();        
      for (int i =0 ; i< menucount; i++){
          JMenu jmenu = jMenuMain.getMenu(i);
          
          cekMenu(jmenu);
      }
    }

    private Component[] cekMenu(JMenu jmenu) throws CodeException {
        Component[] me = jmenu.getMenuComponents();
        
        for (int i = 0; i< me.length; i++) {
            if (me[i] instanceof JMenu) {
                Component[] me2 =  cekMenu((JMenu)me[i]);
            }else if(me[i] instanceof JMenuItem) {
                JMenuItem jmi = (JMenuItem) me[i];
                
                
                /// ini buat ngisi mastermodule  *** Jangan dihapus  ***
                /*if  (jmi.getName() != null) {
                    common.objectclasses.Mastermodule mm = new common.objectclasses.Mastermodule(jmi.getName());
                    mm.setModule(jmi.getName());
                    mm.setDescription(jmi.getText());
                    mm.save();
                    //System.out.println(jmi.getName());
                  
                }*/
                
                
                jmi.setEnabled(false);
                
                if (!"LogOut".equals(jmi.getName()) && !"Exit".equals(jmi.getName()) && !"Reset Password".equals(jmi.getName()) && !"calculator".equals(jmi.getName())) {

                    for (Object o : GlobalUtils.mastergroupdetails.list()) {
                         Mastergroupdetail mgd = (Mastergroupdetail) o;
                         //System.out.print(jmi.getName());
                         if (jmi.getName() != null) {
                             if (mgd.getModule().toUpperCase().equals(jmi.getName().toUpperCase())) {
                                jmi.setEnabled(mgd.getRead() > 0);
                             }
                         }
                        
                    }
                }else {
                    jmi.setEnabled(true);
                }
            }
            
        }
        return me;
    }          
    
    
    public void setIcon(String module) {
       try {
            for (Object o : GlobalUtils.mastergroupdetails.list()) {

                Mastergroupdetail mgd = (Mastergroupdetail) o;

                                
                if (module.equalsIgnoreCase(mgd.getModule())) {

                    this.btnNew.setEnabled(mgd.getEntry() > 0);
                    this.btnSave.setEnabled(mgd.getUpdate() > 0);
                    this.btnUndo.setEnabled(mgd.getUpdate() > 0);
                    this.btnDel.setEnabled(mgd.getDelete() > 0);
                    this.btnPrev.setEnabled(mgd.getRead() > 0);
                    this.btnNext.setEnabled(mgd.getRead() > 0);
                    this.btnFirst.setEnabled(mgd.getRead() > 0);
                    this.btnLast.setEnabled(mgd.getRead() > 0);
                    this.btnPrint.setEnabled(mgd.getPrint() > 0);
                    this.btnImpTxt.setEnabled(mgd.getImport() > 0);
                    this.btnImpXls.setEnabled(mgd.getImport() > 0);
                    this.btnExTxt.setEnabled(mgd.getExport() > 0);
                    this.btnExXls.setEnabled(mgd.getExport() > 0);
                    this.btnConfirm.setEnabled(mgd.getConfirm() > 0);
                    break;
                }
            }
        }catch (Exception e ) {
            e.printStackTrace();
        }
    }

}
