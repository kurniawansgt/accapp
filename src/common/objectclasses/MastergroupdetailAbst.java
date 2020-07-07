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


public abstract class MastergroupdetailAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Mastergroupdetail";

    public static final String TABLE = "mastergroupdetail";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_KODEGROUP = "KodeGroup";
    public static final String PROPERTY_MODULE = "Module";
    public static final String PROPERTY_COMPANY = "Company";
    public static final String PROPERTY_READ = "Read";
    public static final String PROPERTY_CONFIRM = "Confirm";
    public static final String PROPERTY_ENTRY = "Entry";
    public static final String PROPERTY_UPDATE = "Update";
    public static final String PROPERTY_DELETE = "Delete";
    public static final String PROPERTY_PRINT = "Print";
    public static final String PROPERTY_EXPORT = "Export";
    public static final String PROPERTY_IMPORT = "Import";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_USERID = "UserId";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String KodeGroup_;
    private String Module_;
    private String Company_;
    private long Read_;
    private long Confirm_;
    private long Entry_;
    private long Update_;
    private long Delete_;
    private long Print_;
    private long Export_;
    private long Import_;
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

    public MastergroupdetailAbst() throws CodeException {
        loadNew();
    }
    
    public MastergroupdetailAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MastergroupdetailAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MastergroupdetailAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MastergroupdetailAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create MastergroupdetailAbst for Key : " + key + " val : " + val);
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
            
            
            
           KodeGroup_ = rs.getString(PROPERTY_KODEGROUP); 
           Module_ = rs.getString(PROPERTY_MODULE);
           Company_ = rs.getString(PROPERTY_COMPANY);
           Read_ = rs.getLong(PROPERTY_READ); 
           Confirm_ = rs.getLong(PROPERTY_CONFIRM); 
           Entry_ = rs.getLong(PROPERTY_ENTRY); 
           Update_ = rs.getLong(PROPERTY_UPDATE); 
           Delete_ = rs.getLong(PROPERTY_DELETE); 
           Print_ = rs.getLong(PROPERTY_PRINT); 
           Export_ = rs.getLong(PROPERTY_EXPORT); 
           Import_ = rs.getLong(PROPERTY_IMPORT); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           UserId_ = rs.getString(PROPERTY_USERID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MastergroupdetailAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Mastergroupdetail obj = (Mastergroupdetail)cache.get(getID());
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
                    throw new CodeException("Error Reading Mastergroupdetail " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from mastergroupdetail ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Mastergroupdetail " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_KODEGROUP , KodeGroup_ ); 
            rs.updateString(PROPERTY_MODULE , Module_ );
            rs.updateString(PROPERTY_COMPANY , Company_ );
            rs.updateLong(PROPERTY_READ , Read_ ); 
            rs.updateLong(PROPERTY_CONFIRM , Confirm_ ); 
            rs.updateLong(PROPERTY_ENTRY , Entry_ ); 
            rs.updateLong(PROPERTY_UPDATE , Update_ ); 
            rs.updateLong(PROPERTY_DELETE , Delete_ ); 
            rs.updateLong(PROPERTY_PRINT , Print_ ); 
            rs.updateLong(PROPERTY_EXPORT , Export_ ); 
            rs.updateLong(PROPERTY_IMPORT , Import_ ); 
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
        Mastergroupdetail obj = (Mastergroupdetail) jCob;
        id_ = obj.getID();

        
          KodeGroup_ = obj.getKodeGroup();
          Module_ = obj.getModule();
          Company_ = obj.getCompany();
          Read_ = obj.getRead();
          Confirm_ = obj.getConfirm();
          Entry_ = obj.getEntry();
          Update_ = obj.getUpdate();
          Delete_ = obj.getDelete();
          Print_ = obj.getPrint();
          Export_ = obj.getExport();
          Import_ = obj.getImport();
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

    
      public void setKodeGroup(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         KodeGroup_ = param; 
         _isDirty_ = true; 
      } 

      public String getKodeGroup() throws CodeException {
         if (!_isLoaded_) { read();} 
         return KodeGroup_; 
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

      public void setCompany(String param) throws CodeException {
         if (!_isLoaded_) { read();}
         Company_ = param;
         _isDirty_ = true;
      }

      public String getCompany() throws CodeException {
         if (!_isLoaded_) { read();}
         return Company_;
      }

      public void setRead(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Read_ = param; 
         _isDirty_ = true; 
      } 

      public long getRead() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Read_; 
      } 

      public void setConfirm(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Confirm_ = param; 
         _isDirty_ = true; 
      } 

      public long getConfirm() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Confirm_; 
      } 

      public void setEntry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Entry_ = param; 
         _isDirty_ = true; 
      } 

      public long getEntry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Entry_; 
      } 

      public void setUpdate(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Update_ = param; 
         _isDirty_ = true; 
      } 

      public long getUpdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Update_; 
      } 

      public void setDelete(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Delete_ = param; 
         _isDirty_ = true; 
      } 

      public long getDelete() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Delete_; 
      } 

      public void setPrint(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Print_ = param; 
         _isDirty_ = true; 
      } 

      public long getPrint() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Print_; 
      } 

      public void setExport(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Export_ = param; 
         _isDirty_ = true; 
      } 

      public long getExport() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Export_; 
      } 

      public void setImport(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Import_ = param; 
         _isDirty_ = true; 
      } 

      public long getImport() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Import_; 
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
        
           else if (param.equals(PROPERTY_KODEGROUP)) return getKodeGroup(); 
           else if (param.equals(PROPERTY_MODULE)) return getModule();
           else if (param.equals(PROPERTY_COMPANY)) return getCompany();
           else if (param.equals(PROPERTY_READ)) return String.valueOf(getRead()); 
           else if (param.equals(PROPERTY_CONFIRM)) return String.valueOf(getConfirm()); 
           else if (param.equals(PROPERTY_ENTRY)) return String.valueOf(getEntry()); 
           else if (param.equals(PROPERTY_UPDATE)) return String.valueOf(getUpdate()); 
           else if (param.equals(PROPERTY_DELETE)) return String.valueOf(getDelete()); 
           else if (param.equals(PROPERTY_PRINT)) return String.valueOf(getPrint()); 
           else if (param.equals(PROPERTY_EXPORT)) return String.valueOf(getExport()); 
           else if (param.equals(PROPERTY_IMPORT)) return String.valueOf(getImport()); 
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
        
           else if (param.equals(PROPERTY_KODEGROUP))  setKodeGroup(value); 
           else if (param.equals(PROPERTY_MODULE))  setModule(value);
           else if (param.equals(PROPERTY_COMPANY))  setModule(value);
           else if (param.equals(PROPERTY_READ)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setRead(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CONFIRM)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setConfirm(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setEntry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_UPDATE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setUpdate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DELETE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setDelete(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PRINT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setPrint(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_EXPORT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setExport(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_IMPORT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setImport(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
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
            throw new CodeException("Mastergroupdetail : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, id_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Mastergroupdetail : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBeanCommon db = DbBeanCommon.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, id_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Mastergroupdetail : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Mastergroupdetail : Cannot Move Last " + ex.getMessage());
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



