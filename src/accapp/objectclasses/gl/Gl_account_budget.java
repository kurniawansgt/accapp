/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_account_budgetAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_account_budget obj = new Gl_account_budget();
 * 
 * 2. Gl_account_budget obj = new Gl_account_budget(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget(1);
 * 
 *    It Means : Select * from gl_account_budget where id = 1;
 * 
 * 3. Gl_account_budget obj = new Gl_account_budget(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget(1);
 * 
 *    It Means : Select * from gl_account_budget where id = 1;
 * 
 * 4. Gl_account_budget obj = new Gl_account_budget(<primary_key>); 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget("1");
 *    It Means : Select * from gl_account_budget where <primary_key> = "1";
 * 
 * 5. Gl_account_budget obj = new Gl_account_budget(Gl_account_budget.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget(Gl_account_budget.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_account_budget where id = "1";
 * 
 * 6. Gl_account_budget obj = new Gl_account_budget();
 *    obj.loadString(Gl_account_budget.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget();
 *    obj.loadString(Gl_account_budget.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_account_budget where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_account_budget Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_account_budget : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_account_budget obj = new Gl_account_budget(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_account_budget where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Gl_account_budget extends Gl_account_budgetAbst{
    private boolean updated=false;
    public Gl_account_budget() throws CodeException {
       
    }
    
    public Gl_account_budget(long id) throws CodeException {
        super(id);
    }
    
    public Gl_account_budget(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_account_budget(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_account_budget(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void setupdated(boolean b) {
        this.updated=b;
    }

    @Override
    public void save() throws CodeException {
        super.save();
        this.updated=false;
    }

    public boolean isupdated() {
        return this.updated;
    }


}




