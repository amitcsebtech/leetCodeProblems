class Solution {
    private void addAllOutgoing(List<List<Integer>> outgoingEdge,Set<Integer> set, int k,boolean[] vis){
        set.add(k);
        vis[k] = true;
        int s = outgoingEdge.get(k).size();

        for(int i=0; i<s; i++){
            int ng = outgoingEdge.get(k).get(i);
            if(!vis[ng]){
                addAllOutgoing(outgoingEdge, set, ng, vis);
            }
        }

    }

    private boolean checkAnyIncoming(List<List<Integer>> incomingEdge, Set<Integer> set){

        for(Integer val: set){
            int s = incomingEdge.get(val).size();
            for(int i=0; i<s; i++){
                int ng = incomingEdge.get(val).get(i);
                if(!set.contains(ng)){
                    return false;
                }
            }
        }

        return true;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> incomingEdge = new ArrayList<>();
        List<List<Integer>> outgoingEdge = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            incomingEdge.add(new ArrayList<>());
            outgoingEdge.add(new ArrayList<>());
        }
        int len = invocations.length;

        for(int i=0; i<len; i++){
            int a = invocations[i][0];
            int b = invocations[i][1];

            incomingEdge.get(b).add(a);
            outgoingEdge.get(a).add(b);
        }

        addAllOutgoing(outgoingEdge , set , k, vis);
        boolean flag = checkAnyIncoming(incomingEdge, set);

        if(flag){
            for(int i=0; i<n; i++){
                if(!set.contains(i)){
                    ans.add(i);
                }
            }   
        }
        else{
            for(int i=0; i<n; i++){
                ans.add(i);
            }   
        }
        

        return ans;
    }
}