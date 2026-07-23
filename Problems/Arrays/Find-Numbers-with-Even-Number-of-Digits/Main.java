public class Main{
    
    static int findEvenDigits(int[] nums){
        int count = 0;

        for(int n: nums){
            int digitCount = 0;

            while(n!=0){
                n = n/10;
                digitCount++;
            }

            if(digitCount%2==0)
                count++;
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {2,34,234,4334,55};

        System.out.println(findEvenDigits(nums));
    } 
}