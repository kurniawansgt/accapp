/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_adjbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_adjbatchlist obj = new Ap_adjbatchlist();
 * 
 * 2. Ap_adjbatchlist obj = new Ap_adjbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist(1);
 * 
 *    It Means : Select * from ap_adjbatchlist where id = 1;
 * 
 * 3. Ap_adjbatchlist obj = new Ap_adjbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist(1);
 * 
 *    It Means : Select * from ap_adjbatchlist where id = 1;
 * 
 * 4. Ap_adjbatchlist obj = new Ap_adjbatchlist(<primary_key>); 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist("1");
 *    It Means : Select * from ap_adjbatchlist where <primary_key> = "1";
 * 
 * 5. Ap_adjbatchlist obj = new Ap_adjbatchlist(Ap_adjbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist(Ap_adjbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_adjbatchlist where id = "1";
 * 
 * 6. Ap_adjbatchlist obj = new Ap_adjbatchlist();
 *    obj.loadString(Ap_adjbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist();
 *    obj.loadString(Ap_adjbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_adjbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_adjbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_adjbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_adjbatchlist obj = new Ap_adjbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_adjbatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap.adjustment;

import accapp.objectclasses.ap.Ap_optionaldetail1;
import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_adjbatchlist extends Ap_adjbatchlistAbst{
    private  Ap_adjhs detail;
    private Integer dtlslctdindx=0;

    public Ap_adjbatchlist() throws CodeException {
       detail = new Ap_adjhs();
    }
    
    public Ap_adjbatchlist(long id) throws CodeException {
        super(id);
    }
    
    public Ap_adjbatchlist(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_adjbatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_adjbatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }

    public Ap_adjhs getDetail() {
        return detail;
    }

    public void setDetail(Ap_adjhs detail) {
        this.detail = detail;
    }

    public Integer getDtlslctdindx() {
        return dtlslctdindx;
    }

    public void setDtlslctdindx(Integer dtlslctdindx) {
        this.dtlslctdindx = dtlslctdindx;
    }
    public void adddetail(Ap_adjh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ap_adjhs Ap_adjhs) throws CodeException {
        this.detail.add(Ap_adjhs);
    }
    public void getdataDetail(int index, Ap_adjh oAp_adjh) throws CodeException {
        if (detail.size()>0){
            oAp_adjh=(Ap_adjh) detail.list().get(index);

            oAp_adjh=new Ap_adjh(oAp_adjh.getID());
        }
    }
    public void replaceDetail(int index, Ap_adjh oAp_adjh) throws CodeException {
        detail.list().set(index, oAp_adjh);
    }

    public void removeDetail(int index) throws CodeException {

        Ap_adjh oAp_adjh = (Ap_adjh) detail.list().get(index);
        oAp_adjh.delete();

        detail.list().remove(index);

        this.setpayentrcnt(detail.list().size());
        this.save();
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        try{
            Ap_adjhs cbhhs = new Ap_adjhs(Ap_adjh.PROPERTY_BATCHNO, this.getbatchno()+"");
            cbhhs.delete();
        }catch(Exception e) {}

        super.delete();
    }


    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getBatchNoAuto ());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setswprinted("1");
        this.setglpostedsts("0");
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
            Ap_adjh oAp_adjh = (Ap_adjh) o;

            if (oAp_adjh.getID() == 0||oAp_adjh.getID()==NULLID) {
                oAp_adjh.setdocentry(oAp_adjh.getMaxbtchentry((int)this.getbatchno()));
            }
            oAp_adjh.setbatchno(this.getbatchno());

            if (oAp_adjh.getadjno() == 0) {
                Ap_optionaldetail1 apo = new Ap_optionaldetail1(Ap_optionaldetail1.PROPERTY_DOCNUMID, "12");
                oAp_adjh.setadjno(apo.getdocnum() + 1);
                apo.setdocnum(apo.getdocnum() + 1);
                apo.save();
            }

            oAp_adjh.save();

        }

        this.setpayentrcnt(detail.size());
        this.settotpayamt(this.getTotalPayAmount());
        this.setfuncamt(this.gettotpayamt());
        super.save();

    }
    public double getTotalPayAmount() throws CodeException {
        double totaldebit = 0;

        try{
            for (Object o: detail.list()){
                Ap_adjh cbhh = (Ap_adjh) o;
                totaldebit += cbhh.getDetailAmt();
            }
        }catch(Exception e) {}
        

        return totaldebit;
    }

    private Long getBatchNoAuto() throws CodeException{
        long docnum=0;
        Ap_optionaldetail1 apop = new Ap_optionaldetail1("3");
        if (apop.getdocnumid()>0){
            docnum=apop.getdocnum();
            docnum++;

            apop.setdocnum(docnum);
            apop.save();
        }
        return docnum;

    }
    public double getTotalAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ap_adjh cbhh = (Ap_adjh) o;
            totaldebit += cbhh.getadjusttot();
        }

        return totaldebit;
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


    public Boolean posting() throws CodeException{
        for (Object o:this.detail.list()){
            Ap_adjh apinvh=(Ap_adjh) o;
            apinvh.postme(this);
        }
        Ap_optionaldetail1 apop = new Ap_optionaldetail1("11");
        apop.setdocnum(apop.getdocnum() + 1);
        apop.save();

        this.setpostngseq(apop.getdocnum());
        this.setreadytpost("1");
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
             throw new CodeException("ap_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ap_adjbatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }

    public boolean  checkAPAdjustmentPosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_adjbatchlist  WHERE readytpost='1' AND batchsts='1' ";

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

    public Boolean runAPAdjustmentPosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getAPAdjustmentPosting(sbatchnofr ,sbatchnoto ));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ap_adjbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getAPAdjustmentPosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
           String query = "call sp_apadjustmentposting("+sbatchnofr+","+sbatchnoto+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
           System.out.println(query);
            return query;
    }

    public boolean  checkAPAdjustmentTransfer() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_adjbatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public int runAPAdjustmentToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
            db.updateSQL(getAPAdjustmentToGl_batchlistSP());
         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public String getAPAdjustmentToGl_batchlistSP() throws CodeException {
        String query = "call sp_create_apadjustment_to_glbatch ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"')";
        return query;
    }

    public String getAPAdjustmentToGl_batchlist() throws CodeException {
        String query = "/* -- ap adjustmen to gl journal entry -- */ "
                        + "\n INSERT INTO gl_batchlist "
                        + "\n ( "
                        + "\n batchid, readytpost, btchdesc, srceledgr, batchdate, batchtype,  "
                        + "\n batchsts, postngseq, debittot, credittot, qtytotal, entrycnt, nextentry,  "
                        + "\n entrydate, auditdate, audituser, objtype, cmpnyid  "
                        + "\n ) "
                        + "\n SELECT @batchid AS batchid,'1' readytpost, 'AP-AD Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                        + "\n 1 AS batchsts, 0 AS postngseq, SUM(transamtdbt)  AS debittot, SUM(transamtcrd) AS credittot,  "
                        + "\n 1 AS qtytotal,  "
                        + "\n (SELECT COUNT(*) FROM ap_adjbatchlist  WHERE batchsts=2  AND glpostedsts='0' AND "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq=a.postngseq,TRUE) ) AS entrycnt,  "
                        + "\n @batchid:=@batchid+1 AS nextentry,  "
                        + "\n NOW() AS entrydate, NOW() AS auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser, 0 AS objtype, '"+GlobalUtils.company+"' AS cmpnyid  "
                        + "\n FROM ap_adjbatchlist a  "
                        + "\n INNER JOIN ap_adjh b ON a.batchno=b.batchno "
                        + "\n INNER JOIN ( "
                        + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                        + "\n FROM "
                        + "\n ( "
                        + "\n  "
                        + "\n SELECT d.vendcode AS transref ,b.docnum AS transdesc, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,1) AS postngseq, "
                        + "\n a.batchno,b.docentry,1 AS linenum,e.apacccode AS accglcode , "
                        + "\n IF(b.adjusttot>0,0,ABS(b.adjusttot)) AS transamtdbt,IF(b.adjusttot>0,ABS(b.adjusttot),0) AS transamtcrd, "
                        + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                        + "\n FROM ap_adjbatchlist a  "
                        + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                        + "\n UNION ALL "
                        + "\n SELECT d.vendcode,adjno AS docnum, "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,c.acccode AS accglcode , "
                        + "\n IF(c.distamt>0,ABS(c.distamt),0) AS transamtdbt,IF(c.distamt>0,0,ABS(c.distamt)) AS transamtcrd, "
                        + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                        + "\n FROM ap_adjbatchlist a  "
                        + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_adjd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                        + "\n  "
                        + "\n ) AS a "
                        + "\n GROUP BY a.batchno,a.docentry "
                        + "\n ) AS z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                        + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                        + "\n WHERE batchsts=2  AND glpostedsts='0' "
                        + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',a.postngseq,1) "
                        + "\n ORDER BY @batchid; ";
        return query;

    }

    public String getAPAdjustmentToGl_jeh() throws CodeException {
        String query ="/* -- ap adj to gl_jh --- */ "
                    + "\n INSERT INTO gl_jeh "
                    + "\n ( "
                    + "\n batchid, btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                    + "\n yop, mop, swedit, swreverse, jrnldesc,  "
                    + "\n jrnldebit, jrnlcredit, jrnlquantity,  "
                    + "\n entrydate, auditdate "
                    + "\n ) "
                    + "\n SELECT  batchid,btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                    + "\n yop, mop, swedit, swreverse, jrnldesc,  "
                    + "\n jrnldebit, jrnlcredit, jrnlquantity,  "
                    + "\n entrydate, auditdate "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT  @b AS b,a.postngseq, "
                    + "\n @batchid:=IF(@b<>a.postngseq,@batchid+1,@batchid) AS batchid, "
                    + "\n @NO:=IF(@b<>a.postngseq,1,@NO+1) AS btchentry,@b:=a.postngseq AS b2, "
                    + "\n NOW() AS btchentrydate,'AP' AS srcelgrcode, 'AD' AS srcetypecode, "
                    + "\n YEAR(NOW()) AS yop,MONTH(NOW()) AS mop,1 AS swedit,1 AS swreverse,a.dscription AS jrnldesc, "
                    + "\n jrnldebit, jrnlcredit, 1 AS jrnlquantity,  "
                    + "\n NOW() AS entrydate, NOW() AS auditdate "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq,b.batchno,b.dscription,SUM(z.transamtdbt) AS jrnldebit,SUM(z.transamtdbt) AS jrnlcredit "
                    + "\n FROM ap_adjbatchlist a  "
                    + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno "
                    + "\n INNER JOIN  "
                    + "\n ( "
                    + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                    + "\n FROM "
                    + "\n ( "
                    + "\n  "
                    + "\n SELECT d.vendcode AS transref ,b.docnum AS transdesc, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,1 AS linenum,e.apacccode AS accglcode , "
                    + "\n IF(b.adjusttot>0,0,ABS(b.adjusttot)) AS transamtdbt,IF(b.adjusttot>0,ABS(b.adjusttot),0) AS transamtcrd, "
                    + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                    + "\n FROM ap_adjbatchlist a  "
                    + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                    + "\n UNION ALL "
                    + "\n SELECT d.vendcode,adjno AS docnum, "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq, "
                    + "\n a.batchno,b.docentry,c.linenum,c.acccode AS accglcode , "
                    + "\n IF(c.distamt>0,ABS(c.distamt),0) AS transamtdbt,IF(c.distamt>0,0,ABS(c.distamt)) AS transamtcrd, "
                    + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                    + "\n FROM ap_adjbatchlist a  "
                    + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                    + "\n INNER JOIN ap_adjd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                    + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                    + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                    + "\n  "
                    + "\n ) AS a "
                    + "\n GROUP BY a.batchno,a.docentry "
                    + "\n ) z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                    + "\n  "
                    + "\n ,(SELECT @NO:=0) AS NO,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)-1) AS a, "
                    + "\n (SELECT @b:=-1) AS b "
                    + "\n WHERE a.batchsts=2  AND a.glpostedsts='0' "
                    + "\n GROUP BY a.postngseq,b.batchno,b.docentry "
                    + "\n ) AS a "
                    + "\n /*b.pseqno,b.pseqentry*/ "
                    + "\n ) AS aa; ";
        return query;

    }

    public String getAPAdjustmentToGl_jed() throws CodeException {
        String query ="/* -- ap adj to gl_jd -- */ "
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
                        + "\n SELECT  docentry,@btchentry:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),@btchentry+1,@btchentry) AS btchentry, "
                        + "\n @d:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),1,IF(@NO<>a.postngseq,@d+1,@d)) AS journalid, "
                        + "\n @transnbr:=IF(@e<>@d OR @b<>IF(@posttoglbypostseq='N',0,a.postngseq),1,@transnbr+1) AS transnbr, "
                        + "\n @b:=IF(@posttoglbypostseq='N',0,a.postngseq) AS b2,@c:=docentry AS c2,@e:=@d AS d2,@NO:=a.postngseq AS f2, "
                        + "\n a.accglcode AS acccode,  "
                        + "\n a.transamtdbt,  "
                        + "\n a.transamtcrd,  "
                        + "\n 1 AS transqty, a.curnccode,a.curnccode AS srcecurnccode, "
                        + "\n a.ratetype AS ratetype, a.rate AS rate, a.rate*a.transamtdbt AS funcamtdbt,  "
                        + "\n a.rate*a.transamtcrd AS funcamtcrd,a.transdesc, a.transref, NOW() AS transdate,  "
                        + "\n 'AP' AS srcelgrcode, 'AD' AS srcetypecode, a.comment AS jecomment, NOW() AS entrydate, NOW() AS auditdate,  "
                        + "\n 'admin' AS audituser "
                        + "\n  "
                        + "\n FROM "
                        + "\n ( "
                        + "\n /* --- journal Vendor/Utang  ---*/ "
                        + "\n SELECT d.vendcode AS transref ,b.docnum AS transdesc, "
                        + "\n postngseq, "
                        + "\n a.batchno,b.docentry,1 AS linenum,e.apacccode AS accglcode , "
                        + "\n IF(b.adjusttot>0,0,ABS(b.adjusttot)) AS transamtdbt,IF(b.adjusttot>0,ABS(b.adjusttot),0) AS transamtcrd, "
                        + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,2 AS visorder "
                        + "\n FROM ap_adjbatchlist a  "
                        + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n LEFT JOIN ap_accset e ON e.accsetcode=d.accsetcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                        + "\n UNION ALL "
                        + "\n SELECT d.vendcode,adjno AS docnum, "
                        + "\n postngseq, "
                        + "\n a.batchno,b.docentry,c.linenum,c.acccode AS accglcode , "
                        + "\n IF(c.distamt>0,ABS(c.distamt),0) AS transamtdbt,IF(c.distamt>0,0,ABS(c.distamt)) AS transamtcrd, "
                        + "\n d.curnccode,d.ratetype, 1 AS rate,b.dscription,'' AS COMMENT,1 AS visorder "
                        + "\n FROM ap_adjbatchlist a  "
                        + "\n INNER JOIN ap_adjh b ON b.batchno=a.batchno  "
                        + "\n INNER JOIN ap_adjd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                        + "\n ) AS a, "
                        + "\n (SELECT @NO:=0) AS aNO, "
                        + "\n (SELECT @btchentry:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)-1 ) AS abtchentry, "
                        + "\n (SELECT @journalid:=0 ) AS ajournalid, "
                        + "\n (SELECT @transnbr:=1 ) AS atransnbr, "
                        + "\n (SELECT @b:=-1) AS acounterb,(SELECT @c:=0) AS acounterc ,(SELECT @d:=0) AS acounterd ,(SELECT @e:=0) AS acountere, "
                        + "\n (SELECT @posttoglbypostseq:=(SELECT posttoglbypostseq FROM ap_optional LIMIT 1)) AS posttoglbypostseq "
                        + "\n ORDER BY a.postngseq,a.batchno,a.docentry,a.visorder,a.linenum "
                        + "\n ) AS a "
                        + "\n ORDER BY ABS(btchentry), journalid, transnbr; ";
        return query;
    }

    public String getAPAdjustmentToGl_optiondetail1() throws CodeException {
        String query ="/* --- update gl_optiondetail1 u/  docnum -- */ "
                    + "\n UPDATE gl_optiondetail1 a , "
                    + "\n ( "
                    + "\n SELECT MAX(batchid)+1 AS batchid  "
                    + "\n FROM "
                    + "\n ( "
                    + "\n SELECT @batchid AS batchid,'1' readytpost, 'AP-IN Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                    + "\n 1 AS batchsts, 0 AS postngseq, SUM(0)  AS debittot, SUM(0) AS credittot,  "
                    + "\n 1 AS qtytotal,  "
                    + "\n (SELECT COUNT(*) FROM ap_adjbatchlist  WHERE batchsts=2  AND glpostedsts='0' AND "
                    + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq=a.postngseq,TRUE) ) AS entrycnt,  "
                    + "\n @batchid:=@batchid+1 AS nextentry,  "
                    + "\n NOW() AS entrydate, NOW() AS auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser, 0 AS objtype, '"+GlobalUtils.company+"' AS cmpnyid  "
                    + "\n FROM ap_adjbatchlist a  "
                    + "\n INNER JOIN ap_adjh b ON a.batchno=b.batchno "
                    + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                    + "\n WHERE batchsts=2  AND glpostedsts='0' "
                    + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',a.postngseq,0) "
                    + "\n ORDER BY @batchid "
                    + "\n ) AS a "
                    + "\n ) AS a2 SET a.docnum=a2.batchid "
                    + "\n WHERE a.modulid=1 AND ((SELECT COUNT(*) FROM ap_adjbatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";
        return query;
    }

    public String getAPAdjustmentToAp_optionaldetail1() throws CodeException {
        String query="/* --- update ap_optionaldetail1 GL Posting Seq docnumid=7 -- */ "
                    + "\n UPDATE ap_optionaldetail1 SET docnum=docnum+1 WHERE docnumid=8 "
                    + "\n AND ((SELECT COUNT(*) FROM ap_adjbatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";
        return query;
    }

    public String getAPAdjustmentToAp_adjbatchlist() throws CodeException {
        String query="UPDATE ap_adjbatchlist  "
                    + "\n SET glpostedsts='1' ,  "
                    + "\n glpostngseq=(SELECT docnum FROM ap_optionaldetail1 WHERE docnumid=8)-1,  "
                    + "\n glposteddate=NOW() "
                    + "\n WHERE batchsts=2 AND glpostedsts='0'; ";
        return query;
    }
}




