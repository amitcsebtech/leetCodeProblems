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
        int row;
        int col;

        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root.left == null && root.right == null) return List.of(List.of(root.val));

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Pair>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                Pair p = q.peek();

                if(p.node.left != null){
                    q.offer(new Pair(p.node.left,p.row+1,p.col-1));
                }
                if(p.node.right != null){
                    q.offer(new Pair(p.node.right,p.row+1,p.col+1));
                }
                if(map.containsKey(p.col)){
                    List<Pair> temp = map.get(p.col);
                    temp.add(p);
                    map.put(p.col,temp);
                }
                else{
                    List<Pair> temp = new ArrayList<>();
                    temp.add(p);
                    map.put(p.col,temp);
                }

                q.poll();
            }
        }

        Set<Integer> set =  map.keySet();
        for(Integer key : set){
            List<Pair> temp = map.get(key);
            // we need sorting first based on row and if row is same then based on value
            Collections.sort(temp,(a,b)->{
                if(a.row == b.row){
                    return Integer.compare(a.node.val,b.node.val);
                }

                return Integer.compare(a.row,b.row);
            });
            List<Integer> temp2 = new ArrayList<>();
            for(Pair p:temp){
                temp2.add(p.node.val);
            }
            ans.add(temp2);
        }

        return ans;
    }
}