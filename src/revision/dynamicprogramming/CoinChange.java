package revision.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.print(coinChange(new int[]{186,419,83,408}, 6249));
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        if (coins[0] > amount) {
            return -1;
        }
        dp[0] = 0;
        for (int i = 1; i < coins[0]; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                int idx = j - coins[i];
                if (dp[idx] != -1) {
                    dp[j] = dp[idx] + 1;
                } else {
                    dp[j] = -1;
                }
            }
        }
        return dp[amount];
    }
}
