import java.util.*;

class Main {

    static int longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int consecutiveSequence = 1, temp = 1;
        for (int n : arr)
            set.add(n);

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int val = num + 1;
                for (int i = 0; i < set.size(); i++) {
                    if (set.contains(val)) {
                        val = val + 1;
                        temp++;
                        if (consecutiveSequence < temp)
                            consecutiveSequence = temp;
                    } else {
                        temp = 1;
                        break;
                    }
                }
            }

        }

        return consecutiveSequence;
    }

    public static void main(String[] args) {
        int[] arr = { 1,0,1,2};
        System.out.println(longestConsecutiveSequence(arr));
    }
}