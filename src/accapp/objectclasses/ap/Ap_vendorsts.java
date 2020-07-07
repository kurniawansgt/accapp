/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_vendorstsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_vendorsts obj = new Ap_vendorsts();
 * 
 * 2. Ap_vendorsts obj = new Ap_vendorsts(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts(1);
 * 
 *    It Means : Select * from ap_vendorsts where id = 1;
 * 
 * 3. Ap_vendorsts obj = new Ap_vendorsts(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts(1);
 * 
 *    It Means : Select * from ap_vendorsts where id = 1;
 * 
 * 4. Ap_vendorsts obj = new Ap_vendorsts(<primary_key>); 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts("1");
 *    It Means : Select * from ap_vendorsts where <primary_key> = "1";
 * 
 * 5. Ap_vendorsts obj = new Ap_vendorsts(Ap_vendorsts.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts(Ap_vendorsts.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_vendorsts where id = "1";
 * 
 * 6. Ap_vendorsts obj = new Ap_vendorsts();
 *    obj.loadString(Ap_vendorsts.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts();
 *    obj.loadString(Ap_vendorsts.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_vendorsts where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_vendorsts Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_vendorsts : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_vendorsts obj = new Ap_vendorsts(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_vendorsts where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_vendorsts extends Ap_vendorstsAbst{
    public Ap_vendorsts() throws CodeException {
       
    }
    
    public Ap_vendorsts(long id) throws CodeException {
        super(id);
    }
    
    public Ap_vendorsts(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_vendorsts(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_vendorsts(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setauditdate(this.getentrydate());
        this.setaudituser(GlobalUtils.getUserId());
        this.setcmpnyid(GlobalUtils.company);
        super.saveNew();
    }

    @Override
    public void save() throws CodeException {
        this.setauditdate(this.getauditdate());
        this.setaudituser(GlobalUtils.getUserId());
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }

   public void searchData(String yop, String mop, String vendcode) throws CodeException {
        try {

            String query = " select * from ap_vendorsts where yop = '" + yop + "' and mop = '" + mop + "' and vendcode ='" + vendcode + "'";

            DbBean db = DbBean.connect();
            ResultSet rs = db.executeQuery(query);

            if (rs.next()) {
                loadRs(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Error Ap_Vendor Statistic : " + ex.getMessage());
       }
    }
    
}




