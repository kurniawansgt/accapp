/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_interestAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_interest obj = new Ar_interest();
 * 
 * 2. Ar_interest obj = new Ar_interest(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_interest obj = new Ar_interest(1);
 * 
 *    It Means : Select * from ar_interest where id = 1;
 * 
 * 3. Ar_interest obj = new Ar_interest(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_interest obj = new Ar_interest(1);
 * 
 *    It Means : Select * from ar_interest where id = 1;
 * 
 * 4. Ar_interest obj = new Ar_interest(<primary_key>); 
 *    Sample :
 *    Ar_interest obj = new Ar_interest("1");
 *    It Means : Select * from ar_interest where <primary_key> = "1";
 * 
 * 5. Ar_interest obj = new Ar_interest(Ar_interest.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_interest obj = new Ar_interest(Ar_interest.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_interest where id = "1";
 * 
 * 6. Ar_interest obj = new Ar_interest();
 *    obj.loadString(Ar_interest.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_interest obj = new Ar_interest();
 *    obj.loadString(Ar_interest.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_interest where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_interest Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_interest : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_interest obj = new Ar_interest(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_interest obj = new Ar_interest(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_interest where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.gl.Gl_account;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ar_interest extends Ar_interestAbst{
    public Ar_interest() throws CodeException {
       
    }
    
    public Ar_interest(long id) throws CodeException {
        super(id);
    }
    
    public Ar_interest(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_interest(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_interest(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void setacccode(String param) throws CodeException {
        super.setacccode(param.replace("-", ""));
    }
    

    public String getAccountDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getacccode());
        return glacc.getaccdesc();
    }

    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_INTEREST);
        super.save();


    }
}




