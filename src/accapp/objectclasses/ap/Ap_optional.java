/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_optionalAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_optional obj = new Ap_optional();
 * 
 * 2. Ap_optional obj = new Ap_optional(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_optional obj = new Ap_optional(1);
 * 
 *    It Means : Select * from ap_optional where id = 1;
 * 
 * 3. Ap_optional obj = new Ap_optional(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_optional obj = new Ap_optional(1);
 * 
 *    It Means : Select * from ap_optional where id = 1;
 * 
 * 4. Ap_optional obj = new Ap_optional(<primary_key>); 
 *    Sample :
 *    Ap_optional obj = new Ap_optional("1");
 *    It Means : Select * from ap_optional where <primary_key> = "1";
 * 
 * 5. Ap_optional obj = new Ap_optional(Ap_optional.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_optional obj = new Ap_optional(Ap_optional.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_optional where id = "1";
 * 
 * 6. Ap_optional obj = new Ap_optional();
 *    obj.loadString(Ap_optional.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_optional obj = new Ap_optional();
 *    obj.loadString(Ap_optional.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_optional where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_optional Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_optional : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_optional obj = new Ap_optional(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_optional obj = new Ap_optional(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_optional where id = 1;
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
public class Ap_optional extends Ap_optionalAbst{
    public Ap_optional() throws CodeException {
       
    }
    
    public Ap_optional(long id) throws CodeException {
        super(id);
    }
    
    public Ap_optional(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_optional(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_optional(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




