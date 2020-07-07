/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.cashbook;


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


public abstract class Cb_cash_advanceAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_cash_advance";

    public static final String TABLE = "cb_cash_advance";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BASE_BATCHNO = "base_batchno";
    public static final String PROPERTY_BASE_ENTRYNO = "base_entryno";
    public static final String PROPERTY_BASE_DETAILNO = "base_detailno";
    public static final String PROPERTY_ADVANCE_NO = "advance_no";
    public static final String PROPERTY_ADVANCE_REF_NO = "advance_ref_no";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_ADVANCE_DATE = "advance_date";
    public static final String PROPERTY_ADVANCE_STATUS = "advance_status";
    public static final String PROPERTY_ADVANCE_PIC = "advance_pic";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_ADVANCE_AMOUNT = "advance_amount";
    public static final String PROPERTY_ADVANCE_APPLY = "advance_apply";
    public static final String PROPERTY_ADVANCE_BALANCE = "advance_balance";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    public static final String PROPERTY_ACCCODE = "acccode";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double base_batchno_;
    private long base_entryno_;
    private long base_detailno_;
    private String advance_no_;
    private String advance_ref_no_;
    private long yop_;
    private long mop_;
    private String advance_date_;
    private String advance_status_;
    private String advance_pic_;
    private String dscription_;
    private double advance_amount_;
    private double advance_apply_;
    private double advance_balance_;
    private long objtype_;
    private String entrydate_;
    private String auditdate_;
    private String audituser_;
    private String cmpnyid_;
    private String acccode_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Cb_cash_advanceAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_cash_advanceAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_cash_advanceAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_cash_advanceAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_cash_advanceAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_cash_advanceAbst for Key : " + key + " val : " + val);
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
            
            
            
           base_batchno_ = rs.getDouble(PROPERTY_BASE_BATCHNO); 
           base_entryno_ = rs.getLong(PROPERTY_BASE_ENTRYNO); 
           base_detailno_ = rs.getLong(PROPERTY_BASE_DETAILNO); 
           advance_no_ = rs.getString(PROPERTY_ADVANCE_NO); 
           advance_ref_no_ = rs.getString(PROPERTY_ADVANCE_REF_NO); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           advance_date_ = rs.getString(PROPERTY_ADVANCE_DATE); 
           advance_status_ = rs.getString(PROPERTY_ADVANCE_STATUS); 
           advance_pic_ = rs.getString(PROPERTY_ADVANCE_PIC); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           advance_amount_ = rs.getDouble(PROPERTY_ADVANCE_AMOUNT); 
           advance_apply_ = rs.getDouble(PROPERTY_ADVANCE_APPLY); 
           advance_balance_ = rs.getDouble(PROPERTY_ADVANCE_BALANCE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
           acccode_ = rs.getString(PROPERTY_ACCCODE); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_cash_advanceAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_cash_advance obj = (Cb_cash_advance)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_cash_advance " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbase_batchno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : base_batchno can not be Empty"); 
        } 
 
         o = getbase_entryno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : base_entryno can not be Empty"); 
        } 
 
         o = getacccode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : acccode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_cash_advance ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_cash_advance " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BASE_BATCHNO , base_batchno_ ); 
            rs.updateLong(PROPERTY_BASE_ENTRYNO , base_entryno_ ); 
            rs.updateLong(PROPERTY_BASE_DETAILNO , base_detailno_ ); 
            rs.updateString(PROPERTY_ADVANCE_NO , advance_no_ ); 
            rs.updateString(PROPERTY_ADVANCE_REF_NO , advance_ref_no_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_ADVANCE_DATE , advance_date_ ); 
            rs.updateString(PROPERTY_ADVANCE_STATUS , advance_status_ ); 
            rs.updateString(PROPERTY_ADVANCE_PIC , advance_pic_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateDouble(PROPERTY_ADVANCE_AMOUNT , advance_amount_ ); 
            rs.updateDouble(PROPERTY_ADVANCE_APPLY , advance_apply_ ); 
            rs.updateDouble(PROPERTY_ADVANCE_BALANCE , advance_balance_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditdate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
            rs.updateString(PROPERTY_ACCCODE , acccode_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Cb_cash_advance obj = (Cb_cash_advance) jCob;
        id_ = obj.getID();

        
          base_batchno_ = obj.getbase_batchno();
          base_entryno_ = obj.getbase_entryno();
          base_detailno_ = obj.getbase_detailno();
          advance_no_ = obj.getadvance_no();
          advance_ref_no_ = obj.getadvance_ref_no();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          advance_date_ = obj.getadvance_date();
          advance_status_ = obj.getadvance_status();
          advance_pic_ = obj.getadvance_pic();
          dscription_ = obj.getdscription();
          advance_amount_ = obj.getadvance_amount();
          advance_apply_ = obj.getadvance_apply();
          advance_balance_ = obj.getadvance_balance();
          objtype_ = obj.getobjtype();
          entrydate_ = obj.getentrydate();
          auditdate_ = obj.getauditdate();
          audituser_ = obj.getaudituser();
          cmpnyid_ = obj.getcmpnyid();
          acccode_ = obj.getacccode();
                
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

    
      public void setbase_batchno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         base_batchno_ = param; 
         _isDirty_ = true; 
      } 

      public double getbase_batchno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return base_batchno_; 
      } 

      public void setbase_entryno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         base_entryno_ = param; 
         _isDirty_ = true; 
      } 

      public long getbase_entryno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return base_entryno_; 
      } 

      public void setbase_detailno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         base_detailno_ = param; 
         _isDirty_ = true; 
      } 

      public long getbase_detailno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return base_detailno_; 
      } 

      public void setadvance_no(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_no_ = param; 
         _isDirty_ = true; 
      } 

      public String getadvance_no() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_no_; 
      } 

      public void setadvance_ref_no(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_ref_no_ = param; 
         _isDirty_ = true; 
      } 

      public String getadvance_ref_no() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_ref_no_; 
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

      public void setadvance_date(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_date_ = param; 
         _isDirty_ = true; 
      } 

      public String getadvance_date() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_date_; 
      } 

      public void setadvance_status(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_status_ = param; 
         _isDirty_ = true; 
      } 

      public String getadvance_status() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_status_; 
      } 

      public void setadvance_pic(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_pic_ = param; 
         _isDirty_ = true; 
      } 

      public String getadvance_pic() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_pic_; 
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

      public void setadvance_amount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_amount_ = param; 
         _isDirty_ = true; 
      } 

      public double getadvance_amount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_amount_; 
      } 

      public void setadvance_apply(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_apply_ = param; 
         _isDirty_ = true; 
      } 

      public double getadvance_apply() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_apply_; 
      } 

      public void setadvance_balance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         advance_balance_ = param; 
         _isDirty_ = true; 
      } 

      public double getadvance_balance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return advance_balance_; 
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

      public void setacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccode_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_BASE_BATCHNO)) return decform.format(getbase_batchno()); 
           else if (param.equals(PROPERTY_BASE_ENTRYNO)) return String.valueOf(getbase_entryno()); 
           else if (param.equals(PROPERTY_BASE_DETAILNO)) return String.valueOf(getbase_detailno()); 
           else if (param.equals(PROPERTY_ADVANCE_NO)) return getadvance_no(); 
           else if (param.equals(PROPERTY_ADVANCE_REF_NO)) return getadvance_ref_no(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_ADVANCE_DATE)) return getadvance_date(); 
           else if (param.equals(PROPERTY_ADVANCE_STATUS)) return getadvance_status(); 
           else if (param.equals(PROPERTY_ADVANCE_PIC)) return getadvance_pic(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_ADVANCE_AMOUNT)) return decform.format(getadvance_amount()); 
           else if (param.equals(PROPERTY_ADVANCE_APPLY)) return decform.format(getadvance_apply()); 
           else if (param.equals(PROPERTY_ADVANCE_BALANCE)) return decform.format(getadvance_balance()); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype()); 
           else if (param.equals(PROPERTY_ENTRYDATE)) return getentrydate(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditdate(); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getaudituser(); 
           else if (param.equals(PROPERTY_CMPNYID)) return getcmpnyid(); 
           else if (param.equals(PROPERTY_ACCCODE)) return getacccode(); 
       
        
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
        
           else if (param.equals(PROPERTY_BASE_BATCHNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbase_batchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BASE_ENTRYNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbase_entryno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BASE_DETAILNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbase_detailno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADVANCE_NO))  setadvance_no(value); 
           else if (param.equals(PROPERTY_ADVANCE_REF_NO))  setadvance_ref_no(value); 
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
           else if (param.equals(PROPERTY_ADVANCE_DATE))  setadvance_date(value); 
           else if (param.equals(PROPERTY_ADVANCE_STATUS))  setadvance_status(value); 
           else if (param.equals(PROPERTY_ADVANCE_PIC))  setadvance_pic(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_ADVANCE_AMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadvance_amount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADVANCE_APPLY)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadvance_apply(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADVANCE_BALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadvance_balance(newVal); 
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
           else if (param.equals(PROPERTY_ACCCODE))  setacccode(value); 
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
            throw new CodeException("Cb_cash_advance : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Cb_cash_advance : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Cb_cash_advance : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_cash_advance : Cannot Move Last " + ex.getMessage());
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



