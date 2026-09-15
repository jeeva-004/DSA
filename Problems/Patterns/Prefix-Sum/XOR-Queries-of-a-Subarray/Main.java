import java.util.*;

public class Main{
    
    static int[] xorArrays(int[] nums, int[][] queries){
        int[] prefix = new int[nums.length+1];

        for(int i = 0; i<nums.length; i++){
            prefix[i+1] = prefix[i] ^ nums[i];
        }

        int[] result = new int[queries.length];

        for(int j = 0; j<queries.length; j++){
            result[j] = prefix[queries[j][1]+1] ^ prefix[queries[j][0]];
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,8};
        int[][] queries ={{0,1},{1,2},{0,3},{3,3}}; 

        System.out.print(Arrays.toString(xorArrays(nums, queries)));
    }
}