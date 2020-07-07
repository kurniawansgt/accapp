/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_groupAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_group obj = new Gl_group();
 * 
 * 2. Gl_group obj = new Gl_group(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_group obj = new Gl_group(1);
 * 
 *    It Means : Select * from gl_group where id = 1;
 * 
 * 3. Gl_group obj = new Gl_group(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_group obj = new Gl_group(1);
 * 
 *    It Means : Select * from gl_group where id = 1;
 * 
 * 4. Gl_group obj = new Gl_group(<primary_key>); 
 *    Sample :
 *    Gl_group obj = new Gl_group("1");
 *    It Means : Select * from gl_group where <primary_key> = "1";
 * 
 * 5. Gl_group obj = new Gl_group(Gl_group.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_group obj = new Gl_group(Gl_group.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_group where id = "1";
 * 
 * 6. Gl_group obj = new Gl_group();
 *    obj.loadString(Gl_group.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_group obj = new Gl_group();
 *    obj.loadString(Gl_group.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_group where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_group Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_group : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_group obj = new Gl_group(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_group obj = new Gl_group(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_group where id = 1;
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
public class Gl_group extends Gl_groupAbst{
    public Gl_group() throws CodeException {
       
    }
    
    public Gl_group(long id) throws CodeException {
        super(id);
    }
    
    public Gl_group(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_group(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_group(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




