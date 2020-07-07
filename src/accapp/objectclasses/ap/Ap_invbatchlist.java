/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_invbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_invbatchlist obj = new Ap_invbatchlist();
 * 
 * 2. Ap_invbatchlist obj = new Ap_invbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist(1);
 * 
 *    It Means : Select * from ap_invbatchlist where id = 1;
 * 
 * 3. Ap_invbatchlist obj = new Ap_invbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist(1);
 * 
 *    It Means : Select * from ap_invbatchlist where id = 1;
 * 
 * 4. Ap_invbatchlist obj = new Ap_invbatchlist(<primary_key>); 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist("1");
 *    It Means : Select * from ap_invbatchlist where <primary_key> = "1";
 * 
 * 5. Ap_invbatchlist obj = new Ap_invbatchlist(Ap_invbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist(Ap_invbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_invbatchlist where id = "1";
 * 
 * 6. Ap_invbatchlist obj = new Ap_invbatchlist();
 *    obj.loadString(Ap_invbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist();
 *    obj.loadString(Ap_invbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_invbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_invbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_invbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_invbatchlist obj = new Ap_invbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_invbatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author windu
 */
public class Ap_invbatchlist extends Ap_invbatchlistAbst{

    private Ap_invhs detail;

    private Integer dtlslctdindx=0;

    public Ap_invhs getDetail() {
        return detail;
    }

    public void setDetail(Ap_invhs detail) {
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

    public Ap_invbatchlist() throws CodeException {
       this.setbatchsts("1");
       detail=new Ap_invhs();
    }
    
    public Ap_invbatchlist(long id) throws CodeException {
        super(id);
//        this.setbatchsts("0");
    }
    
    public Ap_invbatchlist(String val)  throws CodeException {
        super(val);
//        this.setbatchsts("0");
    }
    
    public Ap_invbatchlist(String key, String val)  throws CodeException {
        super(key, val);
//        this.setbatchsts("0");
    }
    
    public Ap_invbatchlist(ResultSet rs) throws CodeException {
        super(rs);
//        this.setbatchsts("0");
    }

    public void adddetail(Ap_invh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ap_invhs ar_invhs) throws CodeException {
        this.detail.add(ar_invhs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        this.setbatchsts("4");

        detail = new Ap_invhs(Ap_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
        for (Object o:detail.list()){
            Ap_invh apinvh=(Ap_invh) o;

            for (Object d:apinvh.getDetail().list()){
                Ap_invd arinvd=(Ap_invd) d;

                arinvd.setdetailamt(0);
            }

            apinvh.setdoctotalamt(apinvh.getDetailAmt());
        }

        this.settotinvamt(this.getTotalAmount());
        this.save();
    }

    public Boolean posting() throws CodeException{
        for (Object o:this.detail.list()){
            Ap_invh apinvh=(Ap_invh) o;
            apinvh.postme(this);
        }
        this.setreadytpost("1");
        this.setbatchsts("2");
        this.setglpostedsts("0");
        this.setswprinted("0");
        this.setposteddate(GlobalUtils.getAuditDate());
        
        Ap_optionaldetail1 apop = new Ap_optionaldetail1(Ap_optionaldetail1.PROPERTY_DOCNUMID, "5");

        this.setpostngseq(apop.getdocnum() + 1);

        apop.setdocnum(apop.getdocnum() + 1);
        apop.save();

        this.save();

        return true;
    }

    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getMaxBatchid());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setswprinted("1");
        this.setglpostedsts("0");
        this.setbatchsts("1");
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setinventrcnt(detail.list().size());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.settotinvamt(this.getTotalAmount());
        super.save();

        for(Object o : detail.list()) {
            Ap_invh oap_invh = (Ap_invh) o;

            if (oap_invh.getID() == 0||oap_invh.getID()==NULLID) {
                oap_invh.setdocentry(oap_invh.getMaxbtchentry((int)this.getbatchno()));
            }
            oap_invh.setbatchno(this.getbatchno());

            oap_invh.save();

        }

        this.setinventrcnt(detail.size());
        this.settotinvamt(this.getTotalAmount());
        super.save();

    }

    public int getMaxBatchid() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(batchno) is null then 1 else max(batchno) + 1 end nomor "
                            + "\n from ap_invbatchlist";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Ap_invh ogl_jeh) throws CodeException {
        if (detail.size()>0){
            ogl_jeh=(Ap_invh) detail.list().get(index);

            ogl_jeh=new Ap_invh(ogl_jeh.getID());
        }
    }
    public void replaceDetail(int index, Ap_invh ogl_jeh) throws CodeException {
        detail.list().set(index, ogl_jeh);
    }

    public void removeDetail(int index) throws CodeException {

        Ap_invh ogl_jeh = (Ap_invh) detail.list().get(index);
        ogl_jeh.delete();

        detail.list().remove(index);

        this.setinventrcnt(detail.list().size());
        this.save();
    }

    /**
     * @return the dtlslctdindx
     */


    public double getTotalAmount() throws CodeException {
        double totaldebit = 0;

        for (Object o: detail.list()){
            Ap_invh cbhh = (Ap_invh) o;
            if (cbhh.getdoctype().equalsIgnoreCase("5")){
                totaldebit += cbhh.getdoctotalafttaxamt()*-1;
            } else {
                totaldebit += cbhh.getdoctotalafttaxamt();
            }
        }

        return totaldebit;
    }


    private String batchtypedesc(String batchtype){
        String result="";

        return result;

    }

    public boolean  checkAPInvoiceTransfer() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_invbatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public boolean  checkAPInvoicePosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ap_invbatchlist  WHERE readytpost='1' AND batchsts='1' ";

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

    public Boolean runAPInvoicePosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getAPInvoicePosting(sbatchnofr ,sbatchnoto ));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
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
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ap_invbatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }

    

    public String getAPInvoicePosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
           String query = "call sp_apinvoiceposting("+sbatchnofr+","+sbatchnoto+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
           System.out.println(query);
            return query;
    }

    public int runAPInvoiceToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
             db.updateSQL(getAPInvoiceToGl_SP());
//            db.updateSQL(getAPInvoiceToGl());
//            db.updateSQL(getAPInvoiceToGH());
//            db.updateSQL(getAPInvoiceToGD());
//            db.updateSQL(getAPInvoiceOptionStatus());
//            db.updateSQL(getAPInvoiceStatus());
//            db.updateSQL(getAp_optionaldetail1());

         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }
    public String getAPInvoiceToGl_SP() throws CodeException {
           String query = "call sp_create_apinvoice_to_glbatch ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"') ";
           System.out.println(query);
           return query;
    }

    public String getAPInvoiceToGl() throws CodeException {
           String query = "/* -- ap invoice to gl journal entry -- */ "
                            + "\n /* -- ap to gl_batchcontrol --- */ "
                            + "\n INSERT INTO gl_batchlist "
                            + "\n ( "
                            + "\n 	batchid, readytpost, btchdesc, srceledgr, batchdate, batchtype,  "
                            + "\n 	batchsts, postngseq, debittot, credittot, qtytotal, entrycnt, nextentry,  "
                            + "\n 	entrydate, auditdate, audituser, cmpnyid  "
                            + "\n ) "
                            + "\n SELECT 	@batchid AS batchid,'1' readytpost, 'AP-IN Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                            + "\n 	1 AS batchsts, 0 AS postngseq, SUM(transamtdbt)  AS debittot, SUM(transamtcrd) AS credittot,  "
                            + "\n 	1 AS qtytotal,  "
                            + "\n 	(SELECT COUNT(*) FROM ap_invbatchlist  WHERE batchsts=2  AND glpostedsts='0' and "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq=a.postngseq,true) ) AS entrycnt,  "
                            + "\n 	@batchid:=@batchid+1 AS nextentry,  "
                            + "\n 	NOW() AS entrydate, NOW() AS auditdate, '" + GlobalUtils.userid + "' AS audituser, '" + GlobalUtils.company  + "' AS cmpnyid  "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON a.batchno=b.batchno "
                            + "\n inner join ( "
                            + "\n select  a.batchno,a.docentry,sum(a.transamtdbt) as transamtdbt,sum(a.transamtcrd) as transamtcrd "
                            + "\n from "
                            + "\n ( "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	/* jika tipe dok cn kolom debet selain credit */ "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION  "
                            + "\n /* --- journal PPN ---*/ "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.taxtotalamt) AS transamtdbt,IF(b.doctype=5,b.taxtotalamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode "
                            + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,c.linenum,c.accglcode , "
                            + "\n 	IF(b.doctype=5,0,c.detailamt) AS transamtdbt,IF(b.doctype=5,c.detailamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,c.comment,3 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n INNER JOIN ap_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) ---*/ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT  b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,4 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) DOC APPLY TO --- */ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT b.vendcode,b.docnumapplto, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n ) as a "
                            + "\n group by a.batchno,a.docentry "
                            + "\n ) as z on b.batchno=z.batchno and b.docentry=z.docentry "
                            + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                            + "\n WHERE batchsts=2  AND glpostedsts='0' "
                            + "\n GROUP BY if((select posttoglbypostseq from ap_optional limit 1)='Y',a.postngseq,0) "
                            + "\n ORDER BY @batchid; ";




           return query;

    }


    public String getAPInvoiceToGH() throws CodeException {
           String query = "/* -- ap to gl_jeh --- */ "
                            + "\n insert into gl_jeh "
                            + "\n ( "
                            + "\n batchid, btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                            + "\n 	yop, mop, swedit, swreverse, jrnldesc,  "
                            + "\n 	jrnldebit, jrnlcredit, jrnlquantity,  "
                            + "\n 	entrydate, auditdate, audituser, cmpnyid  "
                            + "\n ) "
                            + "\n SELECT  batchid, btchentry, btchentrydate, srcelgrcode, srcetypecode,  "
                            + "\n 	yop, mop, swedit, swreverse, jrnldesc,  "
                            + "\n 	jrnldebit, jrnlcredit, jrnlquantity,  "
                            + "\n 	entrydate, auditdate, '" +  GlobalUtils.userid + "', '" + GlobalUtils.company + "' "
                            + "\n FROM "
                            + "\n ( "
                            + "\n SELECT  @b AS b,a.postngseq, "
                            + "\n 	@batchid:=IF(@b<>a.postngseq,@batchid+1,@batchid) AS batchid, "
                            + "\n 	@NO:=IF(@b<>a.postngseq,1,@NO+1) AS btchentry,@b:=a.postngseq AS b2, "
                            + "\n 	NOW() AS btchentrydate,'AP' AS srcelgrcode, 'IN' AS srcetypecode, "
                            + "\n 	YEAR(NOW()) AS yop,MONTH(NOW()) AS mop,1 AS swedit,1 AS swreverse,a.dscription AS jrnldesc, "
                            + "\n 	jrnldebit, jrnlcredit, 1 AS jrnlquantity,  "
                            + "\n 	NOW() AS entrydate, NOW() AS auditdate "
                            + "\n FROM "
                            + "\n ( "
                            + "\n SELECT "
                            + "\n if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq,b.batchno,b.dscription,SUM(z.transamtdbt) AS jrnldebit,SUM(z.transamtdbt) AS jrnlcredit "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n inner join  "
                            + "\n ( "
                            + "\n select  a.batchno,a.docentry,sum(a.transamtdbt) as transamtdbt,sum(a.transamtcrd) as transamtcrd "
                            + "\n from "
                            + "\n ( "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	/* jika tipe dok cn kolom debet selain credit */ "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION  "
                            + "\n /* --- journal PPN ---*/ "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.taxtotalamt) AS transamtdbt,IF(b.doctype=5,b.taxtotalamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode "
                            + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,c.linenum,c.accglcode , "
                            + "\n 	IF(b.doctype=5,0,c.detailamt) AS transamtdbt,IF(b.doctype=5,c.detailamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,c.comment,3 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n INNER JOIN ap_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) ---*/ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT  b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,4 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) DOC APPLY TO --- */ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT b.vendcode,b.docnumapplto, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0'  "
                            + "\n ) as a "
                            + "\n group by a.batchno,a.docentry "
                            + "\n ) z on b.batchno=z.batchno and b.docentry=z.docentry "
                            + "\n ,(SELECT @NO:=0) AS NO,(SELECT @batchid:=(SELECT docnum-1 FROM gl_optiondetail1 WHERE modulid=1)) AS a, "
                            + "\n (SELECT @b:='') AS b "
                            + "\n WHERE a.batchsts=2  AND a.glpostedsts='0' "
                            + "\n GROUP BY a.postngseq,b.batchno "
                            + "\n ) AS a "
                            + "\n /*b.pseqno,b.pseqentry*/ "
                            + "\n ) AS aa; ";

           return query;
    }

    public String getAPInvoiceToGD() throws CodeException {
           String query = "/* -- ap to gl_jd -- */ "
                            + "\n INSERT INTO gl_jed "
                            + "\n ( "
                            + "\n 	btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd, transqty, curnccode,  "
                            + "\n 	srcecurnccode, ratetype, rate, funcamtdbt, funcamtcrd, transdesc, transref, transdate,  "
                            + "\n 	srcelgrcode, srcetypecode, jecomment, entrydate, auditdate, audituser,  cmpnyid "
                            + "\n ) "
                            + "\n SELECT  "
                            + "\n 	btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd,  "
                            + "\n 	transqty, curnccode, srcecurnccode, ratetype, rate, funcamtdbt,  "
                            + "\n 	funcamtcrd, transdesc, transref, transdate, srcelgrcode, srcetypecode,  "
                            + "\n 	jecomment, entrydate, auditdate, '" + GlobalUtils.userid + "',  '" +  GlobalUtils.company + "' "
                            + "\n FROM "
                            + "\n ( "
                            + "\n SELECT  @btchentry:=IF(@b<>a.batchno,@btchentry+1,@btchentry) AS btchentry, "
                            + "\n 	a.docentry AS journalid, "
                            + "\n 	@transnbr:=IF(@c=a.docentry,IF(@b=a.batchno,@transnbr+1,1),1) AS transnbr, "
                            + "\n 	@b:=a.batchno AS b2,@c:=docentry AS c2,	@d:=@journalid AS d2, "
                            + "\n 	a.accglcode AS acccode,  "
                            + "\n 	a.transamtdbt,  "
                            + "\n 	a.transamtcrd,  "
                            + "\n 	1 AS transqty, a.curnccode,a.curnccode AS srcecurnccode, "
                            + "\n 	a.ratetype AS ratetype, a.rate AS rate, a.rate*a.transamtdbt AS funcamtdbt,  "
                            + "\n 	a.rate*a.transamtcrd AS funcamtcrd,a.transdesc, a.transref, NOW() AS transdate,  "
                            + "\n 	'CB' AS srcelgrcode, 'CB' AS srcetypecode, a.comment AS jecomment, NOW() AS entrydate, NOW() AS auditdate,  "
                            + "\n 	'admin' AS audituser "
                            + "\n FROM "
                            + "\n ( "
                            + "\n /* --- journal Vendor/Utang  ---*/ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	/* jika tipe dok cn kolom debet selain credit */ "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                            + "\n UNION  "
                            + "\n /* --- journal PPN ---*/ "
                            + "\n SELECT 	b.vendcode AS transref,b.docnum AS transdesc, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.taxtotalamt) AS transamtdbt,IF(b.doctype=5,b.taxtotalamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode "
                            + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                            + "\n UNION ALL "
                            + "\n /* --- journal detail ---*/ "
                            + "\n SELECT b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,c.linenum,c.accglcode , "
                            + "\n 	IF(b.doctype=5,0,c.detailamt) AS transamtdbt,IF(b.doctype=5,c.detailamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,c.comment,3 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno "
                            + "\n INNER JOIN ap_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) ---*/ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT  b.vendcode,b.docnum, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,4 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                            + "\n UNION ALL "
                            + "\n /* --- journal Vendor/Utang  DAN b.doctype IN (5,6) DOC APPLY TO --- */ "
                            + "\n /* --- doctype 4=inv 5=cn 6=dn 7=int --*/ "
                            + "\n SELECT b.vendcode,b.docnumapplto, "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq,0) as postngseq, "
                            + "\n 	a.batchno,b.docentry,0 AS linenum,e.apacccode AS accglcode , "
                            + "\n 	IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                            + "\n 	b.curnccode,d.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder	 "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                            + "\n LEFT JOIN ap_vendor d ON b.vendcode=d.vendcode "
                            + "\n LEFT JOIN ap_accset e ON e.accsetcode=b.accsetcode "
                            + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                            + "\n ) AS a, "
                            + "\n (SELECT @NO:=0) AS aNO, "
                            + "\n (SELECT @btchentry:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1) - 1) AS abtchentry, "
                            + "\n (SELECT @journalid:=0 ) AS ajournalid, "
                            + "\n (SELECT @transnbr:=1 ) AS atransnbr, "
                            + "\n (SELECT @b:=0) AS acounterb,(SELECT @c:=0) AS acounterc  "
                            + "\n ORDER BY a.postngseq,a.batchno,a.docentry,a.visorder,a.linenum "
                            + "\n ) AS a "
                            + "\n ORDER BY ABS(btchentry), journalid, transnbr; " ;

           return query;
    }


    public String getAPInvoiceStatus() throws CodeException {
           String query = "/* --- update ap_invbatchlist u/  glpostedsts , glpostngseq, glposteddate -- */ "
                            + "\n update 	ap_invbatchlist  "
                            + "\n set 	glpostedsts='1' ,  "
                            + "\n 	glpostngseq=(select docnum from ap_optionaldetail1 where docnumid=7),  "
                            + "\n 	glposteddate=now() "
                            + "\n where batchsts=2 AND glpostedsts='0'; ";
            return query;
    }


    public String getAPInvoiceOptionStatus() throws CodeException {
           String query = "/* --- update gl_optiondetail1 u/  docnum -- */ "
                            + "\n update gl_optiondetail1 a , "
                            + "\n ( "
                            + "\n select max(batchid)+1 as batchid  "
                            + "\n from "
                            + "\n ( "
                            + "\n SELECT 	@batchid AS batchid,'1' readytpost, 'AP-IN Transfer Batch' AS btchdesc, 'AP' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                            + "\n 	1 AS batchsts, 0 AS postngseq, SUM(totinvamt)  AS debittot, SUM(totinvamt) AS credittot,  "
                            + "\n 	1 AS qtytotal,  "
                            + "\n 	(SELECT COUNT(*) FROM ap_invbatchlist  WHERE batchsts=2  AND glpostedsts='0' and "
                            + "\n 	if((select posttoglbypostseq from ap_optional limit 1)='Y',postngseq=a.postngseq,true) ) AS entrycnt,  "
                            + "\n 	@batchid:=@batchid+1 AS nextentry,  "
                            + "\n 	NOW() AS entrydate, NOW() AS auditdate, '"+GlobalUtils.getAuditUser()+"' AS audituser, 0 AS objtype, '"+GlobalUtils.company+"' AS cmpnyid  "
                            + "\n FROM ap_invbatchlist a  "
                            + "\n INNER JOIN ap_invh b ON a.batchno=b.batchno "
                            + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                            + "\n WHERE batchsts=2  AND glpostedsts='0' "
                            + "\n GROUP BY if((select posttoglbypostseq from ap_optional limit 1)='Y',a.postngseq,0) "
                            + "\n ORDER BY @batchid "
                            + "\n ) as a "
                            + "\n ) as a2 set a.docnum=a2.batchid "
                            + "\n where a.modulid=1; " ;

           return query;
    }

    public String getAp_optionaldetail1() throws CodeException {
           String query = "\n /* --- update ap_optionaldetail1 GL Posting Seq docnumid=7 -- */"
                            + "\n    UPDATE ap_optionaldetail1 SET docnum=docnum+1 WHERE docnumid=7 "
                            + "\n        AND ((SELECT COUNT(*) FROM ap_invbatchlist WHERE batchsts=2 AND (glpostedsts='0' or glpostedsts is null)    )<>0); " ;

           return query;
    }


}




