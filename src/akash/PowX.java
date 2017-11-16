package akash;

/**
 * Created by akash on 15-11-2017.
 */
public class PowX {
    public static void main(String[] args) {
        System.out.println(myPow(10, 2));
        System.out.println(myPow(10, -2));
    }

    //time complex: O(logn) - > coz reducing the calc
    //by half in each call...
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;

        double half = myPow(x, n / 2);
        // if power is even, just multiply halves n return
        if (n % 2 == 0)
            return half * half;
        else {
            //odd powers..multiply halves and x..
            if (n > 0) {
                return x * half * half;
            } else {
                // negative pow...x^-1 => 1/x ..
                return (1 / x) * half * half;
            }
        }
    }
}
