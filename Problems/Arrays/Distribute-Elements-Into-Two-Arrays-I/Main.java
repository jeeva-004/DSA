import java.util.*;

public class Main {
    static int[] distributeElements(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        int[] combined = new int[nums.length];
        int i = 0, j = 0, k = 2;
        arr1[i] = nums[0];
        arr2[j] = nums[1];

        for (k = 2; k < nums.length; k++) {
            if (arr1[i] > arr2[j])
                arr1[++i] = nums[k];
            else
                arr2[++j] = nums[k];
        }

        for (k = 0; k <= i; k++)
            combined[k] = arr1[k];

        for (i = 0; i <= j; i++)
            combined[k++] = arr2[i];

        return combined;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3 };

        System.out.print(Arrays.toString(distributeElements(nums)));
    }
}