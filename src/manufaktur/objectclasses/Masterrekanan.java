/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MasterrekananAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Masterrekanan obj = new Masterrekanan();
 * 
 * 2. Masterrekanan obj = new Masterrekanan(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan(1);
 * 
 *    It Means : Select * from masterrekanan where id = 1;
 * 
 * 3. Masterrekanan obj = new Masterrekanan(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan(1);
 * 
 *    It Means : Select * from masterrekanan where id = 1;
 * 
 * 4. Masterrekanan obj = new Masterrekanan(<primary_key>); 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan("1");
 *    It Means : Select * from masterrekanan where <primary_key> = "1";
 * 
 * 5. Masterrekanan obj = new Masterrekanan(Masterrekanan.PROPERTY_<field>, <value>);
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan(Masterrekanan.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from masterrekanan where id = "1";
 * 
 * 6. Masterrekanan obj = new Masterrekanan();
 *    obj.loadString(Masterrekanan.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan();
 *    obj.loadString(Masterrekanan.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from masterrekanan where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM masterrekanan Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("masterrekanan : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Masterrekanan obj = new Masterrekanan(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from masterrekanan where id = 1;
 * 
 * 
 */


package manufaktur.objectclasses;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Masterrekanan extends MasterrekananAbst{
    

    public Masterrekanan() throws CodeException {

    }
    
    public Masterrekanan(long id) throws CodeException {
        super(id);
    }
    
    public Masterrekanan(String val)  throws CodeException {
        super(val);
    }
    
    public Masterrekanan(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Masterrekanan(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




