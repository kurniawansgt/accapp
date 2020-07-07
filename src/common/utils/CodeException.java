package common.utils;
 
public class CodeException extends Exception
{
    protected Exception ex_;

    public CodeException(String s)
    {
        this(s, null);
    }
 
    public CodeException(Exception ex) {
        this(ex.getMessage(), ex);
    }

    public CodeException(String s, Exception ex) {
        super(s);
        this.ex_ = ex;
        System.out.println("[" + getTitle() + "] " + super.getMessage());
   }

   public String getTitle() {
     return "Object Framework Error";
   }
 
   public Exception getException() {
     return this.ex_;
   }
}

