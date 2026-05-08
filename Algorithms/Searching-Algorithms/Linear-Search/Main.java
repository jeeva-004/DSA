import java.lang.*;
import java.util.*;

class Main {
    // 1D Array Search

    public static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    public static int findMax(int[] arr) {
        if (arr.length == 0)
            return -1;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            if (maxElement < arr[i])
                maxElement = arr[i];
        return maxElement;
    }

    public static int findMin(int[] arr) {
        if (arr.length == 0)
            return -1;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            if (minElement > arr[i])
                minElement = arr[i];
        return minElement;

    }

    public static int countFourdigits(int[] arr) {
        if (arr.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (999 < arr[i] && arr[i] <= 9999)
                count++;
        return count;
    }

    // String Search

    public static int find(String s, char c) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                return i;
        return -1;
    }

    public static boolean contains(String s, char c) {
        return s.indexOf(c) == -1 ? false : true;
    }

    public static int countChar(String s, char c) {
        if (s == "")
            return -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;
        return count;
    }
    
    // 2D Array Search

    public static int[] find(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] == target)
                    return new int[] { row, column };
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // 1D array search

        int[] oneDarr = { 2382, 83, 233, 32839, 2380, 3333 };

        // String search

        String name = "jeeva";

        // 2D array search

        int[][] twoDarr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
    }
}