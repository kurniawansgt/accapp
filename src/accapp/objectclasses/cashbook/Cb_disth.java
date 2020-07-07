/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_disthAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_disth obj = new Cb_disth();
 * 
 * 2. Cb_disth obj = new Cb_disth(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_disth obj = new Cb_disth(1);
 * 
 *    It Means : Select * from cb_disth where id = 1;
 * 
 * 3. Cb_disth obj = new Cb_disth(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_disth obj = new Cb_disth(1);
 * 
 *    It Means : Select * from cb_disth where id = 1;
 * 
 * 4. Cb_disth obj = new Cb_disth(<primary_key>); 
 *    Sample :
 *    Cb_disth obj = new Cb_disth("1");
 *    It Means : Select * from cb_disth where <primary_key> = "1";
 * 
 * 5. Cb_disth obj = new Cb_disth(Cb_disth.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_disth obj = new Cb_disth(Cb_disth.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_disth where id = "1";
 * 
 * 6. Cb_disth obj = new Cb_disth();
 *    obj.loadString(Cb_disth.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_disth obj = new Cb_disth();
 *    obj.loadString(Cb_disth.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_disth where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_disth Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_disth : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_disth obj = new Cb_disth(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_disth obj = new Cb_disth(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_disth where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Cb_disth extends Cb_disthAbst{
    public Cb_disth() throws CodeException {
       
    }
    
    public Cb_disth(long id) throws CodeException {
        super(id);
    }
    
    public Cb_disth(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_disth(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_disth(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




