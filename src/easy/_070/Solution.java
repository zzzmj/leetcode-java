package easy._070;

/**
 * @author zmj
 * @Description 经典的台阶问题，一次只能走一阶或者两阶
 * 问到第n阶有多少种办法
 * @create 2018/9/25
 */
public class Solution {

    /**
     * 上到第n阶，要么从第n-1阶上，要么从第n-2阶上
     * 所以状态转移方程
     * Sn = Sn-1 + Sn-2
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2, s = 0;
        for (int i = 2; i < n; i++) {
            s = a + b;
            a = b;
            b = s;
        }
        return s;
    }
}
