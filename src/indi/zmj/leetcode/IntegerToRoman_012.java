package indi.zmj.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zmj
 * @create 2018/11/8
 */
public class IntegerToRoman_012 {
    // 1. 把所有规则建立键值对, 其实也可以直接用字符串数组建立，会更快，因为下标是固定的了
    // 2. 拆分数字
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        final int[] a = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        int len = 12;
        while (num != 0) {
            if (num - a[len] >= 0) {
                num -= a[len];
                s.append(map.get(a[len]));
            } else {
                len--;
            }

        }
        return s.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman_012 a = new IntegerToRoman_012();
        a.intToRoman(3);
    }
}
