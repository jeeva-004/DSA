import java.util.*;

public class Main {

    static int[] assignServers(int[] servers, int[] tasks) {
        int[] result = new int[tasks.length];
        // weight, index
        PriorityQueue<long[]> availableServers = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0])
                return 1;
            if (a[0] < b[0])
                return -1;
            return Long.compare(a[1], b[1]);
        });

        // finishing time, weight, index
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);

            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++)
            availableServers.add(new long[] { servers[i], i });

        for (int i = 0; i < tasks.length; i++) {
            int currentTime = i;
            while (!busyServers.isEmpty() && busyServers.peek()[0] <=currentTime) {
                long[] freeServer = busyServers.peek();
                busyServers.remove(freeServer);
                availableServers.add(new long[] { freeServer[1], freeServer[2] });
            }
            if (!availableServers.isEmpty()) {
                long[] selectedServer = availableServers.peek();
                result[i] = (int) selectedServer[1];
                busyServers.add(new long[] {(long) currentTime + tasks[i], selectedServer[0], selectedServer[1] });
                availableServers.remove(selectedServer);
            } else {
                long[] earlyFinisher = busyServers.peek();
                currentTime = (int) earlyFinisher[0];
                
                availableServers.add(new long[] {earlyFinisher[1], earlyFinisher[2]});
                busyServers.remove(earlyFinisher);
                
                while(!busyServers.isEmpty() && busyServers.peek()[0]==earlyFinisher[0]){
                    long[] sameFinisher = busyServers.peek();
                    availableServers.add(new long[] {sameFinisher[1], sameFinisher[2]});
                    busyServers.remove(sameFinisher);
                }
                
                result[i] = (int) availableServers.peek()[1];

                busyServers.add(new long[] {(long) currentTime + tasks[i], availableServers.peek()[0], availableServers.peek()[1]});
                
                availableServers.remove(availableServers.peek());

            }

        }

        return result;
    }

    public static void main(String[] args) {

    }
}