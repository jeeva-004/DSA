import java.util.*;

public class Main{
    
    static int[][] intervalIntersection(int[][] firstList, int[][] secondList){
        if(firstList.length==0 || secondList.length==0)
            return new int[][] {};

        List<List<Integer>> intersections = new ArrayList<>();

        int i = 0, j = 0;
        
        while(i<firstList.length && j<secondList.length){
            int min = Math.max(firstList[i][0], secondList[j][0]);
            int max = Math.min(firstList[i][1], secondList[j][1]);

            if(min<=max){
                intersections.add(Arrays.asList(min, max));
            }
            
            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;
        }

        int[][] result = new int[intersections.size()][2];

        for(i = 0; i<result.length; i++){
            result[i][0] = intersections.get(i).get(0);
            result[i][1] = intersections.get(i).get(1);
        }

        return result;
    }

    public static void main(String[] args){
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        

        int[][] result = intervalIntersection(firstList, secondList);

        for(int[] arr: result){
            System.out.print(Arrays.toString(arr)+" ");
        }

    }
}