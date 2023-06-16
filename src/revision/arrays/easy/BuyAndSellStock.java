package revision.arrays.easy;

public class BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < buy) {
                buy = prices[i];
                continue;
            }
            if (buy < prices[i]) {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}
