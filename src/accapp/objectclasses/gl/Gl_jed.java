/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_jedAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_jed obj = new Gl_jed();
 * 
 * 2. Gl_jed obj = new Gl_jed(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_jed obj = new Gl_jed(1);
 * 
 *    It Means : Select * from gl_jed where id = 1;
 * 
 * 3. Gl_jed obj = new Gl_jed(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_jed obj = new Gl_jed(1);
 * 
 *    It Means : Select * from gl_jed where id = 1;
 * 
 * 4. Gl_jed obj = new Gl_jed(<primary_key>); 
 *    Sample :
 *    Gl_jed obj = new Gl_jed("1");
 *    It Means : Select * from gl_jed where <primary_key> = "1";
 * 
 * 5. Gl_jed obj = new Gl_jed(Gl_jed.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_jed obj = new Gl_jed(Gl_jed.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_jed where id = "1";
 * 
 * 6. Gl_jed obj = new Gl_jed();
 *    obj.loadString(Gl_jed.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_jed obj = new Gl_jed();
 *    obj.loadString(Gl_jed.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_jed where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_jed Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_jed : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_jed obj = new Gl_jed(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_jed obj = new Gl_jed(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_jed where id = 1;
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
public class Gl_jed extends Gl_jedAbst{
    private Integer status=0;

    public Gl_jed() throws CodeException {
       
    }
    
    public Gl_jed(long id) throws CodeException {
        super(id);
    }
    
    public Gl_jed(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_jed(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_jed(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        if (value==null){
            value="";
        }
        
        super.fromString(param, value);
    }


    @Override
    public void save() throws CodeException {
        if (getID()==NULLID||getID()==0) {
            this.setentrydate(TABLE);
        }
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);

        super.save();
    }



    public int getMaxTransnbr(int btchentry,int journalid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(transnbr) is null then 1 else max(transnbr) + 1 end nomor "
                            + "\n from gl_jed where btchentry=" + btchentry+" and journalid="+journalid;

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

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
}




