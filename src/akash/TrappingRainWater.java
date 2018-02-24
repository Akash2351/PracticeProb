package akash;

/**
 * Created by akash on 23-02-2018.
 */
public class TrappingRainWater {


/*Given n non-negative integers representing an elevation map where the
width of each bar is 1, compute how much water it is able to trap after raining.
  For example,
  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/

    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        int maxSeenSoFar = 0;
        int minSeenLeft = 0;
        int[] maxSeenRight = new int[height.length];
        int res = 0;

        //calculate the height of water on top of each tower
        // this is possible only  if the height of current tower is less
        // then any one on its left, and any one on its right...

        //for given tower i, maxSeenRight[i] gives the highest tower to its right...
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxSeenSoFar) {
                maxSeenSoFar = height[i];
            }
            maxSeenRight[i] = maxSeenSoFar;
        }
        //for given tower i, minSeenLeft gives the lowest tower to its left...
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(minSeenLeft, maxSeenRight[i]) - height[i]);
            if (height[i] > minSeenLeft) {
                minSeenLeft = height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
