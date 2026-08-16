import java.util.*;

class Main {
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2; i++){
            int anchar = nums[i];
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int target = 0 - anchar;
            int left = i+1, right = nums.length-1;
            while(left<right){
                int currentSum = nums[left]+nums[right];
                if(currentSum>target)   
                    right--;
                else if(currentSum<target)
                    left++;
                else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(anchar);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);
                    left++;
                    right--;
                    while(left<right&&nums[left-1]==nums[left])
                        left++;
                    while(left<right&&nums[right+1]==nums[right])
                        right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.print(threeSum(nums));
    }
}