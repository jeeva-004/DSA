public class Main{
    
    static int peekElement(int[] nums){
        int start = 0, end = nums.length-1, mid = 0;

        while(start<end){
            if(start==end)
                return start;

            mid = (start+end)/2;

            if(nums[mid]>nums[mid+1])
                end = mid;
            else
                start = mid+1;

        }

        return start;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1};

        System.out.print(peekElement(nums));
    }
}