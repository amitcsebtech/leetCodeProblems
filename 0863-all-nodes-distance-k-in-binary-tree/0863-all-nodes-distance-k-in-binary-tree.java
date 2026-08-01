/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode node ,int level){
            this.node = node;
            this.level = level;
        }
    }
    private void f1(TreeNode root, TreeNode pr,Map<TreeNode,TreeNode> parent){
        if(root == null) return;

        parent.put(root,pr);
        f1(root.left,root,parent);
        f1(root.right,root,parent);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        f1(root,null,parent);

        Set<TreeNode> vis = new HashSet<>();
        vis.add(null); // this is added for queue does not contain any null value
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(target,0));
        vis.add(target);

        while(!q.isEmpty()){
            if(q.peek().level == k) break;
            int s = q.size();

            for(int i=0; i<s; i++){
                Pair p = q.peek();

                if( !vis.contains(p.node.left) ){
                    q.offer( new Pair(p.node.left , p.level+1) );
                    vis.add(p.node.left);
                }
                if( !vis.contains(p.node.right) ){
                    q.offer( new Pair(p.node.right , p.level+1) );
                    vis.add(p.node.right);
                }
                if( !vis.contains(parent.get(p.node) ) ){
                    q.offer( new Pair(parent.get(p.node) , p.level+1) );
                    vis.add(parent.get(p.node));
                }

                q.poll();

            }
        }

        if(q.isEmpty()) return List.of();

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add( q.peek().node.val );
            q.poll();
        }

        return ans;
    }
}