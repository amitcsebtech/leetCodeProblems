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
    private void dfs(TreeNode root,int sum, int targetSum, List<List<Integer>> ans,List<Integer> pathSum){

        if(root.left == null && root.right == null){

            sum += root.val;
            if(sum == targetSum){
                pathSum.add(root.val);
                ans.add(new ArrayList<>(pathSum));
                pathSum.remove(pathSum.size()-1);
            }

            return;
        }

        pathSum.add(root.val);
        sum += root.val;
        if(root.left != null){
            dfs(root.left,sum,targetSum,ans,pathSum);
        }
        if(root.right != null){
            dfs(root.right,sum,targetSum,ans,pathSum);
        }

        pathSum.remove(pathSum.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pathSum = new ArrayList<>();
        dfs(root,0,targetSum,ans,pathSum);

        return ans;
    }
}