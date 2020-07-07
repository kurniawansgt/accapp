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


public abstract class Ar_invhAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ar_invh";

    public static final String TABLE = "ar_invh";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_CUSTMRCODE = "custmrcode";
    public static final String PROPERTY_ADDRCODE = "addrcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_SHPVIA = "shpvia";
    public static final String PROPERTY_SPECINSTR = "specinstr";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCNUM = "docnum";
    public static final String PROPERTY_DOCNUMAPPLTO = "docnumapplto";
    public static final String PROPERTY_DOCDATE = "docdate";
    public static final String PROPERTY_DOCDUEDATE = "docduedate";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_TAXCODE = "taxcode";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_CUSTMRPONO = "custmrpono";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_TERMCODE = "termcode";
    public static final String PROPERTY_DISCDATE = "discdate";
    public static final String PROPERTY_DISCPRCNT = "discprcnt";
    public static final String PROPERTY_DISCVALUEAMT = "discvalueamt";
    public static final String PROPERTY_SLPRSNCODE = "slprsncode";
    public static final String PROPERTY_ACCSETCODE = "accsetcode";
    public static final String PROPERTY_TAXBASE = "taxbase";
    public static final String PROPERTY_TAXAMT = "taxamt";
    public static final String PROPERTY_DOCTOTALAMT = "doctotalamt";
    public static final String PROPERTY_TAXTOTALAMT = "taxtotalamt";
    public static final String PROPERTY_DOCTOTALAFTTAXAMT = "doctotalafttaxamt";
    public static final String PROPERTY_PPDTOTALAMT = "ppdtotalamt";
    public static final String PROPERTY_DUEDOCTOTALAMT = "duedoctotalamt";
    public static final String PROPERTY_DOCNUMPPD = "docnumppd";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_NOMATERIALRECEIVE = "nomaterialreceive";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private long batchno_;
    private long docentry_;
    private String custmrcode_;
    private String addrcode_;
    private String curnccode_;
    private String shpvia_;
    private String specinstr_;
    private String doctype_;
    private String docnum_;
    private String docnumapplto_;
    private String docdate_;
    private String docduedate_;
    private long yop_;
    private long mop_;
    private String dscription_;
    private String taxcode_;
    private String orderno_;
    private String custmrpono_;
    private double rate_;
    private String termcode_;
    private String discdate_;
    private double discprcnt_;
    private double discvalueamt_;
    private String slprsncode_;
    private String accsetcode_;
    private double taxbase_;
    private double taxamt_;
    private double doctotalamt_;
    private double taxtotalamt_;
    private double doctotalafttaxamt_;
    private double ppdtotalamt_;
    private double duedoctotalamt_;
    private String docnumppd_;
    private long objtype_;
    private String nomaterialreceive_;
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

    public Ar_invhAbst() throws CodeException {
        loadNew();
    }
    
    public Ar_invhAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ar_invhAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ar_invhAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ar_invhAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ar_invhAbst for Key : " + key + " val : " + val);
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
           custmrcode_ = rs.getString(PROPERTY_CUSTMRCODE); 
           addrcode_ = rs.getString(PROPERTY_ADDRCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           shpvia_ = rs.getString(PROPERTY_SHPVIA); 
           specinstr_ = rs.getString(PROPERTY_SPECINSTR); 
           doctype_ = rs.getString(PROPERTY_DOCTYPE); 
           docnum_ = rs.getString(PROPERTY_DOCNUM); 
           docnumapplto_ = rs.getString(PROPERTY_DOCNUMAPPLTO); 
           docdate_ = rs.getString(PROPERTY_DOCDATE); 
           docduedate_ = rs.getString(PROPERTY_DOCDUEDATE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           taxcode_ = rs.getString(PROPERTY_TAXCODE); 
           orderno_ = rs.getString(PROPERTY_ORDERNO); 
           custmrpono_ = rs.getString(PROPERTY_CUSTMRPONO); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           termcode_ = rs.getString(PROPERTY_TERMCODE); 
           discdate_ = rs.getString(PROPERTY_DISCDATE); 
           discprcnt_ = rs.getDouble(PROPERTY_DISCPRCNT); 
           discvalueamt_ = rs.getDouble(PROPERTY_DISCVALUEAMT); 
           slprsncode_ = rs.getString(PROPERTY_SLPRSNCODE); 
           accsetcode_ = rs.getString(PROPERTY_ACCSETCODE); 
           taxbase_ = rs.getDouble(PROPERTY_TAXBASE); 
           taxamt_ = rs.getDouble(PROPERTY_TAXAMT); 
           doctotalamt_ = rs.getDouble(PROPERTY_DOCTOTALAMT); 
           taxtotalamt_ = rs.getDouble(PROPERTY_TAXTOTALAMT); 
           doctotalafttaxamt_ = rs.getDouble(PROPERTY_DOCTOTALAFTTAXAMT); 
           ppdtotalamt_ = rs.getDouble(PROPERTY_PPDTOTALAMT); 
           duedoctotalamt_ = rs.getDouble(PROPERTY_DUEDOCTOTALAMT); 
           docnumppd_ = rs.getString(PROPERTY_DOCNUMPPD); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           nomaterialreceive_ = rs.getString(PROPERTY_NOMATERIALRECEIVE);
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ar_invhAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ar_invh obj = (Ar_invh)cache.get(getID());
            if (obj!=null) {
                copy((CodeObjectInt) obj);
            }else{
                DbBean db = DbBean.connect();        
                ResultSet rs = db.retrieve(TABLEPROCESS, PROPERTY_ID, getID());
                try{
                    rs.next();
                    load(rs);
                    rs.close();
                    cache.add(this);
                }catch (SQLException e) {
                    throw new CodeException("Error Reading Ar_invh " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ar_invh ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ar_invh " + e.getMessage());
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
            rs.updateString(PROPERTY_CUSTMRCODE , custmrcode_ ); 
            rs.updateString(PROPERTY_ADDRCODE , addrcode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_SHPVIA , shpvia_ ); 
            rs.updateString(PROPERTY_SPECINSTR , specinstr_ ); 
            rs.updateString(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateString(PROPERTY_DOCNUM , docnum_ ); 
            rs.updateString(PROPERTY_DOCNUMAPPLTO , docnumapplto_ ); 
            rs.updateString(PROPERTY_DOCDATE , docdate_ ); 
            rs.updateString(PROPERTY_DOCDUEDATE , docduedate_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_TAXCODE , taxcode_ ); 
            rs.updateString(PROPERTY_ORDERNO , orderno_ ); 
            rs.updateString(PROPERTY_CUSTMRPONO , custmrpono_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateString(PROPERTY_TERMCODE , termcode_ ); 
            rs.updateString(PROPERTY_DISCDATE , discdate_ ); 
            rs.updateDouble(PROPERTY_DISCPRCNT , discprcnt_ ); 
            rs.updateDouble(PROPERTY_DISCVALUEAMT , discvalueamt_ ); 
            rs.updateString(PROPERTY_SLPRSNCODE , slprsncode_ ); 
            rs.updateString(PROPERTY_ACCSETCODE , accsetcode_ ); 
            rs.updateDouble(PROPERTY_TAXBASE , taxbase_ ); 
            rs.updateDouble(PROPERTY_TAXAMT , taxamt_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALAMT , doctotalamt_ ); 
            rs.updateDouble(PROPERTY_TAXTOTALAMT , taxtotalamt_ ); 
            rs.updateDouble(PROPERTY_DOCTOTALAFTTAXAMT , doctotalafttaxamt_ ); 
            rs.updateDouble(PROPERTY_PPDTOTALAMT , ppdtotalamt_ ); 
            rs.updateDouble(PROPERTY_DUEDOCTOTALAMT , duedoctotalamt_ ); 
            rs.updateString(PROPERTY_DOCNUMPPD , docnumppd_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_NOMATERIALRECEIVE, nomaterialreceive_);
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditdate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Ar_invh obj = (Ar_invh) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          docentry_ = obj.getdocentry();
          custmrcode_ = obj.getcustmrcode();
          addrcode_ = obj.getaddrcode();
          curnccode_ = obj.getcurnccode();
          shpvia_ = obj.getshpvia();
          specinstr_ = obj.getspecinstr();
          doctype_ = obj.getdoctype();
          docnum_ = obj.getdocnum();
          docnumapplto_ = obj.getdocnumapplto();
          docdate_ = obj.getdocdate();
          docduedate_ = obj.getdocduedate();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          dscription_ = obj.getdscription();
          taxcode_ = obj.gettaxcode();
          orderno_ = obj.getorderno();
          custmrpono_ = obj.getcustmrpono();
          rate_ = obj.getrate();
          termcode_ = obj.gettermcode();
          discdate_ = obj.getdiscdate();
          discprcnt_ = obj.getdiscprcnt();
          discvalueamt_ = obj.getdiscvalueamt();
          slprsncode_ = obj.getslprsncode();
          accsetcode_ = obj.getaccsetcode();
          taxbase_ = obj.gettaxbase();
          taxamt_ = obj.gettaxamt();
          doctotalamt_ = obj.getdoctotalamt();
          taxtotalamt_ = obj.gettaxtotalamt();
          doctotalafttaxamt_ = obj.getdoctotalafttaxamt();
          ppdtotalamt_ = obj.getppdtotalamt();
          duedoctotalamt_ = obj.getduedoctotalamt();
          docnumppd_ = obj.getdocnumppd();
          objtype_ = obj.getobjtype();
          nomaterialreceive_ = obj.getnomaterialreceive();
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

      public void setshpvia(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         shpvia_ = param; 
         _isDirty_ = true; 
      } 

      public String getshpvia() throws CodeException {
         if (!_isLoaded_) { read();} 
         return shpvia_; 
      } 

      public void setspecinstr(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         specinstr_ = param; 
         _isDirty_ = true; 
      } 

      public String getspecinstr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return specinstr_; 
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

      public void setdscription(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dscription_ = param; 
         _isDirty_ = true; 
      } 

      public String getdscription() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dscription_; 
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

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
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

      public void setdiscdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getdiscdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discdate_; 
      } 

      public void setdiscprcnt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discprcnt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdiscprcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discprcnt_; 
      } 

      public void setdiscvalueamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         discvalueamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdiscvalueamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return discvalueamt_; 
      } 

      public void setslprsncode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         slprsncode_ = param; 
         _isDirty_ = true; 
      } 

      public String getslprsncode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return slprsncode_; 
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

      public void settaxbase(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxbase_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxbase() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxbase_; 
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

      public void setdoctotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalamt_; 
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

      public void setdoctotalafttaxamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         doctotalafttaxamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getdoctotalafttaxamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return doctotalafttaxamt_; 
      } 

      public void setppdtotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ppdtotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getppdtotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ppdtotalamt_; 
      } 

      public void setduedoctotalamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         duedoctotalamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getduedoctotalamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return duedoctotalamt_; 
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

      public void setobjtype(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         objtype_ = param; 
         _isDirty_ = true; 
      } 

      public long getobjtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return objtype_; 
      } 
      
      public void setnomaterialreceive(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nomaterialreceive_ = param; 
         _isDirty_ = true; 
      } 

      public String getnomaterialreceive() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nomaterialreceive_; 
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
           else if (param.equals(PROPERTY_CUSTMRCODE)) return getcustmrcode(); 
           else if (param.equals(PROPERTY_ADDRCODE)) return getaddrcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_SHPVIA)) return getshpvia(); 
           else if (param.equals(PROPERTY_SPECINSTR)) return getspecinstr(); 
           else if (param.equals(PROPERTY_DOCTYPE)) return getdoctype(); 
           else if (param.equals(PROPERTY_DOCNUM)) return getdocnum(); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO)) return getdocnumapplto(); 
           else if (param.equals(PROPERTY_DOCDATE)) return getdocdate(); 
           else if (param.equals(PROPERTY_DOCDUEDATE)) return getdocduedate(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_TAXCODE)) return gettaxcode(); 
           else if (param.equals(PROPERTY_ORDERNO)) return getorderno(); 
           else if (param.equals(PROPERTY_CUSTMRPONO)) return getcustmrpono(); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_TERMCODE)) return gettermcode(); 
           else if (param.equals(PROPERTY_DISCDATE)) return getdiscdate(); 
           else if (param.equals(PROPERTY_DISCPRCNT)) return decform.format(getdiscprcnt()); 
           else if (param.equals(PROPERTY_DISCVALUEAMT)) return decform.format(getdiscvalueamt()); 
           else if (param.equals(PROPERTY_SLPRSNCODE)) return getslprsncode(); 
           else if (param.equals(PROPERTY_ACCSETCODE)) return getaccsetcode(); 
           else if (param.equals(PROPERTY_TAXBASE)) return decform.format(gettaxbase()); 
           else if (param.equals(PROPERTY_TAXAMT)) return decform.format(gettaxamt()); 
           else if (param.equals(PROPERTY_DOCTOTALAMT)) return decform.format(getdoctotalamt()); 
           else if (param.equals(PROPERTY_TAXTOTALAMT)) return decform.format(gettaxtotalamt()); 
           else if (param.equals(PROPERTY_DOCTOTALAFTTAXAMT)) return decform.format(getdoctotalafttaxamt()); 
           else if (param.equals(PROPERTY_PPDTOTALAMT)) return decform.format(getppdtotalamt()); 
           else if (param.equals(PROPERTY_DUEDOCTOTALAMT)) return decform.format(getduedoctotalamt()); 
           else if (param.equals(PROPERTY_DOCNUMPPD)) return getdocnumppd(); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype());
           else if (param.equals(PROPERTY_NOMATERIALRECEIVE)) return String.valueOf(getnomaterialreceive());
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
           else if (param.equals(PROPERTY_CUSTMRCODE))  setcustmrcode(value); 
           else if (param.equals(PROPERTY_ADDRCODE))  setaddrcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_SHPVIA))  setshpvia(value); 
           else if (param.equals(PROPERTY_SPECINSTR))  setspecinstr(value); 
           else if (param.equals(PROPERTY_DOCTYPE))  setdoctype(value); 
           else if (param.equals(PROPERTY_DOCNUM))  setdocnum(value); 
           else if (param.equals(PROPERTY_DOCNUMAPPLTO))  setdocnumapplto(value); 
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
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_TAXCODE))  settaxcode(value); 
           else if (param.equals(PROPERTY_ORDERNO))  setorderno(value); 
           else if (param.equals(PROPERTY_CUSTMRPONO))  setcustmrpono(value); 
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TERMCODE))  settermcode(value); 
           else if (param.equals(PROPERTY_DISCDATE))  setdiscdate(value); 
           else if (param.equals(PROPERTY_DISCPRCNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdiscprcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DISCVALUEAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdiscvalueamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SLPRSNCODE))  setslprsncode(value); 
           else if (param.equals(PROPERTY_ACCSETCODE))  setaccsetcode(value); 
           else if (param.equals(PROPERTY_TAXBASE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxbase(newVal); 
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
           else if (param.equals(PROPERTY_DOCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalamt(newVal); 
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
           else if (param.equals(PROPERTY_DOCTOTALAFTTAXAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setdoctotalafttaxamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PPDTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setppdtotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DUEDOCTOTALAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setduedoctotalamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DOCNUMPPD))  setdocnumppd(value); 
           else if (param.equals(PROPERTY_OBJTYPE)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setobjtype(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NOMATERIALRECEIVE))  setnomaterialreceive(value);
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
            throw new CodeException("Ar_invh : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Ar_invh : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Ar_invh : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ar_invh : Cannot Move Last " + ex.getMessage());
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



