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
public class FrmBrowseGl_currencyrated extends FrmBrowse{
    public String homcur;
    public String ratetype;
    public String sourcecur;

    public FrmBrowseGl_currencyrated(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseGl_currencyrated(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseGl_currencyrated(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseGl_currencyrated(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseGl_currencyrated(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseGl_currencyrated(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        String sql = "select * from gl_currencyrated where homecur='"+this.homcur+"' and ratetype='"+this.ratetype+"' and sourcecur='"+this.sourcecur+"'";


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
            System.out.println(sql);
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
