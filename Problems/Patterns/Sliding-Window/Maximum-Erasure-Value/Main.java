import java.util.*;

public class Main{
    
    static int maximumUniqueSubArray(int[] nums){
        int maxUniqueSubArray = 0, currentSubArray = 0, left = 0, right = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        while(right<nums.length){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0)+1);
            currentSubArray+=nums[right];

            while(freq.get(nums[right])>1){
                freq.put(nums[right], freq.get(nums[right])-1);
                currentSubArray-=nums[left];
                left++;
            }
            maxUniqueSubArray = maxUniqueSubArray<currentSubArray?currentSubArray:maxUniqueSubArray;

            right++;
        }

        return maxUniqueSubArray;
    }

    public static void main(String[] args){
        int[] nums = {4,2,4,5,6};

        System.out.print(maximumUniqueSubArray(nums));
    }
}