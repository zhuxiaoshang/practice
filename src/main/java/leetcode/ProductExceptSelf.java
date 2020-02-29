package leetcode;

/**
 * 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    public static void main(String[] args) {

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] = k;//i左边的乘积存入数组
            k *= nums[i];//乘上nums[i]作为新的积
        }
        k = 1 ;
        for (int i = nums.length-1; i >=0 ; i--) {
            out[i] *= k; //左边*右边的积;
            k *= nums[i];//右边的积
        }
        return out;
    }
}
