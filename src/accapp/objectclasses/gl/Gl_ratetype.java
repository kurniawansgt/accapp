/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_ratetypeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_ratetype obj = new Gl_ratetype();
 * 
 * 2. Gl_ratetype obj = new Gl_ratetype(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype(1);
 * 
 *    It Means : Select * from gl_ratetype where id = 1;
 * 
 * 3. Gl_ratetype obj = new Gl_ratetype(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype(1);
 * 
 *    It Means : Select * from gl_ratetype where id = 1;
 * 
 * 4. Gl_ratetype obj = new Gl_ratetype(<primary_key>); 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype("1");
 *    It Means : Select * from gl_ratetype where <primary_key> = "1";
 * 
 * 5. Gl_ratetype obj = new Gl_ratetype(Gl_ratetype.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype(Gl_ratetype.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_ratetype where id = "1";
 * 
 * 6. Gl_ratetype obj = new Gl_ratetype();
 *    obj.loadString(Gl_ratetype.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype();
 *    obj.loadString(Gl_ratetype.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_ratetype where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_ratetype Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_ratetype : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_ratetype obj = new Gl_ratetype(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_ratetype where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Gl_ratetype extends Gl_ratetypeAbst{
    public Gl_ratetype() throws CodeException {
       
    }
    
    public Gl_ratetype(long id) throws CodeException {
        super(id);
    }
    
    public Gl_ratetype(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_ratetype(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_ratetype(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




