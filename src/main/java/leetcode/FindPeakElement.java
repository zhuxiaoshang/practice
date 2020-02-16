package leetcode;

/**
 * 寻找峰值
 * 要求O(logN)时间复杂度
 */
public class FindPeakElement {
    public static void main(String[] args) {

    }
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right =nums.length-1;

        return divide(nums, left, right);

    }

    public static int divide(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = start+(end-start)/2;
        if(nums[mid]>nums[mid+1]) {
            return divide(nums, start, mid);
        }
        return divide(nums, mid + 1, end);
    }
}
