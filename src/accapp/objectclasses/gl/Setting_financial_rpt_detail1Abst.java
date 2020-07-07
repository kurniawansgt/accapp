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


public abstract class Setting_financial_rpt_detail1Abst implements CodeObjectInt, NavigatorObjectInt {
    
    public static final long NULLID = 0;
    public static final String CLASSNAME="Setting_financial_rpt_detail1";

    public static final String TABLE = "setting_financial_rpt_detail1";
 
    public String TABLEPROCESS = TABLE;
    
    
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DOCENTRY = "docentry";
    public static final String PROPERTY_LINENO = "lineno";
    public static final String PROPERTY_ROWNO = "rowno";
    public static final String PROPERTY_COLUMNTYPE = "columntype";
    public static final String PROPERTY_LEVELNO = "levelno";
    public static final String PROPERTY_TEXTHEADER = "textheader";
    public static final String PROPERTY_ALLOWFORMULATION = "allowformulation";
    public static final String PROPERTY_SUMMARY = "summary";
    public static final String PROPERTY_TEXTFORMULATION = "textformulation";
    public static final String PROPERTY_VISORDER = "visorder";
    public static final String PROPERTY_SHOWDATA = "showdata";
    
     public static final String PRIMARYKEY = PROPERTY_LINENO;
    
    
    private long id_;
    private long docentry_;
    private long lineno_;
    private long rowno_;
    private String columntype_;
    private long levelno_;
    private String textheader_;
    private String allowformulation_;
    private String summary_;
    private String textformulation_;
    private long visorder_;
    private String showdata_;
            
    static public ObjectCache cache = new ObjectCache(100);
    
    private boolean _isLoaded_ = false;
    private boolean _isDirty_ = false;
    
    DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
    DecimalFormat decform = new DecimalFormat("##0.00");
    DateFormat datetimeformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public String getCLASSNAME() {return CLASSNAME;}

    public Setting_financial_rpt_detail1Abst() throws CodeException {
        loadNew();
    }
    
    public Setting_financial_rpt_detail1Abst(long id) throws CodeException {
        loadID(id);

    }
    
    public Setting_financial_rpt_detail1Abst(String val)  throws CodeException {
        loadString(val);
    }
    
    public Setting_financial_rpt_detail1Abst (String key, String val)  throws CodeException {
        loadString(key,val);
    }
    
    public Setting_financial_rpt_detail1Abst(ResultSet rs) throws CodeException {
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
            throw new CodeException ("Error Create Setting_financial_rpt_detail1Abst for Key : " + key + " val : " + val);
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
            
            
            
           docentry_ = rs.getLong(PROPERTY_DOCENTRY); 
           lineno_ = rs.getLong(PROPERTY_LINENO); 
           rowno_ = rs.getLong(PROPERTY_ROWNO); 
           columntype_ = rs.getString(PROPERTY_COLUMNTYPE); 
           levelno_ = rs.getLong(PROPERTY_LEVELNO); 
           textheader_ = rs.getString(PROPERTY_TEXTHEADER); 
           allowformulation_ = rs.getString(PROPERTY_ALLOWFORMULATION); 
           summary_ = rs.getString(PROPERTY_SUMMARY); 
           textformulation_ = rs.getString(PROPERTY_TEXTFORMULATION); 
           visorder_ = rs.getLong(PROPERTY_VISORDER); 
           showdata_ = rs.getString(PROPERTY_SHOWDATA); 
            
            
            _isLoaded_ = true;
            _isDirty_ = false;
            
            
        }catch (SQLException e) {
            throw new CodeException ("Error Loading Setting_financial_rpt_detail1Abst " + e.getMessage());
        }
    }
    
    private void makeNew() {
        id_ = NULLID;
        _isLoaded_ = true;
    }
    
    public void read() throws CodeException {
       if (getID() != NULLID) {
            Setting_financial_rpt_detail1 obj = (Setting_financial_rpt_detail1)cache.get(getID());
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
                    throw new CodeException("Error Reading Setting_financial_rpt_detail1 " + e.getMessage());
                } finally {
                    db.close();
                }
            }
       }
    }

    public void checkNotNullFields() throws CodeException {
        Object o;
            
        
         o = getdocentry(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : docentry can not be Empty"); 
        } 
 
         o = getlineno(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : lineno can not be Empty"); 
        } 
 
         o = getsummary(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : summary can not be Empty"); 
        } 
 
         o = getvisorder(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : visorder can not be Empty"); 
        } 
 
         o = getshowdata(); 
        if (o == null) { 
            throw new CodeException ("Error Saving Application : showdata can not be Empty"); 
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
           rs = db.retrieveSQL("SELECT max(id) from setting_financial_rpt_detail1 ");
           rs.next();
           id_ = rs.getLong(1);
           
           rs.close();
           _isDirty_ = false;
        }catch (SQLException e) {
            throw new CodeException("Error Save New Setting_financial_rpt_detail1 " + e.getMessage());
        }finally{
            db.close();
        }
    }
    
    private void saveFields(ResultSet rs) throws CodeException {
        try {
            if (getID()==NULLID) {
                rs.updateLong(PROPERTY_ID, id_);
            }
        
            
            rs.updateLong(PROPERTY_DOCENTRY , docentry_ ); 
            rs.updateLong(PROPERTY_LINENO , lineno_ ); 
            rs.updateLong(PROPERTY_ROWNO , rowno_ ); 
            rs.updateString(PROPERTY_COLUMNTYPE , columntype_ ); 
            rs.updateLong(PROPERTY_LEVELNO , levelno_ ); 
            rs.updateString(PROPERTY_TEXTHEADER , textheader_ ); 
            rs.updateString(PROPERTY_ALLOWFORMULATION , allowformulation_ ); 
            rs.updateString(PROPERTY_SUMMARY , summary_ ); 
            rs.updateString(PROPERTY_TEXTFORMULATION , textformulation_ ); 
            rs.updateLong(PROPERTY_VISORDER , visorder_ ); 
            rs.updateString(PROPERTY_SHOWDATA , showdata_ ); 
                    
        }catch (SQLException se) {
            throw new CodeException ("Error Writing fields to Record " + se.getMessage());
        }
    }
    
    public void copy(CodeObjectInt jCob) throws CodeException {
        Setting_financial_rpt_detail1 obj = (Setting_financial_rpt_detail1) jCob;
        id_ = obj.getID();

        
          docentry_ = obj.getdocentry();
          lineno_ = obj.getlineno();
          rowno_ = obj.getrowno();
          columntype_ = obj.getcolumntype();
          levelno_ = obj.getlevelno();
          textheader_ = obj.gettextheader();
          allowformulation_ = obj.getallowformulation();
          summary_ = obj.getsummary();
          textformulation_ = obj.gettextformulation();
          visorder_ = obj.getvisorder();
          showdata_ = obj.getshowdata();
                
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

    
      public void setdocentry(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         docentry_ = param; 
         _isDirty_ = true; 
      } 

      public long getdocentry() throws CodeException {
         if (!_isLoaded_) { read();} 
         return docentry_; 
      } 

      public void setlineno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         lineno_ = param; 
         _isDirty_ = true; 
      } 

      public long getlineno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return lineno_; 
      } 

      public void setrowno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         rowno_ = param; 
         _isDirty_ = true; 
      } 

      public long getrowno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return rowno_; 
      } 

      public void setcolumntype(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         columntype_ = param; 
         _isDirty_ = true; 
      } 

      public String getcolumntype() throws CodeException {
         if (!_isLoaded_) { read();} 
         return columntype_; 
      } 

      public void setlevelno(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         levelno_ = param; 
         _isDirty_ = true; 
      } 

      public long getlevelno() throws CodeException {
         if (!_isLoaded_) { read();} 
         return levelno_; 
      } 

      public void settextheader(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         textheader_ = param; 
         _isDirty_ = true; 
      } 

      public String gettextheader() throws CodeException {
         if (!_isLoaded_) { read();} 
         return textheader_; 
      } 

      public void setallowformulation(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         allowformulation_ = param; 
         _isDirty_ = true; 
      } 

      public String getallowformulation() throws CodeException {
         if (!_isLoaded_) { read();} 
         return allowformulation_; 
      } 

      public void setsummary(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         summary_ = param; 
         _isDirty_ = true; 
      } 

      public String getsummary() throws CodeException {
         if (!_isLoaded_) { read();} 
         return summary_; 
      } 

      public void settextformulation(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         textformulation_ = param; 
         _isDirty_ = true; 
      } 

      public String gettextformulation() throws CodeException {
         if (!_isLoaded_) { read();} 
         return textformulation_; 
      } 

      public void setvisorder(long param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         visorder_ = param; 
         _isDirty_ = true; 
      } 

      public long getvisorder() throws CodeException {
         if (!_isLoaded_) { read();} 
         return visorder_; 
      } 

      public void setshowdata(String param) throws CodeException { 
         if (!_isLoaded_) { read();} 
         showdata_ = param; 
         _isDirty_ = true; 
      } 

      public String getshowdata() throws CodeException {
         if (!_isLoaded_) { read();} 
         return showdata_; 
      } 


    public void deleteAll() throws CodeException {
        //bisa ditambahin yang lain
        delete();
    }

    public String toString(String param) throws CodeException {
        if (param.equals(PROPERTY_ID)) { return String.valueOf(id_) ;}
        
           else if (param.equals(PROPERTY_DOCENTRY)) return String.valueOf(getdocentry()); 
           else if (param.equals(PROPERTY_LINENO)) return String.valueOf(getlineno()); 
           else if (param.equals(PROPERTY_ROWNO)) return String.valueOf(getrowno()); 
           else if (param.equals(PROPERTY_COLUMNTYPE)) return getcolumntype(); 
           else if (param.equals(PROPERTY_LEVELNO)) return String.valueOf(getlevelno()); 
           else if (param.equals(PROPERTY_TEXTHEADER)) return gettextheader(); 
           else if (param.equals(PROPERTY_ALLOWFORMULATION)) return getallowformulation(); 
           else if (param.equals(PROPERTY_SUMMARY)) return getsummary(); 
           else if (param.equals(PROPERTY_TEXTFORMULATION)) return gettextformulation(); 
           else if (param.equals(PROPERTY_VISORDER)) return String.valueOf(getvisorder()); 
           else if (param.equals(PROPERTY_SHOWDATA)) return getshowdata(); 
       
        
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
        
           else if (param.equals(PROPERTY_DOCENTRY)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setdocentry(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_LINENO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlineno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_ROWNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setrowno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_COLUMNTYPE))  setcolumntype(value); 
           else if (param.equals(PROPERTY_LEVELNO)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setlevelno(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_TEXTHEADER))  settextheader(value); 
           else if (param.equals(PROPERTY_ALLOWFORMULATION))  setallowformulation(value); 
           else if (param.equals(PROPERTY_SUMMARY))  setsummary(value); 
           else if (param.equals(PROPERTY_TEXTFORMULATION))  settextformulation(value); 
           else if (param.equals(PROPERTY_VISORDER)) { 
                    long newVal; 
                    try { 
                          newVal = Long.parseLong(value); 
                          setvisorder(newVal); 
                    } catch (NumberFormatException nfe){ 
                      throw new CodeException("Unrecognised Number format: "+nfe.getMessage(),nfe); 
                    }
           }
           else if (param.equals(PROPERTY_SHOWDATA))  setshowdata(value); 
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
            throw new CodeException("Setting_financial_rpt_detail1 : Cannot Move First" + ex.getMessage());
        }
    }

    public void movePrevious() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.movePrevious(TABLEPROCESS, PRIMARYKEY, lineno_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Setting_financial_rpt_detail1 : Cannot Move Previous" + ex.getMessage());
        }
    }

    public void moveNext() throws CodeException {
        try {
            DbBean db = DbBean.connect();
            ResultSet rs = db.moveNext(TABLEPROCESS, PRIMARYKEY, lineno_+"");
            if (rs.next()) {
                load(rs);
            }
            db.close();
        } catch (SQLException ex) {
             throw new CodeException("Setting_financial_rpt_detail1 : Cannot Move Next " + ex.getMessage());
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
             throw new CodeException("Setting_financial_rpt_detail1 : Cannot Move Last " + ex.getMessage());
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



