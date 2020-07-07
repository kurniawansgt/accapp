/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_addrtypeAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_addrtype obj = new Op_addrtype();
 * 
 * 2. Op_addrtype obj = new Op_addrtype(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype(1);
 * 
 *    It Means : Select * from op_addrtype where id = 1;
 * 
 * 3. Op_addrtype obj = new Op_addrtype(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype(1);
 * 
 *    It Means : Select * from op_addrtype where id = 1;
 * 
 * 4. Op_addrtype obj = new Op_addrtype(<primary_key>); 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype("1");
 *    It Means : Select * from op_addrtype where <primary_key> = "1";
 * 
 * 5. Op_addrtype obj = new Op_addrtype(Op_addrtype.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype(Op_addrtype.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_addrtype where id = "1";
 * 
 * 6. Op_addrtype obj = new Op_addrtype();
 *    obj.loadString(Op_addrtype.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype();
 *    obj.loadString(Op_addrtype.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_addrtype where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_addrtype Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_addrtype : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_addrtype obj = new Op_addrtype(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_addrtype where id = 1;
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
public class Op_addrtype extends Op_addrtypeAbst{
    public Op_addrtype() throws CodeException {
       
    }
    
    public Op_addrtype(long id) throws CodeException {
        super(id);
    }
    
    public Op_addrtype(String val)  throws CodeException {
        super(val);
    }
    
    public Op_addrtype(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_addrtype(ResultSet rs) throws CodeException {
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




