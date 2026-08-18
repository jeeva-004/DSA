public class Main{

    static int longestSubArray(int[] nums){
        int left = 0, right = 0, longestSubArray = 0, zeros = 0, val = 0;

        for(right = 0; right<nums.length; right++){
            zeros +=nums[right]==0?1:0;

            while(zeros>1){
                val = nums[left];
                left++;
                zeros-=val==0?1:0;
            }
            
            longestSubArray = longestSubArray<right-left?right-left:longestSubArray;
        }

        return longestSubArray;
    }

    public static void main(String[] args){
        int[] nums = {0,1,1,1,0,1,1,0,1};

        System.out.print(longestSubArray(nums));
    }
}