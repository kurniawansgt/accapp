/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Costacc_glwip_tempAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Costacc_glwip_temp obj = new Costacc_glwip_temp();
 * 
 * 2. Costacc_glwip_temp obj = new Costacc_glwip_temp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp(1);
 * 
 *    It Means : Select * from costacc_glwip_temp where id = 1;
 * 
 * 3. Costacc_glwip_temp obj = new Costacc_glwip_temp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp(1);
 * 
 *    It Means : Select * from costacc_glwip_temp where id = 1;
 * 
 * 4. Costacc_glwip_temp obj = new Costacc_glwip_temp(<primary_key>); 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp("1");
 *    It Means : Select * from costacc_glwip_temp where <primary_key> = "1";
 * 
 * 5. Costacc_glwip_temp obj = new Costacc_glwip_temp(Costacc_glwip_temp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp(Costacc_glwip_temp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from costacc_glwip_temp where id = "1";
 * 
 * 6. Costacc_glwip_temp obj = new Costacc_glwip_temp();
 *    obj.loadString(Costacc_glwip_temp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp();
 *    obj.loadString(Costacc_glwip_temp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from costacc_glwip_temp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM costacc_glwip_temp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("costacc_glwip_temp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Costacc_glwip_temp obj = new Costacc_glwip_temp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from costacc_glwip_temp where id = 1;
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
public class Costacc_glwip_temp extends Costacc_glwip_tempAbst{
    public Costacc_glwip_temp() throws CodeException {
       
    }
    
    public Costacc_glwip_temp(long id) throws CodeException {
        super(id);
    }
    
    public Costacc_glwip_temp(String val)  throws CodeException {
        super(val);
    }
    
    public Costacc_glwip_temp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Costacc_glwip_temp(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




