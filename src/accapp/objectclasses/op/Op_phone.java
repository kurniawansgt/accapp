/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_phoneAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_phone obj = new Op_phone();
 * 
 * 2. Op_phone obj = new Op_phone(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_phone obj = new Op_phone(1);
 * 
 *    It Means : Select * from op_phone where id = 1;
 * 
 * 3. Op_phone obj = new Op_phone(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_phone obj = new Op_phone(1);
 * 
 *    It Means : Select * from op_phone where id = 1;
 * 
 * 4. Op_phone obj = new Op_phone(<primary_key>); 
 *    Sample :
 *    Op_phone obj = new Op_phone("1");
 *    It Means : Select * from op_phone where <primary_key> = "1";
 * 
 * 5. Op_phone obj = new Op_phone(Op_phone.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_phone obj = new Op_phone(Op_phone.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_phone where id = "1";
 * 
 * 6. Op_phone obj = new Op_phone();
 *    obj.loadString(Op_phone.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_phone obj = new Op_phone();
 *    obj.loadString(Op_phone.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_phone where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_phone Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_phone : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_phone obj = new Op_phone(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_phone obj = new Op_phone(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_phone where id = 1;
 * 
 * 
 */


package accapp.objectclasses.op;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Op_phone extends Op_phoneAbst{
    public Op_phone() throws CodeException {
       
    }
    
    public Op_phone(long id) throws CodeException {
        super(id);
    }
    
    public Op_phone(String val)  throws CodeException {
        super(val);
    }
    
    public Op_phone(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_phone(ResultSet rs) throws CodeException {
        super(rs);
    }


    public String getOP_PhoneDescription() throws CodeException {

        Op_phonetype phonetype = new Op_phonetype(this.getphonetypecode());
        return phonetype.getdscription();

    }
    
    public void save() throws CodeException {

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setauditUser(GlobalUtils.getAuditUser());
        this.setauditUser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }


 
}




