class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int el:nums){
            if(el % k == 0){
                set.add(el);
            }
        }

        int val = k;
        while(true){

            if(!set.contains(val)){
                return val;
            }

            val += k;
        }

    }
}