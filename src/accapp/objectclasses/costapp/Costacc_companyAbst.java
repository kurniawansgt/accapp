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


public abstract class Costacc_companyAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Costacc_company";

    public static final String TABLE = "costacc_company";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_COMPANY = "Company";
    public static final String PROPERTY_COMPANYNAME = "CompanyName";
    public static final String PROPERTY_CUSTMRCODE = "CustmrCode";
    public static final String PROPERTY_COMPANYGROUP = "CompanyGroup";
    public static final String PROPERTY_PPNACCCODE = "ppnacccode";
    public static final String PROPERTY_ISPRODUCT = "isproduct";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String Company_;
    private String CompanyName_;
    private String CustmrCode_;
    private String CompanyGroup_;
    private String ppnacccode_;
    private String isproduct_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Costacc_companyAbst() throws CodeException {
        loadNew();
    }
    
    public Costacc_companyAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Costacc_companyAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Costacc_companyAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Costacc_companyAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Costacc_companyAbst for Key : " + key + " val : " + val);
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
            
            
            
           Company_ = rs.getString(PROPERTY_COMPANY); 
           CompanyName_ = rs.getString(PROPERTY_COMPANYNAME); 
           CustmrCode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           CompanyGroup_ = rs.getString(PROPERTY_COMPANYGROUP); 
           ppnacccode_ = rs.getString(PROPERTY_PPNACCCODE); 
           isproduct_ = rs.getString(PROPERTY_ISPRODUCT); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Costacc_companyAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Costacc_company obj = (Costacc_company)cache.get(getID());
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
                    throw new CodeException("Error Reading Costacc_company " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from costacc_company ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Costacc_company " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_COMPANY , Company_ ); 
            rs.updateString(PROPERTY_COMPANYNAME , CompanyName_ ); 
            rs.updateString(PROPERTY_CUSTMRCODE , CustmrCode_ ); 
            rs.updateString(PROPERTY_COMPANYGROUP , CompanyGroup_ ); 
            rs.updateString(PROPERTY_PPNACCCODE , ppnacccode_ ); 
            rs.updateString(PROPERTY_ISPRODUCT , isproduct_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Costacc_company obj = (Costacc_company) jCob;
        id_ = obj.getID();

        
          Company_ = obj.getCompany();
          CompanyName_ = obj.getCompanyName();
          CustmrCode_ = obj.getCustmrCode();
          CompanyGroup_ = obj.getCompanyGroup();
          ppnacccode_ = obj.getppnacccode();
          isproduct_ = obj.getisproduct();
                
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

    
      public void setCompany(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         Company_ = param; 
         _isDirty_ = true; 
      } 

      public String getCompany() throws CodeException {
         if (!_isLoaded_) { read();} 
         return Company_; 
      } 

      public void setCompanyName(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         CompanyName_ = param; 
         _isDirty_ = true; 
      } 

      public String getCompanyName() throws CodeException {
         if (!_isLoaded_) { read();} 
         return CompanyName_; 
      } 

      public void setCustmrCode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         CustmrCode_ = param; 
         _isDirty_ = true; 
      } 

      public String getCustmrCode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return CustmrCode_; 
      } 

      public void setCompanyGroup(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         CompanyGroup_ = param; 
         _isDirty_ = true; 
      } 

      public String getCompanyGroup() throws CodeException {
         if (!_isLoaded_) { read();} 
         return CompanyGroup_; 
      } 

      public void setppnacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ppnacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getppnacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ppnacccode_; 
      } 

      public void setisproduct(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         isproduct_ = param; 
         _isDirty_ = true; 
      } 

      public String getisproduct() throws CodeException {
         if (!_isLoaded_) { read();} 
         return isproduct_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_COMPANY)) return getCompany(); 
           else if (param.equals(PROPERTY_COMPANYNAME)) return getCompanyName(); 
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getCustmrCode(); 
           else if (param.equals(PROPERTY_COMPANYGROUP)) return getCompanyGroup(); 
           else if (param.equals(PROPERTY_PPNACCCODE)) return getppnacccode(); 
           else if (param.equals(PROPERTY_ISPRODUCT)) return getisproduct(); 
       
        
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
        
           else if (param.equals(PROPERTY_COMPANY))  setCompany(value); 
           else if (param.equals(PROPERTY_COMPANYNAME))  setCompanyName(value); 
           else if (param.equals(PROPERTY_CUSTMRCODE))  setCustmrCode(value); 
           else if (param.equals(PROPERTY_COMPANYGROUP))  setCompanyGroup(value); 
           else if (param.equals(PROPERTY_PPNACCCODE))  setppnacccode(value); 
           else if (param.equals(PROPERTY_ISPRODUCT))  setisproduct(value); 
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
            throw new CodeException("Costacc_company : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Costacc_company : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Costacc_company : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Costacc_company : Cannot Move Last " + ex.getMessage());
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



