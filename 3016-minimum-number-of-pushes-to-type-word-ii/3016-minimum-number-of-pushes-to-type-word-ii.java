class Solution {
    private void reverse(int[] arr){
        int n = arr.length;
        int halfLen = n / 2;

        for(int i=0; i<halfLen; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        int n = word.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);
        reverse(freq);

        // we need more freq character first because they use more time keys and less freq char use key less time so need at last

        for(int i=0; i<26; i++){
            if(i < 8){
                ans += freq[i] * 1;
            }
            else if(i < 16){
                ans += freq[i] * 2;
            }
            else if(i < 24){
                ans += freq[i] * 3;
            }
            else{
                ans += freq[i] * 4;
            }
        }

        return ans;
    }
}