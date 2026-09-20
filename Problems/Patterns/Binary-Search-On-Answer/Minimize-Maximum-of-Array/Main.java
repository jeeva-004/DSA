public class Main{
    
    static int minimizeArrayValue(int[] nums){
        int min = 0, max = 0, mid = 0;
        long minimizedMaxValue = 0; 


        for(int n: nums)
            max = max<n?n:max;

        while(min<=max){
            mid = (min+max)/2;

            if(isPossible(nums, mid)){
                minimizedMaxValue = mid;
                max = mid-1;
            }
            else
                min = mid+1;
        }

        return (int) minimizedMaxValue;
    }

    static boolean isPossible(int[] nums, int mid){
        long[] duplicateArr = new long[nums.length];
        
        for(int n = 0; n<duplicateArr.length; n++)
            duplicateArr[n] = nums[n];
        
        for(int i = duplicateArr.length-1; i>=1; i--){
            if(duplicateArr[i]>mid){
                long excess = duplicateArr[i] - mid;
                duplicateArr[i-1]+=excess;
            }
        }

        return duplicateArr[0]<=mid;
    }

    public static void main(String[] args){
        int[] nums = {10,1};
        System.out.print(minimizeArrayValue(nums));
    }
}