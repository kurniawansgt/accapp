/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.cashbook.FrmCb_batchcontrol;
 * 
 * .......
 * 
 * 
 * FrmCb_batchcontrol frmCb_batchcontrol;
 * 
 * .......
 * 
 try {
        if (frmCb_batchcontrol == null) {
            frmmCb_batchcontrol = new FrmCb_batchcontrol(this);
        }
        
        showForm(frmCb_batchcontrol);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.cashbook;

import accapp.component.browse.FrmBrowseAPVendor;
import accapp.component.browse.FrmBrowseARCustomer;
import accapp.component.browse.FrmBrowseAccountActive;
import accapp.component.browse.FrmBrowseCb_voucher;
import accapp.component.browse.FrmBrowseGl_currencyrated;
import accapp.objectclasses.ap.Ap_vendor;
import accapp.objectclasses.ap.Ap_vendors;
import accapp.objectclasses.ar.Ar_customer;
import accapp.objectclasses.ar.Ar_customers;
import accapp.objectclasses.cashbook.Cb_bank;
import accapp.objectclasses.cashbook.Cb_banks;
import accapp.objectclasses.cashbook.Cb_batchhs;
import accapp.objectclasses.cashbook.Cb_voucherds;
import common.component.FrmBrowse;
import common.classinterface.NavigatorFormInt;
import common.classinterface.NavigatorObjectInt;
import common.component.FrmMainFrame;

import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import common.utils.ExtFileChooserFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import accapp.objectclasses.cashbook.Cb_batchcontrol;
import accapp.objectclasses.cashbook.Cb_batchcontrols;
import accapp.objectclasses.cashbook.Cb_batchd;
import accapp.objectclasses.cashbook.Cb_batchds;
import accapp.objectclasses.cashbook.Cb_batchh;
import accapp.objectclasses.cashbook.Cb_batchsd;
import accapp.objectclasses.cashbook.Cb_batchsds;
import accapp.objectclasses.cashbook.Cb_distd;
import accapp.objectclasses.cashbook.Cb_distds;
import accapp.objectclasses.cashbook.Cb_disth;
import accapp.objectclasses.cashbook.Cb_disths;
import accapp.objectclasses.cashbook.Cb_invoblcbhsd;
import accapp.objectclasses.cashbook.Cb_invoblcbhsds;
import accapp.objectclasses.cashbook.Cb_option;
import accapp.objectclasses.cashbook.Cb_source;
import accapp.objectclasses.cashbook.Cb_sources;
import accapp.objectclasses.cashbook.Cb_voucher;
import accapp.objectclasses.cashbook.Cb_voucherd;
import accapp.objectclasses.cashbook.Cb_vouchers;
import accapp.objectclasses.cashbook.Cb_vouchersd;
import accapp.objectclasses.cashbook.Cb_vouchersds;
import accapp.objectclasses.cashbook.Payment_voucher;
import accapp.objectclasses.cashbook.Payment_vouchers;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_currencyrated;
import accapp.objectclasses.gl.Gl_currencyrateds;
import accapp.objectclasses.gl.Gl_currencys;
import accapp.objectclasses.gl.Gl_fiscalh;
import common.component.FrmBrowseObject;
import common.component.frmCalculator;
import common.tablemodels.GlobalModel;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.kazao.calendar.KazaoCalendar;
import org.kazao.calendar.KazaoCalendarAdapter;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author  Generator
 */

public class FrmCb_batchentry extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmCb_batchentry";
    
    FrmMainFrame mf ;
    
    
    public Cb_batchcontrol obj = new Cb_batchcontrol();
   
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0");

    Cb_batchh cbhh = new Cb_batchh();
    Cb_batchds cbhds = new Cb_batchds();
    Cb_option cbo=new Cb_option(Cb_option.PROPERTY_CMPNYID,GlobalUtils.company);

    Object[] datadetail;
    DefaultTableModel tmodeldetail;
     DefaultTableModel tmodeldetailalloacte;



    int posttable = 0;
    long mopbf=0;
    long yopbf=0;

    Boolean MOPChangedManually=false;

    boolean onload = false;
    private Cb_voucher ocb_voucher=new Cb_voucher();

    
    /** Creates new form Area */
    public FrmCb_batchentry() throws CodeException {
        initComponents();
    }
    
    public FrmCb_batchentry(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();


        fillMOP();
        fillYOP();
        changeLabel();

        datadetail = new Object[jtblDetail.getRowCount()];
        tmodeldetail = (DefaultTableModel) jtblDetail.getModel();
        tmodeldetailalloacte = (DefaultTableModel) jtblDetailAllocate.getModel();
        jTab.setEnabledAt(1, false);
        
        

        kdateentrydate.addChangeListener(new KazaoCalendarAdapter() {
            public void onChange(Calendar calendar) {
            }
            public void onChange(KazaoCalendar calendar) {
                if (!MOPChangedManually){
                    jcbMOP.setSelectedItem(GlobalUtils.formatmonth((long)GlobalUtils.getMonth(kdateentrydate.getDate())));
                    jcbYOP.setSelectedItem((long) GlobalUtils.getYear(kdateentrydate.getDate()));
                }
                
            }
            public void onDoubleClick() {
            }
        });

        jPanel1.setVisible(false);
    }

    private void fillMOP(){
        jcbMOP.removeAllItems();

        long i=0;
        for (i=1;i<13;i++){
            if (i<10){
                jcbMOP.addItem("0"+i);
            } else {
                jcbMOP.addItem(i+"");
            }
        }

    }

    private void fillYOP(){
        jcbYOP.removeAllItems();

        int currentYear=GlobalUtils.CNomorInt(GlobalUtils.getCurrentYear());
        long i=0;
        for (i=currentYear-10;i<currentYear+10;i++){
            jcbYOP.addItem(i);
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
        jbtnBrowse = new javax.swing.JButton();
        jtxtid = new javax.swing.JTextField();
        jlblbatchno = new javax.swing.JLabel();
        jtxtbatchno = new javax.swing.JTextField();
        jlblbankcode = new javax.swing.JLabel();
        jtxtbankcode = new javax.swing.JTextField();
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        jbtnBrowseBank = new javax.swing.JButton();
        jpbatch_h = new javax.swing.JPanel();
        jtbnNew = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jcmbentrytypeH = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtReference = new javax.swing.JTextField();
        jlblMisc = new javax.swing.JLabel();
        jtxtmisccode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtdscription = new javax.swing.JTextField();
        jbtnDelete = new javax.swing.JButton();
        jTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new selectallJTable(tmodeldetail);
        jLabel6 = new javax.swing.JLabel();
        jlblTotalEntry = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtxtApplied = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtUnApplied = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtxtAmount = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jtxtSearchInvoice = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblDetailAllocate = new selectallJTable(tmodeldetail);
        jLabel16 = new javax.swing.JLabel();
        jtxtstartpono = new javax.swing.JTextField();
        jbtnBrowse6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jcmbDocType = new javax.swing.JComboBox();
        jbtnShowInvoice = new javax.swing.JButton();
        jlblcustcheqno = new javax.swing.JLabel();
        jbtnBrowseMiscode = new javax.swing.JButton();
        jtxtmiscdscription = new javax.swing.JTextField();
        jtxtcustcheqno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtcurnccode = new javax.swing.JTextField();
        jbtnBrowsecurnccode = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jlbldistcode = new javax.swing.JLabel();
        jtxtdistcode = new javax.swing.JTextField();
        jbtnBrowsedistcode = new javax.swing.JButton();
        jtxtdistdesc = new javax.swing.JTextField();
        jbtnDistributed = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtxtType = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtxtRate = new javax.swing.JTextField();
        jbtnBrowserate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtIndex = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtIndexSum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtEntryno = new javax.swing.JTextField();
        jbtnBrowseEntry = new javax.swing.JButton();
        jlblyop = new javax.swing.JLabel();
        jlblmop = new javax.swing.JLabel();
        jcbMOP = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jlbldebittot = new javax.swing.JLabel();
        jtxtdebittot = new javax.swing.JTextField();
        jlblcredittot = new javax.swing.JLabel();
        jtxtcredittot = new javax.swing.JTextField();
        jlblentrycnt = new javax.swing.JLabel();
        jtxtentrycnt = new javax.swing.JTextField();
        kdateentrydate = new org.kazao.calendar.KazaoCalendarDate();
        jcbYOP = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jtxtNoPV = new javax.swing.JTextField();
        jbtnBrowseNoPV = new javax.swing.JButton();
        jtxtbankcurnccode = new javax.swing.JTextField();
        jchkreadytpost = new javax.swing.JCheckBox();
        jtxtbatchsts = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jtxtbtchdesc = new javax.swing.JTextField();
        jtxtbankname = new javax.swing.JTextField();
        jlblbatchtype = new javax.swing.JLabel();
        jcmbbatchtype = new javax.swing.JComboBox();
        jlblsrceledgr = new javax.swing.JLabel();
        jtxtsrceledgr = new javax.swing.JTextField();
        jlblentrytype = new javax.swing.JLabel();
        jcmbentrytype = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("C/B Batch Entry");
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jHeader.setBackground(new java.awt.Color(102, 102, 102));
        jHeader.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jHeader.setForeground(new java.awt.Color(255, 255, 255));
        jHeader.setText(" : : Batch Entry");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(10, 10, 130, 20);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(240, 50, 30, 17);

        jtxtid.setEditable(false);
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(150, 10, 70, 20);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchno.setText("Batch Number :");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(20, 50, 120, 14);

        jtxtbatchno.setEditable(false);
        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchno.setText("batchno");
        jtxtbatchno.setNextFocusableComponent(jtxtbtchdesc);
        jtxtbatchno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbatchnoKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(140, 50, 90, 20);

        jlblbankcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbankcode.setText("Bank Code");
        getContentPane().add(jlblbankcode);
        jlblbankcode.setBounds(290, 50, 70, 20);

        jtxtbankcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbankcode.setText("bankcode");
        jtxtbankcode.setNextFocusableComponent(kdateentrydate);
        jtxtbankcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbankcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbankcodeKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtbankcode);
        jtxtbankcode.setBounds(370, 50, 90, 20);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(230, 10, 170, 20);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(410, 10, 170, 20);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(590, 10, 150, 20);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(750, 10, 80, 20);

        jbtnBrowseBank.setText("...");
        jbtnBrowseBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseBankActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowseBank);
        jbtnBrowseBank.setBounds(470, 50, 30, 17);

        jpbatch_h.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N
        jpbatch_h.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jpbatch_h.setLayout(null);

        jtbnNew.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtbnNew.setText("New");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jpbatch_h.add(jtbnNew);
        jtbnNew.setBounds(20, 20, 60, 20);

        jbtnMoveFirst.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnMoveFirst.setText("|<");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(120, 20, 50, 20);

        jbtnMovePrevious.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnMovePrevious.setText("<");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(170, 20, 50, 20);

        jbtnMoveNext.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnMoveNext.setText(">");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(390, 20, 50, 20);

        jbtnMoveLast.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jbtnMoveLast.setText(">|");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnMoveLast);
        jbtnMoveLast.setBounds(440, 20, 50, 20);

        jcmbentrytypeH.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbentrytypeH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cashbook", "Accounts Payable", "Account Recievable" }));
        jcmbentrytypeH.setNextFocusableComponent(jtxtmisccode);
        jcmbentrytypeH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbentrytypeHItemStateChanged(evt);
            }
        });
        jcmbentrytypeH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbentrytypeHActionPerformed(evt);
            }
        });
        jcmbentrytypeH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbentrytypeHKeyPressed(evt);
            }
        });
        jpbatch_h.add(jcmbentrytypeH);
        jcmbentrytypeH.setBounds(280, 90, 140, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel4.setText("Type");
        jpbatch_h.add(jLabel4);
        jLabel4.setBounds(250, 90, 40, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel5.setText("Ref/Cheque");
        jpbatch_h.add(jLabel5);
        jLabel5.setBounds(20, 90, 100, 20);

        jtxtReference.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtReference.setText("Reference");
        jtxtReference.setNextFocusableComponent(jcmbentrytypeH);
        jtxtReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtReferenceActionPerformed(evt);
            }
        });
        jtxtReference.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtReferenceKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtReference);
        jtxtReference.setBounds(140, 90, 100, 20);

        jlblMisc.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblMisc.setText("Misc. Code");
        jpbatch_h.add(jlblMisc);
        jlblMisc.setBounds(20, 120, 100, 14);

        jtxtmisccode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtmisccode.setText("misccode");
        jtxtmisccode.setNextFocusableComponent(jtxtcurnccode);
        jtxtmisccode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtmisccodeKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtmisccode);
        jtxtmisccode.setBounds(140, 120, 100, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel7.setText("Description");
        jpbatch_h.add(jLabel7);
        jLabel7.setBounds(20, 160, 100, 14);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdscription.setText("dscription");
        jtxtdscription.setNextFocusableComponent(jtxtcustcheqno);
        jtxtdscription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdscriptionKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtdscription);
        jtxtdscription.setBounds(140, 160, 520, 20);

        jbtnDelete.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnDelete.setText("x");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnDelete);
        jbtnDelete.setBounds(80, 20, 40, 20);

        jTab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTab.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabMouseClicked(evt);
            }
        });
        jTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabKeyPressed(evt);
            }
        });

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jtblDetail.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Source", "Description", "Account", "Account Description", "Receipt Amount", "Payment Amount", "Qty", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetail.setAutoscrolls(false);
        jtblDetail.setSurrendersFocusOnKeystroke(true);
        jtblDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDetailMouseClicked(evt);
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
        if (jtblDetail.getColumnModel().getColumnCount() > 0) {
            jtblDetail.getColumnModel().getColumn(0).setMinWidth(0);
            jtblDetail.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblDetail.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblDetail.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(4).setPreferredWidth(200);
            jtblDetail.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblDetail.getColumnModel().getColumn(6).setPreferredWidth(100);
            jtblDetail.getColumnModel().getColumn(7).setPreferredWidth(50);
            jtblDetail.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 890, 210);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel6.setText("{tbl Insert} -> Tambah Baris, {tbl Delete} -> Delete Baris");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 220, 710, 20);

        jlblTotalEntry.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblTotalEntry.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblTotalEntry.setText("jlblTotalEntry");
        jPanel2.add(jlblTotalEntry);
        jlblTotalEntry.setBounds(710, 220, 180, 20);

        jTab.addTab("Detail", jPanel2);

        jPanel3.setLayout(null);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel8.setText("Applied");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(10, 10, 70, 14);

        jtxtApplied.setEditable(false);
        jtxtApplied.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtApplied.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtApplied.setText("0");
        jtxtApplied.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtAppliedKeyPressed(evt);
            }
        });
        jPanel7.add(jtxtApplied);
        jtxtApplied.setBounds(70, 10, 110, 20);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel12.setText("Un Applied");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(190, 10, 80, 14);

        jtxtUnApplied.setEditable(false);
        jtxtUnApplied.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtUnApplied.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtUnApplied.setText("0");
        jPanel7.add(jtxtUnApplied);
        jtxtUnApplied.setBounds(270, 10, 110, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel13.setText("Amount");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(390, 10, 70, 14);

        jtxtAmount.setEditable(false);
        jtxtAmount.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtAmount.setText("0");
        jPanel7.add(jtxtAmount);
        jtxtAmount.setBounds(450, 10, 110, 20);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(10, 200, 570, 40);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(null);

        jtxtSearchInvoice.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jPanel8.add(jtxtSearchInvoice);
        jtxtSearchInvoice.setBounds(100, 10, 220, 25);

        jbtnSearch.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnSearch);
        jbtnSearch.setBounds(10, 10, 80, 23);

        jPanel3.add(jPanel8);
        jPanel8.setBounds(580, 200, 320, 40);

        jtblDetailAllocate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblDetailAllocate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Apply", "Type", "Document Number", "Date", "Amount Applied", "Discount", "Remaining Amount", "Document Amount", "Pending Amount", "Pending Discount", "PO Number", "SO Number", "Remaining"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetailAllocate.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetailAllocate.setAutoscrolls(false);
        jtblDetailAllocate.setSurrendersFocusOnKeystroke(true);
        jtblDetailAllocate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDetailAllocateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblDetailAllocateMousePressed(evt);
            }
        });
        jtblDetailAllocate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtblDetailAllocateInputMethodTextChanged(evt);
            }
        });
        jtblDetailAllocate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblDetailAllocatePropertyChange(evt);
            }
        });
        jtblDetailAllocate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblDetailAllocateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblDetailAllocateKeyReleased(evt);
            }
        });
        jtblDetailAllocate.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtblDetailAllocateVetoableChange(evt);
            }
        });
        jScrollPane2.setViewportView(jtblDetailAllocate);
        if (jtblDetailAllocate.getColumnModel().getColumnCount() > 0) {
            jtblDetailAllocate.getColumnModel().getColumn(0).setMinWidth(0);
            jtblDetailAllocate.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtblDetailAllocate.getColumnModel().getColumn(0).setMaxWidth(0);
            jtblDetailAllocate.getColumnModel().getColumn(3).setPreferredWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtblDetailAllocate.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(6).setPreferredWidth(100);
            jtblDetailAllocate.getColumnModel().getColumn(7).setMinWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(7).setPreferredWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(8).setMinWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(9).setMinWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(10).setMinWidth(150);
            jtblDetailAllocate.getColumnModel().getColumn(11).setMinWidth(100);
            jtblDetailAllocate.getColumnModel().getColumn(12).setMinWidth(100);
        }

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 40, 890, 160);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel16.setText("Starting Doc No.");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(230, 10, 100, 14);

        jtxtstartpono.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtstartpono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtstartponoActionPerformed(evt);
            }
        });
        jtxtstartpono.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtstartponoPropertyChange(evt);
            }
        });
        jtxtstartpono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstartponoKeyTyped(evt);
            }
        });
        jtxtstartpono.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtstartponoVetoableChange(evt);
            }
        });
        jPanel3.add(jtxtstartpono);
        jtxtstartpono.setBounds(340, 10, 193, 20);

        jbtnBrowse6.setText("...");
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse6);
        jbtnBrowse6.setBounds(540, 10, 20, 17);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel17.setText("Doc Type");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(10, 10, 60, 14);

        jcmbDocType.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbDocType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Credit Note", "Debit Note", "Interest Invoice" }));
        jcmbDocType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbDocTypeKeyPressed(evt);
            }
        });
        jPanel3.add(jcmbDocType);
        jcmbDocType.setBounds(80, 10, 130, 20);

        jbtnShowInvoice.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnShowInvoice.setText("Show Invoice");
        jbtnShowInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowInvoiceActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnShowInvoice);
        jbtnShowInvoice.setBounds(570, 10, 120, 23);

        jTab.addTab("Allocate", jPanel3);

        jpbatch_h.add(jTab);
        jTab.setBounds(20, 230, 910, 270);

        jlblcustcheqno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustcheqno.setText("Cust Cheque");
        jpbatch_h.add(jlblcustcheqno);
        jlblcustcheqno.setBounds(20, 200, 80, 20);

        jbtnBrowseMiscode.setText("...");
        jbtnBrowseMiscode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseMiscodeActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnBrowseMiscode);
        jbtnBrowseMiscode.setBounds(240, 120, 30, 20);

        jtxtmiscdscription.setEditable(false);
        jtxtmiscdscription.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtmiscdscription.setText("Misc. Name");
        jpbatch_h.add(jtxtmiscdscription);
        jtxtmiscdscription.setBounds(280, 120, 380, 20);

        jtxtcustcheqno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustcheqno.setText("custcheqno");
        jtxtcustcheqno.setNextFocusableComponent(jtxtdistcode);
        jtxtcustcheqno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcustcheqnoKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtcustcheqno);
        jtxtcustcheqno.setBounds(140, 200, 110, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel9.setText("Currency");
        jpbatch_h.add(jLabel9);
        jLabel9.setBounds(20, 140, 70, 14);

        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcurnccode.setText("curnccode");
        jtxtcurnccode.setNextFocusableComponent(jtxtType);
        jtxtcurnccode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcurnccodeKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(140, 140, 50, 20);

        jbtnBrowsecurnccode.setText("...");
        jbtnBrowsecurnccode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowsecurnccodeActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnBrowsecurnccode);
        jbtnBrowsecurnccode.setBounds(190, 140, 20, 17);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel10.setText("Date");
        jpbatch_h.add(jLabel10);
        jLabel10.setBounds(140, 60, 40, 14);

        jlbldistcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldistcode.setText("Distribution Code");
        jpbatch_h.add(jlbldistcode);
        jlbldistcode.setBounds(20, 180, 120, 14);

        jtxtdistcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdistcode.setText("distcode");
        jtxtdistcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdistcodeKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtdistcode);
        jtxtdistcode.setBounds(140, 180, 100, 20);

        jbtnBrowsedistcode.setText("...");
        jbtnBrowsedistcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowsedistcodeActionPerformed(evt);
            }
        });
        jbtnBrowsedistcode.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jbtnBrowsedistcodeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jpbatch_h.add(jbtnBrowsedistcode);
        jbtnBrowsedistcode.setBounds(240, 180, 30, 17);

        jtxtdistdesc.setEditable(false);
        jtxtdistdesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdistdesc.setText("Distribution Name");
        jpbatch_h.add(jtxtdistdesc);
        jtxtdistdesc.setBounds(280, 180, 260, 20);

        jbtnDistributed.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnDistributed.setText("Distributed");
        jbtnDistributed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDistributedActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnDistributed);
        jbtnDistributed.setBounds(550, 180, 110, 17);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel14.setText("Source");
        jpbatch_h.add(jLabel14);
        jLabel14.setBounds(480, 140, 60, 14);

        jtxtType.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtType.setNextFocusableComponent(jtxtRate);
        jtxtType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtTypeKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtType);
        jtxtType.setBounds(330, 140, 80, 20);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel15.setText("Type");
        jpbatch_h.add(jLabel15);
        jLabel15.setBounds(280, 140, 40, 14);

        jtxtRate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtRate.setText("1");
        jtxtRate.setNextFocusableComponent(jtxtdscription);
        jtxtRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtRateKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtRate);
        jtxtRate.setBounds(550, 140, 70, 20);

        jbtnBrowserate.setText("...");
        jbtnBrowserate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowserateActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnBrowserate);
        jbtnBrowserate.setBounds(620, 140, 30, 20);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("Index");
        jpbatch_h.add(jLabel1);
        jLabel1.setBounds(230, 20, 40, 14);

        jtxtIndex.setEditable(false);
        jtxtIndex.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtIndex.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtIndexKeyPressed(evt);
            }
        });
        jpbatch_h.add(jtxtIndex);
        jtxtIndex.setBounds(270, 20, 40, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel3.setText("of");
        jpbatch_h.add(jLabel3);
        jLabel3.setBounds(320, 20, 20, 14);

        jtxtIndexSum.setEditable(false);
        jtxtIndexSum.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jpbatch_h.add(jtxtIndexSum);
        jtxtIndexSum.setBounds(340, 20, 40, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Entry#");
        jpbatch_h.add(jLabel2);
        jLabel2.setBounds(20, 60, 40, 20);

        jtxtEntryno.setEditable(false);
        jtxtEntryno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtEntryno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jpbatch_h.add(jtxtEntryno);
        jtxtEntryno.setBounds(60, 60, 50, 20);

        jbtnBrowseEntry.setText("...");
        jbtnBrowseEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseEntryActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnBrowseEntry);
        jbtnBrowseEntry.setBounds(110, 60, 20, 17);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblyop.setText("Year");
        jpbatch_h.add(jlblyop);
        jlblyop.setBounds(300, 60, 30, 14);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblmop.setText("Periode");
        jpbatch_h.add(jlblmop);
        jlblmop.setBounds(430, 60, 50, 14);

        jcbMOP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcbMOP.setNextFocusableComponent(jtxtReference);
        jcbMOP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMOPItemStateChanged(evt);
            }
        });
        jcbMOP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbMOPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbMOPFocusLost(evt);
            }
        });
        jcbMOP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbMOPKeyPressed(evt);
            }
        });
        jpbatch_h.add(jcbMOP);
        jcbMOP.setBounds(480, 60, 50, 20);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        jPanel6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jPanel6.setLayout(null);

        jlbldebittot.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldebittot.setText("Debit");
        jPanel6.add(jlbldebittot);
        jlbldebittot.setBounds(10, 70, 50, 14);

        jtxtdebittot.setEditable(false);
        jtxtdebittot.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdebittot.setForeground(new java.awt.Color(0, 51, 204));
        jtxtdebittot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdebittot.setText("debittot");
        jPanel6.add(jtxtdebittot);
        jtxtdebittot.setBounds(60, 60, 170, 30);

        jlblcredittot.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcredittot.setText("Credit");
        jPanel6.add(jlblcredittot);
        jlblcredittot.setBounds(10, 100, 50, 14);

        jtxtcredittot.setEditable(false);
        jtxtcredittot.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcredittot.setForeground(new java.awt.Color(204, 0, 51));
        jtxtcredittot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtcredittot.setText("credittot");
        jPanel6.add(jtxtcredittot);
        jtxtcredittot.setBounds(60, 100, 170, 30);

        jlblentrycnt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblentrycnt.setText("Enum");
        jPanel6.add(jlblentrycnt);
        jlblentrycnt.setBounds(10, 30, 40, 14);

        jtxtentrycnt.setEditable(false);
        jtxtentrycnt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtentrycnt.setText("entrycnt");
        jPanel6.add(jtxtentrycnt);
        jtxtentrycnt.setBounds(60, 30, 70, 20);

        jpbatch_h.add(jPanel6);
        jPanel6.setBounds(680, 40, 240, 140);

        kdateentrydate.setFontDate(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdateentrydate.setNextFocusableComponent(jcbYOP);
        jpbatch_h.add(kdateentrydate);
        kdateentrydate.setBounds(180, 60, 100, 20);

        jcbYOP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcbYOP.setNextFocusableComponent(jcbMOP);
        jcbYOP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYOPItemStateChanged(evt);
            }
        });
        jcbYOP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbYOPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbYOPFocusLost(evt);
            }
        });
        jcbYOP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbYOPKeyPressed(evt);
            }
        });
        jpbatch_h.add(jcbYOP);
        jcbYOP.setBounds(350, 60, 70, 20);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel11.setText("No. PV");
        jpbatch_h.add(jLabel11);
        jLabel11.setBounds(430, 90, 40, 20);

        jtxtNoPV.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtNoPV.setText("No PV");
        jtxtNoPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNoPVActionPerformed(evt);
            }
        });
        jpbatch_h.add(jtxtNoPV);
        jtxtNoPV.setBounds(470, 90, 150, 20);

        jbtnBrowseNoPV.setText("...");
        jbtnBrowseNoPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseNoPVActionPerformed(evt);
            }
        });
        jpbatch_h.add(jbtnBrowseNoPV);
        jbtnBrowseNoPV.setBounds(620, 90, 30, 20);

        getContentPane().add(jpbatch_h);
        jpbatch_h.setBounds(20, 80, 940, 520);

        jtxtbankcurnccode.setEditable(false);
        jtxtbankcurnccode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbankcurnccode.setText("curnccode");
        getContentPane().add(jtxtbankcurnccode);
        jtxtbankcurnccode.setBounds(510, 50, 40, 20);

        jchkreadytpost.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jchkreadytpost.setText("Ready To Post");
        jchkreadytpost.setNextFocusableComponent(jtxtbankcode);
        jchkreadytpost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jchkreadytpostMouseClicked(evt);
            }
        });
        getContentPane().add(jchkreadytpost);
        jchkreadytpost.setBounds(660, 50, 130, 20);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jtxtbatchsts.setForeground(new java.awt.Color(0, 51, 102));
        jtxtbatchsts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtbatchsts.setText("Batch Status");
        jtxtbatchsts.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jtxtbatchsts);
        jtxtbatchsts.setBounds(820, 40, 140, 30);

        jtxtbtchdesc.setText("btchdesc");
        jtxtbtchdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbtchdescKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbtchdescKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtbtchdesc);

        jtxtbankname.setEditable(false);
        jtxtbankname.setText("bankname");
        jPanel1.add(jtxtbankname);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jlblbatchtype.setText("Batch Type");
        jPanel1.add(jlblbatchtype);

        jcmbbatchtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Entries", "Transfer" }));
        jcmbbatchtype.setEnabled(false);
        jcmbbatchtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbbatchtypeItemStateChanged(evt);
            }
        });
        jPanel1.add(jcmbbatchtype);

        jlblsrceledgr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jlblsrceledgr.setText("Source Ledger");
        jPanel1.add(jlblsrceledgr);

        jtxtsrceledgr.setEditable(false);
        jtxtsrceledgr.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtxtsrceledgr.setText("srceledgr");
        jPanel1.add(jtxtsrceledgr);

        jlblentrytype.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jlblentrytype.setText("Entry Type");
        jPanel1.add(jlblentrytype);

        jcmbentrytype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entered", "Generated" }));
        jcmbentrytype.setEnabled(false);
        jcmbentrytype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbentrytypeItemStateChanged(evt);
            }
        });
        jPanel1.add(jcmbentrytype);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(990, 330, 320, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     
    }//GEN-LAST:event_formInternalFrameOpened

private void kdatePurchaseDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdatePurchaseDateFocusLost

}//GEN-LAST:event_kdatePurchaseDateFocusLost

private void kdatePurchaseDateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_kdatePurchaseDateCaretPositionChanged

}//GEN-LAST:event_kdatePurchaseDateCaretPositionChanged

private void kdatePurchaseDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_kdatePurchaseDatePropertyChange

}//GEN-LAST:event_kdatePurchaseDatePropertyChange

private void jtxtbatchnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchnoKeyPressed
formKeyPressed(evt);
    try {
        
        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchData();
        }

    }catch (Exception e) {

    }

}//GEN-LAST:event_jtxtbatchnoKeyPressed

private void jtxtbtchdescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbtchdescKeyReleased

    
}//GEN-LAST:event_jtxtbtchdescKeyReleased

private void jtxtbatchnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchnoKeyReleased
}//GEN-LAST:event_jtxtbatchnoKeyReleased

private void jtxtbankcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbankcodeKeyReleased
}//GEN-LAST:event_jtxtbankcodeKeyReleased

private void jchkreadytpostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jchkreadytpostMouseClicked
}//GEN-LAST:event_jchkreadytpostMouseClicked

private void jcmbbatchtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbbatchtypeItemStateChanged
    
}//GEN-LAST:event_jcmbbatchtypeItemStateChanged

private void jcmbentrytypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbentrytypeItemStateChanged

}//GEN-LAST:event_jcmbentrytypeItemStateChanged

private void jbtnBrowseBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseBankActionPerformed

          try {
	      Cb_banks brs = new Cb_banks();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtbankcode);
	      bd.setSecondValue(jtxtbankname);
	      bd.setModal(true);
	      bd.setVisible(true);

              Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
              jtxtbankcurnccode.setText(cbbank.getcurnccode());
              jtxtType.setText(cbbank.getratetypecode());
              jtxtcurnccode.setText(cbbank.getcurnccode());
              jtxtRate.setText("1");


	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }


}//GEN-LAST:event_jbtnBrowseBankActionPerformed


private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed

            NewEntry();
        
}//GEN-LAST:event_jtbnNewActionPerformed
public void NewEntry() {
    if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
        JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
    } else if (jtxtReference.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(this, "Ref/Cheque cannot be empty");
    } else {

        if(jlblTotalEntry.getText().equals("0")){

            int jawab = JOptionPane.showConfirmDialog(null, "Baru Lagi ?", "Baru ", JOptionPane.YES_NO_OPTION) ;
            if (jawab == JOptionPane.YES_OPTION) {
                try{
                    jbtnMoveNext.setEnabled(false);
                    jbtnMoveLast.setEnabled(false);
                    jbtnDelete.setEnabled(false);
                    MOPChangedManually=false;
                    cbhh=new Cb_batchh();
                    showDataCbhh();

                    Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
                    jtxtcurnccode.setText(cbbank.getcurnccode());
                    jtxtType.setText(cbbank.getratetypecode());

                    jtxtsrceledgr.setText(cbbank.getsrceledgr());
                }catch(Exception e) {}

                 kdateentrydate.requestFocus();
            }
        }else {

            try{
                    //movetolastentry();
                    int noreferensi = 0;
                    try{
                        noreferensi = Integer.parseInt(jtxtReference.getText());
                    }catch(Exception e) {}


                    if(!obj.getCbhhs().list().isEmpty()) {
                        setDataCbhh();
                    }

                    cbhh = new Cb_batchh();
                    obj.getCbhhs().add(cbhh);

                    jcmbentrytypeH.requestFocusInWindow();
                    jtxtIndex.setText(obj.getCbhhs().size()+"");
                    jtxtIndexSum.setText(obj.getCbhhs().size()+"");

                    jtxtentrycnt.setText(obj.getCbhhs().size()+"");

                    setCbhhEnable(true);

                    cbhh.setcurnccode(jtxtbankcurnccode.getText());
                    

                    showDataCbhh();
                    jtxtUnApplied.setText("0");

                    try {
                        kdateentrydate.setDate(GlobalUtils.sessiondate);
                    } catch (KazaoCalendarDateTimeException ex) {
                        Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
                    jcbYOP.setSelectedItem((long)GlobalUtils.getYear(GlobalUtils.sessiondate));

                    jtxtcurnccode.setText(cbo.getcurnccode());

                    if (noreferensi > 0) {
                        jtxtReference.setText((noreferensi + 1) +"");
                    }
                    kdateentrydate.requestFocus();

                    Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
                    jtxtcurnccode.setText(cbbank.getcurnccode());
                    jtxtType.setText(cbbank.getratetypecode());

                    jtxtsrceledgr.setText(cbbank.getsrceledgr());
                    jtxtRate.setText("1");

            }catch (CodeException e) {}

        }

        jcmbentrytypeH.setSelectedIndex(0);
        jTab.setSelectedIndex(0);
        jTab.setEnabledAt(1, false);

    }
}
private void jcmbentrytypeHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbentrytypeHItemStateChanged

    changeLabel();

    givedefaultvaluetolastrow();

}//GEN-LAST:event_jcmbentrytypeHItemStateChanged


private void givedefaultvaluetolastrow(){
    if (GlobalUtils.churuf(jtblDetail.getValueAt(jtblDetail.getRowCount()-1, 3)).equalsIgnoreCase("")){
        Cb_bank cbbank;
            try {
                cbbank = new Cb_bank(jtxtbankcode.getText());

                if(jcmbentrytypeH.getSelectedItem().toString().equalsIgnoreCase("Account Recievable")){
                    tmodeldetail.setValueAt(cbbank.getarclracccode(), tmodeldetail.getRowCount() - 1, 3);
                }
                if(jcmbentrytypeH.getSelectedItem().toString().equalsIgnoreCase("Accounts Payable")){
                    tmodeldetail.setValueAt(cbbank.getapclraccode(), tmodeldetail.getRowCount() - 1, 3);
                }

                Gl_account glacc=new Gl_account(GlobalUtils.churuf(tmodeldetail.getValueAt(tmodeldetail.getRowCount()-1, 3)));
                tmodeldetail.setValueAt(glacc.getaccfmttd(), tmodeldetail.getRowCount() - 1, 3);
                tmodeldetail.setValueAt(glacc.getaccdesc(), tmodeldetail.getRowCount() - 1, 4);

            } catch (CodeException ex) {
                Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
private void jbtnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveFirstActionPerformed
    if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
        JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
    } else {
        int pos = 0;
        try{
            pos = Integer.parseInt(jtxtIndex.getText()) - 1;
            jbtnMoveNext.setEnabled(true);
            jbtnMoveLast.setEnabled(true);
            jbtnDelete.setEnabled(true);
            MOPChangedManually=true;
            //setDataCbhh();

            if (pos > 0){

                jtxtIndex.setText("1");
                cbhh = (Cb_batchh) obj.getCbhhs().list().get(0);
                showDataCbhh();
            }
        }catch(Exception e) {}

    }
}//GEN-LAST:event_jbtnMoveFirstActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed
    if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
        JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
    } else {
        movetolastentry();
    }
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void movetolastentry(){
    int pos = 0;
    try{
        pos = Integer.parseInt(jtxtIndex.getText()) - 1;
        MOPChangedManually=true;
        //setDataCbhh();

        if (pos < obj.getCbhhs().list().size()){

            jtxtIndex.setText(obj.getCbhhs().size()+"");

            cbhh = (Cb_batchh) obj.getCbhhs().list().get(obj.getCbhhs().list().size() - 1);
            showDataCbhh();
            if (cbhh.getID()==0){
                jtxtUnApplied.setText("0");
                System.out.println("isi:"+cbhh.getCbhds().size());
            }

        }
    }catch(Exception e) {}
}
private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed
    if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
        JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
    } else {
        int pos = 0;
        try{
            if (obj.getCbhhs().size()>0&&Integer.parseInt(jtxtIndex.getText() )<obj.getCbhhs().size()){
                pos = Integer.parseInt(jtxtIndex.getText() ) - 1;
                MOPChangedManually=true;
                //setDataCbhh();

                if (pos < obj.getCbhhs().list().size()){

                    jtxtIndex.setText((pos+2)+"");

                    cbhh = (Cb_batchh) obj.getCbhhs().list().get(pos + 1);
                    showDataCbhh();

                }
            }
        }catch(Exception e) {}
    }
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMovePreviousActionPerformed
    if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
        JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
    } else {
        int pos = 0;
        try{
            pos = Integer.parseInt(jtxtIndex.getText()) - 1;
            jbtnMoveNext.setEnabled(true);
             jbtnMoveLast.setEnabled(true);
             jbtnDelete.setEnabled(true);
             MOPChangedManually=true;
            //setDataCbhh();



            if (pos > 0){

                jtxtIndex.setText((pos)+"");

                cbhh = (Cb_batchh) obj.getCbhhs().list().get(pos - 1);
                showDataCbhh();

            }
        }catch(Exception e) {}
    }
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jtxtIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtIndexKeyPressed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtIndexKeyPressed

private void findCBSource(int row) throws CodeException{

    try{
        if (row == 0 && jcmbentrytypeH.getSelectedIndex() > 0) {
            Cb_source cbs=new Cb_source(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 1)));
            tmodeldetail.setValueAt(cbs.getacccode(), row, 3);
            Gl_account glacc = new Gl_account(Gl_account.PROPERTY_ACCCODE, tmodeldetail.getValueAt(row, 3)+"");

            tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 3);
            tmodeldetail.setValueAt(glacc.getaccdesc(), row, 4);
        }
        
        if (jcmbentrytypeH.getSelectedIndex() > 0) {
            jTab.setEnabledAt(1, true);
        }
    }catch(Exception e) {}
    
}

private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    formKeyPressed(evt);
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (row==0&&jcmbentrytypeH.getSelectedIndex()>0){
        jTab.setEnabledAt(1, true);
    } else {
        jTab.setEnabledAt(1, false);
    }

    if (row>-1&&evt.getKeyCode()==evt.VK_ENTER){
        if (col<jtblDetail.getColumnCount()-1){
            GlobalUtils.selectCellTable(jtblDetail, row, col+1);
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_F12 || evt.getKeyCode() == 107){
        if(col == 5 || col ==6){
            String source = tmodeldetail.getValueAt(row, 1)+"";
            boolean bcal = true;
            if (col==5){
                bcal = source.equalsIgnoreCase("BKIN");
            }

            if (col==6){
                bcal = (source.equalsIgnoreCase("BKUT")) ;
            }

            if (bcal) {
                frmCalculator frmcal = new frmCalculator(tmodeldetail, row, col);
                frmcal.setModal(true);
                frmcal.setVisible(true);
            }

            try{
             caltotal();
            }catch(Exception e){}
            
        }
    }

    if (evt.getKeyCode() == KeyEvent.VK_F5) {

        try {


            if(col == 1){
                Cb_sources brs = new Cb_sources();
                FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 1);
                bd.retrieveData();
                bd.setModal(true);
                bd.setVisible(true);

                findCBSource(row);

                if (row > -1) {
                    cekCbhd();
                }
            }else if(col == 3){
                Gl_accounts brs = new Gl_accounts();
                FrmBrowseAccountActive bd = new FrmBrowseAccountActive(tmodeldetail, brs, row, 3);
                bd.retrieveData();
                bd.setModal(true);
                bd.setVisible(true);

                Gl_account glacc = new Gl_account(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3)).replace("-", ""));
                tmodeldetail.setValueAt(glacc.getaccdesc(), row, 4);

                if (glacc.getID()>0){
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 3);
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
                    this.setToolBar(iformtype, istatus);
                    unlockbutton(true);
                } else {
                    setToolBar(iformtype, 7);
                    unlockbutton(false);
                }

                if (row > -1) {
                    cekCbhd();
                }

            }

            if(row > -1) {
                //chek nilai 0, dirubah menjadi 1
                int qty = 1;
                try {
                    qty = Integer.parseInt(tmodeldetail.getValueAt(row, 7) + "");
                    if(qty == 0) qty = 1;
                }catch (Exception e) {}

                tmodeldetail.setValueAt(qty, row, 7);
            }



        } catch (CodeException e) {
            e.printStackTrace();
        }
    }

    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        if (row==jtblDetail.getRowCount()-1&&!GlobalUtils.churuf(tmodeldetail.getValueAt(tmodeldetail.getRowCount() - 1, 3)).trim().equalsIgnoreCase("")){
            tmodeldetail.addRow(datadetail);
        } else if (!GlobalUtils.churuf(tmodeldetail.getValueAt(tmodeldetail.getRowCount() - 1, 3)).trim().equalsIgnoreCase("")){
           tmodeldetail.addRow(datadetail);
        }
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, 0);

        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 7);

        givedefaultvaluetolastrow();
        
        GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 1);
                
    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{
                cbhh.removeCbhd(row);

                caltotal();

                if (cbhh.getID()>0){
                    saveData();
                }


            }catch(Exception e){e.printStackTrace();}

            try {
                    tmodeldetail.removeRow(row);
            }catch(Exception e){}

            
            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            }

            try{
                showDataCbhh();
            }catch (Exception e) {e.printStackTrace();}
            
        }

        
    }


   if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       evt.consume();
   }

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        evt.consume();
        if(col == 1) {
            GlobalUtils.selectCellTable(jtblDetail, row, 2);
        }
        if(col == 2) {
            GlobalUtils.selectCellTable(jtblDetail, row, 3);
        }
        if(col == 3) {
            GlobalUtils.selectCellTable(jtblDetail, row, 5);
        }
        if(col == 5) {
            GlobalUtils.selectCellTable(jtblDetail, row, 6);
        }
        if(col == 6) {
            GlobalUtils.selectCellTable(jtblDetail, row, 7);
        }
        if(col == 7) {
            GlobalUtils.selectCellTable(jtblDetail, row, 8);
        }
        
    }




}//GEN-LAST:event_jtblDetailKeyPressed

private void unlockbutton(Boolean lock){
    jtbnNew.setEnabled(lock);
    jbtnDelete.setEnabled(lock);
    jbtnMoveFirst.setEnabled(lock);
    jbtnMovePrevious.setEnabled(lock);
    jbtnMoveNext.setEnabled(lock);
    jbtnMoveLast.setEnabled(lock);
}

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange

    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    
    try{
        //if(posttable != row) {

        if (row > -1) {

            cekCbhd();
            
        }
        posttable = row;

        if(col == 1) {
            tmodeldetail.setValueAt((tmodeldetail.getValueAt(row, col)+"").toUpperCase(), row, col);
            findCBSource(row);
        }

        if(col == 3) {
            try{
                Gl_account glacc = new Gl_account(GlobalUtils.churuf(tmodeldetail.getValueAt(row, col)).replace("-", ""));
                if (glacc.getID()>0){
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 3);
                tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
                    this.setToolBar(iformtype, istatus);
                    unlockbutton(true);
                } else {
                    setToolBar(iformtype, 7);
                    unlockbutton(false);
                }
            }catch(Exception e) {}
        }
        if(row > -1) {
            //chek nilai 0, dirubah menjadi 1
            int qty = 1;
            try {
                qty = Integer.parseInt(tmodeldetail.getValueAt(row, 7) + "");
                if(qty == 0) qty = 1;
            }catch (Exception e) {}

            tmodeldetail.setValueAt(qty, row, 7);
        }

        if (col==5||col==6||col==7){
            String source = tmodeldetail.getValueAt(row, 1)+"";
            if (col==5){
                if (source.equalsIgnoreCase("BKUT")) {
                    tmodeldetail.setValueAt(0, row, 5);
                    JOptionPane.showMessageDialog(null, "Source BKUT, Recieve Tidak Boleh Diedit ");
                }else {
                    tmodeldetail.setValueAt(0, row, 6);
                }
            }

            if (col==6){
                if (source.equalsIgnoreCase("BKIN")) {
                    tmodeldetail.setValueAt(0, row, 6);
                    JOptionPane.showMessageDialog(null, "Source BKIN, Payment Tidak Boleh Diedit ");
                }else {
                    tmodeldetail.setValueAt(0, row, 5);
                }
            }
            if (row==0){
                Double alocateamount=new Double(0);
                switch (jcmbentrytypeH.getSelectedIndex()){
                    case 0:
                        break;
                    case 1:
                        alocateamount=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(row, 6)));
                        break;
                    case 2:
                        alocateamount=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(row, 5)));
                        break;
                }

                jtxtAmount.setText(GlobalUtils.formatnumber(alocateamount));
                jtxtUnApplied.setText(GlobalUtils.formatnumber(alocateamount));
            }

        }
        caltotal();

        
        //}
    }catch (Exception e){
        e.printStackTrace();
    }



}//GEN-LAST:event_jtblDetailPropertyChange

private void jbtnBrowsecurnccodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowsecurnccodeActionPerformed

          try {
	      Gl_currencys brs = new Gl_currencys();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtcurnccode);
	      bd.setModal(true);
	      bd.setVisible(true);

              if (jtxtcurnccode.getText().equalsIgnoreCase(jtxtbankcurnccode.getText())){
                  jbtnBrowserate.setEnabled(false);
              } else {
                  Gl_currencyrated glrated=new Gl_currencyrated();
                  glrated.getclosestrate(jtxtbankcurnccode.getText(),jtxtType.getText(),jtxtcurnccode.getText());
                  jtxtRate.setText(GlobalUtils.formatnumber(glrated.getrate()));

                  cbhh.setratedate(glrated.getratedate());

                  jbtnBrowserate.setEnabled(true);
              }
	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }


}//GEN-LAST:event_jbtnBrowsecurnccodeActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtEntryno.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{
            
            obj.removeCbhh(Integer.parseInt(jtxtIndex.getText()) - 1);
            
            showData();

        }catch(Exception e) {
            try{
                obj=new Cb_batchcontrol(jtxtbatchno.getText());
                showData();
            }catch(Exception e1) {}

        }

    }

}//GEN-LAST:event_jbtnDeleteActionPerformed

private void jbtnBrowseEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseEntryActionPerformed

          try {
	      FrmBrowseObject bd = new FrmBrowseObject(obj.getCbhhs());
	      bd.setFirstValue(jtxtEntryno);

              jtxtIndex.setText(jtxtEntryno.getText());
              
	      bd.setModal(true);
	      bd.setVisible(true);

              int index = 0;
              try{
                  index = Integer.parseInt(jtxtIndex.getText());
              }catch(Exception e) {}

              int i = 0;
              for (Object o : obj.getCbhhs().list()) {
                  Cb_batchh ch = (Cb_batchh) o;

                  if ((ch.getentryno()+"").equals(jtxtEntryno.getText()) ) {
                      cbhh = ch;

                      showDataCbhh();

                      jtxtIndex.setText(index+"");
                      break;
                  }
                  i++;
              }

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jbtnBrowseEntryActionPerformed

private void jtblDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyReleased
    // TODO add your handling code here:
    int row=jtblDetail.getSelectedRow();
    int col=jtblDetail.getSelectedColumn();
    
    try {

        if (row==0&&jcmbentrytypeH.getSelectedIndex()>0){
            jTab.setEnabledAt(1, true);
        } else {
            jTab.setEnabledAt(1, false);
        }

        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();
                if (col==1){
                    String sourcecode=GlobalUtils.churuf(jtblDetail.getValueAt(row, col));
                    if (!sourcecode.equalsIgnoreCase("")){
                        Cb_source cbsrc=new Cb_source(sourcecode);

                        if (cbsrc.getsrcecode()==null){
                            JOptionPane.showMessageDialog(null, "Invalid Procedure, Source code "+sourcecode+" does not exist", "alert", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, "Invalid Procedure, Account code "+accountcode+"does not exist");
                            jtblDetail.setValueAt("", row, col);
                        }
                    }
                }
                if (col==3){
                    String accountcode=GlobalUtils.churuf(jtblDetail.getValueAt(row, col));
                    if (!accountcode.equalsIgnoreCase("")){
                        Gl_account glacc=new Gl_account(accountcode.replace("-", ""));

                        if (glacc.getacccode()==null){
                            JOptionPane.showMessageDialog(null, "Invalid Procedure, Account code "+accountcode+" does not exist", "alert", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, "Invalid Procedure, Account code "+accountcode+"does not exist");
                            jtblDetail.setValueAt("", row, col);
                        }
                    }
                }

        }


    } catch (CodeException ex) {
        Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jtblDetailKeyReleased

private void caltotal() throws CodeException{
    double totaldebit=0;
    double totalcredit=0;


    Cb_batchhs cbhdhitungs = obj.getCbhhs();


    for (Object o : cbhdhitungs.list()) {
         Cb_batchh cbhhhitung =  (Cb_batchh) o;
        totaldebit +=cbhhhitung.getTotalDebit();
        totalcredit +=cbhhhitung.getTotalCredit();

    }



    jtxtdebittot.setText(GlobalUtils.formatnumber(totaldebit));

    jtxtcredittot.setText(GlobalUtils.formatnumber( totalcredit));


    jlblTotalEntry.setText(GlobalUtils.formatnumber(getTotalEntry()));

}

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
    // TODO add your handling code here:
    try {
      Cb_batchcontrols brs = new Cb_batchcontrols();
      FrmBrowse bd = new FrmBrowse(this, brs);
      bd.setFirstValue(jtxtbatchno);
      bd.setModal(true);
      bd.setVisible(true);

      obj=new Cb_batchcontrol(jtxtbatchno.getText());
      showData();
      NewEntry();

  } catch (CodeException ex) {
      ex.printStackTrace();
  }
}//GEN-LAST:event_jbtnBrowseActionPerformed

private void jbtnDistributedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDistributedActionPerformed
    // TODO add your handling code here:

    Cb_distds cbds=new Cb_distds(Cb_distd.PROPERTY_DISTCODE, jtxtdistcode.getText());
    try {
        GlobalModel.clearRow(tmodeldetail);
        for (Object o : cbds.list()) {
            Cb_distd cbd=(Cb_distd) o;

            tmodeldetail.addRow(datadetail);
            GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            tmodeldetail.setValueAt(cbd.getsrcecode(), tmodeldetail.getRowCount()-1,1);

            Cb_source cbs=new Cb_source(cbd.getsrcecode());
            tmodeldetail.setValueAt(cbs.getdscription(), tmodeldetail.getRowCount()-1, 2);

            Gl_account glacc=new Gl_account(cbs.getacccode());
            tmodeldetail.setValueAt(glacc.getaccfmttd(), tmodeldetail.getRowCount()-1, 3);
            tmodeldetail.setValueAt(glacc.getaccdesc(), tmodeldetail.getRowCount()-1, 4);

            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount()-1, 5);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount()-1, 6);
            tmodeldetail.setValueAt(1, tmodeldetail.getRowCount()-1, 7);
            
            tmodeldetail.setValueAt("", tmodeldetail.getRowCount()-1, 8);

            cekCbhd();
        }
    } catch (CodeException ex) {
        Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}//GEN-LAST:event_jbtnDistributedActionPerformed

private void jbtnBrowsedistcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowsedistcodeActionPerformed
    // TODO add your handling code here:
    try {
      Cb_disths brs = new Cb_disths();
      FrmBrowse bd = new FrmBrowse(brs);
      bd.setFirstValue(jtxtdistcode);
      bd.setSecondValue(jtxtdistdesc);
      bd.setModal(true);
      bd.setVisible(true);

  } catch (CodeException ex) {
      ex.printStackTrace();
  }
}//GEN-LAST:event_jbtnBrowsedistcodeActionPerformed

private void jbtnBrowseMiscodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseMiscodeActionPerformed
    // TODO add your handling code here:

    switch (jcmbentrytypeH.getSelectedIndex()){
        case 0:
            jTab.setEnabledAt(1, false);
            break;
        case 1:
                try {
                  Ap_vendors brs = new Ap_vendors();
                  FrmBrowseAPVendor bd = new FrmBrowseAPVendor(brs);
                  bd.setFirstValue(jtxtmisccode);
                  bd.setSecondValue(jtxtmiscdscription);
                  bd.setModal(true);
                  bd.setVisible(true);

                  Ap_vendor apvendor=new Ap_vendor(jtxtmisccode.getText());
                  jtxtdistcode.setText(apvendor.getdistcode());

                  if (!jtxtmisccode.getText().trim().equalsIgnoreCase("")){
                        jTab.setEnabledAt(1, true);
                    } else {
                        jTab.setEnabledAt(1, false);
                    }
              } catch (CodeException ex) {
                  ex.printStackTrace();
              }
            break;
        case 2:
            try {
                  Ar_customers brs = new Ar_customers();
                  FrmBrowseARCustomer bd = new FrmBrowseARCustomer(brs);
                  bd.setFirstValue(jtxtmisccode);
                  bd.setSecondValue(jtxtmiscdscription);
                  bd.setModal(true);
                  bd.setVisible(true);


                  if (!jtxtmisccode.getText().trim().equalsIgnoreCase("")){
                        jTab.setEnabledAt(1, true);
                    } else {
                        jTab.setEnabledAt(1, false);
                    }
              } catch (CodeException ex) {
                  ex.printStackTrace();
              }
            break;
    }

    GlobalModel.clearRow(tmodeldetailalloacte);
}//GEN-LAST:event_jbtnBrowseMiscodeActionPerformed
private void checkEntryRow(int row) throws CodeException {
    checkEntryRow(row, true);
}

private void checkEntryRow(int row, boolean cek) throws CodeException {
    if (row> -1 ) {

        double appliedamount = 0;
        double remainamount = 0;
        double documentamount = 0;
        double pendingamount = 0;
        double unapplied = 0;

        
        unapplied = GlobalUtils.toDbl(jtxtUnApplied.getText());
        remainamount =  GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 7)));

        appliedamount =  GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 5)));
        if (appliedamount > unapplied && cek) {
            appliedamount = unapplied;
            tmodeldetailalloacte.setValueAt(appliedamount, row, 5);
        }
        
        documentamount =  GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 8)));
        
        remainamount = remainamount - pendingamount - appliedamount;

        tmodeldetailalloacte.setValueAt(remainamount, row, 7);

        if (appliedamount == 0) {
            tmodeldetailalloacte.setValueAt("No", row, 1);
        }else{
            tmodeldetailalloacte.setValueAt("Yes", row, 1);
        }

    }

}

private void jtblDetailAllocatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailAllocatePropertyChange
    // TODO add your handling code here:

    int row = jtblDetailAllocate.getSelectedRow();
    int col = jtblDetailAllocate.getSelectedColumn();

    try{
        if (row>-1){
            if (cbhh.getCbhds().size()>0){
                cekCbhdAllocate((Cb_batchd) cbhh.getCbhds().list().get(0));
            }
            posttable = row;

        }
    }catch (Exception e){
        e.printStackTrace();
    }

}//GEN-LAST:event_jtblDetailAllocatePropertyChange

private void calculateapplied(Boolean auto){
    int i=0;
    Double awal=GlobalUtils.toDbl(jtxtAmount.getText());
    Double applied=new Double(0);
    for (i=0;i<jtblDetailAllocate.getRowCount();i++){
        if (auto){
            if (GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i,1)).equalsIgnoreCase("yes")){
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i, 7)));

                applied=applied+saldo;
                awal=awal-saldo;
                jtblDetailAllocate.setValueAt(saldo, i,5);

            }
        } else {
            if (GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i,1)).equalsIgnoreCase("yes")){
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i, 5)));
                applied=applied+saldo;
                awal=awal-saldo;

            }
        }

        Double remaining=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i, 7)));
        Double apply=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(i, 5)));

    }
    if(awal < 0) {
        //JOptionPane.showMessageDialog(null, "Nilai amount negatif : " + applied);
    }



    jtxtApplied.setText(GlobalUtils.formatnumber(applied));
    jtxtUnApplied.setText(GlobalUtils.formatnumber(awal));
}

private void jtblDetailAllocateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailAllocateKeyPressed
    int col=jtblDetailAllocate.getSelectedColumn();
    int row=jtblDetailAllocate.getSelectedRow();
    if (row>-1){
        if (evt.getKeyCode()==evt.VK_ENTER){
            evt.consume();

            if (col<jtblDetailAllocate.getColumnCount()-1){
                GlobalUtils.selectCellTable(jtblDetailAllocate, row, col+1);
            }
        }
   }
}//GEN-LAST:event_jtblDetailAllocateKeyPressed

private void jtblDetailAllocateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailAllocateKeyReleased
    // TODO add your handling code here:
    int col = jtblDetailAllocate.getSelectedColumn();
    int row = jtblDetailAllocate.getSelectedRow();

    if (evt.getKeyCode()==evt.VK_ENTER&&col==5){
    
            try{

                Double applied=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 5).toString());
                if (applied.equals(new Double(0))){
                    tmodeldetailalloacte.setValueAt("No", row, 1);
                } else {
                    tmodeldetailalloacte.setValueAt("Yes", row, 1);
                }
                calculateapplied(false);

                Double remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 7).toString());
                Double unapplied=GlobalUtils.toDbl(jtxtUnApplied.getText());

                
                if (unapplied<0){
                    applied=applied-Math.abs(unapplied);
                    jtblDetailAllocate.setValueAt(applied, row, 5);
                    calculateapplied(false);
                    remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 7).toString());
                    unapplied=GlobalUtils.toDbl(jtxtUnApplied.getText());
                }

                if (applied.equals(new Double(0))){
                    tmodeldetailalloacte.setValueAt("No", row, 1);
                } else {
                    tmodeldetailalloacte.setValueAt("Yes", row, 1);
                }

                if (applied>remaining){
                    applied=remaining;
                }

                if (unapplied<0){
                    applied=applied+unapplied;
                }

                if (GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(row, 0)))>0){
                    remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 13).toString())+unapplied;
                } else {
                    remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 13).toString())-applied;
                }
                
                
                cekCbhdAllocate((Cb_batchd) cbhh.getCbhds().list().get(0));
            }catch(Exception e){
                calculateapplied(false);
            }
    }
    formKeyPressed(evt);
}//GEN-LAST:event_jtblDetailAllocateKeyReleased

private void showInvoice() {
    try{

        Cb_invoblcbhsds ocol=new Cb_invoblcbhsds();
        if (jcmbentrytypeH.getSelectedIndex()==1){
            ocol.initdataap(jtxtmisccode.getText());
        } else if (jcmbentrytypeH.getSelectedIndex()==2){
            ocol.initdataar(jtxtmisccode.getText());
        }
        int i=0;
        for (i=0;i<ocol.size();i++){
            showdatainvoice(ocol.get(i));
        }
        //calculateapplied(false);

    }catch(Exception e) {
        e.printStackTrace();
    }
}
private void jbtnShowInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnShowInvoiceActionPerformed

    showInvoice();

}//GEN-LAST:event_jbtnShowInvoiceActionPerformed

private void jtblDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailMouseClicked
    // TODO add your handling code here:
    int row=jtblDetail.getSelectedRow();

    if (row==0 ){
        if ( !jtxtbatchsts.getText().equals("P")&&jcmbentrytypeH.getSelectedIndex()>0 && jtblDetail.getValueAt(row, 1) != null) {
            jTab.setEnabledAt(1, true);
        }else{
            jTab.setEnabledAt(1, false);

        }
    } else {
        jTab.setEnabledAt(1, false);
    }

    
}//GEN-LAST:event_jtblDetailMouseClicked

private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
    // TODO add your handling code here:
    int ifind=findinvoiceintable(jtxtSearchInvoice.getText());
    if (ifind>-1){
        GlobalUtils.selectCellTable(jtblDetailAllocate, ifind, 1);
    }
}//GEN-LAST:event_jbtnSearchActionPerformed

private void jtxtbtchdescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbtchdescKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtbankcode.requestFocus();
    }
    
}//GEN-LAST:event_jtxtbtchdescKeyPressed

private void jtxtReferenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtReferenceKeyPressed
    formKeyPressed(evt);
        Cb_batchd cbhd = null;
        Cb_voucherds cb_voucherds;
        Cb_batchsds cbhsds;
        Cb_batchsd cbhsd;
    if (evt.getKeyCode()==KeyEvent.VK_F5){
        try {
            ocb_voucher=new Cb_voucher();
            JTextField otxt_entryno=new JTextField();

            Cb_vouchers brs = new Cb_vouchers();
            FrmBrowseCb_voucher bd = new FrmBrowseCb_voucher(brs);
              bd.setFirstValue(otxt_entryno);
              bd.setSecondValue(jtxtReference);
              bd.setModal(true);
              bd.setVisible(true);

              
              ocb_voucher=new Cb_voucher(Cb_voucher.PROPERTY_ENTRYNO, otxt_entryno.getText());
              if (ocb_voucher.getID()>0){
                  
                  jtxtbankcode.setText(ocb_voucher.getbankcode());
                  jtxtbankcurnccode.setText(ocb_voucher.getcurnccode());

                  cbhh.setreference(ocb_voucher.getreference());
                  cbhh.setentrytype(ocb_voucher.getentrytype());
                  cbhh.setentrydate(ocb_voucher.getentrydate());
                  cbhh.setyop(ocb_voucher.getyop());
                  cbhh.setmop(ocb_voucher.getmop());
                  cbhh.setmisccode(ocb_voucher.getmisccode());
                  cbhh.setcurnccode(ocb_voucher.getcurnccode());
                  cbhh.setratetype(ocb_voucher.getratetype());
                  cbhh.setrateamount(ocb_voucher.getrateamount());
                  cbhh.setdscription(ocb_voucher.getdscription());
                  cbhh.setdistcode(ocb_voucher.getdistcode());
                  cbhh.setcustcheqno(ocb_voucher.getcustcheqno());
                  cbhh.fromString(Cb_batchh.PROPERTY_BATCHDATE, GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd"));
                  cbhh.fromString(Cb_batchh.PROPERTY_SRCECURNCCODE, jtxtcurnccode.getText());

                  cb_voucherds=ocb_voucher.getCbhds();

                  cbhds=new Cb_batchds();
                  for (Object o:cb_voucherds.list()){
                        Cb_voucherd ocb_voucherd=(Cb_voucherd) o;

                        cbhd=new Cb_batchd();
                        cbhd.setID(0);
                        cbhd.setmisccode(ocb_voucherd.getmisccode());
                        cbhd.setsrcecode(ocb_voucherd.getsrcecode());
                        cbhd.setdscription(ocb_voucherd.getdscription());
                        cbhd.setacccode(ocb_voucherd.getacccode());
                        cbhd.setdetailamnt(ocb_voucherd.getdetailamnt());
                        cbhd.setquantity(ocb_voucherd.getquantity());

                        Cb_vouchersds oCb_vouchersds=ocb_voucherd.getCbhds();
                        cbhsds=cbhd.getCbhds();

                        for(Object  a : oCb_vouchersds.list()){
                                Cb_vouchersd oCb_vouchersd = (Cb_vouchersd) a;

                                cbhsd=new Cb_batchsd();
                                cbhsd.setcustcode(ocb_voucherd.getmisccode());
                                cbhsd.setApplied("Yes");//1"Apply",
                                cbhsd.setdoctype(oCb_vouchersd.getdoctype());//2"Type",
                                cbhsd.setdocno(oCb_vouchersd.getdocno());
                                cbhsd.setdocdate(oCb_vouchersd.getdocdate());
                                cbhsd.setapplamount(oCb_vouchersd.getapplamount());
                                cbhsd.setdiscount(oCb_vouchersd.getdiscount());
                                cbhsds.list().add(cbhsd);
                        }
                        cbhd.setCbhsds(cbhsds);
                        cbhds.list().add(cbhd);
                  }
                  cbhh.setCbhds(cbhds);
                  //obj.getCbhhs().add(cbhh);
                  caltotal();
                  showDataCbhh();
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jcmbentrytypeH.requestFocus();
    }
}//GEN-LAST:event_jtxtReferenceKeyPressed

private void jtxtmisccodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtmisccodeKeyPressed
formKeyPressed(evt);
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){

        switch (jcmbentrytypeH.getSelectedIndex()){
            case 0:
                break;
            case 1:
                    try {
                      Ap_vendor brs = new Ap_vendor(jtxtmisccode.getText());
                      jtxtmiscdscription.setText(brs.getvendname());
                  } catch (CodeException ex) {
                      ex.printStackTrace();
                  }
                break;
            case 2:
                try {
                      Ar_customer brs = new Ar_customer(jtxtmisccode.getText());
                      jtxtmiscdscription.setText(brs.getcustmrname());
                } catch (CodeException ex) {
                      ex.printStackTrace();
                  }
                break;
        }

        jtxtcurnccode.requestFocus();

    }
    
}//GEN-LAST:event_jtxtmisccodeKeyPressed

private void jtxtdscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdscriptionKeyPressed
formKeyPressed(evt);

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){

        if(jcmbentrytypeH.getSelectedIndex() == 0){
            jtxtdistcode.requestFocus();

        }else if(jcmbentrytypeH.getSelectedIndex() == 2){

            jtxtcustcheqno.requestFocus();
        }
        else{
            try{
                jtblDetail.requestFocus();
                GlobalUtils.selectCellTable(jtblDetail, 0, 1);
            }catch(Exception e){}
        }


    }
    
}//GEN-LAST:event_jtxtdscriptionKeyPressed

private void jtxtdistcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdistcodeKeyPressed
formKeyPressed(evt);
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try{
            Cb_disth cbdist = new Cb_disth(jtxtdistcode.getText());

            try{
                jtblDetail.requestFocus();
                GlobalUtils.selectCellTable(jtblDetail, 0, 1);
            }catch(Exception e){}
        }catch(Exception e) {}
    }
}//GEN-LAST:event_jtxtdistcodeKeyPressed

private void jbtnBrowsedistcodeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jbtnBrowsedistcodeAncestorAdded
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowsedistcodeAncestorAdded

private void jtxtbankcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbankcodeKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try{
            Cb_bank bank = new Cb_bank(jtxtbankcode.getText());
            jtxtbankname.setText(bank.getbankname());

        }catch(Exception e) {}

        jtbnNew.requestFocus();
    }
formKeyPressed(evt);
}//GEN-LAST:event_jtxtbankcodeKeyPressed

private void jtxtAppliedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAppliedKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtUnApplied.requestFocus();
    }
    
}//GEN-LAST:event_jtxtAppliedKeyPressed

private void jbtnBrowserateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowserateActionPerformed
    // TODO add your handling code here:
    try {
        JTextField ratedate=new JTextField();

          Gl_currencyrateds brs = new Gl_currencyrateds();
          FrmBrowseGl_currencyrated bd = new FrmBrowseGl_currencyrated(brs);
          bd.homcur=jtxtbankcurnccode.getText();
          bd.ratetype=jtxtType.getText();
          bd.sourcecur=jtxtcurnccode.getText();
          bd.retrieveData();
          bd.setFirstValue(ratedate);
          bd.setSecondValue(jtxtRate);
          bd.setModal(true);
          bd.setVisible(true);

          cbhh.setratedate(ratedate.getText());

      } catch (CodeException ex) {
          ex.printStackTrace();
      }
}//GEN-LAST:event_jbtnBrowserateActionPerformed

private void jtxtTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTypeKeyPressed
formKeyPressed(evt);
    if(evt.getKeyCode()  == KeyEvent.VK_ENTER) {
        jtxtRate.requestFocus();
    }
    
}//GEN-LAST:event_jtxtTypeKeyPressed

private void jtxtcurnccodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcurnccodeKeyPressed
formKeyPressed(evt);
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtType.requestFocus();
    }
    
}//GEN-LAST:event_jtxtcurnccodeKeyPressed

private void jtblDetailAllocateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailAllocateMouseClicked
    int row  = jtblDetailAllocate.getSelectedRow();
    int col = jtblDetailAllocate.getSelectedColumn();


    if (row > -1 && col == 1 && evt.getClickCount() == 2) {
        if (col==1){
            if (GlobalUtils.churuf(jtblDetailAllocate.getValueAt(row, 1)).equalsIgnoreCase("Yes")){
                tmodeldetailalloacte.setValueAt("No", row, 1);
                
                Double remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 7).toString());
                Double applied=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 5).toString());

                remaining=remaining+applied;

                jtblDetailAllocate.setValueAt(remaining, row, 7);
                
                jtblDetailAllocate.setValueAt(0, row, 5);


                
            }else if(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(row, 1)).equalsIgnoreCase("No")) {
                tmodeldetailalloacte.setValueAt("Yes", row, 1);


                Double remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 7).toString());

                if (remaining>0&&GlobalUtils.toDbl(jtxtUnApplied.getText()).equals(new Double(0))){
                    tmodeldetailalloacte.setValueAt("No", row, 1);
                }
                double applied=remaining;
                Double unapplied=GlobalUtils.toDbl(jtxtUnApplied.getText());
                if (unapplied<remaining){
                    applied=unapplied;
                }
                jtblDetailAllocate.setValueAt(applied, row, 5);
                applied=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 5).toString());
                remaining=remaining-applied;

                jtblDetailAllocate.setValueAt(remaining, row, 7);
            }else if(GlobalUtils.churuf(jtblDetailAllocate.getValueAt(row, 1)).equalsIgnoreCase("Pending")) {
                tmodeldetailalloacte.setValueAt("Yes", row, 1);


                Double remaining=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 7).toString());
                double applied=remaining;
                Double unapplied=GlobalUtils.toDbl(jtxtUnApplied.getText());
                if (unapplied<remaining){
                    applied=unapplied;
                }
                jtblDetailAllocate.setValueAt(applied, row, 5);
                applied=GlobalUtils.toDbl(jtblDetailAllocate.getValueAt(row, 5).toString());
                remaining=remaining-applied;

                jtblDetailAllocate.setValueAt(remaining, row, 7);
            }

            try{
                //checkEntryRow(row);
                cekCbhdAllocate((Cb_batchd) cbhh.getCbhds().list().get(0));
            }catch(Exception e){}
                calculateapplied(false);
            }

       
    }
}//GEN-LAST:event_jtblDetailAllocateMouseClicked

private void jtblDetailAllocateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailAllocateMousePressed
    
}//GEN-LAST:event_jtblDetailAllocateMousePressed

private void jTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabMouseClicked

    if (jTab.getSelectedIndex() == 1) {
         //calculateapplied(false);
    }
    
}//GEN-LAST:event_jTabMouseClicked

private void jtblDetailAllocateVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtblDetailAllocateVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtblDetailAllocateVetoableChange

private void jtxtstartponoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtstartponoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoActionPerformed

private void jtxtstartponoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtstartponoPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoPropertyChange

private void jtxtstartponoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyPressed
formKeyPressed(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbDocType.requestFocus();
    }
}//GEN-LAST:event_jtxtstartponoKeyPressed

private void jtxtstartponoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoKeyReleased

private void jtxtstartponoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstartponoKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoKeyTyped

private void jtxtstartponoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtstartponoVetoableChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtstartponoVetoableChange

private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowse6ActionPerformed

private void jcmbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbDocTypeKeyPressed

}//GEN-LAST:event_jcmbDocTypeKeyPressed

private void jcmbentrytypeHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbentrytypeHKeyPressed
formKeyPressed(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         jtxtmisccode.requestFocus();
    }

}//GEN-LAST:event_jcmbentrytypeHKeyPressed

private void jtxtcustcheqnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcustcheqnoKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(jtxtcustcheqno.getText().length()!=10){
              JOptionPane.showMessageDialog(null, "Tidak Boleh Lebih dari 10 digit");
              jtxtcustcheqno.requestFocus();
              jtxtcustcheqno.setText("");
          }else{
             try{
                jtblDetail.requestFocus();
                GlobalUtils.selectCellTable(jtblDetail, 0, 1);
            }catch(Exception e){}
          }

    }
    formKeyPressed(evt);
}//GEN-LAST:event_jtxtcustcheqnoKeyPressed

private void jtxtRateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtRateKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtdscription.requestFocus();
    }
    formKeyPressed(evt);
}//GEN-LAST:event_jtxtRateKeyPressed

private void jcbMOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMOPKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtReference.requestFocus();
    }
formKeyPressed(evt);
}//GEN-LAST:event_jcbMOPKeyPressed

private void jcbYOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbYOPKeyPressed
 if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jcbMOP.requestFocus();
    }
 formKeyPressed(evt);
}//GEN-LAST:event_jcbYOPKeyPressed

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
// TODO add your handling code here:
     if(evt.isControlDown()==true){
         //Ctrl+S
            if (KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("S")) {
                try {
                    saveData();
                    JOptionPane.showMessageDialog(rootPane, "Saved");
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }


            }
            //Ctrl+N
            else if (KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("N")) {
               try {
                    newData();
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        

          //Ctrl+E
            else if (KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("E")) {
               try {
                     NewEntry();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
}
}//GEN-LAST:event_formKeyPressed
    
private void jTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabKeyPressed
    // TODO add your handling code here:
}//GEN-LAST:event_jTabKeyPressed

private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed

}//GEN-LAST:event_jPanel2KeyPressed

private void jtblDetailAllocateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtblDetailAllocateInputMethodTextChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jtblDetailAllocateInputMethodTextChanged

private void jcbYOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcbYOPFocusLost

private void jcbMOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcbMOPFocusLost

private void jcbMOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMOPItemStateChanged
    // TODO add your handling code here:
    if (!onload){
        checklockedperiode();
    }
}//GEN-LAST:event_jcbMOPItemStateChanged

private void jcbYOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYOPItemStateChanged
    // TODO add your handling code here:
    if (!onload){
        checklockedperiode();
    }
}//GEN-LAST:event_jcbYOPItemStateChanged

private void jcbYOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusGained
    // TODO add your handling code here:
    yopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
}//GEN-LAST:event_jcbYOPFocusGained

private void jcbMOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusGained
    // TODO add your handling code here:
    mopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
}//GEN-LAST:event_jcbMOPFocusGained

private void jtxtReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtReferenceActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtReferenceActionPerformed

private void jcmbentrytypeHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbentrytypeHActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcmbentrytypeHActionPerformed

    private void jtxtNoPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNoPVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNoPVActionPerformed

    private void jbtnBrowseNoPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseNoPVActionPerformed
        try {
            Payment_vouchers brs = new Payment_vouchers();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setFirstValue(jtxtNoPV);
            bd.setModal(true);
            bd.setVisible(true);
        } catch (CodeException ex) {
            Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnBrowseNoPVActionPerformed

private void checklockedperiode(){
        Boolean ischanged=false;
        int yopentry=GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
        if (yopentry!=yopbf){
            ischanged=true;
        }
        int mopentry=GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
        if (mopentry!=mopbf){
            ischanged=true;
        }
        if (ischanged){
            try {
                Gl_fiscalh ofisc = new Gl_fiscalh(Gl_fiscalh.PROPERTY_YOP, yopentry+"");
                if (ofisc.getIsperiodelocked(mopentry)) {
                    jcbMOP.setSelectedItem(GlobalUtils.formatmonth(mopbf));
                    jcbYOP.setSelectedItem(GlobalUtils.formatmonth(yopbf));
                    JOptionPane.showMessageDialog(this, "Invalid Procedure, Fiscal Periode Is Locked");
                }
            } catch (CodeException ex) {
                Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

private Integer findinvoiceintable(String docnum){
    int i=0;

    for (i=0;i<tmodeldetailalloacte.getRowCount();i++){
        if (GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(i, 3)).trim().equalsIgnoreCase(docnum.trim())){
            return i;
        }
    }
    return -1;
}

public void showdatainvoice(Cb_invoblcbhsd invcbsd) throws CodeException  {


        int ifind = findinvoiceintable(invcbsd.getDocnum());

        if (ifind > -1) {
            double val5 = 0;
            double pending = 0;
            try{
                val5 = Double.parseDouble(tmodeldetailalloacte.getValueAt(ifind, 5)+"");
            }catch(Exception e){
            }

            double id = 0;
            double remainingamt=0;
            try{
                id = Double.parseDouble(tmodeldetailalloacte.getValueAt(ifind, 0)+"");
            }catch(Exception e) {}

            remainingamt=invcbsd.getNetblc();
            if(id != 0){
                pending = invcbsd.getPendamt() - val5;
            }else {
                pending = invcbsd.getPendamt();
            }


            tmodeldetailalloacte.setValueAt(invcbsd.getDiscamt(), ifind, 6); //"Discount",
            tmodeldetailalloacte.setValueAt(remainingamt, ifind, 7); //"Remaining Amount",
            tmodeldetailalloacte.setValueAt(invcbsd.getOriamt(), ifind, 8); //"Dcoument Amount",

            tmodeldetailalloacte.setValueAt(pending, ifind, 9); //"Pending Amount",
            tmodeldetailalloacte.setValueAt(invcbsd.getPenddisc(), ifind, 10); //"Pending Discount",

            tmodeldetailalloacte.setValueAt(remainingamt, ifind, 13);
            GlobalUtils.selectCellTable(jtblDetailAllocate, ifind, 1);
            //checkEntryRow(ifind, false);
        }else {
            tmodeldetailalloacte.addRow(datadetail);
            GlobalUtils.selectCellTable(jtblDetailAllocate, tmodeldetailalloacte.getRowCount()-1, 1);

            tmodeldetailalloacte.setValueAt(0, tmodeldetailalloacte.getRowCount()-1, 0); //"id",

            tmodeldetailalloacte.setValueAt(invcbsd.getPendamt() > 0 ?"Pending" : "No", tmodeldetailalloacte.getRowCount()-1, 1); //"Apply",
            tmodeldetailalloacte.setValueAt(invcbsd.getDoctype(), tmodeldetailalloacte.getRowCount()-1, 2); //"Type",
            tmodeldetailalloacte.setValueAt(invcbsd.getDocnum(), tmodeldetailalloacte.getRowCount()-1, 3); //"Document Number",
            tmodeldetailalloacte.setValueAt(invcbsd.getDocdate(), tmodeldetailalloacte.getRowCount()-1, 4); //"Date",
            tmodeldetailalloacte.setValueAt(invcbsd.getApplamt(), tmodeldetailalloacte.getRowCount()-1, 5); //"Amount Applied",
            tmodeldetailalloacte.setValueAt(invcbsd.getDiscamt(), tmodeldetailalloacte.getRowCount()-1, 6); //"Discount",


            tmodeldetailalloacte.setValueAt(invcbsd.getNetblc(), tmodeldetailalloacte.getRowCount()-1, 7); //"Remaining Amount",
            tmodeldetailalloacte.setValueAt(invcbsd.getOriamt(), tmodeldetailalloacte.getRowCount()-1, 8); //"Dcoument Amount",
            tmodeldetailalloacte.setValueAt(invcbsd.getPendamt(), tmodeldetailalloacte.getRowCount()-1, 9); //"Pending Amount",

            tmodeldetailalloacte.setValueAt(invcbsd.getPenddisc(), tmodeldetailalloacte.getRowCount()-1, 10); //"Pending Discount",

            tmodeldetailalloacte.setValueAt(invcbsd.getPono(), tmodeldetailalloacte.getRowCount()-1, 11); //"PO Number",
            tmodeldetailalloacte.setValueAt(invcbsd.getOrderno(), tmodeldetailalloacte.getRowCount()-1, 12); //"SO Number"

            tmodeldetailalloacte.setValueAt(invcbsd.getNetblc(), tmodeldetailalloacte.getRowCount()-1, 13); //"Remaining Amount",
            GlobalUtils.selectCellTable(jtblDetailAllocate, tmodeldetailalloacte.getRowCount()-1, 1);
            //checkEntryRow(tmodeldetailalloacte.getRowCount()-1);

        }

        cekCbhdAllocate((Cb_batchd) cbhh.getCbhds().list().get(jtblDetail.getSelectedRow()));

        
    }

private Double getTotalEntry(){
    int i=0;
    Double totalentry=new Double(0);
    Double credit=new Double(0);
    Double debit=new Double(0);


    try{
        debit =cbhh.getTotalDebit();
        credit =cbhh.getTotalCredit();

        totalentry = debit - credit;

    }catch(Exception e) {}
    
    return totalentry;
}
private void cekCbhd() throws CodeException {

    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    if (tmodeldetail.getValueAt(row, 7)==null){
        tmodeldetail.setValueAt("1",row, 7);
    }else if (tmodeldetail.getValueAt(row, 7).equals("0")){
        tmodeldetail.setValueAt("1",row, 7);
    }


    Cb_batchd cbhd;
    if (row > cbhds.size() - 1) {
        cbhd = new Cb_batchd();
        cbhds.add(cbhd);
    }else{
        cbhd = (Cb_batchd) cbhds.list().get(row);
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail.getValueAt(row, 0)+"");
    }catch (Exception e){}
    
    cbhd.setID(idcbhd);
    cbhd.setmisccode(jtxtmisccode.getText());
    cbhd.setsrcecode(tmodeldetail.getValueAt(row, 1)+"");
    cbhd.setdscription(tmodeldetail.getValueAt(row, 2) == null ? "" : tmodeldetail.getValueAt(row, 2)+"");
    cbhd.setacccode(tmodeldetail.getValueAt(row, 3)+"");

    double amount = 0;
    try{
       amount = Double.parseDouble(tmodeldetail.getValueAt(row, 5)+"");
    }catch(Exception e){}
    try{
       amount = amount - Double.parseDouble(tmodeldetail.getValueAt(row, 6)+"") ;
    }catch(Exception e){}

    cbhd.setdetailamnt(amount);

    long entity = 0;
    try{
        entity = Long.parseLong(tmodeldetail.getValueAt(row, 7)+"");
    }catch(Exception e) {}
    cbhd.setquantity(entity);

    cbhd.setcomment(tmodeldetail.getValueAt(row, 8)+"");

    cbhds.list().set(row, cbhd);

    
    if(cbhds.size() > 0 && istatus == 0) {
        jcmbentrytypeH.setEnabled(false);
    }else {
        jcmbentrytypeH.setEnabled(true);
    }

}

private void cekCbhdAllocate(Cb_batchd cbhd) throws CodeException {

    int row = jtblDetailAllocate.getSelectedRow();
    int col = jtblDetailAllocate.getSelectedColumn();


    Cb_batchsds cbhsds=cbhd.getCbhds();
    Cb_batchsd cbhsd;

    if (row > cbhsds.size() - 1) {
        cbhsd = new Cb_batchsd();
        cbhsds.add(cbhsd);
    }else{
        cbhsd = (Cb_batchsd) cbhsds.list().get(row);
    }

    
    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetailalloacte.getValueAt(row, 0)+"");
    }catch (Exception e){}

    cbhsd.setID(idcbhd);
    
    
    cbhsd.setcustcode(jtxtmisccode.getText());

    //0"id",
    cbhsd.setApplied(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 1)));//1"Apply",
    cbhsd.setdoctype(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 2)));//2"Type",
    cbhsd.setdocno(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 3)));//3"Document Number",
    cbhsd.setdocdate(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 4)));//4"Date",
    cbhsd.setapplamount(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 5))));//5"Amount Applied",
    cbhsd.setdiscount(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 6))));//6"Discount",
    //0"Pending Discount",
    //cbhsd.setpono(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 11)));//1"PO Number",
    //cbhsd.setsono(GlobalUtils.churuf(tmodeldetailalloacte.getValueAt(row, 12)));//2"SO Number"
    cbhsds.list().set(row, cbhsd);

    int cnt=0;
    for (Object o:cbhsds.list()){
        Cb_batchsd a=(Cb_batchsd) o;
        if (a.getApplied().equalsIgnoreCase("yes")){
            cnt++;
        }
    }
    System.out.println("Jumlah yang ke Applied"+cnt);
}



private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);
    lockedData(!jtxtbatchsts.getText().equals("P"));

}                                           

                                                                              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmCb_batchcontrol().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTab;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowse6;
    private javax.swing.JButton jbtnBrowseBank;
    private javax.swing.JButton jbtnBrowseEntry;
    private javax.swing.JButton jbtnBrowseMiscode;
    private javax.swing.JButton jbtnBrowseNoPV;
    private javax.swing.JButton jbtnBrowsecurnccode;
    private javax.swing.JButton jbtnBrowsedistcode;
    private javax.swing.JButton jbtnBrowserate;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnDistributed;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnShowInvoice;
    private javax.swing.JComboBox jcbMOP;
    private javax.swing.JComboBox jcbYOP;
    private javax.swing.JCheckBox jchkreadytpost;
    private javax.swing.JComboBox jcmbDocType;
    private javax.swing.JComboBox jcmbbatchtype;
    private javax.swing.JComboBox jcmbentrytype;
    private javax.swing.JComboBox jcmbentrytypeH;
    private javax.swing.JLabel jlblMisc;
    private javax.swing.JLabel jlblTotalEntry;
    private javax.swing.JLabel jlblbankcode;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JLabel jlblbatchtype;
    private javax.swing.JLabel jlblcredittot;
    private javax.swing.JLabel jlblcustcheqno;
    private javax.swing.JLabel jlbldebittot;
    private javax.swing.JLabel jlbldistcode;
    private javax.swing.JLabel jlblentrycnt;
    private javax.swing.JLabel jlblentrytype;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblsrceledgr;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JPanel jpbatch_h;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JTable jtblDetailAllocate;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtAmount;
    private javax.swing.JTextField jtxtApplied;
    private javax.swing.JTextField jtxtEntryno;
    private javax.swing.JTextField jtxtIndex;
    private javax.swing.JTextField jtxtIndexSum;
    private javax.swing.JTextField jtxtNoPV;
    private javax.swing.JTextField jtxtRate;
    private javax.swing.JTextField jtxtReference;
    private javax.swing.JTextField jtxtSearchInvoice;
    private javax.swing.JTextField jtxtType;
    private javax.swing.JTextField jtxtUnApplied;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtbankcode;
    private javax.swing.JTextField jtxtbankcurnccode;
    private javax.swing.JTextField jtxtbankname;
    private javax.swing.JTextField jtxtbatchno;
    private javax.swing.JTextField jtxtbatchsts;
    private javax.swing.JTextField jtxtbtchdesc;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtcredittot;
    private javax.swing.JTextField jtxtcurnccode;
    private javax.swing.JTextField jtxtcustcheqno;
    private javax.swing.JTextField jtxtdebittot;
    private javax.swing.JTextField jtxtdistcode;
    private javax.swing.JTextField jtxtdistdesc;
    private javax.swing.JTextField jtxtdscription;
    private javax.swing.JTextField jtxtentrycnt;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtmisccode;
    private javax.swing.JTextField jtxtmiscdscription;
    private javax.swing.JTextField jtxtsrceledgr;
    protected javax.swing.JTextField jtxtstartpono;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        obj.moveFirst();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
        lockedData(!jtxtbatchsts.getText().equals("P"));
    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
        lockedData(!jtxtbatchsts.getText().equals("P"));
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
        lockedData(!jtxtbatchsts.getText().equals("P"));
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
        lockedData(!jtxtbatchsts.getText().equals("P"));
    }

    public void searchData() throws CodeException {
        obj = new Cb_batchcontrol(this.jtxtbatchno.getText());
        showData();
        mf.setIcon(CLASSNAME);
        lockedData(!jtxtbatchsts.getText().equals("P"));

    }
    public void newData() throws CodeException {
        obj = new Cb_batchcontrol();
        MOPChangedManually=false;
        
        istatus=1;
        jtxtbankcode.requestFocus();
        showData();

        try {
            kdateentrydate.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
        }
        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
        jcbYOP.setSelectedItem((long)GlobalUtils.getYear(GlobalUtils.sessiondate));

        jtxtbankcode.setText(cbo.getbankcode());

        Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
        jtxtbankcurnccode.setText(cbbank.getcurnccode());
        jtxtType.setText(cbbank.getratetypecode());

        jtxtsrceledgr.setText(cbbank.getsrceledgr());
        jchkreadytpost.setSelected(true);

        jtxtcurnccode.setText(cbbank.getcurnccode());

        setToolBar(iformtype,istatus);

        jbtnShowInvoice.setEnabled(true);
        jbtnSearch.setEnabled(true);


        jcmbentrytypeH.setSelectedIndex(0);
        jtxtUnApplied.setText("0");
        jTab.setSelectedIndex(0);
        
    }

    public void saveData() throws CodeException {
        if (GlobalUtils.toDbl(jtxtUnApplied.getText())>0){
            JOptionPane.showMessageDialog(this, "Invalid Procedure, Unapplied Exists");
        } else if (jtxtReference.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Ref/Cheque cannot be empy");
        } else {

            int index = 0;
            try{
                index = Integer.parseInt(jtxtIndex.getText());
            }catch(Exception e) {}


                Cb_bank cbb=new Cb_bank(jtxtbankcode.getText());
            if (cbb.getID()>0){
    
                GlobalModel.clearEmptyRow(tmodeldetail);
                istatus = 0;

                setData();

                setDataCbhh();

                obj.save();

                if (ocb_voucher.getID()!=ocb_voucher.NULLID){
                    ocb_voucher.closestatus();
                }
                obj=new Cb_batchcontrol(obj.getID());


                showData();

                try{
                    cbhh = (Cb_batchh) obj.getCbhhs().list().get(index - 1);                    
                }catch(Exception e){
                    
                }
                showDataCbhh();


                jtxtIndex.setText(jtxtEntryno.getText());
                


                jtxtid.setText(obj.toString(Cb_batchcontrol.PROPERTY_ID));
                jtxtbatchno.setText(decform.format(obj.getbatchno()));

                jtxtEntryno.setText(cbhh.getentryno()+"");

                for(int i = 0; i < jtblDetail.getRowCount(); i++) {

                    try {
                        Cb_batchd cbhd = (Cb_batchd) cbhh.getCbhds().list().get(i);
                        tmodeldetail.setValueAt(cbhd.getID(), i, 0);
                    }catch(Exception e) {}
                }

                //showData();


                mf.setIcon(CLASSNAME);

            } else {
                JOptionPane.showMessageDialog(this,"Invalid procedure, Bank Code Doesnt Exits");
            }
        }
    }

    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	
             jtxtid.setText(obj.toString(Cb_batchcontrol.PROPERTY_ID));
             jtxtbatchno.setText(decform.format(obj.getbatchno()));
             jtxtbankcode.setText(obj.toString(Cb_batchcontrol.PROPERTY_BANKCODE));

             if (obj.getCbhhs().size()>0){
                 jtxtbankcode.setEditable(false);
                 jbtnBrowseBank.setEnabled(false);
             } else {
                 jtxtbankcode.setEditable(true);
                 jbtnBrowseBank.setEnabled(true);
             }
             try{

                 Cb_bank cbbank = obj.getBank();

                 jtxtbankname.setText(cbbank.getbankname());
                 jtxtbankcurnccode.setText(cbbank.getcurnccode());
                 
             }catch(Exception e) {

                 e.printStackTrace();
                   jtxtbankname.setText("");
             }

             jtxtbtchdesc.setText(obj.toString(Cb_batchcontrol.PROPERTY_BTCHDESC));
             jtxtsrceledgr.setText(obj.toString(Cb_batchcontrol.PROPERTY_SRCELEDGR));

             try {
                 if (obj.getbatchtype().equals("N")) {
                    jcmbbatchtype.setSelectedItem(jcmbbatchtype.getItemAt(0)+"");
                 }else {
                    jcmbbatchtype.setSelectedItem(jcmbbatchtype.getItemAt(1)+"");
                 }
            }catch(Exception e) {}


             try{
                 if(obj.getentrytype().equals("E")) {
                    jcmbentrytype.setSelectedItem(jcmbentrytype.getItemAt(0)+"");
                 }else{
                    jcmbentrytype.setSelectedItem(jcmbentrytype.getItemAt(0)+"");
                 }

             }catch(Exception e) {}


             jtxtbatchsts.setText(obj.toString(Cb_batchcontrol.PROPERTY_BATCHSTS));
             jtxtentrycnt.setText(obj.toString(Cb_batchcontrol.PROPERTY_ENTRYCNT));

             if (obj.getID()==0){
                 jchkreadytpost.setSelected(true);
             } else {
                 jchkreadytpost.setSelected(obj.getreadytpost() == 1);
             }
             
             jtxtentrydate.setText(obj.toString(Cb_batchcontrol.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Cb_batchcontrol.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Cb_batchcontrol.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Cb_batchcontrol.PROPERTY_CMPNYID));

             jtxtdebittot.setText(GlobalUtils.formatnumber(obj.getdebittot()));
             jtxtcredittot.setText(GlobalUtils.formatnumber(obj.getcredittot()));

             jtxtIndexSum.setText(obj.getCbhhs().list().size()+"");

             if (obj.getCbhhs().list().isEmpty()) {
                 jtxtIndex.setText("0");
                 //setCbhhEnable(false);
                 cbhh = new Cb_batchh();
             }else{
                jtxtIndex.setText("1");
                cbhh = (Cb_batchh) obj.getCbhhs().list().get(0);
                setCbhhEnable(true);
              }
             showDataCbhh();

        caltotal();
        setCursor(GlobalUtils.NORMALCURSOR);
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        try {
            if (obj.getbatchsts().equals("2")) {
                mf.setToolBar(iformtype, 7);
                unlockbutton(false);
            } else {
                mf.setToolBar(iformtype, istatus);
                unlockbutton(true);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void setData() throws CodeException {
        
	
          obj.fromString(Cb_batchcontrol.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Cb_batchcontrol.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;

          obj.fromString(Cb_batchcontrol.PROPERTY_BANKCODE, jtxtbankcode.getText()) ;
          obj.fromString(Cb_batchcontrol.PROPERTY_BTCHDESC, jtxtbtchdesc.getText()) ;
          obj.fromString(Cb_batchcontrol.PROPERTY_SRCELEDGR, jtxtsrceledgr.getText()) ;

          obj.setbatchtype((jcmbbatchtype.getSelectedItem()+"").substring(0,1));
          obj.setentrytype((jcmbentrytype.getSelectedItem()+"").substring(0,1));
          obj.fromString(Cb_batchcontrol.PROPERTY_BATCHSTS, jtxtbatchsts.getText()) ;
          obj.setdebittot(GlobalUtils.toDbl(jtxtdebittot.getText())) ;
          obj.setcredittot(GlobalUtils.toDbl(jtxtcredittot.getText())) ;
          obj.setentrycnt(GlobalUtils.toInt(jtxtentrycnt.getText())) ;

          obj.setreadytpost(jchkreadytpost.isSelected()? 1:0);

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
        Map parameter = new HashMap();
        NavigatorObjectInt noi = (NavigatorObjectInt) obj;        
        String file   = GlobalUtils.getCurrentDir() +"/Reports/" + noi.getClassName() + ".jrxml";
        GlobalUtils.printReport(file,  false);    
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
    private void changeLabel() {
        jlbldistcode.setVisible(false);
        jtxtdistcode.setVisible(false);
        jbtnBrowsedistcode.setVisible(false);
        jtxtdistdesc.setVisible(false);
//        jlblcustcheqno.setVisible(false);
//        jtxtcustcheqno.setVisible(false);
        jbtnDistributed.setVisible(false);


        if (jcmbentrytypeH.getSelectedIndex() == 0 ) {
            jlblMisc.setText("Misc. Code");
            jlbldistcode.setVisible(true);
            jtxtdistcode.setVisible(true);
            jbtnBrowsedistcode.setVisible(true);
            jtxtdistdesc.setVisible(true);
            jbtnDistributed.setVisible(true);
            jTab.setEnabledAt(1, false);
        }else if(jcmbentrytypeH.getSelectedIndex() == 1 ) {
            //AP
            jlblMisc.setText("Vendor");

            if (!jtxtmisccode.getText().trim().equalsIgnoreCase("")){
                jTab.setEnabledAt(1, true);
            } else {
                jTab.setEnabledAt(1, false);
            }


        }else {
            //AR
            jlblMisc.setText("Customer");
            jlblcustcheqno.setVisible(true);
            jtxtcustcheqno.setVisible(true);

            if (!jtxtmisccode.getText().trim().equalsIgnoreCase("")){
                jTab.setEnabledAt(1, true);
            } else {
                jTab.setEnabledAt(1, false);
            }

            

        }
    }

    //Untuk Batch Header

    
    private void setDataCbhh() throws CodeException {

        GlobalModel.clearEmptyRow(tmodeldetail);

        if (jcmbentrytypeH.getSelectedIndex() == 0) {
            cbhh.setentrytype("C");
        }else if (jcmbentrytypeH.getSelectedIndex() == 1){
            cbhh.setentrytype("P");
        }else{
            cbhh.setentrytype("R");
        }

        cbhh.fromString(Cb_batchh.PROPERTY_BATCHDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd"));
        cbhh.fromString(Cb_batchh.PROPERTY_CURNCCODE, jtxtbankcurnccode.getText());
        cbhh.fromString(Cb_batchh.PROPERTY_SRCECURNCCODE, jtxtcurnccode.getText());
        cbhh.fromString(Cb_batchh.PROPERTY_ENTRYNO, jtxtEntryno.getText());
        cbhh.fromString(Cb_batchh.PROPERTY_ENTRYDATE, kdateentrydate.getDate());
        cbhh.fromString(Cb_batchh.PROPERTY_MISCCODE, jtxtmisccode.getText()) ;
        cbhh.fromString(Cb_batchh.PROPERTY_DSCRIPTION, jtxtdscription.getText()) ;
        cbhh.fromString(Cb_batchh.PROPERTY_REFERENCE, jtxtReference.getText()) ;
        cbhh.fromString(Cb_batchh.PROPERTY_CUSTCHEQNO, jtxtcustcheqno.getText());
        cbhh.fromString(Cb_batchh.PROPERTY_DISTCODE, jtxtdistcode.getText());

        cbhh.fromString(Cb_batchh.PROPERTY_RATETYPE, jtxtType.getText());
        cbhh.fromString(Cb_batchh.PROPERTY_RATEAMOUNT, jtxtRate.getText());

        cbhh.fromString(Cb_batchh.PROPERTY_MOP, jcbMOP.getSelectedItem().toString()) ;
        cbhh.fromString(Cb_batchh.PROPERTY_YOP, jcbYOP.getSelectedItem().toString()) ;
        cbhh.fromString(Cb_batchh.PROPERTY_NO_PAYMENT_VOUCHER, jtxtNoPV.getText());

        if (cbhh.getID()==0){
            obj.addCbhh(cbhh);
        } else {
            try{
                obj.replaceCbhh(Integer.parseInt(jtxtIndex.getText()) - 1, cbhh);
            }catch(Exception e) {}
        }
        
    }


    private void setCbhhEnable(boolean enable) {
        jtxtReference.setEnabled(enable);
        jcmbentrytypeH.setEnabled(enable);
        jtxtmisccode.setEnabled(enable);
        jtxtdscription.setEnabled(enable);
    }

    public void showDataCbhh() throws CodeException  {

        onload=true;
        
        try {
            if(cbhh.getentrytype().equalsIgnoreCase("C")) {
                jcmbentrytypeH.setSelectedIndex(0);
            }else  if(cbhh.getentrytype().equalsIgnoreCase("P")) {
                jcmbentrytypeH.setSelectedIndex(1);
            }else{
                jcmbentrytypeH.setSelectedIndex(2);
            }
        }catch(Exception e) {}

        jtxtcurnccode.setText(cbhh.getsrcecurnccode());
        jtxtType.setText(cbhh.getratetype());
        jtxtRate.setText(GlobalUtils.formatnumber(cbhh.getrateamount()));

        jtxtEntryno.setText(cbhh.getentryno()+"");
        if (cbhh.getentrydate() != null) {
            try {
                kdateentrydate.setDate(GlobalUtils.formatDate(cbhh.getbatchdate(),"MM/dd/yyyy"));
            } catch (KazaoCalendarDateTimeException ex) {
                Logger.getLogger(FrmCb_batchentry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jtxtcustcheqno.setText(cbhh.getcustcheqno());
        jtxtdistcode.setText(cbhh.getdistcode());

        Cb_disth cbdist = new Cb_disth(jtxtdistcode.getText());
        jtxtdistdesc.setText(cbdist.getdscription());
        
        //if(jlblTotalEntry.getText().equals("0")){
           jtxtReference.setText(cbhh.getreference());
        //}else{
        //    jtxtReference.setText((cbhh.getreference() + 1) +"");}
            

        jtxtmisccode.setText(cbhh.getmisccode());
        jtxtmiscdscription.setText("");
        
        if (jcmbentrytypeH.getSelectedIndex()==1){
            Ap_vendor apvendor=new Ap_vendor(jtxtmisccode.getText());
            jtxtmiscdscription.setText(apvendor.getvendname());

        }

        if (jcmbentrytypeH.getSelectedIndex()==2){
            Ar_customer arcust=new Ar_customer(jtxtmisccode.getText());
            jtxtmiscdscription.setText(arcust.getcustmrname());
        }
        
        jtxtdscription.setText(cbhh.getdscription());
        jtxtNoPV.setText(cbhh.getno_payment_voucher());

        mopbf=cbhh.getmop();
        yopbf=cbhh.getyop();
        String mop="";
        if (cbhh.getmop()<10){
            mop="0"+cbhh.getmop();
        } else {
            mop=cbhh.getmop()+"";
        }
        if (cbhh.getID()>0){
            jcbMOP.setSelectedItem(mop);
            jcbYOP.setSelectedItem(cbhh.getyop());
        } else {

            findYear(GlobalUtils.toInt(GlobalUtils.getCurrentYear()));
            mop="";
            if (GlobalUtils.toInt(GlobalUtils.getCurrentMonth())<10){
                mop="0"+GlobalUtils.toInt(GlobalUtils.getCurrentMonth());
            } else {
                mop=GlobalUtils.toInt(GlobalUtils.getCurrentMonth())+"";
            }
            jcbMOP.setSelectedItem(mop);
        }

        cbhds = cbhh.getCbhds();

        try{
            showDataCbhd();
        }catch(Exception e){}

        jlblTotalEntry.setText(GlobalUtils.formatnumber(getTotalEntry()));

        onload=false;
    }

    private void findYear(int year) {
        for (int i = 0; i < jcbYOP.getItemCount() ; i++) {
            if (Integer.parseInt(jcbYOP.getItemAt(i)+ "") == year) {
                jcbYOP.setSelectedIndex(i);
                break;
            }
        }
    }



    //Untuk Batch Detail
    public void showDataCbhd() throws CodeException  {

        

        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, 0);

        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 7);

        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;
        

        for(Object  o : cbhds.list()){
            Cb_batchd cbhd = (Cb_batchd) o;


            tmodeldetail.setValueAt(cbhd.getID(), tmodeldetail.getRowCount() - 1, 0);
            tmodeldetail.setValueAt(cbhd.getsrcecode(), tmodeldetail.getRowCount() - 1, 1);
            tmodeldetail.setValueAt(cbhd.getdscription() == null ? "" : cbhd.getdscription(), tmodeldetail.getRowCount() - 1, 2);
            
            
            Gl_account glacc = new Gl_account(cbhd.getacccode().replace("-", ""));
            tmodeldetail.setValueAt(glacc.getaccfmttd(), tmodeldetail.getRowCount() - 1, 3);
            tmodeldetail.setValueAt(glacc.getaccdesc(), tmodeldetail.getRowCount() - 1, 4);

            double amount = cbhd.getdetailamnt();
            double receive = 0;
            double payment = 0;

            if (amount > 0) {
                receive = amount;                
            }else{
                payment = Math.abs(amount);
            }

            tmodeldetail.setValueAt(receive, tmodeldetail.getRowCount() - 1, 5);
            tmodeldetail.setValueAt(payment, tmodeldetail.getRowCount() - 1, 6);

            tmodeldetail.setValueAt(cbhd.getquantity(), tmodeldetail.getRowCount() - 1, 7);
            tmodeldetail.setValueAt(cbhd.getcomment(), tmodeldetail.getRowCount() - 1, 8);

            tmodeldetail.addRow(datadetail);
        }

        if (cbhds.size()>0){
            caltotal();
             Double alocateamount=new Double(0);
            switch (jcmbentrytypeH.getSelectedIndex()){
                case 0:
                    break;
                case 1:
                    alocateamount=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(0, 6)));
                    break;
                case 2:
                    alocateamount=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(0, 5)));
                    break;
            }

            jtxtAmount.setText(GlobalUtils.formatnumber(alocateamount));
            jtxtUnApplied.setText(GlobalUtils.formatnumber(alocateamount));
            
            showDataCbhsd((Cb_batchd) cbhds.list().get(0));


        } else {
            Cb_batchd cbbatchd=new Cb_batchd();
            showDataCbhsd(cbbatchd);
            jTab.setEnabledAt(1, false);
        }

        if(cbhds.size() > 0 && istatus == 0) {
            jcmbentrytypeH.setEnabled(false);
         }else {
            jcmbentrytypeH.setEnabled(true);
        }
       
    }

    public void showDataCbhsd(Cb_batchd cbhd) throws CodeException  {

        GlobalModel.clearRow(tmodeldetailalloacte);

        posttable = -1;
        Cb_batchsds cbhsds=cbhd.getCbhds();

        for(Object  o : cbhsds.list()){
            Cb_batchsd cbhsd = (Cb_batchsd) o;
            tmodeldetailalloacte.addRow(datadetail);

            tmodeldetailalloacte.setValueAt(cbhsd.getID(), tmodeldetailalloacte.getRowCount()-1, 0); //"id",
            tmodeldetailalloacte.setValueAt(cbhsd.getapplamount() != 0 ? "Yes" : "No", tmodeldetailalloacte.getRowCount()-1, 1); //"Apply",
            tmodeldetailalloacte.setValueAt(cbhsd.getdoctypedesc(), tmodeldetailalloacte.getRowCount()-1, 2); //"Type",
            tmodeldetailalloacte.setValueAt(cbhsd.getdocno(), tmodeldetailalloacte.getRowCount()-1, 3); //"Document Number",
            tmodeldetailalloacte.setValueAt(cbhsd.getdocdate(), tmodeldetailalloacte.getRowCount()-1, 4); //"Date",
            tmodeldetailalloacte.setValueAt(cbhsd.getapplamount(), tmodeldetailalloacte.getRowCount()-1, 5); //"Amount Applied",
            tmodeldetailalloacte.setValueAt(cbhsd.getdiscount(), tmodeldetailalloacte.getRowCount()-1, 6); //"Discount",

        }

        GlobalUtils.selectCellTable(jtblDetail, 0, 1);
        calculateapplied(false);


    }


    private void lockedData(boolean val) {
        mf.btnDel.setEnabled(val);
        mf.btnSave.setEnabled(val);
        mf.btnConfirm.setEnabled(val);
        mf.btnUndo.setEnabled(val);

        jtbnNew.setEnabled(val);
        jbtnDelete.setEnabled(val);
        
    }

    
}
