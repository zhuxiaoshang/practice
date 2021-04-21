package leetcode.beginning2021;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhushang
 * @create: 2021-04-19 10:27
 */
public class L236 {
  Map<TreeNode, TreeNode> map = new HashMap<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    map.put(root, null);
    dfs(root);
    List<TreeNode> pp = new ArrayList<>();
    TreeNode parent = p;
    while (map.containsKey(parent)) {
      pp.add(parent);
      parent = map.get(parent);
    }
    parent = q;
    while (map.containsKey(parent)) {
      if (pp.contains(parent)) {
        break;
      }
      parent = map.get(parent);
    }

    return parent;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      map.put(root.left, root);
    }
    if (root.right != null) {
      map.put(root.right, root);
    }
    dfs(root.left);
    dfs(root.right);
  }
}
