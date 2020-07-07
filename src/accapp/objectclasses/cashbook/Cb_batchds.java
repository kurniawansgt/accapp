/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This Class is Called Collection.
 * It Means this class can contain one or more row(s)
 * 
 * How to use
 * 1. Upload data to Collection 
 *    -  Cb_batchds objs = new Cb_batchds(0); // All Data
 *    or 
 *    - Cb_batchds obj = new Cb_batchds(Cb_batchd.PROPERTY_<field>, <value>);
 *      Sample :
 *      Cb_batchds obj = new Cb_batchds(Cb_batchd.PROPERTY_ID, "1");
 *      It Means : Select * from Cb_batchd where id = "1";
 *    - Resultset
 *      Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM Cb_batchd Where id = 1" ;
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
            Cb_batchds brs = new Cb_batchds(0);

            for (Iterator<Cb_batchd> it = brs.iterator(); it.hasNext(); ) {
                
                Cb_batchd br = (Cb_batchd) it.next();
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCb_batchd());
                
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }
 
       or
        try {
            DbBean.InitConnection();
            Cb_batchds brs = new Cb_batchds(0);

            for (int i = 0; i < brs.size(); i++) {
                Cb_batchd br = (Cb_batchd) brs.list.get(i);
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCb_batchd());
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }

       or
       try {
            DbBean.InitConnection();
            Cb_batchds brs = new Cb_batchds(0);

            List<Object> list = brs.list();
            
            for (Object Obj : list) {
                Cb_batchd br = (Cb_batchd) obj;
                System.out.println( "ID " + br.getID());
                System.out.println( "ID " + br.getNamaCb_batchd());
            }
            
        }catch(CodeException e) {
            e.printStackTrace();
        }

 * 
 *  
 * 
 * 
 */

package accapp.objectclasses.cashbook;

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
public class Cb_batchds  implements CodeCollectionInt, NavigatorBrowseDataInt{

    public static final long NULLID = 0;
    public static final String CLASSNAME = "Cb_batchds";
    public static final String SQLNAME = Cb_batchd.TABLE;
    public static String DEFAULTSORT = Cb_batchd.PROPERTY_ID;

    public static String SORTASC = "ASC";
    public static String SORTDESC = "DESC";
    
    public static final String FOREIGNKEY = Cb_batchd.PROPERTY_ID;
    
    public static final int SEARCHNORMALY = 0;
    public static final int SEARCHSTARTWITH = 1;
    public static final int SEARCHLIKE = 2;
    
    
    List<Object> list;
    private Cb_batchd parentObj_;
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
        {Cb_batchd.PRIMARYKEY, Cb_batchd.PRIMARYKEY, "200"}, 
        {Cb_batchd.PRIMARYKEY, Cb_batchd.PRIMARYKEY, "200"} 
    };
    
    
    public String getCLASSNAME(){ return CLASSNAME; }
    
    public Cb_batchds() throws CodeException {
        this (new Cb_batchd(NULLID));
        _isLoaded_ = true;
    }
    
    public Cb_batchds(long ID) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = new Cb_batchd(ID);
        ID_ = ID;
    }
    
    public Cb_batchds(String PrimaryKey) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = new Cb_batchd(PrimaryKey);
        ID_ = parentObj_.getID();
    }
    
    public Cb_batchds(Cb_batchd parent) throws CodeException {
        ClassRegister.instance().register(CLASSNAME);
        parentObj_ = parent;
        ID_ = parentObj_.getID();
        if (ID_ == NULLID) {
            _isLoaded_ = true;
            list = Collections.synchronizedList(new ArrayList<Object>());
        }
    }
    
    public Cb_batchds(String key, String val) {
        ClassRegister.instance().register(CLASSNAME);
        key_ = key;
        val_ = val;
    }
    
    public Cb_batchds(String key, String val, int searchMethod) {
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
                   list.add(new Cb_batchd(rs));
               }
               _isLoaded_ = true;
               _isDirty_ = false;
           }catch (SQLException e) {
               throw new CodeException("Load Error " + e.getMessage(), e);
           }
    }

    public void add(Cb_batchd obj) throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        list.add(obj);
    }
    
    public void add(Cb_batchds obj) throws CodeException {
        if (!_isLoaded_) {
            dbRead();
        }
        for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
            add((Cb_batchd) it.next());
        }        
                
    }
    
    public long getID() {
        return ID_;
    }
    
    public void setID(long ID) throws CodeException {
        ID_ = ID;
        parentObj_ = new Cb_batchd(ID);
        _isLoaded_ = false;
        dbRead();
    }
    
    public Cb_batchd getParent() {
        return parentObj_;
    }
    
    public void setParent(Cb_batchd obj) throws CodeException{
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
                Cb_batchd obj = (Cb_batchd) it.next();
                obj.fromString(key, val);
        }        
        
    }

    public void delete() throws CodeException {
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Cb_batchd obj = (Cb_batchd) it.next();
            obj.delete();
            _isLoaded_ = false;
        }        
    }
    
    public void deleteAll() throws CodeException{
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Cb_batchd obj = (Cb_batchd) it.next();
            obj.deleteAll();
            _isLoaded_ = false;
        }        
    }
    
    
    public void resetID() throws CodeException {
        for (Iterator<Object> it = iterator(); it.hasNext(); ) {
            Cb_batchd obj = (Cb_batchd) it.next();
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
                Cb_batchd obj = (Cb_batchd) it.next();
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
        return Cb_batchds.DEFAULTSORT;
    }

    public String getSQLNAME(){
        return Cb_batchds.SQLNAME;
    }


    public void searchData(double batchno, long entryno) throws CodeException {
        ResultSet rs = null;
        DbBean db = DbBean.connect();

        String query = " select * from cb_batchd where batchno = " + batchno + "  and entryno = " + entryno;

         
        try {
            rs = db.executeQuery(query);

            recordLoad(rs);
            rs.close();

        }catch (SQLException e) {
            throw new CodeException ("Read Error : " + e.getMessage(), e );
        }finally {
            db.close();
        }
        

    }


}
