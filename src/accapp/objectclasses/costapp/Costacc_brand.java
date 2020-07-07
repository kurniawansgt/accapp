/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Costacc_brandAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Costacc_brand obj = new Costacc_brand();
 * 
 * 2. Costacc_brand obj = new Costacc_brand(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand(1);
 * 
 *    It Means : Select * from costacc_brand where id = 1;
 * 
 * 3. Costacc_brand obj = new Costacc_brand(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand(1);
 * 
 *    It Means : Select * from costacc_brand where id = 1;
 * 
 * 4. Costacc_brand obj = new Costacc_brand(<primary_key>); 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand("1");
 *    It Means : Select * from costacc_brand where <primary_key> = "1";
 * 
 * 5. Costacc_brand obj = new Costacc_brand(Costacc_brand.PROPERTY_<field>, <value>);
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand(Costacc_brand.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from costacc_brand where id = "1";
 * 
 * 6. Costacc_brand obj = new Costacc_brand();
 *    obj.loadString(Costacc_brand.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand();
 *    obj.loadString(Costacc_brand.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from costacc_brand where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM costacc_brand Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("costacc_brand : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Costacc_brand obj = new Costacc_brand(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from costacc_brand where id = 1;
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
public class Costacc_brand extends Costacc_brandAbst{
    public Costacc_brand() throws CodeException {
       
    }
    
    public Costacc_brand(long id) throws CodeException {
        super(id);
    }
    
    public Costacc_brand(String val)  throws CodeException {
        super(val);
    }
    
    public Costacc_brand(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Costacc_brand(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




