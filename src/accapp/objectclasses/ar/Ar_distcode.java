/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_distcodeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_distcode obj = new Ar_distcode();
 * 
 * 2. Ar_distcode obj = new Ar_distcode(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode(1);
 * 
 *    It Means : Select * from ar_distcode where id = 1;
 * 
 * 3. Ar_distcode obj = new Ar_distcode(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode(1);
 * 
 *    It Means : Select * from ar_distcode where id = 1;
 * 
 * 4. Ar_distcode obj = new Ar_distcode(<primary_key>); 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode("1");
 *    It Means : Select * from ar_distcode where <primary_key> = "1";
 * 
 * 5. Ar_distcode obj = new Ar_distcode(Ar_distcode.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode(Ar_distcode.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_distcode where id = "1";
 * 
 * 6. Ar_distcode obj = new Ar_distcode();
 *    obj.loadString(Ar_distcode.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode();
 *    obj.loadString(Ar_distcode.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_distcode where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_distcode Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_distcode : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_distcode obj = new Ar_distcode(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_distcode where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.gl.Gl_account;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ar_distcode extends Ar_distcodeAbst{
    public Ar_distcode() throws CodeException {
       
    }
    
    public Ar_distcode(long id) throws CodeException {
        super(id);
    }
    
    public Ar_distcode(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_distcode(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_distcode(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        super.saveNew();
    }

    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }


    public String getAccRevDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccrevcode());
        return glacc.getaccdesc();
    }

    public String getAccInvDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccinvcode());
        return glacc.getaccdesc();
    }

    public String getAccCostDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getacccogscode());
        return glacc.getaccdesc();
    }


    public void setaccrevcode(String param) throws CodeException {
        super.setaccrevcode(param.replace("-", ""));
    }

    public String getaccrevcodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getaccrevcode());
    }

    public void setaccinvcode(String param) throws CodeException {
        super.setaccinvcode(param.replace("-", ""));
    }

    public String getaccinvcodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getaccinvcode());
    }

    public void setacccogscode(String param) throws CodeException {
        super.setacccogscode(param.replace("-", ""));
    }

    public String getacccogscodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getacccogscode());
    }


}






