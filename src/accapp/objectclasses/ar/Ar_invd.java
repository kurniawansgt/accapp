/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_invdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_invd obj = new Ar_invd();
 * 
 * 2. Ar_invd obj = new Ar_invd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_invd obj = new Ar_invd(1);
 * 
 *    It Means : Select * from ar_invd where id = 1;
 * 
 * 3. Ar_invd obj = new Ar_invd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_invd obj = new Ar_invd(1);
 * 
 *    It Means : Select * from ar_invd where id = 1;
 * 
 * 4. Ar_invd obj = new Ar_invd(<primary_key>); 
 *    Sample :
 *    Ar_invd obj = new Ar_invd("1");
 *    It Means : Select * from ar_invd where <primary_key> = "1";
 * 
 * 5. Ar_invd obj = new Ar_invd(Ar_invd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_invd obj = new Ar_invd(Ar_invd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_invd where id = "1";
 * 
 * 6. Ar_invd obj = new Ar_invd();
 *    obj.loadString(Ar_invd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_invd obj = new Ar_invd();
 *    obj.loadString(Ar_invd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_invd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_invd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_invd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_invd obj = new Ar_invd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_invd obj = new Ar_invd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_invd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

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
public class Ar_invd extends Ar_invdAbst{
    public Ar_invd() throws CodeException {
       
    }
    
    public Ar_invd(long id) throws CodeException {
        super(id);
    }
    
    public Ar_invd(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_invd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_invd(ResultSet rs) throws CodeException {
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
                            + "\n from ar_invd where batchno=" + btchentry+" and docentry="+journalid;

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

    public void setaccrevcode(String param) throws CodeException {
        super.setaccrevcode(param.replace("-", ""));
    }
    public String getaccrevcodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getaccrevcode());
    }
    public String getaccrevcodedscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccrevcode());
        return glacc.getaccdesc();
    }

    public void setaccinvcode(String param) throws CodeException {
        super.setaccinvcode(param.replace("-", ""));
    }
    public String getaccinvcodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getaccinvcode());
    }
    public String getaccinvdscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccinvcode());
        return glacc.getaccdesc();
    }

    public void setacccogscode(String param) throws CodeException {
        super.setacccogscode(param.replace("-", ""));
    }
    public String getacccogscodegmt() throws CodeException {
        return Gl_account.getAccFormat(this.getacccogscode());
    }
    public String getacccogsdscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getacccogsdscription());
        return glacc.getaccdesc();
    }

}




