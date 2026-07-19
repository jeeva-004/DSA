public class Main{

    //we should return a maximum amount of money, and then should't robber adjacent houses
    static int maximumAmount(int[] arr){
        if(arr.length<=1)
            return arr.length==0?0:arr[0];

        int[] mem = new int[arr.length+1];

        mem[0] = arr[0];
        mem[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i<arr.length; i++)
            mem[i] = Math.max(mem[i-1], arr[i] + mem[i-2]);
        
        return mem[arr.length-1];
    }


    public static void main(String[] args){
        int[] houses = {2,3,6,1};
        
        System.out.println(maximumAmount(houses));
    }
}