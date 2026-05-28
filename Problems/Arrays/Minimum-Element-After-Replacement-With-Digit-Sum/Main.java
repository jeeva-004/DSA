import java.util.*;

class Main {

    static int minElement(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        for (int n : nums) {
            String s = n + "";
            char[] c = s.toCharArray();
            int sum = 0;
            for (char i : c) {
                int d = Character.getNumericValue(i);
                sum += d;
            }

            if (sum < minElement)
                minElement = sum;
        }

        return minElement;
    }

    public static void main(String[] args) {
        int[] arr = { 999,19,199 };
        System.out.println(minElement(arr));
    }
}