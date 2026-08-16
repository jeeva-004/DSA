public class Main {

    static int minDays(int[] bloomDays, int m, int k) {
        if ((long) (m * k) > bloomDays.length)
            return -1;

        int min = Integer.MAX_VALUE, max = 0, minDays = -1, mid = 0;

        for(int d: bloomDays){
            min = d<min?d:min;
            max = max<d?d:max;
        }

        while (min <= max) {
            mid = (min + max) / 2;

            if (canMake(bloomDays, mid, m, k)) {
                minDays = mid;
                max = mid - 1;
            } else
                min = mid + 1;
        }

        return minDays;
    }

    static boolean canMake(int[] days, int mid, int m, int k){
        int bouquets = 0, count = 0;
        
        for(int d: days){
            count = d<=mid?count+1:0;

            if(count==k){
                bouquets++;
                count = 0;
            }
        }

        return bouquets>=m;
    }

    public static void main(String[] args) {
        int[] bloomDays =  {1,10,3,10,2};
        int m = 3, k = 1;
        
        System.out.print(minDays(bloomDays, m, k));
    }
}