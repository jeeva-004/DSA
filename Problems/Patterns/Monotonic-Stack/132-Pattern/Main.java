import java.util.*;

public class Main{
    
    //132 patter exist or not 

    static boolean patternExist(int[] nums){
        if(nums.length<3)
            return false;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;

        for(int i = nums.length-1; i>=0 ; i--){
            if(nums[i]<second)
                return true;
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                second = Math.max(second, nums[stack.pop()]);
            
            stack.push(i);
        }
        
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,2};

        System.out.print(patternExist(nums));
    }
}