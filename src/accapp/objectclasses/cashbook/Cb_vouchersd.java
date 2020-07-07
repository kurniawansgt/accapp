/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 * This class is inhereted from Cb_vouchersdAbst that handle CRUD
    (Create/Insert Read Update Delete)
 *
 * How To Use This Class to Read Data or make instance
 * 1. Cb_vouchersd obj = new Cb_vouchersd();
 *
 * 2. Cb_vouchersd obj = new Cb_vouchersd(<id>); // <id> = number of id
 *
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd(1);
 *
 *    It Means : Select * from Cb_vouchersd where id = 1;
 *
 * 3. Cb_vouchersd obj = new Cb_vouchersd();
 *    obj.loadID(1);
 *
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd(1);
 *
 *    It Means : Select * from Cb_vouchersd where id = 1;
 *
 * 4. Cb_vouchersd obj = new Cb_vouchersd(<primary_key>);
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd("1");
 *    It Means : Select * from Cb_vouchersd where <primary_key> = "1";
 *
 * 5. Cb_vouchersd obj = new Cb_vouchersd(Cb_vouchersd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd(Cb_vouchersd.PROPERTY_ID, "1");
 *
 *    It Means : Select * from Cb_vouchersd where id = "1";
 *
 * 6. Cb_vouchersd obj = new Cb_vouchersd();
 *    obj.loadString(Cb_vouchersd.PROPERTY_<field>, <value>)
 *
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd();
 *    obj.loadString(Cb_vouchersd.PROPERTY_ID, "1")
 *
 *    It Means : Select * from Cb_vouchersd where id = "1";
 *
 * 7. User Recordset
 *
 *    Sample :
 *
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM Cb_vouchersd Where id = 1" ;
 *
        try {
            ResultSet rs = db.executeQuery(sql);

            if(rs.next()) {
                loadRs(rs);
            }


        } catch (SQLException ex) {
            throw new CodeException("Cb_vouchersd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 *
 * 8. Save Data
 *
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 *
 *
 *    if the id == 0 then save new else save update
 *
 * 9. Delete
 *
 *    Sample :
 *    Cb_vouchersd obj = new Cb_vouchersd(1);
 *    obj.delete();
 *
 *
 *    It Means : Delete from Cb_vouchersd where id = 1;
 *
 *
 */


package accapp.objectclasses.cashbook;

import common.jdbc.DbBean;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Cb_vouchersd extends Cb_vouchersdAbst{
    private String applied="No";

    public Cb_vouchersd() throws CodeException {

    }

    public Cb_vouchersd(long id) throws CodeException {
        super(id);
    }

    public Cb_vouchersd(String val)  throws CodeException {
        super(val);
    }

    public Cb_vouchersd(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Cb_vouchersd(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxDetailNo(double batchno, long entryno, long linenum) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(detailno) is null then 1 else max(detailno) + 1 end nomor "
                            + "\n from cb_vouchersd where batchno=" + batchno + " and entryno=" + entryno +" and detailno="+linenum;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_voucherh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void save() throws CodeException {

        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setcmpnyid(GlobalUtils.company);
        setobjtype(ObjectType.CB_BATCSD);

        super.save();


    }

    public String getdoctypedesc() throws CodeException{
        String result="";
        if(this.getdoctype() != null) {
            switch (GlobalUtils.toInt(this.getdoctype())){
                case 4:
                    result= "IN";// / Invoice
                    break;
                case 5:
                    result= "CN";// / Debit Note
                    break;
                case 6:
                    result= "DN";// / Credit Note,
                    break;
                case 7:
                    result= "IT";// / Interest
                    break;
            }
        }
        return result;
    }

    public String getdesctodoctype() throws CodeException{
        String result="";
        if (this.getdoctype().equalsIgnoreCase("IN")||this.getdoctype().equalsIgnoreCase("4")){
            result="4";
        } else if (this.getdoctype().equalsIgnoreCase("CN")||this.getdoctype().equalsIgnoreCase("5")){
            result="5";
        } else if (this.getdoctype().equalsIgnoreCase("DN")||this.getdoctype().equalsIgnoreCase("6")){
            result="6";
        } else if (this.getdoctype().equalsIgnoreCase("IT")||this.getdoctype().equalsIgnoreCase("7")){
            result="7";
        }
        return result;
    }

    /**
     * @return the applied
     */
    public String getApplied() {
        return applied;
    }

    /**
     * @param applied the applied to set
     */
    public void setApplied(String applied) {
        this.applied = applied;
    }

}




