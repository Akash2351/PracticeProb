package akash;

import java.util.Arrays;

/**
 * Created by akash on 11-03-2018.
 */
public class QuickSort {

    public void quickSort(int[] ary, int low, int high) {
        if (low < high) {
            int pivot = (low + high) / 2;
            int part = partition(ary, low, high, pivot);
            quickSort(ary, low, part - 1);
            quickSort(ary, part, high);
        }
    }

    public int partition(int[] ary, int low, int high, int pivot) {
        while (low <= high) {

            while (ary[low] < ary[pivot]) low++;
            while (ary[high] > ary[pivot]) high--;

            if (low <= high) {
                int temp = ary[low];
                ary[low] = ary[high];
                ary[high] = temp;

                low++;
                high--;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ary = new int[]{2, 3, 1, 4, 7, 8};
        System.out.println(Arrays.toString(ary));
        quickSort.quickSort(ary, 0, ary.length - 1);
        System.out.println(Arrays.toString(ary));
    }
}
