/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_paymenttermAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_paymentterm obj = new Op_paymentterm();
 * 
 * 2. Op_paymentterm obj = new Op_paymentterm(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm(1);
 * 
 *    It Means : Select * from op_paymentterm where id = 1;
 * 
 * 3. Op_paymentterm obj = new Op_paymentterm(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm(1);
 * 
 *    It Means : Select * from op_paymentterm where id = 1;
 * 
 * 4. Op_paymentterm obj = new Op_paymentterm(<primary_key>); 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm("1");
 *    It Means : Select * from op_paymentterm where <primary_key> = "1";
 * 
 * 5. Op_paymentterm obj = new Op_paymentterm(Op_paymentterm.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm(Op_paymentterm.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_paymentterm where id = "1";
 * 
 * 6. Op_paymentterm obj = new Op_paymentterm();
 *    obj.loadString(Op_paymentterm.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm();
 *    obj.loadString(Op_paymentterm.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_paymentterm where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_paymentterm Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_paymentterm : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_paymentterm obj = new Op_paymentterm(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_paymentterm where id = 1;
 * 
 * 
 */


package accapp.objectclasses.op;

import accapp.objectclasses.gl.Gl_account;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Op_paymentterm extends Op_paymenttermAbst{
    public Op_paymentterm() throws CodeException {
       
    }
    
    public Op_paymentterm(long id) throws CodeException {
        super(id);
    }
    
    public Op_paymentterm(String val)  throws CodeException {
        super(val);
    }
    
    public Op_paymentterm(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_paymentterm(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void save() throws CodeException {

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }
    public void settermcode(String param) throws CodeException { 
        super.settermcode(param.replace("-", ""));
    } 

    public String gettermcodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.gettermcode());
    }

}




