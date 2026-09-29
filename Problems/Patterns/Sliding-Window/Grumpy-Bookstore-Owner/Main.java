public class Main{
    
    static int maxHappyCustomers(int[] customers, int[] grumpy, int minutes){

        int maximumHappyCustomers = 0, left = 0, windowSize = minutes,maxWindowSum = 0, currentWindowSum = 0;

        for(int i = 0; i<customers.length; i++){
            maximumHappyCustomers+= grumpy[i]==1?0:customers[i];
            maxWindowSum += i< minutes && grumpy[i]==1?customers[i]:0;
        }
        currentWindowSum = maxWindowSum;

        while(windowSize<customers.length){
            
            currentWindowSum -= grumpy[left]==1?customers[left]:0;
            currentWindowSum += grumpy[windowSize]==1?customers[windowSize]:0;

            maxWindowSum = Math.max(maxWindowSum, currentWindowSum);

            left++;
            windowSize++;
        }

        return maximumHappyCustomers+maxWindowSum;

    }

    public static void main(String[] args){
        int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        System.out.print(maxHappyCustomers(customers, grumpy, minutes));
    }
}