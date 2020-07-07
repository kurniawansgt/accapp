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


public abstract class Cb_pjhAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Cb_pjh";

    public static final String TABLE = "cb_pjh";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PSEQNO = "pseqno";
    public static final String PROPERTY_PSEQENTRY = "pseqentry";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_ENTRYNO = "entryno";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_TRANSDATE = "transdate";
    public static final String PROPERTY_DSCRIPTION = "dscription";
    public static final String PROPERTY_YOP = "yop";
    public static final String PROPERTY_MOP = "mop";
    public static final String PROPERTY_SRCELEDGR = "srceledgr";
    public static final String PROPERTY_BATCHTYPE = "batchtype";
    public static final String PROPERTY_ENTRYTYPE = "entrytype";
    public static final String PROPERTY_NODETATAILS = "nodetatails";
    public static final String PROPERTY_SRCEAMOUNT = "srceamount";
    public static final String PROPERTY_BANKAMOUNT = "bankamount";
    public static final String PROPERTY_GLAMOUNT = "glamount";
    public static final String PROPERTY_MISCAMOUNT = "miscamount";
    public static final String PROPERTY_TAXAMOUNT = "taxamount";
    public static final String PROPERTY_TAXPERCENT = "taxpercent";
    public static final String PROPERTY_MISCCODE = "misccode";
    public static final String PROPERTY_DISTCODE = "distcode";
    public static final String PROPERTY_GLHOMECRNCY = "glhomecrncy";
    public static final String PROPERTY_GLRATETYPE = "glratetype";
    public static final String PROPERTY_GLSRCECRNCY = "glsrcecrncy";
    public static final String PROPERTY_BANKGLDATE = "bankgldate";
    public static final String PROPERTY_BANKGLRATE = "bankglrate";
    public static final String PROPERTY_BANKGLSPREAD = "bankglspread";
    public static final String PROPERTY_LINESTATUS = "linestatus";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double pseqno_;
    private double pseqentry_;
    private double batchno_;
    private double entryno_;
    private String bankcode_;
    private String reference_;
    private String transdate_;
    private String dscription_;
    private long yop_;
    private long mop_;
    private String srceledgr_;
    private String batchtype_;
    private String entrytype_;
    private long nodetatails_;
    private double srceamount_;
    private double bankamount_;
    private double glamount_;
    private double miscamount_;
    private double taxamount_;
    private double taxpercent_;
    private String misccode_;
    private String distcode_;
    private String glhomecrncy_;
    private String glratetype_;
    private String glsrcecrncy_;
    private String bankgldate_;
    private double bankglrate_;
    private double bankglspread_;
    private long linestatus_;
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

    public Cb_pjhAbst() throws CodeException {
        loadNew();
    }
    
    public Cb_pjhAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Cb_pjhAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Cb_pjhAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Cb_pjhAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Cb_pjhAbst for Key : " + key + " val : " + val);
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
            
            
            
           pseqno_ = rs.getDouble(PROPERTY_PSEQNO); 
           pseqentry_ = rs.getDouble(PROPERTY_PSEQENTRY); 
           batchno_ = rs.getDouble(PROPERTY_BATCHNO); 
           entryno_ = rs.getDouble(PROPERTY_ENTRYNO); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           reference_ = rs.getString(PROPERTY_REFERENCE); 
           transdate_ = rs.getString(PROPERTY_TRANSDATE); 
           dscription_ = rs.getString(PROPERTY_DSCRIPTION); 
           yop_ = rs.getLong(PROPERTY_YOP); 
           mop_ = rs.getLong(PROPERTY_MOP); 
           srceledgr_ = rs.getString(PROPERTY_SRCELEDGR); 
           batchtype_ = rs.getString(PROPERTY_BATCHTYPE); 
           entrytype_ = rs.getString(PROPERTY_ENTRYTYPE); 
           nodetatails_ = rs.getLong(PROPERTY_NODETATAILS); 
           srceamount_ = rs.getDouble(PROPERTY_SRCEAMOUNT); 
           bankamount_ = rs.getDouble(PROPERTY_BANKAMOUNT); 
           glamount_ = rs.getDouble(PROPERTY_GLAMOUNT); 
           miscamount_ = rs.getDouble(PROPERTY_MISCAMOUNT); 
           taxamount_ = rs.getDouble(PROPERTY_TAXAMOUNT); 
           taxpercent_ = rs.getDouble(PROPERTY_TAXPERCENT); 
           misccode_ = rs.getString(PROPERTY_MISCCODE); 
           distcode_ = rs.getString(PROPERTY_DISTCODE); 
           glhomecrncy_ = rs.getString(PROPERTY_GLHOMECRNCY); 
           glratetype_ = rs.getString(PROPERTY_GLRATETYPE); 
           glsrcecrncy_ = rs.getString(PROPERTY_GLSRCECRNCY); 
           bankgldate_ = rs.getString(PROPERTY_BANKGLDATE); 
           bankglrate_ = rs.getDouble(PROPERTY_BANKGLRATE); 
           bankglspread_ = rs.getDouble(PROPERTY_BANKGLSPREAD); 
           linestatus_ = rs.getLong(PROPERTY_LINESTATUS); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Cb_pjhAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Cb_pjh obj = (Cb_pjh)cache.get(getID());
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
                    throw new CodeException("Error Reading Cb_pjh " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getpseqno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pseqno can not be Empty"); 
        } 
 
         o = getpseqentry(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : pseqentry can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from cb_pjh ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Cb_pjh " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_PSEQNO , pseqno_ ); 
            rs.updateDouble(PROPERTY_PSEQENTRY , pseqentry_ ); 
            rs.updateDouble(PROPERTY_BATCHNO , batchno_ ); 
            rs.updateDouble(PROPERTY_ENTRYNO , entryno_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateString(PROPERTY_REFERENCE , reference_ ); 
            rs.updateString(PROPERTY_TRANSDATE , transdate_ ); 
            rs.updateString(PROPERTY_DSCRIPTION , dscription_ ); 
            rs.updateLong(PROPERTY_YOP , yop_ ); 
            rs.updateLong(PROPERTY_MOP , mop_ ); 
            rs.updateString(PROPERTY_SRCELEDGR , srceledgr_ ); 
            rs.updateString(PROPERTY_BATCHTYPE , batchtype_ ); 
            rs.updateString(PROPERTY_ENTRYTYPE , entrytype_ ); 
            rs.updateLong(PROPERTY_NODETATAILS , nodetatails_ ); 
            rs.updateDouble(PROPERTY_SRCEAMOUNT , srceamount_ ); 
            rs.updateDouble(PROPERTY_BANKAMOUNT , bankamount_ ); 
            rs.updateDouble(PROPERTY_GLAMOUNT , glamount_ ); 
            rs.updateDouble(PROPERTY_MISCAMOUNT , miscamount_ ); 
            rs.updateDouble(PROPERTY_TAXAMOUNT , taxamount_ ); 
            rs.updateDouble(PROPERTY_TAXPERCENT , taxpercent_ ); 
            rs.updateString(PROPERTY_MISCCODE , misccode_ ); 
            rs.updateString(PROPERTY_DISTCODE , distcode_ ); 
            rs.updateString(PROPERTY_GLHOMECRNCY , glhomecrncy_ ); 
            rs.updateString(PROPERTY_GLRATETYPE , glratetype_ ); 
            rs.updateString(PROPERTY_GLSRCECRNCY , glsrcecrncy_ ); 
            rs.updateString(PROPERTY_BANKGLDATE , bankgldate_ ); 
            rs.updateDouble(PROPERTY_BANKGLRATE , bankglrate_ ); 
            rs.updateDouble(PROPERTY_BANKGLSPREAD , bankglspread_ ); 
            rs.updateLong(PROPERTY_LINESTATUS , linestatus_ ); 
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
        Cb_pjh obj = (Cb_pjh) jCob;
        id_ = obj.getID();

        
          pseqno_ = obj.getpseqno();
          pseqentry_ = obj.getpseqentry();
          batchno_ = obj.getbatchno();
          entryno_ = obj.getentryno();
          bankcode_ = obj.getbankcode();
          reference_ = obj.getreference();
          transdate_ = obj.gettransdate();
          dscription_ = obj.getdscription();
          yop_ = obj.getyop();
          mop_ = obj.getmop();
          srceledgr_ = obj.getsrceledgr();
          batchtype_ = obj.getbatchtype();
          entrytype_ = obj.getentrytype();
          nodetatails_ = obj.getnodetatails();
          srceamount_ = obj.getsrceamount();
          bankamount_ = obj.getbankamount();
          glamount_ = obj.getglamount();
          miscamount_ = obj.getmiscamount();
          taxamount_ = obj.gettaxamount();
          taxpercent_ = obj.gettaxpercent();
          misccode_ = obj.getmisccode();
          distcode_ = obj.getdistcode();
          glhomecrncy_ = obj.getglhomecrncy();
          glratetype_ = obj.getglratetype();
          glsrcecrncy_ = obj.getglsrcecrncy();
          bankgldate_ = obj.getbankgldate();
          bankglrate_ = obj.getbankglrate();
          bankglspread_ = obj.getbankglspread();
          linestatus_ = obj.getlinestatus();
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

    
      public void setpseqno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pseqno_ = param; 
         _isDirty_ = true; 
      } 

      public double getpseqno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pseqno_; 
      } 

      public void setpseqentry(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         pseqentry_ = param; 
         _isDirty_ = true; 
      } 

      public double getpseqentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return pseqentry_; 
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

      public void setentryno(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         entryno_ = param; 
         _isDirty_ = true; 
      } 

      public double getentryno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return entryno_; 
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

      public void setreference(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         reference_ = param; 
         _isDirty_ = true; 
      } 

      public String getreference() throws CodeException {
         if (!_isLoaded_) { read();} 
         return reference_; 
      } 

      public void settransdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transdate_ = param; 
         _isDirty_ = true; 
      } 

      public String gettransdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transdate_; 
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

      public void setsrceledgr(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srceledgr_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrceledgr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srceledgr_; 
      } 

      public void setbatchtype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchtype_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchtype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchtype_; 
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

      public void setnodetatails(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         nodetatails_ = param; 
         _isDirty_ = true; 
      } 

      public long getnodetatails() throws CodeException {
         if (!_isLoaded_) { read();} 
         return nodetatails_; 
      } 

      public void setsrceamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srceamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getsrceamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srceamount_; 
      } 

      public void setbankamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getbankamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankamount_; 
      } 

      public void setglamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getglamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glamount_; 
      } 

      public void setmiscamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         miscamount_ = param; 
         _isDirty_ = true; 
      } 

      public double getmiscamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return miscamount_; 
      } 

      public void settaxamount(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         taxamount_ = param; 
         _isDirty_ = true; 
      } 

      public double gettaxamount() throws CodeException {
         if (!_isLoaded_) { read();} 
         return taxamount_; 
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

      public void setmisccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         misccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getmisccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return misccode_; 
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

      public void setglhomecrncy(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glhomecrncy_ = param; 
         _isDirty_ = true; 
      } 

      public String getglhomecrncy() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glhomecrncy_; 
      } 

      public void setglratetype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glratetype_ = param; 
         _isDirty_ = true; 
      } 

      public String getglratetype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glratetype_; 
      } 

      public void setglsrcecrncy(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glsrcecrncy_ = param; 
         _isDirty_ = true; 
      } 

      public String getglsrcecrncy() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glsrcecrncy_; 
      } 

      public void setbankgldate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankgldate_ = param; 
         _isDirty_ = true; 
      } 

      public String getbankgldate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankgldate_; 
      } 

      public void setbankglrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankglrate_ = param; 
         _isDirty_ = true; 
      } 

      public double getbankglrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankglrate_; 
      } 

      public void setbankglspread(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         bankglspread_ = param; 
         _isDirty_ = true; 
      } 

      public double getbankglspread() throws CodeException {
         if (!_isLoaded_) { read();} 
         return bankglspread_; 
      } 

      public void setlinestatus(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         linestatus_ = param; 
         _isDirty_ = true; 
      } 

      public long getlinestatus() throws CodeException {
         if (!_isLoaded_) { read();} 
         return linestatus_; 
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
        
           else if (param.equals(PROPERTY_PSEQNO)) return decform.format(getpseqno()); 
           else if (param.equals(PROPERTY_PSEQENTRY)) return decform.format(getpseqentry()); 
           else if (param.equals(PROPERTY_BATCHNO)) return decform.format(getbatchno()); 
           else if (param.equals(PROPERTY_ENTRYNO)) return decform.format(getentryno()); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_REFERENCE)) return getreference(); 
           else if (param.equals(PROPERTY_TRANSDATE)) return gettransdate(); 
           else if (param.equals(PROPERTY_DSCRIPTION)) return getdscription(); 
           else if (param.equals(PROPERTY_YOP)) return String.valueOf(getyop()); 
           else if (param.equals(PROPERTY_MOP)) return String.valueOf(getmop()); 
           else if (param.equals(PROPERTY_SRCELEDGR)) return getsrceledgr(); 
           else if (param.equals(PROPERTY_BATCHTYPE)) return getbatchtype(); 
           else if (param.equals(PROPERTY_ENTRYTYPE)) return getentrytype(); 
           else if (param.equals(PROPERTY_NODETATAILS)) return String.valueOf(getnodetatails()); 
           else if (param.equals(PROPERTY_SRCEAMOUNT)) return decform.format(getsrceamount()); 
           else if (param.equals(PROPERTY_BANKAMOUNT)) return decform.format(getbankamount()); 
           else if (param.equals(PROPERTY_GLAMOUNT)) return decform.format(getglamount()); 
           else if (param.equals(PROPERTY_MISCAMOUNT)) return decform.format(getmiscamount()); 
           else if (param.equals(PROPERTY_TAXAMOUNT)) return decform.format(gettaxamount()); 
           else if (param.equals(PROPERTY_TAXPERCENT)) return decform.format(gettaxpercent()); 
           else if (param.equals(PROPERTY_MISCCODE)) return getmisccode(); 
           else if (param.equals(PROPERTY_DISTCODE)) return getdistcode(); 
           else if (param.equals(PROPERTY_GLHOMECRNCY)) return getglhomecrncy(); 
           else if (param.equals(PROPERTY_GLRATETYPE)) return getglratetype(); 
           else if (param.equals(PROPERTY_GLSRCECRNCY)) return getglsrcecrncy(); 
           else if (param.equals(PROPERTY_BANKGLDATE)) return getbankgldate(); 
           else if (param.equals(PROPERTY_BANKGLRATE)) return decform.format(getbankglrate()); 
           else if (param.equals(PROPERTY_BANKGLSPREAD)) return decform.format(getbankglspread()); 
           else if (param.equals(PROPERTY_LINESTATUS)) return String.valueOf(getlinestatus()); 
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
        
           else if (param.equals(PROPERTY_PSEQNO)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpseqno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PSEQENTRY)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpseqentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
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
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setentryno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_REFERENCE))  setreference(value); 
           else if (param.equals(PROPERTY_TRANSDATE))  settransdate(value); 
           else if (param.equals(PROPERTY_DSCRIPTION))  setdscription(value); 
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
           else if (param.equals(PROPERTY_SRCELEDGR))  setsrceledgr(value); 
           else if (param.equals(PROPERTY_BATCHTYPE))  setbatchtype(value); 
           else if (param.equals(PROPERTY_ENTRYTYPE))  setentrytype(value); 
           else if (param.equals(PROPERTY_NODETATAILS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setnodetatails(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SRCEAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setsrceamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbankamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GLAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setglamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_MISCAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setmiscamount(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TAXAMOUNT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settaxamount(newVal); 
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
           else if (param.equals(PROPERTY_MISCCODE))  setmisccode(value); 
           else if (param.equals(PROPERTY_DISTCODE))  setdistcode(value); 
           else if (param.equals(PROPERTY_GLHOMECRNCY))  setglhomecrncy(value); 
           else if (param.equals(PROPERTY_GLRATETYPE))  setglratetype(value); 
           else if (param.equals(PROPERTY_GLSRCECRNCY))  setglsrcecrncy(value); 
           else if (param.equals(PROPERTY_BANKGLDATE))  setbankgldate(value); 
           else if (param.equals(PROPERTY_BANKGLRATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbankglrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKGLSPREAD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbankglspread(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LINESTATUS)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlinestatus(newVal); 
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
            throw new CodeException("Cb_pjh : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Cb_pjh : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Cb_pjh : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Cb_pjh : Cannot Move Last " + ex.getMessage());
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



