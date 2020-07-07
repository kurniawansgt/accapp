package common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

public class Parser
{
  private String openTag;
  private String closeTag;

  public Parser()
  {
     this.openTag = "$$";
     this.closeTag = "$$";
     ClassRegister.instance().register("Parser");
  }

  public Parser(String open, String close) {
     this.openTag = open;
     this.closeTag = close;
     ClassRegister.instance().register("Parser");
  }

  public void parse(Reader inR, Writer out, IParser pInt) {
     int lenTagO = this.openTag.length();
     int lenTagC = this.closeTag.length();
     String thisLine = "";
     String thisTag = "";
     String preamble = "";
     int tagStart = 0;
     int tagEnd = 0;
     int lines = 0;
     boolean inTag = false;
     boolean searchLine = true;
     BufferedReader in = new BufferedReader(inR);
    try
    {
       thisLine = in.readLine();
    }catch (IOException iox) {
       System.err.println(iox.toString());
    }
     while (thisLine != null) {
       StringBuffer sb = new StringBuffer();
       while (searchLine) {
         if (!inTag) {
           tagStart = thisLine.indexOf(this.openTag);
           if (tagStart > -1) {
             preamble = thisLine.substring(0, tagStart);
             thisLine = thisLine.substring(tagStart + lenTagO);
             inTag = true;
          }
          else {
             searchLine = false;
          }
        }
         if (inTag);
            tagEnd = thisLine.indexOf(this.closeTag);
         if (tagEnd > -1) {
           thisTag = thisLine.substring(0, tagEnd);
           inTag = false;
          try {
             Vector v = pInt.convert(thisTag);
             Enumeration e;
             if (v.size() == 0) {
               sb.append(preamble);
            }
             else if (v.size() == 1) {
               sb.append(preamble + v.elementAt(0));
            }
            else {
               for (e = v.elements(); e.hasMoreElements(); ) {
                 sb.append(preamble + e.nextElement() + "\n");
              }
            }
             preamble = "";
             thisLine = thisLine.substring(tagEnd + lenTagC);
          }
          catch (TagNotKnownException tnk) {
             System.out.println(tnk.toString());
             System.err.println(tnk.toString());
             sb.append(preamble + this.openTag + thisTag + this.closeTag);
          }
        }

         searchLine = false;
      }

       sb.append(thisLine);
      try {
         if (!inTag) {
           out.write(sb.toString() + "\n");
           thisLine = in.readLine();
        }
        else {
           thisLine = thisLine + "\n" + in.readLine();
        }
         ++lines;
         searchLine = true;
      }catch (IOException iox) {
        System.err.println(iox.toString());
      }
    }
    try {
        out.close();
    }
    catch (IOException iox) {
       System.err.println(iox.toString());
    }
  }

  protected void finalize() throws Throwable
  {
     ClassRegister.instance().remove("Parser");
  }
}

