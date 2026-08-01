public class Main{
    
    static int minSize(int[] nums, int target){
        int currentSum = 0, currentSize = 0, start = 0, end = 0, minSize = Integer.MAX_VALUE;

        while(end<nums.length){
            
            currentSum+=nums[end];

            while(currentSum>=target){
                currentSize = end - start + 1;
                minSize = minSize>currentSize?currentSize: minSize;
                currentSum = currentSum - nums[start];
                start++;
            }

            end++;
        }

        return minSize==Integer.MAX_VALUE? 0 : minSize;
    }
    
    public static void main(String[] args){
        int[] nums = {3,2,45,4,2,5};
        int target = 6;

        System.out.print(minSize(nums, target));
    }
}