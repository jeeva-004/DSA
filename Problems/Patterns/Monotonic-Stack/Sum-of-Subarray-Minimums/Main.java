import java.util.*;

public class Main{
    
    static int minSubArraysSums(int[] arr){
        Deque<Integer> dStack = new ArrayDeque<>();
        int[] leftChoices = new int[arr.length];
        int[] rightChoices = new int[arr.length];
        int i = 0, MOD = 1000000007;
        long sum = 0, total = 0;

        for(i = 0; i<arr.length; i++){
            while(!dStack.isEmpty() && arr[dStack.peek()] > arr[i]){
                dStack.pop();
            }
                leftChoices[i] = dStack.isEmpty() ? -1:dStack.peek();
            
            dStack.push(i);
        }

        while(!dStack.isEmpty())
            dStack.pop();

        for(i = arr.length-1; i>=0; i--){
            while(!dStack.isEmpty() && arr[dStack.peek()] >= arr[i]){
                dStack.pop();
            }
            rightChoices[i] = dStack.isEmpty()? arr.length:dStack.peek();
            
            dStack.push(i);
        }
        int lChoices = 0, rChoices = 0;
        for(i = 0; i<arr.length; i++){
            lChoices = i - leftChoices[i];
            rChoices = rightChoices[i] - i;
            total = (long) lChoices * rChoices * arr[i];
            sum = (sum+total) % MOD;
        }   

        return (int) sum;
    }

    public static void main(String[] args){
        int[] arr = {3, 1, 2, 4};
        System.out.print(minSubArraysSums(arr));
    }
}