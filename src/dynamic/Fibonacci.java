/**
 * Created by Chiru on Dec 29, 2016
 */
package dynamic;

//Printing n fibonacci numbers
//Running Time is O(n)
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int[] fibNumbers = new int[n + 1];
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fib(i, fibNumbers));
    }

    public static int fib(int n, int[] fibNumbers) {

        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (fibNumbers[n] > 0)
            return fibNumbers[n];
        else {
            fibNumbers[n] = fib(n - 1, fibNumbers) + fib(n - 2, fibNumbers);
            return fibNumbers[n];
        }
    }
}