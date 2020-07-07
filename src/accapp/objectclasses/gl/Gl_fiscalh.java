/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_fiscalhAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_fiscalh obj = new Gl_fiscalh();
 * 
 * 2. Gl_fiscalh obj = new Gl_fiscalh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh(1);
 * 
 *    It Means : Select * from gl_fiscalh where id = 1;
 * 
 * 3. Gl_fiscalh obj = new Gl_fiscalh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh(1);
 * 
 *    It Means : Select * from gl_fiscalh where id = 1;
 * 
 * 4. Gl_fiscalh obj = new Gl_fiscalh(<primary_key>); 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh("1");
 *    It Means : Select * from gl_fiscalh where <primary_key> = "1";
 * 
 * 5. Gl_fiscalh obj = new Gl_fiscalh(Gl_fiscalh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh(Gl_fiscalh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_fiscalh where id = "1";
 * 
 * 6. Gl_fiscalh obj = new Gl_fiscalh();
 *    obj.loadString(Gl_fiscalh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh();
 *    obj.loadString(Gl_fiscalh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_fiscalh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_fiscalh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_fiscalh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_fiscalh obj = new Gl_fiscalh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_fiscalh where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windu
 */
public class Gl_fiscalh extends Gl_fiscalhAbst{
    private Gl_fiscalds detail;

    public Gl_fiscalh() throws CodeException {
       detail=new Gl_fiscalds();
    }
    
    public Gl_fiscalh(long id) throws CodeException {
        super(id);
    }
    
    public Gl_fiscalh(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_fiscalh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_fiscalh(ResultSet rs) throws CodeException {
        super(rs);
    }

    /**
     * @return the detail
     */
    public Gl_fiscalds getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(Gl_fiscalds detail) {
        this.detail = detail;
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);

        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));
    }


    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Gl_fiscald obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Gl_fiscalds cbds) throws CodeException {
        this.detail.add(cbds);
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

        for(Object o : detail.list()) {
            Gl_fiscald oGl_fiscald = (Gl_fiscald) o;


            oGl_fiscald.setyop(this.getyop());

            oGl_fiscald.save();

            if (oGl_fiscald.getmopsts()!=1){
                GlobalUtils.periodelocked=true;
            }

        }

    }

    @Override
    public void delete() throws CodeException {
        detail = new Gl_fiscalds(Gl_fiscald.PROPERTY_YOP,GlobalUtils.churuf(this.getyop()));

        detail.delete();

        super.delete();
    }

    public void getdataDetail(int index, Gl_fiscald oGl_fiscald) throws CodeException {
        if (detail.size()>0){
            oGl_fiscald=(Gl_fiscald) detail.list().get(index);

            oGl_fiscald=new Gl_fiscald(oGl_fiscald.getID());
        }
    }
    public void replaceDetail(int index, Gl_fiscald oGl_fiscald) throws CodeException {
        detail.list().set(index, oGl_fiscald);
    }

    public void removeDetail(int index) throws CodeException {

        Gl_fiscald oGl_fiscald = (Gl_fiscald) detail.list().get(index);
        oGl_fiscald.delete();

        detail.list().remove(index);

    }

    public Integer getNextFiscalYear() throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = "select max(yop) as yop from gl_fiscalh";


        try {
            rs = db.executeQuery(query);
            System.out.println(query);
            if (rs.next()){
                return rs.getInt("yop")+1;
            }
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }

        return GlobalUtils.toInt(GlobalUtils.getCurrentYear());

    }

    public Boolean getIsperiodelocked(Integer periode){
        try {
            for (Object o : detail.list()) {
                Gl_fiscald cald = (Gl_fiscald) o;
                if (cald.getmop() == periode && cald.getmopsts() != 1) {
                    System.out.println("Session Periode Locked");
                    return true;
                }
            }
        } catch (CodeException ex) {
            Logger.getLogger(Gl_fiscalh.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Session Periode UnLocked");
        return false;
    }

    public void create_open_balance() throws CodeException {

        DbBean db = DbBean.connect();

        String query = "call sp_create_openbalance("+this.getyop()+",'"+GlobalUtils.getUserId()+"')";


        try {
            System.out.println(query);
            db.doexecute(query);

        }catch (SQLException e) {
            throw new CodeException ("Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }
    }
}




