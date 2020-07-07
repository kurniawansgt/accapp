/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_invobpAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_invobp obj = new Ar_invobp();
 * 
 * 2. Ar_invobp obj = new Ar_invobp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp(1);
 * 
 *    It Means : Select * from ar_invobp where id = 1;
 * 
 * 3. Ar_invobp obj = new Ar_invobp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp(1);
 * 
 *    It Means : Select * from ar_invobp where id = 1;
 * 
 * 4. Ar_invobp obj = new Ar_invobp(<primary_key>); 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp("1");
 *    It Means : Select * from ar_invobp where <primary_key> = "1";
 * 
 * 5. Ar_invobp obj = new Ar_invobp(Ar_invobp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp(Ar_invobp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_invobp where id = "1";
 * 
 * 6. Ar_invobp obj = new Ar_invobp();
 *    obj.loadString(Ar_invobp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp();
 *    obj.loadString(Ar_invobp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_invobp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_invobp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_invobp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_invobp obj = new Ar_invobp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_invobp where id = 1;
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
public class Ar_invobp extends Ar_invobpAbst{
    public Ar_invobp() throws CodeException {
       
    }
    
    public Ar_invobp(long id) throws CodeException {
        super(id);
    }
    
    public Ar_invobp(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_invobp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_invobp(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void searchData(String custmrcode,String docnum) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query="";

        query = " select * from ar_invobp where custmrcode='"+custmrcode+"' and docnum='"+docnum+"'";
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




