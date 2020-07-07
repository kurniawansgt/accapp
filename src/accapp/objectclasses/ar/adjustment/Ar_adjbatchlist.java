/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_adjbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_adjbatchlist obj = new Ar_adjbatchlist();
 * 
 * 2. Ar_adjbatchlist obj = new Ar_adjbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist(1);
 * 
 *    It Means : Select * from ar_adjbatchlist where id = 1;
 * 
 * 3. Ar_adjbatchlist obj = new Ar_adjbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist(1);
 * 
 *    It Means : Select * from ar_adjbatchlist where id = 1;
 * 
 * 4. Ar_adjbatchlist obj = new Ar_adjbatchlist(<primary_key>); 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist("1");
 *    It Means : Select * from ar_adjbatchlist where <primary_key> = "1";
 * 
 * 5. Ar_adjbatchlist obj = new Ar_adjbatchlist(Ar_adjbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist(Ar_adjbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_adjbatchlist where id = "1";
 * 
 * 6. Ar_adjbatchlist obj = new Ar_adjbatchlist();
 *    obj.loadString(Ar_adjbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist();
 *    obj.loadString(Ar_adjbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_adjbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_adjbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_adjbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_adjbatchlist obj = new Ar_adjbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_adjbatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar.adjustment;

import accapp.objectclasses.ar.Ar_optiionaldetail1;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_adjbatchlist extends Ar_adjbatchlistAbst{
    private  Ar_adjhs detail;
    private Integer dtlslctdindx=0;

    public Ar_adjbatchlist() throws CodeException {
       detail = new Ar_adjhs();
    }

    public Ar_adjbatchlist(long id) throws CodeException {
        super(id);
    }

    public Ar_adjbatchlist(String val)  throws CodeException {
        super(val);
    }

    public Ar_adjbatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ar_adjbatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }

    public Ar_adjhs getDetail() {
        return detail;
    }

    public void setDetail(Ar_adjhs detail) {
        this.detail = detail;
    }

    public Integer getDtlslctdindx() {
        return dtlslctdindx;
    }

    public void setDtlslctdindx(Integer dtlslctdindx) {
        this.dtlslctdindx = dtlslctdindx;
    }
    public void adddetail(Ar_adjh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ar_adjhs Ar_adjhs) throws CodeException {
        this.detail.add(Ar_adjhs);
    }
    public void getdataDetail(int index, Ar_adjh oAr_adjh) throws CodeException {
        if (detail.size()>0){
            oAr_adjh=(Ar_adjh) detail.list().get(index);

            oAr_adjh=new Ar_adjh(oAr_adjh.getID());
        }
    }
    public void replaceDetail(int index, Ar_adjh oAr_adjh) throws CodeException {
        detail.list().set(index, oAr_adjh);
    }

    public void removeDetail(int index) throws CodeException {

        Ar_adjh oAr_adjh = (Ar_adjh) detail.list().get(index);
        oAr_adjh.delete();

        detail.list().remove(index);

        this.setpayentrcnt(detail.list().size());
        this.save();
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        try{
            Ar_adjhs cbhhs = new Ar_adjhs(Ar_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
            cbhhs.delete();
        }catch(Exception e) {}

        super.delete();
    }


    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getBatchNoAuto ());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setswprinted("1");
        this.setglpostedsts("0");
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {

        this.setpayentrcnt(detail.list().size());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.settotpayamt(this.getTotalAmount());
        super.save();

        for(Object o : detail.list()) {
            Ar_adjh oAr_adjh = (Ar_adjh) o;

            if (oAr_adjh.getID() == 0||oAr_adjh.getID()==NULLID) {
                oAr_adjh.setdocentry(oAr_adjh.getMaxbtchentry((int)this.getbatchno()));
            }
            oAr_adjh.setbatchno(this.getbatchno());

            if (oAr_adjh.getadjno() == 0) {
                Ar_optiionaldetail1 apo = new Ar_optiionaldetail1(Ar_optiionaldetail1.PROPERTY_DOCNUMID, "3");
                oAr_adjh.setadjno(apo.getdocnum() + 1);
                apo.setdocnum(apo.getdocnum() + 1);
                apo.save();
            }

            oAr_adjh.save();

        }

        this.setpayentrcnt(detail.size());
        this.settotpayamt(this.getTotalPayAmount());
        this.setfuncamt(this.gettotpayamt());
        super.save();

    }
    public double getTotalPayAmount() throws CodeException {
        double totaldebit = 0;

        try{
            for (Object o: detail.list()){
                Ar_adjh cbhh = (Ar_adjh) o;
                totaldebit += cbhh.getDetailAmt();
            }
        }catch(Exception e) {}


        return totaldebit;
    }

    private Long getBatchNoAuto() throws CodeException{
        long docnum=0;
        Ar_optiionaldetail1 apop = new Ar_optiionaldetail1("3");
        if (apop.getdocnumid()>0){
            docnum=apop.getdocnum();
            docnum++;

            apop.setdocnum(docnum);
            apop.save();
        }
        return docnum;

    }
    public double getTotalAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ar_adjh cbhh = (Ar_adjh) o;
            totaldebit += cbhh.getadjusttot();
        }

        return totaldebit;
    }
    public String getstatusdescription() throws CodeException{
        String result="Open";
        if (this.getbatchsts()!=null){
            if (this.getbatchsts().equalsIgnoreCase("1")){
                result="Open";
            }
            if (this.getbatchsts().equalsIgnoreCase("2")){
                result="Posted";
            }
            if (this.getbatchsts().equalsIgnoreCase("3")){
                result="Error";
            }
            if (this.getbatchsts().equalsIgnoreCase("4")){
                 result="Delete";
            }
        }
        return result;
    }
    public String gettypedescription() throws CodeException{
        String result="Entries";
        if (this.getbatchtype()!=null){
            if (this.getbatchtype().equalsIgnoreCase("1")){
                result="Entries";
            }
            if (this.getbatchtype().equalsIgnoreCase("2")){
                result="Import";
            }
            if (this.getbatchtype().equalsIgnoreCase("3")){
                 result="Genered";
            }
        }
        return result;
    }


    public Boolean posting() throws CodeException{
        DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getsp_aradjustposting_bybatchno());
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ar_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

        return result;
    }

    public String getsp_aradjustposting_bybatchno() throws CodeException {
           String query ="call sp_aradjustposting_bybatchno("+this.getbatchno()+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"')";
           return query;

    }

    public boolean  checkARAdjustmentTransfer() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ar_adjbatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

         try {
               ResultSet rs = db.executeQuery(query);
               if (rs.next()) {
                   if (rs.getInt(1) > 0) {
                       return true;
                   }else {
                       return false;
                   }
               }else{
                   return false;
               }
         }catch(SQLException e) {
             return false;
         }
    }

    public int runARAdjustmentToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
            db.updateSQL(getARAdjustmentToGl_batchlist());
         } catch (Exception ex) {
             throw new CodeException("Ar_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public String getARAdjustmentToGl_batchlist() throws CodeException {
        String query = "call sp_create_aradjustment_to_glbatch('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
        return query;

    }

    public boolean  checkARAdjustmentPosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ar_adjbatchlist  WHERE readytpost='1' AND batchsts='1' ";

         try {
               ResultSet rs = db.executeQuery(query);
               if (rs.next()) {
                   if (rs.getInt(1) > 0) {
                       return true;
                   }else {
                       return false;
                   }
               }else{
                   return false;
               }
         }catch(SQLException e) {
             return false;
         }
    }

    public Boolean runARAdjustmentPosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getAPInvoicePosting(sbatchnofr ,sbatchnoto ));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ar_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public Boolean ReadtoPostMe(Boolean ready) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            if (ready){
                db.updateSQL(getReadyToPostMe(1));
             } else {
                db.updateSQL(getReadyToPostMe(0));
             }
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ar_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ar_adjbatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }



    public String getAPInvoicePosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
           String query = "call sp_aradjustmentposting("+sbatchnofr+","+sbatchnoto+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
           System.out.println(query);
            return query;
    }
    
}




