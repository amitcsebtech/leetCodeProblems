class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0;
        int zero = 0; // this will contains the count of maximum zero that converted to 1
        int leftZero = 0;
        int rightZero = 0;
        int currOne = 0;
        char[] arr = s.toCharArray();

        for(char ch : arr){
            if(ch == '0' && currOne == 0){
                leftZero += 1;
            }
            if(ch == '0' && currOne != 0){
                rightZero += 1;
            }

            if(ch == '1' && rightZero == 0){
                ans++;
                currOne += 1;
            }

            if(ch == '1' && rightZero != 0){
                if(leftZero != 0){
                    zero = Math.max(zero, (leftZero+rightZero) );
                }

                leftZero = rightZero;
                currOne = 1;
                rightZero = 0;
                ans++;
                
            }
        }

        if(leftZero != 0 && rightZero != 0){
            zero = Math.max(zero, (leftZero+rightZero) );
        }

        return ans + zero;
    }
}


// hint according to problem statement what we did understand count all one and add the count of maximum zero that will converted to 1