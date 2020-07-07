/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcphAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcph obj = new Ar_rcph();
 * 
 * 2. Ar_rcph obj = new Ar_rcph(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph(1);
 * 
 *    It Means : Select * from ar_rcph where id = 1;
 * 
 * 3. Ar_rcph obj = new Ar_rcph(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph(1);
 * 
 *    It Means : Select * from ar_rcph where id = 1;
 * 
 * 4. Ar_rcph obj = new Ar_rcph(<primary_key>); 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph("1");
 *    It Means : Select * from ar_rcph where <primary_key> = "1";
 * 
 * 5. Ar_rcph obj = new Ar_rcph(Ar_rcph.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph(Ar_rcph.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcph where id = "1";
 * 
 * 6. Ar_rcph obj = new Ar_rcph();
 *    obj.loadString(Ar_rcph.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph();
 *    obj.loadString(Ar_rcph.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcph where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcph Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcph : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcph obj = new Ar_rcph(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcph where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import accapp.objectclasses.op.Op_paymentterm;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_rcph extends Ar_rcphAbst{
    
    Ar_rcpds detail;

    public Ar_rcpdmiscs getDetail2() {
        return detail2;
    }
    Ar_rcpdmiscs detail2;

    public Ar_rcpds getDetail() {
        return detail;
    }


    public Ar_rcph() throws CodeException {
       detail=new Ar_rcpds();
       detail2=new Ar_rcpdmiscs();
    }
    
    public Ar_rcph(long id) throws CodeException {
        super(id);
    }
    
    public Ar_rcph(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_rcph(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_rcph(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ar_rcpdmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ar_rcpdmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);

        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ar_rcpdmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ar_rcpd obj) throws CodeException {
        detail.add(obj);
    }

    public void adddetail(Ar_rcpdmisc obj) throws CodeException {
        detail2.add(obj);
    }

    public void addDetails(Ar_rcpds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    public void addDetails(Ar_rcpdmiscs cbds) throws CodeException {
        this.detail2.add(cbds);
    }


    @Override
    public void saveNew() throws CodeException {
        if (this.getdocnum().equalsIgnoreCase("")){
            this.setdocnum(this.getbatchno()+"-"+this.getdocentry());
        }
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        //this.setdoctotalamt(this.getDetailAmt());
        super.save();

        if (this.getdoctype().equalsIgnoreCase("5")){
            for(Object o : detail2.list()) {
                Ar_rcpdmisc oGl_jed = (Ar_rcpdmisc) o;

                if (oGl_jed.getdistrbamt()>0){
                    if (oGl_jed.getID()==0) {
                        oGl_jed.setlinenum(oGl_jed.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                    }
                    oGl_jed.setbatchno(this.getbatchno());
                    oGl_jed.setdocentry(this.getdocentry());

                    oGl_jed.save();
                }

            }
        } else {
            int i=detail.size();
            while (i>0){
                i--;
                Ar_rcpd oappayd=(Ar_rcpd) detail.list().get(i);
                if (oappayd.getApplied().equalsIgnoreCase("no")){
                    detail.list().remove(i);
                }
            }
            for(Object o : detail.list()) {
                Ar_rcpd oGl_jed = (Ar_rcpd) o;
                if (oGl_jed.getpayamt()>0&&(oGl_jed.getApplied().equalsIgnoreCase("yes")||oGl_jed.getApplied().equalsIgnoreCase("Pending"))){
                    if (oGl_jed.getID()==0) {
                        oGl_jed.setlinenum(oGl_jed.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                        if (this.getdoctype().equalsIgnoreCase("2")){
                            oGl_jed.setdocnum(getFormatedDocNum("8"));
                        }
                        if (this.getdoctype().equalsIgnoreCase("3")){
                            oGl_jed.setdocnum(getFormatedDocNum("9"));
                        }
                    }
                    oGl_jed.setbatchno(this.getbatchno());
                    oGl_jed.setdocentry(this.getdocentry());
                    oGl_jed.setcustmrcode(this.getcustmrcode());
                    oGl_jed.save();
                }

            }
        }

    }

    private String getFormatedDocNum(String docnumid) throws CodeException{
        Ar_optiionaldetail1 arop = new Ar_optiionaldetail1(docnumid);
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
                }
            }
        }
        if (!docnum.equalsIgnoreCase("")){
            arop.setdocnum(arop.getdocnum()+1);
            arop.save();

        }
        return docnum;

    }

    @Override
    public void delete() throws CodeException {
        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail.delete();


        detail2 = new Ar_rcpdmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());

        detail2.delete();

        super.delete();
    }



    public int getMaxbtchentry(int batchid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(docentry) is null then 1 else max(docentry) + 1 end nomor "
                            + "\n from ar_rcph where batchno=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Ar_rcph : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Ar_rcpd ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Ar_rcpd) detail.list().get(index);

            ogl_jed=new Ar_rcpd(ogl_jed.getID());
        }
    }

    public void getdataDetail2(int index, Ar_rcpdmisc ogl_jed) throws CodeException {
        if (detail2.size()>0){
            ogl_jed=(Ar_rcpdmisc) detail2.list().get(index);

            ogl_jed=new Ar_rcpdmisc(ogl_jed.getID());
        }
    }

    public void replaceDetail(int index, Ar_rcpd ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void replaceDetail(int index, Ar_rcpdmisc ogl_jed) throws CodeException {
        detail2.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Ar_rcpbatchlist obj) throws CodeException {

        Ar_rcpd ogl_jed = (Ar_rcpd) detail.list().get(index);
        if (ogl_jed.getID()>0){ogl_jed.delete();}
        if (index<detail.list().size()){
            detail.list().remove(index);
        }

        obj.settotrcpamt(obj.getTotalAmount());
        obj.save();
    }

    public void removeDetail2(int index,Ar_rcpbatchlist obj) throws CodeException {

        Ar_rcpdmisc ogl_jed = (Ar_rcpdmisc) detail2.list().get(index);
        if (ogl_jed.getID()>0){ogl_jed.delete();}
        if (index<detail2.list().size()){
            detail2.list().remove(index);
        }

        obj.settotrcpamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double totalkredit = 0;

        if (this.getdoctype().equalsIgnoreCase("5")){
            for (Object o : detail2.list()) {

                Ar_rcpdmisc cbd = (Ar_rcpdmisc) o;
                try{

                    if (cbd.getdistrbamt() >= 0) {
                        totalkredit +=  cbd.getdistrbamt();
                    }

                }catch(Exception e) {}

            }
        } else {
            for (Object o : detail.list()) {

                Ar_rcpd cbd = (Ar_rcpd) o;
                try{

                    if (cbd.getpayamt() >= 0) {
                        totalkredit +=  cbd.getpayamt();
                    }

                }catch(Exception e) {}

            }

        }
        return (Math.abs(totalkredit));
    }

    
    public String gettypedsc() throws CodeException{
        String result="";
        switch (GlobalUtils.toInt(this.getdoctype())){
            case 1:
                result="Receipt";
                break;
            case 2:
                result="Prepayment";
                break;
            case 3:
                result="Unapplied Cash";
                break;
            case 4:
                result="Apply Document";
                break;
            case 5:
                result="Misc Receipt";
                break;

        }
        return result;
    }

    public Boolean postme(Ar_rcpbatchlist arrcpbath) throws CodeException{
        Ar_invobl arinvobl=new Ar_invobl();
        Ar_invobs arinvobs=new Ar_invobs();
        
        Ar_customer arcust=new Ar_customer(this.getcustmrcode());
        Op_paymentterm opterm=new Op_paymentterm(arcust.gettermcode());
            
        for (Object o:this.detail.list()){
            Ar_rcpd arrcpd=(Ar_rcpd) o;

            arinvobl=new Ar_invobl();
            arinvobs=new Ar_invobs();

            if (!this.getdoctype().equalsIgnoreCase("4")){
                arinvobl.searchData(this.getcustmrcode(), arrcpd.getdocnum());
                arinvobl.setdoctotalamtr(arinvobl.getdoctotalamtr()-arrcpd.getpayamt());

                arinvobl.setrcptotalamt(arinvobl.getrcptotalamt()+arrcpd.getpayamt());

                arinvobs.searchData(this.getcustmrcode(), arrcpd.getdocnum());
                arinvobs.setdoctotalpayamtr(arinvobs.getdoctotalpayamtr()-this.getdoctotalpayamt());

                arinvobs.setdisctotalamtr(arinvobs.getdisctotalamtr()+arrcpd.getpayamt());
            } else {
                arinvobl.searchData(this.getcustmrcode(), this.getdocnum());
                arinvobl.setdoctotalamtr(arinvobl.getdoctotalamtr()-this.getdoctotalpayamt());

                arinvobl.setrcptotalamt(arinvobl.getrcptotalamt()+this.getdoctotalpayamt());

                arinvobs.searchData(this.getcustmrcode(), this.getdocnum());
                arinvobs.setdoctotalpayamtr(arinvobs.getdoctotalpayamtr()-this.getdoctotalpayamt());

                arinvobs.setdisctotalamtr(arinvobs.getdisctotalamtr()+this.getdoctotalpayamt());
            }

            if (arinvobl.getdoctotalamtr()==0){
                arinvobl.setswpaid("1");
            } else {
                arinvobl.setswpaid("0");
            }

            if (arinvobs.getdoctotalpayamtr()==0){
                arinvobs.setswpaid("1");
            } else {
                arinvobs.setswpaid("0");
            }
        }

        if (this.getunapltotalamtb()!=0){
            arinvobl=new Ar_invobl();
            arinvobl.searchData(this.getcustmrcode(), this.getdocnum());

            arinvobl.setcustmrcode(this.getcustmrcode());

            arinvobl.setdoctype("4");

            arinvobl.setdocnum(getFormatedDocNum("9"));
            arinvobl.setdocdate(this.getdocdate());

            
            arinvobl.setcurnccode(arcust.getcurnccode());
            arinvobl.setdocduedate(GlobalUtils.getDocDueDate(this.getdocdate(), GlobalUtils.toInt(GlobalUtils.churuf(opterm.getduedays()))));
            arinvobl.setyop(GlobalUtils.getYear(arinvobl.getdocdate()));
            arinvobl.setmop(GlobalUtils.getMonth(arinvobl.getdocdate()));
            arinvobl.setdiscdate(arinvobl.getdocdate());
            arinvobl.setrcpno("");
            arinvobl.setorderno("");
            arinvobl.setcustmrpono("");
            arinvobl.setnatcode(arcust.getnatcode());
            arinvobl.settrantype(1);
            arinvobl.settrantypetxt(0);
            arinvobl.setgrpcode(arcust.getgrpcode());
            arinvobl.setinvdesc(this.getdscription());
            arinvobl.settermcode(arcust.gettermcode());
            arinvobl.setrate(0);

            arinvobl.setdoctotalamt(this.getunapltotalamtc()*-1);
            arinvobl.settaxabletotalamt(0);
            arinvobl.setnontaxabletotalamt(this.getunapltotalamtc()*-1);
            arinvobl.settaxtotalamt(0);
            arinvobl.setrcptotalamt(this.getdoctotalpayamt());
            arinvobl.setswpaid("0");
            arinvobl.settaxcode(arcust.gettaxcode());
            arinvobl.setbasetype(this.getobjtype());
            arinvobl.setbasebatch(this.getbatchno());
            arinvobl.setbaseentry(this.getdocentry());

            arinvobs=new Ar_invobs();
            arinvobs.searchData(this.getcustmrcode(), this.getdocnum());

            arinvobs.setcustmrcode(this.getcustmrcode());
            arinvobs.setdocnum(getFormatedDocNum("9"));
            arinvobs.setdocnumapplto("");

            arinvobs.setdocdate(this.getdocdate());
            arinvobs.setdocduedate(GlobalUtils.getDocDueDate(this.getdocdate(), GlobalUtils.toInt(GlobalUtils.churuf(opterm.getduedays()))));
            arinvobs.setdiscdate(arinvobs.getdocdate());

            arinvobs.setswpaid("0");
            arinvobs.setorderno("");
            arinvobs.setcustmrpono("");
            arinvobs.setnatcode(arcust.getnatcode());
            arinvobs.setgrpcode(arcust.getgrpcode());

            arinvobs.setdoctotalamt(this.getunapltotalamtc()*-1);
            arinvobs.setdisctotalamt(0);
            arinvobs.setdisctotalamtr(0);
            arinvobs.setdoctotalpayamtr(this.getunapltotalamtc()*-1);
            arinvobs.setpndtotalpayamt(0);
            arinvobs.setpnddisctotalamt(0);
            arinvobs.setpndadjusttotalamt(0);
            arinvobs.setdocnumppd("");
            arinvobs.setbasetype(this.getobjtype());
            arinvobs.setbasebatch(this.getbatchno());
            arinvobs.setbaseentry(this.getdocentry());

        }


        for (Object o:this.detail.list()){
            Ar_rcpd arrcpd=(Ar_rcpd) o;

            Ar_invobp arinvobp=new Ar_invobp();
            arinvobp.searchData(this.getcustmrcode(), this.getdocnum());

            arinvobp.setbatchno(arrcpd.getbatchno());
            arinvobp.setdocentry(arrcpd.getdocentry());
            arinvobp.setlinenum(arrcpd.getlinenum());
            arinvobp.setcustmrcode(arrcpd.getcustmrcode());
            arinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
            arinvobp.setdocnum(arrcpd.getdocnum());
            arinvobp.setrcpnum(this.getdocnum());
            arinvobp.setpaydate(this.getdocdate());
            arinvobp.settranstype(GlobalUtils.toInt(this.getdoctype()));
            arinvobp.setpaytotalamt(arrcpd.getpayamt());
            arinvobp.setcurnccode(this.getcurnccode());
            arinvobp.setratetypecode(this.getratetypecodec());
            arinvobp.setrateexch(this.getratetypeexchc());
            arinvobp.setswovrrate(0);
            arinvobp.setbankcode(arrcpbath.getbankcode());
            arinvobp.settrantype(GlobalUtils.toInt(arrcpbath.getbatchtype()));
            arinvobp.setreffmemocode("0");
            arinvobp.setswdelinv(0);
            arinvobp.setdocnumppd(arrcpd.getdocnumppd());
            //arinvobp.setcustmrcodeto(this.getcustmrpono());
            arinvobp.setyop(this.getyop());
            arinvobp.setmop(this.getmop());

        }

        Ar_customersts arcuststs=new Ar_customersts();
        arcuststs.searchData(Long.toString(this.getyop()), Long.toString(this.getmop()), this.getcustmrcode());
        arcust.setcustmrcode(this.getcustmrcode());
        arcuststs.setinvcnt(0);
        arcuststs.setpaycnt(arcuststs.getpaycnt()+1);
        /*arcuststs.setdisccnt(this.get ());
        arcuststs.setcncnt(this.get ());
        arcuststs.setdncnt(this.get ());
        arcuststs.setadjcnt(this.get ());
        arcuststs.setwroffcnt(this.get ());
        arcuststs.setinttcnt(this.get ());
        arcuststs.setrtrchckcnt(this.get ());*/
        arcuststs.setinvpaidcnt(arcuststs.getinvpaidcnt()+1);
        arcuststs.setinvamt(0);
        arcuststs.setpayamt(arcuststs.getpayamt()+this.getdoctotalpayamt());
        arcuststs.setdiscamt(arcuststs.getdiscamt()+this.getdisctotalpayamt());
        arcuststs.setcnamt(0);
        arcuststs.setdnamt(0);
        arcuststs.setadjamt(0);
        arcuststs.setwroffamt(0);
        arcuststs.setinttamt(0);
        arcuststs.setrtrchckamt(0);
        arcuststs.setinvpaidamt(0);

        Ar_custgrpsts ar_custgrpsts=new Ar_custgrpsts();
        ar_custgrpsts.searchData(Long.toString(this.getyop()), Long.toString(this.getmop()), this.getcustmrcode());

        ar_custgrpsts.setyop(this.getyop());
        ar_custgrpsts.setmop(this.getmop());
        ar_custgrpsts.setgrpcode(arcust.getgrpcode());
        //ar_custgrpsts.setinvcnt(this.get ());
        ar_custgrpsts.setpaycnt(ar_custgrpsts.getpaycnt()+1);
        /*ar_custgrpsts.setdisccnt(this.get ());
        ar_custgrpsts.setcncnt(this.get ());
        ar_custgrpsts.setdncnt(this.get ());
        ar_custgrpsts.setadjcnt(this.get ());
        ar_custgrpsts.setwroffcnt(this.get ());
        ar_custgrpsts.setinttcnt(this.get ());
        ar_custgrpsts.setrtrchckcnt(this.get ());
        ar_custgrpsts.setinvpaidcnt(this.get ());*/
        ar_custgrpsts.setinvamt(0);
        ar_custgrpsts.setpayamt(this.getdoctotalpayamt());
        ar_custgrpsts.setdiscamt(this.getdisctotalpayamt());
        ar_custgrpsts.setcnamt(0);
        ar_custgrpsts.setdnamt(0);
        ar_custgrpsts.setadjamt(0);
        ar_custgrpsts.setwroffamt(0);
        ar_custgrpsts.setinttamt(0);
        ar_custgrpsts.setrtrchckamt(0);
        ar_custgrpsts.setinvpaidamt(0);

        Ar_custnatsts ar_custnatsts=new Ar_custnatsts();
        ar_custnatsts.searchData(arcust.getnatcode(),Long.valueOf(this.getyop()).intValue(), Long.valueOf(this.getmop()).intValue());

        ar_custnatsts.setyop(this.getyop());
        ar_custnatsts.setmop(this.getmop());
        ar_custnatsts.setnatcode(arcust.getnatcode());
        //ar_custnatsts.setinvcnt(this.get ());
        ar_custnatsts.setpaycnt(ar_custnatsts.getpaycnt()+1);
        /*ar_custnatsts.setdisccnt(this.get ());
        ar_custnatsts.setcncnt(this.get ());
        ar_custnatsts.setdncnt(this.get ());
        ar_custnatsts.setadjcnt(this.get ());
        ar_custnatsts.setwroffcnt(this.get ());
        ar_custnatsts.setinttcnt(this.get ());
        ar_custnatsts.setrtrchckcnt(this.get ());*/
        ar_custnatsts.setinvpaidcnt(ar_custnatsts.getinvpaidcnt()+1);
        ar_custnatsts.setinvamt(0);
        ar_custnatsts.setpayamt(this.getdoctotalpayamt());
        ar_custnatsts.setdiscamt(this.getdisctotalpayamt());
        ar_custnatsts.setcnamt(0);
        ar_custnatsts.setdnamt(0);
        ar_custnatsts.setadjamt(0);
        ar_custnatsts.setwroffamt(0);
        ar_custnatsts.setinttamt(0);
        ar_custnatsts.setrtrchckamt(0);
        ar_custnatsts.setinvpaidamt(0);

        return true;
    }


}




