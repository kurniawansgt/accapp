/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcpdmiscAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcpdmisc obj = new Ar_rcpdmisc();
 * 
 * 2. Ar_rcpdmisc obj = new Ar_rcpdmisc(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc(1);
 * 
 *    It Means : Select * from ar_rcpdmisc where id = 1;
 * 
 * 3. Ar_rcpdmisc obj = new Ar_rcpdmisc(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc(1);
 * 
 *    It Means : Select * from ar_rcpdmisc where id = 1;
 * 
 * 4. Ar_rcpdmisc obj = new Ar_rcpdmisc(<primary_key>); 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc("1");
 *    It Means : Select * from ar_rcpdmisc where <primary_key> = "1";
 * 
 * 5. Ar_rcpdmisc obj = new Ar_rcpdmisc(Ar_rcpdmisc.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc(Ar_rcpdmisc.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcpdmisc where id = "1";
 * 
 * 6. Ar_rcpdmisc obj = new Ar_rcpdmisc();
 *    obj.loadString(Ar_rcpdmisc.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc();
 *    obj.loadString(Ar_rcpdmisc.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcpdmisc where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcpdmisc Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcpdmisc : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcpdmisc obj = new Ar_rcpdmisc(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcpdmisc where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_rcpdmisc extends Ar_rcpdmiscAbst{
    public Ar_rcpdmisc() throws CodeException {
       
    }
    
    public Ar_rcpdmisc(long id) throws CodeException {
        super(id);
    }
    
    public Ar_rcpdmisc(String val)  throws CodeException {
        super(val);
    }
    
    public Ar_rcpdmisc(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ar_rcpdmisc(ResultSet rs) throws CodeException {
        super(rs);
    }

    public int getMaxTransnbr(int batchno,int docentry) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(linenum) is null then 1 else max(linenum) + 1 end nomor "
                            + "\n from ar_rcpdmisc where batchno=" + batchno+" and docentry="+docentry;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("gl_jeh : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }
    
}




