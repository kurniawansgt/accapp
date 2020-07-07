package common.utils;

public class Pair
{
  private int Now;
  private int Max;

  public Pair()
  {
      setNow(1);
      setMax(1);
  }

  public int getNow() {
     return this.Now;
  }

  public void setNow(int Now) {
     this.Now = Now;
  }

  public void setMax(int Max) {
     this.Max = Max;
  }

  public int getMax() {
     return this.Max;
  }

  public void increment() {
     int count = getNow();
     ++count;
     int max = getMax();
     if (max < count) {
        max = count;
    }
    setNow(count);
    setMax(max);
  }

  public void decrement() {
     int count = getNow();
     --count;
     setNow(count);
  }

  public String toString() {
      return "(" + getNow() + "/" + getMax() + ")";
  }
}
