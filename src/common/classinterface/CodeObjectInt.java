package common.classinterface;

import common.utils.CodeException;

public abstract interface CodeObjectInt
{
  public abstract String getCLASSNAME();

  public abstract void setID(long paramLong)
    throws CodeException;

  public abstract long getID()
    throws CodeException;

  public abstract void delete()
    throws CodeException;

  public abstract void deleteAll()
    throws CodeException;

  public abstract String toString();

  public abstract String toString(String paramString)
    throws CodeException;

  public abstract void fromString(String paramString1, String paramString2)
    throws CodeException;

  public abstract void save()
    throws CodeException;

  public abstract void copy(CodeObjectInt paramJawaCodeObjectInt)
    throws CodeException;

  public abstract void resetID()
    throws CodeException;

  public abstract String[] getSecurityTokens()
    throws CodeException;
}
