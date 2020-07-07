/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.kazao.calendar.KazaoCalendarDate;
import org.kazao.calendar.KazaoCalendarDateTimeException;

public class TableRenderKazao extends KazaoCalendarDate
                         implements TableCellEditor, ActionListener {

    JTable  jtable;
    int row;
    int column;
    
    
    String tanggal;
    
    

    
    public DefaultTableModel tmodel;
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
            this.row = row;
            this.column = column;
            
            this.setDate(new Date());
            
            if (value != null) {
                try {
                    tanggal = value.toString();
                    this.setDate(value.toString());
                } catch (KazaoCalendarDateTimeException ex) {
                    ex.printStackTrace();
                }
            }else {
                tanggal = "";
            }
            
            tmodel.setValueAt(this.getDate(), row, column);
            this.setVisible(true);

            
            return this;
    }

    public Object getCellEditorValue() {
        
        
        return tanggal;
        
    }

    public boolean isCellEditable(EventObject anEvent) {
       
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent) {

        
        return true;
    }

    public boolean stopCellEditing() {
        
        tmodel.setValueAt(this.getDate(), row, column);
        
        
        return true;
    }

    public void cancelCellEditing() {
        tmodel.setValueAt(tanggal, row, column);
    }

    public void addCellEditorListener(CellEditorListener l) {
        
        
    }

    public void removeCellEditorListener(CellEditorListener l) {

    }

    public void actionPerformed(ActionEvent e) {

    }

  

}
