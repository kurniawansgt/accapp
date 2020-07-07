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
public class FrmBrowseCb_batchh extends FrmBrowse{


    public FrmBrowseCb_batchh(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseCb_batchh(Object obj) throws CodeException {
        super(obj);
    }

    public FrmBrowseCb_batchh(Object obj,Boolean desc) throws CodeException {
        super(obj,desc);
    }

    public FrmBrowseCb_batchh(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseCb_batchh(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseCb_batchh(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseCb_batchh(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
        jchkDesc.setSelected(false);
    }

    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select "+this.fields+" from (select "+this.fields+" from cb_batchh where custcheqno<>'') as cb_batchh ";
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
