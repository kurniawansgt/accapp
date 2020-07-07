/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Q_ap_invbatchlistAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Q_ap_invbatchlist obj = new Q_ap_invbatchlist();
 * 
 * 2. Q_ap_invbatchlist obj = new Q_ap_invbatchlist(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist(1);
 * 
 *    It Means : Select * from q_ap_invbatchlist where id = 1;
 * 
 * 3. Q_ap_invbatchlist obj = new Q_ap_invbatchlist(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist(1);
 * 
 *    It Means : Select * from q_ap_invbatchlist where id = 1;
 * 
 * 4. Q_ap_invbatchlist obj = new Q_ap_invbatchlist(<primary_key>); 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist("1");
 *    It Means : Select * from q_ap_invbatchlist where <primary_key> = "1";
 * 
 * 5. Q_ap_invbatchlist obj = new Q_ap_invbatchlist(Q_ap_invbatchlist.PROPERTY_<field>, <value>);
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist(Q_ap_invbatchlist.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from q_ap_invbatchlist where id = "1";
 * 
 * 6. Q_ap_invbatchlist obj = new Q_ap_invbatchlist();
 *    obj.loadString(Q_ap_invbatchlist.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist();
 *    obj.loadString(Q_ap_invbatchlist.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from q_ap_invbatchlist where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM q_ap_invbatchlist Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("q_ap_invbatchlist : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Q_ap_invbatchlist obj = new Q_ap_invbatchlist(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from q_ap_invbatchlist where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class Q_ap_invbatchlist extends Q_ap_invbatchlistAbst{
    public Q_ap_invbatchlist() throws CodeException {
       
    }
    
    public Q_ap_invbatchlist(long id) throws CodeException {
        super(id);
    }
    
    public Q_ap_invbatchlist(String val)  throws CodeException {
        super(val);
    }
    
    public Q_ap_invbatchlist(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Q_ap_invbatchlist(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




