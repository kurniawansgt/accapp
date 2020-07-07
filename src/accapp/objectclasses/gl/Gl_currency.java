/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_currencyAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_currency obj = new Gl_currency();
 * 
 * 2. Gl_currency obj = new Gl_currency(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_currency obj = new Gl_currency(1);
 * 
 *    It Means : Select * from gl_currency where id = 1;
 * 
 * 3. Gl_currency obj = new Gl_currency(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_currency obj = new Gl_currency(1);
 * 
 *    It Means : Select * from gl_currency where id = 1;
 * 
 * 4. Gl_currency obj = new Gl_currency(<primary_key>); 
 *    Sample :
 *    Gl_currency obj = new Gl_currency("1");
 *    It Means : Select * from gl_currency where <primary_key> = "1";
 * 
 * 5. Gl_currency obj = new Gl_currency(Gl_currency.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_currency obj = new Gl_currency(Gl_currency.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_currency where id = "1";
 * 
 * 6. Gl_currency obj = new Gl_currency();
 *    obj.loadString(Gl_currency.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_currency obj = new Gl_currency();
 *    obj.loadString(Gl_currency.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_currency where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_currency Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_currency : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_currency obj = new Gl_currency(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_currency obj = new Gl_currency(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_currency where id = 1;
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
public class Gl_currency extends Gl_currencyAbst{
    public Gl_currency() throws CodeException {
       
    }
    
    public Gl_currency(long id) throws CodeException {
        super(id);
    }
    
    public Gl_currency(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_currency(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_currency(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




