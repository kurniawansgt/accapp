/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_distcodeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_distcode obj = new Ap_distcode();
 * 
 * 2. Ap_distcode obj = new Ap_distcode(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode(1);
 * 
 *    It Means : Select * from ap_distcode where id = 1;
 * 
 * 3. Ap_distcode obj = new Ap_distcode(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode(1);
 * 
 *    It Means : Select * from ap_distcode where id = 1;
 * 
 * 4. Ap_distcode obj = new Ap_distcode(<primary_key>); 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode("1");
 *    It Means : Select * from ap_distcode where <primary_key> = "1";
 * 
 * 5. Ap_distcode obj = new Ap_distcode(Ap_distcode.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode(Ap_distcode.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_distcode where id = "1";
 * 
 * 6. Ap_distcode obj = new Ap_distcode();
 *    obj.loadString(Ap_distcode.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode();
 *    obj.loadString(Ap_distcode.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_distcode where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_distcode Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_distcode : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_distcode obj = new Ap_distcode(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_distcode where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import accapp.objectclasses.gl.Gl_account;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ap_distcode extends Ap_distcodeAbst{
    public Ap_distcode() throws CodeException {
       
    }
    
    public Ap_distcode(long id) throws CodeException {
        super(id);
    }
    
    public Ap_distcode(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_distcode(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_distcode(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void setglacccode(String param) throws CodeException {
        super.setglacccode(param.replace("-", ""));
    }
    
    public String getGLAccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getglacccode());
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
        this.setobjtype(ObjectType.AP_DISTCODE);
        super.save();


    }

    public String getglacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getglacccode());
    } 
}




