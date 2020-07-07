/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ut_external_dataAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ut_external_data obj = new Ut_external_data();
 * 
 * 2. Ut_external_data obj = new Ut_external_data(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data(1);
 * 
 *    It Means : Select * from ut_external_data where id = 1;
 * 
 * 3. Ut_external_data obj = new Ut_external_data(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data(1);
 * 
 *    It Means : Select * from ut_external_data where id = 1;
 * 
 * 4. Ut_external_data obj = new Ut_external_data(<primary_key>); 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data("1");
 *    It Means : Select * from ut_external_data where <primary_key> = "1";
 * 
 * 5. Ut_external_data obj = new Ut_external_data(Ut_external_data.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data(Ut_external_data.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ut_external_data where id = "1";
 * 
 * 6. Ut_external_data obj = new Ut_external_data();
 *    obj.loadString(Ut_external_data.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data();
 *    obj.loadString(Ut_external_data.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ut_external_data where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ut_external_data Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ut_external_data : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ut_external_data obj = new Ut_external_data(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ut_external_data where id = 1;
 * 
 * 
 */


package cpp_utils.objectclasses;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Ut_external_data extends Ut_external_dataAbst{
    public Ut_external_data() throws CodeException {
       
    }
    
    public Ut_external_data(long id) throws CodeException {
        super(id);
    }
    
    public Ut_external_data(String val)  throws CodeException {
        super(val);
    }
    
    public Ut_external_data(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ut_external_data(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




