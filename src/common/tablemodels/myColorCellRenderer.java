/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import common.utils.GlobalUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wgata
 */
public class myColorCellRenderer extends DefaultTableCellRenderer {

    private Color color;
    
    public myColorCellRenderer() {
    }


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        // let the default renderer prepare the component for us
        Component comp = super.getTableCellRendererComponent(table, value,
                                            isSelected, hasFocus, row, column);

        // now get the current font used for this cell
        Font font = comp.getFont();
        int sts=GlobalUtils.toInt(GlobalUtils.churuf(table.getValueAt(row, table.getColumnCount()-2)));

        // check if this cell is in the selected row
        if (row == table.getSelectedRow()) {
            // set the background CYAN and set the font BOLD
            if (sts==3){
            comp.setBackground(Color.RED);
            } else {
            comp.setBackground(Color.lightGray);
            }
            comp.setForeground(Color.BLACK);
            comp.setFont(font.deriveFont(Font.PLAIN));
        }
        else {    // cell is not in the selected row
            // set the default background and font
            if (sts==3){
            comp.setBackground(Color.RED);
            } else {
            comp.setBackground(Color.WHITE);
            }
            comp.setForeground(Color.BLACK);
            comp.setFont(font.deriveFont(Font.PLAIN));
        }
        return comp;
         
    }

}

