package akash;

/**
 * Created by akash on 18-02-2018.
 */
public class ArrayRotate {

//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
// is rotated to [5,6,7,1,2,3,4].

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        //reverse array approach:
        /* 1)we have to first reverse the whole array by swapping
         first element with the last one and so on…
        you will get[7,6,5,4,3,2,1]

        2)reverse the elements from 0 to k-1
        reverse the elements 7,6,5
        you will get [5,6,7,4,3,2,1]

        3)reverse the elements from k to n-1
        reverse the elements 4,3,2,1
        you will get[5,6,7,1,2,3,4]*/

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        //second approach...using new array...
        int[] copy = nums.clone();
        for (int i = 0; i < copy.length; i++) {
            nums[(i + k) % copy.length] = copy[i];
        }
    }

    public void reverse(int[] ary, int start, int end) {
        while (start < end) {
            int temp = ary[start];
            ary[start] = ary[end];
            ary[end] = temp;
            start++;
            end--;
        }
    }
}
