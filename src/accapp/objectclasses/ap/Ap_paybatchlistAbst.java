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


public abstract class Ap_paybatchlistAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Ap_paybatchlist";

    public static final String TABLE = "ap_paybatchlist";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BATCHNO = "batchno";
    public static final String PROPERTY_BATCHDATE = "batchdate";
    public static final String PROPERTY_BATCHDESC = "batchdesc";
    public static final String PROPERTY_READYTPOST = "readytpost";
    public static final String PROPERTY_BATCHTYPE = "batchtype";
    public static final String PROPERTY_BATCHSTS = "batchsts";
    public static final String PROPERTY_TOTPAYAMT = "totpayamt";
    public static final String PROPERTY_PAYENTRCNT = "payentrcnt";
    public static final String PROPERTY_LSTITEMCNT = "lstitemcnt";
    public static final String PROPERTY_BANKCODE = "bankcode";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_RATEDATE = "ratedate";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_RATEEXCHG = "rateexchg";
    public static final String PROPERTY_ADJUSTAMT = "adjustamt";
    public static final String PROPERTY_REAPLYAMT = "reaplyamt";
    public static final String PROPERTY_FUNCAMT = "funcamt";
    public static final String PROPERTY_POSTNGSEQ = "postngseq";
    public static final String PROPERTY_ERRORCNT = "errorcnt";
    public static final String PROPERTY_SWPRINTED = "swprinted";
    public static final String PROPERTY_GLPOSTEDSTS = "glpostedsts";
    public static final String PROPERTY_GLPOSTNGSEQ = "glpostngseq";
    public static final String PROPERTY_GLPOSTEDDATE = "glposteddate";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_BATCHNO;
    
    
    private long id_;
    private long batchno_;
    private String batchdate_;
    private String batchdesc_;
    private String readytpost_;
    private String batchtype_;
    private String batchsts_;
    private double totpayamt_;
    private long payentrcnt_;
    private long lstitemcnt_;
    private String bankcode_;
    private String curnccode_;
    private String ratedate_;
    private String ratetype_;
    private double rateexchg_;
    private double adjustamt_;
    private double reaplyamt_;
    private double funcamt_;
    private double postngseq_;
    private long errorcnt_;
    private String swprinted_;
    private String glpostedsts_;
    private double glpostngseq_;
    private String glposteddate_;
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

    public Ap_paybatchlistAbst() throws CodeException {
        loadNew();
    }
    
    public Ap_paybatchlistAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Ap_paybatchlistAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Ap_paybatchlistAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Ap_paybatchlistAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Ap_paybatchlistAbst for Key : " + key + " val : " + val);
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
           batchdate_ = rs.getString(PROPERTY_BATCHDATE); 
           batchdesc_ = rs.getString(PROPERTY_BATCHDESC); 
           readytpost_ = rs.getString(PROPERTY_READYTPOST); 
           batchtype_ = rs.getString(PROPERTY_BATCHTYPE); 
           batchsts_ = rs.getString(PROPERTY_BATCHSTS); 
           totpayamt_ = rs.getDouble(PROPERTY_TOTPAYAMT); 
           payentrcnt_ = rs.getLong(PROPERTY_PAYENTRCNT); 
           lstitemcnt_ = rs.getLong(PROPERTY_LSTITEMCNT); 
           bankcode_ = rs.getString(PROPERTY_BANKCODE); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           ratedate_ = rs.getString(PROPERTY_RATEDATE); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           rateexchg_ = rs.getDouble(PROPERTY_RATEEXCHG); 
           adjustamt_ = rs.getDouble(PROPERTY_ADJUSTAMT); 
           reaplyamt_ = rs.getDouble(PROPERTY_REAPLYAMT); 
           funcamt_ = rs.getDouble(PROPERTY_FUNCAMT); 
           postngseq_ = rs.getDouble(PROPERTY_POSTNGSEQ); 
           errorcnt_ = rs.getLong(PROPERTY_ERRORCNT); 
           swprinted_ = rs.getString(PROPERTY_SWPRINTED); 
           glpostedsts_ = rs.getString(PROPERTY_GLPOSTEDSTS); 
           glpostngseq_ = rs.getDouble(PROPERTY_GLPOSTNGSEQ); 
           glposteddate_ = rs.getString(PROPERTY_GLPOSTEDDATE); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Ap_paybatchlistAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Ap_paybatchlist obj = (Ap_paybatchlist)cache.get(getID());
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
                    throw new CodeException("Error Reading Ap_paybatchlist " + e.getMessage());
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
           rs = db.retrieveSQL("SELECT max(id) from ap_paybatchlist ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Ap_paybatchlist " + e.getMessage());
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
            rs.updateString(PROPERTY_BATCHDATE , batchdate_ ); 
            rs.updateString(PROPERTY_BATCHDESC , batchdesc_ ); 
            rs.updateString(PROPERTY_READYTPOST , readytpost_ ); 
            rs.updateString(PROPERTY_BATCHTYPE , batchtype_ ); 
            rs.updateString(PROPERTY_BATCHSTS , batchsts_ ); 
            rs.updateDouble(PROPERTY_TOTPAYAMT , totpayamt_ ); 
            rs.updateLong(PROPERTY_PAYENTRCNT , payentrcnt_ ); 
            rs.updateLong(PROPERTY_LSTITEMCNT , lstitemcnt_ ); 
            rs.updateString(PROPERTY_BANKCODE , bankcode_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_RATEDATE , ratedate_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateDouble(PROPERTY_RATEEXCHG , rateexchg_ ); 
            rs.updateDouble(PROPERTY_ADJUSTAMT , adjustamt_ ); 
            rs.updateDouble(PROPERTY_REAPLYAMT , reaplyamt_ ); 
            rs.updateDouble(PROPERTY_FUNCAMT , funcamt_ ); 
            rs.updateDouble(PROPERTY_POSTNGSEQ , postngseq_ ); 
            rs.updateLong(PROPERTY_ERRORCNT , errorcnt_ ); 
            rs.updateString(PROPERTY_SWPRINTED , swprinted_ ); 
            rs.updateString(PROPERTY_GLPOSTEDSTS , glpostedsts_ ); 
            rs.updateDouble(PROPERTY_GLPOSTNGSEQ , glpostngseq_ ); 
            rs.updateString(PROPERTY_GLPOSTEDDATE , glposteddate_ ); 
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
        Ap_paybatchlist obj = (Ap_paybatchlist) jCob;
        id_ = obj.getID();

        
          batchno_ = obj.getbatchno();
          batchdate_ = obj.getbatchdate();
          batchdesc_ = obj.getbatchdesc();
          readytpost_ = obj.getreadytpost();
          batchtype_ = obj.getbatchtype();
          batchsts_ = obj.getbatchsts();
          totpayamt_ = obj.gettotpayamt();
          payentrcnt_ = obj.getpayentrcnt();
          lstitemcnt_ = obj.getlstitemcnt();
          bankcode_ = obj.getbankcode();
          curnccode_ = obj.getcurnccode();
          ratedate_ = obj.getratedate();
          ratetype_ = obj.getratetype();
          rateexchg_ = obj.getrateexchg();
          adjustamt_ = obj.getadjustamt();
          reaplyamt_ = obj.getreaplyamt();
          funcamt_ = obj.getfuncamt();
          postngseq_ = obj.getpostngseq();
          errorcnt_ = obj.geterrorcnt();
          swprinted_ = obj.getswprinted();
          glpostedsts_ = obj.getglpostedsts();
          glpostngseq_ = obj.getglpostngseq();
          glposteddate_ = obj.getglposteddate();
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

      public void setbatchdate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchdate_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchdate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchdate_; 
      } 

      public void setbatchdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchdesc_; 
      } 

      public void setreadytpost(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         readytpost_ = param; 
         _isDirty_ = true; 
      } 

      public String getreadytpost() throws CodeException {
         if (!_isLoaded_) { read();} 
         return readytpost_; 
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

      public void setbatchsts(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         batchsts_ = param; 
         _isDirty_ = true; 
      } 

      public String getbatchsts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return batchsts_; 
      } 

      public void settotpayamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         totpayamt_ = param; 
         _isDirty_ = true; 
      } 

      public double gettotpayamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return totpayamt_; 
      } 

      public void setpayentrcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         payentrcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getpayentrcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return payentrcnt_; 
      } 

      public void setlstitemcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         lstitemcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long getlstitemcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return lstitemcnt_; 
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

      public void setcurnccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         curnccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getcurnccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return curnccode_; 
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

      public void setratetype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         ratetype_ = param; 
         _isDirty_ = true; 
      } 

      public String getratetype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return ratetype_; 
      } 

      public void setrateexchg(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rateexchg_ = param; 
         _isDirty_ = true; 
      } 

      public double getrateexchg() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rateexchg_; 
      } 

      public void setadjustamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         adjustamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getadjustamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return adjustamt_; 
      } 

      public void setreaplyamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         reaplyamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getreaplyamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return reaplyamt_; 
      } 

      public void setfuncamt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         funcamt_ = param; 
         _isDirty_ = true; 
      } 

      public double getfuncamt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return funcamt_; 
      } 

      public void setpostngseq(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         postngseq_ = param; 
         _isDirty_ = true; 
      } 

      public double getpostngseq() throws CodeException {
         if (!_isLoaded_) { read();} 
         return postngseq_; 
      } 

      public void seterrorcnt(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         errorcnt_ = param; 
         _isDirty_ = true; 
      } 

      public long geterrorcnt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return errorcnt_; 
      } 

      public void setswprinted(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         swprinted_ = param; 
         _isDirty_ = true; 
      } 

      public String getswprinted() throws CodeException {
         if (!_isLoaded_) { read();} 
         return swprinted_; 
      } 

      public void setglpostedsts(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glpostedsts_ = param; 
         _isDirty_ = true; 
      } 

      public String getglpostedsts() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glpostedsts_; 
      } 

      public void setglpostngseq(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glpostngseq_ = param; 
         _isDirty_ = true; 
      } 

      public double getglpostngseq() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glpostngseq_; 
      } 

      public void setglposteddate(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         glposteddate_ = param; 
         _isDirty_ = true; 
      } 

      public String getglposteddate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return glposteddate_; 
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
           else if (param.equals(PROPERTY_BATCHDATE)) return getbatchdate(); 
           else if (param.equals(PROPERTY_BATCHDESC)) return getbatchdesc(); 
           else if (param.equals(PROPERTY_READYTPOST)) return getreadytpost(); 
           else if (param.equals(PROPERTY_BATCHTYPE)) return getbatchtype(); 
           else if (param.equals(PROPERTY_BATCHSTS)) return getbatchsts(); 
           else if (param.equals(PROPERTY_TOTPAYAMT)) return decform.format(gettotpayamt()); 
           else if (param.equals(PROPERTY_PAYENTRCNT)) return String.valueOf(getpayentrcnt()); 
           else if (param.equals(PROPERTY_LSTITEMCNT)) return String.valueOf(getlstitemcnt()); 
           else if (param.equals(PROPERTY_BANKCODE)) return getbankcode(); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_RATEDATE)) return getratedate(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_RATEEXCHG)) return decform.format(getrateexchg()); 
           else if (param.equals(PROPERTY_ADJUSTAMT)) return decform.format(getadjustamt()); 
           else if (param.equals(PROPERTY_REAPLYAMT)) return decform.format(getreaplyamt()); 
           else if (param.equals(PROPERTY_FUNCAMT)) return decform.format(getfuncamt()); 
           else if (param.equals(PROPERTY_POSTNGSEQ)) return decform.format(getpostngseq()); 
           else if (param.equals(PROPERTY_ERRORCNT)) return String.valueOf(geterrorcnt()); 
           else if (param.equals(PROPERTY_SWPRINTED)) return getswprinted(); 
           else if (param.equals(PROPERTY_GLPOSTEDSTS)) return getglpostedsts(); 
           else if (param.equals(PROPERTY_GLPOSTNGSEQ)) return decform.format(getglpostngseq()); 
           else if (param.equals(PROPERTY_GLPOSTEDDATE)) return getglposteddate(); 
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
           else if (param.equals(PROPERTY_BATCHDATE))  setbatchdate(value); 
           else if (param.equals(PROPERTY_BATCHDESC))  setbatchdesc(value); 
           else if (param.equals(PROPERTY_READYTPOST))  setreadytpost(value); 
           else if (param.equals(PROPERTY_BATCHTYPE))  setbatchtype(value); 
           else if (param.equals(PROPERTY_BATCHSTS))  setbatchsts(value); 
           else if (param.equals(PROPERTY_TOTPAYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settotpayamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_PAYENTRCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setpayentrcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LSTITEMCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlstitemcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_BANKCODE))  setbankcode(value); 
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_RATEDATE))  setratedate(value); 
           else if (param.equals(PROPERTY_RATETYPE))  setratetype(value); 
           else if (param.equals(PROPERTY_RATEEXCHG)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrateexchg(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ADJUSTAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setadjustamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_REAPLYAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setreaplyamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_FUNCAMT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setfuncamt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_POSTNGSEQ)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setpostngseq(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ERRORCNT)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          seterrorcnt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SWPRINTED))  setswprinted(value); 
           else if (param.equals(PROPERTY_GLPOSTEDSTS))  setglpostedsts(value); 
           else if (param.equals(PROPERTY_GLPOSTNGSEQ)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setglpostngseq(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_GLPOSTEDDATE))  setglposteddate(value); 
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
            throw new CodeException("Ap_paybatchlist : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, batchno_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_paybatchlist : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, batchno_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Ap_paybatchlist : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Ap_paybatchlist : Cannot Move Last " + ex.getMessage());
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



