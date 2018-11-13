package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description 移除数组中指定的元素
 * @create 2018/9/16
 */
public class RemoveElement_027 {
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
        RemoveElement_027 re = new RemoveElement_027();
        re.removeElement(nums, 2);
    }
}
