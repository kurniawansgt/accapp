/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_customerstsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_customersts obj = new Ar_customersts();
 * 
 * 2. Ar_customersts obj = new Ar_customersts(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts(1);
 * 
 *    It Means : Select * from ar_customersts where id = 1;
 * 
 * 3. Ar_customersts obj = new Ar_customersts(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts(1);
 * 
 *    It Means : Select * from ar_customersts where id = 1;
 * 
 * 4. Ar_customersts obj = new Ar_customersts(<primary_key>); 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts("1");
 *    It Means : Select * from ar_customersts where <primary_key> = "1";
 * 
 * 5. Ar_customersts obj = new Ar_customersts(Ar_customersts.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts(Ar_customersts.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_customersts where id = "1";
 * 
 * 6. Ar_customersts obj = new Ar_customersts();
 *    obj.loadString(Ar_customersts.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts();
 *    obj.loadString(Ar_customersts.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_customersts where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_customersts Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_customersts : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_customersts obj = new Ar_customersts(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_customersts where id = 1;
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
public class Ar_customersts extends Ar_customerstsAbst{
    public Ar_customersts() throws CodeException {
       
    }
    
    public Ar_customersts(long id) throws CodeException {
        super(id);
    }
    
    public Ar_customersts(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_customersts(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_customersts(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void searchData(String yop, String mop, String custmrcode) throws CodeException {
        try {

            String query = " select * from ar_customersts where yop = '" + yop + "' and mop = '" + mop + "' and custmrcode ='" + custmrcode + "'";

            DbBean db = DbBean.connect();
            ResultSet rs = db.executeQuery(query);

            if (rs.next()) {
                loadRs(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Error Ar_customersts : " + ex.getMessage());
       }
    }
}




