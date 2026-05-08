import java.util.*;

public class Main {
    static int thirdLargest(int arr[]) {
        boolean isSame = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                isSame = false;
                break;
            }
        }

        if (arr.length >= 3) {
            if (isSame)
                return arr[0];
            int first = Integer.MIN_VALUE, firstIndex = 0, second = Integer.MIN_VALUE, secondIndex = 0,
                    third = Integer.MIN_VALUE;
            // find firstNumber
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > first) {
                    first = arr[i];
                    firstIndex = i;
                }
            }

            // secondNumber
            for (int i = 0; i < arr.length; i++) {
                if (firstIndex == i)
                    continue;
                if (arr[i] > second) {
                    second = arr[i];
                    secondIndex = i;
                }
            }

            // thirdNumber
            for (int i = 0; i < arr.length; i++) {
                if (firstIndex == i || secondIndex == i)
                    continue;
                if (arr[i] > third)
                    third = arr[i];
            }
            return third;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2 ,4 ,1 ,3 ,5 };
        System.out.println(thirdLargest(arr));
    }
}
