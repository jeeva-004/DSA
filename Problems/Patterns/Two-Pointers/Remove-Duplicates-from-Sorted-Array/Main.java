import java.util.*;
class Main {
    static int[] removeDuplicates(int[] arr) {
        int count = 0, slow = 0, fast = 1;

        while (fast < arr.length) {
            if (arr[slow] == arr[fast])
                fast++;
            else{
                arr[slow] = arr[fast];
                slow++;
            }
            }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        System.out.print(Arrays.toString(removeDuplicates(arr)));
    }
}