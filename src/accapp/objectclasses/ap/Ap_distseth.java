/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ap_distsethAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ap_distseth obj = new Ap_distseth();
 * 
 * 2. Ap_distseth obj = new Ap_distseth(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth(1);
 * 
 *    It Means : Select * from ap_distseth where id = 1;
 * 
 * 3. Ap_distseth obj = new Ap_distseth(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth(1);
 * 
 *    It Means : Select * from ap_distseth where id = 1;
 * 
 * 4. Ap_distseth obj = new Ap_distseth(<primary_key>); 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth("1");
 *    It Means : Select * from ap_distseth where <primary_key> = "1";
 * 
 * 5. Ap_distseth obj = new Ap_distseth(Ap_distseth.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth(Ap_distseth.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ap_distseth where id = "1";
 * 
 * 6. Ap_distseth obj = new Ap_distseth();
 *    obj.loadString(Ap_distseth.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth();
 *    obj.loadString(Ap_distseth.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ap_distseth where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ap_distseth Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ap_distseth : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ap_distseth obj = new Ap_distseth(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ap_distseth where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ap;

import common.objectclasses.ObjectType;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;

/**
 *
 * @author windu
 */
public class Ap_distseth extends Ap_distsethAbst{
    
    private Ap_distsetds adss ;
    

    private void load(ResultSet rs) throws CodeException {
      super.loadRs(rs);

    }

    public Ap_distseth() throws CodeException {
        adss = new Ap_distsetds();
    }
    
    public Ap_distseth(long id) throws CodeException {
        super(id);
    }
    
    public Ap_distseth(String val)  throws CodeException {
        super(val);
    }
    
    public Ap_distseth(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Ap_distseth(ResultSet rs) throws CodeException {
        super(rs);
    }



    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());

    }
    public void loadID(long id) throws CodeException {
        super.loadID(id);
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());

    }

    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());
    }

    //untuk ap_distsetd
    public Ap_distsetds getAp_DistSetDs() {
        return adss;
    }

    public void setAdss(Ap_distsetds adds) {
        this.adss = adss;
    }
    
    public void addAp_setD(Ap_distsetd add) throws CodeException {
        adss.add(add);
    }

    public void addAp_SetDs(Ap_distsetds adss) throws CodeException {
        this.adss.add(adss);
    }

    public void replaceAp_SetD(int index, Ap_distsetd add) throws CodeException {

        System.out.println("Index " + index);
        this.adss.list().set(index, add);
    }


    public void removeAP_SetD(int index) throws CodeException {
        Ap_distsetd add = (Ap_distsetd) adss.list().get(index);
        add.delete();

        adss.list().remove(index);
    }


    public void moveFirst() throws CodeException {
        super.moveFirst();
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());
    }


    public void delete() throws CodeException {
        adss = new Ap_distsetds(Ap_distsetd.PROPERTY_DISTSETCODE, this.getdistsetcode());

        adss.delete();

        super.delete();
    }

    public void save() throws CodeException {
        if (getID() == NULLID) {
            fromString(PROPERTY_ENTRYDATE, GlobalUtils.getAuditDate());
        }

        fromString(PROPERTY_AUDITDATE, GlobalUtils.getAuditDate());
        setaudituser(GlobalUtils.getAuditUser());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setobjtype(ObjectType.AP_DISTSETH);
        super.save();

        for(Object o : this.getAp_DistSetDs().list()) {
            Ap_distsetd add = (Ap_distsetd) o;
            add.setdistsetcode(this.getdistsetcode());
            add.setobjtype(ObjectType.AP_DISTSETD);
            add.save();
        }
    }
}




