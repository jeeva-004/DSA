public class Main{
    
    static double minimizedMaxDistance(int[] stations, int k){
        double min = 0, max = 0, mid = 0;
        double minMaxDistance = 0.0;

        for(int i = 1; i<stations.length; i++)
            max = max<stations[i]-stations[i-1]?stations[i]-stations[i-1]:max;

        while(max-min>1e-6){
            mid = (min+max) / 2;

            if(canAdd(stations, mid, k)){
                minMaxDistance = mid;
                max = mid;
            }
            else
                min = mid;
        }

        return minMaxDistance;
    }

    static boolean canAdd(int[] stations, double mid, int k){
        int totalStations = 0;

        for(int i = 1; i<stations.length; i++){
            
            int gap = stations[i]-stations[i-1];

            int s =(int) Math.ceil(gap/mid)-1;

            totalStations+=s;

            if(totalStations>k)
                return false;
        }

        return true;
    }


    public static void main(String[] args){
        int[] stations = {1, 10};
        int k = 2;

        System.out.print(minimizedMaxDistance(stations, k));
    }
}