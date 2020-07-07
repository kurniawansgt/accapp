/*
 * bdmodel.java
 *
 * Created on October 29, 2007, 11:23 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package common.tablemodels;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class BdModel extends DefaultTableModel{
    
   public boolean isCellEditable(int row, int col){
         return false;      
    }
}
