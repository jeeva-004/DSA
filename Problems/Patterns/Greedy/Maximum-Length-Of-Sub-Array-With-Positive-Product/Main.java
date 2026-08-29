public class Main{
    
    static int longestSubArray(int[] nums){
        int maxProduct = 1, currentProduct = 1, left = 0, longestSubArr = 0;

        for(int i = 0; i<nums.length; i++){
            currentProduct*=nums[i];
            if(currentProduct==0){
                left++;
                currentProduct = 1;
                continue;
            }

            if(currentProduct>maxProduct){
                maxProduct = currentProduct;
                longestSubArr = longestSubArr<i-left+1?i-left+1:longestSubArr;
            }
        }

        return longestSubArr;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, -2, -3, -4};
        System.out.print(longestSubArray(nums));
    }   
}