import java.util.*;

public class Main{
    
    static long getGcdSum(int[] nums){
    
        int[] prefixGcd = new int[nums.length];
        long sumOfGcd = 0;

        // construct prefix gcd array
        int max = nums[0], i = 0;
        for(int n: nums){
            max = Math.max(max, n);
            prefixGcd[i++] = getGcd(max, n);
        }

        Arrays.sort(prefixGcd);

        int left = 0, right = prefixGcd.length-1;

        while(left<right)
            sumOfGcd+=getGcd(prefixGcd[right--], prefixGcd[left++]);
        
        
        return sumOfGcd;
    }

    static int getGcd(int l, int s){
        
        if(l==s)
            return s;

        while(s!=0){
            int remainder = l % s;
            l = s;
            s = remainder;
        }
        return l;
    }

    public static void main(String[] args){
        int[] nums = {2, 6, 4};

        System.out.print(getGcdSum(nums));
    }
}