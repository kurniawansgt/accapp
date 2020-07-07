/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * This Interface implemented on All Form To Navigate Data
 * 
 */

package common.classinterface;

import common.utils.CodeException;

/**
 *
 * @author windu
 */
public interface NavigatorFormInt {

    public void delete() throws CodeException;
    public void moveFirst() throws CodeException;
    public void movePrevious() throws CodeException;
    public void moveNext() throws CodeException;
    public void moveLast() throws CodeException;
    public void newData() throws CodeException;
    public void saveData() throws CodeException;
    public void printData() throws CodeException;

    public void showData() throws CodeException;
    public void setToolBar(int iFormType, int istatus);
    public void setData() throws CodeException;
    public void undo() throws CodeException;
    public void execute() throws CodeException;
    public void searchData() throws CodeException;
    
    public void importCsv() throws CodeException;
    public void exportCsv() throws CodeException;
    public void importText() throws CodeException;
    public void exportText() throws CodeException;
   
    
}
