package common.classinterface;

import common.utils.CodeException;
import java.sql.ResultSet;

public abstract interface CodeCollectionInt extends CodeObjectInt
{
  public abstract void recordLoad(ResultSet paramResultSet)
    throws CodeException;

  public abstract long count()
    throws CodeException;

  public abstract int size()
    throws CodeException;


  public abstract void setSQLSkip(long paramLong)
    throws CodeException;

  public abstract void setSQLLimit(long paramLong)
    throws CodeException;
}
