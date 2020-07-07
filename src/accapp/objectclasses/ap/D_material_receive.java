/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from D_material_receiveAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. D_material_receive obj = new D_material_receive();
 * 
 * 2. D_material_receive obj = new D_material_receive(<id>); // <id> = number of id
 * 
 *    Sample :
 *    D_material_receive obj = new D_material_receive(1);
 * 
 *    It Means : Select * from d_material_receive where id = 1;
 * 
 * 3. D_material_receive obj = new D_material_receive(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    D_material_receive obj = new D_material_receive(1);
 * 
 *    It Means : Select * from d_material_receive where id = 1;
 * 
 * 4. D_material_receive obj = new D_material_receive(<primary_key>); 
 *    Sample :
 *    D_material_receive obj = new D_material_receive("1");
 *    It Means : Select * from d_material_receive where <primary_key> = "1";
 * 
 * 5. D_material_receive obj = new D_material_receive(D_material_receive.PROPERTY_<field>, <value>);
 *    Sample :
 *    D_material_receive obj = new D_material_receive(D_material_receive.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from d_material_receive where id = "1";
 * 
 * 6. D_material_receive obj = new D_material_receive();
 *    obj.loadString(D_material_receive.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    D_material_receive obj = new D_material_receive();
 *    obj.loadString(D_material_receive.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from d_material_receive where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM d_material_receive Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("d_material_receive : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    D_material_receive obj = new D_material_receive(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    D_material_receive obj = new D_material_receive(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from d_material_receive where id = 1;
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
public class D_material_receive extends D_material_receiveAbst{
    public D_material_receive() throws CodeException {
       
    }
    
    public D_material_receive(long id) throws CodeException {
        super(id);
    }
    
    public D_material_receive(String val)  throws CodeException {
        super(val);
    }
    
    public D_material_receive(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public D_material_receive(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




