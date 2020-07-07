/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_pjsdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_pjsd obj = new Cb_pjsd();
 * 
 * 2. Cb_pjsd obj = new Cb_pjsd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd(1);
 * 
 *    It Means : Select * from cb_pjsd where id = 1;
 * 
 * 3. Cb_pjsd obj = new Cb_pjsd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd(1);
 * 
 *    It Means : Select * from cb_pjsd where id = 1;
 * 
 * 4. Cb_pjsd obj = new Cb_pjsd(<primary_key>); 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd("1");
 *    It Means : Select * from cb_pjsd where <primary_key> = "1";
 * 
 * 5. Cb_pjsd obj = new Cb_pjsd(Cb_pjsd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd(Cb_pjsd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_pjsd where id = "1";
 * 
 * 6. Cb_pjsd obj = new Cb_pjsd();
 *    obj.loadString(Cb_pjsd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd();
 *    obj.loadString(Cb_pjsd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_pjsd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_pjsd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_pjsd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_pjsd obj = new Cb_pjsd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_pjsd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Cb_pjsd extends Cb_pjsdAbst{
    public Cb_pjsd() throws CodeException {
       
    }
    
    public Cb_pjsd(long id) throws CodeException {
        super(id);
    }
    
    public Cb_pjsd(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_pjsd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_pjsd(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxDetailNo() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select max(pseqentrysubdetail) as nomor from cb_pjsd where pseqno="+this.getpseqno()+" and pseqentry="+this.getpseqentry()+" and pseqentrydetail="+this.getpseqentrydetail();

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");
                entry++;
            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_pjsd : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    @Override
    public void saveNew() throws CodeException {
        this.setpseqentrysubdetail(getMaxDetailNo());

        this.setentrydate(GlobalUtils.getAuditDate());
        super.saveNew();
    }

    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.userid);
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }




    
}




