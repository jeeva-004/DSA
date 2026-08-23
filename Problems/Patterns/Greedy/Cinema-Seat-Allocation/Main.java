import java.util.*;
import java.util.HashMap;

public class Main {
    static int maxSeatAllocationForFamily(int n, int[][] reservedSeats) {
        int maxSeatsForFamily = 0;
        HashMap<Integer, List<Integer>> lookUpMap = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            lookUpMap.computeIfAbsent(reservedSeats[i][0], k -> new ArrayList()).add(reservedSeats[i][1]);
        }

        boolean left = false, right = false;
        maxSeatsForFamily = (n - lookUpMap.size()) * 2;
        int maxSeats = 0;
        for (Map.Entry<Integer, List<Integer>> m : lookUpMap.entrySet()) {
            maxSeats = 0;
            List<Integer> rs = m.getValue();
            left = false;
            right = false;

            if (!rs.contains(2) && !rs.contains(3) && !rs.contains(4) && !rs.contains(5)) {
                left = true;
                maxSeats++;
            }

            if (!rs.contains(6) && !rs.contains(7) && !rs.contains(8) && !rs.contains(9)) {
                right = true;
                maxSeats++;
            }

            if (!right && !left && !rs.contains(4) && !rs.contains(5) && !rs.contains(6) && !rs.contains(7))
                maxSeats = 1;

            maxSeatsForFamily += maxSeats;
        }

        return maxSeatsForFamily;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = { { 2, 1 }, { 1, 8 }, { 2, 6 } };

        System.out.print(maxSeatAllocationForFamily(n, reservedSeats));
    }
}