import java.util.*;

public class Main {
    static int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> lookUpMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (lookUpMap.containsKey(complement))
                return new int[] { lookUpMap.get(complement), i };
            else
                lookUpMap.put(arr[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 8, 4, 2 };

        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}