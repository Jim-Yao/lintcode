package lintcode;

public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit1 maxProfit1 = new MaxProfit1();
        int a[] = {7, 1, 5, 3, 6, 4};
        maxProfit1.maxProfit(a);
    }
}
