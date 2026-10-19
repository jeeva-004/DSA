import java.util.*;
public class Main{

    static List<Integer> targetIndexes(int[] nums, int target){
        List<Integer> targetIndexes = new ArrayList<>();

        Arrays.sort(nums);

        int start = 0, end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>target)
                end = mid-1;
            else if(nums[mid]<target)
                start = mid+1;
            else{
                int firstIndex = mid;
                while(firstIndex>=0 && nums[firstIndex]==target)
                    firstIndex--;
                
                firstIndex++;

                while(firstIndex<nums.length && nums[firstIndex]==target)
                    targetIndexes.add(firstIndex++);
                
                return targetIndexes;
            }

        }

        return targetIndexes;
    }

    public static void main(String[] args){
        int[] nums = {3,1,2,2,5};
        int target = 2;

        System.out.print(targetIndexes(nums, target));
    }   
}