package revision.matrix;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalSquare(matrix));
    }

    private static int maximalSquare(char[][] matrix) {
        int maxSquare = 1;
        boolean flag = false;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; --i) {
            for (int j = matrix[i].length - 1; j >= 0; --j) {
                if (i == matrix.length - 1 || j == matrix[i].length - 1) {
                    if (matrix[i][j] == '1') {
                        flag = true;
                    }
                    dp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                } else if (matrix[i][j] == '1') {
                    flag = true;
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        if (!flag) return 0;
        return maxSquare * maxSquare;
    }
}
