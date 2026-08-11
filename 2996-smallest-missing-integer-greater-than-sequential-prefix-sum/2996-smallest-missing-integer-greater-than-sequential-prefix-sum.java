class Solution {
    public int missingInteger(int[] nums) {
        int preSum = nums[0];
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int el:nums){
            set.add(el);
        }

        for(int i=1; i<n; i++){
            if(nums[i] - 1 == nums[i-1]){
                preSum += nums[i];
            }
            else{
                break;
            }
        }

        while(set.contains(preSum)){
            preSum++;
        }

        return preSum;
    }
}