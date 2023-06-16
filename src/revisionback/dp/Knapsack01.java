package revisionback.dp;

public class Knapsack01 {
    public static void main(String[] args) {
        System.out.println(knapsack(10, new int[]{1,3,4,6}, new int[]{20,30,10,50}));
    }

    private static int knapsack(int w, int[] weights, int[] value) {
        int[][] dp = new int[weights.length + 1][w + 1];
        for (int i = 0; i <= w; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= weights.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][w];
    }
}
