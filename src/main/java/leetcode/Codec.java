package leetcode;

/**
 * 二叉树的序列化与反序列化
 */
public class Codec {
    public static void main(String[] args) {
        String pre = "124356";
        String mid = "241536";
        recover(pre, mid);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return pre(root, "") + "," + mid(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String pre = data.split(",")[0];
        String mid = data.split(",")[-1];
        return recover(pre, mid);

    }

    public static TreeNode recover(String pre, String mid) {
        TreeNode root = new TreeNode((int) pre.charAt(0));
        int index = mid.indexOf(pre.charAt(0));
        TreeNode left = recover(pre.substring(1,index+1),mid.substring(0,index));
        TreeNode right = recover(pre.substring(3, pre.length() - index - 1), mid.substring(index + 1));
        root.left = left;
        root.right = right;
        return root;
    }

    public String  pre(TreeNode root,String s) {
        if (null != root) {
            s+=root.val;
            pre(root.left, s);
            pre(root.right, s);
        }
        return s;
    }

    public static String mid(TreeNode root,String s) {
        if (null != root) {
            mid(root.left, s);
            s+=root.val;
            mid(root.right, s);
        }
        return s;
    }

}
