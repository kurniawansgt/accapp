/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_optionAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_option obj = new Gl_option();
 * 
 * 2. Gl_option obj = new Gl_option(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_option obj = new Gl_option(1);
 * 
 *    It Means : Select * from gl_option where id = 1;
 * 
 * 3. Gl_option obj = new Gl_option(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_option obj = new Gl_option(1);
 * 
 *    It Means : Select * from gl_option where id = 1;
 * 
 * 4. Gl_option obj = new Gl_option(<primary_key>); 
 *    Sample :
 *    Gl_option obj = new Gl_option("1");
 *    It Means : Select * from gl_option where <primary_key> = "1";
 * 
 * 5. Gl_option obj = new Gl_option(Gl_option.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_option obj = new Gl_option(Gl_option.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_option where id = "1";
 * 
 * 6. Gl_option obj = new Gl_option();
 *    obj.loadString(Gl_option.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_option obj = new Gl_option();
 *    obj.loadString(Gl_option.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_option where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_option Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_option : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_option obj = new Gl_option(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_option obj = new Gl_option(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_option where id = 1;
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
public class Gl_option extends Gl_optionAbst{
    public Gl_option() throws CodeException {
       
    }
    
    public Gl_option(long id) throws CodeException {
        super(id);
    }
    
    public Gl_option(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_option(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_option(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




