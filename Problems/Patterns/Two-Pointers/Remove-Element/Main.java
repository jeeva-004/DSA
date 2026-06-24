import java.util.Arrays;

class Main{
    
    static int removeElement(int[] nums, int val) {
        if(nums.length==0)
            return 0;
        int count = 0;
        int slow = 0, fast = 0;
        
        while(fast<nums.length){
            if(nums[fast]==val)
                while(fast<nums.length&&nums[fast]==val)
                    fast++;
            else{
                count++;
                nums[slow++] = nums[fast++];
            }
        }

        return count;
    }
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};

        System.out.print(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}