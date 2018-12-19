package medium._006;

/**
 * @author zmj
 * @Description 给你一串字符串，指定Z字型的排列方式，排完后，再以从左到右的方式读取，返回这个新字符串
 * @create 2018/10/31
 */
public class Solution {
    /**
     * 这个Z字型的排列，其实就一个向下的操作和一个右上方向操作
     * 用一个二维数组，模拟这个过程，最后再读取这个二维数组
     * <p>
     * 但这不是一个好的办法，会有额外的数组开销
     *
     * @param s：给定的字符串
     * @param numRows：排列的行数
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) return "";
        if (numRows == 1) return s;
        StringBuilder s2 = new StringBuilder();
        char[][] z = new char[numRows + 1][s.length() + 1];
        // 初始化
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < s.length(); j++)
                z[i][j] = '0';
        int x = 0, y = 0, index = 0;
        z[x][y] = s.charAt(index++);
        while (index < s.length()) {
            // 模拟向下走
            while (x + 1 < numRows && index < s.length()) z[++x][y] = s.charAt(index++);
            // 模拟右上走
            while (x > 0 && index < s.length()) z[--x][++y] = s.charAt(index++);
        }
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j <= y; j++)
                if (z[i][j] != '0')
                    s2.append(z[i][j]);
        return s2.toString();
    }


    public static void main(String[] args) {
        new Solution().convert("PAYPALISHIRING", 3);
    }
}
