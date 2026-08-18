import java.util.*;
import java.util.HashMap;

public class Main {

    static int binarySubArrays(int[] nums, int goal) {
        int runningSum = 0, subArrays = 0, target = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int n : nums) {
            runningSum += n;
            target = runningSum - goal;
            if (freq.containsKey(target)) {
                subArrays += freq.get(target);
            }

            freq.put(runningSum, freq.getOrDefault(runningSum, 0) + 1);
        }

        return subArrays;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(binarySubArrays(nums, goal));
    }
}
