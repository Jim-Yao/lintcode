package lintcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        stack.add(curr);
        while (!stack.isEmpty()) {
            while (curr != null && curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }
            //Pop the top node: the curr node
            curr = stack.pop();
            rst.add(curr.val);
            //Move to right node, and push to stack if needed
            curr = curr.right;
            if (curr!= null) {
                stack.push(curr);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        binaryTreeInorderTraversal.new TreeNode(1);

    }
}
