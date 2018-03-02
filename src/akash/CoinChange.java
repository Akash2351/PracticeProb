package akash;

import java.util.Arrays;

/**
 * Created by akash on 01-03-2018.
 */
public class CoinChange {

/* You are given coins of different denominations and a
total amount of money amount. Write a function to compute
 the fewest number of coins that you need to make up that amount.
  If that amount of money cannot be made up by any combination
   of the coins, return -1.
    Example 1:
    coins = [1, 2, 5], amount = 11
            return 3 (11 = 5 + 5 + 1)

    Example 2:
    coins = [2], amount = 3
            return -1.
    Note:
    You may assume that you have an infinite number of each kind of coin.*/

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            //for with repetition, start from amount =0 and increase
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(cc.coinChange(new int[]{2, 5}, 13));
    }
}
