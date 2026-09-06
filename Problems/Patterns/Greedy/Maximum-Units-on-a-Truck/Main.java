import java.util.*;

public class Main{
    //  boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

    static int maximumUnits(int[][] boxTypes, int trackSize){
        Arrays.sort(boxTypes, (a, b)->Integer.compare(a[1], b[1]));
        int maxUnits = 0;

        for(int i = boxTypes.length-1; i>=0; i--){
            int obtainedBoxes = Math.min(boxTypes[i][0], trackSize);
            trackSize-=obtainedBoxes;
            maxUnits+=obtainedBoxes*boxTypes[i][1];

            if(trackSize<=0)
                break;
        }

        return maxUnits;
    }

    public static void main(String[] args){
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int trackSize = 4;

        System.out.print(maximumUnits(boxTypes, trackSize));
    }
}