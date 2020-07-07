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


public abstract class Cb_sourceAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_source";

    public static final String TABLE = "cb_source";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SRCECODE = "srcecode";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_DSCRIPTIONDEF = "dscriptiondef";
    public static final String PROPERTY_ACCCODE = "acccode";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_ACCCODEF = "acccodef";
    public static final String PROPERTY_TAXTYPE = "taxtype";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_SRCECODE;
    
    
    private long id_;
    private String srcecode_;
    private String dscription_;
    private String dscriptiondef_;
    private String acccode_;
    private String taxcode_;
    private double amount_;
    private String comments_;
    private String acccodef_;
    private long taxtype_;
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

    public Cb_sourceAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_sourceAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_sourceAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_sourceAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_sourceAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_sourceAbst for Key : " + key + " val : " + val);
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
            
            
            
           srcecode_ = rs.getString(PROPERTY_SRCECODE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           dscriptiondef_ = rs.getString(PROPERTY_DSCRIPTIONDEF); 
           acccode_ = rs.getString(PROPERTY_ACCCODE); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           amount_ = rs.getDouble(PROPERTY_AMOUNT); 
           comments_ = rs.getString(PROPERTY_COMMENTS); 
           acccodef_ = rs.getString(PROPERTY_ACCCODEF); 
           taxtype_ = rs.getLong(PROPERTY_TAXTYPE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_sourceAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_source obj = (Cb_source)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_source " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getsrcecode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : srcecode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_source ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_source " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_SRCECODE , srcecode_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_DSCRIPTIONDEF , dscriptiondef_ ); 
            rs.updateString(PROPERTY_ACCCODE , acccode_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateDouble(PROPERTY_AMOUNT , amount_ ); 
            rs.updateString(PROPERTY_COMMENTS , comments_ ); 
            rs.updateString(PROPERTY_ACCCODEF , acccodef_ ); 
            rs.updateLong(PROPERTY_TAXTYPE , taxtype_ ); 
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
        Cb_source obj = (Cb_source) jCob;
        id_ = obj.getID();

        
          srcecode_ = obj.getsrcecode();
          dscription_ = obj.getdscription();
          dscriptiondef_ = obj.getdscriptiondef();
          acccode_ = obj.getacccode();
          taxcode_ = obj.gettaxcode();
          amount_ = obj.getamount();
          comments_ = obj.getcomments();
          acccodef_ = obj.getacccodef();
          taxtype_ = obj.gettaxtype();
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

      public void setdscriptiondef(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dscriptiondef_ = param; 
         _isDirty_ = true; 
      } 

      public String getdscriptiondef() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dscriptiondef_; 
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

      public void setamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         amount_ = param; 
         _isDirty_ = true; 
      } 

      public double getamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return amount_; 
      } 

      public void setcomments(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         comments_ = param; 
         _isDirty_ = true; 
      } 

      public String getcomments() throws CodeException {
         if (!_isLoaded_) { read();} 
         return comments_; 
      } 

      public void setacccodef(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccodef_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccodef() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccodef_; 
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
        
           else if (param.equals(PROPERTY_SRCECODE)) return getsrcecode(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_DSCRIPTIONDEF)) return getdscriptiondef(); 
           else if (param.equals(PROPERTY_ACCCODE)) return getacccode(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_AMOUNT)) return decform.format(getamount()); 
           else if (param.equals(PROPERTY_COMMENTS)) return getcomments(); 
           else if (param.equals(PROPERTY_ACCCODEF)) return getacccodef(); 
           else if (param.equals(PROPERTY_TAXTYPE)) return String.valueOf(gettaxtype()); 
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
        
           else if (param.equals(PROPERTY_SRCECODE))  setsrcecode(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_DSCRIPTIONDEF))  setdscriptiondef(value); 
           else if (param.equals(PROPERTY_ACCCODE))  setacccode(value); 
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
           else if (param.equals(PROPERTY_AMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COMMENTS))  setcomments(value); 
           else if (param.equals(PROPERTY_ACCCODEF))  setacccodef(value); 
           else if (param.equals(PROPERTY_TAXTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settaxtype(newVal); 
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
            throw new CodeException("Cb_source : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, srcecode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_source : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, srcecode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_source : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_source : Cannot Move Last " + ex.getMessage());
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



