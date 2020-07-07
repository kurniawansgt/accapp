/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 * This class is inhereted from Cb_voucherAbst that handle CRUD
    (Create/Insert Read Update Delete)
 *
 * How To Use This Class to Read Data or make instance
 * 1. Cb_voucher obj = new Cb_voucher();
 *
 * 2. Cb_voucher obj = new Cb_voucher(<id>); // <id> = number of id
 *
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher(1);
 *
 *    It Means : Select * from Cb_voucher where id = 1;
 *
 * 3. Cb_voucher obj = new Cb_voucher();
 *    obj.loadID(1);
 *
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher(1);
 *
 *    It Means : Select * from Cb_voucher where id = 1;
 *
 * 4. Cb_voucher obj = new Cb_voucher(<primary_key>);
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher("1");
 *    It Means : Select * from Cb_voucher where <primary_key> = "1";
 *
 * 5. Cb_voucher obj = new Cb_voucher(Cb_voucher.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher(Cb_voucher.PROPERTY_ID, "1");
 *
 *    It Means : Select * from Cb_voucher where id = "1";
 *
 * 6. Cb_voucher obj = new Cb_voucher();
 *    obj.loadString(Cb_voucher.PROPERTY_<field>, <value>)
 *
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher();
 *    obj.loadString(Cb_voucher.PROPERTY_ID, "1")
 *
 *    It Means : Select * from Cb_voucher where id = "1";
 *
 * 7. User Recordset
 *
 *    Sample :
 *
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM Cb_voucher Where id = 1" ;
 *
        try {
            ResultSet rs = db.executeQuery(sql);

            if(rs.next()) {
                loadRs(rs);
            }


        } catch (SQLException ex) {
            throw new CodeException("Cb_voucher : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 *
 * 8. Save Data
 *
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 *
 *
 *    if the id == 0 then save new else save update
 *
 * 9. Delete
 *
 *    Sample :
 *    Cb_voucher obj = new Cb_voucher(1);
 *    obj.delete();
 *
 *
 *    It Means : Delete from Cb_voucher where id = 1;
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
public class Cb_voucher extends Cb_voucherAbst{

    Cb_voucherds cbhds;
    private Cb_vouchersds ocb_vouchersds;

    public Cb_voucher() throws CodeException {
        cbhds = new Cb_voucherds();

        this.setdocstatus("O");
        this.setdoctype("P");
    }

    public Cb_voucher(long id) throws CodeException {
        super(id);

        this.setdocstatus("O");
        this.setdoctype("P");
    }

    public Cb_voucher(String val)  throws CodeException {
        super(val);

        this.setdocstatus("O");
        this.setdoctype("P");
    }

    public Cb_voucher(String key, String val)  throws CodeException {
        super(key, val);

        this.setdocstatus("O");
        this.setdoctype("P");
    }

    public Cb_voucher(ResultSet rs) throws CodeException {
        super(rs);

        this.setdocstatus("O");
        this.setdoctype("P");
    }

   public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        cbhds = new Cb_voucherds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        cbhds = new Cb_voucherds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        cbhds = new Cb_voucherds();
        cbhds.searchData(this.getbatchno(), this.getentryno());
    }

    public int getMaxEntryNo(double batchno) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(entryno) is null then 1 else max(entryno) + 1 end nomor "
                            + "\n from cb_voucher where batchno=" + batchno;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_voucher : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    //untuk cbhds
    public Cb_voucherds getCbhds() {
        return cbhds;
    }

    public void setCbhds(Cb_voucherds cbds) {
        this.cbhds = cbds;
    }

    public void addCbhd(Cb_voucherd cbd) throws CodeException {
        cbhds.add(cbd);
    }

    public void addCbhds(Cb_voucherds cbds) throws CodeException {
        this.cbhds.add(cbds);
    }


    public void replaceCbhd(int index, Cb_voucher cbhd) throws CodeException {
        cbhds.list().set(index, cbhd);
    }

    public void removeCbhd(int index) throws CodeException {
        Cb_voucherd cbhd = (Cb_voucherd) cbhds.list().get(index);
        cbhd.delete();

        cbhds.list().remove(index);


    }


    public void delete() throws CodeException {

        System.out.println("==2===");
        Cb_voucherds cbhds = new Cb_voucherds();
        cbhds.searchData(this.getbatchno(), this.getentryno());

        cbhds.delete();

        super.delete();

    }



    public void save() throws CodeException {

        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
            this.setbatchno(0);
            this.setentryno(this.getMaxEntryNo(0));
            this.setreference(getvoucherno());
        }
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setcmpnyid(GlobalUtils.company);
        this.settotamount(getTotalDebit() - getTotalCredit());
        setobjtype(ObjectType.CB_VOUCHER);

        super.save();


        try{
            for(Object o : cbhds.list()) {
                Cb_voucherd cbhd = (Cb_voucherd) o;

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


            Cb_voucherd cbd = (Cb_voucherd) o;
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

            Cb_voucherd cbd = (Cb_voucherd) o;
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

    @Override
    public void moveFirst() throws CodeException {
        super.moveFirst();

        this.cbhds=new Cb_voucherds();
        this.cbhds.searchData(this.getbatchno(), this.getentryno());
        
    }



    @Override
    public void movePrevious() throws CodeException {
        super.movePrevious();

        this.cbhds=new Cb_voucherds();
        this.cbhds.searchData(this.getbatchno(), this.getentryno());
    }



    @Override
    public void moveNext() throws CodeException {
        super.moveNext();

        this.cbhds=new Cb_voucherds();
        this.cbhds.searchData(this.getbatchno(), this.getentryno());
    }


    @Override
    public void moveLast() throws CodeException {
        super.moveLast();

        this.cbhds=new Cb_voucherds();
        this.cbhds.searchData(this.getbatchno(), this.getentryno());
    }

    private String getvoucherno() throws CodeException {
        DbBean db = DbBean.connect();
         String entry = "";
         try {

            String query = "select fget_voucher_no("+this.getyop()+","+this.getmop()+",'"+this.getdoctype()+"','"+this.getbankcode()+"')";

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

    public void closestatus() throws CodeException {
        DbBean db=DbBean.connect();

        String query="update cb_voucher set docstatus='C' where id="+this.getID();
        db.updateSQL(query);
        

    }



}




