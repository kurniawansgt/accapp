/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_vendgrpstsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_vendgrpsts obj = new Ap_vendgrpsts();
 * 
 * 2. Ap_vendgrpsts obj = new Ap_vendgrpsts(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts(1);
 * 
 *    It Means : Select * from ap_vendgrpsts where id = 1;
 * 
 * 3. Ap_vendgrpsts obj = new Ap_vendgrpsts(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts(1);
 * 
 *    It Means : Select * from ap_vendgrpsts where id = 1;
 * 
 * 4. Ap_vendgrpsts obj = new Ap_vendgrpsts(<primary_key>); 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts("1");
 *    It Means : Select * from ap_vendgrpsts where <primary_key> = "1";
 * 
 * 5. Ap_vendgrpsts obj = new Ap_vendgrpsts(Ap_vendgrpsts.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts(Ap_vendgrpsts.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_vendgrpsts where id = "1";
 * 
 * 6. Ap_vendgrpsts obj = new Ap_vendgrpsts();
 *    obj.loadString(Ap_vendgrpsts.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts();
 *    obj.loadString(Ap_vendgrpsts.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_vendgrpsts where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_vendgrpsts Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_vendgrpsts : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_vendgrpsts obj = new Ap_vendgrpsts(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_vendgrpsts where id = 1;
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
public class Ap_vendgrpsts extends Ap_vendgrpstsAbst{
    public Ap_vendgrpsts() throws CodeException {
       
    }
    
    public Ap_vendgrpsts(long id) throws CodeException {
        super(id);
    }
    
    public Ap_vendgrpsts(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_vendgrpsts(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_vendgrpsts(ResultSet rs) throws CodeException {
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




       public void searchData(String yop, String mop, String grpcode) throws CodeException {
        try {

            String query = " select * from ap_vendgrpsts where yop = '" + yop + "' and mop = '" + mop + "' and grpcode ='" + grpcode + "'";

            DbBean db = DbBean.connect();
            ResultSet rs = db.executeQuery(query);

            if (rs.next()) {
                loadRs(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Error Ap_Vendor Group STS : " + ex.getMessage());
       }
    }
}




