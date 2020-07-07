/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from H_material_receiveAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. H_material_receive obj = new H_material_receive();
 * 
 * 2. H_material_receive obj = new H_material_receive(<id>); // <id> = number of id
 * 
 *    Sample :
 *    H_material_receive obj = new H_material_receive(1);
 * 
 *    It Means : Select * from h_material_receive where id = 1;
 * 
 * 3. H_material_receive obj = new H_material_receive(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    H_material_receive obj = new H_material_receive(1);
 * 
 *    It Means : Select * from h_material_receive where id = 1;
 * 
 * 4. H_material_receive obj = new H_material_receive(<primary_key>); 
 *    Sample :
 *    H_material_receive obj = new H_material_receive("1");
 *    It Means : Select * from h_material_receive where <primary_key> = "1";
 * 
 * 5. H_material_receive obj = new H_material_receive(H_material_receive.PROPERTY_<field>, <value>);
 *    Sample :
 *    H_material_receive obj = new H_material_receive(H_material_receive.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from h_material_receive where id = "1";
 * 
 * 6. H_material_receive obj = new H_material_receive();
 *    obj.loadString(H_material_receive.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    H_material_receive obj = new H_material_receive();
 *    obj.loadString(H_material_receive.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from h_material_receive where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM h_material_receive Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("h_material_receive : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    H_material_receive obj = new H_material_receive(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    H_material_receive obj = new H_material_receive(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from h_material_receive where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class H_material_receive extends H_material_receiveAbst{
    public H_material_receive() throws CodeException {
       
    }
    
    public H_material_receive(long id) throws CodeException {
        super(id);
    }
    
    public H_material_receive(String val)  throws CodeException {
        super(val);
    }
    
    public H_material_receive(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public H_material_receive(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




