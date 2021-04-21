package leetcode.beginning2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhushang
 * @create: 2021-04-16 10:28
 */
public class L239 {
  static PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> -a));

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    for (int i = 0; i < k; i++) {
      q.add(nums[i]);
    }
    res[0] = q.peek();
    for (int i = 0; i < n - k; i++) {
      int j = i + k;
      q.remove(nums[i]);
      q.add(nums[j]);
      res[j - 2] = q.peek();
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] res = new L239().maxSlidingWindow(nums, 3);
    Arrays.stream(res).forEach(System.out::println);
  }
}
