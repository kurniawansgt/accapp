/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Payment_voucherAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Payment_voucher obj = new Payment_voucher();
 * 
 * 2. Payment_voucher obj = new Payment_voucher(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher(1);
 * 
 *    It Means : Select * from payment_voucher where id = 1;
 * 
 * 3. Payment_voucher obj = new Payment_voucher(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher(1);
 * 
 *    It Means : Select * from payment_voucher where id = 1;
 * 
 * 4. Payment_voucher obj = new Payment_voucher(<primary_key>); 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher("1");
 *    It Means : Select * from payment_voucher where <primary_key> = "1";
 * 
 * 5. Payment_voucher obj = new Payment_voucher(Payment_voucher.PROPERTY_<field>, <value>);
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher(Payment_voucher.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from payment_voucher where id = "1";
 * 
 * 6. Payment_voucher obj = new Payment_voucher();
 *    obj.loadString(Payment_voucher.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher();
 *    obj.loadString(Payment_voucher.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from payment_voucher where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM payment_voucher Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("payment_voucher : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Payment_voucher obj = new Payment_voucher(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from payment_voucher where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Payment_voucher extends Payment_voucherAbst{
    public Payment_voucher() throws CodeException {
       
    }
    
    public Payment_voucher(long id) throws CodeException {
        super(id);
    }
    
    public Payment_voucher(String val)  throws CodeException {
        super(val);
    }
    
    public Payment_voucher(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Payment_voucher(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




