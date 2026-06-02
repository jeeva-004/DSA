import java.util.*;
class Main {

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        //sort a array using bouble sort
        for(int i = 0; i<nums.length-1; i++){
            for(int j = 0; j<nums.length-1; j++){
                int temp = nums[j];
                if(nums[j]>nums[j+1]){
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int i = 0; i<nums.length; i++){
            
        }

 
        return triplets;
    }   
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.print(threeSum(nums));
    }
}