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

//  we can also solve this problem with the help of hashMap where we can store the level value in list like Map<Integer,List<Integer>> map = new TreeMap<>() where Integer store level of node and List<Integer> store the value of that level 

// but here we using bfs for solving this problem using queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<s; i++){
                TreeNode node = q.element();
                level.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

                q.poll();
            }

            ans.add(level);
        }

        return ans;
    }
}