package leetcode.beginning2021;

import leetcode.common.TreeNode;

/**
 * @author: zhushang
 * @create: 2021-04-20 15:07
 */
public class L104 {
  int res = 0;

  public int maxDepth(TreeNode root) {
    dfs(root, 1);
    return res;
  }

  private void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    res = Math.max(level, res);
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }
}
