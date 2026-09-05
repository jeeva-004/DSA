public class Main{
    
    static int findPivotIndex(int[] nums){
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];

        for(int i = 1; i<nums.length; i++)
            prefixSums[i] = prefixSums[i-1] + nums[i];
        
        for(int j = 0; j<prefixSums.length; j++){
            int leftSum = prefixSums[j];
            int rightSum = j==0?prefixSums[prefixSums.length-1]:prefixSums[prefixSums.length-1] - prefixSums[j-1];

            if(rightSum - leftSum==0)
                return j;
        }

        return -1;

    }

    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};
        System.out.print(findPivotIndex(nums));
    }
}