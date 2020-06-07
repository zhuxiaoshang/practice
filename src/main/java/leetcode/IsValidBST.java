package leetcode;

import scala.Int;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);

    }

    private boolean recursion(TreeNode root, Integer low, Integer up) {
        if(root ==null){
            return true;
        }
        int val = root.val;
        if(low!=null&&val<=low){
            return  false;
        }
        if(up!=null&&val>=up){
            return false;
        }
        if(!recursion(root.left,low,val)){
            return false;
        }
        if(!recursion(root.right,val,up)){
            return false;
        }
        return true;
    }

}
