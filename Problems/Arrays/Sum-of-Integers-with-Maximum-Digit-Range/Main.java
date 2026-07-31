import java.util.*;
import java.util.HashMap;

public class Main {

    static int maxDigitRange(int[] nums) {

        int[] digitRange = new int[nums.length];

        int i = 0, majority = Integer.MIN_VALUE, res = 0;

        for (int n : nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (n > 0) {
                min = min > n % 10 ? n % 10 : min;
                max = max < n % 10 ? n % 10 : max;
                n /= 10;
            }

            digitRange[i++] = max - min;
            majority = majority < (max - min) ? (max - min) : majority;

        }

        for (i = 0; i < digitRange.length; i++)
            res += digitRange[i] == majority ? nums[i] : 0;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 5724, 111, 350 };

        System.out.println(maxDigitRange(nums));
    }
}