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
    private void f1(TreeNode root, int targetSum, long sum, Map<Long,Integer> mp){
        if(root == null){
            return ;
        }

        sum += root.val;

        if(mp.containsKey(sum-targetSum)){
            ans += mp.get(sum-targetSum);
        }

        
        mp.put(sum, mp.getOrDefault(sum,0)+1);

        f1(root.left, targetSum, sum, mp);
        f1(root.right, targetSum, sum, mp);

        mp.put(sum,mp.get(sum)-1);

        if(mp.get(sum) == 0){
            mp.remove(sum);
        }

    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> mp = new HashMap<>();
        ans = 0;
        mp.put((long)0,1);
        f1(root, targetSum,0,mp);

        return ans;
    }
}