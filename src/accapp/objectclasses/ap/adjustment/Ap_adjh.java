/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_adjhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_adjh obj = new Ap_adjh();
 * 
 * 2. Ap_adjh obj = new Ap_adjh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh(1);
 * 
 *    It Means : Select * from ap_adjh where id = 1;
 * 
 * 3. Ap_adjh obj = new Ap_adjh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh(1);
 * 
 *    It Means : Select * from ap_adjh where id = 1;
 * 
 * 4. Ap_adjh obj = new Ap_adjh(<primary_key>); 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh("1");
 *    It Means : Select * from ap_adjh where <primary_key> = "1";
 * 
 * 5. Ap_adjh obj = new Ap_adjh(Ap_adjh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh(Ap_adjh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_adjh where id = "1";
 * 
 * 6. Ap_adjh obj = new Ap_adjh();
 *    obj.loadString(Ap_adjh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh();
 *    obj.loadString(Ap_adjh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_adjh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_adjh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_adjh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_adjh obj = new Ap_adjh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_adjh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap.adjustment;

import accapp.objectclasses.ap.Ap_invh;
import accapp.objectclasses.ap.Ap_invobl;
import accapp.objectclasses.ap.Ap_invobp;
import accapp.objectclasses.ap.Ap_invobs;
import accapp.objectclasses.ap.Ap_optionaldetail1;
import accapp.objectclasses.ap.Ap_vendgrpsts;
import accapp.objectclasses.ap.Ap_vendor;
import accapp.objectclasses.ap.Ap_vendorsts;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_adjh extends Ap_adjhAbst{
    Ap_adjds detail;


    public Ap_adjh() throws CodeException {
       detail=new Ap_adjds();
    }
    
    public Ap_adjh(long id) throws CodeException {
        super(id);
    }
    
    public Ap_adjh(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_adjh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_adjh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public Ap_adjds getDetail() {
        return detail;
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ap_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ap_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ap_adjds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ap_adjd obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Ap_adjds cbds) throws CodeException {
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
        this.setadjusttot(this.getDetailAmt());
        super.save();

        for(Object o : detail.list()) {
            Ap_adjd oap_adjd = (Ap_adjd) o;

            if (oap_adjd.getID()==0) {
                oap_adjd.setlinenum(oap_adjd.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
            }
            oap_adjd.setbatchno(this.getbatchno());
            oap_adjd.setdocentry(this.getdocentry());

            oap_adjd.save();

        }


    }

    @Override
    public void delete() throws CodeException {
        detail = new Ap_adjds();
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
                            + "\n from ap_adjh where batchno=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Ap_ajdh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }


    public void getdataDetail(int index, Ap_adjd oapadjd) throws CodeException {
        if (detail.size()>0){
            oapadjd=(Ap_adjd) detail.list().get(index);

            oapadjd=new Ap_adjd(oapadjd.getID());
        }
    }
    public void replaceDetail(int index, Ap_adjd oapadjd) throws CodeException {
        detail.list().set(index, oapadjd);
    }

    public void removeDetail(int index,Ap_adjbatchlist obj) throws CodeException {

        Ap_adjd ogl_jed = (Ap_adjd) detail.list().get(index);
        ogl_jed.delete();

        detail.list().remove(index);

        obj.settotpayamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double total = 0;
        for (Object o : detail.list()) {

            Ap_adjd cbd = (Ap_adjd) o;
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
        Ap_optionaldetail1 apop = new Ap_optionaldetail1("3");
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
    public Boolean postme(Ap_adjbatchlist apadjbatch) throws CodeException {

        System.out.println("MOP " + this.getmop() + " " + this.getyop());

        Ap_invobl apinvobl=new Ap_invobl();
        apinvobl.searchData(this.getvendcode(), this.getdocnum(), this.getdoctype());

        apinvobl.setdoctotalamtr(apinvobl.getdoctotalamtr() + this.getadjusttot());
        apinvobl.setpaytotalamt(apinvobl.getpaytotalamt() + this.getadjusttot());
        apinvobl.setswpaid(apinvobl.getdoctotalamtr() == 0? "1" : "0");
        apinvobl.save();

        this.setentrysts(1);
        save();

        for(Object o : detail.list) {
            Ap_adjd adj = (Ap_adjd) o;
            adj.setlinests(1);
        }

        Ap_invobs apinvobs = new Ap_invobs();
        apinvobs.searchData(this.getvendcode(), this.getdocnum(), this.getdoctype());

        apinvobs.setdoctotalpayamtr(apinvobs.getdoctotalpayamtr() + this.getadjusttot());
        apinvobs.setswpaid(apinvobs.getdoctotalpayamtr() == 0 ? "1": "0");
        apinvobs.save();


        Ap_invobp apinvobp = new Ap_invobp();
        apinvobp.setbatchno(this.getbatchno());
        apinvobp.setdocentry(this.getdocentry());
        apinvobp.setlinenum(1);
        apinvobp.setvendcode(this.getvendcode());
        apinvobp.setdoctype(Long.parseLong(this.getdoctype()));
        apinvobp.setpaymtnum("1");
        apinvobp.setpaydate(this.getdocdate());
        apinvobp.settranstype(Long.parseLong(this.getdoctype()));
        apinvobp.setpaytotalamt(this.getadjusttot());
        apinvobp.setcurnccode(apadjbatch.getcurnccode());
        apinvobp.setratetypecode(null);
        apinvobp.setrateexch(0);
        apinvobp.setbankcode(apadjbatch.getbankcode());
        apinvobp.settrantype(Long.parseLong(apadjbatch.getbatchtype()));

        Ap_invh apinvh = new Ap_invh(Ap_invh.PROPERTY_DOCNUM, apinvobp.getdocnum());
        apinvobp.setdocnumppd(apinvh.getdocnumppd());
        
        apinvobp.setrcpdate(this.getdocdate());
        apinvobp.setyop(this.getyop());
        apinvobp.setmop(this.getmop());
        apinvobp.setobjtype(1);

        apinvobp.save();

        Ap_vendor apv = new Ap_vendor(this.getvendcode());

        Ap_vendgrpsts apgrpvsts = new Ap_vendgrpsts();
        apgrpvsts.searchData(this.getyop()+"", this.getmop()+"", apv.getgrpcode() );
        apgrpvsts.setyop(this.getyop());
        apgrpvsts.setmop(this.getmop());
        apgrpvsts.setadjcnt(apgrpvsts.getadjcnt() + 1);
        apgrpvsts.setadjamt(apgrpvsts.getadjamt() + this.getadjusttot());
        apgrpvsts.setgrpcode(apv.getgrpcode());
        apgrpvsts.save();

        Ap_vendorsts apvsts = new Ap_vendorsts();
        apvsts.searchData(this.getyop()+"", this.getmop() +"", apv.getvendcode());
        apvsts.setyop(this.getyop());
        apvsts.setmop(this.getmop());
        apvsts.setadjcnt(apgrpvsts.getadjcnt() + 1);
        apvsts.setadjamt(apgrpvsts.getadjamt() + this.getadjusttot());
        apvsts.setvendcode(apv.getvendcode());
        apvsts.save();

        return false;
    }

}




