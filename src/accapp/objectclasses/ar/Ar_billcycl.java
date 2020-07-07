/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_billcyclAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_billcycl obj = new Ar_billcycl();
 * 
 * 2. Ar_billcycl obj = new Ar_billcycl(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl(1);
 * 
 *    It Means : Select * from ar_billcycl where id = 1;
 * 
 * 3. Ar_billcycl obj = new Ar_billcycl(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl(1);
 * 
 *    It Means : Select * from ar_billcycl where id = 1;
 * 
 * 4. Ar_billcycl obj = new Ar_billcycl(<primary_key>); 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl("1");
 *    It Means : Select * from ar_billcycl where <primary_key> = "1";
 * 
 * 5. Ar_billcycl obj = new Ar_billcycl(Ar_billcycl.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl(Ar_billcycl.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_billcycl where id = "1";
 * 
 * 6. Ar_billcycl obj = new Ar_billcycl();
 *    obj.loadString(Ar_billcycl.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl();
 *    obj.loadString(Ar_billcycl.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_billcycl where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_billcycl Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_billcycl : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_billcycl obj = new Ar_billcycl(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_billcycl where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ar_billcycl extends Ar_billcyclAbst{
    public Ar_billcycl() throws CodeException {
       
    }
    
    public Ar_billcycl(long id) throws CodeException {
        super(id);
    }
    
    public Ar_billcycl(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_billcycl(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_billcycl(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_BILLCYCL);
        super.save();


    }
}




