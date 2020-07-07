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


public abstract class Cb_optionAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_option";

    public static final String TABLE = "cb_option";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_OPTIONID = "optionid";
    public static final String PROPERTY_TRANSFERGL = "transfergl";
    public static final String PROPERTY_CONSOLIDATE = "consolidate";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_CURRENTYEAR = "currentyear";
    public static final String PROPERTY_TAXTYPE = "taxtype";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_SRCELGRCODE = "srcelgrcode";
    public static final String PROPERTY_SRCETYPECODE = "srcetypecode";
    public static final String PROPERTY_HISTORYDAYS = "historydays";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_OPTIONID;
    
    
    private long id_;
    private String optionid_;
    private String transfergl_;
    private String consolidate_;
    private String bankcode_;
    private long currentyear_;
    private long taxtype_;
    private String curnccode_;
    private String srcelgrcode_;
    private String srcetypecode_;
    private double historydays_;
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

    public Cb_optionAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_optionAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_optionAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_optionAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_optionAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_optionAbst for Key : " + key + " val : " + val);
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
            
            
            
           optionid_ = rs.getString(PROPERTY_OPTIONID); 
           transfergl_ = rs.getString(PROPERTY_TRANSFERGL); 
           consolidate_ = rs.getString(PROPERTY_CONSOLIDATE); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           currentyear_ = rs.getLong(PROPERTY_CURRENTYEAR); 
           taxtype_ = rs.getLong(PROPERTY_TAXTYPE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           srcelgrcode_ = rs.getString(PROPERTY_SRCELGRCODE); 
           srcetypecode_ = rs.getString(PROPERTY_SRCETYPECODE); 
           historydays_ = rs.getDouble(PROPERTY_HISTORYDAYS); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_optionAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_option obj = (Cb_option)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_option " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getoptionid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : optionid can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_option ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_option " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_OPTIONID , optionid_ ); 
            rs.updateString(PROPERTY_TRANSFERGL , transfergl_ ); 
            rs.updateString(PROPERTY_CONSOLIDATE , consolidate_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateLong(PROPERTY_CURRENTYEAR , currentyear_ ); 
            rs.updateLong(PROPERTY_TAXTYPE , taxtype_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_SRCELGRCODE , srcelgrcode_ ); 
            rs.updateString(PROPERTY_SRCETYPECODE , srcetypecode_ ); 
            rs.updateDouble(PROPERTY_HISTORYDAYS , historydays_ ); 
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
        Cb_option obj = (Cb_option) jCob;
        id_ = obj.getID();

        
          optionid_ = obj.getoptionid();
          transfergl_ = obj.gettransfergl();
          consolidate_ = obj.getconsolidate();
          bankcode_ = obj.getbankcode();
          currentyear_ = obj.getcurrentyear();
          taxtype_ = obj.gettaxtype();
          curnccode_ = obj.getcurnccode();
          srcelgrcode_ = obj.getsrcelgrcode();
          srcetypecode_ = obj.getsrcetypecode();
          historydays_ = obj.gethistorydays();
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

    
      public void setoptionid(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         optionid_ = param; 
         _isDirty_ = true; 
      } 

      public String getoptionid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return optionid_; 
      } 

      public void settransfergl(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transfergl_ = param; 
         _isDirty_ = true; 
      } 

      public String gettransfergl() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transfergl_; 
      } 

      public void setconsolidate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         consolidate_ = param; 
         _isDirty_ = true; 
      } 

      public String getconsolidate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return consolidate_; 
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

      public void setcurrentyear(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         currentyear_ = param; 
         _isDirty_ = true; 
      } 

      public long getcurrentyear() throws CodeException {
         if (!_isLoaded_) { read();} 
         return currentyear_; 
      } 

      public void settaxtype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxtype_ = param; 
         _isDirty_ = true; 
      } 

      public long gettaxtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxtype_; 
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

      public void sethistorydays(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         historydays_ = param; 
         _isDirty_ = true; 
      } 

      public double gethistorydays() throws CodeException {
         if (!_isLoaded_) { read();} 
         return historydays_; 
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
        
           else if (param.equals(PROPERTY_OPTIONID)) return getoptionid(); 
           else if (param.equals(PROPERTY_TRANSFERGL)) return gettransfergl(); 
           else if (param.equals(PROPERTY_CONSOLIDATE)) return getconsolidate(); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_CURRENTYEAR)) return String.valueOf(getcurrentyear()); 
           else if (param.equals(PROPERTY_TAXTYPE)) return String.valueOf(gettaxtype()); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_SRCELGRCODE)) return getsrcelgrcode(); 
           else if (param.equals(PROPERTY_SRCETYPECODE)) return getsrcetypecode(); 
           else if (param.equals(PROPERTY_HISTORYDAYS)) return decform.format(gethistorydays()); 
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
        
           else if (param.equals(PROPERTY_OPTIONID))  setoptionid(value); 
           else if (param.equals(PROPERTY_TRANSFERGL))  settransfergl(value); 
           else if (param.equals(PROPERTY_CONSOLIDATE))  setconsolidate(value); 
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_CURRENTYEAR)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setcurrentyear(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settaxtype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_SRCELGRCODE))  setsrcelgrcode(value); 
           else if (param.equals(PROPERTY_SRCETYPECODE))  setsrcetypecode(value); 
           else if (param.equals(PROPERTY_HISTORYDAYS)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          sethistorydays(newVal); 
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
            throw new CodeException("Cb_option : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, optionid_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_option : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, optionid_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_option : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_option : Cannot Move Last " + ex.getMessage());
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



