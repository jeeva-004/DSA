import java.util.ArrayList;

class Main {
    static int getSecondLargest(int[] arr) {
        int LargestNumber = Integer.MIN_VALUE;
        int secondLargestNumber = Integer.MIN_VALUE;
        boolean isSame = true;
        for (int num = 0; num < arr.length - 1; num++) {
            if (arr[num] != arr[num + 1]) {
                isSame = false;
                break;
            }
        }

        if (!isSame) {
            for (int num : arr) {
                if (num > LargestNumber)
                    LargestNumber = num;
            }
            for (int num : arr) {
                if (num != LargestNumber && num > secondLargestNumber) {
                    secondLargestNumber = num;
                }
            }
            return secondLargestNumber;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 12, 13 };
        getSecondLargest(arr);
    }

}