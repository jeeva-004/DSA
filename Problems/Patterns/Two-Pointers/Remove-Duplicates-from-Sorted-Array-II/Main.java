import java.util.*;

class Main {
    static int removeDuplicates(int[] nums) {
        int slow = 0, traveller = 0, count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (traveller < nums.length) {
            if(!set.contains(nums[traveller])){
                set.add(nums[traveller]);
                nums[slow] = nums[traveller];
                slow++;
                traveller++;
                count++;
            }
            else
                traveller++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1,1,2,2,3,3,3,3,4,4,5 };
        int res = removeDuplicates(nums);
        for(int n = 0; n<res; n++)
            System.out.println(nums[n]+" ");
    }
}