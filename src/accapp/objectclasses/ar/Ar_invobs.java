/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_invobsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_invobs obj = new Ar_invobs();
 * 
 * 2. Ar_invobs obj = new Ar_invobs(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs(1);
 * 
 *    It Means : Select * from ar_invobs where id = 1;
 * 
 * 3. Ar_invobs obj = new Ar_invobs(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs(1);
 * 
 *    It Means : Select * from ar_invobs where id = 1;
 * 
 * 4. Ar_invobs obj = new Ar_invobs(<primary_key>); 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs("1");
 *    It Means : Select * from ar_invobs where <primary_key> = "1";
 * 
 * 5. Ar_invobs obj = new Ar_invobs(Ar_invobs.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs(Ar_invobs.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_invobs where id = "1";
 * 
 * 6. Ar_invobs obj = new Ar_invobs();
 *    obj.loadString(Ar_invobs.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs();
 *    obj.loadString(Ar_invobs.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_invobs where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_invobs Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_invobs : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_invobs obj = new Ar_invobs(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_invobs where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_invobs extends Ar_invobsAbst{
    public Ar_invobs() throws CodeException {
       
    }
    
    public Ar_invobs(long id) throws CodeException {
        super(id);
    }
    
    public Ar_invobs(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_invobs(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_invobs(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void searchData(String custmrcode,String docnum) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query="";

        query = " select * from ar_invobs where custmrcode='"+custmrcode+"' and docnum='"+docnum+"'";
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

        String query = "select * from ar_invobs where vendcode='"+vendcode+"' and docnum='"+docnum+"' and doctype ='" + doctype + "' ";

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




