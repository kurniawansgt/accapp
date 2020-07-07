/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_sourcelgr_descAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc();
 * 
 * 2. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(1);
 * 
 *    It Means : Select * from gl_sourcelgr_desc where id = 1;
 * 
 * 3. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(1);
 * 
 *    It Means : Select * from gl_sourcelgr_desc where id = 1;
 * 
 * 4. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(<primary_key>); 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc("1");
 *    It Means : Select * from gl_sourcelgr_desc where <primary_key> = "1";
 * 
 * 5. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(Gl_sourcelgr_desc.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(Gl_sourcelgr_desc.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_sourcelgr_desc where id = "1";
 * 
 * 6. Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc();
 *    obj.loadString(Gl_sourcelgr_desc.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc();
 *    obj.loadString(Gl_sourcelgr_desc.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_sourcelgr_desc where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_sourcelgr_desc Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_sourcelgr_desc : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_sourcelgr_desc obj = new Gl_sourcelgr_desc(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_sourcelgr_desc where id = 1;
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
public class Gl_sourcelgr_desc extends Gl_sourcelgr_descAbst{
    public Gl_sourcelgr_desc() throws CodeException {
       
    }
    
    public Gl_sourcelgr_desc(long id) throws CodeException {
        super(id);
    }
    
    public Gl_sourcelgr_desc(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_sourcelgr_desc(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_sourcelgr_desc(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




