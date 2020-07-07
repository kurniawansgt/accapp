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


public abstract class Cb_batchsdAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_batchsd";

    public static final String TABLE = "cb_batchsd";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_ENTRYNO = "entryno";
    public static final String PROPERTY_DETAILNO = "detailno";
    public static final String PROPERTY_SUBDETAILNO = "subdetailno";
    public static final String PROPERTY_LINESTS = "linests";
    public static final String PROPERTY_DOCNO = "docno";
    public static final String PROPERTY_PAYMENTNO = "paymentno";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_APPLAMOUNT = "applamount";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_DOCDATE = "docdate";
    public static final String PROPERTY_PREPAYNO = "prepayno";
    public static final String PROPERTY_PONO = "pono";
    public static final String PROPERTY_SONO = "sono";
    public static final String PROPERTY_CUSTCODE = "custcode";
    public static final String PROPERTY_ADJTREFF = "adjtreff";
    public static final String PROPERTY_ADJTDESC = "adjtdesc";
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
    private double subdetailno_;
    private long linests_;
    private String docno_;
    private double paymentno_;
    private String doctype_;
    private double applamount_;
    private double discount_;
    private String docdate_;
    private double prepayno_;
    private String pono_;
    private String sono_;
    private String custcode_;
    private String adjtreff_;
    private String adjtdesc_;
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

    public Cb_batchsdAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_batchsdAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_batchsdAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_batchsdAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_batchsdAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_batchsdAbst for Key : " + key + " val : " + val);
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
           subdetailno_ = rs.getDouble(PROPERTY_SUBDETAILNO); 
           linests_ = rs.getLong(PROPERTY_LINESTS); 
           docno_ = rs.getString(PROPERTY_DOCNO); 
           paymentno_ = rs.getDouble(PROPERTY_PAYMENTNO); 
           doctype_ = rs.getString(PROPERTY_DOCTYPE); 
           applamount_ = rs.getDouble(PROPERTY_APPLAMOUNT); 
           discount_ = rs.getDouble(PROPERTY_DISCOUNT); 
           docdate_ = rs.getString(PROPERTY_DOCDATE); 
           prepayno_ = rs.getDouble(PROPERTY_PREPAYNO); 
           pono_ = rs.getString(PROPERTY_PONO); 
           sono_ = rs.getString(PROPERTY_SONO); 
           custcode_ = rs.getString(PROPERTY_CUSTCODE); 
           adjtreff_ = rs.getString(PROPERTY_ADJTREFF); 
           adjtdesc_ = rs.getString(PROPERTY_ADJTDESC); 
           adjtamount_ = rs.getDouble(PROPERTY_ADJTAMOUNT); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_batchsdAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_batchsd obj = (Cb_batchsd)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_batchsd " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from cb_batchsd ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_batchsd " + e.getMessage());
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
            rs.updateDouble(PROPERTY_SUBDETAILNO , subdetailno_ ); 
            rs.updateLong(PROPERTY_LINESTS , linests_ ); 
            rs.updateString(PROPERTY_DOCNO , docno_ ); 
            rs.updateDouble(PROPERTY_PAYMENTNO , paymentno_ ); 
            rs.updateString(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateDouble(PROPERTY_APPLAMOUNT , applamount_ ); 
            rs.updateDouble(PROPERTY_DISCOUNT , discount_ ); 
            rs.updateString(PROPERTY_DOCDATE , docdate_ ); 
            rs.updateDouble(PROPERTY_PREPAYNO , prepayno_ ); 
            rs.updateString(PROPERTY_PONO , pono_ ); 
            rs.updateString(PROPERTY_SONO , sono_ ); 
            rs.updateString(PROPERTY_CUSTCODE , custcode_ ); 
            rs.updateString(PROPERTY_ADJTREFF , adjtreff_ ); 
            rs.updateString(PROPERTY_ADJTDESC , adjtdesc_ ); 
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
        Cb_batchsd obj = (Cb_batchsd) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          entryno_ = obj.getentryno();
          detailno_ = obj.getdetailno();
          subdetailno_ = obj.getsubdetailno();
          linests_ = obj.getlinests();
          docno_ = obj.getdocno();
          paymentno_ = obj.getpaymentno();
          doctype_ = obj.getdoctype();
          applamount_ = obj.getapplamount();
          discount_ = obj.getdiscount();
          docdate_ = obj.getdocdate();
          prepayno_ = obj.getprepayno();
          pono_ = obj.getpono();
          sono_ = obj.getsono();
          custcode_ = obj.getcustcode();
          adjtreff_ = obj.getadjtreff();
          adjtdesc_ = obj.getadjtdesc();
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

      public void setsubdetailno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         subdetailno_ = param; 
         _isDirty_ = true; 
      } 

      public double getsubdetailno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return subdetailno_; 
      } 

      public void setlinests(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         linests_ = param; 
         _isDirty_ = true; 
      } 

      public long getlinests() throws CodeException {
         if (!_isLoaded_) { read();} 
         return linests_; 
      } 

      public void setdocno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docno_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docno_; 
      } 

      public void setpaymentno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paymentno_ = param; 
         _isDirty_ = true; 
      } 

      public double getpaymentno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paymentno_; 
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

      public void setapplamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         applamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getapplamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return applamount_; 
      } 

      public void setdiscount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discount_ = param; 
         _isDirty_ = true; 
      } 

      public double getdiscount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discount_; 
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

      public void setprepayno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         prepayno_ = param; 
         _isDirty_ = true; 
      } 

      public double getprepayno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return prepayno_; 
      } 

      public void setpono(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pono_ = param; 
         _isDirty_ = true; 
      } 

      public String getpono() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pono_; 
      } 

      public void setsono(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sono_ = param; 
         _isDirty_ = true; 
      } 

      public String getsono() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sono_; 
      } 

      public void setcustcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custcode_; 
      } 

      public void setadjtreff(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtreff_ = param; 
         _isDirty_ = true; 
      } 

      public String getadjtreff() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtreff_; 
      } 

      public void setadjtdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getadjtdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtdesc_; 
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
           else if (param.equals(PROPERTY_SUBDETAILNO)) return decform.format(getsubdetailno()); 
           else if (param.equals(PROPERTY_LINESTS)) return String.valueOf(getlinests()); 
           else if (param.equals(PROPERTY_DOCNO)) return getdocno(); 
           else if (param.equals(PROPERTY_PAYMENTNO)) return decform.format(getpaymentno()); 
           else if (param.equals(PROPERTY_DOCTYPE)) return getdoctype(); 
           else if (param.equals(PROPERTY_APPLAMOUNT)) return decform.format(getapplamount()); 
           else if (param.equals(PROPERTY_DISCOUNT)) return decform.format(getdiscount()); 
           else if (param.equals(PROPERTY_DOCDATE)) return getdocdate(); 
           else if (param.equals(PROPERTY_PREPAYNO)) return decform.format(getprepayno()); 
           else if (param.equals(PROPERTY_PONO)) return getpono(); 
           else if (param.equals(PROPERTY_SONO)) return getsono(); 
           else if (param.equals(PROPERTY_CUSTCODE)) return getcustcode(); 
           else if (param.equals(PROPERTY_ADJTREFF)) return getadjtreff(); 
           else if (param.equals(PROPERTY_ADJTDESC)) return getadjtdesc(); 
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
           else if (param.equals(PROPERTY_SUBDETAILNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setsubdetailno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LINESTS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlinests(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCNO))  setdocno(value); 
           else if (param.equals(PROPERTY_PAYMENTNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpaymentno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCTYPE))  setdoctype(value); 
           else if (param.equals(PROPERTY_APPLAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setapplamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdiscount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCDATE))  setdocdate(value); 
           else if (param.equals(PROPERTY_PREPAYNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setprepayno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PONO))  setpono(value); 
           else if (param.equals(PROPERTY_SONO))  setsono(value); 
           else if (param.equals(PROPERTY_CUSTCODE))  setcustcode(value); 
           else if (param.equals(PROPERTY_ADJTREFF))  setadjtreff(value); 
           else if (param.equals(PROPERTY_ADJTDESC))  setadjtdesc(value); 
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
            throw new CodeException("Cb_batchsd : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Cb_batchsd : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Cb_batchsd : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_batchsd : Cannot Move Last " + ex.getMessage());
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



