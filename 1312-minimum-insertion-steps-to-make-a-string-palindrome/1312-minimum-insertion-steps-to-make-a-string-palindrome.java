class Solution {
    private int f1(String s, int l, int r, int[][] dp){
        if(dp[l][r] != -1){
            return dp[l][r];
        }

        if(l >= r) return dp[l][r] = 0;

        if(s.charAt(l) == s.charAt(r)){
            return dp[l][r] = f1(s,l+1,r-1,dp);
        }

        int cl = 1 + f1(s,l+1,r,dp);
        int cr = 1 + f1(s,l,r-1,dp);

        return dp[l][r] = Math.min(cl,cr);
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        return f1(s,0,n-1,dp);
    }
}