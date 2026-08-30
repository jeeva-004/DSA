import java.lang.*;

public class Main{
    
    static int minNoOfDeletions(int[] nums){
        if(nums.length==1)
            return 1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minIndex = 0, maxIndex = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i]<min){
                minIndex = i;
                min = nums[i];
            }

            if(nums[i]>max){
                maxIndex = i;
                max = nums[i];
            }
        }
 int minimumNoOfDeletions = Integer.MAX_VALUE;

        int option1 = Math.max(minIndex, maxIndex) + 1;

        int option2 = nums.length - Math.min(minIndex, maxIndex);

        int option3 = (Math.min(minIndex, maxIndex) + 1) + (nums.length - Math.max(minIndex, maxIndex));

        minimumNoOfDeletions = minimumNoOfDeletions > option1 ? option1 : minimumNoOfDeletions;
        minimumNoOfDeletions = minimumNoOfDeletions > option2 ? option2 : minimumNoOfDeletions;
        minimumNoOfDeletions = minimumNoOfDeletions > option3 ? option3 : minimumNoOfDeletions;

        return minimumNoOfDeletions;
    }
    
    public static void main(String[] args){
        int[] nums = {2,10,7,5,4,1,8,6};

        System.out.print(minNoOfDeletions(nums));
    }
}