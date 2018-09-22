import java.util.Arrays;

/**
 * @author zmj
 * @Description
 * @create 2018/9/22
 */
public class PlusOne_066 {
  public int[] plusOne(int[] digits) {
    int index = digits.length-1;
    digits[index] += 1;
    int n = 0;
    while (index > n && digits[index-n] == 10) {
      digits[index-n] = 0;
      n++;
      digits[index-n] += 1;
    }
    if (digits[0] == 10) {
      digits = new int[index+2];
      digits[0] = 1;
      for (int i = 1; i < digits.length; i++)
        digits[i] = 0;
    }
    return digits;
  }
  
}
