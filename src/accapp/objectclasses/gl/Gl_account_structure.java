/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_account_structureAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_account_structure obj = new Gl_account_structure();
 * 
 * 2. Gl_account_structure obj = new Gl_account_structure(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure(1);
 * 
 *    It Means : Select * from gl_account_structure where id = 1;
 * 
 * 3. Gl_account_structure obj = new Gl_account_structure(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure(1);
 * 
 *    It Means : Select * from gl_account_structure where id = 1;
 * 
 * 4. Gl_account_structure obj = new Gl_account_structure(<primary_key>); 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure("1");
 *    It Means : Select * from gl_account_structure where <primary_key> = "1";
 * 
 * 5. Gl_account_structure obj = new Gl_account_structure(Gl_account_structure.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure(Gl_account_structure.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_account_structure where id = "1";
 * 
 * 6. Gl_account_structure obj = new Gl_account_structure();
 *    obj.loadString(Gl_account_structure.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure();
 *    obj.loadString(Gl_account_structure.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_account_structure where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_account_structure Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_account_structure : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_account_structure obj = new Gl_account_structure(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_account_structure where id = 1;
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
public class Gl_account_structure extends Gl_account_structureAbst{
    public Gl_account_structure() throws CodeException {
       
    }
    
    public Gl_account_structure(long id) throws CodeException {
        super(id);
    }
    
    public Gl_account_structure(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_account_structure(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_account_structure(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




