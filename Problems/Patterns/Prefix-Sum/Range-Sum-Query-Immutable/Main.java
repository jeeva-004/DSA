import java.util.*;

class NumArray {
    private int[] arr;
    NumArray(int[] arr) {
        this.arr = arr;
        for(int i = 1; i<arr.length; i++)
            arr[i] = arr[i]+arr[i-1];
    }
    public int sumRange(int left, int right) {

        return left==0?arr[right]:arr[right]-arr[left-1];
    }

}

public class Main {
    public static void main(String[] args){
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray arr = new NumArray(nums);
        System.out.print(arr.sumRange(0, 5));
    }
}