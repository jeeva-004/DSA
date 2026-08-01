import java.util.*;

public class Main{
    static int countSubArray(int[] nums, int k){
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        
        for(int n: nums){
            currentSum+=n;
            int target = currentSum - k;

            if(freq.containsKey(target))
                count+=freq.get(target);
            
            freq.put(currentSum, freq.getOrDefault(currentSum, 0)+1);
        }

        return count;
    }   
    
    public static void main(String[] args) {
        int[] nums = {1,-1,0};

        System.out.print(countSubArray(nums, 0));
    }
}