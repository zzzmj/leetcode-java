package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description 
 * 一开始看的时候没看懂这个序列，后来才明白
 * 下一个出现的序列 = 上个序列（数字出现的次数+这个数字）
 * 比如拿 4和5来说，第四个序列是1211，所以第五个序列要是 1个1, 1个2, 2个1
 * 所以第五个序列是111221
 * 就是按照这个规则
 * @create 2018/9/19
 */
public class CountAndSay_038 {
  /**
   * solve()最开始想到的办法：往字符串末尾添加一个标识符，这样方便比较出新字符串
   * 但添加字符到末尾总归会不太好
   * solve2()方法更好一些
   * @param n
   * @return
   */
  public String countAndSay(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) 
      s = solve2(s);
    return s;
  }
  public String solve(String s) {
    s += "#";
    int len = 1;
    String s2 = "";
    for (int i = 0; i < s.length()-1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        len++;
      } else if (s.charAt(i) != s.charAt(i+1)) {
        s2 += String.valueOf(len)+s.charAt(i); 
        len = 1;
      }
    }
    return s2;
  }
  public String solve2(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      int cnt = 1;
      while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
        i++;
        cnt++;
      }
      res += String.valueOf(cnt) + s.charAt(i);
    }
    return res;
  }
  
}
