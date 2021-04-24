package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-22 10:58
 */
public class L121 {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][3];
    dp[0][0] = 0; // 当前没有持有
    dp[0][1] = -prices[0]; // 当前持有
    dp[0][2] = 0; // 当天卖出
    int maxPro = 0;
    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0];
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 昨天持有到今天，昨天没有持有，今天买入
      dp[i][2] = dp[i - 1][1] + prices[i];
      maxPro = Math.max(maxPro, Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
    }
    return maxPro;
  }
}
