/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.ap.Ap_vendors;
import common.component.FrmBrowse;
import common.utils.CodeException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author wgata
 */
public class FrmBrowseCb_voucher extends FrmBrowse{


    public FrmBrowseCb_voucher(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseCb_voucher(Object obj) throws CodeException {
        super(obj);
    }

    public FrmBrowseCb_voucher(Object obj,Boolean desc) throws CodeException {
        super(obj,desc);
    }

    public FrmBrowseCb_voucher(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseCb_voucher(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseCb_voucher(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseCb_voucher(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
        jchkDesc.setSelected(false);
    }

    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select "+this.fields+" from (select "+this.fields+" from cb_voucher where docstatus='O') as cb_voucher ";
        this.isoverwrite=true;
        if (!value.equals("")) {
            if (searchmethod == Ap_vendors.SEARCHNORMALY) {
                sql += "\n where " + field + " =  '" + value + "' ";
            }else if (searchmethod == Ap_vendors.SEARCHSTARTWITH){
                sql += "\n where " + field + " like  '" + value + "%' ";
            }else {
                sql += "\n where " + field + " like  '%" + value + "%' ";
            }
        }
        sql += "\n order by "  + field + " " + sortby;
    }


}
