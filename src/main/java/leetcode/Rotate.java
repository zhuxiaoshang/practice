package leetcode;

/**
 * 旋转数组
 */
public class Rotate {
    public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7} ;
    int k =3;
//    rotate(nums,k);
        ringReplace(nums,k);
    for(int i:nums)
    {
        System.out.println(i);
    }
    }

    public static void rotate(int[] nums, int k) {
        if(k>nums.length){
            k = k%nums.length;
        }
        int[] tmp = new int[k];
        System.arraycopy(nums,nums.length-k,tmp,0,k);
        System.arraycopy(nums,0,nums,k,nums.length-k);
        System.arraycopy(tmp,0,nums,0,k);
    }

    public static void ringReplace(int[] nums, int k) {
        k = k%nums.length;
        int count =0;
        for (int start = 0; count <nums.length ; start++) {//count = nums.length时跳出循环，如果还没有则继续下一轮循环
            int cur = start;
            int pre = nums[start];
            do {
                int next = (cur + k)%nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count++;
            }while (start!=cur);//当cur = start时，标识又回到了起始位置，同时通过count计数的方式来判断是否还有其他元素还没有替换完成
        }
    }
}
