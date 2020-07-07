/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_adjhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_adjh obj = new Ar_adjh();
 * 
 * 2. Ar_adjh obj = new Ar_adjh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh(1);
 * 
 *    It Means : Select * from ar_adjh where id = 1;
 * 
 * 3. Ar_adjh obj = new Ar_adjh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh(1);
 * 
 *    It Means : Select * from ar_adjh where id = 1;
 * 
 * 4. Ar_adjh obj = new Ar_adjh(<primary_key>); 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh("1");
 *    It Means : Select * from ar_adjh where <primary_key> = "1";
 * 
 * 5. Ar_adjh obj = new Ar_adjh(Ar_adjh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh(Ar_adjh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_adjh where id = "1";
 * 
 * 6. Ar_adjh obj = new Ar_adjh();
 *    obj.loadString(Ar_adjh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh();
 *    obj.loadString(Ar_adjh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_adjh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_adjh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_adjh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_adjh obj = new Ar_adjh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_adjh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar.adjustment;

import accapp.objectclasses.ar.Ar_custgrpsts;
import accapp.objectclasses.ar.Ar_customer;
import accapp.objectclasses.ar.Ar_customersts;
import accapp.objectclasses.ar.Ar_invh;
import accapp.objectclasses.ar.Ar_invobl;
import accapp.objectclasses.ar.Ar_invobp;
import accapp.objectclasses.ar.Ar_invobs;
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
public class Ar_adjh extends Ar_adjhAbst{
    Ar_adjds detail;


    public Ar_adjh() throws CodeException {
       detail=new Ar_adjds();
    }

    public Ar_adjh(long id) throws CodeException {
        super(id);
    }

    public Ar_adjh(String val)  throws CodeException {
        super(val);
    }

    public Ar_adjh(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ar_adjh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public Ar_adjds getDetail() {
        return detail;
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ar_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ar_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ar_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ar_adjd obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Ar_adjds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        //this.setdocnum(this.getFormatedDocNum());
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setadjusttot(this.getDetailAmt());
        super.save();

        for(Object o : detail.list()) {
            Ar_adjd oAr_adjd = (Ar_adjd) o;

            if (oAr_adjd.getID()==0) {
                oAr_adjd.setlinenum(oAr_adjd.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
            }
            oAr_adjd.setbatchno(this.getbatchno());
            oAr_adjd.setdocentry(this.getdocentry());

            oAr_adjd.save();

        }


    }

    @Override
    public void delete() throws CodeException {
        detail = new Ar_adjds();
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
                            + "\n from ar_adjh where batchno=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Ar_ajdh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }


    public void getdataDetail(int index, Ar_adjd oapadjd) throws CodeException {
        if (detail.size()>0){
            oapadjd=(Ar_adjd) detail.list().get(index);

            oapadjd=new Ar_adjd(oapadjd.getID());
        }
    }
    public void replaceDetail(int index, Ar_adjd oapadjd) throws CodeException {
        detail.list().set(index, oapadjd);
    }

    public void removeDetail(int index,Ar_adjbatchlist obj) throws CodeException {

        Ar_adjd ogl_jed = (Ar_adjd) detail.list().get(index);
        ogl_jed.delete();

        detail.list().remove(index);

        obj.settotpayamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double total = 0;
        for (Object o : detail.list()) {

            Ar_adjd cbd = (Ar_adjd) o;
            try{
                total +=  cbd.getdistamt();

            }catch(Exception e) {}

        }
        return (total);
    }

    private String getFormatedDocNum() throws CodeException{
        if (!this.getdocnum().equalsIgnoreCase("")){
            return this.getdocnum();
        }
        Ar_optiionaldetail1 apop = new Ar_optiionaldetail1("3");
        int i=0;
        String docnum="";
        for(i=0;i<apop.getlengthno();i++){
            if (i<apop.gettxtprefix().length()){
                docnum=apop.gettxtprefix();
            } else {
                if (i<apop.getlengthno()-GlobalUtils.churuf(apop.getdocnum()).length()){
                    docnum=docnum+"0";
                } else {
                    docnum=docnum+(apop.getdocnum()+1);
                    break;
                }
            }
        }
        if (!docnum.equalsIgnoreCase("")){
            apop.setdocnum(apop.getdocnum()+1);
            apop.save();

        }
        return docnum;

    }
    public Boolean postme(Ar_adjbatchlist apadjbatch) throws CodeException {

        System.out.println("MOP " + this.getmop() + " " + this.getyop());

        Ar_invobl apinvobl=new Ar_invobl();
        apinvobl.searchData(this.getcustmrcode(), this.getdocnum(), this.getdoctype());

        apinvobl.setdoctotalamtr(apinvobl.getdoctotalamtr() + this.getadjusttot());
        apinvobl.setrcptotalamt(apinvobl.getrcptotalamt() + this.getadjusttot());
        apinvobl.setswpaid(apinvobl.getdoctotalamtr() == 0? "1" : "0");
        apinvobl.save();

        this.setentrysts(1);
        save();

        for(Object o : detail.list) {
            Ar_adjd adj = (Ar_adjd) o;
            adj.setlinests(1);
        }

        Ar_invobs apinvobs = new Ar_invobs();
        apinvobs.searchData(this.getcustmrcode(), this.getdocnum(), this.getdoctype());

        apinvobs.setdoctotalpayamtr(apinvobs.getdoctotalpayamtr() + this.getadjusttot());
        apinvobs.setswpaid(apinvobs.getdoctotalpayamtr() == 0 ? "1": "0");
        apinvobs.save();


        Ar_invobp apinvobp = new Ar_invobp();
        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setcustmrcode(this.getcustmrcode());
        apinvobp.setdoctype(Long.parseLong(this.getdoctype()));
        apinvobp.setrcpnum("1");
        apinvobp.setpaydate(this.getdocdate());
        apinvobp.settranstype(Long.parseLong(this.getdoctype()));
        apinvobp.setpaytotalamt(this.getadjusttot());
        apinvobp.setcurnccode(apadjbatch.getcurnccode());
        apinvobp.setratetypecode(null);
        apinvobp.setrateexch(0);
        apinvobp.setbankcode(apadjbatch.getbankcode());
        apinvobp.settrantype(Long.parseLong(apadjbatch.getbatchtype()));

        Ar_invh apinvh = new Ar_invh(Ar_invh.PROPERTY_DOCNUM, apinvobp.getdocnum());
        apinvobp.setdocnumppd(apinvh.getdocnumppd());

        apinvobp.setrcpdate(this.getdocdate());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.setobjtype(1);

        apinvobp.save();

        Ar_customer apv = new Ar_customer(this.getcustmrcode());

        Ar_custgrpsts apgrpvsts = new Ar_custgrpsts();
        apgrpvsts.searchData(this.getyop()+"", this.getmop()+"", apv.getgrpcode() );
        apgrpvsts.setyop(this.getyop());
        apgrpvsts.setmop(this.getmop());
        apgrpvsts.setadjcnt(apgrpvsts.getadjcnt() + 1);
        apgrpvsts.setadjamt(apgrpvsts.getadjamt() + this.getadjusttot());
        apgrpvsts.setgrpcode(apv.getgrpcode());
        apgrpvsts.save();

        Ar_customersts apvsts = new Ar_customersts();
        apvsts.searchData(this.getyop()+"", this.getmop() +"", apv.getcustmrcode());
        apvsts.setyop(this.getyop());
        apvsts.setmop(this.getmop());
        apvsts.setadjcnt(apgrpvsts.getadjcnt() + 1);
        apvsts.setadjamt(apgrpvsts.getadjamt() + this.getadjusttot());
        apvsts.setcustmrcode(apv.getcustmrcode());
        apvsts.save();

        return false;
    }
    
}




