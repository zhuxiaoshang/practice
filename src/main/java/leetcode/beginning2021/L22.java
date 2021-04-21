package leetcode.beginning2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhushang
 * @create: 2021-04-20 16:14
 */
public class L22 {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    dfs(res, n, 0, 0, "");
    return res;
  }

  private void dfs(List<String> res, int n, int left, int right, String s) {
    if (right == n) {
      res.add(s);
      return;
    }
    if (left < n) {
      dfs(res, n, left + 1, right, s + "(");
    }
    if (right < left) {
      dfs(res, n, left, right + 1, s + ")");
    }
  }
}
