class Main {

    // Time Complexity O (Log n)

    public static int search(int[] arr, int target) {

        int start = 0, end = arr.length;
        boolean accending = true;

        if (arr[start] > arr[end - 1])
            accending = false;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (accending) {
                if (arr[mid] < target)
                    start = mid + 1;
                else if (arr[mid] > target)
                    end = mid - 1;
                else
                    return mid; // {1,2,3,4,5} 2
            } else {
                if (arr[mid] < target)
                    end = mid - 1;
                else if (arr[mid] > target)
                    start = mid + 1;
                else
                    return mid; // {5,4,3,2,1}
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(search(arr, 5));
    }
}