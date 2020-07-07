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


public abstract class Ap_vendorAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ap_vendor";

    public static final String TABLE = "ap_vendor";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VENDCODE = "vendcode";
    public static final String PROPERTY_VENDNAME = "vendname";
    public static final String PROPERTY_NOTES = "notes";
    public static final String PROPERTY_BALANCEAMT = "balanceamt";
    public static final String PROPERTY_INVOSAMT = "invosamt";
    public static final String PROPERTY_INVOSCNT = "invoscnt";
    public static final String PROPERTY_PPMOAMT = "ppmoamt";
    public static final String PROPERTY_PPMOCNT = "ppmocnt";
    public static final String PROPERTY_ORDERSBALAMT = "ordersbalamt";
    public static final String PROPERTY_CREDLIMITAMT = "credlimitamt";
    public static final String PROPERTY_GRPCODE = "grpcode";
    public static final String PROPERTY_ACCSETCODE = "accsetcode";
    public static final String PROPERTY_TERMCODE = "termcode";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_DISTBY = "distby";
    public static final String PROPERTY_DISTCODE = "distcode";
    public static final String PROPERTY_GLACCCODE = "glacccode";
    public static final String PROPERTY_DISTSETCODE = "distsetcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_HOLD = "hold";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_REGDATE = "regdate";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_VENDCODE;
    
    
    private long id_;
    private String vendcode_;
    private String vendname_;
    private String notes_;
    private double balanceamt_;
    private double invosamt_;
    private long invoscnt_;
    private double ppmoamt_;
    private double ppmocnt_;
    private double ordersbalamt_;
    private double credlimitamt_;
    private String grpcode_;
    private String accsetcode_;
    private String termcode_;
    private String ratetype_;
    private String taxcode_;
    private String bankcode_;
    private long distby_;
    private String distcode_;
    private String glacccode_;
    private String distsetcode_;
    private String curnccode_;
    private long hold_;
    private long active_;
    private Date regdate_;
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

    public Ap_vendorAbst() throws CodeException {
        loadNew();
    }
    
    public Ap_vendorAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ap_vendorAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ap_vendorAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ap_vendorAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ap_vendorAbst for Key : " + key + " val : " + val);
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
            
            
            
           vendcode_ = rs.getString(PROPERTY_VENDCODE); 
           vendname_ = rs.getString(PROPERTY_VENDNAME); 
           notes_ = rs.getString(PROPERTY_NOTES); 
           balanceamt_ = rs.getDouble(PROPERTY_BALANCEAMT); 
           invosamt_ = rs.getDouble(PROPERTY_INVOSAMT); 
           invoscnt_ = rs.getLong(PROPERTY_INVOSCNT); 
           ppmoamt_ = rs.getDouble(PROPERTY_PPMOAMT); 
           ppmocnt_ = rs.getDouble(PROPERTY_PPMOCNT); 
           ordersbalamt_ = rs.getDouble(PROPERTY_ORDERSBALAMT); 
           credlimitamt_ = rs.getDouble(PROPERTY_CREDLIMITAMT); 
           grpcode_ = rs.getString(PROPERTY_GRPCODE); 
           accsetcode_ = rs.getString(PROPERTY_ACCSETCODE); 
           termcode_ = rs.getString(PROPERTY_TERMCODE); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           distby_ = rs.getLong(PROPERTY_DISTBY); 
           distcode_ = rs.getString(PROPERTY_DISTCODE); 
           glacccode_ = rs.getString(PROPERTY_GLACCCODE); 
           distsetcode_ = rs.getString(PROPERTY_DISTSETCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           hold_ = rs.getLong(PROPERTY_HOLD); 
           active_ = rs.getLong(PROPERTY_ACTIVE); 
           regdate_ = rs.getDate(PROPERTY_REGDATE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ap_vendorAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ap_vendor obj = (Ap_vendor)cache.get(getID());
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
                    throw new CodeException("Error Reading Ap_vendor " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getvendcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : vendcode can not be Empty"); 
        } 
 
         o = getvendname(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : vendname can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from ap_vendor ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ap_vendor " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_VENDCODE , vendcode_ ); 
            rs.updateString(PROPERTY_VENDNAME , vendname_ ); 
            rs.updateString(PROPERTY_NOTES , notes_ ); 
            rs.updateDouble(PROPERTY_BALANCEAMT , balanceamt_ ); 
            rs.updateDouble(PROPERTY_INVOSAMT , invosamt_ ); 
            rs.updateLong(PROPERTY_INVOSCNT , invoscnt_ ); 
            rs.updateDouble(PROPERTY_PPMOAMT , ppmoamt_ ); 
            rs.updateDouble(PROPERTY_PPMOCNT , ppmocnt_ ); 
            rs.updateDouble(PROPERTY_ORDERSBALAMT , ordersbalamt_ ); 
            rs.updateDouble(PROPERTY_CREDLIMITAMT , credlimitamt_ ); 
            rs.updateString(PROPERTY_GRPCODE , grpcode_ ); 
            rs.updateString(PROPERTY_ACCSETCODE , accsetcode_ ); 
            rs.updateString(PROPERTY_TERMCODE , termcode_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateLong(PROPERTY_DISTBY , distby_ ); 
            rs.updateString(PROPERTY_DISTCODE , distcode_ ); 
            rs.updateString(PROPERTY_GLACCCODE , glacccode_ ); 
            rs.updateString(PROPERTY_DISTSETCODE , distsetcode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateLong(PROPERTY_HOLD , hold_ ); 
            rs.updateLong(PROPERTY_ACTIVE , active_ ); 
           if (getregdate()==null) {
              rs.updateDate(PROPERTY_REGDATE , null ); 
           }else{
              rs.updateDate(PROPERTY_REGDATE , getregdate()); 
           }
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
        Ap_vendor obj = (Ap_vendor) jCob;
        id_ = obj.getID();

        
          vendcode_ = obj.getvendcode();
          vendname_ = obj.getvendname();
          notes_ = obj.getnotes();
          balanceamt_ = obj.getbalanceamt();
          invosamt_ = obj.getinvosamt();
          invoscnt_ = obj.getinvoscnt();
          ppmoamt_ = obj.getppmoamt();
          ppmocnt_ = obj.getppmocnt();
          ordersbalamt_ = obj.getordersbalamt();
          credlimitamt_ = obj.getcredlimitamt();
          grpcode_ = obj.getgrpcode();
          accsetcode_ = obj.getaccsetcode();
          termcode_ = obj.gettermcode();
          ratetype_ = obj.getratetype();
          taxcode_ = obj.gettaxcode();
          bankcode_ = obj.getbankcode();
          distby_ = obj.getdistby();
          distcode_ = obj.getdistcode();
          glacccode_ = obj.getglacccode();
          distsetcode_ = obj.getdistsetcode();
          curnccode_ = obj.getcurnccode();
          hold_ = obj.gethold();
          active_ = obj.getactive();
          regdate_ = obj.getregdate();
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

    
      public void setvendcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         vendcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getvendcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return vendcode_; 
      } 

      public void setvendname(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         vendname_ = param; 
         _isDirty_ = true; 
      } 

      public String getvendname() throws CodeException {
         if (!_isLoaded_) { read();} 
         return vendname_; 
      } 

      public void setnotes(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         notes_ = param; 
         _isDirty_ = true; 
      } 

      public String getnotes() throws CodeException {
         if (!_isLoaded_) { read();} 
         return notes_; 
      } 

      public void setbalanceamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         balanceamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getbalanceamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return balanceamt_; 
      } 

      public void setinvosamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invosamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getinvosamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invosamt_; 
      } 

      public void setinvoscnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invoscnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getinvoscnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invoscnt_; 
      } 

      public void setppmoamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ppmoamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getppmoamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ppmoamt_; 
      } 

      public void setppmocnt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ppmocnt_ = param; 
         _isDirty_ = true; 
      } 

      public double getppmocnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ppmocnt_; 
      } 

      public void setordersbalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ordersbalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getordersbalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ordersbalamt_; 
      } 

      public void setcredlimitamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         credlimitamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getcredlimitamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return credlimitamt_; 
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

      public void setaccsetcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsetcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsetcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsetcode_; 
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

      public void setglacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getglacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glacccode_; 
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

      public void setcurnccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         curnccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcurnccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return curnccode_; 
      } 

      public void sethold(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         hold_ = param; 
         _isDirty_ = true; 
      } 

      public long gethold() throws CodeException {
         if (!_isLoaded_) { read();} 
         return hold_; 
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

      public void setregdate(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         regdate_ = param; 
         _isDirty_ = true; 
      } 

      public Date getregdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return regdate_; 
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
        
           else if (param.equals(PROPERTY_VENDCODE)) return getvendcode(); 
           else if (param.equals(PROPERTY_VENDNAME)) return getvendname(); 
           else if (param.equals(PROPERTY_NOTES)) return getnotes(); 
           else if (param.equals(PROPERTY_BALANCEAMT)) return decform.format(getbalanceamt()); 
           else if (param.equals(PROPERTY_INVOSAMT)) return decform.format(getinvosamt()); 
           else if (param.equals(PROPERTY_INVOSCNT)) return String.valueOf(getinvoscnt()); 
           else if (param.equals(PROPERTY_PPMOAMT)) return decform.format(getppmoamt()); 
           else if (param.equals(PROPERTY_PPMOCNT)) return decform.format(getppmocnt()); 
           else if (param.equals(PROPERTY_ORDERSBALAMT)) return decform.format(getordersbalamt()); 
           else if (param.equals(PROPERTY_CREDLIMITAMT)) return decform.format(getcredlimitamt()); 
           else if (param.equals(PROPERTY_GRPCODE)) return getgrpcode(); 
           else if (param.equals(PROPERTY_ACCSETCODE)) return getaccsetcode(); 
           else if (param.equals(PROPERTY_TERMCODE)) return gettermcode(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_DISTBY)) return String.valueOf(getdistby()); 
           else if (param.equals(PROPERTY_DISTCODE)) return getdistcode(); 
           else if (param.equals(PROPERTY_GLACCCODE)) return getglacccode(); 
           else if (param.equals(PROPERTY_DISTSETCODE)) return getdistsetcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_HOLD)) return String.valueOf(gethold()); 
           else if (param.equals(PROPERTY_ACTIVE)) return String.valueOf(getactive()); 
           else if (param.equals(PROPERTY_REGDATE)) return getregdate()  == null ? "" :dateformat.format(getregdate()); 
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
        
           else if (param.equals(PROPERTY_VENDCODE))  setvendcode(value); 
           else if (param.equals(PROPERTY_VENDNAME))  setvendname(value); 
           else if (param.equals(PROPERTY_NOTES))  setnotes(value); 
           else if (param.equals(PROPERTY_BALANCEAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbalanceamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVOSAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinvosamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVOSCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setinvoscnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PPMOAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setppmoamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PPMOCNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setppmocnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ORDERSBALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setordersbalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CREDLIMITAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcredlimitamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GRPCODE))  setgrpcode(value); 
           else if (param.equals(PROPERTY_ACCSETCODE))  setaccsetcode(value); 
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
           else if (param.equals(PROPERTY_GLACCCODE))  setglacccode(value); 
           else if (param.equals(PROPERTY_DISTSETCODE))  setdistsetcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_HOLD)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          sethold(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACTIVE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setactive(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_REGDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setregdate(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setregdate(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
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
            throw new CodeException("Ap_vendor : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, vendcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_vendor : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, vendcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_vendor : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ap_vendor : Cannot Move Last " + ex.getMessage());
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



