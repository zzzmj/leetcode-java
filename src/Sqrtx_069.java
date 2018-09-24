/**
 * @author zmj
 * @Description
 * @create 2018/9/24
 */
public class Sqrtx_069 {
  /**
   * 使用牛顿迭代法
   * Xn+1 = Xn/2 + n/2Xn;
   */
  public int mySqrt(int x) {
    double pre = 0;
    double res = 1;
    while (Math.abs(res-pre) > 0.000001) {
      pre = res;
      res = (res + x/res) / 2;
    }
    return (int)Math.floor(res);
  }
  /**
   * 使用二分搜索
   */
  public int mySqrt2(int x) {
    if (x <= 1) return x;
    int low = 0;
    int high = x;
    while (low <= high) {
      int mid = low + (high-low)/2;
      long sqrt = x / mid;
      if (sqrt == mid) return mid;
      else if (sqrt < mid) high = mid - 1;
      else low = mid + 1;
    }
    return high;
  }

  public static void main(String[] args) {
    Sqrtx_069 sq = new Sqrtx_069();
    System.out.println(sq.mySqrt2(0));
  }
}
