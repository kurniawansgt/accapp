/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.ap.FrmAp_invbatchlist;
 * 
 * .......
 * 
 * 
 * FrmAp_invbatchlist frmAp_invbatchlist;
 * 
 * .......
 * 
try {
if (frmAp_invbatchlist == null) {
frmmAp_invbatchlist = new FrmAp_invbatchlist(this);
}

showForm(frmAp_invbatchlist);

}catch(Exception e) {
e.printStackTrace();
}
 * 
 */
package accapp.component.ap;

import accapp.component.browse.FrmBrowseAPVendor;
import accapp.component.browse.FrmBrowseAp_invoblByVendor;
import accapp.objectclasses.ap.Ap_distcode;
import accapp.objectclasses.ap.Ap_distcodes;
import accapp.objectclasses.ap.Ap_distsetd;
import accapp.objectclasses.ap.Ap_distsetds;
import common.component.FrmBrowse;
import common.classinterface.NavigatorFormInt;
import common.component.FrmMainFrame;

import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.text.ParseException;
import javax.swing.JOptionPane;
import common.utils.ExtFileChooserFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import accapp.objectclasses.ap.Ap_invbatchlist;
import accapp.objectclasses.ap.Ap_invd;
import accapp.objectclasses.ap.Ap_invds;
import accapp.objectclasses.ap.Ap_invh;
import accapp.objectclasses.ap.Ap_invobls;
import accapp.objectclasses.ap.Ap_vendor;
import accapp.objectclasses.ap.Ap_vendors;
import accapp.objectclasses.ap.D_material_receive;
import accapp.objectclasses.ap.D_material_receives;
import accapp.objectclasses.ap.Q_ap_invbatchlists;
import accapp.objectclasses.ar.Ar_invh;
import accapp.objectclasses.ap.H_material_receives;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_currencys;
import accapp.objectclasses.gl.Gl_fiscalh;
import accapp.objectclasses.op.Op_address;
import accapp.objectclasses.op.Op_addresss;
import accapp.objectclasses.op.Op_paymentterm;
import accapp.objectclasses.op.Op_paymentterms;
import accapp.objectclasses.op.Op_tax;
import accapp.objectclasses.op.Op_taxs;
import common.component.FrmBrowseObject;
import common.component.frmCalculator;
import common.print.FrmPrintTransaksiAPBatchListInvoice;
import common.tablemodels.GlobalModel;
import common.tablemodels.MyTableCellEditor;
import common.utils.selectallJTable;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author  Generator
 */
public class FrmAp_invbatchlist extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME = "FrmAp_invbatchlist";
    FrmMainFrame mf;
    public Ap_invbatchlist obj = new Ap_invbatchlist();
    Ap_invbatchlist objtmp = null;
    DecimalFormat decform = new DecimalFormat("##0");
    Ap_invh apinvhh = new Ap_invh();
    Ap_invds apinvhds = new Ap_invds();
    D_material_receives mrds = new D_material_receives();
    Ap_vendor apvendor = new Ap_vendor();
    Object[] datadetail;
    DefaultTableModel tmodeldetail;
    Boolean MOPChangedManually = false;
    long mopbf = 0;
    long yopbf = 0;
    int posttable = 0;
    boolean onload = false;

    /** Creates new form Area */
    public FrmAp_invbatchlist() throws CodeException {
        initComponents();
    }

    public FrmAp_invbatchlist(FrmMainFrame mf) throws CodeException {
        this.mf = mf;
        initComponents();

        fillMOP();
        fillYOP();

        jtxtAccSetCode.setVisible(false);
        jtxtdoctypeapplto.setVisible(false);
        TableColumn col = jtblDetail.getColumnModel().getColumn(4);
        col.setCellEditor(new MyTableCellEditor(4, 1));

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

    private void fillMOP() {
        jcbMOP.removeAllItems();

        long i = 0;
        for (i = 1; i < 13; i++) {
            jcbMOP.addItem(GlobalUtils.formatmonth(i));
        }

    }

    private void fillYOP() {
        jcbYOP.removeAllItems();

        int currentYear = GlobalUtils.CNomorInt(GlobalUtils.getCurrentYear());
        long i = 0;
        for (i = currentYear - 10; i < currentYear + 10; i++) {
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
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlblreadytpost1 = new javax.swing.JLabel();
        jlblbatchtype1 = new javax.swing.JLabel();
        jtxtbatchtype = new javax.swing.JTextField();
        jlblbatchsts1 = new javax.swing.JLabel();
        jtxtbatchsts = new javax.swing.JTextField();
        jchckReadyToPost = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jlbldocentry = new javax.swing.JLabel();
        jlblcustmrcode = new javax.swing.JLabel();
        jtxtdocentry = new javax.swing.JTextField();
        jtxtvendorcode = new javax.swing.JTextField();
        jlbladdrcode = new javax.swing.JLabel();
        jtxtaddrcode = new javax.swing.JTextField();
        jlbldoctype = new javax.swing.JLabel();
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
        jtxtvendordesc = new javax.swing.JTextField();
        jbtnBrowse3 = new javax.swing.JButton();
        jbtnBrowse4 = new javax.swing.JButton();
        jbtnBrowseVendor = new javax.swing.JButton();
        jcbMOP = new javax.swing.JComboBox();
        jcbYOP = new javax.swing.JComboBox();
        jlbljrnldebit = new javax.swing.JLabel();
        jtbnNew = new javax.swing.JButton();
        jbtnMoveFirst = new javax.swing.JButton();
        jbtnMovePrevious = new javax.swing.JButton();
        jbtnMoveNext = new javax.swing.JButton();
        jbtnMoveLast = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jcmbdoctype = new javax.swing.JComboBox();
        jbtnBrowse6 = new javax.swing.JButton();
        jbtnBrowse7 = new javax.swing.JButton();
        jlbldocdate1 = new javax.swing.JLabel();
        jtxtdoctotal1 = new javax.swing.JTextField();
        jtxttaxcodedesc = new javax.swing.JTextField();
        kdateentrydate = new javax.swing.JFormattedTextField();
        kdocduedate = new javax.swing.JFormattedTextField();
        kdiscdate = new javax.swing.JFormattedTextField();
        jlbldoctype1 = new javax.swing.JLabel();
        jtxtNoMR = new javax.swing.JTextField();
        jbtnBrowseNoMR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jtxtcustmrcode1 = new javax.swing.JTextField();
        jlblcustmrcode1 = new javax.swing.JLabel();
        jtxtcustmrdesc1 = new javax.swing.JTextField();
        jlbldocnum1 = new javax.swing.JLabel();
        jtxtdocnum2 = new javax.swing.JTextField();
        jlblcurnccode1 = new javax.swing.JLabel();
        jtxtcurnccode1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetail = new selectallJTable(tmodeldetail);
        jtxttaxcode1 = new javax.swing.JTextField();
        jlbltaxcode1 = new javax.swing.JLabel();
        jbtnBrowse8 = new javax.swing.JButton();
        jlbldocnum2 = new javax.swing.JLabel();
        jtxtdistamount = new javax.swing.JTextField();
        jtxtdocnum3 = new javax.swing.JTextField();
        jlbldocnum3 = new javax.swing.JLabel();
        jlbldocnum4 = new javax.swing.JLabel();
        jtxtdocnum4 = new javax.swing.JTextField();
        jlbldocdate2 = new javax.swing.JLabel();
        jtxtdoctotal2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jlbltotinvamt1 = new javax.swing.JLabel();
        jtxttotinvamt = new javax.swing.JTextField();
        jlblinventrcnt1 = new javax.swing.JLabel();
        jtxtinventrcnt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtxtAccSetCode = new javax.swing.JTextField();
        jlblbatchdate1 = new javax.swing.JLabel();
        jtxtbatchdesc = new javax.swing.JTextField();
        jtxtdoctypeapplto = new javax.swing.JTextField();
        kbatchdate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AP Invoice Entry");
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
        jHeader.setText(" : : AP Invoice Entry");
        jHeader.setToolTipText("accapp.component.ap:frmap_invbatchlist");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 130, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 720, 2);

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
        jbtnBrowse.setBounds(250, 60, 30, 17);

        jtxtid.setEditable(false);
        jtxtid.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(290, 30, 80, 16);

        jlblbatchno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchno.setText("Batch Number");
        getContentPane().add(jlblbatchno);
        jlblbatchno.setBounds(60, 60, 90, 14);

        jtxtbatchno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchno.setText("batchno");
        jtxtbatchno.setNextFocusableComponent(kbatchdate);
        jtxtbatchno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchnoKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchno);
        jtxtbatchno.setBounds(170, 60, 80, 20);

        jlblbatchdate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchdate.setText("Batch Date");
        getContentPane().add(jlblbatchdate);
        jlblbatchdate.setBounds(60, 80, 100, 14);

        jtxtentrydate.setEditable(false);
        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(370, 30, 80, 16);

        jtxtauditdate.setEditable(false);
        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(450, 30, 80, 16);

        jtxtaudituser.setEditable(false);
        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(530, 30, 80, 16);

        jtxtcmpnyid.setEditable(false);
        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(610, 30, 80, 16);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jlblreadytpost1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblreadytpost1.setText("Ready To Post");
        jPanel1.add(jlblreadytpost1);
        jlblreadytpost1.setBounds(30, 50, 140, 14);

        jlblbatchtype1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchtype1.setText("Type");
        jPanel1.add(jlblbatchtype1);
        jlblbatchtype1.setBounds(280, 90, 140, 14);

        jtxtbatchtype.setEditable(false);
        jtxtbatchtype.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchtype.setText("batchtype");
        jPanel1.add(jtxtbatchtype);
        jtxtbatchtype.setBounds(440, 90, 80, 20);

        jlblbatchsts1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchsts1.setText("Status");
        jPanel1.add(jlblbatchsts1);
        jlblbatchsts1.setBounds(30, 90, 140, 14);

        jtxtbatchsts.setEditable(false);
        jtxtbatchsts.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchsts.setText("batchsts");
        jPanel1.add(jtxtbatchsts);
        jtxtbatchsts.setBounds(190, 90, 80, 20);

        jchckReadyToPost.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jchckReadyToPost.setNextFocusableComponent(jtxtvendorcode);
        jPanel1.add(jchckReadyToPost);
        jchckReadyToPost.setBounds(190, 50, 21, 21);

        jTabbedPane1.addTab("Batch", jPanel1);

        jPanel2.setLayout(null);

        jlbldocentry.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocentry.setText("Doc Entry");
        jPanel2.add(jlbldocentry);
        jlbldocentry.setBounds(10, 20, 140, 14);

        jlblcustmrcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrcode.setText("Vendor No");
        jPanel2.add(jlblcustmrcode);
        jlblcustmrcode.setBounds(10, 50, 100, 14);

        jtxtdocentry.setEditable(false);
        jtxtdocentry.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocentry.setText("docentry");
        jPanel2.add(jtxtdocentry);
        jtxtdocentry.setBounds(110, 20, 80, 20);

        jtxtvendorcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtvendorcode.setText("vendorcode");
        jtxtvendorcode.setNextFocusableComponent(jtxtaddrcode);
        jtxtvendorcode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtvendorcodePropertyChange(evt);
            }
        });
        jtxtvendorcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtvendorcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtvendorcode);
        jtxtvendorcode.setBounds(110, 50, 80, 20);

        jlbladdrcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbladdrcode.setText("Remit To");
        jPanel2.add(jlbladdrcode);
        jlbladdrcode.setBounds(10, 70, 100, 14);

        jtxtaddrcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtaddrcode.setText("addrcode");
        jtxtaddrcode.setNextFocusableComponent(jcmbdoctype);
        jtxtaddrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtaddrcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtaddrcode);
        jtxtaddrcode.setBounds(110, 70, 80, 20);

        jlbldoctype.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldoctype.setText("Doc. Type");
        jPanel2.add(jlbldoctype);
        jlbldoctype.setBounds(10, 110, 100, 14);

        jlbldocdate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocdate.setText("Doc Total");
        jPanel2.add(jlbldocdate);
        jlbldocdate.setBounds(10, 190, 100, 14);

        jlbldscription.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldscription.setText("Description");
        jPanel2.add(jlbldscription);
        jlbldscription.setBounds(10, 210, 100, 14);

        jtxtdscription.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdscription.setText("dscription");
        jtxtdscription.setNextFocusableComponent(jtxttaxcode);
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
        jlbltaxcode.setBounds(10, 230, 100, 14);

        jtxttaxcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttaxcode.setText("taxcode");
        jtxttaxcode.setNextFocusableComponent(jtxttermcode);
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
        jlblyop.setBounds(220, 160, 70, 14);

        jlblmop.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblmop.setText("Periode");
        jPanel2.add(jlblmop);
        jlblmop.setBounds(340, 160, 70, 14);

        jlblorderno.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblorderno.setText("Order No.");
        jPanel2.add(jlblorderno);
        jlblorderno.setBounds(510, 200, 80, 14);

        jlblcustmrpono.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrpono.setText("PO No.");
        jPanel2.add(jlblcustmrpono);
        jlblcustmrpono.setBounds(510, 180, 80, 14);

        jlbltermcode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltermcode.setText("Term");
        jPanel2.add(jlbltermcode);
        jlbltermcode.setBounds(10, 250, 70, 14);

        jtxttermcode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttermcode.setText("termcode");
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
        jlbldiscdate.setBounds(230, 270, 90, 14);

        jlbldiscprcnt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldiscprcnt.setText("Disc. Percent");
        jPanel2.add(jlbldiscprcnt);
        jlbldiscprcnt.setBounds(10, 290, 90, 14);

        jlbldiscvalueamt.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldiscvalueamt.setText("Disc. Ammount");
        jPanel2.add(jlbldiscvalueamt);
        jlbldiscvalueamt.setBounds(230, 290, 100, 14);

        jlbldocnum.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum.setText("Document No.");
        jPanel2.add(jlbldocnum);
        jlbldocnum.setBounds(10, 140, 100, 14);

        jtxtdocnum.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum.setText("docnum");
        jtxtdocnum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtdocnumFocusLost(evt);
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
        jlbldocnumapplto.setBounds(510, 140, 100, 14);

        jtxtdocnumapplto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnumapplto.setText("docnumapplto");
        jtxtdocnumapplto.setNextFocusableComponent(jtxtrate);
        jtxtdocnumapplto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdocnumappltoActionPerformed(evt);
            }
        });
        jtxtdocnumapplto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdocnumappltoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtdocnumapplto);
        jtxtdocnumapplto.setBounds(650, 140, 130, 20);

        jlblcurnccode.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcurnccode.setText("Curency Code");
        jPanel2.add(jlblcurnccode);
        jlblcurnccode.setBounds(510, 120, 110, 14);

        jtxtcurnccode.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcurnccode.setText("curnccode");
        jtxtcurnccode.setNextFocusableComponent(jtxtdocnumapplto);
        jtxtcurnccode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcurnccodeKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtcurnccode);
        jtxtcurnccode.setBounds(650, 120, 50, 20);

        jlblrate.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblrate.setText("Rate");
        jPanel2.add(jlblrate);
        jlblrate.setBounds(510, 160, 80, 14);

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
        jtxtrate.setBounds(650, 160, 130, 20);

        jtxtorderno.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtorderno.setText("orderno");
        jtxtorderno.setNextFocusableComponent(jPanel3);
        jtxtorderno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtordernoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtorderno);
        jtxtorderno.setBounds(650, 200, 130, 20);

        jtxtcustmrpono.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrpono.setText("custmrpono");
        jtxtcustmrpono.setNextFocusableComponent(jtxtorderno);
        jtxtcustmrpono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcustmrponoKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtcustmrpono);
        jtxtcustmrpono.setBounds(650, 180, 130, 20);

        jtxtdiscprcnt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdiscprcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdiscprcnt.setText("discprcnt");
        jtxtdiscprcnt.setNextFocusableComponent(jtxtdiscvalueamt);
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
        jtxtdiscvalueamt.setNextFocusableComponent(jPanel3);
        jtxtdiscvalueamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdiscvalueamtActionPerformed(evt);
            }
        });
        jtxtdiscvalueamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdiscvalueamtKeyReleased(evt);
            }
        });
        jPanel2.add(jtxtdiscvalueamt);
        jtxtdiscvalueamt.setBounds(340, 290, 80, 20);

        jbtnBrowse1.setText("...");
        jbtnBrowse1.setNextFocusableComponent(jtxtvendorcode);
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

        jtxtvendordesc.setEditable(false);
        jtxtvendordesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtvendordesc.setText("jtxtvendordesc");
        jtxtvendordesc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtvendordescPropertyChange(evt);
            }
        });
        jPanel2.add(jtxtvendordesc);
        jtxtvendordesc.setBounds(230, 50, 410, 20);

        jbtnBrowse3.setText("...");
        jbtnBrowse3.setNextFocusableComponent(jtxtrate);
        jbtnBrowse3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse3ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse3);
        jbtnBrowse3.setBounds(780, 140, 30, 17);

        jbtnBrowse4.setText("...");
        jbtnBrowse4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse4ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse4);
        jbtnBrowse4.setBounds(190, 230, 30, 17);

        jbtnBrowseVendor.setText("...");
        jbtnBrowseVendor.setNextFocusableComponent(jtxtaddrcode);
        jbtnBrowseVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseVendorActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowseVendor);
        jbtnBrowseVendor.setBounds(190, 50, 30, 17);

        jcbMOP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jcbMOP.setNextFocusableComponent(jtxtdoctotal1);
        jcbMOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcbMOPMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcbMOPMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbMOPMouseReleased(evt);
            }
        });
        jcbMOP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMOPItemStateChanged(evt);
            }
        });
        jcbMOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMOPActionPerformed(evt);
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
        jcbMOP.setBounds(400, 160, 60, 20);

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
        jPanel2.add(jcbYOP);
        jcbYOP.setBounds(260, 160, 70, 20);

        jlbljrnldebit.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbljrnldebit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbljrnldebit.setText("Index 1 of 100");
        jPanel2.add(jlbljrnldebit);
        jlbljrnldebit.setBounds(590, 10, 140, 14);

        jtbnNew.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtbnNew.setText("New");
        jtbnNew.setToolTipText("New Entry");
        jtbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNewActionPerformed(evt);
            }
        });
        jPanel2.add(jtbnNew);
        jtbnNew.setBounds(230, 20, 70, 20);

        jbtnMoveFirst.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveFirst.setToolTipText("First Entry");
        jbtnMoveFirst.setLabel("|<");
        jbtnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveFirstActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMoveFirst);
        jbtnMoveFirst.setBounds(340, 20, 50, 20);

        jbtnMovePrevious.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMovePrevious.setToolTipText("Previous Entry");
        jbtnMovePrevious.setLabel("<");
        jbtnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMovePreviousActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMovePrevious);
        jbtnMovePrevious.setBounds(390, 20, 50, 20);

        jbtnMoveNext.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveNext.setToolTipText("Next Entry");
        jbtnMoveNext.setLabel(">");
        jbtnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoveNextActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMoveNext);
        jbtnMoveNext.setBounds(440, 20, 50, 20);

        jbtnMoveLast.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jbtnMoveLast.setToolTipText("End Entry");
        jbtnMoveLast.setLabel(">|");
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
        jbtnDelete.setBounds(300, 20, 40, 20);

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
        jbtnBrowse6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse6ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse6);
        jbtnBrowse6.setBounds(190, 70, 30, 17);

        jbtnBrowse7.setText("...");
        jbtnBrowse7.setNextFocusableComponent(jtxtdocnumapplto);
        jbtnBrowse7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse7ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowse7);
        jbtnBrowse7.setBounds(700, 120, 30, 17);

        jlbldocdate1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocdate1.setText("Doc. Date");
        jPanel2.add(jlbldocdate1);
        jlbldocdate1.setBounds(10, 160, 100, 14);

        jtxtdoctotal1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdoctotal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotal1.setText("doctotal1");
        jtxtdoctotal1.setNextFocusableComponent(jtxtdscription);
        jtxtdoctotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdoctotal1ActionPerformed(evt);
            }
        });
        jtxtdoctotal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtdoctotal1PropertyChange(evt);
            }
        });
        jtxtdoctotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdoctotal1KeyReleased(evt);
            }
        });
        jPanel2.add(jtxtdoctotal1);
        jtxtdoctotal1.setBounds(110, 190, 130, 20);

        jtxttaxcodedesc.setEditable(false);
        jtxttaxcodedesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttaxcodedesc.setText("taxcode");
        jtxttaxcodedesc.setNextFocusableComponent(jtxttermcode);
        jtxttaxcodedesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttaxcodedescKeyPressed(evt);
            }
        });
        jPanel2.add(jtxttaxcodedesc);
        jtxttaxcodedesc.setBounds(230, 230, 300, 20);

        try {
            kdateentrydate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        kdateentrydate.setToolTipText("Tanggal Dokumen");
        kdateentrydate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdateentrydate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kdateentrydateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                kdateentrydateFocusLost(evt);
            }
        });
        kdateentrydate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                kdateentrydatePropertyChange(evt);
            }
        });
        kdateentrydate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdateentrydateKeyPressed(evt);
            }
        });
        jPanel2.add(kdateentrydate);
        kdateentrydate.setBounds(110, 160, 90, 20);

        try {
            kdocduedate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        kdocduedate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdocduedate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                kdocduedateFocusLost(evt);
            }
        });
        jPanel2.add(kdocduedate);
        kdocduedate.setBounds(110, 270, 80, 20);

        try {
            kdiscdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        kdiscdate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kdiscdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                kdiscdateFocusLost(evt);
            }
        });
        jPanel2.add(kdiscdate);
        kdiscdate.setBounds(340, 270, 80, 20);

        jlbldoctype1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldoctype1.setText("No. MR");
        jPanel2.add(jlbldoctype1);
        jlbldoctype1.setBounds(290, 110, 50, 20);

        jtxtNoMR.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtNoMR.setText("No MR");
        jPanel2.add(jtxtNoMR);
        jtxtNoMR.setBounds(340, 110, 120, 20);

        jbtnBrowseNoMR.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jbtnBrowseNoMR.setText("...");
        jbtnBrowseNoMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseNoMRActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBrowseNoMR);
        jbtnBrowseNoMR.setBounds(460, 110, 30, 20);

        jTabbedPane1.addTab("Invoice", jPanel2);

        jPanel3.setLayout(null);

        jtxtcustmrcode1.setEditable(false);
        jtxtcustmrcode1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrcode1.setText("custmrcode");
        jPanel3.add(jtxtcustmrcode1);
        jtxtcustmrcode1.setBounds(110, 10, 80, 20);

        jlblcustmrcode1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcustmrcode1.setText("Vendor");
        jPanel3.add(jlblcustmrcode1);
        jlblcustmrcode1.setBounds(10, 10, 140, 14);

        jtxtcustmrdesc1.setEditable(false);
        jtxtcustmrdesc1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcustmrdesc1.setText("jtxtcustmrdesc1");
        jPanel3.add(jtxtcustmrdesc1);
        jtxtcustmrdesc1.setBounds(190, 10, 420, 20);

        jlbldocnum1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum1.setText("Dist Amount");
        jPanel3.add(jlbldocnum1);
        jlbldocnum1.setBounds(280, 50, 120, 14);

        jtxtdocnum2.setEditable(false);
        jtxtdocnum2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum2.setText("docnum");
        jPanel3.add(jtxtdocnum2);
        jtxtdocnum2.setBounds(110, 30, 140, 20);

        jlblcurnccode1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblcurnccode1.setText("Currency");
        jPanel3.add(jlblcurnccode1);
        jlblcurnccode1.setBounds(620, 10, 60, 14);

        jtxtcurnccode1.setEditable(false);
        jtxtcurnccode1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtcurnccode1.setText("curnccode");
        jPanel3.add(jtxtcurnccode1);
        jtxtcurnccode1.setBounds(680, 10, 50, 20);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton1.setText("Create Distribution");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(550, 50, 170, 20);

        jtblDetail.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Dist. Code", "Description", "GL Account", "GL Description", "Amount", "Print", "Comment", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, false
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
            jtblDetail.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(2).setMinWidth(150);
            jtblDetail.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(3).setMinWidth(250);
            jtblDetail.getColumnModel().getColumn(3).setPreferredWidth(250);
            jtblDetail.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtblDetail.getColumnModel().getColumn(5).setMinWidth(50);
            jtblDetail.getColumnModel().getColumn(5).setPreferredWidth(50);
            jtblDetail.getColumnModel().getColumn(6).setMinWidth(130);
            jtblDetail.getColumnModel().getColumn(6).setPreferredWidth(130);
            jtblDetail.getColumnModel().getColumn(7).setMinWidth(0);
            jtblDetail.getColumnModel().getColumn(7).setPreferredWidth(0);
            jtblDetail.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 800, 190);

        jtxttaxcode1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttaxcode1.setText("taxcode");
        jtxttaxcode1.setNextFocusableComponent(jtblDetail);
        jtxttaxcode1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxttaxcode1KeyReleased(evt);
            }
        });
        jPanel3.add(jtxttaxcode1);
        jtxttaxcode1.setBounds(110, 50, 80, 20);

        jlbltaxcode1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltaxcode1.setText("Dist. Set");
        jPanel3.add(jlbltaxcode1);
        jlbltaxcode1.setBounds(10, 50, 100, 14);

        jbtnBrowse8.setText("...");
        jbtnBrowse8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse8ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnBrowse8);
        jbtnBrowse8.setBounds(190, 50, 30, 17);

        jlbldocnum2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum2.setText("Document");
        jPanel3.add(jlbldocnum2);
        jlbldocnum2.setBounds(10, 30, 100, 14);

        jtxtdistamount.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdistamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdistamount.setText("distamount");
        jtxtdistamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdistamountKeyReleased(evt);
            }
        });
        jPanel3.add(jtxtdistamount);
        jtxtdistamount.setBounds(400, 50, 140, 20);

        jtxtdocnum3.setEditable(false);
        jtxtdocnum3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdocnum3.setText("docnum");
        jPanel3.add(jtxtdocnum3);
        jtxtdocnum3.setBounds(400, 90, 140, 20);

        jlbldocnum3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum3.setText("UnDist. Amount");
        jPanel3.add(jlbldocnum3);
        jlbldocnum3.setBounds(280, 90, 120, 14);

        jlbldocnum4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocnum4.setText("Tax Total");
        jPanel3.add(jlbldocnum4);
        jlbldocnum4.setBounds(280, 70, 120, 14);

        jtxtdocnum4.setEditable(false);
        jtxtdocnum4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdocnum4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdocnum4.setText("docnum");
        jPanel3.add(jtxtdocnum4);
        jtxtdocnum4.setBounds(400, 70, 140, 20);

        jlbldocdate2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbldocdate2.setText("Doc Total");
        jPanel3.add(jlbldocdate2);
        jlbldocdate2.setBounds(280, 30, 100, 14);

        jtxtdoctotal2.setEditable(false);
        jtxtdoctotal2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtdoctotal2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtdoctotal2.setText("doctotal2");
        jtxtdoctotal2.setNextFocusableComponent(jtxtdscription);
        jtxtdoctotal2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtdoctotal2PropertyChange(evt);
            }
        });
        jtxtdoctotal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdoctotal2KeyReleased(evt);
            }
        });
        jPanel3.add(jtxtdoctotal2);
        jtxtdoctotal2.setBounds(400, 30, 140, 20);

        jTabbedPane1.addTab("Detail", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(60, 130, 820, 350);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(null);

        jlbltotinvamt1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlbltotinvamt1.setText("Batch Amount");
        jPanel4.add(jlbltotinvamt1);
        jlbltotinvamt1.setBounds(10, 10, 140, 14);

        jtxttotinvamt.setEditable(false);
        jtxttotinvamt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxttotinvamt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxttotinvamt.setText("totinvamt");
        jPanel4.add(jtxttotinvamt);
        jtxttotinvamt.setBounds(200, 10, 110, 20);

        jlblinventrcnt1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblinventrcnt1.setText("Total Entries");
        jPanel4.add(jlblinventrcnt1);
        jlblinventrcnt1.setBounds(10, 30, 140, 14);

        jtxtinventrcnt.setEditable(false);
        jtxtinventrcnt.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtinventrcnt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtinventrcnt.setText("inventrcnt");
        jPanel4.add(jtxtinventrcnt);
        jtxtinventrcnt.setBounds(200, 30, 110, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(560, 60, 320, 60);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton2.setText("Prepay...");
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 490, 100, 23);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton3.setText("Total...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 490, 100, 23);

        jtxtAccSetCode.setEditable(false);
        jtxtAccSetCode.setText("jtxtAccSetCode");
        getContentPane().add(jtxtAccSetCode);
        jtxtAccSetCode.setBounds(1080, 290, 110, 20);

        jlblbatchdate1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jlblbatchdate1.setText("Description");
        getContentPane().add(jlblbatchdate1);
        jlblbatchdate1.setBounds(60, 100, 100, 14);

        jtxtbatchdesc.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jtxtbatchdesc.setText("batchdesc");
        jtxtbatchdesc.setNextFocusableComponent(jchckReadyToPost);
        jtxtbatchdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbatchdescKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtbatchdesc);
        jtxtbatchdesc.setBounds(170, 100, 380, 20);

        jtxtdoctypeapplto.setEditable(false);
        jtxtdoctypeapplto.setText("jtxtdoctypeapplto");
        getContentPane().add(jtxtdoctypeapplto);
        jtxtdoctypeapplto.setBounds(930, 250, 160, 20);

        try {
            kbatchdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        kbatchdate.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        kbatchdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kbatchdateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                kbatchdateFocusLost(evt);
            }
        });
        getContentPane().add(kbatchdate);
        kbatchdate.setBounds(170, 80, 80, 20);

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

private void jtxtvendorcodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtvendorcodePropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtvendorcodePropertyChange

private void jtxtdiscprcntKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdiscprcntKeyReleased
    try {
        // TODO add your handling code here:
        caldiscount(apinvhh.getdoctotalamt());


    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtdiscvalueamt.requestFocus();
    }

}//GEN-LAST:event_jtxtdiscprcntKeyReleased

private void jtxtdiscvalueamtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdiscvalueamtKeyReleased
    try {
        // TODO add your handling code here:
        caldiscount(apinvhh.getdoctotalamt());
    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtcurnccode.requestFocus();
    }

}//GEN-LAST:event_jtxtdiscvalueamtKeyReleased

private void jbtnBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse1ActionPerformed
    // TODO add your handling code here:
    try {
        FrmBrowseObject bd = new FrmBrowseObject(obj.getDetail());
        bd.setFirstValue(jtxtdocentry);

        bd.setModal(true);
        bd.setVisible(true);

        int i = 0;
        for (Object o : obj.getDetail().list()) {
            Ap_invh ch = (Ap_invh) o;

            if ((ch.getdocentry() + "").equals(jtxtdocentry.getText())) {
                apinvhh = ch;

                showDataApInvhh();

                obj.setDtlslctdindx(i);
                jlbljrnldebit.setText("Index " + i + " of " + obj.getDetail().size());
                break;
            }
            i++;
        }

    } catch (CodeException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse1ActionPerformed

private void jbtnBrowse2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse2ActionPerformed
    // TODO add your handling code here:
    try {
        Op_paymentterms brs = new Op_paymentterms();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxttermcode);
        bd.setSecondValue(jtxttermdesc);
        bd.setModal(true);
        bd.setVisible(true);


    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse2ActionPerformed

private void jtxtvendordescPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtvendordescPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtvendordescPropertyChange

private void jbtnBrowse3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse3ActionPerformed
    // TODO add your handling code here:
    try {
        if (jcmbdoctype.getSelectedIndex() == 1 || jcmbdoctype.getSelectedIndex() == 2) {
            Ap_invobls brs = new Ap_invobls();
            FrmBrowseAp_invoblByVendor bd = new FrmBrowseAp_invoblByVendor(brs);
            bd.vendcode = jtxtvendorcode.getText();
            bd.retrieveData();
            bd.setFirstValue(jtxtdocnumapplto);
            bd.setSecondValue(jtxtdoctypeapplto);
            bd.setModal(true);
            bd.setVisible(true);
        } else {
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
        bd.setSecondValue(jtxttaxcodedesc);
        bd.setModal(true);
        bd.setVisible(true);


    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse4ActionPerformed

    private void findVendor() throws CodeException {



        jtxtcustmrcode1.setText(jtxtvendorcode.getText());
        jtxtcustmrdesc1.setText(jtxtvendordesc.getText());

        apvendor = new Ap_vendor(jtxtvendorcode.getText());
        jtxtvendorcode.setText(apvendor.getvendcode());
        jtxtvendordesc.setText(apvendor.getvendname());
        jtxtcurnccode1.setText(apvendor.getcurnccode());
        jtxtcurnccode.setText(apvendor.getcurnccode());
        jtxttaxcode.setText(apvendor.gettaxcode());

        Op_tax optax = new Op_tax(apvendor.gettaxcode());
        jtxttaxcodedesc.setText(optax.getdscription());

        jtxttermcode.setText(apvendor.gettermcode());

        jtxtAccSetCode.setText(apvendor.getaccsetcode());
        jtxtdistamount.setEnabled(false);

        if (apvendor.getdistby() == 0) {
            jtxttaxcode1.setText(apvendor.getdistsetcode());
            Ap_distsetds distset = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, jtxttaxcode1.getText());

            GlobalModel.clearRow(tmodeldetail);

            Double doctotal = GlobalUtils.toDbl(jtxtdistamount.getText());


            for (Object o : distset.list()) {
                Ap_distsetd distsetd = (Ap_distsetd) o;

                tmodeldetail.addRow(datadetail);

                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);

                tmodeldetail.setValueAt(distsetd.getdistcode(), tmodeldetail.getRowCount() - 1, 0);

                Ap_distcode apdistcode = new Ap_distcode(distsetd.getdistcode());
                tmodeldetail.setValueAt(apdistcode.getglacccodefmt(), tmodeldetail.getRowCount() - 1, 2);

                tmodeldetail.setValueAt(apdistcode.getGLAccDesc(), tmodeldetail.getRowCount() - 1, 3);

                tmodeldetail.setValueAt(doctotal / distset.list().size(), tmodeldetail.getRowCount() - 1, 4);

                cekApinvd();

            }


            jtxtdistamount.setEnabled(true);
        }
        if (apvendor.getdistby() == 1) {
            jtxttaxcode1.setText("");
            int i = 0;

            GlobalModel.clearRow(tmodeldetail);

            Double doctotal = GlobalUtils.toDbl(jtxtdistamount.getText());
            for (i = 0; i < 1; i++) {
                tmodeldetail.addRow(datadetail);

                GlobalUtils.selectCellTable(jtblDetail, i, 0);

                jtblDetail.setValueAt(apvendor.getdistcode(), i, 0);

                Ap_distcode apdistcode = new Ap_distcode(apvendor.getdistcode());
                tmodeldetail.setValueAt(apdistcode.getglacccodefmt(), tmodeldetail.getRowCount() - 1, 2);

                tmodeldetail.setValueAt(apdistcode.getGLAccDesc(), tmodeldetail.getRowCount() - 1, 3);

                tmodeldetail.setValueAt(doctotal, tmodeldetail.getRowCount() - 1, 4);

                cekApinvd();
            }
        }
        if (apvendor.getdistby() == 2) {
            jtxttaxcode1.setText("");
            int i = 0;

            GlobalModel.clearRow(tmodeldetail);

            Double doctotal = GlobalUtils.toDbl(jtxtdistamount.getText());
            for (i = 0; i < 1; i++) {
                tmodeldetail.addRow(datadetail);


                GlobalUtils.selectCellTable(jtblDetail, i, 0);

                jtblDetail.setValueAt(apvendor.getglacccode(), i, 2);

                tmodeldetail.setValueAt(apvendor.getGLAccDesc(), tmodeldetail.getRowCount() - 1, 3);

                tmodeldetail.setValueAt(doctotal, tmodeldetail.getRowCount() - 1, 4);

                cekApinvd();
            }
        }

        Op_paymentterm oterm = new Op_paymentterm(jtxttermcode.getText());
        jtxttermdesc.setText(oterm.getdscription());

    }

private void jbtnBrowseVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseVendorActionPerformed
    // TODO add your handling code here:
    try {
        Ap_vendors brs = new Ap_vendors();
        FrmBrowseAPVendor bd = new FrmBrowseAPVendor(brs, false);
        bd.setFirstValue(jtxtvendorcode);
        bd.setSecondValue(jtxtvendordesc);
        bd.setModal(true);
        bd.setVisible(true);


        findVendor();


    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowseVendorActionPerformed

    private void setDataAP_invhh(Boolean AffectArray) throws CodeException {

        apinvhh.fromString(Ap_invh.PROPERTY_DOCENTRY, jtxtdocentry.getText());
        apinvhh.fromString(Ap_invh.PROPERTY_VENDCODE, jtxtvendorcode.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_ADDRCODE, jtxtaddrcode.getText());

        apinvhh.setaccsetcode(jtxtAccSetCode.getText());
        int doctype = 0;
        switch (jcmbdoctype.getSelectedIndex()) {
            case 0:
                doctype = 4;
                break;
            case 1:
                doctype = 5;
                break;
            case 2:
                doctype = 6;
                break;
            case 3:
                doctype = 7;
                break;
        }

        apinvhh.fromString(Ap_invh.PROPERTY_DOCENTRY, jtxtdocentry.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_DOCTYPE, GlobalUtils.churuf(doctype));

        apinvhh.fromString(Ap_invh.PROPERTY_DOCNUM, jtxtdocnum.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_DSCRIPTION, jtxtdscription.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_DOCDATE, GlobalUtils.formatDate(kdateentrydate.getText(), "yyyy-MM-dd"));
        apinvhh.fromString(Ap_invh.PROPERTY_DOCDUEDATE, GlobalUtils.formatDate(kdocduedate.getText(), "yyyy-MM-dd"));
        apinvhh.fromString(Ap_invh.PROPERTY_DISCDATE, GlobalUtils.formatDate(kdiscdate.getText(), "yyyy-MM-dd"));

        apinvhh.fromString(Ap_invh.PROPERTY_MOP, jcbMOP.getSelectedItem().toString());
        apinvhh.fromString(Ap_invh.PROPERTY_YOP, jcbYOP.getSelectedItem().toString());

        apinvhh.fromString(Ap_invh.PROPERTY_TAXCODE, jtxttaxcode.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_DISTSETCODE, jtxttaxcode1.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_DISCPRCNT, jtxtdiscprcnt.getText());
        apinvhh.fromString(Ap_invh.PROPERTY_DISCVALUEAMT, jtxtdiscvalueamt.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_TERMCODE, jtxttermcode.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_CURNCCODE, jtxtcurnccode.getText());
        apinvhh.fromString(Ap_invh.PROPERTY_RATE, GlobalUtils.toDbl(jtxtrate.getText()) + "");

        apinvhh.fromString(Ap_invh.PROPERTY_DOCNUMAPPLTO, jtxtdocnumapplto.getText());
        apinvhh.fromString(Ap_invh.PROPERTY_DOCTYPEAPPLTO, jtxtdoctypeapplto.getText());
//    cbhh.fromString(Ar_invh.PROPERTY_SPECINSTR,jtxtspecinstr.getText());

        apinvhh.fromString(Ap_invh.PROPERTY_PONO, jtxtcustmrpono.getText());
        apinvhh.fromString(Ap_invh.PROPERTY_ORDERNO, jtxtorderno.getText());
        
        apinvhh.fromString(Ap_invh.PROPERTY_NOMATERIALRECEIVE, jtxtNoMR.getText());                

        if (AffectArray) {            
            if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*") || obj.getDtlslctdindx() < 0) {
                obj.adddetail(apinvhh);
            } else {
                if (obj.getDtlslctdindx() > -1) {
                    obj.replaceDetail(obj.getDtlslctdindx(), apinvhh);
                }
            }            
        }
    }
    
    

private void jtbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNewActionPerformed
    try {
        if (!isundistribtedexists()) {
            MOPChangedManually = false;
            objtmp = obj;
            jbtnMoveNext.setEnabled(false);
            jbtnMoveLast.setEnabled(false);
            jbtnDelete.setEnabled(false);
            //if (validasibalance()){
            //if(!obj.getDetail().list().isEmpty()) {
            setDataAP_invhh(true);
            //}

            apinvhh = new Ap_invh();
            //obj.getDetail().add(cbhh);

            obj.setDtlslctdindx(obj.getDetail().size());


            setAPInvhhEnable(true);
            jlbldocentry.setText("Doc Entry*");


            showDataApInvhh();


            kdateentrydate.setText(GlobalUtils.sessiondate);
            kdiscdate.setText(GlobalUtils.sessiondate);
            kdocduedate.setText(GlobalUtils.sessiondate);

            jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate) - 1);
            jcbYOP.setSelectedItem((long) GlobalUtils.getYear(GlobalUtils.sessiondate));
            //}
        }
    } catch (CodeException e) {
    }
}//GEN-LAST:event_jtbnNewActionPerformed

private void jbtnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveFirstActionPerformed
    if (!isundistribtedexists()) {
        jbtnMoveNext.setEnabled(true);
        jbtnMoveLast.setEnabled(true);
        jbtnDelete.setEnabled(true);
        MOPChangedManually = true;
        int pos = 0;
        try {
            pos = obj.getDtlslctdindx();
            setDataAP_invhh(true);
            jlbldocentry.setText("Doc Entry");
            if (pos > 0) {

                obj.setDtlslctdindx(0);
                apinvhh = (Ap_invh) obj.getDetail().list().get(0);
                showDataApInvhh();
            }


        } catch (Exception e) {
        }
    }
}//GEN-LAST:event_jbtnMoveFirstActionPerformed

private void jbtnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMovePreviousActionPerformed
    if (!isundistribtedexists()) {
        jbtnMoveNext.setEnabled(true);
        jbtnMoveLast.setEnabled(true);
        jbtnDelete.setEnabled(true);
        MOPChangedManually = true;
        int pos = 0;
        try {
            pos = obj.getDtlslctdindx();
            setDataAP_invhh(true);

            jlbldocentry.setText("Doc Entry");

            if (pos > 0) {

                obj.setDtlslctdindx(pos - 1);

                apinvhh = (Ap_invh) obj.getDetail().list().get(pos - 1);
                showDataApInvhh();

            }


        } catch (Exception e) {
        }

    }
}//GEN-LAST:event_jbtnMovePreviousActionPerformed

private void jbtnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveNextActionPerformed
    if (!isundistribtedexists()) {
        int pos = 0;
        try {
            pos = obj.getDtlslctdindx();
            setDataAP_invhh(true);
            MOPChangedManually = true;
            jlbldocentry.setText("Doc Entry");

            if (pos < obj.getDetail().list().size() - 1) {

                obj.setDtlslctdindx((pos + 1));

                apinvhh = (Ap_invh) obj.getDetail().list().get(pos + 1);
                showDataApInvhh();

            }


        } catch (Exception e) {
        }

    }
}//GEN-LAST:event_jbtnMoveNextActionPerformed

private void jbtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoveLastActionPerformed
    if (!isundistribtedexists()) {
        int pos = 0;
        try {
            pos = obj.getDtlslctdindx();
            MOPChangedManually = true;
            setDataAP_invhh(true);
            jlbldocentry.setText("Doc Entry");

            if (pos < obj.getDetail().list().size() - 1) {

                obj.setDtlslctdindx(obj.getDetail().list().size() - 1);

                apinvhh = (Ap_invh) obj.getDetail().list().get(obj.getDetail().list().size() - 1);
                showDataApInvhh();

            }


        } catch (Exception e) {
        }

    }
}//GEN-LAST:event_jbtnMoveLastActionPerformed

private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
    // TODO add your handling code here:
    int idelete = JOptionPane.showConfirmDialog(null, "Do you want to delete entry# " + jtxtdocentry.getText(), "Delete", JOptionPane.YES_NO_OPTION);

    if (idelete == JOptionPane.YES_OPTION) {
        try {

            obj.removeDetail(obj.getDtlslctdindx());

            obj = new Ap_invbatchlist(obj.getID());
            showData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}//GEN-LAST:event_jbtnDeleteActionPerformed

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

private void jbtnBrowse6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse6ActionPerformed
    // TODO add your handling code here:
    try {
        /*FrmAp_invpopaddress bd = new FrmAp_invpopaddress(cbhh);
        bd.setModal(true);
        bd.setVisible(true);*/
        Op_addresss brs = new Op_addresss(Op_address.PROPERTY_OBJTYPE, "2002");
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxtaddrcode);
        bd.setModal(true);
        bd.setVisible(true);
    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
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

private void jtblDetailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtblDetailPropertyChange
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();


    try {
        //if(posttable != row) {

        if (row > -1) {
            cekApinvd();
        }
        posttable = row;


        if (col == 0) {
            try {
                Ap_distcode apdistcode = new Ap_distcode((tmodeldetail.getValueAt(row, 0) + "").replace("-", ""));
                if (apdistcode.getID() > 0) {
                    tmodeldetail.setValueAt(apdistcode.getglacccodefmt(), row, 2);
                    tmodeldetail.setValueAt(apdistcode.getdscription(), row, 1);

                    Gl_account glacc = new Gl_account(apdistcode.getglacccode());
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, 3);

                    cekApinvd();
                }
            } catch (Exception e) {
            }
        }

        if (col == 2) {
            try {
                Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, col) + "").replace("-", ""));
                if (glacc.getID() > 0) {
                    tmodeldetail.setValueAt(glacc.getaccfmttd(), row, col);
                    tmodeldetail.setValueAt(glacc.getaccdesc(), row, col + 1);
                    this.setToolBar(iformtype, istatus);
                    unlockbutton(true);
                } else {
                    setToolBar(iformtype, 7);
                    unlockbutton(true);
                }
            } catch (Exception e) {
            }
        }

        if (col == 4) {
            double amount = GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 3)));

            apinvhh.setdoctotalamt(apinvhh.getDetailAmt());

            caldiscount(apinvhh.getdoctotalamt());

            jtxtdocnum3.setText(GlobalUtils.formatnumber(Math.abs(GlobalUtils.toDbl(jtxtdoctotal1.getText()) - apinvhh.getdoctotalamt())));
            jtxtdistamount.setText(GlobalUtils.formatnumber(apinvhh.getdoctotalamt()));


        }


        //}
    } catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jtblDetailPropertyChange

    private void caldiscount(Double invamount) {
        double discprcnt = GlobalUtils.toDbl(jtxtdiscprcnt.getText());
        double discamt = GlobalUtils.toDbl(jtxtdiscvalueamt.getText());

        if (discamt > 0) {
            discprcnt = (discamt / invamount) * 100;
        } else {
            discamt = invamount * discprcnt;
        }

        jtxtdiscprcnt.setText(GlobalUtils.formatnumber(discprcnt));
        jtxtdiscvalueamt.setText(GlobalUtils.formatnumber(discamt));
    }

private void jtblDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblDetailKeyPressed
    int row = jtblDetail.getSelectedRow();
    int col = jtblDetail.getSelectedColumn();

    if (evt.getKeyCode() == evt.VK_ENTER) {
        evt.consume();
        if (col < jtblDetail.getColumnCount() - 1) {
            GlobalUtils.selectCellTable(jtblDetail, row, col + 1);
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5 && row >= 0) {
        switch (col) {
            case 0:
                try {
                    Ap_distcodes brs = new Ap_distcodes();
                    FrmBrowse bd = new FrmBrowse(tmodeldetail, brs, row, 0);
                    bd.retrieveData();
                    bd.setModal(true);
                    bd.setVisible(true);

                    Ap_distcode apdistcode = new Ap_distcode((tmodeldetail.getValueAt(row, 0) + "").replace("-", ""));
                    if (apdistcode.getID() > 0) {
                        tmodeldetail.setValueAt(apdistcode.getglacccodefmt(), row, 2);
                        tmodeldetail.setValueAt(apdistcode.getdscription(), row, 1);

                        Gl_account glacc = new Gl_account(apdistcode.getglacccode());
                        tmodeldetail.setValueAt(glacc.getaccdesc(), row, 3);

                        cekApinvd();
                    }
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

                    Gl_account glacc = new Gl_account((tmodeldetail.getValueAt(row, 2) + "").replace("-", ""));
                    if (glacc.getID() > 0) {
                        tmodeldetail.setValueAt(glacc.getaccfmttd(), row, 2);
                        tmodeldetail.setValueAt(glacc.getaccdesc(), row, 3);
                        setToolBar(iformtype, istatus);
                    } else {
                        setToolBar(iformtype, 7);
                    }
                    cekApinvd();

                } catch (CodeException e) {
                    e.printStackTrace();
                }
                break;


        }
        if (row > -1) {
            try {
                cekApinvd();
            } catch (Exception e) {
            }
        }
    }

    if (evt.getKeyCode() == KeyEvent.VK_F12 || evt.getKeyCode() == 107) {
        if (col == 4) {
            frmCalculator frmcal = new frmCalculator(tmodeldetail, row, col);
            frmcal.setModal(true);
            frmcal.setVisible(true);
        }
    }

    if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
        if (row == jtblDetail.getRowCount() - 1 && !GlobalUtils.churuf(tmodeldetail.getValueAt(tmodeldetail.getRowCount() - 1, 2)).trim().equalsIgnoreCase("")) {
            tmodeldetail.addRow(datadetail);
        } else if (!GlobalUtils.churuf(tmodeldetail.getValueAt(tmodeldetail.getRowCount() - 1, 2)).trim().equalsIgnoreCase("")) {
            tmodeldetail.addRow(datadetail);
        }
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 4);
        try {
            if (apvendor.getdistby() == 1) {
                tmodeldetail.setValueAt(jtxttaxcode1.getText(), tmodeldetail.getRowCount() - 1, 0);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 0);
        if (row > -1) {
            try {
                cekApinvd();
            } catch (Exception e) {
            }
        }
    }
    if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

        int iquestion = JOptionPane.showConfirmDialog(null, "Anda Ingin Menghapus Baris Ke " + (row + 1), "Hapus ", JOptionPane.YES_NO_OPTION);
        if (iquestion == JOptionPane.YES_OPTION) {

            try {
                apinvhh.removeDetail(row, obj);

            } catch (Exception e) {/*e.printStackTrace();*/

            }


            tmodeldetail.removeRow(row);
            System.out.println("row2 " + row);

            if (row + 1 < tmodeldetail.getRowCount()) {
                GlobalUtils.selectCellTable(jtblDetail, row, 1);
            } else {
                GlobalUtils.selectCellTable(jtblDetail, tmodeldetail.getRowCount() - 1, 1);
            }

            try {

                jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.gettotinvamt()));
                jtxtinventrcnt.setText(GlobalUtils.formatnumber(obj.getinventrcnt()));
                System.out.println("1.Jumlah row:" + tmodeldetail.getRowCount());
                setDataAP_invhh(false);
                showDataApInvhh();
            } catch (Exception e) {/*e.printStackTrace();*/

            }

        }
    }
}//GEN-LAST:event_jtblDetailKeyPressed

private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    // TODO add your handling code here:
    jtxtdocnum2.setText(jtxtdocnum.getText());
    jtxtcurnccode1.setText(jtxtcurnccode.getText());
    jtxtcustmrcode1.setText(jtxtcustmrcode1.getText());
    jtxtcustmrdesc1.setText(jtxtvendordesc.getText());
}//GEN-LAST:event_jTabbedPane1MouseClicked

    private void calculateundistributed() throws CodeException {
        Double undistributed = new Double(0);
        Double doctoalafttaxamt = apinvhh.getdoctotalafttaxamt();
        Double doctotalamt = apinvhh.getdoctotalamt();
        Double taxtotalamt = apinvhh.gettaxtotalamt();

        undistributed = doctoalafttaxamt - (doctotalamt + taxtotalamt);

        jtxtdocnum3.setText(GlobalUtils.formatnumber(Math.abs(undistributed)));
    }

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {
        apinvhh.setvendcode(jtxtvendorcode.getText());

        int doctype = 0;
        switch (jcmbdoctype.getSelectedIndex()) {
            case 0:
                doctype = 4;
                break;
            case 1:
                doctype = 5;
                break;
            case 2:
                doctype = 6;
                break;
            case 3:
                doctype = 7;
                break;
        }
        apinvhh.setdoctype(GlobalUtils.churuf(doctype));
        apinvhh.setcurnccode(jtxtcurnccode.getText());
        apinvhh.settaxcode(jtxttaxcode.getText());
        apinvhh.settermcode(jtxttermcode.getText());
        apinvhh.setdoctotalamt(apinvhh.getDetailAmt());
        apinvhh.setdoctotalafttaxamt(GlobalUtils.toDbl(jtxtdoctotal1.getText()));

        FrmAp_invpopdoctotal poptotal = new FrmAp_invpopdoctotal(apinvhh);
        poptotal.setModal(true);
        poptotal.setVisible(true);

        jtxttaxcode.setText(apinvhh.gettaxcode());

        Op_tax optax = new Op_tax(apinvhh.gettaxcode());
        jtxttaxcodedesc.setText(optax.getdscription());

        jtxtdocnum4.setText(GlobalUtils.formatnumber(apinvhh.gettaxtotalamt()));

        calculateundistributed();

        double DetailAmt = 0;
        if (GlobalUtils.toInt(jtxtdocentry.getText()) == 0) {
            DetailAmt = apinvhh.getDetailAmt();

        }
        jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount() + (DetailAmt + apinvhh.gettaxtotalamt())));

    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jtxtdoctotal1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdoctotal1KeyReleased
    // TODO add your handling code here:
    Double doctotal = GlobalUtils.toDbl(jtxtdoctotal1.getText());

    jtxtdoctotal1.setText(GlobalUtils.formatnumber(doctotal));
    jtxtdoctotal1.setSelectionStart(jtxtdoctotal1.getText().length());
    jtxtdoctotal1.setSelectionEnd(jtxtdoctotal1.getText().length());

    try {
        apinvhh.setdoctotalafttaxamt(doctotal);

        calculateundistributed();
    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (evt.getKeyCode() == evt.VK_ENTER) {
        jtxtdscription.requestFocus();
    }


    jtxtdoctotal2.setText(jtxtdoctotal1.getText());

}//GEN-LAST:event_jtxtdoctotal1KeyReleased

private void jbtnBrowse8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse8ActionPerformed
    // TODO add your handling code here:
    try {

        Ap_distcodes brs = new Ap_distcodes();
        FrmBrowse bd = new FrmBrowse(brs);
        bd.setFirstValue(jtxttaxcode1);
        bd.setModal(true);
        bd.setVisible(true);

    } catch (CodeException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jbtnBrowse8ActionPerformed

private void jtxtdoctotal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtdoctotal1PropertyChange
    // TODO add your handling code here:

}//GEN-LAST:event_jtxtdoctotal1PropertyChange

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    Double doctotal = GlobalUtils.toDbl(jtxtdistamount.getText());


    try {
        int i = 0;
        int numline = 0;


        for (i = 0; i < jtblDetail.getRowCount(); i++) {
            String acccode = GlobalUtils.churuf(jtblDetail.getValueAt(i, 2));
            acccode = acccode.replace("-", "");
            Gl_account glacc = new Gl_account(acccode);
            if (glacc.getID() > 0) {
                numline++;
            }
        }

        Integer counter = new Integer(0);
        Double sisa = new Double(0);
        Double used = new Double(0);
        for (i = 0; i < jtblDetail.getRowCount(); i++) {

            String acccode = GlobalUtils.churuf(jtblDetail.getValueAt(i, 2));
            acccode = acccode.replace("-", "");
            Gl_account glacc = new Gl_account(acccode);


            if (glacc.getID() > 0) {
                GlobalUtils.selectCellTable(jtblDetail, i, 0);

                counter++;

                if (numline == counter) {
                    sisa = doctotal - used;
                    tmodeldetail.setValueAt(sisa, i, 4);
                } else {
                    used = used + Math.floor(doctotal / numline);
                    tmodeldetail.setValueAt(Math.floor(doctotal / numline), i, 4);
                }

                cekApinvd();
            }
        }

        calculateundistributed();
    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jtxttaxcode1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttaxcode1KeyReleased


    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtblDetail.requestFocus();
        GlobalUtils.selectCellTable(jtblDetail, 0, 0);
    }


}//GEN-LAST:event_jtxttaxcode1KeyReleased

private void jtxtdistamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdistamountKeyReleased
    try {
        // TODO add your handling code here:
        Double doctotal = GlobalUtils.toDbl(jtxtdistamount.getText());
        jtxtdistamount.setText(GlobalUtils.formatnumber(doctotal));
        jtxtdistamount.setSelectionStart(jtxtdoctotal1.getText().length());
        jtxtdistamount.setSelectionEnd(jtxtdistamount.getText().length());
        apinvhh.setdoctotalamt(doctotal);

        calculateundistributed();
    } catch (CodeException ex) {
        Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxttaxcode1.requestFocus();
    }


}//GEN-LAST:event_jtxtdistamountKeyReleased

private void jtxtbatchnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchnoKeyPressed



    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        kbatchdate.requestFocus();
    }

}//GEN-LAST:event_jtxtbatchnoKeyPressed

private void jtxtbatchdescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbatchdescKeyPressed


    if (evt.getKeyCode() == evt.VK_ENTER) {
        jchckReadyToPost.requestFocus();
    }

}//GEN-LAST:event_jtxtbatchdescKeyPressed

private void jtxtvendorcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtvendorcodeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            findVendor();
        } catch (Exception e) {
        }
        jtxtaddrcode.requestFocus();
    }

}//GEN-LAST:event_jtxtvendorcodeKeyPressed

private void jtxtaddrcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtaddrcodeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jcmbdoctype.requestFocus();
    }

}//GEN-LAST:event_jtxtaddrcodeKeyPressed

private void jcmbdoctypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbdoctypeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtdocnum.requestFocus();
    }

}//GEN-LAST:event_jcmbdoctypeKeyPressed

private void jtxtdocnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        kdateentrydate.requestFocus();
    }
}//GEN-LAST:event_jtxtdocnumKeyPressed

private void jcbYOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbYOPKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jcbMOP.requestFocus();
    }
}//GEN-LAST:event_jcbYOPKeyPressed

private void jcbMOPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMOPKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
       // jtxtdoctotal1.requestFocus();
    }

}//GEN-LAST:event_jcbMOPKeyPressed

private void jtxtdscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdscriptionKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxttaxcode.requestFocus();
    }
}//GEN-LAST:event_jtxtdscriptionKeyPressed

private void jtxttaxcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttaxcodeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        Op_tax optax;
        try {
            optax = new Op_tax(jtxttaxcode.getText());
            jtxttaxcodedesc.setText(optax.getdscription());
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }


        jtxttermcode.requestFocus();
    }

}//GEN-LAST:event_jtxttaxcodeKeyPressed

private void jtxttermcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttermcodeKeyPressed


    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            Op_paymentterm brs = new Op_paymentterm(jtxttermcode.getText());
            jtxttermdesc.setText(brs.getdscription());

        } catch (Exception e) {
        }


        kdocduedate.requestFocus();
    }
}//GEN-LAST:event_jtxttermcodeKeyPressed

private void jtxtcurnccodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcurnccodeKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtdocnumapplto.requestFocus();
    }

}//GEN-LAST:event_jtxtcurnccodeKeyPressed

private void jtxtdocnumappltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdocnumappltoKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtrate.requestFocus();
    }
}//GEN-LAST:event_jtxtdocnumappltoKeyPressed

private void jtxtrateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtrateKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtcustmrpono.requestFocus();
    }

}//GEN-LAST:event_jtxtrateKeyPressed

private void jtxtcustmrponoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcustmrponoKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtxtorderno.requestFocus();
    }

}//GEN-LAST:event_jtxtcustmrponoKeyPressed

private void jtxtordernoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtordernoKeyPressed

    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jTabbedPane1.setSelectedIndex(2);
        //jtblDetail.requestFocus();
        //jtxtdistamount.requestFocus();
        jtxttaxcode1.requestFocus();
    }

}//GEN-LAST:event_jtxtordernoKeyPressed

private void jtxtdocnumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtdocnumFocusLost
    try {
        if (apinvhh.getID() == Ap_invh.NULLID) {
            if (apinvhh.isAlreadyCreated(jtxtvendorcode.getText(), jcmbdoctype.getSelectedIndex(), jtxtdocnum.getText())) {
                JOptionPane.showConfirmDialog(null, "Sudah Pernah Terbuat");
            }
        }
    } catch (Exception e) {
    }


}//GEN-LAST:event_jtxtdocnumFocusLost

private void jtxtdoctotal2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtdoctotal2PropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtdoctotal2PropertyChange

private void jtxtdoctotal2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdoctotal2KeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtdoctotal2KeyReleased

private void jcbMOPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMOPMouseReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jcbMOPMouseReleased

private void jcbMOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually = true;
}//GEN-LAST:event_jcbMOPFocusLost

private void jtxttaxcodedescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttaxcodedescKeyPressed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxttaxcodedescKeyPressed

private void jtxtdocnumappltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdocnumappltoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtdocnumappltoActionPerformed

private void jcbYOPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusLost
    // TODO add your handling code here:
    MOPChangedManually = true;
}//GEN-LAST:event_jcbYOPFocusLost

private void jcbYOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYOPItemStateChanged
    // TODO add your handling code here:
    if (!onload) {
        checklockedperiode();
    }
}//GEN-LAST:event_jcbYOPItemStateChanged

private void jcbMOPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMOPItemStateChanged
    // TODO add your handling code here:
    if (!onload) {
        checklockedperiode();
    }
}//GEN-LAST:event_jcbMOPItemStateChanged

private void jcbMOPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMOPMousePressed
    // TODO add your handling code here:
}//GEN-LAST:event_jcbMOPMousePressed

private void jcbMOPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMOPMouseEntered
    // TODO add your handling code here:
}//GEN-LAST:event_jcbMOPMouseEntered

private void jcbMOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbMOPFocusGained
    // TODO add your handling code here:
    mopbf = GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
}//GEN-LAST:event_jcbMOPFocusGained

private void jcbYOPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbYOPFocusGained
    // TODO add your handling code here:
    yopbf = GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
}//GEN-LAST:event_jcbYOPFocusGained

private void kbatchdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kbatchdateFocusGained
    // TODO add your handling code here:
    kbatchdate.setSelectionStart(0);
    kbatchdate.setSelectionEnd(kbatchdate.getText().length());
}//GEN-LAST:event_kbatchdateFocusGained

private void kdateentrydatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_kdateentrydatePropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_kdateentrydatePropertyChange

private void kdateentrydateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdateentrydateKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode() == evt.VK_ENTER) {
        if (!MOPChangedManually) {
            jcbMOP.setSelectedItem(GlobalUtils.formatmonth((long) GlobalUtils.getMonth(kdateentrydate.getText())));
            jcbYOP.setSelectedItem((long) GlobalUtils.getYear(kdateentrydate.getText()));
        }
    }
}//GEN-LAST:event_kdateentrydateKeyPressed

private void kdateentrydateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdateentrydateFocusGained
    // TODO add your handling code here:
    kdateentrydate.setSelectionStart(0);
    kdateentrydate.setSelectionEnd(kdateentrydate.getText().length());
}//GEN-LAST:event_kdateentrydateFocusGained

private void kbatchdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kbatchdateFocusLost
    // TODO add your handling code here:
    if (!dateisvalid(kbatchdate.getText())) {
        JOptionPane.showMessageDialog(this, "Date Invalid");
        kbatchdate.requestFocus();
    }
}//GEN-LAST:event_kbatchdateFocusLost

private void kdateentrydateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdateentrydateFocusLost
    // TODO add your handling code here:
    if (!dateisvalid(kdateentrydate.getText())) {
        JOptionPane.showMessageDialog(this, "Date Invalid");
        kdateentrydate.requestFocus();
    }
}//GEN-LAST:event_kdateentrydateFocusLost

private void kdocduedateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdocduedateFocusLost
    // TODO add your handling code here:
    if (!dateisvalid(kdocduedate.getText())) {
        JOptionPane.showMessageDialog(this, "Date Invalid");
        kdocduedate.requestFocus();
    }
}//GEN-LAST:event_kdocduedateFocusLost

private void kdiscdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kdiscdateFocusLost
    // TODO add your handling code here:
    if (!dateisvalid(kdiscdate.getText())) {
        JOptionPane.showMessageDialog(this, "Date Invalid");
        kdiscdate.requestFocus();
    }
}//GEN-LAST:event_kdiscdateFocusLost

private void jtxtdiscvalueamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdiscvalueamtActionPerformed
    // TODO add your handling code here:
    
}//GEN-LAST:event_jtxtdiscvalueamtActionPerformed

private void jcbMOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMOPActionPerformed
    // TODO add your handling code here:

}//GEN-LAST:event_jcbMOPActionPerformed

private void jtxtdoctotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdoctotal1ActionPerformed
    // TODO add your handling code here:

}//GEN-LAST:event_jtxtdoctotal1ActionPerformed

    private void jbtnBrowseNoMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseNoMRActionPerformed
        try {

            H_material_receives brs = new H_material_receives();
            FrmBrowse bd = new FrmBrowse(brs);
            bd.setSecondValue(jtxtNoMR);
            bd.setModal(true);
            bd.setVisible(true);

        } catch (CodeException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jbtnBrowseNoMRActionPerformed


    private Boolean dateisvalid(String tgl) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date vdate = null;
        try {
            vdate = sdf.parse(tgl);
            return true;
        } catch (ParseException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void checklockedperiode() {
        Boolean ischanged = false;
        int yopentry = GlobalUtils.toInt(GlobalUtils.churuf(jcbYOP.getSelectedItem()));
        if (yopentry != yopbf) {
            ischanged = true;
        }
        int mopentry = GlobalUtils.toInt(GlobalUtils.churuf(jcbMOP.getSelectedItem()));
        if (mopentry != mopbf) {
            ischanged = true;
        }
        if (ischanged) {
            try {
                Gl_fiscalh ofisc = new Gl_fiscalh(Gl_fiscalh.PROPERTY_YOP, yopentry + "");
                if (ofisc.getIsperiodelocked(mopentry)) {
                    onload = true;
                    onload = false;

                    jtbnNew.setEnabled(false);
                    jbtnDelete.setEnabled(false);
                    jbtnMoveFirst.setEnabled(true);
                    jbtnMovePrevious.setEnabled(true);
                    jbtnMoveNext.setEnabled(true);
                    jbtnMoveLast.setEnabled(true);
                    JOptionPane.showMessageDialog(this, "Invalid Procedure, Fiscal Period Is Locked");

                    mf.setToolBar(iformtype, 7);
                } else {
                    jtbnNew.setEnabled(true);
                    jbtnDelete.setEnabled(true);
                    jbtnMoveFirst.setEnabled(true);
                    jbtnMovePrevious.setEnabled(true);
                    if (jlbldocentry.getText().equalsIgnoreCase("docentry*")) {
                        jbtnMoveNext.setEnabled(true);
                        jbtnMoveLast.setEnabled(true);
                    }

                    mf.setToolBar(iformtype, istatus);
                }
            } catch (CodeException ex) {
                Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cekApinvd() throws CodeException {

        int row = jtblDetail.getSelectedRow();
        int col = jtblDetail.getSelectedColumn();


        Ap_invd apinvd;
        if (row > apinvhds.list().size() - 1) {
            apinvd = new Ap_invd();
            apinvhds.add(apinvd);
        } else {
            apinvd = (Ap_invd) apinvhds.list().get(row);
        }

        long idAPinvhd = 0;
        try {
            idAPinvhd = Long.parseLong(tmodeldetail.getValueAt(row, tmodeldetail.getColumnCount() - 1) + "");
        } catch (Exception e) {
        }

        apinvd.setID(idAPinvhd);
        apinvd.setdistcode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 0)));
        apinvd.setdscription(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 1)));
        apinvd.setaccglcode(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 2)).replace("-", ""));
        apinvd.setdetailamt(GlobalUtils.toDbl(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 4))));
        apinvd.setcomment(tmodeldetail.getValueAt(row, 6) + "");

        //cbhd.setaccrevdscription(GlobalUtils.churuf(tmodeldetail.getValueAt(row, 5)));

        apinvhds.list().set(row, apinvd);

        double DetailAmt = 0;
        if (GlobalUtils.toInt(jtxtdocentry.getText()) == 0) {
            if (jcmbdoctype.getSelectedIndex() == 1) {
                DetailAmt = apinvhh.getDetailAmt() * -1;
            } else {
                DetailAmt = apinvhh.getDetailAmt();
            }
        }
        jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.getTotalAmount() + DetailAmt));
    }

    public void showDataApInvhh() throws CodeException {
        onload = true;
        //System.out.println(cbhh.getID() + "   " + cbhh.getdscription());

        jtxtdocentry.setText(GlobalUtils.churuf(apinvhh.getdocentry()));
        jtxtvendorcode.setText(apinvhh.getvendcode());

        jtxtcustmrcode1.setText(apinvhh.getvendcode());

        apvendor = new Ap_vendor(apinvhh.getvendcode());
        jtxtvendordesc.setText(apvendor.getvendname());

        jtxtcustmrdesc1.setText(apvendor.getvendname());

        jtxtaddrcode.setText(apinvhh.getaddrcode());
        jtxtdocnum.setText(apinvhh.getdocnum());

        jtxtdocnum2.setText(apinvhh.getdocnum());

        jtxtdscription.setText(apinvhh.getdscription());

        kdateentrydate.setText(GlobalUtils.formatDate(apinvhh.getdocdate(), "MM/dd/yyyy"));
        kdocduedate.setText(GlobalUtils.formatDate(apinvhh.getdocduedate(), "MM/dd/yyyy"));
        kdiscdate.setText(GlobalUtils.formatDate(apinvhh.getdiscdate(), "MM/dd/yyyy"));

        mopbf = apinvhh.getmop();
        yopbf = apinvhh.getyop();
        String mop = "";
        if (apinvhh.getmop() < 10) {
            mop = "0" + apinvhh.getmop();
        } else {
            mop = apinvhh.getmop() + "";
        }

        jtxtAccSetCode.setText(apinvhh.getaccsetcode());

        jcbMOP.setSelectedItem(mop);
        jcbYOP.setSelectedItem(apinvhh.getyop());

        int doctype = GlobalUtils.toInt(GlobalUtils.churuf(apinvhh.getdoctype()));
        switch (doctype) {
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

        jtxttaxcode.setText(apinvhh.gettaxcode());
        Op_tax optax = new Op_tax(apinvhh.gettaxcode());
        jtxttaxcodedesc.setText(optax.getdscription());

        jtxttaxcode1.setText(apinvhh.getdistsetcode());

        jtxtdiscprcnt.setText(GlobalUtils.formatnumber(apinvhh.getdiscprcnt()));
        jtxtdiscvalueamt.setText(GlobalUtils.formatnumber(apinvhh.getdiscvalueamt()));

        jtxttermcode.setText(apinvhh.gettermcode());
        Op_paymentterm opterm = new Op_paymentterm(apinvhh.gettermcode());
        jtxttermdesc.setText(opterm.getdscription());

        jtxtcurnccode.setText(apinvhh.getcurnccode());

        jtxtcurnccode1.setText(apinvhh.getcurnccode());

        jtxtrate.setText(GlobalUtils.formatnumber(apinvhh.getrate()));

        jtxtdocnumapplto.setText(apinvhh.getdocnumapplto());
        jtxtdoctypeapplto.setText(apinvhh.getdoctypeapplto());


        jtxtdoctotal1.setText(GlobalUtils.formatnumber(apinvhh.getdoctotalamt()));
        jtxtdoctotal2.setText(jtxtdoctotal1.getText());
        jtxtdistamount.setText(GlobalUtils.formatnumber(apinvhh.getdoctotalamt()));

        jtxtdocnum4.setText(GlobalUtils.formatnumber(apinvhh.gettaxtotalamt()));

        jtxtcustmrpono.setText(apinvhh.getpono());
        jtxtorderno.setText(apinvhh.getorderno());
        jtxtNoMR.setText(apinvhh.getnomaterialreceive());

        calculateundistributed();

        visiblefield();

        apinvhds = apinvhh.getDetail();

        if (jlbldocentry.getText().equalsIgnoreCase("Doc Entry*")) {
            jlbljrnldebit.setText("Index * of " + obj.getDetail().size());
        } else {
            jlbljrnldebit.setText("Index " + (obj.getDtlslctdindx() + 1) + " of " + obj.getDetail().size());
        }

        try {
            showDataCbhd();
        } catch (Exception e) {
        }

        jtxtdocnum3.setText(GlobalUtils.formatnumber(Math.abs(GlobalUtils.toDbl(jtxtdistamount.getText()) - apinvhh.getdoctotalamt())));

        onload = false;
    }

    private void visibleaddon(Boolean bvisible) {
        jlbltermcode.setVisible(bvisible);
        jtxttermcode.setVisible(bvisible);
        jbtnBrowse2.setVisible(bvisible);
        jtxttermdesc.setVisible(bvisible);

        jlbldocduedate.setVisible(bvisible);
        kdocduedate.setVisible(bvisible);

        jlbldiscdate.setVisible(bvisible);
        kdiscdate.setVisible(bvisible);

        jlbldiscprcnt.setVisible(bvisible);
        jtxtdiscprcnt.setVisible(bvisible);

        jlbldiscvalueamt.setVisible(bvisible);
        jtxtdiscvalueamt.setVisible(bvisible);


    }

    private void visiblefield() {
        visibleaddon(true);


        switch (jcmbdoctype.getSelectedIndex()) {
            case 0://Invoice,
                jlbldocnumapplto.setVisible(false);
                jbtnBrowse3.setVisible(false);
                jtxtdocnumapplto.setVisible(false);
                break;
            case 1://Credit Note,
                jlbldocnumapplto.setVisible(true);
                jbtnBrowse3.setVisible(true);
                jtxtdocnumapplto.setVisible(true);
                visibleaddon(false);
                break;
            case 2://Debit Note,
                jlbldocnumapplto.setVisible(true);
                jbtnBrowse3.setVisible(true);
                jtxtdocnumapplto.setVisible(true);
                visibleaddon(false);
                break;
            case 3://Interest Invoice
                jlbldocnumapplto.setVisible(false);
                jbtnBrowse3.setVisible(false);
                jtxtdocnumapplto.setVisible(false);
                visibleaddon(false);

                jlbltaxcode.setVisible(false);
                jtxttaxcode.setVisible(false);
                jbtnBrowse4.setVisible(false);
                break;
        }
    }

    public void showDataCbhd() throws CodeException {

        GlobalModel.clearRow(tmodeldetail);
        tmodeldetail.addRow(datadetail);
        tmodeldetail.setValueAt("0", tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);
        tmodeldetail.setValueAt(0, tmodeldetail.getRowCount() - 1, 4);
        GlobalUtils.selectCellTable(jtblDetail, 0, 1);

        posttable = -1;


        for (Object o : apinvhds.list()) {
            Ap_invd cbhd = (Ap_invd) o;


            tmodeldetail.setValueAt(cbhd.getID(), tmodeldetail.getRowCount() - 1, tmodeldetail.getColumnCount() - 1);

            tmodeldetail.setValueAt(cbhd.getdistcode(), tmodeldetail.getRowCount() - 1, 0);
            tmodeldetail.setValueAt(cbhd.getdscription() == null ? "" : cbhd.getdscription(), tmodeldetail.getRowCount() - 1, 1);
            tmodeldetail.setValueAt(cbhd.getaccglcodefmt(), tmodeldetail.getRowCount() - 1, 2);
            tmodeldetail.setValueAt(cbhd.getaccgldscription(), tmodeldetail.getRowCount() - 1, 3);

            tmodeldetail.setValueAt(cbhd.getdetailamt(), tmodeldetail.getRowCount() - 1, 4);

            tmodeldetail.setValueAt(cbhd.getdetailamt(), tmodeldetail.getRowCount() - 1, 5);
            tmodeldetail.setValueAt(cbhd.getcomment(), tmodeldetail.getRowCount() - 1, 6);

            tmodeldetail.addRow(datadetail);
        }


    }

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
        mf.setIcon(CLASSNAME);
        setToolBar(iformtype, istatus);
        //
    }

    private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Q_ap_invbatchlists brs = new Q_ap_invbatchlists();
            FrmBrowse bd = new FrmBrowse(this, brs);
            bd.setFirstValue(jtxtbatchno);
            bd.setModal(true);
            bd.setVisible(true);

            obj = new Ap_invbatchlist(jtxtbatchno.getText());
            MOPChangedManually = true;
            showData();
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
                    new FrmAp_invbatchlist().setVisible(true);
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
    private javax.swing.JButton jbtnBrowse8;
    private javax.swing.JButton jbtnBrowseNoMR;
    private javax.swing.JButton jbtnBrowseVendor;
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
    private javax.swing.JLabel jlblbatchdate1;
    private javax.swing.JLabel jlblbatchno;
    private javax.swing.JLabel jlblbatchsts1;
    private javax.swing.JLabel jlblbatchtype1;
    private javax.swing.JLabel jlblcurnccode;
    private javax.swing.JLabel jlblcurnccode1;
    private javax.swing.JLabel jlblcustmrcode;
    private javax.swing.JLabel jlblcustmrcode1;
    private javax.swing.JLabel jlblcustmrpono;
    private javax.swing.JLabel jlbldiscdate;
    private javax.swing.JLabel jlbldiscprcnt;
    private javax.swing.JLabel jlbldiscvalueamt;
    private javax.swing.JLabel jlbldocdate;
    private javax.swing.JLabel jlbldocdate1;
    private javax.swing.JLabel jlbldocdate2;
    private javax.swing.JLabel jlbldocduedate;
    private javax.swing.JLabel jlbldocentry;
    private javax.swing.JLabel jlbldocnum;
    private javax.swing.JLabel jlbldocnum1;
    private javax.swing.JLabel jlbldocnum2;
    private javax.swing.JLabel jlbldocnum3;
    private javax.swing.JLabel jlbldocnum4;
    private javax.swing.JLabel jlbldocnumapplto;
    private javax.swing.JLabel jlbldoctype;
    private javax.swing.JLabel jlbldoctype1;
    private javax.swing.JLabel jlbldscription;
    private javax.swing.JLabel jlblinventrcnt1;
    private javax.swing.JLabel jlbljrnldebit;
    private javax.swing.JLabel jlblmop;
    private javax.swing.JLabel jlblorderno;
    private javax.swing.JLabel jlblrate;
    private javax.swing.JLabel jlblreadytpost1;
    private javax.swing.JLabel jlbltaxcode;
    private javax.swing.JLabel jlbltaxcode1;
    private javax.swing.JLabel jlbltermcode;
    private javax.swing.JLabel jlbltotinvamt1;
    private javax.swing.JLabel jlblyop;
    private javax.swing.JTable jtblDetail;
    private javax.swing.JButton jtbnNew;
    private javax.swing.JTextField jtxtAccSetCode;
    private javax.swing.JTextField jtxtNoMR;
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
    private javax.swing.JTextField jtxtcustmrcode1;
    private javax.swing.JTextField jtxtcustmrdesc1;
    private javax.swing.JTextField jtxtcustmrpono;
    private javax.swing.JTextField jtxtdiscprcnt;
    private javax.swing.JTextField jtxtdiscvalueamt;
    private javax.swing.JTextField jtxtdistamount;
    private javax.swing.JTextField jtxtdocentry;
    private javax.swing.JTextField jtxtdocnum;
    private javax.swing.JTextField jtxtdocnum2;
    private javax.swing.JTextField jtxtdocnum3;
    private javax.swing.JTextField jtxtdocnum4;
    private javax.swing.JTextField jtxtdocnumapplto;
    private javax.swing.JTextField jtxtdoctotal1;
    private javax.swing.JTextField jtxtdoctotal2;
    private javax.swing.JTextField jtxtdoctypeapplto;
    private javax.swing.JTextField jtxtdscription;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtinventrcnt;
    private javax.swing.JTextField jtxtorderno;
    private javax.swing.JTextField jtxtrate;
    private javax.swing.JTextField jtxttaxcode;
    private javax.swing.JTextField jtxttaxcode1;
    private javax.swing.JTextField jtxttaxcodedesc;
    private javax.swing.JTextField jtxttermcode;
    private javax.swing.JTextField jtxttermdesc;
    private javax.swing.JTextField jtxttotinvamt;
    private javax.swing.JTextField jtxtvendorcode;
    private javax.swing.JTextField jtxtvendordesc;
    private javax.swing.JFormattedTextField kbatchdate;
    private javax.swing.JFormattedTextField kdateentrydate;
    private javax.swing.JFormattedTextField kdiscdate;
    private javax.swing.JFormattedTextField kdocduedate;
    // End of variables declaration//GEN-END:variables

    public void moveFirst() throws CodeException {
        jlbldocentry.setText("Doc Entry");
        if (objtmp != null) {
            obj = objtmp;
        }
        MOPChangedManually = true;
        obj.moveFirst();
        showData();

    }

    public void movePrevious() throws CodeException {
        jlbldocentry.setText("Doc Entry");
        if (objtmp != null) {
            obj = objtmp;
        }
        MOPChangedManually = true;
        obj.movePrevious();
        showData();

    }

    public void moveNext() throws CodeException {
        jlbldocentry.setText("Doc Entry");
        if (objtmp != null) {
            obj = objtmp;
        }
        MOPChangedManually = true;
        obj.moveNext();
        showData();

    }

    public void moveLast() throws CodeException {
        jlbldocentry.setText("Doc Entry");
        if (objtmp != null) {
            obj = objtmp;
        }
        MOPChangedManually = true;
        obj.moveLast();
        showData();

    }

    public void searchData() throws CodeException {
        obj = new Ap_invbatchlist(this.jtxtbatchno.getText());
        MOPChangedManually = true;
        showData();

    }

    public void buttonEnable(boolean val) {
        mf.btnSave.setEnabled(val);
        mf.btnDel.setEnabled(val);
        mf.btnConfirm.setEnabled(val);
        jtbnNew.setEnabled(val);
        jbtnDelete.setEnabled(val);
    }

    public void newData() throws CodeException {
        objtmp = obj;
        obj = new Ap_invbatchlist();
        obj.setreadytpost("0");

        istatus = 1;
        jlbldocentry.setText("Doc Entry*");
        showData();

        kbatchdate.setText(GlobalUtils.sessiondate);
        kdateentrydate.setText(GlobalUtils.sessiondate);
        kdiscdate.setText(GlobalUtils.sessiondate);
        kdocduedate.setText(GlobalUtils.sessiondate);

        jcbMOP.setSelectedIndex(GlobalUtils.getMonth(GlobalUtils.sessiondate) - 1);
        MOPChangedManually = false;
        setToolBar(iformtype, istatus);
    }

    private Boolean isundistribtedexists() {
        if (GlobalUtils.toDbl(jtxtdocnum3.getText()) > 0) {
            JOptionPane.showMessageDialog(this, "Invalid Procedure, Undistributed Amount Exists");
            return true;
        }
        return false;
    }

    public void saveData() throws CodeException {


        if (!isundistribtedexists()) {
            istatus = 0;

            setData();

            setDataAP_invhh(true);                        

            obj.save();
            if (obj.getDetail().size() == 1) {
                obj.setDtlslctdindx(obj.getDetail().size() - 1);
            }
            jlbldocentry.setText("Doc Entry");
            
            int lastDocId = (int) (obj.getinventrcnt());
            int batchNo = (int) obj.getbatchno();
            String noMR = jtxtNoMR.getText();
                        
            //saveDetailMR(noMR, batchNo, lastDocId);
            
            showData();


            if (obj.getbatchsts().equals("2")) {
                buttonEnable(false);
            } else {
                buttonEnable(true);
            }
        }
    }

    public void setap_invbatchlist(Ap_invbatchlist obj) {
        this.obj = obj;
        try {
            showData();
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showData() throws CodeException {
        if (obj.getbatchsts() != null) {
            if (obj.getbatchsts().equals("2")) {
                buttonEnable(false);
            } else {
                buttonEnable(true);
            }
        } else {
            buttonEnable(true);
        }
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        jtxtid.setText(obj.toString(Ap_invbatchlist.PROPERTY_ID));
        jtxtbatchno.setText(obj.toString(Ap_invbatchlist.PROPERTY_BATCHNO));

        kbatchdate.setText(GlobalUtils.formatDate(obj.toString(Ap_invbatchlist.PROPERTY_BATCHDATE), "MM/dd/yyyy"));

        jtxtbatchdesc.setText(obj.toString(Ap_invbatchlist.PROPERTY_BATCHDESC));

        if (GlobalUtils.churuf(obj.getreadytpost()).equalsIgnoreCase("1")) {
            jchckReadyToPost.setSelected(true);
        } else {
            jchckReadyToPost.setSelected(false);
        }


        String batchtype = "";
        switch (GlobalUtils.toInt(GlobalUtils.churuf(obj.getbatchtype()))) {
            case 1:
                batchtype = "Entries";
                break;
            case 2:
                batchtype = "Import";
                break;
            case 3:
                batchtype = "Transfer";
                break;
        }
        jtxtbatchtype.setText(batchtype);

        String batchstatus = "Open";
        try {
            switch (GlobalUtils.toInt(obj.getbatchsts())) {
                case 1:
                    batchstatus = "Open";
                    break;
                case 2:
                    batchstatus = "Posted";
                    break;
                case 3:
                    batchstatus = "Error";
                    break;
                case 4:
                    batchstatus = "Delete";
                    break;
            }
        } catch (Exception e) {
        }

        jtxtbatchsts.setText(batchstatus);
        jtxttotinvamt.setText(GlobalUtils.formatnumber(obj.gettotinvamt()));
        jtxtinventrcnt.setText(obj.toString(Ap_invbatchlist.PROPERTY_INVENTRCNT));
        jtxtentrydate.setText(obj.toString(Ap_invbatchlist.PROPERTY_ENTRYDATE));
        jtxtauditdate.setText(obj.toString(Ap_invbatchlist.PROPERTY_AUDITDATE));
        jtxtaudituser.setText(obj.toString(Ap_invbatchlist.PROPERTY_AUDITUSER));
        jtxtcmpnyid.setText(obj.toString(Ap_invbatchlist.PROPERTY_CMPNYID));

        if (obj.getDetail().list().isEmpty()) {
            obj.setDtlslctdindx(-1);
            setAPInvhhEnable(false);
            apinvhh = new Ap_invh();
        } else {
            if (obj.getDtlslctdindx() < obj.getDetail().size() - 1) {
                apinvhh = (Ap_invh) obj.getDetail().list().get(obj.getDtlslctdindx());
                setAPInvhhEnable(true);
            } else {
                obj.setDtlslctdindx(obj.getDetail().size() - 1);
                apinvhh = (Ap_invh) obj.getDetail().list().get(obj.getDetail().size() - 1);
                setAPInvhhEnable(true);
            }
        }
        showDataApInvhh();
        mf.setIcon(CLASSNAME);
        setToolBar(iformtype, istatus);
        setCursor(GlobalUtils.NORMALCURSOR);
    }

    private void setAPInvhhEnable(boolean enable) {
        jtxtdocentry.setEnabled(enable);
        //jtxtjrnldesc.setEnabled(enable);
        //jtxtsrcelgrcode.setEnabled(enable);
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
    }

    private void unlockbutton(Boolean lock) {
        jtbnNew.setEnabled(lock);
        jbtnDelete.setEnabled(lock);
        jbtnMoveFirst.setEnabled(lock);
        jbtnMovePrevious.setEnabled(lock);
        jbtnMoveNext.setEnabled(lock);
        jbtnMoveLast.setEnabled(lock);

        if (jlbldocentry.getText().equalsIgnoreCase("doc entry*")) {
            jbtnMoveNext.setEnabled(false);
            jbtnMoveLast.setEnabled(false);
        }
    }

    public void setToolBar(int iFormType, int istatus) {
        try {
            if (obj.getbatchsts().equals("2") || obj.getbatchsts().equals("4")) {
                mf.setToolBar(iformtype, 7);

                 unlockbutton(true);
            } else {
                mf.setToolBar(iformtype, istatus);
                unlockbutton(true);
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setData() throws CodeException {


        obj.fromString(Ap_invbatchlist.PROPERTY_ID, jtxtid.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_BATCHNO, jtxtbatchno.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(kbatchdate.getText(), "yyyy-MM-dd"));
        obj.fromString(Ap_invbatchlist.PROPERTY_BATCHDESC, jtxtbatchdesc.getText());

        if (jchckReadyToPost.isSelected()) {
            obj.setreadytpost("1");
        } else {
            obj.setreadytpost("0");
        }
        if (obj.getID() == 0) {
            obj.setbatchtype("1");
        }

        obj.settotinvamt(GlobalUtils.toDbl(jtxttotinvamt.getText()));
        obj.fromString(Ap_invbatchlist.PROPERTY_INVENTRCNT, jtxtinventrcnt.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_ENTRYDATE, jtxtentrydate.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_AUDITDATE, jtxtauditdate.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_AUDITUSER, jtxtaudituser.getText());
        obj.fromString(Ap_invbatchlist.PROPERTY_CMPNYID, jtxtcmpnyid.getText());

    }

    public void undo() throws CodeException {
        istatus = 0;
        setToolBar(iformtype, istatus);
        jlbldocentry.setText("Doc Entry");
        if (objtmp != null) {
            obj = objtmp;
        }
        showData();
    }

    public void execute() throws CodeException {
        saveData();
    }

    public void printData() throws CodeException {
        FrmPrintTransaksiAPBatchListInvoice fp = new FrmPrintTransaksiAPBatchListInvoice();
        fp.jcmblistingfor.setSelectedIndex(0);
        fp.setVisible(true);
    }

    public void importCsv() throws CodeException {

        String file1 = "";
        String file2 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".csv";

        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Pilih File ");
        FileFilter filter1 = new ExtFileChooserFilter("CSV", new String[]{"CSV"});
        chooser.setFileFilter(filter1);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                file1 = selectedFile.getCanonicalPath();

            } catch (Exception e) {
            }

            GlobalUtils.copyfile(file1, file2);

            obj.importCsv();

        } else {
            JOptionPane.showMessageDialog(null, "No Selection ");
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

                    JOptionPane.showMessageDialog(null, GlobalUtils.copyfile(file1, file2));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "No Selection ");
            }

        }

    }

    public void importText() throws CodeException {
        String file1 = "";
        String file2 = GlobalUtils.getCurrentDir() + GlobalUtils.temp + obj.TABLEPROCESS + ".txt";

        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Pilih File ");
        FileFilter filter1 = new ExtFileChooserFilter("txt", new String[]{"txt"});
        chooser.setFileFilter(filter1);


        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                file1 = selectedFile.getCanonicalPath();

            } catch (Exception e) {
            }

            GlobalUtils.copyfile(file1, file2);

            obj.importCsv();

        } else {
            JOptionPane.showMessageDialog(null, "No Selection ");
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
                    JOptionPane.showMessageDialog(null, GlobalUtils.copyfile(file1, file2));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "No Selection ");
            }

        }
    }

    private void saveDetailMR(String noMR, int batchno, int lastdocid) throws CodeException {
        mrds = new D_material_receives();
        try {
            mrds.searchDataByMR(noMR);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAp_invbatchlist.class.getName()).log(Level.SEVERE, null, ex);
        }
        int lineno = 1;
        for (Object o : mrds.list()) {
            D_material_receive mrd = (D_material_receive) o;

            System.out.println("No: "+lineno);
            System.out.println("Batch No: "+batchno);
            System.out.println("Doc Entry: "+lastdocid);
            System.out.println("ID: "+mrd.getID());
            System.out.println("Kode Beban: "+mrd.getkode_beban());
            System.out.println("Item Desc: "+mrd.getitemDesc());
            System.out.println("Price: "+mrd.getprice());
            System.out.println("Qty: "+mrd.getqtyReceive());
            
            long idAPinvhd = 0;
            String distcode = "21911";
            String description = "Accrued Lain2.";
            String accglcode = "1111343000000";
            double detailamt = mrd.getprice()*mrd.getqtyReceive();
            
            Ap_invd apinvd;
            apinvd = new Ap_invd();
            
            apinvd.setID(idAPinvhd);
            apinvd.setbatchno(batchno);
            apinvd.setdocentry(lastdocid);
            apinvd.setlinenum(lineno);
            apinvd.setdistcode(distcode);
            apinvd.setdscription(description);
            apinvd.setaccglcode(accglcode);
            apinvd.setdetailamt(detailamt);
            apinvd.setcomment(mrd.getitemDesc());
            apinvd.save();
            
            lineno++;
        }
    }
}
