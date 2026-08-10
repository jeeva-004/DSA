import java.util.*;

public class Main {

    static int removeOverLapingIntervals(int[][] intervals){
        
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));
        int removableIntervals = 0, pre = intervals[0][1], current = 0;
    
        for(int i = 1; i<intervals.length; i++){
            current = intervals[i][0];
            if(current<pre){
                removableIntervals++;
            }
            else
                pre = intervals[i][1];
        }

        return removableIntervals;
    }

    public static void main(String[] args) {
        // int[][] intervals = {{1,2}, {2,3},{3,4},{1,3}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};

        System.out.print(removeOverLapingIntervals(intervals));
    }
}