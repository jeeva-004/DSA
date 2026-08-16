import java.util.*;
public class Main{
    
    static int[] productOfArray(int[] arr){
        int[] prefixProduct = new int[arr.length];

        prefixProduct[0] = 1;

        for(int i = 1; i<arr.length; i++){
            prefixProduct[i] = prefixProduct[i-1] * arr[i-1];
        }

        int suffixProduct = 1;

        for(int i = prefixProduct.length-1; i>=0; i--){
            prefixProduct[i] = prefixProduct[i] * suffixProduct;
            suffixProduct = arr[i]*suffixProduct;
        }
        return prefixProduct;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};

        System.out.print(Arrays.toString(productOfArray(arr)));
    }
}