package akash;

import java.util.Arrays;

/**
 * Created by akash on 14-11-2017.
 */
public class OnePlus {

    public static void main(String[] args) {
        OnePlus op = new OnePlus();
        System.out.println(Arrays.toString(op.plusOne(new int[]{1, 3, 9})));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        //traverse from the last digit,
        //if not 9, add one to it and send...
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            //last digit is 9, make 0, carry over 1.
            // 1 is added by default, no need for carry.
            digits[i] = 0;
        }

        //if we have come here, it means array is all 9's..
        int[] ret = new int[len + 1];
        ret[0] = 1;

        return ret;
    }
}
