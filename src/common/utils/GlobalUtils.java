 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.utils;


import common.classinterface.NavigatorObjectInt;
import common.jdbc.DbBean;
import common.jdbc.DbBeanCommon;
import common.objectclasses.Mastergroupdetails;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.kazao.calendar.KazaoCalendarDateTimeException;

/**
 *
 * @author windu
 */
public class GlobalUtils {
    
    public static final Cursor HOURGLASSCURSOR  = new Cursor(Cursor.WAIT_CURSOR);
    public static final Cursor NORMALCURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
    public static String userid = "";
    public static String password = "";
    public static String currentdir = "";
    public static String audituser="User";
    public static String auditdate="";
    public static String temp="/temp/";
    public static Mastergroupdetails mastergroupdetails;
    public static String company = "";
    public static String namapt = "";
    public static String sessiondate="";
    public static Boolean periodelocked=false;
    public static String serverip="";

    public static void setNamaPT(String namaPT){
        namapt = namaPT ;
    }
    public static String getNamaPT(){
        return namapt;
    }
    public static void setUserId(String userID) {
        userid = userID;
    }
    public static String getUserId() {
        return userid;
    }
    public static void setPassword(String Password) {
        password = Password;
    }
    public static String getPassword() {
        return password;
    }
    public static void setCurrentDir(String Currentdir) {
        currentdir = Currentdir; 
    }
    public static String getCurrentDir(){
        return currentdir;
    }
    public static void setAuditUser(String Audituser){
        audituser = Audituser;
    }
    public static String getAuditUser() {
        return audituser;
    }
    public static void setAuditDate(String Auditdate) {
        auditdate = Auditdate;
    }

    public static void setGlobal(String UserId, String Password, String Currentdir) {
        setUserId(UserId);
        setPassword(Password);
        setCurrentDir(Currentdir);
    }
   
    public static String churuf(Object o){
        String result="";

        if (o==null){
            return "";
        }
        result=o.toString().trim();
        
        return result;
    }
    public static String extractPassword(char spass[]){
       
            Integer i=new Integer(0);
            String spassword="";
            for (i=0;i<spass.length;i++){
                spassword=spassword+spass[i];
            }
            return spassword;
    }
    public static String CDate(String str){
         String hasil="00/00/0000";
         
         org.kazao.calendar.KazaoCalendarDate odate=new org.kazao.calendar.KazaoCalendarDate();
        try {
            odate.setDate(str);

            hasil=odate.getDate();
        } catch (KazaoCalendarDateTimeException ex) {
            hasil="00/00/0000";
        }
         return hasil;
     }
     public Double CNomor(String str){
        Double dresult=new Double(0);
        try {
        dresult= Double.parseDouble(str);
        } catch (NumberFormatException nfe){
        dresult=new Double(0);
        }
        return dresult;
    }
     public static Integer CNomorInt(String str){
        Integer dresult=new Integer(0);
        try {
        dresult= Integer.parseInt(str);
        } catch (NumberFormatException nfe){
        dresult=new Integer(0);
        }
        return dresult;
    }
     public static String getAuditDate(){
        String result="0000-00-00 00:00:00";
        if (auditdate.equals("")||auditdate.equals("0000-00-00 00:00:00")){
            DateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date date=new java.util.Date();
            result= dateformate.format(date);
        }
        return result;
    }
    public static String getCurrentDate(){
        DateFormat dateformate=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        java.util.Date date=new java.util.Date();
        return dateformate.format(date);
    }

    public static String getTanggalJam(){
        DateFormat dateformate=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        java.util.Date date=new java.util.Date();
        return dateformate.format(date);
    }

    public static String getCurrentMonth(){
        DateFormat dateformate=new SimpleDateFormat("MM");
        java.util.Date date=new java.util.Date();
        return dateformate.format(date);
    }

    public static String getCurrentYear(){
        DateFormat dateformate=new SimpleDateFormat("yyyy");
        java.util.Date date=new java.util.Date();
        return dateformate.format(date);
    }

    public static String getYear(Date date){
        DateFormat dateformate=new SimpleDateFormat("yyyy");
        return dateformate.format(date);
    }
    public static String getYear2Digit(Date date){
        DateFormat dateformate=new SimpleDateFormat("yy");
        return dateformate.format(date);
    }
    
    public static String getMonth(Date date){
        DateFormat dateformate=new SimpleDateFormat("MM");
        return dateformate.format(date);
    }
    
    public static String getDay(Date date){
        DateFormat dateformate=new SimpleDateFormat("dd");
        return dateformate.format(date);
    }
    
    
    public static String getDocDueDate(String tgl,Integer term){
        Date newdate=null;
        DateFormat dateformate=new SimpleDateFormat("MM/dd/yyyy");
        try {
            
            Calendar cal=Calendar.getInstance();
            Date d=dateformate.parse(tgl);
            
            cal.setTime(d);
            cal.add(Calendar.DATE,term);
            newdate=cal.getTime();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        return dateformate.format(newdate);
    }
    public static Integer getDay(String tgl){//REVISI 03/19/2008
        Integer iresult=new Integer(0);
        iresult=CNomorInt(tgl.substring(3,5));
        return iresult;
    }
    public static Integer getMonth(String tgl){
        Integer iresult=new Integer(0);
        iresult=CNomorInt(tgl.substring(0,2));
        return iresult;
    }
    public static Integer getYear(String tgl){
        Integer iresult=new Integer(0);
        iresult=CNomorInt(tgl.substring(6));
        return iresult;
    }

    public static String formatmonth(long month){
        if (month<10){
            return "0"+month;
        } else {
            return month+"";
        }
    }
    public static String getMySQLDateFormate(String tgl){
        String d="";
        String m="";
        String y="";
        //09/08/2007
        System.out.println(tgl);
        if (tgl!=null){
            if (tgl.trim()=="") {
                tgl="0000-00-00";
            } else {
                y=tgl.substring(6,10);
                d=tgl.substring(3,5);
                m=tgl.substring(0,2);
                tgl=y+"-"+m+"-"+d;
            }
        } else {
            tgl="0000-00-00";
        }
        return tgl;
    }
    
    public static String getConvertMySQLDate(String tgl){
        String d="";
        String m="";
        String y="";
        System.out.println(tgl);
        //2007-09-28
        if (tgl.trim()=="") {
            tgl="00/00/0000";
        } else {
            y=tgl.substring(0,4);
            d=tgl.substring(8,10);
            m=tgl.substring(5,7);
            tgl=m+"/"+d+"/"+y;
        }
        System.out.println(tgl);
        return tgl;
    }
    public static boolean getAppDir(){
        Boolean result=false;
        File dir1 = new File (".");
        File dir2 = new File ("..");
         try {
             setCurrentDir(dir1.getCanonicalPath().replace("\\","/"));
             java.lang.System.out.println(currentdir);
           }
         catch(IOException e) {
            try {
                
                setCurrentDir(dir2.getCanonicalPath().replace("\\","/"));
                java.lang.System.out.println(currentdir);
           } catch (IOException ex) {
                ex.printStackTrace();
            }
             
           }
        return result;
    }
    public static String showDateTime(int lday, String tipe) {
        String sTanggal;
        long lTanggal = new Date().getTime();

        //86400000 = satuhari ( 60 X 60 X 24 X 1000)
        lTanggal = lTanggal + lday * 86400000;
        Date dTanggal = new Date(lTanggal);
        sTanggal = (
                     dTanggal.getYear() + 1900
                   )
                   + "-" + (dTanggal.getMonth()+ 1)
                   + "-" + dTanggal.getDate();
        if (tipe.toUpperCase().equals("T")){
            sTanggal = sTanggal + " "
                       + dTanggal.getHours()
                       + ":" + dTanggal.getMinutes()
                       + ":" + dTanggal.getSeconds();
        }
        return (sTanggal);
    }

    public static String[] getMonth() {
        String[] month = {"Januari", "Februari", "Maret" , "April", "Mei", 
                          "Juni", "Juli" , "Agustus", "September",
                          "Oktober", "November" , "Desember" };
        return month;
    }

    public static void printReportMaster (Object obj) {
        NavigatorObjectInt noi = (NavigatorObjectInt) obj;
        String file   = getCurrentDir() +"/Reports/" + noi.getClassName() + ".jrxml";
        String query  = "Select * from " + noi.getTable();
        GlobalUtils.printReport(file,  query, false);
    }
    
   
    public static void printReport(String file, Map map, boolean preview) {
        JasperPrint jasperPrint;
            
        try {
            DbBean db = DbBean.connect();
            String sFile = file.substring(0, file.length() -6);
            
            File f = new File(sFile + ".jasper");
            if (!f.exists()) {
                JasperReport jasperReport = JasperCompileManager.compileReport(file);                
                jasperPrint = JasperFillManager.fillReport(jasperReport, map, db.getConnection());
            }else{
                jasperPrint = JasperFillManager.fillReport(sFile + ".jasper", map, db.getConnection());
            }
            
            JasperViewer.viewReport(jasperPrint, preview);
  
            db.close();
        }catch(JRException e){
            e.printStackTrace();
        
        }catch (CodeException e){
            e.printStackTrace();
        }
    }
    public static void printReport(String file, String query, boolean preview) {
        JasperPrint jasperPrint;
            
        try {
            
            DbBean db = DbBean.connect();
            ResultSet rs = db.executeQuery(query);
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);
            
            String sFile = file.substring(0, file.length() -6);
            File f = new File(sFile + ".jasper");
            if (!f.exists()) {
                JasperReport jasperReport = JasperCompileManager.compileReport(file);                
                jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), resultSetDataSource);
            }else{
                jasperPrint = JasperFillManager.fillReport(sFile + ".jasper",new HashMap(), resultSetDataSource);                
            }
            
            JasperViewer.viewReport(jasperPrint, preview);
            
            db.close();
        }catch(JRException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        
        }catch (CodeException e){
            e.printStackTrace();
        }
    }
    public static void printReport(String file, boolean preview) {
        printReport(file, new HashMap(), preview);
    }
    
    public static String formatSpaceRight(String string, int length) {
        return formatSpace(string,length,1);
    }
    public static String formatSpaceLeft(String string, int length) {
        return formatSpace(string,length,0);
    }
    
    public static String formatSpace(String string, int length, int pos) {
        int lengthstring = string.length();
        int minus = length - lengthstring;
        String space = "";
        
        for (int i=1; i<=minus; i++){
            space += " ";                        
        }
        
        if (pos==0) {
            string += space;
        }else{
            space += string;
            string = space;
        }
        return string;
    }
    
    
    public  static String copyfile(String srFile, String dtFile){
        String message = "";
        try{
          File f1 = new File(srFile);
          File f2 = new File(dtFile);
          InputStream in = new FileInputStream(f1);

          OutputStream out = new FileOutputStream(f2);

          byte[] buf = new byte[1024];
          int len;
          while ((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
          }
          in.close();
          out.close();
          message = "File copied to " + f2.getCanonicalPath();
          
        }catch(FileNotFoundException ex){
          message = ex.getMessage() + " in the specified directory.";
        }catch(IOException e){
          message = e.getMessage();      
        }
        
        return message;
        
      }
    
     public static String terbilang(double number) {
        String bilangan[] = new String[] { "", "Satu ", "Dua ", "Tiga ", "Empat ",
                "Lima ", "Enam ", "Tujuh ", "Delapan ", "Sembilan ", "Sepuluh ",
                "Sebelas "};
        String terbilang = "";
        if (number < 12) {
            terbilang = bilangan[(int)number];
        }
        else if (number >= 12 && number < 20) {
            terbilang += terbilang( number - 10);
            terbilang += "Belas ";
        }
        else if(number >= 20 && number < 100){
            terbilang += terbilang(number/10);
            terbilang += "Puluh ";
            terbilang += terbilang(number % 10);
        }
        else if (number >= 100 && number < 200) {
            terbilang += "Seratus ";
            terbilang += terbilang( number % 100 );
        }
        else if (number >= 200 && number < 1000){
            terbilang += terbilang(number / 100);
            terbilang += "Ratus ";
            terbilang += terbilang( number % 100 );
        }
        else if (number >= 1000 && number < 2000){
            terbilang += "Seribu ";
            terbilang += terbilang( number % 1000 );
        }
        else if(number >= 2000 && number < 1000000){
            terbilang += terbilang(number/1000);
            terbilang += "Ribu ";
            terbilang += terbilang( number % 1000);
        }
        else if (number >= 1000000 && number < 1000000000){
            terbilang += terbilang(number/1000000);
            terbilang += "Juta ";
            terbilang += terbilang( number % 1000000 );
        }
        return terbilang;
    }

    public static  void selectCellTable(JTable  jtable , int row,int col){
        if(row!=-1 && col !=-1){
            jtable.setRowSelectionInterval(row,row);
            jtable.setColumnSelectionInterval(col,col);

            scrollTableRowTo(jtable,row,col);
        }
    }
    public static void scrollTableRowTo(JTable  jtable, int row,int col){
            Rectangle rec = jtable.getCellRect(row, col, true);
            jtable.scrollRectToVisible(rec);
    }
     public static void setColumnWidth(JTable otable,Integer ColumnIdx,Integer Width){
       TableColumn column=otable.getColumnModel().getColumn(ColumnIdx);
       column.setMinWidth(0);
       column.setMaxWidth(Width);
       column.setPreferredWidth(Width);
    }

    public static String formatnumber(Object value){
        if (value==null){
            value=0;
        }
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat df = (DecimalFormat)nf;
        return df.format(value);
    }

     public static Double toDbl(String value){
        Double result=new Double(0);
        if (value.equalsIgnoreCase("")){value="0";}
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat df = (DecimalFormat)nf;
        try {
            result= df.parse(value).doubleValue();
            return result;
        } catch (ParseException ex) {
            return new Double(0);
        }
    }

    public static Integer toInt(String value){
        if (value.equalsIgnoreCase("")){value="0";}
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat df = (DecimalFormat)nf;
        try {
            return (Integer) df.parse(value).intValue();
        } catch (ParseException ex) {
            ex.printStackTrace();
            return new Integer(0);
        }
    }

    public static String formatDate(String tanggal,String format){
        String result=GlobalUtils.getAuditDate();
        Date date=null;
        try {
            tanggal=tanggal==null?GlobalUtils.getAuditDate():tanggal;
            tanggal=tanggal==""?GlobalUtils.getAuditDate():tanggal;
            tanggal=tanggal=="0000-00-00 00:00:00"?GlobalUtils.getAuditDate():tanggal;
            if (tanggal.contains("/")){
                DateFormat dateformate=new SimpleDateFormat("MM/dd/yyyy");
                date = dateformate.parse(tanggal);
                result=dateformate.format(date);
                DateFormat toformat=new SimpleDateFormat(format);
                result=toformat.format(date);

            } else {
                DateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
                date=dateformate.parse(tanggal);
                result=dateformate.format(date);
                DateFormat toformat=new SimpleDateFormat(format);
                result=toformat.format(date);
            }
        } catch (ParseException ex) {
            Logger.getLogger(GlobalUtils.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;
    }

    public static void highlighttext(JTextField otxt){
        otxt.setSelectionStart(0);
        otxt.setSelectionEnd(otxt.getText().length());
    }
    
    public static String getRomawi(int val) {
        String sRomawi = "";
        if (val == 1) {
            sRomawi = "I";
        }else if (val == 2) {
            sRomawi = "II";
        }else if(val == 3) {
            sRomawi = "III";
        }else if(val == 4) {
            sRomawi = "IV";
        }else if(val == 5) {
            sRomawi = "V";
        }else if(val == 6) {
            sRomawi = "VI";
        }else if(val == 7) {
            sRomawi = "VII";
        }else if(val == 8) {
            sRomawi = "VIII";
        }else if(val == 9) {
            sRomawi = "IX";
        }else if(val == 10) {
            sRomawi = "X";
        }else if(val == 11) {
            sRomawi = "XI";
        }else if(val == 12) {
            sRomawi = "XII";
        }
        return sRomawi;
    }

    public static String getlastdateofmonth(String tgl){
        Date newdate=null;
        DateFormat dateformate=new SimpleDateFormat("MM/dd/yyyy");
        try {

            Calendar cal=Calendar.getInstance();
            Date d=dateformate.parse(tgl);

            cal.setTime(d);

            int term=cal.getActualMaximum(Calendar.DATE);
            cal.add(Calendar.DATE,term-1);
            newdate=cal.getTime();

            System.out.println("Date     :"+tgl);
            System.out.println("Last Date:"+newdate);
            System.out.println("Max:"+term);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Calendar calendar=Calendar.getInstance();
        //int lastdate=calendar.getActualMaximum(time.getDate());
        
        return dateformate.format(newdate);

        
    }
     public static void main(String[] args)   {
          try {
                DbBeanCommon.InitConnection();
                //DbInsysCommon.initDB();
                //GlobalUtils.printReport("/home/windu/NetBeansProjects/FixedAssets/Reports/Category.jrxml", false);
                //GlobalUtils.printReport("/home/windu/NetBeansProjects/FixedAssets/Reports/Vendor.j", "Select * from vendor ", false);                
            }catch(Exception e) {
                e.printStackTrace();
            }

            
    }
    

}
