class Main {

    static int findMissing(int[] arr) {
        int n = arr.length, actualSum = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        for(int j = 0; j<n; j++){
            if(max<arr[j])
                max = arr[j];
        } 
        // System.out.println(actualSum);
        return max*(max+1)/2 - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findMissing(arr));
    }
}