/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_custnatAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_custnat obj = new Ar_custnat();
 * 
 * 2. Ar_custnat obj = new Ar_custnat(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat(1);
 * 
 *    It Means : Select * from ar_custnat where id = 1;
 * 
 * 3. Ar_custnat obj = new Ar_custnat(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat(1);
 * 
 *    It Means : Select * from ar_custnat where id = 1;
 * 
 * 4. Ar_custnat obj = new Ar_custnat(<primary_key>); 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat("1");
 *    It Means : Select * from ar_custnat where <primary_key> = "1";
 * 
 * 5. Ar_custnat obj = new Ar_custnat(Ar_custnat.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat(Ar_custnat.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_custnat where id = "1";
 * 
 * 6. Ar_custnat obj = new Ar_custnat();
 *    obj.loadString(Ar_custnat.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat();
 *    obj.loadString(Ar_custnat.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_custnat where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_custnat Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_custnat : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_custnat obj = new Ar_custnat(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_custnat where id = 1;
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
public class Ar_custnat extends Ar_custnatAbst{
    public Ar_custnat() throws CodeException {
       
    }
    
    public Ar_custnat(long id) throws CodeException {
        super(id);
    }
    
    public Ar_custnat(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_custnat(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_custnat(ResultSet rs) throws CodeException {
        super(rs);
    }


    public String getAccSetDesc() throws CodeException {
        Ar_accset accset=new Ar_accset(Ar_accset.PROPERTY_ACCSETCODE,this.getaccsetcode());
        return accset.getdscription();
    }

    public String getBillCycleDesc () throws CodeException {
            Ar_billcycl billcycl=new Ar_billcycl(Ar_billcycl.PROPERTY_CYCLCODE,this.getcyclcode());
            return billcycl.getdscrition();
    }


    public String getInterestDesc() throws CodeException {
            Ar_interest interest=new Ar_interest(Ar_interest.PROPERTY_INTRSCHRCODE,this.getintrschrcode());
            return interest.getdscription();
    }

    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_CUSTNAT);
        super.save();


    }

    public void setaccsetcode(String param) throws CodeException {
        super.setaccsetcode(param.replace("-", ""));
    }
    public void setcyclcode(String param) throws CodeException {
        super.setcyclcode(param.replace("-", ""));
    }

    public void setintrschrcode(String param) throws CodeException {
        super.setintrschrcode(param.replace("-", ""));
    }

    

}




