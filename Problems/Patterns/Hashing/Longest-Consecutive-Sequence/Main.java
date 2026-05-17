import java.util.*;

class Main {

    static int longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // ArrayList<Integer> list = new ArrayList<>(set);
        for (int n : arr)
            set.add(n);
        int consecutiveSequence = 1, min = Integer.MAX_VALUE;
        while (set.size() > 0) {
            // find min
            for (int num : set)
                if (min > num)
                    min = num;

            int tempSequence = 1, tempMin = min + 1;
            set.remove(min);
            min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(tempMin)) {
                    tempSequence++;
                    int temp = tempMin + 1;
                    set.remove(tempMin);
                    tempMin = temp;
                    if (tempSequence > consecutiveSequence)
                        consecutiveSequence = tempSequence;
                } else {
                    tempSequence = 1;
                    break;
                }
            }
        }

        return consecutiveSequence;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutiveSequence(arr));
    }
}