/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_invdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_invd obj = new Ap_invd();
 * 
 * 2. Ap_invd obj = new Ap_invd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_invd obj = new Ap_invd(1);
 * 
 *    It Means : Select * from ap_invd where id = 1;
 * 
 * 3. Ap_invd obj = new Ap_invd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_invd obj = new Ap_invd(1);
 * 
 *    It Means : Select * from ap_invd where id = 1;
 * 
 * 4. Ap_invd obj = new Ap_invd(<primary_key>); 
 *    Sample :
 *    Ap_invd obj = new Ap_invd("1");
 *    It Means : Select * from ap_invd where <primary_key> = "1";
 * 
 * 5. Ap_invd obj = new Ap_invd(Ap_invd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_invd obj = new Ap_invd(Ap_invd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_invd where id = "1";
 * 
 * 6. Ap_invd obj = new Ap_invd();
 *    obj.loadString(Ap_invd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_invd obj = new Ap_invd();
 *    obj.loadString(Ap_invd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_invd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_invd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_invd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_invd obj = new Ap_invd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_invd obj = new Ap_invd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_invd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import accapp.objectclasses.gl.Gl_account;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_invd extends Ap_invdAbst{
    public Ap_invd() throws CodeException {
       
    }
    
    public Ap_invd(long id) throws CodeException {
        super(id);
    }
    
    public Ap_invd(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_invd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_invd(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        if (value==null){
            value="";
        }

        super.fromString(param, value);
    }


    @Override
    public void save() throws CodeException {
        if (getID()==NULLID||getID()==0) {
            this.setentrydate(TABLE);
        }
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }



    public int getMaxTransnbr(int btchentry,int journalid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ap_invd where batchno=" + btchentry+" and docentry="+journalid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("gl_jeh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void setaccglcode(String param) throws CodeException {
        super.setaccglcode(param.replace("-", ""));
    }
    public String getaccglcodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getaccglcode());
    }
    public String getaccgldscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccglcode());
        return glacc.getaccdesc();
    }


    public void setacctaxcode(String param) throws CodeException {
        super.setacctaxcode(param.replace("-", ""));
    }
    public String getacctaxcodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getacctaxcode());
    }
    public String getacctaxdscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getacctaxcode());
        return glacc.getaccdesc();
    }

    public void setacccogscode(String param) throws CodeException {
        super.setacccogscode(param.replace("-", ""));
    }
    public String getacccogscodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getacccogscode());
    }
    public String getacccogscodedscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getacccogscode());
        return glacc.getaccdesc();
    }


}




