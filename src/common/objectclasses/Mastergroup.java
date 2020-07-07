/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MastergroupAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Mastergroup obj = new Mastergroup();
 * 
 * 2. Mastergroup obj = new Mastergroup(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Mastergroup obj = new Mastergroup(1);
 * 
 *    It Means : Select * from mastergroup where id = 1;
 * 
 * 3. Mastergroup obj = new Mastergroup(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Mastergroup obj = new Mastergroup(1);
 * 
 *    It Means : Select * from mastergroup where id = 1;
 * 
 * 4. Mastergroup obj = new Mastergroup(<primary_key>); 
 *    Sample :
 *    Mastergroup obj = new Mastergroup("1");
 *    It Means : Select * from mastergroup where <primary_key> = "1";
 * 
 * 5. Mastergroup obj = new Mastergroup(Mastergroup.PROPERTY_<field>, <value>);
 *    Sample :
 *    Mastergroup obj = new Mastergroup(Mastergroup.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from mastergroup where id = "1";
 * 
 * 6. Mastergroup obj = new Mastergroup();
 *    obj.loadString(Mastergroup.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Mastergroup obj = new Mastergroup();
 *    obj.loadString(Mastergroup.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from mastergroup where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM mastergroup Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Mastergroup obj = new Mastergroup(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Mastergroup obj = new Mastergroup(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from mastergroup where id = 1;
 * 
 * 
 */


package common.objectclasses;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Mastergroup extends MastergroupAbst{
    public Mastergroup() throws CodeException {
       
    }
    
    public Mastergroup(long id) throws CodeException {
        super(id);
    }
    
    public Mastergroup(String val)  throws CodeException {
        super(val);
    }
    
    public Mastergroup(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Mastergroup(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




