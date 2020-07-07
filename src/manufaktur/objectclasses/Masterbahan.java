/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MasterbahanAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Masterbahan obj = new Masterbahan();
 * 
 * 2. Masterbahan obj = new Masterbahan(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Masterbahan obj = new Masterbahan(1);
 * 
 *    It Means : Select * from masterbahan where id = 1;
 * 
 * 3. Masterbahan obj = new Masterbahan(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Masterbahan obj = new Masterbahan(1);
 * 
 *    It Means : Select * from masterbahan where id = 1;
 * 
 * 4. Masterbahan obj = new Masterbahan(<primary_key>); 
 *    Sample :
 *    Masterbahan obj = new Masterbahan("1");
 *    It Means : Select * from masterbahan where <primary_key> = "1";
 * 
 * 5. Masterbahan obj = new Masterbahan(Masterbahan.PROPERTY_<field>, <value>);
 *    Sample :
 *    Masterbahan obj = new Masterbahan(Masterbahan.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from masterbahan where id = "1";
 * 
 * 6. Masterbahan obj = new Masterbahan();
 *    obj.loadString(Masterbahan.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Masterbahan obj = new Masterbahan();
 *    obj.loadString(Masterbahan.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from masterbahan where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM masterbahan Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("masterbahan : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Masterbahan obj = new Masterbahan(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Masterbahan obj = new Masterbahan(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from masterbahan where id = 1;
 * 
 * 
 */


package manufaktur.objectclasses;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Masterbahan extends MasterbahanAbst{
    public Masterbahan() throws CodeException {
       
    }
    
    public Masterbahan(long id) throws CodeException {
        super(id);
    }
    
    public Masterbahan(String val)  throws CodeException {
        super(val);
    }
    
    public Masterbahan(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Masterbahan(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




