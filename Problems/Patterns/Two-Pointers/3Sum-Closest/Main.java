import java.util.Arrays;

public class Main{
    
    static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);

        long closest = (long) nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                long currentSum = (long) nums[i] + nums[left] + nums[right];

                long currentDiff = Math.abs((long) target - currentSum);
                long closestDiff = Math.abs((long) target - closest);

                if (currentDiff < closestDiff ||
                    (currentDiff == closestDiff && currentSum > closest)) {
                    closest = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } 
                else if (currentSum > target) {
                    right--;
                } 
                else {
                    return (int) currentSum;
                }
            }
        }

        return (int) closest;
    }

    public static void main(String[] args){
        int[] nums = {5,2,7,5};
        int target = 13;

        System.out.print(threeSumClosest(nums, target));
    }
}