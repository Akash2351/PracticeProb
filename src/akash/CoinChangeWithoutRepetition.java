package akash;

import java.util.Arrays;

/**
 * Created by akash on 01-03-2018.
 */
public class CoinChangeWithoutRepetition {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            //for without repetition, start from amount=max and decrease..
            //for with repetition, start from amount =0 and increase
            for (int j = amount; j >= 1; j--) {
                if (coins[i] <= j && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeWithoutRepetition cc = new CoinChangeWithoutRepetition();
        System.out.println(cc.coinChange(new int[]{1, 2, 3, 4}, 9));
        System.out.println(cc.coinChange(new int[]{1, 2, 3, 4}, 11));
    }
}
