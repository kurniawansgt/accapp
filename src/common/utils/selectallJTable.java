/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

/**
 *
 * @author isparthama
 */
public class selectallJTable extends JTable{
    public selectallJTable(AbstractTableModel dataModel) {
        super(dataModel);
        TableCellRenderer highlightRenderer = new SelectAll();
        setDefaultRenderer(Object.class, highlightRenderer);
      }

      public boolean editCellAt(int row, int column, EventObject e) {
        boolean result = super.editCellAt(row, column, e);
        Component editor = getEditorComponent();
        if (editor != null) {
          if (editor instanceof JComboBox)
            editor = ((JComboBox) editor).getEditor().getEditorComponent();
          if (editor instanceof JTextComponent) {

              ((JTextComponent)editor).selectAll();

          }
        }
        return result;
      }

    class SelectAll extends DefaultTableCellRenderer {
        private Color selectionBackground = UIManager.getColor("TextField.selectionBackground");
        private Border editBorder = BorderFactory.createLineBorder(Color.BLACK);
        private boolean cellHasFocus;

        public Component getTableCellRendererComponent(
          JTable table, Object value, boolean isSelected,
          boolean hasFocus, int row, int column) {
          super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          cellHasFocus = hasFocus;
          return this;
        }

        protected void paintComponent(Graphics g) {
          if (cellHasFocus && !getText().equals("")) {
            setBorder( editBorder );
            g.setColor( selectionBackground );
            g.fillRect(0, 0, getPreferredSize().width, getSize().height);
          }
          super.paintComponent(g);
        }
      }
}
