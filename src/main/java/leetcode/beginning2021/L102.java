package leetcode.beginning2021;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zhushang
 * @create: 2021-04-20 11:39
 */
public class L102 {
  // BFS
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> l = new ArrayList<>();
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode node = queue.poll();
        l.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      res.add(l);
    }

    return res;
  }

  public List<List<Integer>> levelOrder_dfs(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, res, 1);

    return res;
  }

  private void dfs(TreeNode root, List<List<Integer>> res, int level) {
    if (root == null) return;
    if (res.size() < level) res.add(new ArrayList<>());

    res.get(level - 1).add(root.val);

    dfs(root.left, res, level + 1);
    dfs(root.right, res, level + 1);
  }
}
