import java.util.*;

class Main {
    static boolean containsDuplicateII(int[] arr, int k) {
        HashMap<Integer, Integer> lookUpMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            if (!lookUpMap.containsKey(arr[i]))
                lookUpMap.put(arr[i], i);

        for (int j = 0; j < arr.length; j++)
            if (lookUpMap.containsKey(arr[j]))
                if (j != lookUpMap.get(arr[j]) && j - lookUpMap.get(arr[j]) <= k)
                    return true;
                else
                    lookUpMap.put(arr[j], j);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        System.out.println(containsDuplicateII(arr, 2));
    }
}