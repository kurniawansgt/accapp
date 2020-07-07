/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.gl.FrmGl_batchlist;
 * 
 * .......
 * 
 * 
 * FrmGl_batchlist frmGl_batchlist;
 * 
 * .......
 * 
 try {
        if (frmGl_batchlist == null) {
            frmmGl_batchlist = new FrmGl_batchlist(this);
        }
        
        showForm(frmGl_batchlist);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.gl;

import accapp.component.browse.FrmBrowseAccountActive;
import accapp.component.browse.FrmBrowseCb_cash_advances_open;
import accapp.component.browse.FrmBrowseGl_sourcelgrsGL;
import accapp.objectclasses.cashbook.Cb_cash_advance;
import accapp.objectclasses.cashbook.Cb_cash_advances;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
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
import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_batchlists;
import accapp.objectclasses.gl.Gl_currency;
import accapp.objectclasses.gl.Gl_currencys;
import accapp.objectclasses.gl.Gl_fiscald;
import accapp.objectclasses.gl.Gl_fiscalh;
import accapp.objectclasses.gl.Gl_fiscalhs;
import accapp.objectclasses.gl.Gl_import_data_msg;
import accapp.objectclasses.gl.Gl_jed;
import accapp.objectclasses.gl.Gl_jed_temp;
import accapp.objectclasses.gl.Gl_jeds;
import accapp.objectclasses.gl.Gl_jeh;
import accapp.objectclasses.gl.Gl_option;
import accapp.objectclasses.gl.Gl_sourcelgr;
import accapp.objectclasses.gl.Gl_sourcelgrs;
import common.component.FrmBrowseObject;
import common.tablemodels.GlobalModel;
import common.tablemodels.myColorCellRenderer;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.kazao.calendar.KazaoCalendar;
import org.kazao.calendar.KazaoCalendarAdapter;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author  Generator
 */

public class FrmGl_batchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmGl_batchlist";
    
    FrmMainFrame mf ;
    
    
    public Gl_batchlist obj = new Gl_batchlist();

    DateFormat dfmmddyyyy =new SimpleDateFormat("MM/dd/yyyy");
    DateFormat dfddmmyyyy =new SimpleDateFormat("dd/MM/yyyy");

    DecimalFormat decform = new DecimalFormat("##0");

    Gl_jeh gljeh = new Gl_jeh();
    Gl_jeds gljeds = new Gl_jeds();

    Gl_option glopt=new Gl_option(GlobalUtils.company);


    Object[] datadetail;
    DefaultTableModel tmodeldetail;


    int posttable = 0;
    long mopbf=0;
    long yopbf=0;

    Boolean MOPChangedManually=false;

    boolean onload = false;
    private Gl_batchlist objtmp;
    private Gl_jeh gljehtmp;

    

    /** Creates new form Area */
    public FrmGl_batchlist() throws CodeException {
        initComponents();
    }
    
    public FrmGl_batchlist(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();

        kdateentrydate.addChangeListener(new KazaoCalendarAdapter() {
            public void onChange(Calendar calendar) {
            }
            public void onChange(KazaoCalendar calendar) {
                if (!MOPChangedManually){

                    jcmbYOP.setSelectedItem(GlobalUtils.getYear(kdateentrydate.getDate()).longValue());
                    jcmbMOP.setSelectedIndex(GlobalUtils.getMonth(kdateentrydate.getDate())-1);
                }
            }
            public void onDoubleClick() {
            }
            });

        datadetail = new Object[jtblDetail.getRowCount()];
        tmodeldetail = (DefaultTableModel) jtblDetail.getModel();

        jtxtid.setBounds(180, 30, 80, 20);
        jtxtentrydate.setBounds(260, 30, 160, 20);
        jtxtauditdate.setBounds(420, 30, 140, 20);
        jtxtaudituser.setBounds(560, 30, 110, 20);
        jtxtcmpnyid.setBounds(670, 30, 120, 20);

        jtxtid.setEditable(false);
        jtxtentrydate.setEditable(false);
        jtxtauditdate.setEditable(false);
        jtxtaudituser.setEditable(false);
        jtxtcmpnyid.setEditable(false);

        fillYOP();
        fillMOP();
        

        jtblDetail.setDefaultRenderer(Object.class, new myColorCellRenderer());

    }

    public void setgl_batchlist(Gl_batchlist obj){
        this.obj=obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillMOP() throws CodeException{
        jcmbMOP.removeAllItems();

        Gl_fiscalh ocal=new Gl_fiscalh(Gl_fiscalh.PROPERTY_YOP, GlobalUtils.getYear(GlobalUtils.sessiondate)+"");
        for (Object od:ocal.getDetail().list()){
            Gl_fiscald ocald=(Gl_fiscald) od;

            if (ocald.getmop()<10){
                jcmbMOP.addItem("0"+ocald.getmop());
            } else {
                jcmbMOP.addItem(""+ocald.getmop());
            }
        }
        jcmbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
    }

    private void fillYOP() throws CodeException{
        jcmbYOP.removeAllItems();

        Gl_fiscalhs ocaly=new Gl_fiscalhs();
        ocaly.searchData();
        for (Object od:ocaly.list()){
            Gl_fiscalh ocal=(Gl_fiscalh) od;
            jcmbYOP.addItem(ocal.getyop());

        }

        jcmbYOP.setSelectedItem(GlobalUtils.getYear(GlobalUtils.sessiondate).longValue());
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
        jbtnBrowse = new javax.swing.JButton();
        jtxtid = new javax.swing.JTextField();
        jlblbatchid = new javax.swing.JLabel();
        jtxtbatchid = new javax.swing.JTextField();
        jtxtbatchdesc = new javax.swing.JTextField();
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlblentrycnt = new javax.swing.JLabel();
        jtxtentrycnt = new javax.swing.JTextField();
        jlbldebittot = new javax.swing.JLabel();
        jtxtdebittot = new javax.swing.JTextField();
        jlblcredittot = new javax.swing.JLabel();
        jtxtcredittot = new javax.swing.JTextField();
        jlblbatchtype = new javax.swing.JLabel();
        jtxtbatchtype = new javax.swing.JTextField();
        jlblbatchsts = new javax.swing.JLabel();
        jtxtbatchsts = new javax.swing.JTextField();
        HorizontalLine1 = new javax.swing.JSeparator();
        jtxtbtchentry = new javax.swing.JTextField();
        jlblbtchentry = new javax.swing.JLabel();
        jtxtjrnldesc = new javax.swing.JTextField();
        jbtnBrowseSourceGL = new javax.swing.JButton();
        jlbljournalentry1 = new javax.swing.JLabel();
        jlblyop = new javax.swing.JLabel();
        jlblmop = new javax.swing.JLabel();
        jlblsrcelgrcode = new javax.swing.JLabel();
        jtxtsrcelgrcodedesc = new javax.swing.JTextField();
        jtxtsrcelgrcode = new javax.swing.JTextField();
        jchkAutoReversal = new javax.swing.JCheckBox();
        jcmbMOP = new javax.swing.JComboBox();
        jcmbYOP = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new selectallJTable(tmodeldetail);
        jlbljrnldebit = new javax.swing.JLabel();
        jtxtjrnldebit = new javax.swing.JTextField();
        jlbljrnlcredit = new javax.swing.JLabel();
        jtxtjrnlcredit = new javax.swing.JTextField();
        jlbljrnlcredit1 = new javax.swing.JLabel();
        jtxtoutbalance = new javax.swing.JTextField();
        jbtnBrowseEntry = new javax.swing.JButton();
        jtbnNew = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jlbljrnldebit1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kdateentrydate = new org.kazao.calendar.KazaoCalendarDate();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("G/L Journal Entry");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        jHeader.setBackground(new java.awt.Color(102, 102, 102));
        jHeader.setFont(new java.awt.Font("Dialog", 1, 10));
        jHeader.setForeground(new java.awt.Color(255, 255, 255));
        jHeader.setText(" : : Journal Entry");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 130, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 830, 12);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 12, 400);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(210, 70, 20, 20);

        jtxtid.setFont(new java.awt.Font("Tahoma", 0, 10));
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(170, 30, 80, 25);

        jlblbatchid.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchid.setText("Journal");
        getContentPane().add(jlblbatchid);
        jlblbatchid.setBounds(50, 70, 80, 13);

        jtxtbatchid.setEditable(false);
        jtxtbatchid.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchid.setText("batchid");
        jtxtbatchid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtbatchidActionPerformed(evt);
            }
        });
        jtxtbatchid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtbatchidFocusGained(evt);
            }
        });
        jtxtbatchid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchidKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchid);
        jtxtbatchid.setBounds(130, 70, 80, 25);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchdesc.setText("btchdesc");
        jtxtbatchdesc.setToolTipText("Batch Description");
        jtxtbatchdesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtbatchdescFocusGained(evt);
            }
        });
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(240, 70, 330, 25);

        jtxtentrydate.setFont(new java.awt.Font("Tahoma", 0, 10));
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(250, 30, 80, 25);

        jtxtauditdate.setFont(new java.awt.Font("Tahoma", 0, 10));
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(330, 30, 80, 25);

        jtxtaudituser.setFont(new java.awt.Font("Tahoma", 0, 10));
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(410, 30, 80, 25);

        jtxtcmpnyid.setFont(new java.awt.Font("Tahoma", 0, 10));
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(490, 30, 80, 25);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(null);

        jlblentrycnt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblentrycnt.setText("Entries");
        jPanel5.add(jlblentrycnt);
        jlblentrycnt.setBounds(10, 10, 140, 13);

        jtxtentrycnt.setEditable(false);
        jtxtentrycnt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtentrycnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtentrycnt.setText("entrycnt");
        jPanel5.add(jtxtentrycnt);
        jtxtentrycnt.setBounds(130, 10, 150, 25);

        jlbldebittot.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldebittot.setText("Debits");
        jPanel5.add(jlbldebittot);
        jlbldebittot.setBounds(10, 30, 140, 13);

        jtxtdebittot.setEditable(false);
        jtxtdebittot.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdebittot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdebittot.setText("debittot");
        jPanel5.add(jtxtdebittot);
        jtxtdebittot.setBounds(130, 30, 150, 25);

        jlblcredittot.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblcredittot.setText("Credits");
        jPanel5.add(jlblcredittot);
        jlblcredittot.setBounds(10, 50, 140, 13);

        jtxtcredittot.setEditable(false);
        jtxtcredittot.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcredittot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtcredittot.setText("credittot");
        jPanel5.add(jtxtcredittot);
        jtxtcredittot.setBounds(130, 50, 150, 25);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchtype.setText("Type");
        jPanel5.add(jlblbatchtype);
        jlblbatchtype.setBounds(10, 90, 140, 13);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchtype.setText("batchtype");
        jPanel5.add(jtxtbatchtype);
        jtxtbatchtype.setBounds(130, 90, 150, 25);

        jlblbatchsts.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchsts.setText("Status");
        jPanel5.add(jlblbatchsts);
        jlblbatchsts.setBounds(10, 110, 140, 13);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchsts.setText("batchsts");
        jPanel5.add(jtxtbatchsts);
        jtxtbatchsts.setBounds(130, 110, 150, 25);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(700, 70, 290, 140);

        HorizontalLine1.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine1.setAlignmentX(0.0F);
        HorizontalLine1.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine1);
        HorizontalLine1.setBounds(50, 100, 520, 10);

        jtxtbtchentry.setEditable(false);
        jtxtbtchentry.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbtchentry.setText("btchentry");
        jtxtbtchentry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtbtchentryFocusGained(evt);
            }
        });
        jtxtbtchentry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbtchentryKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbtchentry);
        jtxtbtchentry.setBounds(130, 110, 80, 25);

        jlblbtchentry.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbtchentry.setText("Date");
        getContentPane().add(jlblbtchentry);
        jlblbtchentry.setBounds(50, 140, 70, 13);

        jtxtjrnldesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtjrnldesc.setText("jrnldesc");
        jtxtjrnldesc.setToolTipText("Entry Description");
        jtxtjrnldesc.setNextFocusableComponent(jtxtsrcelgrcode);
        jtxtjrnldesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtjrnldescFocusGained(evt);
            }
        });
        jtxtjrnldesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtjrnldescKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtjrnldesc);
        jtxtjrnldesc.setBounds(240, 110, 330, 25);

        jbtnBrowseSourceGL.setText("...");
        jbtnBrowseSourceGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseSourceGLActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowseSourceGL);
        jbtnBrowseSourceGL.setBounds(220, 210, 20, 20);

        jlbljournalentry1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljournalentry1.setText("Entry");
        getContentPane().add(jlbljournalentry1);
        jlbljournalentry1.setBounds(50, 110, 70, 13);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblyop.setText("Year");
        getContentPane().add(jlblyop);
        jlblyop.setBounds(190, 170, 70, 20);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblmop.setText("Periode");
        getContentPane().add(jlblmop);
        jlblmop.setBounds(50, 170, 70, 20);

        jlblsrcelgrcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblsrcelgrcode.setText("Source Ldgr");
        getContentPane().add(jlblsrcelgrcode);
        jlblsrcelgrcode.setBounds(50, 210, 70, 13);

        jtxtsrcelgrcodedesc.setEditable(false);
        jtxtsrcelgrcodedesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcelgrcodedesc.setText("srcelgrcode");
        jtxtsrcelgrcodedesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcelgrcodedescFocusGained(evt);
            }
        });
        getContentPane().add(jtxtsrcelgrcodedesc);
        jtxtsrcelgrcodedesc.setBounds(250, 210, 270, 25);

        jtxtsrcelgrcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcelgrcode.setToolTipText("Source Code GL");
        jtxtsrcelgrcode.setNextFocusableComponent(jtblDetail);
        jtxtsrcelgrcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcelgrcodeFocusGained(evt);
            }
        });
        jtxtsrcelgrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtsrcelgrcodeKeyTyped(evt);
            }
        });
        getContentPane().add(jtxtsrcelgrcode);
        jtxtsrcelgrcode.setBounds(130, 210, 80, 25);

        jchkAutoReversal.setFont(new java.awt.Font("Dialog", 1, 10));
        jchkAutoReversal.setText("Auto Reversal");
        jchkAutoReversal.setNextFocusableComponent(jtblDetail);
        getContentPane().add(jchkAutoReversal);
        jchkAutoReversal.setBounds(420, 170, 140, 23);

        jcmbMOP.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbMOP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbMOPItemStateChanged(evt);
            }
        });
        jcmbMOP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcmbMOPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcmbMOPFocusLost(evt);
            }
        });
        getContentPane().add(jcmbMOP);
        jcmbMOP.setBounds(130, 170, 50, 27);

        jcmbYOP.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbYOP.setNextFocusableComponent(jtxtsrcelgrcode);
        jcmbYOP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbYOPItemStateChanged(evt);
            }
        });
        jcmbYOP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcmbYOPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcmbYOPFocusLost(evt);
            }
        });
        getContentPane().add(jcmbYOP);
        jcmbYOP.setBounds(270, 170, 100, 27);

        jtblDetail.setFont(new java.awt.Font("Dialog", 0, 10));
        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ref.", "Description", "Account", "Account Description", "Curr", "Source Debit", "Source Credit", "Date", "Source Ledger", "Source Code", "Rate Type", "Rate", "Func. Debit", "Func. Credit", "Comment", "sts", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetail.setSurrendersFocusOnKeystroke(true);
        jtblDetail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtblDetailFocusGained(evt);
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
        jtblDetail.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(2).setPreferredWidth(150);
        jtblDetail.getColumnModel().getColumn(3).setPreferredWidth(300);
        jtblDetail.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtblDetail.getColumnModel().getColumn(5).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(7).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(9).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(10).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(11).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(12).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(13).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(14).setPreferredWidth(100);
        jtblDetail.getColumnModel().getColumn(15).setMinWidth(0);
        jtblDetail.getColumnModel().getColumn(15).setPreferredWidth(0);
        jtblDetail.getColumnModel().getColumn(15).setMaxWidth(0);
        jtblDetail.getColumnModel().getColumn(16).setMinWidth(0);
        jtblDetail.getColumnModel().getColumn(16).setPreferredWidth(0);
        jtblDetail.getColumnModel().getColumn(16).setMaxWidth(0);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 280, 940, 240);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnldebit.setText("Index 1 of 100");
        getContentPane().add(jlbljrnldebit);
        jlbljrnldebit.setBounds(60, 560, 140, 13);

        jtxtjrnldebit.setEditable(false);
        jtxtjrnldebit.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtjrnldebit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtjrnldebit.setText("jrnldebit");
        getContentPane().add(jtxtjrnldebit);
        jtxtjrnldebit.setBounds(250, 560, 130, 25);

        jlbljrnlcredit.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnlcredit.setText(" Credits");
        getContentPane().add(jlbljrnlcredit);
        jlbljrnlcredit.setBounds(380, 560, 60, 13);

        jtxtjrnlcredit.setEditable(false);
        jtxtjrnlcredit.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtjrnlcredit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtjrnlcredit.setText("jrnlcredit");
        getContentPane().add(jtxtjrnlcredit);
        jtxtjrnlcredit.setBounds(440, 560, 130, 25);

        jlbljrnlcredit1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnlcredit1.setText(" Out Balance By");
        getContentPane().add(jlbljrnlcredit1);
        jlbljrnlcredit1.setBounds(570, 560, 110, 13);

        jtxtoutbalance.setEditable(false);
        jtxtoutbalance.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtoutbalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtoutbalance.setText("jrnlcredit");
        getContentPane().add(jtxtoutbalance);
        jtxtoutbalance.setBounds(680, 560, 130, 25);

        jbtnBrowseEntry.setText("...");
        jbtnBrowseEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseEntryActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowseEntry);
        jbtnBrowseEntry.setBounds(210, 110, 20, 17);

        jtbnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_newfile.gif"))); // NOI18N
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        getContentPane().add(jtbnNew);
        jtbnNew.setBounds(50, 240, 40, 30);

        jbtnMoveFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_first.gif"))); // NOI18N
        jbtnMoveFirst.setToolTipText("First Entry");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(130, 240, 40, 32);

        jbtnMovePrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_prev.gif"))); // NOI18N
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(170, 240, 40, 32);

        jbtnMoveNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_next.gif"))); // NOI18N
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMoveNext);
        jbtnMoveNext.setBounds(210, 240, 40, 32);

        jbtnMoveLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_last.gif"))); // NOI18N
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMoveLast);
        jbtnMoveLast.setBounds(250, 240, 40, 32);

        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_del.gif"))); // NOI18N
        jbtnDelete.setToolTipText("Delete Entry");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnDelete);
        jbtnDelete.setBounds(90, 240, 40, 30);

        jlbljrnldebit1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnldebit1.setText("Debits");
        getContentPane().add(jlbljrnldebit1);
        jlbljrnldebit1.setBounds(200, 560, 50, 13);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel6.setText("F5 -> Browse Data, {tbl Insert} -> Tambah Baris, {tbl Delete} -> Delete Baris");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 530, 750, 13);

        kdateentrydate.setFont(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate.setFontDate(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate.setNextFocusableComponent(jtxtsrcelgrcode);
        getContentPane().add(kdateentrydate);
        kdateentrydate.setBounds(130, 140, 100, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {
      try {
	      Gl_batchlists brs = new Gl_batchlists();
	      FrmBrowse bd = new FrmBrowse(this, brs);
	      bd.setFirstValue(jtxtbatchid);
	      bd.setModal(true);
	      bd.setVisible(true);

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
    }


    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);
}
private void kdatePurchaseDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdatePurchaseDateFocusLost

}//GEN-LAST:event_kdatePurchaseDateFocusLost

private void kdatePurchaseDateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_kdatePurchaseDateCaretPositionChanged

}//GEN-LAST:event_kdatePurchaseDateCaretPositionChanged

private void kdatePurchaseDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_kdatePurchaseDatePropertyChange

}//GEN-LAST:event_kdatePurchaseDatePropertyChange

private void jbtnBrowseSourceGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseSourceGLActionPerformed
    try {
        Gl_sourcelgrs brs = new Gl_sourcelgrs();
        FrmBrowseGl_sourcelgrsGL bd = new FrmBrowseGl_sourcelgrsGL(brs);
        bd.setFirstValue(jtxtsrcelgrcode);
        bd.setSecondValue(jtxtsrcelgrcodedesc);
        bd.setModal(true);
        bd.setVisible(true);

        Gl_sourcelgr glsrclgr=new Gl_sourcelgr();
        glsrclgr.searchData(jtxtsrcelgrcode.getText(), jtxtsrcelgrcodedesc.getText());
        jtxtsrcelgrcode.setText(glsrclgr.getsrcelgrcode()+"-"+glsrclgr.getsrcetypecode());
        jtxtsrcelgrcodedesc.setText(glsrclgr.getsrcedesc());
        gljeh.setsrcelgrcode(glsrclgr.getsrcelgrcode());
        gljeh.setsrcetypecode(glsrclgr.getsrcetypecode());

        int i=0;
        for (i=0;i<tmodeldetail.getRowCount();i++){
            tmodeldetail.setValueAt(gljeh.getsrcelgrcode(), i, 8);
            tmodeldetail.setValueAt(gljeh.getsrcetypecode(), i, 9);
        }
    } catch (CodeException e) {
        e.printStackTrace();
    }

}//GEN-LAST:event_jbtnBrowseSourceGLActionPerformed

private void jbtnBrowseEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseEntryActionPerformed
    // TODO add your handling code here:
    try {
	      FrmBrowseObject bd = new FrmBrowseObject(obj.getDetail());
	      bd.setFirstValue(jtxtbtchentry);

              //jtxtIndex.setText(jtxtEntryno.getText());

	      bd.setModal(true);
	      bd.setVisible(true);

              int index = 0;
              try{
                  index = Integer.parseInt(jtxtbtchentry.getText());
              }catch(Exception e) {}

              int i = 0;
              for (Object o : obj.getDetail().list()) {
                  Gl_jeh ch = (Gl_jeh) o;

                  Double btchentry=ch.getbtchentry();
                  if (btchentry.equals(GlobalUtils.toDbl(jtxtbtchentry.getText()))) {
                      obj.setDtlslctdindx((i));

                      gljeh = ch;

                      showDataGlJeh();

                      break;
                  }
                  i++;
              }

	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jbtnBrowseEntryActionPerformed

private void jtxtbatchidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtbatchidFocusGained

}//GEN-LAST:event_jtxtbatchidFocusGained

private void jtxtbatchdescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtbatchdescFocusGained
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtbatchdescFocusGained

private void jtxtbtchentryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtbtchentryFocusGained
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtbtchentryFocusGained

private void jtxtjrnldescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtjrnldescFocusGained
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtjrnldescFocusGained

private void jtxtsrcelgrcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcodeFocusGained
    // TODO add your handling code here:
    jtxtsrcelgrcode.selectAll();
    
}//GEN-LAST:event_jtxtsrcelgrcodeFocusGained

private void jtxtsrcelgrcodedescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcodedescFocusGained
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtsrcelgrcodedescFocusGained

private void jtxtjrnldescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtjrnldescKeyReleased
    // TODO add your handling code here:
    /*int i=0;
    for (i=0;i<tmodel.getRowCount()-1;i++){
        tmodel.setValueAt(tmodel.getValueAt(i, 0)==null?"":tmodel.getValueAt(i, 0), i,0);
        tmodel.setValueAt(tmodel.getValueAt(i, 0)==null?jtxtjrnldesc.getText():tmodel.getValueAt(i, 0), i,0);
    }*/
}//GEN-LAST:event_jtxtjrnldescKeyReleased

private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    // TODO add your handling code here:
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (evt.getKeyCode()==evt.VK_ENTER){
        evt.consume();
        if (row>-1){
            if (col<jtblDetail.getColumnCount()-1){
                GlobalUtils.selectCellTable(jtblDetail, row, col+1);
            }
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_F6 && row >= 0) {
        switch (col){
            
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col){
            case 0:
                try {
                    Cb_cash_advances brs = new Cb_cash_advances();
                    FrmBrowse bd = new FrmBrowseCb_cash_advances_open(tmodeldetail, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Cb_cash_advance cba=new Cb_cash_advance(Cb_cash_advance.PROPERTY_ADVANCE_NO,tmodeldetail.getValueAt(row, 0)+"");
                    tmodeldetail.setValueAt(cba.getacccode(), row, 2);
                    tmodeldetail.setValueAt(cba.getadvance_balance(), row, 6);

                    Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, 2)+"").replace("-", ""));
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 2);
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, 3);
                    tmodeldetail.setValueAt(glacc.getcurnccode(), row, 4);

                    if (row > -1) {
                        cekGLJed();
                    }
                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                try {
                    Gl_sourcelgrs brs = new Gl_sourcelgrs();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 8);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_sourcelgr glsrc=new Gl_sourcelgr(tmodeldetail.getValueAt(row, 8)+"");
                    tmodeldetail.setValueAt(glsrc.getsrcetypecode(), row, 9);

                    if (row > -1) {
                        cekGLJed();
                    }
                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    Gl_currencys brs = new Gl_currencys();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 4);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_currency glcry=new Gl_currency(tmodeldetail.getValueAt(row, 4)+"");
                    tmodeldetail.setValueAt(1, row,11);

                    if (row > -1) {
                        cekGLJed();
                    }

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Gl_accounts brs = new Gl_accounts();
                    FrmBrowseAccountActive bd = new FrmBrowseAccountActive(tmodeldetail, brs, row, 2);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, 2)+"").replace("-", ""));
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 2);
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, 3);
                    tmodeldetail.setValueAt(glacc.getcurnccode(), row, 4);

                    if (row > -1) {
                        cekGLJed();
                    }

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            

        }
    }
    

    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        evt.consume();
        try {
            if (row == gljeh.getDetail().size()-1) {
                tmodeldetail.addRow(datadetail);
                if (tmodeldetail.getRowCount()>1){
                    tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 0), tmodeldetail.getRowCount() - 1, 0);
                    tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 1), tmodeldetail.getRowCount() - 1, 1);
                }
                tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);
                tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);
                tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);
                //            tmodeldetail.setValueAt(kdatebtchentrydate.getDate(), tmodeldetail.getRowCount() - 1, 7);
                tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 11);
                tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 12);
                tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 13);
                tmodeldetail.setValueAt(GlobalUtils.getCurrentDate(), tmodeldetail.getRowCount() - 1, 7);

                tmodeldetail.setValueAt(gljeh.getsrcelgrcode(), tmodeldetail.getRowCount() - 1, 8);
                tmodeldetail.setValueAt(gljeh.getsrcetypecode(), tmodeldetail.getRowCount() - 1, 9);
                tmodeldetail.setValueAt(glopt.getratetype(), tmodeldetail.getRowCount() - 1, 10);

                tmodeldetail.setValueAt(1, tmodeldetail.getRowCount() - 1, 11);
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{

                System.out.println(gljeh.getDetail().size() + "=====" + row + "======");

                gljeh.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            //tmodeldetail.removeRow(row);
            tmodeldetail.setValueAt(3, row, tmodeldetail.getColumnCount()-2);

            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            }

            try{
                jtxtdebittot.setText(GlobalUtils.formatnumber(obj.getdebittot()));
                jtxtcredittot.setText(GlobalUtils.formatnumber(obj.getcredittot()));

                jtxtjrnldebit.setText(GlobalUtils.formatnumber(gljeh.getTotalDebit()));
                jtxtjrnlcredit.setText(GlobalUtils.formatnumber(gljeh.getTotalCredit()));
                jtxtoutbalance.setText(GlobalUtils.formatnumber(gljeh.getTotalDebit()-gljeh.getTotalCredit()));
     //           showDataGlJeh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }


}//GEN-LAST:event_jtblDetailKeyPressed

private void jtblDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyReleased
    // TODO add your handling code here:
    
    
}//GEN-LAST:event_jtblDetailKeyReleased

private void jtblDetailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtblDetailFocusGained
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtblDetailFocusGained

private void jtxtbtchentryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbtchentryKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode()==evt.VK_DOWN){

    }
}//GEN-LAST:event_jtxtbtchentryKeyPressed

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange
    // TODO add your handling code here:
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    try{

        if (row > -1) {
            if (jtblDetail.getValueAt(row, 4) == null) {
                jtblDetail.setValueAt("IDR", row, 4);
            }
            cekGLJed();
        }
        posttable = row;


        if(col == 2&&!onload) {
            try{
                String acccode=GlobalUtils.churuf(tmodeldetail.getValueAt(row, col));
                if (!acccode.equalsIgnoreCase("")){
                    Gl_account glacc = new Gl_account(acccode.replace("-", ""));
                    if (glacc.getID()==glacc.NULLID){
                        JOptionPane.showMessageDialog(this, "<html>Kode Akun TIDAK Ditemukan.<br>Masukkan Kode Akun atau Tekan F5</html>","Master Kode Akun",JOptionPane.WARNING_MESSAGE);

                        tmodeldetail.setValueAt("", row, col);
                        mf.setToolBar(iformtype, 7);
                        jtbnNew.setEnabled(false);
                        jbtnDelete.setEnabled(false);
                        jbtnMoveFirst.setEnabled(false);
                        jbtnMovePrevious.setEnabled(false);
                        jbtnMoveNext.setEnabled(false);
                        jbtnMoveLast.setEnabled(false);
                    } else {
                        tmodeldetail.setValueAt(glacc.getaccfmttd(), row, col);
                        tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
                        mf.setToolBar(iformtype, istatus);
                        jtbnNew.setEnabled(true);
                        jbtnDelete.setEnabled(true);
                        jbtnMoveFirst.setEnabled(true);
                        jbtnMovePrevious.setEnabled(true);
                        jbtnMoveNext.setEnabled(true);
                        jbtnMoveLast.setEnabled(true);
                    }
                }
            }catch(Exception e) {}
        }

        if (col == 5|| col==6){
            double rate=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 11)));
            double debet=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 5)));
            double credit=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 6)));
            double funcdebet=rate*debet;
            double funccredit=rate*credit;

            tmodeldetail.setValueAt(funcdebet, row, 12);
            tmodeldetail.setValueAt(funccredit, row, 13);
            

        }
        //}
    }catch (Exception e){
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblDetailPropertyChange

private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed
    try{
        if (validasibalance()){
            jbtnMoveNext.setEnabled(false);
             jbtnMoveLast.setEnabled(false);
             jbtnDelete.setEnabled(false);
             MOPChangedManually=false;
             setDataGlJeh();

            gljehtmp=gljeh;
            gljeh = new Gl_jeh();
            gljeh.setsrcelgrcode(gljehtmp.getsrcelgrcode());
            gljeh.setsrcetypecode(gljehtmp.getsrcetypecode());

            obj.setDtlslctdindx(obj.getDetail().size());

            setGlJehEnable(true);
            jlbljournalentry1.setText("Entry*");

            showDataGlJeh();

            fillMOP();
            fillYOP();
        }
    }catch (CodeException e) {}

    
}//GEN-LAST:event_jtbnNewActionPerformed

private void jbtnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveFirstActionPerformed

    int pos = 0;
    try{
        jbtnMoveNext.setEnabled(true);
         jbtnMoveLast.setEnabled(true);
         jbtnDelete.setEnabled(true);
         MOPChangedManually=true;

        pos = obj.getDtlslctdindx();
        setDataGlJeh();
        jlbljournalentry1.setText("Entry");
        
        if (pos > 0){

            obj.setDtlslctdindx(0);
            gljeh = (Gl_jeh) obj.getDetail().list().get(0);
            showDataGlJeh();
        }

        
        
    }catch(Exception e) {}

}//GEN-LAST:event_jbtnMoveFirstActionPerformed

private void jbtnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMovePreviousActionPerformed
    int pos = 0;
    try{
        jbtnMoveNext.setEnabled(true);
         jbtnMoveLast.setEnabled(true);
         jbtnDelete.setEnabled(true);
         MOPChangedManually=true;

        pos = obj.getDtlslctdindx();
        setDataGlJeh();

        jlbljournalentry1.setText("Entry");

        if (pos > 0){

            obj.setDtlslctdindx(pos-1);

            gljeh = (Gl_jeh) obj.getDetail().list().get(pos - 1);
            showDataGlJeh();
        }
    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;

        setDataGlJeh();

        jlbljournalentry1.setText("Entry");
        if (pos < obj.getDetail().list().size() - 1){

            obj.setDtlslctdindx((pos+1));

            gljeh = (Gl_jeh) obj.getDetail().list().get(pos + 1);
            showDataGlJeh();

        }
    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;

        setDataGlJeh();
        jlbljournalentry1.setText("Entry");
        
        if (pos < obj.getDetail().list().size()){

            obj.setDtlslctdindx(obj.getDetail().list().size()-1);

            gljeh = (Gl_jeh) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
            showDataGlJeh();
            

        }

        

        
    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jtxtbatchidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchidKeyPressed
    try {

        if(evt.getKeyCode() == evt.VK_ENTER) {
            searchData();
        }

    }catch (Exception e) {

    }
}//GEN-LAST:event_jtxtbatchidKeyPressed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    // TODO add your handling code here:
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtbtchentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{

            obj.removeDetail(obj.getDtlslctdindx());

            obj=new Gl_batchlist();
            showData();

        }catch(Exception e) {e.printStackTrace();}

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed

private void setyopmopval(){
    try{
        Date batchentry = dfddmmyyyy.parse(kdateentrydate.getDate());

        jcmbMOP.setSelectedIndex(batchentry.getMonth());



        for (int i = 0 ; i < jcmbYOP.getItemCount(); i++) {

            if ((1900 + batchentry.getYear() + "").equals(jcmbYOP.getItemAt(i)+"")) {
                jcmbYOP.setSelectedIndex(i);
            }

        }

    }catch(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, kdateentrydate.getDate() + " Bukan Format Tanggal ");
           kdateentrydate.requestFocus();
    }
}
private void jtxtsrcelgrcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcodeKeyTyped

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtsrcelgrcodedesc.setText("");
        try{
            
            Gl_sourcelgr gls = new Gl_sourcelgr( jtxtsrcelgrcode.getText());
            jtxtsrcelgrcodedesc.setText(gls.getsrcedesc());

        }catch(Exception e ) {}
    }
}//GEN-LAST:event_jtxtsrcelgrcodeKeyTyped

private void jcmbMOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbMOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcmbMOPFocusLost

private void jcmbYOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbYOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcmbYOPFocusLost

private void jcmbYOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbYOPItemStateChanged
    // TODO add your handling code here:
    if (!onload){
        checklockedperiode();
    }
}//GEN-LAST:event_jcmbYOPItemStateChanged

private void jcmbMOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbMOPItemStateChanged
    // TODO add your handling code here:
    if (!onload){
        checklockedperiode();
    }
}//GEN-LAST:event_jcmbMOPItemStateChanged

private void jcmbMOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbMOPFocusGained
    // TODO add your handling code here:
    mopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcmbMOP.getSelectedItem()));
}//GEN-LAST:event_jcmbMOPFocusGained

private void jcmbYOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbYOPFocusGained
    // TODO add your handling code here:
    yopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcmbYOP.getSelectedItem()));
}//GEN-LAST:event_jcmbYOPFocusGained

private void jtxtbatchidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtbatchidActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtbatchidActionPerformed

private void checklockedperiode(){
    Boolean ischanged=false;
    int yopentry=GlobalUtils.toInt(GlobalUtils.churuf(jcmbYOP.getSelectedItem()));
    if (yopentry!=yopbf){
        ischanged=true;
    }
    int mopentry=GlobalUtils.toInt(GlobalUtils.churuf(jcmbMOP.getSelectedItem()));
    if (mopentry!=mopbf){
        ischanged=true;
    }
    if (ischanged){
        try {
            Gl_fiscalh ofisc = new Gl_fiscalh(Gl_fiscalh.PROPERTY_YOP, yopentry+"");
            if (ofisc.getIsperiodelocked(mopentry)) {
                onload=true;
                onload=false;

                jtbnNew.setEnabled(false);
                jbtnDelete.setEnabled(false);
                jbtnMoveFirst.setEnabled(false);
                jbtnMovePrevious.setEnabled(false);
                jbtnMoveNext.setEnabled(false);
                jbtnMoveLast.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Invalid Procedure, Fiscal Periode Is Locked");

                mf.setToolBar(iformtype, 7);
            }  else {
                jtbnNew.setEnabled(true);
                jbtnDelete.setEnabled(true);
                jbtnMoveFirst.setEnabled(true);
                jbtnMovePrevious.setEnabled(true);
                if (jlbljournalentry1.getText().equalsIgnoreCase("docentry*")){
                jbtnMoveNext.setEnabled(true);
                jbtnMoveLast.setEnabled(true);
                }

                mf.setToolBar(iformtype, istatus);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void cekGLJed() throws CodeException {

    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    Gl_jed gljed;
    if (row > gljeds.list().size() - 1) {
        gljed = new Gl_jed();
        gljeds.add(gljed);
        System.out.println("Insert Row");
    }else{
        gljed = (Gl_jed) gljeds.list().get(row);
        System.out.println("Load Current");
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail.getValueAt(row, tmodeldetail.getColumnCount()-1)+"");
    }catch (Exception e){}

    gljed.setID(idcbhd);
    gljed.settransref(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0))); //Ref.
    gljed.settransdesc(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 1))); //Description
    gljed.setacccode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 2)).replace("-", "")); //Account
    //cbhd.set(tmodeldetail.getValueAt(row, 3))); //Account Description
    gljed.setcurnccode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 4))); //Currency
    gljed.settransamtdbt(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 5)))); //Source Debit
    gljed.settransamtcrd(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 6)))); //Source Credit
    gljed.settransdate(GlobalUtils.formatDate(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 7)),"yyyy-MM-dd")); //Date
    
    gljed.setsrcetypecode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 9))); //Source Ledger
    gljed.setsrcelgrcode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 8))); //Source Code

    gljed.setratetype(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 10))); //Rate Type
    gljed.setrate(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 11)))); //Rate
    gljed.setfuncamtdbt(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 12)))); //Func. Debit
    gljed.setfuncamtcrd(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 13)))); //Func. Credit
    gljed.setjecomment(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 14))); //Comment

    gljeds.list().set(row, gljed);

    jtxtjrnldebit.setText(GlobalUtils.formatnumber(gljeh.getTotalDebit()));
    jtxtjrnlcredit.setText(GlobalUtils.formatnumber(gljeh.getTotalCredit()));
    jtxtoutbalance.setText(GlobalUtils.formatnumber(gljeh.getTotalDebit()-gljeh.getTotalCredit()));


    double totaldebit=0;
    double totalcredit=0;
    if (GlobalUtils.toInt(jtxtbtchentry.getText())==0){
        totaldebit=gljeh.getTotalDebit();
        totalcredit=gljeh.getTotalCredit();
    }
    jtxtdebittot.setText(GlobalUtils.formatnumber(obj.getTotalDebit()));
    jtxtcredittot.setText(GlobalUtils.formatnumber(obj.getTotalKredit()));
    /*
    jtxtdebittot.setText(GlobalUtils.formatnumber(obj.getTotalDebit()+totaldebit));
    jtxtcredittot.setText(GlobalUtils.formatnumber(obj.getTotalKredit()+totalcredit));*/

}



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmGl_batchlist().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JSeparator HorizontalLine1;
    private javax.swing.JLabel jHeader;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowseEntry;
    private javax.swing.JButton jbtnBrowseSourceGL;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JCheckBox jchkAutoReversal;
    private javax.swing.JComboBox jcmbMOP;
    private javax.swing.JComboBox jcmbYOP;
    private javax.swing.JLabel jlblbatchid;
    private javax.swing.JLabel jlblbatchsts;
    private javax.swing.JLabel jlblbatchtype;
    private javax.swing.JLabel jlblbtchentry;
    private javax.swing.JLabel jlblcredittot;
    private javax.swing.JLabel jlbldebittot;
    private javax.swing.JLabel jlblentrycnt;
    private javax.swing.JLabel jlbljournalentry1;
    private javax.swing.JLabel jlbljrnlcredit;
    private javax.swing.JLabel jlbljrnlcredit1;
    private javax.swing.JLabel jlbljrnldebit;
    private javax.swing.JLabel jlbljrnldebit1;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblsrcelgrcode;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtbatchdesc;
    private javax.swing.JTextField jtxtbatchid;
    private javax.swing.JTextField jtxtbatchsts;
    private javax.swing.JTextField jtxtbatchtype;
    private javax.swing.JTextField jtxtbtchentry;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtcredittot;
    private javax.swing.JTextField jtxtdebittot;
    private javax.swing.JTextField jtxtentrycnt;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtjrnlcredit;
    private javax.swing.JTextField jtxtjrnldebit;
    private javax.swing.JTextField jtxtjrnldesc;
    private javax.swing.JTextField jtxtoutbalance;
    private javax.swing.JTextField jtxtsrcelgrcode;
    private javax.swing.JTextField jtxtsrcelgrcodedesc;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate;
    // End of variables declaration//GEN-END:variables

    public void moveFirst() throws CodeException {
        obj.moveFirst();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        MOPChangedManually=true;
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void searchData() throws CodeException {
        obj = new Gl_batchlist(this.jtxtbatchid.getText());
        showData();
        mf.setIcon(CLASSNAME);

    }
    public void newData() throws CodeException {
        objtmp=obj;
        obj = new Gl_batchlist();
        MOPChangedManually=false;

        istatus=1;
        jlbljournalentry1.setText("Entry*");
        try {
            kdateentrydate.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        fillYOP();
        fillMOP();
        jtxtbatchdesc.requestFocus();
        showData();
        setToolBar(iformtype,istatus);



    }

    private Boolean validasibalance(){
        Double debet=GlobalUtils.toDbl(jtxtjrnldebit.getText());
        Double credit=GlobalUtils.toDbl(jtxtjrnlcredit.getText());
        if (!debet.equals(credit)){
            JOptionPane.showMessageDialog(this, "Entry not balance , Modification Required");
            return false;
        } else {
            return true;
        }
    }

    public void saveData() throws CodeException {
        if (validasibalance()){
            istatus = 0;
            setData();

            System.out.println("ukuran " + obj.getDetail().size());

            setDataGlJeh();

            obj.save();
            jlbljournalentry1.setText("Entry");
            showData();

            mf.setIcon(CLASSNAME);
        }
    }

    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        
        if (obj.getbatchsts() != null) {
            if (obj.getbatchsts().equals("2")) {
                buttonEnable(false);
            } else {
                buttonEnable(true);
            }
        } else {
            buttonEnable(true);
        }
             jtxtid.setText(obj.toString(Gl_batchlist.PROPERTY_ID));
             jtxtbatchid.setText(decform.format(obj.getbatchid()));
             jtxtbatchdesc.setText(obj.toString(Gl_batchlist.PROPERTY_BTCHDESC));

             jtxtbatchsts.setText(obj.getbatchstsdesc());
             jtxtdebittot.setText(GlobalUtils.formatnumber(obj.getdebittot()));
             jtxtcredittot.setText(GlobalUtils.formatnumber(obj.getcredittot()));
             jtxtentrycnt.setText(obj.toString(Gl_batchlist.PROPERTY_ENTRYCNT));

             jtxtentrydate.setText(obj.toString(Gl_batchlist.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Gl_batchlist.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Gl_batchlist.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Gl_batchlist.PROPERTY_CMPNYID));

             jtxtbatchtype.setText(obj.getbatchtypedsc());
             

             if (obj.getDetail().list().isEmpty()) {
                jlbljournalentry1.setText("Entry*");
                 setGlJehEnable(false);
                 gljeh = new Gl_jeh();
                 obj.setDtlslctdindx(0);
             }else{
                obj.setDtlslctdindx(obj.getDetail().size()-1);
                gljeh = (Gl_jeh) obj.getDetail().list().get(obj.getDetail().size()-1);
                setGlJehEnable(true);
              }
             showDataGlJeh();



        setCursor(GlobalUtils.NORMALCURSOR);
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        showData();
        if (obj.getbatchsts().equals("2")) {
            buttonEnable(false);
        } else {
            buttonEnable(true);
        }
        mf.setIcon(CLASSNAME);
    }
    public void buttonEnable(boolean val) {
        mf.btnSave.setEnabled(val);
        mf.btnDel.setEnabled(val);
        mf.btnConfirm.setEnabled(val);
        jtbnNew.setEnabled(val);
        jbtnDelete.setEnabled(val);
    }
    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);
    }



    public void setData() throws CodeException {


          obj.fromString(Gl_batchlist.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Gl_batchlist.PROPERTY_BATCHID, jtxtbatchid.getText()) ;

          obj.fromString(Gl_batchlist.PROPERTY_BTCHDESC, jtxtbatchdesc.getText()) ;

          obj.setdebittot(GlobalUtils.toDbl(jtxtdebittot.getText())) ;
          obj.setcredittot(GlobalUtils.toDbl(jtxtcredittot.getText())) ;


          obj.fromString(Gl_batchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText()) ;
          obj.fromString(Gl_batchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText()) ;
          obj.fromString(Gl_batchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText()) ;
          obj.fromString(Gl_batchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText()) ;

    }

    public void undo() throws CodeException {
        istatus = 0;
        obj=objtmp;
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
        chooser.setDialogTitle("Import From CSV: Pilih File ");
        FileFilter filter1 = new ExtFileChooserFilter("CSV", new String[] { "CSV"});
        chooser.setFileFilter(filter1);

        setCursor(GlobalUtils.HOURGLASSCURSOR);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                file1 = selectedFile.getCanonicalPath();

            }catch (Exception e) {}

            //GlobalUtils.copyfile(file1, file2 );

            Gl_jed_temp gljedtmp=new Gl_jed_temp(Gl_jed.PROPERTY_AUDITUSER, GlobalUtils.audituser);
            if (gljedtmp.importCsv(file1)){
                if (gljedtmp.runSp_get_gl_import_journal_entry_sts()>0){
                    Gl_import_data_msg msg=new Gl_import_data_msg();
                    if (msg.getID()>0){
                        if (msg.getimportsts().equals("0")){
                            JOptionPane.showMessageDialog(this, msg.gettxtmessage() .replace(",", "\n"));
                        } else {
                            if(gljedtmp.runSp_create_gl_import_journal_entry()>0){
                                JOptionPane.showMessageDialog(this,"Import Completed");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this,"Import InCompleted, Validation Return No Message");
                    }
                }else {
                    JOptionPane.showMessageDialog(this,"Import Completed, Validation Fail");
                }
            }

        }else {
          JOptionPane.showMessageDialog(null,"No Selection ");
        }
    setCursor(GlobalUtils.NORMALCURSOR);
    }

    public void exportCsv() throws CodeException {


        if (obj.exportCsv()) {

            String file1 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".csv";
            String file2 = "";

            JFileChooser chooser = new JFileChooser(".");
            chooser.setDialogTitle("Export To Csv: Pilih Directory ");

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
        
        
        importCsv();
        
        

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


    //Untuk Batch Header

    private void setDataGlJeh() throws CodeException {

        gljeh.fromString(Gl_jeh.PROPERTY_BATCHID, jtxtbtchentry.getText());
        gljeh.fromString(Gl_jeh.PROPERTY_JRNLDESC, jtxtjrnldesc.getText());

        try{
            gljeh.fromString(Gl_jeh.PROPERTY_BTCHENTRYDATE, kdateentrydate.getDate());
        }catch (Exception e) {}
        
        
        gljeh.fromString(Gl_jeh.PROPERTY_MOP, jcmbMOP.getSelectedItem().toString()) ;
        gljeh.fromString(Gl_jeh.PROPERTY_YOP, jcmbYOP.getSelectedItem().toString()) ;
        //gljeh.fromString(Gl_jeh.PROPERTY_SRCELGRCODE, jtxtsrcelgrcode.getText()) ;

        gljeh.setjrnlcredit(GlobalUtils.toDbl(jtxtjrnlcredit.getText()));
        gljeh.setjrnldebit(GlobalUtils.toDbl(jtxtjrnldebit.getText()));

        gljeh.setswreverse(jchkAutoReversal.isSelected() ? 1 : 0);

        
        if (jlbljournalentry1.getText().equalsIgnoreCase("Entry*")){
            obj.adddetail(gljeh);
        } else {

            System.out.println("Index " + obj.getDtlslctdindx());
            
            if (obj.getDtlslctdindx() > -1) {
                obj.replaceDetail(obj.getDtlslctdindx(), gljeh);
            }
        }

    }


    private void setGlJehEnable(boolean enable) {
        jtxtbtchentry.setEnabled(enable);
        //jtxtjrnldesc.setEnabled(enable);
        //jtxtsrcelgrcode.setEnabled(enable);
    }

    public void showDataGlJeh() throws CodeException  {


        onload=true;
        if (obj.getbatchsts().equals("2")) {
            buttonEnable(false);
        } else {
            buttonEnable(true);
        }
        
        jtxtbtchentry.setText(GlobalUtils.churuf(gljeh.getbtchentry()));
        jtxtjrnldesc.setText(gljeh.getjrnldesc());

        if(gljeh.getbtchentrydate() != null) {
            try {
                kdateentrydate.setDate(gljeh.toString(gljeh.PROPERTY_BTCHENTRYDATE));
            } catch (KazaoCalendarDateTimeException ex) {
                Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        jcmbYOP.setSelectedItem(gljeh.getyop());
        jcmbMOP.setSelectedIndex((int) (gljeh.getmop() - 1));

        jchkAutoReversal.setSelected(false);
        try{
            jchkAutoReversal.setSelected(gljeh.getswreverse() == 1);
        }catch(Exception e) {}
        
        jtxtsrcelgrcode.setText(gljeh.getsrcelgrcode()+"-"+gljeh.getsrcetypecode());
        Gl_sourcelgr glbr = new Gl_sourcelgr();
        glbr.searchData(gljeh.getsrcelgrcode(), gljeh.getsrcetypecode());
        jtxtsrcelgrcodedesc.setText(glbr.getsrcedesc());

        gljeds = gljeh.getDetail();

        jtxtjrnldebit.setText(GlobalUtils.formatnumber(gljeh.getjrnldebit()));
        jtxtjrnlcredit.setText(GlobalUtils.formatnumber(gljeh.getjrnlcredit()));
        jtxtoutbalance.setText(GlobalUtils.formatnumber(gljeh.getjrnldebit()-gljeh.getjrnlcredit()));

        if (jlbljournalentry1.getText().equalsIgnoreCase("Entry*")){
            jlbljrnldebit.setText("Index * of "+obj.getDetail().size());
        } else {
            jlbljrnldebit.setText("Index "+(obj.getDtlslctdindx()+1)+" of "+obj.getDetail().size());
        }
        try{
            showDataGlhd();
        }catch(Exception e){}

        onload=false;
    }




    //Untuk Batch Detail
    public void showDataGlhd() throws CodeException  {

        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        if (tmodeldetail.getRowCount()>1){
            tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 0), tmodeldetail.getRowCount() - 1, 0);
            tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 1), tmodeldetail.getRowCount() - 1, 1);
        }
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);
        //            tmodeldetail.setValueAt(kdatebtchentrydate.getDate(), tmodeldetail.getRowCount() - 1, 7);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 11);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 12);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 13);
        tmodeldetail.setValueAt(GlobalUtils.getCurrentDate(), tmodeldetail.getRowCount() - 1, 7);

        tmodeldetail.setValueAt(gljeh.getsrcelgrcode(), tmodeldetail.getRowCount() - 1, 8);
        tmodeldetail.setValueAt(gljeh.getsrcetypecode(), tmodeldetail.getRowCount() - 1, 9);
        tmodeldetail.setValueAt(glopt.getratetype(), tmodeldetail.getRowCount() - 1, 10);
        tmodeldetail.setValueAt(1, tmodeldetail.getRowCount() - 1, 11);
        GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);

        posttable = -1;



        for(Object  o : gljeds.list()){
            Gl_jed cbhd = (Gl_jed) o;


            tmodeldetail.setValueAt(cbhd.getID(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
            tmodeldetail.setValueAt(cbhd.gettransref(), tmodeldetail.getRowCount() - 1, 1);
            tmodeldetail.setValueAt(cbhd.gettransdesc(), tmodeldetail.getRowCount() - 1, 2);
            tmodeldetail.setValueAt(cbhd.getacccode(), tmodeldetail.getRowCount() - 1, 3);

            tmodeldetail.setValueAt(cbhd.gettransref(),tmodeldetail.getRowCount()-1, 0); //Ref.
            tmodeldetail.setValueAt(cbhd.gettransdesc(),tmodeldetail.getRowCount()-1, 1); //Description

            tmodeldetail.setValueAt(Gl_account.getAccFormat( cbhd.getacccode()),tmodeldetail.getRowCount()-1, 2); //Account
            //cbhd.set(tmodeldetail.getValueAt(row, 3)+""); //Account Description
            tmodeldetail.setValueAt(cbhd.getcurnccode(),tmodeldetail.getRowCount()-1, 4); //Currency
            tmodeldetail.setValueAt(cbhd.gettransamtdbt(),tmodeldetail.getRowCount()-1, 5); //Source Debit
            tmodeldetail.setValueAt(cbhd.gettransamtcrd(),tmodeldetail.getRowCount()-1, 6); //Source Credit
            tmodeldetail.setValueAt(GlobalUtils.formatDate(cbhd.gettransdate(),"MM/dd/yyyy"),tmodeldetail.getRowCount()-1, 7); //Date
            tmodeldetail.setValueAt(cbhd.getsrcetypecode(),tmodeldetail.getRowCount()-1, 8); //Source Ledger
            tmodeldetail.setValueAt(cbhd.getsrcelgrcode(),tmodeldetail.getRowCount()-1, 9); //Source Code
            tmodeldetail.setValueAt(cbhd.getratetype(),tmodeldetail.getRowCount()-1, 10); //Rate Type
            //cbhd.set(tmodeldetail.getValueAt(row, 11)+""); //Rate
            //cbhd.set(tmodeldetail.getValueAt(row, 12)+""); //Func. Debit
            //cbhd.settransref(tmodeldetail.getValueAt(row, 13)+""); //Func. Credit
            tmodeldetail.setValueAt(cbhd.getjecomment(),tmodeldetail.getRowCount()-1, 14); //Comment

            Gl_account glacc = new Gl_account(cbhd.getacccode());
            tmodeldetail.setValueAt(glacc.getaccdesc(), tmodeldetail.getRowCount() - 1, 3);


            tmodeldetail.addRow(datadetail);
            if (tmodeldetail.getRowCount()>1){
                tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 0), tmodeldetail.getRowCount() - 1, 0);
                tmodeldetail.setValueAt(tmodeldetail.getValueAt(0, 1), tmodeldetail.getRowCount() - 1, 1);
            }
            tmodeldetail.setValueAt(cbhd.getStatus(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 2);
            tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);
            //            tmodeldetail.setValueAt(kdatebtchentrydate.getDate(), tmodeldetail.getRowCount() - 1, 7);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 11);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 12);
            tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 13);
            tmodeldetail.setValueAt(GlobalUtils.getCurrentDate(), tmodeldetail.getRowCount() - 1, 7);

            tmodeldetail.setValueAt(gljeh.getsrcelgrcode(), tmodeldetail.getRowCount() - 1, 8);
            tmodeldetail.setValueAt(gljeh.getsrcetypecode(), tmodeldetail.getRowCount() - 1, 9);
            tmodeldetail.setValueAt(glopt.getratetype(), tmodeldetail.getRowCount() - 1, 10);
            tmodeldetail.setValueAt(1, tmodeldetail.getRowCount() - 1, 11);
            GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);
        }


    }


    
}
