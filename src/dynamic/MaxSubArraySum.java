/**
 * Created by Chiru on Jan 13, 2017
 */
package dynamic;

// scan through the array values,
//computing at each position the maximum (positive sum) subarray ending at that position
public class MaxSubArraySum {

    public static void main(String[] args) {
        int arr[] = {1, -2, 5, 4, -3, 5};
        System.out.println(maxSubArraySum(arr));
    }

    public static int maxSubArraySum(int[] arr) {

        int maxSumEndingHere = 0;
        int maxSumSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxSumEndingHere = maxSumEndingHere + arr[i];

            if (maxSumEndingHere > maxSumSoFar) {
                maxSumSoFar = maxSumEndingHere;
            }
            if (maxSumEndingHere < 0)
                maxSumEndingHere = 0;
        }
        return maxSumSoFar;
    }
}