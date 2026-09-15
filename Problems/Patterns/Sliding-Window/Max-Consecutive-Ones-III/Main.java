public class Main{
    
    static int maxConsecutiveOnes(int[] nums, int k){
        int left = 0, right = 0, maxOnes = 0, zeros = 0;

        while(right<nums.length){
            zeros+=nums[right]==0?1:0;

            while(zeros>k){
                zeros-=nums[left]==0?1:0;
                left++;
            }

            maxOnes = maxOnes<right-left+1?right-left+1:maxOnes;
            right++;
        }

        return maxOnes;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.print(maxConsecutiveOnes(nums, k));
    }
}