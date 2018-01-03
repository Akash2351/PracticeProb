package akash;

/**
 * Created by akash on 03-01-2018.
 */
public class PowerOfThree {

    //check if a no is power of 3.

    public boolean isPower(int n) {
        if (n < 0) return false;
        while (n % 3 == 0) n = n / 3;
        return n == 1;
    }

    public boolean isPowerRecursive(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerRecursive(n / 3)));
    }
}
