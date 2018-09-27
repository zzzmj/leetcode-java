/**
 * @author zmj
 * @Description 合并两个有序数组
 * @create 2018/9/25
 */
public class MergeSortedArray_088 {
  /**
   * 其实这道题一开始容易想到的方法，就是两个数组相互比较，放到第三个数组里，最后再把第三个数组
   * 赋值给第一个数组，这样做的话，其实也比较麻烦，也会开辟新的空间造成浪费
   * 
   * 其实更好的办法是考虑到nums1数组后面的空间
   * 将两个数组从后面开始比较，因为长度我们已经知道了，是m+n
   * 所以从nums[m+n-1]一直往前推，最终是能够合并两个数组的
   * 
   * 也要考虑特殊情况，当最小的元素在nums1时，我们不用处理
   * 但如果最小的元素在nums2时，我们应该再拿出来单独处理
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-1, j = n-1;
    int k = m+n-1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] < nums2[j]) {
        nums1[k--] = nums2[j--];
      } else {
        nums1[k--] = nums1[i--]; 
      }
    }
    
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
  
}
