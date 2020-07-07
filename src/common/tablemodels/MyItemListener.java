/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 *
 * @author puja
 */
class MyItemListener implements ItemListener {
    // This method is called only if a new item has been selected.

    public void itemStateChanged(ItemEvent evt) {
        JComboBox cb = (JComboBox)evt.getSource();

        // Get the affected item
        Object item = evt.getItem();

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Item was just selected
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            // Item is no longer selected
        }
    }
}

