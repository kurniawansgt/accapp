/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import accapp.component.gl.FrmGl_sourcelgr;
 * 
 * .......
 * 
 * 
 * FrmGl_sourcelgr frmGl_sourcelgr;
 * 
 * .......
 * 
 try {
        if (frmGl_sourcelgr == null) {
            frmmGl_sourcelgr = new FrmGl_sourcelgr(this);
        }
        
        showForm(frmGl_sourcelgr);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package accapp.component.gl;

import accapp.component.browse.FrmBrowseGl_SourceGr;
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
import accapp.objectclasses.gl.Gl_sourcelgr;
import accapp.objectclasses.gl.Gl_sourcelgr_desc;
import accapp.objectclasses.gl.Gl_sourcelgr_descs;
import accapp.objectclasses.gl.Gl_sourcelgrs;
import common.print.FrmPrintMasterGLSourceCode;
import javax.swing.JTextField;

/**
 *
 * @author  Generator
 */

public class FrmGl_sourcelgr extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="FrmGl_sourcelgr";
    
    FrmMainFrame mf ;
    
    
    public Gl_sourcelgr obj = new Gl_sourcelgr();
    Gl_sourcelgr_desc obj_desc=new Gl_sourcelgr_desc();
   
    /** Creates new form Area */
    public FrmGl_sourcelgr() throws CodeException {
        initComponents();
    }
    
    public FrmGl_sourcelgr(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();

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

    public void highlight(JTextField otxt){
        otxt.setSelectionStart(0);
        otxt.setSelectionEnd(otxt.getText().length());
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
        jlblsrcelgrcode = new javax.swing.JLabel();
        jtxtsrcelgrcode = new javax.swing.JTextField();
        jlblsrcetypecode = new javax.swing.JLabel();
        jtxtsrcetypecode = new javax.swing.JTextField();
        jlblsrcedesc = new javax.swing.JLabel();
        jtxtsrcedesc = new javax.swing.JTextField();
        jtxtentrydate = new javax.swing.JTextField();
        jtxtauditdate = new javax.swing.JTextField();
        jtxtaudituser = new javax.swing.JTextField();
        jtxtcmpnyid = new javax.swing.JTextField();
        jtxtsrcelgrcode_desc = new javax.swing.JTextField();
        jbtnBrowse1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setTitle("G/L Source Codes");
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
        jHeader.setText(" : : G/L Source Codes");
        jHeader.setAlignmentY(0.0F);
        jHeader.setOpaque(true);
        getContentPane().add(jHeader);
        jHeader.setBounds(30, 30, 130, 20);

        HorizontalLine.setForeground(new java.awt.Color(102, 102, 102));
        HorizontalLine.setAlignmentX(0.0F);
        HorizontalLine.setAlignmentY(0.0F);
        getContentPane().add(HorizontalLine);
        HorizontalLine.setBounds(160, 50, 650, 12);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setAlignmentX(0.0F);
        jSeparator3.setAlignmentY(0.0F);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 50, 12, 400);

        jbtnBrowse.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(340, 130, 30, 20);

        jtxtid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtid.setText("id");
        getContentPane().add(jtxtid);
        jtxtid.setBounds(170, 30, 80, 20);

        jlblsrcelgrcode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblsrcelgrcode.setText("Code");
        getContentPane().add(jlblsrcelgrcode);
        jlblsrcelgrcode.setBounds(70, 100, 140, 13);

        jtxtsrcelgrcode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcelgrcode.setText("srcelgrcode");
        jtxtsrcelgrcode.setNextFocusableComponent(jtxtsrcetypecode);
        jtxtsrcelgrcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcelgrcodeFocusGained(evt);
            }
        });
        jtxtsrcelgrcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtsrcelgrcodeKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtsrcelgrcode);
        jtxtsrcelgrcode.setBounds(260, 100, 80, 25);

        jlblsrcetypecode.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblsrcetypecode.setText("Type Code");
        getContentPane().add(jlblsrcetypecode);
        jlblsrcetypecode.setBounds(70, 130, 140, 13);

        jtxtsrcetypecode.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcetypecode.setText("srcetypecode");
        jtxtsrcetypecode.setNextFocusableComponent(jtxtsrcedesc);
        jtxtsrcetypecode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcetypecodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtsrcetypecodeFocusLost(evt);
            }
        });
        jtxtsrcetypecode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtsrcetypecodeKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtsrcetypecode);
        jtxtsrcetypecode.setBounds(260, 130, 80, 25);

        jlblsrcedesc.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblsrcedesc.setText("Description");
        getContentPane().add(jlblsrcedesc);
        jlblsrcedesc.setBounds(70, 160, 140, 13);

        jtxtsrcedesc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcedesc.setText("srcedesc");
        jtxtsrcedesc.setNextFocusableComponent(jtxtsrcelgrcode);
        jtxtsrcedesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcedescFocusGained(evt);
            }
        });
        getContentPane().add(jtxtsrcedesc);
        jtxtsrcedesc.setBounds(260, 160, 460, 25);

        jtxtentrydate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtentrydate.setText("entrydate");
        getContentPane().add(jtxtentrydate);
        jtxtentrydate.setBounds(260, 30, 150, 20);

        jtxtauditdate.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtauditdate.setText("auditdate");
        getContentPane().add(jtxtauditdate);
        jtxtauditdate.setBounds(420, 30, 150, 20);

        jtxtaudituser.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtaudituser.setText("audituser");
        getContentPane().add(jtxtaudituser);
        jtxtaudituser.setBounds(580, 30, 90, 20);

        jtxtcmpnyid.setFont(new java.awt.Font("Dialog", 0, 8));
        jtxtcmpnyid.setText("cmpnyid");
        getContentPane().add(jtxtcmpnyid);
        jtxtcmpnyid.setBounds(680, 30, 130, 20);

        jtxtsrcelgrcode_desc.setFont(new java.awt.Font("Dialog", 0, 10));
        jtxtsrcelgrcode_desc.setText("srcelgrcode_desc");
        jtxtsrcelgrcode_desc.setNextFocusableComponent(jtxtsrcetypecode);
        jtxtsrcelgrcode_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtsrcelgrcode_descFocusGained(evt);
            }
        });
        jtxtsrcelgrcode_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtsrcelgrcode_descKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtsrcelgrcode_desc);
        jtxtsrcelgrcode_desc.setBounds(380, 100, 340, 25);

        jbtnBrowse1.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnBrowse1.setText("...");
        jbtnBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowse1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse1);
        jbtnBrowse1.setBounds(340, 100, 30, 20);

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

private void jtxtsrcelgrcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcodeFocusGained
    // TODO add your handling code here:
    highlight((JTextField) evt.getComponent());
}//GEN-LAST:event_jtxtsrcelgrcodeFocusGained

private void jtxtsrcetypecodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcetypecodeFocusGained
    // TODO add your handling code here:
    highlight((JTextField) evt.getComponent());
}//GEN-LAST:event_jtxtsrcetypecodeFocusGained

private void jtxtsrcedescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcedescFocusGained
    // TODO add your handling code here:
    highlight((JTextField) evt.getComponent());
}//GEN-LAST:event_jtxtsrcedescFocusGained

private void jtxtsrcelgrcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcodeKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) {
        jtxtsrcetypecode.requestFocus();
    }
    
}//GEN-LAST:event_jtxtsrcelgrcodeKeyPressed

private void jtxtsrcetypecodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsrcetypecodeKeyPressed

    if(evt.getKeyCode() == evt.VK_ENTER) {
        jtxtsrcedesc.requestFocus();
    }
}//GEN-LAST:event_jtxtsrcetypecodeKeyPressed

private void jtxtsrcelgrcode_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcode_descFocusGained
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtsrcelgrcode_descFocusGained

private void jtxtsrcelgrcode_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsrcelgrcode_descKeyPressed
    // TODO add your handling code here:
}//GEN-LAST:event_jtxtsrcelgrcode_descKeyPressed

private void jbtnBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowse1ActionPerformed
    // TODO add your handling code here:
    try {
	      Gl_sourcelgr_descs brs = new Gl_sourcelgr_descs();
	      FrmBrowse bd = new FrmBrowse(brs);
	      bd.setFirstValue(jtxtsrcelgrcode);
              bd.setSecondValue(jtxtsrcelgrcode_desc);
	      bd.setModal(true);
	      bd.setVisible(true);


	  } catch (CodeException ex) {
	      ex.printStackTrace();
	  }
}//GEN-LAST:event_jbtnBrowse1ActionPerformed

private void jtxtsrcetypecodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtsrcetypecodeFocusLost
        try {
            // TODO add your handling code here:
            Gl_sourcelgr obj_find = new Gl_sourcelgr();
            obj_find.searchData(jtxtsrcelgrcode.getText(), jtxtsrcetypecode.getText());
            if (obj_find.getID()>0){
                obj=obj_find;
                showData();
            }
        } catch (CodeException ex) {
            Logger.getLogger(FrmGl_sourcelgr.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_jtxtsrcetypecodeFocusLost


private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);
}                                           

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
	      Gl_sourcelgrs brs = new Gl_sourcelgrs();
	      FrmBrowseGl_SourceGr bd = new FrmBrowseGl_SourceGr(this, brs,jtxtsrcelgrcode.getText());
              bd.sSrcelgrcode=jtxtsrcelgrcode.getText();
              bd.retrieveData();
	      bd.setFirstValue(jtxtsrcelgrcode);
              bd.setSecondValue(jtxtsrcetypecode);
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
                    new FrmGl_sourcelgr().setVisible(true);
                } catch (CodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel jHeader;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnBrowse1;
    private javax.swing.JLabel jlblsrcedesc;
    private javax.swing.JLabel jlblsrcelgrcode;
    private javax.swing.JLabel jlblsrcetypecode;
    private javax.swing.JTextField jtxtauditdate;
    private javax.swing.JTextField jtxtaudituser;
    private javax.swing.JTextField jtxtcmpnyid;
    private javax.swing.JTextField jtxtentrydate;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtsrcedesc;
    private javax.swing.JTextField jtxtsrcelgrcode;
    private javax.swing.JTextField jtxtsrcelgrcode_desc;
    private javax.swing.JTextField jtxtsrcetypecode;
    // End of variables declaration//GEN-END:variables

 
    public void moveFirst() throws CodeException {
        obj.moveFirst();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void movePrevious() throws CodeException {
        obj.movePrevious();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveNext() throws CodeException {
        obj.moveNext();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void moveLast() throws CodeException {
        obj.moveLast();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void searchData() throws CodeException {
        obj.searchData(jtxtsrcelgrcode.getText(), jtxtsrcetypecode.getText());
        showData();
        mf.setIcon(CLASSNAME);

    }
    public void newData() throws CodeException {
        obj = new Gl_sourcelgr();
        istatus=1;
        showData();
        setToolBar(iformtype,istatus);
    }

    public void saveData() throws CodeException {
        
        setData();
        obj.save();
        
        showData();
        istatus = 0;
        mf.setIcon(CLASSNAME);
    }

    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	
             jtxtid.setText(obj.toString(Gl_sourcelgr.PROPERTY_ID));
             jtxtsrcelgrcode.setText(obj.toString(Gl_sourcelgr.PROPERTY_SRCELGRCODE));
             jtxtsrcetypecode.setText(obj.toString(Gl_sourcelgr.PROPERTY_SRCETYPECODE));
             jtxtsrcedesc.setText(obj.toString(Gl_sourcelgr.PROPERTY_SRCEDESC));
             jtxtentrydate.setText(obj.toString(Gl_sourcelgr.PROPERTY_ENTRYDATE));
             jtxtauditdate.setText(obj.toString(Gl_sourcelgr.PROPERTY_AUDITDATE));
             jtxtaudituser.setText(obj.toString(Gl_sourcelgr.PROPERTY_AUDITUSER));
             jtxtcmpnyid.setText(obj.toString(Gl_sourcelgr.PROPERTY_CMPNYID));

             obj_desc=new Gl_sourcelgr_desc(Gl_sourcelgr_desc.PROPERTY_SRCELGRCODE,obj.getsrcelgrcode());
             jtxtsrcelgrcode_desc.setText(obj_desc.getsrcelgrdesc());
        setCursor(GlobalUtils.NORMALCURSOR);
    }

    public void delete() throws CodeException {
        obj.delete();
        obj.moveFirst();
        showData();
        mf.setIcon(CLASSNAME);
    }

    public void setToolBar(int iFormType, int istatus) {
        mf.setToolBar(iformtype,istatus);        
    }

    public void setData() throws CodeException {
        
	
          obj.fromString(Gl_sourcelgr.PROPERTY_SRCELGRCODE, jtxtsrcelgrcode.getText()) ;
          obj.fromString(Gl_sourcelgr.PROPERTY_SRCETYPECODE, jtxtsrcetypecode.getText()) ;
          obj.fromString(Gl_sourcelgr.PROPERTY_SRCEDESC, jtxtsrcedesc.getText()) ;
          if (istatus==1){
              obj.fromString(Gl_sourcelgr.PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate()) ;
          }
          obj.fromString(Gl_sourcelgr.PROPERTY_AUDITDATE, GlobalUtils.getAuditDate()) ;
          obj.fromString(Gl_sourcelgr.PROPERTY_AUDITUSER, GlobalUtils.audituser) ;
          obj.fromString(Gl_sourcelgr.PROPERTY_CMPNYID, GlobalUtils.company) ;

          obj_desc=new Gl_sourcelgr_desc(Gl_sourcelgr_desc.PROPERTY_SRCELGRCODE,obj.getsrcelgrcode());
          obj_desc.setsrcelgrcode(obj.getsrcelgrcode());
          obj_desc.setsrcelgrdesc(jtxtsrcelgrcode_desc.getText());
          obj_desc.save();
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
//        Map parameter = new HashMap();
//        NavigatorObjectInt noi = (NavigatorObjectInt) obj;
//        String file   = GlobalUtils.getCurrentDir() +"/Reports/" + noi.getClassName() + ".jrxml";
//        GlobalUtils.printReport(file,  false);
        FrmPrintMasterGLSourceCode fprint = new FrmPrintMasterGLSourceCode();
        fprint.setVisible(true);
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
