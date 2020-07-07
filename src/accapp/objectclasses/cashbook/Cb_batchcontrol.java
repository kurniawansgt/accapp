/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_batchcontrolAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_batchcontrol obj = new Cb_batchcontrol();
 * 
 * 2. Cb_batchcontrol obj = new Cb_batchcontrol(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol(1);
 * 
 *    It Means : Select * from cb_batchcontrol where id = 1;
 * 
 * 3. Cb_batchcontrol obj = new Cb_batchcontrol(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol(1);
 * 
 *    It Means : Select * from cb_batchcontrol where id = 1;
 * 
 * 4. Cb_batchcontrol obj = new Cb_batchcontrol(<primary_key>); 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol("1");
 *    It Means : Select * from cb_batchcontrol where <primary_key> = "1";
 * 
 * 5. Cb_batchcontrol obj = new Cb_batchcontrol(Cb_batchcontrol.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol(Cb_batchcontrol.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_batchcontrol where id = "1";
 * 
 * 6. Cb_batchcontrol obj = new Cb_batchcontrol();
 *    obj.loadString(Cb_batchcontrol.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol();
 *    obj.loadString(Cb_batchcontrol.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_batchcontrol where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_batchcontrol Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_batchcontrol : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_batchcontrol obj = new Cb_batchcontrol(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_batchcontrol where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;


import accapp.objectclasses.ap.Ap_paybatchlist;
import accapp.objectclasses.ap.Ap_payd;
import accapp.objectclasses.ap.Ap_payh;
import accapp.objectclasses.ar.Ar_rcpbatchlist;
import accapp.objectclasses.ar.Ar_rcpd;
import accapp.objectclasses.ar.Ar_rcph;
import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_batchlist;
import accapp.objectclasses.gl.Gl_jed;
import accapp.objectclasses.gl.Gl_jeh;
import common.jdbc.DbBean;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Cb_batchcontrol extends Cb_batchcontrolAbst{


    private Cb_batchhs cbhhs;

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Cb_batchcontrol() throws CodeException {
       setbatchsts("1");
       cbhhs = new Cb_batchhs();
    }
    
    public Cb_batchcontrol(long id) throws CodeException {
        super(id);
    }
    
    public Cb_batchcontrol(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_batchcontrol(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_batchcontrol(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,  val);
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public Cb_bank getBank() throws CodeException {
        Cb_bank cbbank = new Cb_bank(getbankcode());

        return cbbank;
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void delete() throws CodeException {

        Cb_batchhs cbhhs = new Cb_batchhs(Cb_batchh.PROPERTY_BATCHNO, this.getbatchno()+"");
        
        
        cbhhs.delete();

        super.delete();
        
    }

    public void saveNew() throws CodeException {

        Cb_optiondetail1 cbo = new Cb_optiondetail1(Cb_optiondetail1.PROPERTY_MODULID, "1");
        this.setbatchno(cbo.getdocnum());
        fromString(PROPERTY_BATCHSTS, "O");
        fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        this.setbatchdate(GlobalUtils.formatDate(GlobalUtils.sessiondate, "yyyy-MM-dd"));
        this.setsrceledgr("CB");

        this.setglpostedsts("0");
        
        super.saveNew();

        cbo.setdocnum(cbo.getdocnum()+1);
        cbo.save();

    }

    public void save() throws CodeException {
        try{
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        setobjtype(ObjectType.CB_BATCHCONTROL);
        


        super.save();


        for(Object o : cbhhs.list()) {
            Cb_batchh cbhh = (Cb_batchh) o;

            if (cbhh.getID() == 0) {
                cbhh.setentryno(cbhh.getMaxEntryNo(this.getbatchno()));
                cbhh.setcustcheqno(cbhh.getvoucherno(this.getbankcode()));
            }
            cbhh.setbatchno(this.getbatchno());
 
            cbhh.save();

        }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //untuk cbhhs
    public Cb_batchhs getCbhhs() {
        return cbhhs;
    }

    public void setCbhhs(Cb_batchhs cbhhs) {
        this.cbhhs = cbhhs;
    }

    public void addCbhh(Cb_batchh cbhh) throws CodeException {
        cbhhs.add(cbhh);
    }

    public void addCbhhs(Cb_batchhs cbhhs) throws CodeException {
        this.cbhhs.add(cbhhs);
    }


    public void replaceCbhh(int index, Cb_batchh cbhh) throws CodeException {
        cbhhs.list().set(index, cbhh);
    }

    public void removeCbhh(int index) throws CodeException {

        
        Cb_batchh cbh = (Cb_batchh) cbhhs.list().get(index);

        
        cbh.delete();
        
        cbhhs.list().remove(index);


        this.setdebittot(getTotalDebit());
        this.setcredittot(getTotalKredit());

        this.save();


    }

    //end cbhss

    public double getTotalDebit() throws CodeException {
        double totaldebit = 0;

        for (Object o: cbhhs.list()){
            Cb_batchh cbhh = (Cb_batchh) o;
            totaldebit += cbhh.getTotalDebit();
        }

        return totaldebit;
    }

    public double getTotalKredit() throws CodeException {
        double totalkredit = 0;

        for (Object o: cbhhs.list()){
            Cb_batchh cbhh = (Cb_batchh) o;
            totalkredit += cbhh.getTotalCredit();
        }

        return totalkredit;
    }


    public Boolean postme(Cb_optiondetail1 copdtl) throws CodeException{
        Boolean result=false;

        Ap_paybatchlist apinvb=new Ap_paybatchlist();

        Ar_rcpbatchlist arinvb=new Ar_rcpbatchlist();


        for (Object o:cbhhs.list()){
            Cb_batchh cbbatchh=(Cb_batchh) o;

            addtopj(cbbatchh,copdtl);

            if (cbbatchh.getentrytype().equalsIgnoreCase("P")){
                addtoapinv(cbbatchh,apinvb);
            }

            if (cbbatchh.getentrytype().equalsIgnoreCase("R")){
                addtoarinv(cbbatchh,arinvb);
            }




        }


        if (apinvb.getDetail().size()>0){
            apinvb.fromString(Ap_paybatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(GlobalUtils.getCurrentDate(),"yyyy-MM-dd")) ;
            apinvb.fromString(Ap_paybatchlist.PROPERTY_BATCHDESC, "Cashbook No:"+this.getbatchno()) ;
            apinvb.fromString(Ap_paybatchlist.PROPERTY_BATCHTYPE, "3") ;
            apinvb.fromString(Ap_paybatchlist.PROPERTY_BANKCODE, this.getbankcode()) ;
            apinvb.settotpayamt(apinvb.getTotalPayAmount());
            apinvb.setpayentrcnt(apinvb.getDetail().size()) ;
            apinvb.save();

            result=true;

        }

        if (arinvb.getDetail().size()>0){
            arinvb.fromString(Ar_rcpbatchlist.PROPERTY_BATCHDATE, GlobalUtils.formatDate(GlobalUtils.getCurrentDate(),"yyyy-MM-dd")) ;
            arinvb.fromString(Ar_rcpbatchlist.PROPERTY_BATCHDESC, "Cashbook No:"+this.getbatchno()) ;
            arinvb.fromString(Ar_rcpbatchlist.PROPERTY_BATCHTYPE, "3") ;
            arinvb.settotrcpamt(arinvb.getTotalAmount());
            arinvb.setrcpentrcnt(arinvb.getDetail().size()) ;
            arinvb.fromString(Ar_rcpbatchlist.PROPERTY_BANKCODE, this.getbankcode()) ;
            arinvb.save();

            result=true;

        }

        
        this.setpostngseq(copdtl.getdocnum());
        this.setbatchsts("P");
        this.save();

        


        
        return true;
    }

    private Boolean addtopj(Cb_batchh cbbatchh,Cb_optiondetail1 copdtl) throws CodeException{
        Cb_pjh cbpjh=new Cb_pjh();
        cbpjh.setpseqno(copdtl.getdocnum());
        cbpjh.setpseqentry(cbpjh.getMaxEntryNo(cbpjh.getpseqno()));
        cbpjh.setbatchno(this.getbatchno());
        cbpjh.setentryno(cbbatchh.getentryno());
        cbpjh.setbankcode(this.getbankcode());
        cbpjh.setreference(cbbatchh.getreference());
        cbpjh.settransdate(cbbatchh.getbatchdate());
        cbpjh.setdscription(cbbatchh.getdscription());
        cbpjh.setyop(cbbatchh.getyop());
        cbpjh.setmop(cbbatchh.getmop());
        cbpjh.setsrceledgr(this.getsrceledgr());
        cbpjh.setbatchtype(this.getbatchtype());
        cbpjh.setentrytype(cbbatchh.getentrytype());
        cbpjh.setnodetatails(cbbatchh.getnodetatails());
        cbpjh.setsrceamount(cbbatchh.gettotamount());
        cbpjh.setbankamount(cbbatchh.gettotamount());
        cbpjh.setglamount(cbbatchh.gettotamount());
        cbpjh.setmiscamount(cbbatchh.gettotamount());
        cbpjh.settaxamount(cbbatchh.gettottax());
        cbpjh.settaxpercent(cbbatchh.gettaxpercent());
        cbpjh.setmisccode(cbbatchh.getmisccode());
        cbpjh.setdistcode(cbbatchh.getdistcode());
        cbpjh.setglhomecrncy(cbbatchh.getcurnccode());
        cbpjh.setglratetype(cbbatchh.getratetype());
        //cbpjh.setglsrcecrncy(cbbatchh.getsr);
        cbpjh.setbankgldate(cbbatchh.getratedate());
        cbpjh.setbankglrate(cbbatchh.getrateamount());
        cbpjh.setbankglspread(1);
        cbpjh.setlinestatus(0);
        cbpjh.save();
        
        for (Object o:cbbatchh.getCbhds().list()){
            Cb_batchd cbbatchd=(Cb_batchd) o;
            
            Cb_pjd cbpjd=new Cb_pjd();
            cbpjd.setpseqno(copdtl.getdocnum());
            cbpjd.setpseqentry(cbpjh.getpseqentry());
            cbpjd.setpseqentrydetail(cbpjd.getMaxEntryNo(cbpjh.getpseqno(),cbpjh.getpseqentry()));
            cbpjd.setbatchno(this.getbatchno());
            cbpjd.setentryno(cbbatchd.getentryno());
            cbpjd.setdetailno(cbbatchd.getdetailno());
            cbpjd.setsrcecode(cbbatchd.getsrcecode());
            
            Gl_account glacc=new Gl_account(cbbatchd.getacccode());
            cbpjd.setaccfmttd(glacc.getaccfmttd());
            cbpjd.setaccdesc(glacc.getaccdesc());
            cbpjd.setdscription(cbbatchd.getdscription());
            cbpjd.setdetailamnt(cbbatchd.getdetailamnt());
            cbpjd.settaxcode(cbbatchd.gettaxcode());
            cbpjd.settaxtype(cbbatchd.gettaxtype());
            cbpjd.settaxpercent(cbbatchd.gettaxpercent());
            cbpjd.settaxamount(cbbatchd.gettaxamount());
            cbpjd.setcomment(cbbatchd.getcomment());
            cbpjd.setacccode(cbbatchd.getacccode());
            cbpjd.save();
            
            Cb_batchsds cbbatchsds=cbbatchd.getCbhds();
            if (cbbatchsds.size()>0){
                for (Object b:cbbatchsds.list()){
                    Cb_batchsd cbbatchsd=(Cb_batchsd) b;
                    
                    Cb_pjsd cbpjsd=new Cb_pjsd();
                    cbpjsd.setpseqno(copdtl.getdocnum());
                    cbpjsd.setpseqentry(cbpjd.getpseqentry());
                    cbpjsd.setpseqentrydetail(cbpjd.getpseqentrydetail());
                    //cbpjsd.setpseqentrysubdetail(cbpjd.getMaxEntryNo(copdtl.getdocnum(), cbpjd.getpseqentry(),cbpjd.getpseqentrydetail()));
                    cbpjsd.setbatchno(this.getbatchno());
                    cbpjsd.setentryno(cbbatchsd.getentryno());
                    cbpjsd.setdocno(cbbatchsd.getdocno());
                    Double paymentno=cbbatchsd.getpaymentno();
                    cbpjsd.setpaymentno(paymentno.longValue());
                    cbpjsd.setdoctype(cbbatchsd.getdoctype());
                    cbpjsd.setapplamount(cbbatchsd.getapplamount());
                    cbpjsd.setdiscount(cbbatchsd.getdiscount());
                    cbpjsd.setdocdate(cbbatchsd.getdocdate());
                    cbpjsd.setcustcode(cbbatchsd.getcustcode());
                    cbpjsd.setadjtamount(cbbatchsd.getadjtamount());
                    cbpjsd.save();
                    
                }
            }
        }
        
        return true;
    }
    private Boolean addtoapinv(Cb_batchh cbbatchh,Ap_paybatchlist obj) throws CodeException{
        Ap_payh appayh=new Ap_payh();

        appayh.fromString(Ap_payh.PROPERTY_REMITNAME,"-");
        appayh.fromString(Ap_payh.PROPERTY_VENDCODE,cbbatchh.getmisccode());
        appayh.fromString(Ap_payh.PROPERTY_DOCTYPE,"1");
        appayh.fromString(Ap_payh.PROPERTY_DOCNUM,cbbatchh.getcustcheqno());
        appayh.fromString(Ap_payh.PROPERTY_DSCRIPTION,"Retrieve from "+cbbatchh.getbatchno()+"-"+cbbatchh.getentryno());
        appayh.fromString(Ap_payh.PROPERTY_DOCDATE, cbbatchh.getbatchdate());
        appayh.fromString(Ap_payh.PROPERTY_MOP, cbbatchh.getmop()+"") ;
        appayh.fromString(Ap_payh.PROPERTY_YOP, cbbatchh.getyop()+"") ;

        appayh.fromString(Ap_payh.PROPERTY_CURNCCODE,cbbatchh.getcurnccode());

        appayh.fromString(Ap_payh.PROPERTY_PAYCODE,"CASH");


        

        if (cbbatchh.getCbhds().list().size()>0){
            Cb_batchd cbbatchd=(Cb_batchd) cbbatchh.getCbhds().list().get(0);
            Cb_batchsds cbbatchsds=cbbatchd.getCbhds();
            if (cbbatchsds.size()>0){
                System.out.println("Processing "+appayh.getdscription());
                for (Object o:cbbatchsds.list()){
                    Cb_batchsd cbbatchsd=(Cb_batchsd) o;
                    Ap_payd appayd=new Ap_payd();
                    appayd.setApplied("yes");
                    appayd.setdocnumppd("");
                    appayd.setdocnum(cbbatchsd.getdocno());//2"Document Number",
                    appayd.setpayamt(Math.abs(cbbatchsd.getapplamount()));//4"Applied Amount",
                    appayd.setentrydate(GlobalUtils.getAuditDate());
                    appayd.setentrysts(0);

                    appayh.adddetail(appayd);
                }
            }
        }


        if (appayh.getDetail().size()>0){
            appayh.setdoctotalamt(appayh.getDetailAmt());
            appayh.setunapltotalamtc(appayh.getunapltotalamtc());
            obj.adddetail(appayh);
        }
        
        return true;
    }

    private Boolean addtoarinv(Cb_batchh cbbatchh,Ar_rcpbatchlist obj) throws CodeException{
        Ar_rcph arrcph=new Ar_rcph();

        arrcph.fromString(Ar_rcph.PROPERTY_CUSTMRCODE,cbbatchh.getmisccode());
        arrcph.fromString(Ar_rcph.PROPERTY_DOCTYPE,"1");
        arrcph.fromString(Ar_rcph.PROPERTY_DOCNUM,cbbatchh.getcustcheqno());
        arrcph.fromString(Ar_rcph.PROPERTY_DSCRIPTION,"Retrieve from "+cbbatchh.getbatchno()+"-"+cbbatchh.getentryno());

        arrcph.fromString(Ar_rcph.PROPERTY_DOCDATE, cbbatchh.getbatchdate());
        arrcph.fromString(Ar_rcph.PROPERTY_MOP, cbbatchh.getmop()+"") ;
        arrcph.fromString(Ar_rcph.PROPERTY_YOP, cbbatchh.getyop()+"") ;

        arrcph.fromString(Ar_rcph.PROPERTY_CURNCCODE,cbbatchh.getcurnccode());
        arrcph.fromString(Ar_rcph.PROPERTY_PAYOR,"");
        arrcph.fromString(Ar_rcph.PROPERTY_PAYCODE,"CASH");

        

        if (cbbatchh.getCbhds().list().size()>0){
            Cb_batchd cbbatchd=(Cb_batchd) cbbatchh.getCbhds().list().get(0);
            Cb_batchsds cbbatchsds=cbbatchd.getCbhds();
            for (Object o:cbbatchsds.list()){
                Cb_batchsd cbbatchsd=(Cb_batchsd) o;
                Ar_rcpd arrcpd=new Ar_rcpd();

                arrcpd.setdocnumppd("");
                arrcpd.setApplied("yes");
                arrcpd.setdocnum(cbbatchsd.getdocno());//2"Document Number",
                arrcpd.setpayamt(cbbatchsd.getapplamount());//4"Applied Amount",
                arrcpd.setentrydate(GlobalUtils.getAuditDate());
                arrcpd.setentrysts(0);

                arrcph.adddetail(arrcpd);
            }
        }

        if (arrcph.getDetail().size()>0){
            arrcph.setdoctotalamt(arrcph.getDetailAmt());
            arrcph.setunapltotalamtc(0);
            obj.adddetail(arrcph);
        }
        return true;
    }

    public Boolean transfertoGL(Cb_optiondetail1 copdtl,Gl_batchlist glbatchl) throws CodeException{

        Cb_pjh cbpjh=new Cb_pjh(Cb_pjh.PROPERTY_PSEQNO,GlobalUtils.churuf(this.getpostngseq()));

        Gl_jeh gljeh=new Gl_jeh();
        gljeh.fromString(Gl_jeh.PROPERTY_BTCHENTRYDATE, GlobalUtils.getCurrentDate());
        gljeh.setsrcelgrcode("CB");
        gljeh.setsrcetypecode("CB");
        gljeh.setyop(GlobalUtils.toInt(GlobalUtils.getCurrentYear()));
        gljeh.setmop(GlobalUtils.toInt(GlobalUtils.getCurrentMonth()));
        gljeh.setswedit(1);
        gljeh.setswreverse(1);
        gljeh.setjrnldesc(cbpjh.getdscription());
	gljeh.setjrnldebit(0);
        gljeh.setjrnlcredit(0);
        gljeh.setjrnlquantity(0);


        for (Object o:this.getCbhhs().list()){
            Cb_batchh cbbatch=(Cb_batchh) o;
            
            adddetailtogl(gljeh, cbbatch, cbpjh);
        }

        glbatchl.adddetail(gljeh);

        return true;
    }

    public Boolean adddetailtogl(Gl_jeh gljeh,Cb_batchh cbbatch,Cb_pjh cbpjh) throws CodeException{
        for (Object o: cbbatch.getCbhds().list()){
            Cb_batchd cbbatchd=(Cb_batchd) o;

            Gl_jed gljed=new Gl_jed();
            gljed.setacccode(cbbatchd.getacccode());

            if (cbbatchd.getdetailamnt()>0){
                gljed.settransamtdbt(gljed.gettransamtdbt()+Math.abs(cbbatchd.getdetailamnt()));
            } else {
                gljed.settransamtcrd(gljed.gettransamtcrd()+Math.abs(cbbatchd.getdetailamnt()));
            }
            
            gljed.settransqty(1);
            gljed.setcurnccode(cbpjh.getglhomecrncy());
            gljed.setsrcecurnccode(cbpjh.getglsrcecrncy());
            gljed.setratetype(cbpjh.getglratetype());
            gljed.setrate(cbpjh.getbankglrate());
            gljed.setfuncamtdbt(0);
            gljed.setfuncamtcrd(0);
            gljed.settransdesc(cbpjh.getdscription());
            gljed.settransref(cbpjh.getreference());
            gljed.settransdate(GlobalUtils.formatDate(GlobalUtils.getCurrentDate(),"yyyy-MM-dd"));
            gljed.setsrcelgrcode("CB");
            gljed.setsrcetypecode("CB");
            gljed.setjecomment("");

            gljeh.adddetail(gljed);
        }
        return true;
    }

    public boolean  checkCBPostingSP(String vbatchnofr,String vbatchnoto,String vbankcodefr,String vbankcodeto) throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM cb_batchcontrol "+
                        "where 	batchsts='O' and  "+
                        "batchno BETWEEN "+vbatchnofr+" AND "+vbatchnoto+" AND "+
                        "bankcode BETWEEN '"+vbankcodefr+"' AND '"+vbankcodeto+"'; ";
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

    public Boolean runCBPostingSP(String vbatchnofr,String vbatchnoto,String vbankcodefr,String vbankcodeto) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getCBPostingSP(vbatchnofr,vbatchnoto,vbankcodefr,vbankcodeto));
         } catch (Exception ex) {
             throw new CodeException("cb_batchcontrol : " + ex.getMessage());
         }finally{
           result=true;
           db.close();
         }

       return result;
    }

    public String getCBPostingSP(String vbatchnofr,String vbatchnoto,String vbankcodefr,String vbankcodeto) throws CodeException {
        String query="call sp_create_cbpostjournal ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"',"+vbatchnofr+","+vbatchnoto+",'"+vbankcodefr+"','"+vbankcodeto+"','"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
        System.out.println(query);
        return query;
    }

    public boolean  checkCBPostingToGLSP(String vbankcodefr,String vbankcodeto,String sbatchdatefr,String sbatchdateto) throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM cb_batchcontrol "+
                        "where 	batchsts='P' AND glpostedsts='0' and "+
                        "bankcode BETWEEN '"+vbankcodefr+"' AND '"+vbankcodeto+"' and "
                        + "date(batchdate) between '"+sbatchdatefr+"' and '"+sbatchdateto+"' ;";
         try {
               System.out.println(query);
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

    public Boolean runCBPostingToGLSP(String vbankcodefr,String vbankcodeto,String sbatchdatefr,String sbatchdateto) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getCBPostingToGLSP(vbankcodefr,vbankcodeto,sbatchdatefr,sbatchdateto));
         } catch (Exception ex) {
             throw new CodeException("cb_batchcontrol : " + ex.getMessage());
         }finally{
           result=true;
           db.close();
         }

       return result;
    }

    public String getCBPostingToGLSP(String vbankcodefr,String vbankcodeto,String sbatchdatefr,String sbatchdateto) throws CodeException {
        String query="call sp_create_cbpostingtoglbatch ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+vbankcodefr+"','"+vbankcodeto+"','"+sbatchdatefr+"','"+sbatchdateto+"','"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
        System.out.println(query);
        return query;
    }
}




