import java.util.*;

class Main {
    static void mergeSort(int[] arr, int low, int high) {
        int s = low, e = high;
        if (low >= high)
            return;
        int mid = (s + e) / 2;
        int pivot = arr[mid];

        while (s <= e) {
            while (arr[s] < pivot)
                s++;
            while (arr[e] > pivot)
                e--;
            // swap
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }
        mergeSort(arr, low, e);
        mergeSort(arr, s, high);
    }

    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}