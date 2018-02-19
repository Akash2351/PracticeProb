package akash;

/**
 * Created by akash on 18-02-2018.
 */
public class TargetSum {

/*    public static  int findTargetSumWaysDP(int[] nums, int S) {
        if(nums.length == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        int target = (S+sum) /2;

        int[] table = new int[target+1];
        table[0] = 1;
        for(int i=0; i< nums.length; i++){
            for(int j=target; j>=nums[i]; j--){  //for non repetition, start from higher no and decrease
            //for(int j=nums[i]; j<=target; j++){  //for repetition, start from lower no and increment
                table[j] += table[j-nums[i]];
            }
        }
        return table[target];
    }

    public static int findTargetSumWaysDP2(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    public static  int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        HashSet<String> set = new HashSet<>();
        generateRecursive(nums, S, 0, 0, "",0, set);
        System.out.println(set);
        return set.size();

    }

    public static void generateRecursive(int[] nums, int target, int cur,int index, String curStr,int loopCount, HashSet<String> set){
        if(loopCount == nums.length){
            if(target == cur) {
                set.add(curStr);
            }
        }

        for(int i=index; i<nums.length; i++){
            generateRecursive(nums, target, cur+nums[i], i+1, curStr+"+"+nums[i],loopCount+1, set);
            generateRecursive(nums, target, cur-nums[i], i+1,curStr+"-"+nums[i],loopCount+1, set);
        }
    }*/


/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
    Now you have 2 symbols + and -. For each integer, you should choose
    one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
 Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:
            -1+1+1+1+1 = 3
            +1-1+1+1+1 = 3
            +1+1-1+1+1 = 3
            +1+1+1-1+1 = 3
            +1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.*/

    static int count = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public static void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}



