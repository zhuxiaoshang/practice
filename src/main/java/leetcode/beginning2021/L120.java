package leetcode.beginning2021;

import java.util.List;

/**
 * @author: zhushang
 * @create: 2021-04-21 19:47
 */
public class L120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int depth = triangle.size();
    int width = triangle.get(depth - 1).size();
    int[][] dp = new int[depth][width];
    for (int i = 0; i < width; i++) {
      dp[depth - 1][i] = triangle.get(depth - 1).get(i);
    }
    for (int i = depth - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
      }
    }

    return dp[0][0];
  }

  public int minimumTotal_1(List<List<Integer>> triangle) {
    int depth = triangle.size();
    for (int i = depth - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        triangle
            .get(i)
            .set(
                j,
                triangle.get(i).get(j)
                    + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
      }
    }

    return triangle.get(0).get(0);
  }
}
