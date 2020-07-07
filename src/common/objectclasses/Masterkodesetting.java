/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from MasterkodesettingAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Masterkodesetting obj = new Masterkodesetting();
 * 
 * 2. Masterkodesetting obj = new Masterkodesetting(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting(1);
 * 
 *    It Means : Select * from masterkodesetting where id = 1;
 * 
 * 3. Masterkodesetting obj = new Masterkodesetting(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting(1);
 * 
 *    It Means : Select * from masterkodesetting where id = 1;
 * 
 * 4. Masterkodesetting obj = new Masterkodesetting(<primary_key>); 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting("1");
 *    It Means : Select * from masterkodesetting where <primary_key> = "1";
 * 
 * 5. Masterkodesetting obj = new Masterkodesetting(Masterkodesetting.PROPERTY_<field>, <value>);
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting(Masterkodesetting.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from masterkodesetting where id = "1";
 * 
 * 6. Masterkodesetting obj = new Masterkodesetting();
 *    obj.loadString(Masterkodesetting.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting();
 *    obj.loadString(Masterkodesetting.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from masterkodesetting where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM masterkodesetting Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("masterkodesetting : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Masterkodesetting obj = new Masterkodesetting(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from masterkodesetting where id = 1;
 * 
 * 
 */


package common.objectclasses;

import common.jdbc.DbBeanCommon;
import common.utils.GlobalUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Masterkodesetting extends MasterkodesettingAbst{
    public Masterkodesetting() throws CodeException {
       
    }
    
    public Masterkodesetting(long id) throws CodeException {
        super(id);
    }
    
    public Masterkodesetting(String val)  throws CodeException {
        super(val);
    }
    
    public Masterkodesetting(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Masterkodesetting(ResultSet rs) throws CodeException {
        super(rs);
    }
    
    
    public void loadData(String owner, String kodesetting) throws CodeException {
      
        DbBeanCommon db = DbBeanCommon.connect();
 
        String sql = "select * "
                     + "\n   from masterkodesetting " 
                     + "\n      where owner = '" + owner + "' " 
                     + "\n           and kodesetting = '" + kodesetting + "' ";

        
        //System.out.println(sql);
        
        try {
            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {
                loadRs(rs);
            }else {
                loadNew();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        db.close();
        
    }
    
    
    public void save() throws CodeException {        
        setUserID(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_TANGGALENTRY, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_TANGGALUPDATE, GlobalUtils.getCurrentDate());
        super.save();
    } 
    
}





