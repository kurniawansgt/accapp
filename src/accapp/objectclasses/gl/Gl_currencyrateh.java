/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_currencyratehAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_currencyrateh obj = new Gl_currencyrateh();
 * 
 * 2. Gl_currencyrateh obj = new Gl_currencyrateh(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh(1);
 * 
 *    It Means : Select * from gl_currencyrateh where id = 1;
 * 
 * 3. Gl_currencyrateh obj = new Gl_currencyrateh(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh(1);
 * 
 *    It Means : Select * from gl_currencyrateh where id = 1;
 * 
 * 4. Gl_currencyrateh obj = new Gl_currencyrateh(<primary_key>); 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh("1");
 *    It Means : Select * from gl_currencyrateh where <primary_key> = "1";
 * 
 * 5. Gl_currencyrateh obj = new Gl_currencyrateh(Gl_currencyrateh.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh(Gl_currencyrateh.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_currencyrateh where id = "1";
 * 
 * 6. Gl_currencyrateh obj = new Gl_currencyrateh();
 *    obj.loadString(Gl_currencyrateh.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh();
 *    obj.loadString(Gl_currencyrateh.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_currencyrateh where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_currencyrateh Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_currencyrateh : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_currencyrateh obj = new Gl_currencyrateh(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_currencyrateh where id = 1;
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
public class Gl_currencyrateh extends Gl_currencyratehAbst{
    Gl_currencyrateds cbhds;

    public Gl_currencyrateh() throws CodeException {
       cbhds = new Gl_currencyrateds();
    }
    
    public Gl_currencyrateh(long id) throws CodeException {
        super(id);
    }
    
    public Gl_currencyrateh(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_currencyrateh(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_currencyrateh(ResultSet rs) throws CodeException {
        super(rs);
    }

    @Override
    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }

    public void loadID(long id) throws CodeException {
        super.loadID(id);

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);
        
        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }

    public void moveNext() throws CodeException {
        super.moveNext();

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }


    public void moveLast() throws CodeException {
        super.moveLast();

        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),"");
    }

    public void filterbysourcecur(String sourcecur) throws CodeException{
        cbhds = new Gl_currencyrateds();
        cbhds.searchData(this.gethomecur(),this.getratetype(),sourcecur);
    }

    public Gl_currencyrateds getCbhds() {
        return cbhds;
    }

    public void setCbhsds(Gl_currencyrateds cbds) {
        this.cbhds = cbds;
    }

    public void addCbhd(Gl_currencyrated cbd) throws CodeException {
        cbhds.add(cbd);
    }

    public void addCbhds(Gl_currencyrateds cbds) throws CodeException {
        this.cbhds.add(cbds);
    }


    public void replaceCbhd(int index, Gl_currencyrated cbhd) throws CodeException {
        cbhds.list().set(index, cbhd);
    }

    public void removeCbhd(int index) throws CodeException {
        Gl_currencyrated cbhd = (Gl_currencyrated) cbhds.list().get(index);

        if (cbhd.getID()>0){
            cbhd.delete();
        }

        cbhds.list().remove(index);


    }

    public void save() throws CodeException {

        setaudituser(GlobalUtils.getUserId());
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setcmpnyid(GlobalUtils.company);


        super.save();

         try{
            for(Object o : cbhds.list()) {
                Gl_currencyrated cbhd = (Gl_currencyrated) o;

                if (cbhd.getID()==NULLID){
                    cbhd.sethomecur(this.gethomecur());
                    cbhd.setratetype(this.getratetype());
                }

                cbhd.setdatematch(this.getdatematch());
                cbhd.setrateoper(this.getrateoper());

                cbhd.save();


            }

        }catch(Exception e){}
    }
    
}




