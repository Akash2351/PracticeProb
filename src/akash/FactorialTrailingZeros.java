package akash;

/**
 * Created by akash on 15-11-2017.
 */
public class FactorialTrailingZeros {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        if (n == 0)
            return 0;

        int zeros = 0;
        //Because all trailing 0 is from factors 5 * 2.
        //find n/5 + n/25 + n/125 ...
        while (n > 0) {
            zeros = zeros + n / 5;
            n = n / 5;
        }
        return zeros;
    }
}
