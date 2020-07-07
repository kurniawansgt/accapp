/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_vendgrpAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_vendgrp obj = new Ap_vendgrp();
 * 
 * 2. Ap_vendgrp obj = new Ap_vendgrp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp(1);
 * 
 *    It Means : Select * from ap_vendgrp where id = 1;
 * 
 * 3. Ap_vendgrp obj = new Ap_vendgrp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp(1);
 * 
 *    It Means : Select * from ap_vendgrp where id = 1;
 * 
 * 4. Ap_vendgrp obj = new Ap_vendgrp(<primary_key>); 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp("1");
 *    It Means : Select * from ap_vendgrp where <primary_key> = "1";
 * 
 * 5. Ap_vendgrp obj = new Ap_vendgrp(Ap_vendgrp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp(Ap_vendgrp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_vendgrp where id = "1";
 * 
 * 6. Ap_vendgrp obj = new Ap_vendgrp();
 *    obj.loadString(Ap_vendgrp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp();
 *    obj.loadString(Ap_vendgrp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_vendgrp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_vendgrp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_vendgrp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_vendgrp obj = new Ap_vendgrp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_vendgrp where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import accapp.objectclasses.cashbook.Cb_bank;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_ratetype;
import accapp.objectclasses.op.Op_paymentterm;
import accapp.objectclasses.op.Op_tax;
import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Ap_vendgrp extends Ap_vendgrpAbst{
    public Ap_vendgrp() throws CodeException {
       
    }
    
    public Ap_vendgrp(long id) throws CodeException {
        super(id);
    }
    
    public Ap_vendgrp(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_vendgrp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_vendgrp(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getAp_distsethDesc() throws CodeException {
        Ap_distseth apdistset = new Ap_distseth(this.getdistsetcode());
        return apdistset.getdscription();
    }


    public String getAP_accsetDesc() throws CodeException {
        Ap_accset aracc = new Ap_accset(this.getaccsetcode());
        return aracc.getdscription();
    }
    public String getOp_PaymentTermDesc() throws CodeException {
        Op_paymentterm arint = new Op_paymentterm(this.gettermcode());
        return arint.getdscription();
    }
    public String getTermDescription () throws CodeException {
        Op_paymentterm opterm = new Op_paymentterm(this.gettermcode());
        return opterm.getdscription();
    }


    public String getAp_distDesc() throws CodeException {
        Ap_distcode apdistcode = new Ap_distcode(this.getdistcode());
        return apdistcode.getdscription();
    }

    public String getOP_TaxDesc() throws CodeException {
        Op_tax taxcode = new Op_tax(this.gettaxcode());
        return taxcode.getdscription();
    }

    public String getGL_AccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getglacccode());
        return glacc.getaccdesc();
    }

    public String getCB_BankDesc() throws CodeException {
        Cb_bank bank = new Cb_bank(this.getbankcode());
        return bank.getbankname();
    }

    public String getGl_RateTypeDesc() throws CodeException {
        Gl_ratetype rate  = new Gl_ratetype(this.getratetype());
        return rate.getdscription();
    }



    public void setglacccode(String param) throws CodeException {
        super.setglacccode(param.replace("-", ""));
    }
    public String getglacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getglacccode());
    }


}





