package leetcode.beginning2021;

import leetcode.common.TreeNode;

/**
 * @author: zhushang
 * @create: 2021-04-19 10:27
 */
public class L235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      TreeNode tmp;
      tmp = p;
      p = q;
      q = tmp;
    }
    if (p.val <= root.val && q.val >= root.val) {
      return root;
    } else if (q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
