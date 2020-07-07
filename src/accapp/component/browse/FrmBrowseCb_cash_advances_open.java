/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.cashbook.Cb_cash_advances;
import common.component.FrmBrowse;
import common.utils.CodeException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author wgata
 */
public class FrmBrowseCb_cash_advances_open extends FrmBrowse{


    public FrmBrowseCb_cash_advances_open(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseCb_cash_advances_open(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseCb_cash_advances_open(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseCb_cash_advances_open(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseCb_cash_advances_open(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseCb_cash_advances_open(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select * from cb_cash_advance where advance_status = 'O' ";
        this.isoverwrite=true;

        if (!value.equals("")) {
            if (searchmethod == Cb_cash_advances.SEARCHNORMALY) {
                sql += "\n and  " + field + " =  '" + value + "' ";
            }else if (searchmethod == Cb_cash_advances.SEARCHSTARTWITH){
                sql += "\n and  " + field + " like  '" + value + "%' ";
            }else {
                sql += "\n and  " + field + " like  '%" + value + "%' ";
            }
        }
        sql += "\n order by "  + field + " " + sortby;
    }


}
