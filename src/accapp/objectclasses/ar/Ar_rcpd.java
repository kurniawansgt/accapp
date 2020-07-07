/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcpdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcpd obj = new Ar_rcpd();
 * 
 * 2. Ar_rcpd obj = new Ar_rcpd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd(1);
 * 
 *    It Means : Select * from ar_rcpd where id = 1;
 * 
 * 3. Ar_rcpd obj = new Ar_rcpd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd(1);
 * 
 *    It Means : Select * from ar_rcpd where id = 1;
 * 
 * 4. Ar_rcpd obj = new Ar_rcpd(<primary_key>); 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd("1");
 *    It Means : Select * from ar_rcpd where <primary_key> = "1";
 * 
 * 5. Ar_rcpd obj = new Ar_rcpd(Ar_rcpd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd(Ar_rcpd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcpd where id = "1";
 * 
 * 6. Ar_rcpd obj = new Ar_rcpd();
 *    obj.loadString(Ar_rcpd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd();
 *    obj.loadString(Ar_rcpd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcpd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcpd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcpd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcpd obj = new Ar_rcpd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcpd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_rcpd extends Ar_rcpdAbst{
    private String applied="No";

    public Ar_rcpd() throws CodeException {
       
    }
    
    public Ar_rcpd(long id) throws CodeException {
        super(id);
    }
    
    public Ar_rcpd(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_rcpd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_rcpd(ResultSet rs) throws CodeException {
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
            this.setentrydate(GlobalUtils.getAuditDate());
        }
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }



    public int getMaxTransnbr(int batchno,int docentry) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ar_rcpd where batchno=" + batchno+" and docentry="+docentry;

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

    /**
     * @return the applied
     */
    public String getApplied() {
        return applied;
    }

    /**
     * @param applied the applied to set
     */
    public void setApplied(String applied) {
        this.applied = applied;
    }
    
}




