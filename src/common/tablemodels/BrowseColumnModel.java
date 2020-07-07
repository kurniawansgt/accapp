/*
 * browcolumnmodel.java
 *
 * Created on October 23, 2007, 1:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package common.tablemodels;

/**
 *
 * @author ISParthama
 */
public class BrowseColumnModel {
    private String colName="";
    private String colDesc="";
    private Integer colWidth=new Integer(0);
    
    /** Creates a new instance of browcolumnmodel */
    public BrowseColumnModel() {
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }

    public Integer getColWidth() {
        return colWidth;
    }

    public void setColWidth(Integer colWidth) {
        this.colWidth = colWidth;
    }
    
}
