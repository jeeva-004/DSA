public class Main {

    static int minSpeedToArrive(int[] dist, double hours) {
        int min = 1, max = 10_000_000, mid = 0, minSpeed = -1;

        while (min <= max) {
            mid = (min + max) / 2;

            if (canArrive(dist, mid, hours)) {
                minSpeed = mid;
                max = mid - 1;
            } else
                min = mid + 1;
        }

        return minSpeed;
    }

    static boolean canArrive(int[] dist, int mid, double hours) {
        double calculatedHours = 0.0;

        for (int i = 0; i < dist.length - 1; i++) {
            calculatedHours += Math.ceil((double) dist[i] / mid);
        }

        calculatedHours += (double) dist[dist.length - 1] / mid;

        return calculatedHours <= hours;
    }

    public static void main(String[] args) {
        int[] dist = {1,3,2};
        double hours = 2.7;

        System.out.print(minSpeedToArrive(dist, hours));
    }
}