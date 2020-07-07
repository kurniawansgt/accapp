/*
 * browcolumnmodelcol.java
 *
 * Created on October 23, 2007, 2:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package common.tablemodels;

import java.util.ArrayList;

/**
 *
 * @author ISParthama
 */
public class BrowseColumnModelCol extends ArrayList<BrowseColumnModel>{
    private BrowseColumnModel colModel=new BrowseColumnModel();
    /** Creates a new instance of browcolumnmodelcol */
    public BrowseColumnModelCol() {
    }

    public BrowseColumnModel getColModel() {
        return colModel;
    }

    public void setColModel(BrowseColumnModel colModel) {
        this.colModel = colModel;
    }
    
    public void Insert(){
        colModel=new BrowseColumnModel();
    }
    
    
}
