package indi.zmj.leetcode;

/**
 * @author zmj
 * @create 2018/11/4
 */
public class ContainerWithMostWater_011 {
    /**
     * 初步思路：枚举每一种可能，复杂度O(n²)
     * 显然，这种方法不够好~~
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int capacity = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                capacity = Math.min(height[i], height[j]) * (j - i);
                if (capacity > max) {
                    max = capacity;
                }
            }
        }
        return max;
    }


    /*
      O(n)的解法，看了官方的解答才恍然大悟，矩形的面积受限于长度更小的一条线段，
      维护双指针，一直移动小的线段，最后能解出最优解
     */
    public int maxArea2(int[] height) {
        int capacity = 0;
        int max = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            capacity = Math.min(height[i], height[j]) * (j - i);
            if (capacity > max) {
                max = capacity;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;

    }

    public static void main(String[] args) {

    }
}
