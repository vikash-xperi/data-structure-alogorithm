package revision.matrix;

public class PathWithMaximumGold {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) {
        System.out.print(getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }

    private static int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxGold = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j, m, n, visited, 0));
                }
            }
        }
        return maxGold;
    }

    private static int dfs(int[][] grid, int r, int c, int m, int n, boolean[][] visited, int count) {
        visited[r][c] = true;
        count += grid[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];
            if (isSafe(grid, nr, nc, m, n, visited)) {
                return dfs(grid, nr, nc, m, n, visited, count);
            }
        }
        visited[r][c] = false;
        return count;
    }

    private static boolean isSafe(int[][] grid, int r, int c, int m, int n, boolean[][] visited) {
        if (r >= m || c >= n || r < 0 || c < 0 || visited[r][c] || grid[r][c] == 0) {
            return false;
        }
        return true;
    }
}
