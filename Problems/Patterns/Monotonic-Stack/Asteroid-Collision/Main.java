import java.util.*;

public class Main {

    static int[] asteroidCollition(int[] asteroids) {
        Deque<Integer> dStack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                dStack.push(asteroid);
            } else {
                while (!dStack.isEmpty() && dStack.peek() > 0 && dStack.peek() < Math.abs(asteroid)) {
                    dStack.pop();
                }

                if (!dStack.isEmpty() && dStack.peek() == Math.abs(asteroid))
                    dStack.pop();
                else if (dStack.isEmpty() && dStack.peek() < 0)
                    dStack.push(asteroid);

            }
        }
        int[] ans = new int[dStack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = dStack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] steroids = { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollition(steroids)));
    }
}