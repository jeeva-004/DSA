import java.util.HashMap;

public class Main{

    static int contigousSubArrayLength(int[] arr){
        if(arr.length<=1) return 0;
        int maxLength = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prePrefixSums = new HashMap<>();
        prePrefixSums.put(0, -1);
        
        for(int i = 0; i<arr.length; i++){
            currentSum+=arr[i]==0?-1:arr[i];

            if(prePrefixSums.containsKey(currentSum))
                maxLength = Math.max(i-prePrefixSums.get(currentSum), maxLength);
            else
                prePrefixSums.put(currentSum, i);
        }


        return maxLength;
    }

    public static void main(String[] args){
        int[] arr = {1,0, 1};

        System.out.print(contigousSubArrayLength(arr));
    }
}

