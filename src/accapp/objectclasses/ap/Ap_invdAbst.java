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


public abstract class Ap_invdAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ap_invd";

    public static final String TABLE = "ap_invd";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_LINENUM = "linenum";
    public static final String PROPERTY_DISTCODE = "distcode";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_ACCGLCODE = "accglcode";
    public static final String PROPERTY_ACCGLDSCRIPTION = "accgldscription";
    public static final String PROPERTY_ACCTAXCODE = "acctaxcode";
    public static final String PROPERTY_ACCCOGSCODE = "acccogscode";
    public static final String PROPERTY_DETAILAMT = "detailamt";
    public static final String PROPERTY_COMMENT = "comment";
    public static final String PROPERTY_COGSAMT = "cogsamt";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_TAXAMT = "taxamt";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long batchno_;
    private long docentry_;
    private long linenum_;
    private String distcode_;
    private String dscription_;
    private String accglcode_;
    private String accgldscription_;
    private String acctaxcode_;
    private String acccogscode_;
    private double detailamt_;
    private String comment_;
    private double cogsamt_;
    private double rate_;
    private double taxamt_;
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

    public Ap_invdAbst() throws CodeException {
        loadNew();
    }
    
    public Ap_invdAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ap_invdAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ap_invdAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ap_invdAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ap_invdAbst for Key : " + key + " val : " + val);
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
           distcode_ = rs.getString(PROPERTY_DISTCODE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           accglcode_ = rs.getString(PROPERTY_ACCGLCODE); 
           accgldscription_ = rs.getString(PROPERTY_ACCGLDSCRIPTION); 
           acctaxcode_ = rs.getString(PROPERTY_ACCTAXCODE); 
           acccogscode_ = rs.getString(PROPERTY_ACCCOGSCODE); 
           detailamt_ = rs.getDouble(PROPERTY_DETAILAMT); 
           comment_ = rs.getString(PROPERTY_COMMENT); 
           cogsamt_ = rs.getDouble(PROPERTY_COGSAMT); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           taxamt_ = rs.getDouble(PROPERTY_TAXAMT); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ap_invdAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ap_invd obj = (Ap_invd)cache.get(getID());
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
                    throw new CodeException("Error Reading Ap_invd " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ap_invd ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ap_invd " + e.getMessage());
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
            rs.updateString(PROPERTY_DISTCODE , distcode_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_ACCGLCODE , accglcode_ ); 
            rs.updateString(PROPERTY_ACCGLDSCRIPTION , accgldscription_ ); 
            rs.updateString(PROPERTY_ACCTAXCODE , acctaxcode_ ); 
            rs.updateString(PROPERTY_ACCCOGSCODE , acccogscode_ ); 
            rs.updateDouble(PROPERTY_DETAILAMT , detailamt_ ); 
            rs.updateString(PROPERTY_COMMENT , comment_ ); 
            rs.updateDouble(PROPERTY_COGSAMT , cogsamt_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateDouble(PROPERTY_TAXAMT , taxamt_ ); 
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
        Ap_invd obj = (Ap_invd) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          linenum_ = obj.getlinenum();
          distcode_ = obj.getdistcode();
          dscription_ = obj.getdscription();
          accglcode_ = obj.getaccglcode();
          accgldscription_ = obj.getaccgldscription();
          acctaxcode_ = obj.getacctaxcode();
          acccogscode_ = obj.getacccogscode();
          detailamt_ = obj.getdetailamt();
          comment_ = obj.getcomment();
          cogsamt_ = obj.getcogsamt();
          rate_ = obj.getrate();
          taxamt_ = obj.gettaxamt();
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

      public void setdistcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         distcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getdistcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return distcode_; 
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

      public void setaccglcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accglcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccglcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accglcode_; 
      } 

      public void setaccgldscription(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         accgldscription_ = param; 
         _isDirty_ = true; 
      } 

      public String getaccgldscription() throws CodeException {
         if (!_isLoaded_) { read();} 
         return accgldscription_; 
      } 

      public void setacctaxcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acctaxcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacctaxcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acctaxcode_; 
      } 

      public void setacccogscode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccogscode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccogscode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccogscode_; 
      } 

      public void setdetailamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         detailamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdetailamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return detailamt_; 
      } 

      public void setcomment(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         comment_ = param; 
         _isDirty_ = true; 
      } 

      public String getcomment() throws CodeException {
         if (!_isLoaded_) { read();} 
         return comment_; 
      } 

      public void setcogsamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cogsamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getcogsamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cogsamt_; 
      } 

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
      } 

      public void settaxamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxamt_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxamt_; 
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
        
           else if (param.equals(PROPERTY_BATCHNO)) return String.valueOf(getbatchno()); 
           else if (param.equals(PROPERTY_DOCENTRY)) return String.valueOf(getdocentry()); 
           else if (param.equals(PROPERTY_LINENUM)) return String.valueOf(getlinenum()); 
           else if (param.equals(PROPERTY_DISTCODE)) return getdistcode(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_ACCGLCODE)) return getaccglcode(); 
           else if (param.equals(PROPERTY_ACCGLDSCRIPTION)) return getaccgldscription(); 
           else if (param.equals(PROPERTY_ACCTAXCODE)) return getacctaxcode(); 
           else if (param.equals(PROPERTY_ACCCOGSCODE)) return getacccogscode(); 
           else if (param.equals(PROPERTY_DETAILAMT)) return decform.format(getdetailamt()); 
           else if (param.equals(PROPERTY_COMMENT)) return getcomment(); 
           else if (param.equals(PROPERTY_COGSAMT)) return decform.format(getcogsamt()); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_TAXAMT)) return decform.format(gettaxamt()); 
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
           else if (param.equals(PROPERTY_DISTCODE))  setdistcode(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_ACCGLCODE))  setaccglcode(value); 
           else if (param.equals(PROPERTY_ACCGLDSCRIPTION))  setaccgldscription(value); 
           else if (param.equals(PROPERTY_ACCTAXCODE))  setacctaxcode(value); 
           else if (param.equals(PROPERTY_ACCCOGSCODE))  setacccogscode(value); 
           else if (param.equals(PROPERTY_DETAILAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdetailamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COMMENT))  setcomment(value); 
           else if (param.equals(PROPERTY_COGSAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcogsamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxamt(newVal); 
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
            throw new CodeException("Ap_invd : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ap_invd : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ap_invd : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ap_invd : Cannot Move Last " + ex.getMessage());
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



