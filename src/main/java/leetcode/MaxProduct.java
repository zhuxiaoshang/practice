package leetcode;

/**
 * 最大乘积子序列
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxMulti = Integer.MIN_VALUE;
        int imax =1,imin  =1;


        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<0)
            {//如果是负数，乘上以后最大变最小，最小变最大
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            maxMulti = Math.max(imax,maxMulti);
        }
        return maxMulti;
    }
}
