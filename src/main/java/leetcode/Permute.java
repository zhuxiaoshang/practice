package leetcode;

import java.util.*;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0 ){
            return res;
        }
        boolean[] used = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
            List<Integer> path = new ArrayList<>();
            while(!queue.isEmpty()){
                if (path.size() == len) {
                    res.add(path);
                    path = new ArrayList<>();
                }
        }



        }
//        bfs()
//        dfs(nums,0,len,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int depth,int len, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <len; i++) {
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] =true;
            dfs(nums, depth+1, len, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

}
