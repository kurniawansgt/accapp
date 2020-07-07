/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.ap.adjustment;


import common.classinterface.NavigatorObjectInt;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import common.utils.ClassRegister;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.utils.ObjectCache;
import common.jdbc.DbBean;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


public abstract class Ap_adjhAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ap_adjh";

    public static final String TABLE = "ap_adjh";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_VENDCODE = "vendcode";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_DOCDATE = "docdate";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_TXTDESC = "txtdesc";
    public static final String PROPERTY_GLREFF = "glreff";
    public static final String PROPERTY_ADJNO = "adjno";
    public static final String PROPERTY_PAYENTCNT = "payentcnt";
    public static final String PROPERTY_DOCTOTALPAYAMT = "doctotalpayamt";
    public static final String PROPERTY_DISCTOTALPAYAMT = "disctotalpayamt";
    public static final String PROPERTY_PAYCODE = "paycode";
    public static final String PROPERTY_PAYOR = "payor";
    public static final String PROPERTY_DOCNUMMTCH = "docnummtch";
    public static final String PROPERTY_DOCNUMAPPLTO = "docnumapplto";
    public static final String PROPERTY_ADJUSTTOT = "adjusttot";
    public static final String PROPERTY_ADJUSTTOTDBTC = "adjusttotdbtc";
    public static final String PROPERTY_ADJUSTTOTCRTC = "adjusttotcrtc";
    public static final String PROPERTY_ENTRYSTS = "entrysts";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long batchno_;
    private long docentry_;
    private String vendcode_;
    private String doctype_;
    private String docnum_;
    private String docdate_;
    private long yop_;
    private long mop_;
    private String dscription_;
    private String txtdesc_;
    private String glreff_;
    private long adjno_;
    private long payentcnt_;
    private double doctotalpayamt_;
    private double disctotalpayamt_;
    private String paycode_;
    private String payor_;
    private String docnummtch_;
    private String docnumapplto_;
    private double adjusttot_;
    private double adjusttotdbtc_;
    private double adjusttotcrtc_;
    private long entrysts_;
    private String entrydate_;
    private String auditdate_;
    private String audituser_;
    private long objtype_;
    private String cmpnyid_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Ap_adjhAbst() throws CodeException {
        loadNew();
    }
    
    public Ap_adjhAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ap_adjhAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ap_adjhAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ap_adjhAbst(ResultSet rs) throws CodeException {
        loadRs(rs);
    }
    
    public void loadNew() throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        makeNew();
    }
     
     public void loadID(long id) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        if (id == NULLID) {
            makeNew();
        }else {
            id_=id;
            read();
        }    
    }
    public void loadString(String val)  throws CodeException {
        loadString(PRIMARYKEY, val);
        read();      
    }
    
     public void loadString (String key, String val)  throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        
        DbBean db = DbBean.connect();
        try{

            ResultSet rs = db.retrieve(TABLEPROCESS, key, val);
       
            if (rs.isBeforeFirst()) {
                rs.next();
                load(rs);
            }
            rs.close();
        } catch (SQLException sqle ) {
            throw new CodeException ("Error Create Ap_adjhAbst for Key : " + key + " val : " + val);
        } finally {
            db.close();
        }        
    }
    public void loadRs(ResultSet rs) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        load(rs);        
    }
    private void load(ResultSet rs) throws CodeException {
        try {
            
            long tempID = rs.getLong(PROPERTY_ID);
            long temp;
            String tempS;
            java.sql.Date tempDate;
            Timestamp tempTS;
            Date tempdate;
            id_=tempID;
            
            
            
           batchno_ = rs.getLong(PROPERTY_BATCHNO); 
           docentry_ = rs.getLong(PROPERTY_DOCENTRY); 
           vendcode_ = rs.getString(PROPERTY_VENDCODE); 
           doctype_ = rs.getString(PROPERTY_DOCTYPE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           docdate_ = rs.getString(PROPERTY_DOCDATE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           txtdesc_ = rs.getString(PROPERTY_TXTDESC); 
           glreff_ = rs.getString(PROPERTY_GLREFF); 
           adjno_ = rs.getLong(PROPERTY_ADJNO); 
           payentcnt_ = rs.getLong(PROPERTY_PAYENTCNT); 
           doctotalpayamt_ = rs.getDouble(PROPERTY_DOCTOTALPAYAMT); 
           disctotalpayamt_ = rs.getDouble(PROPERTY_DISCTOTALPAYAMT); 
           paycode_ = rs.getString(PROPERTY_PAYCODE); 
           payor_ = rs.getString(PROPERTY_PAYOR); 
           docnummtch_ = rs.getString(PROPERTY_DOCNUMMTCH); 
           docnumapplto_ = rs.getString(PROPERTY_DOCNUMAPPLTO); 
           adjusttot_ = rs.getDouble(PROPERTY_ADJUSTTOT); 
           adjusttotdbtc_ = rs.getDouble(PROPERTY_ADJUSTTOTDBTC); 
           adjusttotcrtc_ = rs.getDouble(PROPERTY_ADJUSTTOTCRTC); 
           entrysts_ = rs.getLong(PROPERTY_ENTRYSTS); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ap_adjhAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ap_adjh obj = (Ap_adjh)cache.get(getID());
            if (obj!=null) {
                copy(obj);
            }else{
                DbBean db = DbBean.connect();        
                ResultSet rs = db.retrieve(TABLEPROCESS, PROPERTY_ID, getID());
                try{
                    rs.next();
                    load(rs);
                    rs.close();
                    cache.add(this);
                }catch (SQLException e) {
                    throw new CodeException("Error Reading Ap_adjh " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbatchno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : batchno can not be Empty"); 
        } 
 
         o = getdocentry(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : docentry can not be Empty"); 
        } 
 
        
    }
    public void save() throws CodeException {
        cache.remove(this);
        
        checkNotNullFields();
        
        if (!_isDirty_) {
            return ;
        }else if (getID()==NULLID) {
            saveNew();
        }else {
            DbBean db = DbBean.connect();
            ResultSet rs = db.update(TABLEPROCESS, PROPERTY_ID, id_);
            try {
                rs.next();
                saveFields(rs);
                rs.updateRow();
                rs.close();
                _isDirty_ = false;
            }catch (SQLException e) {
                throw new CodeException ("Error Saving Application " + e.getMessage());
            } finally {
                db.close();
            }
        }
        
    }
    
    public void saveNew() throws CodeException {
        checkNotNullFields();

        DbBean db = DbBean.connect();
        ResultSet rs = db.update(TABLEPROCESS, PROPERTY_ID, id_);
        try {
           rs.moveToInsertRow();
           saveFields(rs);
           rs.insertRow();
           rs = db.retrieveSQL("SELECT max(id) from ap_adjh ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ap_adjh " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateLong(PROPERTY_BATCHNO , batchno_ ); 
            rs.updateLong(PROPERTY_DOCENTRY , docentry_ ); 
            rs.updateString(PROPERTY_VENDCODE , vendcode_ ); 
            rs.updateString(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateString(PROPERTY_DOCDATE , docdate_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_TXTDESC , txtdesc_ ); 
            rs.updateString(PROPERTY_GLREFF , glreff_ ); 
            rs.updateLong(PROPERTY_ADJNO , adjno_ ); 
            rs.updateLong(PROPERTY_PAYENTCNT , payentcnt_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALPAYAMT , doctotalpayamt_ ); 
            rs.updateDouble(PROPERTY_DISCTOTALPAYAMT , disctotalpayamt_ ); 
            rs.updateString(PROPERTY_PAYCODE , paycode_ ); 
            rs.updateString(PROPERTY_PAYOR , payor_ ); 
            rs.updateString(PROPERTY_DOCNUMMTCH , docnummtch_ ); 
            rs.updateString(PROPERTY_DOCNUMAPPLTO , docnumapplto_ ); 
            rs.updateDouble(PROPERTY_ADJUSTTOT , adjusttot_ ); 
            rs.updateDouble(PROPERTY_ADJUSTTOTDBTC , adjusttotdbtc_ ); 
            rs.updateDouble(PROPERTY_ADJUSTTOTCRTC , adjusttotcrtc_ ); 
            rs.updateLong(PROPERTY_ENTRYSTS , entrysts_ ); 
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditdate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Ap_adjh obj = (Ap_adjh) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          vendcode_ = obj.getvendcode();
          doctype_ = obj.getdoctype();
          docnum_ = obj.getdocnum();
          docdate_ = obj.getdocdate();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          dscription_ = obj.getdscription();
          txtdesc_ = obj.gettxtdesc();
          glreff_ = obj.getglreff();
          adjno_ = obj.getadjno();
          payentcnt_ = obj.getpayentcnt();
          doctotalpayamt_ = obj.getdoctotalpayamt();
          disctotalpayamt_ = obj.getdisctotalpayamt();
          paycode_ = obj.getpaycode();
          payor_ = obj.getpayor();
          docnummtch_ = obj.getdocnummtch();
          docnumapplto_ = obj.getdocnumapplto();
          adjusttot_ = obj.getadjusttot();
          adjusttotdbtc_ = obj.getadjusttotdbtc();
          adjusttotcrtc_ = obj.getadjusttotcrtc();
          entrysts_ = obj.getentrysts();
          entrydate_ = obj.getentrydate();
          auditdate_ = obj.getauditdate();
          audituser_ = obj.getaudituser();
          objtype_ = obj.getobjtype();
          cmpnyid_ = obj.getcmpnyid();
                
        _isDirty_ = false;
        _isLoaded_ = true;
    }
    
    public void delete() throws CodeException {
        cache.remove(this);
        DbBean db = DbBean.connect();
        db.delete(TABLEPROCESS, PROPERTY_ID, id_);
        resetID();
        db.close();
    }
    
    
    public void setID(long arg0) throws CodeException {
        id_ = arg0;
        _isLoaded_ = false;
    }

    public long getID() throws CodeException {
        return id_;
    }

    
      public void setbatchno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchno_ = param; 
         _isDirty_ = true; 
      } 

      public long getbatchno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchno_; 
      } 

      public void setdocentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getdocentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docentry_; 
      } 

      public void setvendcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         vendcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getvendcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return vendcode_; 
      } 

      public void setdoctype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctype_ = param; 
         _isDirty_ = true; 
      } 

      public String getdoctype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctype_; 
      } 

      public void setdocnum(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnum_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnum() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnum_; 
      } 

      public void setdocdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docdate_; 
      } 

      public void setyop(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         yop_ = param; 
         _isDirty_ = true; 
      } 

      public long getyop() throws CodeException {
         if (!_isLoaded_) { read();} 
         return yop_; 
      } 

      public void setmop(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         mop_ = param; 
         _isDirty_ = true; 
      } 

      public long getmop() throws CodeException {
         if (!_isLoaded_) { read();} 
         return mop_; 
      } 

      public void setdscription(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dscription_ = param; 
         _isDirty_ = true; 
      } 

      public String getdscription() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dscription_; 
      } 

      public void settxtdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         txtdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String gettxtdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return txtdesc_; 
      } 

      public void setglreff(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glreff_ = param; 
         _isDirty_ = true; 
      } 

      public String getglreff() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glreff_; 
      } 

      public void setadjno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjno_ = param; 
         _isDirty_ = true; 
      } 

      public long getadjno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjno_; 
      } 

      public void setpayentcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payentcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getpayentcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payentcnt_; 
      } 

      public void setdoctotalpayamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalpayamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalpayamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalpayamt_; 
      } 

      public void setdisctotalpayamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         disctotalpayamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdisctotalpayamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return disctotalpayamt_; 
      } 

      public void setpaycode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paycode_ = param; 
         _isDirty_ = true; 
      } 

      public String getpaycode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paycode_; 
      } 

      public void setpayor(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payor_ = param; 
         _isDirty_ = true; 
      } 

      public String getpayor() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payor_; 
      } 

      public void setdocnummtch(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnummtch_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnummtch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnummtch_; 
      } 

      public void setdocnumapplto(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnumapplto_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnumapplto() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnumapplto_; 
      } 

      public void setadjusttot(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjusttot_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjusttot() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjusttot_; 
      } 

      public void setadjusttotdbtc(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjusttotdbtc_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjusttotdbtc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjusttotdbtc_; 
      } 

      public void setadjusttotcrtc(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjusttotcrtc_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjusttotcrtc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjusttotcrtc_; 
      } 

      public void setentrysts(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrysts_ = param; 
         _isDirty_ = true; 
      } 

      public long getentrysts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrysts_; 
      } 

      public void setentrydate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrydate_ = param; 
         _isDirty_ = true; 
      } 

      public String getentrydate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrydate_; 
      } 

      public void setauditdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         auditdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getauditdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return auditdate_; 
      } 

      public void setaudituser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         audituser_ = param; 
         _isDirty_ = true; 
      } 

      public String getaudituser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return audituser_; 
      } 

      public void setobjtype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         objtype_ = param; 
         _isDirty_ = true; 
      } 

      public long getobjtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return objtype_; 
      } 

      public void setcmpnyid(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cmpnyid_ = param; 
         _isDirty_ = true; 
      } 

      public String getcmpnyid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cmpnyid_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_BATCHNO)) return String.valueOf(getbatchno()); 
           else if (param.equals(PROPERTY_DOCENTRY)) return String.valueOf(getdocentry()); 
           else if (param.equals(PROPERTY_VENDCODE)) return getvendcode(); 
           else if (param.equals(PROPERTY_DOCTYPE)) return getdoctype(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_DOCDATE)) return getdocdate(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_TXTDESC)) return gettxtdesc(); 
           else if (param.equals(PROPERTY_GLREFF)) return getglreff(); 
           else if (param.equals(PROPERTY_ADJNO)) return String.valueOf(getadjno()); 
           else if (param.equals(PROPERTY_PAYENTCNT)) return String.valueOf(getpayentcnt()); 
           else if (param.equals(PROPERTY_DOCTOTALPAYAMT)) return decform.format(getdoctotalpayamt()); 
           else if (param.equals(PROPERTY_DISCTOTALPAYAMT)) return decform.format(getdisctotalpayamt()); 
           else if (param.equals(PROPERTY_PAYCODE)) return getpaycode(); 
           else if (param.equals(PROPERTY_PAYOR)) return getpayor(); 
           else if (param.equals(PROPERTY_DOCNUMMTCH)) return getdocnummtch(); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO)) return getdocnumapplto(); 
           else if (param.equals(PROPERTY_ADJUSTTOT)) return decform.format(getadjusttot()); 
           else if (param.equals(PROPERTY_ADJUSTTOTDBTC)) return decform.format(getadjusttotdbtc()); 
           else if (param.equals(PROPERTY_ADJUSTTOTCRTC)) return decform.format(getadjusttotcrtc()); 
           else if (param.equals(PROPERTY_ENTRYSTS)) return String.valueOf(getentrysts()); 
           else if (param.equals(PROPERTY_ENTRYDATE)) return getentrydate(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditdate(); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getaudituser(); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype()); 
           else if (param.equals(PROPERTY_CMPNYID)) return getcmpnyid(); 
       
        
        return "";
    
    }

    public void fromString(String param, String value) throws CodeException {
        if (param.equals(PROPERTY_ID)) {
            long newVal;
            try {
                newVal = (long) Double.parseDouble(value);
                setID(newVal);
            }catch (NumberFormatException nfe) {
                throw new CodeException("1. Unrecognized Number Format " + nfe.getMessage() );
            }
        }
        
           else if (param.equals(PROPERTY_BATCHNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbatchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("2. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_DOCENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdocentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("3. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_VENDCODE))  setvendcode(value); 
           else if (param.equals(PROPERTY_DOCTYPE))  setdoctype(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_DOCDATE))  setdocdate(value); 
           else if (param.equals(PROPERTY_YOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setyop(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("4. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_MOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setmop(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("5. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_TXTDESC))  settxtdesc(value); 
           else if (param.equals(PROPERTY_GLREFF))  setglreff(value); 
           else if (param.equals(PROPERTY_ADJNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setadjno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("6. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_PAYENTCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setpayentcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("7. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_DOCTOTALPAYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalpayamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("8. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_DISCTOTALPAYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdisctotalpayamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("9. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_PAYCODE))  setpaycode(value); 
           else if (param.equals(PROPERTY_PAYOR))  setpayor(value); 
           else if (param.equals(PROPERTY_DOCNUMMTCH))  setdocnummtch(value); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO))  setdocnumapplto(value); 
           else if (param.equals(PROPERTY_ADJUSTTOT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjusttot(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("10. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_ADJUSTTOTDBTC)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjusttotdbtc(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("11. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_ADJUSTTOTCRTC)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjusttotcrtc(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("12. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_ENTRYSTS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setentrysts(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("13. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_ENTRYDATE))  setentrydate(value); 
           else if (param.equals(PROPERTY_AUDITDATE))  setauditdate(value); 
           else if (param.equals(PROPERTY_AUDITUSER))  setaudituser(value); 
           else if (param.equals(PROPERTY_OBJTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setobjtype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("14. Unrecognised Number format: "+nfe.getMessage(),nfe);
                    }
           }
           else if (param.equals(PROPERTY_CMPNYID))  setcmpnyid(value); 
    }


    public void resetID() throws CodeException {
        if (!_isLoaded_) {
            read();
        }
        id_= NULLID;
        _isDirty_ = true;
    }

    public String[] getSecurityTokens() throws CodeException {
        String[] token = new String[1];
        return token;
    }

    public void moveFirst() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveFirst(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
            throw new CodeException("Ap_adjh : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, id_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_adjh : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, id_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_adjh : Cannot Move Next " + ex.getMessage());
       }
    }
    

    public void moveLast() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveLast(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_adjh : Cannot Move Last " + ex.getMessage());
       }
    }

    public String getClassName() {
        return CLASSNAME;
    }

    public String getTable() {
        return TABLEPROCESS;
    }

    public boolean importCsv() {
        try {
            DbBean db = DbBean.connect();
            db.importFromCsv(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exportCsv() {
        try {
            DbBean db = DbBean.connect();
            db.exportToCSV(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean importText(){
        try {
            DbBean db = DbBean.connect();
            db.importFromText(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exportText() {
        try {
            DbBean db = DbBean.connect();
            db.exportToTextTabDelimited(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



