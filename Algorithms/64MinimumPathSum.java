//二维数组
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1) {
                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
                } else if(j == 1) {
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
                } else {
                    dp[i][j] = Math.min((dp[i][j-1] + grid[i-1][j-1]), (dp[i-1][j] + grid[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}


/*
//一维数组
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0) return 0;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    dp[j] = dp[j];
                } else if(i == 0) {
                    dp[j] = dp[j-1];
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n-1];
    }
}
*/