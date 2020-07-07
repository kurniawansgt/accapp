/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import common.utils.GlobalUtils;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author isparthama
 */
public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    // This is the component that will handle the editing of the cell value
    JComponent component = new JTextField();
    int selectedcol;
    int editcolno;
    int rules;

    public MyTableCellEditor(int editcolno,int rules){
        this.editcolno=editcolno;
        this.rules=rules;
    }

    public MyTableCellEditor(int editcolno,int rules,JComboBox combo){
        this.editcolno=editcolno;
        this.rules=rules;
        this.component=combo;
    }
    // This method is called when a cell value is edited by the user.
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)

        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }
        selectedcol=vColIndex;
        // Configure the component with the specified value
        
        if (vColIndex==this.editcolno){
            if (this.rules==1){
                ((JTextField)component).setText(GlobalUtils.formatnumber(GlobalUtils.toDbl(GlobalUtils.churuf(value))).replace(",", ""));
                JTextField t=(JTextField)component;
                t.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                t.setSelectionEnd(t.getText().length());
                component=t;
            }
        } else {
            ((JTextField)component).setText((String)value);
        }

        // Return the configured component
        
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        if (this.selectedcol==this.editcolno){
            if (this.rules==1){
                Object result =((JTextField)component).getText();
                return GlobalUtils.toDbl(GlobalUtils.churuf(result));
            }
            if (this.rules==2){
                Object result =((JComboBox)component).getSelectedItem();
                return GlobalUtils.churuf(result);
            }
        }

        return ((JTextField)component).getText();


    }
}
