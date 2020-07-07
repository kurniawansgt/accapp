/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_optionalAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_optional obj = new Ar_optional();
 * 
 * 2. Ar_optional obj = new Ar_optional(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_optional obj = new Ar_optional(1);
 * 
 *    It Means : Select * from ar_optional where id = 1;
 * 
 * 3. Ar_optional obj = new Ar_optional(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_optional obj = new Ar_optional(1);
 * 
 *    It Means : Select * from ar_optional where id = 1;
 * 
 * 4. Ar_optional obj = new Ar_optional(<primary_key>); 
 *    Sample :
 *    Ar_optional obj = new Ar_optional("1");
 *    It Means : Select * from ar_optional where <primary_key> = "1";
 * 
 * 5. Ar_optional obj = new Ar_optional(Ar_optional.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_optional obj = new Ar_optional(Ar_optional.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_optional where id = "1";
 * 
 * 6. Ar_optional obj = new Ar_optional();
 *    obj.loadString(Ar_optional.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_optional obj = new Ar_optional();
 *    obj.loadString(Ar_optional.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_optional where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_optional Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_optional : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_optional obj = new Ar_optional(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_optional obj = new Ar_optional(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_optional where id = 1;
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
public class Ar_optional extends Ar_optionalAbst{
    public Ar_optional() throws CodeException {
       
    }
    
    public Ar_optional(long id) throws CodeException {
        super(id);
    }
    
    public Ar_optional(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_optional(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_optional(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




