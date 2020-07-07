package common.utils;

public class TagNotKnownException extends Throwable
{
  public TagNotKnownException(String tag)
  {
     super(tag);
  }
}

