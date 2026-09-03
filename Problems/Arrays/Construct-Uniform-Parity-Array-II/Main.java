public class Main{
    
    static boolean uniformArray(int[] nums){
        int smallestOdd = Integer.MAX_VALUE;
        boolean isEven = false, isOdd = false;

        for(int n: nums){
            if(n%2!=0 && smallestOdd>n){
                smallestOdd = n;
            }

            isEven = n%2==0?true:isEven;
            isOdd = n%2!=0?true:isOdd;
        }

        if(!isEven || !isOdd)
            return true;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2==0 && nums[i]<smallestOdd)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        int[] nums = {1, 4, 7};

        System.out.print(uniformArray(nums));
    }
}