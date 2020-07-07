/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_batchhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_batchh obj = new Cb_batchh();
 * 
 * 2. Cb_batchh obj = new Cb_batchh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh(1);
 * 
 *    It Means : Select * from cb_batchh where id = 1;
 * 
 * 3. Cb_batchh obj = new Cb_batchh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh(1);
 * 
 *    It Means : Select * from cb_batchh where id = 1;
 * 
 * 4. Cb_batchh obj = new Cb_batchh(<primary_key>); 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh("1");
 *    It Means : Select * from cb_batchh where <primary_key> = "1";
 * 
 * 5. Cb_batchh obj = new Cb_batchh(Cb_batchh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh(Cb_batchh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_batchh where id = "1";
 * 
 * 6. Cb_batchh obj = new Cb_batchh();
 *    obj.loadString(Cb_batchh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh();
 *    obj.loadString(Cb_batchh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_batchh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_batchh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_batchh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_batchh obj = new Cb_batchh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_batchh where id = 1;
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
public class Cb_batchh extends Cb_batchhAbst{

    Cb_batchds cbhds;

    public Cb_batchh() throws CodeException {
        cbhds = new Cb_batchds();       
    }
    
    public Cb_batchh(long id) throws CodeException {
        super(id);
    }
    
    public Cb_batchh(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_batchh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_batchh(ResultSet rs) throws CodeException {
        super(rs);

    }

   public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        cbhds = new Cb_batchds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        cbhds = new Cb_batchds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(val);
        cbhds = new Cb_batchds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }

    public int getMaxEntryNo(double batchno) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(entryno) is null then 1 else max(entryno) + 1 end nomor "
                            + "\n from cb_batchh where batchno=" + batchno;

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

    //untuk cbhds
    public Cb_batchds getCbhds() {
        return cbhds;
    }

    public void setCbhds(Cb_batchds cbds) {
        this.cbhds = cbds;
    }

    public void addCbhd(Cb_batchd cbd) throws CodeException {
        cbhds.add(cbd);
    }

    public void addCbhds(Cb_batchds cbds) throws CodeException {
        this.cbhds.add(cbds);
    }


    public void replaceCbhd(int index, Cb_batchh cbhd) throws CodeException {
        cbhds.list().set(index, cbhd);
    }

    public void removeCbhd(int index) throws CodeException {
        Cb_batchd cbhd = (Cb_batchd) cbhds.list().get(index);
        cbhd.delete();

        cbhds.list().remove(index);


    }


    public void delete() throws CodeException {

        System.out.println("==2===");
        Cb_batchds cbhds = new Cb_batchds();
        cbhds.searchData(this.getbatchno(), this.getentryno());

        cbhds.delete();

        super.delete();

    }

    public String getvoucherno(String bankcode) throws CodeException {
        DbBean db = DbBean.connect();
         String entry = "";
         try {

            String query = "select fget_voucher_cb_no("+this.getyop()+","+this.getmop()+",'"+bankcode+"','"+this.getreference()+"')";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getString(1);

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_voucher : " + ex.getMessage());
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
        this.settotamount(getTotalDebit() - getTotalCredit());
        setobjtype(ObjectType.CB_BATCHH);

        super.save();


        try{
            for(Object o : cbhds.list()) {
                Cb_batchd cbhd = (Cb_batchd) o;

                if (cbhd.getID() == 0) {
                    cbhd.setdetailno(cbhd.getMaxDetailNo(this.getbatchno(), this.getentryno()));
                }
                cbhd.setacccode(cbhd.getacccode().replace("-",""));
                cbhd.setbatchno(this.getbatchno());
                cbhd.setentryno(this.getentryno());

                cbhd.save();

            }
        }catch(Exception e){}

    }


    public double getTotalDebit() throws CodeException{
        double totaldebit = 0;


        int i = 1;
        for (Object o : cbhds.list()) {


            Cb_batchd cbd = (Cb_batchd) o;
            try{

                if (cbd.getdetailamnt() >= 0) {
                    totaldebit +=  cbd.getdetailamnt() * cbd.getquantity();
                }

                //System.out.println("Hitung Total debit" + totaldebit);
            }catch(Exception e) {
                e.printStackTrace();
            }

        }

        return totaldebit;
    }

    public double getTotalCredit() throws CodeException{
        double totalkredit = 0;

        for (Object o : cbhds.list()) {

            Cb_batchd cbd = (Cb_batchd) o;
            try{

                if (cbd.getdetailamnt() < 0) {
                    totalkredit +=  cbd.getdetailamnt() * cbd.getquantity();
                }

                //System.out.println("Total Credit" + totalkredit);
            }catch(Exception e) {
                e.printStackTrace();
            }

        }

        return (Math.abs(totalkredit));
    }

}




