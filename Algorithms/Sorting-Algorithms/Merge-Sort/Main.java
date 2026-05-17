import java.util.*;

class Main {

    // merge sort in call by value

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] joined = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (left.length > i && right.length > j) {
            if (left[i] > right[j])
                joined[k++] = right[j++];
            else
                joined[k++] = left[i++];
        }

        while (left.length > i)
            joined[k++] = left[i++];
        while (right.length > j)
            joined[k++] = right[j++];

        return joined;
    }

    // merge sort in call by reference

    static void mergeSortInPlace(int[] arr, int start, int end) {

        if (end - start == 1)
            return;

        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] joined = new int[e - s];

        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] > arr[j])
                joined[k++] = arr[j++];
            else
                joined[k++] = arr[i++];
        }

        while (i < m)
            joined[k++] = arr[i++];
        while (j < e)
            joined[k++] = arr[j++];

        for (k = 0; k < joined.length; k++)
            arr[s++] = joined[k];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 4, 3, 5, 6, 9 };
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}