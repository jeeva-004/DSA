import java.util.*;

public class Main {

    static int maxSubArrays(int[] nums, int k) {
        int maxSubArrayLength = 0, runningSum = 0, target = 0;
        HashMap<Integer, Integer> lookUpMap = new HashMap<>();
        lookUpMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            target = runningSum - k;

            if (lookUpMap.containsKey(target)) {
                maxSubArrayLength = i - lookUpMap.get(target) > maxSubArrayLength ? i - lookUpMap.get(target)
                        : maxSubArrayLength;
            }
            if (!lookUpMap.containsKey(runningSum))
                lookUpMap.put(runningSum, i);
        }

        return maxSubArrayLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, -1, 5, -2, 3 };

        System.out.print(maxSubArrays(nums, 3));
    }
}