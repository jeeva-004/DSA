import java.util.*;

class Main {
    static int[] moveZero(int[] arr) {
        int[] tempArr = new int[arr.length];
        int j = 0;
        for (int i : arr)
            if (i != 0)
                tempArr[j++] = i;
        for (int n = 0; n < arr.length; n++) {
            arr[n] = tempArr[n];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 2, 3, 0, 2, 0 };
        System.out.println(Arrays.toString(moveZero(arr)));
    }
}