import java.util.*;

public class Main{
    
    static int[] dailyTemperatures(int[] temperatures){
        int[] waitingDays = new int[temperatures.length];
        Deque<Integer> dStack = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length; i++){

            while(!dStack.isEmpty() && temperatures[dStack.peek()]<temperatures[i]){
                waitingDays[dStack.peek()] = i - dStack.peek();
                dStack.pop();
            }

            dStack.push(i);

        }

        return waitingDays;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}