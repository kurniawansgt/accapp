/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Costacc_purchasevariance_tempAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp();
 * 
 * 2. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(1);
 * 
 *    It Means : Select * from costacc_purchasevariance_temp where id = 1;
 * 
 * 3. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(1);
 * 
 *    It Means : Select * from costacc_purchasevariance_temp where id = 1;
 * 
 * 4. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(<primary_key>); 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp("1");
 *    It Means : Select * from costacc_purchasevariance_temp where <primary_key> = "1";
 * 
 * 5. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(Costacc_purchasevariance_temp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(Costacc_purchasevariance_temp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from costacc_purchasevariance_temp where id = "1";
 * 
 * 6. Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp();
 *    obj.loadString(Costacc_purchasevariance_temp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp();
 *    obj.loadString(Costacc_purchasevariance_temp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from costacc_purchasevariance_temp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM costacc_purchasevariance_temp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("costacc_purchasevariance_temp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Costacc_purchasevariance_temp obj = new Costacc_purchasevariance_temp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from costacc_purchasevariance_temp where id = 1;
 * 
 * 
 */


package accapp.objectclasses.costapp;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Costacc_purchasevariance_temp extends Costacc_purchasevariance_tempAbst{
    public Costacc_purchasevariance_temp() throws CodeException {
       
    }
    
    public Costacc_purchasevariance_temp(long id) throws CodeException {
        super(id);
    }
    
    public Costacc_purchasevariance_temp(String val)  throws CodeException {
        super(val);
    }
    
    public Costacc_purchasevariance_temp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Costacc_purchasevariance_temp(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




