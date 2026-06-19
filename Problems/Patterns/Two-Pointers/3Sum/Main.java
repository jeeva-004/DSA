import java.util.*;

class Main {

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int anchor = nums[i], target = 0 - anchor;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[left] + nums[right];
                if (currentSum < target)
                    left++;
                else if (currentSum > target)
                    right--;
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(anchor);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.print(threeSum(nums));
    }
}