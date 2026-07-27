class Solution {
    public int maxProduct(int[] nums) {
        int first = -1;
        int second = -1;
        for(int el:nums){
            if(el > first){
                second = first;
                first = el;
            }
            else{
                second = Math.max(second,el);
            }
        }

        return (first-1) * (second-1);
    }
}