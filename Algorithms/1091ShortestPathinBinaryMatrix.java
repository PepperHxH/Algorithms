class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        int[][] direction = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int res = 1;
        while(queue.size() != 0) {
            int cnt = queue.size();
            while(cnt-- > 0) {
                int[] pair = queue.poll();
                if(pair[0] == m-1 && pair[1] == n-1) return res;
                for(int[] d : direction) {
                    int cx = pair[0] + d[0];
                    int cy = pair[1] + d[1];
                    if(cx >= 0 && cx < m && cy >= 0 && cy < n && grid[cx][cy] == 0) {
                        queue.add(new int[]{cx, cy});
                        grid[cx][cy] = 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}