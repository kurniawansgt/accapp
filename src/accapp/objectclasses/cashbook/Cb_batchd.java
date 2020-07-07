/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_batchdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_batchd obj = new Cb_batchd();
 * 
 * 2. Cb_batchd obj = new Cb_batchd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd(1);
 * 
 *    It Means : Select * from cb_batchd where id = 1;
 * 
 * 3. Cb_batchd obj = new Cb_batchd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd(1);
 * 
 *    It Means : Select * from cb_batchd where id = 1;
 * 
 * 4. Cb_batchd obj = new Cb_batchd(<primary_key>); 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd("1");
 *    It Means : Select * from cb_batchd where <primary_key> = "1";
 * 
 * 5. Cb_batchd obj = new Cb_batchd(Cb_batchd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd(Cb_batchd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_batchd where id = "1";
 * 
 * 6. Cb_batchd obj = new Cb_batchd();
 *    obj.loadString(Cb_batchd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd();
 *    obj.loadString(Cb_batchd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_batchd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_batchd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_batchd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_batchd obj = new Cb_batchd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_batchd where id = 1;
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
public class Cb_batchd extends Cb_batchdAbst{

    Cb_batchsds cbhds;
   
    public Cb_batchd() throws CodeException {
       cbhds = new Cb_batchsds();
    }
    
    public Cb_batchd(long id) throws CodeException {
        super(id);
    }
    
    public Cb_batchd(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_batchd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_batchd(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        cbhds = new Cb_batchsds();
        cbhds.searchData(this.getbatchno(), this.getentryno(), (long) this.getdetailno());
    }

    public void loadID(long id) throws CodeException {
        super.loadID(id);

        cbhds = new Cb_batchsds();
        cbhds.searchData(this.getbatchno(), this.getentryno(), (long) this.getdetailno());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(val);

        cbhds = new Cb_batchsds();
        cbhds.searchData(this.getbatchno(), this.getentryno(), (long) this.getdetailno());
    }

    public Cb_batchsds getCbhds() {
        return cbhds;
    }

    public void setCbhsds(Cb_batchsds cbds) {
        this.cbhds = cbds;
    }

    public void addCbhd(Cb_batchsd cbd) throws CodeException {
        cbhds.add(cbd);
    }

    public void addCbhds(Cb_batchsds cbds) throws CodeException {
        this.cbhds.add(cbds);
    }


    public void replaceCbhd(int index, Cb_batchsd cbhd) throws CodeException {
        cbhds.list().set(index, cbhd);
    }

    public void removeCbhd(int index) throws CodeException {
        Cb_batchsd cbhd = (Cb_batchsd) cbhds.list().get(index);
        cbhd.delete();

        cbhds.list().remove(index);


    }


    public void delete() throws CodeException {

        System.out.println("==2===");

        cbhds = new Cb_batchsds();
        cbhds.searchData(this.getbatchno(), this.getentryno(), (long) this.getdetailno());

        cbhds.delete();

        if (getID() != NULLID){
            super.delete();
        }

    }

    public Cb_source getSource() throws CodeException {

        Cb_source cbsource = new Cb_source(this.getsrcecode());
        
        return cbsource;
    }


     public int getMaxDetailNo(double batchno, long entryno) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(detailno) is null then 1 else max(detailno) + 1 end nomor "
                            + "\n from cb_batchd where batchno=" + batchno + " and entryno=" + entryno;

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
        setobjtype(ObjectType.CB_BATCHD);

        super.save();

         try{
            for(Object o : cbhds.list()) {
                Cb_batchsd cbhd = (Cb_batchsd) o;

                if (cbhd.getID()>0){
                    cbhd.setApplied("Yes");
                }
                
                if (cbhd.getApplied().equalsIgnoreCase("Yes")){
                    if (cbhd.getID() == 0) {
                        cbhd.setsubdetailno(cbhd.getMaxDetailNo(this.getbatchno(), this.getentryno(), (long) this.getdetailno()));
                    }

                    cbhd.setbatchno(this.getbatchno());
                    cbhd.setentryno(this.getentryno());
                    cbhd.setdetailno(this.getdetailno());
                    cbhd.setdoctype(cbhd.getdesctodoctype());

                    if (cbhd.getapplamount()!=0){
                        cbhd.save();
                    } else {
                        cbhd.delete();
                    }
                } 

            }

        }catch(Exception e){}
    }
}




