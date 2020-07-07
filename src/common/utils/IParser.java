package common.utils;

import java.util.Vector;

public abstract interface IParser
{
  public abstract Vector convert(String paramString)
    throws TagNotKnownException;
}
