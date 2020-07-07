/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpp_utils.objectclasses;


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


public abstract class Ut_external_dataAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ut_external_data";

    public static final String TABLE = "ut_external_data";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_EXTERNAL_ID = "external_id";
    public static final String PROPERTY_EXTERNAL_DESC = "external_desc";
    public static final String PROPERTY_EXTERNAL_SVRIP = "external_svrip";
    public static final String PROPERTY_EXTERNAL_DBNM = "external_dbnm";
    public static final String PROPERTY_EXTERNAL_UID = "external_uid";
    public static final String PROPERTY_EXTERNAL_PWD = "external_pwd";
    public static final String PROPERTY_PPN_ACC = "ppn_acc";
    public static final String PROPERTY_EXTERNAL_PORT = "external_port";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String external_id_;
    private String external_desc_;
    private String external_svrip_;
    private String external_dbnm_;
    private String external_uid_;
    private String external_pwd_;
    private String ppn_acc_;
    private String external_port_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Ut_external_dataAbst() throws CodeException {
        loadNew();
    }
    
    public Ut_external_dataAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ut_external_dataAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ut_external_dataAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ut_external_dataAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ut_external_dataAbst for Key : " + key + " val : " + val);
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
            
            
            
           external_id_ = rs.getString(PROPERTY_EXTERNAL_ID); 
           external_desc_ = rs.getString(PROPERTY_EXTERNAL_DESC); 
           external_svrip_ = rs.getString(PROPERTY_EXTERNAL_SVRIP); 
           external_dbnm_ = rs.getString(PROPERTY_EXTERNAL_DBNM); 
           external_uid_ = rs.getString(PROPERTY_EXTERNAL_UID); 
           external_pwd_ = rs.getString(PROPERTY_EXTERNAL_PWD); 
           ppn_acc_ = rs.getString(PROPERTY_PPN_ACC); 
           external_port_ = rs.getString(PROPERTY_EXTERNAL_PORT); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ut_external_dataAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ut_external_data obj = (Ut_external_data)cache.get(getID());
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
                    throw new CodeException("Error Reading Ut_external_data " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ut_external_data ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ut_external_data " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_EXTERNAL_ID , external_id_ ); 
            rs.updateString(PROPERTY_EXTERNAL_DESC , external_desc_ ); 
            rs.updateString(PROPERTY_EXTERNAL_SVRIP , external_svrip_ ); 
            rs.updateString(PROPERTY_EXTERNAL_DBNM , external_dbnm_ ); 
            rs.updateString(PROPERTY_EXTERNAL_UID , external_uid_ ); 
            rs.updateString(PROPERTY_EXTERNAL_PWD , external_pwd_ ); 
            rs.updateString(PROPERTY_PPN_ACC , ppn_acc_ ); 
            rs.updateString(PROPERTY_EXTERNAL_PORT , external_port_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Ut_external_data obj = (Ut_external_data) jCob;
        id_ = obj.getID();

        
          external_id_ = obj.getexternal_id();
          external_desc_ = obj.getexternal_desc();
          external_svrip_ = obj.getexternal_svrip();
          external_dbnm_ = obj.getexternal_dbnm();
          external_uid_ = obj.getexternal_uid();
          external_pwd_ = obj.getexternal_pwd();
          ppn_acc_ = obj.getppn_acc();
          external_port_ = obj.getexternal_port();
                
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

    
      public void setexternal_id(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_id_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_id_; 
      } 

      public void setexternal_desc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_desc_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_desc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_desc_; 
      } 

      public void setexternal_svrip(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_svrip_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_svrip() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_svrip_; 
      } 

      public void setexternal_dbnm(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_dbnm_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_dbnm() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_dbnm_; 
      } 

      public void setexternal_uid(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_uid_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_uid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_uid_; 
      } 

      public void setexternal_pwd(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_pwd_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_pwd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_pwd_; 
      } 

      public void setppn_acc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ppn_acc_ = param; 
         _isDirty_ = true; 
      } 

      public String getppn_acc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ppn_acc_; 
      } 

      public void setexternal_port(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         external_port_ = param; 
         _isDirty_ = true; 
      } 

      public String getexternal_port() throws CodeException {
         if (!_isLoaded_) { read();} 
         return external_port_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_EXTERNAL_ID)) return getexternal_id(); 
           else if (param.equals(PROPERTY_EXTERNAL_DESC)) return getexternal_desc(); 
           else if (param.equals(PROPERTY_EXTERNAL_SVRIP)) return getexternal_svrip(); 
           else if (param.equals(PROPERTY_EXTERNAL_DBNM)) return getexternal_dbnm(); 
           else if (param.equals(PROPERTY_EXTERNAL_UID)) return getexternal_uid(); 
           else if (param.equals(PROPERTY_EXTERNAL_PWD)) return getexternal_pwd(); 
           else if (param.equals(PROPERTY_PPN_ACC)) return getppn_acc(); 
           else if (param.equals(PROPERTY_EXTERNAL_PORT)) return getexternal_port(); 
       
        
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
        
           else if (param.equals(PROPERTY_EXTERNAL_ID))  setexternal_id(value); 
           else if (param.equals(PROPERTY_EXTERNAL_DESC))  setexternal_desc(value); 
           else if (param.equals(PROPERTY_EXTERNAL_SVRIP))  setexternal_svrip(value); 
           else if (param.equals(PROPERTY_EXTERNAL_DBNM))  setexternal_dbnm(value); 
           else if (param.equals(PROPERTY_EXTERNAL_UID))  setexternal_uid(value); 
           else if (param.equals(PROPERTY_EXTERNAL_PWD))  setexternal_pwd(value); 
           else if (param.equals(PROPERTY_PPN_ACC))  setppn_acc(value); 
           else if (param.equals(PROPERTY_EXTERNAL_PORT))  setexternal_port(value); 
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
            throw new CodeException("Ut_external_data : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ut_external_data : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ut_external_data : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ut_external_data : Cannot Move Last " + ex.getMessage());
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



