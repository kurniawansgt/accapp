/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Setting_financial_rptAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Setting_financial_rpt obj = new Setting_financial_rpt();
 * 
 * 2. Setting_financial_rpt obj = new Setting_financial_rpt(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt(1);
 * 
 *    It Means : Select * from setting_financial_rpt where id = 1;
 * 
 * 3. Setting_financial_rpt obj = new Setting_financial_rpt(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt(1);
 * 
 *    It Means : Select * from setting_financial_rpt where id = 1;
 * 
 * 4. Setting_financial_rpt obj = new Setting_financial_rpt(<primary_key>); 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt("1");
 *    It Means : Select * from setting_financial_rpt where <primary_key> = "1";
 * 
 * 5. Setting_financial_rpt obj = new Setting_financial_rpt(Setting_financial_rpt.PROPERTY_<field>, <value>);
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt(Setting_financial_rpt.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from setting_financial_rpt where id = "1";
 * 
 * 6. Setting_financial_rpt obj = new Setting_financial_rpt();
 *    obj.loadString(Setting_financial_rpt.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt();
 *    obj.loadString(Setting_financial_rpt.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from setting_financial_rpt where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM setting_financial_rpt Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("setting_financial_rpt : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Setting_financial_rpt obj = new Setting_financial_rpt(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from setting_financial_rpt where id = 1;
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
public class Setting_financial_rpt extends Setting_financial_rptAbst{
    private Setting_financial_rpt_detail1s detail;

    public Setting_financial_rpt() throws CodeException {
       detail=new Setting_financial_rpt_detail1s();
    }
    
    public Setting_financial_rpt(long id) throws CodeException {
        super(id);
    }
    
    public Setting_financial_rpt(String val)  throws CodeException {
        super(val);
    }
    
    public Setting_financial_rpt(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Setting_financial_rpt(ResultSet rs) throws CodeException {
        super(rs);
    }

    /**
     * @return the detail
     */
    public Setting_financial_rpt_detail1s getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(Setting_financial_rpt_detail1s detail) {
        this.detail = detail;
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Setting_financial_rpt_detail1s(Setting_financial_rpt_detail1.PROPERTY_DOCENTRY,this.getdocentry()+"");
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Setting_financial_rpt_detail1s(Setting_financial_rpt_detail1.PROPERTY_DOCENTRY,this.getdocentry()+"");
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(key, val);

        detail = new Setting_financial_rpt_detail1s(Setting_financial_rpt_detail1.PROPERTY_DOCENTRY,this.getdocentry()+"");
    }

    public void moveFirst() throws CodeException {
        super.moveFirst();
        detail = new Setting_financial_rpt_detail1s();
        detail.loadby_rownumber(this.getdocentry());
    }

    public void movePrevious() throws CodeException {
        super.movePrevious();
        detail = new Setting_financial_rpt_detail1s();
        detail.loadby_rownumber(this.getdocentry());
    }

    public void moveNext() throws CodeException {
        super.moveNext();
        detail = new Setting_financial_rpt_detail1s();
        detail.loadby_rownumber(this.getdocentry());
    }


    public void moveLast() throws CodeException {
        super.moveLast();
        detail = new Setting_financial_rpt_detail1s();
        detail.loadby_rownumber(this.getdocentry());
    }


    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Setting_financial_rpt_detail1 obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Setting_financial_rpt_detail1s cbds) throws CodeException {
        this.detail.add(cbds);
    }

    public int getMaxDocEntry() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(docentry) is null then 1 else max(docentry) + 1 end nomor "
                            + "\n from setting_financial_rpt";

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

    @Override
    public void saveNew() throws CodeException {
        this.setdocentry(getMaxDocEntry());
        this.setentrydate(GlobalUtils.getAuditDate());
        this.setcratedate(this.getentrydate());
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        super.save();

        for(Object o : detail.list()) {
            Setting_financial_rpt_detail1 oSetting_financial_rpt_detail1 = (Setting_financial_rpt_detail1) o;

            if (oSetting_financial_rpt_detail1.getID()==0){
                oSetting_financial_rpt_detail1.setdocentry(this.getdocentry());
                oSetting_financial_rpt_detail1.setlineno(oSetting_financial_rpt_detail1.getMaxDocEntry());
            }
            oSetting_financial_rpt_detail1.save();

        }

    }

    @Override
    public void delete() throws CodeException {
        detail = new Setting_financial_rpt_detail1s(Setting_financial_rpt_detail1.PROPERTY_DOCENTRY,this.getdocentry()+"");

        detail.delete();

        super.delete();
    }

    public void getdataDetail(int index, Setting_financial_rpt_detail1 oSetting_financial_rpt_detail1) throws CodeException {
        if (detail.size()>0){
            oSetting_financial_rpt_detail1=(Setting_financial_rpt_detail1) detail.list().get(index);

            oSetting_financial_rpt_detail1=new Setting_financial_rpt_detail1(oSetting_financial_rpt_detail1.getID());
        }
    }
    public void replaceDetail(int index, Setting_financial_rpt_detail1 oSetting_financial_rpt_detail1) throws CodeException {
        detail.list().set(index, oSetting_financial_rpt_detail1);
    }

    public void removeDetail(int index) throws CodeException {

        Setting_financial_rpt_detail1 oSetting_financial_rpt_detail1 = (Setting_financial_rpt_detail1) detail.list().get(index);
        oSetting_financial_rpt_detail1.delete();

        detail.list().remove(index);

    }

    public Boolean doProses(Integer syop, Integer smop ) throws CodeException {
         DbBean db = DbBean.connect();
         Boolean result=false;
         try {
                db.updateSQL(getdoProses(syop, smop));
            result=true;
         } catch (Exception ex) {
             throw new CodeException("gl_batchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return result;
    }

    public String getdoProses(Integer syop, Integer smop) throws CodeException {
           String query = "call sp_create_financial_report("+syop+","+smop+","+this.getdocentry()+",'"+GlobalUtils.userid+"','"+GlobalUtils.company+"')";
           System.out.println(query);
            return query;
    }
}




