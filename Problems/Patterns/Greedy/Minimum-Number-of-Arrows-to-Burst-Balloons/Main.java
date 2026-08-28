import java.util.*;

public class Main{
    
    static int findMinArrowShots(int[][] points){
        Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));

        int minArrows = 1, shootingPosition = points[0][1];
        int[] range;
        for(int i = 1; i<points.length; i++){
            range = points[i];

            if(range[0]>shootingPosition){
                minArrows++;
                shootingPosition = range[1];
            }
        }

        return minArrows;
    }

    public static void main(String[] args){
        int[][] points = {{10,16}, {2, 8}, {1, 6}, {7, 12}};

        System.out.print(findMinArrowShots(points));
    }
}