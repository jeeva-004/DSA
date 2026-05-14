import java.util.*;

class Main {
    static int majorityElement(int[] arr) {
        HashMap<Integer, Integer> lookUpMap = new HashMap<>();
        for (int n : arr)
            if (lookUpMap.containsKey(n))
                lookUpMap.put(n, lookUpMap.get(n) + 1);
            else
                lookUpMap.put(n, 1);

        int frequentedNumber = 0, frequency = 0;
        for (Map.Entry<Integer, Integer> map : lookUpMap.entrySet())
            if (frequency < map.getValue()) {
                frequentedNumber = map.getKey();
                frequency = map.getValue();
            }
        return frequentedNumber;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,2,4};
        System.out.println(majorityElement(arr));
    }
}