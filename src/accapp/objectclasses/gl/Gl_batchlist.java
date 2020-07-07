/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_batchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_batchlist obj = new Gl_batchlist();
 * 
 * 2. Gl_batchlist obj = new Gl_batchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist(1);
 * 
 *    It Means : Select * from gl_batchlist where id = 1;
 * 
 * 3. Gl_batchlist obj = new Gl_batchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist(1);
 * 
 *    It Means : Select * from gl_batchlist where id = 1;
 * 
 * 4. Gl_batchlist obj = new Gl_batchlist(<primary_key>); 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist("1");
 *    It Means : Select * from gl_batchlist where <primary_key> = "1";
 * 
 * 5. Gl_batchlist obj = new Gl_batchlist(Gl_batchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist(Gl_batchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_batchlist where id = "1";
 * 
 * 6. Gl_batchlist obj = new Gl_batchlist();
 *    obj.loadString(Gl_batchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist();
 *    obj.loadString(Gl_batchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_batchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_batchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_batchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_batchlist obj = new Gl_batchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_batchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Gl_batchlist extends Gl_batchlistAbst{

    private Gl_jehs detail;

    private Integer dtlslctdindx=0;

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Gl_jehs getDetail() {
        return detail;
    }

    public Gl_batchlist() throws CodeException {
       detail=new Gl_jehs();
    }
    
    public Gl_batchlist(long id) throws CodeException {
        super(id);
    }
    
    public Gl_batchlist(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_batchlist(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_batchlist(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void adddetail(Gl_jeh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Gl_jehs gl_jehs) throws CodeException {
        this.detail.add(gl_jehs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
    }

    @Override
    public void delete() throws CodeException {
        Gl_jehs cbhhs = new Gl_jehs(Gl_jeh.PROPERTY_BATCHID, this.getbatchid()+"");
        cbhhs.delete();

        super.delete();
    }


    @Override
    public void saveNew() throws CodeException {
        Gl_optiondetail1 glopd=new Gl_optiondetail1(Gl_optiondetail1.PROPERTY_MODULID, "1");
        if (glopd.getID()>0){
            this.setbatchid(glopd.getdocnum());

            
            
            this.setentrydate(GlobalUtils.getAuditDate());
            this.setbatchtype("1");
            this.setbatchsts("1");

            this.setreadytpost("0");
            this.setbatchdate(GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd"));
            this.setsrceledgr("GL");
            super.saveNew();

            glopd.setdocnum(glopd.getdocnum()+1);
            glopd.save();
        } else {
            throw new CodeException("gl_batchlist: GL_Optiondetail1 not set, save canceled");
        }
    }


    @Override
    public void save() throws CodeException {
        this.setentrycnt(detail.list().size());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setcmpnyid(GlobalUtils.company);

        super.save();


        System.out.println("ukuran " + detail.size());

        for(Object o : detail.list()) {
            Gl_jeh oGl_jeh = (Gl_jeh) o;

            if (oGl_jeh.getID() == 0||oGl_jeh.getID()==NULLID) {
                oGl_jeh.setbtchentry(oGl_jeh.getMaxbtchentry((int)this.getbatchid()));
            }
            oGl_jeh.setbatchid(this.getbatchid());

            oGl_jeh.save();

        }

        this.setdebittot(this.getTotalDebit());
        this.setcredittot(this.getTotalKredit());

        super.save();

    }

    public int getMaxBatchid() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(batchid) is null then 1 else max(batchid) + 1 end nomor "
                            + "\n from gl_batchlist";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("gl_batchlist : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Gl_jeh ogl_jeh) throws CodeException {
        if (detail.size()>0){
            ogl_jeh=(Gl_jeh) detail.list().get(index);

            ogl_jeh=new Gl_jeh(ogl_jeh.getID());
        }
    }
    public void replaceDetail(int index, Gl_jeh ogl_jeh) throws CodeException {
        detail.list().set(index, ogl_jeh);
    }

    public void removeDetail(int index) throws CodeException {

        Gl_jeh ogl_jeh = (Gl_jeh) detail.list().get(index);
        ogl_jeh.delete();

        detail.list().remove(index);

        this.setentrycnt(detail.size());
        this.setcredittot(getTotalKredit());
        this.setdebittot(getTotalDebit());
        this.save();
    }

    /**
     * @return the dtlslctdindx
     */
    public Integer getDtlslctdindx() {
        return dtlslctdindx;
    }

    /**
     * @param dtlslctdindx the dtlslctdindx to set
     */
    public void setDtlslctdindx(Integer dtlslctdindx) {
        this.dtlslctdindx = dtlslctdindx;
    }

    public double getTotalDebit() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Gl_jeh cbhh = (Gl_jeh) o;
            totaldebit += cbhh.getTotalDebit();
        }

        return totaldebit;
    }

    public double getTotalKredit() throws CodeException {
        double totalkredit = 0;

        for (Object o: detail.list()){
            Gl_jeh cbhh = (Gl_jeh) o;
            totalkredit += cbhh.getTotalCredit();
        }

        return totalkredit;
    }

    public String getbatchtypedsc() throws CodeException{
        if (this.getbatchtype()==null){
            this.setbatchtype("1");
        }
        if (this.getbatchtype().equalsIgnoreCase("1")){
            return "Entered";
        }
        if (this.getbatchtype().equalsIgnoreCase("2")){
            return "Sub Ledger";
        }
        if (this.getbatchtype().equalsIgnoreCase("3")){
            return "Generated";
        }
        return "Entered";
    }

    public String getbatchstsdesc() throws CodeException{
        if (this.getbatchsts()==null){
            this.setbatchsts("1");
        }
        if (this.getbatchsts().equalsIgnoreCase("1")){
            return "Open";
        }
        if (this.getbatchsts().equalsIgnoreCase("2")){
            return "Posted";
        }
        if (this.getbatchsts().equalsIgnoreCase("3")){
            return "Error";
        }
        if (this.getbatchsts().equalsIgnoreCase("4")){
            return "Delete";
        }
        if (this.getbatchsts().equalsIgnoreCase("5")){
            return "Prov. Posted";
        }

        return "Open";
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
             throw new CodeException("gl_batchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update gl_batchlist set readytpost='"+ready+"' where batchid="+this.getbatchid();
           System.out.println(query);
            return query;
    }

    public Boolean posting(Integer batchsts) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getChangeStatus(batchsts));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("gl_batchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public Boolean doPosting(Boolean provpost,int sbatchidfr, int sbatchidto) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
                db.updateSQL(getDoPosting(provpost,sbatchidfr, sbatchidto));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("gl_batchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getChangeStatus(int batchsts) throws CodeException {
           String query = "update gl_batchlist set batchsts='"+batchsts+"' where batchid="+this.getbatchid();
           System.out.println(query);
            return query;
    }

    public String getDoPosting(Boolean provpost,int sbatchidfr, int sbatchidto) throws CodeException {
            String query="";
            if  (provpost){
                query = "call sp_gljournal_provposted ("+sbatchidfr+" ,"+sbatchidto+",'"+GlobalUtils.company+"','"+GlobalUtils.userid+"','Y')";
            } else {
                query = "call sp_gljournal_posted ("+sbatchidfr+" ,"+sbatchidto+",'"+GlobalUtils.company+"','"+GlobalUtils.userid+"')";
            }
            System.out.println(query);
            return query;
    }

    public boolean  checkGLJournalPosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM gl_batchlist  WHERE readytpost='1' AND batchsts IN ('1','5') ";
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

}




