/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_paydmiscAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_paydmisc obj = new Ap_paydmisc();
 * 
 * 2. Ap_paydmisc obj = new Ap_paydmisc(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc(1);
 * 
 *    It Means : Select * from ap_paydmisc where id = 1;
 * 
 * 3. Ap_paydmisc obj = new Ap_paydmisc(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc(1);
 * 
 *    It Means : Select * from ap_paydmisc where id = 1;
 * 
 * 4. Ap_paydmisc obj = new Ap_paydmisc(<primary_key>); 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc("1");
 *    It Means : Select * from ap_paydmisc where <primary_key> = "1";
 * 
 * 5. Ap_paydmisc obj = new Ap_paydmisc(Ap_paydmisc.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc(Ap_paydmisc.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_paydmisc where id = "1";
 * 
 * 6. Ap_paydmisc obj = new Ap_paydmisc();
 *    obj.loadString(Ap_paydmisc.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc();
 *    obj.loadString(Ap_paydmisc.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_paydmisc where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_paydmisc Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_paydmisc : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_paydmisc obj = new Ap_paydmisc(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_paydmisc where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_paydmisc extends Ap_paydmiscAbst{
    public Ap_paydmisc() throws CodeException {
       
    }
    
    public Ap_paydmisc(long id) throws CodeException {
        super(id);
    }
    
    public Ap_paydmisc(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_paydmisc(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_paydmisc(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxTransnbr(int batchno,int docentry) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ap_paydmisc where batchno=" + batchno+" and docentry="+docentry;

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

    public void setacccode(String param) throws CodeException {
        super.setacccode(param.replace("-", ""));
    } 
}




