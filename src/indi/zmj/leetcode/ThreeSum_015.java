package indi.zmj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一个数组，找到三个数和为0的有多少组，并显示出来
 *
 * @author zmj
 * @create 2018/11/12
 */
public class ThreeSum_015 {
    /**
     * 最简单的办法是打印所有三元组, 最后去重, 这样做会超时
     * <p>
     * 真正的办法是将 a + b + c = 0, 转化为 -a = b + c;
     * 我们必须先将数组排序
     * 先用一重循环fix第一个数字, 然后用双指针指向剩余数组的首尾
     * b+c 如果小于-a, 左指针往后推, b+c大于-a, 则右指针往前推
     * 如果相等, 我们把这组数加入到集合中, 而且双指针需要继续走, 去掉重复的数字
     * 剪枝叶去重, 如果遇到fix的数字大于0, 那可以直接跳过, 如果上一个数等于当前数, 则需要跳过避免重复
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        if (nums.length < 3)
            return ll;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            // 必须写成nums[i-1] == nums[i]的形式, 因为可能会出现两个相同的数加起来的情况 
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> l = Arrays.asList(nums[i], nums[left], nums[right]);
                    List<String> a = Arrays.asList("12", "13");
                    ll.add(l);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        String a = "213121";
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new ThreeSum_015().threeSum(nums);
    }
}
