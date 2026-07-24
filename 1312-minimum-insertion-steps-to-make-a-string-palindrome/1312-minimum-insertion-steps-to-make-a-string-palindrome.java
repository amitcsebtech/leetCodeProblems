class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int k=1; k<n; k++){
            int i = 0;
            int j = k;

            while(j < n){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]);
                }
                i++;
                j++;
            }
        }


        return dp[0][n-1];
    }
}