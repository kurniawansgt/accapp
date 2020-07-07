/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.gl.Gl_accounts;
import common.component.FrmBrowse;
import common.jdbc.DbBean;
import common.utils.CodeException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author wgata
 */
public class FrmBrowseAr_invoblAdjustmentByCustomer extends FrmBrowse{

    public String custmrcode = "";
    public String doctype = "";

    public FrmBrowseAr_invoblAdjustmentByCustomer(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseAr_invoblAdjustmentByCustomer(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseAr_invoblAdjustmentByCustomer(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseAr_invoblAdjustmentByCustomer(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseAr_invoblAdjustmentByCustomer(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseAr_invoblAdjustmentByCustomer(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select "+this.fields+" from ar_invobl where  custmrcode='" + custmrcode + "' ";
        this.isoverwrite=true;
        if (doctype != null && !doctype.equals("")) {
            sql = sql + " and doctype=" + doctype  ;
        }

        if (!value.equals("")) {
            if (searchmethod == Gl_accounts.SEARCHNORMALY) {
                sql += "\n and  " + field + " =  '" + value + "' ";
            }else if (searchmethod == Gl_accounts.SEARCHSTARTWITH){
                sql += "\n and  " + field + " like  '" + value + "%' ";
            }else {
                sql += "\n and  " + field + " like  '%" + value + "%' ";
            }
        }
        sql += "\n order by "  + field + " " + sortby;
    }


}
