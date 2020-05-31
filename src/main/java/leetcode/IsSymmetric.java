package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            if(!isSymmetric(list)){
                return false;
            }
            for (TreeNode node :
                    list) {
                queue.add(node.left);
                queue.add(node.right);

            }
            list.clear();

            }
         return true;
        }

    private boolean isSymmetric(List<TreeNode> list) {
        int left = 0,right = list.size()-1;
        while(left<right){
            TreeNode leftNode = list.get(left);
            TreeNode rightNode = list.get(right);
            if(leftNode==null&&rightNode==null){

            }else if(leftNode==null||rightNode==null||list.get(left).val!=list.get(right).val){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
