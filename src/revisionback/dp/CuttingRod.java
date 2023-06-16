package revisionback.dp;

public class CuttingRod {
    public static void main(String[] args) {
        System.out.println(maxPrice(new int[]{1,5,6,9,11,12,14,16}));
    }

    private static int maxPrice(int[] prices) {
        int[] dp = new int[prices.length + 1];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
            }
        }
        return dp[prices.length];
    }
}
