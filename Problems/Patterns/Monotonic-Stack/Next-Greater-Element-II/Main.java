import java.util.*;

public class Main {

    static int[] nextGreatestElement(int[] nums) {
        int[] nextGreatestElements = new int[nums.length];
        Arrays.fill(nextGreatestElements, -1);

        Deque<Integer> dStack = new ArrayDeque<>();

        for (int i = 0; i < nums.length * 2; i++) {
            while (!dStack.isEmpty() && nums[dStack.peek()] < nums[i % nums.length])
                nextGreatestElements[dStack.pop()] = nums[i % nums.length];

            dStack.push(i % nums.length);
        }

        return nextGreatestElements;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        System.out.print(Arrays.toString(nextGreatestElement(nums)));
    }
}