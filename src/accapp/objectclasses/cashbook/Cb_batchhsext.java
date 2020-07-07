/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;

import common.utils.CodeException;

/**
 *
 * @author User
 */
public class Cb_batchhsext extends Cb_batchhs {

   public Cb_batchhsext() throws CodeException {
        this.column=new String[][] {
        {Cb_batchh.PROPERTY_CUSTCHEQNO, Cb_batchh.PROPERTY_CUSTCHEQNO, "70"},
        {Cb_batchh.PROPERTY_REFERENCE, Cb_batchh.PROPERTY_REFERENCE, "120"},
        {Cb_batchh.PROPERTY_DSCRIPTION, Cb_batchh.PROPERTY_DSCRIPTION, "220"},
        {Cb_batchh.PROPERTY_MISCCODE, Cb_batchh.PROPERTY_MISCCODE, "70"},
        {Cb_batchh.PROPERTY_TOTAMOUNT, Cb_batchh.PROPERTY_TOTAMOUNT, "100"},
        {Cb_batchh.PROPERTY_ENTRYDATE, Cb_batchh.PROPERTY_ENTRYDATE, "100"}

    };
    }

}
