package easy._009;

/**
 * @author zmj
 * @Description 判断一个数是不是回文数
 * @create 2018/9/9
 */
public class Solution {
    /**
     * 将整数转为字符串的做法。
     */
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int len = num.length();
        for (int i = 0; i < len / 2; i++) {
            if (num.charAt(i) != num.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 直接做法，求逆序数，与原数比较，相等即是回文数
     */
    public boolean isPalindrome2(int x) {

        if (x != ReverseInteger(x) || x < 0) {
            return false;
        } else {
            return true;
        }

    }

    public int ReverseInteger(int x) {
        int num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num;
    }
}
