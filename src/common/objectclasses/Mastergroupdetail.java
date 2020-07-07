/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MastergroupdetailAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Mastergroupdetail obj = new Mastergroupdetail();
 * 
 * 2. Mastergroupdetail obj = new Mastergroupdetail(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail(1);
 * 
 *    It Means : Select * from mastergroupdetail where id = 1;
 * 
 * 3. Mastergroupdetail obj = new Mastergroupdetail(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail(1);
 * 
 *    It Means : Select * from mastergroupdetail where id = 1;
 * 
 * 4. Mastergroupdetail obj = new Mastergroupdetail(<primary_key>); 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail("1");
 *    It Means : Select * from mastergroupdetail where <primary_key> = "1";
 * 
 * 5. Mastergroupdetail obj = new Mastergroupdetail(Mastergroupdetail.PROPERTY_<field>, <value>);
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail(Mastergroupdetail.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from mastergroupdetail where id = "1";
 * 
 * 6. Mastergroupdetail obj = new Mastergroupdetail();
 *    obj.loadString(Mastergroupdetail.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail();
 *    obj.loadString(Mastergroupdetail.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from mastergroupdetail where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM mastergroupdetail Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("mastergroupdetail : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Mastergroupdetail obj = new Mastergroupdetail(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from mastergroupdetail where id = 1;
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
public class Mastergroupdetail extends MastergroupdetailAbst{

    public static String[][] columns= 
                {        
                   {"ID", "ID", "0"},
                   {"Module", "Module", "200"},
                   {"Keterangan", "Keterangan", "200"},
                   {"Read", "Read", "50"}, 
                   {"Confirm", "Confirm", "50"}, 
                   {"Entry", "Entry", "50"}, 
                   {"Update", "Update", "50"}, 
                   {"Delete", "Delete", "50"},
                   {"Print", "Print", "50"},
                   {"Export", "Export", "50"},
                   {"Import", "Import", "50"}
                };

    public Mastergroupdetail() throws CodeException {
       
    }
    
    public Mastergroupdetail(long id) throws CodeException {
        super(id);
    }
    
    public Mastergroupdetail(String val)  throws CodeException {
        super(val);
    }
    
    public Mastergroupdetail(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Mastergroupdetail(ResultSet rs) throws CodeException {
        super(rs);
    }
    
    public void loadData(String kodegroup, String company,  String module) throws CodeException {
        DbBeanCommon db = DbBeanCommon.connect();
        String sql = "SELECT * FROM " 
                      + this.TABLEPROCESS 
                      + " Where kodegroup = '" + kodegroup + "' "
                      + "         and company = '" + company + "' "
                      + "         and module = '" + module + "' ";
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



