class Solution {
    int n;
    public int findCircleNum(int[][] M) {
        n = M.length;
        boolean[] hasVisited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!hasVisited[i]) {
                dfs(M, i, hasVisited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for(int k = 0; k < n; k++) {
            if(M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}