/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_cash_advanceAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_cash_advance obj = new Cb_cash_advance();
 * 
 * 2. Cb_cash_advance obj = new Cb_cash_advance(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance(1);
 * 
 *    It Means : Select * from cb_cash_advance where id = 1;
 * 
 * 3. Cb_cash_advance obj = new Cb_cash_advance(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance(1);
 * 
 *    It Means : Select * from cb_cash_advance where id = 1;
 * 
 * 4. Cb_cash_advance obj = new Cb_cash_advance(<primary_key>); 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance("1");
 *    It Means : Select * from cb_cash_advance where <primary_key> = "1";
 * 
 * 5. Cb_cash_advance obj = new Cb_cash_advance(Cb_cash_advance.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance(Cb_cash_advance.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_cash_advance where id = "1";
 * 
 * 6. Cb_cash_advance obj = new Cb_cash_advance();
 *    obj.loadString(Cb_cash_advance.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance();
 *    obj.loadString(Cb_cash_advance.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_cash_advance where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_cash_advance Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_cash_advance : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_cash_advance obj = new Cb_cash_advance(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_cash_advance where id = 1;
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
public class Cb_cash_advance extends Cb_cash_advanceAbst{
    public Cb_cash_advance() throws CodeException {
       
    }
    
    public Cb_cash_advance(long id) throws CodeException {
        super(id);
    }
    
    public Cb_cash_advance(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_cash_advance(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_cash_advance(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




