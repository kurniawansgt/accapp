/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.objectclasses;


import common.classinterface.NavigatorObjectInt;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import common.utils.ClassRegister;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.utils.ObjectCache;
import common.jdbc.DbBeanCommon;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


public abstract class MastermoduleAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Mastermodule";

    public static final String TABLE = "mastermodule";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_MODULE = "Module";
    public static final String PROPERTY_DESCRIPTION = "Description";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_USERID = "UserId";
    
     public static final String PRIMARYKEY = PROPERTY_MODULE;
    
    
    private long id_;
    private String Module_;
    private String Description_;
    private Timestamp TanggalEntry_;
    private Timestamp TanggalUpdate_;
    private String UserId_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public MastermoduleAbst() throws CodeException {
        loadNew();
    }
    
    public MastermoduleAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MastermoduleAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MastermoduleAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MastermoduleAbst(ResultSet rs) throws CodeException {
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
        
        DbBeanCommon db = DbBeanCommon.connect();
        try{

            ResultSet rs = db.retrieve(TABLEPROCESS, key, val);
       
            if (rs.isBeforeFirst()) {
                rs.next();
                load(rs);
            }
            rs.close();
        } catch (SQLException sqle ) {
            throw new CodeException ("Error Create MastermoduleAbst for Key : " + key + " val : " + val);
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
            
            
            
           Module_ = rs.getString(PROPERTY_MODULE); 
           Description_ = rs.getString(PROPERTY_DESCRIPTION); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           UserId_ = rs.getString(PROPERTY_USERID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MastermoduleAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Mastermodule obj = (Mastermodule)cache.get(getID());
            if (obj!=null) {
                copy(obj);
            }else{
                DbBeanCommon db = DbBeanCommon.connect();
                ResultSet rs = db.retrieve(TABLEPROCESS, PROPERTY_ID, getID());
                try{
                    rs.next();
                    load(rs);
                    rs.close();
                    cache.add(this);
                }catch (SQLException e) {
                    throw new CodeException("Error Reading Mastermodule " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {

        
    }
    public void save() throws CodeException {
        cache.remove(this);
        
        checkNotNullFields();
        
        if (!_isDirty_) {
            return ;
        }else if (getID()==NULLID) {
            saveNew();
        }else {
            DbBeanCommon db = DbBeanCommon.connect();
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

        DbBeanCommon db = DbBeanCommon.connect();
        ResultSet rs = db.update(TABLEPROCESS, PROPERTY_ID, id_);
        try {
           rs.moveToInsertRow();
           saveFields(rs);
           rs.insertRow();
           rs = db.retrieveSQL("SELECT max(id) from mastermodule ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Mastermodule " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_MODULE , Module_ ); 
            rs.updateString(PROPERTY_DESCRIPTION , Description_ ); 
            if (getTanggalEntry()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALENTRY ,  getTanggalEntry()); 
            }
            if (getTanggalUpdate()==null) {
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,   null ); 
            }else{
               rs.updateTimestamp(PROPERTY_TANGGALUPDATE ,  getTanggalUpdate()); 
            }
            rs.updateString(PROPERTY_USERID , UserId_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Mastermodule obj = (Mastermodule) jCob;
        id_ = obj.getID();

        
          Module_ = obj.getModule();
          Description_ = obj.getDescription();
          TanggalEntry_ = obj.getTanggalEntry();
          TanggalUpdate_ = obj.getTanggalUpdate();
          UserId_ = obj.getUserId();
                
        _isDirty_ = false;
        _isLoaded_ = true;
    }
    
    public void delete() throws CodeException {
        cache.remove(this);
        DbBeanCommon db = DbBeanCommon.connect();
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

    
      public void setModule(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Module_ = param; 
         _isDirty_ = true; 
      } 

      public String getModule() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Module_; 
      } 

      public void setDescription(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Description_ = param; 
         _isDirty_ = true; 
      } 

      public String getDescription() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Description_; 
      } 

      public void setTanggalEntry(Timestamp param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalEntry_ = param; 
         _isDirty_ = true; 
      } 

      public Timestamp getTanggalEntry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalEntry_; 
      } 

      public void setTanggalUpdate(Timestamp param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         TanggalUpdate_ = param; 
         _isDirty_ = true; 
      } 

      public Timestamp getTanggalUpdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return TanggalUpdate_; 
      } 

      public void setUserId(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         UserId_ = param; 
         _isDirty_ = true; 
      } 

      public String getUserId() throws CodeException {
         if (!_isLoaded_) { read();} 
         return UserId_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_MODULE)) return getModule(); 
           else if (param.equals(PROPERTY_DESCRIPTION)) return getDescription(); 
           else if (param.equals(PROPERTY_TANGGALENTRY)) return getTanggalEntry()  == null || getTanggalEntry().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalEntry()) ; 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) return getTanggalUpdate()  == null || getTanggalUpdate().equals("0000-00-00 00:00:00") ? "" : datetimeformat.format(getTanggalUpdate()) ; 
           else if (param.equals(PROPERTY_USERID)) return getUserId(); 
       
        
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
        
           else if (param.equals(PROPERTY_MODULE))  setModule(value); 
           else if (param.equals(PROPERTY_DESCRIPTION))  setDescription(value); 
           else if (param.equals(PROPERTY_TANGGALENTRY)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalEntry(null); 
                   else { 
                        try{ 
                             java.util.Date d = datetimeformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             String time = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + ".0"; 
                             setTanggalEntry(Timestamp.valueOf(date + " " + time)); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_TANGGALUPDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setTanggalUpdate(null); 
                   else { 
                        try{ 
                             java.util.Date d = datetimeformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             String time = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds() + ".0"; 
                             setTanggalUpdate(Timestamp.valueOf(date + " " + time)); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_USERID))  setUserId(value); 
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
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.moveFirst(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
            throw new CodeException("Mastermodule : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, Module_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Mastermodule : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, Module_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Mastermodule : Cannot Move Next " + ex.getMessage());
       }
    }
    

    public void moveLast() throws CodeException {
        try {
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.moveLast(TABLEPROCESS, PRIMARYKEY);
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Mastermodule : Cannot Move Last " + ex.getMessage());
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
            DbBeanCommon db = DbBeanCommon.connect();
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
            DbBeanCommon db = DbBeanCommon.connect();
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
            DbBeanCommon db = DbBeanCommon.connect();
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
            DbBeanCommon db = DbBeanCommon.connect();
            db.exportToTextTabDelimited(TABLEPROCESS);
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



