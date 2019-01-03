package medium._005;

/**
 * @author zmj
 * @create 2019/1/3
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        int x = 0, y = 1;
        // 状态转移方程 dp[i][j] = dp[i+1][j-1] str[i] == str[j]
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i+1 < len && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                x = i;
                y = i+2;
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len && j+i < len; j++) {
                if (s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1] == 1) {
                    dp[j][j+i] = 1;
                    x = j;
                    y = j+i+1;
                }
            }
        }
        return s.substring(x, y);
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("acb"));
    }
}
