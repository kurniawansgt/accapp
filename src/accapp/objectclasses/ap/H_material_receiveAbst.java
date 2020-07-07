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


public abstract class H_material_receiveAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="H_material_receive";

    public static final String TABLE = "h_material_receive";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NO_MR = "no_mr";
    public static final String PROPERTY_NO_PP = "no_pp";
    public static final String PROPERTY_NO_SJ = "no_sj";
    public static final String PROPERTY_TGL_MR = "tgl_mr";
    public static final String PROPERTY_ENTRYTIME = "entrytime";
    public static final String PROPERTY_ENTRYUSER = "entryuser";
    public static final String PROPERTY_UPDATETIME = "updatetime";
    public static final String PROPERTY_UPDATEUSER = "updateuser";
    public static final String PROPERTY_IPADDRESS = "ipaddress";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String no_mr_;
    private String no_pp_;
    private String no_sj_;
    private Date tgl_mr_;
    private String entrytime_;
    private String entryuser_;
    private String updatetime_;
    private String updateuser_;
    private String ipaddress_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public H_material_receiveAbst() throws CodeException {
        loadNew();
    }
    
    public H_material_receiveAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public H_material_receiveAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public H_material_receiveAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public H_material_receiveAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create H_material_receiveAbst for Key : " + key + " val : " + val);
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
            
            
            
           no_mr_ = rs.getString(PROPERTY_NO_MR); 
           no_pp_ = rs.getString(PROPERTY_NO_PP); 
           no_sj_ = rs.getString(PROPERTY_NO_SJ); 
           tgl_mr_ = rs.getDate(PROPERTY_TGL_MR); 
           entrytime_ = rs.getString(PROPERTY_ENTRYTIME); 
           entryuser_ = rs.getString(PROPERTY_ENTRYUSER); 
           updatetime_ = rs.getString(PROPERTY_UPDATETIME); 
           updateuser_ = rs.getString(PROPERTY_UPDATEUSER); 
           ipaddress_ = rs.getString(PROPERTY_IPADDRESS); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading H_material_receiveAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            H_material_receive obj = (H_material_receive)cache.get(getID());
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
                    throw new CodeException("Error Reading H_material_receive " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from h_material_receive ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New H_material_receive " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_NO_MR , no_mr_ ); 
            rs.updateString(PROPERTY_NO_PP , no_pp_ ); 
            rs.updateString(PROPERTY_NO_SJ , no_sj_ ); 
           if (gettgl_mr()==null) {
              rs.updateDate(PROPERTY_TGL_MR , null ); 
           }else{
              rs.updateDate(PROPERTY_TGL_MR , gettgl_mr()); 
           }
            rs.updateString(PROPERTY_ENTRYTIME , entrytime_ ); 
            rs.updateString(PROPERTY_ENTRYUSER , entryuser_ ); 
            rs.updateString(PROPERTY_UPDATETIME , updatetime_ ); 
            rs.updateString(PROPERTY_UPDATEUSER , updateuser_ ); 
            rs.updateString(PROPERTY_IPADDRESS , ipaddress_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        H_material_receive obj = (H_material_receive) jCob;
        id_ = obj.getID();

        
          no_mr_ = obj.getno_mr();
          no_pp_ = obj.getno_pp();
          no_sj_ = obj.getno_sj();
          tgl_mr_ = obj.gettgl_mr();
          entrytime_ = obj.getentrytime();
          entryuser_ = obj.getentryuser();
          updatetime_ = obj.getupdatetime();
          updateuser_ = obj.getupdateuser();
          ipaddress_ = obj.getipaddress();
                
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

    
      public void setno_mr(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         no_mr_ = param; 
         _isDirty_ = true; 
      } 

      public String getno_mr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return no_mr_; 
      } 

      public void setno_pp(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         no_pp_ = param; 
         _isDirty_ = true; 
      } 

      public String getno_pp() throws CodeException {
         if (!_isLoaded_) { read();} 
         return no_pp_; 
      } 

      public void setno_sj(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         no_sj_ = param; 
         _isDirty_ = true; 
      } 

      public String getno_sj() throws CodeException {
         if (!_isLoaded_) { read();} 
         return no_sj_; 
      } 

      public void settgl_mr(Date param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         tgl_mr_ = param; 
         _isDirty_ = true; 
      } 

      public Date gettgl_mr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return tgl_mr_; 
      } 

      public void setentrytime(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrytime_ = param; 
         _isDirty_ = true; 
      } 

      public String getentrytime() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrytime_; 
      } 

      public void setentryuser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entryuser_ = param; 
         _isDirty_ = true; 
      } 

      public String getentryuser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entryuser_; 
      } 

      public void setupdatetime(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         updatetime_ = param; 
         _isDirty_ = true; 
      } 

      public String getupdatetime() throws CodeException {
         if (!_isLoaded_) { read();} 
         return updatetime_; 
      } 

      public void setupdateuser(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         updateuser_ = param; 
         _isDirty_ = true; 
      } 

      public String getupdateuser() throws CodeException {
         if (!_isLoaded_) { read();} 
         return updateuser_; 
      } 

      public void setipaddress(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ipaddress_ = param; 
         _isDirty_ = true; 
      } 

      public String getipaddress() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ipaddress_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_NO_MR)) return getno_mr(); 
           else if (param.equals(PROPERTY_NO_PP)) return getno_pp(); 
           else if (param.equals(PROPERTY_NO_SJ)) return getno_sj(); 
           else if (param.equals(PROPERTY_TGL_MR)) return gettgl_mr()  == null ? "" :dateformat.format(gettgl_mr()); 
           else if (param.equals(PROPERTY_ENTRYTIME)) return getentrytime(); 
           else if (param.equals(PROPERTY_ENTRYUSER)) return getentryuser(); 
           else if (param.equals(PROPERTY_UPDATETIME)) return getupdatetime(); 
           else if (param.equals(PROPERTY_UPDATEUSER)) return getupdateuser(); 
           else if (param.equals(PROPERTY_IPADDRESS)) return getipaddress(); 
       
        
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
        
           else if (param.equals(PROPERTY_NO_MR))  setno_mr(value); 
           else if (param.equals(PROPERTY_NO_PP))  setno_pp(value); 
           else if (param.equals(PROPERTY_NO_SJ))  setno_sj(value); 
           else if (param.equals(PROPERTY_TGL_MR)) { 
                   if (value==null || value.equals("") || value.equals("null") ) 
                       settgl_mr(null); 
                   else { 
                        try{ 
                             java.util.Date d = dateformat.parse(value); 
                             String year = String.valueOf(d.getYear()+1900); 
                             int imonth = d.getMonth() + 1; 
                             String month = imonth > 9 ? String.valueOf(imonth) : "0" + imonth; 
                             String numdate = d.getDate() > 9 ? String.valueOf(d.getDate()) : "0" + d.getDate();  
                             String date = year + "-" + month + "-" + numdate; 
                             settgl_mr(Date.valueOf(date )); 
                        }catch(java.text.ParseException pe){ 
                           throw new CodeException("Unrecognised Date format: "+pe.getMessage(),pe); 
                        } 
                   } 
           } 
           else if (param.equals(PROPERTY_ENTRYTIME))  setentrytime(value); 
           else if (param.equals(PROPERTY_ENTRYUSER))  setentryuser(value); 
           else if (param.equals(PROPERTY_UPDATETIME))  setupdatetime(value); 
           else if (param.equals(PROPERTY_UPDATEUSER))  setupdateuser(value); 
           else if (param.equals(PROPERTY_IPADDRESS))  setipaddress(value); 
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
            throw new CodeException("H_material_receive : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("H_material_receive : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("H_material_receive : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("H_material_receive : Cannot Move Last " + ex.getMessage());
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



