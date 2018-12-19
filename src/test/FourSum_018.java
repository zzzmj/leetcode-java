package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zmj
 * @create 2018/11/14
 */
public class FourSum_018 {
    /**
     * 3Sum基础上再加一层循环
     * @param sums
     * @param target
     * @return
     */
    public List<List<Integer>> forSum(int[] sums, int target) {
        Arrays.sort(sums);
        List<List<Integer>> ll = new ArrayList<>();
        
        int len = sums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (sums[i] == sums[j]) continue;
                int left = j+1;
                int right = len-1;
                while (left < right) {
                    int res = sums[i] + sums[j] + sums[left] + sums[right];
                    if (res == target) {
                        List<Integer> list = Arrays.asList(sums[i], sums[j], sums[left], sums[right]);
                        ll.add(list);
                        
                        while (left < right && sums[left] == sums[left+1]) left++;
                        while (left < right && sums[right] == sums[right-1]) right--;
                        left++; right--;
                    } else if (res < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        System.out.println(ll);
        return ll;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, 0, -2, 2};
        new FourSum_018().forSum(nums, 0);
    }
}
