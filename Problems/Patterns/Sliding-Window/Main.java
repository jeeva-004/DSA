class Main{
    
    static double maxAvg(int[] arr, int k){
        
        int start = 0, windowSize = k;
        double maxSum = 0;
        for(int i = 0; i<windowSize; i++)
            maxSum+=arr[i];
        double currentSum = maxSum;
        while(windowSize<arr.length){
            currentSum = currentSum-arr[start]+arr[windowSize];
            maxSum = Math.max(currentSum, maxSum);
            start++;
            windowSize++;
        }
        return maxSum/k;
    }
    
    public static void main(String[] args){
        int[] arr = {1,12,-5,-6,50,3};

        System.out.println(maxAvg(arr, 4));
    }
}