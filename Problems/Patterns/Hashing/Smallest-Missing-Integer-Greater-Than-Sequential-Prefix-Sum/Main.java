import java.util.*;

public class Main{
    
    static int missingInteger(int[] nums){
        if(nums.length==1)
            return nums[0]+1;

        HashSet<Integer> lookUpSet = new HashSet<>();

        for(int n: nums)
            lookUpSet.add(n);

        int sum = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }   
            else
                break;
        }

        while(lookUpSet.contains(sum))
            sum++;

        return sum;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,2,5};

        System.out.print(missingInteger(nums));
    }
}