/**
 * Created by Chiru on Dec 27, 2016
 */
package sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = {22, 44, 55, 66, 33, 11};

        int sorted[] = bubbleSort(arr);

        display(sorted);
    }

    public static int[] bubbleSort(int[] arr) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;

    }

    public static void display(int[] arr) {
        for (int ele : arr)
            System.out.println(ele);
    }
}