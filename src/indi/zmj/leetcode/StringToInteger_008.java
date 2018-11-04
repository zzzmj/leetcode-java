package indi.zmj.leetcode;

/**
 * 将字符串转换成整数
 * @author zmj
 * @create 2018/11/2
 */
public class StringToInteger_008 {
  /**
   * 
   * 主要比较难处理的还是溢出问题，想把这个算法写漂亮也不容易
   * 参考了别人的写法
   * @param str
   * @return
   */
  public int myAtoi(String str) {
    if (str == null || str.length() <= 0) return 0;
    int i = 0, len = str.length(), sign = 1, n = 0;
    // 处理前端空格
    while (i < len && str.charAt(i) == ' ') ++i;
    if (i == len) return 0;
    if (str.charAt(i) == '-' || str.charAt(i) == '+') {
      sign = (str.charAt(i++) == '+') ? 1 : -1;
    }
    while (i < len && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
        if (n > Integer.MAX_VALUE/10 ||
                (n == Integer.MAX_VALUE/10 && (str.charAt(i)-'0') % 10 > 7))
          return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        n = n*10 + (str.charAt(i)-'0');
        i++;
    }
    return n*sign;
  }
  
}
