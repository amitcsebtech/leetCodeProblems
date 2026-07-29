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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();
            double level = 0;

            for(int i=0; i<s; i++){
                TreeNode node = q.peek();
                level += node.val;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

                q.poll();
            }

            ans.add(level/s);
        }

        return ans;
    }
}