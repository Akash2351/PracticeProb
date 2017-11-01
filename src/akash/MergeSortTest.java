package akash;

import java.util.Arrays;

/**
 * Created by akash on 31-10-2017.
 */
public class MergeSortTest {

    public static void main(String[] args) {
        MergeSortTest mt = new MergeSortTest();
        int ary[] = new int[]{90, 10, 30, 80, 70, 20};
        mt.mergeSort(ary, 0, 5);
        System.out.println(Arrays.toString(ary));
    }

    void mergeSort(int ary[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(ary, low, mid);
            mergeSort(ary, mid + 1, high);
            merge(ary, low, mid, high);
        }
    }

    void merge(int[] ary, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        int temp[] = new int[high + 1];

        for (int idx = low; idx <= high; idx++) {
            temp[idx] = ary[idx];
        }
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                ary[k++] = temp[i++];
            } else {
                ary[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            ary[k++] = temp[i++];
        }
    }
}
