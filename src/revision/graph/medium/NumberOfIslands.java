package revision.graph.medium;

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'},
                                                    {'1','1','0','0','0'},
                                                    {'0','0','1','0','0'},
                                                    {'0','0','0','1','1'}}));
    }

    private static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0' && !visited[i][j]) {
                    dfs(grid, i, j, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void dfs(char[][] grid, int r, int c, int m, int n, boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (isSafe(grid, nr, nc, m, n, visited)) {
                dfs(grid, nr, nc, m, n, visited);
            }
        }
    }

    private static boolean isSafe(char[][] grid, int r, int c, int m, int n, boolean[][] visited) {
        if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == '1') return true;
        return false;
    }
}
