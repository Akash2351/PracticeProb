package akash;

import java.util.Arrays;

/**
 * Created by akash on 09-11-2017.
 */
public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    //1) Construct a temporary array left[] such that left[i] contains product
    // of all elements on left of arr[i] excluding arr[i].
    //2) Construct another temporary array right[] such that right[i] contains
    // product of all elements on on right of arr[i] excluding arr[i].
    //3) To get prod[], multiply left[] and right[].
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] result = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 0; i < len - 1; i++) {
            left[i + 1] = left[i] * nums[i];
            // left[1] = product of nums until left[2].
            //i.e left[1] = 1* nums[0].
        }

        for (int i = len - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }

        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
