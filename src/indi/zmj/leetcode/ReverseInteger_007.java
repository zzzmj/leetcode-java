package indi.zmj.leetcode;

/**
 * @author 1
 * @Description 将一个整数反转输出
 * @create 2018/9/9
 * @since 1.0.0
 */
public class ReverseInteger_007 {
  
  public int reverses(int x) {
    int num = 0;
    while(x != 0) {
      if(num > (Integer.MAX_VALUE)/10 - (x%10)/10) {
        return 0;
      }
      if(num < (Integer.MIN_VALUE)/10 - (x%10)/10) {
        return 0;
      }
      num = num*10 + x%10;
      x /= 10;
    }
    return num;
  }
  
}
