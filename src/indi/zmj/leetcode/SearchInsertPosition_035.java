package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @create 2018/9/19
 */
public class SearchInsertPosition_035 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }
        return len;
    }

}
