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


public abstract class Gl_jedAbst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Gl_jed";

    public static final String TABLE = "gl_jed";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BTCHENTRY = "btchentry";
    public static final String PROPERTY_JOURNALID = "journalid";
    public static final String PROPERTY_TRANSNBR = "transnbr";
    public static final String PROPERTY_ACCCODE = "acccode";
    public static final String PROPERTY_TRANSAMTDBT = "transamtdbt";
    public static final String PROPERTY_TRANSAMTCRD = "transamtcrd";
    public static final String PROPERTY_TRANSQTY = "transqty";
    public static final String PROPERTY_CURNCCODE = "curnccode";
    public static final String PROPERTY_SRCECURNCCODE = "srcecurnccode";
    public static final String PROPERTY_RATETYPE = "ratetype";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_FUNCAMTDBT = "funcamtdbt";
    public static final String PROPERTY_FUNCAMTCRD = "funcamtcrd";
    public static final String PROPERTY_TRANSDESC = "transdesc";
    public static final String PROPERTY_TRANSREF = "transref";
    public static final String PROPERTY_TRANSDATE = "transdate";
    public static final String PROPERTY_SRCELGRCODE = "srcelgrcode";
    public static final String PROPERTY_SRCETYPECODE = "srcetypecode";
    public static final String PROPERTY_JECOMMENT = "jecomment";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_AUDITDATE = "auditdate";
    public static final String PROPERTY_AUDITUSER = "audituser";
    public static final String PROPERTY_OBJTYPE = "objtype";
    public static final String PROPERTY_CMPNYID = "cmpnyid";
    
     public static final String PRIMARYKEY = PROPERTY_ID;
    
    
    private long id_;
    private double btchentry_;
    private double journalid_;
    private double transnbr_;
    private String acccode_;
    private double transamtdbt_;
    private double transamtcrd_;
    private long transqty_;
    private String curnccode_;
    private String srcecurnccode_;
    private String ratetype_;
    private double rate_;
    private double funcamtdbt_;
    private double funcamtcrd_;
    private String transdesc_;
    private String transref_;
    private String transdate_;
    private String srcelgrcode_;
    private String srcetypecode_;
    private String jecomment_;
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

    public Gl_jedAbst() throws CodeException {
        loadNew();
    }
    
    public Gl_jedAbst(long id) throws CodeException {
        loadID(id);

    }
    
    public Gl_jedAbst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Gl_jedAbst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Gl_jedAbst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Gl_jedAbst for Key : " + key + " val : " + val);
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
            
            
            
           btchentry_ = rs.getDouble(PROPERTY_BTCHENTRY); 
           journalid_ = rs.getDouble(PROPERTY_JOURNALID); 
           transnbr_ = rs.getDouble(PROPERTY_TRANSNBR); 
           acccode_ = rs.getString(PROPERTY_ACCCODE); 
           transamtdbt_ = rs.getDouble(PROPERTY_TRANSAMTDBT); 
           transamtcrd_ = rs.getDouble(PROPERTY_TRANSAMTCRD); 
           transqty_ = rs.getLong(PROPERTY_TRANSQTY); 
           curnccode_ = rs.getString(PROPERTY_CURNCCODE); 
           srcecurnccode_ = rs.getString(PROPERTY_SRCECURNCCODE); 
           ratetype_ = rs.getString(PROPERTY_RATETYPE); 
           rate_ = rs.getDouble(PROPERTY_RATE); 
           funcamtdbt_ = rs.getDouble(PROPERTY_FUNCAMTDBT); 
           funcamtcrd_ = rs.getDouble(PROPERTY_FUNCAMTCRD); 
           transdesc_ = rs.getString(PROPERTY_TRANSDESC); 
           transref_ = rs.getString(PROPERTY_TRANSREF); 
           transdate_ = rs.getString(PROPERTY_TRANSDATE); 
           srcelgrcode_ = rs.getString(PROPERTY_SRCELGRCODE); 
           srcetypecode_ = rs.getString(PROPERTY_SRCETYPECODE); 
           jecomment_ = rs.getString(PROPERTY_JECOMMENT); 
           entrydate_ = rs.getString(PROPERTY_ENTRYDATE); 
           auditdate_ = rs.getString(PROPERTY_AUDITDATE); 
           audituser_ = rs.getString(PROPERTY_AUDITUSER); 
           objtype_ = rs.getLong(PROPERTY_OBJTYPE); 
           cmpnyid_ = rs.getString(PROPERTY_CMPNYID); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Gl_jedAbst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Gl_jed obj = (Gl_jed)cache.get(getID());
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
                    throw new CodeException("Error Reading Gl_jed " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getbtchentry(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : btchentry can not be Empty"); 
        } 
 
         o = getjournalid(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : journalid can not be Empty"); 
        } 
 
         o = gettransnbr(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : transnbr can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from gl_jed ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Gl_jed " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateDouble(PROPERTY_BTCHENTRY , btchentry_ ); 
            rs.updateDouble(PROPERTY_JOURNALID , journalid_ ); 
            rs.updateDouble(PROPERTY_TRANSNBR , transnbr_ ); 
            rs.updateString(PROPERTY_ACCCODE , acccode_ ); 
            rs.updateDouble(PROPERTY_TRANSAMTDBT , transamtdbt_ ); 
            rs.updateDouble(PROPERTY_TRANSAMTCRD , transamtcrd_ ); 
            rs.updateLong(PROPERTY_TRANSQTY , transqty_ ); 
            rs.updateString(PROPERTY_CURNCCODE , curnccode_ ); 
            rs.updateString(PROPERTY_SRCECURNCCODE , srcecurnccode_ ); 
            rs.updateString(PROPERTY_RATETYPE , ratetype_ ); 
            rs.updateDouble(PROPERTY_RATE , rate_ ); 
            rs.updateDouble(PROPERTY_FUNCAMTDBT , funcamtdbt_ ); 
            rs.updateDouble(PROPERTY_FUNCAMTCRD , funcamtcrd_ ); 
            rs.updateString(PROPERTY_TRANSDESC , transdesc_ ); 
            rs.updateString(PROPERTY_TRANSREF , transref_ ); 
            rs.updateString(PROPERTY_TRANSDATE , transdate_ ); 
            rs.updateString(PROPERTY_SRCELGRCODE , srcelgrcode_ ); 
            rs.updateString(PROPERTY_SRCETYPECODE , srcetypecode_ ); 
            rs.updateString(PROPERTY_JECOMMENT , jecomment_ ); 
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
        Gl_jed obj = (Gl_jed) jCob;
        id_ = obj.getID();

        
          btchentry_ = obj.getbtchentry();
          journalid_ = obj.getjournalid();
          transnbr_ = obj.gettransnbr();
          acccode_ = obj.getacccode();
          transamtdbt_ = obj.gettransamtdbt();
          transamtcrd_ = obj.gettransamtcrd();
          transqty_ = obj.gettransqty();
          curnccode_ = obj.getcurnccode();
          srcecurnccode_ = obj.getsrcecurnccode();
          ratetype_ = obj.getratetype();
          rate_ = obj.getrate();
          funcamtdbt_ = obj.getfuncamtdbt();
          funcamtcrd_ = obj.getfuncamtcrd();
          transdesc_ = obj.gettransdesc();
          transref_ = obj.gettransref();
          transdate_ = obj.gettransdate();
          srcelgrcode_ = obj.getsrcelgrcode();
          srcetypecode_ = obj.getsrcetypecode();
          jecomment_ = obj.getjecomment();
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

    
      public void setbtchentry(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         btchentry_ = param; 
         _isDirty_ = true; 
      } 

      public double getbtchentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return btchentry_; 
      } 

      public void setjournalid(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         journalid_ = param; 
         _isDirty_ = true; 
      } 

      public double getjournalid() throws CodeException {
         if (!_isLoaded_) { read();} 
         return journalid_; 
      } 

      public void settransnbr(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transnbr_ = param; 
         _isDirty_ = true; 
      } 

      public double gettransnbr() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transnbr_; 
      } 

      public void setacccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         acccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getacccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return acccode_; 
      } 

      public void settransamtdbt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transamtdbt_ = param; 
         _isDirty_ = true; 
      } 

      public double gettransamtdbt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transamtdbt_; 
      } 

      public void settransamtcrd(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transamtcrd_ = param; 
         _isDirty_ = true; 
      } 

      public double gettransamtcrd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transamtcrd_; 
      } 

      public void settransqty(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transqty_ = param; 
         _isDirty_ = true; 
      } 

      public long gettransqty() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transqty_; 
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

      public void setsrcecurnccode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcecurnccode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcecurnccode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcecurnccode_; 
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

      public void setrate(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rate_ = param; 
         _isDirty_ = true; 
      } 

      public double getrate() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rate_; 
      } 

      public void setfuncamtdbt(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         funcamtdbt_ = param; 
         _isDirty_ = true; 
      } 

      public double getfuncamtdbt() throws CodeException {
         if (!_isLoaded_) { read();} 
         return funcamtdbt_; 
      } 

      public void setfuncamtcrd(double param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         funcamtcrd_ = param; 
         _isDirty_ = true; 
      } 

      public double getfuncamtcrd() throws CodeException {
         if (!_isLoaded_) { read();} 
         return funcamtcrd_; 
      } 

      public void settransdesc(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transdesc_ = param; 
         _isDirty_ = true; 
      } 

      public String gettransdesc() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transdesc_; 
      } 

      public void settransref(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         transref_ = param; 
         _isDirty_ = true; 
      } 

      public String gettransref() throws CodeException {
         if (!_isLoaded_) { read();} 
         return transref_; 
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

      public void setsrcelgrcode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcelgrcode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcelgrcode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcelgrcode_; 
      } 

      public void setsrcetypecode(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         srcetypecode_ = param; 
         _isDirty_ = true; 
      } 

      public String getsrcetypecode() throws CodeException {
         if (!_isLoaded_) { read();} 
         return srcetypecode_; 
      } 

      public void setjecomment(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         jecomment_ = param; 
         _isDirty_ = true; 
      } 

      public String getjecomment() throws CodeException {
         if (!_isLoaded_) { read();} 
         return jecomment_; 
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
        
           else if (param.equals(PROPERTY_BTCHENTRY)) return decform.format(getbtchentry()); 
           else if (param.equals(PROPERTY_JOURNALID)) return decform.format(getjournalid()); 
           else if (param.equals(PROPERTY_TRANSNBR)) return decform.format(gettransnbr()); 
           else if (param.equals(PROPERTY_ACCCODE)) return getacccode(); 
           else if (param.equals(PROPERTY_TRANSAMTDBT)) return decform.format(gettransamtdbt()); 
           else if (param.equals(PROPERTY_TRANSAMTCRD)) return decform.format(gettransamtcrd()); 
           else if (param.equals(PROPERTY_TRANSQTY)) return String.valueOf(gettransqty()); 
           else if (param.equals(PROPERTY_CURNCCODE)) return getcurnccode(); 
           else if (param.equals(PROPERTY_SRCECURNCCODE)) return getsrcecurnccode(); 
           else if (param.equals(PROPERTY_RATETYPE)) return getratetype(); 
           else if (param.equals(PROPERTY_RATE)) return decform.format(getrate()); 
           else if (param.equals(PROPERTY_FUNCAMTDBT)) return decform.format(getfuncamtdbt()); 
           else if (param.equals(PROPERTY_FUNCAMTCRD)) return decform.format(getfuncamtcrd()); 
           else if (param.equals(PROPERTY_TRANSDESC)) return gettransdesc(); 
           else if (param.equals(PROPERTY_TRANSREF)) return gettransref(); 
           else if (param.equals(PROPERTY_TRANSDATE)) return gettransdate(); 
           else if (param.equals(PROPERTY_SRCELGRCODE)) return getsrcelgrcode(); 
           else if (param.equals(PROPERTY_SRCETYPECODE)) return getsrcetypecode(); 
           else if (param.equals(PROPERTY_JECOMMENT)) return getjecomment(); 
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
        
           else if (param.equals(PROPERTY_BTCHENTRY)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setbtchentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_JOURNALID)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setjournalid(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRANSNBR)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settransnbr(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ACCCODE))  setacccode(value); 
           else if (param.equals(PROPERTY_TRANSAMTDBT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settransamtdbt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRANSAMTCRD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          settransamtcrd(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRANSQTY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          settransqty(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_CURNCCODE))  setcurnccode(value); 
           else if (param.equals(PROPERTY_SRCECURNCCODE))  setsrcecurnccode(value); 
           else if (param.equals(PROPERTY_RATETYPE))  setratetype(value); 
           else if (param.equals(PROPERTY_RATE)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setrate(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_FUNCAMTDBT)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setfuncamtdbt(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_FUNCAMTCRD)) { 
                    double newVal; 
                    try { 
                          newVal = Double.parseDouble(value); 
                          setfuncamtcrd(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TRANSDESC))  settransdesc(value); 
           else if (param.equals(PROPERTY_TRANSREF))  settransref(value); 
           else if (param.equals(PROPERTY_TRANSDATE))  settransdate(value); 
           else if (param.equals(PROPERTY_SRCELGRCODE))  setsrcelgrcode(value); 
           else if (param.equals(PROPERTY_SRCETYPECODE))  setsrcetypecode(value); 
           else if (param.equals(PROPERTY_JECOMMENT))  setjecomment(value); 
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
            throw new CodeException("Gl_jed : Cannot Move First" + ex.getMessage());
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
             throw new CodeException("Gl_jed : Cannot Move Previous" + ex.getMessage());
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
             throw new CodeException("Gl_jed : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Gl_jed : Cannot Move Last " + ex.getMessage());
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



