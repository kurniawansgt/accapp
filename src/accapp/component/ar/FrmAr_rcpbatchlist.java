/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import test.FrmAr_rcpbatchlist;
 * 
 * .......
 * 
 * 
 * FrmAr_rcpbatchlist frmAr_rcpbatchlist;
 * 
 * .......
 * 
 try {
        if (frmAr_rcpbatchlist == null) {
            frmmAr_rcpbatchlist = new FrmAr_rcpbatchlist(this);
        }
        
        showForm(frmAr_rcpbatchlist);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.ar;

import accapp.component.browse.FrmBrowseAccountActive;
import accapp.component.gl.FrmGl_batchlist;
import accapp.objectclasses.ar.Ar_customer;
import accapp.objectclasses.ar.Ar_customers;
import accapp.objectclasses.ar.Ar_distcode;
import accapp.objectclasses.ar.Ar_distcodes;
import accapp.objectclasses.ar.Ar_invobl;
import accapp.objectclasses.ar.Ar_invobls;
import accapp.objectclasses.ar.Ar_invh;
import accapp.objectclasses.ar.Ar_optional;
import accapp.objectclasses.ar.Ar_rcpd;
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
import accapp.objectclasses.ar.Ar_rcpbatchlist;
import accapp.objectclasses.ar.Ar_rcpbatchlists;
import accapp.objectclasses.ar.Ar_rcpdmisc;
import accapp.objectclasses.ar.Ar_rcpdmiscs;
import accapp.objectclasses.ar.Ar_rcpds;
import accapp.objectclasses.ar.Ar_rcph;
import accapp.objectclasses.cashbook.Cb_bank;
import accapp.objectclasses.cashbook.Cb_banks;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_fiscalh;
import common.tablemodels.GlobalModel;
import common.utils.selectallJTable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.kazao.calendar.KazaoCalendar;
import org.kazao.calendar.KazaoCalendarAdapter;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author  Generator
 */

public class FrmAr_rcpbatchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmAr_rcpbatchlist";
    
    FrmMainFrame mf ;
    
    
    public Ar_rcpbatchlist obj = new Ar_rcpbatchlist();

    Ar_rcph cbhh = new Ar_rcph();
    Ar_rcpds cbhds = new Ar_rcpds();
    Ar_rcpdmiscs cbhdmiscs = new Ar_rcpdmiscs();
    Ar_optional arop=null;

    Object[] datadetail;
    DefaultTableModel tmodeldetail;

    Object[] datadetail1;
    DefaultTableModel tmodeldetail1;


    int posttable = 0;
    long mopbf=0;
    long yopbf=0;

    Boolean MOPChangedManually=false;

    boolean onload = false;

   
    /** Creates new form Area */
    public FrmAr_rcpbatchlist() throws CodeException {
        initComponents();
    }
    
    public FrmAr_rcpbatchlist(FrmMainFrame mf) throws CodeException{
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

        TableColumn bonuscolumn = jtblDetail.getColumnModel().getColumn(0);
        String[] petStrings = { "Yes", "No", "Pending"};
        JComboBox comboBox = new JComboBox(petStrings);
        comboBox.addItemListener(new MyItemListener(this));
        bonuscolumn.setCellEditor(new DefaultCellEditor(comboBox));
    }

    class MyItemListener implements ItemListener {
    // This method is called only if a new item has been selected.
    FrmAr_rcpbatchlist iframe;
    public MyItemListener (FrmAr_rcpbatchlist iframe){
        this.iframe=iframe;

    }
    public void itemStateChanged(ItemEvent evt) {
        JComboBox cb = (JComboBox)evt.getSource();

        // Get the affected item
        Object item = evt.getItem();

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Item was just selected
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            // Item is no longer selected
            if (cb.getSelectedItem().equals("Yes")){
                doapplly(true);
            } else {
                doapplly(false);
            }
            calculateapplied(false);
        }

        
    }
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
        jtxtNomorDeposit = new javax.swing.JTextField();
        jtxtDepostSlipPrinted = new javax.swing.JTextField();
        jlblbankcode2 = new javax.swing.JLabel();
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
        jtxtcustmrdesc = new javax.swing.JTextField();
        jlbldocdate = new javax.swing.JLabel();
        jlblyop = new javax.swing.JLabel();
        jlblmop = new javax.swing.JLabel();
        jlblpayor = new javax.swing.JLabel();
        jtxtpayor = new javax.swing.JTextField();
        jlblunapltotalamtc = new javax.swing.JLabel();
        jtxtunapltotalamtc = new javax.swing.JTextField();
        jtxtcustmrcode = new javax.swing.JTextField();
        jtxtcurnccode1 = new javax.swing.JTextField();
        jcbYOP = new javax.swing.JComboBox();
        jcbMOP = new javax.swing.JComboBox();
        jbtnBrowse6Customer = new javax.swing.JButton();
        jcmbdoctype = new javax.swing.JComboBox();
        jbtnBrowse7 = new javax.swing.JButton();
        kdateentrydate1 = new org.kazao.calendar.KazaoCalendarDate();
        jcmbpaycode = new javax.swing.JComboBox();
        jlblpaycode1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AR Receipt Entry");
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
        jHeader.setText(" : : AR Receipt Entry");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 130, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 730, 2);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 2, 400);

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(260, 80, 30, 17);

        jtxtid.setEditable(false);
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(350, 30, 80, 17);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchno.setText("Batch Number");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(70, 80, 140, 13);

        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchno.setText("batchno");
        jtxtbatchno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchnoKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(170, 80, 80, 17);

        jlblbatchdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdate.setText("Batch Date");
        getContentPane().add(jlblbatchdate);
        jlblbatchdate.setBounds(70, 100, 140, 13);

        jlblbatchdesc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchdesc.setText("Description");
        getContentPane().add(jlblbatchdesc);
        jlblbatchdesc.setBounds(70, 120, 140, 13);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchdesc.setText("batchdesc");
        jtxtbatchdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchdescKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(170, 120, 360, 17);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(430, 30, 80, 17);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(510, 30, 80, 17);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(590, 30, 80, 17);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(670, 30, 80, 17);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(null);

        jlblrcpentrcnt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblrcpentrcnt.setText("Total Entries");
        jPanel1.add(jlblrcpentrcnt);
        jlblrcpentrcnt.setBounds(10, 10, 90, 13);

        jtxtrcpentrcnt.setEditable(false);
        jtxtrcpentrcnt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtrcpentrcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtrcpentrcnt.setText("rcpentrcnt");
        jPanel1.add(jtxtrcpentrcnt);
        jtxtrcpentrcnt.setBounds(130, 10, 130, 17);

        jlbltotrcpamt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbltotrcpamt.setText("Batch Total");
        jPanel1.add(jlbltotrcpamt);
        jlbltotrcpamt.setBounds(10, 30, 90, 13);

        jtxttotrcpamt.setEditable(false);
        jtxttotrcpamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxttotrcpamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxttotrcpamt.setText("totrcpamt");
        jPanel1.add(jtxttotrcpamt);
        jtxttotrcpamt.setBounds(130, 30, 130, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(610, 70, 270, 70);

        kdateentrydate.setFont(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate.setFontDate(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdateentrydateKeyPressed(evt);
            }
        });
        getContentPane().add(kdateentrydate);
        kdateentrydate.setBounds(170, 100, 100, 20);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 10));

        jPanel2.setLayout(null);

        jlblbatchtype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchtype.setText("Type");
        jPanel2.add(jlblbatchtype);
        jlblbatchtype.setBounds(330, 20, 70, 13);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchtype.setText("batchtype");
        jPanel2.add(jtxtbatchtype);
        jtxtbatchtype.setBounds(400, 20, 160, 17);

        jlblbatchsts.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbatchsts.setText("Status");
        jPanel2.add(jlblbatchsts);
        jlblbatchsts.setBounds(10, 20, 140, 13);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbatchsts.setText("batchsts");
        jPanel2.add(jtxtbatchsts);
        jtxtbatchsts.setBounds(200, 20, 120, 17);

        jlblbankcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbankcode.setText("Deposit No");
        jPanel2.add(jlblbankcode);
        jlblbankcode.setBounds(10, 80, 140, 13);

        jtxtbankcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbankcode.setText("bankcode");
        jtxtbankcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbankcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtbankcode);
        jtxtbankcode.setBounds(200, 50, 80, 17);

        jbtnBrowse1.setText("...");
        jbtnBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse1);
        jbtnBrowse1.setBounds(290, 50, 30, 17);

        jtxtbankname.setEditable(false);
        jtxtbankname.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtbankname.setText("bankcode");
        jPanel2.add(jtxtbankname);
        jtxtbankname.setBounds(330, 50, 360, 17);

        jlblbankcode1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbankcode1.setText("Bank Code");
        jPanel2.add(jlblbankcode1);
        jlblbankcode1.setBounds(10, 50, 140, 13);

        jtxtNomorDeposit.setEditable(false);
        jtxtNomorDeposit.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtNomorDeposit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtNomorDeposit.setText("NomorDeposit");
        jPanel2.add(jtxtNomorDeposit);
        jtxtNomorDeposit.setBounds(200, 80, 120, 17);

        jtxtDepostSlipPrinted.setEditable(false);
        jtxtDepostSlipPrinted.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtDepostSlipPrinted.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtDepostSlipPrinted.setText("jtxtDepostSlipPrinted");
        jPanel2.add(jtxtDepostSlipPrinted);
        jtxtDepostSlipPrinted.setBounds(520, 80, 120, 17);

        jlblbankcode2.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblbankcode2.setText("Deposit Slip Printed");
        jPanel2.add(jlblbankcode2);
        jlblbankcode2.setBounds(330, 80, 140, 13);

        jTabbedPane1.addTab("Batch Info", jPanel2);

        jPanel3.setLayout(null);

        jtbnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_newfile.gif"))); // NOI18N
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jPanel3.add(jtbnNew);
        jtbnNew.setBounds(220, 10, 40, 30);

        jbtnMoveFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_first.gif"))); // NOI18N
        jbtnMoveFirst.setToolTipText("First Entry");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(300, 10, 40, 30);

        jbtnMovePrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_prev.gif"))); // NOI18N
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(340, 10, 40, 30);

        jbtnMoveNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_next.gif"))); // NOI18N
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(380, 10, 40, 30);

        jbtnMoveLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_move_last.gif"))); // NOI18N
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveLastActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnMoveLast);
        jbtnMoveLast.setBounds(420, 10, 40, 30);

        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_del.gif"))); // NOI18N
        jbtnDelete.setToolTipText("Delete Entry");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnDelete);
        jbtnDelete.setBounds(260, 10, 40, 30);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbljrnldebit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbljrnldebit.setText("Index 1 of 100");
        jPanel3.add(jlbljrnldebit);
        jlbljrnldebit.setBounds(590, 10, 140, 13);

        jlbldocentry.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocentry.setText("Entry");
        jPanel3.add(jlbldocentry);
        jlbldocentry.setBounds(10, 50, 140, 13);

        jtxtdocentry.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocentry.setText("docentry");
        jtxtdocentry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocentryKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtdocentry);
        jtxtdocentry.setBounds(140, 50, 80, 17);

        jlbldscription.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldscription.setText("Description");
        jPanel3.add(jlbldscription);
        jlbldscription.setBounds(310, 50, 80, 13);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdscription.setText("dscription");
        jtxtdscription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdscriptionKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtdscription);
        jtxtdscription.setBounds(390, 50, 330, 17);

        jlbldoctype.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldoctype.setText("Trans Type");
        jPanel3.add(jlbldoctype);
        jlbldoctype.setBounds(10, 70, 130, 13);

        jlbldoctotalamt.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldoctotalamt.setText("Amount");
        jPanel3.add(jlbldoctotalamt);
        jlbldoctotalamt.setBounds(10, 90, 130, 13);

        jtxtdoctotalamt.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdoctotalamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotalamt.setText("doctotalamt");
        jtxtdoctotalamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdoctotalamtKeyReleased(evt);
            }
        });
        jPanel3.add(jtxtdoctotalamt);
        jtxtdoctotalamt.setBounds(140, 90, 110, 17);

        jlbldocnum.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocnum.setText("Check/Receipt No.");
        jPanel3.add(jlbldocnum);
        jlbldocnum.setBounds(10, 110, 130, 13);

        jtxtdocnum.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocnum.setText("docnum");
        jtxtdocnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocnumKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtdocnum);
        jtxtdocnum.setBounds(140, 110, 110, 17);

        jtxtcurnccode.setEditable(false);
        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcurnccode.setText("curnccode");
        jPanel3.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(650, 130, 70, 17);

        jlblcustmrcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblcustmrcode.setText("Cust. No");
        jPanel3.add(jlblcustmrcode);
        jlblcustmrcode.setBounds(310, 70, 80, 13);

        jtxtcustmrdesc.setEditable(false);
        jtxtcustmrdesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcustmrdesc.setText("jtxtcustmrdesc");
        jPanel3.add(jtxtcustmrdesc);
        jtxtcustmrdesc.setBounds(490, 70, 230, 17);

        jlbldocdate.setFont(new java.awt.Font("Dialog", 1, 10));
        jlbldocdate.setText("Date");
        jPanel3.add(jlbldocdate);
        jlbldocdate.setBounds(310, 90, 50, 13);

        jlblyop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblyop.setText("Year");
        jPanel3.add(jlblyop);
        jlblyop.setBounds(510, 90, 40, 13);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblmop.setText("Periode");
        jPanel3.add(jlblmop);
        jlblmop.setBounds(620, 90, 50, 13);

        jlblpayor.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpayor.setText("Payer");
        jPanel3.add(jlblpayor);
        jlblpayor.setBounds(310, 110, 140, 13);

        jtxtpayor.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtpayor.setText("payor");
        jtxtpayor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtpayorKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtpayor);
        jtxtpayor.setBounds(390, 110, 330, 17);

        jlblunapltotalamtc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblunapltotalamtc.setText("Unapplied Amount");
        jPanel3.add(jlblunapltotalamtc);
        jlblunapltotalamtc.setBounds(310, 130, 140, 13);

        jtxtunapltotalamtc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtunapltotalamtc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtunapltotalamtcKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtunapltotalamtc);
        jtxtunapltotalamtc.setBounds(480, 130, 170, 17);

        jtxtcustmrcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcustmrcode.setText("custmrcode");
        jtxtcustmrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcustmrcodeKeyPressed(evt);
            }
        });
        jPanel3.add(jtxtcustmrcode);
        jtxtcustmrcode.setBounds(390, 70, 80, 17);

        jtxtcurnccode1.setEditable(false);
        jtxtcurnccode1.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtcurnccode1.setText("curnccode");
        jPanel3.add(jtxtcurnccode1);
        jtxtcurnccode1.setBounds(250, 90, 50, 17);

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
        jcbYOP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbYOPKeyPressed(evt);
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
        jcbMOP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbMOPKeyPressed(evt);
            }
        });
        jPanel3.add(jcbMOP);
        jcbMOP.setBounds(670, 90, 50, 20);

        jbtnBrowse6Customer.setText("...");
        jbtnBrowse6Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6CustomerActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse6Customer);
        jbtnBrowse6Customer.setBounds(470, 70, 20, 17);

        jcmbdoctype.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbdoctype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Receipt", "Prepayment", "Unapplied Cash", "Apply Document", "Misc Receipt" }));
        jcmbdoctype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbdoctypeKeyPressed(evt);
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

        kdateentrydate1.setFontDate(new java.awt.Font("Dialog", 0, 10));
        kdateentrydate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdateentrydate1KeyPressed(evt);
            }
        });
        jPanel3.add(kdateentrydate1);
        kdateentrydate1.setBounds(390, 90, 100, 20);

        jcmbpaycode.setFont(new java.awt.Font("Dialog", 0, 10));
        jcmbpaycode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Check" }));
        jcmbpaycode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbpaycodeKeyPressed(evt);
            }
        });
        jPanel3.add(jcmbpaycode);
        jcmbpaycode.setBounds(140, 130, 110, 20);

        jlblpaycode1.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode1.setText("Receipt Type");
        jPanel3.add(jlblpaycode1);
        jlblpaycode1.setBounds(10, 130, 130, 13);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 10));
        jButton1.setText("Retrieve Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(470, 10, 120, 30);

        jPanel4.setLayout(null);

        jlblpaycode2.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode2.setText("Apply Prepayment To");
        jPanel4.add(jlblpaycode2);
        jlblpaycode2.setBounds(300, 0, 160, 13);

        jlblpaycode3.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblpaycode3.setText("Document Type");
        jPanel4.add(jlblpaycode3);
        jlblpaycode3.setBounds(0, 0, 130, 13);

        jtxtdocnumapplto.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtdocnumapplto.setText("jtxtdocnumapplto");
        jtxtdocnumapplto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocnumappltoKeyPressed(evt);
            }
        });
        jPanel4.add(jtxtdocnumapplto);
        jtxtdocnumapplto.setBounds(470, 0, 170, 17);

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
        jlblpaycode4.setBounds(170, 50, 160, 13);

        jtxtpredocnum.setText("jtxtpredocnum");
        jPanel4.add(jtxtpredocnum);
        jtxtpredocnum.setBounds(340, 50, 170, 19);

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
        jcmbDocType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbDocTypeKeyPressed(evt);
            }
        });
        jPanel4.add(jcmbDocType);
        jcmbDocType.setBounds(130, 0, 103, 22);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 160, 790, 153);

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
                true, true, false, true, true, true, true, true, true, true, true, true, true, false
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblDetailKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtblDetail);
        jtblDetail.getColumnModel().getColumn(0).setMinWidth(150);
        jtblDetail.getColumnModel().getColumn(1).setMinWidth(200);
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
        jScrollPane1.setBounds(10, 160, 790, 153);

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

        jTabbedPane1.addTab("Entry Info", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(70, 150, 820, 370);

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

      } catch (CodeException ex) {
          ex.printStackTrace();
      }

}//GEN-LAST:event_jbtnBrowse1ActionPerformed

private void setDataCbhh() throws CodeException {

    cbhh.fromString(Ar_rcph.PROPERTY_DOCENTRY,jtxtdocentry.getText());
    cbhh.fromString(Ar_rcph.PROPERTY_CUSTMRCODE,jtxtcustmrcode.getText());

    cbhh.fromString(Ar_rcph.PROPERTY_DOCENTRY,jtxtdocentry.getText());

    cbhh.fromString(Ar_rcph.PROPERTY_DOCTYPE,GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));

    cbhh.fromString(Ar_rcph.PROPERTY_DOCNUM,jtxtdocnum.getText());

    cbhh.fromString(Ar_rcph.PROPERTY_DSCRIPTION,jtxtdscription.getText());

    cbhh.fromString(Ar_rcph.PROPERTY_DOCDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd"));
    cbhh.fromString(Ar_rcph.PROPERTY_MOP, jcbMOP.getSelectedItem().toString()) ;
    cbhh.fromString(Ar_rcph.PROPERTY_YOP, jcbYOP.getSelectedItem().toString()) ;

    cbhh.fromString(Ar_rcph.PROPERTY_CURNCCODE,jtxtcurnccode.getText());
    cbhh.fromString(Ar_rcph.PROPERTY_DOCNUM,jtxtdocnum.getText());
    cbhh.fromString(Ar_rcph.PROPERTY_PAYOR,jtxtpayor.getText());
    cbhh.fromString(Ar_rcph.PROPERTY_PAYCODE,jcmbpaycode.getSelectedItem().toString());

    cbhh.setdoctotalamt(GlobalUtils.toDbl(jtxtdoctotalamt.getText()));
    cbhh.setunapltotalamtc(GlobalUtils.toDbl(jtxtunapltotalamtc.getText()));

    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
        obj.adddetail(cbhh);
    } else {
        obj.replaceDetail(obj.getDtlslctdindx(), cbhh);
    }

}

private void setCbhhEnable(boolean enable) {
    jtxtdocentry.setEnabled(enable);
    //jtxtjrnldesc.setEnabled(enable);
    //jtxtsrcelgrcode.setEnabled(enable);
}

public void showDataCbhh() throws CodeException  {

    onload=true;
    //System.out.println(cbhh.getID() + "   " + cbhh.getdscription());

    if (cbhh.getID()>0){
        jcmbdoctype.setEnabled(false);
        if(obj.getbatchsts().equalsIgnoreCase("2")){jButton1.setEnabled(false);};
        jcmbpaycode.setEnabled(false);
    } else {
        jcmbdoctype.setEnabled(true);
        jButton1.setEnabled(true);
        jcmbpaycode.setEnabled(true);
    }
    jtxtdocnumapplto.setText("");
    jtxtpredocnum.setText("");

    jtxtdocentry.setText(GlobalUtils.churuf(cbhh.getdocentry()));
    jtxtcustmrcode.setText(cbhh.getcustmrcode());

    Ar_customer arcust=new Ar_customer(cbhh.getcustmrcode());
    jtxtcustmrdesc.setText(arcust.getcustmrname());

    jtxtdocnum.setText(cbhh.getdocnum());

    jtxtdscription.setText(cbhh.getdscription());

    try {
        kdateentrydate.setDate(GlobalUtils.formatDate(cbhh.getdocdate(),"MM/dd/yyyy"));
    } catch (KazaoCalendarDateTimeException ex) {
        Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

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
        jcbYOP.setSelectedItem((int)cbhh.getyop());
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
    
    jtxtcurnccode.setText(cbhh.getcurnccode());
    jtxtpayor.setText(cbhh.getpayor());
    jcmbpaycode.setSelectedItem(cbhh.getpaycode());
    jtxtdoctotalamt.setText(GlobalUtils.formatnumber(cbhh.getdoctotalamt()));
    jtxtunapltotalamtc.setText(GlobalUtils.formatnumber(cbhh.getunapltotalamtc()));
    jcmbdoctype.setSelectedIndex(GlobalUtils.toInt(GlobalUtils.churuf(cbhh.getdoctype()))-1);
    if (jcmbdoctype.getSelectedIndex()==1||jcmbdoctype.getSelectedIndex()==2){
        jPanel4.setVisible(true);
        jtblDetail.setVisible(false);
    } else {
        jPanel4.setVisible(false);
        jtblDetail.setVisible(true);
    }

    if (!GlobalUtils.churuf(cbhh.getdoctype()).equalsIgnoreCase("2")){
        cbhds = cbhh.getDetail();
    } else {
        cbhdmiscs = cbhh.getDetail2();
    }

    if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")){
        jlbljrnldebit.setText("Index * of "+obj.getDetail().size());
    } else {
        jlbljrnldebit.setText("Index "+(obj.getDtlslctdindx()+1)+" of "+obj.getDetail().size());
    }

    try{
        if (jcmbdoctype.getSelectedIndex()==4){
            showDataCbhd1();
        } else {
            showDataCbhd();
        }
    }catch(Exception e){}

    onload=false;
}

public void showDataCbhd() throws CodeException  {
        onload=true;
        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 3);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;

        for(Object  o : cbhds.list()){
            Ar_rcpd cbhd = (Ar_rcpd) o;

            tmodeldetail.setValueAt(cbhd.getID(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

            

            tmodeldetail.setValueAt(cbhd.getApplied(), tmodeldetail.getRowCount() - 1, 0);//0"Apply",
            Ar_invobl oarinvobl=new Ar_invobl(Ar_invobl.PROPERTY_DOCNUM, cbhd.getdocnum());
            
            tmodeldetail.setValueAt(cbhd.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",
            tmodeldetail.setValueAt(oarinvobl.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",

            tmodeldetail.setValueAt(cbhd.getpayamt(), tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr()-cbhd.getpayamt(), tmodeldetail.getRowCount() - 1, 5);//5"Net Balance",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 6);//6"Current Balance",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamt(), tmodeldetail.getRowCount() - 1, 7);//7"Original Amount",
            tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 8);//8"Pending Amount",
            tmodeldetail.setValueAt(oarinvobl.getcustmrpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
            tmodeldetail.setValueAt(oarinvobl.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
            tmodeldetail.setValueAt(oarinvobl.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
            tmodeldetail.setValueAt(oarinvobl.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",

            if (cbhh.getdoctype().equalsIgnoreCase("2")||cbhh.getdoctype().equalsIgnoreCase("3")){
                jtxtdocnumapplto.setText(cbhd.getdocnumppd());
                jtxtpredocnum.setText(cbhd.getdocnum());
            }
            tmodeldetail.addRow(datadetail);
        }

        onload=false;

    }

public void showDataCbhd1() throws CodeException  {
        onload=true;
        GlobalModel.clearRow(tmodeldetail1);
        tmodeldetail1.addRow(datadetail1);
        tmodeldetail1.setValueAt("0", tmodeldetail1.getRowCount() - 1, tmodeldetail1.getColumnCount()-1);
        tmodeldetail1.setValueAt(0, tmodeldetail1.getRowCount() - 1, 2);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;

        for(Object  o : cbhdmiscs.list()){
            Ar_rcpdmisc cbhd = (Ar_rcpdmisc) o;

            tmodeldetail1.setValueAt(cbhd.getID(), tmodeldetail1.getRowCount() - 1, tmodeldetail1.getColumnCount()-1);

            tmodeldetail1.setValueAt(cbhd.getdistcode(), tmodeldetail1.getRowCount() - 1, 0);//0"Apply",

            Ar_invobl oarinvobl=new Ar_invobl(Ar_invobl.PROPERTY_DOCNUM, "");
            Ar_invh oarinvh=new Ar_invh(Ar_invh.PROPERTY_DOCNUM,"");

            tmodeldetail1.setValueAt(cbhd.getacccode(), tmodeldetail1.getRowCount() - 1, 1);//2"Document Number",
            tmodeldetail1.setValueAt(cbhd.getdistrbamt(), tmodeldetail1.getRowCount() - 1, 2);//4"Applied Amount",
            tmodeldetail1.setValueAt(cbhd.getglreff(), tmodeldetail1.getRowCount() - 1, 3);//4"Applied Amount"
            tmodeldetail1.setValueAt(cbhd.getgldesc(), tmodeldetail1.getRowCount() - 1, 4);//4"Applied Amount"


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
        setDataCbhh();
        //}

        cbhh = new Ar_rcph();

        try {
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);
        
        //obj.getDetail().add(cbhh);

        obj.setDtlslctdindx(obj.getDetail().size());


        setCbhhEnable(true);
        jlbldocentry.setText("Doc Entry*");

        showDataCbhh();

        jcmbdoctype.setSelectedIndex(0);

        arop = new Ar_optional(GlobalUtils.company);
        jcmbpaycode.setSelectedItem(arop.getpaycode().trim());
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
        setDataCbhh();
        jlbldocentry.setText("Doc Entry");
        if (pos > 0){

            obj.setDtlslctdindx(0);
            cbhh = (Ar_rcph) obj.getDetail().list().get(0);
            showDataCbhh();
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
        setDataCbhh();

        jlbldocentry.setText("Doc Entry");

        if (pos > 0){

            obj.setDtlslctdindx(pos-1);

            cbhh = (Ar_rcph) obj.getDetail().list().get(pos - 1);
            showDataCbhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;

        setDataCbhh();

        jlbldocentry.setText("Doc Entry");

        if (pos < obj.getDetail().list().size() - 1){

            obj.setDtlslctdindx((pos+1));

            cbhh = (Ar_rcph) obj.getDetail().list().get(pos + 1);
            showDataCbhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed

    int pos = 0;
    try{
        pos = obj.getDtlslctdindx();
        MOPChangedManually=true;

        setDataCbhh();

        jlbldocentry.setText("Doc Entry");
        
        if (pos < obj.getDetail().list().size()){

            obj.setDtlslctdindx(obj.getDetail().list().size()-1);

            cbhh = (Ar_rcph) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
            showDataCbhh();

        }


    }catch(Exception e) {}
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    // TODO add your handling code here:
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtdocentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try{

            obj.removeDetail(obj.getDtlslctdindx());

            obj=new Ar_rcpbatchlist(obj.getID());
            showData();

        }catch(Exception e) {e.printStackTrace();}

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed
private void cekCbhd(int row,int col) throws CodeException {

    


    Ar_rcpd cbhd;
    if (row > cbhds.list().size() - 1) {
        cbhd = new Ar_rcpd();
        cbhds.add(cbhd);
    }else{
        cbhd = (Ar_rcpd) cbhds.list().get(row);
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail.getValueAt(row, tmodeldetail.getColumnCount()-1)+"");
    }catch (Exception e){}

    cbhd.setID(idcbhd);
    cbhd.setApplied(GlobalUtils.churuf(tmodeldetail.getValueAt(row, col)));
    cbhd.setdocnumppd(jtxtdocnumapplto.getText());
    //tmodeldetail.setValueAt(oarinvh.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
    cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,2)));//2"Document Number",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,3)));//3"Pending Balance",
    cbhd.setpayamt(GlobalUtils.toDbl(tmodeldetail.getValueAt(row,4).toString()));//4"Applied Amount",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,5)));//5"Net Balance",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,6)));//6"Current Balance",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,7)));//7"Original Amount",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,8)));//8"Pending Amount",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,9)));//9"Po Number",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,10)));//0"Sales Order Number",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,11)));//1"Document Date",
    //cbhd.setdocnum(GlobalUtils.churuf(tmodeldetail.getValueAt(row,12)));//2"Due Date",
    cbhd.setentrydate(GlobalUtils.formatDate(kdateentrydate1.getDate(), "yyyy-MM-dd"));
    cbhd.setentrysts(0);
    cbhds.list().set(row, cbhd);

    cbhh.setdoctype(GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));
    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=cbhh.getDetailAmt();

    }
    //jtxtdoctotalamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount()+DetailAmt));
}

private void cekCbhd1(int row,int col) throws CodeException {


    cbhh.fromString(Ar_rcph.PROPERTY_DOCTYPE,GlobalUtils.churuf(jcmbdoctype.getSelectedIndex()+1));

    Ar_rcpdmisc cbhd;
    if (row > cbhdmiscs.list().size() - 1) {
        cbhd = new Ar_rcpdmisc();
        cbhdmiscs.add(cbhd);
    }else{
        cbhd = (Ar_rcpdmisc) cbhdmiscs.list().get(row);
    }

    long idcbhd = 0 ;
    try{
        idcbhd = Long.parseLong(tmodeldetail1.getValueAt(row, tmodeldetail1.getColumnCount()-1)+"");
    }catch (Exception e){}

    cbhd.setID(idcbhd);


    cbhd.setdistcode(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,0)));//2"Document Number",
    cbhd.setacccode(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,1)));//3"Pending Balance",
    cbhd.setdistrbamt(GlobalUtils.toDbl(tmodeldetail1.getValueAt(row,2).toString()));//4"Applied Amount",
    cbhd.setglreff(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,3)));//5"Net Balance",
    cbhd.setgldesc(GlobalUtils.churuf(tmodeldetail1.getValueAt(row,4)));//6"Current Balance",
    cbhd.setentrydate(GlobalUtils.formatDate(kdateentrydate1.getDate(), "yyyy-MM-dd"));
    cbhdmiscs.list().set(row, cbhd);

    double DetailAmt=0;
    if (GlobalUtils.toInt(jtxtdocentry.getText())==0){
        DetailAmt=cbhh.getDetailAmt();

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
            

            if (row > -1) {
                cekCbhd(row,col);
            }
            posttable = row;


            if(col == 2) {
                try{
                    Gl_account glacc = new Gl_account(tmodeldetail.getValueAt(row, col)+"");
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, col+1);
                }catch(Exception e) {}
            }

            if (col == 3){
                double amount=GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3)));

                cbhh.setdoctotalamt(cbhh.getDetailAmt());

            }
            //}
        }
    }catch (Exception e){
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblDetailPropertyChange

private Double getnetbalance(Double saldo,Double applied){
    return saldo-applied;
}
public void calculateapplied(Boolean auto){
    int i=0;
    Double awal=GlobalUtils.toDbl(jtxtdoctotalamt.getText());
    Double appl=new Double(0);
     if (jcmbdoctype.getSelectedIndex()==4){
        for (i=0;i<jtblDetail1.getRowCount();i++){
            Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail1.getValueAt(i, 2)));
            awal=awal-jmlapp;
        }
    } else {
        for (i=0;i<jtblDetail.getRowCount();i++){
            Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
            Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 4)));
            jtblDetail.setValueAt(getnetbalance(saldo, jmlapp), i,5);
            appl=appl+jmlapp;
        }
    }
    jtxtunapltotalamtc.setText(GlobalUtils.formatnumber(awal-appl));
}

public void doapplly(Boolean apply){
    int irow=jtblDetail.getSelectedRow();
    Double awal=GlobalUtils.toDbl(jtxtunapltotalamtc.getText());
    Double jmlapp=new Double(0);
    if (apply){
        jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(irow, 3)));
        if (jmlapp>awal){
            jmlapp=awal;
        }
        jtblDetail.setValueAt(jmlapp, irow, 4);
    } else {
        jtblDetail.setValueAt(0, irow, 4);
    }
    jtblDetail.setValueAt(0, irow,5);
    
}
public void calculateapplied2(Boolean auto){
    int i=0;
    Double awal=GlobalUtils.toDbl(jtxtdoctotalamt.getText());
    if (jcmbdoctype.getSelectedIndex()==4){
        for (i=0;i<jtblDetail1.getRowCount();i++){
            Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail1.getValueAt(i, 2)));
            awal=awal-jmlapp;
        }
    } else {
        for (i=0;i<jtblDetail.getRowCount();i++){
            if (auto){
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                if (GlobalUtils.churuf(jtblDetail.getValueAt(i,0)).equalsIgnoreCase("yes")){
                    Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                    if (jmlapp>awal){
                        jmlapp=awal;
                    }
                    awal=awal-jmlapp;
                    jtblDetail.setValueAt(jmlapp, i,4);
                    jtblDetail.setValueAt(getnetbalance(saldo, jmlapp), i,5);
                } else {
                    jtblDetail.setValueAt(0, i,4);
                    jtblDetail.setValueAt(getnetbalance(saldo, new Double(0)), i,5);
                }
            } else {
                Double saldo=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 3)));
                if (GlobalUtils.churuf(jtblDetail.getValueAt(i,0)).equalsIgnoreCase("yes")){
                    Double jmlapp=GlobalUtils.toDbl(GlobalUtils.churuf(jtblDetail.getValueAt(i, 4)));
                    if (jmlapp>awal){
                        jmlapp=awal;
                    }
                    awal=awal-jmlapp;
                    jtblDetail.setValueAt(getnetbalance(saldo, jmlapp), i,5);
                } else {
                    jtblDetail.setValueAt(0, i,4);
                    jtblDetail.setValueAt(getnetbalance(saldo, new Double(0)), i,5);
                }
            }
        }
    }

    jtxtunapltotalamtc.setText(GlobalUtils.formatnumber(awal));
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
                    Ar_distcodes brs = new Ar_distcodes();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Ar_distcode glacc = new Ar_distcode(tmodeldetail.getValueAt(row, 0)+"");
                    tmodeldetail.setValueAt(glacc.getaccrevcode(), row, 1);
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

                System.out.println(cbhh.getDetail().size() + "=====" + row + "======");

                cbhh.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail.removeRow(row);

            if (row+1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount()-1, 1);
            }

            try{
                jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotrcpamt()));
                jtxtrcpentrcnt.setText(GlobalUtils.formatnumber(obj.getrcpentrcnt()));
                showDataCbhh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }
}//GEN-LAST:event_jtblDetailKeyPressed

private void jbtnBrowse6CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6CustomerActionPerformed
    // TODO add your handling code here:
    try {
        Ar_customers brs = new Ar_customers();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtcustmrcode);
        bd.setSecondValue(jtxtcustmrdesc);
        bd.setModal(true);
        bd.setVisible(true);

        Ar_customer arcust=new Ar_customer(jtxtcustmrcode.getText());
        jtxtcurnccode1.setText(arcust.getcurnccode());
        jtxtcurnccode.setText(arcust.getcurnccode());

    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse6CustomerActionPerformed

private void jbtnBrowse7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse7ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbtnBrowse7ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
        FrmAr_rcppopsearchdata obrowse;
        try {
            obrowse = new FrmAr_rcppopsearchdata(this.cbhh);
            obrowse.setModal(true);
            obrowse.setVisible(true);

            Ar_invobls oar_invobss=new Ar_invobls();
            if (!obrowse.getTypes().equalsIgnoreCase("")){
                oar_invobss.searchData(jtxtcustmrcode.getText(),obrowse.getMode(),obrowse.getStartpono(),obrowse.getTypes(),obrowse.getSortby());

                int irow=jtblDetail.getRowCount()-1;
                for (Object o:oar_invobss.list()){
                    Ar_invobl oarinvobl=(Ar_invobl) o;

                    
                    tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

                    tmodeldetail.setValueAt("No", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
                    tmodeldetail.setValueAt(oarinvobl.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
                    tmodeldetail.setValueAt(oarinvobl.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",
                    tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 3);//3"Pending Balance",
                    tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 4);//4"Applied Amount",
                    tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 5);//5"Net Balance",
                    tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 6);//6"Current Balance",
                    tmodeldetail.setValueAt(oarinvobl.getdoctotalamt(), tmodeldetail.getRowCount() - 1, 7);//7"Original Amount",
                    tmodeldetail.setValueAt(oarinvobl.getdoctotalamtr(), tmodeldetail.getRowCount() - 1, 8);//8"Pending Amount",
                    tmodeldetail.setValueAt(oarinvobl.getcustmrpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
                    tmodeldetail.setValueAt(oarinvobl.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
                    tmodeldetail.setValueAt(oarinvobl.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
                    tmodeldetail.setValueAt(oarinvobl.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",
                    //3"id"
                    //calculateapplied(true);
                    cekCbhd(irow,0);
                    irow++;

                    tmodeldetail.addRow(datadetail);


                }
                
            }
            
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_jButton1ActionPerformed

private void jtxtdoctotalamtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdoctotalamtKeyReleased
    // TODO add your handling code here:
    jtxtdoctotalamt.setText(GlobalUtils.formatnumber(GlobalUtils.toDbl(jtxtdoctotalamt.getText())));
    jtxtdoctotalamt.setSelectionStart(jtxtdoctotalamt.getText().length());

    jtxtunapltotalamtc.setText(jtxtdoctotalamt.getText());

    Integer idoctype=jcmbdoctype.getSelectedIndex();
    if (idoctype.equals(2)){
            try {
                showinvoice("");
            } catch (CodeException ex) {
                Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    if (jcmbDocType.getSelectedIndex()==1||jcmbDocType.getSelectedIndex()==3){
        calculateapplied(false);
    } else {
        calculateapplied(false);
    }

    //kdateentrydate1.requestFocus();
    
}//GEN-LAST:event_jtxtdoctotalamtKeyReleased

private void jbtnBrowse8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse8ActionPerformed
    // TODO add your handling code here:
    try {
        Ar_invobls brs = new Ar_invobls();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtdocnumapplto);
        bd.setModal(true);
        bd.setVisible(true);

        showinvoice(jtxtdocnumapplto.getText());
        applyscreen();
    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse8ActionPerformed

private void showinvoice(String docnum) throws CodeException{
    Ar_invh oarinvh=new Ar_invh(Ar_invh.PROPERTY_DOCNUM,docnum);
    Ar_invobl oarinvobl=new Ar_invobl(Ar_invobl.PROPERTY_DOCNUM, docnum);
    tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount()-1);

    tmodeldetail.setValueAt("Yes", tmodeldetail.getRowCount() - 1, 0);//0"Apply",
    tmodeldetail.setValueAt(oarinvh.getdoctype(), tmodeldetail.getRowCount() - 1, 1);//1"Document Type",
    tmodeldetail.setValueAt(oarinvh.getdocnum(), tmodeldetail.getRowCount() - 1, 2);//2"Document Number",

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
    tmodeldetail.setValueAt(oarinvh.getcustmrpono(), tmodeldetail.getRowCount() - 1, 9);//9"Po Number",
    tmodeldetail.setValueAt(oarinvh.getorderno(), tmodeldetail.getRowCount() - 1, 10);//0"Sales Order Number",
    tmodeldetail.setValueAt(oarinvh.getdocdate(), tmodeldetail.getRowCount() - 1, 11);//1"Document Date",
    tmodeldetail.setValueAt(oarinvh.getdocduedate(), tmodeldetail.getRowCount() - 1, 12);//2"Due Date",

    calculateapplied(true);
    cekCbhd(tmodeldetail.getRowCount() - 1,0);

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
        jtxtcustmrcode.setVisible(true);
        jbtnBrowse6Customer.setVisible(true);
        jtxtcustmrdesc.setVisible(true);
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
        jtxtcustmrcode.setVisible(true);
        jbtnBrowse6Customer.setVisible(true);
        jtxtcustmrdesc.setVisible(true);
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
        jtxtcustmrcode.setVisible(false);
        jbtnBrowse6Customer.setVisible(false);
        jtxtcustmrdesc.setVisible(false);

        
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
        jtxtcustmrcode.setVisible(true);
        jbtnBrowse6Customer.setVisible(true);
        jtxtcustmrdesc.setVisible(true);

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
        jtxtcustmrcode.setVisible(true);
        jbtnBrowse6Customer.setVisible(true);
        jtxtcustmrdesc.setVisible(true);

    }
}
private void jcmbdoctypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbdoctypeItemStateChanged
    // TODO add your handling code here:
    applyscreen();
    try {
        if (!GlobalUtils.churuf(cbhh.getdoctype()).equalsIgnoreCase("2")) {
            cbhds = cbhh.getDetail();
        } else {
            cbhdmiscs = cbhh.getDetail2();
        }
    } catch (CodeException ex) {
        Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }


    try{
        if (jcmbdoctype.getSelectedIndex()==4){
            showDataCbhd1();
        } else {
            showDataCbhd();
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
                cekCbhd1(row,col);
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

                cbhh.setdoctotalamt(cbhh.getDetailAmt());

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

                System.out.println(cbhh.getDetail().size() + "=====" + row + "======");

                cbhh.removeDetail(row,obj);

            }catch(Exception e){e.printStackTrace();}


            tmodeldetail1.removeRow(row);

            if (row+1 < tmodeldetail1.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail1, row, 1);
            }else{
                GlobalUtils.selectCellTable(jtblDetail1, tmodeldetail1.getRowCount()-1, 1);
            }

            try{
                jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotrcpamt()));
                jtxtrcpentrcnt.setText(GlobalUtils.formatnumber(obj.getrcpentrcnt()));
                showDataCbhh();
            }catch (Exception e) {e.printStackTrace();}

        }
    }
}//GEN-LAST:event_jtblDetail1KeyPressed

private void jtxtbatchnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchnoKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        kdateentrydate.requestFocus();
    }
    
}//GEN-LAST:event_jtxtbatchnoKeyPressed

private void kdateentrydateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdateentrydateKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtbatchdesc.requestFocus();
    }
    
}//GEN-LAST:event_kdateentrydateKeyPressed

private void jtxtbatchdescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchdescKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtbankcode.requestFocus();
    }
}//GEN-LAST:event_jtxtbatchdescKeyPressed

private void jtxtbankcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbankcodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        try{
          Cb_bank bank = new Cb_bank();
          jtxtbatchdesc.setText(bank.getbankname());
        }catch(Exception e){}

        jtbnNew.requestFocus();
    }
}//GEN-LAST:event_jtxtbankcodeKeyPressed

private void jtxtdocentryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocentryKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdscription.requestFocus();
    }
}//GEN-LAST:event_jtxtdocentryKeyPressed

private void jtxtdscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdscriptionKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbdoctype.requestFocus();
    }
}//GEN-LAST:event_jtxtdscriptionKeyPressed

private void jcmbdoctypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbdoctypeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        jtxtcustmrcode.requestFocus();
    }
}//GEN-LAST:event_jcmbdoctypeKeyPressed

private void jtxtcustmrcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcustmrcodeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        try{
            Ar_customer cust = new Ar_customer(jtxtcustmrcode.getText());
            jtxtcustmrdesc.setText(cust.getcustmrname());

        }catch(Exception e){}
        jtxtdoctotalamt.requestFocus();

    }
}//GEN-LAST:event_jtxtcustmrcodeKeyPressed

private void kdateentrydate1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdateentrydate1KeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcbYOP.requestFocus();
    }
    
}//GEN-LAST:event_kdateentrydate1KeyPressed

private void jcbYOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbYOPKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcbMOP.requestFocus();
    }
    
}//GEN-LAST:event_jcbYOPKeyPressed

private void jcbMOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMOPKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdocnum.requestFocus();
    }
}//GEN-LAST:event_jcbMOPKeyPressed

private void jtxtdocnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtpayor.requestFocus();
    }
}//GEN-LAST:event_jtxtdocnumKeyPressed

private void jtxtpayorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtpayorKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbpaycode.requestFocus();
    }

}//GEN-LAST:event_jtxtpayorKeyPressed

private void jcmbpaycodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbpaycodeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtunapltotalamtc.requestFocus();
    }
    
}//GEN-LAST:event_jcmbpaycodeKeyPressed

private void jtxtunapltotalamtcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtunapltotalamtcKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jcmbDocType.requestFocus();
    }
    
}//GEN-LAST:event_jtxtunapltotalamtcKeyPressed

private void jcmbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbDocTypeKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtdocnumapplto.requestFocus();
    }
    
}//GEN-LAST:event_jcmbDocTypeKeyPressed

private void jtxtdocnumappltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumappltoKeyPressed

    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        jtxtpredocnum.requestFocus();
    }
    
}//GEN-LAST:event_jtxtdocnumappltoKeyPressed

private void jcbYOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusLost
    // TODO add your handling code here:
        MOPChangedManually=true;
}//GEN-LAST:event_jcbYOPFocusLost

private void jcbMOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusLost
    // TODO add your handling code here:
        MOPChangedManually=true;
}//GEN-LAST:event_jcbMOPFocusLost

private void jcbYOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusGained
    // TODO add your handling code here:
    yopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
}//GEN-LAST:event_jcbYOPFocusGained

private void jcbMOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusGained
    // TODO add your handling code here:
    mopbf=GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
}//GEN-LAST:event_jcbMOPFocusGained

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

private void jtblDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyReleased
    // TODO add your handling code here:
     int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (evt.getKeyCode()==evt.VK_ENTER){
        evt.consume();

        //if(posttable != row) {
        if (col==0){
            calculateapplied(true);
        }

        if (col==4){
            calculateapplied(false);
        }
    }
}//GEN-LAST:event_jtblDetailKeyReleased

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
            Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);

}                                           

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
	      Ar_rcpbatchlists brs = new Ar_rcpbatchlists();
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
                    new FrmAr_rcpbatchlist().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jbtnBrowse6Customer;
    private javax.swing.JButton jbtnBrowse7;
    private javax.swing.JButton jbtnBrowse8;
    private javax.swing.JButton jbtnBrowse9;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnMoveFirst;
    private javax.swing.JButton jbtnMoveLast;
    private javax.swing.JButton jbtnMoveNext;
    private javax.swing.JButton jbtnMovePrevious;
    private javax.swing.JComboBox jcbMOP;
    private javax.swing.JComboBox jcbYOP;
    private javax.swing.JComboBox jcmbDocType;
    private javax.swing.JComboBox jcmbdoctype;
    private javax.swing.JComboBox jcmbpaycode;
    private javax.swing.JLabel jlblbankcode;
    private javax.swing.JLabel jlblbankcode1;
    private javax.swing.JLabel jlblbankcode2;
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
    private javax.swing.JTextField jtxtDepostSlipPrinted;
    private javax.swing.JTextField jtxtNomorDeposit;
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
    private javax.swing.JTextField jtxtcustmrcode;
    private javax.swing.JTextField jtxtcustmrdesc;
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
        obj = new Ar_rcpbatchlist(this.jtxtbatchno.getText());
        showData();
        mf.setIcon(CLASSNAME);

    }
    public void newData() throws CodeException {
        obj = new Ar_rcpbatchlist();
        MOPChangedManually=false;
        istatus=1;
        showData();

        jlbldocentry.setText("Doc Entry*");

        arop = new Ar_optional(GlobalUtils.company);
        jtxtbankcode.setText(arop.getbankcode());
        try {
            kdateentrydate.setDate(GlobalUtils.sessiondate);
            kdateentrydate1.setDate(GlobalUtils.sessiondate);
        } catch (KazaoCalendarDateTimeException ex) {
            Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate)-1);

        Cb_bank cbbank=new Cb_bank(arop.getbankcode());
        jtxtbankname.setText(cbbank.getbankname());

        jcmbdoctype.setSelectedIndex(0);

        jcmbpaycode.setSelectedItem(arop.getpaycode().trim());
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
            Logger.getLogger(FrmAr_rcpbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void saveData() throws CodeException {
        if (validatebank(jtxtbankcode.getText())){
            if (jcmbpaycode.getSelectedIndex()>-1){
            istatus = 0;
            setData();

            setDataCbhh();

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

    public void setar_rcpbatchlist(Ar_rcpbatchlist obj){
        this.obj=obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAr_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	
             jtxtid.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_ID));
             jtxtbatchno.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_BATCHNO));
             try {
                kdateentrydate.setDate(GlobalUtils.formatDate(obj.getbatchdate(),"MM/dd/yyyy"));
            } catch (KazaoCalendarDateTimeException ex) {
                Logger.getLogger(FrmGl_batchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
             jtxtbatchdesc.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_BATCHDESC));
             jtxtbatchtype.setText(obj.gettypedescription());
             jtxtbatchsts.setText(obj.getstatusdescription());
             jtxttotrcpamt.setText(GlobalUtils.formatnumber(obj.gettotrcpamt()));
             jtxtrcpentrcnt.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_RCPENTRCNT));

             jtxtbankcode.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_BANKCODE));

             Cb_bank cbbank=new Cb_bank(jtxtbankcode.getText());
             jtxtbankname.setText(cbbank.getbankname());
             
             if (obj.getID()>0){
                 jtxtbankcode.setEditable(false);
                 jbtnBrowse1.setEnabled(false);
             } else {
                 jtxtbankcode.setEditable(true);
                 jbtnBrowse1.setEnabled(true);
             }
             jtxtentrydate.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Ar_rcpbatchlist.PROPERTY_CMPNYID));

             jtxtNomorDeposit.setText("0");
             jtxtDepostSlipPrinted.setText("0");

             if (obj.getDetail().list().isEmpty()) {
                 obj.setDtlslctdindx(-1);
                 setCbhhEnable(false);
                 cbhh = new Ar_rcph();
             }else{
                obj.setDtlslctdindx(obj.getDetail().size()-1);
                cbhh = (Ar_rcph) obj.getDetail().list().get(obj.getDetail().size()-1);
                setCbhhEnable(true);
              }
             showDataCbhh();

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

    public void buttonEnable(boolean val){
         this.mf.btnSave.setEnabled(val);
         this.mf.btnDel.setEnabled(val);
         this.mf.btnConfirm.setEnabled(val);
         jtbnNew.setEnabled(val);
         jbtnDelete.setEnabled(val);
    }
    
    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        if (obj.getID()==0){
            obj=new Ar_rcpbatchlist();
        }
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Ar_rcpbatchlist.PROPERTY_ID, jtxtid.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_BATCHNO, jtxtbatchno.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(kdateentrydate.getDate(),"yyyy-MM-dd")) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_BATCHDESC, jtxtbatchdesc.getText()) ;

          if (obj.getID()==0){
              obj.fromString(Ar_rcpbatchlist.PROPERTY_BATCHTYPE, "1") ;
           }
          obj.settotrcpamt(GlobalUtils.toDbl(jtxttotrcpamt.getText()));
          obj.setrcpentrcnt(GlobalUtils.toDbl(jtxtrcpentrcnt.getText()).longValue()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_BANKCODE, jtxtbankcode.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText()) ;
          obj.fromString(Ar_rcpbatchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText()) ;

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
