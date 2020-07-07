/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_distdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_distd obj = new Cb_distd();
 * 
 * 2. Cb_distd obj = new Cb_distd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_distd obj = new Cb_distd(1);
 * 
 *    It Means : Select * from cb_distd where id = 1;
 * 
 * 3. Cb_distd obj = new Cb_distd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_distd obj = new Cb_distd(1);
 * 
 *    It Means : Select * from cb_distd where id = 1;
 * 
 * 4. Cb_distd obj = new Cb_distd(<primary_key>); 
 *    Sample :
 *    Cb_distd obj = new Cb_distd("1");
 *    It Means : Select * from cb_distd where <primary_key> = "1";
 * 
 * 5. Cb_distd obj = new Cb_distd(Cb_distd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_distd obj = new Cb_distd(Cb_distd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_distd where id = "1";
 * 
 * 6. Cb_distd obj = new Cb_distd();
 *    obj.loadString(Cb_distd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_distd obj = new Cb_distd();
 *    obj.loadString(Cb_distd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_distd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_distd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_distd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_distd obj = new Cb_distd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_distd obj = new Cb_distd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_distd where id = 1;
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
public class Cb_distd extends Cb_distdAbst{
    public Cb_distd() throws CodeException {
       
    }
    
    public Cb_distd(long id) throws CodeException {
        super(id);
    }
    
    public Cb_distd(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_distd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_distd(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




