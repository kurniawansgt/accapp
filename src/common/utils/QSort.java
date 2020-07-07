package common.utils;

public class QSort
{
  public void q_sort(String[] in_array, int left, int right)
  {
     if (left >= right) {
       return;
    }

     swap(in_array, left, (left + right) / 2);
     int last = left;
     for (int current = left + 1; current <= right; ++current) {
       int result = in_array[current].compareTo(in_array[left]);
       if (result < 0) {
         swap(in_array, ++last, current);
      }
    }
     swap(in_array, left, last);
     q_sort(in_array, left, last - 1);
     q_sort(in_array, last + 1, right);
  }

  private void swap(String[] in_array, int i, int j)
  {
     String temp = in_array[i];
     in_array[i] = in_array[j];
     in_array[j] = temp;
  }
}
