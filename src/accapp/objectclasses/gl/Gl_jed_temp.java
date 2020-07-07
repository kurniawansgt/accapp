/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from Gl_jed_tempAbst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. Gl_jed_temp obj = new Gl_jed_temp();
 * 
 * 2. Gl_jed_temp obj = new Gl_jed_temp(<id>); // <id> = number of id
 * 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp(1);
 * 
 *    It Means : Select * from gl_jed_temp where id = 1;
 * 
 * 3. Gl_jed_temp obj = new Gl_jed_temp(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp(1);
 * 
 *    It Means : Select * from gl_jed_temp where id = 1;
 * 
 * 4. Gl_jed_temp obj = new Gl_jed_temp(<primary_key>); 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp("1");
 *    It Means : Select * from gl_jed_temp where <primary_key> = "1";
 * 
 * 5. Gl_jed_temp obj = new Gl_jed_temp(Gl_jed_temp.PROPERTY_<field>, <value>);
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp(Gl_jed_temp.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from gl_jed_temp where id = "1";
 * 
 * 6. Gl_jed_temp obj = new Gl_jed_temp();
 *    obj.loadString(Gl_jed_temp.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp();
 *    obj.loadString(Gl_jed_temp.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from gl_jed_temp where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM gl_jed_temp Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("gl_jed_temp : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    Gl_jed_temp obj = new Gl_jed_temp(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from gl_jed_temp where id = 1;
 * 
 * 
 */


package accapp.objectclasses.gl;

import common.jdbc.DbBean;
import java.sql.ResultSet;
import common.utils.CodeException;
import common.utils.GlobalUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author windu
 */
public class Gl_jed_temp extends Gl_jed_tempAbst{
    public Gl_jed_temp() throws CodeException {
       
    }
    
    public Gl_jed_temp(long id) throws CodeException {
        super(id);
    }
    
    public Gl_jed_temp(String val)  throws CodeException {
        super(val);
    }
    
    public Gl_jed_temp(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public Gl_jed_temp(ResultSet rs) throws CodeException {
        super(rs);
    }

    public boolean importCsv(String filepath) {
       try {
            DbBean db = DbBean.connect();
            String limiter = ",";
            
            FileReader in = new FileReader(filepath);
            BufferedReader br = new BufferedReader(in);

            String emptytable = "delete from " + this.TABLE +" where audituser='"+GlobalUtils.userid+"'";
            db.updateSQL(emptytable);

            String str = "";
            String[] field = null ;
            String[] contains;

            int i = 0;
            while((str=br.readLine()) != null){
               //str = str.replace("\"", "");
                if (i==0) {
                    field = str.split(limiter);
                } else{
                    Gl_jed_temp o=new Gl_jed_temp();

                    int istart=str.indexOf("\"");
                    int iend=0;
                    if (istart>0){
                        iend=str.indexOf("\"", istart+1);
                    }
                    if (iend>0){
                        String streplace=str.substring(istart, iend+1);
                        String streplaceto=streplace.replace(",", "");
                        streplaceto=streplaceto.replace(" ", "");
                        streplaceto=streplaceto.replace("\"", "");
                        if (streplaceto.contains("(")){
                            streplaceto=streplaceto.replace("(", "-");
                            streplaceto=streplaceto.replace(")", "");

                        }
                        str=str.replace(streplace, streplaceto);
                    }
               try
                   {
                    contains = str.split(limiter);
                    o.setbtchentry(GlobalUtils.toDbl(contains[0]));
                    o.setjournalid(GlobalUtils.toDbl(contains[1]));

                    o.setsourcelgrcode(GlobalUtils.churuf(contains[2]));
                    o.fromString(Gl_jed_temp.PROPERTY_TRANSDATE,contains[3]);

                    o.setjournaldesc(contains[4]);
                    o.settransnbr(GlobalUtils.toDbl(contains[5]));
                    o.setacccode(contains[6]);
                    o.settransamt(GlobalUtils.toDbl(contains[7]));
                    o.setsrcecurnccode(contains[8]);
                    o.settransdesc(contains[9]);
                    o.settransref(contains[10]);
                    o.setentrydate(GlobalUtils.getAuditDate());
                    o.setauditdate(GlobalUtils.getAuditDate());
                    o.setaudituser(GlobalUtils.getUserId());
                    o.setcmpnyid(GlobalUtils.company);

                    o.save();
                    }catch(Exception e){}
                }
                i++;
            }
            db.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int runSp_get_gl_import_journal_entry_sts() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
             db.updateSQL(getsp_get_gl_import_journal_entry_sts());
             entry=1;
         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }
    public String getsp_get_gl_import_journal_entry_sts() throws CodeException {
           String query = "call sp_get_gl_import_journal_entry_sts ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"') ";
           System.out.println(query);
           return query;
    }

    public int runSp_create_gl_import_journal_entry() throws CodeException {
         DbBean db = DbBean.connect();
         int entry = 0;
         try {
             db.updateSQL(getsp_create_gl_import_journal_entry());
             entry=1;
         } catch (Exception ex) {
             throw new CodeException("ap_invbatchlist : " + ex.getMessage());
         }finally{
           db.close();
         }

       return entry;
    }
    public String getsp_create_gl_import_journal_entry() throws CodeException {
           String query = "call sp_create_gl_import_journal_entry ('"+GlobalUtils.formatDate(GlobalUtils.sessiondate,"yyyy-MM-dd")+"','"+GlobalUtils.company+"','"+GlobalUtils.userid+"') ";
           System.out.println(query);
           return query;
    }


    
}




