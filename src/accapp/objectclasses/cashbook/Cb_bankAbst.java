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


public abstract class Cb_bankAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_bank";

    public static final String TABLE = "cb_bank";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_BANKNAME = "bankname";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_POSTALCODE = "postalcode";
    public static final String PROPERTY_PHONE1 = "phone1";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_FAXNO = "faxno";
    public static final String PROPERTY_CONTACT = "contact";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_BANKACCNO = "bankaccno";
    public static final String PROPERTY_SRCELEDGR = "srceledgr";
    public static final String PROPERTY_RVSLSRCECODE = "rvslsrcecode";
    public static final String PROPERTY_VOIDSRCECODE = "voidsrcecode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_RATETYPECODE = "ratetypecode";
    public static final String PROPERTY_NODECIMAL = "nodecimal";
    public static final String PROPERTY_DPLCTCHECK = "dplctcheck";
    public static final String PROPERTY_AUTOALLCT = "autoallct";
    public static final String PROPERTY_INCLDISCOUNT = "incldiscount";
    public static final String PROPERTY_OPENBALANCE = "openbalance";
    public static final String PROPERTY_CRNTBALANCE = "crntbalance";
    public static final String PROPERTY_BANKBALANCE = "bankbalance";
    public static final String PROPERTY_RUNOPENBALANCE = "runopenbalance";
    public static final String PROPERTY_RUNCRNTBALANCE = "runcrntbalance";
    public static final String PROPERTY_RUNBANKBALANCE = "runbankbalance";
    public static final String PROPERTY_LASTUPDATE = "lastupdate";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_BANKACCCODE = "bankacccode";
    public static final String PROPERTY_VOIDACCCODE = "voidacccode";
    public static final String PROPERTY_TRNFCLRACCCODE = "trnfclracccode";
    public static final String PROPERTY_CASHCLRACCCODE = "cashclracccode";
    public static final String PROPERTY_ARCLRACCCODE = "arclracccode";
    public static final String PROPERTY_APCLRACCODE = "apclraccode";
    public static final String PROPERTY_JCCLRACCCODE = "jcclracccode";
    public static final String PROPERTY_PRCLRACCCODE = "prclracccode";
    public static final String PROPERTY_APBANKACCCODE = "apbankacccode";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_BANKCODE;
    
    
    private long id_;
    private String bankcode_;
    private String bankname_;
    private String address1_;
    private String address2_;
    private String city_;
    private String state_;
    private String postalcode_;
    private String phone1_;
    private String phone2_;
    private String faxno_;
    private String contact_;
    private String comments_;
    private String bankaccno_;
    private String srceledgr_;
    private String rvslsrcecode_;
    private String voidsrcecode_;
    private String curnccode_;
    private String ratetypecode_;
    private long nodecimal_;
    private long dplctcheck_;
    private long autoallct_;
    private long incldiscount_;
    private double openbalance_;
    private double crntbalance_;
    private double bankbalance_;
    private double runopenbalance_;
    private double runcrntbalance_;
    private double runbankbalance_;
    private String lastupdate_;
    private String startdate_;
    private String enddate_;
    private String bankacccode_;
    private String voidacccode_;
    private String trnfclracccode_;
    private String cashclracccode_;
    private String arclracccode_;
    private String apclraccode_;
    private String jcclracccode_;
    private String prclracccode_;
    private String apbankacccode_;
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

    public Cb_bankAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_bankAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_bankAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_bankAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_bankAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_bankAbst for Key : " + key + " val : " + val);
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
            
            
            
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           bankname_ = rs.getString(PROPERTY_BANKNAME); 
           address1_ = rs.getString(PROPERTY_ADDRESS1); 
           address2_ = rs.getString(PROPERTY_ADDRESS2); 
           city_ = rs.getString(PROPERTY_CITY); 
           state_ = rs.getString(PROPERTY_STATE); 
           postalcode_ = rs.getString(PROPERTY_POSTALCODE); 
           phone1_ = rs.getString(PROPERTY_PHONE1); 
           phone2_ = rs.getString(PROPERTY_PHONE2); 
           faxno_ = rs.getString(PROPERTY_FAXNO); 
           contact_ = rs.getString(PROPERTY_CONTACT); 
           comments_ = rs.getString(PROPERTY_COMMENTS); 
           bankaccno_ = rs.getString(PROPERTY_BANKACCNO); 
           srceledgr_ = rs.getString(PROPERTY_SRCELEDGR); 
           rvslsrcecode_ = rs.getString(PROPERTY_RVSLSRCECODE); 
           voidsrcecode_ = rs.getString(PROPERTY_VOIDSRCECODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           ratetypecode_ = rs.getString(PROPERTY_RATETYPECODE); 
           nodecimal_ = rs.getLong(PROPERTY_NODECIMAL); 
           dplctcheck_ = rs.getLong(PROPERTY_DPLCTCHECK); 
           autoallct_ = rs.getLong(PROPERTY_AUTOALLCT); 
           incldiscount_ = rs.getLong(PROPERTY_INCLDISCOUNT); 
           openbalance_ = rs.getDouble(PROPERTY_OPENBALANCE); 
           crntbalance_ = rs.getDouble(PROPERTY_CRNTBALANCE); 
           bankbalance_ = rs.getDouble(PROPERTY_BANKBALANCE); 
           runopenbalance_ = rs.getDouble(PROPERTY_RUNOPENBALANCE); 
           runcrntbalance_ = rs.getDouble(PROPERTY_RUNCRNTBALANCE); 
           runbankbalance_ = rs.getDouble(PROPERTY_RUNBANKBALANCE); 
           lastupdate_ = rs.getString(PROPERTY_LASTUPDATE); 
           startdate_ = rs.getString(PROPERTY_STARTDATE); 
           enddate_ = rs.getString(PROPERTY_ENDDATE); 
           bankacccode_ = rs.getString(PROPERTY_BANKACCCODE); 
           voidacccode_ = rs.getString(PROPERTY_VOIDACCCODE); 
           trnfclracccode_ = rs.getString(PROPERTY_TRNFCLRACCCODE); 
           cashclracccode_ = rs.getString(PROPERTY_CASHCLRACCCODE); 
           arclracccode_ = rs.getString(PROPERTY_ARCLRACCCODE); 
           apclraccode_ = rs.getString(PROPERTY_APCLRACCODE); 
           jcclracccode_ = rs.getString(PROPERTY_JCCLRACCCODE); 
           prclracccode_ = rs.getString(PROPERTY_PRCLRACCCODE); 
           apbankacccode_ = rs.getString(PROPERTY_APBANKACCCODE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_bankAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_bank obj = (Cb_bank)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_bank " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbankcode(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : bankcode can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_bank ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_bank " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateString(PROPERTY_BANKNAME , bankname_ ); 
            rs.updateString(PROPERTY_ADDRESS1 , address1_ ); 
            rs.updateString(PROPERTY_ADDRESS2 , address2_ ); 
            rs.updateString(PROPERTY_CITY , city_ ); 
            rs.updateString(PROPERTY_STATE , state_ ); 
            rs.updateString(PROPERTY_POSTALCODE , postalcode_ ); 
            rs.updateString(PROPERTY_PHONE1 , phone1_ ); 
            rs.updateString(PROPERTY_PHONE2 , phone2_ ); 
            rs.updateString(PROPERTY_FAXNO , faxno_ ); 
            rs.updateString(PROPERTY_CONTACT , contact_ ); 
            rs.updateString(PROPERTY_COMMENTS , comments_ ); 
            rs.updateString(PROPERTY_BANKACCNO , bankaccno_ ); 
            rs.updateString(PROPERTY_SRCELEDGR , srceledgr_ ); 
            rs.updateString(PROPERTY_RVSLSRCECODE , rvslsrcecode_ ); 
            rs.updateString(PROPERTY_VOIDSRCECODE , voidsrcecode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_RATETYPECODE , ratetypecode_ ); 
            rs.updateLong(PROPERTY_NODECIMAL , nodecimal_ ); 
            rs.updateLong(PROPERTY_DPLCTCHECK , dplctcheck_ ); 
            rs.updateLong(PROPERTY_AUTOALLCT , autoallct_ ); 
            rs.updateLong(PROPERTY_INCLDISCOUNT , incldiscount_ ); 
            rs.updateDouble(PROPERTY_OPENBALANCE , openbalance_ ); 
            rs.updateDouble(PROPERTY_CRNTBALANCE , crntbalance_ ); 
            rs.updateDouble(PROPERTY_BANKBALANCE , bankbalance_ ); 
            rs.updateDouble(PROPERTY_RUNOPENBALANCE , runopenbalance_ ); 
            rs.updateDouble(PROPERTY_RUNCRNTBALANCE , runcrntbalance_ ); 
            rs.updateDouble(PROPERTY_RUNBANKBALANCE , runbankbalance_ ); 
            rs.updateString(PROPERTY_LASTUPDATE , lastupdate_ ); 
            rs.updateString(PROPERTY_STARTDATE , startdate_ ); 
            rs.updateString(PROPERTY_ENDDATE , enddate_ ); 
            rs.updateString(PROPERTY_BANKACCCODE , bankacccode_ ); 
            rs.updateString(PROPERTY_VOIDACCCODE , voidacccode_ ); 
            rs.updateString(PROPERTY_TRNFCLRACCCODE , trnfclracccode_ ); 
            rs.updateString(PROPERTY_CASHCLRACCCODE , cashclracccode_ ); 
            rs.updateString(PROPERTY_ARCLRACCCODE , arclracccode_ ); 
            rs.updateString(PROPERTY_APCLRACCODE , apclraccode_ ); 
            rs.updateString(PROPERTY_JCCLRACCCODE , jcclracccode_ ); 
            rs.updateString(PROPERTY_PRCLRACCCODE , prclracccode_ ); 
            rs.updateString(PROPERTY_APBANKACCCODE , apbankacccode_ ); 
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
        Cb_bank obj = (Cb_bank) jCob;
        id_ = obj.getID();

        
          bankcode_ = obj.getbankcode();
          bankname_ = obj.getbankname();
          address1_ = obj.getaddress1();
          address2_ = obj.getaddress2();
          city_ = obj.getcity();
          state_ = obj.getstate();
          postalcode_ = obj.getpostalcode();
          phone1_ = obj.getphone1();
          phone2_ = obj.getphone2();
          faxno_ = obj.getfaxno();
          contact_ = obj.getcontact();
          comments_ = obj.getcomments();
          bankaccno_ = obj.getbankaccno();
          srceledgr_ = obj.getsrceledgr();
          rvslsrcecode_ = obj.getrvslsrcecode();
          voidsrcecode_ = obj.getvoidsrcecode();
          curnccode_ = obj.getcurnccode();
          ratetypecode_ = obj.getratetypecode();
          nodecimal_ = obj.getnodecimal();
          dplctcheck_ = obj.getdplctcheck();
          autoallct_ = obj.getautoallct();
          incldiscount_ = obj.getincldiscount();
          openbalance_ = obj.getopenbalance();
          crntbalance_ = obj.getcrntbalance();
          bankbalance_ = obj.getbankbalance();
          runopenbalance_ = obj.getrunopenbalance();
          runcrntbalance_ = obj.getruncrntbalance();
          runbankbalance_ = obj.getrunbankbalance();
          lastupdate_ = obj.getlastupdate();
          startdate_ = obj.getstartdate();
          enddate_ = obj.getenddate();
          bankacccode_ = obj.getbankacccode();
          voidacccode_ = obj.getvoidacccode();
          trnfclracccode_ = obj.gettrnfclracccode();
          cashclracccode_ = obj.getcashclracccode();
          arclracccode_ = obj.getarclracccode();
          apclraccode_ = obj.getapclraccode();
          jcclracccode_ = obj.getjcclracccode();
          prclracccode_ = obj.getprclracccode();
          apbankacccode_ = obj.getapbankacccode();
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

    
      public void setbankcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankcode_; 
      } 

      public void setbankname(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankname_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankname() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankname_; 
      } 

      public void setaddress1(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         address1_ = param; 
         _isDirty_ = true; 
      } 

      public String getaddress1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return address1_; 
      } 

      public void setaddress2(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         address2_ = param; 
         _isDirty_ = true; 
      } 

      public String getaddress2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return address2_; 
      } 

      public void setcity(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         city_ = param; 
         _isDirty_ = true; 
      } 

      public String getcity() throws CodeException {
         if (!_isLoaded_) { read();} 
         return city_; 
      } 

      public void setstate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         state_ = param; 
         _isDirty_ = true; 
      } 

      public String getstate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return state_; 
      } 

      public void setpostalcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         postalcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getpostalcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return postalcode_; 
      } 

      public void setphone1(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         phone1_ = param; 
         _isDirty_ = true; 
      } 

      public String getphone1() throws CodeException {
         if (!_isLoaded_) { read();} 
         return phone1_; 
      } 

      public void setphone2(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         phone2_ = param; 
         _isDirty_ = true; 
      } 

      public String getphone2() throws CodeException {
         if (!_isLoaded_) { read();} 
         return phone2_; 
      } 

      public void setfaxno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         faxno_ = param; 
         _isDirty_ = true; 
      } 

      public String getfaxno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return faxno_; 
      } 

      public void setcontact(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         contact_ = param; 
         _isDirty_ = true; 
      } 

      public String getcontact() throws CodeException {
         if (!_isLoaded_) { read();} 
         return contact_; 
      } 

      public void setcomments(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         comments_ = param; 
         _isDirty_ = true; 
      } 

      public String getcomments() throws CodeException {
         if (!_isLoaded_) { read();} 
         return comments_; 
      } 

      public void setbankaccno(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankaccno_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankaccno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankaccno_; 
      } 

      public void setsrceledgr(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srceledgr_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrceledgr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srceledgr_; 
      } 

      public void setrvslsrcecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rvslsrcecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getrvslsrcecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rvslsrcecode_; 
      } 

      public void setvoidsrcecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         voidsrcecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getvoidsrcecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return voidsrcecode_; 
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

      public void setratetypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratetypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getratetypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratetypecode_; 
      } 

      public void setnodecimal(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nodecimal_ = param; 
         _isDirty_ = true; 
      } 

      public long getnodecimal() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nodecimal_; 
      } 

      public void setdplctcheck(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         dplctcheck_ = param; 
         _isDirty_ = true; 
      } 

      public long getdplctcheck() throws CodeException {
         if (!_isLoaded_) { read();} 
         return dplctcheck_; 
      } 

      public void setautoallct(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         autoallct_ = param; 
         _isDirty_ = true; 
      } 

      public long getautoallct() throws CodeException {
         if (!_isLoaded_) { read();} 
         return autoallct_; 
      } 

      public void setincldiscount(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         incldiscount_ = param; 
         _isDirty_ = true; 
      } 

      public long getincldiscount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return incldiscount_; 
      } 

      public void setopenbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         openbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getopenbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return openbalance_; 
      } 

      public void setcrntbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         crntbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getcrntbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return crntbalance_; 
      } 

      public void setbankbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getbankbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankbalance_; 
      } 

      public void setrunopenbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         runopenbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getrunopenbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return runopenbalance_; 
      } 

      public void setruncrntbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         runcrntbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getruncrntbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return runcrntbalance_; 
      } 

      public void setrunbankbalance(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         runbankbalance_ = param; 
         _isDirty_ = true; 
      } 

      public double getrunbankbalance() throws CodeException {
         if (!_isLoaded_) { read();} 
         return runbankbalance_; 
      } 

      public void setlastupdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         lastupdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getlastupdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return lastupdate_; 
      } 

      public void setstartdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         startdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getstartdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return startdate_; 
      } 

      public void setenddate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         enddate_ = param; 
         _isDirty_ = true; 
      } 

      public String getenddate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return enddate_; 
      } 

      public void setbankacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankacccode_; 
      } 

      public void setvoidacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         voidacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getvoidacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return voidacccode_; 
      } 

      public void settrnfclracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         trnfclracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String gettrnfclracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return trnfclracccode_; 
      } 

      public void setcashclracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         cashclracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcashclracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return cashclracccode_; 
      } 

      public void setarclracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         arclracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getarclracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return arclracccode_; 
      } 

      public void setapclraccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         apclraccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getapclraccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return apclraccode_; 
      } 

      public void setjcclracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jcclracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getjcclracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jcclracccode_; 
      } 

      public void setprclracccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         prclracccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getprclracccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return prclracccode_; 
      } 

      public void setapbankacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         apbankacccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getapbankacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return apbankacccode_; 
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
        
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_BANKNAME)) return getbankname(); 
           else if (param.equals(PROPERTY_ADDRESS1)) return getaddress1(); 
           else if (param.equals(PROPERTY_ADDRESS2)) return getaddress2(); 
           else if (param.equals(PROPERTY_CITY)) return getcity(); 
           else if (param.equals(PROPERTY_STATE)) return getstate(); 
           else if (param.equals(PROPERTY_POSTALCODE)) return getpostalcode(); 
           else if (param.equals(PROPERTY_PHONE1)) return getphone1(); 
           else if (param.equals(PROPERTY_PHONE2)) return getphone2(); 
           else if (param.equals(PROPERTY_FAXNO)) return getfaxno(); 
           else if (param.equals(PROPERTY_CONTACT)) return getcontact(); 
           else if (param.equals(PROPERTY_COMMENTS)) return getcomments(); 
           else if (param.equals(PROPERTY_BANKACCNO)) return getbankaccno(); 
           else if (param.equals(PROPERTY_SRCELEDGR)) return getsrceledgr(); 
           else if (param.equals(PROPERTY_RVSLSRCECODE)) return getrvslsrcecode(); 
           else if (param.equals(PROPERTY_VOIDSRCECODE)) return getvoidsrcecode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_RATETYPECODE)) return getratetypecode(); 
           else if (param.equals(PROPERTY_NODECIMAL)) return String.valueOf(getnodecimal()); 
           else if (param.equals(PROPERTY_DPLCTCHECK)) return String.valueOf(getdplctcheck()); 
           else if (param.equals(PROPERTY_AUTOALLCT)) return String.valueOf(getautoallct()); 
           else if (param.equals(PROPERTY_INCLDISCOUNT)) return String.valueOf(getincldiscount()); 
           else if (param.equals(PROPERTY_OPENBALANCE)) return decform.format(getopenbalance()); 
           else if (param.equals(PROPERTY_CRNTBALANCE)) return decform.format(getcrntbalance()); 
           else if (param.equals(PROPERTY_BANKBALANCE)) return decform.format(getbankbalance()); 
           else if (param.equals(PROPERTY_RUNOPENBALANCE)) return decform.format(getrunopenbalance()); 
           else if (param.equals(PROPERTY_RUNCRNTBALANCE)) return decform.format(getruncrntbalance()); 
           else if (param.equals(PROPERTY_RUNBANKBALANCE)) return decform.format(getrunbankbalance()); 
           else if (param.equals(PROPERTY_LASTUPDATE)) return getlastupdate(); 
           else if (param.equals(PROPERTY_STARTDATE)) return getstartdate(); 
           else if (param.equals(PROPERTY_ENDDATE)) return getenddate(); 
           else if (param.equals(PROPERTY_BANKACCCODE)) return getbankacccode(); 
           else if (param.equals(PROPERTY_VOIDACCCODE)) return getvoidacccode(); 
           else if (param.equals(PROPERTY_TRNFCLRACCCODE)) return gettrnfclracccode(); 
           else if (param.equals(PROPERTY_CASHCLRACCCODE)) return getcashclracccode(); 
           else if (param.equals(PROPERTY_ARCLRACCCODE)) return getarclracccode(); 
           else if (param.equals(PROPERTY_APCLRACCODE)) return getapclraccode(); 
           else if (param.equals(PROPERTY_JCCLRACCCODE)) return getjcclracccode(); 
           else if (param.equals(PROPERTY_PRCLRACCCODE)) return getprclracccode(); 
           else if (param.equals(PROPERTY_APBANKACCCODE)) return getapbankacccode(); 
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
        
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_BANKNAME))  setbankname(value); 
           else if (param.equals(PROPERTY_ADDRESS1))  setaddress1(value); 
           else if (param.equals(PROPERTY_ADDRESS2))  setaddress2(value); 
           else if (param.equals(PROPERTY_CITY))  setcity(value); 
           else if (param.equals(PROPERTY_STATE))  setstate(value); 
           else if (param.equals(PROPERTY_POSTALCODE))  setpostalcode(value); 
           else if (param.equals(PROPERTY_PHONE1))  setphone1(value); 
           else if (param.equals(PROPERTY_PHONE2))  setphone2(value); 
           else if (param.equals(PROPERTY_FAXNO))  setfaxno(value); 
           else if (param.equals(PROPERTY_CONTACT))  setcontact(value); 
           else if (param.equals(PROPERTY_COMMENTS))  setcomments(value); 
           else if (param.equals(PROPERTY_BANKACCNO))  setbankaccno(value); 
           else if (param.equals(PROPERTY_SRCELEDGR))  setsrceledgr(value); 
           else if (param.equals(PROPERTY_RVSLSRCECODE))  setrvslsrcecode(value); 
           else if (param.equals(PROPERTY_VOIDSRCECODE))  setvoidsrcecode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_RATETYPECODE))  setratetypecode(value); 
           else if (param.equals(PROPERTY_NODECIMAL)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setnodecimal(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_DPLCTCHECK)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdplctcheck(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_AUTOALLCT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setautoallct(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_INCLDISCOUNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setincldiscount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_OPENBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setopenbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CRNTBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setcrntbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbankbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RUNOPENBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrunopenbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RUNCRNTBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setruncrntbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_RUNBANKBALANCE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrunbankbalance(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LASTUPDATE))  setlastupdate(value); 
           else if (param.equals(PROPERTY_STARTDATE))  setstartdate(value); 
           else if (param.equals(PROPERTY_ENDDATE))  setenddate(value); 
           else if (param.equals(PROPERTY_BANKACCCODE))  setbankacccode(value); 
           else if (param.equals(PROPERTY_VOIDACCCODE))  setvoidacccode(value); 
           else if (param.equals(PROPERTY_TRNFCLRACCCODE))  settrnfclracccode(value); 
           else if (param.equals(PROPERTY_CASHCLRACCCODE))  setcashclracccode(value); 
           else if (param.equals(PROPERTY_ARCLRACCCODE))  setarclracccode(value); 
           else if (param.equals(PROPERTY_APCLRACCODE))  setapclraccode(value); 
           else if (param.equals(PROPERTY_JCCLRACCCODE))  setjcclracccode(value); 
           else if (param.equals(PROPERTY_PRCLRACCCODE))  setprclracccode(value); 
           else if (param.equals(PROPERTY_APBANKACCCODE))  setapbankacccode(value); 
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
            throw new CodeException("Cb_bank : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, bankcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_bank : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, bankcode_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Cb_bank : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_bank : Cannot Move Last " + ex.getMessage());
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



