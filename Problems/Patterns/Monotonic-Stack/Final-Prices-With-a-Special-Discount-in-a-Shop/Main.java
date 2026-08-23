import java.util.*;

public class Main{
    
    static int[] finalPrices(int[] prices){
        Deque<Integer> dStack = new ArrayDeque<>();
        
        for(int i = 0; i<prices.length; i++){

            while(!dStack.isEmpty() && prices[dStack.peek()] >= prices[i]){
                prices[dStack.peek()] = prices[dStack.peek()] - prices[i];
                dStack.pop();
            }

            dStack.push(i);
        }

        return prices;
    }

    public static void main(String[] args){
        int[] prices = {8,4,6,2,3};

        System.out.print(Arrays.toString(finalPrices(prices)));
    }
}