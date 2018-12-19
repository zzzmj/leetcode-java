package easy._026;

/**
 * @author zmj
 * @Description 删除排序数组中的重复项
 * @create 2018/9/15
 */
public class Solution {
    /**
     * 完全模拟的方法，出现相同的数，数组就前移，这种方法比较慢，但实际上改变的数组的值
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int repeat = 0;
        int i = 0;
        while (i != (len - 1)) {
            if (i + 1 < len && nums[i] != nums[i + 1]) {
                i++;
            } else {
                while (i + 1 < len && nums[i] == nums[i + 1]) {
                    repeat++;
                    i++;
                }
                len -= repeat; // 数组前移，长度减小
                i -= repeat;
                for (int j = i + 1; j < len; j++)
                    nums[j] = nums[j + repeat];
                repeat = 0;
            }

        }

        return len;
    }

    /**
     * 第二种方法我第一时间没想到，参考了别人的代码
     * 既然是有序的，相同的数字都在一起，遇到不同的数字时，我们直接把这个数字放在前面，舍弃中间的数字即可
     *
     * @param nums
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[len] != nums[i])
                nums[++len] = nums[i];
      
        return len + 1;
    }
}
