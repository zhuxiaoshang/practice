package leetcode.beginning2021;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhushang
 * @create: 2021-04-20 15:18
 */
public class L111 {
  int res = Integer.MAX_VALUE;

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int level = 1;
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        TreeNode node = q.poll();
        if (node.left == null && node.right == null) return level;
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
      level++;
    }
    return level;
  }

  private void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      res = Math.min(res, level);
    }
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }
}
