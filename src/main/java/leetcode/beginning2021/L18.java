package leetcode.beginning2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhushang
 * @create: 2021-04-16 15:08
 */
public class L18 {
  // [1,0,-1,0,-2,2] -2,-1,0,0,1,2
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j - 1] == nums[j]) {
          continue;
        }
        int l = j + 1;
        int r = n - 1;
        while (l < r) {
          int sum = nums[i] + nums[j] + nums[l] + nums[r];
          if (sum > target) {
            r--;
          } else if (sum < target) {
            l++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            while (l < r && nums[l + 1] == nums[l]) {
              l++;
            }
            while (l < r && nums[r - 1] == nums[r]) {
              r--;
            }
            l++;
            r--;
          }
        }
      }
    }
    return res;
  }
}
