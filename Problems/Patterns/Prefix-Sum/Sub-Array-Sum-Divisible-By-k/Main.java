import java.util.*;

public class Main {

    static int subArrayDivByK(int[] nums, int k){
        int subArrays = 0, runningSum = 0, target = 0;

        int[] lookUp = new int[k];
        lookUp[0] = 1;

        for(int n: nums){
            runningSum+=n;
            target = runningSum%k;
            target = (target+k) % k;

            subArrays+=lookUp[target];
            lookUp[target]++;
        }

        return subArrays;
    }

    public static void main(String[] args){
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.print(subArrayDivByK(nums, k));
    }    
}
