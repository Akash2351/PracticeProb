package akash;

import java.util.Arrays;

/**
 * Created by akash on 09-11-2017.
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        /*note  the sequence
        0 -> 0000   -> 0
        1 -> 0001   -> 1  (0 +1%2)
        2 -> 0010   -> 1  (1 +2%2)
        3 -> 0011   -> 2  (1 +3%2)
        4 -> 0100   -> 1  (1 +4%2)
        5 -> 0101   -> 1  (1 +5%2)
            res[i] = res[i / 2] + i % 2;
        */

        for (int i = 1; i <= num; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}
