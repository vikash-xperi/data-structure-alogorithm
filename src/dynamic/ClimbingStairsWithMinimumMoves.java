package dynamic;

public class ClimbingStairsWithMinimumMoves {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solve(n));
    }
    private static int solve(int n) {
        int[] dp = new int[n + 1];
        if (n == 1 || n == 2)
            return 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + 1;
        }
        return dp[n];
    }
}
