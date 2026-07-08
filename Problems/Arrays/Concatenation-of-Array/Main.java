import java.util.*;

public class Main{
    
    static int[] getConcatination(int[] arr){
        int[] concatinatedArr = Arrays.copyOf(arr, arr.length*2);

        int l = 0;

        for(int i = arr.length; i<concatinatedArr.length; i++)
            concatinatedArr[i] = arr[l++];

        return concatinatedArr;
    }
    
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};

        System.out.println(Arrays.toString(getConcatination(arr)));
    }
}