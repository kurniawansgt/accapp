/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.ar;


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


public abstract class Ar_rcpdAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_rcpd";

    public static final String TABLE = "ar_rcpd";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_LINENUM = "linenum";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_PAYAMT = "payamt";
    public static final String PROPERTY_DISCAMT = "discamt";
    public static final String PROPERTY_ADJUSTAMT = "adjustamt";
    public static final String PROPERTY_ADJUSTNO = "adjustno";
    public static final String PROPERTY_TEXTAJUST = "textajust";
    public static final String PROPERTY_GLREFF = "glreff";
    public static final String PROPERTY_DOCNUMPPD = "docnumppd";
    public static final String PROPERTY_DBADJAMT = "dbadjamt";
    public static final String PROPERTY_CRADJAMT = "cradjamt";
    public static final String PROPERTY_ENTRYSTS = "entrysts";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long batchno_;
    private long docentry_;
    private long linenum_;
    private String custmrcode_;
    private String docnum_;
    private double payamt_;
    private double discamt_;
    private double adjustamt_;
    private long adjustno_;
    private String textajust_;
    private String glreff_;
    private String docnumppd_;
    private double dbadjamt_;
    private double cradjamt_;
    private long entrysts_;
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

    public Ar_rcpdAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_rcpdAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_rcpdAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_rcpdAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_rcpdAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_rcpdAbst for Key : " + key + " val : " + val);
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
            
            
            
           batchno_ = rs.getLong(PROPERTY_BATCHNO); 
           docentry_ = rs.getLong(PROPERTY_DOCENTRY); 
           linenum_ = rs.getLong(PROPERTY_LINENUM); 
           custmrcode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           payamt_ = rs.getDouble(PROPERTY_PAYAMT); 
           discamt_ = rs.getDouble(PROPERTY_DISCAMT); 
           adjustamt_ = rs.getDouble(PROPERTY_ADJUSTAMT); 
           adjustno_ = rs.getLong(PROPERTY_ADJUSTNO); 
           textajust_ = rs.getString(PROPERTY_TEXTAJUST); 
           glreff_ = rs.getString(PROPERTY_GLREFF); 
           docnumppd_ = rs.getString(PROPERTY_DOCNUMPPD); 
           dbadjamt_ = rs.getDouble(PROPERTY_DBADJAMT); 
           cradjamt_ = rs.getDouble(PROPERTY_CRADJAMT); 
           entrysts_ = rs.getLong(PROPERTY_ENTRYSTS); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_rcpdAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_rcpd obj = (Ar_rcpd)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_rcpd " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_rcpd ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_rcpd " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateLong(PROPERTY_BATCHNO , batchno_ ); 
            rs.updateLong(PROPERTY_DOCENTRY , docentry_ ); 
            rs.updateLong(PROPERTY_LINENUM , linenum_ ); 
            rs.updateString(PROPERTY_CUSTMRCODE , custmrcode_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateDouble(PROPERTY_PAYAMT , payamt_ ); 
            rs.updateDouble(PROPERTY_DISCAMT , discamt_ ); 
            rs.updateDouble(PROPERTY_ADJUSTAMT , adjustamt_ ); 
            rs.updateLong(PROPERTY_ADJUSTNO , adjustno_ ); 
            rs.updateString(PROPERTY_TEXTAJUST , textajust_ ); 
            rs.updateString(PROPERTY_GLREFF , glreff_ ); 
            rs.updateString(PROPERTY_DOCNUMPPD , docnumppd_ ); 
            rs.updateDouble(PROPERTY_DBADJAMT , dbadjamt_ ); 
            rs.updateDouble(PROPERTY_CRADJAMT , cradjamt_ ); 
            rs.updateLong(PROPERTY_ENTRYSTS , entrysts_ ); 
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
        Ar_rcpd obj = (Ar_rcpd) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          linenum_ = obj.getlinenum();
          custmrcode_ = obj.getcustmrcode();
          docnum_ = obj.getdocnum();
          payamt_ = obj.getpayamt();
          discamt_ = obj.getdiscamt();
          adjustamt_ = obj.getadjustamt();
          adjustno_ = obj.getadjustno();
          textajust_ = obj.gettextajust();
          glreff_ = obj.getglreff();
          docnumppd_ = obj.getdocnumppd();
          dbadjamt_ = obj.getdbadjamt();
          cradjamt_ = obj.getcradjamt();
          entrysts_ = obj.getentrysts();
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

    
      public void setbatchno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchno_ = param; 
         _isDirty_ = true; 
      } 

      public long getbatchno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchno_; 
      } 

      public void setdocentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getdocentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docentry_; 
      } 

      public void setlinenum(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         linenum_ = param; 
         _isDirty_ = true; 
      } 

      public long getlinenum() throws CodeException {
         if (!_isLoaded_) { read();} 
         return linenum_; 
      } 

      public void setcustmrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custmrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustmrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custmrcode_; 
      } 

      public void setdocnum(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnum_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnum() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnum_; 
      } 

      public void setpayamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpayamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payamt_; 
      } 

      public void setdiscamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdiscamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discamt_; 
      } 

      public void setadjustamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjustamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjustamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjustamt_; 
      } 

      public void setadjustno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjustno_ = param; 
         _isDirty_ = true; 
      } 

      public long getadjustno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjustno_; 
      } 

      public void settextajust(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         textajust_ = param; 
         _isDirty_ = true; 
      } 

      public String gettextajust() throws CodeException {
         if (!_isLoaded_) { read();} 
         return textajust_; 
      } 

      public void setglreff(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glreff_ = param; 
         _isDirty_ = true; 
      } 

      public String getglreff() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glreff_; 
      } 

      public void setdocnumppd(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnumppd_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnumppd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnumppd_; 
      } 

      public void setdbadjamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dbadjamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdbadjamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dbadjamt_; 
      } 

      public void setcradjamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cradjamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getcradjamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cradjamt_; 
      } 

      public void setentrysts(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrysts_ = param; 
         _isDirty_ = true; 
      } 

      public long getentrysts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrysts_; 
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
        
           else if (param.equals(PROPERTY_BATCHNO)) return String.valueOf(getbatchno()); 
           else if (param.equals(PROPERTY_DOCENTRY)) return String.valueOf(getdocentry()); 
           else if (param.equals(PROPERTY_LINENUM)) return String.valueOf(getlinenum()); 
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getcustmrcode(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_PAYAMT)) return decform.format(getpayamt()); 
           else if (param.equals(PROPERTY_DISCAMT)) return decform.format(getdiscamt()); 
           else if (param.equals(PROPERTY_ADJUSTAMT)) return decform.format(getadjustamt()); 
           else if (param.equals(PROPERTY_ADJUSTNO)) return String.valueOf(getadjustno()); 
           else if (param.equals(PROPERTY_TEXTAJUST)) return gettextajust(); 
           else if (param.equals(PROPERTY_GLREFF)) return getglreff(); 
           else if (param.equals(PROPERTY_DOCNUMPPD)) return getdocnumppd(); 
           else if (param.equals(PROPERTY_DBADJAMT)) return decform.format(getdbadjamt()); 
           else if (param.equals(PROPERTY_CRADJAMT)) return decform.format(getcradjamt()); 
           else if (param.equals(PROPERTY_ENTRYSTS)) return String.valueOf(getentrysts()); 
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
        
           else if (param.equals(PROPERTY_BATCHNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbatchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdocentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LINENUM)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlinenum(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CUSTMRCODE))  setcustmrcode(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_PAYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpayamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdiscamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJUSTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjustamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJUSTNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setadjustno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TEXTAJUST))  settextajust(value); 
           else if (param.equals(PROPERTY_GLREFF))  setglreff(value); 
           else if (param.equals(PROPERTY_DOCNUMPPD))  setdocnumppd(value); 
           else if (param.equals(PROPERTY_DBADJAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdbadjamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CRADJAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcradjamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYSTS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setentrysts(newVal); 
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
            throw new CodeException("Ar_rcpd : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_rcpd : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_rcpd : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_rcpd : Cannot Move Last " + ex.getMessage());
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



