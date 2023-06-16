package revisionback.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int n = 18;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println(minCoinChange(n, new int[]{7, 5, 1}, dp));
    }

    private static int minCoinChange(int n, int[] coins, int[] dp) {
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (n - coins[i] >= 0) {
                int subAns = 0;
                if (dp[n - coins[i]] != -1) {
                    subAns = dp[n - coins[i]];
                } else {
                    subAns = minCoinChange(n - coins[i], coins, dp);
                }
                ans = Math.min(ans, subAns + 1);
            }
        }
        return dp[n] = ans;
    }
}
