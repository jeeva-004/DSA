import java.util.*;

public class Main{
    
    static int[] sortArrayParityII(int[] arr){
        int[] res = new int[arr.length];
        int even = 0, odd = 1;

        for(int n: arr){
            if(n%2==0){
                res[even] = n;
                even+=2;
            }
            else{
                res[odd] = n;
                odd+=2;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {2,2,3,5};
        System.out.print(Arrays.toString(sortArrayParityII(arr)));
    }
}