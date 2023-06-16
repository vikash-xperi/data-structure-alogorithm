package revisionback.array;

public class BestTimeToSellStock1 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
