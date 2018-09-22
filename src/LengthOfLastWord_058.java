/**
 * @author zmj
 * @Description 给定一个字符串 返回最后一个单词的长度
 * @create 2018/9/20
 */
public class LengthOfLastWord_058 {
  /**
   * 使用正则直接匹配的方法
   */
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() <= 0) 
      return 0;
    String[] strings;
    strings = s.split(" ");
    int len = strings.length-1;
    if (len < 0) 
      return 0;
    return strings[len].length();
  }

  /**
   * 从字符串最后开始检查，用count记录长度，当count有数值以后检查到空格时，即可退出循环
   */
  
  public int lengthOfLastWord2(String s) {
    if (s == null || s.length() <= 0)
      return 0;
    int len = s.length();
    int count = 0; // 记录单词长度
    
    for (int i = len-1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        count++;
      } else if(count > 0 ) {
        break;
      }
    }
    return count;
  }
}
