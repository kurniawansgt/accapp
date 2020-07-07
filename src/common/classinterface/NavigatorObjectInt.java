/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This interface is implemented on Abstract Class to Navigate Data
 */

package common.classinterface;

import common.utils.CodeException;

/**
 *
 * @author windu
 */
public interface NavigatorObjectInt {
    
    public void moveFirst() throws CodeException;
    public void movePrevious() throws CodeException;
    public void moveNext() throws CodeException;
    public void moveLast() throws CodeException;
    public String getTable();
    public String getClassName();
    
    public boolean importCsv();
    public boolean exportCsv();
    public boolean importText();
    public boolean exportText();
}
