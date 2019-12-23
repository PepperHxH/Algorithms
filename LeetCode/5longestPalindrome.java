//Reference Solution
class Solution {
    private int lo = 0, hi = 0, sum = 0;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        
        if(len <= 1) return s;
        
        for(int i = 0; i < len - 1; i++) {
            extendStr(s, i, i);
            extendStr(s, i, i+1);
        }
        return s.substring(lo, hi+1);
    }
    
    public void extendStr(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(j - i - 1 > sum) {
            sum = j - i - 1;
            lo = i + 1;
            hi = j - 1;
        }
    }
}
