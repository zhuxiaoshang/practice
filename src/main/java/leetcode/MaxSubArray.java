package leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int cur = 0,max = nums[0];
        for(int i:nums){
            cur = Math.max(cur+i,i);
            max = Math.max(max,cur);
        }
        return max;
    }
}
