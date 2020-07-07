package common.utils;

import java.util.Vector;

public class ObjectPool{
  private int max_ = 0;
  private Vector pool;
  private Class class_;
 
  public ObjectPool(int max, Class poolClass){
     this.max_ = max;
     this.class_ = poolClass;
     this.pool = new Vector(max + 2);
  }
 
  public void add(Object obj) {
    synchronized (this.pool) {
      if (this.pool.size() < this.max_)
         this.pool.add(obj);
      }
  }
 
  public Object getObject(){
     if (this.pool.size() == 0) {
       return null;
     }
     synchronized (this.pool) {
        if (this.pool.size() == 0) {
         return null;
        }

        Object o = this.pool.elementAt(0);
        this.pool.removeElementAt(0);
     return o;
     }
   }
}
