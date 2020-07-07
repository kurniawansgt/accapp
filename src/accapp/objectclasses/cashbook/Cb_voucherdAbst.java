/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;


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


public abstract class Cb_voucherdAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="cb_voucherd";

    public static final String TABLE = "cb_voucherd";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_ENTRYNO = "entryno";
    public static final String PROPERTY_DETAILNO = "detailno";
    public static final String PROPERTY_SRCECODE = "srcecode";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_ACCCODE = "acccode";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_TAXTYPE = "taxtype";
    public static final String PROPERTY_TAXPERCENT = "taxpercent";
    public static final String PROPERTY_TAXAMOUNT = "taxamount";
    public static final String PROPERTY_DETAILAMNT = "detailamnt";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_COMMENT = "comment";
    public static final String PROPERTY_RCPTNO = "rcptno";
    public static final String PROPERTY_CASH = "cash";
    public static final String PROPERTY_RCPTDSCRIPTION = "rcptdscription";
    public static final String PROPERTY_MISCCODE = "misccode";
    public static final String PROPERTY_MISCBANKLINE = "miscbankline";
    public static final String PROPERTY_RCPTENTRY = "rcptentry";
    public static final String PROPERTY_ALLCMODE = "allcmode";
    public static final String PROPERTY_ACCDESC = "accdesc";
    public static final String PROPERTY_ACCQTYSW = "accqtysw";
    public static final String PROPERTY_TAXACCOUNT = "taxaccount";
    public static final String PROPERTY_TAXACCDESC = "taxaccdesc";
    public static final String PROPERTY_ADJTAMOUNT = "adjtamount";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double batchno_;
    private double entryno_;
    private double detailno_;
    private String srcecode_;
    private String dscription_;
    private String acccode_;
    private String taxcode_;
    private String taxtype_;
    private double taxpercent_;
    private double taxamount_;
    private double detailamnt_;
    private long quantity_;
    private String comment_;
    private long rcptno_;
    private double cash_;
    private String rcptdscription_;
    private String misccode_;
    private long miscbankline_;
    private long rcptentry_;
    private long allcmode_;
    private String accdesc_;
    private long accqtysw_;
    private String taxaccount_;
    private String taxaccdesc_;
    private double adjtamount_;
    private long objtype_;
    private String entrydate_;
    private String auditdate_;
    private String audituser_;
    private String cmpnyid_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Cb_voucherdAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_voucherdAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_voucherdAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_voucherdAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_voucherdAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_voucherdAbst for Key : " + key + " val : " + val);
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
            
            
            
           batchno_ = rs.getDouble(PROPERTY_BATCHNO); 
           entryno_ = rs.getDouble(PROPERTY_ENTRYNO); 
           detailno_ = rs.getDouble(PROPERTY_DETAILNO); 
           srcecode_ = rs.getString(PROPERTY_SRCECODE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           acccode_ = rs.getString(PROPERTY_ACCCODE); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           taxtype_ = rs.getString(PROPERTY_TAXTYPE); 
           taxpercent_ = rs.getDouble(PROPERTY_TAXPERCENT); 
           taxamount_ = rs.getDouble(PROPERTY_TAXAMOUNT); 
           detailamnt_ = rs.getDouble(PROPERTY_DETAILAMNT); 
           quantity_ = rs.getLong(PROPERTY_QUANTITY); 
           comment_ = rs.getString(PROPERTY_COMMENT); 
           rcptno_ = rs.getLong(PROPERTY_RCPTNO); 
           cash_ = rs.getDouble(PROPERTY_CASH); 
           rcptdscription_ = rs.getString(PROPERTY_RCPTDSCRIPTION); 
           misccode_ = rs.getString(PROPERTY_MISCCODE); 
           miscbankline_ = rs.getLong(PROPERTY_MISCBANKLINE); 
           rcptentry_ = rs.getLong(PROPERTY_RCPTENTRY); 
           allcmode_ = rs.getLong(PROPERTY_ALLCMODE); 
           accdesc_ = rs.getString(PROPERTY_ACCDESC); 
           accqtysw_ = rs.getLong(PROPERTY_ACCQTYSW); 
           taxaccount_ = rs.getString(PROPERTY_TAXACCOUNT); 
           taxaccdesc_ = rs.getString(PROPERTY_TAXACCDESC); 
           adjtamount_ = rs.getDouble(PROPERTY_ADJTAMOUNT); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_voucherdAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_voucherd obj = (Cb_voucherd)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_voucherd " + e.getMessage());
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
 
         o = getentryno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : entryno can not be Empty"); 
        } 
 
         o = getdetailno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : detailno can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_voucherd ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_voucherd " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BATCHNO , batchno_ ); 
            rs.updateDouble(PROPERTY_ENTRYNO , entryno_ ); 
            rs.updateDouble(PROPERTY_DETAILNO , detailno_ ); 
            rs.updateString(PROPERTY_SRCECODE , srcecode_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_ACCCODE , acccode_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateString(PROPERTY_TAXTYPE , taxtype_ ); 
            rs.updateDouble(PROPERTY_TAXPERCENT , taxpercent_ ); 
            rs.updateDouble(PROPERTY_TAXAMOUNT , taxamount_ ); 
            rs.updateDouble(PROPERTY_DETAILAMNT , detailamnt_ ); 
            rs.updateLong(PROPERTY_QUANTITY , quantity_ ); 
            rs.updateString(PROPERTY_COMMENT , comment_ ); 
            rs.updateLong(PROPERTY_RCPTNO , rcptno_ ); 
            rs.updateDouble(PROPERTY_CASH , cash_ ); 
            rs.updateString(PROPERTY_RCPTDSCRIPTION , rcptdscription_ ); 
            rs.updateString(PROPERTY_MISCCODE , misccode_ ); 
            rs.updateLong(PROPERTY_MISCBANKLINE , miscbankline_ ); 
            rs.updateLong(PROPERTY_RCPTENTRY , rcptentry_ ); 
            rs.updateLong(PROPERTY_ALLCMODE , allcmode_ ); 
            rs.updateString(PROPERTY_ACCDESC , accdesc_ ); 
            rs.updateLong(PROPERTY_ACCQTYSW , accqtysw_ ); 
            rs.updateString(PROPERTY_TAXACCOUNT , taxaccount_ ); 
            rs.updateString(PROPERTY_TAXACCDESC , taxaccdesc_ ); 
            rs.updateDouble(PROPERTY_ADJTAMOUNT , adjtamount_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditdate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Cb_voucherd obj = (Cb_voucherd) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          entryno_ = obj.getentryno();
          detailno_ = obj.getdetailno();
          srcecode_ = obj.getsrcecode();
          dscription_ = obj.getdscription();
          acccode_ = obj.getacccode();
          taxcode_ = obj.gettaxcode();
          taxtype_ = obj.gettaxtype();
          taxpercent_ = obj.gettaxpercent();
          taxamount_ = obj.gettaxamount();
          detailamnt_ = obj.getdetailamnt();
          quantity_ = obj.getquantity();
          comment_ = obj.getcomment();
          rcptno_ = obj.getrcptno();
          cash_ = obj.getcash();
          rcptdscription_ = obj.getrcptdscription();
          misccode_ = obj.getmisccode();
          miscbankline_ = obj.getmiscbankline();
          rcptentry_ = obj.getrcptentry();
          allcmode_ = obj.getallcmode();
          accdesc_ = obj.getaccdesc();
          accqtysw_ = obj.getaccqtysw();
          taxaccount_ = obj.gettaxaccount();
          taxaccdesc_ = obj.gettaxaccdesc();
          adjtamount_ = obj.getadjtamount();
          objtype_ = obj.getobjtype();
          entrydate_ = obj.getentrydate();
          auditdate_ = obj.getauditdate();
          audituser_ = obj.getaudituser();
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

    
      public void setbatchno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchno_ = param; 
         _isDirty_ = true; 
      } 

      public double getbatchno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchno_; 
      } 

      public void setentryno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entryno_ = param; 
         _isDirty_ = true; 
      } 

      public double getentryno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entryno_; 
      } 

      public void setdetailno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         detailno_ = param; 
         _isDirty_ = true; 
      } 

      public double getdetailno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return detailno_; 
      } 

      public void setsrcecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcecode_; 
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

      public void setacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccode_; 
      } 

      public void settaxcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxcode_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxcode_; 
      } 

      public void settaxtype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxtype_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxtype_; 
      } 

      public void settaxpercent(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxpercent_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxpercent() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxpercent_; 
      } 

      public void settaxamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxamount_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxamount_; 
      } 

      public void setdetailamnt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         detailamnt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdetailamnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return detailamnt_; 
      } 

      public void setquantity(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         quantity_ = param; 
         _isDirty_ = true; 
      } 

      public long getquantity() throws CodeException {
         if (!_isLoaded_) { read();} 
         return quantity_; 
      } 

      public void setcomment(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         comment_ = param; 
         _isDirty_ = true; 
      } 

      public String getcomment() throws CodeException {
         if (!_isLoaded_) { read();} 
         return comment_; 
      } 

      public void setrcptno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcptno_ = param; 
         _isDirty_ = true; 
      } 

      public long getrcptno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcptno_; 
      } 

      public void setcash(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cash_ = param; 
         _isDirty_ = true; 
      } 

      public double getcash() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cash_; 
      } 

      public void setrcptdscription(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcptdscription_ = param; 
         _isDirty_ = true; 
      } 

      public String getrcptdscription() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcptdscription_; 
      } 

      public void setmisccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         misccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getmisccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return misccode_; 
      } 

      public void setmiscbankline(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         miscbankline_ = param; 
         _isDirty_ = true; 
      } 

      public long getmiscbankline() throws CodeException {
         if (!_isLoaded_) { read();} 
         return miscbankline_; 
      } 

      public void setrcptentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcptentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getrcptentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcptentry_; 
      } 

      public void setallcmode(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         allcmode_ = param; 
         _isDirty_ = true; 
      } 

      public long getallcmode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return allcmode_; 
      } 

      public void setaccdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accdesc_; 
      } 

      public void setaccqtysw(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accqtysw_ = param; 
         _isDirty_ = true; 
      } 

      public long getaccqtysw() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accqtysw_; 
      } 

      public void settaxaccount(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxaccount_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxaccount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxaccount_; 
      } 

      public void settaxaccdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxaccdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxaccdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxaccdesc_; 
      } 

      public void setadjtamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjtamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtamount_; 
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
        
           else if (param.equals(PROPERTY_BATCHNO)) return decform.format(getbatchno()); 
           else if (param.equals(PROPERTY_ENTRYNO)) return decform.format(getentryno()); 
           else if (param.equals(PROPERTY_DETAILNO)) return decform.format(getdetailno()); 
           else if (param.equals(PROPERTY_SRCECODE)) return getsrcecode(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_ACCCODE)) return getacccode(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_TAXTYPE)) return gettaxtype(); 
           else if (param.equals(PROPERTY_TAXPERCENT)) return decform.format(gettaxpercent()); 
           else if (param.equals(PROPERTY_TAXAMOUNT)) return decform.format(gettaxamount()); 
           else if (param.equals(PROPERTY_DETAILAMNT)) return decform.format(getdetailamnt()); 
           else if (param.equals(PROPERTY_QUANTITY)) return String.valueOf(getquantity()); 
           else if (param.equals(PROPERTY_COMMENT)) return getcomment(); 
           else if (param.equals(PROPERTY_RCPTNO)) return String.valueOf(getrcptno()); 
           else if (param.equals(PROPERTY_CASH)) return decform.format(getcash()); 
           else if (param.equals(PROPERTY_RCPTDSCRIPTION)) return getrcptdscription(); 
           else if (param.equals(PROPERTY_MISCCODE)) return getmisccode(); 
           else if (param.equals(PROPERTY_MISCBANKLINE)) return String.valueOf(getmiscbankline()); 
           else if (param.equals(PROPERTY_RCPTENTRY)) return String.valueOf(getrcptentry()); 
           else if (param.equals(PROPERTY_ALLCMODE)) return String.valueOf(getallcmode()); 
           else if (param.equals(PROPERTY_ACCDESC)) return getaccdesc(); 
           else if (param.equals(PROPERTY_ACCQTYSW)) return String.valueOf(getaccqtysw()); 
           else if (param.equals(PROPERTY_TAXACCOUNT)) return gettaxaccount(); 
           else if (param.equals(PROPERTY_TAXACCDESC)) return gettaxaccdesc(); 
           else if (param.equals(PROPERTY_ADJTAMOUNT)) return decform.format(getadjtamount()); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype()); 
           else if (param.equals(PROPERTY_ENTRYDATE)) return getentrydate(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditdate(); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getaudituser(); 
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
                throw new CodeException("Unrecognized Number Format " + nfe.getMessage() );
            }
        }
        
           else if (param.equals(PROPERTY_BATCHNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbatchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setentryno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DETAILNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdetailno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SRCECODE))  setsrcecode(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_ACCCODE))  setacccode(value); 
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
           else if (param.equals(PROPERTY_TAXTYPE))  settaxtype(value); 
           else if (param.equals(PROPERTY_TAXPERCENT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxpercent(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DETAILAMNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdetailamnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_QUANTITY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setquantity(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COMMENT))  setcomment(value); 
           else if (param.equals(PROPERTY_RCPTNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrcptno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CASH)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcash(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RCPTDSCRIPTION))  setrcptdscription(value); 
           else if (param.equals(PROPERTY_MISCCODE))  setmisccode(value); 
           else if (param.equals(PROPERTY_MISCBANKLINE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setmiscbankline(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RCPTENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrcptentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ALLCMODE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setallcmode(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCDESC))  setaccdesc(value); 
           else if (param.equals(PROPERTY_ACCQTYSW)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setaccqtysw(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXACCOUNT))  settaxaccount(value); 
           else if (param.equals(PROPERTY_TAXACCDESC))  settaxaccdesc(value); 
           else if (param.equals(PROPERTY_ADJTAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjtamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OBJTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setobjtype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYDATE))  setentrydate(value); 
           else if (param.equals(PROPERTY_AUDITDATE))  setauditdate(value); 
           else if (param.equals(PROPERTY_AUDITUSER))  setaudituser(value); 
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
            throw new CodeException("Cb_voucherd : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Cb_voucherd : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Cb_voucherd : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_voucherd : Cannot Move Last " + ex.getMessage());
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



