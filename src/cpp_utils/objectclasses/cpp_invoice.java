/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpp_utils.objectclasses;

/**
 *
 * @author solution
 */
public class cpp_invoice {
    private String trans_number;
    private String invoice_date;
    private String invoice_number;
    private String cust_number;
    private String cust_name;
    private String cust_code_accpac;
    private Double bfrppn;
    private Double ppn;
    private Double ppnval;
    private Double aftppn;
    private String invoice_due_date;
    private String account_code;
    private boolean disable=false;

    /**
     * @return the trans_number
     */
    public String getTrans_number() {
        return trans_number;
    }

    /**
     * @param trans_number the trans_number to set
     */
    public void setTrans_number(String trans_number) {
        this.trans_number = trans_number;
    }

    /**
     * @return the invoice_date
     */
    public String getInvoice_date() {
        return invoice_date;
    }

    /**
     * @param invoice_date the invoice_date to set
     */
    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    /**
     * @return the invoice_number
     */
    public String getInvoice_number() {
        return invoice_number;
    }

    /**
     * @param invoice_number the invoice_number to set
     */
    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    /**
     * @return the cust_number
     */
    public String getCust_number() {
        return cust_number;
    }

    /**
     * @param cust_number the cust_number to set
     */
    public void setCust_number(String cust_number) {
        this.cust_number = cust_number;
    }

    /**
     * @return the cust_name
     */
    public String getCust_name() {
        return cust_name;
    }

    /**
     * @param cust_name the cust_name to set
     */
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    /**
     * @return the cust_code_accpac
     */
    public String getCust_code_accpac() {
        return cust_code_accpac;
    }

    /**
     * @param cust_code_accpac the cust_code_accpac to set
     */
    public void setCust_code_accpac(String cust_code_accpac) {
        this.cust_code_accpac = cust_code_accpac;
    }

    /**
     * @return the bfrppn
     */
    public Double getBfrppn() {
        return bfrppn;
    }

    /**
     * @param bfrppn the bfrppn to set
     */
    public void setBfrppn(Double bfrppn) {
        this.bfrppn = bfrppn;
    }

    /**
     * @return the ppn
     */
    public Double getPpn() {
        return ppn;
    }

    /**
     * @param ppn the ppn to set
     */
    public void setPpn(Double ppn) {
        this.ppn = ppn;
    }

    /**
     * @return the ppnval
     */
    public Double getPpnval() {
        return ppnval;
    }

    /**
     * @param ppnval the ppnval to set
     */
    public void setPpnval(Double ppnval) {
        this.ppnval = ppnval;
    }

    /**
     * @return the aftppn
     */
    public Double getAftppn() {
        return aftppn;
    }

    /**
     * @param aftppn the aftppn to set
     */
    public void setAftppn(Double aftppn) {
        this.aftppn = aftppn;
    }

    public String getInvoice_due_date() {
        return this.invoice_due_date;
    }

    void setInvoice_due_date(String invoice_due_date) {
        this.invoice_due_date=invoice_due_date;
    }

    public String getacccount_code() {
        return this.account_code;
    }

    public void setaccount_code(String account_code) {
        this.account_code=account_code;
    }

    public void setdisable(boolean b) {
        this.disable=b;
    }

    public boolean isdisable() {
        return this.disable;
    }

}
