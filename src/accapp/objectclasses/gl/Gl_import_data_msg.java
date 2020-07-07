/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_import_data_msgAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_import_data_msg obj = new Gl_import_data_msg();
 * 
 * 2. Gl_import_data_msg obj = new Gl_import_data_msg(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg(1);
 * 
 *    It Means : Select * from gl_import_data_msg where id = 1;
 * 
 * 3. Gl_import_data_msg obj = new Gl_import_data_msg(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg(1);
 * 
 *    It Means : Select * from gl_import_data_msg where id = 1;
 * 
 * 4. Gl_import_data_msg obj = new Gl_import_data_msg(<primary_key>); 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg("1");
 *    It Means : Select * from gl_import_data_msg where <primary_key> = "1";
 * 
 * 5. Gl_import_data_msg obj = new Gl_import_data_msg(Gl_import_data_msg.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg(Gl_import_data_msg.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_import_data_msg where id = "1";
 * 
 * 6. Gl_import_data_msg obj = new Gl_import_data_msg();
 *    obj.loadString(Gl_import_data_msg.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg();
 *    obj.loadString(Gl_import_data_msg.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_import_data_msg where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_import_data_msg Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_import_data_msg : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_import_data_msg obj = new Gl_import_data_msg(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_import_data_msg where id = 1;
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
public class Gl_import_data_msg extends Gl_import_data_msgAbst{
    public Gl_import_data_msg() throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = " select * from gl_import_data_msg where "
                + "audituser = '" + GlobalUtils.userid + "'  and cmpnyid = '" + GlobalUtils.company +"'";

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
    
    public Gl_import_data_msg(long id) throws CodeException {
        super(id);
    }
    
    public Gl_import_data_msg(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_import_data_msg(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_import_data_msg(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




