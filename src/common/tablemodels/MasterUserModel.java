/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.tablemodels;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wgata
 */

public class MasterUserModel extends DefaultTableModel{
   public boolean isCellEditable(int row, int col){
       
        if (col == 0 
                || col == 1
                || col == 2
           )
        {
           return false;
        }
        
        return true;      
   }
}
