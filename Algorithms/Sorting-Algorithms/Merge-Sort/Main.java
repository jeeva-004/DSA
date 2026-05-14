import java.util.*;

class Main {

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, mid)), mergeSort(Arrays.copyOfRange(arr, mid, arr.length)));
    }

    static int[] merge(int[] left, int[] right) {
        int[] joined = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (left.length > i && right.length > j) {
            if (left[i] < right[j])
                joined[k++] = left[i++];
            else
                joined[k++] = right[j++];
        }

        while (i < left.length)
            joined[k++] = left[i++];
        while (j < left.length)
            joined[k++] = right[j++];

        return joined;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 4, 3, 5, 6, 9 };

        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}