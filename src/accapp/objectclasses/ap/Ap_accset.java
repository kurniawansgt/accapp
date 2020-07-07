/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_accsetAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_accset obj = new Ap_accset();
 * 
 * 2. Ap_accset obj = new Ap_accset(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_accset obj = new Ap_accset(1);
 * 
 *    It Means : Select * from ap_accset where id = 1;
 * 
 * 3. Ap_accset obj = new Ap_accset(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_accset obj = new Ap_accset(1);
 * 
 *    It Means : Select * from ap_accset where id = 1;
 * 
 * 4. Ap_accset obj = new Ap_accset(<primary_key>); 
 *    Sample :
 *    Ap_accset obj = new Ap_accset("1");
 *    It Means : Select * from ap_accset where <primary_key> = "1";
 * 
 * 5. Ap_accset obj = new Ap_accset(Ap_accset.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_accset obj = new Ap_accset(Ap_accset.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_accset where id = "1";
 * 
 * 6. Ap_accset obj = new Ap_accset();
 *    obj.loadString(Ap_accset.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_accset obj = new Ap_accset();
 *    obj.loadString(Ap_accset.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_accset where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_accset Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_accset : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_accset obj = new Ap_accset(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_accset obj = new Ap_accset(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_accset where id = 1;
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
public class Ap_accset extends Ap_accsetAbst{
    public Ap_accset() throws CodeException {
       
    }
    
    public Ap_accset(long id) throws CodeException {
        super(id);
    }
    
    public Ap_accset(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_accset(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_accset(ResultSet rs) throws CodeException {
        super(rs);
    }


    public String getAppAccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getapacccode());
        return glacc.getaccdesc();
    }
    public String getDiscAccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getdiscacccode());

        return glacc.getaccdesc();
    }
    public String getPrePayAccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getprepayacccode());

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
        this.setobjtype(ObjectType.AP_ACCSET);
        super.save();


    }

    public void setaccsetcode(String param) throws CodeException {
        super.setaccsetcode(param.replace("-", ""));
    }

    public String getaccsetcodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getaccsetcode());
    }

    public void setapacccode(String param) throws CodeException {
        super.setapacccode(param.replace("-", ""));
    }
    
    public String getapacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getapacccode());
    } 

    public void setdiscacccode(String param) throws CodeException {
        super.setdiscacccode(param.replace("-", ""));
    }
    public String getdiscacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getdiscacccode());
    }


    public void setprepayacccode(String param) throws CodeException {
        super.setprepayacccode(param.replace("-", ""));
    }
    public String getprepayacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getprepayacccode());
    }

    
}




