/**
 * Created by Chiru on Jan 2, 2017
 */
package cci;

import java.util.Hashtable;

//Given array of distinct int values
//Count the #of pair integers with difference k 
public class IntsWithDifferenceK {

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int diff = 2;

        System.out.println(intsWithDiffK(arr, diff));

    }

    //Add array to HashTable and look for element +/- k
    public static int intsWithDiffK(int[] arr, int k) {
        int count = 0;

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (int ele : arr)
            hashtable.put(ele, ele);

        for (int i = 0; i < arr.length; i++) {
            if (hashtable.get(arr[i] + k) != null) {
                //System.out.println(hashtable.get(arr[i]) + " " + hashtable.get(arr[i] + k));
                count++;
            }
        }
        return count;
    }
}