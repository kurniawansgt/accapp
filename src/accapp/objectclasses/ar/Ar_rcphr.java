/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Ar_rcphrAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Ar_rcphr obj = new Ar_rcphr();
 * 
 * 2. Ar_rcphr obj = new Ar_rcphr(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr(1);
 * 
 *    It Means : Select * from ar_rcphr where id = 1;
 * 
 * 3. Ar_rcphr obj = new Ar_rcphr(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr(1);
 * 
 *    It Means : Select * from ar_rcphr where id = 1;
 * 
 * 4. Ar_rcphr obj = new Ar_rcphr(<primary_key>); 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr("1");
 *    It Means : Select * from ar_rcphr where <primary_key> = "1";
 * 
 * 5. Ar_rcphr obj = new Ar_rcphr(Ar_rcphr.PROPERTY_<field>, <value>);
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr(Ar_rcphr.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from ar_rcphr where id = "1";
 * 
 * 6. Ar_rcphr obj = new Ar_rcphr();
 *    obj.loadString(Ar_rcphr.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr();
 *    obj.loadString(Ar_rcphr.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from ar_rcphr where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM ar_rcphr Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("ar_rcphr : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Ar_rcphr obj = new Ar_rcphr(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from ar_rcphr where id = 1;
 * 
 * 
 */


package accapp.objectclasses.ar;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.sql.SQLException;

/**
 *
 * @author windu
 */
public class Ar_rcphr extends Ar_rcphrAbst{

    Ar_rcpds detail;

    public Ar_rcpds getDetail() {
        return detail;
    }

    public Ar_rcphr() throws CodeException {
       detail=new Ar_rcpds();
    }

    public Ar_rcphr(long id) throws CodeException {
        super(id);
    }

    public Ar_rcphr(String val)  throws CodeException {
        super(val);
    }

    public Ar_rcphr(String key, String val)  throws CodeException {
        super(key, val);
    }

    public Ar_rcphr(ResultSet rs) throws CodeException {
        super(rs);
    }

    public void loadRs(ResultSet rs) throws CodeException {
        super.loadRs(rs);

        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

   public void loadID(long id) throws CodeException {
        super.loadID(id);

        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }
    public void loadString (String key, String val)  throws CodeException {
        super.loadString(val);
        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());
    }

    @Override
    public void fromString(String param, String value) throws CodeException {
        value=value==null?"":value;

        super.fromString(param, value);
    }


    public void adddetail(Ar_rcpd obj) throws CodeException {
        detail.add(obj);
    }

    public void addDetails(Ar_rcpds cbds) throws CodeException {
        this.detail.add(cbds);
    }

    @Override
    public void saveNew() throws CodeException {
        if (this.getdocnum().equalsIgnoreCase("")){
            this.setdocnum(this.getbatchno()+"-"+this.getdocentry());
        }
        super.saveNew();
    }


    @Override
    public void save() throws CodeException {
        this.setauditdate(GlobalUtils.getAuditDate());
        this.setaudituser(GlobalUtils.getAuditUser());
        this.setcmpnyid(GlobalUtils.company);
        this.setdoctotalamt(this.getDetailAmt());
        super.save();

        for(Object o : detail.list()) {
            Ar_rcpd oGl_jed = (Ar_rcpd) o;

            if (oGl_jed.getID()==0) {
                oGl_jed.setlinenum(oGl_jed.getMaxTransnbr((int)this.getbatchno(),(int)this.getdocentry()));
            }
            oGl_jed.setbatchno(this.getbatchno());
            oGl_jed.setdocentry(this.getdocentry());

            oGl_jed.save();

        }


    }

    @Override
    public void delete() throws CodeException {
        detail = new Ar_rcpds();
        detail.searchData(this.getbatchno(), this.getdocentry());

        detail.delete();

        super.delete();
    }



    public int getMaxbtchentry(int batchid) throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {

            String query = "select "
                            + "\n case when max(docentry) is null then 1 else max(docentry) + 1 end nomor "
                            + "\n from ar_rcphr where batchno=" + batchid;

            ResultSet rs = db.executeQuery(query);

            if(rs.next()) {
                entry = rs.getInt("nomor");

            }

       } catch (SQLException ex) {
             throw new CodeException("Ar_rcphr : " + ex.getMessage());
       }finally{
           db.close();
       }

       return entry;
    }

    public void getdataDetail(int index, Ar_rcpd ogl_jed) throws CodeException {
        if (detail.size()>0){
            ogl_jed=(Ar_rcpd) detail.list().get(index);

            ogl_jed=new Ar_rcpd(ogl_jed.getID());
        }
    }
    public void replaceDetail(int index, Ar_rcpd ogl_jed) throws CodeException {
        detail.list().set(index, ogl_jed);
    }

    public void removeDetail(int index,Ar_rcpbatchlist obj) throws CodeException {

        Ar_rcpd ogl_jed = (Ar_rcpd) detail.list().get(index);
        ogl_jed.delete();

        detail.list().remove(index);

        obj.settotrcpamt(obj.getTotalAmount());
        obj.save();
    }

    public double getDetailAmt() throws CodeException{
        double totalkredit = 0;

        for (Object o : detail.list()) {

            Ar_rcpd cbd = (Ar_rcpd) o;
            try{

                if (cbd.getpayamt() >= 0) {
                    totalkredit +=  cbd.getpayamt();
                }

            }catch(Exception e) {}

        }

        return (Math.abs(totalkredit));
    }

    private String getFormatedDocNum() throws CodeException{
        if (!this.getdocnum().equalsIgnoreCase("")){
            return this.getdocnum();
        }
        Ar_optiionaldetail1 arop = new Ar_optiionaldetail1(this.getdoctype());
        int i=0;
        String docnum="";
        for(i=0;i<arop.getlengthno();i++){
            if (i<arop.gettxtprefix().length()){
                docnum=arop.gettxtprefix();
            } else {
                if (i<arop.getlengthno()-GlobalUtils.churuf(arop.getdocnum()).length()){
                    docnum=docnum+"0";
                } else {
                    docnum=docnum+(arop.getdocnum()+1);
                }
            }
        }
        if (!docnum.equalsIgnoreCase("")){
            arop.setdocnum(arop.getdocnum()+1);
            arop.save();

        }
        return docnum;

    }

    public String gettypedsc() throws CodeException{
        String result="";
        switch (GlobalUtils.toInt(this.getdoctype())){
            case 1:
                result="Receipt";
                break;
            case 2:
                result="Prepayment";
                break;
            case 3:
                result="Unapplied Cash";
                break;
            case 4:
                result="Apply Document";
                break;
            case 5:
                result="Misc Receipt";
                break;

        }
        return result;
    }
}




