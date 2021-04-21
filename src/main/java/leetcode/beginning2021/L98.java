package leetcode.beginning2021;

import leetcode.common.TreeNode;

/**
 * @author: zhushang
 * @create: 2021-04-18 00:04
 */
public class L98 {
  public boolean isValidBST(TreeNode root) {
    return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean dfs(TreeNode root, long min, long max) {
    if (root == null) return true;
    if (min >= root.val || max <= root.val) return false;

    return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
  }
}
