/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_optiionaldetail1Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1();
 * 
 * 2. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(1);
 * 
 *    It Means : Select * from ar_optiionaldetail1 where id = 1;
 * 
 * 3. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(1);
 * 
 *    It Means : Select * from ar_optiionaldetail1 where id = 1;
 * 
 * 4. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(<primary_key>); 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1("1");
 *    It Means : Select * from ar_optiionaldetail1 where <primary_key> = "1";
 * 
 * 5. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(Ar_optiionaldetail1.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(Ar_optiionaldetail1.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_optiionaldetail1 where id = "1";
 * 
 * 6. Ar_optiionaldetail1 obj = new Ar_optiionaldetail1();
 *    obj.loadString(Ar_optiionaldetail1.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1();
 *    obj.loadString(Ar_optiionaldetail1.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_optiionaldetail1 where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_optiionaldetail1 Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_optiionaldetail1 : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_optiionaldetail1 obj = new Ar_optiionaldetail1(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_optiionaldetail1 where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Ar_optiionaldetail1 extends Ar_optiionaldetail1Abst{
    public Ar_optiionaldetail1() throws CodeException {
       
    }
    
    public Ar_optiionaldetail1(long id) throws CodeException {
        super(id);
    }
    
    public Ar_optiionaldetail1(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_optiionaldetail1(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_optiionaldetail1(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




