/*
 * From Template
 *
 * Created on June 29, 2007, 2:00 PM
 * 
 * 
 * How to Call this Form on FrmMainFrame
 * Sample : 
 *    
 * import <Package>.Frm<Table>;
 * 
 * .......
 * 
 * 
 * Frm<Table> frm<table>;
 * 
 * .......
 * 
 try {
        if (frm<table> == null) {
            frmm<table> = new Frm<Table>(this);
        }
        
        showForm(frm<table>);
        
    }catch(Exception e) {
        e.printStackTrace();
    }
 * 
 */

package <Package>;

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
import <PackageObject>.<Table>;
import <PackageObject>.<Table>s;

/**
 *
 * @author  Generator
 */

public class Frm<Table> extends javax.swing.JInternalFrame implements NavigatorFormInt {

    private static int istatus = 0;
    private static int iformtype = 0;
    public static String CLASSNAME="Frm<Table>";
    
    FrmMainFrame mf ;
    
    
    public <Table> obj = new <Table>();
    
   
    /** Creates new form Area */
    public Frm<Table>() throws CodeException {
        initComponents();
    }
    
    public Frm<Table>(FrmMainFrame mf) throws CodeException{
        this.mf = mf;
        initComponents();
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

        <Declaration>

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("<Table>");
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
        jHeader.setText(" : : <Table>");
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

        jbtnBrowse.setText("...");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBrowse);
        jbtnBrowse.setBounds(350, 100, 30, 20);

	<SetPosition>

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


private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {                                            
    setToolBar(iformtype,istatus);
    mf.setIcon(CLASSNAME);
}                                           

private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
	      <Table>s brs = new <Table>s();
	      FrmBrowse bd = new FrmBrowse(this, brs);
	      bd.setFirstValue(jtxt<PrimaryKey>);
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
                    new Frm<Table>().setVisible(true);
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

    <Variables>

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
        obj = new <Table>(this.jtxt<PrimaryKey>.getText());
        showData();
        mf.setIcon(CLASSNAME);

    }
    public void newData() throws CodeException {
        obj = new <Table>();
        istatus=1;
        showData();
        setToolBar(iformtype,istatus);
    }

    public void saveData() throws CodeException {
        istatus = 0;
        setData();
        obj.save();
        
        showData();
        
        mf.setIcon(CLASSNAME);
    }

    public void showData() throws CodeException {
        setCursor(GlobalUtils.HOURGLASSCURSOR);
	<ShowData>
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
        
	<SetData>

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