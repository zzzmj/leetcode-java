package easy._053;

/**
 * @author zmj
 * @Description 其实这个问题不那么容易，以前虽然做过，但是忘了
 * @create 2018/9/19
 */
public class Solution {
    /**
     * O(n²)的解法，思路很清晰，第一层循环i作为序列的左边界
     * 第二层循环j作为序列的右边界，然后更新最大的序列即可
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    /**
     * O(n)的解法，代码虽然很简单，但是理解起来并不太容易
     * 因为最大连续子序列和只可能在0~n-1中某个位置结尾。
     * 因为对第i+1的元素，我们有两种选择
     * 要么放入前面找到的子序列中，要么作为新序列的第一个元素
     * 状态转移方程
     * sum[i] = max(sum[i-1]+a[i], a[i]);
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int curSum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            if (curSum > maxSum)
                maxSum = curSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution maximumSubarray_053 = new Solution();
        System.out.println(maximumSubarray_053.maxSubArray2(nums));
    }
}
