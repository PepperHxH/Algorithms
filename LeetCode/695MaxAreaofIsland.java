class Solution {
    private int[][] direction = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    private int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, grid));
            }
        }
        return res;
    }

    public int dfs(int x, int y, int[][] grid) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        int res = 1;
        for(int[] d : direction) {
             res += dfs(x + d[0], y + d[1], grid);
        }
        return res;
    }
}