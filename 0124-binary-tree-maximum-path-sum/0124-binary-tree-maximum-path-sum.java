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
    int ans;
    private int f1(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int left = f1(root.left);
        int right = f1(root.right);

        ans = Math.max(ans,left);
        ans = Math.max(ans,right);

        if(left == Integer.MIN_VALUE) left = 0;
        if(right == Integer.MIN_VALUE) right = 0;

        int maxSub = Math.max(left,right);

        ans = Math.max(ans,root.val+maxSub);
        ans = Math.max(ans,root.val);

        ans = Math.max(ans,(root.val+left+right));

        return Math.max(root.val,(root.val + maxSub));
    }
    
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        f1(root);

        return ans;
    }
}