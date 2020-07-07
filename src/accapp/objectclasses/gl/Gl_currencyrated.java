/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_currencyratedAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_currencyrated obj = new Gl_currencyrated();
 * 
 * 2. Gl_currencyrated obj = new Gl_currencyrated(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated(1);
 * 
 *    It Means : Select * from gl_currencyrated where id = 1;
 * 
 * 3. Gl_currencyrated obj = new Gl_currencyrated(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated(1);
 * 
 *    It Means : Select * from gl_currencyrated where id = 1;
 * 
 * 4. Gl_currencyrated obj = new Gl_currencyrated(<primary_key>); 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated("1");
 *    It Means : Select * from gl_currencyrated where <primary_key> = "1";
 * 
 * 5. Gl_currencyrated obj = new Gl_currencyrated(Gl_currencyrated.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated(Gl_currencyrated.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_currencyrated where id = "1";
 * 
 * 6. Gl_currencyrated obj = new Gl_currencyrated();
 *    obj.loadString(Gl_currencyrated.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated();
 *    obj.loadString(Gl_currencyrated.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_currencyrated where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_currencyrated Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_currencyrated : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_currencyrated obj = new Gl_currencyrated(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_currencyrated where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Gl_currencyrated extends Gl_currencyratedAbst{
    public Gl_currencyrated() throws CodeException {
       
    }
    
    public Gl_currencyrated(long id) throws CodeException {
        super(id);
    }
    
    public Gl_currencyrated(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_currencyrated(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_currencyrated(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void saveNew() throws CodeException {
        this.setentrydate(GlobalUtils.getAuditDate());
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }

    public void getclosestrate(String homecur,String ratetype,String sourcecur) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = "select * from gl_currencyrated cd inner join "
                + "(select homecur,ratetype,sourcecur,max(ratedate) as ratedate from gl_currencyrated "
                + "where homecur='"+homecur+"' and ratetype='"+ratetype+"' and sourcecur='"+sourcecur+"' "
                + "group by homecur,ratetype,sourcecur) as a on "
                + "cd.homecur=a.homecur and cd.ratetype=a.ratetype and cd.sourcecur=a.sourcecur "
                + "and cd.ratedate=a.ratedate";

        try {
            rs = db.executeQuery(query);
            System.out.println(query);
            if (rs.next()){
            loadRs(rs);
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }


    }

    
}




