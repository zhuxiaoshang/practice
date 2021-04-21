package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 15:29
 */
public class L231 {
  public boolean isPowerOfTwo(int n) {
    // n必须大于0，且二进制位中只有1个1，n & (n - 1)去掉最低位1后就是0
    return n > 0 && (n & (n - 1)) == 0;
  }
}
