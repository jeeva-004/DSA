import java.util.*;
public class Main {

    static int agressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        long min = 1, max = stalls[stalls.length - 1] - stalls[0], maximizedMinDistance = 0, mid = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            if (isPossible(stalls, mid, cows)) {
                maximizedMinDistance = Math.max(maximizedMinDistance, mid);
                min = mid + 1;
            } else
                max = mid - 1;
        }
        return (int) maximizedMinDistance;
    }

    static boolean isPossible(int[] stalls, long mid, int cows) {

        long cowsPlaced = 0;
        int lastIndex = 0;

        for (int i = 0; i < stalls.length; i++) {
            if (i == 0) {
                cowsPlaced++;
                lastIndex = i;
                if (cowsPlaced == cows)
                    return true;
                continue;
            }

            if (stalls[i] - stalls[lastIndex] >= mid) {
                cowsPlaced++;
                if (cowsPlaced == cows)
                    return true;
                lastIndex = i;
            }
        }

        return cowsPlaced == cows;
    }

    public static void main(String[] args) {
        int[] stalls = { 1, 2, 4, 8, 9 };
        int cows = 3;

        System.out.print(agressiveCows(stalls, cows));
    }
}