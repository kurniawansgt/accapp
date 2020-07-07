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


public abstract class Gl_account_structureAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_account_structure";

    public static final String TABLE = "gl_account_structure";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACCSTCTCODE = "accstctcode";
    public static final String PROPERTY_ACCSTCTDESC = "accstctdesc";
    public static final String PROPERTY_ACCSGMNCODE1 = "accsgmncode1";
    public static final String PROPERTY_SGMNSTRT1 = "sgmnstrt1";
    public static final String PROPERTY_SGMNLEN1 = "sgmnlen1";
    public static final String PROPERTY_ACCSGMNCODE2 = "accsgmncode2";
    public static final String PROPERTY_SGMNSTRT2 = "sgmnstrt2";
    public static final String PROPERTY_SGMNLEN2 = "sgmnlen2";
    public static final String PROPERTY_ACCSGMNCODE3 = "accsgmncode3";
    public static final String PROPERTY_SGMNSTRT3 = "sgmnstrt3";
    public static final String PROPERTY_SGMNLEN3 = "sgmnlen3";
    public static final String PROPERTY_ACCSGMNCODE4 = "accsgmncode4";
    public static final String PROPERTY_SGMNSTRT4 = "sgmnstrt4";
    public static final String PROPERTY_SGMNLEN4 = "sgmnlen4";
    public static final String PROPERTY_ACCSGMNCODE5 = "accsgmncode5";
    public static final String PROPERTY_SGMNSTRT5 = "sgmnstrt5";
    public static final String PROPERTY_SGMNLEN5 = "sgmnlen5";
    public static final String PROPERTY_ACCSGMNCODE6 = "accsgmncode6";
    public static final String PROPERTY_SGMNSTRT6 = "sgmnstrt6";
    public static final String PROPERTY_SGMNLEN6 = "sgmnlen6";
    public static final String PROPERTY_ACCSGMNCODE7 = "accsgmncode7";
    public static final String PROPERTY_SGMNSTRT7 = "sgmnstrt7";
    public static final String PROPERTY_SGMNLEN7 = "sgmnlen7";
    public static final String PROPERTY_ACCSGMNCODE8 = "accsgmncode8";
    public static final String PROPERTY_SGMNSTRT8 = "sgmnstrt8";
    public static final String PROPERTY_SGMNLEN8 = "sgmnlen8";
    public static final String PROPERTY_ACCSGMNCODE9 = "accsgmncode9";
    public static final String PROPERTY_SGMNSTRT9 = "sgmnstrt9";
    public static final String PROPERTY_SGMNLEN9 = "sgmnlen9";
    public static final String PROPERTY_ACCSGMNCODE10 = "accsgmncode10";
    public static final String PROPERTY_SGMNSTRT10 = "sgmnstrt10";
    public static final String PROPERTY_SGMNLEN10 = "sgmnlen10";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ACCSTCTCODE;
    
    
    private long id_;
    private String accstctcode_;
    private String accstctdesc_;
    private String accsgmncode1_;
    private long sgmnstrt1_;
    private long sgmnlen1_;
    private String accsgmncode2_;
    private long sgmnstrt2_;
    private long sgmnlen2_;
    private String accsgmncode3_;
    private long sgmnstrt3_;
    private long sgmnlen3_;
    private String accsgmncode4_;
    private long sgmnstrt4_;
    private long sgmnlen4_;
    private String accsgmncode5_;
    private long sgmnstrt5_;
    private long sgmnlen5_;
    private String accsgmncode6_;
    private long sgmnstrt6_;
    private long sgmnlen6_;
    private String accsgmncode7_;
    private long sgmnstrt7_;
    private long sgmnlen7_;
    private String accsgmncode8_;
    private long sgmnstrt8_;
    private long sgmnlen8_;
    private String accsgmncode9_;
    private long sgmnstrt9_;
    private long sgmnlen9_;
    private String accsgmncode10_;
    private long sgmnstrt10_;
    private long sgmnlen10_;
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

    public Gl_account_structureAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_account_structureAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_account_structureAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_account_structureAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_account_structureAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_account_structureAbst for Key : " + key + " val : " + val);
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
            
            
            
           accstctcode_ = rs.getString(PROPERTY_ACCSTCTCODE); 
           accstctdesc_ = rs.getString(PROPERTY_ACCSTCTDESC); 
           accsgmncode1_ = rs.getString(PROPERTY_ACCSGMNCODE1); 
           sgmnstrt1_ = rs.getLong(PROPERTY_SGMNSTRT1); 
           sgmnlen1_ = rs.getLong(PROPERTY_SGMNLEN1); 
           accsgmncode2_ = rs.getString(PROPERTY_ACCSGMNCODE2); 
           sgmnstrt2_ = rs.getLong(PROPERTY_SGMNSTRT2); 
           sgmnlen2_ = rs.getLong(PROPERTY_SGMNLEN2); 
           accsgmncode3_ = rs.getString(PROPERTY_ACCSGMNCODE3); 
           sgmnstrt3_ = rs.getLong(PROPERTY_SGMNSTRT3); 
           sgmnlen3_ = rs.getLong(PROPERTY_SGMNLEN3); 
           accsgmncode4_ = rs.getString(PROPERTY_ACCSGMNCODE4); 
           sgmnstrt4_ = rs.getLong(PROPERTY_SGMNSTRT4); 
           sgmnlen4_ = rs.getLong(PROPERTY_SGMNLEN4); 
           accsgmncode5_ = rs.getString(PROPERTY_ACCSGMNCODE5); 
           sgmnstrt5_ = rs.getLong(PROPERTY_SGMNSTRT5); 
           sgmnlen5_ = rs.getLong(PROPERTY_SGMNLEN5); 
           accsgmncode6_ = rs.getString(PROPERTY_ACCSGMNCODE6); 
           sgmnstrt6_ = rs.getLong(PROPERTY_SGMNSTRT6); 
           sgmnlen6_ = rs.getLong(PROPERTY_SGMNLEN6); 
           accsgmncode7_ = rs.getString(PROPERTY_ACCSGMNCODE7); 
           sgmnstrt7_ = rs.getLong(PROPERTY_SGMNSTRT7); 
           sgmnlen7_ = rs.getLong(PROPERTY_SGMNLEN7); 
           accsgmncode8_ = rs.getString(PROPERTY_ACCSGMNCODE8); 
           sgmnstrt8_ = rs.getLong(PROPERTY_SGMNSTRT8); 
           sgmnlen8_ = rs.getLong(PROPERTY_SGMNLEN8); 
           accsgmncode9_ = rs.getString(PROPERTY_ACCSGMNCODE9); 
           sgmnstrt9_ = rs.getLong(PROPERTY_SGMNSTRT9); 
           sgmnlen9_ = rs.getLong(PROPERTY_SGMNLEN9); 
           accsgmncode10_ = rs.getString(PROPERTY_ACCSGMNCODE10); 
           sgmnstrt10_ = rs.getLong(PROPERTY_SGMNSTRT10); 
           sgmnlen10_ = rs.getLong(PROPERTY_SGMNLEN10); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_account_structureAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_account_structure obj = (Gl_account_structure)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_account_structure " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getaccstctcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : accstctcode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from gl_account_structure ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_account_structure " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_ACCSTCTCODE , accstctcode_ ); 
            rs.updateString(PROPERTY_ACCSTCTDESC , accstctdesc_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE1 , accsgmncode1_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT1 , sgmnstrt1_ ); 
            rs.updateLong(PROPERTY_SGMNLEN1 , sgmnlen1_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE2 , accsgmncode2_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT2 , sgmnstrt2_ ); 
            rs.updateLong(PROPERTY_SGMNLEN2 , sgmnlen2_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE3 , accsgmncode3_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT3 , sgmnstrt3_ ); 
            rs.updateLong(PROPERTY_SGMNLEN3 , sgmnlen3_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE4 , accsgmncode4_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT4 , sgmnstrt4_ ); 
            rs.updateLong(PROPERTY_SGMNLEN4 , sgmnlen4_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE5 , accsgmncode5_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT5 , sgmnstrt5_ ); 
            rs.updateLong(PROPERTY_SGMNLEN5 , sgmnlen5_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE6 , accsgmncode6_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT6 , sgmnstrt6_ ); 
            rs.updateLong(PROPERTY_SGMNLEN6 , sgmnlen6_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE7 , accsgmncode7_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT7 , sgmnstrt7_ ); 
            rs.updateLong(PROPERTY_SGMNLEN7 , sgmnlen7_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE8 , accsgmncode8_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT8 , sgmnstrt8_ ); 
            rs.updateLong(PROPERTY_SGMNLEN8 , sgmnlen8_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE9 , accsgmncode9_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT9 , sgmnstrt9_ ); 
            rs.updateLong(PROPERTY_SGMNLEN9 , sgmnlen9_ ); 
            rs.updateString(PROPERTY_ACCSGMNCODE10 , accsgmncode10_ ); 
            rs.updateLong(PROPERTY_SGMNSTRT10 , sgmnstrt10_ ); 
            rs.updateLong(PROPERTY_SGMNLEN10 , sgmnlen10_ ); 
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
        Gl_account_structure obj = (Gl_account_structure) jCob;
        id_ = obj.getID();

        
          accstctcode_ = obj.getaccstctcode();
          accstctdesc_ = obj.getaccstctdesc();
          accsgmncode1_ = obj.getaccsgmncode1();
          sgmnstrt1_ = obj.getsgmnstrt1();
          sgmnlen1_ = obj.getsgmnlen1();
          accsgmncode2_ = obj.getaccsgmncode2();
          sgmnstrt2_ = obj.getsgmnstrt2();
          sgmnlen2_ = obj.getsgmnlen2();
          accsgmncode3_ = obj.getaccsgmncode3();
          sgmnstrt3_ = obj.getsgmnstrt3();
          sgmnlen3_ = obj.getsgmnlen3();
          accsgmncode4_ = obj.getaccsgmncode4();
          sgmnstrt4_ = obj.getsgmnstrt4();
          sgmnlen4_ = obj.getsgmnlen4();
          accsgmncode5_ = obj.getaccsgmncode5();
          sgmnstrt5_ = obj.getsgmnstrt5();
          sgmnlen5_ = obj.getsgmnlen5();
          accsgmncode6_ = obj.getaccsgmncode6();
          sgmnstrt6_ = obj.getsgmnstrt6();
          sgmnlen6_ = obj.getsgmnlen6();
          accsgmncode7_ = obj.getaccsgmncode7();
          sgmnstrt7_ = obj.getsgmnstrt7();
          sgmnlen7_ = obj.getsgmnlen7();
          accsgmncode8_ = obj.getaccsgmncode8();
          sgmnstrt8_ = obj.getsgmnstrt8();
          sgmnlen8_ = obj.getsgmnlen8();
          accsgmncode9_ = obj.getaccsgmncode9();
          sgmnstrt9_ = obj.getsgmnstrt9();
          sgmnlen9_ = obj.getsgmnlen9();
          accsgmncode10_ = obj.getaccsgmncode10();
          sgmnstrt10_ = obj.getsgmnstrt10();
          sgmnlen10_ = obj.getsgmnlen10();
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

    
      public void setaccstctcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accstctcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccstctcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accstctcode_; 
      } 

      public void setaccstctdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accstctdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccstctdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accstctdesc_; 
      } 

      public void setaccsgmncode1(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode1_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode1_; 
      } 

      public void setsgmnstrt1(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt1_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt1_; 
      } 

      public void setsgmnlen1(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen1_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen1_; 
      } 

      public void setaccsgmncode2(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode2_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode2_; 
      } 

      public void setsgmnstrt2(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt2_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt2_; 
      } 

      public void setsgmnlen2(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen2_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen2_; 
      } 

      public void setaccsgmncode3(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode3_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode3_; 
      } 

      public void setsgmnstrt3(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt3_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt3_; 
      } 

      public void setsgmnlen3(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen3_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen3() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen3_; 
      } 

      public void setaccsgmncode4(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode4_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode4() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode4_; 
      } 

      public void setsgmnstrt4(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt4_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt4() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt4_; 
      } 

      public void setsgmnlen4(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen4_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen4() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen4_; 
      } 

      public void setaccsgmncode5(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode5_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode5() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode5_; 
      } 

      public void setsgmnstrt5(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt5_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt5() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt5_; 
      } 

      public void setsgmnlen5(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen5_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen5() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen5_; 
      } 

      public void setaccsgmncode6(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode6_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode6() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode6_; 
      } 

      public void setsgmnstrt6(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt6_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt6() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt6_; 
      } 

      public void setsgmnlen6(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen6_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen6() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen6_; 
      } 

      public void setaccsgmncode7(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode7_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode7() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode7_; 
      } 

      public void setsgmnstrt7(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt7_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt7() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt7_; 
      } 

      public void setsgmnlen7(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen7_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen7() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen7_; 
      } 

      public void setaccsgmncode8(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode8_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode8() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode8_; 
      } 

      public void setsgmnstrt8(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt8_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt8() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt8_; 
      } 

      public void setsgmnlen8(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen8_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen8() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen8_; 
      } 

      public void setaccsgmncode9(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode9_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode9() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode9_; 
      } 

      public void setsgmnstrt9(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt9_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt9() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt9_; 
      } 

      public void setsgmnlen9(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen9_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen9() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen9_; 
      } 

      public void setaccsgmncode10(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accsgmncode10_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccsgmncode10() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accsgmncode10_; 
      } 

      public void setsgmnstrt10(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnstrt10_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnstrt10() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnstrt10_; 
      } 

      public void setsgmnlen10(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         sgmnlen10_ = param; 
         _isDirty_ = true; 
      } 

      public long getsgmnlen10() throws CodeException {
         if (!_isLoaded_) { read();} 
         return sgmnlen10_; 
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
        
           else if (param.equals(PROPERTY_ACCSTCTCODE)) return getaccstctcode(); 
           else if (param.equals(PROPERTY_ACCSTCTDESC)) return getaccstctdesc(); 
           else if (param.equals(PROPERTY_ACCSGMNCODE1)) return getaccsgmncode1(); 
           else if (param.equals(PROPERTY_SGMNSTRT1)) return String.valueOf(getsgmnstrt1()); 
           else if (param.equals(PROPERTY_SGMNLEN1)) return String.valueOf(getsgmnlen1()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE2)) return getaccsgmncode2(); 
           else if (param.equals(PROPERTY_SGMNSTRT2)) return String.valueOf(getsgmnstrt2()); 
           else if (param.equals(PROPERTY_SGMNLEN2)) return String.valueOf(getsgmnlen2()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE3)) return getaccsgmncode3(); 
           else if (param.equals(PROPERTY_SGMNSTRT3)) return String.valueOf(getsgmnstrt3()); 
           else if (param.equals(PROPERTY_SGMNLEN3)) return String.valueOf(getsgmnlen3()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE4)) return getaccsgmncode4(); 
           else if (param.equals(PROPERTY_SGMNSTRT4)) return String.valueOf(getsgmnstrt4()); 
           else if (param.equals(PROPERTY_SGMNLEN4)) return String.valueOf(getsgmnlen4()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE5)) return getaccsgmncode5(); 
           else if (param.equals(PROPERTY_SGMNSTRT5)) return String.valueOf(getsgmnstrt5()); 
           else if (param.equals(PROPERTY_SGMNLEN5)) return String.valueOf(getsgmnlen5()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE6)) return getaccsgmncode6(); 
           else if (param.equals(PROPERTY_SGMNSTRT6)) return String.valueOf(getsgmnstrt6()); 
           else if (param.equals(PROPERTY_SGMNLEN6)) return String.valueOf(getsgmnlen6()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE7)) return getaccsgmncode7(); 
           else if (param.equals(PROPERTY_SGMNSTRT7)) return String.valueOf(getsgmnstrt7()); 
           else if (param.equals(PROPERTY_SGMNLEN7)) return String.valueOf(getsgmnlen7()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE8)) return getaccsgmncode8(); 
           else if (param.equals(PROPERTY_SGMNSTRT8)) return String.valueOf(getsgmnstrt8()); 
           else if (param.equals(PROPERTY_SGMNLEN8)) return String.valueOf(getsgmnlen8()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE9)) return getaccsgmncode9(); 
           else if (param.equals(PROPERTY_SGMNSTRT9)) return String.valueOf(getsgmnstrt9()); 
           else if (param.equals(PROPERTY_SGMNLEN9)) return String.valueOf(getsgmnlen9()); 
           else if (param.equals(PROPERTY_ACCSGMNCODE10)) return getaccsgmncode10(); 
           else if (param.equals(PROPERTY_SGMNSTRT10)) return String.valueOf(getsgmnstrt10()); 
           else if (param.equals(PROPERTY_SGMNLEN10)) return String.valueOf(getsgmnlen10()); 
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
        
           else if (param.equals(PROPERTY_ACCSTCTCODE))  setaccstctcode(value); 
           else if (param.equals(PROPERTY_ACCSTCTDESC))  setaccstctdesc(value); 
           else if (param.equals(PROPERTY_ACCSGMNCODE1))  setaccsgmncode1(value); 
           else if (param.equals(PROPERTY_SGMNSTRT1)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt1(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN1)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen1(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE2))  setaccsgmncode2(value); 
           else if (param.equals(PROPERTY_SGMNSTRT2)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt2(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN2)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen2(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE3))  setaccsgmncode3(value); 
           else if (param.equals(PROPERTY_SGMNSTRT3)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt3(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN3)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen3(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE4))  setaccsgmncode4(value); 
           else if (param.equals(PROPERTY_SGMNSTRT4)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt4(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN4)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen4(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE5))  setaccsgmncode5(value); 
           else if (param.equals(PROPERTY_SGMNSTRT5)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt5(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN5)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen5(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE6))  setaccsgmncode6(value); 
           else if (param.equals(PROPERTY_SGMNSTRT6)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt6(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN6)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen6(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE7))  setaccsgmncode7(value); 
           else if (param.equals(PROPERTY_SGMNSTRT7)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt7(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN7)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen7(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE8))  setaccsgmncode8(value); 
           else if (param.equals(PROPERTY_SGMNSTRT8)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt8(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN8)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen8(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE9))  setaccsgmncode9(value); 
           else if (param.equals(PROPERTY_SGMNSTRT9)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt9(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN9)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen9(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCSGMNCODE10))  setaccsgmncode10(value); 
           else if (param.equals(PROPERTY_SGMNSTRT10)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnstrt10(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SGMNLEN10)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setsgmnlen10(newVal); 
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
            throw new CodeException("Gl_account_structure : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, accstctcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_account_structure : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, accstctcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Gl_account_structure : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_account_structure : Cannot Move Last " + ex.getMessage());
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



