public class Main{
    
    static int minimumIndex(int[] capacity, int itemSize){

        int index = 0;
        int minCapacity = Integer.MAX_VALUE;

        for(int i = 0; i<capacity.length; i++){
            if(capacity[i]>=itemSize && minCapacity>capacity[i]){
                minCapacity = capacity[i];
                index = i;
            }
        }

        return minCapacity==Integer.MAX_VALUE?-1:index;
    }

    public static void main(String[] args){
        int[] capacity = {3, 5, 4, 2};
        
        System.out.println(minimumIndex(capacity, 2));
    }
}