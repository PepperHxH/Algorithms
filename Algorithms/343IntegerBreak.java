//动规解法
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
            }
        }
        return dp[n];
    }
}


/*
//找规律解法
class Solution {
    public int integerBreak(int n) {
        if(n <= 1) return 0; 
        if(n == 2) return 1;
        if(n == 3) return 2;
        int timeof3 = n / 3;
        if(n - timeof3 * 3 == 1) timeof3--;
        int timeof2 = (n - timeof3 * 3) / 2;
        return (int)Math.pow(2, timeof2) * (int)Math.pow(3, timeof3);
    }
}
*/