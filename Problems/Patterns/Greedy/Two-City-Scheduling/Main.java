import java.util.*;

public class Main{
    
    static int minimumCosts(int[][] costs){
        Arrays.sort(costs, (a, b) -> (a[0]-a[1]) - (b[0]-b[1]));
        int minimumCost = 0;

        for(int i = 0; i<costs.length; i++){
            if(i<costs.length/2)
                minimumCost+=costs[i][0];
            else    
                minimumCost+=costs[i][1];
        }

        return minimumCost;
    }
    
    public static void main(String[] args){
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};

        System.out.print(minimumCosts(costs));
    }
}