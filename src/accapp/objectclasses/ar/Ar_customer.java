/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_customerAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_customer obj = new Ar_customer();
 * 
 * 2. Ar_customer obj = new Ar_customer(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_customer obj = new Ar_customer(1);
 * 
 *    It Means : Select * from ar_customer where id = 1;
 * 
 * 3. Ar_customer obj = new Ar_customer(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_customer obj = new Ar_customer(1);
 * 
 *    It Means : Select * from ar_customer where id = 1;
 * 
 * 4. Ar_customer obj = new Ar_customer(<primary_key>); 
 *    Sample :
 *    Ar_customer obj = new Ar_customer("1");
 *    It Means : Select * from ar_customer where <primary_key> = "1";
 * 
 * 5. Ar_customer obj = new Ar_customer(Ar_customer.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_customer obj = new Ar_customer(Ar_customer.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_customer where id = "1";
 * 
 * 6. Ar_customer obj = new Ar_customer();
 *    obj.loadString(Ar_customer.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_customer obj = new Ar_customer();
 *    obj.loadString(Ar_customer.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_customer where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_customer Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_customer : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_customer obj = new Ar_customer(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_customer obj = new Ar_customer(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_customer where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.op.Op_address;
import accapp.objectclasses.op.Op_addresss;
import accapp.objectclasses.op.Op_paymentterm;
import accapp.objectclasses.op.Op_tax;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.text.DecimalFormat;

/**
 *
 * @author windu
 */


public class Ar_customer extends Ar_customerAbst{
    
    private Op_addresss opaddresss;

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Ar_customer() throws CodeException {
        opaddresss = new Op_addresss();
    }
    
    public Ar_customer(long id) throws CodeException {
        super(id);
        
    }
    
    public Ar_customer(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_customer(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_customer(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
 
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
    }


    public String getNarCodeDescription () throws CodeException {

        Ar_custnat arcn = new Ar_custnat(this.getnatcode() );
        return arcn.getdscription();

    }

    public String getCustGroupDescription () throws CodeException {

        Ar_custgrp argrp = new Ar_custgrp(this.getgrpcode() );
        return argrp.getdscription();

    }

    public String getAccountSetDescription () throws CodeException {

        Ar_accset arc = new Ar_accset(this.getaccsetcode());
        return arc.getdscription();
    }

    public String getInterestProfileDescription () throws CodeException {
        Ar_interest ari = new Ar_interest(this.getintrschrcode());
        return ari.getdscription();
    }

    public String getCycleDescription () throws CodeException {
         Ar_billcycl arb = new Ar_billcycl(this.getcyclcode());
        return arb.getdscrition();
    }

    public String getTermDescription () throws CodeException {
        Op_paymentterm opterm = new Op_paymentterm(this.gettermcode());
        return opterm.getdscription();
    }

    public String getTaxDescription () throws CodeException {
         Op_tax opt = new Op_tax(this.gettaxcode());
        return opt.getdscription();
    }


    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_CUSTOMER);
        super.save();

        for(Object o : this.getOp_Addresss().list()) {
            Op_address opaddress = (Op_address) o;

            if (opaddress.getID() == 0) {
                DecimalFormat df = new DecimalFormat("000");
                opaddress.setaddrcode(df.format(opaddress.getMaxEntryNo(this.getcustmrcode(), opaddress.getaddrtypecode(), ObjectType.AR_CUSTOMER)));
            }
            opaddress.setownercode(this.getcustmrcode());
            opaddress.setbasetype(ObjectType.AR_CUSTOMER);
            opaddress.save();
        }
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);
    }


    public void delete() throws CodeException {
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getcustmrcode(), ObjectType.AR_CUSTOMER);

        opaddresss.delete();

        super.delete();
    }

    //untuk Op_Addresss
    public Op_addresss getOp_Addresss() {
        return opaddresss;
    }

    public void setOp_Addresss(Op_addresss opaddresss) {
        this.opaddresss = opaddresss;
    }

    public void addOp_Address(Op_address opaddress) throws CodeException {
        opaddresss.add(opaddress);
    }

    public void addOp_Address(Op_addresss opadresss) throws CodeException {
        this.opaddresss.add(opaddresss);
    }

    public void replaceOp_Address(int index, Op_address opaddress) throws CodeException {
        this.opaddresss.list().set(index, opaddress);
    }


    public void removeOp_Address(int index) throws CodeException {
        Op_address opaddress = (Op_address) opaddresss.list().get(index);
        opaddress.delete();

        opaddresss.list().remove(index);

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

    public void settaxcode(String param) throws CodeException {
        super.settaxcode(param.replace("-", ""));
    } 
    public void setdisccode(String param) throws CodeException {
        super.setdisccode(param.replace("-", ""));
    }


}




