package revision.arrays.easy;

public class BuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{6,1,3,2,4,7}));
    }

    private static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        boolean hold = true;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (!hold) {
                if (profit < prices[i] - buy) {
                    profit = prices[i] - buy;
                } else {
                    buy = prices[i];
                    hold = true;
                    maxProfit += profit;
                }
            }else if (buy > prices[i]) {
                buy = prices[i];
            }else if (buy < prices[i]) {
                profit += prices[i] - buy;
                hold = false;
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
