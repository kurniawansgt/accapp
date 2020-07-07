/*
 * CheckBoxRenderer.java
 *
 * Created on August 27, 2007, 4:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package common.tablemodels;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ISParthama
 */
public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

  public CheckBoxRenderer() {
    setHorizontalAlignment(JLabel.CENTER);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setSelected((value != null && ((Boolean) value).booleanValue()));
    return this;
  }
  private void MyCheckBoxRenderer(JTable table){
        Integer i=new Integer(0);
        for (i=0;i<table.getRowCount();i++){
            if (table.getValueAt(i,8)==""){
                //table.setValueAt(bselect,i,0);
                setSelected(false);
            }
        }
  }
}
