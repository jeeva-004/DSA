class Main{
    static double maxAvg(int[] arr, int k){
        // set a variables to store values and positions

        int start = 0, windowSize = k;
        double current = 0, maxSum = 0;

        //accumulate current window sum

        for(int i = 0; i<windowSize; i++)
            current+=arr[i];

        //set initially the both current and maxsum variables same one

        maxSum = current;

        while(windowSize<arr.length){
            current = current-arr[start]+arr[windowSize];
            maxSum = Math.max(current, maxSum);
            windowSize++;
            start++;
        }

        return maxSum/k;

    }
    
    public static void main(String[] args){
        int[] arr = {4,2,1,3,3};

        System.out.println(maxAvg(arr, 2));
    }
}