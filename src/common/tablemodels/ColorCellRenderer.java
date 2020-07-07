/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import java.awt.Color;
import java.awt.Component;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wgata
 */
public class ColorCellRenderer extends DefaultTableCellRenderer {

    private Vector v;
    private Color color;
    
    public ColorCellRenderer() {
    }

    public void setRowToColor(Vector v, Color color) {
        this.v = v;
        this.color = color;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (v != null) {
            boolean bcek = false;
            for (Enumeration e = v.elements(); e.hasMoreElements();) {
                Integer i = (Integer) e.nextElement();
                if (row == i) {
                    bcek = true;
                    break;
                }
            }

            if (bcek) {
                    component.setBackground(color);
            }else{
                   component.setBackground(Color.WHITE);                
            }
        }
        return component;
         
    }
}