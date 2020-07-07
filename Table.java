/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This class is inhereted from <Table>Abst that handle CRUD 
    (Create/Insert Read Update Delete)
 * 
 * How To Use This Class to Read Data or make instance
 * 1. <Table> obj = new <Table>();
 * 
 * 2. <Table> obj = new <Table>(<id>); // <id> = number of id
 * 
 *    Sample :
 *    <Table> obj = new <Table>(1);
 * 
 *    It Means : Select * from <table> where id = 1;
 * 
 * 3. <Table> obj = new <Table>(); 
 *    obj.loadID(1);
 * 
 *    Sample :
 *    <Table> obj = new <Table>(1);
 * 
 *    It Means : Select * from <table> where id = 1;
 * 
 * 4. <Table> obj = new <Table>(<primary_key>); 
 *    Sample :
 *    <Table> obj = new <Table>("1");
 *    It Means : Select * from <table> where <primary_key> = "1";
 * 
 * 5. <Table> obj = new <Table>(<Table>.PROPERTY_<field>, <value>);
 *    Sample :
 *    <Table> obj = new <Table>(<Table>.PROPERTY_ID, "1");
 * 
 *    It Means : Select * from <table> where id = "1";
 * 
 * 6. <Table> obj = new <Table>();
 *    obj.loadString(<Table>.PROPERTY_<field>, <value>)
 * 
 *    Sample :
 *    <Table> obj = new <Table>();
 *    obj.loadString(<Table>.PROPERTY_ID, "1")
 * 
 *    It Means : Select * from <table> where id = "1";
 * 
 * 7. User Recordset
 * 
 *    Sample :
 * 
 *      DbBean db = DbBean.connect();
        String sql = "SELECT * FROM <table> Where id = 1" ;
 * 
        try {
            ResultSet rs = db.executeQuery(sql);
            
            if(rs.next()) {
                loadRs(rs);
            }
                

        } catch (SQLException ex) {
            throw new CodeException("<table> : Cannot Set Data " + ex.getMessage());
        }
        db.close();
 * 
 * 8. Save Data
 * 
 *    Sample :
 *    <Table> obj = new <Table>(1);
 *    obj.set<field>(<value>);
 *    obj.save();
 * 
 * 
 *    if the id == 0 then save new else save update
 *     
 * 9. Delete
 * 
 *    Sample :
 *    <Table> obj = new <Table>(1);
 *    obj.delete();
 * 
 * 
 *    It Means : Delete from <table> where id = 1;
 * 
 * 
 */


package <Package>;

import java.sql.ResultSet;
import common.utils.CodeException;

/**
 *
 * @author windu
 */
public class <Table> extends <Table>Abst{
    public <Table>() throws CodeException {
       
    }
    
    public <Table>(long id) throws CodeException {
        super(id);
    }
    
    public <Table>(String val)  throws CodeException {
        super(val);
    }
    
    public <Table>(String key, String val)  throws CodeException {
        super(key, val);
    }
    
    public <Table>(ResultSet rs) throws CodeException {
        super(rs);
    }
    
}




