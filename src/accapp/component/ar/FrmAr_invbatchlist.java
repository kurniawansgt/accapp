/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import test.FrmAr_invbatchlist;
 * 
 * .......
 * 
 * 
 * FrmAr_invbatchlist frmAr_invbatchlist;
 * 
 * .......
 * 
 try {
        if (frmAr_invbatchlist == null) {
            frmmAr_invbatchlist = new FrmAr_invbatchlist(this);
        }
        
        showForm(frmAr_invbatchlist);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.ar;

import accapp.component.browse.FrmBrowseARCustomer;
import accapp.component.browse.FrmBrowseAr_invoblByCustomer;
import accapp.objectclasses.ar.Ar_customer;
import accapp.objectclasses.ar.Ar_customers;
import accapp.objectclasses.ar.Ar_distcode;
import accapp.objectclasses.ar.Ar_distcodes;
import common.component.FrmBrowse;
import common.classinterface.NavigatorFormInt;
import common.classinterface.NavigatorObjectInt;
import common.component.FrmMainFrame;

import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import common.utils.ExtFileChooserFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import accapp.objectclasses.ar.Ar_invbatchlist;
import accapp.objectclasses.ar.Ar_invbatchlists;
import accapp.objectclasses.ar.Ar_invd;
import accapp.objectclasses.ar.Ar_invds;
import accapp.objectclasses.ar.Ar_invh;
import accapp.objectclasses.ar.Ar_invobls;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_currencys;
import accapp.objectclasses.gl.Gl_fiscalh;
import accapp.objectclasses.op.Op_addresss;
import accapp.objectclasses.op.Op_paymentterm;
import accapp.objectclasses.op.Op_paymentterms;
import accapp.objectclasses.op.Op_taxs;
import accapp.objectclasses.ap.H_material_receive;
import accapp.objectclasses.ap.H_material_receives;
import common.component.frmCalculator;
import common.tablemodels.GlobalModel;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.kazao.calendar.KazaoCalendar;
import org.kazao.calendar.KazaoCalendarAdapter;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author  Generator
 */

public class FrmAr_invbatchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmAr_invbatchlist";
    
    FrmMainFrame mf ;

    Boolean MOPChangedManually=false;
    
    public Ar_invbatchlist obj = new Ar_invbatchlist();
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");

    DecimalFormat decform = new DecimalFormat("##0");

    Ar_invh arinvhh = new Ar_invh();
    Ar_invds arinvhds = new Ar_invds();


    Object[] datadetail;
    DefaultTableModel tmodeldetail;



    int posttable = 0;
    long mopbf=0;
    long yopbf=0;


    boolean onload = false;

    
   
    /** Creates new form Area */
    public FrmAr_invbatchlist() throws CodeException {
        initComponents();
    }
    
    public FrmAr_invbatchlist(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();

        fillMOP();
        fillYOP();

        kdateentrydate.addChangeListener(new KazaoCalendarAdapter() {
        public void onChange(Calendar calendar) {
        }
        public void onChange(KazaoCalendar calendar) {
            if (!MOPChangedManually){
                jcbMOP.setSelectedItem(GlobalUtils.formatmonth((long)GlobalUtils.getMonth(kdateentrydate.getDate())));
                jcbYOP.setSelectedItem((long)GlobalUtils.getYear(kdateentrydate.getDate()));
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
        HorizontalLine = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jtxtid = new javax.swing.JTextField();
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlblreadytpost = new javax.swing.JLabel();
        jlblbatchtype = new javax.swing.JLabel();
        jtxtbatchtype = new javax.swing.JTextField();
        jlblbatchsts = new javax.swing.JLabel();
        jtxtbatchsts = new javax.swing.JTextField();
        jchckReadyToPost = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jlbldocentry = new javax.swing.JLabel();
        jlblcustmrcode = new javax.swing.JLabel();
        jtxtdocentry = new javax.swing.JTextField();
        jtxtcustmrcode = new javax.swing.JTextField();
        jlbladdrcode = new javax.swing.JLabel();
        jtxtaddrcode = new javax.swing.JTextField();
        jlbldocdate = new javax.swing.JLabel();
        jlbldscription = new javax.swing.JLabel();
        jtxtdscription = new javax.swing.JTextField();
        jlbltaxcode = new javax.swing.JLabel();
        jtxttaxcode = new javax.swing.JTextField();
        jlblyop = new javax.swing.JLabel();
        jlblmop = new javax.swing.JLabel();
        jlblorderno = new javax.swing.JLabel();
        jlblcustmrpono = new javax.swing.JLabel();
        jlbltermcode = new javax.swing.JLabel();
        jtxttermcode = new javax.swing.JTextField();
        jlbldocduedate = new javax.swing.JLabel();
        jlbldiscdate = new javax.swing.JLabel();
        jlbldiscprcnt = new javax.swing.JLabel();
        jlbldiscvalueamt = new javax.swing.JLabel();
        jlbldocnum = new javax.swing.JLabel();
        jtxtdocnum = new javax.swing.JTextField();
        jlbldocnumapplto = new javax.swing.JLabel();
        jtxtdocnumapplto = new javax.swing.JTextField();
        jlblcurnccode = new javax.swing.JLabel();
        jtxtcurnccode = new javax.swing.JTextField();
        jlblrate = new javax.swing.JLabel();
        jtxtrate = new javax.swing.JTextField();
        jtxtorderno = new javax.swing.JTextField();
        jtxtcustmrpono = new javax.swing.JTextField();
        jtxtdiscprcnt = new javax.swing.JTextField();
        jtxtdiscvalueamt = new javax.swing.JTextField();
        jbtnBrowse1 = new javax.swing.JButton();
        jtxttermdesc = new javax.swing.JTextField();
        jbtnBrowse2 = new javax.swing.JButton();
        jtxtcustmrdesc = new javax.swing.JTextField();
        jbtnBrowse3 = new javax.swing.JButton();
        jbtnBrowse4 = new javax.swing.JButton();
        jtbnBrowseCustomer = new javax.swing.JButton();
        jcbMOP = new javax.swing.JComboBox();
        jcbYOP = new javax.swing.JComboBox();
        kdateentrydate = new org.kazao.calendar.KazaoCalendarDate();
        jlbljrnldebit = new javax.swing.JLabel();
        kdocduedate = new org.kazao.calendar.KazaoCalendarDate();
        kdiscdate = new org.kazao.calendar.KazaoCalendarDate();
        jtbnNew = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jcmbdoctype = new javax.swing.JComboBox();
        jbtnBrowse6 = new javax.swing.JButton();
        jbtnBrowse7 = new javax.swing.JButton();
        jtxtTermDueDays = new javax.swing.JTextField();
        jlbldoctype1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtxtcustmrcode1 = new javax.swing.JTextField();
        jlblcustmrcode1 = new javax.swing.JLabel();
        jtxtcustmrdesc1 = new javax.swing.JTextField();
        jlbldocnum1 = new javax.swing.JLabel();
        jtxtdocnum1 = new javax.swing.JTextField();
        jlblcurnccode1 = new javax.swing.JLabel();
        jtxtcurnccode1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new selectallJTable(tmodeldetail);
        jbtnBrowse = new javax.swing.JButton();
        jlblbatchno = new javax.swing.JLabel();
        jtxtbatchno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jlbltotinvamt = new javax.swing.JLabel();
        jtxttotinvamt = new javax.swing.JTextField();
        jlblinventrcnt = new javax.swing.JLabel();
        jtxtinventrcnt = new javax.swing.JTextField();
        jlblbatchdate = new javax.swing.JLabel();
        kbatchdate = new org.kazao.calendar.KazaoCalendarDate();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtxtbatchdesc = new javax.swing.JTextField();
        jlblbatchdesc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modul AR");
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
        jHeader.setText(" : : AR Invoice Entry");
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
        jtxtid.setBounds(410, 30, 80, 19);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(490, 30, 80, 19);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(570, 30, 80, 19);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(650, 30, 80, 19);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(730, 30, 80, 19);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jlblreadytpost.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblreadytpost.setText("Ready To Post");
        jPanel1.add(jlblreadytpost);
        jlblreadytpost.setBounds(30, 50, 140, 14);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchtype.setText("Type");
        jPanel1.add(jlblbatchtype);
        jlblbatchtype.setBounds(280, 90, 140, 14);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchtype.setText("batchtype");
        jPanel1.add(jtxtbatchtype);
        jtxtbatchtype.setBounds(440, 90, 80, 20);

        jlblbatchsts.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchsts.setText("Status");
        jPanel1.add(jlblbatchsts);
        jlblbatchsts.setBounds(30, 90, 140, 14);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchsts.setText("batchsts");
        jPanel1.add(jtxtbatchsts);
        jtxtbatchsts.setBounds(190, 90, 80, 20);

        jchckReadyToPost.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jchckReadyToPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jchckReadyToPostKeyPressed(evt);
            }
        });
        jPanel1.add(jchckReadyToPost);
        jchckReadyToPost.setBounds(190, 50, 21, 21);

        jTabbedPane1.addTab("Batch", jPanel1);

        jPanel2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jPanel2.setLayout(null);

        jlbldocentry.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocentry.setText("Doc Entry");
        jPanel2.add(jlbldocentry);
        jlbldocentry.setBounds(10, 20, 100, 14);

        jlblcustmrcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrcode.setText("Customer No");
        jPanel2.add(jlblcustmrcode);
        jlblcustmrcode.setBounds(10, 50, 140, 14);

        jtxtdocentry.setEditable(false);
        jtxtdocentry.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocentry.setText("docentry");
        jPanel2.add(jtxtdocentry);
        jtxtdocentry.setBounds(110, 20, 80, 20);

        jtxtcustmrcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrcode.setText("custmrcode");
        jtxtcustmrcode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtcustmrcodePropertyChange(evt);
            }
        });
        jtxtcustmrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcustmrcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtcustmrcode);
        jtxtcustmrcode.setBounds(110, 50, 80, 20);

        jlbladdrcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbladdrcode.setText("Shipt To");
        jPanel2.add(jlbladdrcode);
        jlbladdrcode.setBounds(10, 70, 140, 14);

        jtxtaddrcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtaddrcode.setText("addrcode");
        jtxtaddrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtaddrcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtaddrcode);
        jtxtaddrcode.setBounds(110, 70, 80, 20);

        jlbldocdate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocdate.setText("Doc. Date");
        jPanel2.add(jlbldocdate);
        jlbldocdate.setBounds(10, 170, 100, 14);

        jlbldscription.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldscription.setText("Description");
        jPanel2.add(jlbldscription);
        jlbldscription.setBounds(10, 210, 100, 14);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdscription.setText("dscription");
        jtxtdscription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtdscriptionFocusGained(evt);
            }
        });
        jtxtdscription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdscriptionKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtdscription);
        jtxtdscription.setBounds(110, 210, 310, 20);

        jlbltaxcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltaxcode.setText("Tax Group");
        jPanel2.add(jlbltaxcode);
        jlbltaxcode.setBounds(10, 230, 140, 14);

        jtxttaxcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttaxcode.setText("taxcode");
        jtxttaxcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttaxcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxttaxcode);
        jtxttaxcode.setBounds(110, 230, 80, 20);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblyop.setText("Year");
        jPanel2.add(jlblyop);
        jlblyop.setBounds(220, 170, 70, 14);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblmop.setText("Periode");
        jPanel2.add(jlblmop);
        jlblmop.setBounds(340, 170, 70, 14);

        jlblorderno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblorderno.setText("Order No.");
        jPanel2.add(jlblorderno);
        jlblorderno.setBounds(490, 210, 80, 14);

        jlblcustmrpono.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrpono.setText("PO No.");
        jPanel2.add(jlblcustmrpono);
        jlblcustmrpono.setBounds(490, 190, 80, 14);

        jlbltermcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltermcode.setText("Term");
        jPanel2.add(jlbltermcode);
        jlbltermcode.setBounds(10, 250, 70, 14);

        jtxttermcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttermcode.setText("termcode");
        jtxttermcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxttermcodeFocusLost(evt);
            }
        });
        jtxttermcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttermcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxttermcode);
        jtxttermcode.setBounds(110, 250, 80, 20);

        jlbldocduedate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocduedate.setText("Due Date");
        jPanel2.add(jlbldocduedate);
        jlbldocduedate.setBounds(10, 270, 70, 14);

        jlbldiscdate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldiscdate.setText("Disc. Date");
        jPanel2.add(jlbldiscdate);
        jlbldiscdate.setBounds(210, 270, 90, 14);

        jlbldiscprcnt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldiscprcnt.setText("Disc. Percent");
        jPanel2.add(jlbldiscprcnt);
        jlbldiscprcnt.setBounds(10, 290, 90, 14);

        jlbldiscvalueamt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldiscvalueamt.setText("Disc. Ammount");
        jPanel2.add(jlbldiscvalueamt);
        jlbldiscvalueamt.setBounds(200, 290, 100, 14);

        jlbldocnum.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum.setText("Document");
        jPanel2.add(jlbldocnum);
        jlbldocnum.setBounds(10, 140, 100, 14);

        jtxtdocnum.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum.setText("docnum");
        jtxtdocnum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtdocnumFocusGained(evt);
            }
        });
        jtxtdocnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocnumKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtdocnum);
        jtxtdocnum.setBounds(110, 140, 250, 20);

        jlbldocnumapplto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnumapplto.setText("Doc. Apply To");
        jPanel2.add(jlbldocnumapplto);
        jlbldocnumapplto.setBounds(490, 140, 100, 14);

        jtxtdocnumapplto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnumapplto.setText("docnumapplto");
        jtxtdocnumapplto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocnumappltoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtdocnumapplto);
        jtxtdocnumapplto.setBounds(630, 140, 130, 20);

        jlblcurnccode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcurnccode.setText("Curency Code");
        jPanel2.add(jlblcurnccode);
        jlblcurnccode.setBounds(490, 120, 110, 14);

        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcurnccode.setText("curnccode");
        jtxtcurnccode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcurnccodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(630, 120, 130, 20);

        jlblrate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblrate.setText("Rate");
        jPanel2.add(jlblrate);
        jlblrate.setBounds(490, 170, 80, 14);

        jtxtrate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtrate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtrate.setText("rate");
        jtxtrate.setNextFocusableComponent(jtxtcustmrpono);
        jtxtrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtrateKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtrate);
        jtxtrate.setBounds(630, 170, 130, 20);

        jtxtorderno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtorderno.setText("orderno");
        jtxtorderno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtordernoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtorderno);
        jtxtorderno.setBounds(630, 210, 130, 20);

        jtxtcustmrpono.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrpono.setText("custmrpono");
        jtxtcustmrpono.setNextFocusableComponent(jtxtorderno);
        jtxtcustmrpono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcustmrponoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtcustmrpono);
        jtxtcustmrpono.setBounds(630, 190, 130, 20);

        jtxtdiscprcnt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdiscprcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdiscprcnt.setText("discprcnt");
        jtxtdiscprcnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdiscprcntKeyReleased(evt);
            }
        });
        jPanel2.add(jtxtdiscprcnt);
        jtxtdiscprcnt.setBounds(110, 290, 80, 20);

        jtxtdiscvalueamt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdiscvalueamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdiscvalueamt.setText("discvalueamt");
        jtxtdiscvalueamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdiscvalueamtKeyReleased(evt);
            }
        });
        jPanel2.add(jtxtdiscvalueamt);
        jtxtdiscvalueamt.setBounds(300, 290, 80, 20);

        jbtnBrowse1.setText("...");
        jbtnBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse1);
        jbtnBrowse1.setBounds(190, 20, 30, 17);

        jtxttermdesc.setEditable(false);
        jtxttermdesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttermdesc.setText("jtxttermdesc");
        jPanel2.add(jtxttermdesc);
        jtxttermdesc.setBounds(230, 250, 300, 20);

        jbtnBrowse2.setText("...");
        jbtnBrowse2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse2ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse2);
        jbtnBrowse2.setBounds(190, 250, 30, 17);

        jtxtcustmrdesc.setEditable(false);
        jtxtcustmrdesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrdesc.setText("custmtdesc");
        jtxtcustmrdesc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtcustmrdescPropertyChange(evt);
            }
        });
        jPanel2.add(jtxtcustmrdesc);
        jtxtcustmrdesc.setBounds(230, 50, 410, 20);

        jbtnBrowse3.setText("...");
        jbtnBrowse3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse3ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse3);
        jbtnBrowse3.setBounds(600, 140, 30, 17);

        jbtnBrowse4.setText("...");
        jbtnBrowse4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse4ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse4);
        jbtnBrowse4.setBounds(190, 230, 30, 17);

        jtbnBrowseCustomer.setText("...");
        jtbnBrowseCustomer.setNextFocusableComponent(jbtnBrowse6);
        jtbnBrowseCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnBrowseCustomerActionPerformed(evt);
            }
        });
        jPanel2.add(jtbnBrowseCustomer);
        jtbnBrowseCustomer.setBounds(190, 50, 30, 17);

        jcbMOP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcbMOP.setNextFocusableComponent(jtxtdscription);
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
        jPanel2.add(jcbMOP);
        jcbMOP.setBounds(400, 170, 50, 20);

        jcbYOP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
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
        jPanel2.add(jcbYOP);
        jcbYOP.setBounds(260, 170, 60, 20);

        kdateentrydate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdateentrydate.setFontDate(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdateentrydate.setFormat("dd/mm/yyyy");
        kdateentrydate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdateentrydateKeyPressed(evt);
            }
        });
        jPanel2.add(kdateentrydate);
        kdateentrydate.setBounds(110, 170, 100, 20);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbljrnldebit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbljrnldebit.setText("Index 1 of 100");
        jPanel2.add(jlbljrnldebit);
        jlbljrnldebit.setBounds(620, 20, 140, 14);

        kdocduedate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdocduedate.setFontDate(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdocduedate.setFormat("dd/mm/yyyy");
        kdocduedate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdocduedateKeyPressed(evt);
            }
        });
        jPanel2.add(kdocduedate);
        kdocduedate.setBounds(110, 270, 100, 20);

        kdiscdate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdiscdate.setFontDate(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdiscdate.setFormat("dd/mm/yyyy");
        kdiscdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdiscdateKeyPressed(evt);
            }
        });
        jPanel2.add(kdiscdate);
        kdiscdate.setBounds(300, 270, 100, 20);

        jtbnNew.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtbnNew.setText("New");
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jPanel2.add(jtbnNew);
        jtbnNew.setBounds(230, 20, 60, 20);

        jbtnMoveFirst.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveFirst.setText("|<");
        jbtnMoveFirst.setToolTipText("First Entry");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(340, 20, 50, 20);

        jbtnMovePrevious.setText("<");
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(390, 20, 50, 20);

        jbtnMoveNext.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveNext.setText(">");
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(440, 20, 50, 20);

        jbtnMoveLast.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveLast.setText(">|");
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMoveLast);
        jbtnMoveLast.setBounds(490, 20, 50, 20);

        jbtnDelete.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnDelete.setText("X");
        jbtnDelete.setToolTipText("Delete Entry");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnDelete);
        jbtnDelete.setBounds(290, 20, 50, 20);

        jcmbdoctype.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcmbdoctype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Credit Note", "Debit Note", "Interest Invoice" }));
        jcmbdoctype.setNextFocusableComponent(jtxtdocnum);
        jcmbdoctype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbdoctypeItemStateChanged(evt);
            }
        });
        jcmbdoctype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbdoctypeKeyPressed(evt);
            }
        });
        jPanel2.add(jcmbdoctype);
        jcmbdoctype.setBounds(110, 110, 160, 20);

        jbtnBrowse6.setText("...");
        jbtnBrowse6.setNextFocusableComponent(jcmbdoctype);
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse6);
        jbtnBrowse6.setBounds(190, 70, 30, 17);

        jbtnBrowse7.setText("...");
        jbtnBrowse7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse7ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse7);
        jbtnBrowse7.setBounds(600, 120, 30, 17);

        jtxtTermDueDays.setEditable(false);
        jtxtTermDueDays.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtTermDueDays.setText("jtxtTermDueDays");
        jPanel2.add(jtxtTermDueDays);
        jtxtTermDueDays.setBounds(540, 250, 86, 20);

        jlbldoctype1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldoctype1.setText("Doc. Type");
        jPanel2.add(jlbldoctype1);
        jlbldoctype1.setBounds(10, 110, 100, 14);

        jTabbedPane1.addTab("Invoice", jPanel2);

        jPanel3.setLayout(null);

        jtxtcustmrcode1.setEditable(false);
        jtxtcustmrcode1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrcode1.setText("custmrcode");
        jPanel3.add(jtxtcustmrcode1);
        jtxtcustmrcode1.setBounds(110, 10, 80, 20);

        jlblcustmrcode1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrcode1.setText("Customer");
        jPanel3.add(jlblcustmrcode1);
        jlblcustmrcode1.setBounds(10, 10, 140, 14);

        jtxtcustmrdesc1.setEditable(false);
        jtxtcustmrdesc1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrdesc1.setText("jTextField1");
        jPanel3.add(jtxtcustmrdesc1);
        jtxtcustmrdesc1.setBounds(190, 10, 420, 20);

        jlbldocnum1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum1.setText("Document");
        jPanel3.add(jlbldocnum1);
        jlbldocnum1.setBounds(10, 40, 100, 14);

        jtxtdocnum1.setEditable(false);
        jtxtdocnum1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum1.setText("docnum");
        jPanel3.add(jtxtdocnum1);
        jtxtdocnum1.setBounds(110, 40, 180, 20);

        jlblcurnccode1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcurnccode1.setText("Currency");
        jPanel3.add(jlblcurnccode1);
        jlblcurnccode1.setBounds(310, 40, 100, 14);

        jtxtcurnccode1.setEditable(false);
        jtxtcurnccode1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcurnccode1.setText("curnccode");
        jPanel3.add(jtxtcurnccode1);
        jtxtcurnccode1.setBounds(410, 40, 80, 20);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("Acc../Tax..");
        jPanel3.add(jButton1);
        jButton1.setBounds(500, 40, 110, 20);

        jtblDetail.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Dist. Code", "Revenue Account", "Description", "Amount", "Comment", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, false
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
        jtblDetail.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblDetailPropertyChange(evt);
            }
        });
        jtblDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblDetailKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblDetail);
        if (jtblDetail.getColumnModel().getColumnCount() > 0) {
            jtblDetail.getColumnModel().getColumn(1).setMinWidth(150);
            jtblDetail.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(1).setMaxWidth(150);
            jtblDetail.getColumnModel().getColumn(2).setMinWidth(250);
            jtblDetail.getColumnModel().getColumn(2).setPreferredWidth(250);
            jtblDetail.getColumnModel().getColumn(2).setMaxWidth(250);
            jtblDetail.getColumnModel().getColumn(4).setMinWidth(170);
            jtblDetail.getColumnModel().getColumn(4).setPreferredWidth(170);
            jtblDetail.getColumnModel().getColumn(4).setMaxWidth(170);
            jtblDetail.getColumnModel().getColumn(5).setMinWidth(0);
            jtblDetail.getColumnModel().getColumn(5).setPreferredWidth(0);
            jtblDetail.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 750, 220);

        jTabbedPane1.addTab("Detail", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(60, 130, 780, 350);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(240, 60, 30, 17);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchno.setText("Batch Number");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(60, 60, 140, 14);

        jtxtbatchno.setEditable(false);
        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchno.setText("batchno");
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(160, 60, 80, 20);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(null);

        jlbltotinvamt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltotinvamt.setText("Batch Amount");
        jPanel4.add(jlbltotinvamt);
        jlbltotinvamt.setBounds(10, 10, 140, 14);

        jtxttotinvamt.setEditable(false);
        jtxttotinvamt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttotinvamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxttotinvamt.setText("totinvamt");
        jPanel4.add(jtxttotinvamt);
        jtxttotinvamt.setBounds(200, 10, 110, 20);

        jlblinventrcnt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblinventrcnt.setText("Total Entries");
        jPanel4.add(jlblinventrcnt);
        jlblinventrcnt.setBounds(10, 30, 140, 14);

        jtxtinventrcnt.setEditable(false);
        jtxtinventrcnt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtinventrcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtinventrcnt.setText("inventrcnt");
        jPanel4.add(jtxtinventrcnt);
        jtxtinventrcnt.setBounds(200, 30, 110, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(480, 60, 320, 60);

        jlblbatchdate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchdate.setText("Batch Date");
        getContentPane().add(jlblbatchdate);
        jlblbatchdate.setBounds(60, 80, 140, 14);

        kbatchdate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kbatchdate.setFontDate(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        getContentPane().add(kbatchdate);
        kbatchdate.setBounds(160, 80, 100, 20);

        jButton2.setText("Prepay...");
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 490, 130, 23);

        jButton3.setText("Total...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 490, 110, 23);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchdesc.setText("batchdesc");
        jtxtbatchdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchdescKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(160, 100, 310, 20);

        jlblbatchdesc.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchdesc.setText("Description");
        getContentPane().add(jlblbatchdesc);
        jlblbatchdesc.setBounds(60, 100, 140, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
         try {
            moveLast();

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

private void jbtnBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse1ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowse1ActionPerformed

private void jbtnBrowse2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse2ActionPerformed
    // TODO add your handling code here:
    try {
        Op_paymentterms brs = new Op_paymentterms();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxttermcode);
        bd.setSecondValue(jtxttermdesc);
        bd.setThirdValue(jtxtTermDueDays);

        bd.setModal(true);
        bd.setVisible(true);

        changeDueDate();


    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse2ActionPerformed
private void changeDueDate() {
        try{
            Calendar c1 = Calendar.getInstance();
            c1.setTime(dateformat.parse(kdateentrydate.getDate()));

            System.out.println("1 " + c1.getTime());
            c1.add(Calendar.DATE, Integer.parseInt(jtxtTermDueDays.getText()));

            kdocduedate.setDate(c1.getTime());
            System.out.println("2 " + c1.getTime());
            
        }catch(Exception e) {}

}
private void jbtnBrowse3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse3ActionPerformed
    // TODO add your handling code here:
    try {
        if (jcmbdoctype.getSelectedIndex()==1||jcmbdoctype.getSelectedIndex()==2){
            Ar_invobls brs = new Ar_invobls();
            FrmBrowseAr_invoblByCustomer bd = new FrmBrowseAr_invoblByCustomer(brs);
            bd.custmrcode = jtxtcustmrcode.getText();
            bd.retrieveData();
            bd.setFirstValue(jtxtdocnumapplto);
            bd.setModal(true);
            bd.setVisible(true);
            
        } else{
            Op_addresss brs = new Op_addresss();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setFirstValue(jtxtaddrcode);
            bd.setModal(true);
            bd.setVisible(true);

        }
    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse3ActionPerformed

private void jbtnBrowse4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse4ActionPerformed
    // TODO add your handling code here:
    try {
        Op_taxs brs = new Op_taxs();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxttaxcode);
        bd.setModal(true);
        bd.setVisible(true);


    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse4ActionPerformed

private void findCustomer() throws CodeException {
        Ar_customer arcust=new Ar_customer(jtxtcustmrcode.getText());
        jtxtcustmrcode.setText(arcust.getcustmrcode());
        jtxtcustmrdesc.setText(arcust.getcustmrname());

        jtxtcustmrcode1.setText(jtxtcustmrcode.getText());
        jtxtcustmrdesc1.setText(jtxtcustmrdesc.getText());

        
        jtxtcurnccode1.setText(arcust.getcurnccode());
        jtxtcurnccode.setText(arcust.getcurnccode());
        jtxttaxcode.setText(arcust.gettaxcode());
        jtxttermcode.setText(arcust.gettermcode());

        /* Set due date */
        Op_paymentterm oterm=new Op_paymentterm(jtxttermcode.getText());
        jtxttermdesc.setText(oterm.getdscription());
        String s = String.valueOf(oterm.getduedays());
        jtxtTermDueDays.setText(s);
}
private void jtbnBrowseCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnBrowseCustomerActionPerformed
    try {
        Ar_customers brs = new Ar_customers();
        FrmBrowseARCustomer bd = new FrmBrowseARCustomer(brs);
        bd.setFirstValue(jtxtcustmrcode);
        bd.setSecondValue(jtxtcustmrdesc);
        bd.setModal(true);
        bd.setVisible(true);

        findCustomer();
        
    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jtbnBrowseCustomerActionPerformed

private void insertnewline(){
    tmodeldetail.addRow(datadetail);
    tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
    tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);
    GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);
}
private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (evt.getKeyCode() == KeyEvent.VK_ENTER && row >= 0) {
        evt.consume();
        if (col<jtblDetail.getColumnCount()-2){
            GlobalUtils.selectCellTable(jtblDetail, row, col+1);
        } else {
            if (GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3)))!=0){
                insertnewline();
            }
        }
    }

    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col){
            case 0:
                try {
                    Ar_distcodes brs = new Ar_distcodes();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Ar_distcode glacc = new Ar_distcode(tmodeldetail.getValueAt(row, 0)+"");
                    tmodeldetail.setValueAt(glacc.getaccrevcodefmt(), row, 1);
                    tmodeldetail.setValueAt(glacc.getdscription(), row, 2);
                    cekArInvhd();

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    Gl_accounts brs = new Gl_accounts();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 1);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, 1)+"").replace("-", ""));
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 1);
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, 2);

                    cekArInvhd();
                } catch (CodeException e) {
                    e.printStackTrace();
                }

                break;


        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_F12 || evt.getKeyCode() == 107){
        if (col == 3) {
            frmCalculator frmcal = new frmCalculator(tmodeldetail, row, col);
            frmcal.setModal(true);
            frmcal.setVisible(true);
        }
    }


    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        insertnewline();

    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{

                System.out.println(arinvhh.getDetail().size() + "=====" + row + "======");

                arinvhh.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail.removeRow(row);

            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            }

            try{
                jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.gettotinvamt()));
                jtxtinventrcnt.setText(GlobalUtils.formatnumber(obj.getinventrcnt()));
                showDataARInvhh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }
}//GEN-LAST:event_jtblDetailKeyPressed
private void setDataARInvhh() throws CodeException {

    arinvhh.fromString(Ar_invh.PROPERTY_DOCENTRY,jtxtdocentry.getText());
    arinvhh.fromString(Ar_invh.PROPERTY_CUSTMRCODE,jtxtcustmrcode.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_ADDRCODE,jtxtaddrcode.getText());

    int doctype=0;
    switch (jcmbdoctype.getSelectedIndex()){
        case 0:
            doctype=4;
            break;
        case 1:
            doctype=5;
            break;
        case 2:
            doctype=6;
            break;
        case 3:
            doctype=7;
            break;
    }

    arinvhh.fromString(Ar_invh.PROPERTY_DOCENTRY,jtxtdocentry.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_DOCTYPE,GlobalUtils.churuf(doctype));

    arinvhh.fromString(Ar_invh.PROPERTY_DOCNUM,jtxtdocnum.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_DSCRIPTION,jtxtdscription.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_DOCDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd"));
    arinvhh.fromString(Ar_invh.PROPERTY_DOCDUEDATE, GlobalUtils.formatDate(kdocduedate.getDate(),"yyyy-MM-dd"));
    arinvhh.fromString(Ar_invh.PROPERTY_DISCDATE, GlobalUtils.formatDate(kdiscdate.getDate(),"yyyy-MM-dd"));

    arinvhh.fromString(Ar_invh.PROPERTY_MOP, jcbMOP.getSelectedItem().toString()) ;
    arinvhh.fromString(Ar_invh.PROPERTY_YOP, jcbYOP.getSelectedItem().toString()) ;

    arinvhh.fromString(Ar_invh.PROPERTY_TAXCODE,jtxttaxcode.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_DISCPRCNT,jtxtdiscprcnt.getText());
    arinvhh.fromString(Ar_invh.PROPERTY_DISCVALUEAMT,jtxtdiscvalueamt.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_TERMCODE,jtxttermcode.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_CURNCCODE,jtxtcurnccode.getText());
    arinvhh.fromString(Ar_invh.PROPERTY_RATE,jtxtrate.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_DOCNUMAPPLTO,jtxtdocnumapplto.getText());
//    cbhh.fromString(Ar_invh.PROPERTY_SPECINSTR,jtxtspecinstr.getText());

    arinvhh.fromString(Ar_invh.PROPERTY_CUSTMRPONO,jtxtcustmrpono.getText());
    arinvhh.fromString(Ar_invh.PROPERTY_ORDERNO,jtxtorderno.getText());    

    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*") || obj.getDtlslctdindx() < 0){
        obj.adddetail(arinvhh);
    } else {
        obj.replaceDetail(obj.getDtlslctdindx(), arinvhh);
    }

}

private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed
    try{
        //if (validasibalance()){
            //if(!obj.getDetail().list().isEmpty()) {
            jbtnMoveNext.setEnabled(false);
            jbtnMoveLast.setEnabled(false);
            jbtnDelete.setEnabled(false);

            setDataARInvhh();
            //}

            arinvhh = new Ar_invh();
            try {
                kdateentrydate.setDate(GlobalUtils.sessiondate);
                kdiscdate.setDate(GlobalUtils.sessiondate);
                kdocduedate.setDate(GlobalUtils.sessiondate);
            } catch (KazaoCalendarDateTimeException ex) {
                Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
            }

            jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
            
            obj.setDtlslctdindx(obj.getDetail().size());


            setCArInvhEnable(true);
            jlbldocentry.setText("Doc Entry*");


            showDataARInvhh();
        //}
    }catch (CodeException e) {}

}//GEN-LAST:event_jtbnNewActionPerformed

private void jbtnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveFirstActionPerformed

    int pos = 0;
    try{
        jbtnMoveNext.setEnabled(true);
         jbtnMoveLast.setEnabled(true);
         jbtnDelete.setEnabled(true);
        pos = obj.getDtlslctdindx();
        setDataARInvhh();
        jlbldocentry.setText("Doc Entry");
        if (pos > 0){

            obj.setDtlslctdindx(0);
            arinvhh = (Ar_invh) obj.getDetail().list().get(0);
            showDataARInvhh();
        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveFirstActionPerformed

private void jbtnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMovePreviousActionPerformed
    int pos = 0;
    try{
        jbtnMoveNext.setEnabled(true);
         jbtnMoveLast.setEnabled(true);
         jbtnDelete.setEnabled(true);
        pos = obj.getDtlslctdindx();
        setDataARInvhh();

        jlbldocentry.setText("Doc Entry");

        if (pos > 0){

            obj.setDtlslctdindx(pos-1);

            arinvhh = (Ar_invh) obj.getDetail().list().get(pos - 1);
            showDataARInvhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        setDataARInvhh();

        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size() - 1){

            obj.setDtlslctdindx((pos+1));

            arinvhh = (Ar_invh) obj.getDetail().list().get(pos + 1);
            showDataARInvhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        setDataARInvhh();
        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size()){

            obj.setDtlslctdindx(obj.getDetail().list().size()-1);

            arinvhh = (Ar_invh) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
            showDataARInvhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    // TODO add your handling code here:
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtdocentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{

            obj.removeDetail(obj.getDtlslctdindx());
            obj.save();

            obj=new Ar_invbatchlist(obj.getID());
            showData();

        }catch(Exception e) {e.printStackTrace();}

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed

private void jtxtcustmrcodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtcustmrcodePropertyChange
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtcustmrcodePropertyChange

private void jtxtcustmrdescPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtcustmrdescPropertyChange
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtcustmrdescPropertyChange

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    try{
        //if(posttable != row) {

        if (row > -1) {
            cekArInvhd();
        }
        posttable = row;


        if(col == 1) {
            try{
                Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, col)+"").replace("-", ""));
                tmodeldetail.setValueAt(glacc.getaccfmttd(), row, col);
                tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
            }catch(Exception e) {}
        }

        if (col == 3){
            double amount=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3)));

            arinvhh.setdoctotalamt(arinvhh.getDetailAmt());

            caldiscount(arinvhh.getdoctotalamt());

        }
        //}
    }catch (Exception e){
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblDetailPropertyChange

private void caldiscount(Double invamount){
    double discprcnt=GlobalUtils.toDbl(jtxtdiscprcnt.getText());
    double discamt=GlobalUtils.toDbl(jtxtdiscvalueamt.getText());

    if (discamt>0){
        discprcnt=(discamt/invamount)*100;
    } else {
        discamt=invamount*discprcnt;
    }

    jtxtdiscprcnt.setText(GlobalUtils.formatnumber(discprcnt));
    jtxtdiscvalueamt.setText(GlobalUtils.formatnumber(discamt));
}
private void jcmbdoctypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbdoctypeItemStateChanged
    // TODO add your handling code here:
    //Invoice,Credit Note,Debit Note,Interest Invoice
    /*int doctype=0;
    switch (jcmbdoctype.getSelectedIndex()){
        case 0:
            doctype=4;
            break;
        case 1:
            doctype=5;
            break;
        case 2:
            doctype=6;
            break;
        case 3:
            doctype=7;
            break;
    }
        try {
            Ar_optiionaldetail1 arop = new Ar_optiionaldetail1(doctype);
            int i=0;
            String docnum="";
            for(i=0;i<arop.getlengthno();i++){
                if (i<arop.gettxtprefix().length()){
                    docnum=arop.gettxtprefix();
                } else {
                    if (i<arop.getlengthno()-GlobalUtils.churuf(arop.getdocnum()).length()){
                        docnum=docnum+"0";
                    } else {
                        docnum=docnum+(arop.getdocnum()+1);
                    }
                }
            }

            jtxtdocnum.setText(docnum);
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    visiblefield();
}//GEN-LAST:event_jcmbdoctypeItemStateChanged

private void visiblefield(){
    switch (jcmbdoctype.getSelectedIndex()){
        case 0:
            jlbldocnumapplto.setVisible(false);
            jbtnBrowse3.setVisible(false);
            jtxtdocnumapplto.setVisible(false);
            break;
        case 1:
            jlbldocnumapplto.setVisible(true);
            jbtnBrowse3.setVisible(true);
            jtxtdocnumapplto.setVisible(true);
            break;
        case 2:
            jlbldocnumapplto.setVisible(true);
            jbtnBrowse3.setVisible(true);
            jtxtdocnumapplto.setVisible(true);
            break;
        case 3:
            jlbldocnumapplto.setVisible(false);
            jbtnBrowse3.setVisible(false);
            jtxtdocnumapplto.setVisible(false);
            break;
    }
}
private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
    // TODO add your handling code here:        
        try {
            FrmAr_invpopaddress bd = new FrmAr_invpopaddress(arinvhh);
            bd.setModal(true);
            bd.setVisible(true);
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtnBrowse6ActionPerformed

private void jbtnBrowse7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse7ActionPerformed
    // TODO add your handling code here:
    try {
        Gl_currencys brs = new Gl_currencys();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtcurnccode);
        bd.setModal(true);
        bd.setVisible(true);

    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse7ActionPerformed

private void jtxtdiscprcntKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdiscprcntKeyReleased
        try {
            caldiscount(arinvhh.getdoctotalamt());
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtxtdiscvalueamt.requestFocus();


}//GEN-LAST:event_jtxtdiscprcntKeyReleased

private void jtxtdiscvalueamtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdiscvalueamtKeyReleased
        try {
            // TODO add your handling code here:
            caldiscount(arinvhh.getdoctotalamt());
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtxtcurnccode.requestFocus();
}//GEN-LAST:event_jtxtdiscvalueamtKeyReleased

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            arinvhh.setcustmrcode(jtxtcustmrcode.getText());

            int doctype=0;
            switch (jcmbdoctype.getSelectedIndex()){
                case 0:
                    doctype=4;
                    break;
                case 1:
                    doctype=5;
                    break;
                case 2:
                    doctype=6;
                    break;
                case 3:
                    doctype=7;
                    break;
            }
            arinvhh.setdoctype(GlobalUtils.churuf(doctype));
            arinvhh.setcurnccode(jtxtcurnccode.getText());
            arinvhh.settaxcode(jtxttaxcode.getText());
            arinvhh.settermcode(jtxttermcode.getText());
            FrmAr_invpopdoctotal poptotal=new FrmAr_invpopdoctotal(arinvhh);
            poptotal.setModal(true);
            poptotal.setVisible(true);

            jtxttaxcode.setText(arinvhh.gettaxcode());

            double DetailAmt=0;
            if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
                DetailAmt=arinvhh.getDetailAmt();

            }
            jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount()+(DetailAmt+arinvhh.gettaxtotalamt())));
            jtxtinventrcnt.setText(GlobalUtils.formatnumber(obj.getinventrcnt()));
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_jButton3ActionPerformed

private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    // TODO add your handling code here:
    jtxtdocnum1.setText(jtxtdocnum.getText());
    jtxtcurnccode1.setText(jtxtcurnccode.getText());
    jtxtcustmrcode1.setText(jtxtcustmrcode1.getText());
    jtxtcustmrdesc1.setText(jtxtcustmrdesc.getText());
}//GEN-LAST:event_jTabbedPane1MouseClicked

private void jtxtbatchdescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchdescKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        jchckReadyToPost.requestFocus();
    }
    
}//GEN-LAST:event_jtxtbatchdescKeyPressed

private void jchckReadyToPostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jchckReadyToPostKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtbnNew.requestFocus();
    }
    
}//GEN-LAST:event_jchckReadyToPostKeyPressed

private void jtxtcustmrcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcustmrcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        try{
            findCustomer();
        }catch(Exception e){}
        
        jtxtaddrcode.requestFocus();
    }
}//GEN-LAST:event_jtxtcustmrcodeKeyPressed

private void jtxtaddrcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtaddrcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbdoctype.requestFocus();
    }
}//GEN-LAST:event_jtxtaddrcodeKeyPressed

private void jcmbdoctypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbdoctypeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdocnum.requestFocus();
    }
}//GEN-LAST:event_jcmbdoctypeKeyPressed

private void jtxtdocnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        kdateentrydate.requestFocus();
    }
    
}//GEN-LAST:event_jtxtdocnumKeyPressed

private void kdateentrydateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdateentrydateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcbYOP.requestFocus();
    }
    
}//GEN-LAST:event_kdateentrydateKeyPressed

private void jcbYOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbYOPKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcbMOP.requestFocus();
    }
}//GEN-LAST:event_jcbYOPKeyPressed

private void jcbMOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMOPKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdscription.requestFocus();
    }
    
}//GEN-LAST:event_jcbMOPKeyPressed

private void jtxtdscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdscriptionKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxttaxcode.requestFocus();
    }
}//GEN-LAST:event_jtxtdscriptionKeyPressed

private void jtxttaxcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttaxcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxttermcode.requestFocus();
    }
}//GEN-LAST:event_jtxttaxcodeKeyPressed

private void jtxttermcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttermcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        try{
            Op_paymentterm op = new Op_paymentterm(jtxttermcode.getText());

            jtxttermdesc.setText(op.getdscription());

        }catch(Exception e){}
        kdocduedate.requestFocus();
        changeDueDate();
    }
}//GEN-LAST:event_jtxttermcodeKeyPressed

private void kdocduedateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdocduedateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        kdiscdate.requestFocus();
    }
}//GEN-LAST:event_kdocduedateKeyPressed

private void kdiscdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdiscdateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdiscprcnt.requestFocus();
    }
}//GEN-LAST:event_kdiscdateKeyPressed

private void jtxtcurnccodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcurnccodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdocnumapplto.requestFocus();
    }
}//GEN-LAST:event_jtxtcurnccodeKeyPressed

private void jtxtdocnumappltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumappltoKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtrate.requestFocus();
    }
    
}//GEN-LAST:event_jtxtdocnumappltoKeyPressed

private void jtxtrateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtrateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtcustmrpono.requestFocus();
    }
    
}//GEN-LAST:event_jtxtrateKeyPressed

private void jtxtcustmrponoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcustmrponoKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtorderno.requestFocus();
    }
    
}//GEN-LAST:event_jtxtcustmrponoKeyPressed

private void jtxtordernoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtordernoKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtblDetail.requestFocus();
    }

}//GEN-LAST:event_jtxtordernoKeyPressed

private void jcbMOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcbMOPFocusLost

private void jcbYOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually=true;
}//GEN-LAST:event_jcbYOPFocusLost

private void jcbYOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYOPItemStateChanged
    // TODO add your handling code here:
        if (!onload){
            checklockedperiode();
        }

}//GEN-LAST:event_jcbYOPItemStateChanged

private void jcbMOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMOPItemStateChanged
    // TODO add your handling code here:
        if (!onload){
            checklockedperiode();
        }
}//GEN-LAST:event_jcbMOPItemStateChanged

private void jcbMOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusGained
    // TODO add your handling code here:
     mopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
}//GEN-LAST:event_jcbMOPFocusGained

private void jcbYOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusGained
    // TODO add your handling code here:
    yopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
}//GEN-LAST:event_jcbYOPFocusGained

private void jtxtdocnumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtdocnumFocusGained
    // TODO add your handling code here:
    jtxtdocnum.selectAll();
}//GEN-LAST:event_jtxtdocnumFocusGained

private void jtxtdscriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtdscriptionFocusGained
    // TODO add your handling code here:
    jtxtdscription.selectAll();
}//GEN-LAST:event_jtxtdscriptionFocusGained

private void jtxttermcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxttermcodeFocusLost
    // TODO add your handling code here:
    changeDueDate();
}//GEN-LAST:event_jtxttermcodeFocusLost

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
                onload=true;
                onload=false;

                jtbnNew.setEnabled(false);
                jbtnDelete.setEnabled(false);
                jbtnMoveFirst.setEnabled(false);
                jbtnMovePrevious.setEnabled(true);
                jbtnMoveNext.setEnabled(true);
                jbtnMoveLast.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Invalid Procedure, Fiscal Periode Is Locked");

                mf.setToolBar(iformtype, 7);
            }  else {
                jtbnNew.setEnabled(true);
                jbtnDelete.setEnabled(true);
                jbtnMoveFirst.setEnabled(true);
                jbtnMovePrevious.setEnabled(true);
                if (jlbldocentry.getText().equalsIgnoreCase("docentry*")){
                jbtnMoveNext.setEnabled(true);
                jbtnMoveLast.setEnabled(true);
                }

                mf.setToolBar(iformtype, istatus);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void cekArInvhd() throws CodeException {

    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    Ar_invd cbhd;
    if (row > arinvhds.list().size() - 1) {
        cbhd = new Ar_invd();
        arinvhds.add(cbhd);
    }else{
        cbhd = (Ar_invd) arinvhds.list().get(row);
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail.getValueAt(row, tmodeldetail.getColumnCount()-1)+"");
    }catch (Exception e){}

    cbhd.setID(idcbhd);
    cbhd.setdistcode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0)));
    cbhd.setaccrevcode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 1)));
    cbhd.setdetailamt(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3))));
    cbhd.setaccrevdscription(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 4)));

    arinvhds.list().set(row, cbhd);

    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=arinvhh.getDetailAmt();

    }
    jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount()+DetailAmt));
    jtxtinventrcnt.setText(GlobalUtils.formatnumber(obj.getinventrcnt()));
}

public void showDataARInvhh() throws CodeException  {

        onload=true;
        jtxtdocentry.setText(GlobalUtils.churuf(arinvhh.getdocentry()));
        jtxtcustmrcode.setText(arinvhh.getcustmrcode());

        jtxtcustmrcode1.setText(arinvhh.getcustmrcode());

        Ar_customer arcust=new Ar_customer(arinvhh.getcustmrcode());
        jtxtcustmrdesc.setText(arcust.getcustmrname());

        jtxtcustmrdesc1.setText(arcust.getcustmrname());

        jtxtaddrcode.setText(arinvhh.getaddrcode());
        jtxtdocnum.setText(arinvhh.getdocnum());

        jtxtdocnum1.setText(arinvhh.getdocnum());

        jtxtdscription.setText(arinvhh.getdscription());
        try {
            kdateentrydate.setDate(GlobalUtils.formatDate(arinvhh.getdocdate(),"MM/dd/yyyy"));
            kdocduedate.setDate(GlobalUtils.formatDate(arinvhh.getdocduedate(),"MM/dd/yyyy"));
            kdiscdate.setDate(GlobalUtils.formatDate(arinvhh.getdiscdate(),"MM/dd/yyyy"));
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        mopbf=arinvhh.getmop();
        yopbf=arinvhh.getyop();
        String mop="";
        if (arinvhh.getmop()<10){
            mop="0"+arinvhh.getmop();
        } else {
            mop=arinvhh.getmop()+"";
        }
        jcbMOP.setSelectedItem(mop);
        jcbYOP.setSelectedItem(arinvhh.getyop());

        jtxttaxcode.setText(arinvhh.gettaxcode());

        jtxtdiscprcnt.setText(GlobalUtils.formatnumber(arinvhh.getdiscprcnt()));
        jtxtdiscvalueamt.setText(GlobalUtils.formatnumber(arinvhh.getdiscvalueamt()));

        jtxttermcode.setText(arinvhh.gettermcode());
        Op_paymentterm opterm=new Op_paymentterm(arinvhh.gettermcode());
        jtxttermdesc.setText(opterm.getdscription());
        jtxtTermDueDays.setText(opterm.getduedays()+"");

        jtxtcurnccode.setText(arinvhh.getcurnccode());

        jtxtcurnccode1.setText(arinvhh.getcurnccode());

        if (arinvhh.getdoctype()==null){
            jcmbdoctype.setSelectedIndex(0);
        } else {
            switch (GlobalUtils.toInt(arinvhh.getdoctype())){
            case 4:
                jcmbdoctype.setSelectedIndex(0);
                break;
            case 5:
                jcmbdoctype.setSelectedIndex(1);
                break;
            case 6:
                jcmbdoctype.setSelectedIndex(2);
                break;
            case 7:
                jcmbdoctype.setSelectedIndex(3);
                break;
            }
        }


        jtxtrate.setText(GlobalUtils.formatnumber(arinvhh.getrate()));

        jtxtdocnumapplto.setText(arinvhh.getdocnumapplto());
//        jtxtspecinstr.setText(cbhh.getspecinstr());

        jtxtcustmrpono.setText(arinvhh.getcustmrpono());
        jtxtorderno.setText(arinvhh.getorderno());

        visiblefield();

        arinvhds = arinvhh.getDetail();

        if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
            jlbljrnldebit.setText("Index * of "+obj.getDetail().size());
        } else {
            jlbljrnldebit.setText("Index "+(obj.getDtlslctdindx()+1)+" of "+obj.getDetail().size());
        }

        try{
            showDataCbhd();
        }catch(Exception e){}

        onload=false;
    }

public void showDataCbhd() throws CodeException  {

        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;



        for(Object  o : arinvhds.list()){
            Ar_invd cbhd = (Ar_invd) o;


            tmodeldetail.setValueAt(cbhd.getID(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

            tmodeldetail.setValueAt(cbhd.getdistcode(), tmodeldetail.getRowCount() - 1, 0);
            tmodeldetail.setValueAt(cbhd.getaccrevcodefmt(), tmodeldetail.getRowCount() - 1, 1);
            tmodeldetail.setValueAt(cbhd.getaccrevcodedscription(), tmodeldetail.getRowCount() - 1, 2);


            tmodeldetail.setValueAt(cbhd.getdetailamt(), tmodeldetail.getRowCount() - 1, 3);
            tmodeldetail.setValueAt(cbhd.getaccrevdscription(), tmodeldetail.getRowCount() - 1, 4);

            tmodeldetail.addRow(datadetail);
        }


    }

private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
    mf.setIcon(CLASSNAME);
    setToolBar(iformtype,istatus);
}                                           

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
	      Ar_invbatchlists brs = new Ar_invbatchlists();
	      FrmBrowse bd = new FrmBrowse(this, brs);
	      bd.setFirstValue(jtxtbatchno);
	      bd.setModal(true);
	      bd.setVisible(true);            
	      
	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}                                                                                 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAr_invbatchlist().setVisible(true);
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
    private javax.swing.JLabel jHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowse1;
    private javax.swing.JButton jbtnBrowse2;
    private javax.swing.JButton jbtnBrowse3;
    private javax.swing.JButton jbtnBrowse4;
    private javax.swing.JButton jbtnBrowse6;
    private javax.swing.JButton jbtnBrowse7;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JComboBox jcbMOP;
    private javax.swing.JComboBox jcbYOP;
    private javax.swing.JCheckBox jchckReadyToPost;
    private javax.swing.JComboBox jcmbdoctype;
    private javax.swing.JLabel jlbladdrcode;
    private javax.swing.JLabel jlblbatchdate;
    private javax.swing.JLabel jlblbatchdesc;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JLabel jlblbatchsts;
    private javax.swing.JLabel jlblbatchtype;
    private javax.swing.JLabel jlblcurnccode;
    private javax.swing.JLabel jlblcurnccode1;
    private javax.swing.JLabel jlblcustmrcode;
    private javax.swing.JLabel jlblcustmrcode1;
    private javax.swing.JLabel jlblcustmrpono;
    private javax.swing.JLabel jlbldiscdate;
    private javax.swing.JLabel jlbldiscprcnt;
    private javax.swing.JLabel jlbldiscvalueamt;
    private javax.swing.JLabel jlbldocdate;
    private javax.swing.JLabel jlbldocduedate;
    private javax.swing.JLabel jlbldocentry;
    private javax.swing.JLabel jlbldocnum;
    private javax.swing.JLabel jlbldocnum1;
    private javax.swing.JLabel jlbldocnumapplto;
    private javax.swing.JLabel jlbldoctype1;
    private javax.swing.JLabel jlbldscription;
    private javax.swing.JLabel jlblinventrcnt;
    private javax.swing.JLabel jlbljrnldebit;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblorderno;
    private javax.swing.JLabel jlblrate;
    private javax.swing.JLabel jlblreadytpost;
    private javax.swing.JLabel jlbltaxcode;
    private javax.swing.JLabel jlbltermcode;
    private javax.swing.JLabel jlbltotinvamt;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JButton jtbnBrowseCustomer;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtTermDueDays;
    private javax.swing.JTextField jtxtaddrcode;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtbatchdesc;
    private javax.swing.JTextField jtxtbatchno;
    private javax.swing.JTextField jtxtbatchsts;
    private javax.swing.JTextField jtxtbatchtype;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtcurnccode;
    private javax.swing.JTextField jtxtcurnccode1;
    private javax.swing.JTextField jtxtcustmrcode;
    private javax.swing.JTextField jtxtcustmrcode1;
    private javax.swing.JTextField jtxtcustmrdesc;
    private javax.swing.JTextField jtxtcustmrdesc1;
    private javax.swing.JTextField jtxtcustmrpono;
    private javax.swing.JTextField jtxtdiscprcnt;
    private javax.swing.JTextField jtxtdiscvalueamt;
    private javax.swing.JTextField jtxtdocentry;
    private javax.swing.JTextField jtxtdocnum;
    private javax.swing.JTextField jtxtdocnum1;
    private javax.swing.JTextField jtxtdocnumapplto;
    private javax.swing.JTextField jtxtdscription;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtinventrcnt;
    private javax.swing.JTextField jtxtorderno;
    private javax.swing.JTextField jtxtrate;
    private javax.swing.JTextField jtxttaxcode;
    private javax.swing.JTextField jtxttermcode;
    private javax.swing.JTextField jtxttermdesc;
    private javax.swing.JTextField jtxttotinvamt;
    private org.kazao.calendar.KazaoCalendarDate kbatchdate;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate;
    private org.kazao.calendar.KazaoCalendarDate kdiscdate;
    private org.kazao.calendar.KazaoCalendarDate kdocduedate;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        obj.moveFirst();
        showData();
    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        showData();
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        showData();
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        showData();
    }

    public void searchData() throws CodeException {
        obj = new Ar_invbatchlist(this.jtxtbatchno.getText());
        showData();

    }
    public void newData() throws CodeException {
        obj = new Ar_invbatchlist();
        obj.setreadytpost("0");
        MOPChangedManually=false;
        istatus=1;
        jlbldocentry.setText("Doc Entry*");
        showData();
        try {
                kbatchdate.setDate(GlobalUtils.sessiondate);
                kdateentrydate.setDate(GlobalUtils.sessiondate);
                kdiscdate.setDate(GlobalUtils.sessiondate);
                kdocduedate.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
        
        setToolBar(iformtype,istatus);
    }

    public void saveData() throws CodeException {
        istatus = 0;
        setData();

        setDataARInvhh();

        obj.save();
        jlbldocentry.setText("Doc Entry");
        showData();
        
    }

    public void setar_invbatchlist(Ar_invbatchlist obj){
        this.obj=obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	System.out.println(obj.getbatchno());

        jtxtid.setText(obj.toString(Ar_invbatchlist.PROPERTY_ID));
        jtxtbatchno.setText(obj.toString(Ar_invbatchlist.PROPERTY_BATCHNO));
        try {
            kbatchdate.setDate(GlobalUtils.formatDate(obj.toString(Ar_invbatchlist.PROPERTY_BATCHDATE), "MM/dd/yyyy"));
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             jtxtbatchdesc.setText(obj.toString(Ar_invbatchlist.PROPERTY_BATCHDESC));

             if (GlobalUtils.churuf(obj.getreadytpost()).equalsIgnoreCase("1")){
                 jchckReadyToPost.setSelected(true);
             } else {
                 jchckReadyToPost.setSelected(false);
             }
             

             String batchtype="";
             switch (GlobalUtils.toInt(GlobalUtils.churuf(obj.getbatchtype()))){
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
             jtxtbatchtype.setText(batchtype);

             String batchsts="";
             switch (GlobalUtils.toInt(GlobalUtils.churuf(obj.getbatchsts()))){
                 case 1:
                     batchsts="Open";
                     break;
                 case 2:
                     batchsts="Error";
                     break;
                 case 3:
                     batchsts="Posted";
                     break;
                 case 4:
                     batchsts="Deleted";
                     break;
             }
             jtxtbatchsts.setText(batchsts);
             jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.gettotinvamt()));
             jtxtinventrcnt.setText(obj.toString(Ar_invbatchlist.PROPERTY_INVENTRCNT));
             jtxtentrydate.setText(obj.toString(Ar_invbatchlist.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Ar_invbatchlist.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Ar_invbatchlist.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Ar_invbatchlist.PROPERTY_CMPNYID));

             if (obj.getDetail().list().isEmpty()) {
                 obj.setDtlslctdindx(-1);
                 setCArInvhEnable(false);
                 arinvhh = new Ar_invh();
             }else{
                if (obj.getDetail().size()==1){
                    obj.setDtlslctdindx(0);
                }
                if (obj.getDtlslctdindx()<obj.getDetail().size()-1){
                    arinvhh = (Ar_invh) obj.getDetail().list().get(obj.getDtlslctdindx());
                    setCArInvhEnable(true);
                 } else{
                    obj.setDtlslctdindx(obj.getDetail().size()-1);
                    arinvhh = (Ar_invh) obj.getDetail().list().get(obj.getDetail().size()-1);
                    setCArInvhEnable(true);
                 }
              }
             showDataARInvhh();
        mf.setIcon(CLASSNAME);
        setToolBar(iformtype, istatus);
        setCursor(GlobalUtils.NORMALCURSOR);
    }

    private void setCArInvhEnable(boolean enable) {
        jtxtdocentry.setEnabled(enable);
        //jtxtjrnldesc.setEnabled(enable);
        //jtxtsrcelgrcode.setEnabled(enable);
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        showData();
    }

    public void setToolBar(int iFormType, int istatus) {
        try {
            if (obj.getbatchsts().equals("2")||obj.getbatchsts().equals("4")) {
                mf.setToolBar(iformtype, 7);

                unlockbutton(false);
                jbtnMoveNext.setEnabled(true);
                jbtnMovePrevious.setEnabled(true);
                jbtnMoveFirst.setEnabled(true);
                jbtnMoveLast.setEnabled(true);
            } else {
                mf.setToolBar(iformtype, istatus);
                unlockbutton(true);

            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void unlockbutton(Boolean lock){
        jtbnNew.setEnabled(lock);
        jbtnDelete.setEnabled(lock);
        jbtnMoveFirst.setEnabled(lock);
        jbtnMovePrevious.setEnabled(lock);
        jbtnMoveNext.setEnabled(lock);
        jbtnMoveLast.setEnabled(lock);

        if (jlbldocentry.getText().equalsIgnoreCase("doc entry*")){
            jbtnMoveNext.setEnabled(true);
            jbtnMoveLast.setEnabled(false);
        }
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Ar_invbatchlist.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(kbatchdate.getDate(),"yyyy-MM-dd")) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_BATCHDESC, jtxtbatchdesc.getText()) ;

          if (jchckReadyToPost.isSelected()){
            obj.setreadytpost("1");
          } else {
            obj.setreadytpost("0");  
          }
          if (obj.getID()==0){
              obj.setbatchtype("1");
          }

          obj.settotinvamt(GlobalUtils.toDbl(jtxttotinvamt.getText())) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_INVENTRCNT, jtxtinventrcnt.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText()) ;
          obj.fromString(Ar_invbatchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText()) ;

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

    
}
