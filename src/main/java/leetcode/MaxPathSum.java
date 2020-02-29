package leetcode;

/**
 * 二叉树中的最大路径和
 */
public class MaxPathSum {
    public static void main(String[] args) {
        Math.sqrt(16);
        System.out.println(Math.floor(Math.sqrt(23)));
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }

    public int recursion(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = Math.max(recursion(root.left),0);
        int right = Math.max(recursion(root.right),0);

        int weight = Math.max(left, right) + root.val;

        max = Math.max(max, left + right + root.val);
        return weight;
    }
}
