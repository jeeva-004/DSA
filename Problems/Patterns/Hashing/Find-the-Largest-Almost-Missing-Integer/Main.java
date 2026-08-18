import java.util.*;

public class Main{
    
    static int largestMissingNumber(int[] nums, int k){
        int max = 0, missingNumber = -1, first = nums[0], last = nums[nums.length-1];

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n: nums){
            max = max<n?n:max;
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }

        for(Map.Entry<Integer, Integer> m: freq.entrySet()){
            if(m.getValue()==1)
                missingNumber = missingNumber < m.getKey() ? m.getKey():missingNumber;
        }

        if(k==1 || k==nums.length)
            return k==1?missingNumber:max;

        missingNumber = -1;

        if(freq.get(first)==1)
            missingNumber = missingNumber<first?first:missingNumber;

        if(freq.get(last)==1)
            missingNumber = missingNumber<last?last:missingNumber;

        return missingNumber;

    }

    public static void main(String[] args){
        int[] nums = {3,9,2,1,7};
        int k = 3;

        System.out.print(largestMissingNumber(nums, k));
    }
}