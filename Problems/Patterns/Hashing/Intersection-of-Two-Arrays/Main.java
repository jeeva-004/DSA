import java.util.*;

class Main {
    static int[] intersection(int[] arr1, int[] arr2) {

        HashSet<Integer> lookUpSet = new HashSet<>();
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int n : arr1)
            tempMap.put(n, 1);

        for (int i = 0; i < arr2.length; i++)
            if (tempMap.containsKey(arr2[i]))
                lookUpSet.add(arr2[i]);

        int[] intersections = new int[lookUpSet.size()];
        int k = 0;
        for (int n : lookUpSet)
            intersections[k++] = n;

        return intersections;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4,9,5 }, arr2 = {9,4,9,8,4};

        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}