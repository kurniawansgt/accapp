/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_batchsdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_batchsd obj = new Cb_batchsd();
 * 
 * 2. Cb_batchsd obj = new Cb_batchsd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd(1);
 * 
 *    It Means : Select * from cb_batchsd where id = 1;
 * 
 * 3. Cb_batchsd obj = new Cb_batchsd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd(1);
 * 
 *    It Means : Select * from cb_batchsd where id = 1;
 * 
 * 4. Cb_batchsd obj = new Cb_batchsd(<primary_key>); 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd("1");
 *    It Means : Select * from cb_batchsd where <primary_key> = "1";
 * 
 * 5. Cb_batchsd obj = new Cb_batchsd(Cb_batchsd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd(Cb_batchsd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_batchsd where id = "1";
 * 
 * 6. Cb_batchsd obj = new Cb_batchsd();
 *    obj.loadString(Cb_batchsd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd();
 *    obj.loadString(Cb_batchsd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_batchsd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_batchsd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_batchsd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_batchsd obj = new Cb_batchsd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_batchsd where id = 1;
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
public class Cb_batchsd extends Cb_batchsdAbst{
    private String applied="No";

    public Cb_batchsd() throws CodeException {
       
    }
    
    public Cb_batchsd(long id) throws CodeException {
        super(id);
    }
    
    public Cb_batchsd(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_batchsd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_batchsd(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxDetailNo(double batchno, long entryno, long linenum) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(detailno) is null then 1 else max(detailno) + 1 end nomor "
                            + "\n from cb_batchsd where batchno=" + batchno + " and entryno=" + entryno +" and detailno="+linenum;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_batchh : " + ex.getMessage());
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




