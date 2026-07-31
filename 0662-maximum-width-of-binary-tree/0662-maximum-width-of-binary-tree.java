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
    class Pair{
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 1;

        int ans = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int minIdx = q.peek().idx;
            int firstIdx = -1;
            int lastIdx = -1;
            int s = q.size();

            for(int i=0; i<s; i++){
                Pair p = q.peek();

                if(i == 0){
                    firstIdx = p.idx;
                }
                if(i == s-1){
                    lastIdx = p.idx;
                }

                p.idx -= minIdx;
                if(p.node.left != null){
                    q.offer(new Pair(p.node.left,p.idx*2+1));
                }

                if(p.node.right != null){
                    q.offer(new Pair(p.node.right,p.idx*2+2));
                }

                q.poll();
            }

            ans = Math.max(ans,(lastIdx-firstIdx)+1);
        }

        return ans;
    }
}