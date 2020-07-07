/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;

import common.jdbc.DbBean;
import common.utils.CodeException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author isparthama
 */
public class Cb_invoblcbhsd {
    private String vendcode;
    private String aplyto;
    private String doctype;
    private String docnum;
    private Double applamt;
    private Double discamt;
    private Double netblc;
    private Double crnblc;
    private Double oriamt;
    private Double pendamt;
    private Double penddisc;
    private String pono;
    private String orderno;
    private String docdate;

    /**
     * @return the vendcode
     */
    public String getVendcode() {
        return vendcode;
    }

    /**
     * @param vendcode the vendcode to set
     */
    public void setVendcode(String vendcode) {
        this.vendcode = vendcode;
    }

    /**
     * @return the aplyto
     */
    public String getAplyto() {
        return aplyto;
    }

    /**
     * @param aplyto the aplyto to set
     */
    public void setAplyto(String aplyto) {
        this.aplyto = aplyto;
    }

    /**
     * @return the doctype
     */
    public String getDoctype() {
        return doctype;
    }

    /**
     * @param doctype the doctype to set
     */
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    /**
     * @return the docnum
     */
    public String getDocnum() {
        return docnum;
    }

    /**
     * @param docnum the docnum to set
     */
    public void setDocnum(String docnum) {
        this.docnum = docnum;
    }

    /**
     * @return the applamt
     */
    public Double getApplamt() {
        return applamt;
    }

    /**
     * @param applamt the applamt to set
     */
    public void setApplamt(Double applamt) {
        this.applamt = applamt;
    }

    /**
     * @return the discamt
     */
    public Double getDiscamt() {
        return discamt;
    }

    /**
     * @param discamt the discamt to set
     */
    public void setDiscamt(Double discamt) {
        this.discamt = discamt;
    }

    /**
     * @return the netblc
     */
    public Double getNetblc() {
        return netblc;
    }

    /**
     * @param netblc the netblc to set
     */
    public void setNetblc(Double netblc) {
        this.netblc = netblc;
    }

    /**
     * @return the crnblc
     */
    public Double getCrnblc() {
        return crnblc;
    }

    /**
     * @param crnblc the crnblc to set
     */
    public void setCrnblc(Double crnblc) {
        this.crnblc = crnblc;
    }

    /**
     * @return the oriamt
     */
    public Double getOriamt() {
        return oriamt;
    }

    /**
     * @param oriamt the oriamt to set
     */
    public void setOriamt(Double oriamt) {
        this.oriamt = oriamt;
    }

    /**
     * @return the pendamt
     */
    public Double getPendamt() {
        return pendamt;
    }

    /**
     * @param pendamt the pendamt to set
     */
    public void setPendamt(Double pendamt) {
        this.pendamt = pendamt;
    }

    /**
     * @return the penddisc
     */
    public Double getPenddisc() {
        return penddisc;
    }

    /**
     * @param penddisc the penddisc to set
     */
    public void setPenddisc(Double penddisc) {
        this.penddisc = penddisc;
    }

    /**
     * @return the pono
     */
    public String getPono() {
        return pono;
    }

    /**
     * @param pono the pono to set
     */
    public void setPono(String pono) {
        this.pono = pono;
    }

    /**
     * @return the orderno
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * @param orderno the orderno to set
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    /**
     * @return the docdate
     */
    public String getDocdate() {
        return docdate;
    }

    /**
     * @param docdate the docdate to set
     */
    public void setDocdate(String docdate) {
        this.docdate = docdate;
    }


    private void recordLoadap(ResultSet rs) throws SQLException{
        setVendcode(rs.getString("Vendcode"));
        setAplyto(rs.getString("aplyto"));
        setDoctype(rs.getString("doctype"));
        setDocdate(rs.getString("docdate"));
        setDocnum(rs.getString("docnum"));
        setApplamt(rs.getDouble("applamt"));
        setDiscamt(rs.getDouble("discamt"));
        setNetblc(rs.getDouble("netblc"));
        setCrnblc(rs.getDouble("crnblc"));
        setOriamt(rs.getDouble("oriamt"));
        setPendamt(rs.getDouble("pendamt"));
        setPenddisc(rs.getDouble("penddisc"));
        setPono(rs.getString("pono"));
        setOrderno(rs.getString("orderno"));
    }

    private void recordLoadar(ResultSet rs) throws SQLException{
        setVendcode(rs.getString("custmrcode"));
        setAplyto(rs.getString("aplyto"));
        setDoctype(rs.getString("doctype"));
        setDocdate(rs.getString("docdate"));
        setDocnum(rs.getString("docnum"));
        setApplamt(rs.getDouble("applamt"));
        setDiscamt(rs.getDouble("discamt"));
        setNetblc(rs.getDouble("netblc"));
        setCrnblc(rs.getDouble("crnblc"));
        setOriamt(rs.getDouble("oriamt"));
        setPendamt(rs.getDouble("pendamt"));
        setPenddisc(rs.getDouble("penddisc"));
        setPono(rs.getString("pono"));
        setOrderno(rs.getString("orderno"));
    }

    public Boolean initdataap (String vendorcode, String docnum) throws CodeException{
        String query="select  a.vendcode,if(sum(a.aplyto)=0,'N','P') as aplyto, "+
                            "\n if(a.doctype=4,'IN',if(a.doctype=5,'DN',if(a.doctype=6,'CN','IT'))) as doctype, a.docdate,a.docnum, sum(a.applamt) as applamt,  "+
                            "\n sum(discamt) as discamt,sum(a.netblc) as netblc, sum(a.crnblc) as crnblc, sum(a.oriamt) as oriamt, sum(a.pendamt) as pendamt, "+
                            "\n sum(penddisc) as penddisc,pono,orderno "+
                    "\n from "+
                    "\n ( select vendcode,0 as aplyto,doctype as doctype,docnum,docdate,docduedate,  "+
                            "\n 0 as applamt, 0 as discamt,doctotalamtr as netblc, doctotalamtr as crnblc,doctotalamt as oriamt,  "+
                            "\n 0 as pendamt,0 as penddisc,pono,orderno "+
                    "\n from  ap_invobl where swpaid=0 and vendcode='" + vendorcode + "' and docnum = '" + docnum + "' " +
                    "\n union all "+
                    "\n select  b.custcode as vendcodeap_invobl,1 as aplyto,a.doctype as doctype,b.docno,a.docdate,a.docduedate, "+
                            "\n 0 as applamt, 0 as discamt,b.applamount*-1 as netblc, 0 as crnblc, 0 as oriamt,  "+
                            "\n b.applamount as pendamt,b.discount as penddisc,a.pono,a.orderno "+
                    "\n from  ap_invobl a  "+
                    "\n inner join cb_batchsd b on  a.vendcode=b.custcode and a.docnum=b.docno and a.swpaid=0 and  "+
                            "\n b.linests=0 and b.custcode='" + vendorcode + "' and a.docnum = '" + docnum + "' " +
                    "\n inner join cb_batchh c on b.batchno=c.batchno and b.entryno=c.entryno and c.entrytype='P' "+
                    "\n ) as a "+
                    "\n group by a.vendcode,a.docdate,a.docnum,a.doctype" +
                    "\n having sum(a.oriamt) - sum(a.pendamt) > 0 ";




        System.out.println(query);

        ResultSet rs = null;
        DbBean db = DbBean.connect();


        try {
            rs = (ResultSet) db.executeQuery(query);
            if (rs.next()) {
                recordLoadap(rs);
            }

            rs.close();
            
        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }

        return false;
    }


    public Boolean initdataar (String vendorcode, String docnum) throws CodeException{
        String query="select  a.custmrcode,if(sum(a.aplyto)=0,'N','P') as aplyto, "+
                    "\n         if(a.doctype=4,'IN',if(a.doctype=5,'DN',if(a.doctype=6,'CN','IT'))) as doctype, a.docdate,a.docnum, sum(a.applamt) as applamt,  "+
                    "\n         sum(discamt) as discamt,sum(a.netblc) as netblc, sum(a.crnblc) as crnblc, sum(a.oriamt) as oriamt, sum(a.pendamt) as pendamt, "+
                    "\n         sum(penddisc) as penddisc,pono,orderno "+
                    "\n from "+
                    "\n ( select custmrcode,0 as aplyto,doctype as doctype,docnum,docdate,docduedate,  "+
                    "\n         0 as applamt, 0 as discamt,doctotalamtr as netblc, doctotalamtr as crnblc,doctotalamt as oriamt,  "+
                    "\n         0 as pendamt,0 as penddisc,custmrpono as pono,orderno "+
                    "\n from  ar_invobl where swpaid=0 and custmrcode='" + vendorcode +  "' and docnum = '" + docnum + "' " +
                    "\n union all "+
                    "\n select  b.custcode as vendcodear_invobl,1 as aplyto,a.doctype as doctype,b.docno,a.docdate,a.docduedate, "+
                    "\n         0 as applamt, 0 as discamt,b.applamount*-1 as netblc, 0 as crnblc, 0 as oriamt,  "+
                    "\n         b.applamount as pendamt,b.discount as penddisc,a.custmrpono as pono,a.orderno "+
                    "\n from  ar_invobl a  "+
                    "\n inner join cb_batchsd b on  a.custmrcode=b.custcode and a.docnum=b.docno and a.swpaid=0 and  "+
                    "\n         b.linests=0 and b.custcode='" + vendorcode + "' and a.docnum = '" + docnum + "' " +
                    "\n inner join cb_batchh c on b.batchno=c.batchno and b.entryno=c.entryno and c.entrytype='R' "+
                    "\n ) as a "+
                    "\n group by a.custmrcode,a.docdate,a.docnum,a.doctype";

        ResultSet rs = null;
        DbBean db = DbBean.connect();


        System.out.println(query);


        try {
            rs = (ResultSet) db.executeQuery(query);
            if(rs.next()) {
                recordLoadar(rs);
            }
            rs.close();
        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }

        return false;
    }

}
