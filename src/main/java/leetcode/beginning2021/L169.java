package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-19 23:57
 */
public class L169 {
  public int majorityElement(int[] nums) {
    // 摩尔投票法
    int res = 0;
    int count = 0;
    for (int n : nums) {
      if (count == 0) {
        res = n;
        count++;
      } else {
        if (n == res) count++;
        else count--;
      }
    }
    return res;
  }

  public int majorityElement_1(int[] nums) {
    // 分治
    return majorityElement_1(nums, 0, nums.length - 1);
  }

  private int majorityElement_1(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    int mid = left + (right - left) / 2;
    int l = majorityElement_1(nums, left, mid);
    int r = majorityElement_1(nums, mid + 1, right);

    int cl = count(nums, left, mid, l);
    int cr = count(nums, mid + 1, right, r);

    return cl > cr ? l : r;
  }

  private int count(int[] nums, int left, int right, int t) {
    int count = 0;
    for (int i = left; i <= right; i++) {
      //
      if (nums[i] == t) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    new L169().majorityElement(new int[] {3, 3, 4});
  }
}
