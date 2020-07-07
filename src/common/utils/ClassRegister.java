package common.utils;
 
import java.util.Hashtable;

public class ClassRegister
{
    private static ClassRegister instance_ = new ClassRegister();
    private Hashtable h = new Hashtable();
 
    public static ClassRegister instance(){
      return instance_;
    }
    public Hashtable getCollection() {
      return this.h;
    }

    public void register(String name){
      if (this.h.containsKey(name)) {
        Pair p = (Pair)this.h.get(name);
        p.increment();
      }else {
        Pair p = new Pair();
        this.h.put(name, p);
      }
   }

   public void remove(String name){
      int max = 0;

      Pair p = null;
      if (this.h.containsKey(name)) {
        p = (Pair)this.h.get(name);
        p.decrement();
      }else {
        System.err.println("****** Register cannot remove " + name + " ********");
      }
   }
 
   public void report(){
     report(false);
   }

   public void report(boolean gc) {
     if (gc) {
       System.gc();
     }
     System.out.println(this.h);
   }
 
   public Hashtable getRegister(){
     return this.h;
   }
}

