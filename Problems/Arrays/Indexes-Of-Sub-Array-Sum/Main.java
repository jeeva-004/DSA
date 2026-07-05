import java.util.*;

class Main {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> indexs = new ArrayList<>();
        int left = 0, right = 0, currentValue = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    indexs.add(i+1);
                    indexs.add(j+1);
                    return indexs;
                }
            }
        }

        return indexs;
    }

    public static void main(String[] args) {
        int[] arr = { 49, 23, 2, 22, 50, 8, 27, 43, 40, 26, 13, 1, 11, 4, 20 };

        System.out.print(subarraySum(arr, 35));
    }
}