public class Main{
    
    //top down DP (Memoization)

    static int fibMemoization(int n){
        int[] mem = new int[n+1];
        if(n<=1){
            mem[n] = 1;
            return mem[n];
        }
        
        if(mem[n]!=0)
            return mem[n];

        mem[n] = fibMemoization(n-1) + fibMemoization(n-2);

        return mem[n];
    }

    //bottom up DP (Tablulation)

    static int fibTabulation(int n){

        int[] tabulation = new int[n+1];
        tabulation[0] = 1;
        tabulation[1] = 1;
        
        if(n<=1)
            return n==0?tabulation[0]:tabulation[1];

        for(int i = 2; i<=n; i++)
            tabulation[i] = tabulation[i-1]  + tabulation[i-2];
        
        return tabulation[n];
    }
    
    public static void main(String[] args){
        System.out.println(fibMemoization(5));
        System.out.println(fibTabulation(5));
    }
}