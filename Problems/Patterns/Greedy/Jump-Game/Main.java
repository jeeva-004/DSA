public class Main{
    static boolean canJump(int[] nums){
        if(nums.length<=1)
            return true;        
        if(nums.length>1 && nums[0]==0)
            return false;
        int maximumJumps = 0, i = 0, current = 0;
        while(i<nums.length){
            if(i>maximumJumps)
                return false;

            current = i+nums[i];
            maximumJumps = maximumJumps<current?current:maximumJumps;

            if(maximumJumps>=nums.length-1)
                return true;
            i++;
        }
        return true;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}