/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_custnatstsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_custnatsts obj = new Ar_custnatsts();
 * 
 * 2. Ar_custnatsts obj = new Ar_custnatsts(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts(1);
 * 
 *    It Means : Select * from ar_custnatsts where id = 1;
 * 
 * 3. Ar_custnatsts obj = new Ar_custnatsts(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts(1);
 * 
 *    It Means : Select * from ar_custnatsts where id = 1;
 * 
 * 4. Ar_custnatsts obj = new Ar_custnatsts(<primary_key>); 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts("1");
 *    It Means : Select * from ar_custnatsts where <primary_key> = "1";
 * 
 * 5. Ar_custnatsts obj = new Ar_custnatsts(Ar_custnatsts.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts(Ar_custnatsts.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_custnatsts where id = "1";
 * 
 * 6. Ar_custnatsts obj = new Ar_custnatsts();
 *    obj.loadString(Ar_custnatsts.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts();
 *    obj.loadString(Ar_custnatsts.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_custnatsts where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_custnatsts Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_custnatsts : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_custnatsts obj = new Ar_custnatsts(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_custnatsts where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_custnatsts extends Ar_custnatstsAbst{
    public Ar_custnatsts() throws CodeException {
       
    }
    
    public Ar_custnatsts(long id) throws CodeException {
        super(id);
    }
    
    public Ar_custnatsts(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_custnatsts(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_custnatsts(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void searchData(String natcode,Integer yop,Integer mop) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = " select * from ar_custnatsts where natcode = '" + natcode + "'  and yop = " + yop +" and mop="+mop;

        try {
            rs = db.executeQuery(query);

            if (rs.next()){
                loadRs(rs);
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }
    }
}




