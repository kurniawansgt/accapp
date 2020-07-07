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


public abstract class Gl_batchlistAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_batchlist";

    public static final String TABLE = "gl_batchlist";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHID = "batchid";
    public static final String PROPERTY_READYTPOST = "readytpost";
    public static final String PROPERTY_BTCHDESC = "btchdesc";
    public static final String PROPERTY_SRCELEDGR = "srceledgr";
    public static final String PROPERTY_BATCHDATE = "batchdate";
    public static final String PROPERTY_BATCHTYPE = "batchtype";
    public static final String PROPERTY_BATCHSTS = "batchsts";
    public static final String PROPERTY_POSTNGSEQ = "postngseq";
    public static final String PROPERTY_DEBITTOT = "debittot";
    public static final String PROPERTY_CREDITTOT = "credittot";
    public static final String PROPERTY_QTYTOTAL = "qtytotal";
    public static final String PROPERTY_ENTRYCNT = "entrycnt";
    public static final String PROPERTY_NEXTENTRY = "nextentry";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_BATCHID;
    
    
    private long id_;
    private double batchid_;
    private String readytpost_;
    private String btchdesc_;
    private String srceledgr_;
    private String batchdate_;
    private String batchtype_;
    private String batchsts_;
    private double postngseq_;
    private double debittot_;
    private double credittot_;
    private long qtytotal_;
    private long entrycnt_;
    private long nextentry_;
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

    public Gl_batchlistAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_batchlistAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_batchlistAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_batchlistAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_batchlistAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_batchlistAbst for Key : " + key + " val : " + val);
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
            
            
            
           batchid_ = rs.getDouble(PROPERTY_BATCHID); 
           readytpost_ = rs.getString(PROPERTY_READYTPOST); 
           btchdesc_ = rs.getString(PROPERTY_BTCHDESC); 
           srceledgr_ = rs.getString(PROPERTY_SRCELEDGR); 
           batchdate_ = rs.getString(PROPERTY_BATCHDATE); 
           batchtype_ = rs.getString(PROPERTY_BATCHTYPE); 
           batchsts_ = rs.getString(PROPERTY_BATCHSTS); 
           postngseq_ = rs.getDouble(PROPERTY_POSTNGSEQ); 
           debittot_ = rs.getDouble(PROPERTY_DEBITTOT); 
           credittot_ = rs.getDouble(PROPERTY_CREDITTOT); 
           qtytotal_ = rs.getLong(PROPERTY_QTYTOTAL); 
           entrycnt_ = rs.getLong(PROPERTY_ENTRYCNT); 
           nextentry_ = rs.getLong(PROPERTY_NEXTENTRY); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_batchlistAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_batchlist obj = (Gl_batchlist)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_batchlist " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbatchid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : batchid can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from gl_batchlist ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_batchlist " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BATCHID , batchid_ ); 
            rs.updateString(PROPERTY_READYTPOST , readytpost_ ); 
            rs.updateString(PROPERTY_BTCHDESC , btchdesc_ ); 
            rs.updateString(PROPERTY_SRCELEDGR , srceledgr_ ); 
            rs.updateString(PROPERTY_BATCHDATE , batchdate_ ); 
            rs.updateString(PROPERTY_BATCHTYPE , batchtype_ ); 
            rs.updateString(PROPERTY_BATCHSTS , batchsts_ ); 
            rs.updateDouble(PROPERTY_POSTNGSEQ , postngseq_ ); 
            rs.updateDouble(PROPERTY_DEBITTOT , debittot_ ); 
            rs.updateDouble(PROPERTY_CREDITTOT , credittot_ ); 
            rs.updateLong(PROPERTY_QTYTOTAL , qtytotal_ ); 
            rs.updateLong(PROPERTY_ENTRYCNT , entrycnt_ ); 
            rs.updateLong(PROPERTY_NEXTENTRY , nextentry_ ); 
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
        Gl_batchlist obj = (Gl_batchlist) jCob;
        id_ = obj.getID();

        
          batchid_ = obj.getbatchid();
          readytpost_ = obj.getreadytpost();
          btchdesc_ = obj.getbtchdesc();
          srceledgr_ = obj.getsrceledgr();
          batchdate_ = obj.getbatchdate();
          batchtype_ = obj.getbatchtype();
          batchsts_ = obj.getbatchsts();
          postngseq_ = obj.getpostngseq();
          debittot_ = obj.getdebittot();
          credittot_ = obj.getcredittot();
          qtytotal_ = obj.getqtytotal();
          entrycnt_ = obj.getentrycnt();
          nextentry_ = obj.getnextentry();
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

    
      public void setbatchid(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchid_ = param; 
         _isDirty_ = true; 
      } 

      public double getbatchid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchid_; 
      } 

      public void setreadytpost(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         readytpost_ = param; 
         _isDirty_ = true; 
      } 

      public String getreadytpost() throws CodeException {
         if (!_isLoaded_) { read();} 
         return readytpost_; 
      } 

      public void setbtchdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         btchdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getbtchdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return btchdesc_; 
      } 

      public void setsrceledgr(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srceledgr_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrceledgr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srceledgr_; 
      } 

      public void setbatchdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchdate_; 
      } 

      public void setbatchtype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchtype_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchtype_; 
      } 

      public void setbatchsts(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchsts_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchsts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchsts_; 
      } 

      public void setpostngseq(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         postngseq_ = param; 
         _isDirty_ = true; 
      } 

      public double getpostngseq() throws CodeException {
         if (!_isLoaded_) { read();} 
         return postngseq_; 
      } 

      public void setdebittot(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         debittot_ = param; 
         _isDirty_ = true; 
      } 

      public double getdebittot() throws CodeException {
         if (!_isLoaded_) { read();} 
         return debittot_; 
      } 

      public void setcredittot(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         credittot_ = param; 
         _isDirty_ = true; 
      } 

      public double getcredittot() throws CodeException {
         if (!_isLoaded_) { read();} 
         return credittot_; 
      } 

      public void setqtytotal(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         qtytotal_ = param; 
         _isDirty_ = true; 
      } 

      public long getqtytotal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return qtytotal_; 
      } 

      public void setentrycnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrycnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getentrycnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrycnt_; 
      } 

      public void setnextentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nextentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getnextentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nextentry_; 
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
        
           else if (param.equals(PROPERTY_BATCHID)) return decform.format(getbatchid()); 
           else if (param.equals(PROPERTY_READYTPOST)) return getreadytpost(); 
           else if (param.equals(PROPERTY_BTCHDESC)) return getbtchdesc(); 
           else if (param.equals(PROPERTY_SRCELEDGR)) return getsrceledgr(); 
           else if (param.equals(PROPERTY_BATCHDATE)) return getbatchdate(); 
           else if (param.equals(PROPERTY_BATCHTYPE)) return getbatchtype(); 
           else if (param.equals(PROPERTY_BATCHSTS)) return getbatchsts(); 
           else if (param.equals(PROPERTY_POSTNGSEQ)) return decform.format(getpostngseq()); 
           else if (param.equals(PROPERTY_DEBITTOT)) return decform.format(getdebittot()); 
           else if (param.equals(PROPERTY_CREDITTOT)) return decform.format(getcredittot()); 
           else if (param.equals(PROPERTY_QTYTOTAL)) return String.valueOf(getqtytotal()); 
           else if (param.equals(PROPERTY_ENTRYCNT)) return String.valueOf(getentrycnt()); 
           else if (param.equals(PROPERTY_NEXTENTRY)) return String.valueOf(getnextentry()); 
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
        
           else if (param.equals(PROPERTY_BATCHID)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbatchid(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_READYTPOST))  setreadytpost(value); 
           else if (param.equals(PROPERTY_BTCHDESC))  setbtchdesc(value); 
           else if (param.equals(PROPERTY_SRCELEDGR))  setsrceledgr(value); 
           else if (param.equals(PROPERTY_BATCHDATE))  setbatchdate(value); 
           else if (param.equals(PROPERTY_BATCHTYPE))  setbatchtype(value); 
           else if (param.equals(PROPERTY_BATCHSTS))  setbatchsts(value); 
           else if (param.equals(PROPERTY_POSTNGSEQ)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpostngseq(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DEBITTOT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdebittot(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CREDITTOT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcredittot(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_QTYTOTAL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setqtytotal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setentrycnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NEXTENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setnextentry(newVal); 
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
            throw new CodeException("Gl_batchlist : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, batchid_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_batchlist : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, batchid_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_batchlist : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_batchlist : Cannot Move Last " + ex.getMessage());
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



