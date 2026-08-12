import java.util.*;

public class Main {

    static int longestSubArray(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxLength = 0, left = 0, right = 0;

        for (right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.containsKey(nums[right]) && freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left])-1);
                left++;
            }

            maxLength = maxLength < right - left + 1 ? right - left + 1 : maxLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};

        System.out.print(longestSubArray(nums, 2));
    }
}