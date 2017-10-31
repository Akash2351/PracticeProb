/**
 * Created by Chiru on Dec 29, 2016
 */
package sorting;

//Running time O(n*n)
public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {33, 55, 11, 44, 22};
        insertionSort(arr);

        for (int ele : arr)
            System.out.println(ele);
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int valueToInsert = arr[i];
            int hole = i;
            while (hole > 0 && arr[hole - 1] > valueToInsert) {

                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = valueToInsert;
        }
    }
}