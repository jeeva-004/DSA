public class Main{
    
    static int subArraysLessthanK(int[] nums, int k){
        if(k<=1)
            return 0;
        
        int subArrays = 0, left = 0, right = 0, product = 1;

        for(right = 0; right<nums.length; right++){
            product*=nums[right];

            while(product>=k && left<=right){
                product /= nums[left++];
            }

            subArrays+=right-left+1;
        }

        return subArrays;

    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.print(subArraysLessthanK(nums, 6));
    }
}