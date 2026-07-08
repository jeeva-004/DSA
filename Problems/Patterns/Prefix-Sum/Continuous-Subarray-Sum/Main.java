import java.util.*;
public class Main{
    
    static boolean isSubArray(int[] nums, int k){
        
        int prefixSum = 0;
        HashMap<Integer, Integer> remains = new HashMap<>();

        remains.put(0, -1);

        for(int n = 0; n<nums.length; n++){
            prefixSum+=nums[n];
            int remainder = prefixSum % k;
            
            remainder = (remainder + k) % k;

            if(remains.containsKey(remainder)){
                if(n - remains.get(remainder) > 1)
                    return true;
            }
            else
                remains.put(remainder, n);
        }
        
        
        return false;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {23, 6, 4, 5};
    
        System.out.println(isSubArray(nums, 6));
    }
}