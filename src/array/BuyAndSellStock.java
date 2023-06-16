package array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                profit = Math.max(prices[i] - buy, profit);
            }
        }
        return profit;
    }
}
