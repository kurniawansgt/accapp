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
public class FrmBrowseAp_invoblByVendor extends FrmBrowse{

    public String vendcode = "";

    public FrmBrowseAp_invoblByVendor(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseAp_invoblByVendor(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseAp_invoblByVendor(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseAp_invoblByVendor(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseAp_invoblByVendor(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseAp_invoblByVendor(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select "+this.fields+" from ap_invobl where vendcode = '" + vendcode + "' and doctotalamtr > 0 " ;
        this.isoverwrite=true;
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
