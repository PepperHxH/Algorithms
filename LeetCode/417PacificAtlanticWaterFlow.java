class Solution {
    int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] reachP = new boolean[m][n];
        boolean[][] reachA = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            dfs(i, 0, matrix, reachP);
            dfs(i, n-1, matrix, reachA);
        }
        for(int i = 0; i < n; i++) {
            dfs(0, i, matrix, reachP);
            dfs(m-1, i, matrix, reachA);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(reachP[i][j] && reachA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, int[][] matrix, boolean[][] b) {
        if(b[i][j]) {
            return;
        }
        b[i][j] = true;
        for(int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] < matrix[i][j]) continue;
            dfs(x, y, matrix, b);
        }
        return;
    }

}