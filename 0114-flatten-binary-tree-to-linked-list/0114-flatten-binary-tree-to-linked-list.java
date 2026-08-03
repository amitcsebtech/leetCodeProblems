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

//  first solution is we can simply store all node in queue with the help of preorder traversal and then added all node to its right pointer and make left pointer to null


class Solution {
    TreeNode nextRight = null;

    public void flatten(TreeNode root) {
        if(root == null) return ;
        
        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}