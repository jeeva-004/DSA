import java.util.*;
public class Main {

    static int maximumDistance(int[] positions, int balls){
        Arrays.sort(positions);
        int min = 1, max = positions[positions.length-1], mid = 0, maxDistance = 0;

        while(min<=max){
            mid = (min+max)/2;

            if(canPlace(positions, mid, balls)){
                maxDistance = maxDistance<mid?mid:maxDistance;
                min = mid+1;
            }
            else
                max = mid - 1;
        }

        return maxDistance;
    }

    static boolean canPlace(int[] positions, int mid, int balls){
        int placedBalls = 0, lastIndex = 0;

        for(int i = 0; i<positions.length; i++){
            if(i==0){
                placedBalls++;
                if(placedBalls==balls)
                    return true;
                lastIndex = i;
                continue;
            }

            if(positions[i]-positions[lastIndex]>=mid){
                placedBalls++;
                if(placedBalls==balls)
                    return true;
                lastIndex = i;
            }
        }

        return placedBalls==balls;
    }

    public static void main(String[] args){
        int[] positions = {1,2,3,4,7};
        int balls= 3;

        System.out.print(maximumDistance(positions, balls));
    }
}
