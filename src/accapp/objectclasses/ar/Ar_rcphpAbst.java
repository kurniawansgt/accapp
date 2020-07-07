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


public abstract class Ar_rcphpAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_rcphp";

    public static final String TABLE = "ar_rcphp";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_PAYENTCNT = "payentcnt";
    public static final String PROPERTY_PAYTOTAMT = "paytotamt";
    public static final String PROPERTY_DISCTOTAMT = "disctotamt";
    public static final String PROPERTY_ADJTOTAMT = "adjtotamt";
    public static final String PROPERTY_ADJCNT = "adjcnt";
    public static final String PROPERTY_ADJTXT = "adjtxt";
    public static final String PROPERTY_GLREFF = "glreff";
    public static final String PROPERTY_DOCNUMPPD = "docnumppd";
    public static final String PROPERTY_DEBADJAMT = "debadjamt";
    public static final String PROPERTY_CRDADJAMT = "crdadjamt";
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
    private String custmrcode_;
    private String docnum_;
    private long payentcnt_;
    private double paytotamt_;
    private double disctotamt_;
    private double adjtotamt_;
    private long adjcnt_;
    private String adjtxt_;
    private String glreff_;
    private String docnumppd_;
    private double debadjamt_;
    private double crdadjamt_;
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

    public Ar_rcphpAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_rcphpAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_rcphpAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_rcphpAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_rcphpAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_rcphpAbst for Key : " + key + " val : " + val);
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
           custmrcode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           payentcnt_ = rs.getLong(PROPERTY_PAYENTCNT); 
           paytotamt_ = rs.getDouble(PROPERTY_PAYTOTAMT); 
           disctotamt_ = rs.getDouble(PROPERTY_DISCTOTAMT); 
           adjtotamt_ = rs.getDouble(PROPERTY_ADJTOTAMT); 
           adjcnt_ = rs.getLong(PROPERTY_ADJCNT); 
           adjtxt_ = rs.getString(PROPERTY_ADJTXT); 
           glreff_ = rs.getString(PROPERTY_GLREFF); 
           docnumppd_ = rs.getString(PROPERTY_DOCNUMPPD); 
           debadjamt_ = rs.getDouble(PROPERTY_DEBADJAMT); 
           crdadjamt_ = rs.getDouble(PROPERTY_CRDADJAMT); 
           entrysts_ = rs.getLong(PROPERTY_ENTRYSTS); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_rcphpAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_rcphp obj = (Ar_rcphp)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_rcphp " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_rcphp ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_rcphp " + e.getMessage());
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
            rs.updateString(PROPERTY_CUSTMRCODE , custmrcode_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateLong(PROPERTY_PAYENTCNT , payentcnt_ ); 
            rs.updateDouble(PROPERTY_PAYTOTAMT , paytotamt_ ); 
            rs.updateDouble(PROPERTY_DISCTOTAMT , disctotamt_ ); 
            rs.updateDouble(PROPERTY_ADJTOTAMT , adjtotamt_ ); 
            rs.updateLong(PROPERTY_ADJCNT , adjcnt_ ); 
            rs.updateString(PROPERTY_ADJTXT , adjtxt_ ); 
            rs.updateString(PROPERTY_GLREFF , glreff_ ); 
            rs.updateString(PROPERTY_DOCNUMPPD , docnumppd_ ); 
            rs.updateDouble(PROPERTY_DEBADJAMT , debadjamt_ ); 
            rs.updateDouble(PROPERTY_CRDADJAMT , crdadjamt_ ); 
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
        Ar_rcphp obj = (Ar_rcphp) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          custmrcode_ = obj.getcustmrcode();
          docnum_ = obj.getdocnum();
          payentcnt_ = obj.getpayentcnt();
          paytotamt_ = obj.getpaytotamt();
          disctotamt_ = obj.getdisctotamt();
          adjtotamt_ = obj.getadjtotamt();
          adjcnt_ = obj.getadjcnt();
          adjtxt_ = obj.getadjtxt();
          glreff_ = obj.getglreff();
          docnumppd_ = obj.getdocnumppd();
          debadjamt_ = obj.getdebadjamt();
          crdadjamt_ = obj.getcrdadjamt();
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

      public void setpayentcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payentcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getpayentcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payentcnt_; 
      } 

      public void setpaytotamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paytotamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpaytotamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paytotamt_; 
      } 

      public void setdisctotamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         disctotamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdisctotamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return disctotamt_; 
      } 

      public void setadjtotamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtotamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjtotamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtotamt_; 
      } 

      public void setadjcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getadjcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjcnt_; 
      } 

      public void setadjtxt(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtxt_ = param; 
         _isDirty_ = true; 
      } 

      public String getadjtxt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtxt_; 
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

      public void setdebadjamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         debadjamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdebadjamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return debadjamt_; 
      } 

      public void setcrdadjamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         crdadjamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getcrdadjamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return crdadjamt_; 
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
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getcustmrcode(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_PAYENTCNT)) return String.valueOf(getpayentcnt()); 
           else if (param.equals(PROPERTY_PAYTOTAMT)) return decform.format(getpaytotamt()); 
           else if (param.equals(PROPERTY_DISCTOTAMT)) return decform.format(getdisctotamt()); 
           else if (param.equals(PROPERTY_ADJTOTAMT)) return decform.format(getadjtotamt()); 
           else if (param.equals(PROPERTY_ADJCNT)) return String.valueOf(getadjcnt()); 
           else if (param.equals(PROPERTY_ADJTXT)) return getadjtxt(); 
           else if (param.equals(PROPERTY_GLREFF)) return getglreff(); 
           else if (param.equals(PROPERTY_DOCNUMPPD)) return getdocnumppd(); 
           else if (param.equals(PROPERTY_DEBADJAMT)) return decform.format(getdebadjamt()); 
           else if (param.equals(PROPERTY_CRDADJAMT)) return decform.format(getcrdadjamt()); 
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
           else if (param.equals(PROPERTY_CUSTMRCODE))  setcustmrcode(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_PAYENTCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setpayentcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PAYTOTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpaytotamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCTOTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdisctotamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJTOTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjtotamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setadjcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJTXT))  setadjtxt(value); 
           else if (param.equals(PROPERTY_GLREFF))  setglreff(value); 
           else if (param.equals(PROPERTY_DOCNUMPPD))  setdocnumppd(value); 
           else if (param.equals(PROPERTY_DEBADJAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdebadjamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CRDADJAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcrdadjamt(newVal); 
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
            throw new CodeException("Ar_rcphp : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_rcphp : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_rcphp : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_rcphp : Cannot Move Last " + ex.getMessage());
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



