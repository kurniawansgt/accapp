/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accapp.objectclasses.costapp;


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


public abstract class Costacc_wip_tempAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Costacc_wip_temp";

    public static final String TABLE = "bankjurnal.costacc_wip_temp";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_COST_DETAIL_ID = "cost_detail_id";
    public static final String PROPERTY_COST_DETAIL = "cost_detail";
    public static final String PROPERTY_PRODUKSI = "produksi";
    public static final String PROPERTY_PRODUKSIPCNT = "produksipcnt";
    public static final String PROPERTY_INVENTORY = "inventory";
    public static final String PROPERTY_INVENTORYPCNT = "inventorypcnt";
    public static final String PROPERTY_TOTAL_1 = "total_1";
    public static final String PROPERTY_SOACCRUED = "soaccrued";
    public static final String PROPERTY_VARIANCE = "variance";
    public static final String PROPERTY_TOTAL_2 = "total_2";
    public static final String PROPERTY_COGS = "cogs";
    public static final String PROPERTY_ACCRUED = "accrued";
    public static final String PROPERTY_TOTAL_3 = "total_3";
    public static final String PROPERTY_ISCOMPLETED = "iscompleted";
    public static final String PROPERTY_CREATEDATE = "createdate";
    public static final String PROPERTY_CREATEUSER = "createuser";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long yop_;
    private long mop_;
    private long cost_detail_id_;
    private String cost_detail_;
    private double produksi_;
    private double produksipcnt_;
    private double inventory_;
    private double inventorypcnt_;
    private double total_1_;
    private double soaccrued_;
    private double variance_;
    private double total_2_;
    private double cogs_;
    private double accrued_;
    private double total_3_;
    private String iscompleted_;
    private Date createdate_;
    private String createuser_;
    private Date auditdate_;
    private String audituser_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Costacc_wip_tempAbst() throws CodeException {
        loadNew();
    }
    
    public Costacc_wip_tempAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Costacc_wip_tempAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Costacc_wip_tempAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Costacc_wip_tempAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Costacc_wip_tempAbst for Key : " + key + " val : " + val);
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
           cost_detail_id_ = rs.getLong(PROPERTY_COST_DETAIL_ID); 
           cost_detail_ = rs.getString(PROPERTY_COST_DETAIL); 
           produksi_ = rs.getDouble(PROPERTY_PRODUKSI); 
           produksipcnt_ = rs.getDouble(PROPERTY_PRODUKSIPCNT); 
           inventory_ = rs.getDouble(PROPERTY_INVENTORY); 
           inventorypcnt_ = rs.getDouble(PROPERTY_INVENTORYPCNT); 
           total_1_ = rs.getDouble(PROPERTY_TOTAL_1); 
           soaccrued_ = rs.getDouble(PROPERTY_SOACCRUED); 
           variance_ = rs.getDouble(PROPERTY_VARIANCE); 
           total_2_ = rs.getDouble(PROPERTY_TOTAL_2); 
           cogs_ = rs.getDouble(PROPERTY_COGS); 
           accrued_ = rs.getDouble(PROPERTY_ACCRUED); 
           total_3_ = rs.getDouble(PROPERTY_TOTAL_3); 
           iscompleted_ = rs.getString(PROPERTY_ISCOMPLETED); 
           createdate_ = rs.getDate(PROPERTY_CREATEDATE); 
           createuser_ = rs.getString(PROPERTY_CREATEUSER); 
           auditdate_ = rs.getDate(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Costacc_wip_tempAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Costacc_wip_temp obj = (Costacc_wip_temp)cache.get(getID());
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
                    throw new CodeException("Error Reading Costacc_wip_temp " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from costacc_wip_temp ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Costacc_wip_temp " + e.getMessage());
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
            rs.updateLong(PROPERTY_COST_DETAIL_ID , cost_detail_id_ ); 
            rs.updateString(PROPERTY_COST_DETAIL , cost_detail_ ); 
            rs.updateDouble(PROPERTY_PRODUKSI , produksi_ ); 
            rs.updateDouble(PROPERTY_PRODUKSIPCNT , produksipcnt_ ); 
            rs.updateDouble(PROPERTY_INVENTORY , inventory_ ); 
            rs.updateDouble(PROPERTY_INVENTORYPCNT , inventorypcnt_ ); 
            rs.updateDouble(PROPERTY_TOTAL_1 , total_1_ ); 
            rs.updateDouble(PROPERTY_SOACCRUED , soaccrued_ ); 
            rs.updateDouble(PROPERTY_VARIANCE , variance_ ); 
            rs.updateDouble(PROPERTY_TOTAL_2 , total_2_ ); 
            rs.updateDouble(PROPERTY_COGS , cogs_ ); 
            rs.updateDouble(PROPERTY_ACCRUED , accrued_ ); 
            rs.updateDouble(PROPERTY_TOTAL_3 , total_3_ ); 
            rs.updateString(PROPERTY_ISCOMPLETED , iscompleted_ ); 
           if (getcreatedate()==null) {
              rs.updateDate(PROPERTY_CREATEDATE , null ); 
           }else{
              rs.updateDate(PROPERTY_CREATEDATE , getcreatedate()); 
           }
            rs.updateString(PROPERTY_CREATEUSER , createuser_ ); 
           if (getauditdate()==null) {
              rs.updateDate(PROPERTY_AUDITDATE , null ); 
           }else{
              rs.updateDate(PROPERTY_AUDITDATE , getauditdate()); 
           }
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Costacc_wip_temp obj = (Costacc_wip_temp) jCob;
        id_ = obj.getID();

        
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          cost_detail_id_ = obj.getcost_detail_id();
          cost_detail_ = obj.getcost_detail();
          produksi_ = obj.getproduksi();
          produksipcnt_ = obj.getproduksipcnt();
          inventory_ = obj.getinventory();
          inventorypcnt_ = obj.getinventorypcnt();
          total_1_ = obj.gettotal_1();
          soaccrued_ = obj.getsoaccrued();
          variance_ = obj.getvariance();
          total_2_ = obj.gettotal_2();
          cogs_ = obj.getcogs();
          accrued_ = obj.getaccrued();
          total_3_ = obj.gettotal_3();
          iscompleted_ = obj.getiscompleted();
          createdate_ = obj.getcreatedate();
          createuser_ = obj.getcreateuser();
          auditdate_ = obj.getauditdate();
          audituser_ = obj.getaudituser();
                
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

      public void setcost_detail_id(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cost_detail_id_ = param; 
         _isDirty_ = true; 
      } 

      public long getcost_detail_id() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cost_detail_id_; 
      } 

      public void setcost_detail(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cost_detail_ = param; 
         _isDirty_ = true; 
      } 

      public String getcost_detail() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cost_detail_; 
      } 

      public void setproduksi(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         produksi_ = param; 
         _isDirty_ = true; 
      } 

      public double getproduksi() throws CodeException {
         if (!_isLoaded_) { read();} 
         return produksi_; 
      } 

      public void setproduksipcnt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         produksipcnt_ = param; 
         _isDirty_ = true; 
      } 

      public double getproduksipcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return produksipcnt_; 
      } 

      public void setinventory(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inventory_ = param; 
         _isDirty_ = true; 
      } 

      public double getinventory() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inventory_; 
      } 

      public void setinventorypcnt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         inventorypcnt_ = param; 
         _isDirty_ = true; 
      } 

      public double getinventorypcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return inventorypcnt_; 
      } 

      public void settotal_1(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         total_1_ = param; 
         _isDirty_ = true; 
      } 

      public double gettotal_1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return total_1_; 
      } 

      public void setsoaccrued(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         soaccrued_ = param; 
         _isDirty_ = true; 
      } 

      public double getsoaccrued() throws CodeException {
         if (!_isLoaded_) { read();} 
         return soaccrued_; 
      } 

      public void setvariance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         variance_ = param; 
         _isDirty_ = true; 
      } 

      public double getvariance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return variance_; 
      } 

      public void settotal_2(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         total_2_ = param; 
         _isDirty_ = true; 
      } 

      public double gettotal_2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return total_2_; 
      } 

      public void setcogs(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cogs_ = param; 
         _isDirty_ = true; 
      } 

      public double getcogs() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cogs_; 
      } 

      public void setaccrued(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accrued_ = param; 
         _isDirty_ = true; 
      } 

      public double getaccrued() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accrued_; 
      } 

      public void settotal_3(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         total_3_ = param; 
         _isDirty_ = true; 
      } 

      public double gettotal_3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return total_3_; 
      } 

      public void setiscompleted(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         iscompleted_ = param; 
         _isDirty_ = true; 
      } 

      public String getiscompleted() throws CodeException {
         if (!_isLoaded_) { read();} 
         return iscompleted_; 
      } 

      public void setcreatedate(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         createdate_ = param; 
         _isDirty_ = true; 
      } 

      public Date getcreatedate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return createdate_; 
      } 

      public void setcreateuser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         createuser_ = param; 
         _isDirty_ = true; 
      } 

      public String getcreateuser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return createuser_; 
      } 

      public void setauditdate(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         auditdate_ = param; 
         _isDirty_ = true; 
      } 

      public Date getauditdate() throws CodeException {
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


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_COST_DETAIL_ID)) return String.valueOf(getcost_detail_id()); 
           else if (param.equals(PROPERTY_COST_DETAIL)) return getcost_detail(); 
           else if (param.equals(PROPERTY_PRODUKSI)) return decform.format(getproduksi()); 
           else if (param.equals(PROPERTY_PRODUKSIPCNT)) return decform.format(getproduksipcnt()); 
           else if (param.equals(PROPERTY_INVENTORY)) return decform.format(getinventory()); 
           else if (param.equals(PROPERTY_INVENTORYPCNT)) return decform.format(getinventorypcnt()); 
           else if (param.equals(PROPERTY_TOTAL_1)) return decform.format(gettotal_1()); 
           else if (param.equals(PROPERTY_SOACCRUED)) return decform.format(getsoaccrued()); 
           else if (param.equals(PROPERTY_VARIANCE)) return decform.format(getvariance()); 
           else if (param.equals(PROPERTY_TOTAL_2)) return decform.format(gettotal_2()); 
           else if (param.equals(PROPERTY_COGS)) return decform.format(getcogs()); 
           else if (param.equals(PROPERTY_ACCRUED)) return decform.format(getaccrued()); 
           else if (param.equals(PROPERTY_TOTAL_3)) return decform.format(gettotal_3()); 
           else if (param.equals(PROPERTY_ISCOMPLETED)) return getiscompleted(); 
           else if (param.equals(PROPERTY_CREATEDATE)) return getcreatedate()  == null ? "" :dateformat.format(getcreatedate()); 
           else if (param.equals(PROPERTY_CREATEUSER)) return getcreateuser(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditdate()  == null ? "" :dateformat.format(getauditdate()); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getaudituser(); 
       
        
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
           else if (param.equals(PROPERTY_COST_DETAIL_ID)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setcost_detail_id(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COST_DETAIL))  setcost_detail(value); 
           else if (param.equals(PROPERTY_PRODUKSI)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setproduksi(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PRODUKSIPCNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setproduksipcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVENTORY)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinventory(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INVENTORYPCNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setinventorypcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TOTAL_1)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settotal_1(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SOACCRUED)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setsoaccrued(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_VARIANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setvariance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TOTAL_2)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settotal_2(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COGS)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcogs(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCRUED)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setaccrued(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TOTAL_3)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settotal_3(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISCOMPLETED))  setiscompleted(value); 
           else if (param.equals(PROPERTY_CREATEDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setcreatedate(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setcreatedate(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_CREATEUSER))  setcreateuser(value); 
           else if (param.equals(PROPERTY_AUDITDATE)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       setauditdate(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             setauditdate(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_AUDITUSER))  setaudituser(value); 
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
            throw new CodeException("Costacc_wip_temp : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Costacc_wip_temp : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Costacc_wip_temp : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Costacc_wip_temp : Cannot Move Last " + ex.getMessage());
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



