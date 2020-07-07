/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Setting_financial_rpt_detail1Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1();
 * 
 * 2. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(1);
 * 
 *    It Means : Select * from setting_financial_rpt_detail1 where id = 1;
 * 
 * 3. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(1);
 * 
 *    It Means : Select * from setting_financial_rpt_detail1 where id = 1;
 * 
 * 4. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(<primary_key>); 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1("1");
 *    It Means : Select * from setting_financial_rpt_detail1 where <primary_key> = "1";
 * 
 * 5. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(Setting_financial_rpt_detail1.PROPERTY_<field>, <value>);
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(Setting_financial_rpt_detail1.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from setting_financial_rpt_detail1 where id = "1";
 * 
 * 6. Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1();
 *    obj.loadString(Setting_financial_rpt_detail1.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1();
 *    obj.loadString(Setting_financial_rpt_detail1.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from setting_financial_rpt_detail1 where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM setting_financial_rpt_detail1 Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("setting_financial_rpt_detail1 : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Setting_financial_rpt_detail1 obj = new Setting_financial_rpt_detail1(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from setting_financial_rpt_detail1 where id = 1;
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
public class Setting_financial_rpt_detail1 extends Setting_financial_rpt_detail1Abst{
    public Setting_financial_rpt_detail1() throws CodeException {
       
    }
    
    public Setting_financial_rpt_detail1(long id) throws CodeException {
        super(id);
    }
    
    public Setting_financial_rpt_detail1(String val)  throws CodeException {
        super(val);
    }
    
    public Setting_financial_rpt_detail1(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Setting_financial_rpt_detail1(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxDocEntry() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(lineno) is null then 1 else max(lineno) + 1 end lineno "
                            + "\n from setting_financial_rpt_detail1 where docentry="+this.getdocentry();

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("lineno");

            }

       } catch (SQLException ex) {
             throw new CodeException("Setting_financial_rpt_detail1 : " + ex.getMessage());
       }finally{
           db.close();
       }
       return entry;
    }
    
}




