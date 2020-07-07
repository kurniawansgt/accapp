/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_optionAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_option obj = new Cb_option();
 * 
 * 2. Cb_option obj = new Cb_option(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_option obj = new Cb_option(1);
 * 
 *    It Means : Select * from cb_option where id = 1;
 * 
 * 3. Cb_option obj = new Cb_option(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_option obj = new Cb_option(1);
 * 
 *    It Means : Select * from cb_option where id = 1;
 * 
 * 4. Cb_option obj = new Cb_option(<primary_key>); 
 *    Sample :
 *    Cb_option obj = new Cb_option("1");
 *    It Means : Select * from cb_option where <primary_key> = "1";
 * 
 * 5. Cb_option obj = new Cb_option(Cb_option.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_option obj = new Cb_option(Cb_option.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_option where id = "1";
 * 
 * 6. Cb_option obj = new Cb_option();
 *    obj.loadString(Cb_option.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_option obj = new Cb_option();
 *    obj.loadString(Cb_option.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_option where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_option Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_option : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_option obj = new Cb_option(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_option obj = new Cb_option(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_option where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Cb_option extends Cb_optionAbst{
    public Cb_option() throws CodeException {
       
    }
    
    public Cb_option(long id) throws CodeException {
        super(id);
    }
    
    public Cb_option(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_option(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_option(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }

        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        setobjtype(ObjectType.CB_OPTION);

        super.save();


    }
}




