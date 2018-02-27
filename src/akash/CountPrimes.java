package akash;

import java.util.Arrays;

/**
 * Created by akash on 26-02-2018.
 */
public class CountPrimes {

    // Count the number of prime numbers less than a non-negative number, n.
    public int countPrimes(int n) {
        if (n < 3) return 0;
        if (n == 3) return 1;

        boolean[] nos = new boolean[n];
        Arrays.fill(nos, true);
        int primes = 0;

        //seive of eraothothenes method..
        //for 2 to srqt(n), make its multiples false...
        //remaining will be primes..
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            int idx = 2;
            while (i * idx < n) {
                nos[i * idx] = false;
                idx++;
            }
            ;
        }
        for (int i = 2; i < n; i++) {
            if (nos[i]) primes++;
        }
        return primes;
    }
}
