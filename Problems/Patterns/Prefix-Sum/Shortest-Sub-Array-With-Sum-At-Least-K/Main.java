import java.util.*;

public class Main{
    
    static int shortestSubArray(int[] nums, int k){

        int[] prefixSum = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }

        int shortSubArr = Integer.MAX_VALUE;
        Deque<Integer> iStack = new ArrayDeque<>();

        for(int j = 0; j<prefixSum.length; j++){
            while(!iStack.isEmpty() && prefixSum[j] - prefixSum[iStack.peekFirst()]>=k){
                shortSubArr = shortSubArr>j-iStack.getFirst()?j-iStack.getFirst():shortSubArr;
                iStack.removeFirst(); 
            }   


            while(!iStack.isEmpty() && prefixSum[j]<=prefixSum[iStack.peekLast()]){
                iStack.removeLast();
            }

            iStack.addLast(j); 
        }

        return shortSubArr==Integer.MAX_VALUE?-1:shortSubArr;
    }

    public static void main(String[] args){
        int[] nums = {2, -1, 2};
        int k = 3;

        System.out.print(shortestSubArray(nums, k));
    }
}