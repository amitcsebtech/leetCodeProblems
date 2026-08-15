class Solution {
    public int longestSubsequence(int[] nums) {
       int ans = 0;
       int zero = 0;

       for(int el:nums){
        ans ^= el;
        if(el == 0) zero++;
       }

       int n = nums.length;

       if(ans != 0) return n;
       if(zero == n) return 0;

       return n-1;
    }
}