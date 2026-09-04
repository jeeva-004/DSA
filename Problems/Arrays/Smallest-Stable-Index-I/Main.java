public class Main{
    
    static int firstStableIndex(int[] nums, int k){
        for(int i = 0; i<nums.length; i++){
            int max = -1, j = 0;

            while(j<=i){
                max = max<nums[j]?nums[j]:max;
                j++;
            }

            int min = Integer.MAX_VALUE, l = i;

            while(l<nums.length){
                min = min>nums[l]?nums[l]:min;
                l++;
            }

            if((max-min)<=k)
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