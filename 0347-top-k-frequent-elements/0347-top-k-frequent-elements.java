class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int[] ans = new int[k];

        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
            maxFreq = Math.max(maxFreq,map.get(el));
        }

        List<List<Integer>> bucket = new ArrayList<>();
        int s = maxFreq+1;

        for(int i=0; i<s; i++){
            bucket.add(new ArrayList<>());
        }

        Set<Integer> set = map.keySet();

        for(Integer key:set){
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }
        
        int idx = 0;

        outerLoop : for(int i=maxFreq; i>=0; i--){
            List<Integer> temp = bucket.get(i);
            for(int el:temp){
                if(idx < k){
                    ans[idx] = el;
                    idx++;
                }
                else{
                    break outerLoop;
                }
            }
        }

        return ans;
    }
}