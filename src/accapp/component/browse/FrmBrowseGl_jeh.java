/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.gl.Gl_accounts;
import common.classinterface.CodeObjectInt;
import common.component.FrmBrowse;
import common.jdbc.DbBean;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author wgata
 */
public class FrmBrowseGl_jeh extends FrmBrowse{


    public String Journal_Id_from  = "";
    public String Journal_Id_to  = "";

    public FrmBrowseGl_jeh(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseGl_jeh(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseGl_jeh(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseGl_jeh(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseGl_jeh(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseGl_jeh(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        String sql = "select * from (select * from gl_jeh where batchid = '" + this.Journal_Id_from + "' and '"+this.Journal_Id_to+"') as  gl_jeh ";

        if (!value.equals("")) {
            if (searchmethod == Gl_accounts.SEARCHNORMALY) {
                sql += "\n where  " + field + " =  '" + value + "' ";
            }else if (searchmethod == Gl_accounts.SEARCHSTARTWITH){
                sql += "\n where  " + field + " like  '" + value + "%' ";
            }else {
                sql += "\n where  " + field + " like  '%" + value + "%' ";
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
