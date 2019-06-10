## 笔记

### 215题，数组中的第K个最大元素（分治）

这题我一开始用的办法是
```java
public int quickSort(int[] nums, int left, int right, int k) {
    int partitionIndex = partition(nums, left, right);
    if (partitionIndex == k) {
        return nums[k];
    } else if (partitionIndex < k) {
        return quickSort(nums, partitionIndex + 1, right, k);
    } else {
        return quickSort(nums, left, partitionIndex - 1, k);
    }
}
```

但是发现，使用这种快排的方式，居然没有java自带的排序，排序后再选取元素快



按道理不应该啊，然后我就去看了一下别人的实现原理，
我注意到，导致快排慢的原因是我们的基准数选取有问题，
我选取基准数的策略是每次选取最后一个数字当基准数，
这个策略在测试的数据中选取了很差的基准数，导致程序变慢了

改进：采用三数取中选取基准值

```java
public int medianOf3(int[] nums, int left, int right) {
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
```



最后在`partition`中，把选取的中值和最后一个数交换一下

