package common.utils;
import common.classinterface.CodeObjectInt;
import common.utils.CodeException;
import java.util.Hashtable;
import java.util.Vector;

public class ObjectCache{
    public static long getRequests = 0L;
    public static long getHits = 0L;
    public static long addRequests = 0L;
    public static long adds = 0L;
    public static long removeRequest = 0L;
    public static long removes = 0L;
    private int max_ = 0;
    private Vector pool;
    private Hashtable hash;
    private Class class_;
 
    public ObjectCache(int max){
        this.max_ = max;
        this.pool = new Vector(max + 2);
        this.hash = new Hashtable();
    }
 
    public void add(CodeObjectInt obj) throws CodeException {
        synchronized (this.pool) {
        addRequests += 1L;
  
        long ID = obj.getID();
        if (get(ID) == null){
            adds += 1L;
            CodeObjectInt newObj;
            try{
                newObj = (CodeObjectInt)obj.getClass().newInstance();
                newObj.copy(obj);
            }catch (Exception e) {
               throw new CodeException("Unable to create new object from cache: " + e.getMessage(), e);
            }

            Long longID = new Long(ID);
            this.pool.add(longID);
            this.hash.put(longID, newObj);
       }
 
       if (this.pool.size() > this.max_) {
           Long longID = (Long)this.pool.elementAt(0);
           this.pool.removeElementAt(0);
           this.hash.remove(longID);
       }
     }
   }
 
   public CodeObjectInt get(long key) throws CodeException {
         getRequests += 1L;
 
         CodeObjectInt obj = (CodeObjectInt)this.hash.get(new Long(key));
         if (obj == null) {
             return null;
         }

        getHits += 1L;
        CodeObjectInt newObj;
        try{
           newObj = (CodeObjectInt)obj.getClass().newInstance();
           newObj.copy(obj);
        }catch (Exception e) {
           throw new CodeException("Unable to create new object from cache: " + e.getMessage(), e);
        }
        return newObj;
   }
   public void clear() {
     synchronized (this.pool) {
       this.pool.removeAllElements();
       this.hash = new Hashtable();
       getRequests = 0L;
       getHits = 0L;
       addRequests = 0L;
       adds = 0L;
       removeRequest = 0L;
       removes = 0L;
     }
   }
 
   public void remove(CodeObjectInt obj) throws CodeException {
     removeRequest += 1L;
     Long longID = new Long(obj.getID());
     this.hash.remove(longID);
     if (this.pool.removeElement(longID))
       removes += 1L;
   }

   public int getMax(){
     return this.max_;
   }

   public int getPoolSize() {
     return this.pool.size();
    }
    
    public int getCacheSize() {
         return this.hash.size();
    }
}

