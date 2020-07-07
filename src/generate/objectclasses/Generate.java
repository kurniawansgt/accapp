/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generate.objectclasses;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSet;
import common.jdbc.DbBean;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.Vector;
import common.utils.CodeException;

/**
 *
 * @author root
 */
public abstract class  Generate {
    
    protected final int  TABLE_CAT = 0;
    protected final int  TABLE_SCHEM = 1; 
    protected final int  TABLE_NAME = 2;
    protected final int  COLUMN_NAME = 3;
    protected final int  DATA_TYPE = 4;
    protected final int  TYPE_NAME = 5;
    protected final int  COLUMN_SIZE = 6;
    protected final int  BUFFER_LENGTH = 7;
    protected final int  DECIMAL_DIGITS = 8;
    protected final int  NUM_PREC_RADIX = 9;
    protected final int  NULLABLE = 10;
    protected final int  REMARKS = 11;
    protected final int  COLUMN_DEF = 12; 
    protected final int  SQL_DATA_TYPE = 13;
    protected final int  SQL_DATETIME_SUB = 14; 
    protected final int  CHAR_OCTET_LENGTH = 15;
    protected final int  ORDINAL_POSITION = 16;
    protected final int  IS_NULLABLE = 17;
          
    String primarykey = "";
    Vector vStructure = new Vector();

    public static StringBuffer openFile(String file) {
        StringBuffer sb = new StringBuffer();
        
        try {
            RandomAccessFile openfile = new RandomAccessFile(file, "r");
            long bytelong = openfile.length();
            
            for (int i = 0; i<= bytelong; i++) {
                char c = (char) openfile.read();
                sb.append(c);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return sb;
        
    }
    
    public boolean saveToFile(String location, String filename, String filecontain) {
        
        String FileOutput = location + "/" + filename;
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
    
    public String getPrimaryKey(String table){

        primarykey = "";
        
        try {
            
            DbBean db = DbBean.connect();

            DatabaseMetaData dbm = (DatabaseMetaData) db.getConnection().getMetaData();

            ResultSet indexList = (ResultSet) dbm.getIndexInfo(db.getConnection().getCatalog(), null, table, true, true);
            while(indexList.next()) {
                //6 untuk dapatkan primary
                //9 nama field
                if ("PRIMARY".equals(indexList.getString(6))) {
                    primarykey = indexList.getString(9);
                }
                
            }

            db.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return primarykey;
    }

        

    public static Vector getStructure(String table ) {
        /*
         * 
         * 1. TABLE_CAT String => table catalog (may be null)
         * 2. TABLE_SCHEM String => table schema (may be null)
         * 3. TABLE_NAME String => table name
         * 4. COLUMN_NAME String => column name
         * 5. DATA_TYPE int => SQL type from java.sql.Types
         * 6. TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
         * 7. COLUMN_SIZE int => column size. For char or date types this is the maximum number of characters, for numeric or decimal types this is precision.
         * 8. BUFFER_LENGTH is not used.
         * 9. DECIMAL_DIGITS int => the number of fractional digits
         * 10. NUM_PREC_RADIX int => Radix (typically either 10 or 2)
         * 11. NULLABLE int => is NULL allowed.
         *      columnNoNulls - might not allow NULL values
         *      columnNullable - definitely allows NULL values
         *      columnNullableUnknown - nullability unknown 
         * 12. REMARKS String => comment describing column (may be null)
         * 13. COLUMN_DEF String => default value (may be null)
         * 14. SQL_DATA_TYPE int => unused
         * 15. SQL_DATETIME_SUB int => unused
         * 16. CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
         * 17. ORDINAL_POSITION int => index of column in table (starting at 1)
         * 18.  IS_NULLABLE String => "NO" means column definitely does not allow NULL values; "YES" means the column might allow NULL values. An empty string means nobody knows. 
         * 
         * 
         */
        
        Vector v = new Vector();
                
        try {
            
            DbBean db = DbBean.connect();

            DatabaseMetaData dbm = (DatabaseMetaData) db.getConnection().getMetaData();

            ResultSet indexList = (ResultSet) dbm.getColumns(null, null, table, null);
            
            
            while(indexList.next()) {
                String structure[] = new String[18];
                for (int i=1; i< 18 ; i++) {
                    structure[i-1] = indexList.getString(i);
                    
                }

                v.add(structure);
            }

            db.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return v;
    }


    public static String[] getAllTables() throws CodeException, SQLException {
        DbBean db = DbBean.connect();
        DatabaseMetaData dbm = (DatabaseMetaData) db.getConnection().getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = (ResultSet) dbm.getTables(null,null,"%",types);
       
        
        StringBuffer sb = new StringBuffer();
                
        while (rs.next()){
          String table = rs.getString("TABLE_NAME");
                  
          table = table.substring(0,1).toUpperCase() + table.substring(1);
          sb.append(table + "~");
        }
        
        

        
        db.close();

        String tables =  sb.substring(0, sb.length() -1);
                
        return tables.split("~");
    }
    public String getJavaVariableFromMysql(String val) {
        
        if ("int".equals(val) ||
             "bigint".equals(val) ||
             "smallint".equals(val)) {
            val = "long";
        }else if ("decimal".equals(val) || 
                  "double".equals(val) ||
                  "float".equals(val) ||
                  "numeric".equals(val) ||
                  "real".equals(val) 
                  ) {
            val = "double";
        }else if("timestamp".equals(val)) {
            val = "Timestamp";
        }else if("date".equals(val)) {
           val = "Date";
        }else {
          val = "String";
        }
        
        return val;
    }

}
