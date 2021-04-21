package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-19 19:36
 */
public class L50 {
  public double myPow(double x, int n) {
    return n >= 0 ? pow(x, n) : 1 / pow(x, -n);
  }

  public double pow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    // 二分
    double m = pow(x, n / 2);
    // n&1 == 0 判断奇偶 比 n%2==0 要快
    return (n & 1) == 0 ? m * m : m * m * x;
  }
}
