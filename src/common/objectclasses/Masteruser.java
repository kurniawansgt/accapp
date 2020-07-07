/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MasteruserAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Masteruser obj = new Masteruser();
 * 
 * 2. Masteruser obj = new Masteruser(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Masteruser obj = new Masteruser(1);
 * 
 *    It Means : Select * from masteruser where id = 1;
 * 
 * 3. Masteruser obj = new Masteruser(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Masteruser obj = new Masteruser(1);
 * 
 *    It Means : Select * from masteruser where id = 1;
 * 
 * 4. Masteruser obj = new Masteruser(<primary_key>); 
 *    Sample :
 *    Masteruser obj = new Masteruser("1");
 *    It Means : Select * from masteruser where <primary_key> = "1";
 * 
 * 5. Masteruser obj = new Masteruser(Masteruser.PROPERTY_<field>, <value>);
 *    Sample :
 *    Masteruser obj = new Masteruser(Masteruser.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from masteruser where id = "1";
 * 
 * 6. Masteruser obj = new Masteruser();
 *    obj.loadString(Masteruser.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Masteruser obj = new Masteruser();
 *    obj.loadString(Masteruser.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from masteruser where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM masteruser Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("masteruser : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Masteruser obj = new Masteruser(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Masteruser obj = new Masteruser(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from masteruser where id = 1;
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
public class Masteruser extends MasteruserAbst{
    public Masteruser() throws CodeException {
       
    }
    
    public Masteruser(long id) throws CodeException {
        super(id);
    }
    
    public Masteruser(String val)  throws CodeException {
        super(val);
    }
    
    public Masteruser(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Masteruser(ResultSet rs) throws CodeException {
        super(rs);
    }
    
    public void delete() throws CodeException {
        Masteruserdetails msd = new Masteruserdetails(Masteruserdetail.PROPERTY_USER, getUser() );
        msd.delete();
        
        super.delete();
    }
}




