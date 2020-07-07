/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_invbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_invbatchlist obj = new Ar_invbatchlist();
 * 
 * 2. Ar_invbatchlist obj = new Ar_invbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist(1);
 * 
 *    It Means : Select * from ar_invbatchlist where id = 1;
 * 
 * 3. Ar_invbatchlist obj = new Ar_invbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist(1);
 * 
 *    It Means : Select * from ar_invbatchlist where id = 1;
 * 
 * 4. Ar_invbatchlist obj = new Ar_invbatchlist(<primary_key>); 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist("1");
 *    It Means : Select * from ar_invbatchlist where <primary_key> = "1";
 * 
 * 5. Ar_invbatchlist obj = new Ar_invbatchlist(Ar_invbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist(Ar_invbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_invbatchlist where id = "1";
 * 
 * 6. Ar_invbatchlist obj = new Ar_invbatchlist();
 *    obj.loadString(Ar_invbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist();
 *    obj.loadString(Ar_invbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_invbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_invbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_invbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_invbatchlist obj = new Ar_invbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_invbatchlist where id = 1;
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
public class Ar_invbatchlist extends Ar_invbatchlistAbst{

    private Ar_invhs detail;

    private Integer dtlslctdindx=0;

    public Ar_invhs getDetail() {
        return detail;
    }

    public void setDetail(Ar_invhs detail) {
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

    public Ar_invbatchlist() throws CodeException {
       this.setbatchsts("1");
       detail=new Ar_invhs();
    }
    
    public Ar_invbatchlist(long id) throws CodeException {
        super(id);
    }
    
    public Ar_invbatchlist(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_invbatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_invbatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }
    
    public void adddetail(Ar_invh obj) throws CodeException{
        detail.add(obj);
    }

    public void addDetails(Ar_invhs ar_invhs) throws CodeException {
        this.detail.add(ar_invhs);
    }


    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key,val);
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
    }

    @Override
    public void delete() throws CodeException {
        this.setbatchsts("4");

        /*detail = new Ar_invhs(Ar_invh.PROPERTY_BATCHNO, this.getbatchno()+"");
        for (Object o:detail.list()){
            Ar_invh arinvh=(Ar_invh) o;

            for (Object d:arinvh.getDetail().list()){
                Ar_invd arinvd=(Ar_invd) d;

                arinvd.setdetailamt(0);
            }

            arinvh.setdoctotalamt(arinvh.getDetailAmt());
        }

        this.settotinvamt(this.getTotalAmount());*/
        this.save();
    }

    public Boolean posting() throws CodeException{
        for (Object o:this.detail.list()){
            Ar_invh arinvh=(Ar_invh) o;
            arinvh.postme();
        }

        Ar_optiionaldetail1 arop=new Ar_optiionaldetail1("10");
        arop.setdocnum(arop.getdocnum()+1);
        arop.save();

        this.setpostngseq(arop.getdocnum());
        this.setreadytpost("0");
        this.setbatchsts("2");
        this.save();

        return true;
    }

    @Override
    public void saveNew() throws CodeException {
        this.setbatchno(this.getMaxBatchid());
        this.setentrydate(GlobalUtils.getAuditDate());

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
            Ar_invh oGl_jeh = (Ar_invh) o;

            if (oGl_jeh.getID() == 0||oGl_jeh.getID()==NULLID) {
                oGl_jeh.setdocentry(oGl_jeh.getMaxbtchentry((int)this.getbatchno()));
            }
            oGl_jeh.setbatchno(this.getbatchno());

            oGl_jeh.save();

        }

        this.settotinvamt(this.getTotalAmount());
        super.save();

    }

    public int getMaxBatchid() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(batchno) is null then 1 else max(batchno) + 1 end nomor "
                            + "\n from ar_invbatchlist";

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("ar_invbatchlist : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Ar_invh ogl_jeh) throws CodeException {
        if (detail.size()>0){
            ogl_jeh=(Ar_invh) detail.list().get(index);

            ogl_jeh=new Ar_invh(ogl_jeh.getID());
        }
    }
    public void replaceDetail(int index, Ar_invh ogl_jeh) throws CodeException {
        detail.list().set(index, ogl_jeh);
    }

    public void removeDetail(int index) throws CodeException {

        Ar_invh ogl_jeh = (Ar_invh) detail.list().get(index);
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
            Ar_invh cbhh = (Ar_invh) o;
            if (cbhh.getdoctype().equalsIgnoreCase("5")){
                totaldebit += cbhh.getdoctotalafttaxamt()*-1;
            } else{
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
         String query  = "SELECT COUNT(*) FROM ar_invbatchlist  WHERE batchsts=2  AND (glpostedsts='0' or glpostedsts is null) ";

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

    public int runARInvoiceToGl() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
            db.updateSQL(getARInvoiceToGl_sp());
         } catch (Exception ex) {
             throw new CodeException("ar_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }

    public String getARInvoiceToGl_sp() throws CodeException {
           String query ="call sp_create_arinvoice_to_glbatch ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"')  ";
           return query;

    }

    public String getARInvoiceToGl() throws CodeException {
           String query ="INSERT INTO gl_batchlist "
                        + "\n ( "
                        + "\n batchid, readytpost, btchdesc, srceledgr, batchdate, batchtype,  "
                        + "\n batchsts, postngseq, debittot, credittot, qtytotal, entrycnt, nextentry,  "
                        + "\n entrydate, auditdate, audituser, objtype, cmpnyid  "
                        + "\n ) "
                        + "\n SELECT @batchid AS batchid,'1' readytpost,  "
                        + "\n CONCAT(UCASE((SELECT cmpnyid FROM ar_optional LIMIT 1)),' AR ',DATE_FORMAT(NOW(),'%d-%m-%Y')) AS btchdesc,  "
                        + "\n 'AR' AS srceledgr, NOW() AS batchdate, 2 AS batchtype,  "
                        + "\n 1 AS batchsts, 0 AS postngseq, SUM(transamtdbt)  AS debittot, SUM(transamtcrd) AS credittot,  "
                        + "\n 1 AS qtytotal,  "
                        + "\n (SELECT COUNT(*) FROM ap_adjbatchlist  WHERE batchsts=2  AND glpostedsts='0' AND "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq=a.postngseq,TRUE) ) AS entrycnt,  "
                        + "\n @batchid:=@batchid+1 AS nextentry,  "
                        + "\n NOW() AS entrydate, NOW() AS auditdate, '" +  GlobalUtils.userid + "' AS audituser, 0 AS objtype, '" + GlobalUtils.company + "' AS cmpnyid  "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON a.batchno=b.batchno "
                        + "\n INNER JOIN ( "
                        + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION  "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.taxtotalamt,0) AS transamtdbt,IF(b.doctype=5,0,b.taxtotalamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,c.linenum,c.accrevcode , "
                        + "\n IF(b.doctype=5,c.detailamt,0) AS transamtdbt,IF(b.doctype=5,0,c.detailamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,3 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n INNER JOIN ar_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                        + "\n b.curnccode, ao.ratetype,b.rate,b.dscription,'' AS COMMENT,4 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnumapplto, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode "
                        + "\n , ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostngseq='0' "
                        + "\n ) AS a "
                        + "\n GROUP BY a.batchno,a.docentry "
                        + "\n ) AS z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                        + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                        + "\n WHERE batchsts=2  AND glpostedsts='0' "
                        + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ar_optional LIMIT 1)='Y',a.postngseq,1) "
                        + "\n ORDER BY @batchid; ";
           return query;

    }

    public String getARInvoiceToGH() throws CodeException {
           String query ="INSERT INTO gl_jeh "
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
                        + "\n @batchid:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),@batchid+1,@batchid) AS batchid, "
                        + "\n @d:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),1,IF(@NO<>a.postngseq,@d+1,@d)) AS btchentry, "
                        + "\n @b:=IF(@posttoglbypostseq='N',0,a.postngseq) AS b2, "
                        + "\n NOW() AS btchentrydate,'AR' AS srcelgrcode, 'IN' AS srcetypecode, "
                        + "\n YEAR(NOW()) AS yop,MONTH(NOW()) AS mop,1 AS swedit,1 AS swreverse,a.dscription AS jrnldesc, "
                        + "\n jrnldebit, jrnlcredit, 1 AS jrnlquantity,  "
                        + "\n NOW() AS entrydate, NOW() AS auditdate "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT "
                        + "\n IF((SELECT posttoglbypostseq FROM ap_optional LIMIT 1)='Y',postngseq,0) AS postngseq,b.batchno,b.dscription,SUM(z.transamtdbt) AS jrnldebit,SUM(z.transamtdbt) AS jrnlcredit "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n INNER JOIN  "
                        + "\n ( "
                        + "\n SELECT  a.batchno,a.docentry,SUM(a.transamtdbt) AS transamtdbt,SUM(a.transamtcrd) AS transamtcrd "
                        + "\n FROM "
                        + "\n ( "
                        + "\n  "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION  "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.taxtotalamt,0) AS transamtdbt,IF(b.doctype=5,0,b.taxtotalamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,c.linenum,c.accrevcode , "
                        + "\n IF(b.doctype=5,c.detailamt,0) AS transamtdbt,IF(b.doctype=5,0,c.detailamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,3 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n INNER JOIN ar_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                        + "\n b.curnccode, ao.ratetype,b.rate,b.dscription,'' AS COMMENT,4 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnumapplto, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode "
                        + "\n , ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n  "
                        + "\n ) AS a "
                        + "\n GROUP BY a.batchno,a.docentry "
                        + "\n ) z ON b.batchno=z.batchno AND b.docentry=z.docentry "
                        + "\n  "
                        + "\n ,(SELECT @NO:=0) AS NO,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)-1) AS a, "
                        + "\n (SELECT @b:=-1) AS b "
                        + "\n WHERE a.batchsts=2  AND a.glpostedsts='0' "
                        + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ar_optional LIMIT 1)='Y',a.postngseq,1),b.batchno,b.docentry "
                        + "\n ) AS a "
                        + "\n ) AS aa; ";
           return query;

    }

    public String getARInvoiceToGD() throws CodeException {
           String query ="INSERT INTO gl_jed "
                        + "\n ( "
                        + "\n btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd, transqty, curnccode,  "
                        + "\n srcecurnccode, ratetype, rate, funcamtdbt, funcamtcrd, transdesc, transref, transdate,  "
                        + "\n srcelgrcode, srcetypecode, jecomment, entrydate, auditdate, audituser, cmpnyid "
                        + "\n ) "
                        + "\n SELECT  "
                        + "\n btchentry, journalid, transnbr, acccode, transamtdbt, transamtcrd,  "
                        + "\n transqty, curnccode, srcecurnccode, ratetype, rate, funcamtdbt,  "
                        + "\n funcamtcrd, transdesc, transref, transdate, srcelgrcode, srcetypecode,  "
                        + "\n jecomment, entrydate, auditdate, audituser,'namacompany' AS cmpnyid "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT  IF(@posttoglbypostseq='N',0,a.postngseq) AS bbbb, "
                        + "\n @btchentry:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),@btchentry+1,@btchentry) AS btchentry, "
                        + "\n @d:=IF(@b<>IF(@posttoglbypostseq='N',0,a.postngseq),1,IF(@NO<>a.postngseq,@d+1,@d)) AS journalid, "
                        + "\n @transnbr:=IF(@e<>@d OR @b<>IF(@posttoglbypostseq='N',0,a.postngseq),1,@transnbr+1) AS transnbr, "
                        + "\n @b:=IF(@posttoglbypostseq='N',0,a.postngseq) AS b2,@c:=docentry AS c2,@e:=@d AS d2,@NO:=a.postngseq AS f2, "
                        + "\n a.accglcode AS acccode,  "
                        + "\n a.transamtdbt,  "
                        + "\n a.transamtcrd,  "
                        + "\n 1 AS transqty, a.curnccode,a.curnccode AS srcecurnccode, "
                        + "\n a.ratetype AS ratetype, a.rate AS rate, a.rate*a.transamtdbt AS funcamtdbt,  "
                        + "\n a.rate*a.transamtcrd AS funcamtcrd,a.transdesc, a.transref, NOW() AS transdate,  "
                        + "\n IF(a.doctype='5','CR','IN') AS srcelgrcode,'AR' AS srcetypecode, a.comment AS jecomment, NOW() AS entrydate, NOW() AS auditdate,  "
                        + "\n 'admin' AS audituser "
                        + "\n  "
                        + "\n FROM "
                        + "\n ( "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,1 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION  "
                        + "\n SELECT b.custmrcode AS transref,b.docnum AS transdesc, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.liablyacccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.taxtotalamt,0) AS transamtdbt,IF(b.doctype=5,0,b.taxtotalamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,2 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n INNER JOIN op_tax e ON e.taxcode=b.taxcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2  AND b.taxtotalamt<>0 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,c.linenum,c.accrevcode , "
                        + "\n IF(b.doctype=5,c.detailamt,0) AS transamtdbt,IF(b.doctype=5,0,c.detailamt) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,3 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno "
                        + "\n INNER JOIN ar_invd c ON c.batchno=b.batchno AND c.docentry=b.docentry "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnum, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtdbt,IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtcrd, "
                        + "\n b.curnccode, ao.ratetype,b.rate,b.dscription,'' AS COMMENT,4 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode, ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n UNION ALL "
                        + "\n SELECT b.custmrcode,b.docnumapplto, "
                        + "\n a.postngseq,a.batchno,b.docentry,0 AS linenum,e.aracccode AS accglcode , "
                        + "\n IF(b.doctype=5,0,b.doctotalafttaxamt) AS transamtdbt,IF(b.doctype=5,b.doctotalafttaxamt,0) AS transamtcrd, "
                        + "\n b.curnccode,ao.ratetype, b.rate,b.dscription,'' AS COMMENT,6 AS visorder,b.doctype "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON b.batchno=a.batchno AND b.doctype IN (5,6) "
                        + "\n LEFT JOIN ar_customer d ON b.custmrcode=d.custmrcode "
                        + "\n LEFT JOIN ar_accset e ON e.accsetcode=d.accsetcode "
                        + "\n , ar_optional ao  "
                        + "\n WHERE a.batchsts=2 AND a.glpostedsts='0' "
                        + "\n ) AS a, "
                        + "\n (SELECT @NO:=0) AS aNO, "
                        + "\n (SELECT @btchentry:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS abtchentry, "
                        + "\n (SELECT @journalid:=0 ) AS ajournalid, "
                        + "\n (SELECT @transnbr:=1 ) AS atransnbr, "
                        + "\n (SELECT @b:=0) AS acounterb,(SELECT @c:=0) AS acounterc ,(SELECT @d:=0 ) AS aconterd, "
                        + "\n (SELECT @posttoglbypostseq:=(SELECT posttoglbypostseq FROM ar_optional LIMIT 1)) AS posttoglbypostseq "
                        + "\n ORDER BY a.postngseq,a.batchno,a.docentry,a.visorder,a.linenum "
                        + "\n  "
                        + "\n ) AS a "
                        + "\n ORDER BY ABS(btchentry), journalid, transnbr; ";
           return query;

    }

    public String getARInvoiceOptionStatus() throws CodeException {
           String query ="UPDATE gl_optiondetail1 a , "
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
                        + "\n NOW() AS entrydate, NOW() AS auditdate, '" +  GlobalUtils.userid + "' AS audituser, 0 AS objtype, '" + GlobalUtils.company + "' AS cmpnyid  "
                        + "\n FROM ar_invbatchlist a  "
                        + "\n INNER JOIN ar_invh b ON a.batchno=b.batchno "
                        + "\n ,(SELECT @batchid:=(SELECT docnum FROM gl_optiondetail1 WHERE modulid=1)) AS a  "
                        + "\n WHERE batchsts=2  AND glpostedsts='0' "
                        + "\n GROUP BY IF((SELECT posttoglbypostseq FROM ar_optional LIMIT 1)='Y',a.postngseq,0) "
                        + "\n ORDER BY @batchid "
                        + "\n ) AS a "
                        + "\n ) AS a2 SET a.docnum=a2.batchid "
                        + "\n WHERE a.modulid=1 AND ((SELECT COUNT(*) FROM ar_invbatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";
           return query;

    }

    public String getAR_optionaldetail1() throws CodeException {
           String query ="UPDATE ar_optiionaldetail1 SET docnum=docnum+1 WHERE docnumid=12  "
                            + "\n AND ((SELECT COUNT(*) FROM ar_invbatchlist WHERE batchsts=2 AND glpostedsts='0')<>0); ";
           return query;

    }

    public String getARInvoiceStatus() throws CodeException {
           String query ="UPDATE ar_invbatchlist  "
                        + "\n SET glpostedsts='1' ,  "
                        + "\n glpostngseq=(SELECT docnum FROM ar_optiionaldetail1 WHERE docnumid=12)-1,  "
                        + "\n glposteddate=NOW() "
                        + "\n WHERE batchsts=2 AND glpostedsts='0'; ";
           return query;

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
             throw new CodeException("ar_rcpbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getReadyToPostMe(int ready) throws CodeException {
           String query = "update ar_invbatchlist set readytpost='"+ready+"' where batchno="+this.getbatchno();
           System.out.println(query);
            return query;
    }


    public Boolean runARInvoicePosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
            db.updateSQL(getARInvoicePosting(sbatchnofr ,sbatchnoto ));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("ar_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }
    
    public String getARInvoicePosting(long sbatchnofr ,long sbatchnoto ) throws CodeException {
           String query = "call sp_arinvoiceposting("+sbatchnofr+","+sbatchnoto+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"') ";
           System.out.println(query);
            return query;
    }

    public boolean  checkARInvoicePosting() throws CodeException {
         DbBean db = DbBean.connect();
         String query  = "SELECT COUNT(*) FROM ar_invbatchlist  WHERE readytpost='1' AND batchsts='1' ";

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
    
}




