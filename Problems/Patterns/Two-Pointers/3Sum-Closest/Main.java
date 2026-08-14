import java.util.Arrays;

public class Main{
    
    static int threeSumClosest(int[] nums, int target){
        int left = 0, right = 0, currentSum = 0, closest = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            left = i+1;
            right = nums.length-1;

            while(left<right){
                currentSum = nums[i] + nums[left] + nums[right];
                closest = Math.abs(target - closest)<Math.abs(target-currentSum)?closest:currentSum;

                if(currentSum<target)
                    left++;
                else if(currentSum>target)
                    right--;
                else
                    return currentSum;
            }
        }

        return closest;
    }

    public static void main(String[] args){
        int[] nums = {0,0,0};
        int target = 1;

        System.out.print(threeSumClosest(nums, target));
    }
}