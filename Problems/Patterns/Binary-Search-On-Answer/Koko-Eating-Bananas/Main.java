import java.util.*;

public class Main {

    static int minSpeed(int[] piles, int h) {
        
        int minSpeed = Integer.MAX_VALUE;
        int max = 1;
        int min = 1;
        int mid = 0;

        for(int n: piles)
            max = Math.max(n, max);

        while(min<=max){
            mid = (min + max) / 2;

            if(isValid(piles, mid, h)){
                minSpeed = Math.min(minSpeed, mid);
                max = mid-1;
            }   
            else
                min = mid+1;
        }

        return minSpeed;
    }

    static boolean isValid(int[] piles, int mid, int h) {
        long hours = 0;

        for(int n: piles){
            hours+=(n+mid-1) / mid;
        
            if(hours>h)
                return false;
        }
        return hours<=h;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;

        System.out.print(minSpeed(piles, h));
    }
}
