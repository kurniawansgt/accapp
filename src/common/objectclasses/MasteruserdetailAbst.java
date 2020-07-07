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


public abstract class MasteruserdetailAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Masteruserdetail";

    public static final String TABLE = "masteruserdetail";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_USER = "User";
    public static final String PROPERTY_KODEGROUP = "KodeGroup";
    public static final String PROPERTY_TANGGALENTRY = "TanggalEntry";
    public static final String PROPERTY_TANGGALUPDATE = "TanggalUpdate";
    public static final String PROPERTY_USERID = "UserId";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String User_;
    private String KodeGroup_;
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

    public MasteruserdetailAbst() throws CodeException {
        loadNew();
    }
    
    public MasteruserdetailAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public MasteruserdetailAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public MasteruserdetailAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public MasteruserdetailAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create MasteruserdetailAbst for Key : " + key + " val : " + val);
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
            
            
            
           User_ = rs.getString(PROPERTY_USER); 
           KodeGroup_ = rs.getString(PROPERTY_KODEGROUP); 
           TanggalEntry_ = rs.getTimestamp(PROPERTY_TANGGALENTRY); 
           TanggalUpdate_ = rs.getTimestamp(PROPERTY_TANGGALUPDATE); 
           UserId_ = rs.getString(PROPERTY_USERID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading MasteruserdetailAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Masteruserdetail obj = (Masteruserdetail)cache.get(getID());
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
                    throw new CodeException("Error Reading Masteruserdetail " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from masteruserdetail ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Masteruserdetail " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_USER , User_ ); 
            rs.updateString(PROPERTY_KODEGROUP , KodeGroup_ ); 
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
        Masteruserdetail obj = (Masteruserdetail) jCob;
        id_ = obj.getID();

        
          User_ = obj.getUser();
          KodeGroup_ = obj.getKodeGroup();
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

    
      public void setUser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         User_ = param; 
         _isDirty_ = true; 
      } 

      public String getUser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return User_; 
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
        
           else if (param.equals(PROPERTY_USER)) return getUser(); 
           else if (param.equals(PROPERTY_KODEGROUP)) return getKodeGroup(); 
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
        
           else if (param.equals(PROPERTY_USER))  setUser(value); 
           else if (param.equals(PROPERTY_KODEGROUP))  setKodeGroup(value); 
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
            throw new CodeException("Masteruserdetail : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Masteruserdetail : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Masteruserdetail : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Masteruserdetail : Cannot Move Last " + ex.getMessage());
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



