public class Main {

    static int minCapacityToShipWeights(int[] weights, int days) {

        int min = Integer.MIN_VALUE, max = 0, minCapacity = Integer.MAX_VALUE;
        int mid = 0;
        for (int n : weights) {
            min = Math.max(min, n);
            max += n;
        }

        while (min <= max) {
            mid = (min + max) / 2;

            if (canShip(weights, mid, days)) {
                minCapacity = Math.min(minCapacity, mid);
                max = mid - 1;
            } else
                min = mid + 1;

        }

        return minCapacity;
    }

    static boolean canShip(int[] weights, int mid, int days) {
        int calculatedDays = 1;
        int weight = 0;

        for (int n : weights) {

            if (weight + n > mid) {
                calculatedDays++;
                weight = n;
            } else
                weight += n;
        }

        return calculatedDays <= days;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(minCapacityToShipWeights(weights, days));
    }
}