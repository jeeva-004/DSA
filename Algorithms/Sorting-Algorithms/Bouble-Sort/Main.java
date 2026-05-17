import java.util.*;

class Main {
    // Time Complexity O(n2)
    static void sortAccending(int[] arr) {
        boolean isSwaped = false;
       for(int i = 0; i<arr.length-1; i++){
        for(int j = 0; j<arr.length-1; j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                isSwaped = true;
            }
        }
        if(!isSwaped)
            break;
       }
    }

    public static void main(String[] args) {
        int[] arr = { 3,2,4,3,5,6,3,7,3,1,20,0,9,7,6,2};
        sortAccending(arr);
        System.out.print(Arrays.toString(arr));
    }
}