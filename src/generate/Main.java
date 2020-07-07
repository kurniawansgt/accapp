/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generate;

import common.component.FrmMainFrame;
import common.jdbc.DbBeanCommon;
import common.jdbc.DbBeanWMS;


/**
 *
 * @author root
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
                        
            DbBeanCommon.InitConnection();
            //DbInsysCommon.initDB();
            
            
            DbBeanWMS.InitConnection();
            
/*            
            DbBeanCommonWMS dbcWMS = DbBeanCommonWMS.connect();
            
            dbcWMS.updateSQL("call spTarik_SalesToTable(2019,12);");
*/            
            
                       
            FrmMainFrame frm = new FrmMainFrame();
            frm.setVisible(true);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
