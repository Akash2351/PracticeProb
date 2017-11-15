package akash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by akash on 15-11-2017.
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(18));
    }

    public static boolean isHappy(int n) {
        if (n == 1)
            return true;

        Set<Integer> set = new HashSet<>();
        int remain = 0;
        //repeat until product is unique..
        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n = n / 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }
        return false;
    }
}
