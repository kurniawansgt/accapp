/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_jehAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_jeh obj = new Gl_jeh();
 * 
 * 2. Gl_jeh obj = new Gl_jeh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh(1);
 * 
 *    It Means : Select * from gl_jeh where id = 1;
 * 
 * 3. Gl_jeh obj = new Gl_jeh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh(1);
 * 
 *    It Means : Select * from gl_jeh where id = 1;
 * 
 * 4. Gl_jeh obj = new Gl_jeh(<primary_key>); 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh("1");
 *    It Means : Select * from gl_jeh where <primary_key> = "1";
 * 
 * 5. Gl_jeh obj = new Gl_jeh(Gl_jeh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh(Gl_jeh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_jeh where id = "1";
 * 
 * 6. Gl_jeh obj = new Gl_jeh();
 *    obj.loadString(Gl_jeh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh();
 *    obj.loadString(Gl_jeh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_jeh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_jeh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_jeh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_jeh obj = new Gl_jeh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_jeh where id = 1;
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
public class Gl_jeh extends Gl_jehAbst{

    Gl_jeds detail;

    public Gl_jeds getDetail() {
        return detail;
    }

    public Gl_jeh() throws CodeException {
       detail=new Gl_jeds();

       this.setyop(GlobalUtils.getYear(GlobalUtils.sessiondate).longValue());
       this.setmop(GlobalUtils.getMonth(GlobalUtils.sessiondate));
    }
    
    public Gl_jeh(long id) throws CodeException {
        super(id);
    }
    
    public Gl_jeh(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_jeh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_jeh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Gl_jeds();
        detail.searchData(this.getbatchid(), this.getbtchentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Gl_jeds();
        detail.searchData(this.getbatchid(), this.getbtchentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(val);
        detail = new Gl_jeds();
        detail.searchData(this.getbatchid(), this.getbtchentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;
        
        super.fromString(param, value);
    }


    public void adddetail(Gl_jed obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Gl_jeds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    @Override
    public void saveNew() throws CodeException {
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        super.save();

        int i=detail.list().size()-1;
        while (i>=0){
            Gl_jed o=(Gl_jed) detail.list().get(i);
            if (o.getStatus()==3){
                o.delete();
                detail.list().remove(i);
            }
            i--;
        }

        for(Object o : detail.list()) {
            Gl_jed oGl_jed = (Gl_jed) o;

            if (oGl_jed.getID()==0) {
                oGl_jed.settransnbr(oGl_jed.getMaxTransnbr((int)this.getbatchid(),(int)this.getbtchentry()));
                oGl_jed.setbtchentry(this.getbatchid());
                oGl_jed.setjournalid(this.getbtchentry());
            }
            
            oGl_jed.setsrcelgrcode(this.getsrcelgrcode());
            oGl_jed.setsrcetypecode(this.getsrcetypecode());
            oGl_jed.save();

        }

        this.setjrnldebit(this.getTotalDebit());
        this.setjrnlcredit(this.getTotalCredit());
        super.save();

    }

    @Override
    public void delete() throws CodeException {
        detail = new Gl_jeds();
        detail.searchData(this.getbatchid(), this.getbtchentry());

        detail.delete();

        super.delete();
    }



    public int getMaxbtchentry(int batchid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(btchentry) is null then 1 else max(btchentry) + 1 end nomor "
                            + "\n from gl_jeh where batchid=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("gl_jeh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Gl_jed ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Gl_jed) detail.list().get(index);

            ogl_jed=new Gl_jed(ogl_jed.getID());
        }
    }
    public void replaceDetail(int index, Gl_jed ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Gl_batchlist obj) throws CodeException {

        Gl_jed ogl_jed = (Gl_jed) detail.list().get(index);

            ogl_jed.setStatus(3);
        

        //detail.list().remove(index);

        this.setjrnlcredit(getTotalCredit());
        this.setjrnldebit(getTotalDebit());

        //this.save();


        obj.setcredittot(obj.getTotalKredit());
        obj.setdebittot(obj.getTotalDebit());

        //obj.save();
    }

    public double getTotalDebit() throws CodeException{
        double totaldebit = 0;

        for (Object o : detail.list()) {

            Gl_jed cbd = (Gl_jed) o;
            try{

                if (cbd.gettransamtdbt() >= 0 && cbd.getStatus()!=3) {
                    totaldebit +=  cbd.gettransamtdbt();
                }

            }catch(Exception e) {}

        }

        return totaldebit;
    }

    public double getTotalCredit() throws CodeException{
        double totalkredit = 0;

        for (Object o : detail.list()) {

            Gl_jed cbd = (Gl_jed) o;
            try{

                if (cbd.gettransamtcrd() >= 0 && cbd.getStatus()!=3) {
                    totalkredit +=  cbd.gettransamtcrd();
                }

            }catch(Exception e) {}

        }

        return (Math.abs(totalkredit));
    }
}




