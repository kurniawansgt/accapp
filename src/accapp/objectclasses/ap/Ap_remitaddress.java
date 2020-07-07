/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_remitaddressAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_remitaddress obj = new Ap_remitaddress();
 * 
 * 2. Ap_remitaddress obj = new Ap_remitaddress(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress(1);
 * 
 *    It Means : Select * from ap_remitaddress where id = 1;
 * 
 * 3. Ap_remitaddress obj = new Ap_remitaddress(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress(1);
 * 
 *    It Means : Select * from ap_remitaddress where id = 1;
 * 
 * 4. Ap_remitaddress obj = new Ap_remitaddress(<primary_key>); 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress("1");
 *    It Means : Select * from ap_remitaddress where <primary_key> = "1";
 * 
 * 5. Ap_remitaddress obj = new Ap_remitaddress(Ap_remitaddress.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress(Ap_remitaddress.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_remitaddress where id = "1";
 * 
 * 6. Ap_remitaddress obj = new Ap_remitaddress();
 *    obj.loadString(Ap_remitaddress.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress();
 *    obj.loadString(Ap_remitaddress.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_remitaddress where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_remitaddress Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_remitaddress : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_remitaddress obj = new Ap_remitaddress(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_remitaddress where id = 1;
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
public class Ap_remitaddress extends Ap_remitaddressAbst{
    public Ap_remitaddress() throws CodeException {
       
    }
    
    public Ap_remitaddress(long id) throws CodeException {
        super(id);
    }
    
    public Ap_remitaddress(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_remitaddress(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_remitaddress(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void searchData(long batchno,long docentry) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = " select * from ap_remitaddress where batchno="+batchno+" and docentry="+docentry;
        System.out.println(query);
        try {
            rs = db.executeQuery(query);
            if (rs.next()){
            this.loadRs(rs);
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }


    }
}




