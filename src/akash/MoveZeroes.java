package akash;

import java.util.Arrays;

/**
 * Created by akash on 09-11-2017.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arry = new int[]{0, 1, 0, 0, 3, 5};
        moveZeroes(arry);
        System.out.println(Arrays.toString(arry));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        //index j will hold only non zero nums,
        //starting from the beginning...
        //keep swapping filling nums at j index...
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        //brute force way - double loop...
        /*int len = nums.length;
        for(int i=0; i<len;i++){
            if(nums[i]==0){
                for(int j=i+1; j<len;j++){
                    if(nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }*/
    }
}
