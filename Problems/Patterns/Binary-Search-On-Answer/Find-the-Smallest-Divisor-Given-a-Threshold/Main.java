public class Main{
    
    static int smallestDivisor(int[] nums, int threshold){
        int minDivisor = Integer.MAX_VALUE;
        int min = 1, max = Integer.MIN_VALUE, mid = 0;
        
        for(int n: nums)
            max = Math.max(n, max);

        while(min<=max){
            mid = (min+max) / 2;

            int sum = 0;
            boolean isValid = true;

            for(int n: nums){
                sum+= (n+mid-1) / mid;

                if(sum>threshold){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                minDivisor = Math.min(minDivisor, mid);
                max = mid-1;
            }
            else
                min = mid+1;
        }

        return minDivisor;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}