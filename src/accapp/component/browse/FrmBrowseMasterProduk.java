/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.component.browse;

import accapp.objectclasses.ar.Ar_customers;
import common.component.FrmBrowse;
import common.utils.CodeException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author wgata
 */
public class FrmBrowseMasterProduk extends FrmBrowse{


    public FrmBrowseMasterProduk(JInternalFrame jf,Object obj) throws CodeException {
        super(jf,obj);
    }

    public FrmBrowseMasterProduk(Object obj) throws CodeException {
        super(obj);
    }


    public FrmBrowseMasterProduk(JInternalFrame jf, Object obj, String filterfield) throws CodeException {
        super(jf,obj, filterfield);
    }
    public FrmBrowseMasterProduk(Object obj, String filterfield) {
        super(obj, filterfield);
    }

    public FrmBrowseMasterProduk(JTable jtable, Object obj, int row, int col) {
        super(jtable, obj, row, col);
    }

    public FrmBrowseMasterProduk(TableModel tmodel, Object obj, int row, int col) {
        super(tmodel, obj, row, col);
    }


    public void getNavigatorBrowseData (String field, String value, int searchmethod, String sortby ) throws CodeException{
        this.sql = "select * from manufaktur.masterproduk ";
        this.isoverwrite=true;
        if (!value.equals("")) {
            if (searchmethod == Ar_customers.SEARCHNORMALY) {
                sql += "\n where  " + field + " =  '" + value + "' ";
            }else if (searchmethod == Ar_customers.SEARCHSTARTWITH){
                sql += "\n where  " + field + " like  '" + value + "%' ";
            }else {
                sql += "\n where  " + field + " like  '%" + value + "%' ";
            }
        }
        sql += "\n order by "  + field + " " + sortby;
        
        System.out.println(sql);
    }


}
