package leetcode;

import java.util.*;

public class LowestCommonAncestor {
    TreeNode anc = null;

    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return anc;
    }

    public  boolean recursion(TreeNode cur, TreeNode p, TreeNode q) {
        if(cur ==null)
        {
            return false;
        }
        int left = recursion(cur.left,p,q)?1:0;
        int right = recursion(cur.right,p,q)?1:0;

        int mid = cur==p||cur ==q?1:0;
        if(mid+left+right>=2){
            anc = cur;
        }

        return mid+left+right>0;
    }

    public  TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack  = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        //遍历二叉树，知道找到p和q，并将遍历过的左右子节点的父节点存入map
        while (!parent.containsKey(p)||!parent.containsKey(q)) {
           TreeNode cur =stack.pop();

            if (cur.left != null) {
                parent.put(cur.left, cur);
                stack.push(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                stack.push(cur.right);
            }
        }
        //回溯寻找p的父节点及祖先节点
        Set<TreeNode> p_ancs = new HashSet<>();
        while (p != null) {
            p_ancs.add(parent.get(p));
            p = parent.get(p);
        }
        //找q的父节点及祖先节点，直到第一个父节点在p_ancs中出现，则当前节点就是p和q的第一个公共父节点
        while (!parent.containsKey(q)) {
            q = parent.get(q);
        }
        return q;

    }
}
