import java.util.*;

class Main {
    static int removeDuplicates(int[] nums) {
        int slow = 2, fast = 2;

        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

        System.out.println(removeDuplicates(nums));
    }
}