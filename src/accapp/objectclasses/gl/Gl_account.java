/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_accountAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_account obj = new Gl_account();
 * 
 * 2. Gl_account obj = new Gl_account(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_account obj = new Gl_account(1);
 * 
 *    It Means : Select * from gl_account where id = 1;
 * 
 * 3. Gl_account obj = new Gl_account(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_account obj = new Gl_account(1);
 * 
 *    It Means : Select * from gl_account where id = 1;
 * 
 * 4. Gl_account obj = new Gl_account(<primary_key>); 
 *    Sample :
 *    Gl_account obj = new Gl_account("1");
 *    It Means : Select * from gl_account where <primary_key> = "1";
 * 
 * 5. Gl_account obj = new Gl_account(Gl_account.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_account obj = new Gl_account(Gl_account.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_account where id = "1";
 * 
 * 6. Gl_account obj = new Gl_account();
 *    obj.loadString(Gl_account.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_account obj = new Gl_account();
 *    obj.loadString(Gl_account.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_account where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_account Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_account : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_account obj = new Gl_account(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_account obj = new Gl_account(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_account where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Gl_account extends Gl_accountAbst{
    public Gl_account() throws CodeException {
       
    }
    
    public Gl_account(long id) throws CodeException {
        super(id);
    }
    
    public Gl_account(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_account(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_account(ResultSet rs) throws CodeException {
        super(rs);
    }


    public static String getAccFormat(String account) throws CodeException{
        Gl_account gla = new Gl_account(account);
        return GlobalUtils.churuf(gla.getaccfmttd()).trim();
    }

    public static String getNonAccFormat(String account) throws CodeException {
        return account.replace("-", "");
    }


    public String getAccountGroupDescription() throws CodeException {

        Gl_group glgrp = new Gl_group(this.getaccgrpcode());

        return glgrp.getaccgrpdesc();
        
    }
    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setcmpnyid(GlobalUtils.company);
        super.save();
    }


    public Boolean cekkodeaccount(String accountcode,String accountstructure) throws CodeException{
            ResultSet rs = null;
            DbBean db = DbBean.connect();
            accountcode=accountcode.trim();
            String query = "SELECT fcheck_segment('"+accountcode+"','"+accountstructure+"') as ceksegement";
            System.out.println(query);
            try {
                rs = db.executeQuery(query);
                if (rs.next()){
                    if (accountcode.equalsIgnoreCase(rs.getString("ceksegement"))){
                        return  true;
                    } else {
                        throw new CodeException (rs.getString("ceksegement"));
                    }
                }
                rs.close();

            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }

        return false;
    }

    public String cekkodeaccountformated(String accountcode,String accountstructure) throws CodeException{
            ResultSet rs = null;
            DbBean db = DbBean.connect();

            String query = "SELECT fget_acccodefmtd('"+accountcode+"','"+accountstructure+"') as accountformated";
            System.out.println(query);
            try {
                rs = db.executeQuery(query);
                if (rs.next()){
                    return rs.getString("accountformated");
                }
                rs.close();

            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }

        return "";
    }
}




