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
    boolean present;
    private boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null && subRoot != null) return false;
        if(root != null && subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }
    private void f1(TreeNode root, TreeNode subRoot){
        if(root == null) return ;

        if(root.val == subRoot.val){
            if(check(root,subRoot)){
                present = true;
            }
        }

        if(!present){
            f1(root.left,subRoot);
            f1(root.right,subRoot);
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        present = false;
        f1(root,subRoot);

        return present;
    }
}