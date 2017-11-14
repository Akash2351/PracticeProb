package akash;

/**
 * Created by akash on 14-11-2017.
 */
public class StockBuySell2 {


    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
        }

        return total;
    }
}
