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
//  here we are using top down method 

class Solution {
    private boolean f1(TreeNode root, int targetSum){
        if(root.left == null && root.right == null){
            return targetSum == root.val ? true : false;
        }

        boolean left = false;
        boolean right = false;

        if(root.left != null){
            left = f1(root.left,targetSum-root.val);
        }
        if(root.right != null){
            right = f1(root.right,targetSum-root.val);
        }
        return left || right ;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return f1(root,targetSum);
    }
}