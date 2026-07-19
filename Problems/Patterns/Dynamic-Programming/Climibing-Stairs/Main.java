public class Main{
    
    //we can jumb at a time 1 step or two steps
    static int climbingStairs(int n){

        if(n<=1)
            return 1;

        int[] mem = new int[n+1];
        mem[0] = 1;
        mem[1] = 1;

        for(int i = 2; i<=n; i++)
            mem[i] = mem[i-1] + mem[i-2];

        return mem[n];
    }
    
    public static void main(String[] args) {
        System.out.println(climbingStairs(4));
    }
}