class Main {

    // Time Complexity O(n2);

    static void sortAccending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i], minIndex = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] <arr[minIndex])
                    minIndex = j;
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static void sortDeccending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i], maxIndex = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4,6,4,7,6,6,1, 2, 5 };
        sortAccending(arr);
        for (int num : arr)
            System.out.print(num + " ");

    }
}