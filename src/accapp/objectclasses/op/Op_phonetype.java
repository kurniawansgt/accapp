/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_phonetypeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_phonetype obj = new Op_phonetype();
 * 
 * 2. Op_phonetype obj = new Op_phonetype(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype(1);
 * 
 *    It Means : Select * from op_phonetype where id = 1;
 * 
 * 3. Op_phonetype obj = new Op_phonetype(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype(1);
 * 
 *    It Means : Select * from op_phonetype where id = 1;
 * 
 * 4. Op_phonetype obj = new Op_phonetype(<primary_key>); 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype("1");
 *    It Means : Select * from op_phonetype where <primary_key> = "1";
 * 
 * 5. Op_phonetype obj = new Op_phonetype(Op_phonetype.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype(Op_phonetype.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_phonetype where id = "1";
 * 
 * 6. Op_phonetype obj = new Op_phonetype();
 *    obj.loadString(Op_phonetype.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype();
 *    obj.loadString(Op_phonetype.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_phonetype where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_phonetype Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_phonetype : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_phonetype obj = new Op_phonetype(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_phonetype where id = 1;
 * 
 * 
 */


package accapp.objectclasses.op;

import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Op_phonetype extends Op_phonetypeAbst{
    public Op_phonetype() throws CodeException {
       
    }
    
    public Op_phonetype(long id) throws CodeException {
        super(id);
    }
    
    public Op_phonetype(String val)  throws CodeException {
        super(val);
    }
    
    public Op_phonetype(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_phonetype(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void save() throws CodeException {

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();


    }
}




