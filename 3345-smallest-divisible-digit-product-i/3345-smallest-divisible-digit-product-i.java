class Solution {
    private int findDigitProduct(int n){
        int ans = 1;
        while(n != 0){
            int r = n % 10;
            ans *= r;
            n /= 10;
        }

        return ans;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            int product = findDigitProduct(n);
            if(product%t == 0) return n;
            n++;
        }

        // return -1;
    }
}