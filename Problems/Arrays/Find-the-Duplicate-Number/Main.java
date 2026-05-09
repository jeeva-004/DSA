import java.util.*;

class Main {

    static int findDuplicate(int[] arr) {

        HashMap<Integer, Integer> lookUpMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (lookUpMap.containsKey(arr[i]))
                return arr[i];
            else
                lookUpMap.put(arr[i], i);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        System.out.println(findDuplicate(arr));
    }
}