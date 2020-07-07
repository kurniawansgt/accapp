/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_adjdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_adjd obj = new Ap_adjd();
 * 
 * 2. Ap_adjd obj = new Ap_adjd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd(1);
 * 
 *    It Means : Select * from ap_adjd where id = 1;
 * 
 * 3. Ap_adjd obj = new Ap_adjd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd(1);
 * 
 *    It Means : Select * from ap_adjd where id = 1;
 * 
 * 4. Ap_adjd obj = new Ap_adjd(<primary_key>); 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd("1");
 *    It Means : Select * from ap_adjd where <primary_key> = "1";
 * 
 * 5. Ap_adjd obj = new Ap_adjd(Ap_adjd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd(Ap_adjd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_adjd where id = "1";
 * 
 * 6. Ap_adjd obj = new Ap_adjd();
 *    obj.loadString(Ap_adjd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd();
 *    obj.loadString(Ap_adjd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_adjd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_adjd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_adjd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_adjd obj = new Ap_adjd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_adjd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap.adjustment;

import accapp.objectclasses.gl.Gl_account;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_adjd extends Ap_adjdAbst{
    public Ap_adjd() throws CodeException {
       
    }
    
    public Ap_adjd(long id) throws CodeException {
        super(id);
    }
    
    public Ap_adjd(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_adjd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_adjd(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void save() throws CodeException {
        this.setacccode(this.getaccfmttd().replace("-", ""));
        super.save();
    }



    public int getMaxTransnbr(int btchentry,int journalid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ap_adjd where batchno=" + btchentry+" and docentry="+journalid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("gl_adjd : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public String getaccglcode() throws CodeException {
        return Gl_account.getAccFormat(this.getaccfmttd());
    }
    public String getaccgldscription() throws CodeException {
        Gl_account glacc = new Gl_account(this.getaccfmttd().replace("-", ""));
        return glacc.getaccdesc();
    }

    
}




