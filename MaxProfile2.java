package lintcode;

public class MaxProfile2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int start = 0;
        int peek = 0;
        while (start < prices.length - 1) {
            peek = start + 1;
            while (peek < prices.length && prices[peek - 1] <= prices[peek]) {
                peek++;
            }
            profit += prices[peek - 1] - prices[start];
            start = peek;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a ={2,1,2,0,1};
        MaxProfile2 maxProfile2 = new MaxProfile2();
        maxProfile2.maxProfit(a);

    }    
}
