package lintcode;

public class MaxProfit3 {
    public int maxProfit2(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int[] local = new int[3];
        int[] global = new int[3];
        for(int i=0;i<prices.length-1;i++)
        {
            int diff = prices[i+1]-prices[i];
            for(int j=2;j>=1;j--)
            {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

    public int maxProfit1(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;

        int[] local = new int[3];
        int[] global = new int[3];
        for(int i = 1; i < prices.length; i++)
        {
            int diff = prices[i] - prices[i - 1];
            for(int j = 1; j <= 2; j++)
            {
                local[j] = Math.max(global[j - 1]+(diff>0?diff:0), local[j] + diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];
        int min = prices[0];    //Default:leftProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];    //Default:rightProfit[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, leftProfit[i] + rightProfit[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a= {4,4,6,1,1,4,2,5};

        MaxProfit3 maxProfit3 = new MaxProfit3();
        int rst = maxProfit3.maxProfit1(a);
        System.out.println(rst);
    }
}
