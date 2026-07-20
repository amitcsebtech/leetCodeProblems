/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isBalance = true;
    private int findDepth(TreeNode root){
        if(root == null) return 0;

        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if(Math.abs(left-right) > 1) isBalance = false;

        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        findDepth(root);

        return isBalance;
    }
}