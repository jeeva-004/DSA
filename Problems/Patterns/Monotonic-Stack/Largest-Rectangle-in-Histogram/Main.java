import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    static int findMaxArea(int[] heights){
        int maxArea = 0, left = 0, width = 0, popped = 0, i = 0;
        int[] newHeights = new int[heights.length+1];
        Deque<Integer> dStack = new ArrayDeque<>();

        for(i = 0; i<heights.length; i++)
            newHeights[i] = heights[i];

        for(i = 0; i<newHeights.length; i++){   
            while(!dStack.isEmpty() && newHeights[i]<newHeights[dStack.peek()]){
                popped = dStack.pop();
                left = dStack.isEmpty()?-1:dStack.peek();
                width = i - left - 1;
                maxArea = maxArea<newHeights[popped] * width ? newHeights[popped] * width:maxArea;
            }
            
            dStack.push(i);
        }    
        return maxArea;
    }

    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};

        System.out.println(findMaxArea(heights));
    }
}