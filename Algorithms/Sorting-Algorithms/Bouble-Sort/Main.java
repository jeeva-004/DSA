import java.util.*;

class Main {
    // Time Complexity O(n2)
    static void sortAccending(int[] arr) {
        boolean swap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 14, 2, 3, 4 };
        sortAccending(arr);
        System.out.print(Arrays.toString(arr));
    }
}