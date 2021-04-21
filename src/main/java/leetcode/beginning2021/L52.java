package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 19:24
 */
public class L52 {
  int count = 0;

  public int totalNQueens(int n) {
    dfs(n, 0, 0, 0, 0);
    return count;
  }

  private void dfs(int n, int row, int col, int pie, int na) {
    if (row >= n) {
      count++;
      return;
    }
    int bits = ~(col | pie | na) & ((1 << n) - 1);
    while (bits > 0) {
      int bit = bits & (-bits);
      dfs(n, row + 1, col | bit, (pie | bit) << 1, (na | bit) >> 1);
      bits &= bits - 1;
    }
  }
}
