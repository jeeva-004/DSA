import java.util.*;

class Main {
    static int[] removeDuplicates(int[] nums) {
        int slow = 0, i = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[i] == nums[fast]) {
                while (fast!=nums.length&&nums[i] == nums[fast])
                    fast++;
                i = fast;
                fast++;
            } else {
                nums[slow++] = nums[i];
                i = fast;
                fast++;
                if (fast == nums.length)
                    nums[slow] = nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,4,4,5 };
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}