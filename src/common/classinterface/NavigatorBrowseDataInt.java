/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This interface is implemented on All Collection for Browsing Data Grid 
 * on FrmBrowse.java
 * 
 */

package common.classinterface;

import common.utils.CodeException;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author windu
 */
public interface NavigatorBrowseDataInt {
    public List<Object> list() throws CodeException;    
    public Iterator<Object> iterator() throws CodeException;
    public String getDefaultSort();
    public String getSQLNAME();
    public String[][] getColumn();
    public String getCLASSNAME();
    public void recordLoad(ResultSet rs) throws CodeException;
    public void searchData (String key, String val, int searchMethod,  String fieldsort, String sortby, int skip, int limit ) throws CodeException;
    public int size() throws CodeException;

}
