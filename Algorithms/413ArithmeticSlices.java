class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(A == null || n == 0) return 0;
        int[] dp = new int[n];
        for(int i = 2; i < n; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int  res = 0;
        for(int cnt : dp) {
            res += cnt;
        }
        return res;
    }
}