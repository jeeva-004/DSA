import java.util.*;

public class Main{
    
    static int[] personsCanVisible(int[] heights){
        int[] res = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()])
                res[stack.pop()]++;
            
            if(!stack.isEmpty())
                res[stack.peek()]++;

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args){
        int[] heights = {10,6,8,5,11,9};
        System.out.print(Arrays.toString(personsCanVisible(heights)));
    }
}