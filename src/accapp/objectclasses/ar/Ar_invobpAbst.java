/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.ar;


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


public abstract class Ar_invobpAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_invobp";

    public static final String TABLE = "ar_invobp";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_LINENUM = "linenum";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_RCPNUM = "rcpnum";
    public static final String PROPERTY_PAYDATE = "paydate";
    public static final String PROPERTY_TRANSTYPE = "transtype";
    public static final String PROPERTY_PAYTOTALAMT = "paytotalamt";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_RATETYPECODE = "ratetypecode";
    public static final String PROPERTY_RATEEXCH = "rateexch";
    public static final String PROPERTY_SWOVRRATE = "swovrrate";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_TRANTYPE = "trantype";
    public static final String PROPERTY_REFFMEMOCODE = "reffmemocode";
    public static final String PROPERTY_SWDELINV = "swdelinv";
    public static final String PROPERTY_DOCNUMPPD = "docnumppd";
    public static final String PROPERTY_CUSTMRCODETO = "custmrcodeto";
    public static final String PROPERTY_RCPDATE = "rcpdate";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long batchno_;
    private long docentry_;
    private long linenum_;
    private String custmrcode_;
    private long doctype_;
    private String docnum_;
    private String rcpnum_;
    private String paydate_;
    private long transtype_;
    private double paytotalamt_;
    private String curnccode_;
    private String ratetypecode_;
    private double rateexch_;
    private long swovrrate_;
    private String bankcode_;
    private long trantype_;
    private String reffmemocode_;
    private long swdelinv_;
    private String docnumppd_;
    private String custmrcodeto_;
    private String rcpdate_;
    private long yop_;
    private long mop_;
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

    public Ar_invobpAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_invobpAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_invobpAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_invobpAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_invobpAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_invobpAbst for Key : " + key + " val : " + val);
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
           linenum_ = rs.getLong(PROPERTY_LINENUM); 
           custmrcode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           doctype_ = rs.getLong(PROPERTY_DOCTYPE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           rcpnum_ = rs.getString(PROPERTY_RCPNUM); 
           paydate_ = rs.getString(PROPERTY_PAYDATE); 
           transtype_ = rs.getLong(PROPERTY_TRANSTYPE); 
           paytotalamt_ = rs.getDouble(PROPERTY_PAYTOTALAMT); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           ratetypecode_ = rs.getString(PROPERTY_RATETYPECODE); 
           rateexch_ = rs.getDouble(PROPERTY_RATEEXCH); 
           swovrrate_ = rs.getLong(PROPERTY_SWOVRRATE); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           trantype_ = rs.getLong(PROPERTY_TRANTYPE); 
           reffmemocode_ = rs.getString(PROPERTY_REFFMEMOCODE); 
           swdelinv_ = rs.getLong(PROPERTY_SWDELINV); 
           docnumppd_ = rs.getString(PROPERTY_DOCNUMPPD); 
           custmrcodeto_ = rs.getString(PROPERTY_CUSTMRCODETO); 
           rcpdate_ = rs.getString(PROPERTY_RCPDATE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_invobpAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_invobp obj = (Ar_invobp)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_invobp " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
        
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
           rs = db.retrieveSQL("SELECT max(id) from ar_invobp ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_invobp " + e.getMessage());
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
            rs.updateLong(PROPERTY_LINENUM , linenum_ ); 
            rs.updateString(PROPERTY_CUSTMRCODE , custmrcode_ ); 
            rs.updateLong(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateString(PROPERTY_RCPNUM , rcpnum_ ); 
            rs.updateString(PROPERTY_PAYDATE , paydate_ ); 
            rs.updateLong(PROPERTY_TRANSTYPE , transtype_ ); 
            rs.updateDouble(PROPERTY_PAYTOTALAMT , paytotalamt_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_RATETYPECODE , ratetypecode_ ); 
            rs.updateDouble(PROPERTY_RATEEXCH , rateexch_ ); 
            rs.updateLong(PROPERTY_SWOVRRATE , swovrrate_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateLong(PROPERTY_TRANTYPE , trantype_ ); 
            rs.updateString(PROPERTY_REFFMEMOCODE , reffmemocode_ ); 
            rs.updateLong(PROPERTY_SWDELINV , swdelinv_ ); 
            rs.updateString(PROPERTY_DOCNUMPPD , docnumppd_ ); 
            rs.updateString(PROPERTY_CUSTMRCODETO , custmrcodeto_ ); 
            rs.updateString(PROPERTY_RCPDATE , rcpdate_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
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
        Ar_invobp obj = (Ar_invobp) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          linenum_ = obj.getlinenum();
          custmrcode_ = obj.getcustmrcode();
          doctype_ = obj.getdoctype();
          docnum_ = obj.getdocnum();
          rcpnum_ = obj.getrcpnum();
          paydate_ = obj.getpaydate();
          transtype_ = obj.gettranstype();
          paytotalamt_ = obj.getpaytotalamt();
          curnccode_ = obj.getcurnccode();
          ratetypecode_ = obj.getratetypecode();
          rateexch_ = obj.getrateexch();
          swovrrate_ = obj.getswovrrate();
          bankcode_ = obj.getbankcode();
          trantype_ = obj.gettrantype();
          reffmemocode_ = obj.getreffmemocode();
          swdelinv_ = obj.getswdelinv();
          docnumppd_ = obj.getdocnumppd();
          custmrcodeto_ = obj.getcustmrcodeto();
          rcpdate_ = obj.getrcpdate();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
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

      public void setlinenum(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         linenum_ = param; 
         _isDirty_ = true; 
      } 

      public long getlinenum() throws CodeException {
         if (!_isLoaded_) { read();} 
         return linenum_; 
      } 

      public void setcustmrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custmrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustmrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custmrcode_; 
      } 

      public void setdoctype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctype_ = param; 
         _isDirty_ = true; 
      } 

      public long getdoctype() throws CodeException {
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

      public void setrcpnum(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcpnum_ = param; 
         _isDirty_ = true; 
      } 

      public String getrcpnum() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcpnum_; 
      } 

      public void setpaydate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paydate_ = param; 
         _isDirty_ = true; 
      } 

      public String getpaydate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paydate_; 
      } 

      public void settranstype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transtype_ = param; 
         _isDirty_ = true; 
      } 

      public long gettranstype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transtype_; 
      } 

      public void setpaytotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paytotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpaytotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paytotalamt_; 
      } 

      public void setcurnccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         curnccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcurnccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return curnccode_; 
      } 

      public void setratetypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratetypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getratetypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratetypecode_; 
      } 

      public void setrateexch(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rateexch_ = param; 
         _isDirty_ = true; 
      } 

      public double getrateexch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rateexch_; 
      } 

      public void setswovrrate(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swovrrate_ = param; 
         _isDirty_ = true; 
      } 

      public long getswovrrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swovrrate_; 
      } 

      public void setbankcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankcode_; 
      } 

      public void settrantype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         trantype_ = param; 
         _isDirty_ = true; 
      } 

      public long gettrantype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return trantype_; 
      } 

      public void setreffmemocode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         reffmemocode_ = param; 
         _isDirty_ = true; 
      } 

      public String getreffmemocode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return reffmemocode_; 
      } 

      public void setswdelinv(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swdelinv_ = param; 
         _isDirty_ = true; 
      } 

      public long getswdelinv() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swdelinv_; 
      } 

      public void setdocnumppd(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnumppd_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnumppd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnumppd_; 
      } 

      public void setcustmrcodeto(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custmrcodeto_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustmrcodeto() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custmrcodeto_; 
      } 

      public void setrcpdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcpdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getrcpdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcpdate_; 
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
        
           else if (param.equals(PROPERTY_BATCHNO)) return String.valueOf(getbatchno()); 
           else if (param.equals(PROPERTY_DOCENTRY)) return String.valueOf(getdocentry()); 
           else if (param.equals(PROPERTY_LINENUM)) return String.valueOf(getlinenum()); 
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getcustmrcode(); 
           else if (param.equals(PROPERTY_DOCTYPE)) return String.valueOf(getdoctype()); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_RCPNUM)) return getrcpnum(); 
           else if (param.equals(PROPERTY_PAYDATE)) return getpaydate(); 
           else if (param.equals(PROPERTY_TRANSTYPE)) return String.valueOf(gettranstype()); 
           else if (param.equals(PROPERTY_PAYTOTALAMT)) return decform.format(getpaytotalamt()); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_RATETYPECODE)) return getratetypecode(); 
           else if (param.equals(PROPERTY_RATEEXCH)) return decform.format(getrateexch()); 
           else if (param.equals(PROPERTY_SWOVRRATE)) return String.valueOf(getswovrrate()); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_TRANTYPE)) return String.valueOf(gettrantype()); 
           else if (param.equals(PROPERTY_REFFMEMOCODE)) return getreffmemocode(); 
           else if (param.equals(PROPERTY_SWDELINV)) return String.valueOf(getswdelinv()); 
           else if (param.equals(PROPERTY_DOCNUMPPD)) return getdocnumppd(); 
           else if (param.equals(PROPERTY_CUSTMRCODETO)) return getcustmrcodeto(); 
           else if (param.equals(PROPERTY_RCPDATE)) return getrcpdate(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
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
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbatchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdocentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LINENUM)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlinenum(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CUSTMRCODE))  setcustmrcode(value); 
           else if (param.equals(PROPERTY_DOCTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdoctype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_RCPNUM))  setrcpnum(value); 
           else if (param.equals(PROPERTY_PAYDATE))  setpaydate(value); 
           else if (param.equals(PROPERTY_TRANSTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settranstype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PAYTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpaytotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_RATETYPECODE))  setratetypecode(value); 
           else if (param.equals(PROPERTY_RATEEXCH)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrateexch(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SWOVRRATE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setswovrrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_TRANTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settrantype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_REFFMEMOCODE))  setreffmemocode(value); 
           else if (param.equals(PROPERTY_SWDELINV)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setswdelinv(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCNUMPPD))  setdocnumppd(value); 
           else if (param.equals(PROPERTY_CUSTMRCODETO))  setcustmrcodeto(value); 
           else if (param.equals(PROPERTY_RCPDATE))  setrcpdate(value); 
           else if (param.equals(PROPERTY_YOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setyop(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setmop(newVal); 
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
            throw new CodeException("Ar_invobp : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_invobp : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_invobp : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_invobp : Cannot Move Last " + ex.getMessage());
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



