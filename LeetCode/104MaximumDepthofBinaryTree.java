/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

//BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode t = queue.poll();
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            depth++;
        }
        return depth;
    }
}


/*
//DFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        while(stack.size() != 0) {
            TreeNode t = stack.pop();
            int tmp = value.pop();
            depth = Math.max(depth, tmp);
            if(t.left != null) {
                stack.push(t.left);
                value.push(tmp + 1);
            }
            if(t.right != null) {
                stack.push(t.right);
                value.push(tmp + 1);
            }
        }
        return depth;
    }
}
*/