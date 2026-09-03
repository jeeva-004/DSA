import java.util.*;

public class Main{
    
    static int carFleets(int target, int[] positions, int[] speeds){
        double[] times = new double[speeds.length];
        HashMap<Integer, Double> pairs = new HashMap<>();

        for(int i = 0; i<positions.length; i++){
            times[i] = (double) (target - positions[i]) / speeds[i];
            pairs.put(positions[i], times[i]);
        }

        Arrays.sort(positions);
        Deque<Double> dStack = new ArrayDeque<>();

        int fleets = 1;
        dStack.push(pairs.get(positions[positions.length-1]));

        for(int j = positions.length-2; j>=0; j--){
            if(dStack.peek() < pairs.get(positions[j])){
                fleets++;
                dStack.push(pairs.get(positions[j]));
            }
        }

        return fleets;
    }

    public static void main(String[] args){
        int[] positions = {10,8,0,5,3}, speeds = {2, 4, 1, 1,3};
        int target = 12;

        System.out.print(carFleets(target, positions, speeds));
    }
}