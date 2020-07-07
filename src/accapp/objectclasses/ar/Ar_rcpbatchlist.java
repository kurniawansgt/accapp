/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcpbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcpbatchlist obj = new Ar_rcpbatchlist();
 * 
 * 2. Ar_rcpbatchlist obj = new Ar_rcpbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist(1);
 * 
 *    It Means : Select * from ar_rcpbatchlist where id = 1;
 * 
 * 3. Ar_rcpbatchlist obj = new Ar_rcpbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist(1);
 * 
 *    It Means : Select * from ar_rcpbatchlist where id = 1;
 * 
 * 4. Ar_rcpbatchlist obj = new Ar_rcpbatchlist(<primary_key>); 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist("1");
 *    It Means : Select * from ar_rcpbatchlist where <primary_key> = "1";
 * 
 * 5. Ar_rcpbatchlist obj = new Ar_rcpbatchlist(Ar_rcpbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist(Ar_rcpbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcpbatchlist where id = "1";
 * 
 * 6. Ar_rcpbatchlist obj = new Ar_rcpbatchlist();
 *    obj.loadString(Ar_rcpbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist();
 *    obj.loadString(Ar_rcpbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcpbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcpbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcpbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcpbatchlist obj = new Ar_rcpbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcpbatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_rcpbatchlist extends Ar_rcpbatchlistAbst{

    private Ar_rcphs detail;

    private Integer dtlslctdindx=0;

    public Ar_rcphs getDetail() {
        return detail;
    }

    public void setDetail(Ar_rcphs detail) {
        this.detail = detail;
    }

    public Integer getDtlslctdindx() {
        return dtlslctdindx;
    }

    public void setDtlslctdindx(Integer dtlslctdindx) {
        this.dtlslctdindx = dtlslctdindx;
    }

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Ar_rcpbatchlist() throws CodeException {
       detail=new Ar_rcphs();
    }

    public Ar_rcpbatchlist(long id) throws CodeException {
        super(id);
    }

    public Ar_rcpbatchlist(String val)  throws CodeException {
        super(val);
    }

    public Ar_rcpbatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ar_rcpbatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void adddetail(Ar_rcph obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ar_rcphs Ar_rcphs) throws CodeException {
        this.detail.add(Ar_rcphs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        /*Ar_rcphs cbhhs = new Ar_rcphs(Ar_rcph.PROPERTY_BATCHNO, this.getbatchno()+"");
        cbhhs.delete();

        super.delete();*/

        this.setbatchsts("4");
        this.save();
    }


    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getBatchNoAuto ());
        this.setentrydate(GlobalUtils.getAuditDate());

        this.setbatchsts("1");
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setrcpentrcnt(detail.list().size());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.settotrcpamt(this.getTotalAmount());
        super.save();

        for(Object o : detail.list()) {
            Ar_rcph oAr_rcph = (Ar_rcph) o;

            if (oAr_rcph.getID() == 0||oAr_rcph.getID()==NULLID) {
                oAr_rcph.setdocentry(oAr_rcph.getMaxbtchentry((int)this.getbatchno()));
            }
            oAr_rcph.setbatchno(this.getbatchno());

            oAr_rcph.save();

        }

        this.setrcpentrcnt(detail.size());
        this.settotrcpamt(this.getTotalAmount());
        this.setfuncamt(this.gettotrcpamt());
        super.save();

    }

    private Long getBatchNoAuto() throws CodeException{
        long docnum=0;
        Ar_optiionaldetail1 arop = new Ar_optiionaldetail1("2");
        if (arop.getdocnumid()>0){
            docnum=arop.getdocnum();
            docnum++;

            arop.setdocnum(docnum);
            arop.save();
        }
        return docnum;

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

    public void getdataDetail(int index, Ar_rcph oAr_rcph) throws CodeException {
        if (detail.size()>0){
            oAr_rcph=(Ar_rcph) detail.list().get(index);

            oAr_rcph=new Ar_rcph(oAr_rcph.getID());
        }
    }
    public void replaceDetail(int index, Ar_rcph oAr_rcph) throws CodeException {
        detail.list().set(index, oAr_rcph);
    }

    public void removeDetail(int index) throws CodeException {

        Ar_rcph oAr_rcph = (Ar_rcph) detail.list().get(index);
        oAr_rcph.delete();

        detail.list().remove(index);

        this.setrcpentrcnt(detail.list().size());
        this.save();
    }

    /**
     * @return the dtlslctdindx
     */


    public double getTotalAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ar_rcph cbhh = (Ar_rcph) o;
            totaldebit += cbhh.getdoctotalamt();
        }

        return totaldebit;
    }


    private String batchtypedesc(String batchtype){
        String result="";

        return result;

    }

    public Boolean posting() throws CodeException{
        for (Object o: this.detail.list()){
            Ar_rcph arrcph=(Ar_rcph) o;
            arrcph.postme(this);
        }

        Ar_optiionaldetail1 aroptd=new Ar_optiionaldetail1("11");
        aroptd.setdocnum(aroptd.getdocnum()+1);
        aroptd.save();

        this.setpostngseq(aroptd.getdocnum());
        this.setbatchsts("2");
        this.save();
        return true;
    }

    public boolean  checkARReceiptTransfer() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ar_rcpbatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public int runARReceipToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
            db.updateSQL(getARReceipToGl());
         } catch (Exception ex) {
             throw new CodeException("ar_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public String getARReceipToGl() throws CodeException {
           String query ="call sp_Create_ARRcpToGLBatch('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"')";
           return query;

    }

    public boolean  checkARReceiptPosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ar_rcpbatchlist  WHERE readytpost='1' AND batchsts='1' ";

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

    public Boolean runARReceiptPosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getARReceiptPosting(sbatchnofr ,sbatchnoto ));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ar_rcpbatchlist : " + ex.getMessage());
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
             throw new CodeException("ar_rcpbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ar_rcpbatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }



    public String getARReceiptPosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
           String query = "call sp_arreceiptposting("+sbatchnofr+","+sbatchnoto+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
           System.out.println(query);
            return query;
    }
}




