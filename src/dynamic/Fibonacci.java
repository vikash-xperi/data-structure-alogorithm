package dynamic;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        long[] dp = new long[n + 1];
//        System.out.println(solve(n, dp));
        System.out.println(tabulationMethod(n));
    }

    private static long solve(int n, long[] dp) {
        if (n <= 2) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }

    public static int tabulationMethod(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
