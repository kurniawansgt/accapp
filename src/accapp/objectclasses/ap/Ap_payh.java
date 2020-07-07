/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_payhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_payh obj = new Ap_payh();
 * 
 * 2. Ap_payh obj = new Ap_payh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_payh obj = new Ap_payh(1);
 * 
 *    It Means : Select * from ap_payh where id = 1;
 * 
 * 3. Ap_payh obj = new Ap_payh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_payh obj = new Ap_payh(1);
 * 
 *    It Means : Select * from ap_payh where id = 1;
 * 
 * 4. Ap_payh obj = new Ap_payh(<primary_key>); 
 *    Sample :
 *    Ap_payh obj = new Ap_payh("1");
 *    It Means : Select * from ap_payh where <primary_key> = "1";
 * 
 * 5. Ap_payh obj = new Ap_payh(Ap_payh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_payh obj = new Ap_payh(Ap_payh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_payh where id = "1";
 * 
 * 6. Ap_payh obj = new Ap_payh();
 *    obj.loadString(Ap_payh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_payh obj = new Ap_payh();
 *    obj.loadString(Ap_payh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_payh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_payh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_payh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_payh obj = new Ap_payh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_payh obj = new Ap_payh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_payh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import accapp.objectclasses.ar.Ar_optiionaldetail1;
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
public class Ap_payh extends Ap_payhAbst{
    Ap_payds detail;
    
    Ap_remitaddress apremit;

    public Ap_remitaddress getApremit() {
        return apremit;
    }

    public void setApremit(Ap_remitaddress apremit) {
        this.apremit = apremit;
    }


    public Ap_paydmiscs getDetail2() {
        return detail2;
    }
    Ap_paydmiscs detail2;

    public Ap_payds getDetail() {
        return detail;
    }


    public Ap_payh() throws CodeException {
       detail=new Ap_payds();
       detail2=new Ap_paydmiscs();

       apremit=new Ap_remitaddress();
    }

    public Ap_payh(long id) throws CodeException {
        super(id);
    }

    public Ap_payh(String val)  throws CodeException {
        super(val);
    }

    public Ap_payh(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ap_payh(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ap_payds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ap_paydmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());

        apremit=new Ap_remitaddress();
        apremit.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ap_payds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ap_paydmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());

        apremit=new Ap_remitaddress();
        apremit.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);

        detail = new Ap_payds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail2 = new Ap_paydmiscs();
        detail2.searchData(this.getbatchno(), this.getdocentry());

        apremit=new Ap_remitaddress();
        apremit.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ap_payd obj) throws CodeException {
        detail.add(obj);
    }

    public void adddetail(Ap_paydmisc obj) throws CodeException {
        detail2.add(obj);
    }

    public void addDetails(Ap_payds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    public void addDetails(Ap_paydmiscs cbds) throws CodeException {
        this.detail2.add(cbds);
    }


    @Override
    public void saveNew() throws CodeException {
        if (this.getdocnum().equalsIgnoreCase("")){
            this.setdocnum(this.getbatchno()+"-"+this.getdocentry());
        }
        super.saveNew();

        apremit.setbatchno(this.getbatchno());
        apremit.setdocentry(this.getdocentry());
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        //this.setdoctotalamt(this.getDetailAmt());
        super.save();

        if (apremit.getremitname()!=null){
            if (!apremit.getremitname().equalsIgnoreCase("")){

                apremit.save();
            }
        }
        if (this.getdoctype().equalsIgnoreCase("5")){
            for(Object o : detail2.list()) {
                Ap_paydmisc appaydmisc = (Ap_paydmisc) o;

                if (appaydmisc.getdistrbamt()>0){
                    if (appaydmisc.getID()==0) {
                        appaydmisc.setlinenum(appaydmisc.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                    }
                    appaydmisc.setbatchno(this.getbatchno());
                    appaydmisc.setdocentry(this.getdocentry());

                    appaydmisc.save();
                }

            }
        } else {
                
            int i=detail.size();
            while (i>0){
                i--;
                Ap_payd oappayd=(Ap_payd) detail.list().get(i);
                if (oappayd.getApplied().equalsIgnoreCase("no")){
                    detail.list().remove(i);
                }
            }
            for(Object o : detail.list()) {
                Ap_payd appayd = (Ap_payd) o;


                if (appayd.getpayamt()>0&&(appayd.getApplied().equalsIgnoreCase("yes") /*||oGl_jed.getApplied().equalsIgnoreCase("Pending")*/)){

                    if (appayd.getID()==0) {
                        appayd.setlinenum(appayd.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
                        if (this.getdoctype().equalsIgnoreCase("2")){
                            appayd.setdocnumppd(getFormatedDocNum("8"));
                        }
                        if (this.getdoctype().equalsIgnoreCase("3")){
                            appayd.setdocnum(getFormatedDocNum("9"));
                        }
                    }
                    appayd.setbatchno(this.getbatchno());
                    appayd.setdocentry(this.getdocentry());
                    System.out.println("save doctype"+appayd.getdoctype());
                    appayd.save();
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
        detail = new Ap_payds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail.delete();


        detail2 = new Ap_paydmiscs();
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
                            + "\n from ap_payh where batchno=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Ap_payh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Ap_payd ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Ap_payd) detail.list().get(index);

            ogl_jed=new Ap_payd(ogl_jed.getID());
        }
    }

    public void getdataDetail2(int index, Ap_paydmisc ogl_jed) throws CodeException {
        if (detail2.size()>0){
            ogl_jed=(Ap_paydmisc) detail2.list().get(index);

            ogl_jed=new Ap_paydmisc(ogl_jed.getID());
        }
    }

    public void replaceDetail(int index, Ap_payd ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void replaceDetail(int index, Ap_paydmisc ogl_jed) throws CodeException {
        detail2.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Ap_paybatchlist obj) throws CodeException {

        Ap_payd ogl_jed = (Ap_payd) detail.list().get(index);
        if (ogl_jed.getID()>0){ogl_jed.delete();}
        if (index<detail.list().size()){
            detail.list().remove(index);
        }

        obj.settotpayamt(obj.getTotalAmount());
        obj.save();
    }

    public void removeDetail2(int index,Ap_paybatchlist obj) throws CodeException {

        Ap_paydmisc ogl_jed = (Ap_paydmisc) detail2.list().get(index);
        if (ogl_jed.getID()>0){ogl_jed.delete();}
        if (index<detail2.list().size()){
            detail2.list().remove(index);
        }

        obj.settotpayamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double totalkredit = 0;

        if (this.getdoctype().equalsIgnoreCase("5")){
            for (Object o : detail2.list()) {

                Ap_paydmisc cbd = (Ap_paydmisc) o;
                try{

                    if (cbd.getdistrbamt() >= 0) {
                        totalkredit +=  cbd.getdistrbamt();
                    }

                }catch(Exception e) {}

            }
        } else {
            for (Object o : detail.list()) {

                Ap_payd cbd = (Ap_payd) o;
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

    public Boolean postme(Ap_paybatchlist apaybath) throws CodeException{
        Ap_invobl apinvobl=new Ap_invobl();
        Ap_invobs apinvobs=new Ap_invobs();

        Ap_vendor apvend=new Ap_vendor(this.getvendcode());
        Op_paymentterm opterm=new Op_paymentterm(apvend.gettermcode());

        for (Object o:this.detail.list()){
            Ap_payd appayd=(Ap_payd) o;

            apinvobl=new Ap_invobl();
            apinvobs=new Ap_invobs();

            apinvobl.setvendcode(apvend.getvendcode());
            apinvobl.setdocnum(appayd.getdocnum());
            apinvobl.searchData(this.getvendcode(), appayd.getdocnum());
            apinvobl.setdoctotalamtr(apinvobl.getdoctotalamtr()-appayd.getpayamt());
            apinvobl.setpaytotalamt(this.getdoctotalamt());

            if (apinvobl.getdoctotalamtr()==0){
                apinvobl.setswpaid("1");
            } else {
                apinvobl.setswpaid("0");
            }
            
            apinvobl.save();

            apinvobs.searchData(this.getvendcode(), appayd.getdocnum());
            apinvobs.setvendcode(apvend.getvendcode());
            apinvobs.setdocnum(appayd.getdocnum());
            apinvobs.setdoctotalpayamtr(apinvobs.getdoctotalpayamtr()-appayd.getpayamt());
            apinvobs.setdisctotalamtr(apinvobs.getdisctotalamtr()-appayd.getdiscamt());

            

            if (apinvobs.getdoctotalpayamtr()==0){
                apinvobs.setswpaid("1");
            } else {
                apinvobs.setswpaid("0");
            }

            apinvobs.save();

            appayd.setlinests(1);
            appayd.save();

            Ap_invobp apinvobp=new Ap_invobp();
            apinvobp.searchData(apvend.getvendcode(), appayd.getdocnum());

            apinvobp.setvendcode(apvend.getvendcode());
            apinvobp.setdocnum(appayd.getdocnum());

            apinvobp.setbatchno(appayd.getbatchno());
            apinvobp.setdocentry(appayd.getdocentry());
            apinvobp.setlinenum(appayd.getlinenum());
            apinvobp.setvendcode(this.getvendcode());
            apinvobp.setdoctype(GlobalUtils.toInt(this.getdoctype()));
            apinvobp.setdocnum(appayd.getdocnum());
            apinvobp.setpaymtnum("1");
            apinvobp.setpaydate(this.getdocdate());
            apinvobp.settranstype(GlobalUtils.toInt(this.getdoctype()));
            apinvobp.setpaytotalamt(appayd.getpayamt());
            apinvobp.setcurnccode(this.getcurnccode());
            apinvobp.setratetypecode(this.getratetypecodec());
            apinvobp.setrateexch(this.getratetypeexchc());
            apinvobp.setbankcode(apaybath.getbankcode());
            apinvobp.settrantype(GlobalUtils.toInt(apaybath.getbatchtype()));
            apinvobp.setdocnumppd(appayd.getdocnumppd());
            apinvobp.setrcpdate(this.getdocdate());
            apinvobp.setyop(this.getyop());
            apinvobp.setmop(this.getmop());
            apinvobp.setobjtype(1);
            apinvobp.save();

            Ap_vendgrpsts apvendgrpsts=new Ap_vendgrpsts();
            apvendgrpsts.searchData(GlobalUtils.churuf(this.getyop()), GlobalUtils.churuf(this.getmop()), apvend.getgrpcode());

            apvendgrpsts.setgrpcode(apvend.getgrpcode());
            apvendgrpsts.setyop(this.getyop());
            apvendgrpsts.setmop(this.getmop());
            apvendgrpsts.setpaycnt(apvendgrpsts.getpaycnt()+1);
            apvendgrpsts.setpayamt(apvendgrpsts.getpayamt()+appayd.getpayamt());
            apvendgrpsts.save();

            Ap_vendorsts apvendsts=new Ap_vendorsts();
            apvendsts.searchData(GlobalUtils.churuf(this.getyop()), GlobalUtils.churuf(this.getmop()), apvend.getvendcode());

            apvendsts.setvendcode(apvend.getvendcode());
            apvendsts.setyop(this.getyop());
            apvendsts.setmop(this.getmop());
            apvendsts.setpaycnt(apvendsts.getpaycnt()+1);
            apvendsts.setpayamt(apvendsts.getpayamt()+appayd.getpayamt());
            apvendsts.save();
        }


        this.setentrysts(1);
        this.save();

        return true;
    }
    
}




