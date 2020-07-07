/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_paydAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_payd obj = new Ap_payd();
 * 
 * 2. Ap_payd obj = new Ap_payd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_payd obj = new Ap_payd(1);
 * 
 *    It Means : Select * from ap_payd where id = 1;
 * 
 * 3. Ap_payd obj = new Ap_payd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_payd obj = new Ap_payd(1);
 * 
 *    It Means : Select * from ap_payd where id = 1;
 * 
 * 4. Ap_payd obj = new Ap_payd(<primary_key>); 
 *    Sample :
 *    Ap_payd obj = new Ap_payd("1");
 *    It Means : Select * from ap_payd where <primary_key> = "1";
 * 
 * 5. Ap_payd obj = new Ap_payd(Ap_payd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_payd obj = new Ap_payd(Ap_payd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_payd where id = "1";
 * 
 * 6. Ap_payd obj = new Ap_payd();
 *    obj.loadString(Ap_payd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_payd obj = new Ap_payd();
 *    obj.loadString(Ap_payd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_payd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_payd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_payd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_payd obj = new Ap_payd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_payd obj = new Ap_payd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_payd where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_payd extends Ap_paydAbst{
    private String applied="No";

    public Ap_payd() throws CodeException {
       
    }
    
    public Ap_payd(long id) throws CodeException {
        super(id);
    }
    
    public Ap_payd(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_payd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_payd(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        if (value==null){
            value="";
        }

        super.fromString(param, value);
    }


    @Override
    public void save() throws CodeException {
        if (getID()==NULLID||getID()==0) {
            this.setentrydate(GlobalUtils.getAuditDate());
        }
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }

    public int searchData(String vendcode, String docnum ) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select * from ap_payd where vendcode = '" + vendcode + "' and docnum = '" + docnum + "'";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                loadRs(rs);
            }else{
                loadNew();
            }

       } catch (SQLException ex) {
             throw new CodeException("ap_payd : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }


    public int getMaxTransnbr(int batchno,int docentry) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ap_payd where batchno=" + batchno+" and docentry="+docentry;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("ap_payd : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }



    public double getPayAmount() throws CodeException {
         DbBean db = DbBean.connect();
         double payamount = 0;
         try {

            String query = "select ifnull(sum(payamt),0) totalpayment from ap_payd "
                            + "\n inner join ap_paybatchlist  on ap_payd.batchno = ap_paybatchlist.batchno "
                            + "\n where vendcode = '" + this.getvendcode() + "' and doctype  = '" + this.getdoctype() + "' and docnum= '" + this.getdocnum() + "' ";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                payamount = rs.getInt("totalpayment");

            }

       } catch (SQLException ex) {
             throw new CodeException("ap_payd : " + ex.getMessage());
       }finally{
           db.close();
       }

       return payamount;
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




