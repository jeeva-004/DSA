import java.util.*;

public class Main{
    
    static int longestSubArray(int[] nums, int limit){
        int left = 0, right =0, longSubArray = 0;

        Deque<Integer> minimums = new ArrayDeque<>();
        Deque<Integer> maximums = new ArrayDeque<>();

        while(right<nums.length){

            while(!minimums.isEmpty() && nums[minimums.peekLast()]>nums[right])
                minimums.pollLast();
            
            minimums.addLast(right);

            while(!maximums.isEmpty() && nums[maximums.peekLast()]<nums[right])
                maximums.pollLast();

            maximums.addLast(right); 

            while(!maximums.isEmpty() && !minimums.isEmpty() && nums[maximums.peekFirst()] - nums[minimums.peekFirst()] > limit ){
                left++;

                while(!maximums.isEmpty() && maximums.peekFirst() < left)
                    maximums.pollFirst();
                
                while(!minimums.isEmpty() && minimums.peekFirst() < left)
                    minimums.pollFirst();

            }
            longSubArray = longSubArray < right - left +1 ? right-left+1:longSubArray;
            right++;
        }

        return longSubArray;
    }

    public static void main(String[] args){
        int[] nums = {8,2,4,7};
        int limit = 4;

        System.out.print(longestSubArray(nums, limit));
    }
}