/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author wgata
 */
public class GlobalModel {

    public static void setColHeader(DefaultTableModel dtm, String[][] columns){
        for (int i=0;i<columns.length;i++){
            dtm.addColumn(columns[i][0]);
        }
    }

   
    public static void setCol (JTable jtable, String[][] columns) {
        for (int i=0;i<columns.length;i++){
            setColumnWidth(jtable, i, Integer.parseInt(columns[i][2]));
        }       
    }

    public static void setCol (JTable jtable, int[] columns) {
        for (int i=0;i<columns.length;i++){
            setColumnWidth(jtable, i,columns[i]);
        }       
    }
    
    public static void showTable(JTable jtable, DefaultTableModel dtm) {
            jtable.setModel(dtm);
    }
    
    public static void setColumnWidth(JTable jtable, Integer ColumnIdx,Integer Width){
       TableColumn column= jtable.getColumnModel().getColumn(ColumnIdx);
       column.setResizable(false);
       column.setMinWidth(0);
       column.setMaxWidth(Width);
       column.setPreferredWidth(Width);
    }    
    
    public static void clearRow (DefaultTableModel dtm) {
        int row = dtm.getRowCount();			
        while(row > 0){	
           row--;				
           dtm.removeRow(row);
        }
             
    }

    private static Boolean isrowempty(DefaultTableModel dtm,int row){
        int i=0;
        for (i=0;i<dtm.getColumnCount();i++){
            if (dtm.getValueAt(row, i)!=null){
                return false;
            }
        }
        return true;
    }
    public static void clearEmptyRow (DefaultTableModel dtm) {
       int row = dtm.getRowCount();
        while(row > 0){
           row--;
           if (isrowempty(dtm,row)){
                dtm.removeRow(row);

           }
        }

    }
    
    private void renderColumn(JTable jtable, Integer ColumnIdx,final Boolean RightAlignment, final Boolean CenterAlignment){
          jtable.getColumnModel().getColumn(ColumnIdx).setCellRenderer(new DefaultTableCellRenderer(){
          public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
            if (RightAlignment){
                setHorizontalAlignment(RIGHT);
            }
            if (CenterAlignment){
                setHorizontalAlignment(CENTER);
            }
            return super.getTableCellRendererComponent(table, value, isSelected,
                                                      hasFocus, row, column);
          }
        });       
    }
}
