class Main {

    static int findMissing(int[] arr) {
        
        int currentSum = 0, n = arr.length;
        
        for (int i: arr) 
            currentSum += i;

        return n*(n+1)/2 - currentSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,0};
        System.out.println(findMissing(arr));
    }
}