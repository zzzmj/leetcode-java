package indi.zmj.leetcode;

import java.util.Arrays;

/**
 * @author zmj
 * @Description
 * @create 2018/9/22
 */
public class PlusOne_066 {
  /**
   * 我的做法是将最后一个数字加上1，如果等于10，就会产生进位，此时用n变量记录好，把当前数字变为0，
   * 然后前一位数字+1，以此类推
   * 
   * 最后如果首位等于10的情况再拿出来单独判断
   */
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
