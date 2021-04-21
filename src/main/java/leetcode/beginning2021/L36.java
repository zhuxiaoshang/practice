package leetcode.beginning2021;

/**
 * @author: zhushang
 * @create: 2021-04-20 22:44
 */
public class L36 {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !isValid(board, i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int i, int j) {
    // 当前行与board[i][j]相同则不合法
    for (int k = 0; k != j && k < 9; k++) {
      if (board[i][j] == board[i][k]) return false;
    }
    // 当前列与board[i][j]相同则不合法
    for (int k = 0; k != i && k < 9; k++) {
      if (board[i][j] == board[k][j]) return false;
    }
    // 九宫格与board[i][j]相同则不合法
    for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
      for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
        // k != i && l != j 不能放上面，因为两重循环，会多过滤掉board[i][j]所在行和列的元素
        if (k != i && l != j && board[i][j] == board[k][l]) return false;
      }
    }
    return true;
  }
}
