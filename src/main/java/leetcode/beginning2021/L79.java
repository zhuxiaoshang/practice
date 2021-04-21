package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 13:56
 */
public class L79 {
  int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  boolean res = false;

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)) {
          boolean[][] isvisit = new boolean[m][n];
          dfs(board, m, n, i, j, isvisit, word, 0);
        }
      }
      //
    }
    return res;
  }

  private void dfs(
      char[][] board, int m, int n, int i, int j, boolean[][] isvisit, String word, int k) {
    if (k == word.length()) {
      res = true;
      return;
    }

    if (i >= m
        || i < 0
        || j >= n
        || j < 0
        || isvisit[i][j]
        || word.charAt(k) != board[i][j]) { // 减枝
      return;
    }
    isvisit[i][j] = true;
    for (int[] d : dirs) {
      int x = i + d[0];
      int y = j + d[1];
      dfs(board, m, n, x, y, isvisit, word, k + 1);
    }
    isvisit[i][j] = false; // 回溯
  }
}
