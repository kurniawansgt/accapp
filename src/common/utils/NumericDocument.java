/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.utils;

import javax.swing.text.*;
import java.awt.*;
/**
 *
 * @author wgata
 */
public class NumericDocument  extends PlainDocument {
//Variables
     protected int decimalPrecision = 0;
     protected boolean allowNegative = false;

     //Constructor
     public NumericDocument(int decimalPrecision, boolean allowNegative) {
          super();
          this.decimalPrecision = decimalPrecision;
          this.allowNegative = allowNegative;
     }

     //Insert string method
     public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
          if (str != null){
               if (isNumeric(str) == false && str.equals(".") == false && str.equals("-") == false){ //First, is it a valid character?
                    Toolkit.getDefaultToolkit().beep();
                    return;
               }
               else if (str.equals(".") == true && super.getText(0, super.getLength()).contains(".") == true){ //Next, can we place a decimal here?
                    Toolkit.getDefaultToolkit().beep();
                    return;
               }
               else if (isNumeric(str) == true && super.getText(0, super.getLength()).indexOf(".") != -1 && offset>super.getText(0, super.getLength()).indexOf(",") && super.getLength()-super.getText(0, super.getLength()).indexOf(",")>decimalPrecision && decimalPrecision > 0){ //Next, do we get past the decimal precision limit?
                    Toolkit.getDefaultToolkit().beep();
                    return;
               }
               else if (str.equals("-") == true && (offset != 0 || allowNegative == false)){ //Next, can we put a negative sign?
                    Toolkit.getDefaultToolkit().beep();
                    return;
               }

               //All is fine, so add the character to the text box
               super.insertString(offset, str, attr);
          }
          return;
     }

     private boolean isNumeric(String str){
         try{
             double num = Double.parseDouble(str);
             return true;
         }catch(Exception e) {
             return false;
         }
     }
}
