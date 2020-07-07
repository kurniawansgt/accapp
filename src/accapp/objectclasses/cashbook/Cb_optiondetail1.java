/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_optiondetail1Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_optiondetail1 obj = new Cb_optiondetail1();
 * 
 * 2. Cb_optiondetail1 obj = new Cb_optiondetail1(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1(1);
 * 
 *    It Means : Select * from cb_optiondetail1 where id = 1;
 * 
 * 3. Cb_optiondetail1 obj = new Cb_optiondetail1(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1(1);
 * 
 *    It Means : Select * from cb_optiondetail1 where id = 1;
 * 
 * 4. Cb_optiondetail1 obj = new Cb_optiondetail1(<primary_key>); 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1("1");
 *    It Means : Select * from cb_optiondetail1 where <primary_key> = "1";
 * 
 * 5. Cb_optiondetail1 obj = new Cb_optiondetail1(Cb_optiondetail1.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1(Cb_optiondetail1.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_optiondetail1 where id = "1";
 * 
 * 6. Cb_optiondetail1 obj = new Cb_optiondetail1();
 *    obj.loadString(Cb_optiondetail1.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1();
 *    obj.loadString(Cb_optiondetail1.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_optiondetail1 where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_optiondetail1 Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_optiondetail1 : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_optiondetail1 obj = new Cb_optiondetail1(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_optiondetail1 where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import common.jdbc.DbBean;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Cb_optiondetail1 extends Cb_optiondetail1Abst{


    public Cb_optiondetail1() throws CodeException {
       
    }
    
    public Cb_optiondetail1(long id) throws CodeException {
        super(id);
    }
    
    public Cb_optiondetail1(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_optiondetail1(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_optiondetail1(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setobjtype(ObjectType.CB_OPTIONDETAIL1);

        super.save();
    }
}




