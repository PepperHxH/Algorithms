//递归的dfs方法
class Solution {
    int[][] direction = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int m, n;

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n-1, board);
        }
        for(int i = 0; i < n; i++) {
            dfs(0, i, board);
            dfs(m-1, i, board);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    public void dfs(int i, int j, char[][] board) {
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return ;
        board[i][j] = 'T';
        for(int[] d : direction) {
            dfs(i + d[0], j + d[1], board);
        }
        return ;
    }
}

/*
//用队列实现的bfs方法 效率低一些
class Solution {
    int[][] direction = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int m, n;

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == 'O') {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while(queue.size() != 0) {
                        int size = queue.size();
                        board[i][j] = 'T';
                        while(size-- > 0) {
                            int[] tmp = queue.poll();
                            for(int[] d : direction) {
                                int x = tmp[0] + d[0];
                                int y = tmp[1] + d[1];
                                if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') continue;
                                queue.offer(new int[]{x, y});
                                board[x][y] = 'T';
                            }
                        }
                    }
                }
            }
        }
            
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}
*/

