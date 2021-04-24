package leetcode.beginning2021;

import java.util.Arrays;

/**
 * @author: zhushang
 * @create: 2021-04-22 13:10
 */
public class L322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      for (int c : coins) {
        if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - c] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
