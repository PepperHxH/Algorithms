class Solution {
    int[][] direction = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int x, int y, char[][] grid) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') return;
        grid[x][y] = '0';
        for(int[] d : direction) {
            dfs(x + d[0], y + d[1], grid);
        }
        return;
    }

}