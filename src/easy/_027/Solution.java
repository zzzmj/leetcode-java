package easy._027;

/**
 * @author zmj
 * @Description 移除数组中指定的元素
 * @create 2018/9/16
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {};
        Solution re = new Solution();
        re.removeElement(nums, 2);
    }
}
