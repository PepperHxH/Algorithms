/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);    
    }
    
    public boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}

/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null || t1.val != t2.val) return false;
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
    }
}
*/