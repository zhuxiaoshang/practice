package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-22 14:35
 */
public class L200 {
  public int numIslands(char[][] grid) {
    return 0;
  }

  class UF {
    int[] root;
    int m;
    int n;

    public UF(int a, int b, char[][] grid) {
      this.m = a;
      this.n = b;
      root = new int[m * n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') root[i * n + j] = i * n + j;
        }
      }
    }

    public int findRoot(int i, int j) {
      int r = i * n + j;
      while (r != root[r]) {
        r = root[r];
      }
      return r;
    }

    public void connect(int i1, int j1, int i2, int j2) {
      int r1 = i1 * n + j1;
      int r2 = i2 * n + j2;
      root[r1] = r2;
    }

    public void union(int i1, int j1, int i2, int j2) {
      int r1 = findRoot(i1, j1);
      int r2 = findRoot(i2, j2);
      root[r1] = r2;
    }
  }
}
