import java.util.*;

public class Main{
    
    static int maxOperations(int[] nums, int k){
        Arrays.sort(nums);
        int left = 0, right = nums.length-1; 
        int operations = 0, sum = 0;

        while(left<right){
            sum = nums[left] + nums[right];

            if(sum<k){
                left++;
            }
            else if(sum>k){
                right--;
            }
            else{
                operations++;
                left++;
                right--;
            }
        }

        return operations;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 3;

        System.out.print(maxOperations(nums, k));
    }
}