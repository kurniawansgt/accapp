/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcphpAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcphp obj = new Ar_rcphp();
 * 
 * 2. Ar_rcphp obj = new Ar_rcphp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp(1);
 * 
 *    It Means : Select * from ar_rcphp where id = 1;
 * 
 * 3. Ar_rcphp obj = new Ar_rcphp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp(1);
 * 
 *    It Means : Select * from ar_rcphp where id = 1;
 * 
 * 4. Ar_rcphp obj = new Ar_rcphp(<primary_key>); 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp("1");
 *    It Means : Select * from ar_rcphp where <primary_key> = "1";
 * 
 * 5. Ar_rcphp obj = new Ar_rcphp(Ar_rcphp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp(Ar_rcphp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcphp where id = "1";
 * 
 * 6. Ar_rcphp obj = new Ar_rcphp();
 *    obj.loadString(Ar_rcphp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp();
 *    obj.loadString(Ar_rcphp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcphp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcphp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcphp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcphp obj = new Ar_rcphp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcphp where id = 1;
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
public class Ar_rcphp extends Ar_rcphpAbst{
    public Ar_rcphp() throws CodeException {
       
    }
    
    public Ar_rcphp(long id) throws CodeException {
        super(id);
    }
    
    public Ar_rcphp(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_rcphp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_rcphp(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




