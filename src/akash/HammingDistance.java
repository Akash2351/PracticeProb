package akash;

/**
 * Created by akash on 03-11-2017.
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        //xor to get the no formed with different bits.
        int xor = x ^ y, count = 0;
        // 1 ^ 4 => 5..find the no of ones in 5...
        while (xor != 0) {
            if ((xor & 1) == 1)
                count++;
            xor = xor >> 1;
        }
        return count;
    }
}
