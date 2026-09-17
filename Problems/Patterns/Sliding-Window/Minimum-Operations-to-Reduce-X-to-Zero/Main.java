public class Main{
    static int minOperations(int[] nums, int x){
        int sum = 0;

        for(int n: nums)
            sum+=n;
        
        if(sum<x)
            return -1;

        if(sum==x)
            return nums.length;

        int target = sum - x;
        int left = 0, right = 0, maxLength = 0, currrentSum = 0;

        while(right<nums.length){
            currrentSum+=nums[right];

            while(currrentSum>target){
                currrentSum-=nums[left];
                left++;
            }

            if(currrentSum==target)
                maxLength = maxLength<right-left+1?right-left+1:maxLength;

            right++;
        }

        return maxLength==0?-1:nums.length-maxLength;
    }


    public static void main(String[] args){
        int[] nums = {1,1,4,2,3};
        int x = 5;

        System.out.print(minOperations(nums, x));        
    }
}