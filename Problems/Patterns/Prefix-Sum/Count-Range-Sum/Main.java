import java.util.*;
public class Main{
    
    static int rangeSum(int[] nums, int lower, int upper){
        
        int count = 0;

        long[] prefixSums = new long[nums.length+1];
        int currentSum = 0;

        for(int i = 0; i<nums.length; i++)
            prefixSums[i+1] = nums[i] + prefixSums[i];

        for(int m = 0; m<prefixSums.length; m++){
            for(int n = 0; n<m; n++){
                long subArraySum = prefixSums[m] - prefixSums[n];

                if(subArraySum>=lower&&subArraySum<=upper)
                    count++;
            }
        }

        return  count;
    }    
    public static void main(String[] args){
        int[] nums = {1,2,3};

        System.out.println(rangeSum(nums, 1, 3));
    }
}