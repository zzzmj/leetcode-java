package indi.zmj.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zmj
 * @Description 给定一个字符串，找出最长不重复子串
 * @create 2018/10/30
 */
public class LongestSubstringWithoutRepeatingCharacters_003 {
  
  // 由于找不不重复的字符
  // 比较笨的方法：用两重循环，遍历字符串每个位置，如果集合里没有就放进去，时间复杂度O(n²)
  public int lengthOfLongestSubstring(String s) {
    if (s== null || s.length() <= 0) return 0;
    int len = s.length();
    int max = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      
      for (int j = i; j < s.length(); j++) {
        if (!set.contains(s.charAt(j))) {
          set.add(s.charAt(j));
        } else {
          break;
        }
      }
      if (set.size() > max) {
        max = set.size();
      }
      set.clear();
    }
    return max;
  }
  
  
  // 滑动窗口法，维护一个窗口 range[i, j], 没遇到重复的字符, 将字符添加进集合
  // 遇到重复的字符，左边界一直往前滑，直到删掉那个字符
  // 左边界往前滑的时候，其实不需要一个个往前滑，这样比较慢，可以用保存好这个重复字符的位置，直接移动i指针
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
  

  public static void main(String[] args) {
    String s = "pwbwwkew";
    new LongestSubstringWithoutRepeatingCharacters_003().lengthOfLongestSubstring2(s);
  }
}
