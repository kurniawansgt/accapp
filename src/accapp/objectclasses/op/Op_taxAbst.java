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


public abstract class Op_taxAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Op_tax";

    public static final String TABLE = "op_tax";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_TAXVALUE = "taxvalue";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_LIABLYACCCODE = "liablyacccode";
    public static final String PROPERTY_RECOVERABLE = "recoverable";
    public static final String PROPERTY_RATERECOV = "raterecov";
    public static final String PROPERTY_RECVRACCCODE = "recvracccode";
    public static final String PROPERTY_EXPSEPARTE = "expseparte";
    public static final String PROPERTY_EXPNACCCODE = "expnacccode";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_TAXCODE;
    
    
    private long id_;
    private String taxcode_;
    private String dscription_;
    private double taxvalue_;
    private String curnccode_;
    private double rate_;
    private String liablyacccode_;
    private long recoverable_;
    private double raterecov_;
    private String recvracccode_;
    private double expseparte_;
    private String expnacccode_;
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

    public Op_taxAbst() throws CodeException {
        loadNew();
    }
    
    public Op_taxAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Op_taxAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Op_taxAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Op_taxAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Op_taxAbst for Key : " + key + " val : " + val);
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
            
            
            
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           taxvalue_ = rs.getDouble(PROPERTY_TAXVALUE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           liablyacccode_ = rs.getString(PROPERTY_LIABLYACCCODE); 
           recoverable_ = rs.getLong(PROPERTY_RECOVERABLE); 
           raterecov_ = rs.getDouble(PROPERTY_RATERECOV); 
           recvracccode_ = rs.getString(PROPERTY_RECVRACCCODE); 
           expseparte_ = rs.getDouble(PROPERTY_EXPSEPARTE); 
           expnacccode_ = rs.getString(PROPERTY_EXPNACCCODE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Op_taxAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Op_tax obj = (Op_tax)cache.get(getID());
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
                    throw new CodeException("Error Reading Op_tax " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = gettaxcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : taxcode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from op_tax ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Op_tax " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateDouble(PROPERTY_TAXVALUE , taxvalue_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateString(PROPERTY_LIABLYACCCODE , liablyacccode_ ); 
            rs.updateLong(PROPERTY_RECOVERABLE , recoverable_ ); 
            rs.updateDouble(PROPERTY_RATERECOV , raterecov_ ); 
            rs.updateString(PROPERTY_RECVRACCCODE , recvracccode_ ); 
            rs.updateDouble(PROPERTY_EXPSEPARTE , expseparte_ ); 
            rs.updateString(PROPERTY_EXPNACCCODE , expnacccode_ ); 
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
        Op_tax obj = (Op_tax) jCob;
        id_ = obj.getID();

        
          taxcode_ = obj.gettaxcode();
          dscription_ = obj.getdscription();
          taxvalue_ = obj.gettaxvalue();
          curnccode_ = obj.getcurnccode();
          rate_ = obj.getrate();
          liablyacccode_ = obj.getliablyacccode();
          recoverable_ = obj.getrecoverable();
          raterecov_ = obj.getraterecov();
          recvracccode_ = obj.getrecvracccode();
          expseparte_ = obj.getexpseparte();
          expnacccode_ = obj.getexpnacccode();
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

    
      public void settaxcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxcode_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxcode_; 
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

      public void settaxvalue(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxvalue_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxvalue() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxvalue_; 
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

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
      } 

      public void setliablyacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         liablyacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getliablyacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return liablyacccode_; 
      } 

      public void setrecoverable(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         recoverable_ = param; 
         _isDirty_ = true; 
      } 

      public long getrecoverable() throws CodeException {
         if (!_isLoaded_) { read();} 
         return recoverable_; 
      } 

      public void setraterecov(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         raterecov_ = param; 
         _isDirty_ = true; 
      } 

      public double getraterecov() throws CodeException {
         if (!_isLoaded_) { read();} 
         return raterecov_; 
      } 

      public void setrecvracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         recvracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getrecvracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return recvracccode_; 
      } 

      public void setexpseparte(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         expseparte_ = param; 
         _isDirty_ = true; 
      } 

      public double getexpseparte() throws CodeException {
         if (!_isLoaded_) { read();} 
         return expseparte_; 
      } 

      public void setexpnacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         expnacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getexpnacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return expnacccode_; 
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
        
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_TAXVALUE)) return decform.format(gettaxvalue()); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_LIABLYACCCODE)) return getliablyacccode(); 
           else if (param.equals(PROPERTY_RECOVERABLE)) return String.valueOf(getrecoverable()); 
           else if (param.equals(PROPERTY_RATERECOV)) return decform.format(getraterecov()); 
           else if (param.equals(PROPERTY_RECVRACCCODE)) return getrecvracccode(); 
           else if (param.equals(PROPERTY_EXPSEPARTE)) return decform.format(getexpseparte()); 
           else if (param.equals(PROPERTY_EXPNACCCODE)) return getexpnacccode(); 
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
        
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_TAXVALUE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxvalue(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LIABLYACCCODE))  setliablyacccode(value); 
           else if (param.equals(PROPERTY_RECOVERABLE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrecoverable(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RATERECOV)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setraterecov(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RECVRACCCODE))  setrecvracccode(value); 
           else if (param.equals(PROPERTY_EXPSEPARTE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setexpseparte(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_EXPNACCCODE))  setexpnacccode(value); 
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
            throw new CodeException("Op_tax : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, taxcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Op_tax : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, taxcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Op_tax : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Op_tax : Cannot Move Last " + ex.getMessage());
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



