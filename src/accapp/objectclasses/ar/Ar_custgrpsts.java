/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_custgrpstsAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_custgrpsts obj = new Ar_custgrpsts();
 * 
 * 2. Ar_custgrpsts obj = new Ar_custgrpsts(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts(1);
 * 
 *    It Means : Select * from ar_custgrpsts where id = 1;
 * 
 * 3. Ar_custgrpsts obj = new Ar_custgrpsts(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts(1);
 * 
 *    It Means : Select * from ar_custgrpsts where id = 1;
 * 
 * 4. Ar_custgrpsts obj = new Ar_custgrpsts(<primary_key>); 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts("1");
 *    It Means : Select * from ar_custgrpsts where <primary_key> = "1";
 * 
 * 5. Ar_custgrpsts obj = new Ar_custgrpsts(Ar_custgrpsts.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts(Ar_custgrpsts.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_custgrpsts where id = "1";
 * 
 * 6. Ar_custgrpsts obj = new Ar_custgrpsts();
 *    obj.loadString(Ar_custgrpsts.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts();
 *    obj.loadString(Ar_custgrpsts.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_custgrpsts where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_custgrpsts Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_custgrpsts : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_custgrpsts obj = new Ar_custgrpsts(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_custgrpsts where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_custgrpsts extends Ar_custgrpstsAbst{
    public Ar_custgrpsts() throws CodeException {
       
    }
    
    public Ar_custgrpsts(long id) throws CodeException {
        super(id);
    }
    
    public Ar_custgrpsts(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_custgrpsts(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_custgrpsts(ResultSet rs) throws CodeException {
        super(rs);
    }
    public void searchData(String yop, String mop, String grpcode) throws CodeException {
        try {

            String query = " select * from ar_custgrpsts where yop = '" + yop + "' and mop = '" + mop + "' and grpcode ='" + grpcode + "'";

            DbBean db = DbBean.connect();
            ResultSet rs = db.executeQuery(query);

            if (rs.next()) {
                loadRs(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Error Ar_custgrpsts :  " + ex.getMessage());
       }
    }
    public void save() throws CodeException {
        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getCurrentDate());
        }
        fromString(PROPERTY_AUDITDATE, GlobalUtils.getCurrentDate());
        setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AR_CUSTGRPSTS);
        super.save();
    }

    
}




