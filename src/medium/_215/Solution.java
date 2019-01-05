package medium._215;

/**
 * @author zmj
 * @create 2019/1/5
 */
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, right, i);
        return i;
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (partitionIndex == k) {
                return ;
            } else if (partitionIndex < k) {
                quickSort(nums, partitionIndex + 1, right, k);
            } else {
                quickSort(nums, left, partitionIndex - 1, k);
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(s.findKthLargest(arr, 4));
    }

}
