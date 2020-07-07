package common.utils;

import common.utils.CodeException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Hashtable;

public class TemplateFiller
{
  public static final String TOKEN_PREFIX = "[%";
  public static final String TOKEN_SUFFIX = "%]";

  public String fillTemplate(String templateFile, Hashtable fillerHt)
    throws CodeException
  {
     StringBuffer filledTemplateSb = new StringBuffer();
    try{
       FileReader fileReader = new FileReader(templateFile);
       BufferedReader bufReader = new BufferedReader(fileReader);
       while (bufReader.ready()) {
         String line = bufReader.readLine();
         fillLine(line, fillerHt, filledTemplateSb);
      }
       bufReader.close();
    }catch (Exception e) {
      throw new CodeException(e);
    }

    return filledTemplateSb.toString();
  }

  public String fillTemplateString(String templateStr, Hashtable fillerHt)
    throws CodeException {
     StringBuffer filledTemplateSb = new StringBuffer();
    try{
       StringReader stringReader = new StringReader(templateStr);
       BufferedReader bufReader = new BufferedReader(stringReader);
       while (bufReader.ready()) {
         String line = bufReader.readLine();
         if (line == null) {
          break;
        }
         fillLine(line, fillerHt, filledTemplateSb);
      }
       bufReader.close();
    }catch (Exception e) {
       e.printStackTrace();
       throw new CodeException(e);
    }

     return filledTemplateSb.toString();
  }

  private void fillLine(String line, Hashtable fillerHt, StringBuffer filledTemplateSb)
    throws Exception
  {
     int index = 0;
     while ((index < line.length()) && (index != -1)) {
       index = line.indexOf("[%", index);
       if (index >= 0)
      {
         filledTemplateSb.append(line.substring(0, index));

         int endIndex = line.indexOf("%]", index);
         String token = line.substring(index + "[%".length(), endIndex);

         String filler = (String)fillerHt.get(token);

         filledTemplateSb.append(filler);

         int nextSubStringIndex = endIndex + "%]".length();

         line = line.substring(nextSubStringIndex);
         index = 0;
      }

       filledTemplateSb.append(line);
    }

    filledTemplateSb.append("\n");
  }
}

