/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_accsetAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_accset obj = new Ar_accset();
 * 
 * 2. Ar_accset obj = new Ar_accset(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_accset obj = new Ar_accset(1);
 * 
 *    It Means : Select * from ar_accset where id = 1;
 * 
 * 3. Ar_accset obj = new Ar_accset(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_accset obj = new Ar_accset(1);
 * 
 *    It Means : Select * from ar_accset where id = 1;
 * 
 * 4. Ar_accset obj = new Ar_accset(<primary_key>); 
 *    Sample :
 *    Ar_accset obj = new Ar_accset("1");
 *    It Means : Select * from ar_accset where <primary_key> = "1";
 * 
 * 5. Ar_accset obj = new Ar_accset(Ar_accset.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_accset obj = new Ar_accset(Ar_accset.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_accset where id = "1";
 * 
 * 6. Ar_accset obj = new Ar_accset();
 *    obj.loadString(Ar_accset.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_accset obj = new Ar_accset();
 *    obj.loadString(Ar_accset.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_accset where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_accset Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_accset : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_accset obj = new Ar_accset(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_accset obj = new Ar_accset(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_accset where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_currency;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ar_accset extends Ar_accsetAbst{


    public Ar_accset() throws CodeException {
       
    }
    
    public Ar_accset(long id) throws CodeException {
        super(id);
    }
    
    public Ar_accset(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_accset(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_accset(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getARAccountDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaracccode());
        return glacc.getaccdesc();
    }
    public String getDiscAccountDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getdiscacccode());
        return glacc.getaccdesc();
    }
    public String getPrepayAccountDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getprepayacccode());
        return glacc.getaccdesc();
    }
    public String getWrofAccountDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getwrofacccode());
        return glacc.getaccdesc();
    }
    public String getCurncDesc() throws CodeException {
        Gl_currency glcur = new Gl_currency(this.getcurnccode());
        return glcur.getcurncdesc();
    }


    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_ACCSET);
        super.save();


    }
    public void setaccsetcode(String param) throws CodeException {
         super.setaccsetcode(param.replace("-", "")) ;
    }

    
}




