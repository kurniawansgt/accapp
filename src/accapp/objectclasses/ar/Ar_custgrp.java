/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_custgrpAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_custgrp obj = new Ar_custgrp();
 * 
 * 2. Ar_custgrp obj = new Ar_custgrp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp(1);
 * 
 *    It Means : Select * from ar_custgrp where id = 1;
 * 
 * 3. Ar_custgrp obj = new Ar_custgrp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp(1);
 * 
 *    It Means : Select * from ar_custgrp where id = 1;
 * 
 * 4. Ar_custgrp obj = new Ar_custgrp(<primary_key>); 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp("1");
 *    It Means : Select * from ar_custgrp where <primary_key> = "1";
 * 
 * 5. Ar_custgrp obj = new Ar_custgrp(Ar_custgrp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp(Ar_custgrp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_custgrp where id = "1";
 * 
 * 6. Ar_custgrp obj = new Ar_custgrp();
 *    obj.loadString(Ar_custgrp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp();
 *    obj.loadString(Ar_custgrp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_custgrp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_custgrp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_custgrp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_custgrp obj = new Ar_custgrp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_custgrp where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.op.Op_paymentterm;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ar_custgrp extends Ar_custgrpAbst{
    public Ar_custgrp() throws CodeException {
       
    }
    
    public Ar_custgrp(long id) throws CodeException {
        super(id);
    }
    
    public Ar_custgrp(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_custgrp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_custgrp(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getAR_accsetDesc() throws CodeException {
        Ar_accset aracc = new Ar_accset(this.getaccsetcode());
        return aracc.getdscription();
    }
    public String getAR_billcyclsDesc() throws CodeException {
        Ar_billcycl arbill = new Ar_billcycl(this.getcyclcode());
        return arbill.getdscrition();
    }
    public String getAR_intrschrDesc() throws CodeException {
        Ar_interest arint = new Ar_interest(this.getintrschrcode());
        return arint.getdscription();
    }
    public String getOp_PaymentTermDesc() throws CodeException {
        Op_paymentterm arint = new Op_paymentterm(this.gettermcode());
        return arint.getdscription();
    }

    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_CUSTGRP);
        super.save();
    }
    public void setaccsetcode(String param) throws CodeException {
         super.setaccsetcode(param.replace("-", ""));
    }

    public void setcyclcode(String param) throws CodeException {
        super.setcyclcode(param.replace("-", ""));
    }

    public void setintrschrcode(String param) throws CodeException {
        super.setintrschrcode(param.replace("-", ""));
    }


    public void settermcode(String param) throws CodeException {
        super.settermcode(param.replace("-", ""));
    }

    

}




