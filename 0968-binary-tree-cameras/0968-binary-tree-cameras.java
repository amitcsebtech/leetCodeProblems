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

//  1 means i need camera , 2 i have camera and 3 i do not need camera

class Solution {
    int ans;
    private int findResult(TreeNode root){
        if(root == null) return 3;

        int left = findResult(root.left);
        int right = findResult(root.right);

        if(left == 1 || right == 1){
            ans++;
            return 2;
        }

        if(left == 2 || right == 2){
            return 3;
        }

        
        return 1;

    }
    public int minCameraCover(TreeNode root) {
        ans = 0;
        int result = findResult(root);
        if(result == 1) ans++;

        return ans;
    }
}