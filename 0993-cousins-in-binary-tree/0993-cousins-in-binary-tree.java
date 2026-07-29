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
        int par;

        Pair(TreeNode node, int par){
            this.node = node;
            this.par = par;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer,Integer> level = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,-1));

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                TreeNode node = q.peek().node;
                level.put(node.val,q.peek().par);

                if(node.left != null){
                    q.offer(new Pair(node.left,node.val));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right,node.val));
                }

                q.poll();
            }

            if(level.containsKey(x) && level.containsKey(y)) {
                // check their parent are not same if same return false
                if(level.get(x) == level.get(y)) return false;

                break;
            }

            // if that level contains only one value that means their depth are different
            if(level.containsKey(x)) return false;
            if(level.containsKey(y)) return false;

            level.clear();
        }

        return true;
    }
}