import java.util.*;

class Main {

    static int[] findTopFrequented(int[] arr, int k) {

        HashMap<Integer, Integer> lookUpMap = new HashMap<>();

        for (int n : arr) {
            if (lookUpMap.containsKey(n))
                lookUpMap.put(n, lookUpMap.get(n) + 1);
            else
                lookUpMap.put(n, 1);
        }

        int[] topFrequented = new int[k];
        int highestNum = 0;
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> map : lookUpMap.entrySet()) {
                if (highestNum < map.getValue()) {
                    highestNum = map.getValue();
                    topFrequented[i] = map.getKey();
                }
            }
            lookUpMap.remove(topFrequented[i]);
            highestNum = 0;
        }

        return topFrequented;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(findTopFrequented(arr, 2)));
    }
}