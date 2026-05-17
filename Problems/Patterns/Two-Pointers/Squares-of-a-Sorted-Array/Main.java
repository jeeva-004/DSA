import java.util.Arrays;

class Main {
    static int[] SquaresOfSortedArray(int[] arr) {

        for (int i = 0; i < arr.length; i++)
            arr[i] = Math.abs(arr[i] * arr[i]);
        boolean isSwaped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwaped = true;
                }
            }
            if (!isSwaped)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };

        System.out.println(Arrays.toString(SquaresOfSortedArray(arr)));
    }
}