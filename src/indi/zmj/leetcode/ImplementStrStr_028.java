package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description 实现strStr()函数，给定两个字符串，在第一个字符串中找第二个字符串出现的位置
 * @create 2018/9/16
 */
public class ImplementStrStr_028 {

    // 直接调用indexOf()方法
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
    
        return haystack.indexOf(needle);
    }

    // 手写就是把将haystack与needle逐个比较，以needle长度为界
    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.length() <= 0)
            return 0;

        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            int flag = 1;
            for (int j = 0; j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = 0;
                }
            }
            if (flag == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr_028 i = new ImplementStrStr_028();
    }
}
