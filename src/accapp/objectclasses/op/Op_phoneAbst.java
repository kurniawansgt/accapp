/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.op;


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


public abstract class Op_phoneAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Op_phone";

    public static final String TABLE = "op_phone";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_OWNERCODE = "ownercode";
    public static final String PROPERTY_ADDRCODE = "addrcode";
    public static final String PROPERTY_ADDRTYPECODE = "addrtypecode";
    public static final String PROPERTY_PHONETYPECODE = "phonetypecode";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditDate";
    public static final String PROPERTY_AUDITUSER = "auditUser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String ownercode_;
    private String addrcode_;
    private String addrtypecode_;
    private String phonetypecode_;
    private String phone_;
    private long objtype_;
    private String entrydate_;
    private String auditDate_;
    private String auditUser_;
    private String cmpnyid_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Op_phoneAbst() throws CodeException {
        loadNew();
    }
    
    public Op_phoneAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Op_phoneAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Op_phoneAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Op_phoneAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Op_phoneAbst for Key : " + key + " val : " + val);
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
            
            
            
           ownercode_ = rs.getString(PROPERTY_OWNERCODE); 
           addrcode_ = rs.getString(PROPERTY_ADDRCODE); 
           addrtypecode_ = rs.getString(PROPERTY_ADDRTYPECODE); 
           phonetypecode_ = rs.getString(PROPERTY_PHONETYPECODE); 
           phone_ = rs.getString(PROPERTY_PHONE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditDate_ = rs.getString(PROPERTY_AUDITDATE); 
           auditUser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Op_phoneAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Op_phone obj = (Op_phone)cache.get(getID());
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
                    throw new CodeException("Error Reading Op_phone " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getownercode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : ownercode can not be Empty"); 
        } 
 
         o = getaddrcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : addrcode can not be Empty"); 
        } 
 
         o = getaddrtypecode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : addrtypecode can not be Empty"); 
        } 
 
         o = getphonetypecode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : phonetypecode can not be Empty"); 
        } 
 
         o = getphone(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : phone can not be Empty"); 
        } 
 
         o = getobjtype(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : objtype can not be Empty"); 
        } 
 
         o = getauditDate(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : auditDate can not be Empty"); 
        } 
 
         o = getauditUser(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : auditUser can not be Empty"); 
        } 
 
         o = getcmpnyid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : cmpnyid can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from op_phone ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Op_phone " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_OWNERCODE , ownercode_ ); 
            rs.updateString(PROPERTY_ADDRCODE , addrcode_ ); 
            rs.updateString(PROPERTY_ADDRTYPECODE , addrtypecode_ ); 
            rs.updateString(PROPERTY_PHONETYPECODE , phonetypecode_ ); 
            rs.updateString(PROPERTY_PHONE , phone_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditDate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , auditUser_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Op_phone obj = (Op_phone) jCob;
        id_ = obj.getID();

        
          ownercode_ = obj.getownercode();
          addrcode_ = obj.getaddrcode();
          addrtypecode_ = obj.getaddrtypecode();
          phonetypecode_ = obj.getphonetypecode();
          phone_ = obj.getphone();
          objtype_ = obj.getobjtype();
          entrydate_ = obj.getentrydate();
          auditDate_ = obj.getauditDate();
          auditUser_ = obj.getauditUser();
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

    
      public void setownercode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ownercode_ = param; 
         _isDirty_ = true; 
      } 

      public String getownercode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ownercode_; 
      } 

      public void setaddrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         addrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaddrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return addrcode_; 
      } 

      public void setaddrtypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         addrtypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaddrtypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return addrtypecode_; 
      } 

      public void setphonetypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         phonetypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getphonetypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return phonetypecode_; 
      } 

      public void setphone(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         phone_ = param; 
         _isDirty_ = true; 
      } 

      public String getphone() throws CodeException {
         if (!_isLoaded_) { read();} 
         return phone_; 
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

      public void setauditDate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         auditDate_ = param; 
         _isDirty_ = true; 
      } 

      public String getauditDate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return auditDate_; 
      } 

      public void setauditUser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         auditUser_ = param; 
         _isDirty_ = true; 
      } 

      public String getauditUser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return auditUser_; 
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
        
           else if (param.equals(PROPERTY_OWNERCODE)) return getownercode(); 
           else if (param.equals(PROPERTY_ADDRCODE)) return getaddrcode(); 
           else if (param.equals(PROPERTY_ADDRTYPECODE)) return getaddrtypecode(); 
           else if (param.equals(PROPERTY_PHONETYPECODE)) return getphonetypecode(); 
           else if (param.equals(PROPERTY_PHONE)) return getphone(); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype()); 
           else if (param.equals(PROPERTY_ENTRYDATE)) return getentrydate(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditDate(); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getauditUser(); 
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
        
           else if (param.equals(PROPERTY_OWNERCODE))  setownercode(value); 
           else if (param.equals(PROPERTY_ADDRCODE))  setaddrcode(value); 
           else if (param.equals(PROPERTY_ADDRTYPECODE))  setaddrtypecode(value); 
           else if (param.equals(PROPERTY_PHONETYPECODE))  setphonetypecode(value); 
           else if (param.equals(PROPERTY_PHONE))  setphone(value); 
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
           else if (param.equals(PROPERTY_AUDITDATE))  setauditDate(value); 
           else if (param.equals(PROPERTY_AUDITUSER))  setauditUser(value); 
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
            throw new CodeException("Op_phone : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Op_phone : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Op_phone : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Op_phone : Cannot Move Last " + ex.getMessage());
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



