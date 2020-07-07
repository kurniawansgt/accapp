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


public abstract class Ar_custgrpstsAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_custgrpsts";

    public static final String TABLE = "ar_custgrpsts";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_GRPCODE = "grpcode";
    public static final String PROPERTY_INVCNT = "invcnt";
    public static final String PROPERTY_PAYCNT = "paycnt";
    public static final String PROPERTY_DISCCNT = "disccnt";
    public static final String PROPERTY_CNCNT = "cncnt";
    public static final String PROPERTY_DNCNT = "dncnt";
    public static final String PROPERTY_ADJCNT = "adjcnt";
    public static final String PROPERTY_WROFFCNT = "wroffcnt";
    public static final String PROPERTY_INTTCNT = "inttcnt";
    public static final String PROPERTY_RTRCHCKCNT = "rtrchckcnt";
    public static final String PROPERTY_INVPAIDCNT = "invpaidcnt";
    public static final String PROPERTY_INVAMT = "invamt";
    public static final String PROPERTY_PAYAMT = "payamt";
    public static final String PROPERTY_DISCAMT = "discamt";
    public static final String PROPERTY_CNAMT = "cnamt";
    public static final String PROPERTY_DNAMT = "dnamt";
    public static final String PROPERTY_ADJAMT = "adjamt";
    public static final String PROPERTY_WROFFAMT = "wroffamt";
    public static final String PROPERTY_INTTAMT = "inttamt";
    public static final String PROPERTY_RTRCHCKAMT = "rtrchckamt";
    public static final String PROPERTY_INVPAIDAMT = "invpaidamt";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long yop_;
    private long mop_;
    private String grpcode_;
    private long invcnt_;
    private long paycnt_;
    private long disccnt_;
    private long cncnt_;
    private long dncnt_;
    private long adjcnt_;
    private long wroffcnt_;
    private long inttcnt_;
    private long rtrchckcnt_;
    private long invpaidcnt_;
    private double invamt_;
    private double payamt_;
    private double discamt_;
    private double cnamt_;
    private double dnamt_;
    private double adjamt_;
    private double wroffamt_;
    private double inttamt_;
    private double rtrchckamt_;
    private double invpaidamt_;
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

    public Ar_custgrpstsAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_custgrpstsAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_custgrpstsAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_custgrpstsAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_custgrpstsAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_custgrpstsAbst for Key : " + key + " val : " + val);
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
            
            
            
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           grpcode_ = rs.getString(PROPERTY_GRPCODE); 
           invcnt_ = rs.getLong(PROPERTY_INVCNT); 
           paycnt_ = rs.getLong(PROPERTY_PAYCNT); 
           disccnt_ = rs.getLong(PROPERTY_DISCCNT); 
           cncnt_ = rs.getLong(PROPERTY_CNCNT); 
           dncnt_ = rs.getLong(PROPERTY_DNCNT); 
           adjcnt_ = rs.getLong(PROPERTY_ADJCNT); 
           wroffcnt_ = rs.getLong(PROPERTY_WROFFCNT); 
           inttcnt_ = rs.getLong(PROPERTY_INTTCNT); 
           rtrchckcnt_ = rs.getLong(PROPERTY_RTRCHCKCNT); 
           invpaidcnt_ = rs.getLong(PROPERTY_INVPAIDCNT); 
           invamt_ = rs.getDouble(PROPERTY_INVAMT); 
           payamt_ = rs.getDouble(PROPERTY_PAYAMT); 
           discamt_ = rs.getDouble(PROPERTY_DISCAMT); 
           cnamt_ = rs.getDouble(PROPERTY_CNAMT); 
           dnamt_ = rs.getDouble(PROPERTY_DNAMT); 
           adjamt_ = rs.getDouble(PROPERTY_ADJAMT); 
           wroffamt_ = rs.getDouble(PROPERTY_WROFFAMT); 
           inttamt_ = rs.getDouble(PROPERTY_INTTAMT); 
           rtrchckamt_ = rs.getDouble(PROPERTY_RTRCHCKAMT); 
           invpaidamt_ = rs.getDouble(PROPERTY_INVPAIDAMT); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_custgrpstsAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_custgrpsts obj = (Ar_custgrpsts)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_custgrpsts " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_custgrpsts ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_custgrpsts " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_GRPCODE , grpcode_ ); 
            rs.updateLong(PROPERTY_INVCNT , invcnt_ ); 
            rs.updateLong(PROPERTY_PAYCNT , paycnt_ ); 
            rs.updateLong(PROPERTY_DISCCNT , disccnt_ ); 
            rs.updateLong(PROPERTY_CNCNT , cncnt_ ); 
            rs.updateLong(PROPERTY_DNCNT , dncnt_ ); 
            rs.updateLong(PROPERTY_ADJCNT , adjcnt_ ); 
            rs.updateLong(PROPERTY_WROFFCNT , wroffcnt_ ); 
            rs.updateLong(PROPERTY_INTTCNT , inttcnt_ ); 
            rs.updateLong(PROPERTY_RTRCHCKCNT , rtrchckcnt_ ); 
            rs.updateLong(PROPERTY_INVPAIDCNT , invpaidcnt_ ); 
            rs.updateDouble(PROPERTY_INVAMT , invamt_ ); 
            rs.updateDouble(PROPERTY_PAYAMT , payamt_ ); 
            rs.updateDouble(PROPERTY_DISCAMT , discamt_ ); 
            rs.updateDouble(PROPERTY_CNAMT , cnamt_ ); 
            rs.updateDouble(PROPERTY_DNAMT , dnamt_ ); 
            rs.updateDouble(PROPERTY_ADJAMT , adjamt_ ); 
            rs.updateDouble(PROPERTY_WROFFAMT , wroffamt_ ); 
            rs.updateDouble(PROPERTY_INTTAMT , inttamt_ ); 
            rs.updateDouble(PROPERTY_RTRCHCKAMT , rtrchckamt_ ); 
            rs.updateDouble(PROPERTY_INVPAIDAMT , invpaidamt_ ); 
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
        Ar_custgrpsts obj = (Ar_custgrpsts) jCob;
        id_ = obj.getID();

        
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          grpcode_ = obj.getgrpcode();
          invcnt_ = obj.getinvcnt();
          paycnt_ = obj.getpaycnt();
          disccnt_ = obj.getdisccnt();
          cncnt_ = obj.getcncnt();
          dncnt_ = obj.getdncnt();
          adjcnt_ = obj.getadjcnt();
          wroffcnt_ = obj.getwroffcnt();
          inttcnt_ = obj.getinttcnt();
          rtrchckcnt_ = obj.getrtrchckcnt();
          invpaidcnt_ = obj.getinvpaidcnt();
          invamt_ = obj.getinvamt();
          payamt_ = obj.getpayamt();
          discamt_ = obj.getdiscamt();
          cnamt_ = obj.getcnamt();
          dnamt_ = obj.getdnamt();
          adjamt_ = obj.getadjamt();
          wroffamt_ = obj.getwroffamt();
          inttamt_ = obj.getinttamt();
          rtrchckamt_ = obj.getrtrchckamt();
          invpaidamt_ = obj.getinvpaidamt();
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

    
      public void setyop(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         yop_ = param; 
         _isDirty_ = true; 
      } 

      public long getyop() throws CodeException {
         if (!_isLoaded_) { read();} 
         return yop_; 
      } 

      public void setmop(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         mop_ = param; 
         _isDirty_ = true; 
      } 

      public long getmop() throws CodeException {
         if (!_isLoaded_) { read();} 
         return mop_; 
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

      public void setinvcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getinvcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invcnt_; 
      } 

      public void setpaycnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         paycnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getpaycnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return paycnt_; 
      } 

      public void setdisccnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         disccnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getdisccnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return disccnt_; 
      } 

      public void setcncnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cncnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getcncnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cncnt_; 
      } 

      public void setdncnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dncnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getdncnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dncnt_; 
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

      public void setwroffcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         wroffcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getwroffcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return wroffcnt_; 
      } 

      public void setinttcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inttcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getinttcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inttcnt_; 
      } 

      public void setrtrchckcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rtrchckcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getrtrchckcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rtrchckcnt_; 
      } 

      public void setinvpaidcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invpaidcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getinvpaidcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invpaidcnt_; 
      } 

      public void setinvamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getinvamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invamt_; 
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

      public void setcnamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cnamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getcnamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cnamt_; 
      } 

      public void setdnamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dnamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdnamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dnamt_; 
      } 

      public void setadjamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjamt_; 
      } 

      public void setwroffamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         wroffamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getwroffamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return wroffamt_; 
      } 

      public void setinttamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inttamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getinttamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inttamt_; 
      } 

      public void setrtrchckamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rtrchckamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getrtrchckamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rtrchckamt_; 
      } 

      public void setinvpaidamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invpaidamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getinvpaidamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invpaidamt_; 
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
        
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_GRPCODE)) return getgrpcode(); 
           else if (param.equals(PROPERTY_INVCNT)) return String.valueOf(getinvcnt()); 
           else if (param.equals(PROPERTY_PAYCNT)) return String.valueOf(getpaycnt()); 
           else if (param.equals(PROPERTY_DISCCNT)) return String.valueOf(getdisccnt()); 
           else if (param.equals(PROPERTY_CNCNT)) return String.valueOf(getcncnt()); 
           else if (param.equals(PROPERTY_DNCNT)) return String.valueOf(getdncnt()); 
           else if (param.equals(PROPERTY_ADJCNT)) return String.valueOf(getadjcnt()); 
           else if (param.equals(PROPERTY_WROFFCNT)) return String.valueOf(getwroffcnt()); 
           else if (param.equals(PROPERTY_INTTCNT)) return String.valueOf(getinttcnt()); 
           else if (param.equals(PROPERTY_RTRCHCKCNT)) return String.valueOf(getrtrchckcnt()); 
           else if (param.equals(PROPERTY_INVPAIDCNT)) return String.valueOf(getinvpaidcnt()); 
           else if (param.equals(PROPERTY_INVAMT)) return decform.format(getinvamt()); 
           else if (param.equals(PROPERTY_PAYAMT)) return decform.format(getpayamt()); 
           else if (param.equals(PROPERTY_DISCAMT)) return decform.format(getdiscamt()); 
           else if (param.equals(PROPERTY_CNAMT)) return decform.format(getcnamt()); 
           else if (param.equals(PROPERTY_DNAMT)) return decform.format(getdnamt()); 
           else if (param.equals(PROPERTY_ADJAMT)) return decform.format(getadjamt()); 
           else if (param.equals(PROPERTY_WROFFAMT)) return decform.format(getwroffamt()); 
           else if (param.equals(PROPERTY_INTTAMT)) return decform.format(getinttamt()); 
           else if (param.equals(PROPERTY_RTRCHCKAMT)) return decform.format(getrtrchckamt()); 
           else if (param.equals(PROPERTY_INVPAIDAMT)) return decform.format(getinvpaidamt()); 
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
        
           else if (param.equals(PROPERTY_YOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setyop(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MOP)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setmop(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GRPCODE))  setgrpcode(value); 
           else if (param.equals(PROPERTY_INVCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setinvcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PAYCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setpaycnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdisccnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CNCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setcncnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DNCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdncnt(newVal); 
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
           else if (param.equals(PROPERTY_WROFFCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setwroffcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INTTCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setinttcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RTRCHCKCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrtrchckcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVPAIDCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setinvpaidcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinvamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
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
           else if (param.equals(PROPERTY_CNAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcnamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DNAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdnamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_WROFFAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setwroffamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INTTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinttamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RTRCHCKAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrtrchckamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVPAIDAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinvpaidamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
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
            throw new CodeException("Ar_custgrpsts : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_custgrpsts : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_custgrpsts : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_custgrpsts : Cannot Move Last " + ex.getMessage());
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



