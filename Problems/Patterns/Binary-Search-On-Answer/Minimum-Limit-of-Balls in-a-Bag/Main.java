public class Main{
    
    static int minimumSize(int[] bags, int maxOperations ){
        int min = 1, max = 0, mid = 0, minPenalty = 0;

        for(int b: bags)
            max = max<b?b:max;
        
        while(min<=max){
            mid = (min+max)/2;

            if(canSplit(bags, mid, maxOperations)){
                minPenalty = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }

        return minPenalty;
    }

    static boolean canSplit(int[] bags, int mid, int maxOperations){
        int totalOperations = 0;

        for(int b: bags){
            totalOperations+=(b+mid-1)/mid-1;

            if(totalOperations>maxOperations)
                return false;
        }

        return totalOperations<=maxOperations;
    }

    public static void main(String[] args){
        int[] bags = {9};
        int maxOperations = 2;

        System.out.println(minimumSize(bags, maxOperations));
    }
}