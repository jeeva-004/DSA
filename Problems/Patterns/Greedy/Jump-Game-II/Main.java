public class Main{
    
    static int minJumps(int[] nums){
        if(nums.length<=1)
            return 0;
        
        int i = 0, jumps = 0, farthest = 0, currentEnd = 0;

        while(i<nums.length-1){
            farthest = farthest<i+nums[i]?i+nums[i]:farthest;

            if(i==currentEnd){
                currentEnd = farthest;
                jumps++;
            }
            
            i++;
        }

        return jumps;
    }
    
    public static void main(String[] args){
        int[] nums = {2,3,1,1,1};

        System.out.print(minJumps(nums));
    }
}