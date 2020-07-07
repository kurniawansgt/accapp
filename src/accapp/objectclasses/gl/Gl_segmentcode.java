/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_segmentcodeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_segmentcode obj = new Gl_segmentcode();
 * 
 * 2. Gl_segmentcode obj = new Gl_segmentcode(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode(1);
 * 
 *    It Means : Select * from gl_segmentcode where id = 1;
 * 
 * 3. Gl_segmentcode obj = new Gl_segmentcode(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode(1);
 * 
 *    It Means : Select * from gl_segmentcode where id = 1;
 * 
 * 4. Gl_segmentcode obj = new Gl_segmentcode(<primary_key>); 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode("1");
 *    It Means : Select * from gl_segmentcode where <primary_key> = "1";
 * 
 * 5. Gl_segmentcode obj = new Gl_segmentcode(Gl_segmentcode.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode(Gl_segmentcode.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_segmentcode where id = "1";
 * 
 * 6. Gl_segmentcode obj = new Gl_segmentcode();
 *    obj.loadString(Gl_segmentcode.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode();
 *    obj.loadString(Gl_segmentcode.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_segmentcode where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_segmentcode Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_segmentcode : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_segmentcode obj = new Gl_segmentcode(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_segmentcode where id = 1;
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
public class Gl_segmentcode extends Gl_segmentcodeAbst{
    public Gl_segmentcode() throws CodeException {
       
    }
    
    public Gl_segmentcode(long id) throws CodeException {
        super(id);
    }
    
    public Gl_segmentcode(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_segmentcode(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_segmentcode(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




