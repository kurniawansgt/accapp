/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import test.FrmAp_paybatchlist;
 * 
 * .......
 * 
 * 
 * FrmAp_paybatchlist frmAp_paybatchlist;
 * 
 * .......
 * 
 try {
        if (frmAp_paybatchlist == null) {
            frmmAp_paybatchlist = new FrmAp_paybatchlist(this);
        }
        
        showForm(frmAp_paybatchlist);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.ap;

import accapp.component.browse.FrmBrowseAPVendor;
import accapp.component.browse.FrmBrowseAccountActive;
import accapp.component.browse.FrmBrowseAp_invoblByVendor;
import accapp.component.gl.FrmGl_batchlist;
import accapp.objectclasses.ap.Ap_distcode;
import accapp.objectclasses.ap.Ap_distcodes;
import accapp.objectclasses.ap.Ap_invh;
import accapp.objectclasses.ap.Ap_invobl;
import accapp.objectclasses.ap.Ap_invobls;
import accapp.objectclasses.ap.Ap_optional;
import accapp.objectclasses.ap.Ap_paybatchlist;
import accapp.objectclasses.ap.Ap_paybatchlists;
import accapp.objectclasses.ap.Ap_payd;
import accapp.objectclasses.ap.Ap_paydmisc;
import accapp.objectclasses.ap.Ap_paydmiscs;
import accapp.objectclasses.ap.Ap_payds;
import accapp.objectclasses.ap.Ap_payh;
import accapp.objectclasses.ap.Ap_vendor;
import accapp.objectclasses.ap.Ap_vendors;


import common.component.FrmBrowse;
import common.classinterface.NavigatorFormInt;
import common.component.FrmMainFrame;

import common.utils.CodeException;
import common.utils.GlobalUtils;
import javax.swing.JOptionPane;
import common.utils.ExtFileChooserFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import accapp.objectclasses.cashbook.Cb_bank;
import accapp.objectclasses.cashbook.Cb_banks;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_currency;
import accapp.objectclasses.gl.Gl_fiscalh;
import common.print.FrmPrintTransaksiAPBatchListInvoice;
import common.tablemodels.GlobalModel;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.kazao.calendar.KazaoCalendar;
import org.kazao.calendar.KazaoCalendarAdapter;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author  Generator
 */

public class FrmAp_paybatchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmAp_paybatchlist";
    
    FrmMainFrame mf ;
    
    
    public Ap_paybatchlist obj = new Ap_paybatchlist();

    Ap_payh apph = new Ap_payh();
    Ap_payds appds = new Ap_payds();
    Ap_paydmiscs appdmiscs = new Ap_paydmiscs();
    Ap_optional apop=null;

    Object[] datadetail;
    DefaultTableModel tmodeldetail;

    Object[] datadetail1;
    DefaultTableModel tmodeldetail1;

    JTextField appddoctype=new JTextField();


    int posttable = 0;
    Boolean MOPChangedManually=false;

    long mopbf=0;
    long yopbf=0;

    boolean onload = false;

   
    /** Creates new form Area */
    public FrmAp_paybatchlist() throws CodeException {
        initComponents();
    }
    
    public FrmAp_paybatchlist(FrmMainFrame mf) throws CodeException{
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

        datadetail = new Object[jtblDetail.getRowCount()];
        tmodeldetail = (DefaultTableModel) jtblDetail.getModel();
        
        datadetail1 = new Object[jtblDetail1.getRowCount()];
        tmodeldetail1 = (DefaultTableModel) jtblDetail1.getModel();
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jHeader = new javax.swing.JLabel();
        HorizontalLine = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
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
        jPanel1 = new javax.swing.JPanel();
        jlblrcpentrcnt = new javax.swing.JLabel();
        jtxtrcpentrcnt = new javax.swing.JTextField();
        jlbltotrcpamt = new javax.swing.JLabel();
        jtxttotrcpamt = new javax.swing.JTextField();
        kdateentrydate = new org.kazao.calendar.KazaoCalendarDate();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlblbatchtype = new javax.swing.JLabel();
        jtxtbatchtype = new javax.swing.JTextField();
        jlblbatchsts = new javax.swing.JLabel();
        jtxtbatchsts = new javax.swing.JTextField();
        jlblbankcode = new javax.swing.JLabel();
        jtxtbankcode = new javax.swing.JTextField();
        jbtnBrowse1 = new javax.swing.JButton();
        jtxtbankname = new javax.swing.JTextField();
        jlblbankcode1 = new javax.swing.JLabel();
        jtxtCurr = new javax.swing.JTextField();
        jtxtCurDescription = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jtbnNew = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jlbljrnldebit = new javax.swing.JLabel();
        jlbldocentry = new javax.swing.JLabel();
        jtxtdocentry = new javax.swing.JTextField();
        jlbldscription = new javax.swing.JLabel();
        jtxtdscription = new javax.swing.JTextField();
        jlbldoctype = new javax.swing.JLabel();
        jlbldoctotalamt = new javax.swing.JLabel();
        jtxtdoctotalamt = new javax.swing.JTextField();
        jlbldocnum = new javax.swing.JLabel();
        jtxtdocnum = new javax.swing.JTextField();
        jtxtcurnccode = new javax.swing.JTextField();
        jlblcustmrcode = new javax.swing.JLabel();
        jtxtvenddesc = new javax.swing.JTextField();
        jlbldocdate = new javax.swing.JLabel();
        jlblyop = new javax.swing.JLabel();
        jlblmop = new javax.swing.JLabel();
        jlblpayor = new javax.swing.JLabel();
        jtxtpayor = new javax.swing.JTextField();
        jlblunapltotalamtc = new javax.swing.JLabel();
        jtxtunapltotalamtc = new javax.swing.JTextField();
        jtxtvendcode = new javax.swing.JTextField();
        jtxtcurnccode1 = new javax.swing.JTextField();
        jcbYOP = new javax.swing.JComboBox();
        jcbMOP = new javax.swing.JComboBox();
        jbtnBrowse6 = new javax.swing.JButton();
        jcmbdoctype = new javax.swing.JComboBox();
        jbtnBrowse7 = new javax.swing.JButton();
        kdateentrydate1 = new org.kazao.calendar.KazaoCalendarDate();
        jcmbpaycode = new javax.swing.JComboBox();
        jlblpaycode1 = new javax.swing.JLabel();
        jbtnRetrieve = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlblpaycode2 = new javax.swing.JLabel();
        jlblpaycode3 = new javax.swing.JLabel();
        jtxtdocnumapplto = new javax.swing.JTextField();
        jbtnBrowse8 = new javax.swing.JButton();
        jlblpaycode4 = new javax.swing.JLabel();
        jtxtpredocnum = new javax.swing.JTextField();
        jbtnBrowse9 = new javax.swing.JButton();
        jcmbDocType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new selectallJTable(tmodeldetail);
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblDetail1 = new selectallJTable(tmodeldetail);
        jbtnBrowse10 = new javax.swing.JButton();
        jbtnBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AP Payment Entry");
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
        jHeader.setText(" : : AP Payment Entry");
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
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(350, 30, 80, 16);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchno.setText("Batch Number");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(70, 80, 140, 14);

        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchno.setText("batchno");
        jtxtbatchno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtbatchnoActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(170, 80, 80, 20);

        jlblbatchdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdate.setText("Batch Date");
        getContentPane().add(jlblbatchdate);
        jlblbatchdate.setBounds(70, 100, 140, 14);

        jlblbatchdesc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdesc.setText("Description");
        getContentPane().add(jlblbatchdesc);
        jlblbatchdesc.setBounds(70, 120, 140, 14);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchdesc.setText("batchdesc");
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(170, 120, 360, 20);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(430, 30, 80, 16);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(510, 30, 80, 16);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(590, 30, 80, 16);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(670, 30, 80, 16);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(null);

        jlblrcpentrcnt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblrcpentrcnt.setText("Total Entries");
        jPanel1.add(jlblrcpentrcnt);
        jlblrcpentrcnt.setBounds(10, 10, 90, 14);

        jtxtrcpentrcnt.setEditable(false);
        jtxtrcpentrcnt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtrcpentrcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtrcpentrcnt.setText("rcpentrcnt");
        jPanel1.add(jtxtrcpentrcnt);
        jtxtrcpentrcnt.setBounds(130, 10, 130, 20);

        jlbltotrcpamt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbltotrcpamt.setText("Batch Total");
        jPanel1.add(jlbltotrcpamt);
        jlbltotrcpamt.setBounds(10, 30, 90, 14);

        jtxttotrcpamt.setEditable(false);
        jtxttotrcpamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxttotrcpamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxttotrcpamt.setText("totrcpamt");
        jPanel1.add(jtxttotrcpamt);
        jtxttotrcpamt.setBounds(130, 30, 130, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(540, 70, 270, 70);

        kdateentrydate.setFont(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate.setFontDate(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(kdateentrydate);
        kdateentrydate.setBounds(170, 100, 100, 20);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 10));

        jPanel2.setLayout(null);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchtype.setText("Type");
        jPanel2.add(jlblbatchtype);
        jlblbatchtype.setBounds(10, 50, 70, 14);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchtype.setText("batchtype");
        jPanel2.add(jtxtbatchtype);
        jtxtbatchtype.setBounds(200, 50, 160, 20);

        jlblbatchsts.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchsts.setText("Status");
        jPanel2.add(jlblbatchsts);
        jlblbatchsts.setBounds(10, 20, 140, 14);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchsts.setText("batchsts");
        jPanel2.add(jtxtbatchsts);
        jtxtbatchsts.setBounds(200, 20, 120, 20);

        jlblbankcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbankcode.setText("Currency");
        jPanel2.add(jlblbankcode);
        jlblbankcode.setBounds(10, 110, 140, 14);

        jtxtbankcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbankcode.setText("bankcode");
        jPanel2.add(jtxtbankcode);
        jtxtbankcode.setBounds(200, 80, 80, 20);

        jbtnBrowse1.setText("...");
        jbtnBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse1);
        jbtnBrowse1.setBounds(290, 80, 30, 17);

        jtxtbankname.setEditable(false);
        jtxtbankname.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbankname.setText("bankcode");
        jPanel2.add(jtxtbankname);
        jtxtbankname.setBounds(330, 80, 360, 20);

        jlblbankcode1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbankcode1.setText("Bank Code");
        jPanel2.add(jlblbankcode1);
        jlblbankcode1.setBounds(10, 80, 140, 14);

        jtxtCurr.setEditable(false);
        jtxtCurr.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtCurr.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtxtCurr.setText("jtxtCur");
        jPanel2.add(jtxtCurr);
        jtxtCurr.setBounds(200, 110, 80, 20);

        jtxtCurDescription.setEditable(false);
        jtxtCurDescription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtCurDescription.setText("jtxtCurDescription");
        jPanel2.add(jtxtCurDescription);
        jtxtCurDescription.setBounds(290, 110, 360, 20);

        jTabbedPane1.addTab("Batch Info", jPanel2);

        jPanel3.setLayout(null);

        jtbnNew.setFont(new java.awt.Font("Dialog", 1, 10));
        jtbnNew.setText("New");
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jPanel3.add(jtbnNew);
        jtbnNew.setBounds(10, 10, 70, 20);

        jbtnMoveFirst.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnMoveFirst.setText("|<");
        jbtnMoveFirst.setToolTipText("First Entry");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(170, 10, 50, 20);

        jbtnMovePrevious.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnMovePrevious.setText("<");
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(220, 10, 50, 20);

        jbtnMoveNext.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnMoveNext.setText(">");
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(270, 10, 50, 20);

        jbtnMoveLast.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnMoveLast.setText(">|");
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveLast);
        jbtnMoveLast.setBounds(320, 10, 50, 20);

        jbtnDelete.setFont(new java.awt.Font("Dialog", 1, 10));
        jbtnDelete.setText("Delete");
        jbtnDelete.setToolTipText("Delete Entry");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnDelete);
        jbtnDelete.setBounds(80, 10, 80, 20);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnldebit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbljrnldebit.setText("Index 1 of 100");
        jPanel3.add(jlbljrnldebit);
        jlbljrnldebit.setBounds(590, 10, 140, 14);

        jlbldocentry.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocentry.setText("Entry");
        jPanel3.add(jlbldocentry);
        jlbldocentry.setBounds(10, 50, 140, 14);

        jtxtdocentry.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocentry.setText("docentry");
        jPanel3.add(jtxtdocentry);
        jtxtdocentry.setBounds(140, 50, 80, 20);

        jlbldscription.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldscription.setText("Description");
        jPanel3.add(jlbldscription);
        jlbldscription.setBounds(310, 50, 80, 14);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdscription.setText("dscription");
        jPanel3.add(jtxtdscription);
        jtxtdscription.setBounds(390, 50, 330, 20);

        jlbldoctype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldoctype.setText("Trans Type");
        jPanel3.add(jlbldoctype);
        jlbldoctype.setBounds(10, 70, 130, 14);

        jlbldoctotalamt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldoctotalamt.setText("Amount");
        jPanel3.add(jlbldoctotalamt);
        jlbldoctotalamt.setBounds(10, 90, 130, 14);

        jtxtdoctotalamt.setEditable(false);
        jtxtdoctotalamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdoctotalamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotalamt.setText("doctotalamt");
        jtxtdoctotalamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdoctotalamtKeyReleased(evt);
            }
        });
        jPanel3.add(jtxtdoctotalamt);
        jtxtdoctotalamt.setBounds(140, 90, 110, 20);

        jlbldocnum.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocnum.setText("Check/Receipt No.");
        jPanel3.add(jlbldocnum);
        jlbldocnum.setBounds(10, 110, 130, 14);

        jtxtdocnum.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocnum.setText("noreff");
        jtxtdocnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdocnumActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtdocnum);
        jtxtdocnum.setBounds(140, 110, 110, 20);

        jtxtcurnccode.setEditable(false);
        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcurnccode.setText("curnccode");
        jPanel3.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(650, 130, 70, 20);

        jlblcustmrcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblcustmrcode.setText("Vendor");
        jPanel3.add(jlblcustmrcode);
        jlblcustmrcode.setBounds(310, 70, 80, 14);

        jtxtvenddesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtvenddesc.setText("venddesc");
        jPanel3.add(jtxtvenddesc);
        jtxtvenddesc.setBounds(490, 70, 230, 20);

        jlbldocdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocdate.setText("Date");
        jPanel3.add(jlbldocdate);
        jlbldocdate.setBounds(310, 90, 50, 14);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblyop.setText("Year");
        jPanel3.add(jlblyop);
        jlblyop.setBounds(510, 90, 40, 14);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblmop.setText("Periode");
        jPanel3.add(jlblmop);
        jlblmop.setBounds(620, 90, 50, 14);

        jlblpayor.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpayor.setText("Remit To");
        jPanel3.add(jlblpayor);
        jlblpayor.setBounds(310, 110, 140, 14);

        jtxtpayor.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtpayor.setText("payor");
        jPanel3.add(jtxtpayor);
        jtxtpayor.setBounds(390, 110, 310, 20);

        jlblunapltotalamtc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblunapltotalamtc.setText("Applied Amount");
        jPanel3.add(jlblunapltotalamtc);
        jlblunapltotalamtc.setBounds(310, 130, 140, 14);

        jtxtunapltotalamtc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtunapltotalamtc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtunapltotalamtcKeyReleased(evt);
            }
        });
        jPanel3.add(jtxtunapltotalamtc);
        jtxtunapltotalamtc.setBounds(480, 130, 170, 20);

        jtxtvendcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtvendcode.setText("vendcode");
        jtxtvendcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtvendcodeKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtvendcode);
        jtxtvendcode.setBounds(390, 70, 80, 20);

        jtxtcurnccode1.setEditable(false);
        jtxtcurnccode1.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcurnccode1.setText("curnccode");
        jPanel3.add(jtxtcurnccode1);
        jtxtcurnccode1.setBounds(250, 90, 50, 20);

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
        jcbYOP.setBounds(550, 90, 70, 20);

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
        jcbMOP.setBounds(670, 90, 50, 20);

        jbtnBrowse6.setText("...");
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse6);
        jbtnBrowse6.setBounds(470, 70, 20, 17);

        jcmbdoctype.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbdoctype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Payment", "Prepayment", "Apply Document", "Misc Receipt" }));
        jcmbdoctype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbdoctypeItemStateChanged(evt);
            }
        });
        jPanel3.add(jcmbdoctype);
        jcmbdoctype.setBounds(140, 70, 110, 20);

        jbtnBrowse7.setText("...");
        jbtnBrowse7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse7ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse7);
        jbtnBrowse7.setBounds(220, 50, 20, 17);

        kdateentrydate1.setFont(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate1.setFontDate(new java.awt.Font("Dialog", 0, 10));
        jPanel3.add(kdateentrydate1);
        kdateentrydate1.setBounds(390, 90, 100, 20);

        jcmbpaycode.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbpaycode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Check" }));
        jPanel3.add(jcmbpaycode);
        jcmbpaycode.setBounds(140, 130, 110, 20);

        jlblpaycode1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode1.setText("Receipt Type");
        jPanel3.add(jlblpaycode1);
        jlblpaycode1.setBounds(10, 130, 130, 14);

        jbtnRetrieve.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnRetrieve.setText("Retrieve Data");
        jbtnRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRetrieveActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnRetrieve);
        jbtnRetrieve.setBounds(470, 10, 120, 30);

        jPanel4.setLayout(null);

        jlblpaycode2.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode2.setText("Apply Prepayment To");
        jPanel4.add(jlblpaycode2);
        jlblpaycode2.setBounds(300, 0, 160, 14);

        jlblpaycode3.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode3.setText("Document Type");
        jPanel4.add(jlblpaycode3);
        jlblpaycode3.setBounds(0, 0, 130, 14);

        jtxtdocnumapplto.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocnumapplto.setText("docnumapplto");
        jPanel4.add(jtxtdocnumapplto);
        jtxtdocnumapplto.setBounds(470, 0, 170, 20);

        jbtnBrowse8.setText("...");
        jbtnBrowse8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse8ActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnBrowse8);
        jbtnBrowse8.setBounds(640, 0, 20, 17);

        jlblpaycode4.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode4.setText("Prepayment Doc No.");
        jPanel4.add(jlblpaycode4);
        jlblpaycode4.setBounds(170, 50, 160, 14);

        jtxtpredocnum.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtpredocnum.setText("predocnum");
        jPanel4.add(jtxtpredocnum);
        jtxtpredocnum.setBounds(340, 50, 170, 20);

        jbtnBrowse9.setText("...");
        jbtnBrowse9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse9ActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnBrowse9);
        jbtnBrowse9.setBounds(510, 50, 20, 17);

        jcmbDocType.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbDocType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Credit Note", "Debit Note", "Interest Invoice" }));
        jPanel4.add(jcmbDocType);
        jcmbDocType.setBounds(130, 0, 98, 22);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 160, 705, 153);

        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Apply", "Document Type", "Document Number", "Pending Balance", "Applied Amount", "Net Balance", "Current Balance", "Original Amount", "Pending Amount", "Po Number", "Sales Order Number", "Document Date", "Due Date", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true, true, true, true, true, true, true, false
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
        jtblDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblDetailMousePressed(evt);
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
        });
        jScrollPane1.setViewportView(jtblDetail);
        jtblDetail.getColumnModel().getColumn(0).setMinWidth(80);
        jtblDetail.getColumnModel().getColumn(1).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(2).setMinWidth(120);
        jtblDetail.getColumnModel().getColumn(3).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(4).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(6).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(7).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(8).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(9).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(10).setMinWidth(200);
        jtblDetail.getColumnModel().getColumn(11).setMinWidth(100);
        jtblDetail.getColumnModel().getColumn(13).setMinWidth(0);
        jtblDetail.getColumnModel().getColumn(13).setPreferredWidth(0);
        jtblDetail.getColumnModel().getColumn(13).setMaxWidth(0);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 705, 153);

        jtblDetail1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Account", "Account Name", "Amount", "Reference", "Description", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDetail1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblDetail1.setSurrendersFocusOnKeystroke(true);
        jtblDetail1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtblDetail1PropertyChange(evt);
            }
        });
        jtblDetail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblDetail1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtblDetail1);
        jtblDetail1.getColumnModel().getColumn(0).setMinWidth(150);
        jtblDetail1.getColumnModel().getColumn(1).setMinWidth(200);
        jtblDetail1.getColumnModel().getColumn(2).setMinWidth(100);
        jtblDetail1.getColumnModel().getColumn(3).setMinWidth(100);
        jtblDetail1.getColumnModel().getColumn(4).setMinWidth(200);
        jtblDetail1.getColumnModel().getColumn(5).setMinWidth(0);
        jtblDetail1.getColumnModel().getColumn(5).setPreferredWidth(0);
        jtblDetail1.getColumnModel().getColumn(5).setMaxWidth(0);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 160, 705, 153);

        jbtnBrowse10.setText("...");
        jbtnBrowse10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse10ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse10);
        jbtnBrowse10.setBounds(700, 110, 20, 17);

        jTabbedPane1.addTab("Entry Info", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(70, 150, 740, 370);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(260, 80, 30, 17);

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
    try {
          Cb_banks brs = new Cb_banks();
          FrmBrowse bd = new FrmBrowse(brs);
          bd.setFirstValue(jtxtbankcode);
          bd.setSecondValue(jtxtbankname);

          bd.setModal(true);
          bd.setVisible(true);

          Cb_bank cbbank = new Cb_bank(Cb_bank.PROPERTY_BANKCODE, jtxtbankcode.getText());
          if (cbbank.getID() != Cb_bank.NULLID) {
              jtxtCurr.setText(cbbank.getcurnccode());
              jtxtCurDescription.setText(cbbank.getCurrencyDescription());
              jtxtcurnccode.setText(jtxtCurr.getText());
              jtxtcurnccode1.setText(jtxtCurr.getText());
          }

      } catch (CodeException ex) {
          ex.printStackTrace();
      }

}//GEN-LAST:event_jbtnBrowse1ActionPerformed

private void setDataPayh() throws CodeException {

    apph.fromString(Ap_payh.PROPERTY_DOCENTRY,jtxtdocentry.getText());
    apph.fromString(Ap_payh.PROPERTY_VENDCODE,jtxtvendcode.getText());

    apph.fromString(Ap_payh.PROPERTY_DOCENTRY,jtxtdocentry.getText());

    apph.fromString(Ap_payh.PROPERTY_DOCTYPE,GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));

    apph.fromString(Ap_payh.PROPERTY_NOREFF,jtxtdocnum.getText());

    apph.fromString(Ap_payh.PROPERTY_DSCRIPTION,jtxtdscription.getText());

    apph.fromString(Ap_payh.PROPERTY_DOCDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd"));
    apph.fromString(Ap_payh.PROPERTY_MOP, jcbMOP.getSelectedItem().toString()) ;
    apph.fromString(Ap_payh.PROPERTY_YOP, jcbYOP.getSelectedItem().toString()) ;

    apph.fromString(Ap_payh.PROPERTY_CURNCCODE,jtxtcurnccode.getText());
    //apph.fromString(Ap_payh.PROPERTY_DOCNUM,jtxtdocnum.getText());
    //cbhh.fromString(Ap_payh.PROPERTY_PAYOR,jtxtpayor.getText());
    apph.fromString(Ap_payh.PROPERTY_PAYCODE,jcmbpaycode.getSelectedItem().toString());

    apph.setdoctotalamt(GlobalUtils.toDbl(jtxtdoctotalamt.getText()));
    apph.setunapltotalamtc(GlobalUtils.toDbl(jtxtunapltotalamtc.getText()));

    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
        obj.adddetail(apph);
    } else {
        obj.replaceDetail(obj.getDtlslctdindx(), apph);
    }

    cekPrepayment();
    
}


private void cekPrepayment() throws CodeException {
   
    if (jcmbdoctype.getSelectedIndex() + 1 == 2) {

        Ap_payd appd;
        if (appds.size() == 0) {

            appd = new Ap_payd();
            appds.add(appd);

        }else{

            appd = (Ap_payd) appds.list().get(0);
        }
        appd.setlinenum(1);
        appd.setlinests(1);
        appd.setvendcode(jtxtvendcode.getText());
        appd.setdoctype(GlobalUtils.churuf(tmodeldetail.getValueAt(0, 1)));
        appd.setdocnum(jtxtdocnumapplto.getText());
        appd.fromString(Ap_payd.PROPERTY_PAYAMT, jtxtunapltotalamtc.getText().replace(",", ""));
        appd.settextajust("");
        appd.setglreff("");
        appd.setdocnumppd(jtxtpredocnum.getText());
        appd.setdocnummtch("");
        appd.setApplied("yes");

        appds.list().set(0, appd);
       
    }

}

private void setPayhEnable(boolean enable) {
    jtxtdocentry.setEnabled(enable);
    //jtxtjrnldesc.setEnabled(enable);
    //jtxtsrcelgrcode.setEnabled(enable);
}

public void showDataPayh() throws CodeException  {
    onload=true;
    if (apph.getID()>0){
        jcmbdoctype.setEnabled(false);
        if(obj.getbatchsts().equalsIgnoreCase("1")){jbtnRetrieve.setEnabled(false);};
        jcmbpaycode.setEnabled(false);
    } else {
        jcmbdoctype.setEnabled(true);
        jbtnRetrieve.setEnabled(true);
        jcmbpaycode.setEnabled(true);
    }
    jtxtdocnumapplto.setText("");
    jtxtpredocnum.setText("");

    jtxtdocentry.setText(GlobalUtils.churuf(apph.getdocentry()));
    jtxtvendcode.setText(apph.getvendcode());

    Ap_vendor arcust=new Ap_vendor(apph.getvendcode());
    jtxtvenddesc.setText(arcust.getvendname());

    jtxtdocnum.setText(apph.getnoreff());

    jtxtdscription.setText(apph.getdscription());

    try {
        kdateentrydate1.setDate(GlobalUtils.formatDate(apph.getdocdate(),"MM/dd/yyyy"));
    } catch (KazaoCalendarDateTimeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }
    mopbf=apph.getmop();
    yopbf=apph.getyop();
    String mop="";
    if (apph.getmop()<10){
        mop="0"+apph.getmop();
    } else {
        mop=apph.getmop()+"";
    }

    if (apph.getID()>0){
        jcbMOP.setSelectedItem(mop);
        jcbYOP.setSelectedItem((int)apph.getyop());
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
    
    jtxtcurnccode.setText(apph.getcurnccode());
    jtxtpayor.setText(apph.getpayor());
    jcmbpaycode.setSelectedItem(apph.getpaycode() == null ? 0 : apph.getpaycode());
    jtxtdoctotalamt.setText(GlobalUtils.formatnumber(apph.getdoctotalamt()));
    jtxtunapltotalamtc.setText(GlobalUtils.formatnumber(apph.getunapltotalamtc()));
    
    

    jcmbdoctype.setSelectedIndex(apph.getdoctype() == null ? 0 : GlobalUtils.toInt(GlobalUtils.churuf(apph.getdoctype()))-1);

    if (jcmbdoctype.getSelectedIndex()==1||jcmbdoctype.getSelectedIndex()==2){
        jPanel4.setVisible(true);
        jtblDetail.setVisible(false);
    } else {
        jPanel4.setVisible(false);
        jtblDetail.setVisible(true);
    }

    if (!GlobalUtils.churuf(apph.getdoctype()).equalsIgnoreCase("4")){
        appds = apph.getDetail();
    } else {
        appdmiscs = apph.getDetail2();
    }


    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
        jlbljrnldebit.setText("Index * of "+obj.getDetail().size());
    } else {
        jlbljrnldebit.setText("Index "+(obj.getDtlslctdindx()+1)+" of "+obj.getDetail().size());
    }


    try{
        if (jcmbdoctype.getSelectedIndex()==4){
            showDataPayd1();
        } else {
            showDataPayd();
        }
    }catch(Exception e){}

    onload=false;
}

public void showDataPayd() throws CodeException  {
        onload=true;
        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        GlobalModel.setColumnWidth(jtblDetail, 3, 0);
        GlobalModel.setColumnWidth(jtblDetail, 5, 0);
        GlobalModel.setColumnWidth(jtblDetail, 8, 0);

        posttable = -1;

        for(Object  o : appds.list()){
            Ap_payd appayd = (Ap_payd) o;

            tmodeldetail.setValueAt(appayd.getID(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

            if (appayd.getID()>0){
                tmodeldetail.setValueAt("Yes", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
            } else {
                tmodeldetail.setValueAt("No", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
            }
            

            Ap_invobl oarinvobl=new Ap_invobl(Ap_invobl.PROPERTY_DOCNUM, appayd.getdocnum());
            Ap_invh oarinvh=new Ap_invh(Ap_invh.PROPERTY_DOCNUM,appayd.getdocnum());

            tmodeldetail.setValueAt(appayd.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",
            tmodeldetail.setValueAt(appayd.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
            tmodeldetail.setValueAt(appayd.getPayAmount(), tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",

            tmodeldetail.setValueAt(appayd.getpayamt(), tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr()-appayd.getPayAmount(), tmodeldetail.getRowCount() - 1, 5);//5"Net Balance",


            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 6);//6"Current Balance",
            tmodeldetail.setValueAt(oarinvh.getdoctotalamt(), tmodeldetail.getRowCount() - 1, 7);//7"Original Amount",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 8);//8"Pending Amount",
            tmodeldetail.setValueAt(oarinvh.getpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
            tmodeldetail.setValueAt(oarinvh.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
            tmodeldetail.setValueAt(oarinvh.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
            tmodeldetail.setValueAt(oarinvh.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",

            if (apph.getdoctype().equalsIgnoreCase("2")||apph.getdoctype().equalsIgnoreCase("3")){
                jtxtdocnumapplto.setText(appayd.getdocnum());
                jtxtpredocnum.setText(appayd.getdocnumppd());
            }
            tmodeldetail.addRow(datadetail);
        }

        onload=false;

    }

public void showDataPayd1() throws CodeException  {
        onload=true;
        GlobalModel.clearRow(tmodeldetail1);
        tmodeldetail1.addRow(datadetail1);
        tmodeldetail1.setValueAt("0", tmodeldetail1.getRowCount() - 1, tmodeldetail1.getColumnCount()-1);
        tmodeldetail1.setValueAt(0, tmodeldetail1.getRowCount() - 1, 2);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;

        for(Object  o : appdmiscs.list()){
            Ap_paydmisc appaydimisc = (Ap_paydmisc) o;

            tmodeldetail1.setValueAt(appaydimisc.getID(), tmodeldetail1.getRowCount() - 1, tmodeldetail1.getColumnCount()-1);

            tmodeldetail1.setValueAt(appaydimisc.getdistcode(), tmodeldetail1.getRowCount() - 1, 0);//0"Apply",

            Ap_invobl oarinvobl=new Ap_invobl(Ap_invobl.PROPERTY_DOCNUM, "");
            Ap_invh oarinvh=new Ap_invh(Ap_invh.PROPERTY_DOCNUM,"");

            tmodeldetail1.setValueAt(appaydimisc.getacccode(), tmodeldetail1.getRowCount() - 1, 1);//2"Document Number",
            tmodeldetail1.setValueAt(appaydimisc.getdistrbamt(), tmodeldetail1.getRowCount() - 1, 2);//4"Applied Amount",
            tmodeldetail1.setValueAt(appaydimisc.getglreff(), tmodeldetail1.getRowCount() - 1, 3);//4"Applied Amount"
            tmodeldetail1.setValueAt(appaydimisc.getgldesc(), tmodeldetail1.getRowCount() - 1, 4);//4"Applied Amount"


            tmodeldetail1.addRow(datadetail1);
        }

        onload=false;

    }

private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed
    try{
        //if (validasibalance()){
        //if(!obj.getDetail().list().isEmpty()) {
        MOPChangedManually=false;
        jbtnMoveNext.setEnabled(false);
         jbtnMoveLast.setEnabled(false);
         jbtnDelete.setEnabled(false);

        setDataPayh();
        //}

        apph = new Ap_payh();

        try {
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);

        obj.setDtlslctdindx(obj.getDetail().size());


        setPayhEnable(true);
        jlbldocentry.setText("Doc Entry*");

        showDataPayh();

        jcmbdoctype.setSelectedIndex(0);
        jcmbpaycode.setSelectedIndex(0);

        apop = new Ap_optional(GlobalUtils.company);
        jcmbpaycode.setSelectedItem(apop.getpaycode().trim());
        //}
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
        setDataPayh();
        jlbldocentry.setText("Doc Entry");
        if (pos > 0){

            obj.setDtlslctdindx(0);
            apph = (Ap_payh) obj.getDetail().list().get(0);
            showDataPayh();
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
        setDataPayh();

        jlbldocentry.setText("Doc Entry");

        if (pos > 0){

            obj.setDtlslctdindx(pos-1);

            apph = (Ap_payh) obj.getDetail().list().get(pos - 1);
            showDataPayh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;
        setDataPayh();
        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size() - 1){

            obj.setDtlslctdindx((pos+1));

            apph = (Ap_payh) obj.getDetail().list().get(pos + 1);
            showDataPayh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;
        setDataPayh();

        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size()){

            obj.setDtlslctdindx(obj.getDetail().list().size()-1);

            apph = (Ap_payh) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
            showDataPayh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    // TODO add your handling code here:
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtdocentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{

            obj.removeDetail(obj.getDtlslctdindx());

            obj=new Ap_paybatchlist(obj.getID());
            showData();

        }catch(Exception e) {e.printStackTrace();}

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed
private void cekAppd(int row) throws CodeException {

    
    Ap_payd appd;
    if (row > appds.list().size() - 1) {
        appd = new Ap_payd();
        appds.add(appd);
    }else{
        appd = (Ap_payd) appds.list().get(row);
    }

    long idpayd = 0 ;
    try{
        idpayd = Long.parseLong(tmodeldetail.getValueAt(row, tmodeldetail.getColumnCount()-1)+"");
    }catch (Exception e){}

    appd.setID(idpayd);
    appd.setApplied(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0)));
    appd.setdocnumppd(jtxtpredocnum.getText());
    //tmodeldetail.setValueAt(oarinvh.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
    appd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,2)));//2"Document Number",
    appd.setpayamt(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row,4).toString())));//4"Applied Amount",
    appd.setentrydate(GlobalUtils.formatDate(kdateentrydate1.getDate(), "yyyy-MM-dd"));
    appd.setentrysts(0);

    appd.setdoctype(GlobalUtils.churuf(tmodeldetail.getValueAt(row,1)));
    appd.setvendcode(jtxtvendcode.getText());
    appds.list().set(row, appd);

    apph.setdoctype(GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));
    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=apph.getDetailAmt();

    }
    jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.getTotalPayAmount()+DetailAmt));
}

private void cekPayd1(int row,int col) throws CodeException {


    apph.fromString(Ap_payh.PROPERTY_DOCTYPE,GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));

    Ap_paydmisc appaydmisc;
    if (row > appdmiscs.list().size() - 1) {
        appaydmisc = new Ap_paydmisc();
        appdmiscs.add(appaydmisc);
    }else{
        appaydmisc = (Ap_paydmisc) appdmiscs.list().get(row);
    }

    long idpayd = 0 ;
    try{
        idpayd = Long.parseLong(tmodeldetail1.getValueAt(row, tmodeldetail1.getColumnCount()-1)+"");
    }catch (Exception e){}

    appaydmisc.setID(idpayd);


    appaydmisc.setdistcode(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,0)));//2"Document Number",
    appaydmisc.setacccode(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,1)));//3"Pending Balance",
    appaydmisc.setdistrbamt(GlobalUtils.toDbl(tmodeldetail1.getValueAt(row,2).toString()));//4"Applied Amount",
    appaydmisc.setglreff(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,3)));//5"Net Balance",
    appaydmisc.setgldesc(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,4)));//6"Current Balance",
    appaydmisc.setentrydate(GlobalUtils.formatDate(kdateentrydate1.getDate(), "yyyy-MM-dd"));
    appdmiscs.list().set(row, appaydmisc);

    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=apph.getDetailAmt();

    }
    //jtxtdoctotalamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount()+DetailAmt));
}

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange
    // TODO add your handling code here:
    // TODO add your handling code here:
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    try{

        if (!onload){
            //if(posttable != row) {
            if (col==0){
                calculateapplied(true);
            }
            
            if (col==4){
                tmodeldetail1.setValueAt("Yes", row, 0);
                checkEntryRow(row);
                calculateapplied(false);
            }

            if (row > -1) {
                cekAppd(row);
            }
            posttable = row;


            if(col == 2) {
                try{
                    Gl_account glacc = new Gl_account(tmodeldetail.getValueAt(row, col)+"");
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
                }catch(Exception e) {}
            }


        }
    }catch (Exception e){
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblDetailPropertyChange

private Double getnetbalance(Double saldo,Double applied){
    return saldo-applied;
}

private void checkEntryRow(int row) throws CodeException {
    if (row> -1 ) {

        String apply = "No";
        double pendingbalance = 0;
        double appliedamount = 0;
        double netbalance = 0;
        double currentbalance = 0;


        //1. Ambil dari baris 0
        apply = tmodeldetail.getValueAt(row, 0)+"";
        try{
            pendingbalance = Double.parseDouble(tmodeldetail.getValueAt(row, 3)+"");
        }catch (Exception e) {}
        try{
            appliedamount = Double.parseDouble(tmodeldetail.getValueAt(row, 4)+"");
        }catch (Exception e) {}
        try{
            netbalance = Double.parseDouble(tmodeldetail.getValueAt(row, 5)+"");
        }catch (Exception e) {}
        try{
            currentbalance = Double.parseDouble(tmodeldetail.getValueAt(row, 6)+"");
        }catch (Exception e) {}

        
        netbalance = currentbalance - pendingbalance - appliedamount;
        if(netbalance < 0 ) {
            appliedamount = appliedamount + netbalance;
            tmodeldetail.setValueAt(appliedamount, row, 4);
            netbalance = 0;
        }


        tmodeldetail.setValueAt(netbalance, row, 5);


        if (appliedamount == 0) {
            tmodeldetail.setValueAt("No", row, 0);
        }else{
            tmodeldetail.setValueAt("Yes", row, 0);
        }

        cekAppd(row);



    }

}

private void calculateapplied(Boolean auto){
    int i=0;
    Double awal=new Double(0);
    if (jcmbdoctype.getSelectedIndex()==4){
        for (i=0;i<jtblDetail1.getRowCount();i++){
            Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail1.getValueAt(i, 2)));
            awal=awal+jmlapp;
        }
    } else {
        for (i=0;i<jtblDetail.getRowCount();i++){
            if (auto){
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                if (!GlobalUtils.churuf(jtblDetail.getValueAt(i,0)).equalsIgnoreCase("no")){
                    Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                    
                    awal=awal+jmlapp;
                } 
            } else {
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                if (!GlobalUtils.churuf(jtblDetail.getValueAt(i,0)).equalsIgnoreCase("no")){
                    Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 4)));
                    
                    awal=awal+jmlapp;
                } 
            }
        }
    }

    jtxtunapltotalamtc.setText(GlobalUtils.formatnumber(awal));
    jtxtdoctotalamt.setText(GlobalUtils.formatnumber(awal));
}
private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    // TODO add your handling code here:
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (evt.getKeyCode()==evt.VK_ENTER){
        evt.consume();
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col){
            case 0:
                try {
                    Ap_distcodes brs = new Ap_distcodes();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Ap_distcode glacc = new Ap_distcode(tmodeldetail.getValueAt(row, 0)+"");
                    tmodeldetail.setValueAt(glacc.getglacccode(), row, 1);
                    tmodeldetail.setValueAt(glacc.getdscription(), row, 2);

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;


        }
    }


    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);
        GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);

    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
        evt.consume();

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{

                System.out.println(apph.getDetail().size() + "=====" + row + "======");

                apph.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail.removeRow(row);

            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            }

            try{
                jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotpayamt()));
                jtxtrcpentrcnt.setText(GlobalUtils.formatnumber(obj.getpayentrcnt()));
                showDataPayh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }
}//GEN-LAST:event_jtblDetailKeyPressed

private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
    // TODO add your handling code here:
    try {
        Ap_vendors brs = new Ap_vendors();
        FrmBrowseAPVendor bd = new FrmBrowseAPVendor(brs,false);
        bd.setFirstValue(jtxtvendcode);
        bd.setSecondValue(jtxtvenddesc);
        bd.setModal(true);
        bd.setVisible(true);

        Ap_vendor arcust=new Ap_vendor(jtxtvendcode.getText());
        jtxtcurnccode1.setText(arcust.getcurnccode());
        jtxtcurnccode.setText(arcust.getcurnccode());

    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse6ActionPerformed

private void jbtnBrowse7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse7ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowse7ActionPerformed

private void jbtnRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRetrieveActionPerformed
        FrmAp_paypopsearchdata obrowse;
        try {
            obrowse = new FrmAp_paypopsearchdata(this.apph);
            obrowse.setModal(true);
            obrowse.setVisible(true);

            Ap_invobls oar_invobss=new Ap_invobls();
            if (!obrowse.getTypes().equalsIgnoreCase("")){

                oar_invobss.searchData(jtxtvendcode.getText(),obrowse.getMode(),obrowse.getStartpono(),obrowse.getTypes(),obrowse.getSortby());
                GlobalModel.setColumnWidth(jtblDetail, 3, 100);
                GlobalModel.setColumnWidth(jtblDetail, 5, 100);

                int irow=jtblDetail.getRowCount()-1;
                for (Object o:oar_invobss.list()){
                    Ap_invobl oarinvobl=(Ap_invobl) o;

                    Ap_invh oarinvh=new Ap_invh(Ap_invh.PROPERTY_DOCNUM,oarinvobl.getdocnum());

                    Ap_payd appayd = new Ap_payd();
                    appayd.searchData(oarinvobl.getvendcode(), oarinvobl.getdocnum());

                    boolean bcek = false;
                    for (int i=0; i < tmodeldetail.getRowCount() -1 ;i++) {
                        if (
                                (jtxtvendcode.getText()).equals(oarinvobl.getvendcode())
                                &&
                                (tmodeldetail.getValueAt(i, 2)+"").equals(oarinvobl.getdocnum())

                                ){
                            bcek = true;
                            break;
                        }
                    }

                    if (!bcek) {

                        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

                        tmodeldetail.setValueAt(appayd.getID()==Ap_payd.NULLID ? "No" : "Pending", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
                        tmodeldetail.setValueAt(oarinvobl.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",
                        tmodeldetail.setValueAt(oarinvh.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
                        tmodeldetail.setValueAt(appayd.getPayAmount(), tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",
                        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
                        tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr()-appayd.getPayAmount(), tmodeldetail.getRowCount() - 1, 5);//5"Net Balance",
                        tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 6);//6"Current Balance",
                        tmodeldetail.setValueAt(oarinvh.getdoctotalamt(), tmodeldetail.getRowCount() - 1, 7);//7"Original Amount",
                        tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 8);//8"Pending Amount",
                        tmodeldetail.setValueAt(oarinvh.getpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
                        tmodeldetail.setValueAt(oarinvh.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
                        tmodeldetail.setValueAt(oarinvh.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
                        tmodeldetail.setValueAt(oarinvh.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",

                        cekAppd(irow);

                        irow++;

                        tmodeldetail.addRow(datadetail);
                    }



                }
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_jbtnRetrieveActionPerformed

private void jtxtdoctotalamtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdoctotalamtKeyReleased
    // TODO add your handling code here:
    jtxtdoctotalamt.setText(GlobalUtils.formatnumber(GlobalUtils.toDbl(jtxtdoctotalamt.getText())));
    jtxtdoctotalamt.setSelectionStart(jtxtdoctotalamt.getText().length());

    jtxtunapltotalamtc.setText(jtxtdoctotalamt.getText());

    Integer idoctype=jcmbdoctype.getSelectedIndex();
    if (idoctype.equals(2)){
            try {
                showinvoice("","");
            } catch (CodeException ex) {
                Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    if (jcmbDocType.getSelectedIndex()==1||jcmbDocType.getSelectedIndex()==3){
        calculateapplied(false);
    } else {
        calculateapplied(false);
    }

}//GEN-LAST:event_jtxtdoctotalamtKeyReleased

private void jbtnBrowse8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse8ActionPerformed
    // TODO add your handling code here:
    try {
        
        Ap_invobls brs = new Ap_invobls();
        FrmBrowseAp_invoblByVendor bd = new FrmBrowseAp_invoblByVendor(brs);
        bd.vendcode = jtxtvendcode.getText();
        bd.retrieveData();
        bd.setFirstValue(jtxtdocnumapplto);
        bd.setSecondValue(appddoctype);
        bd.setModal(true);
        bd.setVisible(true);
        
        showinvoice(jtxtdocnumapplto.getText(),appddoctype.getText());
        applyscreen();
    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse8ActionPerformed

private void showinvoice(String docnum, String doctype) throws CodeException{
    Ap_invh oarinvh=new Ap_invh(Ap_invh.PROPERTY_DOCNUM,docnum);
    Ap_invobl oarinvobl=new Ap_invobl(Ap_invobl.PROPERTY_DOCNUM, docnum);
    tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

    tmodeldetail.setValueAt("Yes", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
    tmodeldetail.setValueAt(doctype, tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
    tmodeldetail.setValueAt(oarinvh.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",
System.out.println("doctype:"+doctype+",model:"+tmodeldetail.getValueAt(tmodeldetail.getRowCount()-1, 1));
    if (jcmbdoctype.getSelectedIndex()==2){
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
    } else {
        tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",
        tmodeldetail.setValueAt(GlobalUtils.toDbl(jtxtdoctotalamt.getText()), tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
    }
    
    tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr()-GlobalUtils.toDbl(jtxtdoctotalamt.getText()), tmodeldetail.getRowCount() - 1, 5);//5"Net Balance",
    tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);//6"Current Balance",
    tmodeldetail.setValueAt(oarinvh.getdoctotalamt(), tmodeldetail.getRowCount() - 1, 7);//7"Original Amount",
    tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 8);//8"Pending Amount",
    tmodeldetail.setValueAt(oarinvh.getpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
    tmodeldetail.setValueAt(oarinvh.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
    tmodeldetail.setValueAt(oarinvh.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
    tmodeldetail.setValueAt(oarinvh.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",

    calculateapplied(true);
    cekAppd(tmodeldetail.getRowCount() - 1);

}
private void jbtnBrowse9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse9ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowse9ActionPerformed

private void applyscreen(){
    if (jcmbdoctype.getSelectedIndex()==1){
        jPanel4.setVisible(true);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        jlblpaycode4.setText("Prepayment Doc No.");
        jlblpaycode3.setVisible(true);
        jcmbDocType.setVisible(true);
        jlblpaycode2.setVisible(true);
        jtxtdocnumapplto.setVisible(true);
        jtxtpredocnum.setVisible(true);
        jbtnBrowse8.setVisible(true);
        jlblpaycode4.setVisible(true);

        jlblpaycode1.setVisible(true);
        jcmbpaycode.setVisible(true);
        jlblpayor.setVisible(true);
        jtxtpayor.setVisible(true);

        jlbldscription.setVisible(true);
        jtxtdscription.setVisible(true);
        jlblcustmrcode.setVisible(true);
        jtxtvendcode.setVisible(true);
        jbtnBrowse6.setVisible(true);
        jtxtvenddesc.setVisible(true);
    } else if (jcmbdoctype.getSelectedIndex()==2){
        jPanel4.setVisible(true);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        jlblpaycode4.setVisible(true);
        jlblpaycode4.setText("Unapplied Cash Doc. No.");
        jlblpaycode3.setVisible(false);
        jcmbDocType.setVisible(false);
        jlblpaycode2.setVisible(false);
        jtxtdocnumapplto.setVisible(false);
        jtxtpredocnum.setVisible(true);
        jbtnBrowse8.setVisible(false);

        jlblpaycode1.setVisible(true);
        jcmbpaycode.setVisible(true);
        jlblpayor.setVisible(true);
        jtxtpayor.setVisible(true);

        jlbldscription.setVisible(true);
        jtxtdscription.setVisible(true);
        jlblcustmrcode.setVisible(true);
        jtxtvendcode.setVisible(true);
        jbtnBrowse6.setVisible(true);
        jtxtvenddesc.setVisible(true);
    } else if (jcmbdoctype.getSelectedIndex()==4){
        jPanel4.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(true);

        jlblpaycode1.setVisible(true);
        jcmbpaycode.setVisible(true);
        jlblpayor.setVisible(true);
        jtxtpayor.setVisible(true);

        jlbldscription.setVisible(false);
        jtxtdscription.setVisible(false);
        jlblcustmrcode.setVisible(false);
        jtxtvendcode.setVisible(false);
        jbtnBrowse6.setVisible(false);
        jtxtvenddesc.setVisible(false);

        
    } else if (jcmbdoctype.getSelectedIndex()==3){
        jPanel4.setVisible(false);
        jScrollPane1.setVisible(true);
        jScrollPane2.setVisible(false);

        jlblpaycode1.setVisible(false);
        jcmbpaycode.setVisible(false);
        jlblpayor.setVisible(false);
        jtxtpayor.setVisible(false);

        jlbldscription.setVisible(true);
        jtxtdscription.setVisible(true);
        jlblcustmrcode.setVisible(true);
        jtxtvendcode.setVisible(true);
        jbtnBrowse6.setVisible(true);
        jtxtvenddesc.setVisible(true);

    } else {
        jPanel4.setVisible(false);
        jScrollPane1.setVisible(true);
        jScrollPane2.setVisible(false);

        jlblpaycode1.setVisible(true);
        jcmbpaycode.setVisible(true);
        jlblpayor.setVisible(true);
        jtxtpayor.setVisible(true);

        jlbldscription.setVisible(true);
        jtxtdscription.setVisible(true);
        jlblcustmrcode.setVisible(true);
        jtxtvendcode.setVisible(true);
        jbtnBrowse6.setVisible(true);
        jtxtvenddesc.setVisible(true);

    }
}
private void jcmbdoctypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbdoctypeItemStateChanged


    if (jcmbdoctype.getSelectedIndex() + 1 == 2) {
        jlblunapltotalamtc.setText("Prepayment Amount");
    }else {
        jlblunapltotalamtc.setText("Applied Amount");
    }

    applyscreen();
    try {
        if (!GlobalUtils.churuf(apph.getdoctype()).equalsIgnoreCase("4")) {
            appds = apph.getDetail();
        } else {
            appdmiscs = apph.getDetail2();
        }


    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }


    try{
        if (jcmbdoctype.getSelectedIndex()==4){
            showDataPayd1();
        } else {
            showDataPayd();
        }
    }catch(Exception e){}
    
}//GEN-LAST:event_jcmbdoctypeItemStateChanged

private void jtblDetail1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetail1PropertyChange
    // TODO add your handling code here:
    int row = jtblDetail1.getSelectedRow();
    int col = jtblDetail1.getSelectedColumn();


    try{

        if (!onload){
            //if(posttable != row) {
            if (col==2){
                calculateapplied(true);
            }

            if (row > -1) {
                cekPayd1(row,col);
            }
            posttable = row;


            if(col == 2) {
                try{
                    Gl_account glacc = new Gl_account(tmodeldetail1.getValueAt(row, col)+"");
                    tmodeldetail1.setValueAt(glacc.getaccdesc(), row, col+1);
                }catch(Exception e) {}
            }

            if (col == 3){
                double amount=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail1.getValueAt(row, 3)));

                apph.setdoctotalamt(apph.getDetailAmt());

            }
            //}
        }
    }catch (Exception e){
        e.printStackTrace();
    }

}//GEN-LAST:event_jtblDetail1PropertyChange

private void jtblDetail1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetail1KeyPressed
    // TODO add your handling code here:
    int row = jtblDetail1.getSelectedRow();
    int col = jtblDetail1.getSelectedColumn();

    if (evt.getKeyCode()==evt.VK_ENTER){
        evt.consume();
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col){
            case 0:
                try {
                    Gl_accounts brs = new Gl_accounts();
                    FrmBrowseAccountActive bd = new FrmBrowseAccountActive(tmodeldetail1, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Gl_account glacc = new Gl_account(tmodeldetail1.getValueAt(row, 0)+"");
                    tmodeldetail1.setValueAt(glacc.getacccode(), row, 0);
                    tmodeldetail1.setValueAt(glacc.getaccdesc(), row, 1);

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;


        }
    }


    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        tmodeldetail1.addRow(datadetail1);
        tmodeldetail1.setValueAt("0", tmodeldetail1.getRowCount() - 1, tmodeldetail1.getColumnCount()-1);
        tmodeldetail1.setValueAt(0, tmodeldetail1.getRowCount() - 1, 2);
        GlobalUtils.selectCellTable(jtblDetail1, tmodeldetail1.getRowCount() - 1, 0);

    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
        evt.consume();

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row+1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if ( iquestion == JOptionPane.YES_OPTION) {

            try{

                System.out.println(apph.getDetail().size() + "=====" + row + "======");

                apph.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail1.removeRow(row);

            if (row+1 < tmodeldetail1.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail1, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail1, tmodeldetail1.getRowCount()-1, 1);
            }

            try{
                jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotpayamt()));
                jtxtrcpentrcnt.setText(GlobalUtils.formatnumber(obj.getpayentrcnt()));
                showDataPayh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }
}//GEN-LAST:event_jtblDetail1KeyPressed

private void jbtnBrowse10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse10ActionPerformed
    // TODO add your handling code here:
    try {
      FrmAp_payremitto bd = new FrmAp_payremitto(apph);
      bd.setModal(true);
      bd.setVisible(true);

      jtxtpayor.setText(apph.getApremit().getremitname());

  } catch (CodeException ex) {
      ex.printStackTrace();
  }
}//GEN-LAST:event_jbtnBrowse10ActionPerformed

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed

      try {
	      Ap_paybatchlists brs = new Ap_paybatchlists();
	      FrmBrowse bd = new FrmBrowse(this, brs);
	      bd.setFirstValue(jtxtbatchno);
	      bd.setModal(true);
	      bd.setVisible(true);

              MOPChangedManually=true;
	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
      
}//GEN-LAST:event_jbtnBrowseActionPerformed

private void jtblDetailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetailMousePressed

    int row  = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();
    
    double appliedamount = 0;
    try{
        appliedamount = Double.parseDouble(tmodeldetail.getValueAt(row, 4)+"");
    }catch(Exception e) {}
    double netbalance = 0;
    try{
        netbalance = Double.parseDouble(tmodeldetail.getValueAt(row, 5)+"");
    }catch(Exception e) {}


    if (row > -1 && col == 0 && evt.getClickCount() == 2 && netbalance > 0) {
        
        if (col==0){
            if (GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0)).equalsIgnoreCase("Yes")){
                tmodeldetail.setValueAt(0, row, 4);
                tmodeldetail.setValueAt("No", row, 0);

            }else if(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0)).equalsIgnoreCase("No")) {
                tmodeldetail.setValueAt(appliedamount+netbalance, row, 4);
                tmodeldetail.setValueAt("Yes", row, 0);
            }
        }

        try{
            checkEntryRow(row);
            calculateapplied(false);
        }catch(Exception e){}

    }



}//GEN-LAST:event_jtblDetailMousePressed

private void jtxtunapltotalamtcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtunapltotalamtcKeyReleased

    jtxtdoctotalamt.setText(jtxtunapltotalamtc.getText());
}//GEN-LAST:event_jtxtunapltotalamtcKeyReleased

private void jtxtvendcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtvendcodeKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode()==evt.VK_ENTER){
        Ap_vendor arcust;
            try {
                arcust = new Ap_vendor(jtxtvendcode.getText());
                jtxtvendcode.setText(arcust.getvendcode());
                jtxtvenddesc.setText(arcust.getvendname());
                jtxtcurnccode1.setText(arcust.getcurnccode());
                jtxtcurnccode.setText(arcust.getcurnccode());
            } catch (CodeException ex) {
                Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
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

private void jtxtdocnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdocnumActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtdocnumActionPerformed

private void jtxtbatchnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtbatchnoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtbatchnoActionPerformed

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
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


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
                    new FrmAp_paybatchlist().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowse1;
    private javax.swing.JButton jbtnBrowse10;
    private javax.swing.JButton jbtnBrowse6;
    private javax.swing.JButton jbtnBrowse7;
    private javax.swing.JButton jbtnBrowse8;
    private javax.swing.JButton jbtnBrowse9;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JButton jbtnRetrieve;
    private javax.swing.JComboBox jcbMOP;
    private javax.swing.JComboBox jcbYOP;
    private javax.swing.JComboBox jcmbDocType;
    private javax.swing.JComboBox jcmbdoctype;
    private javax.swing.JComboBox jcmbpaycode;
    private javax.swing.JLabel jlblbankcode;
    private javax.swing.JLabel jlblbankcode1;
    private javax.swing.JLabel jlblbatchdate;
    private javax.swing.JLabel jlblbatchdesc;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JLabel jlblbatchsts;
    private javax.swing.JLabel jlblbatchtype;
    private javax.swing.JLabel jlblcustmrcode;
    private javax.swing.JLabel jlbldocdate;
    private javax.swing.JLabel jlbldocentry;
    private javax.swing.JLabel jlbldocnum;
    private javax.swing.JLabel jlbldoctotalamt;
    private javax.swing.JLabel jlbldoctype;
    private javax.swing.JLabel jlbldscription;
    private javax.swing.JLabel jlbljrnldebit;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblpaycode1;
    private javax.swing.JLabel jlblpaycode2;
    private javax.swing.JLabel jlblpaycode3;
    private javax.swing.JLabel jlblpaycode4;
    private javax.swing.JLabel jlblpayor;
    private javax.swing.JLabel jlblrcpentrcnt;
    private javax.swing.JLabel jlbltotrcpamt;
    private javax.swing.JLabel jlblunapltotalamtc;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JTable jtblDetail1;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtCurDescription;
    private javax.swing.JTextField jtxtCurr;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtbankcode;
    private javax.swing.JTextField jtxtbankname;
    private javax.swing.JTextField jtxtbatchdesc;
    private javax.swing.JTextField jtxtbatchno;
    private javax.swing.JTextField jtxtbatchsts;
    private javax.swing.JTextField jtxtbatchtype;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtcurnccode;
    private javax.swing.JTextField jtxtcurnccode1;
    private javax.swing.JTextField jtxtdocentry;
    private javax.swing.JTextField jtxtdocnum;
    private javax.swing.JTextField jtxtdocnumapplto;
    private javax.swing.JTextField jtxtdoctotalamt;
    private javax.swing.JTextField jtxtdscription;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtpayor;
    private javax.swing.JTextField jtxtpredocnum;
    private javax.swing.JTextField jtxtrcpentrcnt;
    private javax.swing.JTextField jtxttotrcpamt;
    private javax.swing.JTextField jtxtunapltotalamtc;
    private javax.swing.JTextField jtxtvendcode;
    private javax.swing.JTextField jtxtvenddesc;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate;
    private org.kazao.calendar.KazaoCalendarDate kdateentrydate1;
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
        obj = new Ap_paybatchlist(this.jtxtbatchno.getText());
        showData();
        mf.setIcon(CLASSNAME);

    }
    public void newData() throws CodeException {
        obj = new Ap_paybatchlist();
        MOPChangedManually=false;
        istatus=1;
        showData();
        try {
            kdateentrydate.setDate(GlobalUtils.sessiondate);
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
        
        jlbldocentry.setText("Doc Entry*");
        
        apop = new Ap_optional(GlobalUtils.company);
        jtxtbankcode.setText(apop.getbankcode());

        Cb_bank cbbank=new Cb_bank(apop.getbankcode());
        jtxtbankname.setText(cbbank.getbankname());
        jtxtCurr.setText(cbbank.getcurnccode());

        Gl_currency glcur=new Gl_currency(cbbank.getcurnccode());
        jtxtCurDescription.setText(glcur.getcurncdesc());

        jcmbdoctype.setSelectedIndex(0);

        jcmbpaycode.setSelectedItem(apop.getpaycode().trim());
        setToolBar(iformtype,istatus);
    }

    private Boolean validatebank(String bankcode){
        Cb_bank cbbank;
        try {
            cbbank = new Cb_bank(bankcode);
            if (cbbank.getID()>0){
                return true;
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void saveData() throws CodeException {
        if (validatebank(jtxtbankcode.getText())){
            if (jcmbpaycode.getSelectedIndex()>-1){
                istatus = 0;
                setData();

                setDataPayh();

                obj.save();
                jlbldocentry.setText("Doc Entry");
                showData();

                mf.setIcon(CLASSNAME);
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Payment Code");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Correct Bank Code");
        }
    }

    public void setAp_paybatchlist(Ap_paybatchlist obj){
        this.obj=obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buttonEnable(boolean val){
         this.mf.btnSave.setEnabled(val);
         this.mf.btnDel.setEnabled(val);
         this.mf.btnConfirm.setEnabled(val);
         jtbnNew.setEnabled(val);
         jbtnDelete.setEnabled(val);
    }
    
    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
             jtxtid.setText(obj.toString(Ap_paybatchlist.PROPERTY_ID));
             jtxtbatchno.setText(obj.toString(Ap_paybatchlist.PROPERTY_BATCHNO));
             try {
                kdateentrydate.setDate(GlobalUtils.formatDate(obj.getbatchdate(),"MM/dd/yyyy"));
            } catch (KazaoCalendarDateTimeException ex) {
                Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
             jtxtbatchdesc.setText(obj.toString(Ap_paybatchlist.PROPERTY_BATCHDESC));
             jtxtbatchtype.setText(obj.gettypedescription());
             jtxtbatchsts.setText(obj.getstatusdescription());
             jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotpayamt()));
             jtxtrcpentrcnt.setText(obj.toString(Ap_paybatchlist.PROPERTY_PAYENTRCNT));

             jtxtbankcode.setText(obj.toString(Ap_paybatchlist.PROPERTY_BANKCODE));

             Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
             jtxtbankname.setText(cbbank.getbankname());
             jtxtCurr.setText(cbbank.getcurnccode());
             jtxtCurDescription.setText(cbbank.getCurrencyDescription());
             jtxtcurnccode.setText(cbbank.getcurnccode());
             jtxtcurnccode1.setText(cbbank.getcurnccode());
             
             if (obj.getID()>0){
                 jtxtbankcode.setEditable(false);
                 jbtnBrowse1.setEnabled(false);
             } else {
                 jtxtbankcode.setEditable(true);
                 jbtnBrowse1.setEnabled(true);
             }
             jtxtentrydate.setText(obj.toString(Ap_paybatchlist.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Ap_paybatchlist.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Ap_paybatchlist.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Ap_paybatchlist.PROPERTY_CMPNYID));


            
             if (obj.getDetail().list().isEmpty()) {
                 obj.setDtlslctdindx(-1);
                 setPayhEnable(false);
                 apph = new Ap_payh();
             }else{
                obj.setDtlslctdindx(obj.getDetail().size()-1);
                apph = (Ap_payh) obj.getDetail().list().get(obj.getDetail().size()-1);
                setPayhEnable(true);
              }
             showDataPayh();

        setCursor(GlobalUtils.NORMALCURSOR);

        if(obj.getbatchsts()!=null){
            if (obj.getbatchsts().equals("2") ){
                buttonEnable(false);
            }else{
                buttonEnable(true);
            }
        } else {
            buttonEnable(true);
        }
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        if (obj.getID()==0){
            obj=new Ap_paybatchlist();
        }
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Ap_paybatchlist.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd")) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_BATCHDESC, jtxtbatchdesc.getText()) ;

          if (obj.getID()==0){
              obj.fromString(Ap_paybatchlist.PROPERTY_BATCHTYPE, "1") ;
           }
          obj.settotpayamt(GlobalUtils.toDbl(jtxttotrcpamt.getText()));
          obj.setpayentrcnt(GlobalUtils.toDbl(jtxtrcpentrcnt.getText()).longValue()) ;

          if ( obj.getID() == Ap_paybatchlist.NULLID) {
            obj.setreadytpost("0");
          }
          obj.setcurnccode(jtxtCurr.getText());
          


          obj.fromString(Ap_paybatchlist.PROPERTY_BANKCODE, jtxtbankcode.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText()) ;
          obj.fromString(Ap_paybatchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText()) ;



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
        fp.jcmblistingfor.setSelectedIndex(1);
        fp.setVisible(true);
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

    public void setap_paybatchlist(Ap_paybatchlist o){
        this.obj=o;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_paybatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
