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


public abstract class Gl_currencyratedAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_currencyrated";

    public static final String TABLE = "gl_currencyrated";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_HOMECUR = "homecur";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_SOURCECUR = "sourcecur";
    public static final String PROPERTY_RATEDATE = "ratedate";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_SPREAD = "spread";
    public static final String PROPERTY_DATEMATCH = "datematch";
    public static final String PROPERTY_RATEOPER = "rateoper";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String homecur_;
    private String ratetype_;
    private String sourcecur_;
    private String ratedate_;
    private double rate_;
    private double spread_;
    private long datematch_;
    private long rateoper_;
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

    public Gl_currencyratedAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_currencyratedAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_currencyratedAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_currencyratedAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_currencyratedAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_currencyratedAbst for Key : " + key + " val : " + val);
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
            
            
            
           homecur_ = rs.getString(PROPERTY_HOMECUR); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           sourcecur_ = rs.getString(PROPERTY_SOURCECUR); 
           ratedate_ = rs.getString(PROPERTY_RATEDATE); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           spread_ = rs.getDouble(PROPERTY_SPREAD); 
           datematch_ = rs.getLong(PROPERTY_DATEMATCH); 
           rateoper_ = rs.getLong(PROPERTY_RATEOPER); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_currencyratedAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_currencyrated obj = (Gl_currencyrated)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_currencyrated " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from gl_currencyrated ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_currencyrated " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_HOMECUR , homecur_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateString(PROPERTY_SOURCECUR , sourcecur_ ); 
            rs.updateString(PROPERTY_RATEDATE , ratedate_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateDouble(PROPERTY_SPREAD , spread_ ); 
            rs.updateLong(PROPERTY_DATEMATCH , datematch_ ); 
            rs.updateLong(PROPERTY_RATEOPER , rateoper_ ); 
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
        Gl_currencyrated obj = (Gl_currencyrated) jCob;
        id_ = obj.getID();

        
          homecur_ = obj.gethomecur();
          ratetype_ = obj.getratetype();
          sourcecur_ = obj.getsourcecur();
          ratedate_ = obj.getratedate();
          rate_ = obj.getrate();
          spread_ = obj.getspread();
          datematch_ = obj.getdatematch();
          rateoper_ = obj.getrateoper();
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

    
      public void sethomecur(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         homecur_ = param; 
         _isDirty_ = true; 
      } 

      public String gethomecur() throws CodeException {
         if (!_isLoaded_) { read();} 
         return homecur_; 
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

      public void setsourcecur(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sourcecur_ = param; 
         _isDirty_ = true; 
      } 

      public String getsourcecur() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sourcecur_; 
      } 

      public void setratedate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratedate_ = param; 
         _isDirty_ = true; 
      } 

      public String getratedate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratedate_; 
      } 

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
      } 

      public void setspread(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         spread_ = param; 
         _isDirty_ = true; 
      } 

      public double getspread() throws CodeException {
         if (!_isLoaded_) { read();} 
         return spread_; 
      } 

      public void setdatematch(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         datematch_ = param; 
         _isDirty_ = true; 
      } 

      public long getdatematch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return datematch_; 
      } 

      public void setrateoper(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rateoper_ = param; 
         _isDirty_ = true; 
      } 

      public long getrateoper() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rateoper_; 
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
        
           else if (param.equals(PROPERTY_HOMECUR)) return gethomecur(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_SOURCECUR)) return getsourcecur(); 
           else if (param.equals(PROPERTY_RATEDATE)) return getratedate(); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_SPREAD)) return decform.format(getspread()); 
           else if (param.equals(PROPERTY_DATEMATCH)) return String.valueOf(getdatematch()); 
           else if (param.equals(PROPERTY_RATEOPER)) return String.valueOf(getrateoper()); 
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
        
           else if (param.equals(PROPERTY_HOMECUR))  sethomecur(value); 
           else if (param.equals(PROPERTY_RATETYPE))  setratetype(value); 
           else if (param.equals(PROPERTY_SOURCECUR))  setsourcecur(value); 
           else if (param.equals(PROPERTY_RATEDATE))  setratedate(value); 
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SPREAD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setspread(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DATEMATCH)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdatematch(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RATEOPER)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrateoper(newVal); 
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
            throw new CodeException("Gl_currencyrated : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Gl_currencyrated : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Gl_currencyrated : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_currencyrated : Cannot Move Last " + ex.getMessage());
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



