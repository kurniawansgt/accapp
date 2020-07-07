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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.tablemodels.BdModel;
import common.tablemodels.BrowseColumnModelCol;
import common.utils.GlobalUtils;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author  windu
 */
public class FrmBrowseObject extends javax.swing.JDialog {
    protected DefaultTableModel tmodel=new BdModel();
    
    protected NavigatorBrowseDataInt nbd = null;
    protected BrowseColumnModelCol colModel=new BrowseColumnModelCol();
    
    protected String filterfield="";
    String table="";
    
    protected JTextField first = null;
    protected JTextField second = null;
    protected JTextField third = null;
    protected JTextField fourth = null;
    
    protected int skip = 0;
    
    
    
    /** Creates new form frmBrowse */
    public FrmBrowseObject() throws CodeException {
        initComponents();

        jtblBrowse.getTableHeader().setResizingAllowed(true);
    }
    public FrmBrowseObject(Object obj) throws CodeException {
        initComponents();
        nbd = (NavigatorBrowseDataInt) obj;
        setFieldInCombo();
        setColHeader();
        setColWidth();
        retrieveData();

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
    
    private void setColHeader(){
        for (int i=0;i<colModel.size();i++){
            tmodel.addColumn(colModel.get(i).getColDesc());
        }
    }
    private void setColWidth(){
        for (int i=0;i<colModel.size();i++){
            if (colModel.get(i).getColWidth()>0){
                setColumnWidth(i,colModel.get(i).getColWidth());
            }
        }
    }
    protected void setFieldInCombo(){
        String[][] columns= nbd.getColumn();

        for (int i= 0; i < columns.length; i++ ) {
            colModel.Insert();
            colModel.getColModel().setColName(columns[i][0]);
            colModel.getColModel().setColDesc(columns[i][1]);
            colModel.getColModel().setColWidth(Integer.parseInt(columns[i][2]));
            colModel.add(colModel.getColModel());
        }


    }
    
    private void retrieveData () throws CodeException{
        
        setCursor(GlobalUtils.HOURGLASSCURSOR);
        
        String[][] columns= nbd.getColumn();
        
        //delete row
        int row = tmodel.getRowCount();			
        while(row > 0){	
            row--;				
            tmodel.removeRow(row);
        }	


        Object[] data = new Object[nbd.getColumn().length];

         for (Object o: nbd.list()) {

             CodeObjectInt jcoi = (CodeObjectInt) o;
             for (int i = 0; i< columns.length; i++) {
                data[i] = jcoi.toString(columns[i][0]);
             }
             tmodel.addRow(data);
         }
         
         
        setCursor(GlobalUtils.NORMALCURSOR);

    }

    protected void setColumnWidth(Integer ColumnIdx,Integer Width){
       TableColumn column= jtblBrowse.getColumnModel().getColumn(ColumnIdx);
       column.setMinWidth(0);
       column.setMaxWidth(Width);
       column.setPreferredWidth(Width);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSelect = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblBrowse = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnSelect.setText("Select");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jtblBrowse.setAutoCreateRowSorter(true);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbtnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSelect)
                    .addComponent(jbtnCancel))
                .addGap(20, 20, 20))
        );

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
                   fourth.setText(tmodel.getValueAt(irow,2).toString());
               }
           }
      }
   }
   
   setVisible(false); 
   
   setCursor(GlobalUtils.NORMALCURSOR);

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed

private void jtblBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBrowseMouseClicked
    
      if (evt.getClickCount() == 2){
         selectRow();
      }
    
}//GEN-LAST:event_jtblBrowseMouseClicked

private void jtblBrowseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblBrowseKeyPressed

}//GEN-LAST:event_jtblBrowseKeyPressed

private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed

}//GEN-LAST:event_jScrollPane1KeyPressed

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    
}//GEN-LAST:event_formWindowOpened



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnSelect;
    public javax.swing.JTable jtblBrowse;
    // End of variables declaration//GEN-END:variables

    protected JTable jtableparam;
    protected TableModel tmodelparam;
    protected int coltable1 = 0;
    protected int rowtable1 = 0;
    
}
