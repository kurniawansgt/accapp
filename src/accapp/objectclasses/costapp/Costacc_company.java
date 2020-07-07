/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Costacc_companyAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Costacc_company obj = new Costacc_company();
 * 
 * 2. Costacc_company obj = new Costacc_company(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Costacc_company obj = new Costacc_company(1);
 * 
 *    It Means : Select * from costacc_company where id = 1;
 * 
 * 3. Costacc_company obj = new Costacc_company(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Costacc_company obj = new Costacc_company(1);
 * 
 *    It Means : Select * from costacc_company where id = 1;
 * 
 * 4. Costacc_company obj = new Costacc_company(<primary_key>); 
 *    Sample :
 *    Costacc_company obj = new Costacc_company("1");
 *    It Means : Select * from costacc_company where <primary_key> = "1";
 * 
 * 5. Costacc_company obj = new Costacc_company(Costacc_company.PROPERTY_<field>, <value>);
 *    Sample :
 *    Costacc_company obj = new Costacc_company(Costacc_company.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from costacc_company where id = "1";
 * 
 * 6. Costacc_company obj = new Costacc_company();
 *    obj.loadString(Costacc_company.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Costacc_company obj = new Costacc_company();
 *    obj.loadString(Costacc_company.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from costacc_company where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM costacc_company Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("costacc_company : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Costacc_company obj = new Costacc_company(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Costacc_company obj = new Costacc_company(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from costacc_company where id = 1;
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
public class Costacc_company extends Costacc_companyAbst{
    public Costacc_company() throws CodeException {
       
    }
    
    public Costacc_company(long id) throws CodeException {
        super(id);
    }
    
    public Costacc_company(String val)  throws CodeException {
        super(val);
    }
    
    public Costacc_company(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Costacc_company(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




