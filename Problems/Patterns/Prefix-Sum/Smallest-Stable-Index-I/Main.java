public class Main{
    
    static int firstStableIndex(int[] nums, int k){
        int max = -1;
        int[] suffixMins = new int[nums.length];
        suffixMins[suffixMins.length-1] = nums[nums.length-1];

        for(int n = suffixMins.length-2; n>=0; n--){
            suffixMins[n] = nums[n]<suffixMins[n+1]?nums[n]:suffixMins[n+1];
        }

        for(int i = 0; i<nums.length; i++){
            
            max = max<nums[i]?nums[i]:max;
    
            if((max-suffixMins[i])<=k)
                return i;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {5, 0, 1, 4};
        int k = 3;

        System.out.print(firstStableIndex(nums, k));
    }
}