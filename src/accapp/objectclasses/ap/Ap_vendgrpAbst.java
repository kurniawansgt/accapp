/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.ap;


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


public abstract class Ap_vendgrpAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ap_vendgrp";

    public static final String TABLE = "ap_vendgrp";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_GRPCODE = "grpcode";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_ACCSETCODE = "accsetcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_TERMCODE = "termcode";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_DISTBY = "distby";
    public static final String PROPERTY_DISTCODE = "distcode";
    public static final String PROPERTY_DISTSETCODE = "distsetcode";
    public static final String PROPERTY_GLACCCODE = "glacccode";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_GRPCODE;
    
    
    private long id_;
    private String grpcode_;
    private long active_;
    private String dscription_;
    private String accsetcode_;
    private String curnccode_;
    private String termcode_;
    private String ratetype_;
    private String taxcode_;
    private String bankcode_;
    private long distby_;
    private String distcode_;
    private String distsetcode_;
    private String glacccode_;
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

    public Ap_vendgrpAbst() throws CodeException {
        loadNew();
    }
    
    public Ap_vendgrpAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ap_vendgrpAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ap_vendgrpAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ap_vendgrpAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ap_vendgrpAbst for Key : " + key + " val : " + val);
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
            
            
            
           grpcode_ = rs.getString(PROPERTY_GRPCODE); 
           active_ = rs.getLong(PROPERTY_ACTIVE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           accsetcode_ = rs.getString(PROPERTY_ACCSETCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           termcode_ = rs.getString(PROPERTY_TERMCODE); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           distby_ = rs.getLong(PROPERTY_DISTBY); 
           distcode_ = rs.getString(PROPERTY_DISTCODE); 
           distsetcode_ = rs.getString(PROPERTY_DISTSETCODE); 
           glacccode_ = rs.getString(PROPERTY_GLACCCODE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ap_vendgrpAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ap_vendgrp obj = (Ap_vendgrp)cache.get(getID());
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
                    throw new CodeException("Error Reading Ap_vendgrp " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getgrpcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : grpcode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from ap_vendgrp ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ap_vendgrp " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_GRPCODE , grpcode_ ); 
            rs.updateLong(PROPERTY_ACTIVE , active_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_ACCSETCODE , accsetcode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_TERMCODE , termcode_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateLong(PROPERTY_DISTBY , distby_ ); 
            rs.updateString(PROPERTY_DISTCODE , distcode_ ); 
            rs.updateString(PROPERTY_DISTSETCODE , distsetcode_ ); 
            rs.updateString(PROPERTY_GLACCCODE , glacccode_ ); 
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
        Ap_vendgrp obj = (Ap_vendgrp) jCob;
        id_ = obj.getID();

        
          grpcode_ = obj.getgrpcode();
          active_ = obj.getactive();
          dscription_ = obj.getdscription();
          accsetcode_ = obj.getaccsetcode();
          curnccode_ = obj.getcurnccode();
          termcode_ = obj.gettermcode();
          ratetype_ = obj.getratetype();
          taxcode_ = obj.gettaxcode();
          bankcode_ = obj.getbankcode();
          distby_ = obj.getdistby();
          distcode_ = obj.getdistcode();
          distsetcode_ = obj.getdistsetcode();
          glacccode_ = obj.getglacccode();
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

    
      public void setgrpcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         grpcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getgrpcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return grpcode_; 
      } 

      public void setactive(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         active_ = param; 
         _isDirty_ = true; 
      } 

      public long getactive() throws CodeException {
         if (!_isLoaded_) { read();} 
         return active_; 
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

      public void setaccsetcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsetcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsetcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsetcode_; 
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

      public void settermcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         termcode_ = param; 
         _isDirty_ = true; 
      } 

      public String gettermcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return termcode_; 
      } 

      public void setratetype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratetype_ = param; 
         _isDirty_ = true; 
      } 

      public String getratetype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratetype_; 
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

      public void setbankcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankcode_; 
      } 

      public void setdistby(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         distby_ = param; 
         _isDirty_ = true; 
      } 

      public long getdistby() throws CodeException {
         if (!_isLoaded_) { read();} 
         return distby_; 
      } 

      public void setdistcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         distcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getdistcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return distcode_; 
      } 

      public void setdistsetcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         distsetcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getdistsetcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return distsetcode_; 
      } 

      public void setglacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getglacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glacccode_; 
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
        
           else if (param.equals(PROPERTY_GRPCODE)) return getgrpcode(); 
           else if (param.equals(PROPERTY_ACTIVE)) return String.valueOf(getactive()); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_ACCSETCODE)) return getaccsetcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_TERMCODE)) return gettermcode(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_DISTBY)) return String.valueOf(getdistby()); 
           else if (param.equals(PROPERTY_DISTCODE)) return getdistcode(); 
           else if (param.equals(PROPERTY_DISTSETCODE)) return getdistsetcode(); 
           else if (param.equals(PROPERTY_GLACCCODE)) return getglacccode(); 
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
        
           else if (param.equals(PROPERTY_GRPCODE))  setgrpcode(value); 
           else if (param.equals(PROPERTY_ACTIVE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setactive(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_ACCSETCODE))  setaccsetcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_TERMCODE))  settermcode(value); 
           else if (param.equals(PROPERTY_RATETYPE))  setratetype(value); 
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_DISTBY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdistby(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISTCODE))  setdistcode(value); 
           else if (param.equals(PROPERTY_DISTSETCODE))  setdistsetcode(value); 
           else if (param.equals(PROPERTY_GLACCCODE))  setglacccode(value); 
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
            throw new CodeException("Ap_vendgrp : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, grpcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_vendgrp : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, grpcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_vendgrp : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ap_vendgrp : Cannot Move Last " + ex.getMessage());
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



