package leetcode;

/**
 * 递增的三元子序列
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {13, 8, 1, 6, 2, 7, 5};
        System.out.println(increasingTriplet1(nums));
    }
    //暴力法
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<=nums[i])
                {
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k]<=nums[j])
                    {
                        continue;
                    }
                    return true;
                }

            }

        }
        return false;
    }

    public static boolean increasingTriplet1(int[] nums) {
        int min = Integer.MAX_VALUE,mid = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<=min){
                min = nums[i];
            }else if (nums[i]<=mid){
                mid = nums[i];
            }
            else {
                return true;
            }
        }
        return  false;
    }
}
