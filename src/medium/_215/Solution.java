package medium._215;

/**
 * @author zmj
 * @create 2019/1/5
 */
public class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int medianOf3(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            swap(nums, mid, right);
        }
        return mid;
    }

    private int partition(int[] nums, int left, int right, int mid) {
        int pivot = nums[mid];
        swap(nums, mid, right);
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

    private int quickSort(int[] nums, int left, int right, int k) {
        while (true) {
            if (left == right) {
                return nums[left];
            }
            int mid = medianOf3(nums, left, right);
            int partitionIndex = partition(nums, left, right, mid);
            if (partitionIndex == k) {
                return nums[k];
            } else if (partitionIndex < k) {
                left = partitionIndex + 1;
            } else {
                right = partitionIndex - 1;
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }
}
