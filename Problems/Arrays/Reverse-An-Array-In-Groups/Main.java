class Main {
    static void reverseInGroups(int[] arr, int k) {
        int n = arr.length, s = 0, e = k-1, groupCounts = n/k;
        for(int i = 0; i<groupCounts; i++){
            int temp = arr[i];
            arr[i] = arr[e];
            arr[e] = temp;
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5,6};
        int k = 3;

        reverseInGroups(arr, k);
    }
}