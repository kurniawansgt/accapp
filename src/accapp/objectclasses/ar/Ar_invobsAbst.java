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


public abstract class Ar_invobsAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_invobs";

    public static final String TABLE = "ar_invobs";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_DOCNUMAPPLTO = "docnumapplto";
    public static final String PROPERTY_DOCDATE = "docdate";
    public static final String PROPERTY_DOCDUEDATE = "docduedate";
    public static final String PROPERTY_DISCDATE = "discdate";
    public static final String PROPERTY_SWPAID = "swpaid";
    public static final String PROPERTY_DOCTOTALAMT = "doctotalamt";
    public static final String PROPERTY_DISCTOTALAMT = "disctotalamt";
    public static final String PROPERTY_DISCTOTALAMTR = "disctotalamtr";
    public static final String PROPERTY_DOCTOTALPAYAMTR = "doctotalpayamtr";
    public static final String PROPERTY_PNDTOTALPAYAMT = "pndtotalpayamt";
    public static final String PROPERTY_PNDDISCTOTALAMT = "pnddisctotalamt";
    public static final String PROPERTY_PNDADJUSTTOTALAMT = "pndadjusttotalamt";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_CUSTMRPONO = "custmrpono";
    public static final String PROPERTY_NATCODE = "natcode";
    public static final String PROPERTY_GRPCODE = "grpcode";
    public static final String PROPERTY_DOCNUMPPD = "docnumppd";
    public static final String PROPERTY_BASETYPE = "basetype";
    public static final String PROPERTY_BASEBATCH = "basebatch";
    public static final String PROPERTY_BASEENTRY = "baseentry";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private String custmrcode_;
    private String docnum_;
    private String docnumapplto_;
    private String docdate_;
    private String docduedate_;
    private String discdate_;
    private String swpaid_;
    private double doctotalamt_;
    private double disctotalamt_;
    private double disctotalamtr_;
    private double doctotalpayamtr_;
    private double pndtotalpayamt_;
    private double pnddisctotalamt_;
    private double pndadjusttotalamt_;
    private String orderno_;
    private String custmrpono_;
    private String natcode_;
    private String grpcode_;
    private String docnumppd_;
    private long basetype_;
    private long basebatch_;
    private long baseentry_;
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

    public Ar_invobsAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_invobsAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_invobsAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_invobsAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_invobsAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_invobsAbst for Key : " + key + " val : " + val);
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
            
            
            
           custmrcode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           docnumapplto_ = rs.getString(PROPERTY_DOCNUMAPPLTO); 
           docdate_ = rs.getString(PROPERTY_DOCDATE); 
           docduedate_ = rs.getString(PROPERTY_DOCDUEDATE); 
           discdate_ = rs.getString(PROPERTY_DISCDATE); 
           swpaid_ = rs.getString(PROPERTY_SWPAID); 
           doctotalamt_ = rs.getDouble(PROPERTY_DOCTOTALAMT); 
           disctotalamt_ = rs.getDouble(PROPERTY_DISCTOTALAMT); 
           disctotalamtr_ = rs.getDouble(PROPERTY_DISCTOTALAMTR); 
           doctotalpayamtr_ = rs.getDouble(PROPERTY_DOCTOTALPAYAMTR); 
           pndtotalpayamt_ = rs.getDouble(PROPERTY_PNDTOTALPAYAMT); 
           pnddisctotalamt_ = rs.getDouble(PROPERTY_PNDDISCTOTALAMT); 
           pndadjusttotalamt_ = rs.getDouble(PROPERTY_PNDADJUSTTOTALAMT); 
           orderno_ = rs.getString(PROPERTY_ORDERNO); 
           custmrpono_ = rs.getString(PROPERTY_CUSTMRPONO); 
           natcode_ = rs.getString(PROPERTY_NATCODE); 
           grpcode_ = rs.getString(PROPERTY_GRPCODE); 
           docnumppd_ = rs.getString(PROPERTY_DOCNUMPPD); 
           basetype_ = rs.getLong(PROPERTY_BASETYPE); 
           basebatch_ = rs.getLong(PROPERTY_BASEBATCH); 
           baseentry_ = rs.getLong(PROPERTY_BASEENTRY); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_invobsAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_invobs obj = (Ar_invobs)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_invobs " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_invobs ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_invobs " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_CUSTMRCODE , custmrcode_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateString(PROPERTY_DOCNUMAPPLTO , docnumapplto_ ); 
            rs.updateString(PROPERTY_DOCDATE , docdate_ ); 
            rs.updateString(PROPERTY_DOCDUEDATE , docduedate_ ); 
            rs.updateString(PROPERTY_DISCDATE , discdate_ ); 
            rs.updateString(PROPERTY_SWPAID , swpaid_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALAMT , doctotalamt_ ); 
            rs.updateDouble(PROPERTY_DISCTOTALAMT , disctotalamt_ ); 
            rs.updateDouble(PROPERTY_DISCTOTALAMTR , disctotalamtr_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALPAYAMTR , doctotalpayamtr_ ); 
            rs.updateDouble(PROPERTY_PNDTOTALPAYAMT , pndtotalpayamt_ ); 
            rs.updateDouble(PROPERTY_PNDDISCTOTALAMT , pnddisctotalamt_ ); 
            rs.updateDouble(PROPERTY_PNDADJUSTTOTALAMT , pndadjusttotalamt_ ); 
            rs.updateString(PROPERTY_ORDERNO , orderno_ ); 
            rs.updateString(PROPERTY_CUSTMRPONO , custmrpono_ ); 
            rs.updateString(PROPERTY_NATCODE , natcode_ ); 
            rs.updateString(PROPERTY_GRPCODE , grpcode_ ); 
            rs.updateString(PROPERTY_DOCNUMPPD , docnumppd_ ); 
            rs.updateLong(PROPERTY_BASETYPE , basetype_ ); 
            rs.updateLong(PROPERTY_BASEBATCH , basebatch_ ); 
            rs.updateLong(PROPERTY_BASEENTRY , baseentry_ ); 
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
        Ar_invobs obj = (Ar_invobs) jCob;
        id_ = obj.getID();

        
          custmrcode_ = obj.getcustmrcode();
          docnum_ = obj.getdocnum();
          docnumapplto_ = obj.getdocnumapplto();
          docdate_ = obj.getdocdate();
          docduedate_ = obj.getdocduedate();
          discdate_ = obj.getdiscdate();
          swpaid_ = obj.getswpaid();
          doctotalamt_ = obj.getdoctotalamt();
          disctotalamt_ = obj.getdisctotalamt();
          disctotalamtr_ = obj.getdisctotalamtr();
          doctotalpayamtr_ = obj.getdoctotalpayamtr();
          pndtotalpayamt_ = obj.getpndtotalpayamt();
          pnddisctotalamt_ = obj.getpnddisctotalamt();
          pndadjusttotalamt_ = obj.getpndadjusttotalamt();
          orderno_ = obj.getorderno();
          custmrpono_ = obj.getcustmrpono();
          natcode_ = obj.getnatcode();
          grpcode_ = obj.getgrpcode();
          docnumppd_ = obj.getdocnumppd();
          basetype_ = obj.getbasetype();
          basebatch_ = obj.getbasebatch();
          baseentry_ = obj.getbaseentry();
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

      public void setdocnumapplto(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnumapplto_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnumapplto() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnumapplto_; 
      } 

      public void setdocdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docdate_; 
      } 

      public void setdocduedate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docduedate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocduedate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docduedate_; 
      } 

      public void setdiscdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdiscdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discdate_; 
      } 

      public void setswpaid(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swpaid_ = param; 
         _isDirty_ = true; 
      } 

      public String getswpaid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swpaid_; 
      } 

      public void setdoctotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalamt_; 
      } 

      public void setdisctotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         disctotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdisctotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return disctotalamt_; 
      } 

      public void setdisctotalamtr(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         disctotalamtr_ = param; 
         _isDirty_ = true; 
      } 

      public double getdisctotalamtr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return disctotalamtr_; 
      } 

      public void setdoctotalpayamtr(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalpayamtr_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalpayamtr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalpayamtr_; 
      } 

      public void setpndtotalpayamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pndtotalpayamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpndtotalpayamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pndtotalpayamt_; 
      } 

      public void setpnddisctotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pnddisctotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpnddisctotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pnddisctotalamt_; 
      } 

      public void setpndadjusttotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pndadjusttotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getpndadjusttotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pndadjusttotalamt_; 
      } 

      public void setorderno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         orderno_ = param; 
         _isDirty_ = true; 
      } 

      public String getorderno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return orderno_; 
      } 

      public void setcustmrpono(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custmrpono_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustmrpono() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custmrpono_; 
      } 

      public void setnatcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         natcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getnatcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return natcode_; 
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

      public void setdocnumppd(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docnumppd_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocnumppd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docnumppd_; 
      } 

      public void setbasetype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         basetype_ = param; 
         _isDirty_ = true; 
      } 

      public long getbasetype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return basetype_; 
      } 

      public void setbasebatch(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         basebatch_ = param; 
         _isDirty_ = true; 
      } 

      public long getbasebatch() throws CodeException {
         if (!_isLoaded_) { read();} 
         return basebatch_; 
      } 

      public void setbaseentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         baseentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getbaseentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return baseentry_; 
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
        
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getcustmrcode(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO)) return getdocnumapplto(); 
           else if (param.equals(PROPERTY_DOCDATE)) return getdocdate(); 
           else if (param.equals(PROPERTY_DOCDUEDATE)) return getdocduedate(); 
           else if (param.equals(PROPERTY_DISCDATE)) return getdiscdate(); 
           else if (param.equals(PROPERTY_SWPAID)) return getswpaid(); 
           else if (param.equals(PROPERTY_DOCTOTALAMT)) return decform.format(getdoctotalamt()); 
           else if (param.equals(PROPERTY_DISCTOTALAMT)) return decform.format(getdisctotalamt()); 
           else if (param.equals(PROPERTY_DISCTOTALAMTR)) return decform.format(getdisctotalamtr()); 
           else if (param.equals(PROPERTY_DOCTOTALPAYAMTR)) return decform.format(getdoctotalpayamtr()); 
           else if (param.equals(PROPERTY_PNDTOTALPAYAMT)) return decform.format(getpndtotalpayamt()); 
           else if (param.equals(PROPERTY_PNDDISCTOTALAMT)) return decform.format(getpnddisctotalamt()); 
           else if (param.equals(PROPERTY_PNDADJUSTTOTALAMT)) return decform.format(getpndadjusttotalamt()); 
           else if (param.equals(PROPERTY_ORDERNO)) return getorderno(); 
           else if (param.equals(PROPERTY_CUSTMRPONO)) return getcustmrpono(); 
           else if (param.equals(PROPERTY_NATCODE)) return getnatcode(); 
           else if (param.equals(PROPERTY_GRPCODE)) return getgrpcode(); 
           else if (param.equals(PROPERTY_DOCNUMPPD)) return getdocnumppd(); 
           else if (param.equals(PROPERTY_BASETYPE)) return String.valueOf(getbasetype()); 
           else if (param.equals(PROPERTY_BASEBATCH)) return String.valueOf(getbasebatch()); 
           else if (param.equals(PROPERTY_BASEENTRY)) return String.valueOf(getbaseentry()); 
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
        
           else if (param.equals(PROPERTY_CUSTMRCODE))  setcustmrcode(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO))  setdocnumapplto(value); 
           else if (param.equals(PROPERTY_DOCDATE))  setdocdate(value); 
           else if (param.equals(PROPERTY_DOCDUEDATE))  setdocduedate(value); 
           else if (param.equals(PROPERTY_DISCDATE))  setdiscdate(value); 
           else if (param.equals(PROPERTY_SWPAID))  setswpaid(value); 
           else if (param.equals(PROPERTY_DOCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdisctotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCTOTALAMTR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdisctotalamtr(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCTOTALPAYAMTR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalpayamtr(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PNDTOTALPAYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpndtotalpayamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PNDDISCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpnddisctotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PNDADJUSTTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpndadjusttotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ORDERNO))  setorderno(value); 
           else if (param.equals(PROPERTY_CUSTMRPONO))  setcustmrpono(value); 
           else if (param.equals(PROPERTY_NATCODE))  setnatcode(value); 
           else if (param.equals(PROPERTY_GRPCODE))  setgrpcode(value); 
           else if (param.equals(PROPERTY_DOCNUMPPD))  setdocnumppd(value); 
           else if (param.equals(PROPERTY_BASETYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbasetype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BASEBATCH)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbasebatch(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BASEENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setbaseentry(newVal); 
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
            throw new CodeException("Ar_invobs : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_invobs : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_invobs : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_invobs : Cannot Move Last " + ex.getMessage());
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



