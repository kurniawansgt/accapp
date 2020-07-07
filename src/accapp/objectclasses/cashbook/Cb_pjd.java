/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_pjdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_pjd obj = new Cb_pjd();
 * 
 * 2. Cb_pjd obj = new Cb_pjd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd(1);
 * 
 *    It Means : Select * from cb_pjd where id = 1;
 * 
 * 3. Cb_pjd obj = new Cb_pjd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd(1);
 * 
 *    It Means : Select * from cb_pjd where id = 1;
 * 
 * 4. Cb_pjd obj = new Cb_pjd(<primary_key>); 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd("1");
 *    It Means : Select * from cb_pjd where <primary_key> = "1";
 * 
 * 5. Cb_pjd obj = new Cb_pjd(Cb_pjd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd(Cb_pjd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_pjd where id = "1";
 * 
 * 6. Cb_pjd obj = new Cb_pjd();
 *    obj.loadString(Cb_pjd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd();
 *    obj.loadString(Cb_pjd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_pjd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_pjd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_pjd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_pjd obj = new Cb_pjd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_pjd where id = 1;
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
public class Cb_pjd extends Cb_pjdAbst{
    public Cb_pjd() throws CodeException {
       
    }
    
    public Cb_pjd(long id) throws CodeException {
        super(id);
    }
    
    public Cb_pjd(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_pjd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_pjd(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }


    public int getMaxEntryNo(double pseqno,double pseqentry) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(pseqentrydetail) is null then 1 else max(pseqentrydetail) + 1 end nomor "
                            + "\n from cb_pjd where pseqno=" + pseqno + " and pseqentry=" + pseqentry;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_pjh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }
    
}




