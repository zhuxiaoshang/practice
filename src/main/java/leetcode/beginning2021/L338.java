package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 15:40
 */
public class L338 {
  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    res[0] = 0;
    for (int i = 1; i <= num; i++) {
      res[i] = res[i & (i - 1)] + 1;
    }
    return res;
  }

  private int getBitCount(int i) {
    int count = 0;
    while (i != 0) {
      count++;
      i &= i - 1;
    }
    return count;
  }
}
