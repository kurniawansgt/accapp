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


public abstract class Gl_accountAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_account";

    public static final String TABLE = "gl_account";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACCCODE = "acccode";
    public static final String PROPERTY_ACCDESC = "accdesc";
    public static final String PROPERTY_ACCTYPE = "acctype";
    public static final String PROPERTY_ACCBAL = "accbal";
    public static final String PROPERTY_ACTIVEW = "activew";
    public static final String PROPERTY_ABRKCODE = "abrkcode";
    public static final String PROPERTY_ACCSGMCODE = "accsgmcode";
    public static final String PROPERTY_ACCFMTTD = "accfmttd";
    public static final String PROPERTY_ACCSEGAL01 = "accsegal01";
    public static final String PROPERTY_ACCSEGAL02 = "accsegal02";
    public static final String PROPERTY_ACCSEGAL03 = "accsegal03";
    public static final String PROPERTY_ACCSEGAL04 = "accsegal04";
    public static final String PROPERTY_ACCSEGAL05 = "accsegal05";
    public static final String PROPERTY_ACCSEGAL06 = "accsegal06";
    public static final String PROPERTY_ACCSEGAL07 = "accsegal07";
    public static final String PROPERTY_ACCSEGAL08 = "accsegal08";
    public static final String PROPERTY_ACCSEGAL09 = "accsegal09";
    public static final String PROPERTY_ACCSEGAL10 = "accsegal10";
    public static final String PROPERTY_ACCSEGVAL = "accsegval";
    public static final String PROPERTY_ACCGRPCODE = "accgrpcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ACCCODE;
    
    
    private long id_;
    private String acccode_;
    private String accdesc_;
    private String acctype_;
    private String accbal_;
    private String activew_;
    private String abrkcode_;
    private String accsgmcode_;
    private String accfmttd_;
    private String accsegal01_;
    private String accsegal02_;
    private String accsegal03_;
    private String accsegal04_;
    private String accsegal05_;
    private String accsegal06_;
    private String accsegal07_;
    private String accsegal08_;
    private String accsegal09_;
    private String accsegal10_;
    private String accsegval_;
    private String accgrpcode_;
    private String curnccode_;
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

    public Gl_accountAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_accountAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_accountAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_accountAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_accountAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_accountAbst for Key : " + key + " val : " + val);
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
            
           acccode_ = rs.getString(PROPERTY_ACCCODE); 
           accdesc_ = rs.getString(PROPERTY_ACCDESC); 
           acctype_ = rs.getString(PROPERTY_ACCTYPE); 
           accbal_ = rs.getString(PROPERTY_ACCBAL); 
           activew_ = rs.getString(PROPERTY_ACTIVEW); 
           abrkcode_ = rs.getString(PROPERTY_ABRKCODE); 
           accsgmcode_ = rs.getString(PROPERTY_ACCSGMCODE); 
           accfmttd_ = rs.getString(PROPERTY_ACCFMTTD); 
           accsegal01_ = rs.getString(PROPERTY_ACCSEGAL01); 
           accsegal02_ = rs.getString(PROPERTY_ACCSEGAL02); 
           accsegal03_ = rs.getString(PROPERTY_ACCSEGAL03); 
           accsegal04_ = rs.getString(PROPERTY_ACCSEGAL04); 
           accsegal05_ = rs.getString(PROPERTY_ACCSEGAL05); 
           accsegal06_ = rs.getString(PROPERTY_ACCSEGAL06); 
           accsegal07_ = rs.getString(PROPERTY_ACCSEGAL07); 
           accsegal08_ = rs.getString(PROPERTY_ACCSEGAL08); 
           accsegal09_ = rs.getString(PROPERTY_ACCSEGAL09); 
           accsegal10_ = rs.getString(PROPERTY_ACCSEGAL10); 
           accsegval_ = rs.getString(PROPERTY_ACCSEGVAL); 
           accgrpcode_ = rs.getString(PROPERTY_ACCGRPCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_accountAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_account obj = (Gl_account)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_account " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
        o = getacccode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : acccode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from gl_account ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_account " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }

            rs.updateString(PROPERTY_ACCCODE , acccode_ ); 
            rs.updateString(PROPERTY_ACCDESC , accdesc_ ); 
            rs.updateString(PROPERTY_ACCTYPE , acctype_ ); 
            rs.updateString(PROPERTY_ACCBAL , accbal_ ); 
            rs.updateString(PROPERTY_ACTIVEW , activew_ ); 
            rs.updateString(PROPERTY_ABRKCODE , abrkcode_ ); 
            rs.updateString(PROPERTY_ACCSGMCODE , accsgmcode_ ); 
            rs.updateString(PROPERTY_ACCFMTTD , accfmttd_ ); 
            rs.updateString(PROPERTY_ACCSEGAL01 , accsegal01_ ); 
            rs.updateString(PROPERTY_ACCSEGAL02 , accsegal02_ ); 
            rs.updateString(PROPERTY_ACCSEGAL03 , accsegal03_ ); 
            rs.updateString(PROPERTY_ACCSEGAL04 , accsegal04_ ); 
            rs.updateString(PROPERTY_ACCSEGAL05 , accsegal05_ ); 
            rs.updateString(PROPERTY_ACCSEGAL06 , accsegal06_ ); 
            rs.updateString(PROPERTY_ACCSEGAL07 , accsegal07_ ); 
            rs.updateString(PROPERTY_ACCSEGAL08 , accsegal08_ ); 
            rs.updateString(PROPERTY_ACCSEGAL09 , accsegal09_ ); 
            rs.updateString(PROPERTY_ACCSEGAL10 , accsegal10_ ); 
            rs.updateString(PROPERTY_ACCSEGVAL , accsegval_ ); 
            rs.updateString(PROPERTY_ACCGRPCODE , accgrpcode_ ); 
            // rs.updateString(PROPERTY_CURNCCODE , curnccode_ );
            rs.updateString(PROPERTY_CURNCCODE , "IDR" );
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
        Gl_account obj = (Gl_account) jCob;
        id_ = obj.getID();

        
          acccode_ = obj.getacccode();
          accdesc_ = obj.getaccdesc();
          acctype_ = obj.getacctype();
          accbal_ = obj.getaccbal();
          activew_ = obj.getactivew();
          abrkcode_ = obj.getabrkcode();
          accsgmcode_ = obj.getaccsgmcode();
          accfmttd_ = obj.getaccfmttd();
          accsegal01_ = obj.getaccsegal01();
          accsegal02_ = obj.getaccsegal02();
          accsegal03_ = obj.getaccsegal03();
          accsegal04_ = obj.getaccsegal04();
          accsegal05_ = obj.getaccsegal05();
          accsegal06_ = obj.getaccsegal06();
          accsegal07_ = obj.getaccsegal07();
          accsegal08_ = obj.getaccsegal08();
          accsegal09_ = obj.getaccsegal09();
          accsegal10_ = obj.getaccsegal10();
          accsegval_ = obj.getaccsegval();
          accgrpcode_ = obj.getaccgrpcode();
          curnccode_ = obj.getcurnccode();
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

    
      public void setacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccode_; 
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

      public void setacctype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acctype_ = param; 
         _isDirty_ = true; 
      } 

      public String getacctype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acctype_; 
      } 

      public void setaccbal(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accbal_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccbal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accbal_; 
      } 

      public void setactivew(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         activew_ = param; 
         _isDirty_ = true; 
      } 

      public String getactivew() throws CodeException {
         if (!_isLoaded_) { read();} 
         return activew_; 
      } 

      public void setabrkcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         abrkcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getabrkcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return abrkcode_; 
      } 

      public void setaccsgmcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmcode_; 
      } 

      public void setaccfmttd(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accfmttd_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccfmttd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accfmttd_; 
      } 

      public void setaccsegal01(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal01_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal01() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal01_; 
      } 

      public void setaccsegal02(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal02_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal02() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal02_; 
      } 

      public void setaccsegal03(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal03_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal03() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal03_; 
      } 

      public void setaccsegal04(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal04_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal04() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal04_; 
      } 

      public void setaccsegal05(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal05_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal05() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal05_; 
      } 

      public void setaccsegal06(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal06_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal06() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal06_; 
      } 

      public void setaccsegal07(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal07_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal07() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal07_; 
      } 

      public void setaccsegal08(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal08_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal08() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal08_; 
      } 

      public void setaccsegal09(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal09_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal09() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal09_; 
      } 

      public void setaccsegal10(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegal10_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegal10() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegal10_; 
      } 

      public void setaccsegval(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsegval_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsegval() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsegval_; 
      } 

      public void setaccgrpcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accgrpcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccgrpcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accgrpcode_; 
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
        
           else if (param.equals(PROPERTY_ACCCODE)) return getacccode(); 
           else if (param.equals(PROPERTY_ACCDESC)) return getaccdesc(); 
           else if (param.equals(PROPERTY_ACCTYPE)) return getacctype(); 
           else if (param.equals(PROPERTY_ACCBAL)) return getaccbal(); 
           else if (param.equals(PROPERTY_ACTIVEW)) return getactivew(); 
           else if (param.equals(PROPERTY_ABRKCODE)) return getabrkcode(); 
           else if (param.equals(PROPERTY_ACCSGMCODE)) return getaccsgmcode(); 
           else if (param.equals(PROPERTY_ACCFMTTD)) return getaccfmttd(); 
           else if (param.equals(PROPERTY_ACCSEGAL01)) return getaccsegal01(); 
           else if (param.equals(PROPERTY_ACCSEGAL02)) return getaccsegal02(); 
           else if (param.equals(PROPERTY_ACCSEGAL03)) return getaccsegal03(); 
           else if (param.equals(PROPERTY_ACCSEGAL04)) return getaccsegal04(); 
           else if (param.equals(PROPERTY_ACCSEGAL05)) return getaccsegal05(); 
           else if (param.equals(PROPERTY_ACCSEGAL06)) return getaccsegal06(); 
           else if (param.equals(PROPERTY_ACCSEGAL07)) return getaccsegal07(); 
           else if (param.equals(PROPERTY_ACCSEGAL08)) return getaccsegal08(); 
           else if (param.equals(PROPERTY_ACCSEGAL09)) return getaccsegal09(); 
           else if (param.equals(PROPERTY_ACCSEGAL10)) return getaccsegal10(); 
           else if (param.equals(PROPERTY_ACCSEGVAL)) return getaccsegval(); 
           else if (param.equals(PROPERTY_ACCGRPCODE)) return getaccgrpcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
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
        
           else if (param.equals(PROPERTY_ACCCODE))  setacccode(value); 
           else if (param.equals(PROPERTY_ACCDESC))  setaccdesc(value); 
           else if (param.equals(PROPERTY_ACCTYPE))  setacctype(value); 
           else if (param.equals(PROPERTY_ACCBAL))  setaccbal(value); 
           else if (param.equals(PROPERTY_ACTIVEW))  setactivew(value); 
           else if (param.equals(PROPERTY_ABRKCODE))  setabrkcode(value); 
           else if (param.equals(PROPERTY_ACCSGMCODE))  setaccsgmcode(value); 
           else if (param.equals(PROPERTY_ACCFMTTD))  setaccfmttd(value); 
           else if (param.equals(PROPERTY_ACCSEGAL01))  setaccsegal01(value); 
           else if (param.equals(PROPERTY_ACCSEGAL02))  setaccsegal02(value); 
           else if (param.equals(PROPERTY_ACCSEGAL03))  setaccsegal03(value); 
           else if (param.equals(PROPERTY_ACCSEGAL04))  setaccsegal04(value); 
           else if (param.equals(PROPERTY_ACCSEGAL05))  setaccsegal05(value); 
           else if (param.equals(PROPERTY_ACCSEGAL06))  setaccsegal06(value); 
           else if (param.equals(PROPERTY_ACCSEGAL07))  setaccsegal07(value); 
           else if (param.equals(PROPERTY_ACCSEGAL08))  setaccsegal08(value); 
           else if (param.equals(PROPERTY_ACCSEGAL09))  setaccsegal09(value); 
           else if (param.equals(PROPERTY_ACCSEGAL10))  setaccsegal10(value); 
           else if (param.equals(PROPERTY_ACCSEGVAL))  setaccsegval(value); 
           else if (param.equals(PROPERTY_ACCGRPCODE))  setaccgrpcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
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
            throw new CodeException("Gl_account : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, acccode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_account : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, acccode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_account : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_account : Cannot Move Last " + ex.getMessage());
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



