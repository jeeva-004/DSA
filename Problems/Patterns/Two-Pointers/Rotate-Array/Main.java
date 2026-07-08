import java.util.*;

public class Main{
    
    static void rotateArray(int[] arr, int k){

        if(arr.length<=1||k==0) return;

        k = k % arr.length;

        if(k==0) return;

        //reverse a whole arrar

        int left = 0, right = arr.length-1;

        while(left<right){
            int val = arr[left];
            arr[left++] = arr[right];
            arr[right--] = val;
        }

        //reverse up to k positions

        left = 0;
        right = k-1;

        while(left<right){
            int val = arr[left];

            arr[left++] = arr[right];
            arr[right--] = val;
        }

        //reverse a balance elements upto n

        left = k;
        right = arr.length-1;

        while (left<right) {
            int val = arr[left];

            arr[left++] = arr[right];
            arr[right--] = val;
        }
    }
    
    
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};

        rotateArray(arr, 3);

        System.out.print(Arrays.toString(arr));
    }
}