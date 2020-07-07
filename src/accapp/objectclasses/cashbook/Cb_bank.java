/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Cb_bankAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Cb_bank obj = new Cb_bank();
 * 
 * 2. Cb_bank obj = new Cb_bank(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Cb_bank obj = new Cb_bank(1);
 * 
 *    It Means : Select * from cb_bank where id = 1;
 * 
 * 3. Cb_bank obj = new Cb_bank(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Cb_bank obj = new Cb_bank(1);
 * 
 *    It Means : Select * from cb_bank where id = 1;
 * 
 * 4. Cb_bank obj = new Cb_bank(<primary_key>); 
 *    Sample :
 *    Cb_bank obj = new Cb_bank("1");
 *    It Means : Select * from cb_bank where <primary_key> = "1";
 * 
 * 5. Cb_bank obj = new Cb_bank(Cb_bank.PROPERTY_<field>, <value>);
 *    Sample :
 *    Cb_bank obj = new Cb_bank(Cb_bank.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from cb_bank where id = "1";
 * 
 * 6. Cb_bank obj = new Cb_bank();
 *    obj.loadString(Cb_bank.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Cb_bank obj = new Cb_bank();
 *    obj.loadString(Cb_bank.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from cb_bank where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM cb_bank Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("cb_bank : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Cb_bank obj = new Cb_bank(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Cb_bank obj = new Cb_bank(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from cb_bank where id = 1;
 * 
 * 
 */


package accapp.objectclasses.cashbook;

import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_currency;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Cb_bank extends Cb_bankAbst{
    public Cb_bank() throws CodeException {
       
    }
    
    public Cb_bank(long id) throws CodeException {
        super(id);
    }
    
    public Cb_bank(String val)  throws CodeException {
        super(val);
    }
    
    public Cb_bank(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Cb_bank(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getrvslsrceDescription() throws CodeException {
        Cb_source cb = new Cb_source(getrvslsrcecode());
        return cb.getdscription();

    }

    public String getvoidsrceDescription() throws CodeException {
        Cb_source cb = new Cb_source(getvoidsrcecode());
        return cb.getdscription();

    }
    public String getCurrencyDescription() throws CodeException {

        Gl_currency glcurr = new Gl_currency(getcurnccode());

        return glcurr.getcurncdesc();
        
    }


    public String getBankAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getbankacccode());
        
        return acc.getaccdesc();

    }
    public String getVoidAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getvoidacccode());

        return acc.getaccdesc();

    }
    public String getTrnfAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.gettrnfclracccode());

        return acc.getaccdesc();

    }
    public String getCashclrAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getcashclracccode());

        return acc.getaccdesc();

    }

    public String getArclAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getarclracccode());

        return acc.getaccdesc();

    }
    public String getApclrAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getapclraccode());

        return acc.getaccdesc();

    }
    public String getJcclrAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getjcclracccode());

        return acc.getaccdesc();

    }

    public String getPrclrAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getprclracccode());

        return acc.getaccdesc();

    }

    public String getAPBankAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getapbankacccode());

        return acc.getaccdesc();

    }


      public void setbankacccode(String param) throws CodeException {
            super.setbankacccode(param.replace("-", ""));
      }

      public String getbankacccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getbankacccode());
      }

      public void setvoidacccode(String param) throws CodeException {
            super.setvoidacccode(param.replace("-", ""));
      }

      public String getvoidacccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getvoidacccode());
      }

      public void settrnfclracccode(String param) throws CodeException {
            super.settrnfclracccode(param.replace("-", ""));
      }

      public String gettrnfclracccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.gettrnfclracccode());
      }

      public void setcashclracccode(String param) throws CodeException {
            super.setcashclracccode(param.replace("-", ""));
      }

      public String getcashclracccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getcashclracccode());
      }

      public void setarclracccode(String param) throws CodeException {
            super.setarclracccode(param.replace("-", ""));
      }

      public String getarclracccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getarclracccode());
      }

      public void setapclraccode(String param) throws CodeException {
            super.setapclraccode(param.replace("-", ""));
      }

      public String getapclraccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getapclraccode());
      }

      public void setjcclracccode(String param) throws CodeException {
            super.setjcclracccode(param.replace("-", ""));
      }

      public String getjcclracccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getjcclracccode());
      }

      public void setprclracccode(String param) throws CodeException {
            super.setprclracccode(param.replace("-", ""));
      }

      public String getprclracccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getprclracccode());
      }

      public void setapbankacccode(String param) throws CodeException {
            super.setapbankacccode(param.replace("-", ""));
      }

      public String getapbankacccodefmt() throws CodeException {
            return Gl_account.getAccFormat(this.getapbankacccode());
      }


    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setcmpnyid(GlobalUtils.company);
        setobjtype(ObjectType.CB_BANK);
        super.save();
    }

    
}




