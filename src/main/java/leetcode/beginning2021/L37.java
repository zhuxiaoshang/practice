package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-20 23:34
 */
public class L37 {
  public void solveSudoku(char[][] board) {
    dfs(board);
  }

  private boolean dfs(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if (dfs(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          // 如果1-9都不满足 则返回false，进行回溯
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int i, int j, char c) {
    // 当前行与board[i][j]相同则不合法
    // 当前列与board[i][j]相同则不合法
    for (int k = 0; k < 9; k++) {
      if (board[i][k] != '.' && c == board[i][k]) return false;
      if (board[k][j] != '.' && c == board[k][j]) return false;
    }
    // 九宫格与board[i][j]相同则不合法
    for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
      for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
        // k != i && l != j 不能放上面，因为两重循环，会多过滤掉board[i][j]所在行和列的元素
        if (board[k][l] != '.' && c == board[k][l]) return false;
      }
    }
    return true;
  }
}
