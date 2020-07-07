/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_invhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_invh obj = new Ap_invh();
 * 
 * 2. Ap_invh obj = new Ap_invh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_invh obj = new Ap_invh(1);
 * 
 *    It Means : Select * from ap_invh where id = 1;
 * 
 * 3. Ap_invh obj = new Ap_invh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_invh obj = new Ap_invh(1);
 * 
 *    It Means : Select * from ap_invh where id = 1;
 * 
 * 4. Ap_invh obj = new Ap_invh(<primary_key>); 
 *    Sample :
 *    Ap_invh obj = new Ap_invh("1");
 *    It Means : Select * from ap_invh where <primary_key> = "1";
 * 
 * 5. Ap_invh obj = new Ap_invh(Ap_invh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_invh obj = new Ap_invh(Ap_invh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_invh where id = "1";
 * 
 * 6. Ap_invh obj = new Ap_invh();
 *    obj.loadString(Ap_invh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_invh obj = new Ap_invh();
 *    obj.loadString(Ap_invh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_invh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_invh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_invh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_invh obj = new Ap_invh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_invh obj = new Ap_invh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_invh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;


import accapp.objectclasses.ar.Ar_invobp;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windu
 */
public class Ap_invh extends Ap_invhAbst{

    Ap_invds detail;

    public Ap_invds getDetail() {
        return detail;
    }

    public Ap_invh() throws CodeException {
       detail=new Ap_invds();
    }
    
    public Ap_invh(long id) throws CodeException {
        super(id);
    }
    
    public Ap_invh(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_invh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_invh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ap_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ap_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ap_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ap_invd obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Ap_invds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setdocnum(this.getFormatedDocNum());
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setdoctotalamt(this.getDetailAmt());
        this.setdoctotalafttaxamt(this.getdoctotalamt()+this.gettaxtotalamt());
        super.save();

        for(Object o : detail.list()) {
            Ap_invd oap_invd = (Ap_invd) o;
            if (oap_invd.getdetailamt()!=0){
                if (oap_invd.getID()==0) {
                    oap_invd.setlinenum(oap_invd.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                }
                oap_invd.setbatchno(this.getbatchno());
                oap_invd.setdocentry(this.getdocentry());

                oap_invd.save();
            }
        }


    }

    @Override
    public void delete() throws CodeException {
        detail = new Ap_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail.delete();

        super.delete();
    }



    public int getMaxbtchentry(int batchid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(docentry) is null then 1 else max(docentry) + 1 end nomor "
                            + "\n from ap_invh where batchno=" + batchid;

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

    public void getdataDetail(int index, Ap_invd ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Ap_invd) detail.list().get(index);

            ogl_jed=new Ap_invd(ogl_jed.getID());
        }
    }
    public void replaceDetail(int index, Ap_invd ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Ap_invbatchlist obj) throws CodeException {

        try {
        Ap_invd ogl_jed = (Ap_invd) detail.list().get(index);
        ogl_jed.delete();
        }catch(Exception e) {}

        detail.list().remove(index);

        obj.settotinvamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double totalkredit = 0;

        for (Object o : detail.list()) {

            Ap_invd cbd = (Ap_invd) o;
            try{
               totalkredit +=  cbd.getdetailamt();
            }catch(Exception e) {}

        }

        return (Math.abs(totalkredit));
    }

    private String getFormatedDocNum() throws CodeException{
        if (!this.getdocnum().equalsIgnoreCase("")){
            return this.getdocnum();
        }
        Ap_optionaldetail1 arop = new Ap_optionaldetail1("1");
        int i=0;
        String docnum="";
        for(i=0;i<arop.getlengthno();i++){
            if (i<arop.gettxtprefix().length()){
                docnum=arop.gettxtprefix();
            } else {
                if (i<arop.getlengthno()-GlobalUtils.churuf(arop.getdocnum()).length()){
                    docnum=docnum+"0";
                } else {
                    docnum=docnum+(arop.getdocnum()+1);
                    break;
                }
            }
        }
        if (!docnum.equalsIgnoreCase("")){
            arop.setdocnum(arop.getdocnum()+1);
            arop.save();

        }
        return docnum;

    }

    public Boolean postme(Ap_invbatchlist apinvbatch) throws CodeException {
       Ap_vendor apvendor=new Ap_vendor(this.getvendcode());

        if (apvendor.getID()>0){
           switch (GlobalUtils.toInt(this.getdoctype())){
                case 4: case 7:
                    postme47(apinvbatch,apvendor);
                    break;
               case 5:
                   postme5(apinvbatch,apvendor);
                   break;
               case 6:
                   postme6(apinvbatch,apvendor);
                   break;
           }

            Ap_vendorsts apvendorsts=new Ap_vendorsts();
            apvendorsts.searchData(String.valueOf(this.getyop()),String.valueOf(this.getmop()),this.getvendcode());

            apvendorsts.setyop(this.getyop());
            apvendorsts.setmop(this.getmop());
            apvendorsts.setvendcode(this.getvendcode());
            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("4")){
                apvendorsts.setinvcnt(apvendorsts.getinvcnt()+1);
                apvendorsts.setinvamt(apvendorsts.getinvamt()+this.getdoctotalafttaxamt());
            } else {
                apvendorsts.setinvcnt(apvendorsts.getinvcnt()+0);
                apvendorsts.setinvamt(apvendorsts.getinvamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("5")){
                apvendorsts.setdncnt(apvendorsts.getdncnt()+1);
                apvendorsts.setdnamt(apvendorsts.getdnamt()+this.getdoctotalafttaxamt());
            } else {
                apvendorsts.setdncnt(apvendorsts.getdncnt()+0);
                apvendorsts.setdnamt(apvendorsts.getdnamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("6")){
                apvendorsts.setcncnt(apvendorsts.getcncnt()+1);
                apvendorsts.setcnamt(apvendorsts.getcnamt()+this.getdoctotalafttaxamt());
            } else {
                apvendorsts.setcncnt(apvendorsts.getcncnt()+0);
                apvendorsts.setcnamt(apvendorsts.getcnamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("7")){
                apvendorsts.setinttcnt(apvendorsts.getinttcnt()+1);
                apvendorsts.setinttamt(apvendorsts.getinttamt()+this.getdoctotalafttaxamt());
            } else {
                apvendorsts.setinttcnt(apvendorsts.getinttcnt()+0);
                apvendorsts.setinttamt(apvendorsts.getinttamt()+0);
            }
            apvendorsts.save();


            Ap_vendgrpsts apvendgrpsts=new Ap_vendgrpsts();
            apvendgrpsts.searchData(String.valueOf(this.getyop()),String.valueOf(this.getmop()),apvendor.getgrpcode());

            apvendgrpsts.setyop(this.getyop());
            apvendgrpsts.setmop(this.getmop());
            apvendgrpsts.setgrpcode(apvendor.getgrpcode());
            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("4")){
                apvendgrpsts.setinvcnt(apvendgrpsts.getinvcnt()+1);
                apvendgrpsts.setinvamt(apvendgrpsts.getinvamt()+this.getdoctotalafttaxamt());
            } else {
                apvendgrpsts.setinvcnt(apvendgrpsts.getinvcnt()+0);
                apvendgrpsts.setinvamt(apvendgrpsts.getinvamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("5")){
                apvendgrpsts.setdncnt(apvendgrpsts.getdncnt()+1);
                apvendgrpsts.setdnamt(apvendgrpsts.getdnamt()+this.getdoctotalafttaxamt());
            } else {
                apvendgrpsts.setdncnt(apvendgrpsts.getdncnt()+0);
                apvendgrpsts.setdnamt(apvendgrpsts.getdnamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("6")){
                apvendgrpsts.setcncnt(apvendgrpsts.getcncnt()+1);
                apvendgrpsts.setcnamt(apvendgrpsts.getcnamt()+this.getdoctotalafttaxamt());
            } else {
                apvendgrpsts.setcncnt(apvendgrpsts.getcncnt()+0);
                apvendgrpsts.setcnamt(apvendgrpsts.getcnamt()+0);
            }

            if(String.valueOf(this.getdoctype()).equalsIgnoreCase("7")){
                apvendgrpsts.setinttcnt(apvendgrpsts.getinttcnt()+1);
                apvendgrpsts.setinttamt(apvendgrpsts.getinttamt()+this.getdoctotalafttaxamt());
            } else {
                apvendgrpsts.setinttcnt(apvendgrpsts.getinttcnt()+0);
                apvendgrpsts.setinttamt(apvendgrpsts.getinttamt()+0);
            }
            apvendgrpsts.save();
        }




        return false;
    }

    public Boolean postme47(Ap_invbatchlist apinvbatch,Ap_vendor apvendor) throws CodeException {
        Ap_invobl apinvobl=new Ap_invobl();

        apinvobl.searchData(this.getvendcode(), this.getdocnum());

        
        apinvobl.setvendcode(this.getvendcode());
        apinvobl.setaddrcode(this.getaddrcode());
        apinvobl.setcurnccode(this.getcurnccode());
        apinvobl.setdoctype(this.getdoctype());
        apinvobl.setdocnum(this.getdocnum());
        apinvobl.setdocdate(this.getdocdate());
        apinvobl.setdocduedate(this.getdocduedate());
        apinvobl.setyop(this.getyop());
        apinvobl.setmop(this.getmop());
        apinvobl.setdiscdate(this.getdiscdate());
        apinvobl.setorderno(this.getorderno());
        apinvobl.setpono(this.getpono());
        apinvobl.setinvdesc(this.getdscription());
        apinvobl.settermcode(this.gettermcode());
        apinvobl.setrate(this.getrate());
        apinvobl.setdoctotalamt(this.getdoctotalafttaxamt());
        apinvobl.setdoctotalamtr(this.getdoctotalafttaxamt());
        apinvobl.settaxabletotalamt(0);
        apinvobl.setnontaxabletotalamt(0);
        apinvobl.settaxtotalamt(this.gettaxtotalamt());
        apinvobl.setpaytotalamt(0);
        apinvobl.setswpaid("0");
        apinvobl.settaxcode(this.gettaxcode());
        apinvobl.setbasetype(this.getobjtype());
        apinvobl.setbasebatch(this.getbatchno());
        apinvobl.setbaseentry(this.getdocentry());
        apinvobl.save();

        Ap_invobs apinvobs=new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnum());

        apinvobs.setvendcode(this.getvendcode());
        apinvobs.setdocnum(this.getdocnum());
        apinvobs.setdocnumapplto(this.getdocnumapplto());
        apinvobs.setdocdate(this.getdocdate());
        apinvobs.setdocduedate(this.getdocduedate());
        apinvobs.setdiscdate(this.getdiscdate());
        apinvobs.setswpaid("0");
        apinvobs.setdoctotalamt(this.getdoctotalafttaxamt());
        apinvobs.setdisctotalamt(this.getdiscvalueamt());
        apinvobs.setdisctotalamtr(this.getdiscvalueamt());
        apinvobs.setdoctotalpayamtr(this.getdoctotalafttaxamt());
        apinvobs.setpndtotalpayamt(0);
        apinvobs.setpnddisctotalamt(0);
        apinvobs.setpndadjusttotalamt(0);
        apinvobs.setorderno(this.getorderno());
        apinvobs.setpono(this.getpono());
        apinvobs.setgrpcode(apvendor.getgrpcode());
        apinvobs.setdocnumppd(this.getdocnumppd());
        apinvobs.setbasetype(this.getobjtype());
        apinvobs.setbasebatch(this.getbatchno());
        apinvobs.setbaseentry(this.getdocentry());
        apinvobs.save();
        return true;
    }

    public Boolean postme5(Ap_invbatchlist apinvbatch,Ap_vendor apvendor) throws CodeException {
        Ap_invobl apinvobl=new Ap_invobl();
        apinvobl.searchData(this.getvendcode(), this.getdocnum());

        
        apinvobl.setvendcode(this.getvendcode());
        apinvobl.setaddrcode(this.getshpvia());
        apinvobl.setcurnccode(this.getcurnccode());
        apinvobl.setdoctype(this.getdoctype());
        apinvobl.setdocnum(this.getdocnum());
        apinvobl.setdocdate(this.getdocdate());
        apinvobl.setdocduedate(this.getdocduedate());
        apinvobl.setyop(this.getyop());
        apinvobl.setmop(this.getmop());
        apinvobl.setdiscdate(this.getdiscdate());
        apinvobl.setorderno(this.getorderno());
        apinvobl.setpono(this.getpono());
        apinvobl.setinvdesc(this.getdscription());
        apinvobl.settermcode(this.gettermcode());
        apinvobl.setrate(this.getrate());
        apinvobl.setdoctotalamt(this.getdoctotalafttaxamt());
        apinvobl.setdoctotalamtr(0);
        apinvobl.settaxabletotalamt(0);
        apinvobl.setnontaxabletotalamt(0);
        apinvobl.settaxtotalamt(this.gettaxamt ());
        apinvobl.setpaytotalamt(this.getdoctotalafttaxamt());
        apinvobl.setswpaid("1");
        apinvobl.settaxcode(this.gettaxcode());
        apinvobl.setbasetype(this.getobjtype());
        apinvobl.setbasebatch(this.getbatchno());
        apinvobl.setbaseentry(this.getdocentry());
        apinvobl.save();


        apinvobl=new Ap_invobl();
        apinvobl.searchData(this.getvendcode(), this.getdocnumapplto());
        if (apinvobl.getID()>0){
            apinvobl.setdoctotalamtr(apinvobl.getdoctotalamtr()+this.getdoctotalafttaxamt());

            if (apinvobl.getdoctotalamtr()+this.getdoctotalafttaxamt()==0){
                apinvobl.setswpaid("1");
            } else {
                apinvobl.setswpaid("0");
            }

            apinvobl.save();
        }

        Ap_invobs apinvobs=new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnum());

        apinvobs.setvendcode (this.getvendcode());
        apinvobs.setdocnum (this.getdocnum());
        apinvobs.setdocnumapplto (this.getdocnumapplto());
        apinvobs.setdocdate (this.getdocdate());
        apinvobs.setdocduedate (this.getdocduedate());
        apinvobs.setdiscdate (this.getdiscdate());
        apinvobs.setswpaid ("1");
        apinvobs.setdoctotalamt (this.getdoctotalafttaxamt());
        apinvobs.setdisctotalamt (this.getdiscvalueamt());
        apinvobs.setdisctotalamtr (0);
        apinvobs.setdoctotalpayamtr (0);
        apinvobs.setpndtotalpayamt (0);
        apinvobs.setpnddisctotalamt (0);
        apinvobs.setpndadjusttotalamt (0);
        apinvobs.setorderno (this.getorderno());
        apinvobs.setpono (this.getpono());
        apinvobs.setgrpcode (apvendor.getgrpcode());
        apinvobs.setdocnumppd (this.getdocnumppd());
        apinvobs.setbasetype (this.getobjtype());
        apinvobs.setbasebatch (this.getbatchno());
        apinvobs.setbaseentry(this.getdocentry());
        apinvobs.save();

        apinvobs=new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnumapplto());
        if (apinvobs.getID()>0){
            apinvobs.setdoctotalpayamtr(apinvobs.getdoctotalpayamtr()+this.getdoctotalafttaxamt());

            if (apinvobs.getdoctotalpayamtr() +this.getdoctotalafttaxamt()==0){
                apinvobs.setswpaid("1");
            } else {
                apinvobs.setswpaid("0");
            }
            apinvobs.save();
        }

        Ap_invobp apinvobp=new Ap_invobp();
        apinvobp.searchData(this.getvendcode(), this.getdocnum());

        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setvendcode(this.getvendcode());
        apinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
        apinvobp.setdocnum(this.getdocnum());
        apinvobp.setpaymtnum("1");
        apinvobp.setpaydate(GlobalUtils.getCurrentDate());
        apinvobp.settranstype(1);
        apinvobp.setpaytotalamt(this.getdoctotalafttaxamt()*-1);
        apinvobp.setcurnccode(this.getcurnccode());
        apinvobp.setswovrrate(0);
        apinvobp.settrantype(1);
        apinvobp.setreffmemocode(this.getdocnumapplto());
        apinvobp.setswdelinv(0);
        apinvobp.setdocnumppd(this.getdocnumppd());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.save();

        apinvobp=new Ap_invobp();
        apinvobp.searchData(this.getvendcode(), this.getdocnumapplto());
        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setvendcode(this.getvendcode());
        apinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
        apinvobp.setdocnum(this.getdocnumapplto());
        apinvobp.setpaymtnum("1");
        apinvobp.setpaydate(GlobalUtils.getCurrentDate());
        apinvobp.settranstype(1);
        apinvobp.setpaytotalamt(this.getdoctotalafttaxamt());
        apinvobp.setcurnccode(this.getcurnccode());
        apinvobp.setswovrrate(0);
        apinvobp.settrantype(1);
        apinvobp.setreffmemocode(this.getdocnum());
        apinvobp.setswdelinv(0);
        apinvobp.setdocnumppd(this.getdocnumppd());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.save();

        return true;
        
    }

    public Boolean postme6(Ap_invbatchlist apinvbatch,Ap_vendor apvendor) throws CodeException {
        Ap_invobl apinvobl=new Ap_invobl();
        apinvobl.searchData(this.getvendcode(), this.getdocnum());

        
        apinvobl.setvendcode(this.getvendcode());
        apinvobl.setaddrcode(this.getshpvia());
        apinvobl.setcurnccode(this.getcurnccode());
        apinvobl.setdoctype(this.getdoctype());
        apinvobl.setdocnum(this.getdocnum());
        apinvobl.setdocdate(this.getdocdate());
        apinvobl.setdocduedate(this.getdocduedate());
        apinvobl.setyop(this.getyop());
        apinvobl.setmop(this.getmop());
        apinvobl.setdiscdate(this.getdiscdate());
        apinvobl.setorderno(this.getorderno());
        apinvobl.setpono(this.getpono());
        apinvobl.setinvdesc(this.getdscription());
        apinvobl.settermcode(this.gettermcode());
        apinvobl.setrate(this.getrate());
        apinvobl.setdoctotalamt(this.getdoctotalafttaxamt()*-1);
        apinvobl.setdoctotalamtr(0);
        apinvobl.settaxabletotalamt(0);
        apinvobl.setnontaxabletotalamt(0);
        apinvobl.settaxtotalamt(this.gettaxamt());
        apinvobl.setpaytotalamt(this.getdoctotalafttaxamt()*-1);
        apinvobl.setswpaid("1");
        apinvobl.settaxcode(this.gettaxcode());
        apinvobl.setbasetype(this.getobjtype());
        apinvobl.setbasebatch(this.getbatchno());
        apinvobl.setbaseentry(this.getdocentry());
        apinvobl.save();

        apinvobl=new Ap_invobl();
        apinvobl.searchData(this.getvendcode(), this.getdocnumapplto());
        if (apinvobl.getID()>0){
            apinvobl.setdoctotalamtr(apinvobl.getdoctotalamtr()-this.getdoctotalafttaxamt());
            if (apinvobl.getdoctotalamtr()-this.getdoctotalafttaxamt()==0){
                apinvobl.setswpaid("1");
            } else {
                apinvobl.setswpaid("0");
            }
            apinvobl.save();
        }

        Ap_invobs apinvobs=new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnum());

        apinvobs.setvendcode(this.getvendcode());
        apinvobs.setdocnum(this.getdocnum());
        apinvobs.setdocnumapplto(this.getdocnumapplto());
        apinvobs.setdocdate(this.getdocdate());
        apinvobs.setdocduedate(this.getdocduedate());
        apinvobs.setdiscdate(this.getdiscdate());
        apinvobs.setswpaid("1");
        apinvobs.setdoctotalamt(this.getdoctotalafttaxamt()*-1);
        apinvobs.setdisctotalamt(this.getdiscvalueamt());
        apinvobs.setdisctotalamtr(0);
        apinvobs.setdoctotalpayamtr(0);
        apinvobs.setpndtotalpayamt(0);
        apinvobs.setpnddisctotalamt(0);
        apinvobs.setpndadjusttotalamt(0);
        apinvobs.setorderno(this.getorderno());
        apinvobs.setpono(this.getpono());
        apinvobs.setgrpcode(apvendor.getgrpcode());
        apinvobs.setdocnumppd(this.getdocnumppd());
        apinvobs.setbasetype(this.getobjtype());
        apinvobs.setbasebatch(this.getbatchno());
        apinvobs.setbaseentry(this.getdocentry());
        apinvobs.save();

        apinvobs=new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnumapplto());
        if (apinvobs.getID()>0){
            apinvobs.setdoctotalpayamtr(apinvobs.getdoctotalpayamtr()+this.getdoctotalafttaxamt());
            if(apinvobs.getdoctotalpayamtr()-this.getdoctotalafttaxamt()==0){
                apinvobs.setswpaid("1");
            } else {
                apinvobs.setswpaid("0");
            }
            apinvobs.save();
        }


        Ap_invobp apinvobp=new Ap_invobp();
        apinvobp.searchData(this.getvendcode(), this.getdocnum());

        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setvendcode(this.getvendcode());
        apinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
        apinvobp.setdocnum(this.getdocnum());
        apinvobp.setpaymtnum("1");
        apinvobp.setpaydate(GlobalUtils.getCurrentDate());
        apinvobp.settranstype(1);
        apinvobp.setpaytotalamt(this.getdoctotalafttaxamt());
        apinvobp.setcurnccode(this.getcurnccode());
        apinvobp.setswovrrate(0);
        apinvobp.settrantype(1);
        apinvobp.setreffmemocode(this.getdocnumapplto());
        apinvobp.setswdelinv(0);
        apinvobp.setdocnumppd(this.getdocnumppd());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.save();

        apinvobp=new Ap_invobp();
        apinvobp.searchData(this.getvendcode(), this.getdocnumapplto());

        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setvendcode(this.getvendcode());
        apinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
        apinvobp.setdocnum(this.getdocnumapplto());
        apinvobp.setpaymtnum("1");
        apinvobp.setpaydate(GlobalUtils.getCurrentDate());
        apinvobp.settranstype(1);
        apinvobp.setpaytotalamt(this.getdoctotalafttaxamt()*-1);
        apinvobp.setcurnccode(this.getcurnccode());
        apinvobp.setswovrrate(0);
        apinvobp.settrantype(1);
        apinvobp.setreffmemocode(this.getdocnum());
        apinvobp.setswdelinv(0);
        apinvobp.setdocnumppd(this.getdocnumppd());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.save();

        return true;
        
    }


    public void setaccsetcode(String param) throws CodeException {
        super.setaccsetcode(param.replace("-", ""));
    }


    public boolean isAlreadyCreated(String vendorcode, int doctype , String docnum) throws CodeException {
         DbBean db = DbBean.connect();
         boolean cek = false;

         try {

            String query = "select id "
                            + "\n from ap_invh "
                            + "\n where vendcode = '" + vendorcode + "' and doctype = '" + doctype + "' and docnum = '" + docnum + "' ";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                cek = true;
            }

       } catch (SQLException ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
       }finally{
           db.close();
       }

       return cek;
    }

    public Boolean runsp_ap_invobl_insert(String yop, String mop) throws CodeException {
        String query="call sp_ap_invobl_hist_insert("+yop+","+mop+")";
        DbBean db=DbBean.connect();
        db.updateSQL(query);
        return true;
    }

    
}




