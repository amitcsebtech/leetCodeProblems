class Solution {
    private int digitSum(int n){
        int sum = 0;

        while(n != 0){
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }

        return sum;
    }
    private int digitProduct(int n){
        int prod = 1;

        while(n != 0){
            int rem = n % 10;
            prod *= rem;
            n /= 10;
        }

        return prod;
    }
    public boolean checkDivisibility(int n) {
        int sum = digitSum(n);
        int product = digitProduct(n);
        int d = product + sum;

        return n % d == 0;
    }
}