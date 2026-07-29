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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return List.of();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int l = 0;

        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<s; i++){
                TreeNode node = q.peek();
                level.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

                q.poll();
            }
            if(l % 2 != 0)
            Collections.reverse(level);

            ans.add(level);
            l++;
        }

        return ans;
    }
}