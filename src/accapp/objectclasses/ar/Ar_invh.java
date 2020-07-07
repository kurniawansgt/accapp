/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_invhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_invh obj = new Ar_invh();
 * 
 * 2. Ar_invh obj = new Ar_invh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_invh obj = new Ar_invh(1);
 * 
 *    It Means : Select * from ar_invh where id = 1;
 * 
 * 3. Ar_invh obj = new Ar_invh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_invh obj = new Ar_invh(1);
 * 
 *    It Means : Select * from ar_invh where id = 1;
 * 
 * 4. Ar_invh obj = new Ar_invh(<primary_key>); 
 *    Sample :
 *    Ar_invh obj = new Ar_invh("1");
 *    It Means : Select * from ar_invh where <primary_key> = "1";
 * 
 * 5. Ar_invh obj = new Ar_invh(Ar_invh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_invh obj = new Ar_invh(Ar_invh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_invh where id = "1";
 * 
 * 6. Ar_invh obj = new Ar_invh();
 *    obj.loadString(Ar_invh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_invh obj = new Ar_invh();
 *    obj.loadString(Ar_invh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_invh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_invh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_invh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_invh obj = new Ar_invh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_invh obj = new Ar_invh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_invh where id = 1;
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
public class Ar_invh extends Ar_invhAbst{

    Ar_invds detail;

    public void setDetail(Ar_invds detail) {
        this.detail = detail;
    }

    public Ar_invds getDetail() {
        return detail;
    }

    public Ar_invh() throws CodeException {
       detail=new Ar_invds();
    }
    
    public Ar_invh(long id) throws CodeException {
        super(id);
    }
    
    public Ar_invh(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_invh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_invh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ar_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ar_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ar_invds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ar_invd obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Ar_invds cbds) throws CodeException {
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
            Ar_invd oAr_invd = (Ar_invd) o;
            if (oAr_invd.getdetailamt()!=0){
                if (oAr_invd.getID()==0) {
                    oAr_invd.setlinenum(oAr_invd.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                }

                oAr_invd.setbatchno(this.getbatchno());
                oAr_invd.setdocentry(this.getdocentry());

                oAr_invd.save();
            }

        }


    }

    @Override
    public void delete() throws CodeException {
        detail = new Ar_invds();
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
                            + "\n from ar_invh where batchno=" + batchid;

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

    public void getdataDetail(int index, Ar_invd ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Ar_invd) detail.list().get(index);

            ogl_jed=new Ar_invd(ogl_jed.getID());
        }
    }
    public void replaceDetail(int index, Ar_invd ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Ar_invbatchlist obj) throws CodeException {

        Ar_invd ogl_jed = (Ar_invd) detail.list().get(index);
        ogl_jed.delete();

        detail.list().remove(index);

        obj.settotinvamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double totalkredit = 0;

        for (Object o : detail.list()) {

            Ar_invd cbd = (Ar_invd) o;
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
        Ar_optiionaldetail1 arop = new Ar_optiionaldetail1(this.getdoctype());
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

    public Boolean postme() throws CodeException{
        Ar_invobl arinvobl=new Ar_invobl(Ar_invobl.PROPERTY_DOCNUM, this.getdocnum());

        Ar_customer arcust=new Ar_customer(this.getcustmrcode());
        if (arcust.getID()>0){
            arinvobl.setcustmrcode(this.getcustmrcode());
            arinvobl.setaddrcode(this.getaddrcode());
            arinvobl.setcurnccode(this.getcurnccode());
            arinvobl.setdoctype(this.getdoctype());
            arinvobl.setdocnum(this.getdocnum());
            arinvobl.setdocdate(this.getdocdate());
            arinvobl.setdocduedate(this.getdocduedate());
            arinvobl.setyop(this.getyop());
            arinvobl.setmop(this.getmop());
            arinvobl.setdiscdate(this.getdiscdate());
            //arinvobl.setrcpno(this.getrcpno());
            arinvobl.setorderno(this.getorderno());
            arinvobl.setcustmrpono(this.getcustmrpono());
            arinvobl.setnatcode(arcust.getnatcode());
            //arinvobl.settrantype(this.gettrantype());
            //arinvobl.settrantypetxt(this.gettrantypetxt());
            arinvobl.setgrpcode(arcust.getgrpcode());
            arinvobl.setinvdesc(this.getdscription());
            arinvobl.settermcode(this.gettermcode());
            arinvobl.setrate(this.getrate());
            arinvobl.setdoctotalamt(this.getdoctotalamt());
            arinvobl.setdoctotalamtr(this.getdoctotalamt());
            arinvobl.settaxabletotalamt(this.gettaxbase());
            arinvobl.setnontaxabletotalamt(0);
            arinvobl.settaxtotalamt(0);
            arinvobl.setrcptotalamt(0);
            arinvobl.setswpaid("0");
            arinvobl.settaxcode(this.gettaxcode());
            arinvobl.setbasetype(this.getobjtype());
            arinvobl.setbasebatch(this.getbatchno());
            arinvobl.setbaseentry(this.getdocentry());
            arinvobl.setobjtype(this.getobjtype());
            arinvobl.setentrydate(this.getentrydate());
            arinvobl.setauditdate(this.getauditdate());
            arinvobl.setaudituser(this.getaudituser());
            arinvobl.setcmpnyid(this.getcmpnyid());

            arinvobl.save();

            Ar_invobs arinvobs=new Ar_invobs(Ar_invobs.PROPERTY_DOCNUM, this.getdocnum());
            arinvobs.setcustmrcode(this.getcustmrcode());
            arinvobs.setdocnum(this.getdocnum());
            arinvobs.setdocnumapplto(this.getdocnumapplto());
            arinvobs.setdocduedate(this.getdocduedate());
            arinvobs.setdocduedate(this.getdocduedate());
            arinvobs.setdiscdate(this.getdiscdate());
            arinvobs.setswpaid("0");
            arinvobs.setdoctotalamt(this.getdoctotalamt());
            arinvobs.setdisctotalamt(this.getdiscvalueamt());
            arinvobs.setdisctotalamtr(0);
            arinvobs.setdoctotalpayamtr(0);
            arinvobs.setpndtotalpayamt(0);
            arinvobs.setpnddisctotalamt(0);
            arinvobs.setpndadjusttotalamt(0);
            arinvobs.setorderno(this.getorderno());
            arinvobs.setcustmrpono(this.getcustmrpono());
            arinvobs.setnatcode(arcust.getnatcode());
            arinvobs.setgrpcode(arcust.getgrpcode());
            arinvobs.setdocnumppd(this.getdocnumppd());
            arinvobs.setobjtype(this.getobjtype());
            arinvobs.setentrydate(this.getentrydate());
            arinvobs.setauditdate(this.getauditdate());
            arinvobs.setaudituser(this.getaudituser());
            arinvobs.setcmpnyid(this.getcmpnyid());

            arinvobs.save();

            Ar_customersts arcuststs=new Ar_customersts();
            arcuststs.searchData(GlobalUtils.churuf(this.getyop()), GlobalUtils.churuf(this.getmop()), this.getcustmrcode());

            arcuststs.setyop(this.getyop());
            arcuststs.setmop(this.getmop());
            arcuststs.setcustmrcode(this.getcustmrcode());
            arcuststs.setinvcnt(arcuststs.getinvcnt()+1);
            arcuststs.setpaycnt(arcuststs.getpaycnt());
            arcuststs.setdisccnt(arcuststs.getdisccnt());
            arcuststs.setcncnt(arcuststs.getcncnt());
            arcuststs.setdncnt(arcuststs.getdncnt());
            arcuststs.setadjcnt(arcuststs.getadjcnt());
            arcuststs.setwroffcnt(arcuststs.getwroffcnt());
            arcuststs.setinttcnt(arcuststs.getinttcnt());
            arcuststs.setrtrchckcnt(arcuststs.getrtrchckcnt());
            arcuststs.setinvpaidcnt(arcuststs.getinvpaidcnt());
            arcuststs.setinvamt(arcuststs.getinvamt()+this.getdoctotalamt());
            arcuststs.setpayamt(0);
            arcuststs.setdiscamt(arcuststs.getdiscamt()+this.getdiscvalueamt());
            arcuststs.setcnamt(0);
            arcuststs.setdnamt(0);
            arcuststs.setadjamt(0);
            arcuststs.setwroffamt(0);
            arcuststs.setinttamt(0);
            arcuststs.setrtrchckamt(0);
            arcuststs.setinvpaidamt(0);
            arcuststs.setobjtype(this.getobjtype());
            arcuststs.setentrydate(this.getentrydate());
            arcuststs.setauditdate(this.getauditdate());
            arcuststs.setaudituser(this.getaudituser());
            arcuststs.setcmpnyid(this.getcmpnyid());

            arcuststs.save();

            Ar_custgrpsts arcustgrpsts=new Ar_custgrpsts();
            arcustgrpsts.searchData(GlobalUtils.churuf(this.getyop()), GlobalUtils.churuf(this.getmop()), arcust.getgrpcode());

            arcustgrpsts.setyop(this.getyop());
            arcustgrpsts.setmop(this.getmop());
            arcustgrpsts.setgrpcode(arcust.getgrpcode());
            arcustgrpsts.setinvcnt(arcustgrpsts.getinvcnt()+1);
            arcustgrpsts.setpaycnt(arcustgrpsts.getpaycnt());
            arcustgrpsts.setdisccnt(arcustgrpsts.getdisccnt());
            arcustgrpsts.setcncnt(arcustgrpsts.getcncnt());
            arcustgrpsts.setdncnt(arcustgrpsts.getdncnt());
            arcustgrpsts.setadjcnt(arcustgrpsts.getadjcnt());
            arcustgrpsts.setwroffcnt(arcustgrpsts.getwroffcnt());
            arcustgrpsts.setinttcnt(arcustgrpsts.getinttcnt());
            arcustgrpsts.setrtrchckcnt(arcustgrpsts.getrtrchckcnt());
            arcustgrpsts.setinvpaidcnt(arcustgrpsts.getinvpaidcnt());
            arcustgrpsts.setinvamt(arcustgrpsts.getinvamt());
            arcustgrpsts.setpayamt(arcustgrpsts.getpayamt());
            arcustgrpsts.setdiscamt(arcustgrpsts.getdiscamt());
            arcustgrpsts.setcnamt(arcustgrpsts.getcnamt());
            arcustgrpsts.setdnamt(arcustgrpsts.getdnamt());
            arcustgrpsts.setadjamt(arcustgrpsts.getadjamt());
            arcustgrpsts.setwroffamt(arcustgrpsts.getwroffamt());
            arcustgrpsts.setinttamt(arcustgrpsts.getinttamt());
            arcustgrpsts.setrtrchckamt(arcustgrpsts.getrtrchckamt());
            arcustgrpsts.setinvpaidamt(arcustgrpsts.getinvpaidamt());
            arcustgrpsts.setobjtype(this.getobjtype());
            arcustgrpsts.setentrydate(this.getentrydate());
            arcustgrpsts.setauditdate(this.getauditdate());
            arcustgrpsts.setaudituser(this.getaudituser());
            arcustgrpsts.setcmpnyid(this.getcmpnyid());

            arcustgrpsts.save();

            return true;
        }

        return false;
    }

    public void setaccsetcode(String param) throws CodeException {
        super.setaccsetcode(param.replace("-", ""));
    }
}




