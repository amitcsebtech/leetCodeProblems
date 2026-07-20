// generate all subsequence and check all string they contains all character once and store that also compare with other string which statisfy the above condition that is all character must be distinct


// now we have solve this problem in optimise way
class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();
        
        for(char ch:arr){
            freq[ch-'a']++;
        }

        for(char ch:arr){
            while(!st.isEmpty() && !vis[ch-'a'] && ch < st.peek() && freq[st.peek()-'a'] >= 1){
                vis[st.pop()-'a'] = false;
            }

            if(!vis[ch-'a']){
                vis[ch-'a'] = true;
                st.add(ch);
                freq[ch-'a'] -= 1;
            }
            else{
                freq[ch-'a'] -= 1;
            }
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        return ans.toString();
    }
}