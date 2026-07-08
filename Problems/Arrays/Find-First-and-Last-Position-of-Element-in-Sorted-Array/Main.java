import java.util.*;

class Main {
    static int[] searchRange(int[] nums, int target) {
      
        if(nums.length==0)
            return new int[] {-1, -1};

        int[] indexs = new int[2];
        int left = 0, right = nums.length-1; 
        while(left<right){
        int mid = (left+right)/2;
        if(nums[mid]<target)
            left = mid+1;
        else if(nums[mid]>target)
            right = mid-1;
        else{
            int answer = mid;
            left = 0;
            right = mid;
            //find first occurance
            while(left<right){
                
            }

            left = mid;
            right = nums.length-1;
            //find last occurance
            while(left<right){

            }

        }
        }   

        return indexs;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3};
        
        System.out.println(Arrays.toString(searchRange(arr, 3)));
    }
}