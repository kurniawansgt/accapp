/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_distsetdAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_distsetd obj = new Ap_distsetd();
 * 
 * 2. Ap_distsetd obj = new Ap_distsetd(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd(1);
 * 
 *    It Means : Select * from ap_distsetd where id = 1;
 * 
 * 3. Ap_distsetd obj = new Ap_distsetd(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd(1);
 * 
 *    It Means : Select * from ap_distsetd where id = 1;
 * 
 * 4. Ap_distsetd obj = new Ap_distsetd(<primary_key>); 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd("1");
 *    It Means : Select * from ap_distsetd where <primary_key> = "1";
 * 
 * 5. Ap_distsetd obj = new Ap_distsetd(Ap_distsetd.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd(Ap_distsetd.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_distsetd where id = "1";
 * 
 * 6. Ap_distsetd obj = new Ap_distsetd();
 *    obj.loadString(Ap_distsetd.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd();
 *    obj.loadString(Ap_distsetd.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_distsetd where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_distsetd Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_distsetd : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_distsetd obj = new Ap_distsetd(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_distsetd where id = 1;
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
public class Ap_distsetd extends Ap_distsetdAbst{
    public Ap_distsetd() throws CodeException {
       
    }
    
    public Ap_distsetd(long id) throws CodeException {
        super(id);
    }
    
    public Ap_distsetd(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_distsetd(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_distsetd(ResultSet rs) throws CodeException {
        super(rs);
    }

    public String getAp_DistDesc() throws CodeException {
        Ap_distcode ad = new Ap_distcode(this.getdistcode());
        return ad.getdscription();

    }
    public String getAp_DistGL() throws CodeException {
        Ap_distcode ad = new Ap_distcode(this.getdistcode());
        return ad.getglacccodefmt();
    }


}




