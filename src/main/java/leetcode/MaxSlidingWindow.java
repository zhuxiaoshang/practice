package leetcode;

/**
 * 滑动窗口内最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        for (int t :
                maxSlidingWindow(nums, k)) {
            System.out.println(t);

        }
        ;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];;
        int max = Integer.MIN_VALUE;
        int start = 0;

        while (start <= nums.length - k) {
            int end = start + k - 1;
            res[start] = getMax(nums, start, end);
            start++;
        }

        return res;
    }

    public static int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, nums[i]);

        }
        return max;
    }

}
