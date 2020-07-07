/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_addressAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_address obj = new Op_address();
 * 
 * 2. Op_address obj = new Op_address(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_address obj = new Op_address(1);
 * 
 *    It Means : Select * from op_address where id = 1;
 * 
 * 3. Op_address obj = new Op_address(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_address obj = new Op_address(1);
 * 
 *    It Means : Select * from op_address where id = 1;
 * 
 * 4. Op_address obj = new Op_address(<primary_key>); 
 *    Sample :
 *    Op_address obj = new Op_address("1");
 *    It Means : Select * from op_address where <primary_key> = "1";
 * 
 * 5. Op_address obj = new Op_address(Op_address.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_address obj = new Op_address(Op_address.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_address where id = "1";
 * 
 * 6. Op_address obj = new Op_address();
 *    obj.loadString(Op_address.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_address obj = new Op_address();
 *    obj.loadString(Op_address.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_address where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_address Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_address : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_address obj = new Op_address(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_address obj = new Op_address(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_address where id = 1;
 * 
 * 
 */


package accapp.objectclasses.op;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Op_address extends Op_addressAbst{


    Op_phones phones;

    public Op_address() throws CodeException {
       phones = new Op_phones();
    }
    
    public Op_address(long id) throws CodeException {
        super(id);
    }
    
    public Op_address(String val)  throws CodeException {
        super(val);
    }
    
    public Op_address(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_address(ResultSet rs) throws CodeException {
        super(rs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        phones = new Op_phones();
        phones.searchData(this.getownercode(), this.getaddrcode(), this.getaddrtypecode());


    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        phones = new Op_phones();
        phones.searchData(this.getownercode(), this.getaddrcode(), this.getaddrtypecode());

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(val);
        phones = new Op_phones();
        phones.searchData(this.getownercode(), this.getaddrcode(), this.getaddrtypecode());
    }

    public void delete() throws CodeException {

        phones = new Op_phones();
        phones.searchData(this.getownercode(), this.getaddrcode(), this.getaddrtypecode());
        phones.delete();

        super.delete();
    }



    public int getMaxEntryNo(String ownercode, String addrtypecode, int basetype) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(addrcode) is null then 0 else max(addrcode) end nomor "
                            + "\n from op_address "
                            + "\n       where ownercode='" + ownercode + "'"
                            + "\n             and addrtypecode = '" + addrtypecode + "' "
                            + "\n             and basetype = " + basetype ;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = Integer.parseInt(rs.getString("nomor")) + 1;
            }

       } catch (SQLException ex) {
             throw new CodeException("OP Address : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }



    public void save() throws CodeException {

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();

        for(Object o : this.getOP_Phones().list()) {
            Op_phone opphone = (Op_phone) o;

            opphone.setownercode(this.getownercode());
            opphone.setaddrcode(this.getaddrcode());
            opphone.setaddrtypecode(this.getaddrtypecode());
            
            opphone.save();
        }
    }

    //Dapatkan Phone
    public Op_phones getOP_Phones() {
        return phones;
    }

    public void setOP_Phones(Op_phones phones) {
        this.phones = phones;
    }
    
    public void replaceOp_Phone(int index, Op_phone opphone) throws CodeException {
        this.phones.list().set(index, opphone);
    }

    public void removeOp_Phone(int index) throws CodeException {
        Op_phone opphone = (Op_phone) phones.list().get(index);
        opphone.delete();

        phones.list().remove(index);
    }


    public String getOP_AddrTypeDescription() throws CodeException {
        Op_addrtype addrtype = new Op_addrtype(this.getaddrtypecode());

        return addrtype.getdscription();
        
    }

}




