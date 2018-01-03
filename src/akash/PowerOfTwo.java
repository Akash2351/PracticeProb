package akash;

/**
 * Created by akash on 03-01-2018.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
            if (cnt > 1) return false;
        }
        return true;
    }
}
