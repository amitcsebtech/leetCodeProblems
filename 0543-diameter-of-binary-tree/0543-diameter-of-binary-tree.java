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
    int ans = 0;
    // this method only return the depth of node
    private int findDiameter(TreeNode root){
        if(root == null) return 0;

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        ans = Math.max(left+right,ans);

        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);

        return ans;
    }
}