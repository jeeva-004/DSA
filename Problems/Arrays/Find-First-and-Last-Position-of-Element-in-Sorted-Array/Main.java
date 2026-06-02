import java.util.*;

class Main {
    static int[] searchRange(int[] nums, int target) {
        if (nums.toString().indexOf(target)==-1)
            return new int[] { -1, -1 };
        int[] indexs = new int[2];
        int n = nums.length, mid = (0+nums.length-1)/2, i = 0;
        if(mid<target){
            i = mid+1;
            while (i<n) {
                
            }
        }
        else if(mid>target){
            n = mid;
            while (i<n) {
                
            }
        }
        else{

        }

        return indexs;
    }

    public static void main(String[] args) {
        int[] arr = { 2,2 };
        System.out.print(Arrays.toString(searchRange(arr, 7)));
    }
}