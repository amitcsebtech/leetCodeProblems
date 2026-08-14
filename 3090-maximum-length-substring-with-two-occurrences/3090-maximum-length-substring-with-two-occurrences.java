class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int ans = 0;

        while(r < n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            while(map.get(s.charAt(r)) > 2){
                if(map.get(s.charAt(l)) == 1){
                    map.remove(s.charAt(l));
                }
                else{
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                }
                l++;
            }

            ans = Math.max(ans,(r-l)+1);
            
            r++;
        }


        return ans;
    }
}