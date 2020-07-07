/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;

import com.mysql.jdbc.ResultSet;
import common.jdbc.DbBean;
import common.utils.CodeException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isparthama
 */
public class Cb_invoblcbhsds extends ArrayList<Cb_invoblcbhsd>{

    private void recordLoadap(ResultSet rs) throws SQLException{
        Cb_invoblcbhsd ca=new Cb_invoblcbhsd();

        ca.setVendcode(rs.getString("Vendcode"));
        ca.setAplyto(rs.getString("aplyto"));
        ca.setDoctype(rs.getString("doctype"));
        ca.setDocdate(rs.getString("docdate"));
        ca.setDocnum(rs.getString("docnum"));
        ca.setApplamt(rs.getDouble("applamt"));
        ca.setDiscamt(rs.getDouble("discamt"));
        ca.setNetblc(rs.getDouble("netblc"));
        ca.setCrnblc(rs.getDouble("crnblc"));
        ca.setOriamt(rs.getDouble("oriamt"));
        ca.setPendamt(rs.getDouble("pendamt"));
        ca.setPenddisc(rs.getDouble("penddisc"));
        ca.setPono(rs.getString("pono"));
        ca.setOrderno(rs.getString("orderno"));

        this.add(ca);
    }

    private void recordLoadar(ResultSet rs) throws SQLException{
        Cb_invoblcbhsd ca=new Cb_invoblcbhsd();

        ca.setVendcode(rs.getString("custmrcode"));
        ca.setAplyto(rs.getString("aplyto"));
        ca.setDoctype(rs.getString("doctype"));
        ca.setDocdate(rs.getString("docdate"));
        ca.setDocnum(rs.getString("docnum"));
        ca.setApplamt(rs.getDouble("applamt"));
        ca.setDiscamt(rs.getDouble("discamt"));
        ca.setNetblc(rs.getDouble("netblc"));
        ca.setCrnblc(rs.getDouble("crnblc"));
        ca.setOriamt(rs.getDouble("oriamt"));
        ca.setPendamt(rs.getDouble("pendamt"));
        ca.setPenddisc(rs.getDouble("penddisc"));
        ca.setPono(rs.getString("pono"));
        ca.setOrderno(rs.getString("orderno"));

        this.add(ca);
    }

    public Boolean initdataap (String vendorcode) throws CodeException{
        String query="SELECT  a.vendcode,IF(SUM(a.aplyto)=0,'N','P') AS aplyto, "+
                     "\n        IF(a.doctype=4,'IN',IF(a.doctype=5,'CN',IF(a.doctype=6,'DN','IT'))) AS doctype, a.docdate,a.docnum, SUM(a.applamt) AS applamt,   "+
                     "\n        SUM(discamt) AS discamt,SUM(a.netblc) AS netblc, SUM(a.crnblc) AS crnblc, SUM(a.oriamt) AS oriamt, SUM(a.pendamt) AS pendamt,  "+
                     "\n        SUM(penddisc) AS penddisc,pono,orderno  "+
                     "\n                    FROM  "+
                    "\n(  "+
                    "\nSELECT vendcode,0 AS aplyto,doctype AS doctype,docnum,docdate,docduedate, "+
                    "\n                0 AS applamt, 0 AS discamt,doctotalamtr AS netblc, doctotalamtr AS crnblc,doctotalamt AS oriamt,   "+
                    "\n                0 AS pendamt,0 AS penddisc,pono,orderno  "+
                    "\nFROM  ap_invobl WHERE swpaid=0 AND vendcode='"+vendorcode+"' "+
                    "\nUNION ALL  "+
                    "\nSELECT  b.custcode AS vendcodeap_invobl,1 AS aplyto,a.doctype AS doctype,b.docno,a.docdate,a.docduedate,  "+
                    "\n                             0 AS applamt, 0 AS discamt,b.applamount*-1 AS netblc, 0 AS crnblc, 0 AS oriamt, "+
                    "\n                             b.applamount AS pendamt,b.discount AS penddisc,a.pono,a.orderno  "+
                    "\nFROM  ap_invobl a   "+
                    "\nINNER JOIN cb_batchsd b ON  a.vendcode=b.custcode AND a.docnum=b.docno AND a.swpaid=0 AND b.linests=0 AND b.custcode='"+vendorcode+"'  "+
                    "\nINNER JOIN cb_batchh c ON b.batchno=c.batchno AND b.entryno=c.entryno AND c.entrytype='P'  "+
                    "\nUNION ALL "+
                    "\nSELECT d.vendcode,0 AS aplyto,d.doctype AS doctype,d.docnum,d.docdate,d.docduedate, "+
                    "\n                0 AS applamt, 0 AS discamt,d1.payamt*-1 AS netblc, 0 AS crnblc,0 AS oriamt,   "+
                    "\n                0 AS pendamt,0 AS penddisc,pono,orderno  "+
                    "\nFROM  ap_payd d1  "+
                    "\nINNER JOIN ap_invobl d  "+
                    "\nON d1.vendcode=d.vendcode AND d1.doctype=d.doctype AND d1.docnum=d.docnum  and d1.linests=0 and d1.vendcode='"+vendorcode+"' "+
                    "\n) AS a  "+
                    "\nGROUP BY a.vendcode,a.docdate,a.docnum,a.doctype";
//        +
//                    "\n having sum(a.oriamt) - sum(a.pendamt) > 0 ";

        ResultSet rs = null;
        DbBean db = DbBean.connect();


//        System.out.println(query);


        try {
            rs = (ResultSet) db.executeQuery(query);
            while (rs.next()){

                recordLoadap(rs);
            }
            rs.close();
            if (this.size()>0){
                return true;
            }
        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }

        return false;
    }


    public Boolean initdataar (String vendorcode) throws CodeException{
        String query="SELECT  a.custmrcode, "+
                    "IF(SUM(a.aplyto)=0,'N','P') AS aplyto,  "+
                    "IF(a.doctype=4,'IN',IF(a.doctype=5,'CN',IF(a.doctype=6,'DN','IT'))) AS doctype, a.docdate,a.docnum, SUM(a.applamt) AS applamt,   "+
                    "SUM(discamt) AS discamt,SUM(a.netblc) AS netblc, SUM(a.crnblc) AS crnblc, SUM(a.oriamt) AS oriamt, SUM(a.pendamt) AS pendamt,  "+
                    "SUM(penddisc) AS penddisc,pono,orderno  "+
                    "FROM  "+
                    "( 	SELECT custmrcode,0 AS aplyto,doctype AS doctype,docnum,docdate,docduedate,   "+
                    "0 AS applamt, 0 AS discamt,doctotalamtr AS netblc, doctotalamtr AS crnblc,doctotalamt AS oriamt,   "+
                    "0 AS pendamt,0 AS penddisc,custmrpono AS pono,orderno  "+
                    "FROM  ar_invobl WHERE swpaid=0 AND custmrcode='"+vendorcode+"'  "+
                    "UNION ALL  "+
                    "SELECT	b.custcode AS vendcodear_invobl,1 AS aplyto,a.doctype AS doctype,b.docno,a.docdate,a.docduedate,  "+
                    "        0 AS applamt, 0 AS discamt,b.applamount*-1 AS netblc, 0 AS crnblc, 0 AS oriamt,   "+
                    "        b.applamount AS pendamt,b.discount AS penddisc,a.custmrpono AS pono,a.orderno  "+
                    "FROM  ar_invobl a   "+
                    "INNER JOIN	cb_batchsd b ON  a.custmrcode=b.custcode AND a.docnum=b.docno AND a.swpaid=0 AND   "+
                    "                b.linests=0 AND b.custcode='"+vendorcode+"'  "+
                    "INNER JOIN 	cb_batchh c ON b.batchno=c.batchno AND b.entryno=c.entryno AND c.entrytype='R'  "+
                    "UNION ALL "+
                    "SELECT 	d.custmrcode,0 AS aplyto,d.doctype AS doctype,d.docnum,d.docdate,d.docduedate,  "+
                    "        0 AS applamt, 0 AS discamt,d1.payamt*-1 AS netblc, 0 AS crnblc,0 AS oriamt,    "+
                    "        0 AS pendamt,0 AS penddisc,custmrpono,orderno   "+
                    "FROM  ar_rcpd d1   "+
                    "INNER JOIN 	ar_invobl d ON d1.custmrcode=d.custmrcode AND d1.doctype=d.doctype AND d1.docnum=d.docnum  AND d1.linests=0  "+
                    "                AND d1.custmrcode='"+vendorcode+"'  "+
                    ") 	AS a  "+
                    "GROUP BY a.custmrcode,a.docdate,a.docnum,a.doctype";

        ResultSet rs = null;
        DbBean db = DbBean.connect();


        System.out.println(query);


        try {
            rs = (ResultSet) db.executeQuery(query);
            while (rs.next()){
                recordLoadar(rs);
            }
            rs.close();
            if (this.size()>0){
                return true;
            }
        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }

        return false;
    }

}
