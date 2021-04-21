package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 10:21
 */
public class L69 {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    } else {
      int left = 1, right = x / 2;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (mid == x / mid) {
          return mid;
        } else if (mid > x / mid) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      // 应该输出mid，left = mid+1,所以要减去
      return left - 1;
    }
  }

  public static void main(String[] args) {
    System.out.println(new L69().mySqrt(2147395599));
  }
}
