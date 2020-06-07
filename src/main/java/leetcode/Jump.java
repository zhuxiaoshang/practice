package leetcode;


public class Jump {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Jump().jump(nums));
    }
    int minStep = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        dfs(nums,len,0,0);
        return minStep;

    }

    private int dfs(int[] nums, int len,int start, int step) {
        if(start == len-1)
        {
            return step;
        }
        if(start>=len||nums[start] == 0){
            return len;
        }
        for (int i = 1; i <=nums[start]; i++) {
            minStep = Math.min(minStep,dfs(nums,len,start+i,step+1)) ;
        }
        return minStep;
    }
}
