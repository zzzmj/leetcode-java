package easy._013;

import java.util.HashMap;

/**
 * @author zmj
 * @Description
 * @create 2018/9/10
 */
public class Solution {

    /**
     * V1.0版本，代码还是过于臃肿
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        String num = null;
        int sum = 0;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);

        int i = 0;
        // 特殊情况
        while (i + 1 < s.length()) {
            String a = String.valueOf(s.charAt(i));
            String b = String.valueOf(s.charAt(i + 1));
            if (hashMap.get(a) < hashMap.get(b)) {
                num = a + b;
                if (hashMap.get(num) != null) {
                    System.out.println(num);
                    sum += hashMap.get(num);
                    i += 2;
                }
            } else {
                num = String.valueOf(s.charAt(i));
                System.out.println(num);
                if (hashMap.get(num) != null) {
                    sum += hashMap.get(num);
                }
                i++;
            }
        }
        if (i != s.length()) {
            sum += hashMap.get(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

    /**
     * V2.0版本 待维护
     *
     * @param
     */
    public int romanToInt2() {

        return 0;
    }

    public static void main(String[] args) {
        Solution romanToInteger_013 = new Solution();
        System.out.println(romanToInteger_013.romanToInt("III"));
    }
}
