package leetcode.beginning2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zhushang
 * @create: 2021-04-20 17:42
 */
public class L51 {
  List<List<String>> res = new ArrayList<>();
  Set<Integer> col = new HashSet<>();
  Set<Integer> pie = new HashSet<>();
  Set<Integer> na = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {

    String[][] table = new String[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        table[i][j] = ".";
      }
    }
    dfs(table, 0, n);
    return res;
  }

  private void dfs(String[][] table, int row, int n) {
    if (row >= n) {
      List<String> l = new ArrayList<>();
      for (String[] t : table) {
        l.add(String.join("", t));
      }
      res.add(l);
      return;
    }
    for (int i = 0; i < n; i++) {
      // 遍历列

      if (!check(row, i)) {
        continue;
      }
      table[row][i] = "Q";
      col.add(i);
      pie.add(row + i);
      na.add(row - i);

      dfs(table, row + 1, n);
      // 回溯
      table[row][i] = ".";
      col.remove(i);
      pie.remove(row + i);
      na.remove(row - i);
    }
  }

  private boolean check(int row, int i) {
    return !col.contains(i) && !pie.contains(row + i) && !na.contains(row - i);
  }

  public static void main(String[] args) {
    System.out.println(new L51().solveNQueens(4));
  }
}
