/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.gl;


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


public abstract class Gl_jehAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_jeh";

    public static final String TABLE = "gl_jeh";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHID = "batchid";
    public static final String PROPERTY_BTCHENTRY = "btchentry";
    public static final String PROPERTY_BTCHENTRYDATE = "btchentrydate";
    public static final String PROPERTY_SRCELGRCODE = "srcelgrcode";
    public static final String PROPERTY_SRCETYPECODE = "srcetypecode";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_SWEDIT = "swedit";
    public static final String PROPERTY_SWREVERSE = "swreverse";
    public static final String PROPERTY_JRNLDESC = "jrnldesc";
    public static final String PROPERTY_JRNLDEBIT = "jrnldebit";
    public static final String PROPERTY_JRNLCREDIT = "jrnlcredit";
    public static final String PROPERTY_JRNLQUANTITY = "jrnlquantity";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double batchid_;
    private double btchentry_;
    private Date btchentrydate_;
    private String srcelgrcode_;
    private String srcetypecode_;
    private long yop_;
    private long mop_;
    private long swedit_;
    private long swreverse_;
    private String jrnldesc_;
    private double jrnldebit_;
    private double jrnlcredit_;
    private long jrnlquantity_;
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

    public Gl_jehAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_jehAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_jehAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_jehAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_jehAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_jehAbst for Key : " + key + " val : " + val);
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
            
            
            
           batchid_ = rs.getDouble(PROPERTY_BATCHID); 
           btchentry_ = rs.getDouble(PROPERTY_BTCHENTRY); 
           btchentrydate_ = rs.getDate(PROPERTY_BTCHENTRYDATE); 
           srcelgrcode_ = rs.getString(PROPERTY_SRCELGRCODE); 
           srcetypecode_ = rs.getString(PROPERTY_SRCETYPECODE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           swedit_ = rs.getLong(PROPERTY_SWEDIT); 
           swreverse_ = rs.getLong(PROPERTY_SWREVERSE); 
           jrnldesc_ = rs.getString(PROPERTY_JRNLDESC); 
           jrnldebit_ = rs.getDouble(PROPERTY_JRNLDEBIT); 
           jrnlcredit_ = rs.getDouble(PROPERTY_JRNLCREDIT); 
           jrnlquantity_ = rs.getLong(PROPERTY_JRNLQUANTITY); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_jehAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_jeh obj = (Gl_jeh)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_jeh " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbatchid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : batchid can not be Empty"); 
        } 
 
         o = getbtchentry(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : btchentry can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from gl_jeh ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_jeh " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BATCHID , batchid_ ); 
            rs.updateDouble(PROPERTY_BTCHENTRY , btchentry_ ); 
           if (getbtchentrydate()==null) {
              rs.updateDate(PROPERTY_BTCHENTRYDATE , null ); 
           }else{
              rs.updateDate(PROPERTY_BTCHENTRYDATE , getbtchentrydate()); 
           }
            rs.updateString(PROPERTY_SRCELGRCODE , srcelgrcode_ ); 
            rs.updateString(PROPERTY_SRCETYPECODE , srcetypecode_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateLong(PROPERTY_SWEDIT , swedit_ ); 
            rs.updateLong(PROPERTY_SWREVERSE , swreverse_ ); 
            rs.updateString(PROPERTY_JRNLDESC , jrnldesc_ ); 
            rs.updateDouble(PROPERTY_JRNLDEBIT , jrnldebit_ ); 
            rs.updateDouble(PROPERTY_JRNLCREDIT , jrnlcredit_ ); 
            rs.updateLong(PROPERTY_JRNLQUANTITY , jrnlquantity_ ); 
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
        Gl_jeh obj = (Gl_jeh) jCob;
        id_ = obj.getID();

        
          batchid_ = obj.getbatchid();
          btchentry_ = obj.getbtchentry();
          btchentrydate_ = obj.getbtchentrydate();
          srcelgrcode_ = obj.getsrcelgrcode();
          srcetypecode_ = obj.getsrcetypecode();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          swedit_ = obj.getswedit();
          swreverse_ = obj.getswreverse();
          jrnldesc_ = obj.getjrnldesc();
          jrnldebit_ = obj.getjrnldebit();
          jrnlcredit_ = obj.getjrnlcredit();
          jrnlquantity_ = obj.getjrnlquantity();
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

    
      public void setbatchid(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchid_ = param; 
         _isDirty_ = true; 
      } 

      public double getbatchid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchid_; 
      } 

      public void setbtchentry(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         btchentry_ = param; 
         _isDirty_ = true; 
      } 

      public double getbtchentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return btchentry_; 
      } 

      public void setbtchentrydate(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         btchentrydate_ = param; 
         _isDirty_ = true; 
      } 

      public Date getbtchentrydate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return btchentrydate_; 
      } 

      public void setsrcelgrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcelgrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcelgrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcelgrcode_; 
      } 

      public void setsrcetypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcetypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcetypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcetypecode_; 
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

      public void setswedit(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swedit_ = param; 
         _isDirty_ = true; 
      } 

      public long getswedit() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swedit_; 
      } 

      public void setswreverse(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swreverse_ = param; 
         _isDirty_ = true; 
      } 

      public long getswreverse() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swreverse_; 
      } 

      public void setjrnldesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jrnldesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getjrnldesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jrnldesc_; 
      } 

      public void setjrnldebit(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jrnldebit_ = param; 
         _isDirty_ = true; 
      } 

      public double getjrnldebit() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jrnldebit_; 
      } 

      public void setjrnlcredit(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jrnlcredit_ = param; 
         _isDirty_ = true; 
      } 

      public double getjrnlcredit() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jrnlcredit_; 
      } 

      public void setjrnlquantity(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jrnlquantity_ = param; 
         _isDirty_ = true; 
      } 

      public long getjrnlquantity() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jrnlquantity_; 
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
        
           else if (param.equals(PROPERTY_BATCHID)) return decform.format(getbatchid()); 
           else if (param.equals(PROPERTY_BTCHENTRY)) return decform.format(getbtchentry()); 
           else if (param.equals(PROPERTY_BTCHENTRYDATE)) return getbtchentrydate()  == null ? "" :dateformat.format(getbtchentrydate()); 
           else if (param.equals(PROPERTY_SRCELGRCODE)) return getsrcelgrcode(); 
           else if (param.equals(PROPERTY_SRCETYPECODE)) return getsrcetypecode(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_SWEDIT)) return String.valueOf(getswedit()); 
           else if (param.equals(PROPERTY_SWREVERSE)) return String.valueOf(getswreverse()); 
           else if (param.equals(PROPERTY_JRNLDESC)) return getjrnldesc(); 
           else if (param.equals(PROPERTY_JRNLDEBIT)) return decform.format(getjrnldebit()); 
           else if (param.equals(PROPERTY_JRNLCREDIT)) return decform.format(getjrnlcredit()); 
           else if (param.equals(PROPERTY_JRNLQUANTITY)) return String.valueOf(getjrnlquantity()); 
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
                throw new CodeException("Unrecognized Number Format " + nfe.getMessage() );
            }
        }
        
           else if (param.equals(PROPERTY_BATCHID)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbatchid(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BTCHENTRY)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbtchentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BTCHENTRYDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setbtchentrydate(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setbtchentrydate(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_SRCELGRCODE))  setsrcelgrcode(value); 
           else if (param.equals(PROPERTY_SRCETYPECODE))  setsrcetypecode(value); 
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
           else if (param.equals(PROPERTY_SWEDIT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setswedit(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SWREVERSE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setswreverse(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_JRNLDESC))  setjrnldesc(value); 
           else if (param.equals(PROPERTY_JRNLDEBIT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setjrnldebit(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_JRNLCREDIT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setjrnlcredit(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_JRNLQUANTITY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setjrnlquantity(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
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
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
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
            throw new CodeException("Gl_jeh : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Gl_jeh : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Gl_jeh : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_jeh : Cannot Move Last " + ex.getMessage());
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



