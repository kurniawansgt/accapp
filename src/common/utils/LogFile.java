package common.utils;

import common.utils.CodeException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LogFile {
    private static LogFile instance_ = new LogFile();
    private File f;
    private PrintWriter pwOut;
 
    private LogFile() {
     try{
       this.f = new File(System.getProperty("java.io.tmpdir") + File.separator + "jawacode-common.log");
       FileWriter fw = new FileWriter(this.f);
       BufferedWriter bw = new BufferedWriter(fw);
       this.pwOut = new PrintWriter(bw, true);
     }catch (Exception e) {
        System.out.println("Unable to create Log File : " + e.getMessage());
     }
    }

   public static LogFile instance() {
    return instance_;
   }
 
   public File getFile() {
     return this.f;
   }
 
   public PrintWriter getWriter() throws CodeException {
      return this.pwOut;
   }
}

