/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_sourcelgrAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_sourcelgr obj = new Gl_sourcelgr();
 * 
 * 2. Gl_sourcelgr obj = new Gl_sourcelgr(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr(1);
 * 
 *    It Means : Select * from gl_sourcelgr where id = 1;
 * 
 * 3. Gl_sourcelgr obj = new Gl_sourcelgr(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr(1);
 * 
 *    It Means : Select * from gl_sourcelgr where id = 1;
 * 
 * 4. Gl_sourcelgr obj = new Gl_sourcelgr(<primary_key>); 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr("1");
 *    It Means : Select * from gl_sourcelgr where <primary_key> = "1";
 * 
 * 5. Gl_sourcelgr obj = new Gl_sourcelgr(Gl_sourcelgr.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr(Gl_sourcelgr.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_sourcelgr where id = "1";
 * 
 * 6. Gl_sourcelgr obj = new Gl_sourcelgr();
 *    obj.loadString(Gl_sourcelgr.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr();
 *    obj.loadString(Gl_sourcelgr.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_sourcelgr where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_sourcelgr Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_sourcelgr : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_sourcelgr obj = new Gl_sourcelgr(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_sourcelgr where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Gl_sourcelgr extends Gl_sourcelgrAbst{
    public Gl_sourcelgr() throws CodeException {
       
    }
    
    public Gl_sourcelgr(long id) throws CodeException {
        super(id);
    }
    
    public Gl_sourcelgr(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_sourcelgr(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_sourcelgr(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void searchData(String srcelgrcode, String srcetypecode) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = " select * from gl_sourcelgr where srcelgrcode = '" + srcelgrcode + "'  and srcetypecode = '" + srcetypecode + "'";
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




