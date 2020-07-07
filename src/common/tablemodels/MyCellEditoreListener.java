/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import accapp.component.cashbook.FrmCb_batchentry;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author solution
 */
public class MyCellEditoreListener implements CellEditorListener{
    FrmCb_batchentry ofrm=null;

    public MyCellEditoreListener(FrmCb_batchentry ofrm){
        this.ofrm=ofrm;
    }

    public void editingStopped(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
