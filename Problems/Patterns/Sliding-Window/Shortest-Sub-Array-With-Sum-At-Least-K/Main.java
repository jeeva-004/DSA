public class Main{
    
    static int shortestSubArray(int[] nums, int k){
        int shortSubArr = Integer.MAX_VALUE, left = 0, right = 0, currentSum = 0;

        while(right<nums.length){
            currentSum+=nums[right];

            while(currentSum>=k){
                shortSubArr = right-left+1<shortSubArr?right-left+1:shortSubArr;
                currentSum-=nums[left];
                left++;
            }

            right++;
        }
        
        return shortSubArr==Integer.MAX_VALUE?-1:shortSubArr;
    }

    public static void main(String[] args){
        int[] nums = {2, -1, 2};
        int k = 3;

        System.out.print(shortestSubArray(nums, k));
    }
}