/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.ap.adjustment.FrmAp_adjbatchlist;
 * 
 * .......
 * 
 * 
 * FrmAp_adjbatchlist frmAp_adjbatchlist;
 * 
 * .......
 * 
 try {
        if (frmAp_adjbatchlist == null) {
            frmmAp_adjbatchlist = new FrmAp_adjbatchlist(this);
        }
        
        showForm(frmAp_adjbatchlist);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.ap.adjustment;

import accapp.component.ap.FrmAp_invbatchlist;
import accapp.component.ar.adjustment.FrmAr_adjbatchlist;
import accapp.component.browse.FrmBrowseAp_invoblAdjustmentByVendor;
import accapp.objectclasses.ap.Ap_distcode;
import accapp.objectclasses.ap.Ap_distcodes;
import accapp.objectclasses.ap.Ap_invobl;
import accapp.objectclasses.ap.Ap_invobls;
import accapp.objectclasses.ap.Ap_vendor;
import accapp.objectclasses.ap.Ap_vendors;
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
import accapp.objectclasses.ap.adjustment.Ap_adjbatchlist;
import accapp.objectclasses.ap.adjustment.Ap_adjbatchlists;
import accapp.objectclasses.ap.adjustment.Ap_adjd;
import accapp.objectclasses.ap.adjustment.Ap_adjds;
import accapp.objectclasses.ap.adjustment.Ap_adjh;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_fiscalh;
import common.component.frmCalculator;
import common.tablemodels.GlobalModel;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
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

public class FrmAp_adjbatchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="Frmapadjustmententry";
    
    FrmMainFrame mf ;
    
    public Ap_adjbatchlist obj = new Ap_adjbatchlist();

    Ap_adjh adjh = new Ap_adjh();
    Ap_adjds apadjds = new Ap_adjds();

    Object[] datadetail;
    DefaultTableModel tmodeldetail;
    Boolean MOPChangedManually=false;

    long mopbf=0;
    long yopbf=0;
    Boolean onload=false;
    /** Creates new form Area */
    public FrmAp_adjbatchlist() throws CodeException {
        initComponents();
    }
    
    public FrmAp_adjbatchlist(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();

        fillMOP();
        fillYOP();


        kdateentrydate1.addChangeListener(new KazaoCalendarAdapter() {
        public void onChange(Calendar calendar) {
        }
        public void onChange(KazaoCalendar calendar) {
             if (!MOPChangedManually){
                jcbMOP.setSelectedItem(GlobalUtils.formatmonth((long)GlobalUtils.getMonth(kdateentrydate1.getDate())));
                jcbYOP.setSelectedItem(GlobalUtils.getYear(kdateentrydate1.getDate()));
            }
        }
        public void onDoubleClick() {
        }
        });

        datadetail = new Object[jtblAdjustment.getRowCount()];
        tmodeldetail = (DefaultTableModel) jtblAdjustment.getModel();
        jtxtbatchsts.setVisible(false);
        jtxtbatchtype.setVisible(false);

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
    public void setap_adjbatchlist(Ap_adjbatchlist obj){
        this.obj=obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillYOP(){
        jcbYOP.removeAllItems();

        int currentYear=GlobalUtils.CNomorInt(GlobalUtils.getCurrentYear());
        int i=0;
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
        jbtnBrowse = new javax.swing.JButton();
        jtxtid = new javax.swing.JTextField();
        jlblbatchno = new javax.swing.JLabel();
        jtxtbatchno = new javax.swing.JTextField();
        jlblbatchdate = new javax.swing.JLabel();
        jlblbatchdesc = new javax.swing.JLabel();
        jtxtbatchdesc = new javax.swing.JTextField();
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        kdatebatchdate = new org.kazao.calendar.KazaoCalendarDate();
        jPanel1 = new javax.swing.JPanel();
        jlbltotpayamt = new javax.swing.JLabel();
        jtxttotpayamt = new javax.swing.JTextField();
        jlblpayentrcnt = new javax.swing.JLabel();
        jtxtpayentrcnt = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlblbatchsts = new javax.swing.JLabel();
        jlblbatchtype = new javax.swing.JLabel();
        jchkReadyToPost = new javax.swing.JCheckBox();
        jtxtbatchstsdescription = new javax.swing.JTextField();
        jtxtbatchtypedescription = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jtbnNew = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jlbldocentry = new javax.swing.JLabel();
        jtxtdocentry = new javax.swing.JTextField();
        jbtnBrowseVendor = new javax.swing.JButton();
        jtxtdscription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtadjno = new javax.swing.JTextField();
        jlblyop = new javax.swing.JLabel();
        jcbYOP = new javax.swing.JComboBox();
        jlblmop = new javax.swing.JLabel();
        jcbMOP = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jtxtvendcode = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jtxtVendDescription = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtglreff = new javax.swing.JTextField();
        jtxttxtdesc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtdocnum = new javax.swing.JTextField();
        jtxtpayentcnt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtdoctotalpayamt = new javax.swing.JTextField();
        jtxtdoctotalpayamt2 = new javax.swing.JTextField();
        jtxtcurnccode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAdjustment = new selectallJTable(tmodeldetail);
        jLabel2 = new javax.swing.JLabel();
        jtxtadjusttot = new javax.swing.JTextField();
        jlbljrnldebit = new javax.swing.JLabel();
        jbtnBrowseDocNo = new javax.swing.JButton();
        jtxtDocType = new javax.swing.JTextField();
        jlbldocdate = new javax.swing.JLabel();
        kdateentrydate1 = new org.kazao.calendar.KazaoCalendarDate();
        jtxtbatchtype = new javax.swing.JTextField();
        jtxtbatchsts = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AP Adjustment");
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
        jHeader.setText(" : : Ap Adjusment");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 180, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 650, 6);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 6, 400);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(280, 100, 30, 17);

        jtxtid.setEditable(false);
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(410, 30, 80, 20);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchno.setText("Batch No");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(70, 100, 90, 13);

        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchno.setText("batchno");
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(200, 100, 80, 23);

        jlblbatchdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdate.setText("Batch Date");
        getContentPane().add(jlblbatchdate);
        jlblbatchdate.setBounds(70, 120, 100, 13);

        jlblbatchdesc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdesc.setText("Batch Desc");
        getContentPane().add(jlblbatchdesc);
        jlblbatchdesc.setBounds(70, 140, 100, 13);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchdesc.setText("batchdesc");
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(200, 140, 330, 23);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(490, 30, 80, 20);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(570, 30, 80, 20);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(650, 30, 80, 20);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(730, 30, 80, 20);

        kdatebatchdate.setFont(new java.awt.Font("Dialog", 0, 10));
        kdatebatchdate.setFontDate(new java.awt.Font("Dialog", 0, 10));
        kdatebatchdate.setFormat("dd/mm/yyyy");
        getContentPane().add(kdatebatchdate);
        kdatebatchdate.setBounds(200, 120, 100, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jlbltotpayamt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbltotpayamt.setText("Batch Total");
        jPanel1.add(jlbltotpayamt);
        jlbltotpayamt.setBounds(20, 40, 120, 13);

        jtxttotpayamt.setEditable(false);
        jtxttotpayamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxttotpayamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxttotpayamt.setText("totpayamt");
        jPanel1.add(jtxttotpayamt);
        jtxttotpayamt.setBounds(120, 40, 130, 23);

        jlblpayentrcnt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpayentrcnt.setText("Total Entries");
        jPanel1.add(jlblpayentrcnt);
        jlblpayentrcnt.setBounds(20, 10, 110, 13);

        jtxtpayentrcnt.setEditable(false);
        jtxtpayentrcnt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtpayentrcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtpayentrcnt.setText("payentrcnt");
        jPanel1.add(jtxtpayentrcnt);
        jtxtpayentrcnt.setBounds(120, 10, 130, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(550, 90, 270, 70);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 10));

        jPanel2.setLayout(null);

        jlblbatchsts.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchsts.setText("Batch Status");
        jPanel2.add(jlblbatchsts);
        jlblbatchsts.setBounds(20, 20, 140, 13);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchtype.setText("Batch Type");
        jPanel2.add(jlblbatchtype);
        jlblbatchtype.setBounds(20, 50, 140, 13);

        jchkReadyToPost.setFont(new java.awt.Font("Dialog", 1, 10));
        jchkReadyToPost.setText("Ready To Post");
        jPanel2.add(jchkReadyToPost);
        jchkReadyToPost.setBounds(20, 80, 140, 24);

        jtxtbatchstsdescription.setEditable(false);
        jtxtbatchstsdescription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchstsdescription.setText("batchsts");
        jPanel2.add(jtxtbatchstsdescription);
        jtxtbatchstsdescription.setBounds(140, 20, 80, 23);

        jtxtbatchtypedescription.setEditable(false);
        jtxtbatchtypedescription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchtypedescription.setText("batchtype");
        jPanel2.add(jtxtbatchtypedescription);
        jtxtbatchtypedescription.setBounds(140, 40, 80, 23);

        jTabbedPane1.addTab("Batch Info", jPanel2);

        jPanel3.setLayout(null);

        jtbnNew.setFont(new java.awt.Font("Dialog", 0, 10));
        jtbnNew.setText("New");
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jPanel3.add(jtbnNew);
        jtbnNew.setBounds(20, 10, 70, 20);

        jbtnDelete.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnDelete.setText("X");
        jbtnDelete.setToolTipText("Delete Entry");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnDelete);
        jbtnDelete.setBounds(90, 10, 60, 20);

        jbtnMoveFirst.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnMoveFirst.setText("|<");
        jbtnMoveFirst.setToolTipText("");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(150, 10, 60, 20);

        jbtnMovePrevious.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnMovePrevious.setText("<");
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(210, 10, 60, 20);

        jbtnMoveNext.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnMoveNext.setText(">");
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(270, 10, 50, 20);

        jbtnMoveLast.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnMoveLast.setText(">|");
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveLast);
        jbtnMoveLast.setBounds(320, 10, 60, 20);

        jlbldocentry.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocentry.setText("Doc Entry*");
        jPanel3.add(jlbldocentry);
        jlbldocentry.setBounds(30, 50, 100, 13);

        jtxtdocentry.setEditable(false);
        jtxtdocentry.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocentry.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdocentry.setText("jtxtdocentry");
        jPanel3.add(jtxtdocentry);
        jtxtdocentry.setBounds(140, 50, 90, 23);

        jbtnBrowseVendor.setText("...");
        jbtnBrowseVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseVendorActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowseVendor);
        jbtnBrowseVendor.setBounds(270, 110, 30, 20);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdscription.setText("jtxtdscription");
        jPanel3.add(jtxtdscription);
        jtxtdscription.setBounds(270, 50, 380, 23);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Adjustment No.");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 80, 110, 13);

        jtxtadjno.setEditable(false);
        jtxtadjno.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtadjno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtadjno.setText("jtxtadjno");
        jPanel3.add(jtxtadjno);
        jtxtadjno.setBounds(140, 80, 90, 23);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblyop.setText("Year");
        jPanel3.add(jlblyop);
        jlblyop.setBounds(460, 80, 40, 13);

        jcbYOP.setFont(new java.awt.Font("Dialog", 0, 10));
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
        jPanel3.add(jcbYOP);
        jcbYOP.setBounds(500, 80, 70, 20);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblmop.setText("Periode");
        jPanel3.add(jlblmop);
        jlblmop.setBounds(580, 80, 60, 13);

        jcbMOP.setFont(new java.awt.Font("Dialog", 0, 10));
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
        jPanel3.add(jcbMOP);
        jcbMOP.setBounds(650, 80, 70, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel4.setText("Vendor");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 110, 90, 13);

        jtxtvendcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtvendcode.setText("jtxtvendcode");
        jtxtvendcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtvendcodeKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtvendcode);
        jtxtvendcode.setBounds(140, 110, 130, 23);

        jButton2.setText("...");
        jPanel3.add(jButton2);
        jButton2.setBounds(230, 50, 30, 20);

        jtxtVendDescription.setEditable(false);
        jtxtVendDescription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtVendDescription.setText("jtxtVendDescription");
        jPanel3.add(jtxtVendDescription);
        jtxtVendDescription.setBounds(310, 110, 260, 23);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel5.setText("Referensi");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 130, 100, 13);

        jtxtglreff.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtglreff.setText("jtxtglreff");
        jPanel3.add(jtxtglreff);
        jtxtglreff.setBounds(140, 130, 130, 23);

        jtxttxtdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxttxtdesc.setText("jtxttxtdesc");
        jPanel3.add(jtxttxtdesc);
        jtxttxtdesc.setBounds(310, 130, 260, 23);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel6.setText("Document No ");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 150, 90, 13);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel7.setText("Payment No");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 170, 110, 13);

        jtxtdocnum.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocnum.setText("jtxtdocnum");
        jPanel3.add(jtxtdocnum);
        jtxtdocnum.setBounds(140, 150, 90, 23);

        jtxtpayentcnt.setEditable(false);
        jtxtpayentcnt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtpayentcnt.setText("jtxtpayentcnt");
        jPanel3.add(jtxtpayentcnt);
        jtxtpayentcnt.setBounds(140, 170, 90, 23);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel8.setText("Document Balance");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(310, 150, 140, 13);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel9.setText("Payment Balance");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(310, 170, 130, 13);

        jtxtdoctotalpayamt.setEditable(false);
        jtxtdoctotalpayamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdoctotalpayamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotalpayamt.setText("doctotalamtr");
        jPanel3.add(jtxtdoctotalpayamt);
        jtxtdoctotalpayamt.setBounds(460, 150, 150, 23);

        jtxtdoctotalpayamt2.setEditable(false);
        jtxtdoctotalpayamt2.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdoctotalpayamt2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotalpayamt2.setText("doctotalamtr");
        jPanel3.add(jtxtdoctotalpayamt2);
        jtxtdoctotalpayamt2.setBounds(460, 170, 150, 23);

        jtxtcurnccode.setEditable(false);
        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcurnccode.setText("curnccode");
        jPanel3.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(620, 150, 59, 23);

        jtblAdjustment.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblAdjustment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Dist. Code", "GL Acc", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtblAdjustment.setSurrendersFocusOnKeystroke(true);
        jtblAdjustment.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblAdjustmentPropertyChange(evt);
            }
        });
        jtblAdjustment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblAdjustmentKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblAdjustment);
        jtblAdjustment.getColumnModel().getColumn(0).setMinWidth(0);
        jtblAdjustment.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtblAdjustment.getColumnModel().getColumn(0).setMaxWidth(0);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 670, 90);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("Adjustment Total");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(360, 300, 160, 13);

        jtxtadjusttot.setEditable(false);
        jtxtadjusttot.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtadjusttot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtadjusttot.setText("jtxtadjusttot");
        jPanel3.add(jtxtadjusttot);
        jtxtadjusttot.setBounds(530, 300, 170, 23);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnldebit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbljrnldebit.setText("Index 1 of 100");
        jPanel3.add(jlbljrnldebit);
        jlbljrnldebit.setBounds(590, 10, 140, 13);

        jbtnBrowseDocNo.setText("...");
        jbtnBrowseDocNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseDocNoActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowseDocNo);
        jbtnBrowseDocNo.setBounds(230, 150, 30, 20);

        jtxtDocType.setEditable(false);
        jtxtDocType.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtDocType.setText("jtxtDocType");
        jPanel3.add(jtxtDocType);
        jtxtDocType.setBounds(580, 110, 140, 23);

        jlbldocdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocdate.setText("Date");
        jPanel3.add(jlbldocdate);
        jlbldocdate.setBounds(270, 80, 50, 13);

        kdateentrydate1.setFontDate(new java.awt.Font("Dialog", 0, 10));
        jPanel3.add(kdateentrydate1);
        kdateentrydate1.setBounds(350, 80, 100, 20);

        jTabbedPane1.addTab("Entry Info", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(70, 170, 750, 350);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setText("batchtype");
        getContentPane().add(jtxtbatchtype);
        jtxtbatchtype.setBounds(1140, 280, 80, 28);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setText("batchsts");
        getContentPane().add(jtxtbatchsts);
        jtxtbatchsts.setBounds(1140, 240, 80, 28);

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

private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed
    try{
        MOPChangedManually=true;
        MOPChangedManually=false;
        jbtnMoveNext.setEnabled(false);
        jbtnMoveLast.setEnabled(false);
        jbtnDelete.setEnabled(false);

        setDataApAdjh();

        adjh = new Ap_adjh();

        try {
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAp_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);

        obj.setDtlslctdindx(obj.getDetail().size());

        setAPAdjhEnable(true);
        jlbldocentry.setText("Doc Entry*");

        showDataApAdjh();

        //}
    }catch (CodeException e) {}

}//GEN-LAST:event_jtbnNewActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
   int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtdocentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{

            obj.removeDetail(obj.getDtlslctdindx());

            obj=new Ap_adjbatchlist(obj.getID());
            showData();

        }catch(Exception e) {e.printStackTrace();}

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed

private void jbtnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveFirstActionPerformed
    int pos = 0;
    try{
        jbtnMoveNext.setEnabled(true);
         jbtnMoveLast.setEnabled(true);
         jbtnDelete.setEnabled(true);
         MOPChangedManually=true;

        pos = obj.getDtlslctdindx();
        setDataApAdjh();
        jlbldocentry.setText("Doc Entry");
        if (pos > 0){

            obj.setDtlslctdindx(0);
            adjh = (Ap_adjh) obj.getDetail().list().get(0);
            showDataApAdjh();
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
        setDataApAdjh();

        jlbldocentry.setText("Doc Entry");

        if (pos > 0){

            obj.setDtlslctdindx(pos-1);

            adjh = (Ap_adjh) obj.getDetail().list().get(pos - 1);
            showDataApAdjh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;
        setDataApAdjh();

        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size() - 1){

            obj.setDtlslctdindx((pos+1));

            adjh = (Ap_adjh) obj.getDetail().list().get(pos + 1);
            showDataApAdjh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed
    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;
        setDataApAdjh();

        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size()){

            obj.setDtlslctdindx(obj.getDetail().list().size()-1);

            adjh = (Ap_adjh) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
            showDataApAdjh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jbtnBrowseVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseVendorActionPerformed
    // TODO add your handling code here:
    try {
        Ap_vendors brs = new Ap_vendors();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtvendcode);
        bd.setSecondValue(jtxtVendDescription);
        bd.setModal(true);
        bd.setVisible(true);

        Ap_vendor arcust=new Ap_vendor(jtxtvendcode.getText());
        jtxtcurnccode.setText(arcust.getcurnccode());

    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowseVendorActionPerformed

private void jbtnBrowseDocNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseDocNoActionPerformed

    if (jtxtvendcode.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Vendor Tolong Diisi");
    }else{

        try {
            Ap_invobls brs = new Ap_invobls();
            brs.searchDataAdjust(jtxtvendcode.getText());
            if (brs.size() != 0 ) {
                FrmBrowseAp_invoblAdjustmentByVendor bd = new FrmBrowseAp_invoblAdjustmentByVendor(brs);
                bd.vendcode = jtxtvendcode.getText();
                //bd.doctype = "4";
                bd.retrieveData();

                bd.setFirstValue(jtxtdocnum);
                bd.setSecondValue(jtxtDocType);
                bd.setThirdValue(jtxtdoctotalpayamt);
                bd.setFourthValue(jtxtcurnccode);

                bd.setModal(true);
                bd.setVisible(true);

            }else {
                JOptionPane.showMessageDialog(null, "Tidak Ditemukan Data untuk " + jtxtvendcode.getText());
            }

            jtxtdoctotalpayamt2.setText(jtxtdoctotalpayamt.getText());

        }catch(Exception e) {e.printStackTrace();}
    }
}//GEN-LAST:event_jbtnBrowseDocNoActionPerformed

private void jtblAdjustmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblAdjustmentKeyPressed

    int row = jtblAdjustment.getSelectedRow();
    int col = jtblAdjustment.getSelectedColumn();

    if (evt.getKeyCode()==evt.VK_ENTER){
        evt.consume();
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col){
            case 1:
                try {
                    Ap_distcodes brs = new Ap_distcodes();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 1);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Ap_distcode glacc = new Ap_distcode((tmodeldetail.getValueAt(row, 1)+"").replace("-", ""));

                    tmodeldetail.setValueAt(glacc.getglacccodefmt(), row, 2);

                    cekCbhd(row,col);

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Gl_accounts brs = new Gl_accounts();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 2);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, 2)+"").replace("-", ""));
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 2);

                    cekCbhd(row,col);

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;


        }
        if (row > -1) {
            try{
               cekCbhd(row,col);
            }catch(Exception e){}
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
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, 0);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);

        if (row > -1) {
            try{
                cekCbhd(row,col);
            }catch(Exception e){}
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{

                adjh.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail.removeRow(row);

            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblAdjustment, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblAdjustment, tmodeldetail.getRowCount()-1, 1);
            }


        }
    }

}//GEN-LAST:event_jtblAdjustmentKeyPressed

private void jtblAdjustmentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblAdjustmentPropertyChange
    int row = jtblAdjustment.getSelectedRow();
    int col = jtblAdjustment.getSelectedColumn();


    try{

        if (row > -1) {
              cekCbhd(row,col);
        }

        if(col == 2) {
            Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, col)+"").replace("-", ""));
            tmodeldetail.setValueAt(glacc.getaccfmttd(), row, col);
        }

        if (col == 1){
            Ap_distcode apdist = new Ap_distcode((tmodeldetail.getValueAt(row, 0)+"").replace("-", ""));
            tmodeldetail.setValueAt(apdist.getglacccodefmt(), row, 2);
        }

        jtxtadjusttot.setText(GlobalUtils.formatnumber(adjh.getDetailAmt()));
        
        //calcTotal();

       
    }catch (Exception e){
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblAdjustmentPropertyChange

private void jtxtvendcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtvendcodeKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode()==evt.VK_ENTER){
        Ap_vendor arcust;
            try {
                arcust = new Ap_vendor(jtxtvendcode.getText());
                jtxtVendDescription.setText(arcust.getvendname());
                jtxtcurnccode.setText(arcust.getcurnccode());
            } catch (CodeException ex) {
                Logger.getLogger(FrmAp_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}//GEN-LAST:event_jtxtvendcodeKeyPressed

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
                if (jlbldocentry.getText().equalsIgnoreCase("docentry*")){
                jbtnMoveNext.setEnabled(true);
                jbtnMoveLast.setEnabled(true);
                }

                mf.setToolBar(iformtype, istatus);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


private void calcTotal() {
    double total = 0;

    try{
        for (Object o : apadjds.list()) {
            Ap_adjd adjd = (Ap_adjd) o;
            total += adjd.getdistamt();
        }
    }catch(Exception e) {}

     jtxtadjusttot.setText(GlobalUtils.formatnumber(total));
}
private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);

//    lockedData(!jtxtbatchsts.getText().equals("2"));
}                                           

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
	      Ap_adjbatchlists brs = new Ap_adjbatchlists();
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
                    new FrmAp_adjbatchlist().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jHeader;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowseDocNo;
    private javax.swing.JButton jbtnBrowseVendor;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JComboBox jcbMOP;
    private javax.swing.JComboBox jcbYOP;
    private javax.swing.JCheckBox jchkReadyToPost;
    private javax.swing.JLabel jlblbatchdate;
    private javax.swing.JLabel jlblbatchdesc;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JLabel jlblbatchsts;
    private javax.swing.JLabel jlblbatchtype;
    private javax.swing.JLabel jlbldocdate;
    private javax.swing.JLabel jlbldocentry;
    private javax.swing.JLabel jlbljrnldebit;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblpayentrcnt;
    private javax.swing.JLabel jlbltotpayamt;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JTable jtblAdjustment;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtDocType;
    private javax.swing.JTextField jtxtVendDescription;
    private javax.swing.JTextField jtxtadjno;
    private javax.swing.JTextField jtxtadjusttot;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtbatchdesc;
    private javax.swing.JTextField jtxtbatchno;
    private javax.swing.JTextField jtxtbatchsts;
    private javax.swing.JTextField jtxtbatchstsdescription;
    private javax.swing.JTextField jtxtbatchtype;
    private javax.swing.JTextField jtxtbatchtypedescription;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtcurnccode;
    private javax.swing.JTextField jtxtdocentry;
    private javax.swing.JTextField jtxtdocnum;
    private javax.swing.JTextField jtxtdoctotalpayamt;
    private javax.swing.JTextField jtxtdoctotalpayamt2;
    private javax.swing.JTextField jtxtdscription;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtglreff;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtpayentcnt;
    private javax.swing.JTextField jtxtpayentrcnt;
    private javax.swing.JTextField jtxttotpayamt;
    private javax.swing.JTextField jtxttxtdesc;
    private javax.swing.JTextField jtxtvendcode;
    private org.kazao.calendar.KazaoCalendarDate kdatebatchdate;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate1;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        obj.moveFirst();
        mf.setIcon(CLASSNAME);
        showData();
//        lockedData(!jtxtbatchsts.getText().equals("2"));

    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        mf.setIcon(CLASSNAME);
        showData();
//        lockedData(!jtxtbatchsts.getText().equals("2"));
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        mf.setIcon(CLASSNAME);
        showData();
//        lockedData(!jtxtbatchsts.getText().equals("2"));
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        mf.setIcon(CLASSNAME);
        showData();
//        lockedData(!jtxtbatchsts.getText().equals("2"));
    }

    public void searchData() throws CodeException {
        obj = new Ap_adjbatchlist(this.jtxtbatchno.getText());
        mf.setIcon(CLASSNAME);
        showData();
//        lockedData(!jtxtbatchsts.getText().equals("2"));

    }
    public void newData() throws CodeException {
        obj = new Ap_adjbatchlist();
        istatus=1;
        showData();
        try {
            kdatebatchdate.setDate(GlobalUtils.sessiondate);
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAp_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
        
        jlbldocentry.setText("Doc Entry*");
        setToolBar(iformtype,istatus);
    }

    public void saveData() throws CodeException {
        setData();
        obj.save();
        
        istatus = 0;
        mf.setIcon(CLASSNAME);
        showData();
    }

    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	
             jtxtid.setText(obj.toString(Ap_adjbatchlist.PROPERTY_ID));
             jtxtbatchno.setText(obj.toString(Ap_adjbatchlist.PROPERTY_BATCHNO));
             try {
                kdatebatchdate.setDate(GlobalUtils.formatDate(obj.toString(Ap_adjbatchlist.PROPERTY_BATCHDATE), "MM/dd/yyyy"));
             }catch(Exception e) {
                kdatebatchdate.setDate(new Date());
             }

             jtxtbatchdesc.setText(obj.toString(Ap_adjbatchlist.PROPERTY_BATCHDESC));
             try{
                jchkReadyToPost.setSelected(obj.getreadytpost().equals("1") ? true :  false);
             }catch (Exception e) {
                 jchkReadyToPost.setSelected(false);
             }
             
             jtxtbatchsts.setText(obj.getbatchsts() == null ? "1" : obj.getbatchsts()+"" );
             jtxtbatchtype.setText(obj.getbatchtype() == null   ? "1" : obj.getbatchtype()+"");

             jtxtbatchtypedescription.setText(obj.gettypedescription());

             jtxtbatchstsdescription.setText(obj.getstatusdescription());
             
             jtxttotpayamt.setText(GlobalUtils.formatnumber(obj.gettotpayamt()));
             jtxtpayentrcnt.setText(GlobalUtils.formatnumber(obj.getpayentrcnt()));
             jtxtentrydate.setText(obj.toString(Ap_adjbatchlist.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Ap_adjbatchlist.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Ap_adjbatchlist.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Ap_adjbatchlist.PROPERTY_CMPNYID));

             if (obj.getDetail().list().isEmpty()) {
                 obj.setDtlslctdindx(-1);
                 setAPAdjhEnable(false);
                 adjh = new Ap_adjh();
             }else{
                obj.setDtlslctdindx(obj.getDetail().size()-1);
                adjh = (Ap_adjh) obj.getDetail().list().get(obj.getDetail().size()-1);
                setAPAdjhEnable(true);
              }

             
             showDataApAdjh();

             try {
                 mf.btnSave.setEnabled(!obj.getbatchsts().equalsIgnoreCase("2"));
                 mf.btnDel.setEnabled(!obj.getbatchsts().equalsIgnoreCase("2"));
                 mf.btnUndo.setEnabled(!obj.getbatchsts().equalsIgnoreCase("2"));
             }catch(Exception e) {}
             
             setCursor(GlobalUtils.NORMALCURSOR);
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        mf.setIcon(CLASSNAME);
        showData();
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Ap_adjbatchlist.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;

          
          obj.fromString(Ap_adjbatchlist.PROPERTY_BATCHDATE,  GlobalUtils.formatDate(kdatebatchdate.getDate(),"yyyy-MM-dd")) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_BATCHDESC, jtxtbatchdesc.getText()) ;

          obj.fromString(Ap_adjbatchlist.PROPERTY_READYTPOST, jchkReadyToPost.isSelected() == true ? "1" : "0") ;

          obj.fromString(Ap_adjbatchlist.PROPERTY_BATCHTYPE, jtxtbatchtype.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_BATCHSTS, jtxtbatchsts.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_TOTPAYAMT, adjh.getDetailAmt()+"") ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_PAYENTRCNT, jtxtpayentrcnt.getText().replace(",", "")) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText()) ;
          obj.fromString(Ap_adjbatchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText()) ;

          setDataApAdjh();

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

private void setDataApAdjh() throws CodeException {

          adjh.fromString(Ap_adjh.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_DOCENTRY, jtxtdocentry.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_VENDCODE, jtxtvendcode.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_DOCNUM, jtxtdocnum.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_YOP, jcbYOP.getSelectedItem()+"") ;
          adjh.fromString(Ap_adjh.PROPERTY_MOP, jcbMOP.getSelectedItem()+"") ;
          adjh.fromString(Ap_adjh.PROPERTY_DSCRIPTION, jtxtdscription.getText()) ;

          adjh.fromString(Ap_adjh.PROPERTY_DOCDATE, GlobalUtils.formatDate(kdateentrydate1.getDate(),"yyyy-MM-dd"));

          adjh.fromString(Ap_adjh.PROPERTY_TXTDESC, jtxttxtdesc.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_GLREFF, jtxtglreff.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_ADJNO, jtxtadjno.getText()) ;
          adjh.fromString(Ap_adjh.PROPERTY_PAYENTCNT, jtxtpayentcnt.getText().replace(",", "")) ;
          
          adjh.fromString(Ap_adjh.PROPERTY_DOCTOTALPAYAMT, jtxtdoctotalpayamt.getText().replace(",", "")) ;

          adjh.fromString(Ap_adjh.PROPERTY_ADJUSTTOT, jtxtadjusttot.getText().replace(",", "")) ;


          adjh.fromString(Ap_adjh.PROPERTY_DOCTYPE, jtxtDocType.getText()) ;
          
          if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*") || obj.getDtlslctdindx() < 0){
                obj.adddetail(adjh);
          } else {
                obj.replaceDetail(obj.getDtlslctdindx(), adjh);
          }


}

private void setAPAdjhEnable(boolean enable) {
    jtxtdocentry.setEnabled(enable);
    //jtxtjrnldesc.setEnabled(enable);
    //jtxtsrcelgrcode.setEnabled(enable);
}

public void showDataApAdjh() throws CodeException  {
    //System.out.println(cbhh.getID() + "   " + cbhh.getdscription());
    onload=true;

    jtxtdocentry.setText(GlobalUtils.churuf(adjh.getdocentry()));
    if(adjh.getdocentry() == 0) {
        jlbldocentry.setText("Doc Entry*");
    }else {
        jlbldocentry.setText("Doc Entry");
    }

    jtxtvendcode.setText(adjh.toString(Ap_adjh.PROPERTY_VENDCODE));
    Ap_vendor arcust=new Ap_vendor(adjh.getvendcode());
    jtxtVendDescription.setText(arcust.getvendname());
    jtxtdocnum.setText(adjh.toString(Ap_adjh.PROPERTY_DOCNUM));
    jtxtdscription.setText(adjh.toString(Ap_adjh.PROPERTY_DSCRIPTION));

    try {
        kdateentrydate1.setDate(GlobalUtils.formatDate(adjh.getdocdate(),"MM/dd/yyyy"));
    } catch (KazaoCalendarDateTimeException ex) {
        Logger.getLogger(FrmAr_adjbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

    jtxttxtdesc.setText(adjh.toString(Ap_adjh.PROPERTY_TXTDESC));
    jtxtglreff.setText(adjh.toString(Ap_adjh.PROPERTY_GLREFF));

    jtxtadjno.setText(adjh.toString(Ap_adjh.PROPERTY_ADJNO));

    jtxtpayentcnt.setText(adjh.getpayentcnt() == 0 ? "1" : adjh.getpayentcnt()+"");

    Ap_invobl apinv = new Ap_invobl();
    apinv.searchData(adjh.getvendcode(), adjh.getdocnum());
    
    jtxtdoctotalpayamt.setText(GlobalUtils.formatnumber(apinv.getdoctotalamtr()));
    jtxtdoctotalpayamt2.setText(GlobalUtils.formatnumber(apinv.getdoctotalamtr()));
    jtxtcurnccode.setText(apinv.getcurnccode()==null ? "" : apinv.getcurnccode());

    jtxtadjusttot.setText(GlobalUtils.formatnumber(adjh.getadjusttot()));

    jtxtDocType.setText(adjh.getdoctype()== null ? "1"  : adjh.getdoctype());

    mopbf=adjh.getmop();
    yopbf=adjh.getyop();
    String mop="";
    if (adjh.getmop()<10){
        mop="0"+adjh.getmop();
    } else {
        mop=adjh.getmop()+"";
    }

    if (adjh.getID()>0){
        jcbMOP.setSelectedItem(mop);
        jcbYOP.setSelectedItem((int)adjh.getyop());
    } else {
        jcbYOP.setSelectedItem(GlobalUtils.toInt(GlobalUtils.getCurrentYear()));
        mop="";
        if (GlobalUtils.toInt(GlobalUtils.getCurrentMonth())<10){
            mop="0"+GlobalUtils.toInt(GlobalUtils.getCurrentMonth());
        } else {
            mop=GlobalUtils.toInt(GlobalUtils.getCurrentMonth())+"";
        }
        jcbMOP.setSelectedItem(mop);
    }
    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
        jlbljrnldebit.setText("Index * of "+obj.getDetail().size());
    } else {
        jlbljrnldebit.setText("Index "+(obj.getDtlslctdindx()+1)+" of "+obj.getDetail().size());
    }


    apadjds = adjh.getDetail();

    showDataCbhd();

    onload=false;

}

public void showDataCbhd() throws CodeException  {
    GlobalModel.clearRow(tmodeldetail);
    tmodeldetail.addRow(datadetail);

    for (Object o : apadjds.list()) {
        Ap_adjd apd = (Ap_adjd) o;
        tmodeldetail.setValueAt(apd.getID(), tmodeldetail.getRowCount() - 1, 0);
        tmodeldetail.setValueAt(apd.getdistcode() == null ||  apd.getdistcode().equalsIgnoreCase("null") ? "" : apd.getdistcode()  , tmodeldetail.getRowCount() - 1, 1);
        tmodeldetail.setValueAt(apd.getaccfmttd(), tmodeldetail.getRowCount() - 1, 2);
        tmodeldetail.setValueAt(apd.getdistamt(), tmodeldetail.getRowCount() - 1, 3);

        tmodeldetail.addRow(datadetail);
    }

    jtxttotpayamt.setText(GlobalUtils.formatnumber(adjh.getDetailAmt()));
}


private void cekCbhd(int row,int col) throws CodeException {
    Ap_adjd apajd;
    if (row > apadjds.list().size() - 1) {
        apajd = new Ap_adjd();
        apadjds.add(apajd);
    }else{
        apajd = (Ap_adjd) apadjds.list().get(row);
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail.getValueAt(row, 0)+"");
    }catch (Exception e){}

    apajd.setID(idcbhd);
    apajd.setdistcode(tmodeldetail.getValueAt(row, 1) + "");
    apajd.setaccfmttd(tmodeldetail.getValueAt(row, 2) + "");

    double distamount = 0;
    try {
        distamount = Double.parseDouble((tmodeldetail.getValueAt(row, 3)+"").replace(",", ""));
    }catch (Exception e ) {}

    apajd.setdistamt(distamount);

    apadjds.list().set(row, apajd);

    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=adjh.getDetailAmt();

    }

    jtxttotpayamt.setText(GlobalUtils.formatnumber(DetailAmt));


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
