package akash;

/**
 * Created by akash on 14-11-2017.
 */
public class NoOfBits {

    public static void main(String[] args) {
        NoOfBits bits = new NoOfBits();
        System.out.println(bits.hammingWeight(123));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            // use >>> for unsigned bit shifting
            // >> for signed bit shifting
            n = n >>> 1;
        }
        return count;
    }
}
