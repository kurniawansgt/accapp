/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_optionaldetail1Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_optionaldetail1 obj = new Ap_optionaldetail1();
 * 
 * 2. Ap_optionaldetail1 obj = new Ap_optionaldetail1(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1(1);
 * 
 *    It Means : Select * from ap_optionaldetail1 where id = 1;
 * 
 * 3. Ap_optionaldetail1 obj = new Ap_optionaldetail1(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1(1);
 * 
 *    It Means : Select * from ap_optionaldetail1 where id = 1;
 * 
 * 4. Ap_optionaldetail1 obj = new Ap_optionaldetail1(<primary_key>); 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1("1");
 *    It Means : Select * from ap_optionaldetail1 where <primary_key> = "1";
 * 
 * 5. Ap_optionaldetail1 obj = new Ap_optionaldetail1(Ap_optionaldetail1.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1(Ap_optionaldetail1.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_optionaldetail1 where id = "1";
 * 
 * 6. Ap_optionaldetail1 obj = new Ap_optionaldetail1();
 *    obj.loadString(Ap_optionaldetail1.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1();
 *    obj.loadString(Ap_optionaldetail1.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_optionaldetail1 where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_optionaldetail1 Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_optionaldetail1 : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_optionaldetail1 obj = new Ap_optionaldetail1(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_optionaldetail1 where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Ap_optionaldetail1 extends Ap_optionaldetail1Abst{
    public Ap_optionaldetail1() throws CodeException {
       
    }
    
    public Ap_optionaldetail1(long id) throws CodeException {
        super(id);
    }
    
    public Ap_optionaldetail1(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_optionaldetail1(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_optionaldetail1(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




