/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MasteruserdetailAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Masteruserdetail obj = new Masteruserdetail();
 * 
 * 2. Masteruserdetail obj = new Masteruserdetail(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail(1);
 * 
 *    It Means : Select * from masteruserdetail where id = 1;
 * 
 * 3. Masteruserdetail obj = new Masteruserdetail(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail(1);
 * 
 *    It Means : Select * from masteruserdetail where id = 1;
 * 
 * 4. Masteruserdetail obj = new Masteruserdetail(<primary_key>); 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail("1");
 *    It Means : Select * from masteruserdetail where <primary_key> = "1";
 * 
 * 5. Masteruserdetail obj = new Masteruserdetail(Masteruserdetail.PROPERTY_<field>, <value>);
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail(Masteruserdetail.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from masteruserdetail where id = "1";
 * 
 * 6. Masteruserdetail obj = new Masteruserdetail();
 *    obj.loadString(Masteruserdetail.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail();
 *    obj.loadString(Masteruserdetail.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from masteruserdetail where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM masteruserdetail Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("masteruserdetail : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Masteruserdetail obj = new Masteruserdetail(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from masteruserdetail where id = 1;
 * 
 * 
 */


package common.objectclasses;

import common.jdbc.DbBeanCommon;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Masteruserdetail extends MasteruserdetailAbst{
    public static String[][] columns= 
            {        
               {"ID", "ID", "0"},
               {"Group", "Group", "200"},
               {"Keterangan", "Keterangan", "200"},
               {"Select", "Select", "50"}
            };

    public Masteruserdetail() throws CodeException {
       
    }
    
    public Masteruserdetail(long id) throws CodeException {
        super(id);
    }
    
    public Masteruserdetail(String val)  throws CodeException {
        super(val);
    }
    
    public Masteruserdetail(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Masteruserdetail(ResultSet rs) throws CodeException {
        super(rs);
    }
    
    public void loadData(String user, String kodegroup) throws CodeException {
        DbBeanCommon db = DbBeanCommon.connect();
        String sql = "SELECT * FROM " 
                      + this.TABLEPROCESS 
                      + " Where user = '" + user  + "' " 
                      + "         and kodegroup = '" + kodegroup + "' ";
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException(TABLEPROCESS + " : Cannot Set Data " + ex.getMessage());
        }
        db.close();
    }    
}



