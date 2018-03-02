package akash;

import java.util.Arrays;

/**
 * Created by akash on 01-03-2018.
 */
public class JumpGame {

//Similar to min jumps needed to reach end of array..
/* Given an array of non-negative integers, you are initially
 positioned at the first index of the array.

    Each element in the array represents your maximum jump
    length at that position.
   Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.*/

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        if (nums[0] == 0) return false;

        int[] minJumps = new int[nums.length];
        //initialize all to inifinity, except 0...
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + nums[j]) {// within range, can jump
                    if (minJumps[j] != Integer.MAX_VALUE)
                        minJumps[i] = Math.min(minJumps[i], minJumps[j] + 1);
                }
            }
        }

        //cannot reach till there...
        if (minJumps[nums.length - 1] == Integer.MAX_VALUE)
            return false;

        return true;
    }

    public static void main(String[] args) {
        JumpGame gm = new JumpGame();
        System.out.println(gm.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(gm.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(gm.canJump(new int[]{1, 0, 0, 1, 1, 2, 2, 0, 2, 2}));
    }
}
