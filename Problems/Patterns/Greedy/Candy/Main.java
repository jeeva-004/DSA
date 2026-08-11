public class Main{
    static int minimumCandy(int[] ratings){
        int[] candies = new int[ratings.length];
        int i = 0;
        
        for(i = 0; i<candies.length; i++)
            candies[i] = 1;
        
        for(i = 1; i<ratings.length; i++){
            if(ratings[i-1]<ratings[i])
                candies[i] = candies[i-1]+1; 
        }
        
        int minCandy = candies[candies.length-1];
        
        for(i = ratings.length-2; i>=0; i--){
            
            if(ratings[i]>ratings[i+1])
                candies[i] = candies[i+1]+1>candies[i]?candies[i+1]+1:candies[i];

            minCandy+=candies[i];
        }

        return minCandy;
    }

    public static void main(String[] args){
        int[] ratings = {1,2,2};
        System.out.print(minimumCandy(ratings));
    }
}