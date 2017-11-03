package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 01-11-2017.
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println("");
        System.out.println(cs.combinationSum(new int[]{2, 3, 5, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //for storing the list..
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return list;
        //for storing the temp list
        List<Integer> curList = new ArrayList<>();
        printRecursive(candidates, 0, target, curList, list);
        return list;
    }

    public void printRecursive(int[] candidates, int index, int target,
                               List<Integer> curList, List<List<Integer>> list) {
        //base case..
        if (target == 0) {
            //just adding curList, it will be empty in the end...so making a new copy
            list.add(new ArrayList<>(curList));
        } else if (target > 0) {
            // if starting from i =0, it will give all combinations...
            // if input is [2, 3, 6, 7], we get [2, 2, 3],[2, 3, 2], [3,2,2] with i=0
            // else, it gives only [2, 2, 3]
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                curList.add(candidates[i]);
                printRecursive(candidates, i, target - candidates[i], curList, list);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
