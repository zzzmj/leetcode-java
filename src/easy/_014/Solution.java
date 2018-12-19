package easy._014;

/**
 * @author zmj
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * @create 2018/9/13
 * <p>
 * 学习了两个方法
 * int indexOf(); 返回指定字符串或者字符在此字符串中第一次出现的索引，未出现返回-1
 * <p>
 * String substring(int begin, int end); 返回一个新的字符串，它是此字符串的子字符串，
 * 从begin开始到end结束
 */
public class Solution {
    // 这是一个更好的方法，将第一个字符串当成模板，与其他字符串数组逐个比对，有不同则裁去
    public String longestCommonPrefix(String[] strs) {
        String string = "";

        if (strs.length == 0)
            return "";

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
            }
        }

        return ans;
    }

    // 字符串数组以第一个为模板，每次比较一个字符
    public String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0)
            return "";
        String string = "";

        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++)
            if (strs[i].length() < min)
                min = strs[i].length();

        for (int i = 0; i < min; i++) {
            boolean temp = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    temp = false;
                    break;
                }
            }
            if (temp == true) {
                string += strs[0].charAt(i);
            } else {
                break;
            }
        }
        return string;
    }
}
