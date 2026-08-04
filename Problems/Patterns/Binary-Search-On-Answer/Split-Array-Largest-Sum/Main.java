public class Main{
    static int splitArray(int[] nums, int k){
        long low = Integer.MIN_VALUE, high = 0, mid = 0, minLargeElement = 0;
        for(int n: nums){
            low = low<n?n:low;
            high+=n;
        }

        while(low<=high){
            mid = (low+high) / 2;

            if(canSplit(nums, mid, k)){
                minLargeElement = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }

        return (int) minLargeElement;
    }

    static boolean canSplit(int[] nums, long mid, int k){
        
        long sum = 0, pieces = 1;

        for(int n: nums){

            if(sum+n>mid){
                pieces++;
                
                if(pieces>k)
                    return false;
                
                sum = n;
            }
            else
                sum+=n;
        }
        
        return true;
    }

    public static void main(String[] args){
        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}