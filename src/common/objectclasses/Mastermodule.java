/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MastermoduleAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Mastermodule obj = new Mastermodule();
 * 
 * 2. Mastermodule obj = new Mastermodule(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Mastermodule obj = new Mastermodule(1);
 * 
 *    It Means : Select * from mastermodule where id = 1;
 * 
 * 3. Mastermodule obj = new Mastermodule(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Mastermodule obj = new Mastermodule(1);
 * 
 *    It Means : Select * from mastermodule where id = 1;
 * 
 * 4. Mastermodule obj = new Mastermodule(<primary_key>); 
 *    Sample :
 *    Mastermodule obj = new Mastermodule("1");
 *    It Means : Select * from mastermodule where <primary_key> = "1";
 * 
 * 5. Mastermodule obj = new Mastermodule(Mastermodule.PROPERTY_<field>, <value>);
 *    Sample :
 *    Mastermodule obj = new Mastermodule(Mastermodule.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from mastermodule where id = "1";
 * 
 * 6. Mastermodule obj = new Mastermodule();
 *    obj.loadString(Mastermodule.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Mastermodule obj = new Mastermodule();
 *    obj.loadString(Mastermodule.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from mastermodule where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM mastermodule Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("mastermodule : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Mastermodule obj = new Mastermodule(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Mastermodule obj = new Mastermodule(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from mastermodule where id = 1;
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
public class Mastermodule extends MastermoduleAbst{
    public Mastermodule() throws CodeException {
       
    }
    
    public Mastermodule(long id) throws CodeException {
        super(id);
    }
    
    public Mastermodule(String val)  throws CodeException {
        super(val);
    }
    
    public Mastermodule(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Mastermodule(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




