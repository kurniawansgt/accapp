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


public abstract class Costacc_purchasevariance_tempAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Costacc_purchasevariance_temp";

    public static final String TABLE = "bankjurnal.costacc_purchasevariance_temp";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_COST_DETAIL_ID = "cost_detail_id";
    public static final String PROPERTY_COST_DETAIL = "cost_detail";
    public static final String PROPERTY_STANDARD = "standard";
    public static final String PROPERTY_ACTUAL = "actual";
    public static final String PROPERTY_VARIANCE = "variance";
    public static final String PROPERTY_PERCENTTOSTD = "percenttostd";
    public static final String PROPERTY_ISCOMPLATED = "iscomplated";
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
    private double standard_;
    private double actual_;
    private double variance_;
    private double percenttostd_;
    private String iscomplated_;
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

    public Costacc_purchasevariance_tempAbst() throws CodeException {
        loadNew();
    }
    
    public Costacc_purchasevariance_tempAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Costacc_purchasevariance_tempAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Costacc_purchasevariance_tempAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Costacc_purchasevariance_tempAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Costacc_purchasevariance_tempAbst for Key : " + key + " val : " + val);
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
           standard_ = rs.getDouble(PROPERTY_STANDARD); 
           actual_ = rs.getDouble(PROPERTY_ACTUAL); 
           variance_ = rs.getDouble(PROPERTY_VARIANCE); 
           percenttostd_ = rs.getDouble(PROPERTY_PERCENTTOSTD); 
           iscomplated_ = rs.getString(PROPERTY_ISCOMPLATED); 
           createdate_ = rs.getDate(PROPERTY_CREATEDATE); 
           createuser_ = rs.getString(PROPERTY_CREATEUSER); 
           auditdate_ = rs.getDate(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Costacc_purchasevariance_tempAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Costacc_purchasevariance_temp obj = (Costacc_purchasevariance_temp)cache.get(getID());
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
                    throw new CodeException("Error Reading Costacc_purchasevariance_temp " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from costacc_purchasevariance_temp ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Costacc_purchasevariance_temp " + e.getMessage());
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
            rs.updateDouble(PROPERTY_STANDARD , standard_ ); 
            rs.updateDouble(PROPERTY_ACTUAL , actual_ ); 
            rs.updateDouble(PROPERTY_VARIANCE , variance_ ); 
            rs.updateDouble(PROPERTY_PERCENTTOSTD , percenttostd_ ); 
            rs.updateString(PROPERTY_ISCOMPLATED , iscomplated_ ); 
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
        Costacc_purchasevariance_temp obj = (Costacc_purchasevariance_temp) jCob;
        id_ = obj.getID();

        
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          cost_detail_id_ = obj.getcost_detail_id();
          cost_detail_ = obj.getcost_detail();
          standard_ = obj.getstandard();
          actual_ = obj.getactual();
          variance_ = obj.getvariance();
          percenttostd_ = obj.getpercenttostd();
          iscomplated_ = obj.getiscomplated();
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

      public void setstandard(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         standard_ = param; 
         _isDirty_ = true; 
      } 

      public double getstandard() throws CodeException {
         if (!_isLoaded_) { read();} 
         return standard_; 
      } 

      public void setactual(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         actual_ = param; 
         _isDirty_ = true; 
      } 

      public double getactual() throws CodeException {
         if (!_isLoaded_) { read();} 
         return actual_; 
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

      public void setpercenttostd(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         percenttostd_ = param; 
         _isDirty_ = true; 
      } 

      public double getpercenttostd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return percenttostd_; 
      } 

      public void setiscomplated(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         iscomplated_ = param; 
         _isDirty_ = true; 
      } 

      public String getiscomplated() throws CodeException {
         if (!_isLoaded_) { read();} 
         return iscomplated_; 
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
           else if (param.equals(PROPERTY_STANDARD)) return decform.format(getstandard()); 
           else if (param.equals(PROPERTY_ACTUAL)) return decform.format(getactual()); 
           else if (param.equals(PROPERTY_VARIANCE)) return decform.format(getvariance()); 
           else if (param.equals(PROPERTY_PERCENTTOSTD)) return decform.format(getpercenttostd()); 
           else if (param.equals(PROPERTY_ISCOMPLATED)) return getiscomplated(); 
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
           else if (param.equals(PROPERTY_STANDARD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setstandard(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACTUAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setactual(newVal); 
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
           else if (param.equals(PROPERTY_PERCENTTOSTD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpercenttostd(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ISCOMPLATED))  setiscomplated(value); 
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
            throw new CodeException("Costacc_purchasevariance_temp : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Costacc_purchasevariance_temp : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Costacc_purchasevariance_temp : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Costacc_purchasevariance_temp : Cannot Move Last " + ex.getMessage());
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



