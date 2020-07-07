/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_vendorAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_vendor obj = new Ap_vendor();
 * 
 * 2. Ap_vendor obj = new Ap_vendor(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor(1);
 * 
 *    It Means : Select * from ap_vendor where id = 1;
 * 
 * 3. Ap_vendor obj = new Ap_vendor(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor(1);
 * 
 *    It Means : Select * from ap_vendor where id = 1;
 * 
 * 4. Ap_vendor obj = new Ap_vendor(<primary_key>); 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor("1");
 *    It Means : Select * from ap_vendor where <primary_key> = "1";
 * 
 * 5. Ap_vendor obj = new Ap_vendor(Ap_vendor.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor(Ap_vendor.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_vendor where id = "1";
 * 
 * 6. Ap_vendor obj = new Ap_vendor();
 *    obj.loadString(Ap_vendor.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor();
 *    obj.loadString(Ap_vendor.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_vendor where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_vendor Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_vendor : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_vendor obj = new Ap_vendor(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_vendor where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_currency;
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
public class Ap_vendor extends Ap_vendorAbst{
    private Op_addresss opaddresss;

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Ap_vendor() throws CodeException {
       opaddresss = new Op_addresss();
    }
    
    public Ap_vendor(long id) throws CodeException {
        super(id);
    }
    
    public Ap_vendor(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_vendor(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_vendor(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);

    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);
    }

    public String getAccountSetDescription () throws CodeException {

        Ap_accset arc = new Ap_accset(this.getaccsetcode());
        return arc.getdscription();
    }

    public String getVendGroupDescription () throws CodeException {

        Ap_vendgrp argrp = new Ap_vendgrp(this.getgrpcode() );
        return argrp.getdscription();

    }

    public String getTermDescription () throws CodeException {
        Op_paymentterm opterm = new Op_paymentterm(this.gettermcode());
        return opterm.getdscription();
    }

    public String getAp_distsethDesc() throws CodeException {
        Ap_distseth apdistset = new Ap_distseth(this.getdistsetcode());
        return apdistset.getdscription();
    }

    public String getAp_distDesc() throws CodeException {
        Ap_distcode apdistcode = new Ap_distcode(this.getdistcode());
        return apdistcode.getdscription();
    }

    public String getOP_TaxDesc() throws CodeException {
        Op_tax taxcode = new Op_tax(this.gettaxcode());
        return taxcode.getdscription();
    }

    public String getCurr_Desc() throws CodeException {
        Gl_currency curr = new Gl_currency(this.getcurnccode());
        return curr.getcurncdesc();
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);
    }


    public void delete() throws CodeException {
        opaddresss = new Op_addresss();
        opaddresss.searchData(this.getvendcode(), ObjectType.AP_VENDOR);

        opaddresss.delete();

        super.delete();
    }

    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AP_VENDOR);
        super.save();

        for(Object o : this.getOp_Addresss().list()) {
            Op_address opaddress = (Op_address) o;

            if (opaddress.getID() == 0) {
                DecimalFormat df = new DecimalFormat("000");
                opaddress.setaddrcode(df.format(opaddress.getMaxEntryNo(this.getvendcode(), opaddress.getaddrtypecode(), ObjectType.AP_VENDOR)));
            }
            opaddress.setownercode(this.getvendcode());
            opaddress.setbasetype(ObjectType.AP_VENDOR);
            opaddress.save();
        }
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
    public String getaccsetcodefmt() throws CodeException {
         return Gl_account.getAccFormat(super.getaccsetcode());
    }

    public void setglacccode(String param) throws CodeException {
        super.setglacccode(param.replace("-", ""));

    }

    public String getglacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(super.getglacccode());
    }
    public String getGLAccDesc() throws CodeException {
        Gl_account glacc = new Gl_account(this.getglacccode());
        return glacc.getaccdesc();
    }


}




