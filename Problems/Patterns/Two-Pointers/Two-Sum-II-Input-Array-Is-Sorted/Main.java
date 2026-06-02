import java.util.*;

class Main {
    static int[] twoSum(int[] numbers, int target) {
        int s = 0, f = numbers.length - 1, sum = 0;
        while (s<f) {
            sum = numbers[s] + numbers[f];
            if (sum > target)
                f--;
            else if (sum < target)
                s++;
            else
                return new int[] { s + 1, f + 1 };
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] numbers = { 2,3,4,5};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}