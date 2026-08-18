import java.util.*;

public class Main {

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int left = 0, right = 0;
        long currentSum = 0;

        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum < target)
                        left++;
                    else if (currentSum > target)
                        right--;
                    else {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);
                        quadruplets.add(quadruplet);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;

                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }

                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums = { 1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums, target);

        for (int l = 0; l<ans.size(); l++) {
            System.out.print(ans.get(l) + " ");
        }
    }
}