/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_optiondetail1Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_optiondetail1 obj = new Gl_optiondetail1();
 * 
 * 2. Gl_optiondetail1 obj = new Gl_optiondetail1(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1(1);
 * 
 *    It Means : Select * from gl_optiondetail1 where id = 1;
 * 
 * 3. Gl_optiondetail1 obj = new Gl_optiondetail1(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1(1);
 * 
 *    It Means : Select * from gl_optiondetail1 where id = 1;
 * 
 * 4. Gl_optiondetail1 obj = new Gl_optiondetail1(<primary_key>); 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1("1");
 *    It Means : Select * from gl_optiondetail1 where <primary_key> = "1";
 * 
 * 5. Gl_optiondetail1 obj = new Gl_optiondetail1(Gl_optiondetail1.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1(Gl_optiondetail1.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_optiondetail1 where id = "1";
 * 
 * 6. Gl_optiondetail1 obj = new Gl_optiondetail1();
 *    obj.loadString(Gl_optiondetail1.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1();
 *    obj.loadString(Gl_optiondetail1.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_optiondetail1 where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_optiondetail1 Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_optiondetail1 : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_optiondetail1 obj = new Gl_optiondetail1(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_optiondetail1 where id = 1;
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
public class Gl_optiondetail1 extends Gl_optiondetail1Abst{
    public Gl_optiondetail1() throws CodeException {
       
    }
    
    public Gl_optiondetail1(long id) throws CodeException {
        super(id);
    }
    
    public Gl_optiondetail1(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_optiondetail1(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_optiondetail1(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




