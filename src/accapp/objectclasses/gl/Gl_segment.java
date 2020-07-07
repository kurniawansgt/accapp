/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_segmentAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_segment obj = new Gl_segment();
 * 
 * 2. Gl_segment obj = new Gl_segment(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_segment obj = new Gl_segment(1);
 * 
 *    It Means : Select * from gl_segment where id = 1;
 * 
 * 3. Gl_segment obj = new Gl_segment(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_segment obj = new Gl_segment(1);
 * 
 *    It Means : Select * from gl_segment where id = 1;
 * 
 * 4. Gl_segment obj = new Gl_segment(<primary_key>); 
 *    Sample :
 *    Gl_segment obj = new Gl_segment("1");
 *    It Means : Select * from gl_segment where <primary_key> = "1";
 * 
 * 5. Gl_segment obj = new Gl_segment(Gl_segment.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_segment obj = new Gl_segment(Gl_segment.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_segment where id = "1";
 * 
 * 6. Gl_segment obj = new Gl_segment();
 *    obj.loadString(Gl_segment.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_segment obj = new Gl_segment();
 *    obj.loadString(Gl_segment.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_segment where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_segment Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_segment : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_segment obj = new Gl_segment(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_segment obj = new Gl_segment(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_segment where id = 1;
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
public class Gl_segment extends Gl_segmentAbst{
    public Gl_segment() throws CodeException {
       
    }
    
    public Gl_segment(long id) throws CodeException {
        super(id);
    }
    
    public Gl_segment(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_segment(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_segment(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




