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


public abstract class Ar_invoblAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_invobl";

    public static final String TABLE = "ar_invobl";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_ADDRCODE = "addrcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_DOCDATE = "docdate";
    public static final String PROPERTY_DOCDUEDATE = "docduedate";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_DISCDATE = "discdate";
    public static final String PROPERTY_RCPNO = "rcpno";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_CUSTMRPONO = "custmrpono";
    public static final String PROPERTY_NATCODE = "natcode";
    public static final String PROPERTY_TRANTYPE = "trantype";
    public static final String PROPERTY_TRANTYPETXT = "trantypetxt";
    public static final String PROPERTY_GRPCODE = "grpcode";
    public static final String PROPERTY_INVDESC = "invdesc";
    public static final String PROPERTY_TERMCODE = "termcode";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_DOCTOTALAMT = "doctotalamt";
    public static final String PROPERTY_DOCTOTALAMTR = "doctotalamtr";
    public static final String PROPERTY_TAXABLETOTALAMT = "taxabletotalamt";
    public static final String PROPERTY_NONTAXABLETOTALAMT = "nontaxabletotalamt";
    public static final String PROPERTY_TAXTOTALAMT = "taxtotalamt";
    public static final String PROPERTY_RCPTOTALAMT = "rcptotalamt";
    public static final String PROPERTY_SWPAID = "swpaid";
    public static final String PROPERTY_TAXCODE = "taxcode";
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
    private String addrcode_;
    private String curnccode_;
    private String doctype_;
    private String docnum_;
    private String docdate_;
    private String docduedate_;
    private long yop_;
    private long mop_;
    private String discdate_;
    private String rcpno_;
    private String orderno_;
    private String custmrpono_;
    private String natcode_;
    private long trantype_;
    private long trantypetxt_;
    private String grpcode_;
    private String invdesc_;
    private String termcode_;
    private double rate_;
    private double doctotalamt_;
    private double doctotalamtr_;
    private double taxabletotalamt_;
    private double nontaxabletotalamt_;
    private double taxtotalamt_;
    private double rcptotalamt_;
    private String swpaid_;
    private String taxcode_;
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

    public Ar_invoblAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_invoblAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_invoblAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_invoblAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_invoblAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_invoblAbst for Key : " + key + " val : " + val);
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
           addrcode_ = rs.getString(PROPERTY_ADDRCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           doctype_ = rs.getString(PROPERTY_DOCTYPE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           docdate_ = rs.getString(PROPERTY_DOCDATE); 
           docduedate_ = rs.getString(PROPERTY_DOCDUEDATE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           discdate_ = rs.getString(PROPERTY_DISCDATE); 
           rcpno_ = rs.getString(PROPERTY_RCPNO); 
           orderno_ = rs.getString(PROPERTY_ORDERNO); 
           custmrpono_ = rs.getString(PROPERTY_CUSTMRPONO); 
           natcode_ = rs.getString(PROPERTY_NATCODE); 
           trantype_ = rs.getLong(PROPERTY_TRANTYPE); 
           trantypetxt_ = rs.getLong(PROPERTY_TRANTYPETXT); 
           grpcode_ = rs.getString(PROPERTY_GRPCODE); 
           invdesc_ = rs.getString(PROPERTY_INVDESC); 
           termcode_ = rs.getString(PROPERTY_TERMCODE); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           doctotalamt_ = rs.getDouble(PROPERTY_DOCTOTALAMT); 
           doctotalamtr_ = rs.getDouble(PROPERTY_DOCTOTALAMTR); 
           taxabletotalamt_ = rs.getDouble(PROPERTY_TAXABLETOTALAMT); 
           nontaxabletotalamt_ = rs.getDouble(PROPERTY_NONTAXABLETOTALAMT); 
           taxtotalamt_ = rs.getDouble(PROPERTY_TAXTOTALAMT); 
           rcptotalamt_ = rs.getDouble(PROPERTY_RCPTOTALAMT); 
           swpaid_ = rs.getString(PROPERTY_SWPAID); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
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
            throw new CodeException ("Error Loading Ar_invoblAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_invobl obj = (Ar_invobl)cache.get(getID());
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
                    throw new CodeException("Error Reading Ar_invobl " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_invobl ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_invobl " + e.getMessage());
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
            rs.updateString(PROPERTY_ADDRCODE , addrcode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateString(PROPERTY_DOCDATE , docdate_ ); 
            rs.updateString(PROPERTY_DOCDUEDATE , docduedate_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_DISCDATE , discdate_ ); 
            rs.updateString(PROPERTY_RCPNO , rcpno_ ); 
            rs.updateString(PROPERTY_ORDERNO , orderno_ ); 
            rs.updateString(PROPERTY_CUSTMRPONO , custmrpono_ ); 
            rs.updateString(PROPERTY_NATCODE , natcode_ ); 
            rs.updateLong(PROPERTY_TRANTYPE , trantype_ ); 
            rs.updateLong(PROPERTY_TRANTYPETXT , trantypetxt_ ); 
            rs.updateString(PROPERTY_GRPCODE , grpcode_ ); 
            rs.updateString(PROPERTY_INVDESC , invdesc_ ); 
            rs.updateString(PROPERTY_TERMCODE , termcode_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALAMT , doctotalamt_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALAMTR , doctotalamtr_ ); 
            rs.updateDouble(PROPERTY_TAXABLETOTALAMT , taxabletotalamt_ ); 
            rs.updateDouble(PROPERTY_NONTAXABLETOTALAMT , nontaxabletotalamt_ ); 
            rs.updateDouble(PROPERTY_TAXTOTALAMT , taxtotalamt_ ); 
            rs.updateDouble(PROPERTY_RCPTOTALAMT , rcptotalamt_ ); 
            rs.updateString(PROPERTY_SWPAID , swpaid_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
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
        Ar_invobl obj = (Ar_invobl) jCob;
        id_ = obj.getID();

        
          custmrcode_ = obj.getcustmrcode();
          addrcode_ = obj.getaddrcode();
          curnccode_ = obj.getcurnccode();
          doctype_ = obj.getdoctype();
          docnum_ = obj.getdocnum();
          docdate_ = obj.getdocdate();
          docduedate_ = obj.getdocduedate();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          discdate_ = obj.getdiscdate();
          rcpno_ = obj.getrcpno();
          orderno_ = obj.getorderno();
          custmrpono_ = obj.getcustmrpono();
          natcode_ = obj.getnatcode();
          trantype_ = obj.gettrantype();
          trantypetxt_ = obj.gettrantypetxt();
          grpcode_ = obj.getgrpcode();
          invdesc_ = obj.getinvdesc();
          termcode_ = obj.gettermcode();
          rate_ = obj.getrate();
          doctotalamt_ = obj.getdoctotalamt();
          doctotalamtr_ = obj.getdoctotalamtr();
          taxabletotalamt_ = obj.gettaxabletotalamt();
          nontaxabletotalamt_ = obj.getnontaxabletotalamt();
          taxtotalamt_ = obj.gettaxtotalamt();
          rcptotalamt_ = obj.getrcptotalamt();
          swpaid_ = obj.getswpaid();
          taxcode_ = obj.gettaxcode();
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

      public void setaddrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         addrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getaddrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return addrcode_; 
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

      public void setdoctype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctype_ = param; 
         _isDirty_ = true; 
      } 

      public String getdoctype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctype_; 
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

      public void setdiscdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdiscdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discdate_; 
      } 

      public void setrcpno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcpno_ = param; 
         _isDirty_ = true; 
      } 

      public String getrcpno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcpno_; 
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

      public void settrantype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         trantype_ = param; 
         _isDirty_ = true; 
      } 

      public long gettrantype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return trantype_; 
      } 

      public void settrantypetxt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         trantypetxt_ = param; 
         _isDirty_ = true; 
      } 

      public long gettrantypetxt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return trantypetxt_; 
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

      public void setinvdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         invdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getinvdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return invdesc_; 
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

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
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

      public void setdoctotalamtr(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalamtr_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalamtr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalamtr_; 
      } 

      public void settaxabletotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxabletotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxabletotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxabletotalamt_; 
      } 

      public void setnontaxabletotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nontaxabletotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getnontaxabletotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nontaxabletotalamt_; 
      } 

      public void settaxtotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxtotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxtotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxtotalamt_; 
      } 

      public void setrcptotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rcptotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getrcptotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rcptotalamt_; 
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

      public void settaxcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxcode_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxcode_; 
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
           else if (param.equals(PROPERTY_ADDRCODE)) return getaddrcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_DOCTYPE)) return getdoctype(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_DOCDATE)) return getdocdate(); 
           else if (param.equals(PROPERTY_DOCDUEDATE)) return getdocduedate(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_DISCDATE)) return getdiscdate(); 
           else if (param.equals(PROPERTY_RCPNO)) return getrcpno(); 
           else if (param.equals(PROPERTY_ORDERNO)) return getorderno(); 
           else if (param.equals(PROPERTY_CUSTMRPONO)) return getcustmrpono(); 
           else if (param.equals(PROPERTY_NATCODE)) return getnatcode(); 
           else if (param.equals(PROPERTY_TRANTYPE)) return String.valueOf(gettrantype()); 
           else if (param.equals(PROPERTY_TRANTYPETXT)) return String.valueOf(gettrantypetxt()); 
           else if (param.equals(PROPERTY_GRPCODE)) return getgrpcode(); 
           else if (param.equals(PROPERTY_INVDESC)) return getinvdesc(); 
           else if (param.equals(PROPERTY_TERMCODE)) return gettermcode(); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_DOCTOTALAMT)) return decform.format(getdoctotalamt()); 
           else if (param.equals(PROPERTY_DOCTOTALAMTR)) return decform.format(getdoctotalamtr()); 
           else if (param.equals(PROPERTY_TAXABLETOTALAMT)) return decform.format(gettaxabletotalamt()); 
           else if (param.equals(PROPERTY_NONTAXABLETOTALAMT)) return decform.format(getnontaxabletotalamt()); 
           else if (param.equals(PROPERTY_TAXTOTALAMT)) return decform.format(gettaxtotalamt()); 
           else if (param.equals(PROPERTY_RCPTOTALAMT)) return decform.format(getrcptotalamt()); 
           else if (param.equals(PROPERTY_SWPAID)) return getswpaid(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
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
           else if (param.equals(PROPERTY_ADDRCODE))  setaddrcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_DOCTYPE))  setdoctype(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_DOCDATE))  setdocdate(value); 
           else if (param.equals(PROPERTY_DOCDUEDATE))  setdocduedate(value); 
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
           else if (param.equals(PROPERTY_DISCDATE))  setdiscdate(value); 
           else if (param.equals(PROPERTY_RCPNO))  setrcpno(value); 
           else if (param.equals(PROPERTY_ORDERNO))  setorderno(value); 
           else if (param.equals(PROPERTY_CUSTMRPONO))  setcustmrpono(value); 
           else if (param.equals(PROPERTY_NATCODE))  setnatcode(value); 
           else if (param.equals(PROPERTY_TRANTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settrantype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRANTYPETXT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settrantypetxt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GRPCODE))  setgrpcode(value); 
           else if (param.equals(PROPERTY_INVDESC))  setinvdesc(value); 
           else if (param.equals(PROPERTY_TERMCODE))  settermcode(value); 
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCTOTALAMTR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalamtr(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXABLETOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxabletotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NONTAXABLETOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setnontaxabletotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxtotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RCPTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrcptotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SWPAID))  setswpaid(value); 
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
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
            throw new CodeException("Ar_invobl : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_invobl : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_invobl : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_invobl : Cannot Move Last " + ex.getMessage());
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



