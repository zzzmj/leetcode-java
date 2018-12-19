package medium._017;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zmj
 * @create 2018/11/13
 */
public class Solution {
    private char a;

    /**
     * 思路一：回溯法
     * 1. 建立映射
     * 2. 先将传进来的字符串转为整数
     * 3. 回溯求解所有可能
     * 在递归里使用一个集合保存所有解，使用一个字符数组保存一组解
     */
    public List<String> letterCombinations(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return list;
        }
        
        int len = digits.length();
        int[] num = new int[len];
        char[] ch = new char[len];
        
        for (int i = 0; i < len; i++) {
            num[i] = digits.charAt(i) - '0';
        }
        
        dfs(0, num, dict, list, ch);
        return list;
    }

    /**
     * 参数很多 解释下意思
     * @param levle 递归的层数
     * @param num 由digits字符串转化完成的数字数组
     * @param dict 字典
     * @param list 储存所有的解
     * @param ch 储存一个解的字符数组
     */
    public void dfs(int levle, int[] num, String[] dict, List<String> list, char[] ch) {
        if (levle == num.length) {
            list.add(new String(ch));
            return;
        }
        String s = dict[num[levle]];
        for (int i = 0; i < s.length(); i++) {
            ch[levle] = s.charAt(i);
            dfs(levle+1, num, dict, list, ch);
        }
    }

    /**
     * 不使用递归, 自己一开始没想到还能这样, 参考了别人的解法
     * 使用队列
     */
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<>();
        }
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        int[] num = new int[len];
        List<String> prev = new ArrayList<>();
        prev.add("");
        for (int i = 0; i < len; i++) {
            num[i] = digits.charAt(i) - '0';
            String str = dict[num[i]];
            List<String> newList = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                for (String s : prev) {
                    s = s + str.charAt(j);
                    newList.add(s);
                }
            }
            prev = newList;
        }
        return prev;
    }
    public static void main(String[] args) {
         new Solution().letterCombinations2("23");
    }
    
    
}
