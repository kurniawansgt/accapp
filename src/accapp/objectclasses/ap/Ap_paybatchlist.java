/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_paybatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_paybatchlist obj = new Ap_paybatchlist();
 * 
 * 2. Ap_paybatchlist obj = new Ap_paybatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist(1);
 * 
 *    It Means : Select * from ap_paybatchlist where id = 1;
 * 
 * 3. Ap_paybatchlist obj = new Ap_paybatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist(1);
 * 
 *    It Means : Select * from ap_paybatchlist where id = 1;
 * 
 * 4. Ap_paybatchlist obj = new Ap_paybatchlist(<primary_key>); 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist("1");
 *    It Means : Select * from ap_paybatchlist where <primary_key> = "1";
 * 
 * 5. Ap_paybatchlist obj = new Ap_paybatchlist(Ap_paybatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist(Ap_paybatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_paybatchlist where id = "1";
 * 
 * 6. Ap_paybatchlist obj = new Ap_paybatchlist();
 *    obj.loadString(Ap_paybatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist();
 *    obj.loadString(Ap_paybatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_paybatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_paybatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_paybatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_paybatchlist obj = new Ap_paybatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_paybatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_paybatchlist extends Ap_paybatchlistAbst{
    private Ap_payhs detail;

    private Integer dtlslctdindx=0;

    public Ap_payhs getDetail() {
        return detail;
    }

    public void setDetail(Ap_payhs detail) {
        this.detail = detail;
    }

    public Integer getDtlslctdindx() {
        return dtlslctdindx;
    }

    public void setDtlslctdindx(Integer dtlslctdindx) {
        this.dtlslctdindx = dtlslctdindx;
    }

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Ap_paybatchlist() throws CodeException {
       detail=new Ap_payhs();
    }

    public Ap_paybatchlist(long id) throws CodeException {
        super(id);
    }

    public Ap_paybatchlist(String val)  throws CodeException {
        super(val);
    }

    public Ap_paybatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ap_paybatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void adddetail(Ap_payh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ap_payhs Ap_payhs) throws CodeException {
        this.detail.add(Ap_payhs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        Ap_payhs cbhhs = new Ap_payhs(Ap_payh.PROPERTY_BATCHNO, this.getbatchno()+"");
        cbhhs.delete();

        super.delete();
    }


    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getBatchNoAuto ());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setswprinted("1");
        this.setglpostedsts("0");
        this.setbatchsts("0");
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setpayentrcnt(detail.list().size());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.settotpayamt(this.getTotalAmount());
        super.save();

        for(Object o : detail.list()) {
            Ap_payh oAp_payh = (Ap_payh) o;

            if (oAp_payh.getID() == 0||oAp_payh.getID()==NULLID) {
                oAp_payh.setdocentry(oAp_payh.getMaxbtchentry((int)this.getbatchno()));
            }
            oAp_payh.setbatchno(this.getbatchno());

            oAp_payh.save();

        }

        this.setpayentrcnt(detail.size());
        this.settotpayamt(this.getTotalPayAmount());
        this.setfuncamt(this.gettotpayamt());
        super.save();

    }

    private Long getBatchNoAuto() throws CodeException{
        long docnum=0;
        Ap_optionaldetail1 apop = new Ap_optionaldetail1("2");
        if (apop.getdocnumid()>0){
            docnum=apop.getdocnum();
            docnum++;

            apop.setdocnum(docnum);
            apop.save();
        }
        return docnum;

    }

    public String getstatusdescription() throws CodeException{
        String result="Open";
        if (this.getbatchsts()!=null){
            if (this.getbatchsts().equalsIgnoreCase("1")){
                result="Open";
            }
            if (this.getbatchsts().equalsIgnoreCase("2")){
                result="Posted";
            }
            if (this.getbatchsts().equalsIgnoreCase("3")){
                result="Error";
            }
            if (this.getbatchsts().equalsIgnoreCase("4")){
                 result="Delete";
            }
        }
        return result;
    }

    public String gettypedescription() throws CodeException{
        String result="Entries";
        if (this.getbatchtype()!=null){
            if (this.getbatchtype().equalsIgnoreCase("1")){
                result="Entries";
            }
            if (this.getbatchtype().equalsIgnoreCase("2")){
                result="Import";
            }
            if (this.getbatchtype().equalsIgnoreCase("3")){
                 result="Genered";
            }
        }
        return result;
    }

    public void getdataDetail(int index, Ap_payh oAp_payh) throws CodeException {
        if (detail.size()>0){
            oAp_payh=(Ap_payh) detail.list().get(index);

            oAp_payh=new Ap_payh(oAp_payh.getID());
        }
    }
    public void replaceDetail(int index, Ap_payh oAp_payh) throws CodeException {
        detail.list().set(index, oAp_payh);
    }

    public void removeDetail(int index) throws CodeException {

        Ap_payh oAp_payh = (Ap_payh) detail.list().get(index);
        oAp_payh.delete();

        detail.list().remove(index);

        this.setpayentrcnt(detail.list().size());
        this.save();
    }

    /**
     * @return the dtlslctdindx
     */


    public double getTotalAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ap_payh cbhh = (Ap_payh) o;
            totaldebit += cbhh.getdoctotalamt();
        }

        return totaldebit;
    }

    public double getTotalPayAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ap_payh cbhh = (Ap_payh) o;
            totaldebit += cbhh.getDetailAmt();
        }

        return totaldebit;
    }


    private String batchtypedesc(String batchtype){
        String result="";

        return result;

    }

    public Boolean posting() throws CodeException{
        for (Object o: this.detail.list()){
            Ap_payh appayh=(Ap_payh) o;
            appayh.postme(this);
        }

        Ap_optionaldetail1 aroptd=new Ap_optionaldetail1("6");
        aroptd.setdocnum(aroptd.getdocnum()+1);
        aroptd.save();

        this.setpostngseq(aroptd.getdocnum());
        this.setbatchsts("2");
        this.save();
        return true;
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
             throw new CodeException("ap_paybatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ap_paybatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }

    public int runAPPaymentPosting(int frombatchno,int tobatchno) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
            db.updateSQL(getAPPaymentPosting(frombatchno,tobatchno));
            entry=1;
         } catch (Exception ex) {
             throw new CodeException("ap_paybatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public boolean  checkAPPaymentPosting(int frombatchno,int tobatchno) throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_paybatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public String getAPPaymentPosting(int frombatchno,int tobatchno) throws CodeException {
           String query = "call sp_appaymentposting("+frombatchno+","+tobatchno+",'"+GlobalUtils.userid+"','"+GlobalUtils.password+"')";
           return query;

    }

    public int runAPPaymentToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
             db.updateSQL(getAPPaymentToGl_batchlist_SP());
//            db.updateSQL(getAPPaymentToGl_batchlist());
//            db.updateSQL(getAPPaymentToGl_jeh());
//            db.updateSQL(getAPPaymentToGl_jed());
//            db.updateSQL(getAPPaymentToGl_optiondetail1());
//            db.updateSQL(getAPPaymentToAp_optionaldetail1());
//            db.updateSQL(getAPPaymentToAp_paybatchlist());

         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public String getAPPaymentToGl_batchlist_SP() throws CodeException {
           String query = "call sp_create_appayment_to_glbatch ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"')";
           return query;
    }

    public boolean  checkAPPaymentTransfer() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_paybatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public String getAPPaymentToGl_batchlist() throws CodeException {
           String query = "/* -- ap payment to gl journal entry -- */ "
                            + "\n /* -- ap to gl_batchcontrol --- */ "
                            + "\n INSERT INTO gl_batchlist "
                            + "\n ( "
                            + "\n batchid, readytpost, btchdesc, srceledgr, batchdate, batchtype,  "
                            + "\n batchsts, postngseq, debittot, credittot, qtytotal, entrycnt, nextentry,  "
                            + "\n entrydate, auditdate, audituser, objtype, cmpnyid  "
                            + "\n ) "
                            + "\n SELECT @batchid AS batchid,'1' readytpost, 'AP-IN Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                            + "\n 1 AS batchsts, 0 AS postngseq, SUM(transamtdbt)  AS debittot, SUM(transamtcrd) AS credittot,  "
                            + "\n 1 AS qtytotal,  "
                            + "\n (SELECT COUNT(*) FROM ap_invbatchlist  WHERE batchsts=2  AND glpostedsts='0' AND "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq=a.postngseq,TRUE) ) AS entrycnt,  "
                            + "\n @batchid:=@batchid+1 AS nextentry,  "
                            + "\n NOW() AS entrydate, NOW() AS auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser, 0 AS objtype, '"+GlobalUtils.company+"' AS cmpnyid  "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON a.batchno=b.batchno "
                            + "\n INNER JOIN ( "
                            + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                            + "\n FROM "
                            + "\n ( "
                            + "\n /* --- journal Vendor/Utang  ---*/ "
                            + "\n /* --- doctype 1=payment 2=Prepayment 3=Apply Document 4=Misc. Payment --*/ "
                            + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                            + "\n /* jika tipe dok cn kolom debet selain credit */ "
                            + "\n IF(b.doctype=1,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=1,b.doctotalamt,0) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=1 "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT c.vendcode,c.docnum, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                            + "\n IF(NOT b.doctype=1,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=1,c.payamt,0) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                            + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=1 "
                            + "\n UNION ALL "
                            + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                            + "\n /* jika tipe dok cn kolom debet selain credit */ "
                            + "\n IF(b.doctype=2,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=2,b.doctotalamt,0) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=2 "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT c.vendcode,c.docnum, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                            + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                            + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT c.vendcode,c.docnumppd, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                            + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                            + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT c.vendcode,c.docnumppd, "
                            + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                            + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                            + "\n IF(NOT b.doctype=2,c.payamt,0) AS transamtdbt,IF(NOT b.doctype=2,0,c.payamt) AS transamtcrd, "
                            + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                            + "\n FROM ap_paybatchlist a  "
                            + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                            + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                            + "\n ) AS a "
                            + "\n GROUP BY a.batchno,a.docentry "
                            + "\n ) AS z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                            + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                            + "\n WHERE batchsts=2  AND glpostedsts='0' "
                            + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',a.postngseq,0) "
                            + "\n ORDER BY @batchid; ";

           return query;

    }

    public String getAPPaymentToGl_jeh() throws CodeException {
        String query = "/* -- ap to gl_jh --- */ "
                    + "\n INSERT INTO gl_jeh "
                    + "\n ( "
                    + "\n batchid, btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                    + "\n yop, mop, swedit, swreverse, jrnldesc,  "
                    + "\n jrnldebit, jrnlcredit, jrnlquantity,  "
                    + "\n entrydate, auditdate "
                    + "\n ) "
                    + "\n SELECT  batchid, btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                    + "\n yop, mop, swedit, swreverse, jrnldesc,  "
                    + "\n jrnldebit, jrnlcredit, jrnlquantity,  "
                    + "\n entrydate, auditdate "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT  @b AS b,a.postngseq, "
                    + "\n @batchid:=IF(@b<>a.postngseq,@batchid+1,@batchid) AS batchid, "
                    + "\n @NO:=IF(@b<>a.postngseq,1,@NO+1) AS btchentry,@b:=a.postngseq AS b2, "
                    + "\n NOW() AS btchentrydate,'AP' AS srcelgrcode, 'PY' AS srcetypecode, "
                    + "\n YEAR(NOW()) AS yop,MONTH(NOW()) AS mop,1 AS swedit,1 AS swreverse,a.dscription AS jrnldesc, "
                    + "\n jrnldebit, jrnlcredit, 1 AS jrnlquantity,  "
                    + "\n NOW() AS entrydate, NOW() AS auditdate "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq,b.batchno,b.dscription,SUM(z.transamtdbt) AS jrnldebit,SUM(z.transamtdbt) AS jrnlcredit "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                    + "\n INNER JOIN  "
                    + "\n ( "
                    + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                    + "\n /* jika tipe dok cn kolom debet selain credit */ "
                    + "\n IF(b.doctype=1,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=1,b.doctotalamt,0) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                    + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=1 "
                    + "\n UNION ALL "
                    + "\n /* --- journal detail ---*/ "
                    + "\n SELECT c.vendcode,c.docnum, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                    + "\n IF(NOT b.doctype=1,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=1,c.payamt,0) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                    + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=1 "
                    + "\n UNION ALL "
                    + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                    + "\n /* jika tipe dok cn kolom debet selain credit */ "
                    + "\n IF(b.doctype=2,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=2,b.doctotalamt,0) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                    + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=2 "
                    + "\n UNION ALL "
                    + "\n /* --- journal detail ---*/ "
                    + "\n SELECT c.vendcode,c.docnum, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                    + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                    + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                    + "\n UNION ALL "
                    + "\n /* --- journal detail ---*/ "
                    + "\n SELECT c.vendcode,c.docnumppd, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                    + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                    + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                    + "\n UNION ALL "
                    + "\n /* --- journal detail ---*/ "
                    + "\n SELECT c.vendcode,c.docnumppd, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                    + "\n IF(NOT b.doctype=2,c.payamt,0) AS transamtdbt,IF(NOT b.doctype=2,0,c.payamt) AS transamtcrd, "
                    + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                    + "\n FROM ap_paybatchlist a  "
                    + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                    + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                    + "\n ) AS a "
                    + "\n GROUP BY a.batchno,a.docentry "
                    + "\n ) z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                    + "\n ,(SELECT @NO:=0) AS NO,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)-1) AS a, "
                    + "\n (SELECT @b:='') AS b "
                    + "\n WHERE a.batchsts=2  AND a.glpostedsts='0' "
                    + "\n GROUP BY a.postngseq,b.batchno,b.docentry "
                    + "\n ) AS a "
                    + "\n /*b.pseqno,b.pseqentry*/ "
                    + "\n ) AS aa; ";

        return query;
    }

    public String getAPPaymentToGl_jed() throws CodeException {
        String query = "/* -- ap to gl_jd -- */ "
                        + "\n INSERT INTO gl_jed "
                        + "\n ( "
                        + "\n btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd, transqty, curnccode,  "
                        + "\n srcecurnccode, ratetype, rate, funcamtdbt, funcamtcrd, transdesc, transref, transdate,  "
                        + "\n srcelgrcode, srcetypecode, jecomment, entrydate, auditdate, audituser,  cmpnyid "
                        + "\n ) "
                        + "\n SELECT  "
                        + "\n btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd, transqty, curnccode,  "
                        + "\n srcecurnccode, ratetype, rate, funcamtdbt, funcamtcrd, transdesc, transref, transdate,  "
                        + "\n srcelgrcode, srcetypecode, jecomment, entrydate, auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser,'"+GlobalUtils.company+"' AS cmpnyid "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT  @btchentry:=IF(@b<>a.postngseq,@btchentry+1,@btchentry) AS btchentry, "
                        + "\n @d:=IF(@c<>docentry,IF(@b<>a.postngseq,1,@d+1),@d) AS journalid, "
                        + "\n @transnbr:=IF(@e<>@d,1,@transnbr+1) AS transnbr, "
                        + "\n @b:=a.postngseq AS b2,@c:=docentry AS c2,@e:=@d AS d2, "
                        + "\n a.accglcode AS acccode,  "
                        + "\n a.transamtdbt,  "
                        + "\n a.transamtcrd,  "
                        + "\n 1 AS transqty, a.curnccode,a.curnccode AS srcecurnccode, "
                        + "\n a.ratetype AS ratetype, a.rate AS rate, a.rate*a.transamtdbt AS funcamtdbt,  "
                        + "\n a.rate*a.transamtcrd AS funcamtcrd,a.transdesc, a.transref, NOW() AS transdate,  "
                        + "\n 'PI' AS srcelgrcode, 'AP' AS srcetypecode, a.comment AS jecomment, NOW() AS entrydate, NOW() AS auditdate,  "
                        + "\n 'admin' AS audituser "
                        + "\n  "
                        + "\n FROM "
                        + "\n ( "
                        + "\n /* --- journal Vendor/Utang  ---*/ "
                        + "\n /* --- doctype 1=payment 2=Prepayment 3=Apply Document 4=Misc. Payment --*/ "
                        + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                        + "\n /* jika tipe dok cn kolom debet selain credit */ "
                        + "\n IF(b.doctype=1,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=1,b.doctotalamt,0) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=1 "
                        + "\n UNION ALL "
                        + "\n /* --- journal detail ---*/ "
                        + "\n SELECT c.vendcode,c.docnum, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                        + "\n IF(NOT b.doctype=1,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=1,c.payamt,0) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=1 "
                        + "\n UNION ALL "
                        + "\n SELECT b.vendcode AS transref,b.docnum AS transdesc, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,0 AS linenum,cb.bankacccode AS accglcode , "
                        + "\n /* jika tipe dok cn kolom debet selain credit */ "
                        + "\n IF(b.doctype=2,0,b.doctotalamt) AS transamtdbt,IF(b.doctype=2,b.doctotalamt,0) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN cb_bank cb ON cb.bankcode=a.bankcode "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  AND b.doctype=2 "
                        + "\n UNION ALL "
                        + "\n /* --- journal detail ---*/ "
                        + "\n SELECT c.vendcode,c.docnum, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,e.apacccode AS accglcode , "
                        + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                        + "\n UNION ALL "
                        + "\n /* --- journal detail ---*/ "
                        + "\n SELECT c.vendcode,c.docnumppd, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                        + "\n IF(NOT b.doctype=2,0,c.payamt) AS transamtdbt,IF(NOT b.doctype=2,c.payamt,0) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                        + "\n UNION ALL "
                        + "\n /* --- journal detail ---*/ "
                        + "\n SELECT c.vendcode,c.docnumppd, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,e.prepayacccode AS accglcode , "
                        + "\n IF(NOT b.doctype=2,c.payamt,0) AS transamtdbt,IF(NOT b.doctype=2,0,c.payamt) AS transamtcrd, "
                        + "\n b.curnccode,d.ratetype, b.ratetypeexchb AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_payd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' AND b.doctype=2 "
                        + "\n ) AS a, "
                        + "\n (SELECT @NO:=0) AS aNO, "
                        + "\n (SELECT @btchentry:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)-1 ) AS abtchentry, "
                        + "\n (SELECT @journalid:=0 ) AS ajournalid, "
                        + "\n (SELECT @transnbr:=1 ) AS atransnbr, "
                        + "\n (SELECT @b:=0) AS acounterb,(SELECT @c:=0) AS acounterc ,(SELECT @d:=0) AS acounterd ,(SELECT @e:=0) AS acountere "
                        + "\n  "
                        + "\n ORDER BY a.postngseq,a.batchno,a.docentry,a.visorder,a.linenum "
                        + "\n  "
                        + "\n ) AS a "
                        + "\n ORDER BY ABS(btchentry), journalid, transnbr; ";

        return query;
    }

    public String getAPPaymentToGl_optiondetail1() throws CodeException {
        String query = "\n /* --- update gl_optiondetail1 u/  docnum -- */ "
                        + "\n UPDATE gl_optiondetail1 a , "
                        + "\n ( "
                        + "\n SELECT MAX(batchid)+1 AS batchid  "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT @batchid AS batchid,'1' readytpost, 'AP-IN Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                        + "\n 1 AS batchsts, 0 AS postngseq, SUM(0)  AS debittot, SUM(0) AS credittot,  "
                        + "\n 1 AS qtytotal,  "
                        + "\n (SELECT COUNT(*) FROM ap_invbatchlist  WHERE batchsts=2  AND glpostedsts='0' AND "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq=a.postngseq,TRUE) ) AS entrycnt,  "
                        + "\n @batchid:=@batchid+1 AS nextentry,  "
                        + "\n NOW() AS entrydate, NOW() AS auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser, 0 AS objtype, '"+GlobalUtils.company+"' AS cmpnyid  "
                        + "\n FROM ap_paybatchlist a  "
                        + "\n INNER JOIN ap_payh b ON a.batchno=b.batchno "
                        + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                        + "\n WHERE batchsts=2  AND glpostedsts='0' "
                        + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',a.postngseq,0) "
                        + "\n ORDER BY @batchid "
                        + "\n ) AS a "
                        + "\n ) AS a2 SET a.docnum=a2.batchid "
                        + "\n WHERE a.modulid=1 AND ((SELECT COUNT(*) FROM ap_paybatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";


        return query;
    }

    public String getAPPaymentToAp_optionaldetail1() throws CodeException {
        String query = "\n /* posisi sebelumnya sebelum update gl_optiondetail1 u/  docnum */ "
                        + "\n /* --- update ap_invbatchlist u/  glpostedsts , glpostngseq, glposteddate -- */ "
                        + "\n  "
                        + "\n /* --- update ap_optionaldetail1 GL Posting Seq docnumid=7 -- */ "
                        + "\n UPDATE ap_optionaldetail1 SET docnum=docnum+1 WHERE docnumid=8 "
                        + "\n AND ((SELECT COUNT(*) FROM ap_paybatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";

        return query;
    }

    public String getAPPaymentToAp_paybatchlist() throws CodeException {
        String query ="\n UPDATE ap_paybatchlist  "
                    + "\n SET glpostedsts='1' ,  "
                    + "\n glpostngseq=(SELECT docnum FROM ap_optionaldetail1 WHERE docnumid=8)-1,  "
                    + "\n glposteddate=NOW() "
                    + "\n WHERE batchsts=2 AND glpostedsts='0'; ";
        return query;
    }
}




