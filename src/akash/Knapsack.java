package akash;

import java.util.Arrays;

/**
 * Created by akash on 01-03-2018.
 */
public class Knapsack {

   /* Given a bag which can only take certain weight W.
    Given list of items with their weights and price.
     How do you fill this bag to maximize value of items in the bag.*/

    //0-1 knapsack problem
    /* consider the example, W = 7, wt[] = {1,3,4,5}, val[]={1,4,5,7}
    using DP to solve this... needs 2d matrix

    cols - weight 1 to w
    rows - each item weight

            --- weight 0 to W ----
          0  1  2  3  4  5  6  7
  wt[] 1  0  1  1  1  1  1  1  1  // item[0] can be used only 1 time..val is 1
       3  0  1  1  4  5  5  5  5  // if wt[i]> W, use previous row value..
       4  0  1  1  4  5  6  6  9  //dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i]]+val[i])
       5  0  1  1  4  5  7  8  9
     o/p: 9
     */
    public int knapsackWithoutRepetition(int weight, int n, int[] wt, int[] val) {
        if (weight == 0 || n == 0) return 0;

        int[][] dp = new int[n][1 + weight];
        //initialize values
        for (int j = 0; j < n; j++)
            dp[j][0] = 0;

        //initialize first row...
        for (int i = 1; i < n; i++)
            if (wt[0] <= i) dp[0][i] = val[0];


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (wt[i] > j) {
                    // cannot add this item, its heavy..
                    //use previous row values.
                    dp[i][j] = i > 0 ? dp[i - 1][j] : 0;
                } else {
                    //consider this item... with or without..
                    dp[i][j] = Math.max(dp[i - 1][j],  //without item
                            dp[i - 1][j - wt[i]] + val[i]);  //with item
                }
            }
        }

        return dp[n - 1][weight];
    }

   /* Consider the case when repetition of items are allowed
   *  we need 1d array to solve this..
   *  W = 7, wt[] = {1,3,4,5}, val[]={1,4,5,7}
   *
   *     0  1  2  3  4  5  6  7
   *     0  1  2  3  4  5  6  7  - when coin[0] is only consider
   *
   *     0  1  2  4  5  6  8  9 - when coins[0,1] are considered
   *     0  1  2  4  5  6  8  9 - when coins[0,1,2] are considered
   *     0  1  2  4  5  7  8  9 - when coins[0,1,2,3] are considered
   * o/p: 9
   * */

    public int knapsackWithRepetition(int weight, int n, int[] wt, int[] val) {
        if (weight == 0 || n == 0) return 0;

        int[] dp = new int[1 + weight];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (wt[i] <= j) {  //consider the item
                    dp[j] = Math.max(dp[j], //dont consider the item
                            dp[j - wt[i]] + val[i]);  //consider the item
                }
            }
        }
        return dp[weight];
    }

    public static void main(String[] args) {
        Knapsack kp = new Knapsack();
        System.out.println(kp.knapsackWithoutRepetition(7, 4, new int[]{1, 3, 4, 5},
                new int[]{1, 4, 5, 7}));
        System.out.println(kp.knapsackWithRepetition(7, 4, new int[]{1, 3, 4, 5},
                new int[]{1, 4, 5, 7}));

    }
}
