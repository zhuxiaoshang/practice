package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 15:20
 */
public class L191 {
  public int hammingWeight(int n) {
    int count = 0;
    while (n > 0) {
      n &= n - 1;
      count++;
    }
    return count;
  }
}
