package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  二叉搜索树中第K小的元素
 */
public class KthSmallestofTree {
    static int count = 0;
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(kthSmallest(n1,4));
//        preOrderTraverse1(n1);
    }
    public static int kthSmallest (TreeNode root, int k) {
       List<Integer> l = new ArrayList<>();
       midOrderTraverse1(root,l);
        return l.get(k - 1);
    }

    /**递归
     * @param root
     * @param target
     */
    public static void midOrderTraverse1(TreeNode root, List<Integer> target) {
        if (root != null) {
            midOrderTraverse1(root.left,target);
            target.add(root.val);
            midOrderTraverse1(root.right,target);
        }
    }

    /**迭代
     * @param root
     * @param k
     * @return
     */
    public static int midOrderTraverse1(TreeNode root,int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        while (null != root) {
            while(null!=root){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0){
                return  root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
