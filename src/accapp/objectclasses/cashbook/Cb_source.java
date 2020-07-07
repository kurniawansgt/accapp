/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_sourceAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_source obj = new Cb_source();
 * 
 * 2. Cb_source obj = new Cb_source(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_source obj = new Cb_source(1);
 * 
 *    It Means : Select * from cb_source where id = 1;
 * 
 * 3. Cb_source obj = new Cb_source(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_source obj = new Cb_source(1);
 * 
 *    It Means : Select * from cb_source where id = 1;
 * 
 * 4. Cb_source obj = new Cb_source(<primary_key>); 
 *    Sample :
 *    Cb_source obj = new Cb_source("1");
 *    It Means : Select * from cb_source where <primary_key> = "1";
 * 
 * 5. Cb_source obj = new Cb_source(Cb_source.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_source obj = new Cb_source(Cb_source.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_source where id = "1";
 * 
 * 6. Cb_source obj = new Cb_source();
 *    obj.loadString(Cb_source.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_source obj = new Cb_source();
 *    obj.loadString(Cb_source.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_source where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_source Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_source : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_source obj = new Cb_source(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_source obj = new Cb_source(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_source where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import accapp.objectclasses.gl.Gl_account;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Cb_source extends Cb_sourceAbst{
    public Cb_source() throws CodeException {
       
    }
    
    public Cb_source(long id) throws CodeException {
        super(id);
    }
    
    public Cb_source(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_source(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_source(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getAccountDescription() throws CodeException {
         Gl_account glacc = new Gl_account(this.getacccode());
         return glacc.getaccdesc();
    }


  
    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setobjtype(ObjectType.CB_SOURCE);

        super.save();
    }
}




