/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Op_taxAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Op_tax obj = new Op_tax();
 * 
 * 2. Op_tax obj = new Op_tax(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Op_tax obj = new Op_tax(1);
 * 
 *    It Means : Select * from op_tax where id = 1;
 * 
 * 3. Op_tax obj = new Op_tax(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Op_tax obj = new Op_tax(1);
 * 
 *    It Means : Select * from op_tax where id = 1;
 * 
 * 4. Op_tax obj = new Op_tax(<primary_key>); 
 *    Sample :
 *    Op_tax obj = new Op_tax("1");
 *    It Means : Select * from op_tax where <primary_key> = "1";
 * 
 * 5. Op_tax obj = new Op_tax(Op_tax.PROPERTY_<field>, <value>);
 *    Sample :
 *    Op_tax obj = new Op_tax(Op_tax.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from op_tax where id = "1";
 * 
 * 6. Op_tax obj = new Op_tax();
 *    obj.loadString(Op_tax.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Op_tax obj = new Op_tax();
 *    obj.loadString(Op_tax.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from op_tax where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM op_tax Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("op_tax : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Op_tax obj = new Op_tax(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Op_tax obj = new Op_tax(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from op_tax where id = 1;
 * 
 * 
 */


package accapp.objectclasses.op;

import accapp.objectclasses.gl.Gl_account;
import accapp.objectclasses.gl.Gl_currency;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Op_tax extends Op_taxAbst{
    public Op_tax() throws CodeException {
       
    }
    
    public Op_tax(long id) throws CodeException {
        super(id);
    }
    
    public Op_tax(String val)  throws CodeException {
        super(val);
    }
    
    public Op_tax(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Op_tax(ResultSet rs) throws CodeException {
        super(rs);
    }


    public String getCurrencyDesc() throws CodeException {

        Gl_currency glcurr = new Gl_currency(getcurnccode());

        return glcurr.getcurncdesc();
    }
   public String getLiablyAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getliablyacccode());

        return acc.getaccdesc();
    }
   public String getRecVrAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getrecvracccode());

        return acc.getaccdesc();
   }
   public String geExpnAccDesc() throws CodeException{

        Gl_account acc = new Gl_account(this.getexpnacccode());

        return acc.getaccdesc();
    }
   
    public void save() throws CodeException {

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }


     public void setliablyacccode(String param) throws CodeException {
        super.setliablyacccode(param.replace("-", ""));
     }

      public String getliablyacccodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getliablyacccode());
      }

      public String getliablyacccodedesc() throws CodeException {
        Gl_account gla = new Gl_account(this.getliablyacccode());
        return gla.getaccdesc();

      }

      public void setrecvracccode(String param) throws CodeException {
        super.setrecvracccode(param.replace("-", ""));
      }

      public String getrecvracccodefmt() throws CodeException {
        return Gl_account.getAccFormat(this.getrecvracccode());
      }
      
      public String getrecvracccodedesc() throws CodeException {
        Gl_account gla = new Gl_account(this.getrecvracccode());
        return gla.getaccdesc();
      }

      public void setexpnacccode(String param) throws CodeException {
          super.setexpnacccode(param.replace("-", ""));
      }

      public String getexpnacccodefmt() throws CodeException {
          return Gl_account.getAccFormat(this.getexpnacccode());

      }
      public String getexpnacccodedesc() throws CodeException {
        Gl_account gla = new Gl_account(this.getexpnacccode());
        return gla.getaccdesc();
      }


}




