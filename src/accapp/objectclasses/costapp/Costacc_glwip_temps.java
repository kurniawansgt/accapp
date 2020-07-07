/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This Class is Called Collection.
 * It Means this class can contain one or more row(s)
 * 
 * How to use
 * 1. Upload data to Collection 
 *    -  Costacc_glwip_temps objs = new Costacc_glwip_temps(0); // All Data
 *    or 
 *    - Costacc_glwip_temps obj = new Costacc_glwip_temps(Costacc_glwip_temp.PROPERTY_<field>, <value>);
 *      Sample :
 *      Costacc_glwip_temps obj = new Costacc_glwip_temps(Costacc_glwip_temp.PROPERTY_ID, "1");
 *      It Means : Select * from Costacc_glwip_temp where id = "1";
 *    - Resultset
 *      Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM Costacc_glwip_temp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            recordLoad(rs);
            try {
                rs.close();
            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }                

        } catch (SQLException ex) {
            throw new CodeException("mastergroup : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 *
 * 2. Read Data 
        try {
            DbBean.InitConnection();
            Costacc_glwip_temps brs = new Costacc_glwip_temps(0);

            for (Iterator<Costacc_glwip_temp> it = brs.iterator(); it.hasNext(); ) {
                
                Costacc_glwip_temp br = (Costacc_glwip_temp) it.next();
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCostacc_glwip_temp());
                
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }
 
       or
        try {
            DbBean.InitConnection();
            Costacc_glwip_temps brs = new Costacc_glwip_temps(0);

            for (int i = 0; i < brs.size(); i++) {
                Costacc_glwip_temp br = (Costacc_glwip_temp) brs.list.get(i);
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCostacc_glwip_temp());
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }

       or
       try {
            DbBean.InitConnection();
            Costacc_glwip_temps brs = new Costacc_glwip_temps(0);

            List<Object> list = brs.list();
            
            for (Object Obj : list) {
                Costacc_glwip_temp br = (Costacc_glwip_temp) obj;
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCostacc_glwip_temp());
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }

 * 
 *  
 * 
 * 
 */

package accapp.objectclasses.costapp;

import common.classinterface.NavigatorBrowseDataInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.utils.ClassRegister;
import common.classinterface.CodeCollectionInt;
import common.utils.CodeException;
import common.classinterface.CodeObjectInt;
import common.jdbc.DbBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author windu
 */
public class Costacc_glwip_temps  implements CodeCollectionInt, NavigatorBrowseDataInt{

    public static final long NULLID = 0;
    public static final String CLASSNAME = "Costacc_glwip_temps";
    public static final String SQLNAME = Costacc_glwip_temp.TABLE;
    public static String DEFAULTSORT = Costacc_glwip_temp.PROPERTY_ID;

    public static String SORTASC = "ASC";
    public static String SORTDESC = "DESC";
    
    public static final String FOREIGNKEY = Costacc_glwip_temp.PROPERTY_ID;
    
    public static final int SEARCHNORMALY = 0;
    public static final int SEARCHSTARTWITH = 1;
    public static final int SEARCHLIKE = 2;
    
    
    List<Object> list;
    private Costacc_glwip_temp parentObj_;
    private long ID_;
    private boolean _isLoaded_ = false;
    private boolean _isDirty_= false;
    
    
    private String key_ = null;
    private String val_ = null;
    private long searchMethod = SEARCHNORMALY; 
    private long skip = 0;
    private long limit = 0;
    private String fieldsort = DEFAULTSORT;
    private String sortby = SORTASC;
    
    
    private String[][] column = {
        {Costacc_glwip_temp.PRIMARYKEY, Costacc_glwip_temp.PRIMARYKEY, "200"}, 
        {Costacc_glwip_temp.PRIMARYKEY, Costacc_glwip_temp.PRIMARYKEY, "200"} 
    };
    
    
    public String getCLASSNAME(){ return CLASSNAME; }
    
    public Costacc_glwip_temps() throws CodeException {
        this (new Costacc_glwip_temp(NULLID));
        _isLoaded_ = true;
    }
    
    public Costacc_glwip_temps(long ID) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = new Costacc_glwip_temp(ID);
        ID_ = ID;
    }
    
    public Costacc_glwip_temps(String PrimaryKey) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = new Costacc_glwip_temp(PrimaryKey);
        ID_ = parentObj_.getID();
    }
    
    public Costacc_glwip_temps(Costacc_glwip_temp parent) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = parent;
        ID_ = parentObj_.getID();
        if (ID_ == NULLID) {
            _isLoaded_ = true;
            list = Collections.synchronizedList(new ArrayList<Object>());
        }
    }
    
    public Costacc_glwip_temps(String key, String val) {
        ClassRegister.instance().register(CLASSNAME);
        key_ = key;
        val_ = val;
    }
    
    public Costacc_glwip_temps(String key, String val, int searchMethod) {
        ClassRegister.instance().register(CLASSNAME);
        key_ = key;
        val_ = val;
        this.searchMethod = searchMethod;
    }
    
    public void searchData (String key, String val, int searchMethod,  int skip, int limit )  throws CodeException {
        key_ = key;
        val_ = val;
        this.searchMethod = searchMethod;
        this.skip = skip;
        this.limit = limit;
        _isLoaded_ = false;
        
        dbRead();
        
    } 
    public void searchData (String key, String val, int searchMethod,  String fieldsort, String sortby, int skip, int limit ) throws CodeException {
        key_ = key;
        val_ = val;
        this.searchMethod = searchMethod;        
        this.fieldsort = fieldsort;
        this.sortby = sortby;
        this.skip = skip;
        this.limit = limit;
        
        _isLoaded_ = false;
        
        dbRead();
        
    }
    
    public void dbRead() throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();
        
        
        if (!_isLoaded_) {
                 
            if  (searchMethod > SEARCHNORMALY) {
                if (searchMethod == SEARCHSTARTWITH && skip >=0 && limit == 0  && sortby.equals(SORTASC)) {
                     rs = db.retrieveStartWith(SQLNAME, key_, val_, DEFAULTSORT);
                }else if (searchMethod == SEARCHSTARTWITH && skip >=0 && limit == 0  && sortby.equals(SORTDESC)) {
                     rs = db.retrieveStartWithDesc(SQLNAME, key_, val_, DEFAULTSORT);                                     
                     
                }else if (searchMethod == SEARCHSTARTWITH && skip >=0 && limit > 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieveStartWithLimit(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                }else if (searchMethod == SEARCHSTARTWITH && skip >=0 && limit > 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveStartWithLimitDesc(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                
                }else if (searchMethod == SEARCHLIKE && skip >=0 && limit == 0  && sortby.equals(SORTASC)) {
                     rs = db.retrieveLike(SQLNAME, key_, val_, DEFAULTSORT);
                }else if (searchMethod == SEARCHLIKE && skip >=0 && limit == 0  && sortby.equals(SORTDESC)) {
                     rs = db.retrieveLikeDesc(SQLNAME, key_, val_, DEFAULTSORT);                             
                     
                }else if (searchMethod == SEARCHLIKE && skip >=0 && limit > 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieveLikeLimit(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                }else if (searchMethod == SEARCHLIKE && skip >=0 && limit > 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveLikeLimitDesc(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                }
                     
            }else {
                if (key_ != null && skip >=0 && limit == 0  && sortby.equals(SORTASC)) {
                     rs = db.retrieve(SQLNAME, key_, val_, DEFAULTSORT);
                }else if (key_ != null && skip >=0 && limit == 0  && sortby.equals(SORTDESC)) {
                     rs = db.retrieveDesc(SQLNAME, key_, val_, DEFAULTSORT);
                     
                }else if (key_ != null && skip >=0 && limit > 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieveLimit(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                }else if (key_ != null && skip >=0 && limit > 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveLimitDesc(SQLNAME, key_, val_, DEFAULTSORT, skip, limit);
                     
                }else if (ID_ == NULLID && skip >=0 && limit == 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieve(SQLNAME, DEFAULTSORT);                 
                }else if (ID_ == NULLID && skip >=0 && limit == 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveDesc(SQLNAME, DEFAULTSORT);                               
                     
                }else if (ID_ == NULLID && skip >=0 && limit > 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieveLimit(SQLNAME, DEFAULTSORT, skip, limit);
                }else if (ID_ == NULLID && skip >=0 && limit > 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveLimitDesc(SQLNAME, DEFAULTSORT, skip, limit);
                     
                }else if (ID_ != NULLID && skip >=0 && limit == 0  && sortby.equals(SORTASC)) {
                     rs = db.retrieve(SQLNAME, FOREIGNKEY, ID_, DEFAULTSORT);               
                }else if (ID_ != NULLID && skip >=0 && limit == 0  && sortby.equals(SORTDESC)) {
                     rs = db.retrieveDesc(SQLNAME, FOREIGNKEY, ID_, DEFAULTSORT);               
                     
                }else if (ID_ != NULLID && skip >=0 && limit > 0 && sortby.equals(SORTASC)) {
                     rs = db.retrieveLimit(SQLNAME, FOREIGNKEY, ID_, DEFAULTSORT, skip, limit);
                }else if (ID_ != NULLID && skip >=0 && limit > 0 && sortby.equals(SORTDESC)) {
                     rs = db.retrieveLimitDesc(SQLNAME, FOREIGNKEY, ID_, DEFAULTSORT, skip, limit);
                }
                
            }
            
            
            recordLoad(rs);
            try {
                rs.close();
            }catch (SQLException e) {
                throw new CodeException ("Read Error : " + e.getMessage(), e );
            }finally {
                db.close();
            }
        }

    }
    
    public void recordLoad(ResultSet rs) throws CodeException {
           list = Collections.synchronizedList(new ArrayList<Object>());
           try {
               while (rs.next()) {
                   list.add(new Costacc_glwip_temp(rs));
               }
               _isLoaded_ = true;
               _isDirty_ = false;
           }catch (SQLException e) {
               throw new CodeException("Load Error " + e.getMessage(), e);
           }
    }

    public void add(Costacc_glwip_temp obj) throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        list.add(obj);
    }
    
    public void add(Costacc_glwip_temps obj) throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
            add((Costacc_glwip_temp) it.next());
        }        
                
    }
    
    public long getID() {
        return ID_;
    }
    
    public void setID(long ID) throws CodeException {
        ID_ = ID;
        parentObj_ = new Costacc_glwip_temp(ID);
        _isLoaded_ = false;
        dbRead();
    }
    
    public Costacc_glwip_temp getParent() {
        return parentObj_;
    }
    
    public void setParent(Costacc_glwip_temp obj) throws CodeException{
        parentObj_ = obj;
        ID_ = parentObj_.getID();
        if (ID_ == NULLID) {
            _isLoaded_ = true;
            dbRead();
        }
    }
    
    public List<Object> list() throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        return list;
    }
    
    public Iterator<Object> iterator() throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        return list.iterator();
    }

    public int size() throws CodeException {
        if (!_isLoaded_){
            dbRead();
        }
        return list.size();
    }
   
    public long count() throws CodeException {
        DbBean db = DbBean.connect();
        long count = db.count(SQLNAME);
        db.close();
        return count;
    }

    public void fromString(String key, String val) throws CodeException {
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
                Costacc_glwip_temp obj = (Costacc_glwip_temp) it.next();
                obj.fromString(key, val);
        }        
        
    }

    public void delete() throws CodeException {
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Costacc_glwip_temp obj = (Costacc_glwip_temp) it.next();
            obj.delete();
            _isLoaded_ = false;
        }        
    }
    
    public void deleteAll() throws CodeException{
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Costacc_glwip_temp obj = (Costacc_glwip_temp) it.next();
            obj.deleteAll();
            _isLoaded_ = false;
        }        
    }
    
    
    public void resetID() throws CodeException {
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Costacc_glwip_temp obj = (Costacc_glwip_temp) it.next();
            obj.resetID();
        }        
    }
    
    public void copy(CodeObjectInt obj) throws CodeException {
        
    }
    
    public void setSQLSkip(long skip) throws CodeException {
        if (skip < 0 ) {
            throw new CodeException("Skip And Limit must equal or greater than 0");
        }
        this.skip = skip;
        _isLoaded_ = false;
    }

    public void setSQLLimit(long limit) throws CodeException {
        if (limit < 0 ) {
            throw new CodeException("Skip And Limit must equal or greater than 0");
        }
        this.limit = limit;
        _isLoaded_ = false;
   }


    public String toString(String arg0) throws CodeException {
        try {
            return toString(", ");
        }catch (CodeException e) {
            return e.getLocalizedMessage();
        }
    }

    public void save() throws CodeException {
        if(_isLoaded_) {
            for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                Costacc_glwip_temp obj = (Costacc_glwip_temp) it.next();
                obj.save();
            }        
        }
    }


    public String[] getSecurityTokens() throws CodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected void finalize() throws Throwable {
        ClassRegister.instance().remove(CLASSNAME);
        super.finalize();
    }
    
    public String[][] getColumn() {
        return this.column;
    }

    public String getDefaultSort() {
        return Costacc_glwip_temps.DEFAULTSORT;
    }

    public String getSQLNAME(){
        return Costacc_glwip_temps.SQLNAME;
    }

    public void loadData(String bulan, String tahun) throws CodeException {
        DbBean db = DbBean.connect(); 

        String sql = " SELECT * FROM bankjurnal.costacc_glwip_temp WHERE mop = " + bulan + " AND yop =  " + tahun ;
        
        
        System.out.println(sql);

        try {
            ResultSet rs = db.executeQuery(sql);
            recordLoad(rs);
                
        } catch (SQLException ex) {
            throw new CodeException("Load Data: Cannot Set Data " + ex.getMessage());
        }
        db.close();        
    }



}
