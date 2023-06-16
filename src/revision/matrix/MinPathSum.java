package revision.matrix;

public class MinPathSum {
    public static void main(String[] args) {
        System.out.print(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    private static int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
