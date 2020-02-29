package leetcode;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {4,0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int index=0;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]!=0)
            {
                nums[index++] = nums[i];
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }

        for (int t :
                nums) {
            System.out.print(t);

        }
    }
}
