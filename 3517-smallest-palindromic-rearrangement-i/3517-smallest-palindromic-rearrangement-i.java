class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        int halfLen = n / 2;
        char[] ch = new char[halfLen];

        for(int i=0; i<halfLen; i++){
            ch[i] = (s.charAt(i));
        }

        Arrays.sort(ch);

        StringBuilder ans = new StringBuilder();
        ans.append(ch);
        if(n % 2 != 0){
            ans.append(s.charAt(halfLen));
        }
        int len = halfLen/2;

        for(int i=0; i<len; i++){
            char t = ch[i];
            ch[i] = ch[halfLen-1-i];
            ch[halfLen-1-i] = t;
        }
     
        ans.append(ch);


        return ans.toString();
    }
}