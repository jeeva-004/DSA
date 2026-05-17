import java.util.*;
class Main {
    static int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashSet<Integer> lookUpSet = new HashSet<>();
        int  min = 1;
        int consecutiveSequence = 1;
        for(int n: nums){
            lookUpSet.add(n);
            if(min>=n)
                min = n;
        }

        for(int i = min; i<nums.length; i++){
            if(i==min)
                continue;
            if(lookUpSet.contains(i)){
                consecutiveSequence++;
            }
            else
                break;
        }
        
        return consecutiveSequence;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,2};
        System.out.print(longestConsecutive(arr));
    }
}