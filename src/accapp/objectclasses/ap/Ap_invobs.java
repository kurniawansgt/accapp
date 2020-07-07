/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_invobsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_invobs obj = new Ap_invobs();
 * 
 * 2. Ap_invobs obj = new Ap_invobs(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs(1);
 * 
 *    It Means : Select * from ap_invobs where id = 1;
 * 
 * 3. Ap_invobs obj = new Ap_invobs(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs(1);
 * 
 *    It Means : Select * from ap_invobs where id = 1;
 * 
 * 4. Ap_invobs obj = new Ap_invobs(<primary_key>); 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs("1");
 *    It Means : Select * from ap_invobs where <primary_key> = "1";
 * 
 * 5. Ap_invobs obj = new Ap_invobs(Ap_invobs.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs(Ap_invobs.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_invobs where id = "1";
 * 
 * 6. Ap_invobs obj = new Ap_invobs();
 *    obj.loadString(Ap_invobs.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs();
 *    obj.loadString(Ap_invobs.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_invobs where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_invobs Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_invobs : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_invobs obj = new Ap_invobs(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_invobs where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ap_invobs extends Ap_invobsAbst{
    public Ap_invobs() throws CodeException {
       
    }
    
    public Ap_invobs(long id) throws CodeException {
        super(id);
    }
    
    public Ap_invobs(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_invobs(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_invobs(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setauditdate(this.getentrydate());
        this.setaudituser(GlobalUtils.getUserId());
        this.setcmpnyid(GlobalUtils.company);
        super.saveNew();
    }

    @Override
    public void save() throws CodeException {
        this.setauditdate(this.getauditdate());
        this.setaudituser(GlobalUtils.getUserId());
        this.setcmpnyid(GlobalUtils.company);
        super.save();
    }

    public void searchData(String vendcode, String docnum) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = "select * from ap_invobs where vendcode='"+vendcode+"' and docnum='"+docnum+"'";

        try {
            rs = db.executeQuery(query);

            if (rs.next()){
                loadRs(rs);
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }


    }
    public void searchData(String vendcode, String docnum, String doctype) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = "select * from ap_invobs where vendcode='"+vendcode+"' and docnum='"+docnum+"' and doctype ='" + doctype + "' ";

        try {
            rs = db.executeQuery(query);

            if (rs.next()){
                loadRs(rs);
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }


    }
}




