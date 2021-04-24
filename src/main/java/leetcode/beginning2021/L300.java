package leetcode.beginning2021;

import java.util.Arrays;

/**
 * @author: zhushang
 * @create: 2021-04-22 11:51
 */
public class L300 {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int res = 1;
    Arrays.fill(nums, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(res, dp[i]);
        }
      }
    }
    return res;
  }
}
