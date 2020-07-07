/*
 * FrmBrowse.java
 *
 * Created on December 22, 2008, 11:00 AM
 * 
 * FrmBrowse is POPUP Form to Filter Data From Collection
 * 
 * How To :
 * 1. Find array Column In Collection, and change to field/data you want to browse
 * 
 *   Sample : 
        private String[][] column = {
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "200"}, 
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "500"}
        };
 * 
 * 2. From Browse can be used with JTextField, JTable, TableModel
 * 
 * 3. If you input JInternalFrame as Parameter, 
        it will automatically run method searcData on Form
 * 
 */

package common.component;


import common.classinterface.NavigatorBrowseDataInt;
import common.classinterface.NavigatorFormInt;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.jdbc.DbBean;
import common.tablemodels.BdModel;
import common.tablemodels.BrowseColumnModelCol;
import common.tablemodels.GlobalModel;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author  windu
 */
public class FrmBrowse extends javax.swing.JDialog {
    protected DefaultTableModel tmodel=new BdModel();
    
    protected NavigatorBrowseDataInt nbd = null;
    protected BrowseColumnModelCol colModel=new BrowseColumnModelCol();
    
    protected String filterfield="";
    String table="";
    protected Boolean isoverwrite=false;
    protected String fields="";
    protected String sql = "";
    protected JTextField first = null;
    protected JTextField second = null;
    protected JTextField third = null;
    protected JTextField fourth = null;
    
    protected NavigatorFormInt nfi = null;
    
    protected int skip = 0;
    
    
    
    /** Creates new form frmBrowse */
    public FrmBrowse() {
        initComponents();

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    }
    
    public FrmBrowse(JInternalFrame jf,Object obj) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        cbosearchmth.setSelectedIndex(1);
        retrieveData();

        jtblBrowse.getTableHeader().setResizingAllowed(true);

    }

    public FrmBrowse(Object obj) throws CodeException {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth(); 
        cbosearchmth.setSelectedIndex(1);
        retrieveData();

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    }

    public FrmBrowse(Object obj,Boolean desc) throws CodeException {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        cbosearchmth.setSelectedIndex(2);
        jchkDesc.setSelected(desc);
        retrieveData();

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    }

        
    public FrmBrowse(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        this.nfi = (NavigatorFormInt)jf;
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        cbosearchmth.setSelectedIndex(2);
        
        this.filterfield = filterfield;

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    }
    public FrmBrowse(Object obj, String filterfield) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        
        cbosearchmth.setSelectedIndex(2);
        this.filterfield = filterfield;

        jtblBrowse.getTableHeader().setResizingAllowed(true);
               
    }
    
    public FrmBrowse(JTable jtable, Object obj, int row, int col) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        cbosearchmth.setSelectedIndex(2);

        jtableparam = jtable;

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    } 
   
     public FrmBrowse(TableModel tmodel, Object obj, int row, int col) {
        initComponents();
        this.setLocationRelativeTo(null);
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        cbosearchmth.setSelectedIndex(2);

        rowtable1 = row;
        coltable1 = col;
        tmodelparam = tmodel;


        jtblBrowse.getTableHeader().setResizingAllowed(true);
    } 
    
    public void setFirstValue(JTextField first) {
        this.first = first;
    }

      
    public void setSecondValue(JTextField second) {
        this.second = second;
    }

    public void setThirdValue(JTextField third) {
        this.third = third;
    }

    public void setFourthValue(JTextField fourth) {
        this.fourth = fourth;
    }
    
    private void setFieldInCombo(){
        String[][] columns= nbd.getColumn();

        for (int i= 0; i < columns.length; i++ ) {
            colModel.Insert();
            colModel.getColModel().setColName(columns[i][0]);
            colModel.getColModel().setColDesc(columns[i][1]);
            colModel.getColModel().setColWidth(Integer.parseInt(columns[i][2]));
            colModel.add(colModel.getColModel());
        }

        for(int i=0;i<colModel.size();i++){
            cbosearchin.addItem(colModel.get(i).getColDesc());
       }
    }
    
    private void setColHeader(){
        for (int i=0;i<colModel.size();i++){
            tmodel.addColumn(colModel.get(i).getColDesc());

            GlobalModel.setColumnWidth(this.jtblBrowse, i, colModel.get(i).getColWidth());
        }
    }

    private void getFields(){
        this.fields="";
        for (int i=0;i<colModel.size();i++){
            fields=fields+colModel.get(i).getColName()+",";
        }
        fields= fields.substring(0, fields.length()-1);
    }

    private void setColWidth(){
        for (int i=0;i<colModel.size();i++){
            if (colModel.get(i).getColWidth()>0){
                setColumnWidth(i,colModel.get(i).getColWidth());
            }
        }
    }
    
    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        nbd.searchData(field, value, searchmethod, field, sortby , skip, 101);
    }


    public void retrieveData () throws CodeException{

        setCursor(GlobalUtils.HOURGLASSCURSOR);
        String value=txtsearch.getText().trim();
        int searchmethod=cbosearchmth.getSelectedIndex();
        String field=colModel.get(cbosearchin.getSelectedIndex()).getColName();
        String sortby = jchkDesc.isSelected() ? "DESC" : "ASC";

        
        String[][] columns= nbd.getColumn();
        
        
        this.jbtnMore.setVisible(false);
         
        //delete row
        int row = tmodel.getRowCount();			
        while(row > 0){	
            row--;				
            tmodel.removeRow(row);
        }	
          
        getFields();
        getNavigatorBrowseData (field, value, searchmethod, sortby );
        
        if (!this.isoverwrite){
            Object[] data = new Object[nbd.getColumn().length];


             for (Object o: nbd.list()) {
                 CodeObjectInt jcoi = (CodeObjectInt) o;
                 for (int i = 0; i< columns.length; i++) {
                    data[i] = jcoi.toString(columns[i][0]);
                 }
                 tmodel.addRow(data);
             }

             jlblRecordsFound.setText("Record Found " + (nbd.size() > 100 ? "Just Show 100 records " : nbd.size() + "") );

             if (nbd.size() > 100) {
                this.jbtnMore.setVisible(true);
             }
        } else {
            DbBean db = DbBean.connect();
            try {
                System.out.println(sql);
                ResultSet rs = db.executeQuery(sql);
                GlobalModel.clearRow(tmodel);
                while (rs.next()){
                    tmodel.addRow(new Object[colModel.size()]);
                    for (int i=0;i<colModel.size();i++){
                        Object ofield=rs.getObject(colModel.get(i).getColName());
                        tmodel.setValueAt(ofield, tmodel.getRowCount()-1, i);
                    }
                }
                rs.close();

            } catch (SQLException ex) {
                throw new CodeException("Error Browse " + ex.getMessage());
            }finally{
                db.close();
            }
            jlblRecordsFound.setText("Number of Records Found : " + tmodel.getRowCount());
        }
        setCursor(GlobalUtils.NORMALCURSOR);

    }
    
    protected void setColumnWidth(Integer ColumnIdx,Integer Width){
       TableColumn column=jtblBrowse.getColumnModel().getColumn(ColumnIdx);
       column.setMinWidth(Width);
       column.setPreferredWidth(Width);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSelect = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jlblRecordsFound = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbosearchmth = new javax.swing.JComboBox();
        cbosearchin = new javax.swing.JComboBox();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblBrowse = new javax.swing.JTable();
        jbtnMore = new javax.swing.JButton();
        jchkDesc = new javax.swing.JCheckBox();
        jchkAutoFind = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        setMinimumSize(new java.awt.Dimension(620, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jbtnSelect.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnSelect.setText("Select");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSelect);
        jbtnSelect.setBounds(10, 460, 100, 23);

        jbtnCancel.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCancel);
        jbtnCancel.setBounds(110, 460, 100, 23);

        jlblRecordsFound.setFont(new java.awt.Font("Dialog", 1, 10));
        jlblRecordsFound.setText("Number of Records Found : ");
        getContentPane().add(jlblRecordsFound);
        jlblRecordsFound.setBounds(220, 460, 260, 14);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel1.setText("Search In Field");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 14, 93, 14);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("Seach Methode");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 41, 76, 14);

        cbosearchmth.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        cbosearchmth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Equals", "Start With", "Contains" }));
        cbosearchmth.setSelectedIndex(1);
        getContentPane().add(cbosearchmth);
        cbosearchmth.setBounds(120, 40, 100, 22);

        cbosearchin.setFont(new java.awt.Font("Dialog", 0, 10));
        getContentPane().add(cbosearchin);
        cbosearchin.setBounds(120, 10, 190, 22);

        btnsearch.setFont(new java.awt.Font("Dialog", 0, 10));
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(490, 40, 100, 23);

        txtsearch.setFont(new java.awt.Font("Dialog", 0, 10));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtsearchPropertyChange(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });
        txtsearch.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtsearchVetoableChange(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(120, 70, 470, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Search Key");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 70, 56, 14);

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jtblBrowse.setAutoCreateRowSorter(true);
        jtblBrowse.setFont(new java.awt.Font("Dialog", 0, 10));
        jtblBrowse.setModel(tmodel);
        jtblBrowse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBrowseMouseClicked(evt);
            }
        });
        jtblBrowse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblBrowseKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblBrowse);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 581, 350);

        jbtnMore.setFont(new java.awt.Font("Dialog", 0, 10));
        jbtnMore.setText("More");
        jbtnMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoreActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnMore);
        jbtnMore.setBounds(490, 460, 100, 23);

        jchkDesc.setFont(new java.awt.Font("Dialog", 1, 10));
        jchkDesc.setText("Desc");
        getContentPane().add(jchkDesc);
        jchkDesc.setBounds(395, 10, 77, 23);

        jchkAutoFind.setFont(new java.awt.Font("Dialog", 1, 10));
        jchkAutoFind.setSelected(true);
        jchkAutoFind.setText("Auto");
        getContentPane().add(jchkAutoFind);
        jchkAutoFind.setBounds(472, 10, 119, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
      selectRow();
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() {
   Integer irow;
   
   setCursor(GlobalUtils.HOURGLASSCURSOR);

   if (jtblBrowse.getRowCount()>0){
      irow=jtblBrowse.getSelectedRow();
      if (irow<0){
          irow=0;
       } 
              
      if (jtableparam != null) {
             
        jtableparam.setValueAt(tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);
        
      }else if (tmodelparam != null) {
             
        tmodelparam.setValueAt(tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);

        
      }else{
           if (first != null ) {
               first.setText(tmodel.getValueAt(irow,0).toString());
           }
           if (second != null ) {
               second.setText(tmodel.getValueAt(irow,1).toString());
           }

           if (tmodel.getColumnCount() > 2) {
               if (third != null) {
                    third.setText(tmodel.getValueAt(irow,2).toString());
               } 
               if (fourth != null) {
                   fourth.setText(tmodel.getValueAt(irow,3).toString());
               }
           }
      }
   }
   if (nfi != null) {
        try {
            nfi.searchData();
        } catch (CodeException ex) {
            ex.printStackTrace();
        }
   }
   
   setVisible(false); 
   
   setCursor(GlobalUtils.NORMALCURSOR);

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed

private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
    try {
            retrieveData();//GEN-LAST:event_btnsearchActionPerformed
    } catch (CodeException ex) {
       ex.printStackTrace();
    }
}

private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed

}//GEN-LAST:event_txtsearchActionPerformed

private void txtsearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtsearchPropertyChange

    

}//GEN-LAST:event_txtsearchPropertyChange

private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed

   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            retrieveData();                                         
        } catch (CodeException ex) {
           ex.printStackTrace();
        }       
   }
   if (evt.getKeyCode()==evt.VK_DOWN){
       if (jtblBrowse.getRowCount()>0){
        GlobalUtils.selectCellTable(jtblBrowse, 0,0);
        jtblBrowse.requestFocus();
       }
   }
}//GEN-LAST:event_txtsearchKeyPressed

private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
    if(jchkAutoFind.isSelected() && !txtsearch.getText().trim().equals("") ) {
        try {
            retrieveData();                                         
        } catch (CodeException ex) {
           ex.printStackTrace();
        }
    }
}//GEN-LAST:event_txtsearchKeyReleased

private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped

}//GEN-LAST:event_txtsearchKeyTyped

private void txtsearchVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtsearchVetoableChange

}//GEN-LAST:event_txtsearchVetoableChange

private void jtblBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBrowseMouseClicked
    
      if (evt.getClickCount() == 2){
         selectRow();
      }
    
}//GEN-LAST:event_jtblBrowseMouseClicked

private void jtblBrowseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblBrowseKeyPressed
    int irow=jtblBrowse.getSelectedRow();
    if (irow>-1){
        if (evt.getKeyCode()==evt.VK_ENTER){
            selectRow();
        }
        if (evt.getKeyCode()==evt.VK_UP){
            if (irow==0){
                txtsearch.requestFocus();
            }
        }
    }
}//GEN-LAST:event_jtblBrowseKeyPressed

private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed

}//GEN-LAST:event_jScrollPane1KeyPressed

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    txtsearch.requestFocus();
    
}//GEN-LAST:event_formWindowOpened

private void jbtnMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoreActionPerformed
        try {

            skip = skip + 100;
            this.retrieveData();
            
        } catch (CodeException ex) {
            ex.printStackTrace();
        }
    
}//GEN-LAST:event_jbtnMoreActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBrowse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnsearch;
    protected javax.swing.JComboBox cbosearchin;
    protected javax.swing.JComboBox cbosearchmth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnMore;
    protected javax.swing.JButton jbtnSelect;
    protected javax.swing.JCheckBox jchkAutoFind;
    public javax.swing.JCheckBox jchkDesc;
    public javax.swing.JLabel jlblRecordsFound;
    public javax.swing.JTable jtblBrowse;
    protected javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    protected JTable jtableparam;
    protected TableModel tmodelparam;
    protected int coltable1 = 0;
    protected int rowtable1 = 0;
    
}
