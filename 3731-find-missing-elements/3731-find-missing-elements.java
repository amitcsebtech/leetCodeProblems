class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = nums[0];
        int max = nums[0];
        List<Integer> ans = new ArrayList<>();

        for(int el:nums){
            min = Math.min(min,el);
            max = Math.max(max,el);

            set.add(el);
        }

        for(int i=min; i<=max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}