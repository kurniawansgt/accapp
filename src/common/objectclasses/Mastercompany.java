/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from CompanyAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Company obj = new Company();
 * 
 * 2. Company obj = new Company(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Company obj = new Company(1);
 * 
 *    It Means : Select * from company where id = 1;
 * 
 * 3. Company obj = new Company(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Company obj = new Company(1);
 * 
 *    It Means : Select * from company where id = 1;
 * 
 * 4. Company obj = new Company(<primary_key>); 
 *    Sample :
 *    Company obj = new Company("1");
 *    It Means : Select * from company where <primary_key> = "1";
 * 
 * 5. Company obj = new Company(Company.PROPERTY_<field>, <value>);
 *    Sample :
 *    Company obj = new Company(Company.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from company where id = "1";
 * 
 * 6. Company obj = new Company();
 *    obj.loadString(Company.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Company obj = new Company();
 *    obj.loadString(Company.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from company where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBeanCommon db = DbBeanCommon.connect();
        String sql = "SELECT * FROM company Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("company : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Company obj = new Company(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Company obj = new Company(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from company where id = 1;
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
public class Mastercompany extends MastercompanyAbst{
    public Mastercompany() throws CodeException {
       
    }
    
    public Mastercompany(long id) throws CodeException {
        super(id);
    }
    
    public Mastercompany(String val)  throws CodeException {
        super(val);
    }
    
    public Mastercompany(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Mastercompany(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




