class Solution {
    public int maxProduct(int n) {
        int firstDigit = -1;
        int secondDigit = -1;
        while(n != 0){
            int r = n % 10;
            n /= 10;

            if(r > firstDigit){
                secondDigit = firstDigit;
                firstDigit = r;
            }
            else{
                secondDigit = Math.max(secondDigit,r);
            }

        }

        return firstDigit * secondDigit;
    }
}