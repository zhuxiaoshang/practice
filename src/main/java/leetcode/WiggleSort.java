package leetcode;

import java.util.Arrays;

/**
 * 摆动排序 II
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1, mid = nums.length % 2==0?nums.length/2:nums.length/2+1;
        int tmp;
        while (i < nums.length && mid < nums.length) {
            if (i == mid && i < nums.length - 1) {
                tmp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = tmp;
            } else {
                tmp = nums[i];
                nums[i] = nums[mid];
                nums[mid] = tmp;
            }
            i = i + 2;
            mid = mid + 1;
        }
    }
}
