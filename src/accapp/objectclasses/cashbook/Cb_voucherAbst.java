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



public abstract class Cb_voucherAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_voucher";

    public static final String TABLE = "cb_voucher";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_ENTRYNO = "entryno";
    public static final String PROPERTY_ENTRYTYPE = "entrytype";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_BATCHDATE = "batchdate";
    public static final String PROPERTY_MISCCODE = "misccode";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_DISTCODE = "distcode";
    public static final String PROPERTY_SRCECURNCCODE = "srcecurnccode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_RATEDATE = "ratedate";
    public static final String PROPERTY_RATEAMOUNT = "rateamount";
    public static final String PROPERTY_NODETATAILS = "nodetatails";
    public static final String PROPERTY_TOTAMOUNT = "totamount";
    public static final String PROPERTY_TOTTAX = "tottax";
    public static final String PROPERTY_TAXPERCENT = "taxpercent";
    public static final String PROPERTY_CASH = "cash";
    public static final String PROPERTY_BATCNODECIMAL = "batcnodecimal";
    public static final String PROPERTY_MISCNODECIMAL = "miscnodecimal";
    public static final String PROPERTY_TAXGROUP = "taxgroup";
    public static final String PROPERTY_CUSTCHEQNO = "custcheqno";
    public static final String PROPERTY_NOSUBDETAIL = "nosubdetail";
    public static final String PROPERTY_APPLAMOUNT = "applamount";
    public static final String PROPERTY_APPLDISC = "appldisc";
    public static final String PROPERTY_NATACCNO = "nataccno";
    public static final String PROPERTY_ADJTAMOUNT = "adjtamount";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_BANKCODE = "bankcode";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double batchno_;
    private long entryno_;
    private String entrytype_;
    private String reference_;
    private long yop_;
    private long mop_;
    private String batchdate_;
    private String misccode_;
    private String dscription_;
    private String distcode_;
    private String srcecurnccode_;
    private String curnccode_;
    private String ratetype_;
    private String ratedate_;
    private double rateamount_;
    private long nodetatails_;
    private double totamount_;
    private double tottax_;
    private double taxpercent_;
    private double cash_;
    private double batcnodecimal_;
    private double miscnodecimal_;
    private String taxgroup_;
    private String custcheqno_;
    private long nosubdetail_;
    private double applamount_;
    private double appldisc_;
    private String nataccno_;
    private double adjtamount_;
    private long objtype_;
    private String entrydate_;
    private String auditdate_;
    private String audituser_;
    private String cmpnyid_;
    private String docstatus_;
    private String doctype_;
    private String bankcode_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Cb_voucherAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_voucherAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_voucherAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_voucherAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_voucherAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_voucherAbst for Key : " + key + " val : " + val);
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
            
            
            
           batchno_ = rs.getDouble(PROPERTY_BATCHNO); 
           entryno_ = rs.getLong(PROPERTY_ENTRYNO); 
           entrytype_ = rs.getString(PROPERTY_ENTRYTYPE); 
           reference_ = rs.getString(PROPERTY_REFERENCE); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           batchdate_ = rs.getString(PROPERTY_BATCHDATE); 
           misccode_ = rs.getString(PROPERTY_MISCCODE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           distcode_ = rs.getString(PROPERTY_DISTCODE); 
           srcecurnccode_ = rs.getString(PROPERTY_SRCECURNCCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           ratedate_ = rs.getString(PROPERTY_RATEDATE); 
           rateamount_ = rs.getDouble(PROPERTY_RATEAMOUNT); 
           nodetatails_ = rs.getLong(PROPERTY_NODETATAILS); 
           totamount_ = rs.getDouble(PROPERTY_TOTAMOUNT); 
           tottax_ = rs.getDouble(PROPERTY_TOTTAX); 
           taxpercent_ = rs.getDouble(PROPERTY_TAXPERCENT); 
           cash_ = rs.getDouble(PROPERTY_CASH); 
           batcnodecimal_ = rs.getDouble(PROPERTY_BATCNODECIMAL); 
           miscnodecimal_ = rs.getDouble(PROPERTY_MISCNODECIMAL); 
           taxgroup_ = rs.getString(PROPERTY_TAXGROUP); 
           custcheqno_ = rs.getString(PROPERTY_CUSTCHEQNO); 
           nosubdetail_ = rs.getLong(PROPERTY_NOSUBDETAIL); 
           applamount_ = rs.getDouble(PROPERTY_APPLAMOUNT); 
           appldisc_ = rs.getDouble(PROPERTY_APPLDISC); 
           nataccno_ = rs.getString(PROPERTY_NATACCNO); 
           adjtamount_ = rs.getDouble(PROPERTY_ADJTAMOUNT); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
           docstatus_ = rs.getString(PROPERTY_DOCSTATUS); 
           doctype_ = rs.getString(PROPERTY_DOCTYPE); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_voucherAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_voucher obj = (Cb_voucher)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_voucher " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbatchno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : batchno can not be Empty"); 
        } 
 
         o = getentryno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : entryno can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_voucher ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_voucher " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BATCHNO , batchno_ ); 
            rs.updateLong(PROPERTY_ENTRYNO , entryno_ ); 
            rs.updateString(PROPERTY_ENTRYTYPE , entrytype_ ); 
            rs.updateString(PROPERTY_REFERENCE , reference_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_BATCHDATE , batchdate_ ); 
            rs.updateString(PROPERTY_MISCCODE , misccode_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateString(PROPERTY_DISTCODE , distcode_ ); 
            rs.updateString(PROPERTY_SRCECURNCCODE , srcecurnccode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateString(PROPERTY_RATEDATE , ratedate_ ); 
            rs.updateDouble(PROPERTY_RATEAMOUNT , rateamount_ ); 
            rs.updateLong(PROPERTY_NODETATAILS , nodetatails_ ); 
            rs.updateDouble(PROPERTY_TOTAMOUNT , totamount_ ); 
            rs.updateDouble(PROPERTY_TOTTAX , tottax_ ); 
            rs.updateDouble(PROPERTY_TAXPERCENT , taxpercent_ ); 
            rs.updateDouble(PROPERTY_CASH , cash_ ); 
            rs.updateDouble(PROPERTY_BATCNODECIMAL , batcnodecimal_ ); 
            rs.updateDouble(PROPERTY_MISCNODECIMAL , miscnodecimal_ ); 
            rs.updateString(PROPERTY_TAXGROUP , taxgroup_ ); 
            rs.updateString(PROPERTY_CUSTCHEQNO , custcheqno_ ); 
            rs.updateLong(PROPERTY_NOSUBDETAIL , nosubdetail_ ); 
            rs.updateDouble(PROPERTY_APPLAMOUNT , applamount_ ); 
            rs.updateDouble(PROPERTY_APPLDISC , appldisc_ ); 
            rs.updateString(PROPERTY_NATACCNO , nataccno_ ); 
            rs.updateDouble(PROPERTY_ADJTAMOUNT , adjtamount_ ); 
            rs.updateLong(PROPERTY_OBJTYPE , objtype_ ); 
            rs.updateString(PROPERTY_ENTRYDATE , entrydate_ ); 
            rs.updateString(PROPERTY_AUDITDATE , auditdate_ ); 
            rs.updateString(PROPERTY_AUDITUSER , audituser_ ); 
            rs.updateString(PROPERTY_CMPNYID , cmpnyid_ ); 
            rs.updateString(PROPERTY_DOCSTATUS , docstatus_ ); 
            rs.updateString(PROPERTY_DOCTYPE , doctype_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Cb_voucher obj = (Cb_voucher) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          entryno_ = obj.getentryno();
          entrytype_ = obj.getentrytype();
          reference_ = obj.getreference();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          batchdate_ = obj.getbatchdate();
          misccode_ = obj.getmisccode();
          dscription_ = obj.getdscription();
          distcode_ = obj.getdistcode();
          srcecurnccode_ = obj.getsrcecurnccode();
          curnccode_ = obj.getcurnccode();
          ratetype_ = obj.getratetype();
          ratedate_ = obj.getratedate();
          rateamount_ = obj.getrateamount();
          nodetatails_ = obj.getnodetatails();
          totamount_ = obj.gettotamount();
          tottax_ = obj.gettottax();
          taxpercent_ = obj.gettaxpercent();
          cash_ = obj.getcash();
          batcnodecimal_ = obj.getbatcnodecimal();
          miscnodecimal_ = obj.getmiscnodecimal();
          taxgroup_ = obj.gettaxgroup();
          custcheqno_ = obj.getcustcheqno();
          nosubdetail_ = obj.getnosubdetail();
          applamount_ = obj.getapplamount();
          appldisc_ = obj.getappldisc();
          nataccno_ = obj.getnataccno();
          adjtamount_ = obj.getadjtamount();
          objtype_ = obj.getobjtype();
          entrydate_ = obj.getentrydate();
          auditdate_ = obj.getauditdate();
          audituser_ = obj.getaudituser();
          cmpnyid_ = obj.getcmpnyid();
          docstatus_ = obj.getdocstatus();
          doctype_ = obj.getdoctype();
          bankcode_ = obj.getbankcode();
                
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

    
      public void setbatchno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchno_ = param; 
         _isDirty_ = true; 
      } 

      public double getbatchno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchno_; 
      } 

      public void setentryno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entryno_ = param; 
         _isDirty_ = true; 
      } 

      public long getentryno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entryno_; 
      } 

      public void setentrytype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entrytype_ = param; 
         _isDirty_ = true; 
      } 

      public String getentrytype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entrytype_; 
      } 

      public void setreference(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         reference_ = param; 
         _isDirty_ = true; 
      } 

      public String getreference() throws CodeException {
         if (!_isLoaded_) { read();} 
         return reference_; 
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

      public void setbatchdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchdate_; 
      } 

      public void setmisccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         misccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getmisccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return misccode_; 
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

      public void setdistcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         distcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getdistcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return distcode_; 
      } 

      public void setsrcecurnccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcecurnccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcecurnccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcecurnccode_; 
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

      public void setratetype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratetype_ = param; 
         _isDirty_ = true; 
      } 

      public String getratetype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratetype_; 
      } 

      public void setratedate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratedate_ = param; 
         _isDirty_ = true; 
      } 

      public String getratedate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratedate_; 
      } 

      public void setrateamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rateamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getrateamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rateamount_; 
      } 

      public void setnodetatails(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nodetatails_ = param; 
         _isDirty_ = true; 
      } 

      public long getnodetatails() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nodetatails_; 
      } 

      public void settotamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         totamount_ = param; 
         _isDirty_ = true; 
      } 

      public double gettotamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return totamount_; 
      } 

      public void settottax(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         tottax_ = param; 
         _isDirty_ = true; 
      } 

      public double gettottax() throws CodeException {
         if (!_isLoaded_) { read();} 
         return tottax_; 
      } 

      public void settaxpercent(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxpercent_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxpercent() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxpercent_; 
      } 

      public void setcash(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cash_ = param; 
         _isDirty_ = true; 
      } 

      public double getcash() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cash_; 
      } 

      public void setbatcnodecimal(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batcnodecimal_ = param; 
         _isDirty_ = true; 
      } 

      public double getbatcnodecimal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batcnodecimal_; 
      } 

      public void setmiscnodecimal(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         miscnodecimal_ = param; 
         _isDirty_ = true; 
      } 

      public double getmiscnodecimal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return miscnodecimal_; 
      } 

      public void settaxgroup(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxgroup_ = param; 
         _isDirty_ = true; 
      } 

      public String gettaxgroup() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxgroup_; 
      } 

      public void setcustcheqno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         custcheqno_ = param; 
         _isDirty_ = true; 
      } 

      public String getcustcheqno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return custcheqno_; 
      } 

      public void setnosubdetail(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nosubdetail_ = param; 
         _isDirty_ = true; 
      } 

      public long getnosubdetail() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nosubdetail_; 
      } 

      public void setapplamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         applamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getapplamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return applamount_; 
      } 

      public void setappldisc(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         appldisc_ = param; 
         _isDirty_ = true; 
      } 

      public double getappldisc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return appldisc_; 
      } 

      public void setnataccno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nataccno_ = param; 
         _isDirty_ = true; 
      } 

      public String getnataccno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nataccno_; 
      } 

      public void setadjtamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjtamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjtamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjtamount_; 
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

      public void setdocstatus(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docstatus_ = param; 
         _isDirty_ = true; 
      } 

      public String getdocstatus() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docstatus_; 
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

      public void setbankcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankcode_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_BATCHNO)) return decform.format(getbatchno()); 
           else if (param.equals(PROPERTY_ENTRYNO)) return String.valueOf(getentryno()); 
           else if (param.equals(PROPERTY_ENTRYTYPE)) return getentrytype(); 
           else if (param.equals(PROPERTY_REFERENCE)) return getreference(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_BATCHDATE)) return getbatchdate(); 
           else if (param.equals(PROPERTY_MISCCODE)) return getmisccode(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_DISTCODE)) return getdistcode(); 
           else if (param.equals(PROPERTY_SRCECURNCCODE)) return getsrcecurnccode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_RATEDATE)) return getratedate(); 
           else if (param.equals(PROPERTY_RATEAMOUNT)) return decform.format(getrateamount()); 
           else if (param.equals(PROPERTY_NODETATAILS)) return String.valueOf(getnodetatails()); 
           else if (param.equals(PROPERTY_TOTAMOUNT)) return decform.format(gettotamount()); 
           else if (param.equals(PROPERTY_TOTTAX)) return decform.format(gettottax()); 
           else if (param.equals(PROPERTY_TAXPERCENT)) return decform.format(gettaxpercent()); 
           else if (param.equals(PROPERTY_CASH)) return decform.format(getcash()); 
           else if (param.equals(PROPERTY_BATCNODECIMAL)) return decform.format(getbatcnodecimal()); 
           else if (param.equals(PROPERTY_MISCNODECIMAL)) return decform.format(getmiscnodecimal()); 
           else if (param.equals(PROPERTY_TAXGROUP)) return gettaxgroup(); 
           else if (param.equals(PROPERTY_CUSTCHEQNO)) return getcustcheqno(); 
           else if (param.equals(PROPERTY_NOSUBDETAIL)) return String.valueOf(getnosubdetail()); 
           else if (param.equals(PROPERTY_APPLAMOUNT)) return decform.format(getapplamount()); 
           else if (param.equals(PROPERTY_APPLDISC)) return decform.format(getappldisc()); 
           else if (param.equals(PROPERTY_NATACCNO)) return getnataccno(); 
           else if (param.equals(PROPERTY_ADJTAMOUNT)) return decform.format(getadjtamount()); 
           else if (param.equals(PROPERTY_OBJTYPE)) return String.valueOf(getobjtype()); 
           else if (param.equals(PROPERTY_ENTRYDATE)) return getentrydate(); 
           else if (param.equals(PROPERTY_AUDITDATE)) return getauditdate(); 
           else if (param.equals(PROPERTY_AUDITUSER)) return getaudituser(); 
           else if (param.equals(PROPERTY_CMPNYID)) return getcmpnyid(); 
           else if (param.equals(PROPERTY_DOCSTATUS)) return getdocstatus(); 
           else if (param.equals(PROPERTY_DOCTYPE)) return getdoctype(); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
       
        
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
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbatchno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setentryno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ENTRYTYPE))  setentrytype(value); 
           else if (param.equals(PROPERTY_REFERENCE))  setreference(value); 
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
           else if (param.equals(PROPERTY_BATCHDATE))  setbatchdate(value); 
           else if (param.equals(PROPERTY_MISCCODE))  setmisccode(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
           else if (param.equals(PROPERTY_DISTCODE))  setdistcode(value); 
           else if (param.equals(PROPERTY_SRCECURNCCODE))  setsrcecurnccode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_RATETYPE))  setratetype(value); 
           else if (param.equals(PROPERTY_RATEDATE))  setratedate(value); 
           else if (param.equals(PROPERTY_RATEAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrateamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NODETATAILS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setnodetatails(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TOTAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settotamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TOTTAX)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settottax(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXPERCENT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxpercent(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CASH)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcash(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BATCNODECIMAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbatcnodecimal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MISCNODECIMAL)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setmiscnodecimal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXGROUP))  settaxgroup(value); 
           else if (param.equals(PROPERTY_CUSTCHEQNO))  setcustcheqno(value); 
           else if (param.equals(PROPERTY_NOSUBDETAIL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setnosubdetail(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_APPLAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setapplamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_APPLDISC)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setappldisc(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_NATACCNO))  setnataccno(value); 
           else if (param.equals(PROPERTY_ADJTAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjtamount(newVal); 
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
           else if (param.equals(PROPERTY_DOCSTATUS))  setdocstatus(value); 
           else if (param.equals(PROPERTY_DOCTYPE))  setdoctype(value); 
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
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
            throw new CodeException("Cb_voucher : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Cb_voucher : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Cb_voucher : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_voucher : Cannot Move Last " + ex.getMessage());
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



