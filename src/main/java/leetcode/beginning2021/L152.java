package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 23:54
 */
public class L152 {
  public int maxProduct(int[] nums) {
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int res = dp[0][0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= 0) {
        dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
        dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
      } else {
        dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
        dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
      }
      res = Math.max(dp[i][0], res);
    }
    return res;
  }
}
