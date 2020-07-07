/*
 * DbBean.java
 *
 * Created on July 10, 2007, 3:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 *
 * Koneksi ke database SQL (apa aja)
 */

package common.jdbc;

import common.utils.GlobalUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import common.utils.ClassRegister;
import common.utils.CodeException;
import common.utils.ObjectPool;
import java.sql.CallableStatement;


/**
 *
 * @author sandy
 */
public class DbBeanWMS  {
    private Boolean beginTransaction=false;
    PreparedStatement statementt=null;
    
    
    private static ObjectPool pool = new ObjectPool(5,null);
    private static boolean isUsed = false;
    public static String serverip =  "localhost";
    public static String driver ="com.mysql.jdbc.Driver";
    public static String database ="manufaktur";
    public static String url = "jdbc:mysql://" + serverip + ":3306/" + database; 
    public static int dbtype = 2;
    
    public static String username = "sa"; 
    public static String password = "spvsql";
    
    public Connection connection;
    public Statement statement;
     
    public DbBeanWMS(){
        try {
            connectDriver();
            initDB();

        } catch (CodeException ex) {
        }
        
        ClassRegister.instance().register(this.getClass().getName());
    }
 
    
    public static void setServerIp(String serverip) {
        DbBeanWMS.serverip = serverip;
    }
    
    public static String getServerIP(){
        return serverip;
    }
    
    public static void setDatabase(String database ) {
        DbBeanWMS.database = database;
    }
    
    public static String getDatabase() {
        return database;
    }
    
    public static int getDbType() {
        return dbtype;
    }

    public static void setUrl(String url) {
        DbBeanWMS.url = url;
    }
    public static String getUrl() {
        return url;
    }
    
    public static String getDriver() {
        return driver;
    }
    public static void setDriver(String driver) {
        DbBeanWMS.driver = driver;
    }    
    public static void setUserName(String username) {
        DbBeanWMS.username = username;
    }
    
    public static String getUserName(){
        return username;
    }
    
    public static void setPassword(String password) {
        DbBeanWMS.password = password;
    }

    public static String getPassword() {
        return password;
    }
    
    public static Boolean InitConnection(){
        boolean appDir = GlobalUtils.getAppDir();

        Boolean status=false;
        BufferedReader in=null;
        String str="";
        try {
            
            in=new BufferedReader(new FileReader(GlobalUtils.getCurrentDir() + "/ServerWMS.txt"));
            try {
                java.lang.System.out.println("File System setting (ServerWMS.txt found)");
                while (str !=null) {
                    str=in.readLine();
                    if (str!=null) {
                        if (!str.contains("//")){
                            if (str.contains("server")){
                                DbBeanWMS.setServerIp(serverip=str.substring(7));
                            }
                            if(str.contains("database")) {
                                DbBeanWMS.setDatabase(str.substring(9));
                            }
                        }
                    }
                }
                in.close();
                status=true;
            } catch (IOException ex) {
                    ex.printStackTrace();
                    try {
                        in.close();
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }
            }
        } catch (FileNotFoundException ex) {
            java.lang.System.out.println("File System setting (Server.txt) not found");
        }
        initDB();
        return status;
    }
    
    

    
    public static void initDB(){
        initDB(dbtype);
    }
    
    public static void initDB(int dbtype) {
      initDB(dbtype, serverip, database);  
    }
    
    public static void initDB(int dbtype, String database) {
        initDB(dbtype, serverip, database);
    }
    
    public static void initDB(int dbtype, String serverip, String database) {
      switch(dbtype) {
            case 1:
                driver ="oracle.jdbc.driver.OracleDriver";
                url = "jdbc:oracle:thin@" + serverip + ":1521:xe"; 
                break;
            case 2:
                driver ="com.mysql.jdbc.Driver";
                url = "jdbc:mysql://" + serverip + ":3306/" + database ; 
                break;
            case 3:
                driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                url = "jdbc:sqlserver://" + serverip + ";databaseName=" + database ; 
                break;
                        
        }
    }
    public boolean doexecute(String query) throws SQLException{
            statement.execute(query);
            return true;

    }
    
    public static DbBeanWMS connect() throws CodeException {
        DbBeanWMS db = null;

        do {
            db = (DbBeanWMS) pool.getObject();
            if (db != null && !db.isConnectionClosed()) {
                return db;
            }
        } while (db!= null);


        return new DbBeanWMS();
    }
    
    public boolean isConnectionClosed() {
        try {
            Statement stmTest = connection.createStatement();
            stmTest.executeQuery("select 1").close();
            stmTest.close();
            return false;
        }catch (Exception ex) {
            //ignore
        }
        return true;
    }
       
        
    private void connectDriver() throws CodeException{
        connectDriver(url);

    }
    public void connectDriver(String url) throws CodeException{
        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            throw new CodeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new CodeException(ex.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;        
    }
    
    /*public void close() throws SQLException{
        statement.close();
        connection.close();
    }*/
    
    public void close() throws CodeException{
        if (!this.isConnectionClosed()) {
            pool.add(this);
        } 
    }
    
        
    public static void setDbBean (String db) throws CodeException {
        if (isUsed && !db.equals(url)) {
            throw new CodeException("Attemted to set db after it had been used");  
        }
        url = db;  
    }

    
    public void finalize() throws Throwable {
        ClassRegister.instance().remove(this.getClass().getName());
        super.finalize();
    }
    
    public boolean execute(String query) throws SQLException{
            ResultSet rs = execute(query, true);
            return true;

            
    }
    
    public void executeSP() throws SQLException{
        
        
        
        //return cs.executeQuery();
    }
    
    
    public ResultSet execute(String query, boolean log)throws SQLException{
        ResultSet rs=null;
        Integer cmdid=0;
        return statement.executeQuery(query);
    }
        
    public ResultSet executeQuery(String query) throws SQLException{
        return execute(query, true);
    }


    public Boolean BeginTransaction() {
        Boolean status=false;
        try {
            getConnection().setAutoCommit(false);
            System.out.println("Transaction Begin");
            beginTransaction=true;
            status=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public Boolean CommitTransaction(){
        Boolean status=false;
        if (beginTransaction==true){
            try {
                getConnection().commit();
                getConnection().close();
                System.out.println("Transaction Commited");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }
    
    public Boolean RollBackTransaction(){
        Boolean status=false;
        if (beginTransaction==true){
            try {
                getConnection().rollback();
                getConnection().close();
                System.out.println("Transaction rolled back");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    } 
    
    
    
    //Record count
    public long count(String table) throws CodeException  {
        ResultSet rs = retrieveSQL("SELECT COUNT(*) as total FROM " + table + ";");
        try {
            rs.first();
            return rs.getLong(1);
        } catch (SQLException ex) {
            throw new CodeException("Database retrieve error: " + ex);
        }
    }

    public long count(String table, String field, String value) throws CodeException  {
        ResultSet rs = retrieveSQL("SELECT COUNT(*) as total FROM " + table + " WHERE " + field + " = \"" + value+ "\";");
        try {
            rs.first();
            return rs.getLong(1);
        } catch (SQLException ex) {
            throw new CodeException("Database retrieve error: " + ex);
        }
    }
    
    
    //Whole table - used for ID=NULLID
    public ResultSet retrieve(String table) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + ";");
    }

    //Whole table Sorted - used for ID=NULLID
    public ResultSet retrieve(String table,String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " ORDER BY " + sortField + ";");
    }

    public ResultSet retrieveDesc(String table,String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " ORDER BY " + sortField + " Desc ;");
    }
    
    public ResultSet retrieve(String table, String field, long value) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\";");
    }
    //Table for foreign key (or single item if use primary key)
    public ResultSet retrieve(String table, String field, String value) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\";");
    }

    //Table for foreign key (or single item if use primary key) sorted
    public ResultSet retrieve(String table, String field, String value, String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + ";");
    }
    public ResultSet retrieveDesc(String table, String field, String value, String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + " Desc ;");
    }
    
    public ResultSet retrieve(String table, String field, long value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + ";");
    }
    public ResultSet retrieveDesc(String table, String field, long value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + " Desc ;");
    }
    
    public ResultSet retrieveStartWith(String table, String field, String value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"" + value + "%\" ORDER BY " + sortField + ";");       
    }

    public ResultSet retrieveStartWithDesc(String table, String field, String value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"" + value + "%\" ORDER BY " + sortField + " DESC ;");       
    }

    public ResultSet retrieveStartWithLimit(String table, String field, String value, String sortField, long skip, long limit ) throws CodeException {
        return retrieveStartWithLimit(table, field, value, sortField, "ASC", skip, limit );
    }
    
    public ResultSet retrieveStartWithLimitDesc(String table, String field, String value, String sortField, long skip, long limit ) throws CodeException {
        return retrieveStartWithLimit(table, field, value, sortField, "DESC", skip, limit );
    }
    
    
    public ResultSet retrieveStartWithLimit(String table, String field, String value, String sortField, String sortby, long skip, long limit ) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"" + value + "%\" ORDER BY " + sortField + "  " + sortby + " limit " + skip + ", " + limit + ";");       
    }

    
    public ResultSet retrieveLike(String table, String field, String value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"%" + value + "%\" ORDER BY " + sortField + ";");       
    }
    
    public ResultSet retrieveLikeDesc(String table, String field, String value, String sortField) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"%" + value + "%\" ORDER BY " + sortField + " Desc ;");       
    }
    
    public ResultSet retrieveLikeLimit(String table, String field, String value, String sortField, long skip, long limit ) throws CodeException {
        return retrieveLikeLimit(table, field, value, sortField, "ASC", skip, limit );
    }
    
    public ResultSet retrieveLikeLimitDesc(String table, String field, String value, String sortField, long skip, long limit ) throws CodeException {
        return retrieveLikeLimit(table, field, value, sortField, "DESC", skip, limit );
    }
    
    
    public ResultSet retrieveLikeLimit(String table, String field, String value, String sortField, String sortby, long skip, long limit ) throws CodeException {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " like \"%" + value + "%\" ORDER BY " + sortField + "  " + sortby + " limit " + skip + ", " + limit + ";");       
    }

    public ResultSet retrieveLongCondition (String table, String condition) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table +  condition);
    }
    
    public ResultSet retrieveLongCondition(String table, String condition, String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table +  condition + " Order by " + sortField);
    }
    public ResultSet retrieveLongConditionDesc (String table, String condition, String sortField) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + condition + " Order by " + sortField + " DESC");
    }
    public ResultSet retrieveLongConditionDesc (String table, String condition, String sortField, String groupby) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + condition + " Group by "  + groupby + " Order by " + sortField + " DESC");
    }    
    //Whole table - used for ID=NULLID
    public ResultSet retrieveLimit(String table, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " LIMIT " + skip + "," + limit + ";");
    }

    //Whole table Sorted - used for ID=NULLID
    public ResultSet retrieveLimit(String table,String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " ORDER BY " + sortField + " LIMIT " + skip + "," + limit + ";");
    }

    public ResultSet retrieveLimitDesc(String table,String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " ORDER BY " + sortField + " Desc LIMIT " + skip + "," + limit + ";");
    }

    //Table for foreign key (or single item if use primary key)
    public ResultSet retrieveLimit(String table, String field, String value, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\"" + " LIMIT " + skip + "," + limit + ";");
    }

    public ResultSet retrieveLimit(String SQLNAME, String FOREIGNKEY, long id, String sortField, long skip, long limit) throws CodeException {
        return retrieveSQL("SELECT * FROM " + SQLNAME + " WHERE " +  FOREIGNKEY + " = \"" + id + "\"" + " ORDER BY " + sortField + " LIMIT " + skip + "," + limit + ";");
    }

    public ResultSet retrieveLimitDesc(String SQLNAME, String FOREIGNKEY, long id, String sortField, long skip, long limit) throws CodeException {
        return retrieveSQL("SELECT * FROM " + SQLNAME + " WHERE " +  FOREIGNKEY + " = \"" + id + "\"" + " ORDER BY " + sortField + " LIMIT " + skip + "," + limit + ";");
    }
    
    //Table for foreign key (or single item if use primary key) sorted
    public ResultSet retrieveLimit(String table, String field, String value, String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + " LIMIT " + skip + "," + limit + ";");
    }
    public ResultSet retrieveLimitDesc(String table, String field, String value, String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " = \"" + value + "\" ORDER BY " + sortField + " LIMIT " + skip + "," + limit + " Desc;");
    }

   //Table for foreign key (or single item if use primary key) sorted
    public ResultSet retrieveLimit(String table, String field, String operator, String value, String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " " + operator + " \"" + value + "\" ORDER BY " + sortField + " LIMIT " + skip + "," + limit + ";");
    }

       //Table for foreign key (or single item if use primary key) sorted
    public ResultSet retrieveLimitDesc(String table, String field, String operator, String value, String sortField, long skip, long limit) throws CodeException  {
        return retrieveSQL("SELECT * FROM " + table + " WHERE " + field + " " + operator + " \"" + value + "\" ORDER BY " + sortField + " Desc LIMIT " + skip + "," + limit + ";");
    }

    public ResultSet moveFirst(String table, String field) throws CodeException {
        return retrieveLimit(table, field, 0,1);
    }
 
    public ResultSet movePrevious(String table, String field, String value) throws CodeException {
        return retrieveLimitDesc(table, field, "<", value, field, 0,1);
    }
    
    public ResultSet moveNext(String table, String field, String value) throws CodeException {
        return retrieveLimit(table, field, ">", value, field, 0,1);
    }
    
    public ResultSet moveLast(String table, String field) throws CodeException {
        return retrieveLimitDesc(table, field, 0, 1);
    }
    
    //General SQL query, used by others
    public ResultSet retrieveSQL(String sql) throws CodeException  {
        
        try{
            ResultSet rs = statement.executeQuery(sql);
            //System.out.println(sql);
            return rs;
        }
        catch (SQLException e){
            throw new CodeException("Database retrieve error: "+e.getMessage(),e);
        }
    }

    //Update database ie for CREATE
    public boolean updateSQL(String sql) throws CodeException   {
        try{
            //System.out.println(sql);
            int rv = statement.executeUpdate(sql);
            if (rv>0)
                  return true;
            else
                  return false;
        }
        catch (SQLException e){
            throw new CodeException("Database Update error: "+e.getMessage(),e);
        }
    }

    //Updateable recordset for adding/editing records
    public ResultSet update(String table, String field, long ID) throws CodeException  {
        try{
            String sql = "SELECT * FROM "+table+" WHERE "+field+" = "+ID;
            //System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        }
        catch (SQLException e){
            throw new CodeException("Database Updateable Recordset error: "+e.getMessage(),e);
        }
    }

    //Delete record(s) from database
    public void delete(String table, String field, long id) throws CodeException  {
        String sql = "delete from "+table+" where "+field+" = "+id;
        try {
            //System.out.println(sql);
            int rv = statement.executeUpdate(sql);
            if (rv==0)
                throw new CodeException("Error deleting "+table+" for "+field+" = "+id+": No matching records");
        }
        catch (SQLException e){
            throw new CodeException("Error deleting "+table+" for "+field+" = "+id+": "+e.getMessage(),e);
        }
    }

    //Database administration

    //Create a database table
    public void createTable(String s) throws CodeException   {
        updateSQL(s);
    }

    //Delete a database table
    public boolean deleteTable(String t) throws CodeException  {
        return updateSQL("DROP TABLE "+t+";");
    }

    //Empty a database table
    public boolean emptyTable(String t) throws CodeException  {
        return updateSQL("DELETE FROM "+t+";");
    }

    //Rename a the database table
    public boolean renameTable(String from, String to) throws CodeException  {
        return updateSQL("ALTER TABLE "+from+" RENAME "+to+";");
    }
    

    /*
     * Export from table To File
     * 
     */
    
    public boolean exportToTextTabDelimited(String table) throws CodeException {
        String limiter = "~";
        String file = GlobalUtils.getCurrentDir() + GlobalUtils.temp + table + ".txt";        
        return exportToFile(file, table, limiter);        
    }
    public boolean exportToCSV(String table) throws CodeException {
        String limiter = "\t";
        String file = GlobalUtils.getCurrentDir() + GlobalUtils.temp + table + ".csv";        
        return exportToFile(file, table, limiter);
    }
    
    public boolean exportToFile(String table, String limiter) throws CodeException {
        String file = GlobalUtils.getCurrentDir() + GlobalUtils.temp + table + ".txt";        
        return exportToFile(file, table, limiter);
    }
    
    public boolean exportToFile(String FileOutput, String table, String limiter) throws CodeException {
        String filecontain = getContainsTable(table, limiter).toString();
        try {
            
            FileOutputStream fos = new FileOutputStream(FileOutput);
            fos.write(filecontain.getBytes());
            fos.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    public boolean exportAssetToFile(String FileOutput, StringBuffer query, String limiter) throws CodeException {
        String filecontain = getContainsTable(query, limiter).toString();
        try {
            
            FileOutputStream fos = new FileOutputStream(FileOutput);
            fos.write(filecontain.getBytes());
            fos.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    public StringBuffer getContainsTable(String table, String delimiter) throws CodeException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM " + table + ";");
        
        return getContainsTable(sb, delimiter);
    }
    
    public StringBuffer getContainsTable(StringBuffer query, String delimiter) throws CodeException {
    
       StringBuffer result = new StringBuffer();
       try {
            ResultSet rs = retrieveSQL(query.toString());
            ResultSetMetaData metaData = rs.getMetaData();
            int numberofcolumns = metaData.getColumnCount();
            
            
            //getheader of table
            for(int i= 1; i<=numberofcolumns; i++ ){
                if (i !=numberofcolumns) {                   
                    result.append(metaData.getColumnName(i) + delimiter);
                }else{
                    result.append(metaData.getColumnName(i) );                    
                }
                
            }
            result.append("\n");
            
            //getdetail of table
            while (rs.next()) {
                for(int i = 1; i<=numberofcolumns; i++) {
                    //clean up character " '
                    String row = "";
                    
                    if (rs.getObject(i) != null){
                        row = rs.getObject(i).toString();
                        row = row.replaceAll("\"", "\'");
                    }
                    if (i !=numberofcolumns) {
                        result.append(row + delimiter);
                    }else{
                        result.append(row );                        
                    }
                            
                }
                result.append("\n");
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result ;
    }
    
    /*
     * Import form file to database
     */
    
    public boolean importFromCsv(String table) throws CodeException {
        String limiter = "\t";
        String file = GlobalUtils.getCurrentDir() + GlobalUtils.temp + table + ".csv";  
        return importFromFile(file, table, limiter);
    }
    public boolean importFromText(String table) throws CodeException {
        
        String limiter = "~";
        String file = GlobalUtils.getCurrentDir() + GlobalUtils.temp + table + ".txt";  
        return importFromFile(file, table, limiter);
    }
    public boolean importFromFile(String file, String table, String delimiter) throws CodeException {
            try {
                
                DateFormat dateformat=new SimpleDateFormat("MM/dd/yy");
                DateFormat datetimeformat=new SimpleDateFormat("MMddyyHHmmss");
                
                /*backup dulu datanya */
                String backuptable = " create table " + table  + "backup" + datetimeformat.format(new java.util.Date()) + " select * from " + table;
                updateSQL(backuptable);                
                
                /*kosongin data ....*/
                
                String emptytable = "truncate table " + table;
                updateSQL(emptytable);
               
                Calendar c = Calendar.getInstance();      
    
                ResultSet rs = retrieveSQL("SELECT * FROM " + table + ";");
                ResultSetMetaData metaData = rs.getMetaData();
                int numberofcolumns = metaData.getColumnCount();
                
                String[] type = new String[numberofcolumns];
                
                
                for (int i=1 ; i<= numberofcolumns; i++) {
                    type[i-1] = metaData.getColumnTypeName(i);
                }
                                        
                FileReader in = new FileReader(file);
                BufferedReader br = new BufferedReader(in);
            
                String str = "";
                String[] field = null ;
                String[] contains;
                
                int i = 0;
                while((str=br.readLine()) != null){
                    str = str.replace("\"", "");
                    if (i==0) {
                        field = str.split(delimiter);
                    }else{                        
                        rs.moveToInsertRow();
                        contains = str.split(delimiter);
                        for (int j=0; j<contains.length; j++) {
                            
                            if (contains[j] != null && !"".equals(contains[j].trim())) {
                               String s =field[j] + "," +  contains[j];
                               try {

                                    
                                   if ("VARCHAR".equals(type[j])) {
                                        rs.updateString(field[j], contains[j]);
                                    }else if("INTEGER".equals(type[j])){
                                        rs.updateInt(field[j], Integer.parseInt(contains[j]));
                                    }else if("DOUBLE".equals(type[j])){
                                        rs.updateDouble(field[j], Double.parseDouble(contains[j]));
                                    }else if("DATE".equals(type[j])){
                                        try {
                                            rs.updateDate(field[j],Date.valueOf(contains[j]));
                                        }catch (Exception e) {  
                                            
                                            String[] split =  contains[j].split("/");

                                            String year = "";
                                            if (split[2].length() == 2) {
                                                if (Integer.parseInt(split[2]) > 80) {
                                                    year = "19" + split[2];
                                                }else {
                                                    year = "20" + split[2];                                                
                                                }
                                            }
                                            rs.updateDate(field[j],Date.valueOf(year + "-" + split[0] + "-" + split[1]));
                                        }

                                        
                                    }else if("TIMESTAMP".equals(type[j])){
                                        try {
                                            rs.updateTimestamp(field[j],  Timestamp.valueOf(contains[j]));
                                        }catch (Exception e) {
                                            try {
                                            String[] splittimestamp =  contains[j].split(" ");
                                            String ampm = "AM";
                                            if (splittimestamp.length > 2) {
                                                ampm = splittimestamp[2];
                                            }
                                            String[] splittime = splittimestamp[1].split(":");
                                            
                                            String hour = splittime[0];
                                            String minute = splittime[1];
                                            String second = "00";
                                            if (splittime.length > 2) {
                                                second = splittime[2];
                                            }
                                            
                                            if("PM".equals(ampm)) {
                                                hour = String.valueOf(Integer.parseInt(hour) + 12);
                                            }
                                            
                                            String[] splitdate =  splittimestamp[0].split("/");
                                            String date = splitdate[1];
                                            String month =splitdate[0];
                                            String year = "1900";
                                            if (splitdate[2].length() == 2) {
                                                if (Integer.parseInt(splitdate[2]) > 80) {
                                                    year = "19" + splitdate[2];
                                                }else {
                                                    year = "20" + splitdate[2];                                                
                                                }
                                            }
                                                                                        
                                            rs.updateTimestamp(field[j], Timestamp.valueOf(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second));
                                            }catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                        }

                                    }else {
                                        rs.updateString(field[j], contains[j]);                                        
                                    }
                               }catch(Exception e) {

                                    e.printStackTrace();
                                }
                            }
                            
                        }
                        
                        rs.insertRow();
                        rs.moveToCurrentRow();
                        
                    }
                    i++;
                }
            
                in.close();
          
                return true;
            
            }catch (SQLException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        
   
        return false;
    }
    
}