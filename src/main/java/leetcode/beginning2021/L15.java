package leetcode.beginning2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhushang
 * @create: 2021-04-16 13:42
 */
public class L15 {
  // [-1,0,1,2,-1,-4] a+b+c = 0
  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum > 0) {
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l + 1] == nums[l]) {
            l++;
          }
          while (l < r && nums[r - 1] == nums[r]) {
            r--;
          }
          r--;
          l++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(new L15().threeSum(nums));
  }
}
