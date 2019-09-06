package season2.top_100;

import java.util.Arrays;

/**
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 */
public class CountingBits {

    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int res[] = new int[num + 1];
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

        for (int n = 1; n <= num; n++) {
            if (n % 2 == 0)
                res[n] = res[n / 2];
            else
                res[n] = res[n / 2] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(5)));
    }
}
