/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_pjhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_pjh obj = new Cb_pjh();
 * 
 * 2. Cb_pjh obj = new Cb_pjh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh(1);
 * 
 *    It Means : Select * from cb_pjh where id = 1;
 * 
 * 3. Cb_pjh obj = new Cb_pjh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh(1);
 * 
 *    It Means : Select * from cb_pjh where id = 1;
 * 
 * 4. Cb_pjh obj = new Cb_pjh(<primary_key>); 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh("1");
 *    It Means : Select * from cb_pjh where <primary_key> = "1";
 * 
 * 5. Cb_pjh obj = new Cb_pjh(Cb_pjh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh(Cb_pjh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_pjh where id = "1";
 * 
 * 6. Cb_pjh obj = new Cb_pjh();
 *    obj.loadString(Cb_pjh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh();
 *    obj.loadString(Cb_pjh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_pjh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_pjh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_pjh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_pjh obj = new Cb_pjh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_pjh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_jed;
import accapp.objectclasses.gl.Gl_jeh;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Cb_pjh extends Cb_pjhAbst{
    public Cb_pjh() throws CodeException {
       
    }
    
    public Cb_pjh(long id) throws CodeException {
        super(id);
    }
    
    public Cb_pjh(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_pjh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_pjh(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }


    public int getMaxEntryNo(double pseqno) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(pseqentry) is null then 1 else max(pseqentry) + 1 end nomor "
                            + "\n from cb_pjh where pseqno=" + pseqno;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Cb_pjh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public Boolean transfertoGL(Gl_batchlist glbatchl,Cb_bank cbbank) throws CodeException{
        Cb_pjds cbpjdsall=new Cb_pjds();
        cbpjdsall.searchData(this.getbatchno());

        int i=0;
        double entryno1=0;
        double entryno2=0;


        Gl_jeh gljeh=new Gl_jeh();
        gljeh.fromString(Gl_jeh.PROPERTY_BTCHENTRYDATE, GlobalUtils.getCurrentDate());
        gljeh.setsrcelgrcode("CB");
        gljeh.setsrcetypecode("CB");
        gljeh.setyop(GlobalUtils.toInt(GlobalUtils.getCurrentYear()));
        gljeh.setmop(GlobalUtils.toInt(GlobalUtils.getCurrentMonth()));
        gljeh.setswedit(1);
        gljeh.setswreverse(1);
        gljeh.setjrnldesc(this.getdscription());
	gljeh.setjrnldebit(0);
        gljeh.setjrnlcredit(0);
        gljeh.setjrnlquantity(0);

        Double ttldtlamnt=new Double(0);
        for (Object o:cbpjdsall.list()){
            Cb_pjd cbpjd=(Cb_pjd) o;
            if (i==0){
                entryno1=cbpjd.getentryno();
                entryno2=cbpjd.getentryno();

                ttldtlamnt=ttldetailamnt(entryno2);
                adddetailBank(cbbank, glbatchl, gljeh,ttldtlamnt);
            }
            i++;
            entryno2=cbpjd.getentryno();
            if (entryno1!=entryno2){
                entryno1=entryno2;

                glbatchl.adddetail(gljeh);

                gljeh=new Gl_jeh();
                gljeh.fromString(Gl_jeh.PROPERTY_BTCHENTRYDATE, GlobalUtils.getCurrentDate());
                gljeh.setsrcelgrcode("CB");
                gljeh.setsrcetypecode("CB");
                gljeh.setyop(GlobalUtils.toInt(GlobalUtils.getCurrentYear()));
                gljeh.setmop(GlobalUtils.toInt(GlobalUtils.getCurrentMonth()));
                gljeh.setswedit(1);
                gljeh.setswreverse(1);
                gljeh.setjrnldesc(this.getdscription());
                gljeh.setjrnldebit(0);
                gljeh.setjrnlcredit(0);
                gljeh.setjrnlquantity(0);

                ttldtlamnt=ttldetailamnt(entryno2);
                adddetailBank(cbbank, glbatchl, gljeh,ttldtlamnt);

                adddetail(cbbank,glbatchl,gljeh,cbpjd);
            } else {
                adddetail(cbbank,glbatchl,gljeh,cbpjd);
            }
        }


        glbatchl.adddetail(gljeh);
        
        return true;
    }

    private Double ttldetailamnt(Double entryno) throws CodeException{
        Cb_pjds cbpjds=new Cb_pjds();
        cbpjds.searchData(this.getbatchno(),entryno);

        Double ttl=new Double(0);
        for (Object o:cbpjds.list()){
            Cb_pjd cbpjd=(Cb_pjd) o;
            if (cbpjd.getentryno()==entryno){
                ttl=ttl+cbpjd.getdetailamnt();
            } else {
                return ttl;
            }
        }
        return ttl;
    }
    private Boolean adddetailBank(Cb_bank cbbank,Gl_batchlist glbatchl,Gl_jeh gljeh,Double ttldetailamnt) throws CodeException{

        Gl_jed gljed=new Gl_jed();
        gljed.setacccode(cbbank.getbankacccode());
        gljed.settransqty(1);
        gljed.setcurnccode(this.getglhomecrncy());
        gljed.setsrcecurnccode(this.getglsrcecrncy());
        gljed.setratetype(this.getglratetype());
        gljed.setrate(this.getbankglrate());

        if (ttldetailamnt<0){
            gljed.settransamtdbt(Math.abs(ttldetailamnt));
        } else {
            gljed.settransamtcrd(Math.abs(ttldetailamnt));
        }
        gljed.setfuncamtdbt(0);
        gljed.setfuncamtcrd(0);
        gljed.settransdesc(this.getdscription());
        gljed.settransref(this.getreference());
        gljed.settransdate(GlobalUtils.formatDate(GlobalUtils.getCurrentDate(),"yyyy-MM-dd"));
        gljed.setsrcelgrcode("CB");
        gljed.setsrcetypecode("CB");
        gljed.setjecomment("");

        gljeh.adddetail(gljed);

        return true;
    }

    private Boolean adddetail(Cb_bank cbbank,Gl_batchlist glbatchl,Gl_jeh gljeh,Cb_pjd cbpjd) throws CodeException{


        Gl_jed gljed=new Gl_jed();
        gljed.setacccode(cbpjd.getacccode());
        gljed.settransqty(1);
        gljed.setcurnccode(this.getglhomecrncy());
        gljed.setsrcecurnccode(this.getglsrcecrncy());
        gljed.setratetype(this.getglratetype());
        gljed.setrate(this.getbankglrate());

        if (cbpjd.getdetailamnt()>0){
            gljed.settransamtdbt(Math.abs(cbpjd.getdetailamnt()));
            gljed.settransamtcrd(0);
        } else {
            gljed.settransamtcrd(Math.abs(cbpjd.getdetailamnt()));
            gljed.settransamtdbt(0);
        }

        gljed.setfuncamtdbt(0);
        gljed.setfuncamtcrd(0);
        gljed.settransdesc(this.getdscription());
        gljed.settransref(this.getreference());
        gljed.settransdate(GlobalUtils.formatDate(GlobalUtils.getCurrentDate(),"yyyy-MM-dd"));
        gljed.setsrcelgrcode("CB");
        gljed.setsrcetypecode("CB");
        gljed.setjecomment("");

        gljeh.adddetail(gljed);


        return true;
    }
    
}




