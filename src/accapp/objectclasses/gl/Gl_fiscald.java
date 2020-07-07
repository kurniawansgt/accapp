/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_fiscaldAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_fiscald obj = new Gl_fiscald();
 * 
 * 2. Gl_fiscald obj = new Gl_fiscald(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald(1);
 * 
 *    It Means : Select * from gl_fiscald where id = 1;
 * 
 * 3. Gl_fiscald obj = new Gl_fiscald(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald(1);
 * 
 *    It Means : Select * from gl_fiscald where id = 1;
 * 
 * 4. Gl_fiscald obj = new Gl_fiscald(<primary_key>); 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald("1");
 *    It Means : Select * from gl_fiscald where <primary_key> = "1";
 * 
 * 5. Gl_fiscald obj = new Gl_fiscald(Gl_fiscald.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald(Gl_fiscald.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_fiscald where id = "1";
 * 
 * 6. Gl_fiscald obj = new Gl_fiscald();
 *    obj.loadString(Gl_fiscald.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald();
 *    obj.loadString(Gl_fiscald.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_fiscald where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_fiscald Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_fiscald : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_fiscald obj = new Gl_fiscald(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_fiscald where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Gl_fiscald extends Gl_fiscaldAbst{
    public Gl_fiscald() throws CodeException {
       
    }
    
    public Gl_fiscald(long id) throws CodeException {
        super(id);
    }
    
    public Gl_fiscald(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_fiscald(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_fiscald(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getmopstsdsc() throws CodeException{
        if (this.getmopsts()==1){
            return "Unlocked";
        }
        return "Locked";
    }

    public String getmopdesc() throws CodeException {
        String [] month_name=GlobalUtils.getMonth();
        Long mop=this.getmop()-1;
        return month_name[mop.intValue()];
    }
}




