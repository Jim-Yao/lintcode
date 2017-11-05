package lintcode;

import java.util.ArrayList;

public class BST2 {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        dfs(root, 0, result);
        return result;
    }
    public static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> rst) {
        if (root == null) {
            return;
        }
        if (level >= rst.size()) {
            rst.add(0, new ArrayList<Integer>());
        }
        dfs(root.left, level + 1, rst);
        dfs(root.right, level + 1, rst);
        rst.get(rst.size() - level - 1).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20 = new TreeNode(20);
        tn3.left = tn9;
        tn3.right = tn20;

        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);
        tn20.left = tn15;
        tn20.right = tn7;

        levelOrderButtom(tn3);
    }
}
