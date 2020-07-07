/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.gl.Gl_accounts;
import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_batchlists;
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
public class FrmBrowseAR_invoBatchList extends FrmBrowse{


    public String Journal_Id_from  = "";
    public String Journal_Id_to  = "";

    public FrmBrowseAR_invoBatchList(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseAR_invoBatchList(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseAR_invoBatchList(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseAR_invoBatchList(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseAR_invoBatchList(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseAR_invoBatchList(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        String sql = "SELECT * FROM ar_invbatchlist";
        //field = "batchno";
        //sortby = "DESC";
        if (!value.equals("")) {
            if (searchmethod == Gl_batchlists.SEARCHNORMALY) {
                sql += "\n where  " + field + " =  '" + value + "' ";
            }else if (searchmethod == Gl_batchlists.SEARCHSTARTWITH){
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
