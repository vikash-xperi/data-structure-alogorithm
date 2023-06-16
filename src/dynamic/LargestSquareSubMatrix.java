package dynamic;

public class LargestSquareSubMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 1, 0, 1},
                          {1, 0, 1, 0, 1, 0},
                          {0, 1, 1, 1, 1, 0},
                          {0, 0, 1, 1, 1, 0},
                          {1, 1, 1, 1, 1, 1}};
        System.out.println(solve(matrix));
    }

    private static int solve(int[][] arr) {
        int maxSize = 0;
        int row = arr.length, col = arr[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = arr[i][j];
                } else if (arr[i][j] != 0 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0 && dp[i - 1][j - 1] != 0) {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                } else {
                    dp[i][j] = arr[i][j];
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }
}
