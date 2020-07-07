/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpp_utils.objectclasses;

import common.jdbc.DbBean;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solution
 */
public class cpp_invoices extends ArrayList<cpp_invoice>{
    private Ut_external_data oe;
    private cpp_invoice oi;

    public cpp_invoices(Ut_external_data oe){
        this.oe=oe;
    }
    public Boolean initdata(String fromdate, String todate, String type, String frcustmr, String tocustmr){
        DbBean db=new DbBean();
        try {
            db.InitConnection(oe.getexternal_svrip(), oe.getexternal_dbnm(),"");
            db.connectDriver();
            String squery="\n 	SELECT tl.trans_number,tl.invoice_date,tl.invoice_due_date,tl.invoice_number,ci.cust_number,ci.cust_name,ci.cust_code_accpac,account_number,	" +
                            "\n 	SUM(finalprice) bfrppn,tl.ppn,Round((SUM(finalprice)*tl.ppn)/100) ppnval,SUM(finalprice)+ROUND((SUM(finalprice)*tl.ppn)/100) aftppn	" +
                            "\n 	FROM transaction_log tl	" +
                            "\n 	INNER JOIN	" +
                            "\n 	(	" +
                            "\n 	SELECT account_number,trans_number,prod_number,prod_unit_price,prod_quantity,(subtotal),disc,ROUND(subtotal-disc) finalprice	" +
                            "\n 	FROM	" +
                            "\n 	(	" +
                            "\n 	SELECT a.account_number,a.trans_number,a.prod_number,a.prod_unit_price,a.prod_quantity,a.prod_special_offer,	" +
                            "\n 	(a.prod_unit_price*a.prod_quantity) subtotal,((a.prod_unit_price*a.prod_quantity)*a.prod_special_offer)/100 disc	" +
                            "\n 	FROM product_transaction a	" +
                            "\n 	) AS aa	" +
                            "\n 	) AS ab ON tl.trans_number=ab.trans_number	" +
                            "\n 	INNER JOIN customer_info ci ON tl.cust_number=ci.cust_number	" +
                            "\n 	WHERE (accpacsts='N') and" +
                            "\n 	(ci.cust_code_accpac between case when '"+frcustmr+"'='' then ci.cust_code_accpac else '"+frcustmr+"' end and  " +
                            "\n 	case when '"+tocustmr+"'='' then ci.cust_code_accpac else '"+tocustmr+"' end) and  " +
                            "\n         (tl.invoice_date BETWEEN '"+fromdate+"' AND '"+todate+"') AND tl.trans_type_id in ("+type+")	" +
                            "\n 	GROUP BY tl.invoice_number " +
                            "\n         ORDER BY tl.invoice_number;	";
            ResultSet rs;
            System.out.println(squery);
            rs = db.executeQuery(squery);
            while (rs.next()){
                oi=new cpp_invoice();
                if (fillme(rs)){
                    this.add(oi);
                }
            }
            db.close();
            DbBean.resetpool();
            DbBean.InitConnection(GlobalUtils.serverip, GlobalUtils.company,"");
            if (this.size()>0){
                return true;
            }
        } catch (CodeException ex) {
            Logger.getLogger(cpp_invoices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cpp_invoices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private boolean fillme(ResultSet rs) throws SQLException {
        oi.setTrans_number(rs.getString("Trans_number"));
        oi.setInvoice_date(rs.getString("invoice_date"));
        oi.setInvoice_number(rs.getString("Invoice_number"));
        oi.setCust_number(rs.getString("Cust_number"));
        oi.setCust_name(rs.getString("Cust_name"));
        oi.setCust_code_accpac(rs.getString("Cust_code_accpac"));
        oi.setBfrppn(rs.getDouble("Bfrppn"));
        oi.setPpn(rs.getDouble("Ppn"));
        oi.setPpnval(rs.getDouble("Ppnval"));
        oi.setAftppn(rs.getDouble("Aftppn"));
        oi.setInvoice_due_date(rs.getString("invoice_due_date"));
        oi.setaccount_code(rs.getString("account_number"));
        return true;
    }

    public Boolean closeaccsts(String invnum) {
        DbBean db=new DbBean();
        try {
            db.InitConnection(oe.getexternal_svrip(), oe.getexternal_dbnm(),"");
            db.connectDriver();
            String squery="update transaction_log set accpacsts='Y' where invoice_number in ("+invnum+")";
            db.doexecute(squery);
            db.close();
            DbBean.resetpool();
            DbBean.InitConnection(GlobalUtils.serverip, GlobalUtils.company,"");
            return true;
        } catch (CodeException ex) {
            Logger.getLogger(cpp_invoices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cpp_invoices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
