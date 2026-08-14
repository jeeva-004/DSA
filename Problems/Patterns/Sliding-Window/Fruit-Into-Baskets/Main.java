import java.util.HashMap;

public class Main {

    static int maximumFruits(int[] fruits) {
        int left = 0, maxFruits = 0, leftFruit = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);

            while (freq.size() > 2) {
                leftFruit = fruits[left];
                freq.put(fruits[left], freq.get(fruits[left]) - 1);

                if (freq.get(leftFruit) == 0)
                    freq.remove(leftFruit);

                left++;
            }

            maxFruits = maxFruits < right - left + 1 ? right - left + 1 : maxFruits;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};

        System.out.print(maximumFruits(fruits));
    }
}
