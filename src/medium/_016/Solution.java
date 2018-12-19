package medium._016;

import java.util.Arrays;

/**
 * @author zmj
 * @create 2018/11/13
 */
public class Solution {
    /**
     * 和第15题用的方法类似, 不过比15题更简单
     * 也是固定好第一个数, 用双指针指向剩余数组的末尾, 代表第二个数和第三个数
     * 不同的是，我们每次寻找把值记录下来，固定到最后一个数的时候
     * 自然找到了最接近target的数字
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -4, -2, 0, 2, 5};
        int target = 2;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
