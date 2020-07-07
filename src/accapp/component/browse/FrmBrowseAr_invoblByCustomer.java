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
public class FrmBrowseAr_invoblByCustomer extends FrmBrowse{

    public String custmrcode = "";

    public FrmBrowseAr_invoblByCustomer(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseAr_invoblByCustomer(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseAr_invoblByCustomer(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseAr_invoblByCustomer(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseAr_invoblByCustomer(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseAr_invoblByCustomer(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        String sql = "select * from ar_invobl where custmrcode = '" + custmrcode + "' and doctotalamtr > 0 " ;

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
        sql += "\n limit " + skip + ", 101 ";


        DbBean db = DbBean.connect();
        try {

            ResultSet rs = db.executeQuery(sql);
            nbd.recordLoad(rs);
            rs.close();

        } catch (SQLException ex) {
            throw new CodeException("Error Browse " + ex.getMessage());
        }finally{
            db.close();
        }
    }


}
